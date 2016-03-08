package project2.app.server.service.aaaboundedcontext.authorization;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project2.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project2.app.server.repository.aaaboundedcontext.authorization.UserRoleBridgeRepository;
import project2.app.shared.aaaboundedcontext.authorization.UserRoleBridge;
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
import project2.app.shared.aaaboundedcontext.authentication.User;
import project2.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import project2.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import project2.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import project2.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import project2.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import project2.app.shared.aaaboundedcontext.authentication.PassRecovery;
import project2.app.shared.aaaboundedcontext.authentication.Question;
import project2.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import project2.app.shared.aaaboundedcontext.authentication.UserData;
import project2.app.shared.aaaboundedcontext.authorization.Roles;
import project2.app.server.repository.aaaboundedcontext.authorization.RolesRepository;

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
            User user = new User();
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelIcon("2ItIOB1DO4iRkC5AtTQGaQhe6fIhJJRqELSC4ddv05aNAGfk12");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            useraccesslevel.setLevelHelp("urjZG9P5nKjyjIV2OGSDZtVvvljxapzwNzhOlg8S1tCOerK16q");
            useraccesslevel.setLevelDescription("5ts80uICzf2V7HkjsXcm7g2TBmQRfUlDu4zytcIqvD5CcUna5H");
            useraccesslevel.setLevelName("VlaBJF5UlqhqTa6aYM8o6u9XfC4Fa3WWHfskiCBX6egs5ScOn3");
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainIcon("7zynim7OM9baEyF9qfwmr24gV8wABxIpBTqFmjU6j2z8ZCNzIJ");
            useraccessdomain.setDomainDescription("ChI3JZe6sovRMyv61DpZK2rw69Gs1VId4qkEZ8nNZzThkNcMbS");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            useraccessdomain.setDomainHelp("SBxXqsLmabYhCNlB6oGdcjIAlesvvGNTMRajY0Yu0FiAySfsph");
            useraccessdomain.setDomainName("Lsd6G3I2cwoRQSGKw2EpXP7rTadR7NfVVPoZB52BPODJsoNAJl");
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setSessionTimeout(1560);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(1457448014859l));
            user.setPasswordAlgo("JjorckrTWbOdFkiLX4KPmAuNK8eCg7XiMV6sGaW4b9ANvQ4NCG");
            user.setMultiFactorAuthEnabled(1);
            user.setAllowMultipleLogin(1);
            user.setIsDeleted(1);
            user.setChangePasswordNextLogin(1);
            user.setIsLocked(1);
            user.setGenTempOneTimePassword(1);
            user.setUserAccessCode(52489);
            user.setPasswordExpiryDate(new java.sql.Timestamp(1457448014859l));
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            Question question = new Question();
            question.setQuestionIcon("hBvgXJ2YwOfyC6tvlUFma3B9JtjOTEGHzzVIbMaCbB8NtYZWR3");
            question.setQuestionDetails("l");
            question.setLevelid(3);
            question.setQuestion("e9XST7zqWyVTGbcwZgGLvjsMboNysK3ByVkUGPlovfiTA9VOHU");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setUser(user);
            passrecovery.setAnswer("ujI6BVYEUKcAAFmGhiGIYZHi9U9FCK5D1ahnGKwSTf5hb1xGDL");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setOneTimePasswordExpiry(7);
            userdata.setPassword("wEftZCkeiOMHYtjgNgFm316oGRiyFTJnDlbiGELrcSS3jN7iam");
            userdata.setOneTimePasswordExpiry(6);
            userdata.setPassword("78Mi1mQ3wiieXVlL872QRa6O31taMiYs84uKMp4hAU1fxC9raR");
            userdata.setUser(user);
            userdata.setOneTimePassword("NVWOPoQsm4y2sUscrpCyFcB7JG2qThYj");
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1457448015082l));
            userdata.setLast5Passwords("PIU96oje2xdlarMvRIN16FC2u6M3ntjQUsZg6WPPwBbvXqYiaX");
            user.setUserData(userdata);
            User UserTest = userRepository.save(user);
            map.put("UserPrimaryKey", user._getPrimarykey());
            Roles roles = new Roles();
            roles.setRoleDescription("f2wx153vdhZmHjsIlqf6NURgMIOOC6umNvUih4kxmqkR1GJvb1");
            roles.setRoleName("E4UF56F1KZoSzMpO8sr6qQPyWEsyuTVNA6DQtFHOw1JdAx9xpO");
            roles.setRoleIcon("8qkYazAg9zB6RAdEgEgdWy95aIfC6SUrQZTJrzYSJO2Ji8ETfX");
            roles.setRoleHelp("As8ZAKyMk6ChC3CyD6R2PAEnxZenRh1E2OiXVpLqu2rIAKrrPl");
            Roles RolesTest = rolesRepository.save(roles);
            map.put("RolesPrimaryKey", roles._getPrimarykey());
            UserRoleBridge userrolebridge = new UserRoleBridge();
            userrolebridge.setUserId((java.lang.String) UserTest._getPrimarykey()); /* ******Adding refrenced table data */
            userrolebridge.setRoleId((java.lang.String) RolesTest._getPrimarykey());
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
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Autowired
    private RolesRepository<Roles> rolesRepository;

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
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserRoleBridgePrimaryKey"));
            userrolebridgeRepository.delete((java.lang.String) map.get("UserRoleBridgePrimaryKey")); /* Deleting refrenced data */
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey")); /* Deleting refrenced data */
            userRepository.delete((java.lang.String) map.get("UserPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
