package com.wells.giftkart.service;

import java.util.List;

import com.wells.giftkart.exceptions.GiftkartPersistenceException;
import com.wells.giftkart.valueobject.User;

public interface IUserService {

	public boolean saveUser(User user) throws GiftkartPersistenceException;
	
	public User getUserDetails(long userId);
	
	public List<User> getAllUserDetails();
	
	public boolean rechargeAccount(User user);
}
