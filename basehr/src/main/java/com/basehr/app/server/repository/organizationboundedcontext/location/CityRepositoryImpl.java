package com.basehr.app.server.repository.organizationboundedcontext.location;
import com.basehr.app.server.repository.core.SearchInterfaceImpl;
import com.basehr.app.shared.organizationboundedcontext.location.City;
import org.springframework.stereotype.Repository;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.config.server.helper.ResourceFactoryManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.spartan.pluggable.logger.alarms.AppAlarm;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.spartan.pluggable.logger.api.LogManager;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import java.lang.Override;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Repository
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for City Master table Entity", complexity = Complexity.LOW)
public class CityRepositoryImpl extends SearchInterfaceImpl implements CityRepository<City> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(System.getProperty("LOGGER_ID"));

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<City> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.basehr.app.shared.organizationboundedcontext.location.City> query = emanager.createQuery("select u from City u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "CityRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public City save(City entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "CityRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<City> save(List<City> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.basehr.app.shared.organizationboundedcontext.location.City obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "CityRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.basehr.app.shared.organizationboundedcontext.location.City s = emanager.find(com.basehr.app.shared.organizationboundedcontext.location.City.class, id);
        emanager.remove(s);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "CityRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(City entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "CityRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<City> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.basehr.app.shared.organizationboundedcontext.location.City obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "CityRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public List<City> findByCountryId(String countryId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("City.findByCountryId");
        query.setParameter("countryId", countryId);
        java.util.List<com.basehr.app.shared.organizationboundedcontext.location.City> listOfCity = query.getResultList();
        Log.out.println("ORGLO324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "CityRepositoryImpl", "findByCountryId", "Total Records Fetched = " + listOfCity.size());
        return listOfCity;
    }

    @Transactional
    public List<City> findByStateId(String stateId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("City.findByStateId");
        query.setParameter("stateId", stateId);
        java.util.List<com.basehr.app.shared.organizationboundedcontext.location.City> listOfCity = query.getResultList();
        Log.out.println("ORGLO324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "CityRepositoryImpl", "findByStateId", "Total Records Fetched = " + listOfCity.size());
        return listOfCity;
    }

    @Transactional
    public City findById(String cityId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("City.findById");
        query.setParameter("cityId", cityId);
        com.basehr.app.shared.organizationboundedcontext.location.City listOfCity = (com.basehr.app.shared.organizationboundedcontext.location.City) query.getSingleResult();
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "CityRepositoryImpl", "findById", "Total Records Fetched = " + listOfCity);
        return listOfCity;
    }
}
