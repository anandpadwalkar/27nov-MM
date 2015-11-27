package com.iitms.rfcampusdata.authentication.dao;

import java.util.List;

import com.iitms.rfcampusdata.authentication.entity.UserMasterEntity;

public interface UserCreationDao {

    public boolean addUser(UserMasterEntity userMasterEntity);
    public boolean updateUser(UserMasterEntity userMasterEntity);
    public UserMasterEntity getUserInformation(int userId);
    public boolean isUserAvailable(String username);
    public List<UserMasterEntity> searchUserByCriteria(int searchBy, String searchText);
}
