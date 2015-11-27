package com.iitms.rfcampusdata.authentication.entity;

import java.io.Serializable;

public class MenuResponse implements Serializable{

	private int menuId;
	private int moduleId;
	private int parentMenuId;
	private String menuName;
	private String menuLink;
	private String menuToolTip;
	private float menuSrNo;
	private int active;
	
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public int getParentMenuId() {
		return parentMenuId;
	}
	public void setParentMenuId(int parentMenuId) {
		this.parentMenuId = parentMenuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuLink() {
		return menuLink;
	}
	public void setMenuLink(String menuLink) {
		this.menuLink = menuLink;
	}
	public String getMenuToolTip() {
		return menuToolTip;
	}
	public void setMenuToolTip(String menuToolTip) {
		this.menuToolTip = menuToolTip;
	}
	public float getMenuSrNo() {
		return menuSrNo;
	}
	public void setMenuSrNo(float menuSrNo) {
		this.menuSrNo = menuSrNo;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	
	
}
