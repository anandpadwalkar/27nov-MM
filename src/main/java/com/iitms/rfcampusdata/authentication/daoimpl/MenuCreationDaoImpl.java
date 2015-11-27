package com.iitms.rfcampusdata.authentication.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iitms.rfcampusdata.authentication.dao.MenuCreationDao;
import com.iitms.rfcampusdata.authentication.entity.MenuMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMenuAllocationEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMenuResponse;

@Repository
public class MenuCreationDaoImpl implements MenuCreationDao {

    private static final Logger logger = LoggerFactory.getLogger(MenuCreationDaoImpl.class);
    
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<MenuMasterEntity> getMainMainById(int moduleId, int parentMenuId) {
		Session session = this.sessionFactory.getCurrentSession();
		
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("menuId").as("menuId"));
		projectionList.add(Projections.property("moduleId").as("moduleId"));
		projectionList.add(Projections.property("menuName").as("menuName"));
		projectionList.add(Projections.property("menuLink").as("menuLink"));
		projectionList.add(Projections.property("menuTooltip").as("menuToolTip"));//menuStatus
		projectionList.add(Projections.property("menuStatus").as("active"));
		projectionList.add(Projections.property("menuSerialNumber").as("menuSrno"));
		projectionList.add(Projections.property("parentMenuId").as("parentMenuId"));
		
		Criteria criteria = session.createCriteria(MenuMasterEntity.class);
		List<MenuMasterEntity> menuResponse = (List<MenuMasterEntity>) criteria.setProjection(projectionList)
				.add(Restrictions.eq("moduleId", moduleId))
				.add(Restrictions.eq("parentMenuId", parentMenuId))
				.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
		
		
		return menuResponse;
		
	}

	@Override
	public boolean addMainMenuCreation(MenuMasterEntity menuMasterEntity) {
	 this.sessionFactory.getCurrentSession().save(menuMasterEntity);
	 return true;
	}
	

	@Override
	public boolean updateMainMenuCreation(MenuMasterEntity menuMasterEntity) {
	 this.sessionFactory.getCurrentSession().update(menuMasterEntity);
	 return true;
	}

	@SuppressWarnings("unchecked")
    @Override
    public List<MenuMasterEntity> getModulewiseMenu(int moduleId) 
    {
        Session session = this.sessionFactory.getCurrentSession();
        //Hibernate.initialize("module.getModule()");
        //SerializationFeature.FAIL_ON_EMPTY_BEANS
    //  session.enableFetchProfile("module");
        List<MenuMasterEntity> subMenuList;
        List<MenuMasterEntity> mainMenuList = session.createCriteria(MenuMasterEntity.class)
            //  .createAlias("subMenu", "subMenu", JoinType.INNER_JOIN)
                .add(Restrictions.eq("parentMenuId", 0))
                .add(Restrictions.eq("moduleId", moduleId))
                .list();
        
        for(MenuMasterEntity mainMenu : mainMenuList){
            subMenuList = session.createCriteria(MenuMasterEntity.class)
                    //  .createAlias("subMenu", "subMenu", JoinType.INNER_JOIN)
                        .add(Restrictions.eq("parentMenuId", mainMenu.getMenuId()))
                        .add(Restrictions.eq("moduleId", moduleId))
                        .list();
            mainMenu.setSubMenu(subMenuList);
        }
        //logger.info("Menu Size : " + mainMenuList .size() + " - " + mainMenuList);
        
        return mainMenuList ;
    }

	@SuppressWarnings("unchecked")
    @Override
    public List<RoleMenuResponse> getModulewiseMenu(int moduleId, List<Integer> roleIds) {
        Session session = this.sessionFactory.getCurrentSession();
        
        List<Integer> assignedMenus = session.createCriteria(RoleMenuAllocationEntity.class)
        .setProjection(Projections.distinct(Projections.property("menuId")))
        .add(Restrictions.in("roleId", roleIds))
        .add(Restrictions.eq("moduleId", moduleId))
        .list();
        
        
        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.property("menuMasterEntity.menuId").as("menuId"));
        projectionList.add(Projections.property("menuMasterEntity.menuName").as("menuName"));
        projectionList.add(Projections.property("menuMasterEntity.menuTooltip").as("menuTooltip"));
        projectionList.add(Projections.property("menuMasterEntity.menuLink").as("menuLink"));
        projectionList.add(Projections.property("menuMasterEntity.parentMenuId").as("parentMenuId"));
        // Hibernate.initialize("module.getModule()");
        // SerializationFeature.FAIL_ON_EMPTY_BEANS
        // session.enableFetchProfile("module");
        List<RoleMenuResponse> subMenuList;
        List<RoleMenuResponse> mainMenuList = session.createCriteria(RoleMenuAllocationEntity.class)
                .createAlias("menuMasterEntity", "menuMasterEntity", JoinType.INNER_JOIN)
                .setProjection(projectionList)
                .add(Restrictions.in("roleId", roleIds))
                .add(Restrictions.eq("menuMasterEntity.parentMenuId", 0))
                .add(Restrictions.eq("menuMasterEntity.moduleId", moduleId))
                .addOrder(Order.asc("menuMasterEntity.menuSerialNumber"))
                .setResultTransformer(new AliasToBeanResultTransformer(RoleMenuResponse.class))
                .list();

        projectionList = Projections.projectionList();
        projectionList.add(Projections.property("menuId").as("menuId"));
        projectionList.add(Projections.property("menuName").as("menuName"));
        projectionList.add(Projections.property("menuTooltip").as("menuTooltip"));
        projectionList.add(Projections.property("menuLink").as("menuLink"));
        projectionList.add(Projections.property("parentMenuId").as("parentMenuId"));
        
        for (RoleMenuResponse mainMenu : mainMenuList) {
            subMenuList = session.createCriteria(MenuMasterEntity.class)
                    //.createAlias("MenuMasterEntity", "MenuMasterEntity", JoinType.INNER_JOIN)
                    .setProjection(projectionList)
                    //.add(Restrictions.eq("roleId", roleId))
                    .add(Restrictions.in("menuId", assignedMenus))
                    .add(Restrictions.eq("parentMenuId", mainMenu.getMenuId()           
                            ))
                    //.add(Restrictions.eq("MenuMasterEntity.moduleId", moduleId))
                    .addOrder(Order.asc("menuSerialNumber"))
                    .setResultTransformer(new AliasToBeanResultTransformer(RoleMenuResponse.class))
                    .list();
            mainMenu.setSubmenu(subMenuList);
        }
        
        return mainMenuList;
    }



	

	

}
