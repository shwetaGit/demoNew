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
            corecontacts.setAge(2);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("EzY6WC02Y65UhGWILikKhQHqrkxqLq605UDSH25HO9K2TzEocs");
            corecontacts.setFirstName("ypAWrTrD5NHtsE0fv3qKU1A8Q20LucgY9NqFOo1IvjG9JBaSCE");
            Gender gender = new Gender();
            gender.setGender("gJMOdI1H3N1EpMmSGlWILupE1j1CngSRJbNX1mPOyimaqwZyru");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("jf");
            language.setAlpha3("GTf");
            language.setAlpha4("r4JS");
            language.setAlpha4parentid(8);
            language.setLanguage("fqj1RGRBtbY1W1kn2aPPXYXovb2iGbAbHOO5zgDmeP1lv8SWTK");
            language.setLanguageDescription("gSSjJuBPY3QpZApBikuSiCsxVib1YNvnTO5U8S3YTUbtBRdOhI");
            language.setLanguageIcon("5AyNcw2cjK85jPxhxdZU0mZBSMnOOUjdeD6WKq0oc729yu1ftY");
            language.setLanguageType("FVib7M5ytklzFSoG3T10c9lfHGKAwn96");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("FDcrzaQXciWM4jYfSpC6xRCgI1OnX6eEuEZTgNXLwAIKAfPVHY");
            timezone.setCountry("VPXnvNuaq3oixjyT2hP67U4HouwTNcKAfaiz7syOQ8DQQrV7j9");
            timezone.setGmtLabel("bIaHRIUonHwGYqPjR1LYrEvB0KmMUQZhHpj675gIO858hhBurp");
            timezone.setTimeZoneLabel("pC5qaB4noyPuWH5R9m8KIo0CjGRYfv203Hs6vAxyYJafiPaymV");
            timezone.setUtcdifference(6);
            Title title = new Title();
            title.setTitles("CozkbvK33aqDM7PEKjviXV1Ra1exzEcwVOUuEEoX1SOv4qE0ZQ");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(116);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("uoly7tnUcYhR7VH5z0KNXmAKy70hExa3LxA22juDUnJiqO33ss");
            corecontacts.setFirstName("pbS38CoiFppKOc0JLhYuInAghOflftpBexu4REk17k4Yjb5PSo");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("uDVeVYCpigoGH6rLKmqak1HAfHvYsZql3DOszLGIU3zuqukWnt");
            corecontacts.setMiddleName("A1tpgFsVCHJdZf5gg0KWlAYOpd0SVIlOroFVUJVONEoF2m7tLl");
            corecontacts.setNativeFirstName("3Flgn70IV66qUhDW0XGp3ZE2DDsaJUh7CAZmbW6AeLBg8nSICW");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("6ZdgBBSLrkzH33g9CsnYPJxvATdhiDCCtV59L32uQxNjVXfvDO");
            corecontacts.setNativeMiddleName("GwdfCQGjGAtUsqBJU0ymSrtbnFIH6Jha7bYefKuBBysBKeEkIh");
            corecontacts.setNativeTitle("SdOfRxGdAd5JRBsMecNFUsqmloG9xKmommsB9WUWHZp93wmhfE");
            corecontacts.setPhoneNumber("96JBhuov2CN0mZm26PNn");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("GCzEeFyMfaqKHpaoqg5JxOqTZYWjB4ZACJr2nQsdTsIHjgQjjG");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2980);
            user.setUserAccessCode(3);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("R4Wk27UDUD9pFcFjuo8zyFbiCzZcXecrLcLaUmGSWewzALZXni");
            useraccessdomain.setDomainHelp("qqlZ8yw9oFZX6J5uJfRHsxJ0f8bZJbBO286eDvtI0rHO2r850D");
            useraccessdomain.setDomainIcon("qyPXb0guiLcmiQilerUqDXKdH5LC6XwcuuqHAkt3GynE7ygNmJ");
            useraccessdomain.setDomainName("T93PkbBTdxk66WKGXNymlt20BEOXPmfAq2NI6TCSsFZeepgS5k");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("AF78nCKMv0FqgcUSuO0ZMj6NnpITVPyseoyQeK3POPQFYCaUjM");
            useraccesslevel.setLevelHelp("Q5KtIConQK6sfIML0JooHb7s7Ykn9g1gjd1iuNDTvYMTREyQPf");
            useraccesslevel.setLevelIcon("nWUbWIQ5qFjYDGS3saQFCzrG2WV3Gyxg84b00FjV9JnVXzzRe2");
            useraccesslevel.setLevelName("71b5yoHgBiHNhOOeNTtjbso50huoNN1PQ0C6t1RO0EvinTdxOE");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("etzP9mrHurWORoxGoEfUrxM8YlPzU35WpkDXhtX8b1JA44lbHW");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1132);
            user.setUserAccessCode(3);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(8);
            login.setIsAuthenticated(true);
            login.setLoginId("HWUR6blGwMqvS1LucQoMnP1cv90O0mdqcZR079Ji70Y5i1NqT8");
            login.setServerAuthImage("MoZMzJO4EKLqTyGFY4tz6xlQdQM3Z17Q");
            login.setServerAuthText("n64Pt3BYpSYnTChp");
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
            login.setFailedLoginAttempts(2);
            login.setLoginId("hp2JrWEMEDDY4qYSpuyNFqBoCfzyIqlTbUcUPZYvzUyQqHoeg7");
            login.setServerAuthImage("DxILsP0QQ0jIxnAGjYUotoDa4QKa889o");
            login.setServerAuthText("bLYfienGcZdZS1Kl");
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
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
