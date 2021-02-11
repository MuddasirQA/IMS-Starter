package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemsTest {
	
	
	private Items items = new Items(1L, "Red", 60d);
	
	private Items item = new Items("book1",10.00d);

	@Test
	public void testItemName() {
		assertEquals("book1", item.getItemName());

	}
	public void testItemPrice() {
		assertEquals(10.00, item.getItemPrice(),0d);

	}

	@Test
	public void testConstructor() {
		assertEquals(Long.valueOf(1), items.getItemId());

	}


	@Test
	public void equalsContract() {
		EqualsVerifier.simple().forClass(Items.class).verify();
	}
}
