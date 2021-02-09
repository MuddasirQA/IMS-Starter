package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Orders> {

	public static final Logger LOGGER = LogManager.getLogger();
	private OrdersDAO orderDAO;
	private Utils utils = new Utils();
	private ItemsDAO itemDAO = new ItemsDAO();
	private ItemsController itemcontroller = new ItemsController(itemDAO, utils);

	public OrderController(OrdersDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override

	public List<Orders> readAll() {
		List<Orders> orders = orderDAO.readAll();
		for (Orders order : orders) {
			LOGGER.info(order.toString());

			for (Items item : order.getItems()) {
				LOGGER.info(item.toString());
			}

		}

		return orders;

	}

	@Override
	public Orders create() {

		Boolean addItem = true;

		LOGGER.info("please enter a customer id");
		Long customerId = utils.getLong();
		Orders order = orderDAO.create(new Orders(customerId));
		LOGGER.info("here are all the items available");
		LOGGER.info("--------------------------------");
		itemcontroller.readAll();
		LOGGER.info("--------------------------------");
		while (addItem) {

			LOGGER.info("please enter a item id");
			Long itemId = utils.getLong();

			orderDAO.createItemOrder(order.getOrderId(), itemId);
			LOGGER.info("do you wish to add another item to this order? type yes");
			String answer = utils.getString();

			if (!answer.equals("yes")) {

				addItem = false;
			}

		}

		return order;

	}

	@Override
	public int delete() {
		LOGGER.info("please select if you wish to delete an entire order, or an item from an order");
		LOGGER.info("1, Delete entire order");
		LOGGER.info("2, Delete item from order");
		Long a = utils.getLong();
		if (a == 1) {
			LOGGER.info("please enter the order id you wish to delete");
			Long orderId = utils.getLong();
			orderDAO.delete(orderId);
		} else {
			LOGGER.info("please select the order id for the item you wish to delete");
			Long orderId = utils.getLong();
			LOGGER.info("now enter the itemId in this order to delete");
			Long itemId = utils.getLong();
			orderDAO.deleteItemInOrder(orderId, itemId);
			LOGGER.info("this item has been  successfully removed from  order " + orderId);
		}
		return 0;
	}

	@Override
	public Orders update() {

		return null;
	}

}
