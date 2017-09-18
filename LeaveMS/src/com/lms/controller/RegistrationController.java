package com.lms.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lms.service.IUserService;
import com.lms.valueobject.User;

@Controller
public class RegistrationController {
	public static Logger logger=Logger.getLogger(RegistrationController.class);
	
	@Autowired
	IUserService userService;
	
/*	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		logger.info(" initBinder() started ");
		binder.validate();
		logger.info(" initBinder() end ");
	}
*/	
	/*@ExceptionHandler(GiftkartPersistenceException.class)
	public ModelAndView handleCustomException()
	{
		logger.info(" handleCustomException() started ");
		ModelAndView model=new ModelAndView("error");
		logger.info(" handleCustomException() end ");
		return model;
	}

*/	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView register()
	{
		logger.info(" register() started ");
		ModelAndView registerview=new ModelAndView("registration"); 
		logger.info(" register() end ");
		return registerview;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute ("registerform") @Validated User registerform,BindingResult bindingResult)
	{
		logger.info(" registerUser() started ");
		if(bindingResult.hasErrors())
		{
			logger.info(" binding is failed ");
			return new ModelAndView("error");
		}
		logger.debug("username "+ registerform.getUsername());
		logger.debug("email "+ registerform.getEmail());
		logger.debug("email "+ registerform.toString());
		registerform.setStatus("created");
		registerform.setTotalPaidleaves(24);
		registerform.setTotalsickLeaves(7);
		boolean status=userService.saveUser(registerform);
		ModelAndView view=null;
		if(status)
		{
			view=new ModelAndView("success");
		}
		else {
			view=new ModelAndView("error");
		}
		
		logger.info(" registerUser() end ");
		return view;
	}
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
