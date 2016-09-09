package com.wells.giftkart.service.Impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wells.giftkart.dao.IOrderDao;
import com.wells.giftkart.exceptions.GiftkartPersistenceException;
import com.wells.giftkart.service.IOrderService;
import com.wells.giftkart.valueobject.Order;
import com.wells.giftkart.valueobject.ProductOrder;
import com.wells.giftkart.valueobject.User;

/**
 * @author u268407
 *
 */
@Service
public class OrderService implements IOrderService {
	
	public static final Logger logger=Logger.getLogger(OrderService.class);
	
	@Autowired
	IOrderDao orderDao;
	
	public Long order(User user,List<Long>  kartProdIds) throws GiftkartPersistenceException
	{
		logger.info("in order() started "); 
		Long orderid=orderDao.saveOrder(user.getUserId());
		
		orderDao.saveProductOrder(orderid, kartProdIds);
		
		logger.info("in order() end "); 
		return orderid;
}
	
	public List<Order> getAllOrders(Long userid) throws GiftkartPersistenceException
	{
		logger.info("in getAllOrders() started "); 
		List<Order> orderList=orderDao.getAllOrders(userid);
		
		for(Order orderVO:orderList)
		{
			Long orderid=orderVO.getOrderId();
			List<ProductOrder> prodOrdersList=orderDao.getAllProdOrders(orderid);
			orderVO.setProductOrders(prodOrdersList);
		}
		logger.info("in getAllOrders() end "); 
		return orderList;
}

	@Override
	public List<Order> getAllOrders2(long userid)
			throws GiftkartPersistenceException {
		logger.info("in getAllOrders() started "); 
		List<Order> orderList=orderDao.getAllOrders2(userid);
		
		logger.info("in getAllOrders() end "); 
		return orderList;
	}
}