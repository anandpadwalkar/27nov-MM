package com.iitms.rfcampusdata.authentication.dao;

import java.util.List;

import com.iitms.rfcampusdata.authentication.entity.CollegeCreationModel;
import com.iitms.rfcampusdata.authentication.entity.CollegeMasterEntity;

public interface CollegeCreationDao {

    public List<CollegeMasterEntity> getCollegeList();

    public CollegeCreationModel getCollegeInformation(int collegeId);

    public boolean addCollege(CollegeCreationModel collegeCreationModel);

    public boolean updateCollege(CollegeCreationModel collegeCreationModel);

    public boolean isCollegeExist(String collegeName);

    public List<CollegeMasterEntity> getCollegeBySociety(int societyId);
}
