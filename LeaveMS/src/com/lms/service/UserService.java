package com.lms.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.dao.IUserDao;
import com.lms.valueobject.User;


@Service
public class UserService implements IUserService{

	private  static final Logger logger=Logger.getLogger(UserService.class);
	
	@Autowired
	IUserDao userdao;
	
	public IUserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(IUserDao userdao) {
		this.userdao = userdao;
	}
	
	@Override
	public boolean saveUser(User userVO) {
	
		logger.info("UserService.saveUser() started ");
		boolean status=userdao.saveUser(userVO);
		logger.info("UserService.saveUser() end ");
		return status;
	}

	public User getUserDetails(long userId)
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

	@Override
	public List<User> getEmployesForApproval() {
		logger.info("UserService.getEmployesForApproval() started ");
		List<User> userList=userdao.getEmployesForApproval();
		logger.info("UserService.getEmployesForApproval() end ");
		return userList;
	}

	@Override
	public boolean approveUsers(List<Long> useridList) {
		logger.info("UserService.approveUsers() started ");
		boolean approved=userdao.approveUsers(useridList);
		logger.info("UserService.approveUsers() end ");
		return approved;
	}

}
