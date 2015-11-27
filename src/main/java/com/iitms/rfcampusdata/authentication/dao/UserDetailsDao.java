package com.iitms.rfcampusdata.authentication.dao;

import java.util.List;

import com.iitms.rfcampusdata.authentication.entity.UserMasterEntity;

public interface UserDetailsDao {
	public UserMasterEntity loadUserByUsername(String username);
	public List<Integer> getRoleIdsByUser(String username);
}
