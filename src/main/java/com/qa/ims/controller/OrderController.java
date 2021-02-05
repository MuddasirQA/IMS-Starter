package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Orders>{
	
	public static final Logger LOGGER = LogManager.getLogger();
	private OrdersDAO orderDAO;
	private Utils utils;
	

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
			}
			
			return orders;
	
	
	}
	

	@Override
	public Orders create() {
		LOGGER.info("please enter a customer id");
		Long customerId = utils.getLong();
		Orders order = orderDAO.create(new Orders(customerId));
        LOGGER.info("please enter a item id");
        Long itemId = utils.getLong();
        orderDAO.createItemOrder(customerId, itemId);
      
		return order;
		
	}
	
	

	@Override
	public Orders update() {
		LOGGER.info("please enter the order id for the order which you want to update");
		Long orderId = utils.getLong();
		LOGGER.info("please enter a new customer id for this order");
		Long custId = utils.getLong();
		LOGGER.info("please enter a new total cost for this order");
		Double totalCost = utils.getDouble();
		Orders order = orderDAO.update(new Orders(orderId, custId, totalCost)); 
		return order;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
