package com.iitms.rfcampusdata.authentication.dao;

import java.util.List;

import com.iitms.rfcampusdata.authentication.entity.ModuleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMenuAllocationEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMenuResponse;

public interface RoleLinksAllotmentDao 
{
	public List<RoleMasterEntity> getAllocatedRole();
	public List<RoleMasterEntity> getNotAllocatedRole();
	public List<RoleMenuAllocationEntity> loadMenuAsPerRole(int id);
	List<RoleMenuResponse> getMenuList();
	public boolean setModuleAndRolePerMenu(RoleMenuAllocationEntity roleMenuAllocation);
	public List<ModuleMasterEntity> getModuleList();
	public void removeAllocatedMenusByRole(int roleId);
}
