package com.iitms.rfcampusdata.authentication.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ua_role_menu_allo")
public class UserRoles implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ua_roll_menu_all_id")
	private int id;
	/*@Column(name = "ua_role_id")
	private int rollId;*/
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ua_role_id", referencedColumnName = "ua_role_id", insertable = false, updatable = false, nullable = false)
	private Roles role;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*public int getRollId() {
		return rollId;
	}
	public void setRollId(int rollId) {
		this.rollId = rollId;
	}*/
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	
	
}
