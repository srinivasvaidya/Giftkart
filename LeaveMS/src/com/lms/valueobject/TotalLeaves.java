
package com.lms.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="lms_total_leaves")
public class TotalLeaves extends BaseVO{

	private static final long serialVersionUID = 1L;
	
	@Id
	//@GenericGenerator(name = "increment", strategy = "increment")
	//@GeneratedValue(generator = "increment")
	@GeneratedValue
	@Column(name="userId", unique=true, nullable=false)
	private long userId;
	
	@Column(name="total_paidleaves")
	private String totalPaidleaves;
	
	@Column(name="total_sickleaves")
	private String totalsickLeaves;
	
	@Column(name="used_paidleaves")
	private String usedPaidleaves;
	
	@Column(name="used_sickleaves")
	private String usedSickLeaves;

	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getTotalPaidleaves() {
		return totalPaidleaves;
	}

	public void setTotalPaidleaves(String totalPaidleaves) {
		this.totalPaidleaves = totalPaidleaves;
	}

	public String getTotalsickLeaves() {
		return totalsickLeaves;
	}

	public void setTotalsickLeaves(String totalsickLeaves) {
		this.totalsickLeaves = totalsickLeaves;
	}

	public String getUsedPaidleaves() {
		return usedPaidleaves;
	}

	public void setUsedPaidleaves(String usedPaidleaves) {
		this.usedPaidleaves = usedPaidleaves;
	}

	public String getUsedSickLeaves() {
		return usedSickLeaves;
	}

	public void setUsedSickLeaves(String usedSickLeaves) {
		this.usedSickLeaves = usedSickLeaves;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
