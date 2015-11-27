package com.iitms.rfcampusdomain.authentication.serviceimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.iitms.rfcampusdata.authentication.dao.UserDetailsDao;
import com.iitms.rfcampusdata.authentication.entity.RoleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.UserMasterEntity;
import com.iitms.rfcampusdomain.authentication.service.UserDetailsCustomService;

@Component(value = "userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService, UserDetailsCustomService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserDetailsDao userDetailsDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("loadUserByUsername : " + username);
        UserMasterEntity userMasterEntity = userDetailsDao.loadUserByUsername(username);
        
        List<GrantedAuthority> authorities = buildUserAuthority(userMasterEntity.getRoleMasterEntityList());
        
        return buildUserForAuthentication(userMasterEntity, authorities);
    }

    private User buildUserForAuthentication(UserMasterEntity user, List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true,
                true, true, authorities);
    }
    
    
    private List<GrantedAuthority> buildUserAuthority(Set<RoleMasterEntity> roleList) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (RoleMasterEntity userRole : roleList) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRoleName()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }

    @Override
    public List<Integer> getRoleIdsByUser(String username) {
        return userDetailsDao.getRoleIdsByUser(username);
    }
}
