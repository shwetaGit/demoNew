package com.basehr.app.server.repository.aaaboundedcontext.authentication;
import com.basehr.app.server.repository.core.SearchInterfaceImpl;
import com.basehr.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
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
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for UserAccessLevel Master table Entity", complexity = Complexity.LOW)
public class UserAccessLevelRepositoryImpl extends SearchInterfaceImpl implements UserAccessLevelRepository<UserAccessLevel> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(System.getProperty("LOGGER_ID"));

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<UserAccessLevel> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.basehr.app.shared.aaaboundedcontext.authentication.UserAccessLevel> query = emanager.createQuery("select u from UserAccessLevel u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserAccessLevelRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public UserAccessLevel save(UserAccessLevel entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserAccessLevelRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<UserAccessLevel> save(List<UserAccessLevel> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.basehr.app.shared.aaaboundedcontext.authentication.UserAccessLevel obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserAccessLevelRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.basehr.app.shared.aaaboundedcontext.authentication.UserAccessLevel s = emanager.find(com.basehr.app.shared.aaaboundedcontext.authentication.UserAccessLevel.class, id);
        emanager.remove(s);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserAccessLevelRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(UserAccessLevel entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserAccessLevelRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<UserAccessLevel> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.basehr.app.shared.aaaboundedcontext.authentication.UserAccessLevel obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserAccessLevelRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public UserAccessLevel findById(String userAccessLevelId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("UserAccessLevel.findById");
        query.setParameter("userAccessLevelId", userAccessLevelId);
        com.basehr.app.shared.aaaboundedcontext.authentication.UserAccessLevel listOfUserAccessLevel = (com.basehr.app.shared.aaaboundedcontext.authentication.UserAccessLevel) query.getSingleResult();
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserAccessLevelRepositoryImpl", "findById", "Total Records Fetched = " + listOfUserAccessLevel);
        return listOfUserAccessLevel;
    }
}
