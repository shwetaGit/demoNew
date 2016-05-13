package com.app.server.repository.appinsight.health;
import com.app.server.repository.core.SearchInterfaceImpl;
import com.app.shared.appinsight.health.TestAa;
import org.springframework.stereotype.Repository;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.helper.ResourceFactoryManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.spartan.pluggable.logger.alarms.AppAlarm;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import java.lang.Override;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Repository
@SourceCodeAuthorClass(createdBy = "shweta.zagade@algorhythm.co.in", updatedBy = "", versionNumber = "1", comments = "Repository for TestAa Master table Entity", complexity = Complexity.LOW)
public class TestAaRepositoryImpl extends SearchInterfaceImpl implements TestAaRepository<TestAa> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<TestAa> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.app.shared.appinsight.health.TestAa> query = emanager.createQuery("select u from TestAa u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("AISHI324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "TestAaRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public TestAa save(TestAa entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("AISHI322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "TestAaRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<TestAa> save(List<TestAa> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.appinsight.health.TestAa obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("AISHI322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "TestAaRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.app.shared.appinsight.health.TestAa s = emanager.find(com.app.shared.appinsight.health.TestAa.class, id);
        emanager.remove(s);
        Log.out.println("AISHI328100200", runtimeLogInfoHelper.getRequestHeaderBean(), "TestAaRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(TestAa entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("AISHI321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "TestAaRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<TestAa> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.appinsight.health.TestAa obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("AISHI321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "TestAaRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public TestAa findById(String tid) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("TestAa.findById");
        query.setParameter("tid", tid);
        com.app.shared.appinsight.health.TestAa listOfTestAa = (com.app.shared.appinsight.health.TestAa) query.getSingleResult();
        Log.out.println("AISHI324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "TestAaRepositoryImpl", "findById", "Total Records Fetched = " + listOfTestAa);
        return listOfTestAa;
    }
}
