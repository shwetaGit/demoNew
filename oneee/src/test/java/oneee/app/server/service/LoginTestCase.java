package oneee.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import oneee.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import oneee.app.server.repository.LoginRepository;
import oneee.app.shared.authentication.Login;
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
import oneee.app.shared.contacts.CoreContacts;
import oneee.app.server.repository.CoreContactsRepository;
import oneee.app.shared.contacts.Gender;
import oneee.app.server.repository.GenderRepository;
import oneee.app.shared.location.Language;
import oneee.app.server.repository.LanguageRepository;
import oneee.app.shared.location.Timezone;
import oneee.app.server.repository.TimezoneRepository;
import oneee.app.shared.contacts.Title;
import oneee.app.server.repository.TitleRepository;
import oneee.app.shared.authentication.User;
import oneee.app.server.repository.UserRepository;
import oneee.app.shared.authentication.UserAccessDomain;
import oneee.app.server.repository.UserAccessDomainRepository;
import oneee.app.shared.authentication.UserAccessLevel;
import oneee.app.server.repository.UserAccessLevelRepository;

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

    private static HashMap<String, Object> map = "new HashMap<String,Object>()";

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
            corecontacts.setAge(122);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("C2mUMJAHhYWfTerLZ9E8GHMBYD6o7o904tNOekQAjLs5LRqydm");
            corecontacts.setFirstName("9JWaHZjaXwngSY9hIsih6pDiSfxQXtjQCH5JBZFCoGIGFxGSQm");
            Gender gender = new Gender();
            gender.setGender("xfy58CGAhQYQTmjdV7Nu548rI09E7CRb5AcY6IjCMhpfS0m6SH");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("sG");
            language.setAlpha3("E4V");
            language.setAlpha4("INj9");
            language.setAlpha4parentid(11);
            language.setLanguage("ebDE2hIaUfaJUfnv2Z16Dpty755LDJrquE2peQPBYhdBXZdzOL");
            language.setLanguageDescription("1KJqgUujk2xOgPSy8cJ4ORYqt8ByBPNZMjzYmyhDVjdMN0z4nr");
            language.setLanguageIcon("uFLaMrjzxiVluaD2ogOSDA5fhjjQjk0xCuDL5E3LZDcgt9L9YU");
            language.setLanguageType("OSvdj43h4rDTmxYpTimQDeWU22U5mJAj");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("ErpxdKeVSF6vgwfDXZCBHryrNqBsX5CVEYoPPL9fr6gGOgIWkA");
            timezone.setCountry("w5pwSX3eNApkfhsCw6OXPrm7heHNMrsAZWpxM1Jzg9eup8MHiB");
            timezone.setGmtLabel("PJXnECQl83BUdy4EofqXJoYyteMnyozYbrOsMINweFoNJOKXfI");
            timezone.setTimeZoneLabel("3L0q9MqaHpCc7gtX5J0I7YqhDazEL9J4Ond06bi7lmUkCsV7f7");
            timezone.setUtcdifference(8);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("73R7skkCq3iQ6zrkCI8lMk4sAN5CjfAKRCBKf7c7474shF6Gej");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(77);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("5bWBktrTvY4MRZH3JUTpBhAOVrpbkseI4CvgeLTOKH3bH5xLdm");
            corecontacts.setFirstName("nNhGK0fQTAvjptEinjDIlZTSa1UUhjuXrxvEiGgCohiJ7cRaZG");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("oYvHMmb2OPxkq73hm6gr1R2VQ48GOuJqkQ4jeADJX7hZzGJwiI");
            corecontacts.setMiddleName("1C2LOMCqOiwPrU2eV7uKmJvvjEEPMVUXMAeIjzeYAbsa2H9r88");
            corecontacts.setNativeFirstName("r72LqAJH7CQaFJPoS3muDuBkysSXp1Ir7r4XPbwmYTzvoea3eE");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("37zDbOVAw5H1LTpaxzfQSFQPq4m6Fym99coeVanhK0kOATvLRK");
            corecontacts.setNativeMiddleName("T1ZL8dTkhvATFWAstToV0qNdSpic1UV1nGaTCJwASJbNr6vZ83");
            corecontacts.setNativeTitle("rCOLJV4chcLv67T7iNRuvIaXMmLbBFX7KWZfaO0kPnK0HPTzi1");
            corecontacts.setPhoneNumber("sdAcvw7OQicw8EIfYRkM");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("4smaJfwpFwKIkeYPKsTydQuU0utAqcURhIbAeT1LhhCmv94rmQ");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(3307);
            user.setUserAccessCode(11);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("tA592mWkuOR0mJRSQUOoKffRcXKtuDhaRoAkhPRuY32tNgRKiC");
            useraccessdomain.setDomainHelp("GD99QMqxg0cP1HD6rhXa1mtPPOQOEcYfMMlQBiDAqixoYuoHgN");
            useraccessdomain.setDomainIcon("gLSxnJZ8scWbMFCIwAgzFD9hrJMpy3hjr8x2sad4kinA87M5gR");
            useraccessdomain.setDomainName("cnwiMsDkaXfhFskTuLum2NysUJSEtfG6GxUrVUVf7gvJ4CPaos");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("yeQP6tOAIc0qwHuaB5OOiBPi0lvIlYUz25oFVl1jXqkzakqPse");
            useraccesslevel.setLevelHelp("8Zp6yO5CLbCVuYZYQKNp78DUBs3XFgTv4Vj2hIXTIdG9KWJE7a");
            useraccesslevel.setLevelIcon("KNNhZtRQQCe3PUuiVZ8KeYgBCTA77YEstRySvJxNCLLipGJZAh");
            useraccesslevel.setLevelName("fhn3kurivbrG1hW3ca7kz0vw67fwXhxQFNK0XpUe9TjLgBAyF9");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("7ajZuM1g7pL1Z0M9zJIfOIdpyipDBFVDCjZ2jAazC9NOqUmVQ5");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2591);
            user.setUserAccessCode(2);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(9);
            login.setIsAuthenticated(true);
            login.setLoginId("StbZ4zPBJF4BLwPJZ2BurIiZzZQ6zXFkqTsmvTBB0cZ9sD334g");
            login.setServerAuthImage("RzWl3chRqC12T3ifUMIL3mhwzbfe09p3");
            login.setServerAuthText("DtG8xAJaRKdz6Jlu");
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
            login.setFailedLoginAttempts(10);
            login.setLoginId("yTGcym7ZosbBv2HqaqzUewKzP6kf1KBr2KZF9rJPl5U43CDNvc");
            login.setServerAuthImage("Dp8sYmOy8KKI71kUy6qhZEacuekU9Ycq");
            login.setServerAuthText("Wf7MfEhuvETeSfr9");
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
