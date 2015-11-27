package com.iitms.rfcampusdomain.authentication.service;

import java.util.List;

import com.iitms.rfcampusdata.authentication.entity.ModuleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMenuAllocationEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMenuResponse;

public interface RoleLinksAllotmentService
{
	public List<RoleMasterEntity> getAllocatedRole();
	public List<RoleMasterEntity> getNotAllocatedRole();
	public List<RoleMenuResponse> getModulePerMenu(); 
	public boolean setModuleAndRoleWiseMenu(RoleMenuAllocationEntity roleMenuAllocation);
	public List<RoleMenuAllocationEntity> getMenuAsPerRole(int id);
	public List<ModuleMasterEntity> getModuleList();
	public void removeAllocatedMenusByRole(int roleId);
}
