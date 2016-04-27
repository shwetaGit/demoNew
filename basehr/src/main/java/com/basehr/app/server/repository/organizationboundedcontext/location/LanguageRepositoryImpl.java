package com.basehr.app.server.repository.organizationboundedcontext.location;
import com.basehr.app.server.repository.core.SearchInterfaceImpl;
import com.basehr.app.shared.organizationboundedcontext.location.Language;
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
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for Language Master table Entity", complexity = Complexity.LOW)
public class LanguageRepositoryImpl extends SearchInterfaceImpl implements LanguageRepository<Language> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(System.getProperty("LOGGER_ID"));

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<Language> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.basehr.app.shared.organizationboundedcontext.location.Language> query = emanager.createQuery("select u from Language u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "LanguageRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public Language save(Language entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "LanguageRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<Language> save(List<Language> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.basehr.app.shared.organizationboundedcontext.location.Language obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "LanguageRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.basehr.app.shared.organizationboundedcontext.location.Language s = emanager.find(com.basehr.app.shared.organizationboundedcontext.location.Language.class, id);
        emanager.remove(s);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "LanguageRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(Language entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "LanguageRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<Language> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.basehr.app.shared.organizationboundedcontext.location.Language obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "LanguageRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public Language findById(String languageId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("Language.findById");
        query.setParameter("languageId", languageId);
        com.basehr.app.shared.organizationboundedcontext.location.Language listOfLanguage = (com.basehr.app.shared.organizationboundedcontext.location.Language) query.getSingleResult();
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "LanguageRepositoryImpl", "findById", "Total Records Fetched = " + listOfLanguage);
        return listOfLanguage;
    }
}
