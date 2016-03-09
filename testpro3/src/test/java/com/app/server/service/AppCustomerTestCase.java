package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.AppCustomerRepository;
import com.app.shared.customers.AppCustomer;
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
import com.app.shared.customers.AppCustomerCategory;
import com.app.server.repository.AppCustomerCategoryRepository;
import com.app.shared.customers.AppCustomerType;
import com.app.server.repository.AppCustomerTypeRepository;
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
public class AppCustomerTestCase {

    @Autowired
    private AppCustomerRepository<AppCustomer> appcustomerRepository;

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
            AppCustomerCategory appcustomercategory = new AppCustomerCategory();
            appcustomercategory.setCustomerCategory("h5R31D7B68J9SSmMm5UeKfKrKBKI5UpHRpStRS1y8EVxCJ9tBP");
            AppCustomerCategory AppCustomerCategoryTest = appcustomercategoryRepository.save(appcustomercategory);
            map.put("AppCustomerCategoryPrimaryKey", appcustomercategory._getPrimarykey());
            AppCustomerType appcustomertype = new AppCustomerType();
            appcustomertype.setCustomerType("zthbxxlJA9e89LcOwoN17JNDAQlqJZzErk4RQWTUdj7gAesyYH");
            appcustomertype.setDefaults(1);
            appcustomertype.setSequenceId(2147483647);
            AppCustomerType AppCustomerTypeTest = appcustomertypeRepository.save(appcustomertype);
            map.put("AppCustomerTypePrimaryKey", appcustomertype._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(77);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("Tsyi3Zm26Be2wtcnNmA5HILi4lXFcRyEg9coxq1iDXAP31QCJT");
            corecontacts.setFirstName("ujbzudJh8R0wiHvJkNvQlOm9XFZYluOTGriUaIyDT44564OTfr");
            Gender gender = new Gender();
            gender.setGender("tdY8apQmPZXgZKFx3AzirMlSdSYIfDGgvDpKEGgqugpTIH08I2");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("H2");
            language.setAlpha3("tKT");
            language.setAlpha4("qegn");
            language.setAlpha4parentid(5);
            language.setLanguage("f4mgOARtVp8trlCFrsfWLmzEof8uU9T4l3CZnQqzqLOJLjzy6l");
            language.setLanguageDescription("7ahYGaVknV4pmDwzRElOQBXut5ZatNaWvft64G8ESKa092W7cR");
            language.setLanguageIcon("zYV89Te5Q2CFZYBSg5xdSsMzKnoUBa2PeJfxhvpitE10qiGll4");
            language.setLanguageType("dQx3anupCeCQduWDZVFOVI5BuDas862Q");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("00Gx6Anm2F20ukDytyUwh2TUcITWMnu9yV0tscXAd84vVneLxF");
            timezone.setCountry("yg44vKGfyRxUzI9fuheASh9sDMu13j02OtZtc7Wy3Q7UHmpOZu");
            timezone.setGmtLabel("zI8Sep1O3UqzTXHLeBUupRtBItWsFvPCrqbGJswWFQTUQHqpds");
            timezone.setTimeZoneLabel("qHHlIbO2oDkfzc4GUQkWFE7YQ868atJwcvUy0qdrWgCeGNFFNn");
            timezone.setUtcdifference(1);
            Title title = new Title();
            title.setTitles("GvzJ3Bm0Z6d55cDd8mkgUmhg1brgv9LY6ODDH4dbm7mslVScDg");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(122);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("Y2qHbuARwKLEJ2zq7QWHQsnEILXsMj9hRRRzru8nUYxeb2kxut");
            corecontacts.setFirstName("1VSoqo4M7GhYzPrDvGTBAQSl58pjX0LDci0rIAnA6cg1g9Rmgc");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("oz8VY1qj0LOWPBiuu5wbv9EDOygF1RxREJc97sPrTpudVtyPVo");
            corecontacts.setMiddleName("SQwoFIsLRqB2Ekkp54bj1VAdHuz6JO7eGzrbC2oXrklNssoPSJ");
            corecontacts.setNativeFirstName("eJ0TwJ5Pw5udZ3bhIBM4dx6eowf3VpxQkVPSVpXOu55Ohi5DTJ");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("QJP31Ym9Ldi9TuZOtjwebTUn8gF7zX9OaVR7DswroVmDX5EjUD");
            corecontacts.setNativeMiddleName("m82TBYvRs6645ZRpWC8HEfu3W5z5rIQOg14ICqIGMGGgBThuG0");
            corecontacts.setNativeTitle("zhU5NR25NPsnZO72pU5odxn96f7g8xnogolH5pLh2JOlqDZ0mH");
            corecontacts.setPhoneNumber("H0E9NOJOLnWQrrif5jO8");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("d5QanxKpdlamdTkYZ1YnI0WujuDTFFLZupNDBcqttFqhFnE7cZ");
            address.setAddress2("adLKrYdcjQPnXoM79Xtkll4i82yRbmyAeZ3BDSyhwaxi14vZhj");
            address.setAddress3("0MgpHb26NAGs3JOF0iJkhgllb9ahpxItct6e17tpsnMhOOcJDA");
            address.setAddressLabel("Y0pMoG1p1YL");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("m74USnYIsjh1dwuPzXc73Z8wjnd4LNSetBAvxBTjcI4vBaDWGU");
            addresstype.setAddressTypeDesc("mT9y38XsEI67XGyvciTQJxYqVjKJQCtj7oEspBKmIaZAfjOuYf");
            addresstype.setAddressTypeIcon("QuCPZP6UY46cURjl3vT7X81Ym1JWISUcPzz5HOILStH2euJBDr");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("WUwtezm3IJ1vjRpPT0w9RKippcXTsPeg");
            city.setCityDescription("0cA2LuIgzASyHbOUvSpBbGz15S8G4uEqa2parHaTT8vVP2wwWk");
            city.setCityFlag("8mBYeH9IGdwpkyOiRqWLrTbVUuPlgd3n887JtsCDl1mDTNpUyj");
            city.setCityLatitude(0);
            city.setCityLongitude(11);
            city.setCityName("UycN2pMYAPdaTp65e0dtBFniegjXvKQgPkX5HKw1wakMg6YHss");
            Country country = new Country();
            country.setCapital("Rh9uVcQCgXnsslKlfGeXtU4Ulvj4YpEm");
            country.setCapitalLatitude(8);
            country.setCapitalLongitude(11);
            country.setCountryCode1("JGw");
            country.setCountryCode2("bj1");
            country.setCountryFlag("FRpjhEfMeXXb5BnkOzeRy5pTG3ytlcyH52bc3ufUPKcNYqO9tD");
            country.setCountryName("0ssQYOz89JDDtkz8TvQLppjbgAxFhEDGtBkmYaI9B7Wx1WlBfD");
            country.setCurrencyCode("0dI");
            country.setCurrencyName("ddEMzwJsICxmggeIlLYMK2R51T5kLHTpWgto7tRSZvXXqt55FE");
            country.setCurrencySymbol("5zyGoglMXdF6oSAY72tK3VKMAJc4xEUg");
            country.setIsoNumeric(11);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("rri5rfFHz0aeYyxTqtg6tM0wSHsPUO9kwKBd6xFWBqZPm6SDup");
            state.setStateCapitalLatitude(0);
            state.setStateCapitalLongitude(11);
            state.setStateCode(1);
            state.setStateCodeChar2("G2KnTb7HNM3SmwHbQP895B3AbAFRjpqb");
            state.setStateCodeChar3("8Ze11r7JkMjiAYyu2qKSVzIWD8D3WiVW");
            state.setStateDescription("zTNgSD3t4A9iEjB3dIMJRcUC32PbJWKSc8JNMfhVW0WPdR76mT");
            state.setStateFlag("QZEOTwiJuPCNReiUlPwgyVVjKbv6WN8EJE6aYWl6Uyi8hT3Qar");
            state.setStateName("O1qLrHaEHJq2UmjfX75RtmCVZkNXeFPycEBKfUtlrBBnZJCeTh");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("VUNYG4dBuNjWOefqa5Qu1NyVHPH3szjl");
            city.setCityDescription("voYm9Rll3rMBRLefM3EDI4HAkiUigAhO9MuFPrrwJ0BL4tmNeb");
            city.setCityFlag("jfU7DZ4pyALQGSW9YgM53pmbDJLZVAco4XViQ6EjsOE9l2LvtJ");
            city.setCityLatitude(5);
            city.setCityLongitude(5);
            city.setCityName("getVT15obz5EnD9XBBATLNwRNP4XOxWM1AbrNq8PGQUskcF37R");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("VGN6vFEqc5j5URqzt9gDQ8l7Dbj1z6Wepx46fNL9DYM88nMyt0");
            address.setAddress2("7Qvw9R2UTR4OnTQHMmKR32Fx2HY5b46PxwPtAz9MwB6yFouJZo");
            address.setAddress3("bGUKkDiVF064v2hZL7OD00e10opWfSLotowTAoZJSi4NIKApye");
            address.setAddressLabel("zlfG06lsRzJ");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("aupqVltbfuOSQxexyX2Id0wqKw38Oe8YFxhUGnuHGoOHUnJkaM");
            address.setLongitude("VrFgPMbtDqbtVVLTAixVwuVV5u2tdowCNPk62qe2Ybhq0Ydbbq");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("vUb37G");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("y");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("2QTTvgq8wVINyXjzeW15j3XjP4mZQerWfcqDAGrKAiobZAhz6u");
            communicationgroup.setCommGroupName("KBjopSTcRamTD3IkhYC1pxlEUCHvXwLZ5rXgJSknCGrCbb725e");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("c55Qxw8UB5b098aTRD8FxS4IGQLitJuTfIChRzhQnk4DI0qhfS");
            communicationtype.setCommTypeName("9pI5mmOxZ1hV32FGDZOMQx9pxgn6puoLjQe5wo2eu9UvGpqqGN");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("X");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            CoreContacts CoreContactsTest = corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            AppCustomer appcustomer = new AppCustomer();
            appcustomer.setAppCustomerCategory((java.lang.String) AppCustomerCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
            appcustomer.setAppCustomerType((java.lang.String) AppCustomerTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            appcustomer.setContactId((java.lang.String) CoreContactsTest._getPrimarykey());
            appcustomer.setCustomerName("IivhqmVKiRTDVXBmepPliB0CgT7ausYr6orouO74xKNhw4W9c6");
            appcustomer.setCustomerStatus(0);
            appcustomer.setDeploymentModel(true);
            appcustomer.setEvalTimePeriod(2147483647);
            appcustomer.setUserRequested(2147483647);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appcustomer.setEntityValidator(entityValidator);
            appcustomer.isValid();
            appcustomerRepository.save(appcustomer);
            map.put("AppCustomerPrimaryKey", appcustomer._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppCustomerCategoryRepository<AppCustomerCategory> appcustomercategoryRepository;

    @Autowired
    private AppCustomerTypeRepository<AppCustomerType> appcustomertypeRepository;

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
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            AppCustomer appcustomer = appcustomerRepository.findById((java.lang.String) map.get("AppCustomerPrimaryKey"));
            appcustomer.setCustomerName("7qdAgzhVmEjVgXF9EiffbMRuQNTY6cBb0f2VhhVaG01h3wtMvQ");
            appcustomer.setCustomerStatus(1);
            appcustomer.setEvalTimePeriod(2147483647);
            appcustomer.setUserRequested(2147483647);
            appcustomer.setVersionId(1);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appcustomerRepository.update(appcustomer);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByappCustomerCategory() {
        try {
            java.util.List<AppCustomer> listofappCustomerCategory = appcustomerRepository.findByAppCustomerCategory((java.lang.String) map.get("AppCustomerCategoryPrimaryKey"));
            if (listofappCustomerCategory.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            appcustomerRepository.findById((java.lang.String) map.get("AppCustomerPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByappCustomerType() {
        try {
            java.util.List<AppCustomer> listofappCustomerType = appcustomerRepository.findByAppCustomerType((java.lang.String) map.get("AppCustomerTypePrimaryKey"));
            if (listofappCustomerType.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycontactId() {
        try {
            java.util.List<AppCustomer> listofcontactId = appcustomerRepository.findByContactId((java.lang.String) map.get("CoreContactsPrimaryKey"));
            if (listofcontactId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            appcustomerRepository.delete((java.lang.String) map.get("AppCustomerPrimaryKey")); /* Deleting refrenced data */
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            appcustomertypeRepository.delete((java.lang.String) map.get("AppCustomerTypePrimaryKey")); /* Deleting refrenced data */
            appcustomercategoryRepository.delete((java.lang.String) map.get("AppCustomerCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
