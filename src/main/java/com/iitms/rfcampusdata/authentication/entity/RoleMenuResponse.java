package com.iitms.rfcampusdata.authentication.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RoleMenuResponse implements Serializable
{
	private int moduleId;
    private String moduleName;
    private List<MenuMasterEntity> mainMenu;
    
    /*****************/
    private int menuId;
	private String menuName;
	private String menuTooltip;
	private int parentMenuId;
	private String menuLink;
	private List<RoleMenuResponse> submenu = new ArrayList<RoleMenuResponse>();
	/*****************************/
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public List<MenuMasterEntity> getMainMenu() {
		return mainMenu;
	}
	public void setMainMenu(List<MenuMasterEntity> mainMenu) {
		this.mainMenu = mainMenu;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuTooltip() {
		return menuTooltip;
	}
	public void setMenuTooltip(String menuTooltip) {
		this.menuTooltip = menuTooltip;
	}
	public int getParentMenuId() {
		return parentMenuId;
	}
	public void setParentMenuId(int parentMenuId) {
		this.parentMenuId = parentMenuId;
	}
	public String getMenuLink() {
		return menuLink;
	}
	public void setMenuLink(String menuLink) {
		this.menuLink = menuLink;
	}
	public List<RoleMenuResponse> getSubmenu() {
		return submenu;
	}
	public void setSubmenu(List<RoleMenuResponse> submenu) {
		this.submenu = submenu;
	}
	@Override
	public String toString() {
		return "RoleMenuResponse [menuId=" + menuId + ", menuName=" + menuName + ", parentMenuId=" + parentMenuId
				+ ", submenu=" + submenu + "]";
	}
	

/*************/
	
}
