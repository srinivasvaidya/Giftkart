package com.wells.giftkart.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="t_gk_accounts")
public class Account extends BaseVO{
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GenericGenerator(name = "increment", strategy = "increment")
	//@GeneratedValue(generator = "increment")
	@GeneratedValue
	@Column(name="accountnumber", unique=true, nullable=false)
	private long accountNumber;
	
	@Column(name="balance")
	private Double balance;
	
	/*@OneToOne(mappedBy="account")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
*/
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	
	
	
}
