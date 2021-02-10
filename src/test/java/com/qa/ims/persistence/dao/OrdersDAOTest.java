package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;
public class OrdersDAOTest {
	private final OrdersDAO DAO = new OrdersDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Orders created = new Orders(2L);
	
	}
	
	@Test 
	public void testCreateException() {
		final Orders created = new Orders(20000000000l);
				assertEquals(null, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Orders> expected = new ArrayList<>();
		expected.add(new Orders(1L));
	
	}
	

	@Test
	public void testReadLatest() {
	}

	@Test
	public void testRead() {
		final long ID = 1L;

	}



	@Test
	public void testDelete() {
		
	}

}
