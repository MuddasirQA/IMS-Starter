package com.qa.ims.persistence.domain;

public class Orders {
	public Long orderId;
	public Long customerId;
	public Double totalCost;
	
	
	
	
	public Orders(Long orderId, Long customerId, Double totalCost) {
		super();
		this.setOrderId(orderId);
		this.setCustomerId(customerId);
	}
	public Orders(Long customerId, Double totalCost) {
		super();
		this.setOrderId(orderId);
		this.setCustomerId(customerId);
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
		result = prime * result + (int) (customerId ^ (customerId >>> 32));
		result = prime * result + (int) (orderId ^ (orderId >>> 32));
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
		if (customerId != other.customerId)
			return false;
		if (orderId != other.orderId)
			return false;
		if (totalCost == null) {
			if (other.totalCost != null)
				return false;
		} else if (!totalCost.equals(other.totalCost))
			return false;
		return true;
	}


	
	

	
	
}
