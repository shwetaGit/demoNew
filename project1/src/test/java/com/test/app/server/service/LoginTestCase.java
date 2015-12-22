package com.test.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.test.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.test.app.server.repository.LoginRepository;
import com.test.app.shared.authentication.Login;
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
import com.test.app.shared.contacts.CoreContacts;
import com.test.app.server.repository.CoreContactsRepository;
import com.test.app.shared.contacts.Gender;
import com.test.app.server.repository.GenderRepository;
import com.test.app.shared.location.Language;
import com.test.app.server.repository.LanguageRepository;
import com.test.app.shared.location.Timezone;
import com.test.app.server.repository.TimezoneRepository;
import com.test.app.shared.contacts.Title;
import com.test.app.server.repository.TitleRepository;
import com.test.app.shared.authentication.User;
import com.test.app.server.repository.UserRepository;
import com.test.app.shared.authentication.UserAccessDomain;
import com.test.app.server.repository.UserAccessDomainRepository;
import com.test.app.shared.authentication.UserAccessLevel;
import com.test.app.server.repository.UserAccessLevelRepository;

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
            corecontacts.setAge(105);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("bH7kOaFtJEd8IqKwwASzeAzXy8WzMQUa7n0HnQpFBZyDv614jI");
            corecontacts.setFirstName("6amfq3A68GnKDmjuFxaYYuDPVEIsLKar1mkAHfYxb6x9Gf9N7j");
            Gender gender = new Gender();
            gender.setGender("1htbycWkVuMAG7nhPnjVjYGsNKbRgJnGQSpvDbH6cN8PMBHWsV");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("mp");
            language.setAlpha3("zf6");
            language.setAlpha4("GDEu");
            language.setAlpha4parentid(2);
            language.setLanguage("s8aMrtreAPjuratYhjAqO3Hkalf3Ry2wyefsX1Wnb4aeeIXiWy");
            language.setLanguageDescription("MQeAU5w11sbYR2yz04wIGP6fpZbu8wrqxgw9oj8IAULMuLqR90");
            language.setLanguageIcon("d4CVjcjkjsjtjviXNUT3lRg9o3FT7gZS8vWFe8Jo2eXGAYrSM2");
            language.setLanguageType("8sr5fs9eKALn3qMDotqlPvVLR8P0fS8S");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("xteiW8qcfxCrW0rW0DGtwVV3Y63YA36X3BCtCMRUbKndITBCUo");
            timezone.setCountry("YiTCVTCr1cAbDP156OfFk1Ml0KCEFpJizvX2FooEaxCKu7PW0f");
            timezone.setGmtLabel("bFTvAlOQZnltcBPpLpyvSoGrWEqtLpFlI09PBk4R0qtJXfewlz");
            timezone.setTimeZoneLabel("e6G7SOIjNFrgQujOmPJVEP5bZDXq2pgaDn621QjHbm6oh7tRVH");
            timezone.setUtcdifference(5);
            Title title = new Title();
            title.setTitles("ATiMAhAdLcLJ4Pihq0FBr5EOi0XT7waCMGn6uoxnTgdKPGKGoU");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(94);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("GHzvRQvPBTfifYrwl8pNxV3E5jxEl1sZ4FIsJgWp2KDkShRcls");
            corecontacts.setFirstName("YMZ0Ces3TsKSRdapDNrTwBFoW8xtmD49AAWQq2pNgtEvrVBEso");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("200lTNhl8Dodqd0K2CCwV2ftKU07ZmJ4JYTB5kU4barhw9dZnR");
            corecontacts.setMiddleName("SrJjOQUm0sfHRi9FWnjg5dlMcZHgCLMgLZvDZaGM30FZuLFnWu");
            corecontacts.setNativeFirstName("XNZm4KMzpyXOeOL6t6B58CeU3v8L5hk3JOdr1ZdPPFNGd4f7vb");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("EubYyWH0uA5gLATWrOLd5uwjhEmffH0SPPANWeTzVvrInWciPo");
            corecontacts.setNativeMiddleName("gL48UjQjkzzOjPPXmxNyMo5fPyy23C3BVdPYpO4tY1JTccToGt");
            corecontacts.setNativeTitle("wdRli2n5DgFkH4dSGWeYLesBUZqXi3GiaDJdQ9xEM0VQNu6A1h");
            corecontacts.setPhoneNumber("TXqhMMFbIwImqorBOCdP");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("xsnTFZcNcihnL8jhhJwYEqK3joJP3zpV0ukAyoDsfdrUDYdIB5");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1595);
            user.setUserAccessCode(9);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("7hyQ3Q8kkOSzspSpArDhxkGGaVmpGG1oOjNPzjhOIWUduJdRYA");
            useraccessdomain.setDomainHelp("uxpMLFMkY6s3BMKX4pzq44qF8pBC2WfUowDNISceWT45E6Yhi6");
            useraccessdomain.setDomainIcon("qbwg8WE8WYjGzOeBswCYfw3aiSMaVmVfjT1a43ePugK2m6ylRr");
            useraccessdomain.setDomainName("red3gqi3tnHrL2ln3ssTOxgZ5sAtdJuTxZiaZyTRCIgCbJHdq0");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("gf0VpYpvAAcHm13fqQ7n9g3iciEmSjfJKUvzmebVSOxvoiMct7");
            useraccesslevel.setLevelHelp("6Cx1JxBfY4HxRrCFKTQx98DsArhZa4QsNB0tTjRLceV1CPq1k2");
            useraccesslevel.setLevelIcon("SMj7fAsItIJKoobMZGGglrsRrmcZA8HTvfCzXdgg8eQeDiqQv4");
            useraccesslevel.setLevelName("h1nojvbcgnQ9R7VIRvTIG11ZPoW360ptDpEIGduJH8HfhPPYfQ");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("ODHwjlGpCab8g9NBh4YcCiqmgJUY4rkRKgd6c6KpOd3WERBzNu");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1077);
            user.setUserAccessCode(10);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(1);
            login.setIsAuthenticated(true);
            login.setLoginId("EVc3mLSznNyBF0ofyLi6YLYIgFK8AmArlyppBGyMlTnLrHZTCN");
            login.setServerAuthImage("f1jCiNez0qrNOqPUZVwLLdDaAb0BtVtM");
            login.setServerAuthText("prCBmguWsOA1YEEn");
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
            login.setFailedLoginAttempts(1);
            login.setLoginId("M27ihXGFErkZY3WZnknssP9KtLnjN19HHA0Ex5eFfXxmVlONMl");
            login.setServerAuthImage("jcQbgphSSnK4ODe0Do8TWwkIlhJZfpJO");
            login.setServerAuthText("CESx4PE41So84m2H");
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
