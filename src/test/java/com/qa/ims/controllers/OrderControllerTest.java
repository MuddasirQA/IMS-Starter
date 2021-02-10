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
		Long custId = 1L;
		Orders order = new Orders(1L);
		Orders compareOrder = new Orders(custId);
		assertEquals(order, compareOrder);
	}

	@Test
	public void testReadAll() {
		List<Orders> orders = new ArrayList<>();
		List<Items> items = new ArrayList<>();

		orders.add(new Orders(1L));
		items.add(new Items(1L, "book1", 10d));

		Mockito.when(dao.readAll()).thenReturn(orders);
		Mockito.when(itemdao.readAll()).thenReturn(items);

		assertEquals(orders, controller.readAll());
		assertEquals(items, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {

	}

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}

}
