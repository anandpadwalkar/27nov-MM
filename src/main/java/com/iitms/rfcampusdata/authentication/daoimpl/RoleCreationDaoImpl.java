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

import com.iitms.rfcampuscommon.PaginationResponse;
import com.iitms.rfcampusdata.authentication.dao.RoleCreationDao;
import com.iitms.rfcampusdata.authentication.entity.RoleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleTypeMasterEntity;

@Repository
public class RoleCreationDaoImpl implements RoleCreationDao {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<RoleMasterEntity> getRolesByUserType(int roleTypeId) {
        Session session = this.sessionFactory.getCurrentSession();

        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.property("roleId").as("roleId"));
        projectionList.add(Projections.property("roleName").as("roleName"));
        projectionList.add(Projections.property("roleDescription").as("roleDescription"));
        projectionList.add(Projections.property("active").as("active"));

        List<RoleMasterEntity> list = session.createCriteria(RoleMasterEntity.class).setProjection(projectionList)
            .add(Restrictions.eq("userTypeId", roleTypeId)).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();

        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public PaginationResponse getPaginationResponse(int sEcho, int pageStart, int pageLength, int sortColumn,
        String sortDirection, String search, int roleTypeId) {
        Session session = this.sessionFactory.getCurrentSession();

        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.property("roleId").as("roleId"));
        projectionList.add(Projections.property("roleName").as("roleName"));
        projectionList.add(Projections.property("roleDescription").as("roleDescription"));
        projectionList.add(Projections.property("active").as("active"));
        projectionList.add(Projections.property("userTypeId").as("userTypeId"));

        int totalRecord = ((Long) session.createCriteria(RoleMasterEntity.class).setProjection(Projections.rowCount())
            .add(Restrictions.eq("userTypeId", roleTypeId)).uniqueResult()).intValue();

        List<RoleMasterEntity> list = session.createCriteria(RoleMasterEntity.class).setProjection(projectionList)
            .add(Restrictions.eq("userTypeId", roleTypeId)).setFirstResult(pageStart).setMaxResults(pageLength)
            .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();

        PaginationResponse paginationResponse = setPaginationResponse(sEcho, pageStart, pageLength, totalRecord, list);

        return paginationResponse;
    }

    private PaginationResponse setPaginationResponse(int sEcho, int pageStart, int pageLength, int totalRecord,
        List<RoleMasterEntity> list) {
        PaginationResponse paginationResponse = new PaginationResponse();
        paginationResponse.setsEcho(sEcho);
        paginationResponse.setiTotalRecords(totalRecord);
        paginationResponse.setiTotalDisplayRecords(totalRecord);
        paginationResponse.setiDisplayLength(pageLength);
        paginationResponse.setiDisplayStart(pageStart);
        paginationResponse.setAaData(list);

        return paginationResponse;
    }

    @Override
    public RoleMasterEntity getRolesInfo(int roleId) {
        RoleMasterEntity entity =
            (RoleMasterEntity) this.sessionFactory.getCurrentSession().get(RoleMasterEntity.class, roleId);
        return entity;
    }

    @Override
    public boolean addRole(RoleMasterEntity roleMasterEntity) {
        this.sessionFactory.getCurrentSession().save(roleMasterEntity);
        return true;
    }

    @Override
    public boolean updateRole(RoleMasterEntity roleMasterEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        RoleMasterEntity existingRoleEntity =
            (RoleMasterEntity) session.get(RoleMasterEntity.class, roleMasterEntity.getRoleId());
        existingRoleEntity.setRoleName(roleMasterEntity.getRoleName());
        existingRoleEntity.setRoleDescription(roleMasterEntity.getRoleDescription());
        existingRoleEntity.setActive(roleMasterEntity.getActive());
        session.update(existingRoleEntity);
        return true;
    }

    @Override
    public boolean isRoleExist(int roleID, String roleName) {
        Session session = this.sessionFactory.getCurrentSession();

        Criteria criteria = session.createCriteria(RoleMasterEntity.class).setProjection(Projections.rowCount())
            .add(Restrictions.eq("roleName", roleName));
        if (roleID != 0)
            criteria.add(Restrictions.eq("userTypeId", roleID));
        Object o = criteria.uniqueResult();
        return o != null ? true : false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<RoleTypeMasterEntity> getRoleTypes() {
        Session session = this.sessionFactory.getCurrentSession();
        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.property("id").as("id"));
        projectionList.add(Projections.property("roleTypeName").as("roleTypeName"));

        List<RoleTypeMasterEntity> list = session.createCriteria(RoleTypeMasterEntity.class)
            .setProjection(projectionList).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();

        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<RoleMasterEntity> getAllRoles(int roleTypeId) {
        Session session = this.sessionFactory.getCurrentSession();

        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.property("roleId").as("roleId"));
        projectionList.add(Projections.property("roleName").as("roleName"));
        projectionList.add(Projections.property("roleDescription").as("roleDescription"));
        projectionList.add(Projections.property("active").as("active"));
        projectionList.add(Projections.property("userTypeId").as("userTypeId"));

        List<RoleMasterEntity> list = session.createCriteria(RoleMasterEntity.class).setProjection(projectionList)
            .add(Restrictions.eq("userTypeId", roleTypeId)).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();

        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<RoleMasterEntity> getAllRoles() {
        Session session = this.sessionFactory.getCurrentSession();

        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.property("roleId").as("roleId"));
        projectionList.add(Projections.property("roleName").as("roleName"));
        
        List<RoleMasterEntity> list = session.createCriteria(RoleMasterEntity.class).setProjection(projectionList)
            .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();

        return list;
    }

}
