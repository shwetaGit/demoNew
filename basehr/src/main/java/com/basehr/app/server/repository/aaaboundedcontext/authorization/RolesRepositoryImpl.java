package com.basehr.app.server.repository.aaaboundedcontext.authorization;
import com.basehr.app.server.repository.core.SearchInterfaceImpl;
import com.basehr.app.shared.aaaboundedcontext.authorization.Roles;
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
import com.basehr.app.shared.aaaboundedcontext.authorization.RoleMenuBridge;

@Repository
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for Roles Transaction table", complexity = Complexity.MEDIUM)
public class RolesRepositoryImpl extends SearchInterfaceImpl implements RolesRepository<Roles> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(System.getProperty("LOGGER_ID"));

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<Roles> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.basehr.app.shared.aaaboundedcontext.authorization.Roles> query = emanager.createQuery("select u from Roles u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "RolesRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public Roles save(Roles entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "RolesRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<Roles> save(List<Roles> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.basehr.app.shared.aaaboundedcontext.authorization.Roles obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "RolesRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.basehr.app.shared.aaaboundedcontext.authorization.Roles s = emanager.find(com.basehr.app.shared.aaaboundedcontext.authorization.Roles.class, id);
        emanager.remove(s);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "RolesRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void deleteRoleMenuBridge(List<RoleMenuBridge> rolemenubridge) {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (com.basehr.app.shared.aaaboundedcontext.authorization.RoleMenuBridge _rolemenubridge : rolemenubridge) {
            com.basehr.app.shared.aaaboundedcontext.authorization.RoleMenuBridge s = emanager.find(com.basehr.app.shared.aaaboundedcontext.authorization.RoleMenuBridge.class, _rolemenubridge.getRoleMenuMapId());
            emanager.remove(s);
        }
    }

    @Override
    @Transactional
    public void update(Roles entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "RolesRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<Roles> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.basehr.app.shared.aaaboundedcontext.authorization.Roles obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "RolesRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public Roles findById(String roleId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("Roles.findById");
        query.setParameter("roleId", roleId);
        com.basehr.app.shared.aaaboundedcontext.authorization.Roles listOfRoles = (com.basehr.app.shared.aaaboundedcontext.authorization.Roles) query.getSingleResult();
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "RolesRepositoryImpl", "findById", "Total Records Fetched = " + listOfRoles);
        return listOfRoles;
    }
}
