package com.iitms.rfcampusdata.authentication.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iitms.rfcampusdata.authentication.dao.ModuleDao;
import com.iitms.rfcampusdata.authentication.entity.ModuleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMenuAllocationEntity;

@Repository
public class ModuleDaoImpl implements ModuleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<ModuleMasterEntity> listAuthorisedModule(List<Integer> roleIds) {
	    ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.distinct(Projections.property("moduleMasterEntity.moduleId").as("moduleId")));
        projectionList.add(Projections.property("moduleMasterEntity.moduleName").as("moduleName"));

        List<ModuleMasterEntity> list = this.sessionFactory.getCurrentSession().createCriteria(RoleMenuAllocationEntity.class)
                .createAlias("moduleMasterEntity", "moduleMasterEntity")
                .setProjection(projectionList)
                .add(Restrictions.in("roleId", roleIds))
                .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP)
                .list();
        
        return list;
	}

	@Override
	public boolean addModule(ModuleMasterEntity moduleMasterEntity) {
		this.sessionFactory.getCurrentSession().save(moduleMasterEntity);
		return true;
	}

	@Override
	public boolean updateModule(ModuleMasterEntity moduleMasterEntity) {
		Session session = this.sessionFactory.getCurrentSession();
		ModuleMasterEntity entity = (ModuleMasterEntity) session.get(ModuleMasterEntity.class,
				moduleMasterEntity.getModuleId());
		entity.setModuleName(moduleMasterEntity.getModuleName());
		entity.setSerialNumber(moduleMasterEntity.getSerialNumber());
		entity.setModuleStatus(moduleMasterEntity.getModuleStatus());
		session.update(entity);
		return true;
	}

	@Override
	public boolean isModuleNameExist(int moduleId, String moduleName) {
		Session session = this.sessionFactory.getCurrentSession();
		Long o = (Long) session.createCriteria(ModuleMasterEntity.class).add(Restrictions.eq("moduleName", moduleName))
				//.add(Restrictions.ne("id", moduleId))
				.setProjection(Projections.rowCount()).uniqueResult();

		return o.intValue() != 0 ? true : false;
	}

	@Override
	public ModuleMasterEntity getModuleInfo(int moduleId) {
		ModuleMasterEntity entity = (ModuleMasterEntity) this.sessionFactory.getCurrentSession()
				.get(ModuleMasterEntity.class, moduleId);
		return entity;
	}

    @SuppressWarnings("unchecked")
    @Override
    public List<ModuleMasterEntity> listAllModule() {
        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.property("moduleId").as("moduleId"));
        projectionList.add(Projections.property("moduleName").as("moduleName"));
        projectionList.add(Projections.property("moduleStatus").as("moduleStatus"));
        projectionList.add(Projections.property("serialNumber").as("serialNumber"));
        
        List<ModuleMasterEntity> modulesList = this.sessionFactory.getCurrentSession().createCriteria(ModuleMasterEntity.class)
       // .add(Restrictions.eq("", 1))
            .setProjection(projectionList)
            .addOrder(Order.asc("serialNumber"))
            .setResultTransformer(new AliasToBeanResultTransformer(ModuleMasterEntity.class))
        .list();
        
        return modulesList;
    }

}
