
package com.lms.valueobject;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="lms_users")
public class User extends BaseVO{

	private static final long serialVersionUID = 1L;
	
	//@GeneratedValue
	@Id
	@GenericGenerator(name = "increment", strategy = "increment")
	@GeneratedValue(generator = "increment")
	@Column(name="userId", unique=true, nullable=false)
	private long userId;
	
	@Column(name="username", unique=true, nullable=false)
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="usertype")
	private String usertype;
	
	@Column(name="status")
	private String status;
	
	@Column(name="totalpaidleaves")
	private long totalPaidleaves;
	
	@Column(name="totalsickleaves")
	private long totalsickLeaves;
	
	@Column(name="usedpaidleaves")
	private long usedPaidleaves;
	
	@Column(name="usedsickleaves")
	private long usedSickLeaves;

	@OneToMany
	private List<Leave> leaveList;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Leave> getLeaveList() {
		return leaveList;
	}
	public void setLeaveList(List<Leave> leaveList) {
		this.leaveList = leaveList;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getTotalPaidleaves() {
		return totalPaidleaves;
	}
	public void setTotalPaidleaves(long totalPaidleaves) {
		this.totalPaidleaves = totalPaidleaves;
	}
	public long getTotalsickLeaves() {
		return totalsickLeaves;
	}
	public void setTotalsickLeaves(long totalsickLeaves) {
		this.totalsickLeaves = totalsickLeaves;
	}
	public long getUsedPaidleaves() {
		return usedPaidleaves;
	}
	public void setUsedPaidleaves(long usedPaidleaves) {
		this.usedPaidleaves = usedPaidleaves;
	}
	public long getUsedSickLeaves() {
		return usedSickLeaves;
	}
	public void setUsedSickLeaves(long usedSickLeaves) {
		this.usedSickLeaves = usedSickLeaves;
	}

}
