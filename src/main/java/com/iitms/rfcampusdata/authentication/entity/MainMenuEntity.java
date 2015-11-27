package com.iitms.rfcampusdata.authentication.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"UA_MAIN_MENU_MASTER\"")
public class MainMenuEntity implements Serializable {

	@Id
	@Column(name = "menu_id")
	private int menuId;
	@Column(name = "\"MENU_NAME\"")
	private String menuName;
	@Column(name = "\"MOD_ID\"")
	private int moduleId;
	@Column(name = "\"MENU_TOOLTIP\"")
	private String menuTooltip;
	//private String pageName;
	@Column(name = "\"MENU_LINK\"")
	private String menuLink;
	@Column(name = "\"MENU_SRNO\"")
	private String menuSerialNumber;
	@Column(name = "\"MENU_STATUS\"")
	private int menuStatus;
	@Column(name = "\"IPADDRESS\"")
	private String ipAddress;
	@Column(name = "\"MACADDRESS\"")
	private String macAddress;
	@Column(name = "\"CREATED_BY\"")
	private String createdBy;
	@Column(name = "\"CREATE_DT\"")
	private Date createdDate;
	@Column(name = "\"MODIFIED_BY\"")
	private String modifiedBy;
	@Column(name = "\"MODIFIED_DT\"")
	private String modifiedDate;
	
/*	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "\"P_MENU_ID\"", referencedColumnName = "menu_id", insertable = false, updatable = false, nullable = false)
	private List<SubMenuEntity> subMenus;*/
	
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
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public String getMenuTooltip() {
		return menuTooltip;
	}
	public void setMenuTooltip(String menuTooltip) {
		this.menuTooltip = menuTooltip;
	}
	public String getMenuLink() {
		return menuLink;
	}
	public void setMenuLink(String menuLink) {
		this.menuLink = menuLink;
	}
	public String getMenuSerialNumber() {
		return menuSerialNumber;
	}
	public void setMenuSerialNumber(String menuSerialNumber) {
		this.menuSerialNumber = menuSerialNumber;
	}
	public int getMenuStatus() {
		return menuStatus;
	}
	public void setMenuStatus(int menuStatus) {
		this.menuStatus = menuStatus;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	/*public List<SubMenuEntity> getSubMenus() {
		return subMenus;
	}
	public void setSubMenus(List<SubMenuEntity> subMenus) {
		this.subMenus = subMenus;
	}*/
	
	
}
