package com.iitms.rfcampusdata.authentication.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ua_university_master")
public class UniversityEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "univ_id", columnDefinition = "serial")
	private int uid;

	@Column(name = "univ_code")
	private String univCode;

	@Column(name = "univ_name")
	private String univName;
	@Column(name = "active")	
    private int active;
	
	
	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUnivCode() {
		return univCode;
	}

	public void setUnivCode(String univCode) {
		this.univCode = univCode;
	}

	public String getUnivName() {
		return univName;
	}

	public void setUnivName(String univName) {
		this.univName = univName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UniversityEntity [univCode=" + univCode + ", univName=" + univName + "]";
	}

}
