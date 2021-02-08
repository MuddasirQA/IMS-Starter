package com.qa.ims.controller;

import java.util.ArrayList;
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
	private Utils utils;
	private ItemsDAO itemDAO;

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
		String addItem = "yes";

		LOGGER.info("please enter a customer id");
		Long customerId = utils.getLong();
		Orders order = orderDAO.create(new Orders(customerId));
		LOGGER.info("please enter a item id");
		Long itemId = utils.getLong();

		orderDAO.createItemOrder(order.getOrderId(), itemId);
	

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
			LOGGER.info("please select an items_id to delete");
			Long itemId = utils.getLong();
			orderDAO.deleteItemInOrder(itemId);
		}
		return 0;
	}

	@Override
	public Orders update() {
		// TODO Auto-generated method stub
		return null;
	}

}
