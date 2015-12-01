package com.iitms.rfcampusdomain.authentication.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iitms.rfcampusdata.authentication.dao.LoginDao;
import com.iitms.rfcampusdomain.authentication.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public void changePassword(String username, String password) {
        loginDao.changePassword(username, password);
    }

    @Override
    public void updateFailAttempts(String username) {
        loginDao.updateFailAttempts(username);
    }

    @Override
    public void resetFailAttempts(String username) {
        loginDao.resetFailAttempts(username);
    }
}
