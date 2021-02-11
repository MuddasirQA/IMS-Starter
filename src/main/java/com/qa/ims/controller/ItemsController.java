package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.utils.Utils;
import com.qa.ims.persistence.domain.Items;

/**
 * Takes in item details for CRUD functionality
 *
 */
public class ItemsController implements CrudController<Items> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemsDAO itemsDAO;
	private Utils utils;

	public ItemsController(ItemsDAO itemsDAO, Utils utils) {
		super();
		this.itemsDAO = itemsDAO;
		this.utils = utils;
	}

	@Override
	public List<Items> readAll() {
		List<Items> items = itemsDAO.readAll();
		for (Items item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	@Override
	public Items create() {
		LOGGER.info("Enter the name of an item you want to create");
		String itemName = utils.getString();
		LOGGER.info("Create a price for this item");
		Double itemPrice = utils.getDouble();
		Items item = itemsDAO.create(new Items(itemName, itemPrice));
		LOGGER.info(itemName);

		LOGGER.info("Your item was created.");
		return item;
	}

	@Override
	public Items update() {
		LOGGER.info("Please enter an item_id for the item you would like to update");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter the a new name for this item");
		String itemName = utils.getString();
		LOGGER.info("Please enter the new price for this item");
		Double itemPrice = utils.getDouble();
		Items item = itemsDAO.update(new Items(itemId, itemName, itemPrice));
		LOGGER.info("This Item has been updated");
		return item;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = utils.getLong();
		return itemsDAO.delete(id);
	}

}
