package com.iitms.rfcampusdata.authentication.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = " master.useraccess_user_master")
public class UserMasterEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private int userId;

    @Column(name = "student_serial_number")
    private int studentSerialNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    //@Column(name = "role_ids")
    @Transient
    private String roleIds;
    
    @Column(name = "role_id")
    private int roleId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "transaction.useraccess_user_role_allocation",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleMasterEntity> roleMasterEntityList;

    @Column(name = "counter")
    private int counter;

    @Column(name = "cash_counter")
    private String cashCounter;

    @Column(name = "bank_counter")
    private String bankCounter;

    @Column(name = "adjustment_counter")
    private String adjustmentCounter;

    @Column(name = "setworking_date")
    private byte setWorkingDate;

    @Column(name = "user_photo")
    private String userPhoto;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "emailid")
    private String emailid;

    @Column(name = "active")
    private int active;

    @Column(name = "college_id")
    private int college_id;

    @Column(name = "college_ids")
    private String collegeIds;

    @Column(name = "is_society_user")
    private byte isSocietyUser;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getStudentSerialNumber() {
        return studentSerialNumber;
    }

    public void setStudentSerialNumber(int studentSerialNumber) {
        this.studentSerialNumber = studentSerialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public Set<RoleMasterEntity> getRoleMasterEntityList() {
        return roleMasterEntityList;
    }

    public void setRoleMasterEntityList(Set<RoleMasterEntity> roleMasterEntityList) {
        this.roleMasterEntityList = roleMasterEntityList;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getCashCounter() {
        return cashCounter;
    }

    public void setCashCounter(String cashCounter) {
        this.cashCounter = cashCounter;
    }

    public String getBankCounter() {
        return bankCounter;
    }

    public void setBankCounter(String bankCounter) {
        this.bankCounter = bankCounter;
    }

    public String getAdjustmentCounter() {
        return adjustmentCounter;
    }

    public void setAdjustmentCounter(String adjustmentCounter) {
        this.adjustmentCounter = adjustmentCounter;
    }

    public byte getSetWorkingDate() {
        return setWorkingDate;
    }

    public void setSetWorkingDate(byte setWorkingDate) {
        this.setWorkingDate = setWorkingDate;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getCollege_id() {
        return college_id;
    }

    public void setCollege_id(int college_id) {
        this.college_id = college_id;
    }

    public String getCollegeIds() {
        return collegeIds;
    }

    public void setCollegeIds(String collegeIds) {
        this.collegeIds = collegeIds;
    }

    public byte getIsSocietyUser() {
        return isSocietyUser;
    }

    public void setIsSocietyUser(byte isSocietyUser) {
        this.isSocietyUser = isSocietyUser;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    @Override
    public String toString() {
        return "UserMasterEntity [userId=" + userId + ", name=" + name + ", username=" + username + ", password="
            + password + ", roleIds=" + roleIds + ", counter=" + counter + ", setWorkingDate=" + setWorkingDate
            + ", mobileNumber=" + mobileNumber + ", emailid=" + emailid + ", active=" + active + "]";
    }

}
