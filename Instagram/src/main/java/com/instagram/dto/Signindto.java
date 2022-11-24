package com.instagram.dto;

public class Signindto {
	private Integer id;
	private String name;
	private Signoutdto signoutdto;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Signoutdto getSignoutdto() {
		return signoutdto;
	}
	public void setSignoutdto(Signoutdto signoutdto) {
		this.signoutdto = signoutdto;
	}

}
