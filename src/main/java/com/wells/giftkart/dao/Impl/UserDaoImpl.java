package com.wells.giftkart.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.wells.giftkart.dao.IUserDao;
import com.wells.giftkart.exceptions.GiftkartPersistenceException;
import com.wells.giftkart.util.HibernateUtil;
import com.wells.giftkart.valueobject.Account;
import com.wells.giftkart.valueobject.Address;
import com.wells.giftkart.valueobject.User;

 
public class UserDaoImpl  extends BaseDaoImpl implements IUserDao {
	Logger logger=Logger.getLogger(UserDaoImpl.class);


public boolean saveUser(User userVO) throws GiftkartPersistenceException{
	logger.info(" saveUser() started ");  
	String sql= "insert into t_gk_users values(?,?,?,?,?,?,?,?)";
	logger.debug(" save user() sql : "+sql); 
	
	Object[] values = new Object[8];
	int index = 0;
	values[index++]=userVO.getUserId();
	values[index++]=userVO.getUsername();
	values[index++]=userVO.getPassword();
	values[index++]=userVO.getFirstname();
	values[index++]=userVO.getLastname();				
	values[index++]=userVO.getEmail();		
	values[index++]=userVO.getAddress().getAddressId();			
	values[index++]=userVO.getAccount().getAccountNumber();
	
	
	try{
		saveAddress(userVO.getAddress());
		
		saveAccount(userVO.getAccount());
		
		int status=getJdbcTemplate().update(sql, values);
		
		logger.debug(" save user() status : "+status);
	}
	catch(DataAccessException DAex)
	{
		throw new GiftkartPersistenceException();
	}
	
	logger.info(" saveUser() end ");  
	return true;
}

public boolean saveAddress(Address addressVO) throws GiftkartPersistenceException{
	logger.info(" saveAddress() started ");  
	String sql= "insert into t_gk_address values(?,?,?,?,?,?)";
	logger.debug(" save user() sql : "+sql); 
	
	Object[] params = new Object[6];
	int index = 0;
	params[index++]=addressVO.getAddressId();
	params[index++]=addressVO.getHouseNumber();
	params[index++]=addressVO.getStreetname();
	params[index++]=addressVO.getCity();
	params[index++]=addressVO.getState();				
	params[index++]=addressVO.getPincode();						
	
	
 	int status=getJdbcTemplate().update(sql, params);
	
	logger.debug(" save user() status : "+status);
	logger.info(" saveAddress() end ");  
	return true;
}


public boolean saveAccount(Account	accountVO) throws GiftkartPersistenceException {
	logger.info(" saveAccount() started ");  
	String sql= "insert into t_gk_accounts values(?,?)";
	logger.debug(" save user() sql : "+sql); 
	
	Object[] params = new Object[2];
	int index = 0;
	params[index++]=accountVO.getAccountNumber();
	params[index++]=accountVO.getBalance();
															
	int status=getJdbcTemplate().update(sql, params);
	
	logger.debug(" save user() status : "+status);
	logger.info(" saveAccount() end ");  
	return true;
}

public User getUserDetails(long userId)
	{
	
	logger.info(" getUserDetails() started ");  
	String sql= "select * from t_gk_users users, t_gk_address address, t_gk_accounts accounts where users.userid= ? and users.addressid=address.addressid and users.accountnumber=accounts.accountnumber";
	logger.debug("  getUserDetails() sql : "+sql); 
	int intUserId=(int) userId;
	
	Object[] params = new Object[1];
	int index = 0;
	params[index]=intUserId;
	
	
	logger.debug("  getUserDetails() params are : "+params.toString()); 
	final RowMapper<User> mapper=new RowMapper<User>() {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			logger.info(" mapRow() started ");  
			return fillVOforgetUserDetails(rs);
		}
	};
	
	User user=getJdbcTemplate().queryForObject(sql,params,mapper);
	//User user=getJdbcTemplate().queryForObject(sql,mapper);
	logger.debug(" user details are "+ user);
	logger.debug(" user details are "+ user.getPassword());
	logger.info(" getUserDetails() end  ");  
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
		
		Address addressVO=new Address();
		addressVO.setAddressId(rs.getLong("addressid"));
		addressVO.setHouseNumber(rs.getString("housenumber"));
		addressVO.setStreetname(rs.getString("streetname"));
		addressVO.setCity(rs.getString("city"));
		addressVO.setState(rs.getString("state"));
		addressVO.setPincode(rs.getLong("pincode"));
		
		Account accountVO=new Account();
		accountVO.setAccountNumber(rs.getLong("accountnumber"));
		accountVO.setBalance(rs.getDouble("balance"));
		
		userVO.setAddress(addressVO);
		userVO.setAccount(accountVO);
		
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
	public boolean rechargeAccount(User userVO) {
	logger.info(" rechargeAccount() started ");  
	boolean status=true;
	Session session=HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();
	
	long userid=userVO.getUserId();
	logger.info(" login userid "+ userid);  
	User user=(User)session.get(User.class, userid);
	
	logger.debug(" retrieved user from Db ");  
	
	Account accountVO=user.getAccount();
	Double balance= accountVO.getBalance();
	balance=balance + userVO.getAccount().getBalance();
	accountVO.setBalance(balance);
	
	/*try {
		session.update(accountVO);
	} catch (HibernateException e) {
		logger.info(" exception, in catch block ");  
		status=false;
		e.printStackTrace();
		session.getTransaction().rollback();
	}*/
	session.getTransaction().commit();
	session.close();
	logger.debug(" rechargeAccount status : "+status);
	logger.info(" rechargeAccount() end ");  
	return status;
	}
	}
