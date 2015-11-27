package com.iitms.rfcampusdata.authentication.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iitms.rfcampuscommon.ConstantUtil;
import com.iitms.rfcampusdata.authentication.dao.UserCreationDao;
import com.iitms.rfcampusdata.authentication.entity.UserMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.UserRoleAllocationEntity;


@Repository
public class UserCreationDaoImpl implements UserCreationDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean addUser(UserMasterEntity userMasterEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        int userId = (Integer) session.save(userMasterEntity);
        allocateRoles(session, userId, userMasterEntity.getRoleIds());
        return true;
    }

    @Override
    public boolean updateUser(UserMasterEntity userMasterEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        UserMasterEntity sessionEntity =
            (UserMasterEntity) session.get(UserMasterEntity.class, userMasterEntity.getUserId());
        sessionEntity.setName(userMasterEntity.getName());
        sessionEntity.setUsername(userMasterEntity.getUsername());
        sessionEntity.setPassword(userMasterEntity.getPassword());
        sessionEntity.setCounter(userMasterEntity.getCounter());
        sessionEntity.setSetWorkingDate(userMasterEntity.getSetWorkingDate());
        sessionEntity.setActive(userMasterEntity.getActive());
        sessionEntity.setMobileNumber(userMasterEntity.getMobileNumber());
        sessionEntity.setEmailid(userMasterEntity.getEmailid());
        session.update(sessionEntity);
        
        allocateRoles(session, sessionEntity.getUserId(), userMasterEntity.getRoleIds());
        return true;
    }

    @Override
    public UserMasterEntity getUserInformation(int userId) {
        UserMasterEntity userMasterEntity =
            (UserMasterEntity) this.sessionFactory.getCurrentSession().get(UserMasterEntity.class, userId);
        return userMasterEntity;
    }

    @Override
    public boolean isUserAvailable(String username) {
        Object o = this.sessionFactory.getCurrentSession().createCriteria(UserMasterEntity.class)
        .add(Restrictions.eq("username", username))
        .setProjection(Projections.rowCount())
        .uniqueResult();
        return o != null ?true:false;
    }

    /*Private Methods*/
    private void allocateRoles(Session session, int userId, String roleIds) {
        UserRoleAllocationEntity entity;
        
        session.createQuery("Delete From UserRoleAllocationEntity entity where entity.userId = :userId")
        .setParameter("userId", userId)
        .executeUpdate();
        
        for(String roleId : roleIds.split(",")){
            entity = new UserRoleAllocationEntity();
            entity.setUserId(userId);
            entity.setRoleId(Integer.parseInt(roleId));
            session.save(entity);
        }
        
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserMasterEntity> searchUserByCriteria(int searchBy, String searchText) {
        Session session = this.sessionFactory.getCurrentSession();
        
        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.property("userId").as("userId"));
        projectionList.add(Projections.property("name").as("name"));
        projectionList.add(Projections.property("username").as("username"));
        
        Criteria criteria = session.createCriteria(UserMasterEntity.class)
            .setProjection(projectionList)
            .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        
        switch(searchBy){
            case ConstantUtil.USER_NAME:{
                criteria.add(Restrictions.ilike("name", "%"+searchText + "%"));
            }break;
            case ConstantUtil.USER_ID:{
                criteria.add(Restrictions.eq("userId", Integer.parseInt(searchText)));
            }break;
            case ConstantUtil.LOGIN_ID:{
                criteria.add(Restrictions.ilike("username", "%" + searchText + "%"));
            }break;
        }
        
        List<UserMasterEntity> list = criteria.list();
        
        return list;
    }
}
