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
@Table(name="vechicle")
public class Vechicle {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="vechicle_id")
	private Integer vechicleId;
	
	@Column(name="vechicle_no")
	private Integer vechicleNo;
	
	@Column(name="engine_no")
	private Integer engineNo;
	
	@Column(name="chasis_no")
	private Integer chasisNo;
	
	@Column(name="model")
	private String model;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="type")
	private String type;
	
 
//	@ManyToOne(optional=false)
//	@JoinColumn(name="user_id",referencedColumnName="vechicle_id", insertable=false, updatable=false)
	@OneToOne(cascade = CascadeType.ALL)	
	@JoinColumn(name="user_id")
	  private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getVechicleId() {
		return vechicleId;
	}
	public void setVechicleId(Integer vechicleId) {
		this.vechicleId = vechicleId;
	}
	
	public Integer getVechicleNo() {
		return vechicleNo;
	}
	public void setVechicleNo(Integer vechicleNo) {
		this.vechicleNo = vechicleNo;
	}
	public Integer getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(Integer engineNo) {
		this.engineNo = engineNo;
	}
	public Integer getChasisNo() {
		return chasisNo;
	}
	public void setChasisNo(Integer chasisNo) {
		this.chasisNo = chasisNo;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	

}
