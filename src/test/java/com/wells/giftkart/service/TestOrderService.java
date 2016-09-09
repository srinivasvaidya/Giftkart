package com.wells.giftkart.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wells.giftkart.exceptions.GiftkartPersistenceException;
import com.wells.giftkart.valueobject.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-core.xml", "classpath:spring/spring-jdbc.xml" })
public class TestOrderService {

	
	@Autowired
	IOrderService orderService;
	
	@After
	public void tearDown() throws Exception {
	}

	@Test@Ignore
	public void testGetAllOrders() {
		try {
			List<Order> orderList=orderService.getAllOrders(101L);
			
			int expected=3;
		//	int actual=orderList.size();
			assertNotNull(orderList);
		} catch (GiftkartPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test@Ignore
	public void testGetAllOrders2() {
		try {
			List<Order> orderList=orderService.getAllOrders2(101L);
			
			assertNotNull(orderList);
			assertEquals(3, orderList.size());
			
		} catch (GiftkartPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
