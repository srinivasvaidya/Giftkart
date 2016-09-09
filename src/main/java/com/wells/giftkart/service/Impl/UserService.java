package com.wells.giftkart.service.Impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wells.giftkart.dao.IUserDao;
import com.wells.giftkart.exceptions.GiftkartPersistenceException;
import com.wells.giftkart.service.IUserService;
import com.wells.giftkart.valueobject.User;

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
	public boolean saveUser(User userVO) throws GiftkartPersistenceException{
	
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
	public boolean rechargeAccount(User userVO) {
		logger.info("UserService.rechargeAccount() started ");
		boolean status=userdao.rechargeAccount(userVO);
		logger.info("UserService.rechargeAccount() end ");
		return status;
	}
}
