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
		LOGGER.info("please enter the total cost for this order");
		Double totalCost = utils.getDouble();
		Orders order = orderDAO.create(new Orders(customerId, totalCost));
		return order;
		
	}

	@Override
	public Orders update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
