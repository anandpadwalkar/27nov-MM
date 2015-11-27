package com.iitms.rfcampusdomain.authentication.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iitms.rfcampusdata.authentication.dao.CollegeCreationDao;
import com.iitms.rfcampusdata.authentication.entity.CollegeCreationModel;
import com.iitms.rfcampusdata.authentication.entity.CollegeMasterEntity;
import com.iitms.rfcampusdomain.authentication.service.CollegeCreationService;

@Service
@Transactional
public class CollegeCreationServiceImpl implements CollegeCreationService{

	@Autowired
	private CollegeCreationDao collegeCreationDao; 
	
	@Override
	public List<CollegeMasterEntity> getCollegeList() {
		return collegeCreationDao.getCollegeList();
	}

	@Override
	public boolean addCollege(CollegeCreationModel collegeCreationModel) {
		return collegeCreationDao.addCollege(collegeCreationModel);
	}

	@Override
	public boolean updateCollege(CollegeCreationModel collegeCreationModel) {
		return collegeCreationDao.updateCollege(collegeCreationModel);
	}

	@Override
	public boolean isCollegeExist(String collegeName) {
		return collegeCreationDao.isCollegeExist(collegeName);
	}

	@Override
    public CollegeCreationModel getCollegeInformation(int collegeId) {
        return collegeCreationDao.getCollegeInformation(collegeId);
    }

    @Override
    public List<CollegeMasterEntity> getCollegeBySociety(int societyId) {
        return collegeCreationDao.getCollegeBySociety(societyId);
    }

    

}
