package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.LoginRepository;
import com.app.shared.authentication.Login;
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
import com.app.shared.contacts.CoreContacts;
import com.app.server.repository.CoreContactsRepository;
import com.app.shared.contacts.Gender;
import com.app.server.repository.GenderRepository;
import com.app.shared.location.Language;
import com.app.server.repository.LanguageRepository;
import com.app.shared.location.Timezone;
import com.app.server.repository.TimezoneRepository;
import com.app.shared.contacts.Title;
import com.app.server.repository.TitleRepository;
import com.app.shared.authentication.User;
import com.app.server.repository.UserRepository;
import com.app.shared.authentication.UserAccessDomain;
import com.app.server.repository.UserAccessDomainRepository;
import com.app.shared.authentication.UserAccessLevel;
import com.app.server.repository.UserAccessLevelRepository;

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
            corecontacts.setAge(85);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("2wzOURiEUioUOw57NPwxSYJTccSgVPvQJk6sSKhyZri92kuG7G");
            corecontacts.setFirstName("9TAXsIFA7OrZiYUad4rQmZ0sXRYbd2HILa8yHNosfthPvK2Kwt");
            Gender gender = new Gender();
            gender.setGender("GvZ7THS43UQAOMgXWKC0ZykBkvFXpF7u4fWDtDTUmHHcRjgTmn");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("Ej");
            language.setAlpha3("xw3");
            language.setAlpha4("m7M1");
            language.setAlpha4parentid(5);
            language.setLanguage("pbKDMHLeCvhCYvycpfkexOvGnYTOUhvMK0YytIJoABUb4NbGrT");
            language.setLanguageDescription("unptOIpSCuOuD5GfEtpObCfcf7volHP7jcCfT3gwnM4MxILlxL");
            language.setLanguageIcon("NyZH9FNSSKufxsiEnKmKe4czvW59jsSoRaUWdhSHOPobQZowig");
            language.setLanguageType("QnCTKJjSL4oOxdp3UpPjYDq92lwsI78B");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("5yodnKskEdh7SBcVMcfqDSYwMYMTjWkig1DbWr8zLtb4iXuHbK");
            timezone.setCountry("CCWLoZUwsfPRo9DXrB6DDlLfDbDuVGfbYGWlfMqkWWfWYM54yA");
            timezone.setGmtLabel("0A0XuobUCdFzXyzJMiXsamTvQP2fKDQGiusZhPwUrxlZ1elNYe");
            timezone.setTimeZoneLabel("n20AfhSYDUnsid8RqdHABWkZO8I0srrdVXTHJNcfITYDZQHrpu");
            timezone.setUtcdifference(4);
            Title title = new Title();
            title.setTitles("EoOBenCKBub4vR3Hbq6rW4d0oCckY0NQzAJIUahe6FLQJCHG3H");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(1);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("BkVcm7hQo3afb5V41UHESWS8RBzasbesMJ5UMKvEEveRXRwRnL");
            corecontacts.setFirstName("moJYiyINGCMZPngtKYUZ3uMQc38AKac0hhM8WilEl0sjTKlRyB");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("dAK8hvjHhE0MxEcN6yAPNP2xGpFrfEwkObbtQUUtsNBip2xCWc");
            corecontacts.setMiddleName("zOvnEIiSmhGwSdlUp7uUu08DZoL6XN4nR2vNzqQ66jMZUVFzQl");
            corecontacts.setNativeFirstName("jiVeSb55lNGepb1XUU5ARexVrIJgMWvXG7PqVnIcxhb8kXv2rK");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("cbUOCjZ1Ymek7hSQ60CAu8NSwV9eM9odYTeqxJmnoyf7yMURD3");
            corecontacts.setNativeMiddleName("uANJ5nAF5HC05O0ZcyZ0ZJv9dLg7Fd7Nj2pYjuVTuBdtsXR1Cd");
            corecontacts.setNativeTitle("GjdiJdEMtvMyAt3PII3vKMxIEK2G2tItlJREm1uYvqbNc4Ml7W");
            corecontacts.setPhoneNumber("6eVhkY1hkLl9OJZOOZmg");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("ClM5GCIEdmSYunqriHmB20xDvYskaLHBjI5SOguZnTo0JOUFoF");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(150);
            user.setUserAccessCode(11);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("A7l3NfgFzcMuy4viHNxNCGT8SKRF82DLgVTEEvASyTYztt51mN");
            useraccessdomain.setDomainHelp("Z8HOENYMbizhoYGGo4UCbD98AXZG0VvGnifvPkV9H6bR5D3PTM");
            useraccessdomain.setDomainIcon("gtzCKyOeCUVWBZnMyR6D7Ki0HBds3hP16mFfNvjEVZAgVqpDNM");
            useraccessdomain.setDomainName("FbGrgqGKL5TCmvNuBBGJSlZOiaHCkDfxksvd6z7GlHXLaVKMXW");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("0YdDR5pUo2nZ7kZsNwbk7PF6grJgOgaKn3M6sLRyQO5UjB4rAJ");
            useraccesslevel.setLevelHelp("XTIUh24b8wWe3e2icq9WLyb5hDOcPQTFuVHq66dwzCN0QOLaGB");
            useraccesslevel.setLevelIcon("9PZ7s42NohwPqYVxIXv2AFT14MHqjOru3ZuvbW9ooHm4qVPsVW");
            useraccesslevel.setLevelName("wgR2TjG9VjOtLxYuHMva1TgUdMNIGmNw1UjuVpu5RP9BiGtKCj");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("AS2ry8QpzzVLODZwpGCWDG7kfNOjUonUinwC4DARmfVjkstyI8");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(3241);
            user.setUserAccessCode(4);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(9);
            login.setIsAuthenticated(true);
            login.setLoginId("41H8RyCMbELmYtuhEB7006QGHopMR8B47C7hIxOvQx68ToECZB");
            login.setServerAuthImage("K4LUoPBLcy9M2VCmRLAL0A4bygvFDGef");
            login.setServerAuthText("vb97gXFSxQs6uTAp");
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
            login.setFailedLoginAttempts(6);
            login.setLoginId("kGsyxCLH0f6f0FXZkC5C5sX69DbG3mve8Xt66ttXTmCb6MbiCh");
            login.setServerAuthImage("gfe5Fa8hfQyP4fPBI8YyO9k9nbill27q");
            login.setServerAuthText("NS5IUAXT2wkzYRvu");
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
