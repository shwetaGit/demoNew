package com.basehr.app.server.repository.aaaboundedcontext.authentication;
import com.basehr.app.server.repository.core.SearchInterfaceImpl;
import org.springframework.stereotype.Repository;
import com.athena.config.server.helper.ResourceFactoryManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.spartan.server.interfaces.UserInterface;
import com.spartan.server.interfaces.UserRepositoryInterface;
import java.lang.Override;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.spartan.pluggable.logger.alarms.AppAlarm;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.spartan.pluggable.logger.api.LogManager;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.basehr.app.shared.aaaboundedcontext.authentication.User;
import com.basehr.app.shared.aaaboundedcontext.authentication.PassRecovery;

@Repository
public class UserRepositoryImpl extends SearchInterfaceImpl implements UserRepository<User> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    @Transactional
    @Override
    public void update(List<UserInterface> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.spartan.server.interfaces.UserInterface obj = entity.get(i);
            emanager.merge(obj);
        }
    }

    @Override
    @Transactional
    public UserInterface getByUserId(String userId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("User.findById");
        query.setParameter("userId", userId);
        return (com.spartan.server.interfaces.UserInterface) query.getSingleResult();
    }

    private LogManager Log = LogManagerFactory.getInstance(System.getProperty("LOGGER_ID"));

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<User> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.basehr.app.shared.aaaboundedcontext.authentication.User> query = emanager.createQuery("select u from User u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public User save(User entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<User> save(List<User> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.basehr.app.shared.aaaboundedcontext.authentication.User obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.basehr.app.shared.aaaboundedcontext.authentication.User s = emanager.find(com.basehr.app.shared.aaaboundedcontext.authentication.User.class, id);
        emanager.remove(s);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void deletePassRecovery(List<PassRecovery> passrecovery) {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (com.basehr.app.shared.aaaboundedcontext.authentication.PassRecovery _passrecovery : passrecovery) {
            com.basehr.app.shared.aaaboundedcontext.authentication.PassRecovery s = emanager.find(com.basehr.app.shared.aaaboundedcontext.authentication.PassRecovery.class, _passrecovery.getPassRecoveryId());
            emanager.remove(s);
        }
    }

    @Override
    @Transactional
    public void update(User entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserRepositoryImpl", "update", entity);
    }

    @Transactional
    public List<User> findByUserAccessLevelId(String userAccessLevelId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("User.findByUserAccessLevelId");
        query.setParameter("userAccessLevelId", userAccessLevelId);
        java.util.List<com.basehr.app.shared.aaaboundedcontext.authentication.User> listOfUser = query.getResultList();
        Log.out.println("ABSAN324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "UserRepositoryImpl", "findByUserAccessLevelId", "Total Records Fetched = " + listOfUser.size());
        return listOfUser;
    }

    @Transactional
    public List<User> findByUserAccessDomainId(String userAccessDomainId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("User.findByUserAccessDomainId");
        query.setParameter("userAccessDomainId", userAccessDomainId);
        java.util.List<com.basehr.app.shared.aaaboundedcontext.authentication.User> listOfUser = query.getResultList();
        Log.out.println("ABSAN324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "UserRepositoryImpl", "findByUserAccessDomainId", "Total Records Fetched = " + listOfUser.size());
        return listOfUser;
    }

    @Transactional
    public User findById(String userId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("User.findById");
        query.setParameter("userId", userId);
        com.basehr.app.shared.aaaboundedcontext.authentication.User listOfUser = (com.basehr.app.shared.aaaboundedcontext.authentication.User) query.getSingleResult();
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "UserRepositoryImpl", "findById", "Total Records Fetched = " + listOfUser);
        return listOfUser;
    }
}
