package com.instagram.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.instagram.dto.Signoutdto;
@Entity
@Table(name= "signinentity")
public class Signinentity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@OneToOne(mappedBy = "signinentity")
	private Signoutentity signoutentity;
	
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
	public Signoutentity getSignoutentity() {
		return signoutentity;
	}
	public void setSignoutentity(Signoutentity signoutentity) {
		this.signoutentity = signoutentity;
	}


}
