package com.lms.valueobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="lms_leaves")
public class Leave extends BaseVO{

	private static final long serialVersionUID = 1L;
	
	
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@GenericGenerator(name = "increment", strategy = "increment")
	@GeneratedValue(generator = "increment")
	@Column(name="leaveId", unique=true, nullable=false)
	private long leaveId;
	
	@Column(name="leavetype")
	private String leavetype;
	
	@Column(name="status")
	private String status;
	
	@Column(name="fromdate")
	private Date from;
	
	@Column(name="todate")
	private Date to;

	@Column(name="leavecount")
	private long leavecount;

	@Column(name="approvedby")
	private String approvedby;

	@Column(name="userId")
	private long userId;

	@Column(name="usertype")
	private String usertype;

/*	@ManyToOne
	@JoinColumn(name="userId", referencedColumnName="userId")
	private User user;
*/	
	public long getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(long leaveId) {
		this.leaveId = leaveId;
	}

	public String getLeavetype() {
		return leavetype;
	}

	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public long getLeavecount() {
		return leavecount;
	}

	public void setLeavecount(long leavecount) {
		this.leavecount = leavecount;
	}

	public String getApprovedby() {
		return approvedby;
	}

	public void setApprovedby(String approvedby) {
		this.approvedby = approvedby;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	

}
