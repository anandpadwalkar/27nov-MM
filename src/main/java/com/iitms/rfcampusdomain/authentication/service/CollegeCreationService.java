package com.iitms.rfcampusdomain.authentication.service;

import java.util.List;

import com.iitms.rfcampusdata.authentication.entity.CollegeCreationModel;
import com.iitms.rfcampusdata.authentication.entity.CollegeMasterEntity;

public interface CollegeCreationService {

    public List<CollegeMasterEntity> getCollegeList();

    public CollegeCreationModel getCollegeInformation(int collegeId);

    public boolean addCollege(CollegeCreationModel collegeCreationModel);

    public boolean updateCollege(CollegeCreationModel collegeMasterEntity);

    public boolean isCollegeExist(String collegeName);

    public List<CollegeMasterEntity> getCollegeBySociety(int societyId);
}
