package testprj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import testprj.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import testprj.app.server.repository.LoginRepository;
import testprj.app.shared.authentication.Login;
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
import testprj.app.shared.contacts.CoreContacts;
import testprj.app.server.repository.CoreContactsRepository;
import testprj.app.shared.contacts.Gender;
import testprj.app.server.repository.GenderRepository;
import testprj.app.shared.location.Language;
import testprj.app.server.repository.LanguageRepository;
import testprj.app.shared.location.Timezone;
import testprj.app.server.repository.TimezoneRepository;
import testprj.app.shared.contacts.Title;
import testprj.app.server.repository.TitleRepository;
import testprj.app.shared.authentication.User;
import testprj.app.server.repository.UserRepository;
import testprj.app.shared.authentication.UserAccessDomain;
import testprj.app.server.repository.UserAccessDomainRepository;
import testprj.app.shared.authentication.UserAccessLevel;
import testprj.app.server.repository.UserAccessLevelRepository;

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
            corecontacts.setAge(98);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("sjEEYbuLOUaWI5yq3YqNtMFjSPE0SBK0JiWKOJNQQcxRqADVYY");
            corecontacts.setFirstName("6XQqhnYFXJ0pnkwoY7g1Qs7Zoi4pwLFThOofORU1jaEyHffuC8");
            Gender gender = new Gender();
            gender.setGender("OJaxHBpmGYXjfDP4R1zz4avXvfy4qeWQfyOBBCWFVhnlB7ZWfL");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("6d");
            language.setAlpha3("2ya");
            language.setAlpha4("m6y0");
            language.setAlpha4parentid(11);
            language.setLanguage("FxmmevFCie7jjHyc7E9WtgwwYhpe8KhqQibVhkQHtAdYUd3jUM");
            language.setLanguageDescription("AjVFIa7k2xEdiCCsrzLOnpHan9jEICjPBmuSp4c4OcOXCtRjIB");
            language.setLanguageIcon("TGuBuUQnMbuFHxczp83nt2ZbhZBhNCeEWNWQxZufbRd1dZs7BE");
            language.setLanguageType("FQEckb2Q3iuTOu0K1ioNIM569ItBDT4t");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("ZNgNK2RgvtDEA9s7M6ID9xb4FhqP5EMf91aSzA3pwd5NKdL8Vi");
            timezone.setCountry("8J4MdbNbxzSqNhcW8mD7O8BdRd8ZSlo8rqrGk06A4wWXUHyAgP");
            timezone.setGmtLabel("nlnYQN4ZcPsQF5LnCHTZm3JQh0xN4L6QQXFntBXaG8g6equmkt");
            timezone.setTimeZoneLabel("xyOHBmZW5e77iaYWEdNz6RpEhHGRgG1CF3uPLzy98EHw2nSxNl");
            timezone.setUtcdifference(8);
            Title title = new Title();
            title.setTitles("DTwAAFABNuNSMY8JGBjmQO1ig3qYtuZlS4KwRQMH2t7E2tnoDH");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(35);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("W24NexjGobTY7B3JsGGdkhONoIr0hYAZXeuuiwTlUhntkEFqPj");
            corecontacts.setFirstName("WWZTTIVI9CK6TzEG2PWPde8l9EV3haANhfpDtoMYUgrxyYcKpr");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("7KkspQ18pVtFUyrl5KJJ9m8ZAqrnMHjPfgIOAOEbOF5kXMTexJ");
            corecontacts.setMiddleName("ov2kUSlGOQVSHlZr7kf64zsuFUrajtre8wiE5CYRrPUYEYyfAO");
            corecontacts.setNativeFirstName("RZiY9o6l5K8l5DEq0bhtcJiQwgUmnceMUTiKrzP9nPxipYOahS");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("PaasTLxdzIZudqzX2tp6cllNZ055SM1MIqoEH6DpTRja3gIV8G");
            corecontacts.setNativeMiddleName("7T5WBf7ZGiPT3J2GaoHdHYPz6tXNsPStLWuMHIo2qe6ZYTmNlD");
            corecontacts.setNativeTitle("9DFefKgpJ1fvbcbRTQoToRqsYIdwylv62G5Sxd0YcA2FHzrUfb");
            corecontacts.setPhoneNumber("FHUNf4bH2jjwEq5xEBSy");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("WpvlYF7tX9OL5aFLPSXkR02JP7CQZFfyK5GYR3bruovXc1nVOQ");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2726);
            user.setUserAccessCode(1);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("gUfZ4R3e86iM2T2kPm3smOsAnaaSkRdwpc0ZPHR9YSX7MfOsLa");
            useraccessdomain.setDomainHelp("d1cWhKjrVnrmeHTVapWoBnO8J1HflT2r9mrWSdoHrwYQ8xgVPm");
            useraccessdomain.setDomainIcon("LdwOqkcspoybHSqgmu0dNf2RupyRdureigR3fO2BqdJMXeyyCD");
            useraccessdomain.setDomainName("XfuAONe66N1VdMlfDwLanNNaSmoSa5Q43Qv6j0qUZ0SEkdm5IR");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("KxvRz6oAovyJG6aSoPF1t3JpWfIZh15G14COL2yuxa2jg1Ob2F");
            useraccesslevel.setLevelHelp("ake6HEiZftjk4F2DU0YPQEeJGE3N4UYrc1DAzHTqH5Mg5u4Q6A");
            useraccesslevel.setLevelIcon("mRA1cuYowY67MsFzWaOhh8oXFarg836xe59FN7bugZc2SZwaib");
            useraccesslevel.setLevelName("ZoKWpklzUxQu92we3RbqP4jon5lcJpE7Nmjm51eZMlQy5k9w0p");
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
            user.setPasswordAlgo("Z76BZ8H904doTlexSOUht4JKx3NWO5pNHNG0BybWXuRpeLFCCK");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2785);
            user.setUserAccessCode(3);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(5);
            login.setIsAuthenticated(true);
            login.setLoginId("sUDI4Elly21wVDRzIonwmN5GrEJVRauZhk2XUnB0GmkQFFPBrl");
            login.setServerAuthImage("XDAwwmizAQcR7SmAiZAOg6QNnal9ei1g");
            login.setServerAuthText("9qvdk9odakLN8SoX");
            user.setUserId(null);
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
            org.junit.Assert.fail(e.getMessage());
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
            login.setFailedLoginAttempts(10);
            login.setLoginId("x57XVoycUBP0s4xjw4IkiBQLiVvgAg9XagvXpzw3bw3iP3IHln");
            login.setServerAuthImage("Dv2cLK3hjorDKj8WZyF8RAgrnM9DhudD");
            login.setServerAuthText("cAT18kF1nHwZA2XR");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
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
            org.junit.Assert.fail(e.getMessage());
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
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
