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
import com.basehr.app.server.repository.aaaboundedcontext.authentication.PasswordPolicyRepository;
import com.basehr.app.shared.aaaboundedcontext.authentication.PasswordPolicy;
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
public class PasswordPolicyTestCase extends EntityTestCriteria {

    @Autowired
    private PasswordPolicyRepository<PasswordPolicy> passwordpolicyRepository;

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

    private PasswordPolicy createPasswordPolicy(Boolean isSave) throws Exception {
        PasswordPolicy passwordpolicy = new PasswordPolicy();
        passwordpolicy.setMinNumericValues(1);
        passwordpolicy.setMinPwdLength(6);
        passwordpolicy.setPolicyDescription("WK7Ql19pGmo6JWRd14vh2BcBhPIDBJ62WuoG2OOcI6ITe1WShl");
        passwordpolicy.setMaxPwdLength(2);
        passwordpolicy.setMinSmallLetters(8);
        passwordpolicy.setMinSpecialLetters(8);
        passwordpolicy.setAllowedSpecialLetters("wNesL5j1lnDqsN6RYWWzPpYSKGfbjZd7QFTqo7kDOjfDDcEKTS");
        passwordpolicy.setPolicyName("4FJbkqlKctRuZa6MWGCTaw2911JGsJkO7tPD0BB03cO0w9d61z");
        passwordpolicy.setMinCapitalLetters(7);
        passwordpolicy.setEntityValidator(entityValidator);
        return passwordpolicy;
    }

    @Test
    public void test1Save() {
        try {
            PasswordPolicy passwordpolicy = createPasswordPolicy(true);
            passwordpolicy.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            passwordpolicy.isValid();
            passwordpolicyRepository.save(passwordpolicy);
            map.put("PasswordPolicyPrimaryKey", passwordpolicy._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("PasswordPolicyPrimaryKey"));
            PasswordPolicy passwordpolicy = passwordpolicyRepository.findById((java.lang.String) map.get("PasswordPolicyPrimaryKey"));
            passwordpolicy.setMinNumericValues(4);
            passwordpolicy.setMinPwdLength(9);
            passwordpolicy.setVersionId(1);
            passwordpolicy.setPolicyDescription("l8D8cJhbYJCGhs9FSgKvjOraikYtkDAaJ9Y5kkJMozZUE6M0Dj");
            passwordpolicy.setMaxPwdLength(14);
            passwordpolicy.setMinSmallLetters(4);
            passwordpolicy.setMinSpecialLetters(1);
            passwordpolicy.setAllowedSpecialLetters("3SbJCpj2TwGOIynUtpVNwQz7urUc2AavxYHxyWRAkL3G4bVKcm");
            passwordpolicy.setPolicyName("EjHPz45gKpAUO5MRgemuIBzl0f6M45mUGENEEQgLa5erRpZ3As");
            passwordpolicy.setMinCapitalLetters(6);
            passwordpolicy.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            passwordpolicyRepository.update(passwordpolicy);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("PasswordPolicyPrimaryKey"));
            passwordpolicyRepository.findById((java.lang.String) map.get("PasswordPolicyPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("PasswordPolicyPrimaryKey"));
            passwordpolicyRepository.delete((java.lang.String) map.get("PasswordPolicyPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validatePasswordPolicy(EntityTestCriteria contraints, PasswordPolicy passwordpolicy) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            passwordpolicy.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            passwordpolicy.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            passwordpolicy.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            passwordpolicyRepository.save(passwordpolicy);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "policyName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "policyName", "dGvBkKYZZtzJjNqSQO5vXgnbye7Welyd3UG45Yn9AVLnvl1NHGCSqDio9YY5QX09p5Plc9qSEcfZX1ihqfhHuwcUKcCbjOwfUc1XtjdM213i5hVSCRFyc30bsjuOxAZo7YRuEoE4OEgNN037qYsySHDgiDa6qxLw0f7qwaRtItQc38rGK5vqFAdwE14TYUV7SjA9uq0TvRXLc6dy6XQsepf2ityV8JDswd6QZf6SqX5yqCWM4JlUso4U5OSnxxAyq"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "policyDescription", "GF8GVLfGgyU1BM6kRABXFRoGMtHf3RapJ3P8p4Jk7jvU4rAoKa3vPx7smpqQxiai1ddE7IBmRKPdLGBm07tuE6iOwciCkcYy29tzlsf1T7chCQQ7Di3RHpxshGJbnYL3mnaSoBhEFKigth9qq9Xy3XAzXv4k8rofUNCHw9cvpMpGO1hzlgEBIhneFyzT7yvLHLhsKvxdWnmltqv7OU5TnCgxiPfxTI7A0kHCUg6CwKh5cZFQsBeEB8dlHoNOXyqBR"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "maxPwdLength", 53));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "minPwdLength", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "minPwdLength", 14));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "minCapitalLetters", 17));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "minSmallLetters", 18));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "minNumericValues", 18));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "minSpecialLetters", 18));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "allowedSpecialLetters", "W1bE5xF4ucblHLdE5JaKmnV3jV4NKaPnXeUUvLteRwCWW8BlE7meRhjzg9eVN3YsJotEdVqPN9QI2VYgUEQv0vokbzrraRrZ0R4SbKGTf3DmVW1rPl476PNXWE8OFgDgYofyUiPl9cFke6vkrmjppcuVEy0YpyCWwd8KZbrWl0qDyKtchvnUUv8A1gCseTFSUgsnq6gxPN5PnCkv9rmMdDcZ7zb8AptRAbIB9OzghzuLN2YjB6WGyayELQwbD16UM"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                PasswordPolicy passwordpolicy = createPasswordPolicy(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = passwordpolicy.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(passwordpolicy, null);
                        validatePasswordPolicy(contraints, passwordpolicy);
                        failureCount++;
                        break;
                    case 2:
                        passwordpolicy.setPolicyName(contraints.getNegativeValue().toString());
                        validatePasswordPolicy(contraints, passwordpolicy);
                        failureCount++;
                        break;
                    case 3:
                        passwordpolicy.setPolicyDescription(contraints.getNegativeValue().toString());
                        validatePasswordPolicy(contraints, passwordpolicy);
                        failureCount++;
                        break;
                    case 4:
                        passwordpolicy.setMaxPwdLength(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validatePasswordPolicy(contraints, passwordpolicy);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(passwordpolicy, null);
                        validatePasswordPolicy(contraints, passwordpolicy);
                        failureCount++;
                        break;
                    case 6:
                        passwordpolicy.setMinPwdLength(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validatePasswordPolicy(contraints, passwordpolicy);
                        failureCount++;
                        break;
                    case 7:
                        passwordpolicy.setMinCapitalLetters(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validatePasswordPolicy(contraints, passwordpolicy);
                        failureCount++;
                        break;
                    case 8:
                        passwordpolicy.setMinSmallLetters(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validatePasswordPolicy(contraints, passwordpolicy);
                        failureCount++;
                        break;
                    case 9:
                        passwordpolicy.setMinNumericValues(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validatePasswordPolicy(contraints, passwordpolicy);
                        failureCount++;
                        break;
                    case 10:
                        passwordpolicy.setMinSpecialLetters(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validatePasswordPolicy(contraints, passwordpolicy);
                        failureCount++;
                        break;
                    case 11:
                        passwordpolicy.setAllowedSpecialLetters(contraints.getNegativeValue().toString());
                        validatePasswordPolicy(contraints, passwordpolicy);
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
