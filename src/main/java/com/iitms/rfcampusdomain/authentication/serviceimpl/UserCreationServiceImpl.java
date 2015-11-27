package com.iitms.rfcampusdomain.authentication.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iitms.rfcampusdata.authentication.dao.UserCreationDao;
import com.iitms.rfcampusdata.authentication.entity.UserMasterEntity;
import com.iitms.rfcampusdomain.authentication.service.UserCreationService;

@Service
@Transactional
public class UserCreationServiceImpl implements UserCreationService{

    @Autowired
    private UserCreationDao userCreationDao;
    
    @Override
    public boolean addUser(UserMasterEntity userMasterEntity) {
        return userCreationDao.addUser(userMasterEntity);
    }

    @Override
    public boolean updateUser(UserMasterEntity userMasterEntity) {
        return userCreationDao.updateUser(userMasterEntity);
    }

    @Override
    public UserMasterEntity getUserInformation(int userId) {
        return userCreationDao.getUserInformation(userId);
    }

    @Override
    public boolean isUserAvailable(String username) {
        return userCreationDao.isUserAvailable(username);
    }

    @Override
    public List<UserMasterEntity> searchUserByCriteria(int searchBy, String searchText) {
        return userCreationDao.searchUserByCriteria(searchBy, searchText);
    }

}
