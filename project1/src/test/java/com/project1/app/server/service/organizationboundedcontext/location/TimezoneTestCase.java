package com.project1.app.server.service.organizationboundedcontext.location;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.project1.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.project1.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.project1.app.shared.organizationboundedcontext.location.Timezone;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class TimezoneTestCase {

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

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
            Timezone timezone = new Timezone();
<<<<<<< HEAD
            timezone.setCountry("OY6U9TwwEL3rNCww7oDXG7FP8EnhGai4pwRFcttPJWWqixAUr7");
            timezone.setCities("T6H4LQE1C9a4PZpYlw5dy9wSRNvOQCDAI72e0Ywy0dAnLIvHYB");
            timezone.setTimeZoneLabel("4mmSkGcqOP3jGpiAJvaa9wmSpKY58XON8QEZMW0BQzXDaQNE7w");
            timezone.setUtcdifference(7);
            timezone.setGmtLabel("yr32gaz1tAc9XanEpYlBFyxL0eA7ugXr5HBeON5jEgUbsdAGHh");
            timezone.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            timezone.setEntityValidator(entityValidator);
            timezone.isValid();
            timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TimezonePrimaryKey"));
            Timezone timezone = timezoneRepository.findById((java.lang.String) map.get("TimezonePrimaryKey"));
            timezone.setCountry("8tzWndfyOGnqtkknSMMfAvPcFIN83xvu9PIEjxsmhs0MOqyGUz");
            timezone.setCities("0SMFRW3LYd0PgObkuMFf490Z9Z7NfU6emaPHSVvzj5X775lzmg");
            timezone.setTimeZoneLabel("LFa2brMnJeq5D0eqD5AymuO6WeNCtBGkjR6QNNY5Cz2SQRXIUL");
            timezone.setVersionId(1);
            timezone.setUtcdifference(3);
            timezone.setGmtLabel("ubAAsRomkVOvOv6l1JBlcPIoWGdMXMHI5MsYfpkp5MLeOCsKek");
=======
            timezone.setUtcdifference(7);
            timezone.setGmtLabel("r3Xcu06p4XzKz80vJlPwXts5aBjd6hzy7l6dW3KeMVIB88QuKW");
            timezone.setTimeZoneLabel("2CsWHnJ4CXwRq20dEiWkVA4yNL9vL7KHjnZh7SDsmd53NJ10cc");
            timezone.setCities("Pn1MCkfgNjE2pMBXCgl2RWdf0YpQOfwNGEgiIQqHdVvnreWMiB");
            timezone.setCountry("P8Tnr2CGwGsk4e2FlSAKmS6RszxmLpXRFQe7d1vkAD5YWO8ghs");
            timezone.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            timezone.setEntityValidator(entityValidator);
            timezone.isValid();
            timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TimezonePrimaryKey"));
            Timezone timezone = timezoneRepository.findById((java.lang.String) map.get("TimezonePrimaryKey"));
            timezone.setUtcdifference(2);
            timezone.setGmtLabel("xO4ezWS7VPsba0wGo1GwUAS5rzHDOKeIx2jyfSNesKPXXeGDM2");
            timezone.setTimeZoneLabel("iUiyxwQujGWRmNbkkYPljG0sJgXrbjWf7woI7WYF8iDNkfStNF");
            timezone.setVersionId(1);
            timezone.setCities("Y8O0zAPAZPqSkbS1JjydP0EmDNUp2BaagxCjfYOmgi6pc1GNmV");
            timezone.setCountry("hHVq0YMHaxrJIyaK4za32btyfggEzEUMCHIn60diXZL8Qret7m");
>>>>>>> branch 'master' of https://github.com/applifireAlgo/DefaultRepo.git
            timezone.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            timezoneRepository.update(timezone);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TimezonePrimaryKey"));
            timezoneRepository.findById((java.lang.String) map.get("TimezonePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TimezonePrimaryKey"));
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}