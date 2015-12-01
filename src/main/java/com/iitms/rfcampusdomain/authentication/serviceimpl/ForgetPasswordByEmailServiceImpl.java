package com.iitms.rfcampusdomain.authentication.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iitms.rfcampusdata.authentication.dao.ForgetPasswordByEmailDao;
import com.iitms.rfcampusdata.authentication.entity.UserMasterEntity;
import com.iitms.rfcampusdomain.authentication.service.ForgetPasswordByEmailService;

@Service
@Transactional
public class ForgetPasswordByEmailServiceImpl implements ForgetPasswordByEmailService
{
	@Autowired	
    private ForgetPasswordByEmailDao forgetPasswordByEmailDao ;
	@SuppressWarnings("unchecked")
	@Override
	public UserMasterEntity checkEmailService(String email)
	{
		return forgetPasswordByEmailDao.checkEmail(email);
	}

	@Override
	public Boolean updatePasswordService(int id, String password)
	{
		// TODO Auto-generated method stub
		return  forgetPasswordByEmailDao.updatePassword(id, password);
	}

}
