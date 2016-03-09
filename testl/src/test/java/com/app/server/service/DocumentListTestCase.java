package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.DocumentListRepository;
import com.app.shared.documentmanager.DocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.documentmanager.DocumentType;
import com.app.server.repository.DocumentTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class DocumentListTestCase {

    @Autowired
    private DocumentListRepository<DocumentList> documentlistRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            DocumentType documenttype = new DocumentType();
            documenttype.setDocTypeDesc("ukpuZu3UlmpsFqCh4rLwfM0JW9kq8qUn7iCLoBWqRHw9J2CwF5");
            documenttype.setDocTypeName("SX6fXGDqf04cWWdrQGLZrutrmowcmcZesSucKsVGBvfuNjJNeN");
            DocumentType DocumentTypeTest = documenttypeRepository.save(documenttype);
            map.put("DocumentTypePrimaryKey", documenttype._getPrimarykey());
            DocumentList documentlist = new DocumentList();
            documentlist.setDocDate(new java.sql.Timestamp(1456488942853l));
            documentlist.setDocDesc("2ircQPQbNs5q0beEAOLpcKvpLGUknX033KlM8QDiDyDTQ7UYEA");
            documentlist.setDocFile("KLkg2KKt7hlnWhRDri8XJuYM0Kr193Ao4XMWuZNzfK6skHn6XP");
            documentlist.setDocName("PkQwZFk69T91usIG1hwZkeAQV16iHVjEA9uMppTP327pdpi7L2");
            documentlist.setDocTypeCode((java.lang.String) DocumentTypeTest._getPrimarykey());
            documentlist.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            documentlist.setEntityValidator(entityValidator);
            documentlist.isValid();
            documentlistRepository.save(documentlist);
            map.put("DocumentListPrimaryKey", documentlist._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private DocumentTypeRepository<DocumentType> documenttypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("DocumentListPrimaryKey"));
            DocumentList documentlist = documentlistRepository.findById((java.lang.String) map.get("DocumentListPrimaryKey"));
            documentlist.setDocDate(new java.sql.Timestamp(1456488942887l));
            documentlist.setDocDesc("GX3erersZ340CmkBpXxSUokEsQ5qz89sevcbpVyW6GsBlu41z2");
            documentlist.setDocFile("E8lVEiLZ06QnccfxI6kE2LYMD6bGm0au75GZkZH1ggD2Q7GRE5");
            documentlist.setDocName("EBsBJYcRvyTY1nkymgkvuYrflrfXxlZfNzx2A0eNJUeRNGQ5Mh");
            documentlist.setVersionId(1);
            documentlist.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            documentlistRepository.update(documentlist);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("DocumentListPrimaryKey"));
            documentlistRepository.findById((java.lang.String) map.get("DocumentListPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBydocTypeCode() {
        try {
            java.util.List<DocumentList> listofdocTypeCode = documentlistRepository.findByDocTypeCode((java.lang.String) map.get("DocumentTypePrimaryKey"));
            if (listofdocTypeCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("DocumentListPrimaryKey"));
            documentlistRepository.delete((java.lang.String) map.get("DocumentListPrimaryKey")); /* Deleting refrenced data */
            documenttypeRepository.delete((java.lang.String) map.get("DocumentTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
