package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;


public class ItemsDAOTest {
	
	private final ItemsDAO DAO = new ItemsDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Items created = new Items("book1", 10d);
		assertEquals(created, DAO.create(created));
	}
	
	@Test 
	public void testCreateException() {
		final Items created = new Items("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 10d);
		assertEquals(null, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Items> expected = new ArrayList<>();
		expected.add(new Items("a book about hatred", 40d));
		assertEquals(expected, DAO.readAll());
	}
	

	@Test
	public void testReadLatest() {
		assertEquals(new Items("freedom", 10d), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Items(ID, "a wild hippo jumped over the lazy dragon", 250d), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Items updated = new Items("thriller",1d);
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
	
	
}
