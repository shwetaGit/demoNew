package project3.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project3.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project3.app.server.repository.LoginRepository;
import project3.app.shared.authentication.Login;
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
import project3.app.shared.contacts.CoreContacts;
import project3.app.server.repository.CoreContactsRepository;
import project3.app.shared.contacts.Gender;
import project3.app.server.repository.GenderRepository;
import project3.app.shared.location.Language;
import project3.app.server.repository.LanguageRepository;
import project3.app.shared.location.Timezone;
import project3.app.server.repository.TimezoneRepository;
import project3.app.shared.contacts.Title;
import project3.app.server.repository.TitleRepository;
import project3.app.shared.authentication.User;
import project3.app.server.repository.UserRepository;
import project3.app.shared.authentication.UserAccessDomain;
import project3.app.server.repository.UserAccessDomainRepository;
import project3.app.shared.authentication.UserAccessLevel;
import project3.app.server.repository.UserAccessLevelRepository;

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
            corecontacts.setAge(72);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("zZGwXlUxDvdaBWOoCfOTQYO0DPmaiSJPXOD34pDQ8oBEzEYp5H");
            corecontacts.setFirstName("3SXwfr9J6TLj65YdzfQUO0YlC71Kpb2vnywnCCAlpRRkA1uXvz");
            Gender gender = new Gender();
            gender.setGender("bZNcR994jJKj8GcqPPRkvaUxNKLHigKVHnkPchJeu9a0XrRe2d");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("ch");
            language.setAlpha3("8ae");
            language.setAlpha4("bHPB");
            language.setAlpha4parentid(1);
            language.setLanguage("OD69OQ8eVgQcao2xAJktl3aq4PrAJZ46FlLbdBWmpLWXOiZvPG");
            language.setLanguageDescription("HVGUt71elswvtxgYvA09TCbXtqukTXaIKOot0PdavTHCC9ymDO");
            language.setLanguageIcon("l70cUjUXdaTPDlfBGxBfHvHkJTElTRsaKPuF7yBZKc8WPLk0Xm");
            language.setLanguageType("e3Gx4JMG4VPuIxTFSl4snPuQPAPJZiJL");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("KjCrwEo40dsJGUheigxyW1DFHagNi7Y3JzW2HxaF8t0WfKcWI0");
            timezone.setCountry("mWBs84Ux5Lv1SJHxunJoidlAmN0p2K7TSkd3Ynzm4CZF59CYsj");
            timezone.setGmtLabel("FpJu8q0hk3MsYB9pDCLGN1tke8OCeqGYjp1ZxSMj0opdTOd7G9");
            timezone.setTimeZoneLabel("yLz5AmQ5Dw6DeAQixtWewWtzQTQm2V4BMCjc9CIPTDtXevUSDt");
            timezone.setUtcdifference(9);
            Title title = new Title();
            title.setTitles("oCVzs5gIYLqxJ4QPBCKjy2bXJJWC5jwWftOM9GmWrCzDOMR6zY");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(87);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("6DQc6Vwj9xoHClaEUmv2LmrgoLD8bZJt0ZRVhNnKbbv5lCwYy5");
            corecontacts.setFirstName("KyIZGz3Mjr2BWUTmnUUsIr7IlQORupf8Th3EzoWBu9FZkKG8TB");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("6dEq2ES8aril3PAaQxuw0cp2RWv0kY0js61PHVQL0SuaBi2mJY");
            corecontacts.setMiddleName("U3VSgJ97zswb1lHiD4Z3IeQs11mF107phWb1N7qhI3qCVBpPQI");
            corecontacts.setNativeFirstName("vggcxl3Enx3xFw5PhcrLNePYI9ha1hN5pzQDGfOQlWZht1xgVu");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("YHlnsXD2nmc5nNFCZedMCoVsSDpIvgKRQrpbAjeWEgBqBDvnmz");
            corecontacts.setNativeMiddleName("sRVPXQd3bjeZFqhV9NuwXC4Nx6p1gNWB4uUYdeheGKbK9FrGBe");
            corecontacts.setNativeTitle("HPjzWKklFEaDAytR8AqA2u8VGKwPZyMoqBbuBvWhSatnVzl6AW");
            corecontacts.setPhoneNumber("d8Rasw6h8rXJuHvCgnit");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("XB4ErO0EatM4RkLyxqJ1O8w4HNI05t1vSplCuBPWCN6YnBwlI8");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(3450);
            user.setUserAccessCode(1);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("4tDLsMt5sKnnLePZiwJveZQEcaxVPfUxlWzqW2wZLvvUJiiS16");
            useraccessdomain.setDomainHelp("XdT8bQEDqwos456U4Wzm6MzdwVyWbwtZPaSI9oM7TijHYaPXUc");
            useraccessdomain.setDomainIcon("rga5T149Mjrp6XkhJw5kFKPo5FtW07SLFdjPhXjO6pZjTCudus");
            useraccessdomain.setDomainName("IEOcuRc4fvLyp3AkjMa1vnE1QHNCEXSTRtlsi9AFSjtxLHkz9Z");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("ceQP5ZTRqSK87wH1oYoqb3dZ6aOaarn0fcSt4AfKWnyqgCBW9i");
            useraccesslevel.setLevelHelp("oeV7QBmZCSKhQTQx1IlBzdtJCKI06yzynco1aDqDR8MgkvBQtW");
            useraccesslevel.setLevelIcon("lgYpGGOpbehTH3NtxuTkTgbEyPAiB9H6n1vRYQw7p0xoZD0P1d");
            useraccesslevel.setLevelName("ZfTDcQiUyxRmrfbqh57Z4J371DZY7MaILE4877gZGPy9wyDHBC");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("g3nW9aeJjYkc880aEYXIPmk8OtTAi1kxwQ2FdP3ymMyroxHjkW");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1560);
            user.setUserAccessCode(6);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(5);
            login.setIsAuthenticated(true);
            login.setLoginId("YUFfga6bMjWJy0TnFSETpPKVXx05L8MiJcERiiPta7qIsuO2v2");
            login.setServerAuthImage("B7PNbe8VzDhHxmkC1Oos2yMhQcxeG9QB");
            login.setServerAuthText("P52zycAW7GbHepdY");
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
            login.setLoginId("t8fvkQMSWl8XUSfa4v3cZ5DUTHkSuYN4Nhn8NwCbC0Ca7xhfK4");
            login.setServerAuthImage("8xexAQfDaKQruD0A5MEOI5bNBihO8xZj");
            login.setServerAuthText("Lsqgwsm2W46cg3Ka");
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
