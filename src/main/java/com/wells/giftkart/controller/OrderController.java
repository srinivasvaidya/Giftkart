package com.wells.giftkart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wells.giftkart.exceptions.GiftkartPersistenceException;
import com.wells.giftkart.service.IOrderService;
import com.wells.giftkart.valueobject.Order;
import com.wells.giftkart.valueobject.User;

@Controller
@RequestMapping(value = "/orders")
public class OrderController {

	public static final Logger logger = Logger.getLogger(OrderController.class);

	@Autowired
	IOrderService orderService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView getAllOrders(HttpServletRequest request)
			throws GiftkartPersistenceException {
		logger.info(" getAllOrders() started ");
		ModelAndView orderview = new ModelAndView("orders");
		User user = (User) request.getSession().getAttribute("user");
		Long userid = user.getUserId();

		List<Order> orderList = orderService.getAllOrders(userid);
		orderview.addObject("orderList", orderList);
		logger.info(" getAllOrders() end ");
		return orderview;
	}
}
