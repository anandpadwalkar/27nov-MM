package com.iitms.rfcampusdata.authentication.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ua_society_master")
public class SocietyMaster1 implements Serializable{

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "soc_id", columnDefinition = "serial")
	private int id;
	@Column(name = "soc_name")
	private String societyName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSocietyName() {
		return societyName;
	}
	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}
	
	
}
