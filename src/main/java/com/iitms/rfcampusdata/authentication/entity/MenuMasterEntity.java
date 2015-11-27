package com.iitms.rfcampusdata.authentication.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "master.useraccess_menu_master")
// @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
/*
 * @FetchProfiles(
 * @FetchProfile(name = "module", fetchOverrides = @FetchProfile.FetchOverride(association = "module", entity =
 * MenuMasterEntity.class, mode = FetchMode.JOIN )) )
 */
public class MenuMasterEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private int menuId;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_tooltip")
    private String menuTooltip;

    @Column(name = "menu_link")
    private String menuLink;

    @Column(name = "menu_serial_number")
    private String menuSerialNumber;

    @Column(name = "parent_menu_id")
    private int parentMenuId;

    @Column(name = "menu_status")
    private int menuStatus;

    @Column(name = "page_name")
    private String pageName;

    @Column(name = "module_id")
    private int moduleId;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "module_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private ModuleMasterEntity module;

    @Column(name = "ipaddress")
    private String ipAddress;

    @Column(name = "macaddress")
    private String macAddress;

    @Column(name = "created_by")
    private int createdBy;

    @Column(name = "created_date")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Column(name = "modified_by")
    private int modifiedBy;

    @Column(name = "modified_date")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    @Temporal(TemporalType.DATE)
    private Date modifiedDate;

    @Transient
    private  List<MenuMasterEntity> subMenu;

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

    /*
     * public int getParentMenuId() { return parentMenuId; } public void setParentMenuId(int parentMenuId) {
     * this.parentMenuId = parentMenuId; }
     */

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

    /*
     * public SubMenuEntity getMainMenu() { return mainMenu; } public void setMainMenu(SubMenuEntity mainMenu) {
     * this.mainMenu = mainMenu; }
     */

    public List<MenuMasterEntity> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<MenuMasterEntity> subMenu) {
        this.subMenu = subMenu;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((menuName == null) ? 0 : menuName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MenuMasterEntity other = (MenuMasterEntity) obj;
        if (menuName == null) {
            if (other.menuName != null)
                return false;
        } else if (!menuName.equals(other.menuName))
            return false;
        return true;
    }

    public ModuleMasterEntity getModule() {
        return module;
    }

    public void setModule(ModuleMasterEntity module) {
        this.module = module;
    }

    @Override
    public String toString() {
        return "MenuMasterEntity [menuName=" + menuName + ", moduleId=" + moduleId + ", parentMenuId=" + parentMenuId
            + "]";
    }

    public int getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(int parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
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

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

}
