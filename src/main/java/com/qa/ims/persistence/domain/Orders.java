package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {
	private Long orderId;
	private Long customerId;
	List<Items> items = new ArrayList<>();

	public Orders(Long customerId) {
		super();
		this.setCustomerId(customerId);
	}

	public Orders(Long orderId, Long customerId) {
		super();
		this.setOrderId(orderId);
		this.setCustomerId(customerId);

	}

	public Double getTotalCost() {
		Double totalCost = 0d;
		for (Items i : items) {
			totalCost += i.getItemPrice();
		}
		return totalCost;

	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Orders orderId=" + orderId + ", customerId= " + customerId + " totalPrice " + getTotalCost()
				+ "\n ----------------------------------------------------------";

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}

}
