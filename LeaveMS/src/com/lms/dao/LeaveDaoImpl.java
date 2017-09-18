package com.lms.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lms.util.HibernateUtil;
import com.lms.valueobject.Leave;
import com.lms.valueobject.User;

 
public class LeaveDaoImpl  extends BaseDaoImpl implements ILeaveDao {
	Logger logger=Logger.getLogger(LeaveDaoImpl.class);


public boolean saveLeave(Leave leave) {
	logger.info(" saveLeave() started ");  
	
	Session session=HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();
	
	session.save(leave);
	session.getTransaction().commit();
	session.close();
	logger.info(" saveLeave() end ");  

	return true;
}

@Override
public List<Leave> getEmployeLeavesForApproval() {
	logger.info(" getEmployeLeavesForApproval() started ");
	Session session=HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();
	
	List<Leave> leavelist = (List<Leave>)session.createQuery("select s from Leave s where usertype='employee' and status='applied'").list();
	session.close();

	return leavelist; 
}

@Override
public boolean approveEmployeeLeaves(List<Long> leaveidList) {
	logger.info(" approveEmployeeLeaves() started ");
	Session session=HibernateUtil.getSessionFactory().openSession();		
	
	for (Long id : leaveidList) {
		Transaction txn=session.beginTransaction();
		Leave leave = (Leave)session.get(Leave.class, id); 
		leave.setStatus("approved");
         //session.update(user);
        txn.commit();
	}
	session.close();
	return true;
}

/*public User getUserDetails(long userId)
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
*/	
}
