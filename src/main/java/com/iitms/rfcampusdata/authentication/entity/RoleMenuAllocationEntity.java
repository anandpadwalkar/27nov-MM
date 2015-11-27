package com.iitms.rfcampusdata.authentication.entity;

import java.io.Serializable;
import java.util.Date;

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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "transaction.useraccess_role_menu_allocation")
public class RoleMenuAllocationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "useraccess_role_menu_allocation_id", columnDefinition = "serial")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "useraccess_role_id")
    private int roleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "useraccess_role_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private RoleMasterEntity roleMasterEntity;
    
    @Column(name = "menu_id")
    private int menuId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private MenuMasterEntity menuMasterEntity;

    @Column(name = "module_id")
    private int moduleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private ModuleMasterEntity moduleMasterEntity;

    
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

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public ModuleMasterEntity getModuleMasterEntity() {
        return moduleMasterEntity;
    }

    public void setModuleMasterEntity(ModuleMasterEntity moduleMasterEntity) {
        this.moduleMasterEntity = moduleMasterEntity;
    }

    public MenuMasterEntity getMenuMasterEntity() {
        return menuMasterEntity;
    }

    public void setMenuMasterEntity(MenuMasterEntity menuMasterEntity) {
        this.menuMasterEntity = menuMasterEntity;
    }

    public RoleMasterEntity getRoleMasterEntity() {
        return roleMasterEntity;
    }

    public void setRoleMasterEntity(RoleMasterEntity roleMasterEntity) {
        this.roleMasterEntity = roleMasterEntity;
    }

}
