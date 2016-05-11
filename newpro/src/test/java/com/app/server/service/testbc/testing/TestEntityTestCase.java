package com.app.server.service.testbc.testing;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.testbc.testing.TestEntityRepository;
import com.app.shared.testbc.testing.TestEntity;
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
public class TestEntityTestCase {

    @Autowired
    private TestEntityRepository<TestEntity> testentityRepository;

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
            TestEntity testentity = new TestEntity();
            testentity.seteType("qkqhsN1xQ7bBI4O0seAKEtYUTUWcp0yLd5dRUgc1cyfJjaJadA");
            testentity.seteTime("m1BmDfYvWdDnuMQoCvz5Pp2QvtoNUeU9tKfU05ZbPEXzjfZoTP");
            testentity.setCardNo("AShjSr8dj5QX4mnNWienHrFQyF81VVurEFOqhtIAXvK3xV9Aba");
            testentity.settDate("Gyoyw5IEWZUT49cXvwH15wP8ubz6hUTIa3Ad8NWC4aGLtBWXwM");
            testentity.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            testentity.setEntityValidator(entityValidator);
            testentity.isValid();
            testentityRepository.save(testentity);
            map.put("TestEntityPrimaryKey", testentity._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestEntityPrimaryKey"));
            TestEntity testentity = testentityRepository.findById((java.lang.String) map.get("TestEntityPrimaryKey"));
            testentity.seteType("EKp2dWpNmqXo6DUFDZV0Dn69r3vcFCymmorEfqysKKwigS20tA");
            testentity.setVersionId(1);
            testentity.seteTime("48UujV8vtjAKYxZh3hmFH0AmMnNBnqkFf9gmWDPSTArfCVZaLz");
            testentity.setCardNo("IJFoMchWSHBKu0e1lHxL9rZOfkIMSSo3rQPdAu8RmdmHcjajCO");
            testentity.settDate("l7iMcBGKcTlLq3dfD4alN3Fv52cFBytedoi7Cq2y4IW9P9LnqG");
            testentity.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            testentityRepository.update(testentity);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestEntityPrimaryKey"));
            testentityRepository.findById((java.lang.String) map.get("TestEntityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestEntityPrimaryKey"));
            testentityRepository.delete((java.lang.String) map.get("TestEntityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
