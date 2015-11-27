package com.iitms.rfcampusdata.authentication.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "ua_role_master")
public class Roles implements Serializable, GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ua_role_id")
	private int id;
	@Column(name = "role_name")
	private String role;
	
	/*@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="ua_role_menu_allo", joinColumns={@JoinColumn(name="ua_role_id", referencedColumnName="ua_role_id")}
    , inverseJoinColumns={@JoinColumn(name="menu_id", referencedColumnName="menu_id")})
    private Set<Menu> menus;*/

	/*public Set<Menu> getMenus() {
		return menus;
	}
	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}*/
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String getAuthority() {
		return this.role;
	}
	@Override
	public String toString() {
		return "Roles [id=" + id + ", role=" + role + "]";
	}
	
	
	
	
	
	
	
}
