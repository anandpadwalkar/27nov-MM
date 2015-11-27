package com.iitms.rfcampusdata.authentication.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sample")
public class Sample implements Serializable{

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	private int id;
	@Column(name = "p_menu_id")
	private int pMenuId;
	@Column(name = "menu_id")
	private int menuId;
	@Column(name = "module_id")
	private int moduleId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "p_menu_id", referencedColumnName = "menu_id", insertable = false, updatable = false, nullable = false)
	private MenuMasterEntity parentMenu;
	
	/*@OneToMany( fetch = FetchType.EAGER)
	@JoinColumn(name = "menu_id", referencedColumnName="menu_id", insertable = true, updatable = true, nullable = false)
	private List<SubMenuEntity> subMenus ;*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getpMenuId() {
		return pMenuId;
	}

	public void setpMenuId(int pMenuId) {
		this.pMenuId = pMenuId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public MenuMasterEntity getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(MenuMasterEntity parentMenu) {
		this.parentMenu = parentMenu;
	}

	/*public List<SubMenuEntity> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<SubMenuEntity> subMenus) {
		this.subMenus = subMenus;
	} */
	
	
}
