package com.lms.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lms.service.ILeaveService;
import com.lms.service.IUserService;
import com.lms.valueobject.Leave;
import com.lms.valueobject.User;


@Controller 
public class HomeController {

	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	@Autowired
	private ILeaveService leaveService;
	
	@Autowired
	private IUserService userService;
	
	public ILeaveService getLeaveService() {
		return leaveService;
	}

	public void setLeaveService(ILeaveService leaveService) {
		this.leaveService = leaveService;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView getHomePage() 
	{
		logger.info(" getHomePage() started "); 
		ModelAndView welcomeview=new ModelAndView("home"); 
		
		logger.info(" getHomePage() end "); 
		return welcomeview;
	}
	
	@RequestMapping(value="/applyleave", method=RequestMethod.POST)
	public ModelAndView applyLeave(@RequestParam String from,@RequestParam String to,@RequestParam String leavetype, HttpServletRequest request,HttpServletResponse response) 
	{
		logger.info(" applyLeave() started "); 
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date fromdate=formatter.parse(from);
			Date todate=formatter.parse(to);
			int leavecount=todate.getDate() -fromdate.getDate();
			User user=(User)request.getSession().getAttribute("user");
			
			Leave leave=new Leave();
			leave.setFrom(fromdate);
			leave.setTo(todate);
			leave.setLeavetype(leavetype);
			leave.setStatus("applied");
			leave.setLeavecount(leavecount+1); 
			leave.setApprovedby("");
			leave.setUserId(user.getUserId());
			leave.setUsertype(user.getUsertype());
			leaveService.saveLeave(leave);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView welcomeview=new ModelAndView("success"); 
		logger.info(" applyLeave() end "); 
		return welcomeview;
	}
	
	@RequestMapping(value="/approveemployee", method=RequestMethod.GET)
	public ModelAndView approveemployee(HttpServletRequest request,HttpServletResponse response) 
	{
		logger.info(" approveemployee() started "); 
		ModelAndView userview=new ModelAndView("user"); 
		
		List<User> userlist=userService.getEmployesForApproval();
		request.getSession().setAttribute("userlist", userlist);
		userview.addObject("userlist", userlist);
		
		logger.info(" approveemployee() end "); 
		return userview;
	}
	
	@RequestMapping(value="/approveuser", method=RequestMethod.POST)
	public ModelAndView approveuser( HttpServletRequest request,HttpServletResponse response) 
	{
		logger.info(" approveuser() started "); 
		ModelAndView userview=new ModelAndView("success"); 
		
		String[] selectedUsers= request.getParameterValues("userId");
		List<Long> userIdlist=new ArrayList<Long>();
		
		if(selectedUsers != null)
		{
			for(String selectedid : selectedUsers)
			{
				logger.debug("selectedid "+ selectedid);
				userIdlist.add(Long.parseLong(selectedid));
			}
			userService.approveUsers(userIdlist);
		}
		else {
			userview.setViewName("error");
		}
		
		logger.info("approveuser end ");
		return userview;	
	}

	@RequestMapping(value="/approveempleaves", method=RequestMethod.GET)
	public ModelAndView approveempleaves(HttpServletRequest request,HttpServletResponse response) 
	{
		logger.info(" approveempleaves() started "); 
		ModelAndView userview=new ModelAndView("leaves"); 
		
		List<Leave> leaveslist=leaveService.getEmployeLeavesForApproval();
		request.getSession().setAttribute("leaveslist", leaveslist);
		userview.addObject("leaveslist", leaveslist);
		
		logger.info(" approveempleaves() end "); 
		return userview;
	}

	@RequestMapping(value="/approveempleaves", method=RequestMethod.POST)
	public ModelAndView approveempleavespost( HttpServletRequest request,HttpServletResponse response) 
	{
		logger.info(" approveempleaves() started "); 
		ModelAndView userview=new ModelAndView("success"); 
		
		String[] selectedLeaves= request.getParameterValues("leaveId");
		List<Long> leaveIdlist=new ArrayList<Long>();
		
		if(selectedLeaves != null)
		{
			for(String selectedid : selectedLeaves  )
			{
				logger.debug("selectedid "+ selectedid);
				leaveIdlist.add(Long.parseLong(selectedid));
			}
			leaveService.approveEmployeeLeaves(leaveIdlist);
		}
		else {
			userview.setViewName("error");
		}
		
		logger.info("approveempleaves end ");
		return userview;	
	}

}
