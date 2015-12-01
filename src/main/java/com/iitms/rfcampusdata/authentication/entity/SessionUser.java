package com.iitms.rfcampusdata.authentication.entity;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionUser implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private CustomLoginUser customLoginUser;

    public CustomLoginUser getCustomLoginUser() {
        return customLoginUser;
    }

    public void setCustomLoginUser(CustomLoginUser customLoginUser) {
        this.customLoginUser = customLoginUser;
    }
	

	

}
