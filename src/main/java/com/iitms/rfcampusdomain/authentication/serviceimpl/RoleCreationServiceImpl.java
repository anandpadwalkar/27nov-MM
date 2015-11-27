package com.iitms.rfcampusdomain.authentication.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iitms.rfcampuscommon.PaginationResponse;
import com.iitms.rfcampusdata.authentication.dao.RoleCreationDao;
import com.iitms.rfcampusdata.authentication.entity.RoleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleTypeMasterEntity;
import com.iitms.rfcampusdomain.authentication.service.RoleCreationService;

@Service
@Transactional
public class RoleCreationServiceImpl implements RoleCreationService {

    @Autowired
    private RoleCreationDao roleCreationDao;

    @Override
    public List<RoleMasterEntity> getRolesByUserType(int roleTypeId) {
        return roleCreationDao.getRolesByUserType(roleTypeId);
    }

    @Override
    public RoleMasterEntity getRolesInfo(int roleId) {
        return roleCreationDao.getRolesInfo(roleId);
    }

    @Override
    public boolean addRole(RoleMasterEntity roleMasterEntity) {
        return roleCreationDao.addRole(roleMasterEntity);
    }

    @Override
    public boolean updateRole(RoleMasterEntity roleMasterEntity) {
        return roleCreationDao.updateRole(roleMasterEntity);
    }

    @Override
    public boolean isRoleExist(int roleID, String roleName) {
        return roleCreationDao.isRoleExist(roleID, roleName);
    }

    @Override
    public List<RoleTypeMasterEntity> getRoleTypes() {
        return roleCreationDao.getRoleTypes();
    }

    @Override
    public PaginationResponse getPaginationResponse(int sEcho, int pageStart, int pageLength, int sortCulumn,
        String sortDirection, String search, int roleTypeId) {
        return roleCreationDao.getPaginationResponse(sEcho, pageStart, pageLength, sortCulumn, sortDirection, search,
            roleTypeId);
    }

    @Override
    public List<RoleMasterEntity> getAllRoles(int roleTypeId) {
        return roleCreationDao.getAllRoles(roleTypeId);
    }

    @Override
    public List<RoleMasterEntity> getAllRoles() {
        return roleCreationDao.getAllRoles();
    }

}
