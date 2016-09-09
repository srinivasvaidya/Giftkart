package com.wells.giftkart.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wells.giftkart.valueobject.User;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:GiftKart/src/main/webapp/WEB-INF/spring-mvc-servlet.xml","spring/spring-core.xml", "spring/spring-jdbc.xml" })
@ContextConfiguration(locations={"classpath:spring/spring-core.xml", "classpath:spring/spring-jdbc.xml" })
public class TestUserService extends TestCase {

	@Autowired
	IUserService userService;
	
	@Before
	public void prepare()
	{
		//assertTrue(5<4);
	}
	
	@Test@Ignore
	public void testgetAllUserDetails()
	{
		List<User> users=new ArrayList<User>();
		//UserService userService=new UserService();
		users=userService.getAllUserDetails();
		int expected=5;
		int actual=users.size();
		assertEquals(expected, actual);
	}
}
