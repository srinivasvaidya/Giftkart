package com.lms.dao;

import java.util.List;

import com.lms.valueobject.Leave;


public interface ILeaveDao {

	public boolean saveLeave(Leave leave);
//	
//	public User getUserDetails(long userId);
//	
//	public List<User> getAllUserDetails();
	public List<Leave> getEmployeLeavesForApproval();
	
	public boolean approveEmployeeLeaves(List<Long> useridList);

}
