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
        useraccessdomain.setDomainIcon("MJGHbwO9M9WgJffN6UpWauvzdd6wmShu4lo1SycKSJUGgXooQb");
        useraccessdomain.setDomainName("qxDSlFWROSwS5uaCMH11Kz93waNfZlZIzOQRcZkvtaPrm8Zfhi");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("FgmZr2JAPBzrAVopsGbf1buqIqM1hlN8u4JlDtxwaa3GDe9isg");
        useraccessdomain.setDomainDescription("AWfVL4wSuYS1sNdtOUXPScj7W33j0FBxUy6OgGU3964isJ39xZ");
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
            useraccessdomain.setDomainIcon("0XvYXtymIVG0RyCmkrGF654ojYoM7RbH24ojNkme0LMTt4ua5S");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainName("HbjOkffiJmkkteSArSmsJ9s2bWixNv0zFj7qdaue7rTIFcvLKL");
            useraccessdomain.setUserAccessDomain(76618);
            useraccessdomain.setDomainHelp("vE1xi9lvLbaXRCh7sF5ltMwmOjMCxTVNWntNZtA1thBJ6AzWmY");
            useraccessdomain.setDomainDescription("FtINY2G8xwSKXs8YaLgy64NKxiXEzKd6GGHEp1eQ0odyPGUD8f");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 149620));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "s1d3danBRulQervBmfEySwSXZfNnQyKoYYqqqqgJCuaYdZPSlIBxW4cr0mP8zgL9QbQF14iTY5EHULc8FqsLH6OTz9Dll3TWjdf5PFlKjLT1HiiT4LkMtGhAeOFNVevP72x4vAvQfSGurDyDoLb1Dis9kmCsLWabAHSEFvXiH23EGetVH9jCE6i0Rscqzf8mUXMbMQ1caLMdHl2x5cp3QrrZoyp5GWsOSIWYJeFNAtsXvPYrpKdgYzrReEEm6j1GW"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "kGkZ80MoY5u7TjIZZHvMfMfxGjxgHewC90JlsZdc2fpM1CJZpwegQ5ed1PN2wLNairjolhBthrOPH80ZrYzZ42p1kigkp8IYxnCYHesvJxg4sD3FSx6g7LqZJY67RFcZyKUihLc9Wrv4tIV8gf5nADtJU5LZyPf4jFGPc9WYlRdmHCQypN4cQvvXoH2LdggT0Gpt4EDJgI7Mi36Jm4hRei9HTFPTgobn7Vnvln6bd3lVIaCPMfjUuR2pFSPCPKdxt"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "8gG9PzpWeNFHeN4SkOZzl0WCouJ0W6e9iJIhauqxFanzXrsmqSkFbuBb8DltGqu5IDkVi58SG9cthuilFdLVFlT9TRBXd0IQ4HqouIv0l3DQiVOua4S7G14iS3UuJmLBX20H0HPPgmmh5UoH8Kd6AYFn1gFOL8PILkjKcBML7aA2kJVGvGKvePYm65mOImoPPyGcBOzC4PMIxVeCmDtIzUgYSFSn99ixVNNB1RM6HCaBFAZPwvIqcJgzEtJmKl0qP"));
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
