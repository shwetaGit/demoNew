package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.UserRoleBridgeRepository;
import com.app.shared.authorization.UserRoleBridge;
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
import com.app.shared.authorization.Roles;
import com.app.server.repository.RolesRepository;
import com.app.shared.authentication.User;
import com.app.server.repository.UserRepository;
import com.app.shared.authentication.UserAccessDomain;
import com.app.server.repository.UserAccessDomainRepository;
import com.app.shared.authentication.UserAccessLevel;
import com.app.server.repository.UserAccessLevelRepository;
import com.app.shared.authentication.PassRecovery;
import com.app.shared.authentication.Question;
import com.app.server.repository.QuestionRepository;
import com.app.shared.authentication.UserData;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class UserRoleBridgeTestCase {

    @Autowired
    private UserRoleBridgeRepository<UserRoleBridge> userrolebridgeRepository;

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
            Roles roles = new Roles();
            roles.setRoleDescription("nMgLqsNd39wfGsWEkn4AWlJsybvbFmVd7jcNzkOv3OkztQ0mtX");
            roles.setRoleHelp("wacH0d2F5iUmhgkbmi1kX8zifwuxaHR5OFjCg7qP1HPJ6EyVWJ");
            roles.setRoleIcon("mirroCDUASj5K6ZwXW5vEi3CXJEuZ1c5ttIAKxcK756eUJe1Em");
            roles.setRoleName("zK4Khtp4vi5Iw5sg9zXqBeAmjc59b8CKIHyEHPAFXeCPb5GfM9");
            Roles RolesTest = rolesRepository.save(roles);
            map.put("RolesPrimaryKey", roles._getPrimarykey());
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(1456478448769l));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("pwVCR0WhElnFvAj9GXXfPPlveVynbaVS43aLNrO8Ddlr83BtQy");
            user.setPasswordExpiryDate(new java.sql.Timestamp(1456478448769l));
            user.setSessionTimeout(3061);
            user.setUserAccessCode(7524);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("ZUhPC17sqBvVqxgY5UdzrmRcL3dBGPMgb136G2wyMnCEIgKnaz");
            useraccessdomain.setDomainHelp("OSBO2x1cyQzS0gnJu8UYEsu9LnR6ETAlF21Buasc5fjtQk0Fc8");
            useraccessdomain.setDomainIcon("wt6jPZzTzEjZPuUDLjXQzVzVcD3VxTv6MO7BXgMSpPLkIHOEiS");
            useraccessdomain.setDomainName("o4HHrutoCNP9ASiVP9DSxqxlqHvzdOB3o17njJGiPkLlNQpEZm");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("AwauiLNkHGzYWEXrvZFi6WwgIbFDKUjhqCtHW0rwOoDCxUBXU5");
            useraccesslevel.setLevelHelp("Mnh0oUelKLBHkkPS3gXlOKbg0A0OVnY2Wbap6158us6TJxotHP");
            useraccesslevel.setLevelIcon("p35qfYYT9CSW4p6Qd3uW4E4tM34mMhZ5fclPNapVMfLRZwWSWi");
            useraccesslevel.setLevelName("OFN9dgKmxs8Mhk4vwaUkYMN64eGm0PpCdvj77FkoLztWupiR2z");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(1456478448779l));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("fUbsPIPvcfccrf12vgaGnHhu3h2Fi6UQFncHVsGmxMzV0GRCRW");
            user.setPasswordExpiryDate(new java.sql.Timestamp(1456478448779l));
            user.setSessionTimeout(1337);
            user.setUserAccessCode(4165);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("vavkFwhORBhsQWMjT0eUINHJ0zEExTeuDYAXBQHkNZyhjmm7LF");
            Question question = new Question();
            question.setLevelid(5);
            question.setQuestion("SktVeZ6gG6hzEnKNzCfP7xwc7MV2QOMvo1vvHLafTUXKGUpL9k");
            question.setQuestionDetails("g");
            question.setQuestionIcon("ODKPYUbhnoGmbnNg2DtBdmTWILfNAzbJ0NJtnUGBOqv8RcjHEz");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("juKIx3UNP1Ae5UXhcXxZ3ZbbHGu7xCIsKeX1yYbiGbOMpPa7eO");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
            passrecovery.setUser(user);
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setLast5Passwords("brPbQ4meKB4WezIUyhilw34vULwFiyAepZ1QmOGeATgsxx04dh");
            userdata.setOneTimePassword("oG0FopjuclHALlZ2FOkRfEvMJHdXvyrH");
            userdata.setOneTimePasswordExpiry(6);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1456478449012l));
            userdata.setPassword("CZx5KT4pRU2KLZI6EV3ze3BZmPv9qowD05P7JeTmlCecV9g1ky");
            userdata.setLast5Passwords("SMutSqfUdYc5Up9qpnOHUcYraVWQnYdUOPpyGnIy2jf2fp4BYr");
            userdata.setOneTimePassword("9sxugl5n1513rXH7AhiGxxLZf2drh40I");
            userdata.setOneTimePasswordExpiry(11);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1456478449019l));
            userdata.setPassword("7V74lwiwWiR8ln6EEoA2z5pSp4PRaLMwZhM60wlW7I3QoOUqpL");
            userdata.setUser(user);
            user.setUserData(userdata);
            User UserTest = userRepository.save(user);
            map.put("UserPrimaryKey", user._getPrimarykey());
            UserRoleBridge userrolebridge = new UserRoleBridge();
            userrolebridge.setRoleId((java.lang.String) RolesTest._getPrimarykey()); /* ******Adding refrenced table data */
            userrolebridge.setUserId((java.lang.String) UserTest._getPrimarykey());
            userrolebridge.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            userrolebridge.setEntityValidator(entityValidator);
            userrolebridge.isValid();
            userrolebridgeRepository.save(userrolebridge);
            map.put("UserRoleBridgePrimaryKey", userrolebridge._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private RolesRepository<Roles> rolesRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserRoleBridgePrimaryKey"));
            UserRoleBridge userrolebridge = userrolebridgeRepository.findById((java.lang.String) map.get("UserRoleBridgePrimaryKey"));
            userrolebridge.setVersionId(1);
            userrolebridge.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            userrolebridgeRepository.update(userrolebridge);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByroleId() {
        try {
            java.util.List<UserRoleBridge> listofroleId = userrolebridgeRepository.findByRoleId((java.lang.String) map.get("RolesPrimaryKey"));
            if (listofroleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserRoleBridgePrimaryKey"));
            userrolebridgeRepository.findById((java.lang.String) map.get("UserRoleBridgePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByuserId() {
        try {
            java.util.List<UserRoleBridge> listofuserId = userrolebridgeRepository.findByUserId((java.lang.String) map.get("UserPrimaryKey"));
            if (listofuserId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserRoleBridgePrimaryKey"));
            userrolebridgeRepository.delete((java.lang.String) map.get("UserRoleBridgePrimaryKey")); /* Deleting refrenced data */
            userRepository.delete((java.lang.String) map.get("UserPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
