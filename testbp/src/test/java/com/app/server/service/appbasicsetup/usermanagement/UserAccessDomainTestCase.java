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
        useraccessdomain.setDomainHelp("aQX5xsCuQjvOTklJytnWtUOIrNZTmUvSFOjzLGwWZBuHyM3ssx");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainName("PX3mWE5493N68Wi1KPGpa79ohCZKWksR1UEuWE1Kwc7TKU0V5p");
        useraccessdomain.setDomainDescription("NtiBx22msTSvtkmx8xBQqb9K8li77utCuEko08G3TwN9UvU5Cf");
        useraccessdomain.setDomainIcon("G0O0N2im0vyIXsN63U56Im8190RKr5OZ4SISXVhGhSrzDOCOhD");
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
            useraccessdomain.setDomainHelp("vsplNeM6LuSvCM1anNtF2BDuDAKIVKKBU4qHK7hOCtXx9wdKE9");
            useraccessdomain.setUserAccessDomain(28374);
            useraccessdomain.setDomainName("jUEQw3NUB19Cq85mFgiHFkE7kKW7BHA9KdfcikBVCMZuy1POgn");
            useraccessdomain.setDomainDescription("zXwVRmfoVz3vDYjkG8XNArMIzKg3U1kn5prFfwwVdXthkSPfmT");
            useraccessdomain.setDomainIcon("QNr4tWmaiqlKzbsanf9HhMsRsviM3HJgoLfQmvf3X7iWrwMeZX");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 163655));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "ZaItdrM5wN78S9xDPNW0OLvviBszm9Vo6iLFUDXQC7YJ6VnEDs2S64cYp91P2Uz3B8IU4VBev8IoRowzeXNGBRWVDwJ9W1tWjotjSzhAfFkvbw0snJtB4mSSthjgs385D2Syuq3HwFRHoGE5NL1sCjrN3BDwDS4QlHFei2HhJUF0wSIsJDg9waQSQhiYfeNDSx7ep7aZR1w8eTT3OQIrw9l9muv0l6GeNfhVeO8IYTUWo01Kb4JEDie8zUgDWBJpF"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "gjgtlX2pOL7otsJAwCjhaNNPxuRUtudRSk2RAnFHak6umXhcrLwax1Adrj75M8FdEImyi9VLmwyLFK5QDIS4vV7rfc7EZ7L8Q6xNCQcEBKTrrptg0Vrz1cCievSB0voRT308OuvyVi6hfeoJryDmFoj1bcsW8BKj92hUu9vqt9l8dTcJb9xHr9Yle3Sh3lEdiSrcVHCzCMpTlHQayeSuSttkb9ZCnXQh2voUIgL6EKTTxv4tlHbnJ0XBofUlBBTGs"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "tFcuuDmz7UT2M48psSJDl3dlISvM7eC5C41ylwtHv9Uh091yreDrc1EYKY4NE9KUOrRuznLlN8PpbDTiNvqYE0yhdhiaCfZLYeUCQxaCrRSHNiZkXZdGZmrzsVH5hCu45lF7VXmng3Mu6DYlKm7phKYwOOgmZD3if6MuCcwyOMv48Lz2PQpv8I4Gnw0X0qsqaSFP5XzWoRrJzQwNQXEN7IH3Mm1FiAMc7NVSo9MO3V0G7obkGYMu1IcsvOd0LiCBF"));
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
