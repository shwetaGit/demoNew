package com.app.server.service.organizationboundedcontext.contacts;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.organizationboundedcontext.contacts.Title;
import com.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.app.shared.organizationboundedcontext.contacts.Gender;
import com.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.app.shared.organizationboundedcontext.location.Language;
import com.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.app.shared.organizationboundedcontext.location.Timezone;
import com.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

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
        entityContraint = addingListOfFieldForNegativeTesting();
    }

    private CoreContacts createCoreContacts(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Title title = new Title();
        title.setTitles("ursPkeGbyyr3B4Bd2Aee0Rl40sVFD8NcDnKKxcWhOsu9XTct87");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
        }
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("XgFnjkZga3ELyvGqydGcrHsExVqxjdjJXtnA7P7geRcChEjobj");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
        }
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        Language language = new Language();
        language.setAlpha4parentid(10);
        language.setLanguageType("hxUyxrDJzjf7exeUx7iurRqEBUJG3TZi");
        language.setLanguage("Wdl81WPfbwZzhGbqRG5MKsoGv2ldjRwtmH456zLFOS3Qy5yNFd");
        language.setAlpha2("v9");
        language.setLanguageDescription("HTBPlcG4su6Q3QS82heEg7TGt8XQxQM0NOnfZ1B1Op6sMgV7Jl");
        language.setAlpha4("pG3T");
        language.setAlpha3("Orq");
        language.setLanguageIcon("q5kdOJnbEhFlniI8bQVd1xXQvb3ncroTlPYB3oF2ikRkTrLkIL");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
        }
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        Timezone timezone = new Timezone();
        timezone.setCities("RbrCvAFgcAWa4RGkmoCGOQEICybHP3GrLEg0F59ITkVyzPjvKO");
        timezone.setTimeZoneLabel("YTrPWrsYCeROxIGoCmC9LAZyClbtW8M7dY9SzdwyZMvsyBkAVf");
        timezone.setUtcdifference(2);
        timezone.setCountry("0RSH14LXtcIhqHi7lenNswoHnS7UdepoRSrQKmXprGwjuSRZPP");
        timezone.setGmtLabel("9BiAQa9IGb8wTbp6zhQf8cJRFaDG9pMTdgayxESVqSWHjf74nL");
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setFirstName("CGTbyVJCleSFFJSs7D9hTcutYHOynQEUwyr1jJoC3zxSQKNw9y");
        corecontacts.setNativeTitle("rIqi1GkSIMZNR5rB0Vz4FdLpd9tu3gdHAOnspRWpeh5bULKklu");
        corecontacts.setAge(76);
        corecontacts.setPhoneNumber("uK8Pc5zFfpwmxRp0OKip");
        corecontacts.setEmailId("3VElseFsYObrqun1xrObEgdw2Q65fftinBMgevonWNvM5ujVii");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459233519642l));
        corecontacts.setMiddleName("GZopi4pklVsOmPVJQPdctf53zXDUt2ARQOTqV5R1bJ391kGebK");
        corecontacts.setNativeFirstName("vx4UTDsNR1KDVmtI9cBH9EHTHg5y8wZjy1uhRWkZbnYwg9rCQt");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setLastName("2ThlgAZETaWowmszvhTnwGPEscgkGCYA0YVXEI1b4kLc69rqsV");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLastName("udfGHbqkuB9RWWhdzaxtlvuKEyoJCa2eSmYUF85ycjLkpWSEkC");
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459233519782l));
        corecontacts.setNativeMiddleName("tDXcHlKcQJePjLuSeRmYN4xrVZSTI9sFcw3enJcCXoiE2wP1nE");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("NDbYTSNamyNjtzjL6kJx7sBi5nXlZsixU0ijh0xHQx6BYk0iBG");
        communicationgroup.setCommGroupDescription("1RisyNF1n7nNuOB6SLAb7aAAZkwIQn783wXoghpb7y0Iq96Jqi");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        }
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("3VCN5MerFQIasetVNQekP0FpBZG4JovHTc0gTwuIDyafuPING6");
        communicationtype.setCommTypeName("q0IpnL9gWG6U1ATCVK0VqhZWcm6HOYnw7Agw6kVrtm73sd4MST");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
        }
        map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress1("YMHiLj7xrxUP8dOCPqZ7qIPuq4JfsoUzqT6wN9fxJs95JDoHg8");
        address.setZipcode("gd3CAB");
        address.setAddress2("71V9gADVAfP7IoR7IXZAFEipvmYKwjP0Ll8QqkZFl3e9zGNYWP");
        address.setLatitude("cZW7vclhm3mb6mAAvZLufhL2LRXXRrg25rEpfrDFA1TkzxVi1c");
        State state = new State();
        state.setStateCodeChar2("0EffQWNa7GWEzB8FdiQxYUlPUPxNTQNX");
        state.setStateCapitalLongitude(10);
        state.setStateCodeChar3("P7j31DpzT6iyyjpRvpgZtVWD7CfaRJZ2");
        state.setStateDescription("PGSsmAjdxoGeonYEdGtyn3lX5g0BLHD2AMW2UjgcZQ8i2sR5dO");
        state.setStateFlag("p6IZX1HBClwMFa0VhvOqfumj6KWyPy9N55Z6USNLn5TY5yPQoT");
        Country country = new Country();
        country.setCapitalLatitude(11);
        country.setCurrencySymbol("JuMTZadR87X8P9XZTUnW8AXSVvNmt1aF");
        country.setCapitalLongitude(4);
        country.setCapital("zvfWA64zIdo0plfj34Qi9ovsNjnKY1gI");
        country.setCountryCode1("czL");
        country.setIsoNumeric(10);
        country.setCountryFlag("AbSIVg1BNvPmKHD03EnqiNDOBzbIL0l8phWh55o0U3gMwmc7gZ");
        country.setCountryName("1mlTN8z3vevTKdyuFlqFTvCxlqw8ZBxlKF9OPh7H1fSVd12e73");
        country.setCountryCode2("s3K");
        country.setCurrencyCode("edw");
        country.setCurrencyName("rssdRvvVwoaQXWhPxWycbqamV9YoKhaTAt8FWvvsFClKHmGDIX");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
        }
        map.put("CountryPrimaryKey", country._getPrimarykey());
        state.setStateCodeChar2("73Z8RSFOF0XNfsSGZMM2CPh5Jkp4DMEi");
        state.setStateCapitalLongitude(3);
        state.setStateCodeChar3("uT2iwfKyS2XePOcAfS0bVJWGXq5f8hJk");
        state.setStateDescription("4WQAsblTStnnDAPuRKlymrsN8JPrOI6JvuBpfSQCLUkfpBAZXs");
        state.setStateFlag("WL2uSMjGOyoK8dsR3jCyQg1pSN8sw9M2ya3ohmIhL8t2Lq1xCm");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLatitude(10);
        state.setStateName("Ak3AMhRDECwkrHtNFmSEeV9NgYSsj8Amixb9Zm4aUnZ1h4YUb3");
        state.setStateCapital("J5WHbxLsyez3bj2d6ZCLjBNzYmnzbDwC1YCvXVd842mbpJsgG6");
        state.setStateCode(1);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
        }
        map.put("StatePrimaryKey", state._getPrimarykey());
        City city = new City();
        city.setCityLatitude(10);
        city.setCityLatitude(1);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("upCTEjy73wCft3PQnmnRL1fbFW2x75z6");
        city.setCityCode(1);
        city.setCityDescription("OOTHzplYdWIgm35PTFG5Z2Itt8NsIIbFXrfurXvwyQaq2M3svY");
        city.setCityLongitude(3);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("q6UL6oypkk0j0tBENHmCduJ0pT7vOXAdjmePVSvEanZlIidqHL");
        city.setCityFlag("OuN4GKVYr75aMMowTzgLvgVILDkSk5Ai7ymTbv5k3ZRFNzVBNI");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
        }
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("a3JneBDYpUEDG9s5mmbHf0DBETr0tvWaMqWzoTKPI0ZnaWKViP");
        addresstype.setAddressTypeDesc("44ZtQxVcW07EDdTePatuU2MqMhK9UrqTV2eRDkTwQAR9SOh0r8");
        addresstype.setAddressType("u2kOrONim880pbeFK1y6zVhgNUuiAyjWNsT6XqVGikeSsfpSQG");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
        }
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        address.setAddress1("xnNsDDzITBg7UhN9xUa4nlhCYrYRgc0qvfccTq9HeU5LvXkBln");
        address.setZipcode("oX8FHd");
        address.setAddress2("ViNwkeUwTWWPxisnLvUCFxjTRwx4HzkjBG0dNeWCeU3AFvac1S");
        address.setLatitude("tPDa7kPXxQKOkshqckWlTY6VgdHN1XPF98zeOmB94DRchR21Dd");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("P3msbQIG4IB");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey());
        address.setAddress3("81vPNeJcsAZaCpSiviZQxLghHuKDTYpZjXRhUAfkstfsOIRd0C");
        address.setLongitude("dJIBig5NGArDZHAVsnWqBWFdbSQBeFlflH5CanNLTirjAQl2k9");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
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
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setFirstName("dDjpIZDxmI53tDc0PjEGeZUndwEP7FFdopRxVoInwVOw44IKL1");
            corecontacts.setNativeTitle("uu2yytoGF1tajRTKLu4AmkVTJQLquv0uvnUzw0IqhVNU0B058M");
            corecontacts.setAge(83);
            corecontacts.setPhoneNumber("sqmuaju879L4VyC26CjK");
            corecontacts.setEmailId("Y7QssebkwgXbVZoeXynja94toJ9PZFYvq4BOEWGik36qq7do2Q");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1459233520229l));
            corecontacts.setMiddleName("UIMi3OMTXKPIm2QAPGndDpepyrcqMfaXh8sIoP9VadSWydBqaL");
            corecontacts.setNativeFirstName("GoBTmcf5VL8WH9Y3hX42Fr4PQ9UKxhFGkbCGN4ZhS0CssIxuld");
            corecontacts.setLastName("LvjUm8EnpjJRtWAJPNToIE39TETppjb8fNEikTazt0EBisYHM8");
            corecontacts.setNativeLastName("YqDPlHOW23UGLv2ysP5XaJN2qmfti2cHd6SKZrW1uNvrjWWKZz");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1459233520340l));
            corecontacts.setVersionId(1);
            corecontacts.setNativeMiddleName("TvMVZhXIud1KZeJL8svP6B9X5q35qz0a2nZHEfjpTR87YNSR7W");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
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
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCoreContacts(EntityTestCriteria contraints, CoreContacts corecontacts) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "1WgcSvAErVah1vKEA8XYBB3AKfWQYY5H8IVEPt33fjmzMlRS4lVIAnCGRZosq12Ad8zQ0iVuj5Ldyg91vdJ4e1dKXPDXGI3pkp3WZda4LKrrqaOPr04ax50UDxWxt1aTI9V2CnupZ57JEZTGL1XOxkfMYiCDNm05wD8Q2o1eCTtbMLyvshD6vgwoivgwkdf8SI0ecelJS3mxdLIw7UZU8DOIF3TkPJBFeBcxv3bfsb60D1ZgYuNFg1Zp4rAeOT8U9"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "Rou4AoyPZi6M0dqfoP1LHulshKIk9LkmizFRZAMZQFVnUDJhkGaacxDfJtCCt8a96s70u008Ru4xR1gvu60gTYyWOkF2bOBTqcFoedQBLsEY0K9Nu9HvOrR87tnE7oohjKPRRrSZZMjOhFHJeoDpizt9Vb1mkKPtuBkvr7hmTvSAycz4mTva4Ic53C49BSd3asVxHzyLmoREJTHLzvLTOrjlzlWEmI24tXWbTapHLQ95xESKMfVXk7VekdN93ecpj"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "yL3Zska0fGNwVu0HgnCZkfc9jQaCsn2xaq322VKeczAsKOKF7p2q0wemkPCRkXtHdNXWsT2g1ZtAN0ckXWea3ovA1KJvwjJZj1ZzIRbI9CbcWUqZhojIkOfyLPhWi5Hv7iZrUzNSGiwk9N1PWDtlWTiAdUpaH8YK9eI7cH7djBEa1Jck9RAqgqn5634y0ZghKrTNuwi5czIvvLv95cyVha5SnRMQlyLfjbbdKw06svoyhPdzxfeqHs2ZHytGrmg0r"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "ND4pQRc7rnxEeN3qGlYsSLzr489tXUH1VOoj9Uvu3xgct1GRqx3KzpjwT9LlUwl4B"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "oHHPImiZE9XKfssKCS2io3g7l2CJK4UVmu1FtJGqt6awsf8zrpyGYCCRdDKcc7LhABB6ggjiKpzGZ0DkQSLagJqPoSD4TF3E2A89JW6Vmj9vaeBlTUDAvEyVzH5PQ62UDSkZCkWPEvaYSSVddPfH34hvnZYJdrjzlFwl9cx269qT9pNUvzjcqwdTNQo3SZzB7J7cYpQN0JTVzDp0n6JoNb6lCALsqIr8IiTM56vpQLTyAz2GZubQD7L01g3CWZxPm"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "hcwUcpUPsMW0o5UosJu76jM2wmlq5AwPysVF5stG6sDV8VcwTlpVeFZW0uHftmErfrdAShX3ZUXbBPimFdHXSYCIuzLiMIQFJtxkUyGOwyRk6YGPyPMoK5UnKtS1gEhTIOtj18DlrZXMdjSn0l0rabR01FgotjcP9UBEgXcHshMU6I6wZXs7N6cywHPgYchnSNe6kQIzDCRANqVeWbOgwr9GF8IwuczProXtD4wdpbpFmFPwzB2ko6ilyUnEoEyV4"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "c25229o6K7orcO0GTra8YQgbSkf03EUPDSjkRxe4SFBUgWcoQqCipfpC2Yz7UYUfwec3AZx28eGhJaeVa5v5c6zcq77Ak4NWn9oeWFuwKpaS8SQpqQ6kbQiAGq0vgJ23dEQYOb7zwyurP1MTVj53POyC0BoHZcP0w45C3x3vYWCmE6jkPDNE6ZgQqz4nod4D9bfAWzUwilFmWSTVvtmIhBaC21iaem9PISMdUeSoGauHoGywIFxzTzDAydoamqgaJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 216));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "nDinOirWHb7XgCe4Difv3K180vomtziqyJ7QRxG4GlbCLgp7tGwkfHxUQYsjBxZTPqtHRtqIwKU6TpUb6SeZzukKv19cs0YQy9r8KQV5hGmo695QTUXN1HpTXhmga09zVjJaPpEwi9ULzX2cAXjzC9ygGDhhD9WAV60FmuMt9jxya1QPXbe6I1fnxByMUIu7DSRljpcf3eCna1581kWO37djwG1NTgni7U8ziVU8T1AuYMRmA1p87vcSUMyXw5H25"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "tGOJHOVlCbYQlmP31tyWV"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CoreContacts corecontacts = createCoreContacts(false);
                java.lang.reflect.Field field = corecontacts.getClass().getDeclaredField(contraints.getFieldName());
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
            } catch (SpartanIncorrectDataException e) {
                e.printStackTrace();
            } catch (SpartanConstraintViolationException e) {
                e.printStackTrace();
            } catch (SpartanPersistenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
