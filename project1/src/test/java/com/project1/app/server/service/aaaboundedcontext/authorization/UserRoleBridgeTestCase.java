package com.project1.app.server.service.aaaboundedcontext.authorization;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.project1.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.project1.app.server.repository.aaaboundedcontext.authorization.UserRoleBridgeRepository;
import com.project1.app.shared.aaaboundedcontext.authorization.UserRoleBridge;
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
<<<<<<< HEAD
import com.project1.app.shared.aaaboundedcontext.authentication.User;
import com.project1.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import com.project1.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import com.project1.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.project1.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import com.project1.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.project1.app.shared.aaaboundedcontext.authentication.PassRecovery;
import com.project1.app.shared.aaaboundedcontext.authentication.Question;
import com.project1.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import com.project1.app.shared.aaaboundedcontext.authentication.UserData;
import com.project1.app.shared.aaaboundedcontext.authorization.Roles;
import com.project1.app.server.repository.aaaboundedcontext.authorization.RolesRepository;

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
            user.setSessionTimeout(689);
            user.setPasswordAlgo("ZUWoTOVghMQEo7a4PN7otQHrL8quqOluq1HqS6rd3UsyOJDClV");
            user.setChangePasswordNextLogin(1);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(1457502861196l));
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            useraccessdomain.setDomainIcon("Dyeeq6SqCTfdJF0U5tI2xhTo6PPA2viFZ4OvfyzvuddeE1DUIB");
            useraccessdomain.setDomainDescription("Dbb0gbne67MFns4D70ndeyccwwaAEzI1CA7ZHMDAVjd0HBg8hO");
            useraccessdomain.setDomainHelp("cTKhUUAQfsLXED0K7fCnrH8fLIJeAcGTFGx5r9QxgD0I5GEGyE");
            useraccessdomain.setDomainName("bFRjdLQgEPflYGerX1yVBWXEk0ragV6Ai1CfbkHDk9sNbqVdTt");
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            useraccesslevel.setLevelHelp("QWAaf0lvtFBFH0p94M77iVZCa3dIaDXSmV3SLnLUbYwpfmXkYh");
            useraccesslevel.setLevelDescription("udvI9TjKKFJqXeHDh0TFeK1qJjI1LMYW6xiGFmiYjoaszpV4pf");
            useraccesslevel.setLevelIcon("ZzVzverW99V7sfGgpULXB6FSeN2pBglBApK6poLaOq1nfihzJl");
            useraccesslevel.setLevelName("37Oiu2bR4MukiDabRZEmSkVz7qPuNp0lUgrlbffahL6rLRBa3X");
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setSessionTimeout(1913);
            user.setPasswordAlgo("9zunbQnog2841yHPLTVhrDMQtxJqcGLgsZ8mZezofkBYMI92OG");
            user.setChangePasswordNextLogin(1);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(1457502861202l));
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setPasswordExpiryDate(new java.sql.Timestamp(1457502861232l));
            user.setGenTempOneTimePassword(1);
            user.setAllowMultipleLogin(1);
            user.setMultiFactorAuthEnabled(1);
            user.setUserAccessCode(4647);
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("CCmacNp4wFTPIA8LQS204HUizSbUfTwssOYdXCsRLxURjIBHmf");
            Question question = new Question();
            question.setLevelid(8);
            question.setQuestionIcon("g4lmQjcYYzfuQQpG2vqA1omjbl8BjVf4fEU6imVMPBJZGADtM1");
            question.setQuestion("PDrSGUCg8oBBXF1r3p78AEiFDb6I6D47v7D0ENFLVlHyKpXfj3");
            question.setQuestionDetails("g");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("CIy8nqId4XA6qfNWLTx6qjHMvOtELeXEifeKibZIGPCREEb5tL");
            passrecovery.setUser(user);
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setPassword("HifBXUEuVmO2LJKaOej6zT0zsNqFQUagmX7mDuIdd4TtWrksFP");
            userdata.setLast5Passwords("TIGelpnzc2by0NcR1rEH7pHAFnU9TvWYEtofGYS1KGPQKv1JRH");
            userdata.setPassword("ochKuehA53QmMajEpk2sU5aAu1WNaeum81rwIXz2QqJ8dBK9wj");
            userdata.setLast5Passwords("3Sk3ojQW9VLL54S4G0Vv93mBTpt8gSzxqfiKPpG6gNcHThcOYi");
            userdata.setUser(user);
            userdata.setOneTimePasswordExpiry(4);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1457502861472l));
            userdata.setOneTimePassword("EM0St7HG3urlyPxEy8h7WUhbkOtNpbQa");
            user.setUserData(userdata);
            User UserTest = userRepository.save(user);
            map.put("UserPrimaryKey", user._getPrimarykey());
            Roles roles = new Roles();
            roles.setRoleIcon("Ms7fjM16G9Cjz8UC9lpI6N9aIMCnerwtDovWfCesnqrecVG3cl");
            roles.setRoleHelp("Hq37DUbqVXpbFcADdNNd1d0e7Nnzfsf3MBAeFuJNlrknBxOAXy");
            roles.setRoleDescription("sgea7ZFgXdWuk6UddhZbgi1r0Z3ERbBpHMVzOuCv2EQAlvEK0G");
            roles.setRoleName("BeeupfZAtmttkit2q54sv5M2l1a89FQU3nTvIa2MZFV9CUnNFd");
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
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

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
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserRoleBridgePrimaryKey"));
            userrolebridgeRepository.delete((java.lang.String) map.get("UserRoleBridgePrimaryKey")); /* Deleting refrenced data */
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey")); /* Deleting refrenced data */
            userRepository.delete((java.lang.String) map.get("UserPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
=======
import com.project1.app.shared.aaaboundedcontext.authorization.Roles;
import com.project1.app.server.repository.aaaboundedcontext.authorization.RolesRepository;
import com.project1.app.shared.aaaboundedcontext.authentication.User;
import com.project1.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import com.project1.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import com.project1.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.project1.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import com.project1.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.project1.app.shared.aaaboundedcontext.authentication.PassRecovery;
import com.project1.app.shared.aaaboundedcontext.authentication.Question;
import com.project1.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import com.project1.app.shared.aaaboundedcontext.authentication.UserData;

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
            roles.setRoleDescription("zih4chwTeX0YVzJEDrPDwwcSPzrh0OsZyqkBBbv6Syk8b6aDxk");
            roles.setRoleHelp("xPQH95WjeYbB1fbJzZgv6wG9J0dG2SwagqmPKrDjREsWYBKjdt");
            roles.setRoleIcon("EH6EsNk9i9qb8cWl1s9hQPDbzjqwxdCQu5P63DjatJe26Cp0GS");
            roles.setRoleName("8Q4Eca5Ng9Q6xz7RVuY27XhaoKvTMRYTCf0AVQAV36EvvC1ujP");
            Roles RolesTest = rolesRepository.save(roles);
            map.put("RolesPrimaryKey", roles._getPrimarykey());
            User user = new User();
            user.setUserAccessCode(29812);
            user.setPasswordAlgo("7nVJJ8tx9wiXOaSYorRvj5tNXVc7DIqVTG3hwIcXdGN8fPyl9C");
            user.setIsLocked(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setMultiFactorAuthEnabled(1);
            user.setSessionTimeout(1563);
            user.setPasswordExpiryDate(new java.sql.Timestamp(1457502213500l));
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("LsM7xJOBYTs8b9IZ9Q3WvhFGMaMEnxVlBYOxdAB2OsLjw9Ekv3");
            useraccesslevel.setLevelHelp("3Js5PnJnEzNyabN6LSvhpE3gaRTaMi7zrxumR4R79uBa5YCZFA");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            useraccesslevel.setLevelName("0HDKxNXbGJMGyy0GVCcKJ27o5cX3MTr7qD2IrV8XubsQhQNe3q");
            useraccesslevel.setLevelIcon("SGYMhTbOTOsYGheVIh72YXWyLK5HTDGPhW7xj5w5oewWC54Fi8");
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("6A4yyuokuFOCA22H36xjXg8gNDLlv09rKII21V5vgaFPZiKuRV");
            useraccessdomain.setDomainIcon("GH4BjqnZYvFAdfCCuBumRdsiKsrplPZdtZe1KOm2ko3FkxDYoq");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            useraccessdomain.setDomainHelp("nAtanyrcv6QrfeqabomSnbjeRtTvoSphVpzBA0BbGLaxogpQMS");
            useraccessdomain.setDomainName("KKQWvvHDL4mYukGR9fRwliuelH0msv9cum5fiGHZ8tA4dXmTcX");
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            user.setUserAccessCode(26205);
            user.setPasswordAlgo("WO6uzqAccZ4KQCvWv3zq5HFOqSMeQCsUreOZqGMRQk1RfpDgYo");
            user.setIsLocked(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setMultiFactorAuthEnabled(1);
            user.setSessionTimeout(3149);
            user.setPasswordExpiryDate(new java.sql.Timestamp(1457502213509l));
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setLastPasswordChangeDate(new java.sql.Timestamp(1457502213541l));
            user.setChangePasswordNextLogin(1);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setAllowMultipleLogin(1);
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("noh5WnNg2Au8XBwYDN3BwilmrBS137fGqMjKrexdyCiVmNDil2");
            Question question = new Question();
            question.setQuestionDetails("B");
            question.setLevelid(9);
            question.setQuestion("5SC90aW9AzuUJOfd6uZI6pyX4PQu8BZjWHcHyJv7n4gu9zpRT5");
            question.setQuestionIcon("z3lz2asBFQA0E9U4P62axk9akWsKClIiZV82U0s0crjOiTRqwH");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("VyKb00ar04uokWx50ArgANhWwwS3LGJAIK8B1AiUVQ13oROzMx");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
            passrecovery.setUser(user);
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1457502213748l));
            userdata.setOneTimePasswordExpiry(3);
            userdata.setLast5Passwords("JHNkDKNTM6505x25FY9E7WdOatSDgQphHIvZL8v8ghYwFumVgV");
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1457502213756l));
            userdata.setOneTimePasswordExpiry(5);
            userdata.setLast5Passwords("v8wJ9Sn1xdhUKlqblPYTs3oKpdVzoyjaEJQfxSWSLDEyuYIHz6");
            userdata.setUser(user);
            userdata.setPassword("l2tt85jN3f0Y4CJ94gsF3BwRQVYlR5i9VtD3KmuawUVaUbUCG2");
            userdata.setOneTimePassword("M4Cv6to6HfCxyIrqraKaBu3laHznZqJO");
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
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

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
            userRepository.delete((java.lang.String) map.get("UserPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey"));
>>>>>>> branch 'master' of https://github.com/applifireAlgo/DefaultRepo.git
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
