package com.iitms.rfcampusdomain.authentication.service;

import java.util.List;

import com.iitms.rfcampusdata.authentication.entity.UniversityMaster;

public interface UniversityAndBoardService
{
	public boolean addUniversity(UniversityMaster entity);
	
	public List<UniversityMaster> getAllUniversity();
	public boolean updateUniversity(UniversityMaster entity);
}
