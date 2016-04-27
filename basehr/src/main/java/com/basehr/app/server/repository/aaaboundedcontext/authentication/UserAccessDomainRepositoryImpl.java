package com.basehr.app.server.repository.aaaboundedcontext.authentication;
import com.basehr.app.server.repository.core.SearchInterfaceImpl;
import com.basehr.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
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
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for UserAccessDomain Master table Entity", complexity = Complexity.LOW)
public class UserAccessDomainRepositoryImpl extends SearchInterfaceImpl implements UserAccessDomainRepository<UserAccessDomain> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(System.getProperty("LOGGER_ID"));

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<UserAccessDomain> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.basehr.app.shared.aaaboundedcontext.authentication.UserAccessDomain> query = emanager.createQuery("select u from UserAccessDomain u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserAccessDomainRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public UserAccessDomain save(UserAccessDomain entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserAccessDomainRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<UserAccessDomain> save(List<UserAccessDomain> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.basehr.app.shared.aaaboundedcontext.authentication.UserAccessDomain obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserAccessDomainRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.basehr.app.shared.aaaboundedcontext.authentication.UserAccessDomain s = emanager.find(com.basehr.app.shared.aaaboundedcontext.authentication.UserAccessDomain.class, id);
        emanager.remove(s);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserAccessDomainRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(UserAccessDomain entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserAccessDomainRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<UserAccessDomain> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.basehr.app.shared.aaaboundedcontext.authentication.UserAccessDomain obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserAccessDomainRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public UserAccessDomain findById(String userAccessDomainId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("UserAccessDomain.findById");
        query.setParameter("userAccessDomainId", userAccessDomainId);
        com.basehr.app.shared.aaaboundedcontext.authentication.UserAccessDomain listOfUserAccessDomain = (com.basehr.app.shared.aaaboundedcontext.authentication.UserAccessDomain) query.getSingleResult();
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserAccessDomainRepositoryImpl", "findById", "Total Records Fetched = " + listOfUserAccessDomain);
        return listOfUserAccessDomain;
    }
}
