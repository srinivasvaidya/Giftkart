package com.lms.service;

import java.util.List;

import com.lms.valueobject.Leave;
import com.lms.valueobject.User;


public interface ILeaveService {

	public boolean saveLeave(Leave leave);
//	
	//public User getUserDetails(long userId);
//	
	//public List<User> getAllUserDetails();
//	
	
	public List<Leave> getEmployeLeavesForApproval();
	
	public boolean approveEmployeeLeaves(List<Long> useridList);

}
