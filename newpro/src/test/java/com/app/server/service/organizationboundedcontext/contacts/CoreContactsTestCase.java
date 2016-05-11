package com.app.server.service.organizationboundedcontext.contacts;
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
import com.app.shared.organizationboundedcontext.location.Language;
import com.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.app.shared.organizationboundedcontext.contacts.Gender;
import com.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.app.shared.organizationboundedcontext.location.Timezone;
import com.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;

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
            Title title = new Title();
            title.setTitles("Aci1h005kSyBddT4t4KFdycxxLRMQlOhLi7oYJSQa0Jhqlhf8i");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            Language language = new Language();
            language.setLanguageType("fxEpXcf4gSKFLt02xX0lnZKfNaK8DBnf");
            language.setLanguageDescription("nCKisQdxHCCyXhvdqNtXmFnRRBwQOgmJj3jwmWmnFFE1nBnQwj");
            language.setLanguageIcon("NhxE7iNe4urD06A22y3iMIAnx7hu5vvMmCBochF7jmwYUTB2Hy");
            language.setAlpha3("k8t");
            language.setLanguage("xDEL997sxuSYDWaAko3gVeXKONkZxV5vwts7sYyf6I1DFFKYmo");
            language.setAlpha4("3AFs");
            language.setAlpha4parentid(7);
            language.setAlpha2("wK");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Gender gender = new Gender();
            gender.setGender("UhOJDeyDSI7e3R9ET08mr9pnJFVFiMeTJ2cmDVXuDPnMLghZ1H");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setGmtLabel("Gr8AwGHtiIvVjh2MNIlOOMtlvm9SVJCcKY9kPBKSXveNhwLa8d");
            timezone.setUtcdifference(10);
            timezone.setCities("J3eyCbeDJhfWbQoAlMkyiFU7N014UFGBmYqN20MlyEltTreIMC");
            timezone.setCountry("zZteVx57O3hbNHmc4mNbRJ8RoAAQD2X4Zmne99lKQYsb7DhdEt");
            timezone.setTimeZoneLabel("JQziOjOXySwR4i7mcSPkUSF2TRpXgzqYSCmvIDBVPjCIi05QOA");
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457938614883l));
            corecontacts.setNativeFirstName("TVPbdvXS0mPSLZ6HaSkQKaEgnDI8BBiculJp5ui23NEsTZPbOf");
            corecontacts.setNativeMiddleName("zHxabLHZWOlsbme95DTrrIrWcKLwHxVd9i5L6upyg8aRHMHzP8");
            corecontacts.setEmailId("gHt9MQNHLJt4wcOmctxAzb4c1ZjUSHPKAhIbwhB8adMqRvEzE9");
            corecontacts.setLastName("9k9kkkRLCft9SoGQ3vl7BLdQ8TT1mu4Owxx8kIffy0SkRXJol2");
            corecontacts.setFirstName("BnNeh2Typ84Vy0F2zLvyjQ48lshJUJT7pQj97TIsAA6oDXV8hv");
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("diieYsZkJYEsu4Us3RxQpnZt6ErwlEVosZVXYon3EJBVv0vUrT");
            corecontacts.setPhoneNumber("vKRuxhGtCpX39Y0iztET");
            corecontacts.setNativeTitle("lUqojp4LGb9nr0clDKSmuf34ET8OxvixtpqEg4kukegLJXIypG");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setAge(123);
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setMiddleName("xBNSInSpcsWoXTpg0F5fi25ijkRufssb5VpTBN51ML1WKFAdWk");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1457938615029l));
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress2("vJua45HgCEBsUpyQBcUo6F77hShWKsDeRw9bcptkGj6MdEnpFZ");
            State state = new State();
            state.setStateCodeChar3("XQejm4M9DPog6asozOpvZqQcpcewTX74");
            state.setStateDescription("VSNq6AwjB0GdY4CympyWCKSQVS5vnMdeNIgW9zfMobaXVVpdgI");
            state.setStateCapital("ybq7OhP9lxPSk946gSgqhhddZEmeLPn2PTYnO7tpb5q1cFOVZ6");
            state.setStateCode(1);
            state.setStateCodeChar2("t3lqQrfvd3tjejLXcW3IWv6lzCqYQCOb");
            Country country = new Country();
            country.setCurrencyCode("G78");
            country.setCountryFlag("zPwDJhrbyhxjG7jea6X5ZhHG5vpb6ZgmfSXZGiCkcpAJZDbgGg");
            country.setIsoNumeric(10);
            country.setCountryName("TRY4hq4mGP92J5XJHirIV70IRaxB2dcNP8VC29YGErn7XlWNvl");
            country.setCurrencyName("UhbFh6Fmneg2kMXRpSANrI43WLFqaFv6X590xT8rsz410ciEmo");
            country.setCountryCode2("aYj");
            country.setCountryCode1("Lu7");
            country.setCapitalLongitude(1);
            country.setCapital("3a8cpQQrDFLtlECgIW4okKHXGq1DCqKU");
            country.setCurrencySymbol("SbdG8Zn34WY59ZPZBGzgKxWurCVJ4Syz");
            country.setCapitalLatitude(2);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            state.setStateCodeChar3("uWPz6MaBpXp5mA1nYkOtdXYAy9fXKfem");
            state.setStateDescription("e1UB2tW4jtZznCWanVFUGQV97wtPwqx9GDYk4wfdoKQbY2a1N4");
            state.setStateCapital("UXfvijhsglMPdMHYHA8Qtr5llBWFicAJxeyW4AYg6RVf5g5fqc");
            state.setStateCode(2);
            state.setStateCodeChar2("fgBj1k6aVRTiD8B0TQ8fyumr3J6rBXEw");
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateName("paapugSCtIFIDozr1HI0GhjrBQ1i2gT0KkAzKkzTY4y2G2fyw9");
            state.setStateCapitalLongitude(9);
            state.setStateCapitalLatitude(7);
            state.setStateFlag("MsKYuknTKkbFTTu9h4r9hjDahkrLBObs2dqGv3STTkdmJ3Lpdn");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("1Vs6TE5Mk6uTTikRRFlSE77aUTcXQkDzwHKyxZ8thbuokJ5sVM");
            addresstype.setAddressTypeDesc("DcjlPSyrH5f59pZEScvVjPexwUGA7WsvejBj3p0HA19UZXx3ST");
            addresstype.setAddressTypeIcon("pwzsouOUqvc4eaXBYVX3obRaeOV1LfP4Q9t8wed8kbdnUoJzj6");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityCode(1);
            city.setCityLongitude(10);
            city.setCityFlag("VQXxoYYeVVoZ66I9qSqHhNmWWNPWKZi8o6I62NGIJVguxDYABn");
            city.setCityName("kvTcUkN7iyfugXGrmubtSOjHwIFULt1eORj880o48jJgotI1v4");
            city.setCityLatitude(11);
            city.setCityDescription("YW3dO2rsxfUkFclWiAfbmOQ1CSX54XoDe73vIficZt1criWqlf");
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityCodeChar2("xzv87wqmexAYaTDIuiA4Gfg0L9w21aZV");
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress2("4W36UjhUAkbetqp0fcdYS4KbPqZGon17yWCWAn7SouhL4ZOxSR");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("1zYqaV");
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress1("yyJYKdUVzHJx0RCq5521fvvo6FTkCBY1Cc6dMpgf3POdO4VI3L");
            address.setLatitude("BN4BGSr8R7cYh8l9xUIbMo9tUVirvvLAOYhh3a3ipphuzX8j3x");
            address.setLongitude("lmYpE5vO0qAdQsS9rFUzwrnmw66EZbSZx3Ldf1FxWgp3KRMBHA");
            address.setAddressLabel("WbyWxF9W5AQ");
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress3("UEWdbl9EvLgJSpq2UeuB4j0Wkj7TG893h15uzD40eXNngOnuoC");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupName("XSPDerwPAvOf2hF0Bq0xLaJLqloS6U7U5SxcoT0LNkA8zXsVCb");
            communicationgroup.setCommGroupDescription("ibQS1azNSWC2lQ8WuUipWJoQ8vJ5cf7c3KOd7DYYvpanYj8k4v");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeName("rZhhRfd1HLJw8icXqhdggXo1hXnFQ2EHWfAeGmJzHkO6b2si5d");
            communicationtype.setCommTypeDescription("jRoLqZ2JpMHOXYoHWJ3DA0IKCRi7lW7W84YXU2KqMZ7PO9mzUh");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            communicationdata.setCommData("L");
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
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
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457938615365l));
            corecontacts.setVersionId(1);
            corecontacts.setNativeFirstName("bKEnpPYFcqGttbpcbmzE34EGks5wlvcvtXuBJ1LO3U4YsC3C4C");
            corecontacts.setNativeMiddleName("1f95Tf98h6yTrT3pzWNZkZd93lpnS3lUUyowxzEFjfQwfyoUJv");
            corecontacts.setEmailId("zoI3j9kyEEi3BXwh7IQ4iU0uNYY0k4L42Uhybrp7bgqhlCezQv");
            corecontacts.setLastName("aPhxPyXbMqtBiU9pLtlKlnw0grMWpwrbv5G5Rl0BTiM4w2h1To");
            corecontacts.setFirstName("G65DDqVUeNUJCLyu0JAaFMTZOhA3nJXpIxTS1uJaktcAvjBZ1F");
            corecontacts.setNativeLastName("aj4HxvpN5ePCFzGOMbuFgPd8jyp1uauTbdXsgedttpmOY2z6T6");
            corecontacts.setPhoneNumber("EDzPpOPlscEsq2MC2HmQ");
            corecontacts.setNativeTitle("szFYeTcLnQmzvqKo8PhaMl958lxVz3iF5DQopddZfaaV5epy9K");
            corecontacts.setAge(18);
            corecontacts.setMiddleName("Sxlu3qjlkns8xrXaadj3LexwoH77StK37fPdzXoC4r6KCkUFqx");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1457938615497l));
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
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
