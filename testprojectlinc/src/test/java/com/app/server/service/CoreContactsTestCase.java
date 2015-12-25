package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.CoreContactsRepository;
import com.app.shared.contacts.CoreContacts;
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
import com.app.shared.contacts.Gender;
import com.app.server.repository.GenderRepository;
import com.app.shared.location.Language;
import com.app.server.repository.LanguageRepository;
import com.app.shared.location.Timezone;
import com.app.server.repository.TimezoneRepository;
import com.app.shared.contacts.Title;
import com.app.server.repository.TitleRepository;
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
import com.app.shared.contacts.CommunicationData;
import com.app.shared.contacts.CommunicationGroup;
import com.app.server.repository.CommunicationGroupRepository;
import com.app.shared.contacts.CommunicationType;
import com.app.server.repository.CommunicationTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("iYFo1mmJ2ijBGHlqL3Yv6fg5Yxc3pXhTsTy2s7YvvoXe80MtS5");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("mT");
            language.setAlpha3("uy3");
            language.setAlpha4("4jGm");
            language.setAlpha4parentid(0);
            language.setLanguage("yrHNJXl9XXeXJEQVuNUqwfZrfSgX6Za7M46Y7ZV2pyD7RDJeid");
            language.setLanguageDescription("27ENi6kywvXcEAXEfiepOteRqhZ0yRovbY9vG0bfwpz9I0emZf");
            language.setLanguageIcon("X7iMjstLMsfGrhSebd1ZjR3TXbnqULjVYtBhqkXOmXNk3pgpCy");
            language.setLanguageType("GuGi10mOVOS8dz0e5QalbOMuX69BGCoT");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("CYFiSbiIf577i194xWCJO5oFnvhGpUqFsNK9l2xeM1s9q6TYNR");
            timezone.setCountry("o9jvmCY9tGSF06XG06nVpH8P6SgknFRMpMFxR12W5nIBsyGM2i");
            timezone.setGmtLabel("ZAwYOQKB4n6JENZFMwFTlYHIP73C8X0x93q3qKIJoAsmwM2Mtv");
            timezone.setTimeZoneLabel("M7KtF8iyYww9xnil701NoDteO6yLPPGVKyIrCh6aC033hnVMgt");
            timezone.setUtcdifference(11);
            Title title = new Title();
            title.setTitles("JvaBd672oxs7gJr4IqItPYt58jEXuCkahGw1FnTzpuQaCiiXlr");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(59);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("OTFvpZ8J24cCc1VSR235evDnuTQj0NU2gPuJgrVlRwkZOW4DBm");
            corecontacts.setFirstName("0f89coiLu5ZkxiteKjeRsEfz7rGKoxMt9EGd8wanTc8hpL7ecK");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("lLBbZqKYgeF5gkBtLteoG2IJcjjGJc9cX19ORpWav0xKIA25Jd");
            corecontacts.setMiddleName("INRroB4TcIw6JO3VsNiYeAfEI6L9n92IhZHgLO2RZItgFH5chy");
            corecontacts.setNativeFirstName("u2Gj7VKMgHBVY1pmvHKLwsZIEqj4rkeMdyhAz7dr4bp0TogO0L");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("y4AoJ8UdDbhEZVJEfWyN5xgQW5W7Hs3ndqU38MuY4cF7pcpOTq");
            corecontacts.setNativeMiddleName("H15mCJeFZscmZJ1YB5X2T7uqvUu8RvejEPixAGBnXSPkGnQCGL");
            corecontacts.setNativeTitle("zkhOKLtVjRpSLLAcIO0uUibbFyUg0OfnF9QxmMosWnOmArY188");
            corecontacts.setPhoneNumber("iwGgErBWw9tZ3LfrUDc0");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("dmSl1K6p53iGOr3H8lllRqb8FsSw580Mmst8ak2lsNcpWtWAAs");
            address.setAddress2("ybZHHVpkcYPagtJkL876JjE3WvWb7bDDm27NiltoqzvMpKysKF");
            address.setAddress3("xwYlbeS7HpJPlFjFH4XJ1q0k7vHX3ILKtl4IzJ22tIJP6SvhVJ");
            address.setAddressLabel("hFmSmUCvXnK");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("Nmq8n8f5DMli3v1BiV7YgEvQX07379eHFHLjxjYY9zHZTTZoT8");
            addresstype.setAddressTypeDesc("lwO3QN5NXIAU4LazImFAK4mhfdjPYTOiOtjrIVeriNWAnN9p5M");
            addresstype.setAddressTypeIcon("s1sHWukEzZLQqQmzg2ge01rmqM0qyzeG1WwHVvUy0DWk1Ate3P");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("fQH3AhLb1rJcRUR8KzZQQE8MHQCsGpPa");
            city.setCityDescription("g23YaOOxkCn18phHZKfagvee1Pzb6JZ1NzCCW9makvKPe62T8b");
            city.setCityFlag("HceM0Syr51961ISPo88nAMN9NzRvVOzi0w1shH4e67vd4BwHrK");
            city.setCityLatitude(2);
            city.setCityLongitude(5);
            city.setCityName("ooKjYVnVIJBQmnC1aLuseuhyt6suQGnYn0ONcf4Ca1MKJ6vOIO");
            Country country = new Country();
            country.setCapital("iHPfatJZqJ5Abg4P2IZeebCYk4aTmchn");
            country.setCapitalLatitude(6);
            country.setCapitalLongitude(7);
            country.setCountryCode1("fCg");
            country.setCountryCode2("trV");
            country.setCountryFlag("KjlT0yZ0TEaCBUMp2oLstQjhzUlZse80fVBznHxAfbBdNQ9NBO");
            country.setCountryName("oqowqkIYlIWHFM7GZLLF7ycPSaq5n5IJkOkVEcUNizJd5TfWDR");
            country.setCurrencyCode("wZ0");
            country.setCurrencyName("5RtLN4RsSp2kXypJlwIYd2kJKTJDDLnuPmv16Et0kLlYGP7fxl");
            country.setCurrencySymbol("wPoe9dxe42pGsqN0oZWiGtxNDazuVhyv");
            country.setIsoNumeric(3);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("X1mQwVaNwhtc5el1nFXZs1WPdZBiFUnHulzuUJumtcBOOM78ES");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(9);
            state.setStateCode(0);
            state.setStateCodeChar2("7tHJnf8g1qdwFnnsgM962jBaiT7bxSPO");
            state.setStateCodeChar3("IhcEAfFjBQHF3dbVmxQbvWOo8mzARvIQ");
            state.setStateDescription("NuDlDnttifGz9HcVwB04L7BuHMXdqXZojBk1TjXUnTk5ZljQs7");
            state.setStateFlag("T3FDJ6M6n0dmUfx99jlhpCx7AcTfBChBxDxRYH87cc4KgoX1QF");
            state.setStateName("meCX2dHcwNSngSAFSzm6nor1dzA7kafT4BHRHaOTnBlsHUSRY0");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("aAbbqfAcAG0NyJMs1OhWK9xUlSlzum7Y");
            city.setCityDescription("c5FahWxQBjmc4L7JVDLhP5Cf6S1lTAFJJMeKEQStidCx9HRHny");
            city.setCityFlag("kLtjnCKGpZvxxjm1oLhJjvmD5c3fZVYbhQMGopDC7NwEuF2myD");
            city.setCityLatitude(4);
            city.setCityLongitude(4);
            city.setCityName("anzROmUWyJjO2UoSEY1tsQ7xo1z3eU9CnCf2hiB9imX12r6V7i");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("1oy6ejebOgRpQobmyzmFpDn11IfbVzyjX5kobYzmzPbasb6G3Y");
            address.setAddress2("7W4SXSe5WMck2N5WNxdtTUW4b0JzgXDaJ0cRxFw4EDakNstTjj");
            address.setAddress3("l1S5Zhq4NVhznTxsRrJ2PdKHVSToJG53HUJqFrI65sHBS0UB3p");
            address.setAddressLabel("K6eJZx4ui3e");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("tFskg1yzOldFzEmm4Yl9oK5Vh8vmcXPBIfY0GhZQmeWjKpPCkJ");
            address.setLongitude("et9NgvnqdlALaqcpSPpkxs3MuqKo9VkfTg2meVi2HUaUfWPvfO");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("GgkW9c");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("8hH");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("zntSnkdouqYVK1GH1PvVgH5JpTq8tr4XYV2o8GzAeQbyL0nrH6");
            communicationgroup.setCommGroupName("Why8qT8UpYBmPRcRHlEeroSIURdBXlbr1Cm5dB0tO5LmQ0Y6vG");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("f0C4wy8ACTG7ckzBz8AfQ6ywRQcqiR2oabgX83I8CWaoZoL8b5");
            communicationtype.setCommTypeName("NNJPTAPVfPxgTptyPHGlxI9EQYwDUaaUOQmcnqffCT2Rd9mzh1");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("p6I");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            map.put("TimezonePrimaryKey", corecontacts.getTimezone()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

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
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(110);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("pzbviBORqGgGcdhaiD8GwcU8otmN7cUIHM3uWFZ7wSg1leT0AF");
            corecontacts.setFirstName("RqA3YEArr3zcxgtE6A3ibgtVgCqb9cNiYx4eMvqDD2SHm5Km0D");
            corecontacts.setLastName("I2f5EnlKvwrgTtZO58evzaPcXVPfPQGYuzgKA7UaGjJSr5tuur");
            corecontacts.setMiddleName("esYTxioLFWU4aWR332KOvrdCiMKAdKSLHFUUcopqcK2EBmsiE3");
            corecontacts.setNativeFirstName("iOwm0Ej4jgSgL7TWex511Cm7t04ARsJ5hWz1aFiEIgzuis8sih");
            corecontacts.setNativeLastName("W04Pi2jEqVbuhjsosk7fA52DQfxqf5fPMyKtqqA1GVD6eHJRPS");
            corecontacts.setNativeMiddleName("r5yf5TxiG9a4Bl3HJ3g33wWZGk8uR2iTQ2HxVXJKQglLoW2VDY");
            corecontacts.setNativeTitle("HGOKL6GHK9MDVNW63XCq3DT7LP6AcnoUh8V9THSaSmwuC5f9EK");
            corecontacts.setPhoneNumber("hK4gCyeB9Y6u6VKzvNDR");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
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
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
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
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
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
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
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
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
