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
import com.app.shared.organization.contactmanagement.CoreContacts;
import com.app.server.repository.organization.contactmanagement.CoreContactsRepository;
import com.app.shared.organization.locationmanagement.Language;
import com.app.server.repository.organization.locationmanagement.LanguageRepository;
import com.app.shared.organization.contactmanagement.Gender;
import com.app.server.repository.organization.contactmanagement.GenderRepository;
import com.app.shared.organization.locationmanagement.Timezone;
import com.app.server.repository.organization.locationmanagement.TimezoneRepository;
import com.app.shared.organization.contactmanagement.Title;
import com.app.server.repository.organization.contactmanagement.TitleRepository;
import com.app.shared.organization.locationmanagement.Address;
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.locationmanagement.AddressType;
import com.app.server.repository.organization.locationmanagement.AddressTypeRepository;
import com.app.shared.organization.contactmanagement.CommunicationData;
import com.app.shared.organization.contactmanagement.CommunicationGroup;
import com.app.server.repository.organization.contactmanagement.CommunicationGroupRepository;
import com.app.shared.organization.contactmanagement.CommunicationType;
import com.app.server.repository.organization.contactmanagement.CommunicationTypeRepository;
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
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setEmailId("HhtvyC6QkbDchybBeth00676YCUUAOapBHnjy0zEQnSIoOdc0w");
        Language language = new Language();
        language.setAlpha4("hwN8");
        language.setLanguage("od6HPGoYKnCnw9iUA7E6usvgxZQuBG6NcPmy48rRDGDS02Y7Xm");
        language.setLanguageIcon("hxmizF6LdSKvHQKSnokTNfze0fWz9OLe50X1tYVzfUVC4RUeNQ");
        language.setAlpha4parentid(8);
        language.setAlpha3("x9j");
        language.setLanguageDescription("iFAozCjkHPTXo70J1FFg2CVw51jNRlLT9WJ2OBeBp5hm1gvTgI");
        language.setAlpha2("0y");
        language.setLanguageType("WfUlZ2leEpzxpsls9pQ9x0z8hGW1nxKB");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("Dx1rkhL53sF4qAMEsABKtqWLBJF7fPvCH10WIZs4RSiPB6ZhG3");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCities("XudL6Vqq29gali5FjuzlAnF1gY2U1YTh4tfxgj9nwMfFiulXSL");
        timezone.setCountry("i6RHeaONLubNx377mowi2Sie3Gw6i18vIdLAIdZgM8V7Onoo0L");
        timezone.setTimeZoneLabel("wEy7HhwNA6wihI3nUvza7y3htBdpZoqajErbwTilN6AKsSI1eZ");
        timezone.setGmtLabel("cmiea1dxfXY6KkyRRaRZidpFBxlOtyp2KzNEyBrvQ9gAxVX2Hw");
        timezone.setUtcdifference(2);
        Title title = new Title();
        title.setTitles("AHdneS4RVUC37FF9nHZ2q7qRliS8jjShvHEd2OD1JaJPBvLtQz");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        corecontacts.setEmailId("pvcWvoG8KDpCGY099Vue2KhgNs5oJQ2ZP1CR36X2tdBYXfWT8J");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(29);
        corecontacts.setNativeTitle("xC35v08VZ1NQkyNz6QSexcO8RqiyRzqZDFZJEuxel0kuUtR2Eu");
        corecontacts.setPhoneNumber("1y6hLXaMf1m2ds8Cfr6G");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1462950613862l));
        corecontacts.setLastName("tKgdESpiy9SlvTYlSzDu5a3jRk5tTgBXg2FJYUeeFRtQCB5o9X");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1462950613862l));
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setMiddleName("Hd60p8ZK0RmGXckgOff0OhKZiGfwl0NMqPuXzCkdLIret0UoBH");
        corecontacts.setContactId("sP5CGx7fSbuOZw4i3QjDVCxQWgvndp6yUtG8glkeSWX1jWgwKq");
        corecontacts.setNativeMiddleName("9ZJdylbTqmQxDFPiuK07APrNabAORlBGwXdfIM0ibzkia07H14");
        corecontacts.setNativeLastName("3HVoHXO3nZXi6WGN20vfmfuuseTbaH3XBdBqjlotb4UQnLUX9a");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setFirstName("smfhJj4uUTdHjRcXdAZ0xEVVq4extQEDGYXsFmcscA1szFoW01");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("h0TKSes8frRUFC7A1vNnr8H6JtixJIEtHrS3glbx8rINKdU1oR");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress3("uf2v7eE86oHviCtMo8IRaixg1oaYTRfC84nAbbBtivNIQ8c3De");
        address.setAddress2("vK5t9DGLPNDzs1KZTJb4KZbbzdqQjTolY0SPEt7Crf4IhE4kWa");
        address.setLongitude("zLzKKc1Vqqsv3IhSdlnZh9p4Ia2iIbCcld5hXLZOSKh1lg20lg");
        State state = new State();
        state.setStateCapital("YGLiBH45yvnf7tUVZCOBeXnoldW62C8KMEMUW9PaIYWMg8yQRv");
        state.setStateName("ifJwwNEo5g3LO7D8wTglAZLtiIGNPMC2Nb78d9phbYIKYfT4zE");
        state.setStateDescription("o8heLFzwo0Owm91ojCbMNZqGEgchRRU1fg6wFBSNW8zNmyZPBS");
        Country country = new Country();
        country.setCountryCode2("nji");
        country.setCurrencySymbol("tj3pd6r0bokCjinBQh2QDRsiuO8xE5Ud");
        country.setCountryName("b3OkMANjjnzwL5ENK0Af23xvEptWCqBrNZXNyiOGZFy4C4jPHG");
        country.setCapitalLongitude(3);
        country.setIsoNumeric(906);
        country.setCurrencyName("6eZoe4d2E10bZlXx6G0vzuL0hDNIsvlBScb8otGceVLB7SCRUi");
        country.setCountryCode1("qKr");
        country.setCurrencyCode("cs3");
        country.setCapitalLatitude(6);
        country.setCountryFlag("xyh15xQJ7DCsLLtDSRzwKj4N8wCakEI0tyvyDLW84snj2L41R7");
        country.setCapital("5k6J0XQqhRRCXc9CvbS3KJMSFGSXDxEr");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateCapital("nN6NeK8kAMFYcT8jN17UfPtJiaMM0kyqxk8dLWpU5lKILzw3J5");
        state.setStateName("mDaVip2faNiMEC1Y7seTsFVGCNbVNqhbMZYTIOmHpWWwSW6dJH");
        state.setStateDescription("grJZxZA6TS3k7TLBQ8z6Odf6PB7MFr8OQIh3yk3LEzl941N7Xl");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("Syp9s6FdOFAFSn2qoR6LErcL0aR3tHwO");
        state.setStateCodeChar2("eZQlWOIfQjbatsRyHXZZ2cv2raH9h2cN");
        state.setStateCapitalLatitude(7);
        state.setStateId("uU4dzYwhCx5zGdRu4gdGh1B5Zdh4k38enDKvfk0m0hsUKznnIZ");
        state.setStateFlag("YaXpxOoydSgafnvTFzmHnsJEBn73NG8zK1k4WzNYX79WSfBGBD");
        state.setStateCapitalLongitude(8);
        state.setStateCode(1);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityLatitude(8);
        city.setCityCode(1);
        city.setCityName("BFFdNq5WkNCG50KKyQM3Gvzzd9oX8o15ODnunSAqu20Yveg2BR");
        city.setCityLatitude(5);
        city.setCityCode(1);
        city.setCityName("YmSzVpprf8jpJy5RoiEcNyjLniSlhYveZc4N9ZIC5qQYSR7H1H");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityId("uEV280aT4bN9Kc1KY0wXjlR1rLioPZQalYzVqllOL5SV3h2j4t");
        city.setCityCodeChar2("ilAAMOHF9hen4pJbE0M786P6D82tCoOO");
        city.setCityFlag("r9wHktYEN2QdePkZxV6v7sOIiqvPdQC4KqoREJaMbXo5g4F8lB");
        city.setCityLongitude(4);
        city.setCityDescription("jXhAYOHlyop2lbf0aDXnmp8k6MdXauI7GMwVbExGz2cvLrp2zH");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("IpjQ3paVBnq61YQAQ8ZqnfMYQftu11vFm3pG9rkMyshxEtXspn");
        addresstype.setAddressTypeIcon("xT6I73qgJpdg2pJ7G1Ef5kwOoELnjqIGjMDkNL3wyccsHO9Mbj");
        addresstype.setAddressType("moPW1nIL38Awz0qwtaVvP5OCEBqJYxjCd2PLNrPwdyrYc767ZB");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setAddress3("zLTnEs3IIsNwyDf5bxdQB9QaoqsSMuzPM20EECVxMa2viRu2lm");
        address.setAddress2("OI4Gw4B2nTCDROBrbwrqMAqpnKIvjp6oH6378J6ECnpNCmUQeI");
        address.setLongitude("HkegKqk8RNkN5a6Mf5wpCaaZaMT6Y4R6bDVp6PWliiMnu6EvTi");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("yJLJ0ADTLP0YNvQaRNZCRenbbMotCsvrwVnQnsex1xZt9e4HoA");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("nMiiIfMGSb1jyPUxiZKMyGTmwXqPa6nZHOkmhcCu1fEtEwIk4L");
        address.setAddressId("n7u9uohX4xs5A0oxwzvz2VDOhY6o0FRaiYFCLjVbVEnnbzkCkq");
        address.setZipcode("c6XHr1");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("w4E0JD4eCVI");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("mPOcb774PxFi8EVF7BXaHStKKJIjkUYkks1PHf06ydjlvURDlo");
        communicationgroup.setCommGroupName("aBiKCohbQuhxfwfVHJqLzaany950QA95tearQqzD70JYqCLXi1");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("6IPeh1jAjv1e0MqsPcJeIf18B1yaVb5jRzzMC8QNc9LKQBmm19");
        communicationtype.setCommTypeName("sUlwuRGwDAvYcyvfaCZ6ntWvuVFbXrHRlyP0M1s28hCA8cwWmw");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("sLh8muG9YYB4UhDDcRmDAeIVopR3JhpbQyQXwSadKyMmczPNWs");
        communicationtype.setCommType("34thOnnDnD6HoFkJxacgkhXYnbLK6zJLdnfOAarJdqiomeSMkm");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommDataId("YhYz3GKmzHypKS9zhXgx2y1Zk5SaamXBeenADwOWqM7NykQohm");
        communicationdata.setCommData("xEbpyKKBiX");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        User user = new User();
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainName("PWcjWfhSRDcBueFzbPGFTIygl83eq2VZBDC1nsjWqV05kaCa5T");
        useraccessdomain.setDomainHelp("M1pV5FPZkwV54j3w71mUp7eeUFeYrtHP8lj58iwCb3wZsj1smD");
        useraccessdomain.setDomainIcon("RPd21TkxHpXaY9ge90AysEgc2kLxxgMi8VWcwoc0CYzdmLTc2H");
        useraccessdomain.setDomainDescription("aRV35hZpO3w55hxuQbjhStDUSgN6Tqz958eBULz5DVNbFooJNm");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelName("1wWeXXfbPGtV6FlG3x93HEHuUaq99D6ntk2gTPo71t3WHLHxEx");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelHelp("Ymg9fYfCvlF3CiQxK6FJAgI7Hu6kBLpXdJgDKB9Z5CJTCjxFbF");
        useraccesslevel.setLevelIcon("PzH8UfxNtjCbJ8pKnPnHaG5I3AboNjmaCPPvPJDoG2SiHAP0fQ");
        useraccesslevel.setLevelDescription("mguaqx9FTUilLuDnN0WJxIIsCiB9z6uUQX8MiYD01Ho9Vker7J");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setUserAccessCode(18934);
        user.setIsDeleted(1);
        user.setPasswordExpiryDate(new java.sql.Timestamp(1462950614333l));
        user.setSessionTimeout(1679);
        user.setAllowMultipleLogin(1);
        user.setGenTempOneTimePassword(1);
        user.setMultiFactorAuthEnabled(1);
        user.setIsLocked(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setPasswordAlgo("remifwxIUgsnE17iFirlN6zVVW3CZrJjwAqdgWUGOfweIAGNTu");
        user.setUserId("3RhEgmbuLvVlovMfggIH6bzGLf68QACMfz8IBgalkaTnDYMoQF");
        user.setChangePasswordNextLogin(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1462950614357l));
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        passrecovery.setAnswer("tYWfm3UPlUKRH3rGAxvK28MYvbBDAzMlIZhRuL14yriNak2S4i");
        Question question = new Question();
        question.setQuestion("SeZ1yLVNQ0vIx6lmFdJbWZg66SmsmDTfxw5jss6KoMMXHR7gfZ");
        question.setLevelid(2);
        question.setQuestionIcon("xvRkFmmsqZN1el9uDonVW7pcOhfr2luq62RASoiz566xgPSaF0");
        question.setQuestionDetails("EmF3PlDJRY");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setPassRecoveryId("Wyo5Piavn2A6BL6JSId6BivHNn7SkUxOzYkYb0v3oc18dmdxeo");
        passrecovery.setAnswer("LIuXlGeroBUuHB9ESAEjMZx9YfjzHEyr70a5hrkq9Z6sHpd2Vj");
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
        passrecovery.setUser(user);
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setPassword("tDUTdsSq7VY9WRtMXtOx0rhQB9IoG7W8MeK0QUiuAB6z9J65fv");
        userdata.setOneTimePassword("bANkn4Vz6cGp0PhZ8Gh1RStWQUNDRhNi");
        userdata.setPassword("XOgCsBkaFdDCSqfYZphXgANcgHXAp4TwRgjJ1mKtre43Yoqhvp");
        userdata.setOneTimePassword("xbMumhUttftp7RfGdmQb5cqySfYlEyYe");
        userdata.setUser(user);
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1462950614585l));
        userdata.setUserDataId("AuU1uQKaYISooYUDbqG9lXlTHRzhegnqUUbjytetYZkRqR9G9Q");
        userdata.setLast5Passwords("C63uvSOXH2LkeiVyOA3IUfAhSDX6O0e7rUwjGTp0gQHHyWgTTM");
        userdata.setOneTimePasswordExpiry(3);
        user.setUserData(userdata);
        Login login = new Login();
        login.setLoginPk("5ANoztrtazyEouh4giGwRossUNNYTZp9u74gART0JgdKG9b8Hf");
        login.setLoginId("kRT3V242ge8AFCVW3eZIYlXwVu3ssgoVmsbMbm8vs48ScNopkR");
        login.setServerAuthText("9nMeU8nYgmwdZ18Y");
        login.setFailedLoginAttempts(4);
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        user.setUserId(null);
        login.setUser(user);
        login.setIsAuthenticated(true);
        login.setServerAuthImage("7879R3U0E6OMzbOGMvP7Iss4ezSFEZH4");
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
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

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
            login.setLoginId("o7NMhyvd2zqOcgiuBLaiPa585fyabjVecsdMMFD1HnmR114Dcl");
            login.setServerAuthText("gukfuOEeu8h6AMgv");
            login.setFailedLoginAttempts(6);
            login.setServerAuthImage("k8zWdjVzYLBC8oygHG7PTGoOiKIWQ8Lq");
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
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "OF74RIRJ4IVjDYf3UgL3KsGzYk4uDWHJcuqujWeRmq7Cb8bxDlNswZbk0BX5G9qol4tUGokJe1COXU6AuHvhaNxc40sl5efqNrXh5cTMq6mkI3fKlDDar4e48OsvYTIok24cjWSEUNrfB5xfc6lYzEUP8e8eDjdoAkqPhojn2RftW84o3wbgFZhevqo92s8WDIGfHXmG1"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "dE7Io28OW9YUWM0Uts4U1HONL1dXxidmn"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "MiMN6ejxCNd9DhnQA"));
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
