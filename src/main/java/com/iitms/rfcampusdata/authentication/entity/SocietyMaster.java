package com.iitms.rfcampusdata.authentication.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "master.useraccess_society_master")
public class SocietyMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private int societyId;

    @Column(name = "society_code")
    private String societyCode;

    @Column(name = "society_name")
    private String societyName;

    @Column(name = "society_registration_number")
    private String societyRegistrationNumber;

    @Column(name = "society_logo")
    private String societyLogo;

    @Column(name = "society_chairman")
    private String societyChairman;

    @Column(name = "society_secretory")
    private String societySecretory;

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

    /*@OneToOne(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ua_add_master", joinColumns = @JoinColumn(name = "soc_id", updatable = true, insertable = true) , inverseJoinColumns = @JoinColumn(name = "addid") )
    private AddressMaster addressMaster;*/

    @Transient
    private String call;

    @Transient
    private String modIds;

    public SocietyMaster(int socId, String socCode, String socName, String socRegno, String socLogo, String ipAddress,
        String macAddress, String societyChairman, String societySecretory, int createdBy, Date createDt,
        int modifiedBy, Date modifiedDt) {
        super();
        this.societyId = socId;
        this.societyCode = socCode;
        this.societyName = socName;
        this.societyRegistrationNumber = socRegno;
        this.societyLogo = socLogo;
        this.ipAddress = ipAddress;
        this.macAddress = macAddress;
        this.societyChairman = societyChairman;
        this.societySecretory = societySecretory;
        this.createdBy = createdBy;
        this.createdDate = createDt;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDt;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    

    public int getCreateBy() {
        return createdBy;
    }

    public void setCreateBy(int createBy) {
        this.createdBy = createBy;
    }

    public String getCreateDt() {
        String Date = "";
        if (createdDate != null) {
            Date = new SimpleDateFormat("dd-MM-yyyy").format(createdDate);
        } else {
            Date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        }
        return Date;
    }

    /*
     * public void setCreateDt(String createDt) { try { this.createDt = new
     * SimpleDateFormat("dd-MM-yyyy").parse(createDt); } catch (Exception e) { System.out.print(e); } }
     */
    public void setCreatedDate(Date createDt) {
        try {
            this.createdDate = createDt;
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public int getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedDate() {
        String Date = "";
        if (modifiedDate != null) {
            Date = new SimpleDateFormat("dd-MM-yyyy").format(modifiedDate);
        } else {
            Date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        }
        return Date;
    }

    public void setModifiedDt(Date modifiedDt) {
        try {
            this.modifiedDate = modifiedDt;
        } catch (Exception e) {
            System.out.print(e);
        }

    }

    @Override
    public String toString() {
        return "Society [socId=" + societyId + ", socCode=" + societyCode + ", socName=" + societyName + ", socRegno=" + societyRegistrationNumber
            + ", socLogo=" + societyLogo + ", ipAddress=" + ipAddress + ", macAddress=" + macAddress + ", societyChairman="
            + societyChairman + ", societySecretory=" + societySecretory + ", createBy=" + createdBy + ", createDt="
            + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDt=" + modifiedDate + "]";
    }

    public String getModIds() {
        return modIds;
    }

    public void setModIds(String modIds) {
        this.modIds = modIds;
    }

    public void setProperties(String socCode, String socName, String socRegno, String socLogo, String ipAddress,
        String macAddress, String societyChairman, String societySecretory, int modifiedBy, Date modifiedDt) {
        this.societyCode = socCode;
        this.societyName = socName;
        this.societyRegistrationNumber = socRegno;
        this.societyLogo = socLogo;
        this.ipAddress = ipAddress;
        this.macAddress = macAddress;
        this.societyChairman = societyChairman;
        this.societySecretory = societySecretory;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDt;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((societyCode == null) ? 0 : societyCode.hashCode());
        result = prime * result + societyId;
        result = prime * result + ((societyLogo == null) ? 0 : societyLogo.hashCode());
        result = prime * result + ((societyName == null) ? 0 : societyName.hashCode());
        result = prime * result + ((societyRegistrationNumber == null) ? 0 : societyRegistrationNumber.hashCode());
        result = prime * result + ((societyChairman == null) ? 0 : societyChairman.hashCode());
        result = prime * result + ((societySecretory == null) ? 0 : societySecretory.hashCode());
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
        SocietyMaster other = (SocietyMaster) obj;
        if (societyCode == null) {
            if (other.societyCode != null)
                return false;
        } else if (!societyCode.equals(other.societyCode))
            return false;
        if (societyId != other.societyId)
            return false;
        if (societyLogo == null) {
            if (other.societyLogo != null)
                return false;
        } else if (!societyLogo.equals(other.societyLogo))
            return false;
        if (societyName == null) {
            if (other.societyName != null)
                return false;
        } else if (!societyName.equals(other.societyName))
            return false;
        if (societyRegistrationNumber == null) {
            if (other.societyRegistrationNumber != null)
                return false;
        } else if (!societyRegistrationNumber.equals(other.societyRegistrationNumber))
            return false;
        if (societyChairman == null) {
            if (other.societyChairman != null)
                return false;
        } else if (!societyChairman.equals(other.societyChairman))
            return false;
        if (societySecretory == null) {
            if (other.societySecretory != null)
                return false;
        } else if (!societySecretory.equals(other.societySecretory))
            return false;
        return true;
    }

    public SocietyMaster() {
        super();
    }

    public int getSocietyId() {
        return societyId;
    }

    public void setSocietyId(int societyId) {
        this.societyId = societyId;
    }

    public String getSocietyCode() {
        return societyCode;
    }

    public void setSocietyCode(String societyCode) {
        this.societyCode = societyCode;
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    public String getSocietyRegistrationNumber() {
        return societyRegistrationNumber;
    }

    public void setSocietyRegistrationNumber(String societyRegistrationNumber) {
        this.societyRegistrationNumber = societyRegistrationNumber;
    }

    public String getSocietyLogo() {
        return societyLogo;
    }

    public void setSocietyLogo(String societyLogo) {
        this.societyLogo = societyLogo;
    }

    public String getSocietyChairman() {
        return societyChairman;
    }

    public void setSocietyChairman(String societyChairman) {
        this.societyChairman = societyChairman;
    }

    public String getSocietySecretory() {
        return societySecretory;
    }

    public void setSocietySecretory(String societySecretory) {
        this.societySecretory = societySecretory;
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

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

}
