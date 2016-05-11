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
        useraccessdomain.setUserAccessDomainId("xPWocSDL0JdaEugiXtgbnz20UhpZLzAWHd3Dvzjwr50GdU23oN");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainName("jkRhKizf29CFqPCj1rELoDwN0BaD7caBmERT3nmQWBCYxTnnDU");
        useraccessdomain.setDomainHelp("TJrleM3acPV22e0QQ4VwzoueyWzljlpAufe721yXpib7WteOgq");
        useraccessdomain.setDomainIcon("8z5pUZYSw1HJQ0xTiNAkkfEfjeHisxjVhkKuh7wg1TebpmGn9n");
        useraccessdomain.setDomainDescription("JZlXZlRMZ5BJbi8jcO4BOIlCsoCYto9f7pI0eCrpgC0hW8TuXa");
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
            useraccessdomain.setUserAccessDomain(90340);
            useraccessdomain.setDomainName("aTW2e4AdRfyTm53SQiey7P9DNiDTE9vRzuZwp6RqlKQeg1jt61");
            useraccessdomain.setDomainHelp("FwASQwEdQBicNRFarmZEYVSqxfmTRDwgh9LeGiuFPly5TjrKGR");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainIcon("l0qMsLHRusQAiMa3ctrCZrCpl6sZn2o3IA1lZ4jtnBaXqbo0R7");
            useraccessdomain.setDomainDescription("WyZuA932FApVV0DCi4hEj5Zw26hdtg6Y4SaNRwLwqVTZ3wlE8M");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 105810));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "gU4ZqKe0f1hm3C5m872HuUysjkzIeROVwykTFXpv6SbhXbU2fyeCSNNG3JZ5exForojkaCEX71rJ6h8aefc93JATHlB1jF2uFDTJNxVc5QRqZFuZsWdgNunvnvP9T3O9OQn6w9Bb7U95qzTRV6lS0aicb6ffntzU0e7FCWXqUnJABokvyTxINAoCdDa1QuCWu8m5dMWDSeW1HODsFMRYPWhjzjkcMGWD6YmCDPlMJ3yVneTQZPnmA1pKTmLexAFp6"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "qTQN9YYCx3tq43EReRN5nJCtuBOLLiPDtoqp64kcpRNdgM2ZKsoz2eCr4YjCjecQYbluKPfsAGZLod7cMshty8MELOD3Kaw9OAbAtfzNH3E9eQAzbxOhyFsyiQGqmlNFn7ijpYMbVY66Mw6jkHhLGbItfgst1aWVuMVBgGlBFVchOgOxYGZDh3BataULDEuwxTxgm4ZWU4BAsJypEVdmRwcQrucqC79fEAk53cpQFLtvUeotEJBKI8cbC460OIyeM"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "JzIFpOYudRg2FbJtePTKFrGrGucAEMRAbBz8POpKL4KS6BEArUHz996nghdXfsNE70Lw8FfmXsHAcqXdhvTOvR7OWnkeOWXws2MaZoamiOZrIe1AyUg6mkH6l0eVFyUhi4TUUfWiEIncJEsbM23y1CmjzUXqIbrXHSS7eQgNJCNdH3ZBDxI2YpgrKR4uvqZZsirGJssz5MaMkQC0jdZTjUAfpNHw2oXdNsIyLxnfZrSLTZqKYPG0RspjHjimF8uAt"));
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
