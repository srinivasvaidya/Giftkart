package com.wells.giftkart.service;

import java.util.List;

import com.wells.giftkart.exceptions.GiftkartPersistenceException;
import com.wells.giftkart.valueobject.Order;
import com.wells.giftkart.valueobject.User;


public interface IOrderService{

	public Long order(User user, List<Long> sessionKartlist) throws GiftkartPersistenceException;

	public List<Order> getAllOrders(Long userid) throws GiftkartPersistenceException;

	public List<Order> getAllOrders2(long userid) throws GiftkartPersistenceException;

}
