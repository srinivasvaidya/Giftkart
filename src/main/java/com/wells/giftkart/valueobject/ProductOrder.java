package com.wells.giftkart.valueobject;

import java.util.Date;

public class ProductOrder extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	private long orderId;
	private long productorderId;
	private String prodorderStatus;
	private Date orderDate;
	private Date modifiedDate;
	private long productid;


	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getProductorderId() {
		return productorderId;
	}
	public void setProductorderId(long productorderId) {
		this.productorderId = productorderId;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public long getProductid() {
		return productid;
	}
	public void setProductid(long productid) {
		this.productid = productid;
	}

	public Date getOrderDate() {
		return orderDate;
	}
	public String getProdorderStatus() {
		return prodorderStatus;
	}
	public void setProdorderStatus(String prodorderStatus) {
		this.prodorderStatus = prodorderStatus;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	@Override
	public String toString() {
		return "ProductOrder [orderId=" + orderId + ", productorderId="
				+ productorderId + ", prodorderStatus=" + prodorderStatus
				+ ", orderDate=" + orderDate + ", modifiedDate=" + modifiedDate
				+ ", productid=" + productid + "]";	
	}
	}
