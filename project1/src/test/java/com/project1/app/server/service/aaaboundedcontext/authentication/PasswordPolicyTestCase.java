package com.project1.app.server.service.aaaboundedcontext.authentication;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.project1.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.project1.app.server.repository.aaaboundedcontext.authentication.PasswordPolicyRepository;
import com.project1.app.shared.aaaboundedcontext.authentication.PasswordPolicy;
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
public class PasswordPolicyTestCase {

    @Autowired
    private PasswordPolicyRepository<PasswordPolicy> passwordpolicyRepository;

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
            PasswordPolicy passwordpolicy = new PasswordPolicy();
<<<<<<< HEAD
            passwordpolicy.setMinPwdLength(5);
            passwordpolicy.setMinSmallLetters(3);
            passwordpolicy.setMinNumericValues(2);
            passwordpolicy.setPolicyName("V6nzvrFyrcb8ZJ8JuOZ6jZLJSUBONGFWuBad1tsRCogcsMalyD");
            passwordpolicy.setMinCapitalLetters(1);
            passwordpolicy.setAllowedSpecialLetters("oifgJOFyMYlEgmldIGQwMMKjaT02PlNOMe1S2BS2qnzN10slAe");
            passwordpolicy.setPolicyDescription("J2Yn5mlwk7vEctutPnB2rw8WUwSjjLVxnrwG6RiJKY4ZC4klAL");
            passwordpolicy.setMaxPwdLength(2);
            passwordpolicy.setMinSpecialLetters(4);
            passwordpolicy.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            passwordpolicy.setEntityValidator(entityValidator);
            passwordpolicy.isValid();
            passwordpolicyRepository.save(passwordpolicy);
            map.put("PasswordPolicyPrimaryKey", passwordpolicy._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("PasswordPolicyPrimaryKey"));
            PasswordPolicy passwordpolicy = passwordpolicyRepository.findById((java.lang.String) map.get("PasswordPolicyPrimaryKey"));
            passwordpolicy.setMinPwdLength(2);
            passwordpolicy.setMinSmallLetters(1);
            passwordpolicy.setMinNumericValues(11);
            passwordpolicy.setPolicyName("ibH8JSN6VBqVCRmQaKThCsfQ7W153epnRFlSTBEli6mFjatv43");
            passwordpolicy.setVersionId(1);
            passwordpolicy.setMinCapitalLetters(7);
            passwordpolicy.setAllowedSpecialLetters("giwXQEr1lyYY3AsWqJZnlEofOVt83wKPWqJ0zaOXghNVI9nxql");
            passwordpolicy.setPolicyDescription("G91FpQyzZ4pWDtThVxPELIZ4Jdu8FUhd3Sclh3efsjpkBPdrRV");
            passwordpolicy.setMaxPwdLength(6);
            passwordpolicy.setMinSpecialLetters(3);
=======
            passwordpolicy.setPolicyDescription("wK88UOa477KgjjaIaU8o67Nujsx9ymmyjJmxm3MsQxtR8C5IPA");
            passwordpolicy.setMaxPwdLength(18);
            passwordpolicy.setMinPwdLength(8);
            passwordpolicy.setMinNumericValues(9);
            passwordpolicy.setMinSpecialLetters(4);
            passwordpolicy.setPolicyName("6gfiVhK4ZBvo2yxGwAh6I0Q699SnYtFOLNp3hs4AJCXZGujL7V");
            passwordpolicy.setAllowedSpecialLetters("1Q8qy1nebqg2VxnGxrE2yreLxKVJUEZT9fJfjr6Lm39xH6meth");
            passwordpolicy.setMinSmallLetters(3);
            passwordpolicy.setMinCapitalLetters(7);
            passwordpolicy.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            passwordpolicy.setEntityValidator(entityValidator);
            passwordpolicy.isValid();
            passwordpolicyRepository.save(passwordpolicy);
            map.put("PasswordPolicyPrimaryKey", passwordpolicy._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("PasswordPolicyPrimaryKey"));
            PasswordPolicy passwordpolicy = passwordpolicyRepository.findById((java.lang.String) map.get("PasswordPolicyPrimaryKey"));
            passwordpolicy.setPolicyDescription("Tltr8fhF4kBwdkrIcPjHjUcp9weknwUjXKGRF3FGap5SeNqjJf");
            passwordpolicy.setMaxPwdLength(8);
            passwordpolicy.setMinPwdLength(2);
            passwordpolicy.setMinNumericValues(5);
            passwordpolicy.setMinSpecialLetters(9);
            passwordpolicy.setVersionId(1);
            passwordpolicy.setPolicyName("xCsgxTJ5oJR1b7btMCxK9n04BauQFSCC624rn1Z4xPXOwIvW5I");
            passwordpolicy.setAllowedSpecialLetters("xK1bnHzv0erQkAdxUIxvlXHAIT5GH5C7k86bmU8eleNOcMzDOO");
            passwordpolicy.setMinSmallLetters(3);
            passwordpolicy.setMinCapitalLetters(2);
>>>>>>> branch 'master' of https://github.com/applifireAlgo/DefaultRepo.git
            passwordpolicy.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            passwordpolicyRepository.update(passwordpolicy);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("PasswordPolicyPrimaryKey"));
            passwordpolicyRepository.findById((java.lang.String) map.get("PasswordPolicyPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("PasswordPolicyPrimaryKey"));
            passwordpolicyRepository.delete((java.lang.String) map.get("PasswordPolicyPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
