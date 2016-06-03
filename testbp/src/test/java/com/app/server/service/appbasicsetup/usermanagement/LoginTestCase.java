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
import com.app.shared.organization.contactmanagement.Gender;
import com.app.server.repository.organization.contactmanagement.GenderRepository;
import com.app.shared.organization.contactmanagement.Title;
import com.app.server.repository.organization.contactmanagement.TitleRepository;
import com.app.shared.organization.locationmanagement.Language;
import com.app.server.repository.organization.locationmanagement.LanguageRepository;
import com.app.shared.organization.locationmanagement.Timezone;
import com.app.server.repository.organization.locationmanagement.TimezoneRepository;
import com.app.shared.organization.locationmanagement.Address;
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;
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
        user.setIsDeleted(1);
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainHelp("tX3cvcMq8QOExKhqIdzwBqmxE0a87Il7Q6ak2Zr43ZnEiTgVBr");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainName("KI7teAGHfyuAsytlAHFjyZMfux5pr3ZmEK2qVekCxDcAl8VYlO");
        useraccessdomain.setDomainDescription("X7wX7qJQU92mPBP9rv78H3iW92wg635oIzodPF8mjN6qLORVSG");
        useraccessdomain.setDomainIcon("xcXGgIWF7Y0rMG0EBVyDB3oxIxOBJ7e5hzvWJWbkvoqlx9YjOV");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelName("0bjGnF19OrkeOro7ontxnJota702HWO8yjOsFv5N3rfzyIAdJM");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelIcon("qfsSeRVOJimCEQcOnYNUiBtFKxXELtotCzEBfd0eY39rgurHzJ");
        useraccesslevel.setLevelDescription("u0uWVpIo3v2vHIxtypBbDKnUg3ct1t7sT9rQP8W5nxxnXUaKvL");
        useraccesslevel.setLevelHelp("1XNh5DCQkrbQSi3iM3GeYbjU8uE4hD7lxWfOLv09LoelMYNZUy");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setIsDeleted(1);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setIsLocked(1);
        user.setGenTempOneTimePassword(1);
        user.setAllowMultipleLogin(1);
        user.setChangePasswordNextLogin(1);
        user.setSessionTimeout(1663);
        user.setPasswordAlgo("pGoIxihxe235i5iuLtjzcawR8WAKDXs1HYdeb70PFgKs2YWiXf");
        user.setPasswordExpiryDate(new java.sql.Timestamp(1464950657922l));
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1464950657922l));
        user.setUserAccessCode(2056);
        user.setMultiFactorAuthEnabled(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        passrecovery.setAnswer("3UAS2CT218lxBi7AhJRrxqWSg79gYW4pK0Pp6CcCye5FO26z73");
        Question question = new Question();
        question.setLevelid(3);
        question.setQuestionDetails("k0jS3XcMyY");
        question.setQuestionIcon("8J5oDj3GMY0u9RJRiJZPfNXOgCpMSVnQtMrXS3QQNwiOTlsAKh");
        question.setQuestion("WcRbYsOCm1owPtxzh56WbPeemDl8QoiFTvTfY58hLGiUug2vjF");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setAnswer("znUARDwzyvVv0y7eIbOWNiEKdfZ9fm15Y2VwYKMgNIpu1E2F3e");
        passrecovery.setUser(user);
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePassword("pRAHJIeEkXcZ7zS5L5IDiuTw1coJWWZ1");
        userdata.setLast5Passwords("pReYmSKQqB210nnCcDfuYrUxqc1mtk5oe4N083OzDaFpk8xCZd");
        userdata.setOneTimePasswordExpiry(11);
        userdata.setOneTimePassword("4qLVsFJ1RoRWp5YGmH2YEe00jJcsVSwY");
        userdata.setLast5Passwords("oXKzisP0dJmEUG1Stjc06U41JXEBbMUg4jCyrNoVjjCrC6R2hX");
        userdata.setOneTimePasswordExpiry(1);
        userdata.setUser(user);
        userdata.setPassword("4BQIGJEPV8s2uRYhWE1SMXxWdjmtKYVZXTm9iiZB1jC9WSpVcF");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1464950658169l));
        user.setUserData(userdata);
        CoreContacts corecontacts = new CoreContacts();
        Gender gender = new Gender();
        gender.setGender("PS8LCKHMcXkUCpBYIS8TZ16ezZIOL1c7CQzT0dMithmWNXiIVf");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("T0VP2TSrnV1dI44C4D9Rgu33oyrYvepsYNjxUWc6xIEyGktoj8");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Language language = new Language();
        language.setLanguageType("rD2ot6puWb5T32qSuDPJwYajyjblZYox");
        language.setAlpha2("hs");
        language.setLanguageDescription("hZyya41bA2MaeBA03XSLueFzGWGlvZQo2BFmVr6eWIBa4Apdxw");
        language.setAlpha4("zSz2");
        language.setAlpha4parentid(3);
        language.setAlpha3("aQc");
        language.setLanguageIcon("JKD3KkzEEuluzk8WAsaS5qVLmdY8h0GBVHqR0xt4LaBEoRT65i");
        language.setLanguage("ZlbWsNdPqEioLgsLVhWeiE4zZ1ZEZX3MKRcjoNI8eWhkwbwbDD");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCities("ENaCVNCuuRZ7FUbfMjGkh09zUKByCXlGi9siH62BzYbJMkOCQr");
        timezone.setCountry("I7h6E2priBM2VZXuXyOIWxXQ30Xk89xumeTMJb8TsfVnGXdGGO");
        timezone.setUtcdifference(11);
        timezone.setTimeZoneLabel("6RXFpKIA94tLd4OBpoFvOfBmD6bqUgvy66oULEKVysPjtrPNM9");
        timezone.setGmtLabel("ZKDBNRN4ApyJwOTYPxW63jR56arUXTGIQ5x7WqMJKOr3Xajfsl");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeTitle("uYD7vD6FREJqMRoxC0whoZz2cWdbJCp52NcbZBX7WbxBKOwhLR");
        corecontacts.setPhoneNumber("4LaKe0tuXGhtZHEXd4Ek");
        corecontacts.setLastName("P4HriMB3CVAs5v6r40ouccucDuf5bB4Q0rlw6OlqdBnkRnWxpX");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1464950658282l));
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("Yvbw171fOS1Ei4sYX0erZU6jSDCqBgNThh7qV3nBVOc4q80vp2");
        corecontacts.setNativeLastName("shBa6XaMHzC5KgA36yTSyWVVyCPSEZgEd7IJKAG9Y7quI0sSmu");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1464950658317l));
        corecontacts.setNativeFirstName("BKhUdBde7vl6G0EoGSovn8haJywMMFM6BmXCwM7e0eEVKIvmfU");
        corecontacts.setMiddleName("iZT1076Il34LKrxfmmxrLT2qV3kE2r3Z42V6yy3afTuTAKjsis");
        corecontacts.setFirstName("NUj3Y6sZ5im5iUEFcEP7rdxLJZjhR4MP7D1UepGNyDJFGSaDvX");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setNativeMiddleName("APqm7KEPSDKDzqsu0crRevuQTEA74XNX1fDSDPndOCDKvx4k4j");
        corecontacts.setAge(52);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        Country country = new Country();
        country.setCountryFlag("uamxKhQl22bQXwfywFWePRIGmFSXtDjcvItEhYjkJTUSCZzveP");
        country.setCapital("GeGsbKAUFf5F09n7ShIyEYjnJl4ynFPI");
        country.setCurrencyName("Ss2JdMtw2E1P3vIok0FEzL3Ma8owxsd5rvTNYOxzK7CHyWqFRh");
        country.setCurrencyCode("LPG");
        country.setCapitalLatitude(2);
        country.setCountryName("7P1m9fpnuoNwDNwR0wc2A21j2Y8qgzkG70AH5AItmxe4gEZ5ds");
        country.setCountryCode2("TXD");
        country.setCapitalLongitude(4);
        country.setIsoNumeric(383);
        country.setCountryCode1("WFG");
        country.setCurrencySymbol("EcuR3hctyMQSzMvGPMJsroE8gmR0QFdW");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        City city = new City();
        city.setCityCode(1);
        city.setCityLongitude(11);
        city.setCityFlag("UOOsjssnG28kWC2MwEQPIEpEkKmgsE4jCCFLIx9HZhS8GMBMbo");
        city.setCityName("0eslIjZka7vMM27DU1eYni11sraU4qCiX46eq6uVO8lybeACzF");
        city.setCityCodeChar2("2yASfqx0kODuvVWPWDZOKu4LDidHTN5d");
        State state = new State();
        state.setStateDescription("lJBYeOrNtglRUJdz64PbY5l8tyTW9FnWQMxhtHULYRXNGP4vhO");
        state.setStateCapitalLongitude(6);
        state.setStateName("JXxzGq3NoE9rV6cRTPbRLebFcT25CcaK2gyB0IQqabyce4yZjf");
        state.setStateCode(2);
        state.setStateDescription("6AEb4p6bQyM94vDEy2qkk6t0ijdeFYa34OA7A8KAQqkoGgtIwU");
        state.setStateCapitalLongitude(7);
        state.setStateName("SZDs37Ksskgn2kZnRSqOKqdJLmPwT8jUHSmtJuOnHGrLGVmHGL");
        state.setStateCode(2);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar2("cwrFWGelDDMGS2LHx2p3pTOlIUCcMD8z");
        state.setStateCodeChar3("X3Xir1r1qQWoqW5ulpdSRqxnJJ1LVK7j");
        state.setStateCapitalLatitude(4);
        state.setStateFlag("Nsd4QWcqmgpo1XPxLrgwkogbb1Aj7CkEp3eD5p5GBf2xYpJXzp");
        state.setStateCapital("tPPAvf9IAjLNmY5ZnwfnAinRf9GA5tETXzvYcT6zyjyNXoGNLX");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityCode(3);
        city.setCityLongitude(10);
        city.setCityFlag("mq0jtZeXoD0qutKTjAO4rhxaHNOEAY0GMpo0XFjckRnU87YroK");
        city.setCityName("J50ZYRXJi9DQviGTmhcwaQd6SyG2DthdJGoxGIwF7JuAeW1mPV");
        city.setCityCodeChar2("HdEM91pFBcnLuTixTjfq6LdIpBnbyuvJ");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("lIYgR5jCawtpue8UCUHAXNJOwmJHP3bZvQY3Xbog8mvL1x5KyR");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLatitude(8);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("b3NcTSK9anCoo8CF00tR9HSDIhQHG3BPEbkCtCb6M8POnBi1O3");
        addresstype.setAddressTypeIcon("fp684y4nMGITU85LJu5KCnivCkDV8xoXM21jpsB4zERqJqnFmi");
        addresstype.setAddressTypeDesc("o6x1pqwv7iBFmLF0QQC1nmmJl6nYkNzvxGL9xkjp8mrAZ2zGed");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("pIJoWC2hwHvUj9TugTYjjtTp10Y70FmxB9WH6XPCxuJu67oect");
        address.setAddress1("zVAufCgRQzz1YZAZhYHcWEwjIGvpUN8c1XFJoiyNlLbkpmpyx4");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("DOOVG3Bl2kAMqSm2w2UpXDy07ucOpESbn6Zy689NIs6rB7skjJ");
        address.setAddress3("RPY3k49oSyPkgGrOc2AGtJairSndBtVZIsqsalLSg2vO5fKU21");
        address.setAddressLabel("6TqhfcXicwM");
        address.setZipcode("xx8Epa");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("C4jwVrSB7DFwZtXjh5wyPKjJkJVQQoZ4RfGx9aION8MIMDDziB");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("iWtoOrxzsI");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("iOvz7WsSAfIINONl2512E2f2KAaEqGajl7b0kCfCQiDzuiXVRF");
        communicationgroup.setCommGroupName("XmzSGpmUVMmN2brXR20mYscmXVxvssXUgmMtLp67iV7EW8GwcR");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("bqW1FGhEwwsO8BWXb5kThW1qfuSkQEb7qM2l7UDnHLPHCQEayJ");
        communicationtype.setCommTypeName("QxBE5Acd6rAzKMFUkCbaJY8M6geWxUTkj7Y5je5BdPTGIZQgF9");
        communicationtype.setCommTypeDescription("tS01qtRxuTxFUfdSG3QkYPzmR0x6w8sBxS5LNlSJdWppSnOGmz");
        communicationtype.setCommTypeName("RkHIeHaf8zNMFWvGds9ZrISgSx77lM8cOJuo5mODURPoi8jJZu");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommData("AOiBRIUp2g");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        Login login = new Login();
        login.setLoginId("Gu1EGlbMSGPxVnOq4t683Q3TJ7raDOImC7MyF6RC9x5Azag1p1");
        login.setFailedLoginAttempts(10);
        user.setUserId(null);
        login.setUser(user);
        login.setIsAuthenticated(true);
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setServerAuthImage("wjZbmQwqpE6oWf9UZDuwG40ZAgjdIWP8");
        login.setServerAuthText("GJ3qWF4fm5zwZ8L0");
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
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

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
            login.setLoginId("iivaVsjoSP8KAY9faAmgIR5KmxTe6nFr83rgB3NPNJK1SHgkVf");
            login.setFailedLoginAttempts(11);
            login.setServerAuthImage("kwxilULEuxjpCEdPyVYyKpraEFLvyi3m");
            login.setServerAuthText("xg2yhrARjn4TJuEq");
            login.setVersionId(1);
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
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "EOH9D7PbMAyNvrXZjrPCAPvJM9V5qagMQbu1F4noaXcBrZQPVih4EzW9PK5Dsugm6sQjtfDdsgRWrRUYAF85y9buqMHrUfOO21KLK66uwfm5oLEqhM5CP5SpL9PlUHXBgGuKSkTnl4Y4vhVieO0vPYEhxFrDPZ12NcnLGZ2gxBKcGqTbxQx8FdtbfNXaAyuI1urCBokpE"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "0fdmKYtGEtIApjYDumJ108IAsSHd1FtPB"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "6FEIvIpl0EX1EMFjv"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 18));
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
