package com.iitms.rfcampusdata.authentication.dao;

import java.util.List;

import com.iitms.rfcampusdata.authentication.entity.RoleMenuAllocationEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMenuResponse;

public interface RoleBaseMenu {
	public List<RoleMenuAllocationEntity> loadMenu(int id);
	public List<RoleMenuResponse> getMenuList(int moduleId);
}
