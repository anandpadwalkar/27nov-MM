package com.iitms.rfcampusdomain.authentication.service;

import java.util.List;

import com.iitms.rfcampusdata.authentication.entity.AddressMaster;
import com.iitms.rfcampusdata.authentication.entity.CollegeModuleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.SocietyCreationModel;
import com.iitms.rfcampusdata.authentication.entity.SocietyMaster;

public interface SocietyCreationService {
	public List<SocietyMaster> getAllSociety();
	public SocietyCreationModel getSocietyById(int soc_id);
	List<CollegeModuleMasterEntity> getCollegeModuleyById(int socid);
	public int addSocietys(SocietyCreationModel entity);
	public boolean addAddress(AddressMaster address);
	
	public boolean updateSociety(SocietyCreationModel entity);
	public boolean updateAddress(AddressMaster address);
	
	
	public boolean addCollegeModule(CollegeModuleMasterEntity collegeModule);
	public boolean delete_all_module(int soc_id);
}
