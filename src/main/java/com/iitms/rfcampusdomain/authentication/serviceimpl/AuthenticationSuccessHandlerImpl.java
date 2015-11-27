package com.iitms.rfcampusdomain.authentication.serviceimpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.iitms.rfcampusdata.authentication.entity.CustomLoginUser;
import com.iitms.rfcampusdata.authentication.entity.SessionUser;
import com.iitms.rfcampusdomain.authentication.service.UserDetailsCustomService;

@Component("authenticationSuccessHandler")
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler, AuthenticationFailureHandler {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationSuccessHandlerImpl.class);

    @Autowired
    private SessionUser sessionUser;

    @Autowired
    private UserDetailsCustomService userDetailsCustomService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
        throws IOException, ServletException {
        // request.getSession().setAttribute("roleId", 1);
        User user = (User) auth.getPrincipal();
        CustomLoginUser customLoginUser = new CustomLoginUser();
        customLoginUser.setUsername(user.getUsername());
        customLoginUser.setAllocatedRoleIds(userDetailsCustomService.getRoleIdsByUser(user.getUsername()));
        sessionUser.setCustomLoginUser(customLoginUser);
        logger.info("Allocated Roles : " + sessionUser.getCustomLoginUser().getAllocatedRoleIds());
        response.sendRedirect("./success");
        // sessionUser.setUsername();
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
        AuthenticationException exception) throws IOException, ServletException {
        logger.info("Error : " + exception.getMessage());
        response.sendRedirect("./login");

    }

}
