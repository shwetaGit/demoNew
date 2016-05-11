package com.basehr.app.server.service.aaaboundedcontext.authentication;
import com.basehr.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.basehr.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.basehr.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.basehr.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.basehr.app.server.service.RandomValueGenerator;
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
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class UserAccessDomainTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

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
            String logManagerId = LogManagerFactory.createMultiLogManager(_path + "/");
            LogManager Log = LogManagerFactory.getInstance(logManagerId);
            System.setProperty("LOGGER_ID", logManagerId);
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

    private UserAccessDomain createUserAccessDomain(Boolean isSave) throws Exception {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainIcon("keRQYxY9cr1znRltuCKZe2jV7EiQZUZ2HsqAISlLRjjzM0uF8Y");
        useraccessdomain.setDomainDescription("1GxejaZD7qCBrBDg1tToQ67TNSTa1feDkru6ejEojb2hwe4Ox0");
        useraccessdomain.setDomainName("U03KepeZCZKpeA0HPep3Fvnc9KHRDpmmbfPsrlr7NLu5D9NBSC");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("8GzUw2CVKAp6rG2xlKS0IE0yMhfl6cXH12fZ3IUIlhOfoYise4");
        useraccessdomain.setEntityValidator(entityValidator);
        return useraccessdomain;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessDomain useraccessdomain = createUserAccessDomain(true);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccessdomain.isValid();
            useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            UserAccessDomain useraccessdomain = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
            useraccessdomain.setDomainIcon("a7kbAnxlJrUxSWvngYsfFW8AIhSZV24whwSSr8VlzbBjLvMUWr");
            useraccessdomain.setDomainDescription("umooKPog632K1K5L2uRpJljBw1NGu0WFyit6ykINsXNdLqTgnz");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainName("yf94YokcYoTT0rwKW4R5vvjxzDDUP5440GOhGPGxyrY5QtH1Y8");
            useraccessdomain.setUserAccessDomain(78885);
            useraccessdomain.setDomainHelp("hVQSGWfwjIo4tFe8qU8meXKZmx0zcSVRpBCmyPbN9Q4UnlaUxk");
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccessdomainRepository.update(useraccessdomain);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessDomain(EntityTestCriteria contraints, UserAccessDomain useraccessdomain) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccessdomainRepository.save(useraccessdomain);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessDomain", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 129582));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "ySb96pXO4BH6t7ajyYtNiyIyWp5SgXqOtmmuhAjO1VjeEkKiOPEKpdWwVCnTc2LAWqbhCqgMBVz7KG5uJpGkIS22RMMjiQ8vhiLcVxG3305t6d5bsrpMLNclvV7lMXtzxVZqeo4rOsMN5FQUNTeHvMZDiCWQ1dRuHOtLc4iFuMdpxB3nHu0bRjS7RqklHyque3yLZUSVmtkfHprvOV1MX8iXdVUvSqgxvfBHH3hqXrUkrlWGMqYBIT9EDJ26m6CTQ"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "J6by6vU8tyQQmrmorozAmR2MxHVl8We8BkBgfWGwbbR8FJPDjETMdNLysWeoD0U5t0UnWrQIYJe4QlNfZMr6j7fGiWOzfJFp2LP11YUv3PUnPfYQnqA94Jq1HyACyrnyLrjfCvghZoKlwPP6QOoII4mBo0OLv6OcCjTVtFMVxkduWt2239q9Qlbxkofykj64B6YXwemGryw74Q0zehSqv5RDljN10A5KVshkWqAITFeaEw739WryHReHSO8txnC3X"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "OOwtHpip3zDXyh9KzWArO32knqzMXmMIGjJTpq7Ee8Huuo9uHgRJ0fVAmlTBj8r93NmV3FXvgRkRcrRW5bQbXYu4Lza7gAEOA0H4r1RHKQZyFx1kYhfMSSzBnjkvdszDBOPyPHW4ASmOAhQP9X7UNwialQPE2NwWDSctae2OHzc9JH9wXpPdRJJDMcOpLAIhMCN3G8LFhe39Ly9Fv4bIYY4oPlznIQca9WepY0acHANnbRm9ixnpb0VqeXvpwGuja"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        UserAccessDomain useraccessdomainUnique = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessDomain useraccessdomain = createUserAccessDomain(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccessdomain.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 2:
                        useraccessdomain.setUserAccessDomain(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 4:
                        useraccessdomain.setDomainName(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 6:
                        useraccessdomain.setDomainDescription(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 7:
                        useraccessdomain.setDomainHelp(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 8:
                        useraccessdomain.setDomainIcon(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 9:
                        useraccessdomain.setUserAccessDomain(useraccessdomainUnique.getUserAccessDomain());
                        validateUserAccessDomain(contraints, useraccessdomain);
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
