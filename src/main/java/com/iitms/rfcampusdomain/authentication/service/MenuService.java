package com.iitms.rfcampusdomain.authentication.service;

import java.util.List;

import com.iitms.rfcampusdata.authentication.entity.RoleMenuAllocationEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMenuResponse;

public interface MenuService 
{
	public  List<RoleMenuAllocationEntity> getMenuOfRole(int roleId);
	public List<RoleMenuResponse> getMenuList(int moduleId);
}
