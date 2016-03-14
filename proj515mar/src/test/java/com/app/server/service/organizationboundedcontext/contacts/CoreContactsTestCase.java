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
import com.app.shared.organizationboundedcontext.location.Language;
import com.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.app.shared.organizationboundedcontext.contacts.Title;
import com.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.app.shared.organizationboundedcontext.location.Timezone;
import com.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.app.shared.organizationboundedcontext.contacts.Gender;
import com.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;

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
            Language language = new Language();
            language.setAlpha2("4p");
            language.setAlpha4("7aq8");
            language.setLanguage("6HZVc9SES0yJGnXKBM4Ou52jLw10oHw1qJlcQCydILGKT8eh9M");
            language.setLanguageIcon("HXIzWvkAMltUMVF1DJec8sdp6JYK5FQEpY9ffl6b6xYcOEsB91");
            language.setLanguageType("yybog8BRwyQz2WvM1Bnk7tdKGreYoqv0");
            language.setAlpha4parentid(1);
            language.setLanguageDescription("w6TBlwnIoiFdecyKbsyQUSGRnuGKUNGhkgttk3747I1TTVZuEV");
            language.setAlpha3("QCU");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Title title = new Title();
            title.setTitles("VMAdMm6Fvdyxor9L7eSOClLVyc4JkfzWRYLe2w9cNjq0QmUhC6");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setTimeZoneLabel("PLsFLxUQmbKMsXhs5YPGD07666gA5o7CZf0XqAYbZLzQZl5u72");
            timezone.setGmtLabel("3QXIMuX0N2Pq60LXDEAQKBpUUEak8sKTK4RR8gxUNapiYDbkFA");
            timezone.setCities("IbNm4CVRZcGLljdoPJ7aOJ2qBwknuVPdlfZqrbT7TNqlW1SLvc");
            timezone.setUtcdifference(3);
            timezone.setCountry("b7vW9LrYPyRTUBfGk3ruowR3DKMLPai5IIkuE05QJx5b0e5WmT");
            Gender gender = new Gender();
            gender.setGender("wSE8IwB5icggBx1IvcHVRVYOLwBh4EYKXsZuQK5dTMlBfj3SnV");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setEmailId("HaztrSC1rOJsDLhh0eYioIYYje7Uof2ffRBkhygPg5jVRHYaUe");
            corecontacts.setAge(118);
            corecontacts.setFirstName("4oUV63xWCAxispurK2LlsIuAlBgZa2GnAOFQuqGMEywlDLtsnc");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setMiddleName("IQGjGyUIvgknw3vjfN3mUzuvj7ZSSnVwVrux8tDAQmd5LBXCWM");
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeMiddleName("OvVKzFIIAKedTWvi3ZsPXyBHnSise1MJcBFnAFT89aotnrXBcE");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457945741237l));
            corecontacts.setLastName("PXBFg8Pe7ODFd6hwCChHuxrG7RGE3rdYojNwvk0VzKPADEl334");
            corecontacts.setNativeFirstName("V0D1oqFhEKFQA5rmUfy7mfqzcaHzOsYYyhOjmQP6jWJviNBolr");
            corecontacts.setNativeLastName("7GuRS0kuUdnARWHHsj2HS5LZurVX5joglLzYWNQyabM5D7312J");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1457945741237l));
            corecontacts.setPhoneNumber("l3fZOWEmftAysLUGMkEa");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setNativeTitle("i9jKqWPP6eYl3EYHbMLHdoJfKitAiH6oJ7scGUB5JIxW3yCfQP");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setLongitude("zt7F5NQlIrlE6yLV2Ceqi3gwurg6cOUOreWLcal5JdIBf0OF2w");
            address.setAddress2("81fi76hEBWkaEUtb3kirXjXV0DVUAl4u8zNU6HaJ6oXopUJBMv");
            City city = new City();
            city.setCityName("QgOPeZytqDOzwPjupIJ23akN4QmL1g6diiTd3A054GhI2HhSn8");
            city.setCityLatitude(6);
            Country country = new Country();
            country.setCountryCode1("3bY");
            country.setCountryCode2("WSw");
            country.setCurrencyName("vzjVuxwYgSf5pkoHaeZUdEwGXMmQRh73z0v9QjSoyp4hQHBmFu");
            country.setCapital("GFEof60Ah2R8h9dUwn6QaGNvlJbKLN00");
            country.setCapitalLongitude(6);
            country.setCountryName("y86f8LX7PImlc2IFvMwhDuTRUwPM8EjS3dNPVoTFkfkOlkcl0z");
            country.setIsoNumeric(8);
            country.setCurrencyCode("VYC");
            country.setCurrencySymbol("iGSkMajTHa0lVOsnnAP4pPX0L19epHP5");
            country.setCapitalLatitude(10);
            country.setCountryFlag("3hxKyF9UGwOYQ8l8H3PYYvMh52Yg9h3CrVvzYorfhVNWL7CwfO");
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setStateCapital("EYjYuOdz5Jp6IkvVdkfmfmfmlJTy6jx8QGUsxpK6u1TOcMLApZ");
            state.setStateCodeChar2("AncnDRUqDwkt8Q60Bk22S0LUfYz5nJos");
            state.setStateCodeChar3("zg3Lw7vakOlC5KBgS49guP7fnd6KsvsZ");
            state.setStateName("29AaBlYjFMSNxhm6noNcvqF9gJ3WZ0ILk06txyf6wghyrrSRl9");
            state.setStateCapital("sfzbqa9QbeTJW2lczQsYdStcnQT1at1l3jIoPME1waM81ulzQT");
            state.setStateCodeChar2("aZ6ZRn6e3YbYDiPFXsraXyEZVcsfFjtg");
            state.setStateCodeChar3("evAUNIkncZMxfWuD1wuTk7bj48yaWRsb");
            state.setStateName("VBwXnE3KXIBW02lPQe4XgxxemS8DodpBg7PZdLkTKhz8Yujam7");
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapitalLatitude(8);
            state.setStateDescription("URmaCwGXVBPnksrTo532L1mIMgZc0Bq4owEeR5iYChmYZJiQsK");
            state.setStateFlag("YcF3GobIObWQ1GD2EMCoTKy5BkIpA7yKZnWaa3ciQvqAe4YI6I");
            state.setStateCode(2);
            state.setStateCapitalLongitude(11);
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityName("sYRcwlr386FfzHHWP5gbs0YcHQ5kbAfyIG0DGgSIRYPIpmh20T");
            city.setCityLatitude(1);
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityFlag("xttCZjgHKgiYJZ1GKz1UrXq5C7JUI6Fm4PNdayx3mjTKXvFjk3");
            city.setCityCode(2);
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityLongitude(2);
            city.setCityCodeChar2("2HexGpq5zVOJ12CR2vexkrxVJUb6DZda");
            city.setCityDescription("DXjoPAieMyef7S5lxg5JaVjFDZOUov0lCfM6qayTByV9FelXYy");
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            AddressType addresstype = new AddressType();
            addresstype.setAddressTypeDesc("f6pvL07xEjAjgXiIQnCyI2jGJm0Pkq2jWylmvWNqQHnf0Y9m2V");
            addresstype.setAddressTypeIcon("2EFQkGEx1QG0gTePkavROhTJgsNgWtAbNKQezDBUZJJiU5gUKX");
            addresstype.setAddressType("gpVW6Ba9cMN32VL5HWAtrjhHqXY4Bu6jfRKbvtBmS46GpVvOnN");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            address.setLongitude("cGHm0IK4lDN7Djxlh2vsx4TlyXxhWc08Bqfu0BiPWpBTR3ueZa");
            address.setAddress2("IBmWqmYWinUfI38Qw1QYbpSXwFYHr2fdgDCe07C74mfuvsTbAE");
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("SEt3cL");
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress3("qEkhme3pnW4NpDycRIqbRktjXwF78Gh1YMMONkFItn1ezBkyKj");
            address.setAddressLabel("ak8AzJVTpzA");
            address.setLatitude("ZpbybGeXPuOs0moMQHVld4l2LNZFU5iqnOCwagyhuypXcEBV8L");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress1("saTq9P43cTltDYSKWkLT7pJZfCB1uthGt1flJti2dSCRhRgdxe");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommTypeName("KVBJK3XMwjj4VQX11QF1MvHxamFfy9LayFl1GHijKVNxHnUQ33");
            communicationtype.setCommTypeDescription("bUTXId54mRudWAk6kIjbmXexya0YqwhVYHWqwmGNt2nu5VgHdW");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupName("3n896wk14CiiFyQNSYVNPtBGRqkQPip4Y7FjrvMaTPLSNX1QOR");
            communicationgroup.setCommGroupDescription("Za5EjsyFrqNAwVZOBEA2s3LA77lZIt5LCdYABhzVYArdLWayO3");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            communicationtype.setCommTypeName("7uDm27Rtoi8kQp26X2l5stRCWvSZAypL5kiZ61Evls2Ia1qSpk");
            communicationtype.setCommTypeDescription("uAqMSZFReWY8dqf3jOTXZVPuu2lij0QPfNGmHPDiFdY0tCzyt9");
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommData("D");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey());
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
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setEmailId("EB8WRd6AoKpMnFwXBq70q4VNGmPDIbjDk7gCrKlixeoK7RHmQd");
            corecontacts.setAge(2);
            corecontacts.setFirstName("nPKz9Powqrdz0tuE2qEhuHq6WXYaNWPDSS7xFqxbFUVsMFcWm4");
            corecontacts.setMiddleName("G7Kgcrnnunfo4RU2t9uMf5eYjzwcXhwsP4ExMCWa6pA16NJHyM");
            corecontacts.setNativeMiddleName("Q1laZDs3xhOKgCnFtCLzpBOqi7hw8nYuK4uvj88bF3UfZSKhDB");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457945741743l));
            corecontacts.setLastName("O77ES9DqfqxpVdoODIeYjigY7A57y7Y7M5ZL6xuEa7n1L7Xd2r");
            corecontacts.setNativeFirstName("sg5XXJArn8wCC3otGpmrEUW12CqZTkSuOu0rXZlK6WOk521Dre");
            corecontacts.setNativeLastName("ssBS8aAUoWRQyrhfqeD0sY59nUpIwQ5Uo1dUgZWrK4WetLfWvJ");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1457945741778l));
            corecontacts.setPhoneNumber("nx4R59tx5ycHQncz7fu0");
            corecontacts.setNativeTitle("TiKdwMvZKtR3LHRxpYMarBYSqKl0AmhtnojUM7IdaqyBI0RIr1");
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
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
