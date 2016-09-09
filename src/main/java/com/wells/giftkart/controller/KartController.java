package com.wells.giftkart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wells.giftkart.exceptions.GiftkartPersistenceException;
import com.wells.giftkart.service.IOrderService;
import com.wells.giftkart.valueobject.User;


@Controller
public class KartController {

	public static final Logger logger=Logger.getLogger(KartController.class);
	
	@Autowired
	IOrderService orderService;
	
	@ExceptionHandler(GiftkartPersistenceException.class)
	public ModelAndView hanleIOException()
	{
		logger.info("hanleIOException() started ");
		ModelAndView errorview=new ModelAndView("error");
		return errorview;
	}
	
	@RequestMapping(value="/kart", method=RequestMethod.POST, params="addtokart")
	public ModelAndView addtoKart(HttpServletRequest request)
	{
		logger.info("add to kart start ");
		ModelAndView productsview=new ModelAndView("products");
		User user=(User) request.getSession().getAttribute("user");
		List<Long> sessionKartlist=(List<Long>) request.getSession().getAttribute("sessionKartlist");
		if(sessionKartlist == null)
		{
			sessionKartlist=new ArrayList<Long>();
		}
		String[] selectedProducts= request.getParameterValues("productid");
		List<Long> ProdIdlist=new ArrayList<Long>();
		
		if(selectedProducts != null)
		{
			for(String selectedid : selectedProducts)
			{
				logger.debug("selectedid "+ selectedid);
				ProdIdlist.add(Long.parseLong(selectedid));
			}
			
			sessionKartlist.addAll(ProdIdlist);
			request.getSession().setAttribute("sessionKartlist", sessionKartlist);
			request.getSession().setAttribute("sessionKartsize",sessionKartlist.size() );
		}
		else {
			productsview.setViewName("error");
		}
		
		logger.info("add to kart end ");
	return productsview;	
	}
	
	@RequestMapping(value="/kart", method=RequestMethod.POST, params="checkout")
	public String checkout(HttpServletRequest request) throws GiftkartPersistenceException
	{
		logger.info("checkout() start  ");
		User user=(User) request.getSession().getAttribute("user");
		List<Long> sessionKartlist=(List<Long>) request.getSession().getAttribute("sessionKartlist");
		if(sessionKartlist == null)
		{
			sessionKartlist=new ArrayList<Long>();
		}
		String[] selectedProducts= request.getParameterValues("productid");
		List<Long> ProdIdlist=new ArrayList<Long>();
		
		if(selectedProducts != null)
		{
			for(String selectedid : selectedProducts)
			{
				logger.debug("selectedid "+ selectedid);
				ProdIdlist.add(Long.parseLong(selectedid));
			}
			
			sessionKartlist.addAll(ProdIdlist);
		}
		request.getSession().setAttribute("sessionKartlist", sessionKartlist);
		request.getSession().setAttribute("sessionKartsize",sessionKartlist.size() );
		
		Long orderid=orderService.order(user, sessionKartlist);
		if(orderid != null)
		{
			request.getSession().removeAttribute("sessionKartlist");
			request.getSession().removeAttribute("sessionKartsize");
			logger.info("checkout() end :success ");
			return "success";
		}
		else {
			logger.info("checkout() failed  ");
			return "error";
		}
		
}
}
