package com.iitms.rfcampusdomain.authentication.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iitms.rfcampusdata.authentication.dao.RoleLinksAllotmentDao;
import com.iitms.rfcampusdata.authentication.entity.ModuleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMenuAllocationEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMenuResponse;
import com.iitms.rfcampusdomain.authentication.service.RoleLinksAllotmentService;

@Service
@Transactional
public class RoleLinksAllotmentServiceImpl implements RoleLinksAllotmentService{

	@Autowired
	private RoleLinksAllotmentDao roleLinksAllotmentDao;
	
	@Override
	public List<RoleMasterEntity> getAllocatedRole() {
		return roleLinksAllotmentDao.getAllocatedRole();
	}

	@Override
	public List<RoleMasterEntity> getNotAllocatedRole() {
		return roleLinksAllotmentDao.getNotAllocatedRole();
	}

	@Override
	public List<RoleMenuResponse> getModulePerMenu() {
		// TODO Auto-generated method stub
		return roleLinksAllotmentDao.getMenuList();
	}

	

	@Override
	public List<RoleMenuAllocationEntity>getMenuAsPerRole(int id) 
	{
		return roleLinksAllotmentDao.loadMenuAsPerRole(id);
	}

	@Override
	public boolean setModuleAndRoleWiseMenu(RoleMenuAllocationEntity roleMenuAllocation) {
	roleLinksAllotmentDao.setModuleAndRolePerMenu(roleMenuAllocation);
		return false;
	}

	@Override
	public List<ModuleMasterEntity> getModuleList() {
		
		return roleLinksAllotmentDao.getModuleList();
	}

    @Override
    public void removeAllocatedMenusByRole(int roleId) {
        roleLinksAllotmentDao.removeAllocatedMenusByRole(roleId);
    }

}
