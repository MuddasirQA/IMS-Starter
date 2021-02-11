package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Items;



@RunWith(MockitoJUnitRunner.class)
public class ItemsDAOTest {

	@InjectMocks
	private final ItemsDAO DAO = new ItemsDAO();

	@Mock
	private Dao<Items> dao;

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Items created = new Items("book1", 10d);
		DAO.create(created);

	}


	@Test
	public void testReadAll() {

		DAO.readAll();

		
	}
	
	
	

	@Test
	public void testUpdate() {
		Items updatedItem = new Items(1L, "a book about a hippo", 10d);
		DAO.update(updatedItem);
	

	}

	@Test
	public void testDelete() {
		DAO.delete(1L);
	
	}

}
