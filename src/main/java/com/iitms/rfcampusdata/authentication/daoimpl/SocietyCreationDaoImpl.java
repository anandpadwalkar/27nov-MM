package com.iitms.rfcampusdata.authentication.daoimpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iitms.rfcampusdata.authentication.dao.SocietyCreationDao;
import com.iitms.rfcampusdata.authentication.entity.AddressMaster;
import com.iitms.rfcampusdata.authentication.entity.CollegeModuleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.SocietyCreationModel;
import com.iitms.rfcampusdata.authentication.entity.SocietyMaster;

@Repository
public class SocietyCreationDaoImpl implements SocietyCreationDao {

    private static final Logger logger = LoggerFactory.getLogger(SocietyCreationDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings({"unchecked"})
    public List<SocietyMaster> getAllSociety() {
        Session session = this.sessionFactory.getCurrentSession();

        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.property("societyId").as("societyId"));
        projectionList.add(Projections.property("societyCode").as("societyCode"));
        projectionList.add(Projections.property("societyName").as("societyName"));

        List<SocietyMaster> society = session.createCriteria(SocietyMaster.class).setProjection(projectionList)
            .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();

        return society;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public SocietyCreationModel getSocietyById(int societyId) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = null;

        ProjectionList projectionList = getProjection();

        criteria = session.createCriteria(AddressMaster.class).createAlias("societyMaster", "society");

        SocietyCreationModel entity = (SocietyCreationModel) criteria.setProjection(projectionList)
            .add(Restrictions.sqlRestriction("this_.college_id = this_.society_id * 10000"))
            .add(Restrictions.eq("societyId", societyId))
            .setResultTransformer(new AliasToBeanResultTransformer(SocietyCreationModel.class)).uniqueResult();

        
        List<Integer> moduleIds =
            session.createCriteria(CollegeModuleMasterEntity.class).setProjection(Projections.property("moduleId"))
                .add(Restrictions.eq("societyId", entity.getSocId())).list();
        entity.setModules(moduleIds);

        return entity;

    }

    @Override
    @SuppressWarnings({"unchecked"})
    public List<CollegeModuleMasterEntity> getCollegeModuleyById(int socid) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = null;
        criteria = session.createCriteria(CollegeModuleMasterEntity.class);

        List<CollegeModuleMasterEntity> society = criteria
            .add(Restrictions.sqlRestriction(" this_.society_id * 10000 = this_.college_id and this_.society_id =" + socid))
            .list();

        return society;

    }

    @Override
    public int addSocietys(SocietyCreationModel societyCreationModel) {
        Session session = this.sessionFactory.getCurrentSession();

        SocietyMaster society = societyCreationModel.getSocietyMaster();
        Integer id = (Integer) session.save(society);
        AddressMaster addressMaster = societyCreationModel.getAddressMaster();
        addressMaster.setSocietyId(id);
        addressMaster.setCollegeId(addressMaster.getSocietyId() * 10000);
        session.save(addressMaster);
        updateSocietyModule(session, id, societyCreationModel.getSocietyModuleList());

        return 1;
    }

    private void updateSocietyModule(Session session, int societyId, List<Integer> societyModuleList) {
        CollegeModuleMasterEntity entity;

        if (societyModuleList != null) {
            session.createQuery("delete From CollegeModuleMasterEntity where societyId = :societyId")
                .setParameter("societyId", societyId).executeUpdate();

            for (Integer moduleId : societyModuleList) {
                entity = new CollegeModuleMasterEntity();
                entity.setSocietyId(societyId);
                entity.setModuleId(moduleId);
                session.save(entity);
            }
        }
    }

    @Override
    @SuppressWarnings({})
    public boolean addAddress(AddressMaster address) {
        this.sessionFactory.getCurrentSession().save(address);
        return true;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public boolean updateSociety(SocietyCreationModel societyCreationModel) {
        Session session = this.sessionFactory.getCurrentSession();
        AddressMaster sessionAddressMaster =
            (AddressMaster) session.get(AddressMaster.class, societyCreationModel.getAddId());
        SocietyMaster sessionSociety = (SocietyMaster) session.get(SocietyMaster.class, societyCreationModel.getSocId());
        List<Integer> moduleIds =
            session.createCriteria(CollegeModuleMasterEntity.class).setProjection(Projections.property("moduleId"))
                .add(Restrictions.eq("societyId", societyCreationModel.getSocId())).list();
        if (!sessionAddressMaster.equals(societyCreationModel.getAddressMaster())) {
            updateAddressMaster(session, sessionAddressMaster, societyCreationModel.getAddressMaster());
        }
        if (!sessionSociety.equals(societyCreationModel.getSocietyMaster())) {
            updateSocietyMaster(session, sessionSociety, societyCreationModel.getSocietyMaster());
        }
        
        /*if (!societyCreationModel.getCollegeModuleList().containsAll(moduleIds)) {
            updateCollegeModuleMaster(session, societyCreationModel.getSocId(),
                societyCreationModel.getCollegeModuleList());
        }*/
        
        /**Temp Code*/
        updateSocietyModule(session, societyCreationModel.getSocId(),
            societyCreationModel.getCollegeModuleList());
        
        return true;
    }

    private void updateSocietyMaster(Session session, SocietyMaster sessionSociety, SocietyMaster society) {
        sessionSociety.setProperties(society.getSocietyCode(), society.getSocietyName(), society.getSocietyRegistrationNumber(),
            society.getSocietyLogo(), "", "", society.getSocietyChairman(), society.getSocietySecretory(), 1, new Date());
        session.update(sessionSociety);

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
    public boolean updateAddress(AddressMaster address) {
        this.sessionFactory.getCurrentSession().update(address);
        return true;
    }

    @Override
    public boolean addCollegeModule(CollegeModuleMasterEntity collegeModule) {
        this.sessionFactory.getCurrentSession().save(collegeModule);
        return true;
    }

    @Override
    public boolean delete_all_module(int soc_id) {
        boolean result = false;
        Session session = this.sessionFactory.getCurrentSession();
        int count = 0;

        count = session.createQuery("Delete CollegeModuleMasterEntity where societyId = :id").setParameter("id", soc_id)
            .executeUpdate();

        if (count != 0) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    private ProjectionList getProjection() {
        ProjectionList projectionList = Projections.projectionList();

        /* For society Master */
        projectionList.add(Projections.property("society.societyId").as("socId"));
        projectionList.add(Projections.property("society.societyCode").as("socCode"));
        projectionList.add(Projections.property("society.societyName").as("socName"));
        projectionList.add(Projections.property("society.societyRegistrationNumber").as("socRegno"));// menuStatus
        projectionList.add(Projections.property("society.societyLogo").as("socLogo"));
        projectionList.add(Projections.property("society.societyChairman").as("societyChairman"));
        projectionList.add(Projections.property("society.societySecretory").as("societySecretory"));

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
        projectionList.add(Projections.property("societyId").as("societyIdInAddress"));

        return projectionList;
    }
}
