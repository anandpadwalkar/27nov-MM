package com.iitms.rfcampusdata.authentication.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iitms.rfcampusdata.authentication.dao.UserDetailsDao;
import com.iitms.rfcampusdata.authentication.entity.RoleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.UserMasterEntity;

@Repository
public class UserDetailsDaoImpl implements UserDetailsDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public UserMasterEntity loadUserByUsername(String username) {
		Object o = this.sessionFactory.getCurrentSession()
		.createCriteria(UserMasterEntity.class)
		.add(Restrictions.eq("username", username))
		.uniqueResult();
		return (UserMasterEntity) o;
	}

    @Override
    public List<Integer> getRoleIdsByUser(String username) {
        UserMasterEntity entity = loadUserByUsername(username);
        List<Integer> roleIds = new ArrayList<Integer>();
        for(RoleMasterEntity role : entity.getRoleMasterEntityList()){
            roleIds.add(role.getRoleId());
        }
        return roleIds;
    }
	
	
}
