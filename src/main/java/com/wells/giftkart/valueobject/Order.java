package com.wells.giftkart.valueobject;

import java.util.Date;
import java.util.List;

public class Order extends BaseVO{

private static final long serialVersionUID = 1L;
	
	private long orderId;
	private String orderStatus;
	private Date orderDate;
	private Date modifiedDate;
	private long userid;
	private List<ProductOrder> productOrders;
	

	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public List<ProductOrder> getProductOrders() {
		return productOrders;
	}
	public void setProductOrders(List<ProductOrder> productOrders) {
		this.productOrders = productOrders;
	}
	
	
	
}
