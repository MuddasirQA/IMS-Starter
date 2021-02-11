package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;


import org.junit.Test;


import nl.jqno.equalsverifier.EqualsVerifier;


public class CustomerTest {

	private Customer customer = new Customer("Habib", "IbnAhmad");
	private Customer customers = new Customer(1L, "Red", "John");

	@Test
	public void testFirstName() {
		assertEquals("Habib", customer.getFirstName());

	}

	@Test
	public void testConstructor() {
		assertEquals(Long.valueOf(1), customers.getId());

	}

	@Test
	public void testSecondName() {
		assertEquals("IbnAhmad", customer.getSurname());

	}

	@Test
	public void equalsContract() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}

}
