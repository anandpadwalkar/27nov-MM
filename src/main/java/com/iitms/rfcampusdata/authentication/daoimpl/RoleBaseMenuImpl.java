package com.iitms.rfcampusdata.authentication.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iitms.rfcampusdata.authentication.dao.RoleBaseMenu;
import com.iitms.rfcampusdata.authentication.entity.MenuMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.ModuleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMenuAllocationEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMenuResponse;

@Repository
// @Transactional
public class RoleBaseMenuImpl implements RoleBaseMenu {
	private static final Logger logger = LoggerFactory.getLogger(RoleBaseMenuImpl.class);
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<RoleMenuAllocationEntity> loadMenu(int id) {
		logger.info("Load menthod");
		Session session = this.sessionFactory.getCurrentSession();
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("menu.menuId").as("menuId"));
		projectionList.add(Projections.property("menu.menuName").as("menuName"));
		projectionList.add(Projections.property("menu.parentMenuId").as("parentMenuId"));
		projectionList.add(Projections.property("menu.menuLink").as("menuLink"));

		List<RoleMenuAllocationEntity> list = session.createCriteria(RoleMenuAllocationEntity.class)
				.createAlias("menuMasterEntity", "menu", JoinType.INNER_JOIN).setProjection(projectionList)
				.add(Restrictions.eq("roleId", id)).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
		return list;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoleMenuResponse> getMenuList(int moduleId) {
		Session session = this.sessionFactory.getCurrentSession();
		//Hibernate.initialize("module.getModule()");
		//SerializationFeature.FAIL_ON_EMPTY_BEANS
	//	session.enableFetchProfile("module");
		List<MenuMasterEntity> subMenuList;
        List<MenuMasterEntity> mainMenuList = null;
        RoleMenuResponse response;
        List<RoleMenuResponse> listRoleMenuResponse = new ArrayList<RoleMenuResponse>();
		List<ModuleMasterEntity> moduleList = session.createCriteria(ModuleMasterEntity.class)
		.list();
		
		for(ModuleMasterEntity module : moduleList){
		     response = new RoleMenuResponse();
		    
		    mainMenuList = session.createCriteria(MenuMasterEntity.class)
	            //  .createAlias("subMenu", "subMenu", JoinType.INNER_JOIN)
	                .add(Restrictions.eq("parentMenuId", 0))
	                .add(Restrictions.eq("moduleId", module.getModuleId()))
	                .list();
	        logger.info("Main Menus : " + mainMenuList);
		    
	        for(MenuMasterEntity mainMenu : mainMenuList){
	            subMenuList = session.createCriteria(MenuMasterEntity.class)
	                    //  .createAlias("subMenu", "subMenu", JoinType.INNER_JOIN)
	                        .add(Restrictions.eq("parentMenuId", mainMenu.getMenuId()))
	                        .add(Restrictions.eq("moduleId", module.getModuleId()))
	                        .list();
	            mainMenu.setSubMenu(subMenuList);
	        }
	        
	        response.setModuleId(module.getModuleId());
	        response.setModuleName(module.getModuleName());
	        response.setMainMenu(mainMenuList);
	        listRoleMenuResponse.add(response);
		}
		
		//logger.info("Menu Size : " + mainMenuList .size() + " - " + mainMenuList);
		
		return listRoleMenuResponse ;
	}

}
