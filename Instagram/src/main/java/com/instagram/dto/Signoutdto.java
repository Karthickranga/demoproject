package com.instagram.dto;



public class Signoutdto {
	private String age;
	private String city;
	private Signindto signindto;
	
	public Signindto getSignindto() {
		return signindto;
	}
	public void setSignindto(Signindto signindto) {
		this.signindto = signindto;
	}
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
	

}
