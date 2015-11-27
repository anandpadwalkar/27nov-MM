package com.iitms.rfcampusdata.authentication.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SocietyCreationModel implements Serializable {

    /* Fields for ua_society_master table */
    private int socId;

    private String socCode;

    private String socName;

    private String socRegno;

    private String socLogo;
    
    private String oldSocietyLogo;

    private String societyChairman;

    private String societySecretory;

    /* Fields for ua_add_master table */
    private int addId;

    private String address;

    private String city;

    private String pinCode;

    private String phone1;

    private String phone2;

    private String phone3;

    private String fax1;

    private String fax2;

    private String email1;

    private String email2;

    private String website;

    private int socIdInAddress;

    private int societyIdInAddress;

    /* For modules */
    private String[] modIds;

    private List<Integer> modules;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public int getAddId() {
        return addId;
    }

    public void setAddId(int addId) {
        this.addId = addId;
    }

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

    public int getSocId() {
        return socId;
    }

    public void setSocId(int socId) {
        this.socId = socId;
    }

    public int getCollegeIdInAddress() {
        return societyIdInAddress;
    }

    public void setCollegeIdInAddress(int societyIdInAddress) {
        this.societyIdInAddress = societyIdInAddress;
    }

    public List<Integer> getModules() {
        return modules;
    }

    public void setModules(List<Integer> modules) {
        this.modules = modules;
    }

    public List<Integer> getCollegeModuleList() {
        List<Integer> list = new ArrayList<Integer>();
        if (modIds != null) {
            for (String moduleId : modIds) {
                list.add(Integer.parseInt(moduleId));
            }
            return list;
        }
        return null;
    }

    public String getSocCode() {
        return socCode;
    }

    public void setSocCode(String socCode) {
        this.socCode = socCode;
    }

    public String getSocName() {
        return socName;
    }

    public void setSocName(String socName) {
        this.socName = socName;
    }

    public String getSocRegno() {
        return socRegno;
    }

    public void setSocRegno(String socRegno) {
        this.socRegno = socRegno;
    }

    public String getSocLogo() {
        return socLogo;
    }

    public void setSocLogo(String socLogo) {
        this.socLogo = socLogo;
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

    public int getSocIdInAddress() {
        return socIdInAddress;
    }

    public void setSocIdInAddress(int socIdInAddress) {
        this.socIdInAddress = socIdInAddress;
    }

    public String[] getModIds() {
        return modIds;
    }

    public void setModIds(String[] modIds) {
        this.modIds = modIds;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    @Override
    public String toString() {
        return "SocietyCreationModel [socId=" + socId + ", socCode=" + socCode + ", socName=" + socName + ", socRegno="
            + socRegno + ", socLogo=" + socLogo + ", societyChairman=" + societyChairman + ", societySecretory="
            + societySecretory + ", addId=" + addId + ", address=" + address + ", city=" + city + ", pinCode=" + pinCode
            + ", phone1=" + phone1 + ", phone2=" + phone2 + ", phone3=" + phone3 + ", fax1=" + fax1 + ", fax2=" + fax2
            + ", email1=" + email1 + ", email2=" + email2 + ", website=" + website + ", socIdInAddress="
            + socIdInAddress + ", societyIdInAddress=" + societyIdInAddress + ", modIds=" + Arrays.toString(modIds)
            + "]";
    }

    public SocietyMaster getSocietyMaster() {
        SocietyMaster society = new SocietyMaster(socIdInAddress, socCode, socName, socRegno, socLogo, "", "",
            societyChairman, societySecretory, 1, new Date(), 1, new Date());
        return society;
    }

    public AddressMaster getAddressMaster() {
        AddressMaster addressMaster = new AddressMaster(addId, address, city, pinCode, phone1, phone2, phone3, fax1,
            fax2, email1, email2, website, socId, socId * 10000, "", "", 1, new Date(), 1, new Date());
        return addressMaster;
    }
    
    public List<Integer> getSocietyModuleList() {
        List<Integer> list = new ArrayList<Integer>();
        if (modIds != null) {
            for (String moduleId : modIds) {
                list.add(Integer.parseInt(moduleId));
            }
            return list;
        }
        return null;
    }

    public String getOldSocietyLogo() {
        return oldSocietyLogo;
    }

    public void setOldSocietyLogo(String oldSocietyLogo) {
        this.oldSocietyLogo = oldSocietyLogo;
    }

    public int getSocietyIdInAddress() {
        return societyIdInAddress;
    }

    public void setSocietyIdInAddress(int societyIdInAddress) {
        this.societyIdInAddress = societyIdInAddress;
    }

    
}
