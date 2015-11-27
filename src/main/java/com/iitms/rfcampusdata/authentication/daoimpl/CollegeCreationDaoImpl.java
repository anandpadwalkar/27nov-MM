package com.iitms.rfcampusdata.authentication.daoimpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iitms.rfcampusdata.authentication.dao.CollegeCreationDao;
import com.iitms.rfcampusdata.authentication.entity.AddressMaster;
import com.iitms.rfcampusdata.authentication.entity.CollegeCreationModel;
import com.iitms.rfcampusdata.authentication.entity.CollegeMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.CollegeModuleMasterEntity;

@Repository
public class CollegeCreationDaoImpl implements CollegeCreationDao {

    private static final Logger logger = LoggerFactory.getLogger(CollegeCreationDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<CollegeMasterEntity> getCollegeList() {
        ProjectionList projectionList = Projections.projectionList();

        projectionList.add(Projections.property("collegeId").as("collegeId"));
        projectionList.add(Projections.property("collegeName").as("collegeName"));

        List<CollegeMasterEntity> list =
            this.sessionFactory.getCurrentSession().createCriteria(CollegeMasterEntity.class)
                .setProjection(projectionList).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();

        return list;
    }

    @Override
    public boolean addCollege(CollegeCreationModel collegeCreationModel) {
        Session session = this.sessionFactory.getCurrentSession();
        int collegeId = (Integer) session.createCriteria(AddressMaster.class)
        .setProjection(Projections.max("collegeId"))
        .add(Restrictions.eq("societyId", collegeCreationModel.getSocietyId()))
        .uniqueResult();
        
        AddressMaster addressMaster = collegeCreationModel.getAddressMaster();
        addressMaster.setCollegeId(collegeId + 1);
        session.save(addressMaster);
        
        CollegeMasterEntity collegeMasterEntity = collegeCreationModel.getCollegeMasterEntity();
        collegeMasterEntity.setCollegeId(collegeId + 1); 
        Integer id = (Integer) session.save(collegeMasterEntity);
        
        updateCollegeModuleMaster(session, id, collegeCreationModel.getCollegeModuleList());
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean updateCollege(CollegeCreationModel collegeCreationModel) {
        Session session = this.sessionFactory.getCurrentSession();
        AddressMaster sessionAddressMaster =
            (AddressMaster) session.get(AddressMaster.class, collegeCreationModel.getAddId());
        CollegeMasterEntity sessionCollegeMasterEntity =
            (CollegeMasterEntity) session.get(CollegeMasterEntity.class, collegeCreationModel.getCollegeId());
        List<Integer> moduleIds = session.createCriteria(CollegeModuleMasterEntity.class)
            .setProjection(Projections.property("moduleId"))
            .add(Restrictions.eq("collegeId", collegeCreationModel.getCollegeId()))
            .list();
        if (!sessionAddressMaster.equals(collegeCreationModel.getAddressMaster())) {
            updateAddressMaster(session, sessionAddressMaster, collegeCreationModel.getAddressMaster());
        }
        if (!sessionCollegeMasterEntity.equals(collegeCreationModel.getCollegeMasterEntity())) {
            updateCollegeMaster(session, sessionCollegeMasterEntity, collegeCreationModel.getCollegeMasterEntity());
        }
        //if (!moduleIds.containsAll(collegeCreationModel.getCollegeModuleList())) {
            updateCollegeModuleMaster(session, collegeCreationModel.getCollegeId(), collegeCreationModel.getCollegeModuleList());
       // }
        //Collections.sort(moduleIds);
      //  Collections.sort(collegeCreationModel.getCollegeModuleList());
       // ListUtils.
        logger.info("Mod Ids : "  +  moduleIds.containsAll(collegeCreationModel.getCollegeModuleList()));
        return true;
    }

    

    private void updateCollegeModuleMaster(Session session, int collegeId, List<Integer> collegeModuleList) {
        CollegeModuleMasterEntity entity;
        
        if(collegeModuleList != null){
            session.createQuery("delete From CollegeModuleMasterEntity where collegeId = :collegeId")
            .setParameter("collegeId", collegeId)
            .executeUpdate();
            
            for(Integer moduleId : collegeModuleList){
                entity = new CollegeModuleMasterEntity();
                entity.setCollegeId(collegeId);
                entity.setModuleId(moduleId);
                session.save(entity);
            }
        }
    }

    private void updateCollegeMaster(Session session, CollegeMasterEntity sessionCollegeMasterEntity,
        CollegeMasterEntity collegeMasterEntity) {
        sessionCollegeMasterEntity.setProperties(collegeMasterEntity.getCollegeName(),
            collegeMasterEntity.getCollegeCode(), collegeMasterEntity.getCollegeLogo(),
            collegeMasterEntity.getPanNumber(), collegeMasterEntity.getTinNumber(), collegeMasterEntity.getTanNumber(),
            collegeMasterEntity.getPrincipalName(), collegeMasterEntity.getWorkOrderNumber(),
            collegeMasterEntity.getWorkOrderDate(), collegeMasterEntity.getSocialCollege(),
            collegeMasterEntity.getActive(), collegeMasterEntity.getNumberOfUsers(), collegeMasterEntity.getIpAddress(),
            collegeMasterEntity.getMacAddress(), 1, new Date(), collegeMasterEntity.getSocietyId(),
            collegeMasterEntity.getUniversityId());
        session.update(sessionCollegeMasterEntity);

    }

    private void updateAddressMaster(Session session, AddressMaster sessionAddressMaster, AddressMaster addressMaster) {
        sessionAddressMaster.setProperties(addressMaster.getAddress(), addressMaster.getCity(),
            addressMaster.getPinCode(), addressMaster.getPhone1(), addressMaster.getPhone2(), addressMaster.getPhone3(),
            addressMaster.getFax1(), addressMaster.getFax2(), addressMaster.getEmail1(), addressMaster.getEmail2(),
            addressMaster.getWebsite(), addressMaster.getSocietyId(), addressMaster.getIpAddress(),
            addressMaster.getMacAddress(), 1, new Date());
        session.update(sessionAddressMaster);

    }

    @Override
    public boolean isCollegeExist(String collegeName) {
        Object o = this.sessionFactory.getCurrentSession().createCriteria(CollegeMasterEntity.class)
            .setProjection(Projections.rowCount()).add(Restrictions.eq("", collegeName)).uniqueResult();

        return o != null ? true : false;
    }

    private ProjectionList getProjection() {
        ProjectionList projectionList = Projections.projectionList();

        /* For College Master */
        projectionList.add(Projections.property("collegeMasterEntity.collegeId").as("collegeId"));
        projectionList.add(Projections.property("collegeMasterEntity.collegeName").as("collegeName"));
        projectionList.add(Projections.property("collegeMasterEntity.collegeCode").as("collegeCode"));
        projectionList.add(Projections.property("collegeMasterEntity.collegeLogo").as("collegeLogo"));
        projectionList.add(Projections.property("collegeMasterEntity.panNumber").as("panNumber"));
        projectionList.add(Projections.property("collegeMasterEntity.tinNumber").as("tinNumber"));
        projectionList.add(Projections.property("collegeMasterEntity.tanNumber").as("tanNumber"));
        projectionList.add(Projections.property("collegeMasterEntity.principalName").as("principalName"));
        projectionList.add(Projections.property("collegeMasterEntity.workOrderNumber").as("workOrderNumber"));
        projectionList.add(Projections.property("collegeMasterEntity.workOrderDate").as("workOrderDate"));
        projectionList.add(Projections.property("collegeMasterEntity.socialCollege").as("socialCollege"));
        projectionList.add(Projections.property("collegeMasterEntity.active").as("active"));
        projectionList.add(Projections.property("collegeMasterEntity.numberOfUsers").as("numberOfUsers"));
        projectionList.add(Projections.property("collegeMasterEntity.societyId").as("societyId"));
        projectionList.add(Projections.property("collegeMasterEntity.universityId").as("universityId"));

        /* For Address Master */
        projectionList.add(Projections.property("addressId").as("addId"));
        projectionList.add(Projections.property("address").as("address"));
        projectionList.add(Projections.property("city").as("city"));
        projectionList.add(Projections.property("pinCode").as("pinCode"));
        projectionList.add(Projections.property("phone1").as("phone1"));
        projectionList.add(Projections.property("phone2").as("phone2"));
        projectionList.add(Projections.property("phone3").as("phone3"));
        projectionList.add(Projections.property("fax1").as("fax1"));
        projectionList.add(Projections.property("fax2").as("fax2"));
        projectionList.add(Projections.property("email1").as("email1"));
        projectionList.add(Projections.property("email2").as("email2"));
        projectionList.add(Projections.property("website").as("website"));
        projectionList.add(Projections.property("collegeId").as("collegeIdInAddress"));

        return projectionList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public CollegeCreationModel getCollegeInformation(int collegeId) {
        ProjectionList projectionList = getProjection();

        Session session = this.sessionFactory.getCurrentSession();
        CollegeCreationModel entity =
            (CollegeCreationModel) session.createCriteria(AddressMaster.class)
                .createAlias("collegeMasterEntity", "collegeMasterEntity", JoinType.INNER_JOIN)
                .setProjection(projectionList).add(Restrictions.eq("collegeMasterEntity.collegeId", collegeId))
                .setResultTransformer(new AliasToBeanResultTransformer(CollegeCreationModel.class)).uniqueResult();

        List<Integer> moduleIds = session.createCriteria(CollegeModuleMasterEntity.class)
        .setProjection(Projections.property("moduleId"))
        .add(Restrictions.eq("collegeId", entity.getCollegeId()))
        .list();
        entity.setModules(moduleIds);
        
        return entity;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CollegeMasterEntity> getCollegeBySociety(int societyId) {
        Session session = this.sessionFactory.getCurrentSession();
        
        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.property("collegeId").as("collegeId"));
        projectionList.add(Projections.property("collegeName").as("collegeName"));
        
        List<CollegeMasterEntity> collegeList = session.createCriteria(CollegeMasterEntity.class)
            .setProjection(projectionList)
            .add(Restrictions.sqlRestriction("this_.id / 10000 = " + societyId))
            .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP)
            .list();
        
        return collegeList;
    }
}
