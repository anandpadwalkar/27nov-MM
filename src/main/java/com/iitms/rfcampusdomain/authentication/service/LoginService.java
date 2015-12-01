package com.iitms.rfcampusdomain.authentication.service;

public interface LoginService {

    /* Method For Changing Password Forcefully*/
    public void changePassword(String username, String password);
    
    /* Methods for Users Login Attempt*/
    void updateFailAttempts(String username);
    void resetFailAttempts(String username);
}
