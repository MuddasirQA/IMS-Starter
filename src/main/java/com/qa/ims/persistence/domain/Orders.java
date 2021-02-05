package com.qa.ims.persistence.domain;



public class Orders{
	public Long orderId;
	public Long customerId;
	public Double totalCost;
	public Long itemId;


	public Orders(Long orderId, Long customerId, Double totalCost) {
		super();
		this.setOrderId(orderId);
		this.setCustomerId(customerId);
		this.setTotalCost(totalCost);
		
	}
	public Orders(Long orderId, Long customerId,  Long itemId, Double totalCost) {
	     super();
		this.setOrderId(orderId);
		this.setTotalCost(totalCost);
		this.setCustomerId(customerId);
		this.setItemId(itemId);
	
	
	}
	public Orders(Long orderId, Long customerId) {
		super();
		this.setOrderId(orderId);
		this.setCustomerId(customerId);
		
	}
	public Orders(Long customerId, Double totalCost, Long itemId) {
		super();
		 this.setCustomerId(customerId);
		 this.setTotalCost(totalCost);
		 this.setItemId(itemId);
		
	
		
	
	}
	public Orders(Long customerId) {
		super();
		this.setCustomerId(customerId);
	}



	public Long getItemId(Long itemId) {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
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

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "Orders orderId=" + orderId + ", customerId= " + customerId + ", totalCost= " + totalCost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((totalCost == null) ? 0 : totalCost.hashCode());
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
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (totalCost == null) {
			if (other.totalCost != null)
				return false;
		} else if (!totalCost.equals(other.totalCost))
			return false;
		return true;
	}



}
