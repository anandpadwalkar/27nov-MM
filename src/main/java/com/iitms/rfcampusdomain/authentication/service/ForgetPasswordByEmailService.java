package com.iitms.rfcampusdomain.authentication.service;

import com.iitms.rfcampusdata.authentication.entity.UserMasterEntity;

public interface ForgetPasswordByEmailService 
{
	public UserMasterEntity checkEmailService(String email);
	  public Boolean updatePasswordService(int id,String password);
}
