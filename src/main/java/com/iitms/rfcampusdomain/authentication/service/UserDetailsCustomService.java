package com.iitms.rfcampusdomain.authentication.service;

import java.util.List;

import com.iitms.rfcampusdata.authentication.entity.UserMasterEntity;

public interface UserDetailsCustomService {

    public List<Integer> getRoleIdsByUser(String username);

        public UserMasterEntity getuserInformation(String username);
    
}
