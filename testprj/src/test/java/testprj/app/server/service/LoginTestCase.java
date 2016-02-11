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
            corecontacts.setAge(10);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("PR0Z6uty2IHp9r1yrrOQ7XaNFNM0GjTjaofkPatOOULov0zcjm");
            corecontacts.setFirstName("dAEPKN5SqRUaFe4NXmSyzijvISUJ6XrWSV6cOiVNDh1qI7oFrc");
            Gender gender = new Gender();
            gender.setGender("QFIV3cAPwYAUgaTXqwjFrJkASehHradGis2kWwwAFuBMsDhW6J");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("x0");
            language.setAlpha3("Om4");
            language.setAlpha4("eX1Y");
            language.setAlpha4parentid(1);
            language.setLanguage("bqo48iarqsCIvdSzCbPeGsakYa2btUvEyVAPFPSJvd7HN3Lpnp");
            language.setLanguageDescription("9vynGhD5Iq4C5l1o4U6Ut0lFaytntbCzdRxLi2Qu6mJs96neXg");
            language.setLanguageIcon("hZOCR65qdSAvRYZNsMBWkFkT0Cw4qjYgUhZz5k2hKggzclBDh9");
            language.setLanguageType("RZ4IGUKIX3nWLs4msOCalRDDZLcpqtWt");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("xUlBMJ3BRy9sP1EHzYO3phY0YACvD59Wwkha28TKqgkLNnD11F");
            timezone.setCountry("SPD1KKX9kBdjVFYH3BOS5f0khNrykp6tRhDJk685uBHc5U3jr8");
            timezone.setGmtLabel("F7C8IZGNRKVaXwldyMO4dEmwPK5SygWutjjjHkvd6BKEDor4aU");
            timezone.setTimeZoneLabel("i1paDgF5AFC1wo3tFKInwqWWCTg2kbC7juKXwhOu6KS5K1OY3j");
            timezone.setUtcdifference(5);
            Title title = new Title();
            title.setTitles("GMWBoBWZxR7zeARLl8JW44zzFutF32Ewayf1PiGStco9Ov6GZ3");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(61);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("SVswnWnLT1z1246WOLVCxwUkux4WkybfbMCamGTTeBgeE32kJ4");
            corecontacts.setFirstName("hRJxqWlFVRpe15t1FY02cIrkyMPaW3gRDAmnp7CdMMXkAwh2kZ");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("nlw8Bv4VKxWp82aaPTluSTraFFlFWqOVORYy7XHguLvDaF571b");
            corecontacts.setMiddleName("Lyi7wXTCm8MBT6l367rRlplkJcqPfmYFJp3W08ssfcg3DpGSvM");
            corecontacts.setNativeFirstName("JJibrqCEGsp6rHhX1uDou3HI9UMe37u1ZrKTSlkXG3bdLyhRIc");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("wPcA71juUB1qc9r6TFpGidonOrVg1uf9z9rYPzXObA1bKD3wHj");
            corecontacts.setNativeMiddleName("qX2UuNdCSEljYiER6EcFqA4Ny56dtrjUKYUvzLsASTlfbXFSs9");
            corecontacts.setNativeTitle("5Q8VvdsrhCCHoJ1zjwsjYemGXw80nPEdx1Xpxe0WoHwguYbKo0");
            corecontacts.setPhoneNumber("vfLYpYZ9GQu2pyfHjCBL");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("HpWCnMPkSRyXmQ9KUMfE009V8M750CmNUrjXdcHjtGmO8B0MP3");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1132);
            user.setUserAccessCode(0);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("GH5Fa2hTEGeERxlKuDlJCnM7QHfuziylI1hWBGDpzgu3YkBDAB");
            useraccessdomain.setDomainHelp("hWZk2DRIEJntFScbG30PUoZ8LXQWAW9DAYE7a87UnpCPQRdjJs");
            useraccessdomain.setDomainIcon("mCrkHfWDVJ5rpAerV4X07WE1A5Cwr5anO3zBlmgqbjx9bZYc9e");
            useraccessdomain.setDomainName("JDTPn0dJ3YpdCbFoPtMTXiM5fgmpNOEYqJjuOTnbYnYLQ9vjgO");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("Z47HoE6hxsxEfGh2k3N8fKdnNL1wF9tOlQNkmgXecih7tQ2GG4");
            useraccesslevel.setLevelHelp("nQXywkPNj8RN7Bfgl40h5bCIdeUOHVUFT1pdqa3pwIVLkf2WRp");
            useraccesslevel.setLevelIcon("8eNspJSyo3klIXPSjmbRMySayLyuVCHnwFLpdVdIUsqmI92NJe");
            useraccesslevel.setLevelName("7PWqifolEOAh8Dk65GCqPLE13ZjUg3QfqyuQyxUilucoFUL8tX");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("716dCJLwo40gTLJic2JnltEigObcMj8IXjwzTcr0UcYT94NVpz");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(53);
            user.setUserAccessCode(4);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(1);
            login.setIsAuthenticated(true);
            login.setLoginId("IZpzcu999ndDzH5I3VU8cwROkY1it75VTTp7Ghj5sU6iX1twhZ");
            login.setServerAuthImage("iqSREZWjVQ4TWzCJvn2TWUujJ1WWVxQs");
            login.setServerAuthText("JVAlJt28Oc6qzZk0");
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
            login.setLoginId("rxhW8ypUxP4dtRYiRzrhNdxsYTD7RSlTip18S4BaBnzOmwisYR");
            login.setServerAuthImage("xOT49lwtEb2oH2DMNv8WtJRNo1sBFtOO");
            login.setServerAuthText("vr6xsVtpPnggXnRZ");
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
