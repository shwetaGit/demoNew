package com.app.server.service.appbasicsetup.usermanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appbasicsetup.usermanagement.LoginRepository;
import com.app.shared.appbasicsetup.usermanagement.Login;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.app.server.service.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.springframework.mock.web.MockServletContext;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.server.pluggable.interfaces.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.appbasicsetup.usermanagement.User;
import com.app.server.repository.appbasicsetup.usermanagement.UserRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessDomain;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessDomainRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import com.app.shared.appbasicsetup.usermanagement.PassRecovery;
import com.app.shared.appbasicsetup.usermanagement.Question;
import com.app.server.repository.appbasicsetup.usermanagement.QuestionRepository;
import com.app.shared.appbasicsetup.usermanagement.UserData;
import com.app.shared.organization.contactmanagement.CoreContacts;
import com.app.server.repository.organization.contactmanagement.CoreContactsRepository;
import com.app.shared.organization.contactmanagement.Title;
import com.app.server.repository.organization.contactmanagement.TitleRepository;
import com.app.shared.organization.contactmanagement.Gender;
import com.app.server.repository.organization.contactmanagement.GenderRepository;
import com.app.shared.organization.locationmanagement.Timezone;
import com.app.server.repository.organization.locationmanagement.TimezoneRepository;
import com.app.shared.organization.locationmanagement.Language;
import com.app.server.repository.organization.locationmanagement.LanguageRepository;
import com.app.shared.organization.locationmanagement.Address;
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.AddressType;
import com.app.server.repository.organization.locationmanagement.AddressTypeRepository;
import com.app.shared.organization.contactmanagement.CommunicationData;
import com.app.shared.organization.contactmanagement.CommunicationGroup;
import com.app.server.repository.organization.contactmanagement.CommunicationGroupRepository;
import com.app.shared.organization.contactmanagement.CommunicationType;
import com.app.server.repository.organization.contactmanagement.CommunicationTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase extends EntityTestCriteria {

    @Autowired
    private LoginRepository<Login> loginRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        MockServletContext mockServletContext = new MockServletContext("file:src/main/webapp");
        try {
            String _path = mockServletContext.getRealPath("/WEB-INF/conf/");
            LogManagerFactory.createLogManager(_path, AppLoggerConstant.LOGGER_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
        runtimeLogInfoHelper.createRuntimeLogUserInfo("customer", "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
        runtimeLogInfoHelper.setRequestHeaderBean(new RequestHeaderBean(new RuntimeLogUserInfoBean("AAAA", "AAAA", request.getRemoteHost(), 0, 0, 0), "", methodCallStack.getRequestId()));
    }

    private Login createLogin(Boolean isSave) throws Exception {
        User user = new User();
        user.setPasswordAlgo("gMyYlYGlL6a4qFR6szjt6tNwlegof3Cxk36Dq9VrbLNwdNZuuI");
        user.setUserAccessCode(51502);
        user.setIsDeleted(1);
        user.setGenTempOneTimePassword(1);
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainIcon("xt0WDVhoyDWlZSfE8Ki4Ygd6AwnhwfrKcMbUQKtBpcigQmaPnT");
        useraccessdomain.setDomainName("RnLlbGUn8qXKu4AbymCUNc9iujrBtiuOCQgc6PhRBz2ipSd5wV");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("f8mLWbodum1nqjKZ5jOUk9q5Ne0x6D9BhGO1h9mSbMr8jo7w6U");
        useraccessdomain.setDomainDescription("3JoDLI6Mh2auW2QACv7FoU3jobrGsBQfJLxMEBsabTcyUteN8N");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("xQbyu50k0RBDDQBugIeIf4VMO87XKIIxNTBOumicMt8LXYZby0");
        useraccesslevel.setLevelDescription("Pt1sn8lWjY3jx0yNY6gArAy4TDA08rj6X7Bw3W8ZTUVM7n1REq");
        useraccesslevel.setLevelIcon("KxscZegEuEnC0xeZwIGLXrWk9jZIQYbwkZSCqwI6ZHEAr1dFZa");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("M9x7uic9VQaaASTwseLctZrm6GRuIbeSC438UWJYra77VwBQ4Q");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setPasswordAlgo("Uht6uoW2B03Nm7I9ccuBIEqsxQr4A5vzHdMCIqKhSEe7eGbT8a");
        user.setUserAccessCode(44684);
        user.setIsDeleted(1);
        user.setGenTempOneTimePassword(1);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setSessionTimeout(2449);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1463133507319l));
        user.setAllowMultipleLogin(1);
        user.setMultiFactorAuthEnabled(1);
        user.setPasswordExpiryDate(new java.sql.Timestamp(1463133507319l));
        user.setIsLocked(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setChangePasswordNextLogin(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestionIcon("vEbe4gO9PqmtCngXYRVy33xBz9CLJErbHtSU6B41uWc9dP4HEe");
        question.setLevelid(6);
        question.setQuestionDetails("bge7tzyCi5");
        question.setQuestion("uDX2PcCd2C7sCAsjkPxnUokb0Cddvcgzlt4rc8SFpfPbILUfMC");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setUser(user);
        passrecovery.setAnswer("PsHQD73PBTEEgw3Dhv6B4zlGGONju2DUHvcnuvNN7mmmarP74n");
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setPassword("3SisibxrP9nLUOJicRm8RCktdcqfFfXirWGPvFHSEzYzxcpUXB");
        userdata.setOneTimePasswordExpiry(3);
        userdata.setOneTimePassword("nzhCLFjEZ9rkoKDC4LNjIl2o2DjQvSiy");
        userdata.setPassword("WWnd93CYwJYO4w7X7aWyM95uRhfPG1ryqo61iHN3PVXcEW6G3D");
        userdata.setOneTimePasswordExpiry(7);
        userdata.setOneTimePassword("kLw5EnQ7rNud841fUCMYO0jOocQa1uZU");
        userdata.setUser(user);
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1463133507579l));
        userdata.setLast5Passwords("oOqdcopy52vK0kITHoJvwOrUvW7cKk4WoWtizPzDM6ZLQxWdjz");
        user.setUserData(userdata);
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setLastName("lw6oBm7MVMaJvjCLb3YbdmI7nXlnXMIznNdZzSOO8M4qJtNBcw");
        corecontacts.setNativeMiddleName("aDYnTfBwbZ0113hZX8RgmYWOjoEB3C03GCfxTyLn7oQvmTADzY");
        corecontacts.setFirstName("rduPCgyaJYWRBTckkOCFjzAFRZqYNVYIOMSvkRdr4GT4jFRayh");
        corecontacts.setNativeTitle("XJx484BL36RGo6y901uNNxVhwwFpMqrRV0GJW1GtVWg5E3fOpz");
        corecontacts.setNativeFirstName("NhkbBIZaWMxDn7qdoW1hSWhS7UP1XGuD0kRB8txeuf3sN4kR29");
        Title title = new Title();
        title.setTitles("M2mHrKfYm3mQgZiFOd2TMHoIa64ytNLoB7EKK8XklMPy7HV1Nh");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("gDnS4JFoy0SmSYtDRb0Eh4bjIDZuu5i71hhqh7PyfpXMxfppUH");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCities("0JB2icbbISu2RPNmQL4KlmxvVSzCq84ipejvNZQCiQ3g75tCrH");
        timezone.setTimeZoneLabel("42mR1wcMDbnTse6wuApYhPg59sIOO1T7tOABuRbKj4IkzbBxSm");
        timezone.setGmtLabel("QEc4LF1ziETVRQV6hKIYjUUgNlXFhe2QgfG632Cip1yELfdxxc");
        timezone.setCountry("Nxdylr89TUXeJ1fO8l3LcS3fBAOEtsuWzmwQ35Uy4mGtbkBuaf");
        timezone.setUtcdifference(4);
        Language language = new Language();
        language.setAlpha4("ZsHJ");
        language.setLanguageType("sHMdu95j43pUpPrxnEVNMP0sbWQvj56J");
        language.setAlpha3("7Gq");
        language.setLanguageIcon("rHA8AiNZ8c3XRbqeznuhqmZ1W0NYuM2y9s3L5Lc2RYkzQdZ98X");
        language.setAlpha2("Oo");
        language.setLanguage("2k7rwR7mX6uRpwC3GdYQjkhMgrwCcwiCfJq1ivwVIrccn8Exba");
        language.setAlpha4parentid(6);
        language.setLanguageDescription("a8hIS2br3UT7Vn5DxPQYmPNnR3ucM94DJ7o2BdyBp0Hr6ogZUg");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        corecontacts.setLastName("cvChFRmCfzdtISxUP6l2oZL2zNFHPKpoJ7iGBaJFztVu0uJTuU");
        corecontacts.setNativeMiddleName("ZqUsAluSU3TzW16j6xdVQVAIz9xsbWRKJisRnbSyhLHe2qWwqg");
        corecontacts.setFirstName("3IikQfRGGbn6tpaYOa5t1LnEHZvE5vMg8l1AMVFY4JxHN2q4OD");
        corecontacts.setNativeTitle("fRcXDwzO6evx101aMl9ulsRVtQ706NtgxFURhy8nk8uiFW8lTc");
        corecontacts.setNativeFirstName("00fgPY1WIwwlHTy8wX6rU22eYTsQVGwaL2Oy4aDDz38keyyrBK");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLastName("qBJBaqyhX2hUPqZaQzNG7pavjswYtS0fVSksCWfpguIeSSgpVk");
        corecontacts.setEmailId("BjawPy9JN80v33MZjSAtRGEXNSm1TQm9TBtcEbMxxLOjvzvPhQ");
        corecontacts.setPhoneNumber("5IGIHFEdIesuyUzbp0rj");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1463133507710l));
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(37);
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setMiddleName("HVoNhKOFCFXcWlkEZDf3l4rjZq5NKaDwrE2md49ZxjzGztV3VJ");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1463133507773l));
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setZipcode("M3ytrP");
        address.setAddress1("LBLzZcv8BuW3n5L6KtCgZRTzfqI7COap5HUeuUO5zmSgI8miFU");
        City city = new City();
        city.setCityCodeChar2("EGXeoQIFxszhae9TTZddPy1g7DZrXUeS");
        city.setCityCode(2);
        city.setCityLatitude(5);
        city.setCityLongitude(5);
        city.setCityName("82vXmhOPKVSKDSwrGVjv7FwyOPa5HPO6uTlAQVcdRZyTemDyLR");
        city.setCityFlag("O6cmx3JoynrU0v2ozH2UyWgMgk8gDW2Gcihv0VfdiN7cdj9T3m");
        State state = new State();
        state.setStateCapital("zRVpc1aQ7CwfEStfYs9Ps9rm6a7k4OC1QduvzaoblMHdoa7Elk");
        state.setStateCodeChar3("yaJCRH9qFI8qDJz4aCfx5dN9wEPqjT8A");
        Country country = new Country();
        country.setCurrencyCode("wXW");
        country.setCurrencyName("TxZWLaMmjSiA2YOchnm02Q2UQbGRMZAi7CbD03UL22YEym2sXw");
        country.setCapitalLongitude(9);
        country.setIsoNumeric(851);
        country.setCapital("tNwzPMASa1aSLoMmWjetNFjXery6EoSJ");
        country.setCapitalLatitude(2);
        country.setCountryName("FfwUxViVfMm94tpSHawpuHVjierQ3JhfxBNCWlBoN170Cr87u1");
        country.setCurrencySymbol("CHGNMoMw7ldLT4zbhp4QuDOM1YM7sFKM");
        country.setCountryCode1("wtH");
        country.setCountryCode2("6qB");
        country.setCountryFlag("alSty96CF9QPaoZJjwgo5b2rQR0OksiTqloxUUrUG6JN4FHZTk");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateCapital("MkDyxzpnL9AvLpJyeM7CteTPU1OrlTNulalTinWzr7cWeuSLRA");
        state.setStateCodeChar3("YcUjfWnf7TME1qm6wRys3aTcrDnpiKqy");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLatitude(10);
        state.setStateFlag("Aom3DBqPxbYLj7A99ktatDnjaSdnmK55jCKZK8nHNiQH9lLGru");
        state.setStateCodeChar2("EjnVcHXgLiQymEWnGDNDy00hSn0NzZfz");
        state.setStateName("d1YCcoUBQCh1SSdbjFZBAf48ap2VA87HE4ppGNZ4AHLOoMiRqD");
        state.setStateCode(1);
        state.setStateDescription("5V2LVseGueJMzjeen5pAIQ7fhYt7XCzZmFktAaLIP7JWrLZXQe");
        state.setStateCapitalLongitude(5);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityCodeChar2("96eisfzLjOIt1JczVmREFJk9lBPDY2mB");
        city.setCityCode(3);
        city.setCityLatitude(10);
        city.setCityLongitude(10);
        city.setCityName("8JeKZlPVPqSUCGxSITkwkWHorshMfCzRV7CAsT4aBH153B8D6d");
        city.setCityFlag("foMovaPCtjMBlwGdUKmlrCIAjTlJCOEBuWE0x3Yq7xN36c8NLb");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("IZvt229orEKcYLLfaNAglvRDQDjhJ51fBTJfD7ecDAChLRHnXR");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("JMEqnLyRd1MTuVONDAanO3V2r5SuC3ZX5olBzyKOGMEa5j9FDO");
        addresstype.setAddressTypeDesc("r0M4CJfHFQjfTxvYc0oHPPtrDaCnlDSyIi20Lqmn1LLsZQ7oBo");
        addresstype.setAddressType("Wm28ckMlUH7CGxDRrKXHYt3aKqQilGsowZGPFApgEktcy6oY8p");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setZipcode("WRto7L");
        address.setAddress1("SfGs5GAztkAxWTWJeVKeMbO7aLiLaPaAhbupdwWQKvlfqbZmaW");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("rGuRsPVtoBx0BFigq7L4zqESDnlVQ2ua8hvXxAHEQFfBbmyAof");
        address.setAddressLabel("u8Z9smR9TtH");
        address.setLongitude("Aczim2PytTL5Hv9gFiWjHA2rRsHgBk9nKqR7tJw5xSBNQGCyKt");
        address.setAddress3("jDMWq9FFNWFcGFBKsyc5NgQSfWKQl2jeIpKSp8AB7X7NkGRln4");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("zQdEiC7uaMf6DGTD4NulSEE5Pa8vD5rD4w8E2XfTwiK30dgxQU");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("XXjeKegbCMisGRfD7Z1SuOnyFs1L7ehUZGQLs9eWppIcq8BVsa");
        communicationgroup.setCommGroupName("pqSf1EI03QO8Xn83PtiDGWLuyBmNJga7UAIZUbYZJKUKXr6YQj");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("O6qQWLrd7DDUDpSrhcGTvo7AuoiMVBJaV0c0Pb3Ns7hCeMIHs4");
        communicationtype.setCommTypeName("2LgLPhXhlV2XK4FOmtSphIHQx3HtIlNuMwp9d7vofnD7RAJhFt");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("sYiX2UuW8v");
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        Login login = new Login();
        user.setUserId(null);
        login.setUser(user);
        login.setIsAuthenticated(true);
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setLoginId("odlZHDFpsVJcJcrqPQSZEB5Cf3GDZcu893BrCbkaC1q8r0kgIt");
        login.setFailedLoginAttempts(4);
        login.setServerAuthImage("6TBtJW0WiouivPm9X6Nasa1Ep8aZXO3C");
        login.setServerAuthText("0dfqHkWF27qfcCxv");
        login.setEntityValidator(entityValidator);
        return login;
    }

    @Test
    public void test1Save() {
        try {
            Login login = createLogin(true);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setVersionId(1);
            login.setLoginId("wwiB9qv1D5dTcIYBPoSltfT9q9ogCJhE5hs65T0ERtrxi5y8jV");
            login.setFailedLoginAttempts(2);
            login.setServerAuthImage("yR4S7lJh0Vn3O2lfbxgxUUXz5W6rVlAU");
            login.setServerAuthText("EB5DC99P1XLI9urp");
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
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
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateLogin(EntityTestCriteria contraints, Login login) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            login.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            login.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            login.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            loginRepository.save(login);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "loginId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "Q1Lp9U8Ordum8JlIagOYEQ0GGfrr4LLGYE7cbVA2iFokcOlEqmsFDcQPqzQophcgUz5vaMVqsUBC39i1FqxsJL9BQMoNi3iiL5r00P7DEWPI3jQPf6RSczbkRzTGhF8W0cUVvDKV8YqYED49dQb6GGuhIYYvg5DnIqWOR3eN5nbzEEn8l5FqRPKJ8XzLTyJOiy9IKCOaT"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "mRFTYjes9Q8b6pwIGcMIJXG74qrp5FZDR"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "ElBaTyYdbozaCtRhg"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 14));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "isAuthenticated", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Login login = createLogin(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = login.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(login, null);
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 2:
                        login.setLoginId(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 3:
                        login.setServerAuthImage(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 4:
                        login.setServerAuthText(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 5:
                        login.setFailedLoginAttempts(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 6:
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
