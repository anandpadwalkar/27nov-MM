package com.iitms.rfcampusdata.authentication.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@Table(name = "master.useraccess_address_master")
public class AddressMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private int addressId;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "pincode")
    private String pinCode;

    @Column(name = "phone1")
    private String phone1;

    @Column(name = "phone2")
    private String phone2;

    @Column(name = "phone3")
    private String phone3;

    @Column(name = "fax1")
    private String fax1;

    @Column(name = "fax2")
    private String fax2;

    @Column(name = "email1")
    private String email1;

    @Column(name = "email2")
    private String email2;

    @Column(name = "website")
    private String website;

    @Column(name = "society_id")
    private int societyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "society_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private SocietyMaster societyMaster;

    @Column(name = "college_id")
    private int collegeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "college_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private CollegeMasterEntity collegeMasterEntity;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public String getFax1() {
        return fax1;
    }

    public void setFax1(String fax1) {
        this.fax1 = fax1;
    }

    public String getFax2() {
        return fax2;
    }

    public void setFax2(String fax2) {
        this.fax2 = fax2;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
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

    public int getCreateBy() {
        return createdBy;
    }

    public void setCreateBy(int createBy) {
        this.createdBy = createBy;
    }

    public int getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public CollegeMasterEntity getCollegeMasterEntity() {
        return collegeMasterEntity;
    }

    public void setCollegeMasterEntity(CollegeMasterEntity collegeMasterEntity) {
        this.collegeMasterEntity = collegeMasterEntity;
    }

    public void setCreateDt(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setModifiedDt(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public AddressMaster(int addressId, String address, String city, String pinCode, String phone1, String phone2,
        String phone3, String fax1, String fax2, String email1, String email2, String website, int socId, int collegeId,
        String ipAddress, String macAddress, int createdBy, Date createDt, int modifiedBy, Date modifiedDt) {
        super();
        this.addressId = addressId;
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
        this.fax1 = fax1;
        this.fax2 = fax2;
        this.email1 = email1;
        this.email2 = email2;
        this.website = website;
        this.societyId = socId;
        this.collegeId = collegeId;
        this.ipAddress = ipAddress;
        this.macAddress = macAddress;
        this.createdBy = createdBy;
        this.createdDate = createDt;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDt;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + addressId;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((email1 == null) ? 0 : email1.hashCode());
        result = prime * result + ((email2 == null) ? 0 : email2.hashCode());
        result = prime * result + ((fax1 == null) ? 0 : fax1.hashCode());
        result = prime * result + ((fax2 == null) ? 0 : fax2.hashCode());
        result = prime * result + ((phone1 == null) ? 0 : phone1.hashCode());
        result = prime * result + ((phone2 == null) ? 0 : phone2.hashCode());
        result = prime * result + ((phone3 == null) ? 0 : phone3.hashCode());
        result = prime * result + ((pinCode == null) ? 0 : pinCode.hashCode());
        result = prime * result + ((website == null) ? 0 : website.hashCode());
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
        AddressMaster other = (AddressMaster) obj;
        if (addressId != other.addressId)
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (email1 == null) {
            if (other.email1 != null)
                return false;
        } else if (!email1.equals(other.email1))
            return false;
        if (email2 == null) {
            if (other.email2 != null)
                return false;
        } else if (!email2.equals(other.email2))
            return false;
        if (fax1 == null) {
            if (other.fax1 != null)
                return false;
        } else if (!fax1.equals(other.fax1))
            return false;
        if (fax2 == null) {
            if (other.fax2 != null)
                return false;
        } else if (!fax2.equals(other.fax2))
            return false;
        if (phone1 == null) {
            if (other.phone1 != null)
                return false;
        } else if (!phone1.equals(other.phone1))
            return false;
        if (phone2 == null) {
            if (other.phone2 != null)
                return false;
        } else if (!phone2.equals(other.phone2))
            return false;
        if (phone3 == null) {
            if (other.phone3 != null)
                return false;
        } else if (!phone3.equals(other.phone3))
            return false;
        if (pinCode == null) {
            if (other.pinCode != null)
                return false;
        } else if (!pinCode.equals(other.pinCode))
            return false;
        if (website == null) {
            if (other.website != null)
                return false;
        } else if (!website.equals(other.website))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AddressMaster [addId=" + addressId + ", address=" + address + ", city=" + city + ", pinCode=" + pinCode
            + ", phone1=" + phone1 + ", phone2=" + phone2 + ", phone3=" + phone3 + ", fax1=" + fax1 + ", fax2=" + fax2
            + ", email1=" + email1 + ", email2=" + email2 + ", website=" + website + "]";
    }

    public void setProperties(String address, String city, String pinCode, String phone1, String phone2, String phone3,
        String fax1, String fax2, String email1, String email2, String website, int socId, int collegeId,
        String ipAddress, String macAddress, int modifiedBy, Date modifiedDt) {
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
        this.fax1 = fax1;
        this.fax2 = fax2;
        this.email1 = email1;
        this.email2 = email2;
        this.website = website;
        this.societyId = socId;
        this.collegeId = collegeId;
        this.ipAddress = ipAddress;
        this.macAddress = macAddress;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDt;
    }

    public void setProperties(String address, String city, String pinCode, String phone1, String phone2, String phone3,
        String fax1, String fax2, String email1, String email2, String website, int socId, String ipAddress,
        String macAddress, int modifiedBy, Date modifiedDt) {
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
        this.fax1 = fax1;
        this.fax2 = fax2;
        this.email1 = email1;
        this.email2 = email2;
        this.website = website;
        this.societyId = socId;
        this.ipAddress = ipAddress;
        this.macAddress = macAddress;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDt;
    }

    public AddressMaster() {
        super();
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getSocietyId() {
        return societyId;
    }

    public void setSocietyId(int societyId) {
        this.societyId = societyId;
    }

    public SocietyMaster getSocietyMaster() {
        return societyMaster;
    }

    public void setSocietyMaster(SocietyMaster societyMaster) {
        this.societyMaster = societyMaster;
    }

    public String getCreatedDate() {
        String Date = "";
        if (modifiedDate != null) {
            Date = new SimpleDateFormat("dd-MM-yyyy").format(modifiedDate);
        } else {
            Date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        }
        return Date;
    }

    public void setCreatedDate(String createdDate) {
        try {
            this.createdDate = new SimpleDateFormat("dd-MM-yyyy").parse(createdDate);
        } catch (ParseException e) {
            System.out.print(e);
        }
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

    public void setModifiedDate(String modifiedDate) {
        try {
            this.modifiedDate = new SimpleDateFormat("dd-MM-yyyy").parse(modifiedDate);
        } catch (ParseException e) {
            System.out.print(e);
        }

    }

}
