package com.wells.giftkart.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;





@Entity
@Table(name="t_gk_address")
public class Address extends BaseVO{

	private static final long serialVersionUID = 1L;
	
	@Id
	//@GenericGenerator(name = "increment", strategy = "increment")
	//@GeneratedValue(generator = "increment")
	@GeneratedValue
	@Column(name="addressid", unique=true, nullable=false)
	private long addressId;
	
	@Column(name="housenumber")
	private String houseNumber;
	
	@Column(name="streetname")
	private String streetname;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="pincode")
	private long pincode;
	
	/*@OneToOne(mappedBy="address")
	private User user;*/
	
	
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	
	
}
