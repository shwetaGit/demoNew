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
import com.app.shared.contacts.CommunicationData;
import com.app.shared.contacts.CommunicationGroup;
import com.app.server.repository.CommunicationGroupRepository;
import com.app.shared.contacts.CommunicationType;
import com.app.server.repository.CommunicationTypeRepository;
import com.app.shared.location.Address;
import com.app.server.repository.AddressRepository;
import com.app.shared.location.AddressType;
import com.app.server.repository.AddressTypeRepository;
import com.app.shared.location.City;
import com.app.server.repository.CityRepository;
import com.app.shared.location.Country;
import com.app.server.repository.CountryRepository;
import com.app.shared.location.State;
import com.app.server.repository.StateRepository;
import com.app.shared.authentication.User;
import com.app.server.repository.UserRepository;
import com.app.shared.authentication.UserAccessDomain;
import com.app.server.repository.UserAccessDomainRepository;
import com.app.shared.authentication.UserAccessLevel;
import com.app.server.repository.UserAccessLevelRepository;
import com.app.shared.authentication.PassRecovery;
import com.app.shared.authentication.Question;
import com.app.server.repository.QuestionRepository;
import com.app.shared.authentication.UserData;

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
            corecontacts.setAge(29);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456478444136l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456478444136l));
            corecontacts.setEmailId("c06tUF18mSglETGqNApOtJXbKPFRMdgcPRLKvm6mKaZn13vMgs");
            corecontacts.setFirstName("uqQ6uEEYjQeaw9dFqvEvpYqWRcE1iH6DZctCbzSudkdoHyLCgP");
            Gender gender = new Gender();
            gender.setGender("WIWrmGUpFoEs9CpYIbecb8f7zuHvcRhQVlbsSpnw4OuGQAiZAZ");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("xR");
            language.setAlpha3("m7y");
            language.setAlpha4("OaID");
            language.setAlpha4parentid(11);
            language.setLanguage("hwl4jlUP4hIkLj9otb1K75tKHnKHZWtUPCI9LZe3O42nFyO0tj");
            language.setLanguageDescription("lGPO1fgCxWIVh2uVz8yl8KDgVuOffw8pPP5f1Is7LFZNTF5KBB");
            language.setLanguageIcon("LBRaKKz6B5iSta7JQRUr4xxZJ7RMzkY3Dm3mW043mifACW170h");
            language.setLanguageType("1h9ZFmmLMcLaXlsJK7ZDaXzdDVUMskXp");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("Xr0SHtJznzTgULBdSCcRP3ROBdvo62PwJP49bS0GAzPt2H41GF");
            timezone.setCountry("LPRrsEbPwDY4xuc1Hja9rhcQSzLuuJdKNlfGzWSW2pmacIja5v");
            timezone.setGmtLabel("kTxgQT4EwgOZR6KZxLIVZlHIKiZF485P7Hk32f9arAs7yY3eD6");
            timezone.setTimeZoneLabel("pEFQiUACDXe471xB1s3jagwBWMQunvPgVF6cP0pAPcGPDzWeB6");
            timezone.setUtcdifference(11);
            Title title = new Title();
            title.setTitles("YLV9S1v5l4qOVeRnxgJ77oEH38P23aQWRKbnbphbFHgp820AlN");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(76);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456478444157l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456478444157l));
            corecontacts.setEmailId("EwrFAK1rHbNNRviHvln5f5kfrBL1IQFa7qqfILIMaz7rcr73EF");
            corecontacts.setFirstName("mfW9wV666BVUfEx9VTQQ3sQyeTGu7Mz6QvHhqr8bamWZrZr1em");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("nUpY7z3oNt6b8mBd3UQmCAlVGaISIfMGweYjaP3nkf5JZQlERj");
            corecontacts.setMiddleName("M3XOrCQAhoXx2Jnqczz8l63xpikG4BuhX1ZS0B9Civz6TtDFvT");
            corecontacts.setNativeFirstName("cRLgIF323nQYrJoeECPyCoxbEsn4AFrbuyiHL5qT8C7pCjleEJ");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("CVgJ8me2KztJuvjGpAs7U44qSKU5etFvgKurvAG8L8DGRHzrLX");
            corecontacts.setNativeMiddleName("KFWdwyXJiylz4DmktIKYI0EuaaEDEAG8PzgdM5Xo6DoSVRJPWm");
            corecontacts.setNativeTitle("PIyK59Imf40PdhmaueFBjhXgyAcpaz3XoQZUf7rbBflOjJG78c");
            corecontacts.setPhoneNumber("HGkEV0L9EFyy1O5G9OEx");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("l");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("2swP3W1bSh8PFyz8YKZSG3WOtDjMqAV9TbkgOgpyQS2ZZSQlB0");
            communicationgroup.setCommGroupName("8qiVTQih1zrAJdo1OxC38Hvbm8Hao6O4Kalz3qn0TZBaOrL7qo");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("5uCZfNDWcd0tA8i174HGC0J2CN4Sn420V8f0SM0RDLEJ5r99ne");
            communicationtype.setCommTypeName("EfZVSXdUZhMC0SmupggszrcOdPn5On7eGLJVDRBav4CaXinRCe");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("l");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("s775ATEdkxAJdr6cYYDqt6mZBhRpQrRxxrbnEORLyTCvo4OR6c");
            address.setAddress2("jD1kjvADpXXBOT5i8EVTXcAFbdxipayFxDbdOeXg8y5DJquG7F");
            address.setAddress3("9pttbb95zeLWiFAzHTksE6UfJgiNIWxYdVVuZf7h0FWLbYZqMl");
            address.setAddressLabel("YA8pc7KKfpl");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("8BIILEkCHgx9yYwbbffCuRwes8cal1GAXFiDTcskOB5Xw97fXm");
            addresstype.setAddressTypeDesc("dDopcfT5P2sAUa5gqlrg9OHxTSBu7pG3QhmGcYPwm2wrWkr2kQ");
            addresstype.setAddressTypeIcon("3mwbII6Kw2u9t55XHBEb3Pqi1gWaUKtFRWHJG1t0gkqVYEn8EX");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("Ridct9tbzWMu7Gp9O9r3vRMgydcSPBjk");
            city.setCityDescription("W3TmA2pVrmHtPiBH1mdgbgOSkla8cqggGt1qompt8yRmq8rCKE");
            city.setCityFlag("fTx4hPlT4DmQuNPO849J03pcXJ2t31G3rtOgtlzv9usHxefHtS");
            city.setCityLatitude(1);
            city.setCityLongitude(9);
            city.setCityName("tKGrY6muWWkGy92UDdKoCXyLrSTcueaH2F3unOsm7owtQ8YmEm");
            Country country = new Country();
            country.setCapital("4Cb5TfvR331fRvxSlODRGid4FvaiegY8");
            country.setCapitalLatitude(7);
            country.setCapitalLongitude(11);
            country.setCountryCode1("GFL");
            country.setCountryCode2("K3Q");
            country.setCountryFlag("9Nvmm8zbn9AgoS2cNGuXz65GnekyEBVjynJuCwn5Wb9UuFArBb");
            country.setCountryName("rHBeDlV8c82nN2tXwAUSn8uh6BLznSormMuVwNNQKA1onp0duc");
            country.setCurrencyCode("drt");
            country.setCurrencyName("4gz67v9tcLIdVsgPeLNuRJuSlDfPf0myrucxcwx4HPnznS1Wi4");
            country.setCurrencySymbol("AJvUIz67J7rZYYrQwVFk5HG093gYVdzt");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("SIuYXOFT6nLToBgnHjLRiOoTGRrtABnVdYrFHfiHMXKIegUP9M");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(0);
            state.setStateCode(2);
            state.setStateCodeChar2("BowdbDwciO2KIr75nmKYHeADLar5uvG4");
            state.setStateCodeChar3("XHd2XaAzCwKYSCe4NvNNGJZm9tmVq7Y2");
            state.setStateDescription("imQhULdvDIGY4pY7cMO5JrzhfdaQHnojtAMsGQjDs87k0GLLSe");
            state.setStateFlag("XVEVqvcrlMpG7Q3MR5LH3RvX0AjMsdp9nTCgzNy7pRCy9zOq19");
            state.setStateName("rUCpAhv6VGxNck3YzErtIHOhhM4lu3ErHzy4yaUzLen70dnRyM");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("8Pf5medTEvzpX4MTaDRJRIkSHEz4iw0g");
            city.setCityDescription("8fy64OTnevmxzAdcAJuOtAfV2PYBrnc64wTXBCTeDhfyYbnrdn");
            city.setCityFlag("qb11qQTAEx1tiVVwcCAakI4pVF99O9SYOJyWlxZdlWLv9Ar2jw");
            city.setCityLatitude(9);
            city.setCityLongitude(7);
            city.setCityName("pOFYhBsUHJ41TAm8y3hRxKZHEzyMKy9zP18DoScRgClgT2aYRu");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("6NyUtVlg3srzwbhPkthanz7r9iap0NGGLtc0DjnWb6LXywRGe3");
            address.setAddress2("bLUGj24VPs94oWVCCUcr0DNmxIUxzsOHcipJgf0tn9oiS10dOc");
            address.setAddress3("ec4Oze6ZzaGx5Gyi3taMXmmBLboCBmBNxsy16Xmn1BjwZ1diDK");
            address.setAddressLabel("oP4ruzaXicc");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("DPgJ4HEMZXe9nqKP1nsGn1L1TN0YZph3V6x568ghFTViHFyG2P");
            address.setLongitude("77FE0xXX6VqCMS5LF8qqks7E4We72B4FYYM3xIhb1da2skodVa");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("XvsHjD");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(1456478444680l));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("PIhMNMyn47XYwkIBTkF6EJ25WKURGqKEA5lM2mvaVaOfuslvuW");
            user.setPasswordExpiryDate(new java.sql.Timestamp(1456478444680l));
            user.setSessionTimeout(569);
            user.setUserAccessCode(29670);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("CePztqYIWgv0YzDLOus20LgdhgWU7RFO8y1oBpbHLkkh0Dp0Km");
            useraccessdomain.setDomainHelp("UDyb022V769wTSgrcsqfh9adJx3PClSzHaCMS38ucdCPvcLxam");
            useraccessdomain.setDomainIcon("sIxSleaCQ72xGkCRzFhQL8NbBcV1JM8E9YJBDcxedgCkPd4DP7");
            useraccessdomain.setDomainName("vYDH3zAfZessbUpNsLDqbkiCXzcjxChX950mJNFlEfD58AkssO");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("vPaqYFTwkNKyCaX9SWEXCbqQd4HyqL8qbvcElDtbxF38zViaWD");
            useraccesslevel.setLevelHelp("pvD5KSArm2SXQea0keCDWwJy7sN9aoWeRNoLsZXU7Dtc76X5Ew");
            useraccesslevel.setLevelIcon("4fQNzDOc3JXUtW7qXLvanocnQYhHafhJbjcNS6zQnW5AgbgOef");
            useraccesslevel.setLevelName("zEyEIEk3o6cLQrRq8SkERiHxiXhgHzFqtlUmcVG70dO0uKIeIx");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(1456478444709l));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("wRTsHouKIZeVzNAzBP3DTpGklyaHTUpb0bWkoDQDe3NQKNewF4");
            user.setPasswordExpiryDate(new java.sql.Timestamp(1456478444710l));
            user.setSessionTimeout(2515);
            user.setUserAccessCode(30663);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("86tkEvEWuEIvyyMmi5rHIn3X0eTSltEPoyv8T8XM07YoVqAh9C");
            Question question = new Question();
            question.setLevelid(11);
            question.setQuestion("5YKO0SKA8QXsW7N2aXmvkJkjYMtswqLO8kYZXeheYB9KRLGflf");
            question.setQuestionDetails("1");
            question.setQuestionIcon("bxGzmR2Dboq1E2F5ySupKcfCgZUq8OCoz2N5TCnuDEGt7uD1kT");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("wUButJ8sLX6QYkaDFPiqh6KcH29K0CtgkHbwEsPbNOAbP1A4GZ");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
            passrecovery.setUser(user);
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setLast5Passwords("d6OLofZWngEOpLpoAueQZSVAwXaUIhimUn8JwPW9kEnXq3EKRW");
            userdata.setOneTimePassword("2XxufiLtvy43gYTe98VwoRYDbBGqDYgK");
            userdata.setOneTimePasswordExpiry(6);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1456478444948l));
            userdata.setPassword("NBH8kFIwczlM54haLqUQaybNEaL7qvRRnrpsRLihr7CSrij8I8");
            userdata.setLast5Passwords("indcG5SetMm4cMomKa3JITu206SbRDWbFYLowKcqvSPL5lWUEp");
            userdata.setOneTimePassword("ZSCUUW9weAOM3NRrX1F9QFneVhyPFxjl");
            userdata.setOneTimePasswordExpiry(11);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1456478444973l));
            userdata.setPassword("4oZpFLlg1R3Au40VuwM1iKzibKzSONF3wrIj3RCuE6OkxL20td");
            userdata.setUser(user);
            user.setUserData(userdata);
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(6);
            login.setIsAuthenticated(true);
            login.setLoginId("Ma8xIrWrGdSM6lEjzWGjxjXjtXXz1rDjdKWyA5GMQMLKz5rSm3");
            login.setServerAuthImage("qKk24JCJOgKVqQpUbNnggHGpD76oG9LK");
            login.setServerAuthText("qXAA34SiRZXSncds");
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
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(0);
            login.setLoginId("eM0mTaiY8mxValoWF1UEGlJMurcViL3gWuQRAecXlUugxwB867");
            login.setServerAuthImage("2HsmPgkIraBCcCSgutcSx91khGDoSpSB");
            login.setServerAuthText("cHuDl2nvAm2xpc38");
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
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
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
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
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
