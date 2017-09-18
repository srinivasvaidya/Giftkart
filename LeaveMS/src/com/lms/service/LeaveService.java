package com.lms.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.dao.ILeaveDao;
import com.lms.valueobject.Leave;
import com.lms.valueobject.User;


@Service
public class LeaveService implements ILeaveService{

	private  static final Logger logger=Logger.getLogger(LeaveService.class);
	
	@Autowired
	ILeaveDao leavedao;
	
		
	@Override
	public boolean saveLeave(Leave leave) {
	
		logger.info("saveLeave started ");
		boolean status=leavedao.saveLeave(leave);
		logger.info("saveLeave end ");
		return status;
	}

	@Override
	public List<Leave> getEmployeLeavesForApproval() {
		logger.info("UserService.getEmployeLeavesForApproval() started ");
		List<Leave> leaveslist=leavedao.getEmployeLeavesForApproval();
		logger.info("UserService.getEmployeLeavesForApproval() end ");
		return leaveslist;
	}

@Override
	public boolean approveEmployeeLeaves(List<Long> leaveidList) {
		logger.info("UserService.approveEmployeeLeaves() started ");
		boolean approved=leavedao.approveEmployeeLeaves(leaveidList);
		logger.info("UserService.approveEmployeeLeaves() end ");
		return approved;
	}


	/*public User getUserDetails(long userId)
	{
		logger.info("UserService.getUserDetails() started ");
		User user=userdao.getUserDetails(userId);
		logger.debug(" user id passed is "+userId);
		logger.debug(" user details are "+ user.getPassword()); 
		logger.debug(" user name is   "+ user.getUsername());
		logger.info("UserService.getUserDetails() end ");
		return user;
	}
	
	@Override
	public List<User> getAllUserDetails() {
		logger.info("UserService.getAllUserDetails() started ");
		List<User> userList=userdao.getAllUserDetails();
		logger.info("UserService.getAllUserDetails() end ");
		return userList;
	}
*/
}
