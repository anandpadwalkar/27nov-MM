package com.iitms.rfcampuscommon;

import java.io.File;

import org.springframework.stereotype.Component;

@Component
public class UploadsDirectories {

    private String uploadDirectory = "resources" + File.separator + "uploads" + File.separator;
    private String authorizationDirectory = "authorization" + File.separator;
    private String society = "society" + File.separator;
    private String college = "college" + File.separator;
    private String user = "user" + File.separator;
    
    public String getUploadDirectory() {
        return uploadDirectory;
    }
    public void setUploadDirectory(String uploadDirectory) {
        this.uploadDirectory = uploadDirectory;
    }
    public String getAuthorizationDirectory() {
        return authorizationDirectory;
    }
    public void setAuthorizationDirectory(String authorizationDirectory) {
        this.authorizationDirectory = authorizationDirectory;
    }
    public String getSociety() {
        return society;
    }
    public void setSociety(String society) {
        this.society = society;
    }
    public String getCollege() {
        return college;
    }
    public void setCollege(String college) {
        this.college = college;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    
    
}
