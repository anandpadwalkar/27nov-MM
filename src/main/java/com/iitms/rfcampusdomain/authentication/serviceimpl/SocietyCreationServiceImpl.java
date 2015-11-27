package com.iitms.rfcampusdomain.authentication.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iitms.rfcampusdata.authentication.dao.SocietyCreationDao;
import com.iitms.rfcampusdata.authentication.entity.AddressMaster;
import com.iitms.rfcampusdata.authentication.entity.CollegeModuleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.SocietyCreationModel;
import com.iitms.rfcampusdata.authentication.entity.SocietyMaster;
import com.iitms.rfcampusdomain.authentication.service.SocietyCreationService;

@Transactional
@Service
public class SocietyCreationServiceImpl implements SocietyCreationService{

	@Autowired
	private SocietyCreationDao societyCreationDoa;

	@Override
	public List<SocietyMaster> getAllSociety() {
		 return societyCreationDoa.getAllSociety();
	}
	
	@Override
	public SocietyCreationModel getSocietyById(int soc_id) {
		 return societyCreationDoa.getSocietyById(soc_id);
	}

	@Override
	public List<CollegeModuleMasterEntity> getCollegeModuleyById(int socid) {
		 return societyCreationDoa.getCollegeModuleyById(socid);
	}

	@Override
	public int addSocietys(SocietyCreationModel entity){
		 return societyCreationDoa.addSocietys(entity);
	}
	
	@Override
	public boolean addAddress(AddressMaster address){
		 return societyCreationDoa.addAddress(address);
	}

	@Override
	
	public boolean updateSociety(SocietyCreationModel entity) {
	return societyCreationDoa.updateSociety(entity);
	}

	@Override
	public boolean updateAddress(AddressMaster address) {
		return societyCreationDoa.updateAddress(address);
	}

	@Override
	public boolean addCollegeModule(CollegeModuleMasterEntity collegeModule) {
		return societyCreationDoa.addCollegeModule(collegeModule);
	}

	@Override
	public boolean delete_all_module(int soc_id) {
		 return societyCreationDoa.delete_all_module(soc_id);
	}

}
