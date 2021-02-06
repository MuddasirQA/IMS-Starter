package com.qa.ims.persistence.domain;

import java.util.List;

public class Orders{
	public Long orderId;
	public Long customerId;
	List<Items> items;

	
	

	

//
//	public List<Items> getItems() {
//		return items;
//	}

    public Double getTotalCost() {
    	Double totalCost =  0d;
    	for(Items i : items) {
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


	// for creating a new order
	public Orders(Long customerId) {
		super();
		this.setCustomerId(customerId);
	}

	
	public Orders(Long orderId, Long customerId, Long itemId2) {
		super();
		this.setOrderId(orderId);
		this.setCustomerId(customerId);

		
	}

	
	
	public Orders(Long orderId, Long customerId) {
		super();
		this.setOrderId(orderId);
		this.setCustomerId(customerId);
		
	}

	
	



	
	public Long getItemId(Long itemId) {
		return itemId;
	}
//	public void setItemId(Long itemId) {
//		this.itemId = itemId;
//	}
	
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
		return "Orders orderId=" + orderId + ", customerId= " + customerId + " totalPrice" + getTotalCost();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
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
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}





}
