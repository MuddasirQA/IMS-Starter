package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrdersDAO dao;
	
	@Mock
	private ItemsDAO itemdao;

	@InjectMocks
	private OrderController controller;

	@Test
	public void testCreate() {
		final Long custId = 1L;
	

		final Orders created = new Orders(custId);

		
	
	

	
	}

	@Test
	public void testReadAll() {
		List<Orders> order = new ArrayList<>();
		order.add(new Orders(1L));

		Mockito.when(dao.readAll()).thenReturn(order);

		assertEquals(order, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}



	@Test
	public void testDelete() {
		final long ID = 1L;



	}

}
