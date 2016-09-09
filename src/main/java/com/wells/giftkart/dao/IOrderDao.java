package com.wells.giftkart.dao;

import java.util.List;

import com.wells.giftkart.exceptions.GiftkartPersistenceException;
import com.wells.giftkart.valueobject.Order;
import com.wells.giftkart.valueobject.ProductOrder;

public interface IOrderDao extends IBaseDao{

	public Long saveOrder(Long userid) throws GiftkartPersistenceException;
	
	public void saveProductOrder(Long orderid, List<Long> kartProdIds) throws GiftkartPersistenceException;
	
	public Order getOrder(Long orderid);
	
	
	public boolean updateOrder(Long orderid);

	public List<Order> getAllOrders(Long userid);

	public List<ProductOrder> getAllProdOrders(Long orderid);

	public List<Order> getAllOrders2(Long userid);
}
