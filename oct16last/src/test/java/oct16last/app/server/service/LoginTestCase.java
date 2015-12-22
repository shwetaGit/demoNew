package oct16last.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import oct16last.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import oct16last.app.server.repository.LoginRepository;
import oct16last.app.shared.authentication.Login;
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
import oct16last.app.shared.contacts.CoreContacts;
import oct16last.app.server.repository.CoreContactsRepository;
import oct16last.app.shared.contacts.Gender;
import oct16last.app.server.repository.GenderRepository;
import oct16last.app.shared.location.Language;
import oct16last.app.server.repository.LanguageRepository;
import oct16last.app.shared.location.Timezone;
import oct16last.app.server.repository.TimezoneRepository;
import oct16last.app.shared.contacts.Title;
import oct16last.app.server.repository.TitleRepository;
import oct16last.app.shared.authentication.User;
import oct16last.app.server.repository.UserRepository;
import oct16last.app.shared.authentication.UserAccessDomain;
import oct16last.app.server.repository.UserAccessDomainRepository;
import oct16last.app.shared.authentication.UserAccessLevel;
import oct16last.app.server.repository.UserAccessLevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(18);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("DMjROUkZ24JOAym5J36mWNuxiZw5Xg1xIBBocXskuOpXCjM2h5");
            corecontacts.setFirstName("1N6NpQq4EHIAm3OetH9S7hekIWIjgSWtH3sEDWJJFtN4WmhxAo");
            Gender gender = new Gender();
            gender.setGender("IYIJTgt6NJEQR5e4teSNLb5XR0AKESt6N1Bdq9mu0Lss02CZwr");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("bT");
            language.setAlpha3("zg7");
            language.setAlpha4("dnP0");
            language.setAlpha4parentid(10);
            language.setLanguage("563h1uHzzkI99x5FguMxwfKSZYw2GJGKx2qh6XQqJROlJA6av5");
            language.setLanguageDescription("mgLt2LJwcS6CrGv9i1U1QTH6y7MqA6nfOw67iQXXGEAUZuiMoU");
            language.setLanguageIcon("oOvktAjQ8fzXiFHWIFmYKB33GfAWr7wjG5ctnJvQSLy30u1dwj");
            language.setLanguageType("tq8AHTg5y8dSflefFcBMngfs31VRfegp");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("FKa8ocOfOkuTvrNruAw4qzll5Z3OeKLajrMWRUpYGytZps2Y5e");
            timezone.setCountry("WAm0SaNGRqmTZpkvNp3xq8Z0RUY3sefsdmA8nPYHMVA7muTkT2");
            timezone.setGmtLabel("IRIwRrJMPdsPQ8F17RSYzCqtyljZkc2FaHk2xqlGxBp9mGN8iy");
            timezone.setTimeZoneLabel("S3EopZkaQc9B8zDKtUBr2925t86FlupqfALpkPAROCdERgte6r");
            timezone.setUtcdifference(0);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("9yynSDG7wCOS4DJ0d9CBYSvrW5kwlsMWEvOrEeROkWkKKQJQmR");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(98);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("iLIw5KQHQ7JuwmCHNkL28fupB4D7T2AMMfeS9LqERL2HVTgVtn");
            corecontacts.setFirstName("RX7XFtTL0OtNoNxZer75NRT7qcy4YXULcvSOZZGmsArUsQCfUI");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("CpGpORMNxx4QRa6OurleowVivum1JYU6fFsfGHJ7O8f2JFRos7");
            corecontacts.setMiddleName("S5HWKpvcFFhTXPnteFjc0fN4Tuc6JkRy0j1Jwcqg9Se9B6Vv1z");
            corecontacts.setNativeFirstName("8DKt8H59uWpzrNHlddZdk4nMAeu4Iv2YyD7BFvBwVGo0CMJQN7");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("ChRzFVsESaMlNwBBNrv5yDIh7zVbVwihMMOijM2OdZObolGSuj");
            corecontacts.setNativeMiddleName("PWKxtUYHxIgI7hsLEdq9OYn3FrCxVC99yyg7sTDDjwu6CZmJlj");
            corecontacts.setNativeTitle("UNlKysZMBEnvWD8fWkq7eLDDpZR5sSDiKRbMtiFCBa6eEpv5wT");
            corecontacts.setPhoneNumber("cFirCPNUYDbmXMD0Rfa1");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("s4PIx49VW8rFzUih85K5LVaifxLnaWUOP3eqUc28NwxOI3j6i7");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2269);
            user.setUserAccessCode(1);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("s2gxNboa2pLMaW8TC23DI6fTptueJs1g4kXpgZK07DAOgN15SK");
            useraccessdomain.setDomainHelp("REEvSNIOVI34nmKHEV0vT4z5mSoN0pxE78kw4RemG8PUtOxWPO");
            useraccessdomain.setDomainIcon("buUL1gRWChmxpTLxgYopUh1tCNPrG9WJkiY87CHsG20t2l7C1U");
            useraccessdomain.setDomainName("sM61i6MLUnKE1nO2aJ5JYNzjZzxQglchvqS0FBVKKe6L037Bjj");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("4me1loYtasdVDjr1x9EA30M33EP7fGfgAxxOxwyBVrQnxrV9EA");
            useraccesslevel.setLevelHelp("fWXxYyUy1821OxsyZi6KNrTL20xmxQRZwpa1lSrUwc0TzC4KUO");
            useraccesslevel.setLevelIcon("qg9wvGB95aMVoVLX7atJ51pbLddacVikSz3mB5oGWo7Kc48I66");
            useraccesslevel.setLevelName("hJydiHWpzuVrHnxMvnzBJmuZRrX21ZTJwMGSO8jsP1hMeA1hji");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("FeJY1pF6Ev7REqbaG8B0d7JORUjN7jAEQU7g3FaDJFLq3U8mG4");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1607);
            user.setUserAccessCode(8);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(9);
            login.setIsAuthenticated(true);
            login.setLoginId("tiMRGJ2VzIrR0d5M8RfxSxXLAdGMtix13BPzIwG47bSdCPSPcH");
            login.setServerAuthImage("txlg5IssMUdplPSIQ9cuf6KXNfvm96iq");
            login.setServerAuthText("FtBfyQ1qBbyKLo1R");
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(4);
            login.setLoginId("VcLGRjb47oJyymF98WRZvBkeN19OaXAJ6I0QbHGpx0OgZkZk90");
            login.setServerAuthImage("3Mni0V8b99rhCavMaVsUbLuGheGz3sj1");
            login.setServerAuthText("8DlSSrGZq0LsMNAV");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycontactId() {
        try {
            java.util.List<Login> listofcontactId = loginRepository.findByContactId((java.lang.String) map.get("CoreContactsPrimaryKey"));
            if (listofcontactId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findByuserId() {
        try {
            java.util.List<Login> listofuserId = loginRepository.findByUserId((java.lang.String) map.get("UserPrimaryKey"));
            if (listofuserId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
