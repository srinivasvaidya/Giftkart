package com.lms.dao;

import java.util.List;

import com.lms.valueobject.User;


public interface IUserDao {

   public boolean saveUser(User user);
//	
	public User getUserDetails(long userId);
//	
	public List<User> getAllUserDetails();
	
	public List<User> getEmployesForApproval();
	
	public boolean approveUsers(List<Long> useridList);
}
