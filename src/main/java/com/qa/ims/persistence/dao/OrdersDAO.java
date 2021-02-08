package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrdersDAO implements Dao<Orders> {

	public static final Logger LOGGER = LogManager.getLogger();

	public Items itemModelFromResultSet(ResultSet resultSet) throws SQLException {
		Long itemId = resultSet.getLong("item_id");
		String itemName = resultSet.getString("item_name");
		Double itemPrice = resultSet.getDouble("item_price");
		return new Items(itemId, itemName, itemPrice);
	}

//	@Override
//	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
//		Long orderId = resultSet.getLong("order_id");
//
//		Long customerId = resultSet.getLong("customer_id");
//
//		Long itemId = resultSet.getLong("item_id");
//
//		Double totalCost = resultSet.getDouble("total_cost");
//
//		return new Orders(orderId, customerId, itemId, totalCost);
//	}

	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("order_id");

		Long customerId = resultSet.getLong("customer_id");

		return new Orders(orderId, customerId);
	}

//	public Orders bmodelFromResultSet(ResultSet resultSet) throws SQLException {
//		Long orderItemId = resultSet.getLong("order_items_id");
//		Long orderId = resultSet.getLong("order_id");
//
//		Long itemId = resultSet.getLong("item_id");
//
//		return new Orders(orderItemId, orderId, itemId);
//	}

	@Override
	public List<Orders> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
			List<Orders> orders = new ArrayList<>();
			while (resultSet.next()) {
				Orders order = modelFromResultSet(resultSet);
				orders.add(order);
				List<Items> itemsinOrder = readAllItemsForAnOrder(order.getOrderId());
				order.setItems(itemsinOrder);
			}

			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Orders readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orders create(Orders order) {

		try (Connection connection = DBUtils.getInstance().getConnection();

				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders (customer_id) VALUES (?)");) {

			statement.setLong(1, order.getCustomerId());

			statement.executeUpdate();

			return readLatest();

		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;

	}

	public Orders read(Long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();

				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE order_id = ?");) {
			statement.setLong(1, orderId);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);

			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orders update(Orders order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orders SET customer_id = ? WHERE order_id = ?");) {

			statement.setLong(1, order.getCustomerId());
			statement.setLong(2, order.getOrderId());
			statement.executeUpdate();
			return read(order.getOrderId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE order_id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
	// OrderItem DAO methods
	
	
	
	
	public int deleteItemInOrder(Long Id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM order_items WHERE order_items_id = ?");){
			statement.setLong(1, Id);
			return statement.executeUpdate();
		}
		catch (Exception e){
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
			
		}
		return 0;
	}

	public Orders createItemOrder(Long orderId, Long items) {

		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("Insert INTO order_items (order_id, item_id) VALUES (?, ?);");) {
			statement.setLong(1, orderId);

			statement.setLong(2, items);

			statement.executeUpdate();
//			return readLatest();

		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}

		return null;

	}

	public List<Items> readAllItemsForAnOrder(Long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();

				PreparedStatement statement = connection.prepareStatement(
						" SELECT item.* FROM items item JOIN order_items oi on item.item_id = oi.item_id WHERE order_id = ?");) {
			statement.setLong(1, orderId);
			List<Items> items = new ArrayList<>();
			try (ResultSet resultSet = statement.executeQuery();) {
				while (resultSet.next()) {
					items.add(itemModelFromResultSet(resultSet));
				}
				return items;
			}
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

}
