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
        gender.setGender("yTzutpqV10UP4P5nR3frqemXNBVLhcBokKRpohASaGfqk3PUdZ");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("tn32lEAUrubTgjNv3fYVR3R1sxdZNf7P53b09B66JzHCDw36p9");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Language language = new Language();
        language.setLanguageType("bIOHiLvJf0NiPzbfqAfnUfc0wDB9nvlQ");
        language.setAlpha2("K3");
        language.setLanguageDescription("9TvvZF63ljAmdjcZreUwlP3seNW5ISTamJhrg0OuYNyNa8ZTu0");
        language.setAlpha4("M3Sh");
        language.setAlpha4parentid(4);
        language.setAlpha3("LqK");
        language.setLanguageIcon("xTc9rsnsvfEA9x08KYCxXHmoiJ4n7yhDXKCZ22HxVVpzqOCnR5");
        language.setLanguage("Dwzp32QyiTxrTnyDHEhnAhFSdINVct0KIOtfGz8cMe6a5FSqQz");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCities("fvMJaqme18Sv14brel4t6i4QvvgnGSSdAmkjz3cI4hTcR7lqY8");
        timezone.setCountry("liayjM5aCFV8FVxq2RgnJfWATbOo1EgQNmuFEV8T7W9C8FNIF1");
        timezone.setUtcdifference(10);
        timezone.setTimeZoneLabel("LaHdQiRWTeP5ykVdgcZlS30aKqqMJgCehdaB67tH0mXR5rW4wG");
        timezone.setGmtLabel("6V8UeH4kVjaOBCjyr6LLV0HLdYpcGekoqUfalPzJjEhI2BHy6Y");
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeTitle("iDc0ybW3rxksdBAm2y4oGz6fA5EK941RrFxhKeZyDF2gOfYKjM");
        corecontacts.setPhoneNumber("5YlhHTmQ9V8ldst25kyl");
        corecontacts.setLastName("I8HIriUGeQ3XtFDlFSDVoK8ZA2y6zFkPCBeZOobE7fBB4aUj3y");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1464950646535l));
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("4FCMN68wAEUxfV30p5hhiuh1ERbFr2TZkeIWVAEGJiBMQ8Mses");
        corecontacts.setNativeLastName("RueOn0dXqmzxt9S1sLRW5L710lyil3uKMKm8mpzJQgzTeGg4qL");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1464950646565l));
        corecontacts.setNativeFirstName("EZ7U7SHMHT4s4Cd1CQKgIu5gPmPgrUa1OCji6BmzY0qCBHiC3M");
        corecontacts.setMiddleName("ryFeOhEaFgpjGw3kfFU3nWRhNCDG7mb698JLfXySVlM7kmpTPO");
        corecontacts.setFirstName("WKT8wjdGiCN3JSvemuVGbIdNnh3pddfW9NKUtiDipiaPRajNvD");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setNativeMiddleName("nUGAuuDuvU5xZGcHrl5xNQ12r5PYquQvtQkGzlt9fLgFyPUq0f");
        corecontacts.setAge(29);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        Country country = new Country();
        country.setCountryFlag("YUe34IG5z1xAKizv2lT1qTui1SZo5VNrZeocaIqWMOsbyTKjfP");
        country.setCapital("OlUemtyAhayGTHFhPYwrGEigYz2s3d9C");
        country.setCurrencyName("BBoAikIce61W9TsVYH6q4v7d7Dhh35kOyVljPFQQn52t7tSKM6");
        country.setCurrencyCode("x3O");
        country.setCapitalLatitude(8);
        country.setCountryName("thbeJoIpDaHtkRT0l41yR2fKtOzTQElzGAVTFYb8iEsJqH08Aw");
        country.setCountryCode2("BmL");
        country.setCapitalLongitude(1);
        country.setIsoNumeric(411);
        country.setCountryCode1("0JA");
        country.setCurrencySymbol("a64y7HhDfjLbUNezONYA6AFCLZYFIAa8");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        City city = new City();
        city.setCityCode(1);
        city.setCityLongitude(7);
        city.setCityFlag("3IL4QdPxykK1UKKJnqxviVO7lYr8muwm23pRbjiEtLcy3rs9PN");
        city.setCityName("bm4X3Hnw72LQKRurJLxDbwPLzyONe0kZuqwA9I91yZao28DbVz");
        city.setCityCodeChar2("kFA3cIzLzhykZhdI45OoVoXwZiLrGqOV");
        State state = new State();
        state.setStateDescription("2gMSR0WEC5GCuGvvyTsfvNdvDoZmU0K80mG9VaDB6LfdFvYvJ9");
        state.setStateCapitalLongitude(4);
        state.setStateName("KTV0gU6sqFOuiOMLuR4avh9JfXm3jmsjs2YfHzkKh6Kt7cqVt3");
        state.setStateCode(1);
        state.setStateDescription("KdaXCRrFzHgloDUxnuK8gdj4tDr2J3uEGAuTWbhSALbIWk6qWn");
        state.setStateCapitalLongitude(4);
        state.setStateName("PceURJ5aWJlDUNeHKcKN8Df9wZTv4ujurRH2b8SynsXYptTgco");
        state.setStateCode(1);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar2("Bn9j6ByYOrAAkUVmlTiLRX6d0NjZmIay");
        state.setStateCodeChar3("PamTzQvtzSvBDbsmgj7sbvLCBCZJgxTS");
        state.setStateCapitalLatitude(8);
        state.setStateFlag("FH90LflANgDn7JUr72YageyNGcSSNaXYEklM2aH7rw6KpFD9q5");
        state.setStateCapital("0U1k22gSJKGZ8i1v6uYrv0QBJTlpt2a5KFYmzWF8BYBo46l8Iw");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityCode(2);
        city.setCityLongitude(4);
        city.setCityFlag("mMxQvK9MW5dPQivCzHGGAK64QupSoa9HuZlnX64rz9ZVwYT9fP");
        city.setCityName("0GclY0Vj4fISnIK4a7OtZt48OOUQ9RJI5n3EGFA3Uw1i1rob0S");
        city.setCityCodeChar2("CHwNQmxaZjXhW9Fryn6Kk4KQjsfZCngt");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("37xFfbX929wQtx264kH6pScMncYwoh5kV3C1OkkY0EFbanXxPY");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLatitude(8);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("2MVICmzJd3MaPfs1reTo1TKd7rVooIjy339H0aWxpDsl0mY4pb");
        addresstype.setAddressTypeIcon("klJzf5lJshIjsdV8HCDBWox4fASea1WFBqXOMiUePbnKz8Kez1");
        addresstype.setAddressTypeDesc("Lw4fN4dbjyvpxBlNzbAOxq9m3MKgN1K5FndSygNQt22c3JM9iN");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("lqFV2JGtaufkQzxxpBbL7QkZ5uIZAvhCMntcgUesjtUaZt73Pg");
        address.setAddress1("Vu9Vj5ttRoXD3vAoeQ6cnZTpUZY0OyKmSQvC7FQ8q0aL8YsrOR");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("ZEEXvp9YGkn4tzHTOzcA3SUDEzqdCoaX5nI4t3H0G6KEIDnD1R");
        address.setAddress3("GjlgErnfDtReoI92Mr8OkaZerhQUP1Q4PLrpjtnS4XPQvV8dAo");
        address.setAddressLabel("zNfj3pGqtbh");
        address.setZipcode("crOkDc");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("9KtNASC30sC5yIdr50iEC4SRLn8OMO0Ij4XDWY0FU16KbMxfTe");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("K30jMqGHYc");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("jFcnIq0JA4YmfdhTvIAwUOaLBni6s7nwVnG3LDczGpibsNabnU");
        communicationgroup.setCommGroupName("kpNCeqhPcwyGUtYwRAeEfvU0zYUqJ5Yw0jMPVh4CX9srOxe5mc");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("KRxwQqGq8cNdMTnlnaoSKRm5xkBWnsvn4bLOiKPuLPsbNIY3bT");
        communicationtype.setCommTypeName("50Z18mJvVF0YCSP1ZBafDossMaD0NGVQW15USTjUOsrtm1uexH");
        communicationtype.setCommTypeDescription("96PY6psq68KlOmY4GPi8kSmFvVYsuEYmPmDZ0qRZzy84QLhlf3");
        communicationtype.setCommTypeName("QRZN2uSxT709px5paoBXTiYdwGH7agfnbhTHeK1EHgC58U5ay6");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommData("Yop9ffCMjE");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setVersionId(1);
            corecontacts.setNativeTitle("bGgj2Qgg20VDyewKf3KZSw4pnmhrv84IxD1G8QPOUaAO5WXCuq");
            corecontacts.setPhoneNumber("fPkuBWtW1zZqpWH6s4Ok");
            corecontacts.setLastName("C3eLyWeW0PXgW5OLV7nNEaUBV30IZLvZxYHTQhA3185ePXMYi6");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1464950647013l));
            corecontacts.setEmailId("fTfNyfylsV5Lel491L6IJ82kboiElQfRO5Sae57f2pr5dvg7qZ");
            corecontacts.setNativeLastName("oFWAx6MvB882T4pdDbLcXOFRzVAS09Fh9QTBZEFn1tFI9thJne");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1464950647051l));
            corecontacts.setNativeFirstName("5b8gkaRrxy04HYVYaUpldRTtkhotVyLhYxBhGEqHkLPYv1DPXg");
            corecontacts.setMiddleName("NCu4d8Ey9piS5TSCJZC82eJUrtpkBfoIZnTc7dy0t3x9ZdYJoE");
            corecontacts.setFirstName("NSDq61goY4xk9Rn1Q7oBaYNkp3qDf7yP2f8BejSbK1qT6VH7ir");
            corecontacts.setNativeMiddleName("NoeOvWDAksyVc52Jc46pFy6PhkXdHvtECkqvZIaA8lY2zLUh5x");
            corecontacts.setAge(15);
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
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "Uw3N83wxI6icMFVbnaXTjZgzTgH0fmdgtvQszBlPVp9HMySjPW0aT8AqZgB4DwzsViOvylxgKXIqKNGB5ybCdfLY6cVPhZ3pQWlC6FugJ3n25S699JLvFIZi3k2JRuGXnCmXG3yo9TPy6Q88WJ8JuzrKIKhmsoX18Kd8FXGsyGpI0FU8CJmPIMeiOIU6kJAnAzxFchb2D3cD0XDDLgZC248cHx4D4OF13Rr0kUDRoumENIDPxzH5SV7Ug33sKmqIt"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "Yv3caC18tXP6S2SEd6lrbbx5prHrLwIsBrSU3twB1mRa8lpW8NQkOpGgIJyV4FNMz8fnEE1ZqidHTvLnjeLUX535moGpTFUjU1ZhhZCcDp6SRAI5tiiogxCecKIQLgPRgsUrPvbQhjKJH8A65Yqre9pZquIlI8GYNySljTmxBpmbgApsCSsCSJMsMlR1YX9WeyUM5Nj7Aqjme35lS1M8Obu11P6TIfKSeYxSvxouGRN3Ef3CANg6W0cGyrkKUvMcn"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "YvEkQNOGSBVqcnzQNeVl8IrL3uSG8of1tjCKeltTbGFT3iX4g4KzN12lj0mezufZSgvoOh3jD8jW048e1HPkIATPjPw09mD9XTsJ3s3btc7SFZTHbUTIqEuuFzBcFiDuLJkEUDK351WxdyInEiinr9IjtBXGJycN2QQyORMgZHdOiZBgk0LFXPVXkWRbITBCdC7bul2Ctd7DIqIMPsOPCeMkvMZrw6oQn6IedYSTPOHsj7aDEGkRp7mP7e2Ed57uE"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "qaDunO0tjlvf9ouXeIR5U3vAN0FwqUJ1QYqgG6bEw744okbPkJx4fuTEEEYmjTygY"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "glJ5nrpgq2zooP568Bav02T7Z4LaYczrrA6VNeAmy5iGJbhSmCukVycZ6Zn0FnhMFg4Q7M1e839cK8fL0wNcFi0L81bHp8lwppsn3Psbcm3AL7YjP3RykWMVAKjNvOk5xXKuxItmHKa4GOTOmlGCqUAAHHRL7QiCo4EnopCjjqApNw0DeK249iyTzKirQjxmznS6Q5cpdY1MdniR2ZmtNgu26en7Pzgtd8KLEbsHguHZmR5JBIxDHl86HxywaLGM4"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "eXfuA2tHw4UzkI90JJKCt8kSPJIKOJWoGPjsecYf4pnEgsgziiIqV70zJEnrFoVsX7JIurTPyCy68nf3ZGmKWdt3BWq1vWEt4v1PJWs6hNzZmG4urE4BcZYyOOh05ekH5zhRW8oh3uPt8h8ADTW9cuJRAu2w9BV83Kt90VIPIy9oOeQE3Xpd5uNV5SeGSjqLQO0eUrMDyCbcbsNiWBX14S9RNhdE3SMLYWYuLBpqtkPXbKBk9huZ0TeLBWTsXkZ9Z"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "VIgx6eTkFhFLHuhSjRFsPlbfJhGJeS1gSyz1yyhNjsMwPvuWm8FPCo2cOnR3uMG98SxctEcsSoGxwwq82RHf3LHJl9Fi9fmpgJQSKIfNvnnjt1CGGbTZblL51b0LNgwNUPmiw63aaePeB8Nep0Fk29VKTzEvvow4geXIIJZ8gnDdzwwOkkrWimprV03hKIHDYE9KCCBVAW7U10f2kKb2WiXyDXYZkhO8u1iPQk8rFlIVlJCjgWtghI6nCyz6qvquI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 221));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "qdup4WUIhgqy5UTtK3TflFIXzzPMUnReYR1msS6UUWMxpvgY5uvFTnd7aZze5BbVxS4HAviVo870294MlueWZG55HptztvNTvX9AF4WDqpv1kVIBOQhYAHWabwSYJENkwsbxr688e0Ul2DKicMajhjAY5dsGKM2V6hFsapyEF1sd9MqQNpfWE5x41mcPW3NGQznfEU0T3iSzeHMYoLpCg1bY7fd5eClhRG5LuhcB4fs4FzKxC3Bx0FfQxSGKewRka"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "RzlfDolGozJcz3a5OvAKw"));
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
