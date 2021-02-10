package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrdersTest {
	
	private Orders order = new Orders(1L);
	private Orders orders = new Orders(1L, 1L);
	
	@Test
	public void testTotalCost() {
		double totalCost = 0d;
		Items i = new Items(1L,"book3",50d);
		i.setItemPrice(10d);
		assertEquals(10d, i.getItemPrice(), 0d);
		
	}



	@Test
	public void testConstructor() {
		assertEquals(Long.valueOf(1), orders.getOrderId());

	}


	@Test
	public void equalsContract() {
		EqualsVerifier.simple().forClass(Orders.class).verify();
	}
}
