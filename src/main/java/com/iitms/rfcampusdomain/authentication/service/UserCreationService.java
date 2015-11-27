package com.iitms.rfcampusdomain.authentication.service;

import java.util.List;

import com.iitms.rfcampusdata.authentication.entity.UserMasterEntity;

public interface UserCreationService {

    public boolean addUser(UserMasterEntity userMasterEntity);
    public boolean updateUser(UserMasterEntity userMasterEntity);
    public UserMasterEntity getUserInformation(int userId);
    public boolean isUserAvailable(String username);
    public List<UserMasterEntity> searchUserByCriteria(int searchBy, String searchText);
}
