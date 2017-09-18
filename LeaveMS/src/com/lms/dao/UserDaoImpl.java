package com.lms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.lms.util.HibernateUtil;
import com.lms.valueobject.User;

 
public class UserDaoImpl  extends BaseDaoImpl implements IUserDao {
	Logger logger=Logger.getLogger(UserDaoImpl.class);


public boolean saveUser(User userVO) {
	logger.info(" saveUser() started ");  
	Session session=HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();
	
	session.save(userVO);
	session.getTransaction().commit();
	session.close();
	
	logger.info(" saveUser() end ");  
	return true;
}

public User getUserDetails(long userId)
	{
	
	logger.info(" getUserDetails() started ");
	Session session=HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();
	
	User user=(User)session.get(User.class, userId);
	session.close();

	return user; 
}

	private User fillVOforgetUserDetails(ResultSet rs) throws SQLException{
		logger.info(" fillVOforgetUserDetails() started ");  
	User userVO= null;
	if(rs!=null)
	{
		logger.info(" result set is not null ");  
		userVO=new User();
		userVO.setUserId(rs.getLong("userid"));
		userVO.setUsername(rs.getString("username"));
		userVO.setFirstname(rs.getString("firstname"));
		userVO.setLastname(rs.getString("lastname"));
		userVO.setEmail(rs.getString("email"));
		userVO.setPassword(rs.getString("password"));;
		
	}
	logger.info(" fillVOforgetUserDetails() end ");  
	return userVO;
	}
	
	
	public List<User> getAllUserDetails()
	{
	logger.info(" getAllUserDetails() started ");  
	String sql= "select * from t_gk_users users, t_gk_address address, t_gk_accounts accounts where users.addressid=address.addressid and users.accountnumber=accounts.accountnumber";
	logger.debug("  getAllUserDetails() sql : "+sql); 
	
	final List<User> userList=new ArrayList<User>();
	 
	final RowMapper<List<User>> mapper=new RowMapper<List<User>>() {
		@Override
		public List<User> mapRow(ResultSet rs, int rowNum) throws SQLException {
			userList.add(fillVOforgetUserDetails(rs));
			return userList;
		}
	};
	
	getJdbcTemplate().query(sql, mapper);

	logger.info(" getAllUserDetails() end ");  
	return userList;
	}

	@Override
	public List<User> getEmployesForApproval() {
		logger.info(" getEmployesForApproval() started ");
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<User> userlist = (List<User>)session.createQuery("select s from User s where usertype='employee' and status='created'").list();
		session.close();

		return userlist; 
	}

	@Override
	public boolean approveUsers(List<Long> useridList) {
		logger.info(" getEmployesForApproval() started ");
		Session session=HibernateUtil.getSessionFactory().openSession();		
		
		for (Long id : useridList) {
			Transaction txn=session.beginTransaction();
			User user = (User)session.get(User.class, id); 
			user.setStatus("approved");
	         //session.update(user);
	        txn.commit();
		}
		session.close();
		return true;
	}
	
}
