package com.beyonmdcp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name="usertoken")

public class Token {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="token_id")
	private Integer tokenId;
	
	@Column(name="token")
	private String token;
	 

	@Column(name="customer_id")
	private Integer customerId;
	
	@Column(name="date",nullable=false,updatable = false)
	@CreationTimestamp
	private Date date;



	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public Integer getTokenId() {
		return tokenId;
	}


	public void setTokenId(Integer tokenId) {
		this.tokenId = tokenId;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	

}
