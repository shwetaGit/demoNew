package com.basehr.app.server.service.aaaboundedcontext.authentication;
import com.basehr.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.basehr.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.basehr.app.server.repository.aaaboundedcontext.authentication.LoginRepository;
import com.basehr.app.shared.aaaboundedcontext.authentication.Login;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.basehr.app.server.service.RandomValueGenerator;
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
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.basehr.app.shared.aaaboundedcontext.authentication.User;
import com.basehr.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import com.basehr.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import com.basehr.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.basehr.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import com.basehr.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.basehr.app.shared.aaaboundedcontext.authentication.PassRecovery;
import com.basehr.app.shared.aaaboundedcontext.authentication.Question;
import com.basehr.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import com.basehr.app.shared.aaaboundedcontext.authentication.UserData;
import com.basehr.app.shared.organizationboundedcontext.contacts.CoreContacts;
import com.basehr.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import com.basehr.app.shared.organizationboundedcontext.location.Timezone;
import com.basehr.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.basehr.app.shared.organizationboundedcontext.location.Language;
import com.basehr.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.basehr.app.shared.organizationboundedcontext.contacts.Title;
import com.basehr.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.basehr.app.shared.organizationboundedcontext.contacts.Gender;
import com.basehr.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.basehr.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.basehr.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.basehr.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.basehr.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.basehr.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import com.basehr.app.shared.organizationboundedcontext.location.Address;
import com.basehr.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.basehr.app.shared.organizationboundedcontext.location.AddressType;
import com.basehr.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.basehr.app.shared.organizationboundedcontext.location.City;
import com.basehr.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.basehr.app.shared.organizationboundedcontext.location.State;
import com.basehr.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.basehr.app.shared.organizationboundedcontext.location.Country;
import com.basehr.app.server.repository.organizationboundedcontext.location.CountryRepository;

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
            String logManagerId = LogManagerFactory.createMultiLogManager(_path + "/");
            LogManager Log = LogManagerFactory.getInstance(logManagerId);
            System.setProperty("LOGGER_ID", logManagerId);
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
        user.setMultiFactorAuthEnabled(1);
        user.setUserAccessCode(9418);
        user.setIsLocked(1);
        user.setIsDeleted(1);
        user.setGenTempOneTimePassword(1);
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainIcon("3FlEmT848CfM2dzmXBTPUX7XqsD7FZkZ3MgRcdyWq42ykmLI72");
        useraccessdomain.setDomainDescription("5T6ECidFkX0pLX1MSxAvia7nF87mpMbHefkZeGnigxl9W764fz");
        useraccessdomain.setDomainName("gov7UhsTYXmEcDslQ58PamPfprWUePwnyOgXwFPcpqNmz5D92c");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("HyvALb5o4JEok9NC69QXbByJfY0StsDD3NJbl6OxCmDpI1BAG6");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("8zUacLpLoF66PhVmYEjSgCfZXZtv2tJyvyfVPxb0A1OpQYw57M");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelIcon("JfFc0tt6d9OJV9kkBpzBGSvx88VZbwT6xrvQ6LGAV9OPpYdk4r");
        useraccesslevel.setLevelName("tnbDn42VUedRRDHARA8JeipoUSMSGNwnzZXnCzyedXcxHwpocO");
        useraccesslevel.setLevelDescription("SgCK7KgyBdsgY13jfv1yVnraNfMuOAnsbJv26XTk7GfyaDdrYW");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setMultiFactorAuthEnabled(1);
        user.setUserAccessCode(43279);
        user.setIsLocked(1);
        user.setIsDeleted(1);
        user.setGenTempOneTimePassword(1);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setAllowMultipleLogin(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1461751811999l));
        user.setChangePasswordNextLogin(1);
        user.setSessionTimeout(2625);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setPasswordExpiryDate(new java.sql.Timestamp(1461751812030l));
        user.setPasswordAlgo("fkC60VPHfBMgvUCy8xMtJJ2Uh0sCE5jP7H9X04ZNqADsJr8n3k");
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestionDetails("F7mBvpyJKN");
        question.setQuestionIcon("ixkqyaZ715Cv8pZLUEUFmS5MT6UpawEwzFkxoPoKLuqLwzCR1l");
        question.setLevelid(11);
        question.setQuestion("ydbMi2UmdlZQuw0awnIfkGHL6vyGPShNnHjOe8NZSmrEBtn245");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        passrecovery.setAnswer("hJEdkWKoLhaC0JA267HI7c1uCLz5LOFFFasWERA4Cz35YHYPwd");
        passrecovery.setUser(user);
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePassword("eGMEbQ0Jivso7PjaSGx2CeBv6dWMyM2z");
        userdata.setOneTimePassword("ZDWXwA9LuZOVKC6d0ndjO9LuJcEOSFBM");
        userdata.setUser(user);
        userdata.setOneTimePasswordExpiry(9);
        userdata.setPassword("uURAvLdJTcTJFDCcU8WMTX7h6FbsZxwxXtuW32UCUOLC1NSG6f");
        userdata.setLast5Passwords("vuF1jjQZV0hnuaQoF7QRBoJvFNq2rFE4vRxMWFxbgfsZzkAYO8");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1461751812227l));
        user.setUserData(userdata);
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setNativeMiddleName("hhdsOazupspTpQsgKSjc3IrXKoLqtrmHJEOMDo0CjaHFnxo8gn");
        corecontacts.setNativeLastName("CdgzjczeVTVHZ4tCRGK38ZHLkyMYfVAge3aEHWQNn7Kvx1k2cV");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1461751812290l));
        corecontacts.setNativeFirstName("BnXXmzadqKfuLSwsm2UBPB9q04XLj52Nx3wyv68AKx5UWdP7Or");
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("t6XkJooIhQznv7vrlM8qZ2GkXUaC4kX37Wmx8HFuVLX91erIDE");
        timezone.setTimeZoneLabel("BHMYqQ51Ef3xkcFp7r1hieExfhceYek82aiW9IFzYWgtRgxIKB");
        timezone.setCountry("5bDMxwYB1e32QOipTYkHyZm082g7FuWGYZ8VgfbmKGJQN126rG");
        timezone.setUtcdifference(5);
        timezone.setCities("h9MbdG58grRz10xjmsi1ElgqWDvXzwDreXO8xApsMSuxVc1hHF");
        Language language = new Language();
        language.setLanguage("d3zkixzcptaxroexjig8jKE1NjbctlTGIk4xrKDc1JKozZ7FST");
        language.setLanguageType("7i3L3dy6nasj6OAqYe0CKbdVoY6epKkk");
        language.setLanguageIcon("2A0C8Jf0t5MwJqrF1blLnyVm5h1fOElj3oztk0aPifYl1jqshg");
        language.setLanguageDescription("RfnxpHZJoePd6TuIOLrfVL8VFc5vYBJn97GRWY0gFbpMnzMqY1");
        language.setAlpha3("nCf");
        language.setAlpha4parentid(9);
        language.setAlpha4("XtVI");
        language.setAlpha2("Jx");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("Zfo3a2MzZSjOhlv1aegH62xnCU0D5MgAzP3bhVqXifHLFcJ34H");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("G3RQqOcczrb3ydMfMHBn8ZRcqVMnqiOuoeqcyx9wS31waydlix");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        corecontacts.setNativeMiddleName("1RtoD7y0zyvhc2cvvPq0DmSrdD8vmAKft0nWuLyznRy5LfaWug");
        corecontacts.setNativeLastName("qvUTO6vpkFzmorvLtf3dMAAUBYbVqmt0qv7ysPcedKGTQLkqul");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1461751812309l));
        corecontacts.setNativeFirstName("hwMjwdxybeZzxjbV3BWliINqUg5IO0Q8KGs8x3WGOq36Yl6E93");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setFirstName("rlH1t9tIeR77vbIZTAlObrPNiAtwfapYjziSetpVBXpwyIWANM");
        corecontacts.setAge(48);
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1461751812438l));
        corecontacts.setNativeTitle("haBqucAcoVDD3EGpj0BrVWcLh2k4AwJVHygcGHQQCof8bng35c");
        corecontacts.setEmailId("In7H10IoFolaQSUPgpRSn2VTdQHphoRGLX59SwMpaaKY4nSaQW");
        corecontacts.setPhoneNumber("kzDcLZPi2oX8Z5V9UjW9");
        corecontacts.setMiddleName("WG494vv0t9mCGmM0JFQQ5gcxmczLjAwqOXza6diPStNCkvtxRi");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setLastName("YIdCHanxvv78W2Dsv0IabsVDuSN036hvsuHUadPQGjqZeSZRbC");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("GSAhqZlDix9hTcG5HMsTFjYCHZOc919ypLQUjfaxNbwAJS5W1U");
        communicationtype.setCommTypeDescription("vzxhALI0cMOW01XBxO3R6k6c4woPNlXofnFfVeRkI8QHZL0ld8");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("9LGesr6xr7aSLhleRQC0JXlX34TukuCPuk5LHmAIzQ5BNPqE52");
        communicationgroup.setCommGroupName("IDJk76jGzKHJJm4HrmupgykvxfXPSMub4hl9XLPpJCBSgRRoUq");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeName("j0hP6nVE8VjvMboUc436aOShRmapozoeJkasN3l1Frrixj4DPg");
        communicationtype.setCommTypeDescription("kQN5QbazhiJ7QJGDVwnTcqyXUweA2CQuE0yZOHN5K9nPzClOre");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("mToVoqG2Ok");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setLongitude("2dy8QUKo2QSaeRt8CPHj9NflNX8GVseG9xEbQR4DOfYnjCZImG");
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("pBzJkiMMUAHPY6Y3BzoO6a4zOLoDHeUDPKB8RRqPSeaUq23XmG");
        addresstype.setAddressType("PeHeh7yaj3RuGURuy7bl11SBr321qpaASlQsWqgWPc2uuB6kXQ");
        addresstype.setAddressTypeDesc("dfN7kbPIaCk2lEVhzKKQAi6UAGbgqfVALS3ViSFn3KBNSyptUC");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityFlag("cXetEimCeqbeSc0h1FjvTh0UDYHg65GuoyHZZoeAMRvipTSFJP");
        city.setCityCode(2);
        city.setCityLatitude(10);
        city.setCityLongitude(11);
        State state = new State();
        Country country = new Country();
        country.setCurrencySymbol("vChvbr9bQPkXqyiVQsZF2J599TLIOe9m");
        country.setIsoNumeric(644);
        country.setCountryCode1("Icc");
        country.setCapital("XrLCVAgL0ayBuKWKO6IIEVBjGPmXIuv9");
        country.setCountryName("XVevAQS98pUmJY7bqitBNuF2Y6GDY5jDi5VHXwvAdWDkWwq51r");
        country.setCountryFlag("v1oaBmcqfP2HvAZU24LSBySNB8ZUpqI5bdd4mOV3agqgFNDfoh");
        country.setCurrencyCode("w37");
        country.setCapitalLongitude(11);
        country.setCountryCode2("S84");
        country.setCapitalLatitude(9);
        country.setCurrencyName("pFwqrTvRrEhVuAhhtqHRVYXGg2zmPQFyAMAib84A6by9PpkKVM");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLatitude(7);
        state.setStateCodeChar2("VVTwSaeu8D7zVqwm9o2YncJkyijhIgVi");
        state.setStateCode(2);
        state.setStateCapitalLongitude(1);
        state.setStateName("s6PDMDnXfX2piEqWrEI3wlpNerycztVxEV9ukn2eKgkgeo3JE4");
        state.setStateFlag("7kgq1t9MQEIuEep0337bkcigpwPFT4iGSYXgdZ9hpJf5lqdtI6");
        state.setStateCodeChar3("jkj4FQABswPrX5P9kDbyN7uDZbjEpJ71");
        state.setStateCapital("1CfnVQlTtn85eh6J6f2CD5aSVtCdteRil6ky4qib9PSezE4c1p");
        state.setStateDescription("HOXLXZLNbQmbHZfFReyrP70Bipc5zwU4LG7PbaUu7YZovUxfoc");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityFlag("wkA8h0PQXZ5QfA8rSIWM1watPnUsFHCLQMYg0W922qAE01aA8L");
        city.setCityCode(2);
        city.setCityLatitude(3);
        city.setCityLongitude(8);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("UE3QwTV8UnzFtMcYqQJaySOIlrL1PT7TVvWa5zYSgqupfGLhSc");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("ED3rfVOHhgAjFGJ8KvHasY8OeL4lzZNF");
        city.setCityName("cPPPxu4vGdAZ7AxQ4wuJp7Tj8wqt0CvqoRcU0prr3mMX6dyIuT");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setLongitude("LQ5Ig9jYbKMEpuug1YY9wtSpxs80q9lU8Vu7hGSoHvsWqZza9O");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("GDCOOyJk952cUq3KWLiAleRcbR7z7KgNRAaXJd4jmipuNo4WkZ");
        address.setAddress1("8HomF2I8EXR1g3hc2AwZb2NW3PxVVoN62sgAUNPmZhrgXaOi2c");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("veBCrURIiXjZU61ZZi1bx11aNnDgqaSLDCZ6yGRukpVfNHUY6L");
        address.setLatitude("LsSMwtGzYvcS1N0Tgk59yvspx9SnTdSHwNgm4GImKL7Upj2EnR");
        address.setZipcode("Mz6ZBh");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        address.setAddressLabel("dgJba200XUb");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        Login login = new Login();
        login.setFailedLoginAttempts(5);
        login.setIsAuthenticated(true);
        login.setLoginId("cGuEDJFiKSL8oOX0Ot233nzvQKOhTQ5Gl3t4eTVfqWRCMRskOv");
        user.setUserId(null);
        login.setUser(user);
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setServerAuthImage("GD99pMk3vwnYeB0A1xx89ToYtbPpNta0");
        login.setServerAuthText("6evEkuXoAt92RsaO");
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
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(8);
            login.setVersionId(1);
            login.setLoginId("QATjZ8HPCtcYeepbGROyYyfUdC8lU1eEq7na8m6MKKFzS9xsno");
            login.setServerAuthImage("TaqFr1chtAV6YeZGxztn3N3ko9l1PwMi");
            login.setServerAuthText("BjJJSwUGRzOITJnM");
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
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "brapkzGsVtyeeDrDgbgOBRDyNPCmvPVH5VbBO4YiY40NTr8jyzKQXEnF5WKOdeMEXdmGxC9gRLPjpAmbLeSxDfNVnAw5hUONBpnB0yl3DOWHXy7Rbn8xKJ4xp7fkUJRiHM4i925z9khRMT871nmYFCSlKNkgkdeYVe4Ooft0XARwGRdQyrewPT1J659rGrYApujkuLKD6"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "jkbfxQKgHI30NswQJNIyfH5zTmwpkyoMy"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "R6MBiv1ck7L7rmScA"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 20));
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
