package com.iitms.rfcampusdata.authentication.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CollegeCreationModel implements Serializable {

    /* Fields for College \"COLLEGE_MASTER\" table */
    private int collegeId;

    private String collegeName;

    private String collegeCode;

    private String collegeLogo;
    
    private String oldCollegeLogo;
    
    private String panNumber;

    private String tinNumber;

    private String tanNumber;

    private String principalName;

    private String workOrderNumber;

    private Date workOrderDate;
    
    private String  workOrderDateString;

    private int socialCollege;

    private int active;

    private int numberOfUsers;

    private int societyId;

    private int universityId;

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

    private int socId;

    private int collegeIdInAddress;

    /* For modules */
    private String[] moduleIds;
    private List<Integer> modules;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeCode() {
        return collegeCode;
    }

    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode;
    }

    public String getCollegeLogo() {
        return collegeLogo;
    }

    public void setCollegeLogo(String collegeLogo) {
        this.collegeLogo = collegeLogo;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getTanNumber() {
        return tanNumber;
    }

    public void setTanNumber(String tanNumber) {
        this.tanNumber = tanNumber;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public String getWorkOrderDate() {
        return sdf.format(workOrderDate);
    }

    public void setWorkOrderDate(Date workOrderDate) {
        this.workOrderDate = workOrderDate;
        this.workOrderDateString = sdf.format(workOrderDate);
    }

    public int getSocialCollege() {
        return socialCollege;
    }

    public void setSocialCollege(int socialCollege) {
        this.socialCollege = socialCollege;
    }

    

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public int getSocietyId() {
        return societyId;
    }

    public void setSocietyId(int societyId) {
        this.societyId = societyId;
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }

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
        return collegeIdInAddress;
    }

    public void setCollegeIdInAddress(int collegeIdInAddress) {
        this.collegeIdInAddress = collegeIdInAddress;
    }

    public String[] getModuleIds() {
        return moduleIds;
    }

    public void setModuleIds(String[] moduleIds) {
        this.moduleIds = moduleIds;
    }

    public AddressMaster getAddressMaster() {
        AddressMaster addressMaster = new AddressMaster(addId, address, city, pinCode, phone1, phone2, phone3, fax1,
            fax2, email1, email2, website, societyId, collegeIdInAddress, "", "", 1, new Date(), 1, new Date());
        return addressMaster;
    }

    public CollegeMasterEntity getCollegeMasterEntity() {
        CollegeMasterEntity collegeMasterEntity = new CollegeMasterEntity(collegeId, collegeName, collegeCode,
            collegeLogo, panNumber, tinNumber, tanNumber, principalName, workOrderNumber, workOrderDate,
            new Date(), new Date(), socialCollege, active, numberOfUsers, "", "", 1,
            new Date(), 1, new Date(), societyId, universityId);
        return collegeMasterEntity;
    }

    @Override
    public String toString() {
        return "CollegeCreationModel [collegeId=" + collegeId + ", collegeName=" + collegeName + ", collegeCode="
            + collegeCode + ", collegeLogo=" + collegeLogo + ", panNumber=" + panNumber + ", tinNumber=" + tinNumber
            + ", tanNumber=" + tanNumber + ", principalName=" + principalName + ", workOrderNumber=" + workOrderNumber
            + ", workOrderDate=" + workOrderDate + ", socialCollege=" + socialCollege + ", active=" + active
            + ", numberOfUsers=" + numberOfUsers + ", societyId=" + societyId + ", universityId=" + universityId
            + ", addId=" + addId + ", address=" + address + ", city=" + city + ", pinCode=" + pinCode + ", phone1="
            + phone1 + ", phone2=" + phone2 + ", phone3=" + phone3 + ", fax1=" + fax1 + ", fax2=" + fax2 + ", email1="
            + email1 + ", email2=" + email2 + ", website=" + website + ", socId=" + socId + ", collegeIdInAddress="
            + collegeIdInAddress + ", moduleIds=" + Arrays.toString(moduleIds) + "]";
    }

    public String getWorkOrderDateString() {
        return workOrderDateString;
    }

    public void setWorkOrderDateString(String workOrderDateString) throws ParseException {
        this.workOrderDateString = workOrderDateString;
        this.workOrderDate = sdf.parse(workOrderDateString);
    }

    public List<Integer> getModules() {
        return modules;
    }

    public void setModules(List<Integer> modules) {
        this.modules = modules;
    }

    public List<Integer> getCollegeModuleList(){
        List<Integer> list = new ArrayList<Integer>();
        if(moduleIds != null){
            for(String moduleId : moduleIds){
                list.add(Integer.parseInt(moduleId));
            }
            return list;   
        }
        return null;
    }

    public String getOldCollegeLogo() {
        return oldCollegeLogo;
    }

    public void setOldCollegeLogo(String oldCollegeLogo) {
        this.oldCollegeLogo = oldCollegeLogo;
    }
    
}
