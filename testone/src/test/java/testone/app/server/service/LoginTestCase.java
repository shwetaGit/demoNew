package testone.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import testone.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import testone.app.server.repository.LoginRepository;
import testone.app.shared.authentication.Login;
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
import testone.app.shared.contacts.CoreContacts;
import testone.app.server.repository.CoreContactsRepository;
import testone.app.shared.contacts.Gender;
import testone.app.server.repository.GenderRepository;
import testone.app.shared.location.Language;
import testone.app.server.repository.LanguageRepository;
import testone.app.shared.location.Timezone;
import testone.app.server.repository.TimezoneRepository;
import testone.app.shared.contacts.Title;
import testone.app.server.repository.TitleRepository;
import testone.app.shared.authentication.User;
import testone.app.server.repository.UserRepository;
import testone.app.shared.authentication.UserAccessDomain;
import testone.app.server.repository.UserAccessDomainRepository;
import testone.app.shared.authentication.UserAccessLevel;
import testone.app.server.repository.UserAccessLevelRepository;

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
            corecontacts.setAge(73);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("jfTLt7xEa6eX1QVOqLyMjhZRm0Yg1VDIbTPw50syq2QtQKSZ9a");
            corecontacts.setFirstName("oeeReskgjuOOUKgTJPoUu13nKSMFBA7PrDvH6sklAd9AgUjJlo");
            Gender gender = new Gender();
            gender.setGender("OFcklP8FFdBvearHrgbmf0eLvzDIUOpQY4G0IPeZFUqrTJZIfB");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("lG");
            language.setAlpha3("yqW");
            language.setAlpha4("O40K");
            language.setAlpha4parentid(11);
            language.setLanguage("bl62BtRTFweBdS9N8LLMOpuJjlHM6nG7RXlC2tq1u0NEEmupNq");
            language.setLanguageDescription("bo3jzlOn6YMGkPaoLU3xXQEkBB9Uncz7kSCTBzkI2XDAyYw1AJ");
            language.setLanguageIcon("NGe616UGtQam6npWffqvwnCIJoGAGc7T731uvl5kxjvE5wZKBC");
            language.setLanguageType("bCHSjpp1Koq1VLRbTeRZASn3GMxvvyXE");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("cU5bdXdh8eIPS3k2fWxPgox7nH2Jq70XDXnJuI5bfZOvwka6gl");
            timezone.setCountry("YP50pzWoSAfO0JeXKPHApPDVzEgla6fgZosn34Bw8WXxAF7Klm");
            timezone.setGmtLabel("QL77XI4wKPK6n3jUFq83ryHCmkarn6okuE0FVRnVT1iJ2WHGkt");
            timezone.setTimeZoneLabel("OkxWqN60HiLpjwEWOUV6N20cRxzLym6gCbsprFguuMLNVV3qu1");
            timezone.setUtcdifference(5);
            Title title = new Title();
            title.setTitles("VsNLYJ7ym4a2muKnUTtYbzt0n9L7c3VuS9hvZEiLLAiwlcEJo1");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(123);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("kc4lyHaMXe6aubC41yiKCkDZsZQC0ry9o1x3hxju4pCfSrNXKu");
            corecontacts.setFirstName("GEyxnDXXl0UEldUIl1843hYRT5ghK9G2hu1ugpxZXkjMG2pXET");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("gEJ3lhzOns7LHOUymxOQQLM2ZusACPVTZlLIeiQD5PKXrTWxnK");
            corecontacts.setMiddleName("lbd1tzOtTlfJHSqd08ymKOVDEOUJTwD61Mcza3MBuNoeYP957o");
            corecontacts.setNativeFirstName("sND3HAOGVAnhiWjF4x1eiFiNMo1CYrpCgosH53QwpOQQlb61Ea");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("2lFSU5Gosj4Bn0MdKv6EUKODSyZWMknqryG3N3WyP15kK4xS4e");
            corecontacts.setNativeMiddleName("LoK85lb8JGo6CvajQpjFgm9C5TtlhOXpilkxbuRIeBMGPQn1tW");
            corecontacts.setNativeTitle("1MTRu3eRFcE5v2tllueVeC1QTaMdgR7uwI2eIysWc8nAL9ssgw");
            corecontacts.setPhoneNumber("URKKaj1ZIOGDaXlRjx0J");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("jX0KlQkjTPaHX9gI69l7lfly4IywoiU57UJb8nVJXkN15PSrMx");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(636);
            user.setUserAccessCode(1);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("wLTq7Omo0vhyMYvLoBKlGjAz5HAALAohdBebF5FB1ZBMaoR7oA");
            useraccessdomain.setDomainHelp("LakdHUd8UcYZXMJVKKPDpS5qHCSBYdvIT3P4ySKR2pzJxXuh2P");
            useraccessdomain.setDomainIcon("9pk0zXxGu8ATh5xZhWrs2tuiDZ8iaZWdIZC7ou2LpWlH7DURHb");
            useraccessdomain.setDomainName("k8pbbEEJqOmvO9jYgFSNcCWWxDNqhTK5xfPBULtO5e9n9Og6Vn");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("2EIRP5o33yHXTfH7C4JPcuk0Sz1g0qLDbigh7DDbuBxBwVMW6N");
            useraccesslevel.setLevelHelp("Nhc9NeLNhzgZNxancL4sg7WfvlGJetK0i4ysn13JwKgSNKRcwn");
            useraccesslevel.setLevelIcon("1dauVL4HW2XodOaOw9DlrEMSt24R8jnRPqkv9SnqzIVce7Uk8O");
            useraccesslevel.setLevelName("EqXkgzEc023RJuRmJb3KiqBYDFeZD8IC9HvSRuALAPLSFxM75d");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("Zq48e7DfjlxJBaE2CaBj0FwwRuwzhadOBy55oupCBOcqR13CBy");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1487);
            user.setUserAccessCode(0);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(2);
            login.setIsAuthenticated(true);
            login.setLoginId("d5KoVE7ApmT6sKU66pWMCpTpNiupJRLr6T6w9OVeNjDKV5PJ2v");
            login.setServerAuthImage("kxdQGA86fVL9JU1LbqjrsGx9oWdXm4Qt");
            login.setServerAuthText("zclSqvC3PtZFR9Mn");
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
            login.setFailedLoginAttempts(11);
            login.setLoginId("18fiOadxVOTdIKwBn2CaDgL5jYe4yeBw7QrTixtZvgSM4GsqJr");
            login.setServerAuthImage("w1dkTj8RZAWvvimSEhYDjgsK6L3A3auN");
            login.setServerAuthText("Glgm6wYfwQ8JOcwt");
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
