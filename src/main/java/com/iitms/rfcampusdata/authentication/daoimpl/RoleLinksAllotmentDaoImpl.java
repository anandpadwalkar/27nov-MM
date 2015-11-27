package com.iitms.rfcampusdata.authentication.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.sql.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iitms.rfcampusdata.authentication.dao.RoleLinksAllotmentDao;
import com.iitms.rfcampusdata.authentication.entity.MenuMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.ModuleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMenuAllocationEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMenuResponse;

@Repository
public class RoleLinksAllotmentDaoImpl implements RoleLinksAllotmentDao
{
	private static final Logger logger = LoggerFactory.getLogger(RoleLinksAllotmentDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory ;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RoleMasterEntity> getAllocatedRole()
	{
		Session session = this.sessionFactory.getCurrentSession();
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.distinct(Projections.property("roleMaster.roleId").as("roleId")));
		projectionList.add(Projections.property("roleMaster.roleName").as("roleName"));
		List<RoleMasterEntity> list  = session.createCriteria(RoleMenuAllocationEntity.class)
		.createAlias("roleMasterEntity", "roleMaster", JoinType.INNER_JOIN)
		.setProjection(projectionList)
		.add(Restrictions.eq("roleMaster.active", 1))
		.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP)
		.list();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RoleMasterEntity> getNotAllocatedRole()
	{
		Session session = this.sessionFactory.getCurrentSession();
		 
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(RoleMenuAllocationEntity.class)
		.setProjection(Projections.distinct(Projections.property("roleId")));
		
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("roleId").as("roleId"));
		projectionList.add(Projections.property("roleName").as("roleName"));
		List<RoleMasterEntity> list  = session.createCriteria(RoleMasterEntity.class)
		.setProjection(projectionList)
		.add(Restrictions.eq("active", 1))
		.add(Subqueries.propertyNotIn("roleId", detachedCriteria))
		.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP)
		.list();
		return list;
	}
	
/*	@SuppressWarnings("unchecked")
	public List<MenuMasterEntity> getModuleWiseMenu() 
	{
		
		ProjectionList column=Projections.projectionList()
				.add(Projections.property("module.id"))
				.add(Projections.property("module.moduleName"))
				.add(Projections.property("menu.menuName"))
				.add(Projections.property("menu.menuId"));
		
		Session session = this.sessionFactory.getCurrentSession();
		       
		List<MenuMasterEntity> list=session.createCriteria(MenuMasterEntity.class,"menu")
				.setFetchMode("menu.moduleMasterEntity", FetchMode.JOIN)
				.createAlias("menu.moduleMasterEntity","module")
				.setProjection(column)
				.list();
	
				                           
			//Hibernate.initialize("module.getModule()");
		//SerializationFeature.FAIL_ON_EMPTY_BEANS
	//	session.enableFetchProfile("module");
		List<MenuMasterEntity> subMenuList;
	
		List<MenuMasterEntity> mainMenuList = session.createCriteria(MenuMasterEntity.class)
			//	.createAlias("subMenu", "subMenu", JoinType.INNER_JOIN)
				.add(Restrictions.eq("parentMenuId", 0))
				.add(Restrictions.eq("moduleId", moduleId))
				.list();
		
		for(MenuMasterEntity mainMenu : mainMenuList){
			subMenuList = session.createCriteria(MenuMasterEntity.class)
					//	.createAlias("subMenu", "subMenu", JoinType.INNER_JOIN)
						.add(Restrictions.eq("parentMenuId", mainMenu.getMenuId()))
						.add(Restrictions.eq("moduleId", moduleId))
						.list();
			mainMenu.setSubmenu(subMenuList);
		}
		//logger.info("Menu Size : " + mainMenuList .size() + " - " + mainMenuList);
		
		return list ;
	}
*/
	@SuppressWarnings("unchecked")
	@Override
	public List<RoleMenuResponse> getMenuList() 
	{
		Session session = this.sessionFactory.getCurrentSession();
		//Hibernate.initialize("module.getModule()");
		//SerializationFeature.FAIL_ON_EMPTY_BEANS
	//	session.enableFetchProfile("module");
		List<MenuMasterEntity> subMenuList;
        List<MenuMasterEntity> mainMenuList = null;
        RoleMenuResponse roleMenuResponse;
        List<RoleMenuResponse> listRoleMenuResponse = new ArrayList<RoleMenuResponse>();
		List<ModuleMasterEntity> moduleList = session.createCriteria(ModuleMasterEntity.class)
		.list();
		
		for(ModuleMasterEntity module : moduleList){
		    
		    logger.info("Module : "  + module);
		    RoleMenuResponse response = new RoleMenuResponse();
		    
		    mainMenuList = session.createCriteria(MenuMasterEntity.class)
	            //  .createAlias("subMenu", "subMenu", JoinType.INNER_JOIN)
	                .add(Restrictions.eq("parentMenuId", 0))
	                .add(Restrictions.eq("moduleId", module.getModuleId()))
	                .list();
		    //logger.info("Main Menus : " + mainMenuList);
	        
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


	@Override
	@SuppressWarnings("unchecked")
	public List<RoleMenuAllocationEntity> loadMenuAsPerRole(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();
		
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("menuId").as("menuId"));
		projectionList.add(Projections.property("moduleId").as("moduleId"));
		
		List<RoleMenuAllocationEntity> menuIdList=session.createCriteria(RoleMenuAllocationEntity.class)
		.add(Restrictions.eq("roleId",id))
		.setProjection(projectionList)
		.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP)
        .list();
		return menuIdList;
	}

	@Override
	public boolean setModuleAndRolePerMenu(RoleMenuAllocationEntity roleMenuAllocation) 
	{
				this.sessionFactory.getCurrentSession().save(roleMenuAllocation);
    	        return true;	
	}

	@Override
	public List<ModuleMasterEntity> getModuleList() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ModuleMasterEntity> moduleList = session.createCriteria(ModuleMasterEntity.class).list();
		return moduleList;
	}

    @Override
    public void removeAllocatedMenusByRole(int roleId) {
        this.sessionFactory.getCurrentSession()
        .createQuery("Delete From RoleMenuAllocationEntity entity where entity.roleId = :roleId")
        .setParameter("roleId", roleId)
        .executeUpdate();
    }
	

	
	

}
