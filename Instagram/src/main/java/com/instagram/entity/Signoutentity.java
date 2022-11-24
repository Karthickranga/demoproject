package com.instagram.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="signoutentity")
public class Signoutentity {
	@Id
	@Column(name="age")
	private String age;
	@Column(name="city")
	private String city;
	@OneToOne
	@JoinColumn(name="id")
	private Signinentity signinentity;

	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Signinentity getSigninentity() {
		return signinentity;
	}
	public void setSigninentity(Signinentity signinentity) {
		this.signinentity = signinentity;
	}
	
}
