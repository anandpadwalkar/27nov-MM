package com.iitms.rfcampusdata.authentication.dao;

import java.util.List;

import com.iitms.rfcampusdata.authentication.entity.UniversityMaster;

public interface UniversityAndBoardDao 
{
     public boolean addUniversityAndBoard(UniversityMaster entity);
     public List<UniversityMaster> getUniversityList();
     public boolean updateUniversity(UniversityMaster entity);
}
