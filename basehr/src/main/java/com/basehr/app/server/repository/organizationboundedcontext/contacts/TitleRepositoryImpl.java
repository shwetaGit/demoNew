package com.basehr.app.server.repository.organizationboundedcontext.contacts;
import com.basehr.app.server.repository.core.SearchInterfaceImpl;
import com.basehr.app.shared.organizationboundedcontext.contacts.Title;
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
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for Title Master table Entity", complexity = Complexity.LOW)
public class TitleRepositoryImpl extends SearchInterfaceImpl implements TitleRepository<Title> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(System.getProperty("LOGGER_ID"));

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<Title> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.basehr.app.shared.organizationboundedcontext.contacts.Title> query = emanager.createQuery("select u from Title u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "TitleRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public Title save(Title entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "TitleRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<Title> save(List<Title> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.basehr.app.shared.organizationboundedcontext.contacts.Title obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "TitleRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.basehr.app.shared.organizationboundedcontext.contacts.Title s = emanager.find(com.basehr.app.shared.organizationboundedcontext.contacts.Title.class, id);
        emanager.remove(s);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "TitleRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(Title entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "TitleRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<Title> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.basehr.app.shared.organizationboundedcontext.contacts.Title obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "TitleRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public Title findById(String titleId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("Title.findById");
        query.setParameter("titleId", titleId);
        com.basehr.app.shared.organizationboundedcontext.contacts.Title listOfTitle = (com.basehr.app.shared.organizationboundedcontext.contacts.Title) query.getSingleResult();
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "TitleRepositoryImpl", "findById", "Total Records Fetched = " + listOfTitle);
        return listOfTitle;
    }
}
