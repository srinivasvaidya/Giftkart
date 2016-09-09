
package com.wells.giftkart.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="t_gk_users")
public class User extends BaseVO{

	private static final long serialVersionUID = 1L;
	
	@Id
	//@GenericGenerator(name = "increment", strategy = "increment")
	//@GeneratedValue(generator = "increment")
	@GeneratedValue
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
	
	@OneToOne
	@JoinColumn(name="addressid")
	private Address address;
	
	@OneToOne
	@JoinColumn(name="accountNumber")
	private Account account;
	//private List<Order> ordersList;
	
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
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	/*public List<Order> getOrdersList() {
		return ordersList;
	}
	public void setOrdersList(List<Order> ordersList) {
		this.ordersList = ordersList;
	}*/
	
	
	
}
