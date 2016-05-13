package com.app.server.service.organization.contactmanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organization.contactmanagement.CoreContactsRepository;
import com.app.shared.organization.contactmanagement.CoreContacts;
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
import com.app.shared.organization.contactmanagement.Gender;
import com.app.server.repository.organization.contactmanagement.GenderRepository;
import com.app.shared.organization.locationmanagement.Timezone;
import com.app.server.repository.organization.locationmanagement.TimezoneRepository;
import com.app.shared.organization.locationmanagement.Language;
import com.app.server.repository.organization.locationmanagement.LanguageRepository;
import com.app.shared.organization.contactmanagement.Title;
import com.app.server.repository.organization.contactmanagement.TitleRepository;
import com.app.shared.organization.locationmanagement.Address;
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.organization.locationmanagement.AddressType;
import com.app.server.repository.organization.locationmanagement.AddressTypeRepository;
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.contactmanagement.CommunicationData;
import com.app.shared.organization.contactmanagement.CommunicationType;
import com.app.server.repository.organization.contactmanagement.CommunicationTypeRepository;
import com.app.shared.organization.contactmanagement.CommunicationGroup;
import com.app.server.repository.organization.contactmanagement.CommunicationGroupRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase extends EntityTestCriteria {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    private CoreContacts createCoreContacts(Boolean isSave) throws Exception {
        Gender gender = new Gender();
        gender.setGender("OBaqy0sxfoUntTEt12gfLd8Nl8effAfEVtxpYolKKKRQEsz4xD");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCountry("F4a8wmYDvBBKOAW6lMdfDKKCNa02Q8KaDywdTzu6p4kehXhMFs");
        timezone.setUtcdifference(11);
        timezone.setGmtLabel("Kw1ogV96GNa5Sa4OP5R2bvpZktFvz7BoGvKTeVlFMshQ6zKqNf");
        timezone.setTimeZoneLabel("Cp7BLt5fBSQiv7qWgm9uOIHVBEjEQ9GvSQovkmTGvRbsMdEqWN");
        timezone.setCities("1T0syAkscTs07QgersPrLEJxkodT1DDmR32g2lF9PtP3jBXUqW");
        Language language = new Language();
        language.setLanguageDescription("cORTbdvgxggIlKpWzpiXvATVCl3MJzcO5ED5U7aKCw5H6lvwIV");
        language.setAlpha4("4ufy");
        language.setAlpha3("ZrW");
        language.setLanguageIcon("8y2UeHAX7Bmsmwpj0iAp7rmRlemjfmxK12KDPwjHf7LNGLqv2P");
        language.setLanguageType("6yNkOKICCjz7FDau5bUChrjhVVbaYeGU");
        language.setLanguage("JIxaaowYKov7nNUZEwy5P3FZn8oQiiCxqMqiG0dcvbyL6SeP67");
        language.setAlpha4parentid(7);
        language.setAlpha2("dt");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("BaBoTQ1YKpsoVTCjhYZmrH4FlUQpYVJvxNL0DASKqN8d97XH05");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLastName("ufoXoL5HQ5yyyTFBtRNTwTAsb31lAzz2sOydkdKHYvoWMbgGix");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setPhoneNumber("2h48cVySEEPrz2H9xUPf");
        corecontacts.setAge(90);
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1463137332440l));
        corecontacts.setMiddleName("HMuhS8Ks617p4ShCHu2csg7axBAS5ZNHbSW90bQS7itMCkKZfi");
        corecontacts.setNativeMiddleName("bCmRgZsD0AKGoWrrFLWq1XNGXHfC6JmPA2QhFd08C5omoRX3OR");
        corecontacts.setNativeTitle("5BFXS7b8V26VDwEFcd2n1S4zKk9HRkHMUjFrkPdUlqkfR1N4lP");
        corecontacts.setLastName("QkklYGt9V2P0c5EZEFTNFHKtFZuwhniG5TzwiO41IFaFlG178U");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1463137332440l));
        corecontacts.setFirstName("kwV4Tq20PJHNO95TlURxpLomGtqKA0uZncmHfzJwf7Twysljj7");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("z0LAnLlapHHUtSHblheMZLCjXXXsabJpiu7ysTKe65r6U3dMXK");
        corecontacts.setNativeFirstName("ElCYmTyIIdK4emBFGh0uQRC3M6ovct0ONLRdCmrmQ7XO1NJNhx");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setLongitude("7eNvAg02bugsIPcwCI2wXCipb7ltt4UfL7m2RjAJTbV1OhXZTi");
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("3f24qtaU5GS9yNg07BHQyqcVLwDupUi9ojayOjLlnp00d2rICS");
        addresstype.setAddressType("00ScjY3KqMVjJuH1r5CWF8V8FNTcM40hLEXX3EJURILb17XV6k");
        addresstype.setAddressTypeDesc("u31pH3RzIZkmsV4JkYelON0QH0Ny0tOK65oO4tRVA8RrnpkTi4");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        Country country = new Country();
        country.setCurrencyCode("g2L");
        country.setCapitalLatitude(2);
        country.setCountryName("bifEkxTG5VtmTlqgtnIpnF9ZD2NTATBxsnzrKspchL4bNELmnV");
        country.setCountryCode1("O2I");
        country.setCurrencyName("Tbe9SbBCUdY2FauKg47CaHSL1eJFX2zstHjmrxUaMf9KSrat39");
        country.setCapital("nRGZMAeEPSyGD49YIRrXyIsoyQM8yvKC");
        country.setCurrencySymbol("2W9OjxubqaWU0PJJS4sJVKjdrcdh3QGC");
        country.setIsoNumeric(113);
        country.setCapitalLongitude(9);
        country.setCountryFlag("v5q7AbCCkLpunVAZS3hSM6sfE4UYccpEqGTry2tsJ8iFbCn5iv");
        country.setCountryCode2("Kkt");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        City city = new City();
        city.setCityCode(1);
        city.setCityCodeChar2("Ac43uuwHr4VrCjgMQ7riupHm7gX03Esj");
        city.setCityFlag("O8Rr2gYpEEmwDABYo9UT4On3h1NT09FXs64oeTJSPgL5M9LOTl");
        city.setCityLongitude(5);
        city.setCityName("oj7C4eJXp9Jm5aGLYfaG9L1ODtgf3cFNQY7KWJoJBSu8Ajy3Y2");
        city.setCityDescription("QQXvy4PZSwfCkwpcilCcAggMu48SynqBKpR8sfaHWjBXp4wcZQ");
        State state = new State();
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("4AWH0yBPowOW6VdcFM1l0I2U6ef8xn7KqpWrRD07y46hW1j9el");
        state.setStateDescription("dkth7Pa6w3qDfLXapOZfXneZihydZl9eAtFLl1x8qhYsdh5Yiy");
        state.setStateCodeChar2("ToBc1u8coGAoI2eSRwU29t8I6A0svsBb");
        state.setStateCapital("Ywd9Lc1wkestnoZv9ivoAzi3hK8ZPHS2BLOYX2EBCBCZvX3nI5");
        state.setStateCodeChar3("mljrcez7CBnzKAZOKEkX3U7DpQriUNcf");
        state.setStateCapitalLongitude(10);
        state.setStateFlag("rqB5UVY669qlHjkBU9eyQeVfpK6Mzv9xbM8YkBqM5NTk2pGdVh");
        state.setStateCode(1);
        state.setStateCapitalLatitude(3);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityCode(2);
        city.setCityCodeChar2("8gVQuUgdb17ND3QxFYpbgpPNb8CUb3vz");
        city.setCityFlag("ka1EORapNuIQyt2hhZbRQmY3ef8O9dXNsOVZT2xbLWR0ThEK9y");
        city.setCityLongitude(3);
        city.setCityName("N9oxf2ia5xz4y20iEPBzkLpAK3JO8Qu0UcMVDzw8LBUf6dtrzl");
        city.setCityDescription("XUUWL0phI1iPSdzsc4RPV1dUTB7ilrAxiKpYvSOSLKEe77SwCo");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLatitude(10);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setLongitude("Dx5rRBiRsOJNY9LnjUpwyAwS7x3Xsvu17bIGBMqTFXs9QvlquD");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("oPmCAnxqJ8tgTWgrtlTrGw4Fhv0k8Hyvbl6NEvwRZNxt6jNyLD");
        address.setAddress2("QquP0eriNKCViDJ45uXLWAjltAaktJF2J4o7UU03lDdKvJtiPw");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("xjSyvePF1UDPs4426eEM87yxLj1W0B0TC1NrW2wX1wadia7x5j");
        address.setAddressLabel("YTr1i6P4AFZ");
        address.setLatitude("pIwVL6yPAv5vtUixVVEu7A8heCOlaaPKyefuTOUacokMYowUHa");
        address.setZipcode("X4rjxx");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("W32vpjLYthq1K1u7PnR8WhDHTjGNzScqV412TvhNKStyyoBp53");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("KRonbvbQBiQuwIy1dRWIR81oMg0My3YKmMNGLPp7mYir4e9nFG");
        communicationgroup.setCommGroupName("NWMBZuqyNI2jnFRQuKcP4mCcsixdwZqqZSa3bxMuwaun4gfG5j");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeName("dpCHy0p3ldKfI4723JhNcffP2t4iknNGGMU6dVn3RfqaEn9TYy");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("1cSKT4hjyxXHEH1Tlp99CASuLQJHZK3cmo3QzLGbTaQtyqXODY");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey());
        communicationdata.setCommData("HWpoc0zxM4");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        corecontacts.setEntityValidator(entityValidator);
        return corecontacts;
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = createCoreContacts(true);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setVersionId(1);
            corecontacts.setNativeLastName("DrgksHFub2CXudt8VZZ4njfwjCi575zAtl6ZsQBq354NnjUOHm");
            corecontacts.setPhoneNumber("5kM3YasWF1CJUsS4Goyw");
            corecontacts.setAge(55);
            corecontacts.setDateofbirth(new java.sql.Timestamp(1463137332938l));
            corecontacts.setMiddleName("3HYeL8HxoouZaPr2w4R0e50W4YkSuqdyLveqKex93AsIdyMxrg");
            corecontacts.setNativeMiddleName("0aK4wvTid7RnkvLEXSfoiOFYZ9gSaa5blO86v35DKjJvvCBbEU");
            corecontacts.setNativeTitle("tbogstpgZqCEu5ZjgqGx6dpyHBdmNrXPd1i1IUfD9QqbJO2sxO");
            corecontacts.setLastName("JUSWeyw2hWoswghgTyl3eYY9r4ICuDcgjBo1ODSCvJSWnpqNjf");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1463137332991l));
            corecontacts.setFirstName("r2MJpqmaJPyHoBDl2LraYmk71msRV35IxIdevVN4KLYCOWDJ4Y");
            corecontacts.setEmailId("xmTJldr6EE92OulHriIKTXdjWz8GAN2EuvIPG1Wt2dfjOszBuB");
            corecontacts.setNativeFirstName("fkdWGhkKra9GqQbMM0eMbVEoE82T8vDoLAJKSfB0g9kg5c6mr7");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCoreContacts(EntityTestCriteria contraints, CoreContacts corecontacts) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            corecontactsRepository.save(corecontacts);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "firstName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "skOwmsJMDKS0V1D9qmVRDtQo8ZOmBjYjuSbQqdEcRsxCkRYh5Ndu6psUmkpYFyrovq4fafiAdYR3YUzKvGMB7kH9KNFY4ZoGiwFWxiyAsKuG1nFDAYoEyqkeh6La0ycer1Eyxgx1ebm1z7k1RNkqFxnYiWZM0Lm9zxwMwb2kOnRmLSXwnM6JjvtPw4AmCGAizKBQXVnv91qaN0TKenWNiIDZ3hZmEXTPyH1DQ8LnFZ7YtXyUvLcne2zL2AO4tSWiV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "ZRhiTjbzMUY43HBc8gBSMcwUANuv78Wcm2oLKsHiaBicKyI0lccua7pTs7144wMl6Sd5gTPNqMjNcxzuX1POX9iEYvrtHNthI65IlgY5eQzA4sQDTdb2Tlt2R5WECtTXsgKYSWbaX7bHVBaQpyhbhOJRnO3PLT0aoeo0zAk0KBF4v3mp93Eonnya9Qvmkuk3TtQV11YeOStI5WQJqlEua6FOibGN2xUylDqJFaEpUoGJCHFxdqrNZo1Xu4Wibnhmj"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "nz4D2YkzkPRYR0LynnU04O6Il7juWyCXm1yYmUakAov4TORfSqorhnKcu2rM9cgViA5hgjT7TTlsYcQhCI1sWatmfqB3BJCa17Eq92naSvv6W9wj9JPzTWQRYTy655hQeOnLy7Nqa2iO8CP4kUlcFAKWkNy6MBfFD8DY1ipHHTiUZ2XKQvoDJg3qENLZATYQkuApd43pGW76uW7crsDwa4UOmL7JqhKGvskH1OVR5zNCIH8Ets1RrBy5r1YGj1f0g"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "CETC16lmnJ4Ckh1E1jlE0OQTppCGebLNaYrvTdWdbTYcXgJ2JqJqfeoX5ZJAkS1R3"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "qOPEd7t9J433454ogFOtfUft3DZPQxg3OXdBEnuT2wef4KeuNWt3OCAZvBqrdbYcaop7tB3uaOtPoNKPUSKfXVTgZa3lNajsfUOhfQ6EbwojlBIh3IXT9vCnHiyc8ZFl0nnX2PJ3oCI46tXwJsz82dtbse7TytzxLbIhFt3qvXDRKIt2eNbH7p1rDauo9kxtu4QSPhD2whqn7PMteNuIOwWovF6JRRfHrMBEwapdaZSWPFsBkqlS1SGCIlTD1bLbA"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "zAwrNw7ZslYYL5XRObloEXyQVOPNZHwWDRdNjPdpiOitkQXAbJBE2HUFRuu7U7zfCEDN9uhWS9ZKiYYGPfYM16I1ffYwN4K12Mr9Z013JKjJmrm2qEiXkJhb5YhJhOxPvb91ILwn1sRlYG3panpBykfKVh8F9FoHne6HW8z1gSdZxMmvvYPr2RTOpQE4uMu089t0ALsRIaXoHhlmgYSyJE7Hbv3vzwKYaAQ48SpihVNkJCx3Jw4KW3nDrMzb31cLT"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "xf95yJ326nUf1UfFbEfrRgu7q1wbgSX0vpyiN6IagXN5byy2UeghUjVZxkTC9LSh29SCpXLdoYxmnm17ChJwuMEp80nS6nFNNf0YKLAsnXrzYHX8g4gFvf1QQ8CogKtH7gzrilvWTpGJKvFym1Xk1FHCM1r6pIWlp07Oxolfdo1VOYvQv68WWakIvXJ7IFuGr160VBZQOek0mDvMyMZt25dzn2qlk9FlKV7ulPrHjRBhqi1ju6tCokkBrBZ56KHO9"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 159));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "Dj1Z7C6ZqheuE6umEJNw5zpYTrELqfpZOXgx8rmA0C1Ci41UB3FMPaupcP7rFLWln6lwOx5ByyvzhTazE8Ppj7IrNPuNFqrApwIVauInXzVxKY4wNo0f9pKODiR7myBL8YeM1Y7bP7roKpc004vO933lQlFnJbhALVnSmFAes4EI4E6scxrG2lXV6mdpE8PM8jQtDkBAskC7Bo9WaL3dWLOtkaJ5jVRuggCW49OYMdrMmf8F2BiBKPdkNYBARUxYA"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "vfLRWXkBtI7xvj2dw10wp"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CoreContacts corecontacts = createCoreContacts(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = corecontacts.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 2:
                        corecontacts.setFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 3:
                        corecontacts.setMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 5:
                        corecontacts.setLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 6:
                        corecontacts.setNativeTitle(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 7:
                        corecontacts.setNativeFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 8:
                        corecontacts.setNativeMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 9:
                        corecontacts.setNativeLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 10:
                        corecontacts.setAge(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 11:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 12:
                        corecontacts.setEmailId(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 13:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 14:
                        corecontacts.setPhoneNumber(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
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
