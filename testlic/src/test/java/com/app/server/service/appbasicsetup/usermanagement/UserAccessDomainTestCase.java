package com.app.server.service.appbasicsetup.usermanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessDomainRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessDomain;
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

    private UserAccessDomain createUserAccessDomain(Boolean isSave) throws Exception {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainName("l82RCKGvhPFxTutKhEYt9dGaPn9JkzQaBpIx5IxY1ynsEcDO7c");
        useraccessdomain.setDomainHelp("ZYsIfy1BqkDtDdwbA5spFZQmnO4M2vFMUBnur17e4nAxeLb6hk");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainIcon("2QTYUcKvqaGFnVwaD2cgZtcXgJWp0JJGAKFfIAeuRFpcVdykUH");
        useraccessdomain.setDomainDescription("yXco6yhW7NR43XrzkPSdmBuerjPz08p6XuiufG8GFFvBk46Y4J");
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
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainName("EdhqEU2Nz4TDzCYMPNjigfCAUGhRx1IFxPcWjYmO6qaPNUpr4q");
            useraccessdomain.setDomainHelp("otXhCGoe7drR2aVRfaxXr876cWTbF6ltXfuZGmrVEpJaRsUZz5");
            useraccessdomain.setUserAccessDomain(80372);
            useraccessdomain.setDomainIcon("9qsIS0kS303eKmJSUheOoIx5zreXD9fVO75rWE9Y6c0CoRYQOX");
            useraccessdomain.setDomainDescription("uinaVULbwqI9kGJq2dKRd1eB7jxQadaaJBMhN2oXrAJxdCF6e0");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 101005));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "ppdArk6eZBfRGzqgQF8G4uaVq9fB8hA6P9haJRmp12Kd0p3RrO2EJN3xkFJjvvGEATFFX11ufzGwvvp2xYyjNnCniD1vfjTjGL1XqeT2LspHJg2OGPPKypzRziMVs7NBeJhC3f3BwM9AcJ65B5w9iMjrbdHYxECwO751qYCzoSWHbtBOFeG57hG4Z8ozlrNrKTefynimVgrm53ax0sHonZp1ge4029Kn16ZRqric6ptwhXlsQzKeI5XQCzXxF98v7"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "KAVJQkzxTwcP1EaLDjY0EFB9sZVBOgiKUdlfKDsK0KxmGNJt1KP3cochxKvq9XLRKVrgw9jvHsjLKEqPzFOLQ4Iw5uyL5K4yQCh8FvwXyeQKquY3e6ZxvyojuoivNjOJdFbNQY5mUjUkv77z0maO2g21Aqt2G7HpRjM022LiZeNyfGhUgBVmLaGEt1QPrwpqZQC4dvZcXX7FRe2AuOu0bKvLP0GLlSGmE1u5AAjcwjD1pYdTSY1y4vIXWsX4nHFgi"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "VgLknv0PGG6AQxQCm8q91lRjfawFLIadFgljIedipt72LL05Hn6w7fKJZWRTkg50RJNgbcbRthTpp7SzclGcIlSiYFhFXfBRH20nCBi1rfrkx5MNc9P9u3F77cHbqT63BUW6JmRn0sB69iQ2rhEwwIzDyY1Z3o4EfzsxZvaJG2rqzj2NDNe7sUdvTwYPXEDffWZduQswyqsYaicJFw4UoRvQduhekc71BqmYGY7BcPatn8ao4Zd1hwmS3zvuR4iiW"));
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
