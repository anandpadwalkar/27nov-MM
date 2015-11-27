package com.iitms.rfcampusdata.authentication.dao;

import java.util.List;

import com.iitms.rfcampuscommon.PaginationResponse;
import com.iitms.rfcampusdata.authentication.entity.RoleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleTypeMasterEntity;

public interface RoleCreationDao {

    public List<RoleMasterEntity> getRolesByUserType(int roleTypeId);

    public PaginationResponse getPaginationResponse(int sEcho, int pageStart, int pageLength, int sortCulumn,
        String sortDirection, String search, int roleTypeId);

    public RoleMasterEntity getRolesInfo(int roleId);

    public boolean addRole(RoleMasterEntity roleMasterEntity);

    public boolean updateRole(RoleMasterEntity roleMasterEntity);

    public boolean isRoleExist(int roleID, String roleName);

    public List<RoleTypeMasterEntity> getRoleTypes();
    
    public List<RoleMasterEntity> getAllRoles(int roleTypeId);
    public List<RoleMasterEntity> getAllRoles();
}
