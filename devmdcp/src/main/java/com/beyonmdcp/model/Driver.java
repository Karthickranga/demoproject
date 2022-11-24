package com.beyonmdcp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="driver")
public class Driver {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="driver_id")
	private Integer driverId;
	
	@Column(name="dfirst_name")
	private String dfirstName;
	
	@Column(name="dlast_name")
	private String dlastName;
	
	@Column(name="license_no")
	private Integer licenseNo;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="country")
	private String country;
	
	@Column(name="address")
	private String address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	
//	@ManyToOne(optional=false)
//	@JoinColumn(name="user_id",referencedColumnName="driver_id", insertable=false, updatable=false)
	
	

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getDriverId() {
		return driverId;
	}
	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}
	public String getDfirstName() {
		return dfirstName;
	}
	public void setDfirstName(String dfirstName) {
		this.dfirstName = dfirstName;
	}
	public String getDlastName() {
		return dlastName;
	}
	public void setDlastName(String dlastName) {
		this.dlastName = dlastName;
	}
	public Integer getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(Integer licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
