package com.qa.ims.controllers;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.qa.ims.controller.Action;

public class ActionTest {
	

	@Test
	public void createTest() {
		Action action = Action.CREATE;
		assertTrue(action.getDescription().contains("CREATE"));
	}

	@Test
	public void readTest() {
		Action action = Action.READ;
		assertTrue(action.getDescription().contains("READ"));
	}

	@Test
	public void updateTest() {
		Action action = Action.UPDATE;
		assertTrue(action.getDescription().contains("UPDATE"));
	}

	@Test
	public void deleteTest() {
		Action action = Action.DELETE;
		assertTrue(action.getDescription().contains("DELETE"));
	}

	@Test
	public void returnTest() {
		Action action = Action.RETURN;
		assertTrue(action.getDescription().contains("RETURN"));
	}
}
