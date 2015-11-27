package com.iitms.rfcampusdomain.authentication.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iitms.rfcampusdata.authentication.dao.MenuCreationDao;
import com.iitms.rfcampusdata.authentication.entity.MenuMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMenuResponse;
import com.iitms.rfcampusdomain.authentication.service.MenuCreationService;

@Service
@Transactional
public class MenuCreationServiceImpl implements MenuCreationService {

    @Autowired
    private MenuCreationDao menuCreationDao;

    @Override
    public List<MenuMasterEntity> getMainMainById(int moduleId, int parentMenuId) {
        return menuCreationDao.getMainMainById(moduleId, parentMenuId);
    }

    @Override
    public boolean addMainMenuCreation(MenuMasterEntity menuMasterEntity) {
        return menuCreationDao.addMainMenuCreation(menuMasterEntity);

    }

    @Override
    public boolean updateMainMenuCreation(MenuMasterEntity menuMasterEntity) {
        return menuCreationDao.updateMainMenuCreation(menuMasterEntity);

    }

    @Override
    public List<MenuMasterEntity> getModulewiseMenu(int moduleId) {
        return menuCreationDao.getModulewiseMenu(moduleId);
    }

    @Override
    public List<RoleMenuResponse> getModulewiseMenu(int moduleId, List<Integer> roleIds) {
        return menuCreationDao.getModulewiseMenu(moduleId, roleIds);
    }

}
