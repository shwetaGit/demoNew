package com.app.server.service.appinsight.health;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appinsight.health.TestAaRepository;
import com.app.shared.appinsight.health.TestAa;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.app.server.service.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.springframework.mock.web.MockServletContext;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.server.pluggable.interfaces.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class TestAaTestCase extends EntityTestCriteria {

    @Autowired
    private TestAaRepository<TestAa> testaaRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        MockServletContext mockServletContext = new MockServletContext("file:src/main/webapp");
        try {
            String _path = mockServletContext.getRealPath("/WEB-INF/conf/");
            LogManagerFactory.createLogManager(_path, AppLoggerConstant.LOGGER_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
        runtimeLogInfoHelper.createRuntimeLogUserInfo("customer", "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
        runtimeLogInfoHelper.setRequestHeaderBean(new RequestHeaderBean(new RuntimeLogUserInfoBean("AAAA", "AAAA", request.getRemoteHost(), 0, 0, 0), "", methodCallStack.getRequestId()));
    }

    private TestAa createTestAa(Boolean isSave) throws Exception {
        TestAa testaa = new TestAa();
        testaa.setTno(2147483647);
        testaa.setTnm("yqhJCtgT38eheOq40fgNzLgCX2QKkOGXAw4zf8pBDDplZczwWT");
        testaa.setEntityValidator(entityValidator);
        return testaa;
    }

    @Test
    public void test1Save() {
        try {
            TestAa testaa = createTestAa(true);
            testaa.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            testaa.isValid();
            testaaRepository.save(testaa);
            map.put("TestAaPrimaryKey", testaa._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestAaPrimaryKey"));
            TestAa testaa = testaaRepository.findById((java.lang.String) map.get("TestAaPrimaryKey"));
            testaa.setVersionId(1);
            testaa.setTno(2147483647);
            testaa.setTnm("x2r8fmM9i7GCFcAKTdSxKajkA8oOsprD96XpQL9BwTxkXPt7kG");
            testaa.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            testaaRepository.update(testaa);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestAaPrimaryKey"));
            testaaRepository.findById((java.lang.String) map.get("TestAaPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestAaPrimaryKey"));
            testaaRepository.delete((java.lang.String) map.get("TestAaPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateTestAa(EntityTestCriteria contraints, TestAa testaa) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            testaa.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            testaa.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            testaa.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            testaaRepository.save(testaa);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "tnm", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "tnm", "6uAQtl5mvnfAyjIIWgYkOLW7vvEWfqL77pgOugpmmcET64ltpld7ypxWj7UavXky0Ts6Rf30WxZJstncKfFH2anTBeOyoZR4l8mMynGRvZ730Srsu3eoBafrbbMo7s2vHRujjhvTDEjL5PUy61YV0is9JMKCpeXZnEDNGDw1aaetbRuxYHeICPeMDA7MDnYl3Pi9uJkEwayVchkkmGEvzbEtlbY6bd9VD5cocxYRE81nIz71s4MkAIbP7JwMKSOt2"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "tno", null));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                TestAa testaa = createTestAa(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = testaa.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(testaa, null);
                        validateTestAa(contraints, testaa);
                        failureCount++;
                        break;
                    case 2:
                        testaa.setTnm(contraints.getNegativeValue().toString());
                        validateTestAa(contraints, testaa);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(testaa, null);
                        validateTestAa(contraints, testaa);
                        failureCount++;
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
