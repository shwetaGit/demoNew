package com.basehr.app.server.repository.aaaboundedcontext.authorization;
import com.basehr.app.server.repository.core.SearchInterfaceImpl;
import com.basehr.app.shared.aaaboundedcontext.authorization.UserRoleBridge;
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
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for UserRoleBridge Transaction table", complexity = Complexity.MEDIUM)
public class UserRoleBridgeRepositoryImpl extends SearchInterfaceImpl implements UserRoleBridgeRepository<UserRoleBridge> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(System.getProperty("LOGGER_ID"));

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<UserRoleBridge> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.basehr.app.shared.aaaboundedcontext.authorization.UserRoleBridge> query = emanager.createQuery("select u from UserRoleBridge u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserRoleBridgeRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public UserRoleBridge save(UserRoleBridge entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserRoleBridgeRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<UserRoleBridge> save(List<UserRoleBridge> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.basehr.app.shared.aaaboundedcontext.authorization.UserRoleBridge obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserRoleBridgeRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.basehr.app.shared.aaaboundedcontext.authorization.UserRoleBridge s = emanager.find(com.basehr.app.shared.aaaboundedcontext.authorization.UserRoleBridge.class, id);
        emanager.remove(s);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserRoleBridgeRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(UserRoleBridge entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserRoleBridgeRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<UserRoleBridge> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.basehr.app.shared.aaaboundedcontext.authorization.UserRoleBridge obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserRoleBridgeRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public List<UserRoleBridge> findByRoleId(String roleId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("UserRoleBridge.findByRoleId");
        query.setParameter("roleId", roleId);
        java.util.List<com.basehr.app.shared.aaaboundedcontext.authorization.UserRoleBridge> listOfUserRoleBridge = query.getResultList();
        Log.out.println("ABSAU324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "UserRoleBridgeRepositoryImpl", "findByRoleId", "Total Records Fetched = " + listOfUserRoleBridge.size());
        return listOfUserRoleBridge;
    }

    @Transactional
    public List<UserRoleBridge> findByUserId(String userId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("UserRoleBridge.findByUserId");
        query.setParameter("userId", userId);
        java.util.List<com.basehr.app.shared.aaaboundedcontext.authorization.UserRoleBridge> listOfUserRoleBridge = query.getResultList();
        Log.out.println("ABSAU324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "UserRoleBridgeRepositoryImpl", "findByUserId", "Total Records Fetched = " + listOfUserRoleBridge.size());
        return listOfUserRoleBridge;
    }

    @Transactional
    public UserRoleBridge findById(String roleUserMapId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("UserRoleBridge.findById");
        query.setParameter("roleUserMapId", roleUserMapId);
        com.basehr.app.shared.aaaboundedcontext.authorization.UserRoleBridge listOfUserRoleBridge = (com.basehr.app.shared.aaaboundedcontext.authorization.UserRoleBridge) query.getSingleResult();
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserRoleBridgeRepositoryImpl", "findById", "Total Records Fetched = " + listOfUserRoleBridge);
        return listOfUserRoleBridge;
    }
}
