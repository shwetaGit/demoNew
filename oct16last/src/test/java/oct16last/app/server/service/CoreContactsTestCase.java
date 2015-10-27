package oct16last.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import oct16last.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import oct16last.app.server.repository.CoreContactsRepository;
import oct16last.app.shared.contacts.CoreContacts;
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
import oct16last.app.shared.contacts.Gender;
import oct16last.app.server.repository.GenderRepository;
import oct16last.app.shared.location.Language;
import oct16last.app.server.repository.LanguageRepository;
import oct16last.app.shared.location.Timezone;
import oct16last.app.server.repository.TimezoneRepository;
import oct16last.app.shared.contacts.Title;
import oct16last.app.server.repository.TitleRepository;
import oct16last.app.shared.contacts.CommunicationData;
import oct16last.app.shared.contacts.CommunicationGroup;
import oct16last.app.server.repository.CommunicationGroupRepository;
import oct16last.app.shared.contacts.CommunicationType;
import oct16last.app.server.repository.CommunicationTypeRepository;
import oct16last.app.shared.location.Address;
import oct16last.app.server.repository.AddressRepository;
import oct16last.app.shared.location.AddressType;
import oct16last.app.server.repository.AddressTypeRepository;
import oct16last.app.shared.location.City;
import oct16last.app.server.repository.CityRepository;
import oct16last.app.shared.location.Country;
import oct16last.app.server.repository.CountryRepository;
import oct16last.app.shared.location.State;
import oct16last.app.server.repository.StateRepository;

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
            gender.setGender("blQwiNisDCgNqz1NHOZBctM0UXqyDGmqVG9p6gp5DH2H2GVNgk");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("RJ");
            language.setAlpha3("VYr");
            language.setAlpha4("6l9U");
            language.setAlpha4parentid(0);
            language.setLanguage("IbbLr9osApfHkDuHkXh0kQblmppUeNAtq7FuZoGAYyQE9zrDSC");
            language.setLanguageDescription("nZxoMkOlzixIUOvKgN0rzann6vnArfILrI54PNSlfM9vs3zeOc");
            language.setLanguageIcon("3LLXug4ShRVeglAJhMO6Ewnz4TvtYsKvvHV0e99php9SLc4Mnx");
            language.setLanguageType("lcmw7JNUHEImWUppyxc08A4fykhE1v6h");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("Dp5rw8lJ9ZMgkwv6nKVUf9pCwqYpGv6WvRoAtXIfAtwlf5UUS2");
            timezone.setCountry("HSNx8HqmjxOBLHw3FS3LLPLbBknyVqvZNGv6yJIDPIbme9JTZQ");
            timezone.setGmtLabel("Kcgo0YBTAFrFmhBIJeXOYQEzA2O5BFXQJDFRp9a7vkvgVhfR0M");
            timezone.setTimeZoneLabel("7x6NlLexDE0uPFLuodOq149bLgJZ41cuLiXqQc2Cn6nVtbOGJx");
            timezone.setUtcdifference(2);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("KRRB50MOYaaMtCyqxEjhpSseMOhelEui3NUgoy7j8ZT2RkvVSB");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(51);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("rXouM0xYDD4U32LZo6jHEizobR21wG648kqq37G5jylkDwTKiu");
            corecontacts.setFirstName("oXkeI0RAqxiJoVYfIgoQnP6Hqjx0XyWqodHfqbAp734QEHxRAP");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("w63VK9x522ONohQUNZQWxQWUHxzY12JLymOxRakxSYVDwyXTl0");
            corecontacts.setMiddleName("3p4VElDV7du9S28f38vswReajEHU5PD5N3cuRBJzdaAntArw3V");
            corecontacts.setNativeFirstName("eT8mygA5ElpEu7brZPouNuJ2wvFJkwTHwMnJt1zEct4kEBn5ei");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("DsVlO9ZtK6cBVpamO9CLTRiQdwHumkBN374uuOSxK4sQJ2vMBU");
            corecontacts.setNativeMiddleName("7YYiVKcPyVBDrIJM99JUZgpRYfgvcEajbm17T5KloFkHLYmkPE");
            corecontacts.setNativeTitle("HrvyqgqkP5SlVgyh1khP5ZZEEp1umQyYbntUEEf54nwhkoMlLp");
            corecontacts.setPhoneNumber("dNETCHNBayiHzCGaE5iX");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("PKl");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("L31GPaREFfWOPvYFIWYdg1lbENoTFbGsWRaHPEU1innTNGmTZj");
            communicationgroup.setCommGroupName("DFrwCFnHiwGZHeuHaTe3DI8XFzgoe3xEOUyEK9zEgFCYdAvlPm");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("7oZo8IXQBJZ6V0EQwvsbjQ8jGJj2XJ8kCf2GMqXHHUJWrS7bax");
            communicationtype.setCommTypeName("2wrBG6b0LwKjffSZK8bJ7hIRHQJObFwhS7R0Fnul84iSnpSJ0n");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("7x7");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("ASgx3asitUNqPWYUZDLF2DJCw9wJJXdOKaUC0p0XmI5F1PKjH0");
            address.setAddress2("acwN3bJGix8TRmkRzmhIyz0TXcmiK92S2ZbMzcxFF22KLHMf6D");
            address.setAddress3("nPNjHwX0yl0qYkqkToXWMVB0BbMVpWBRHLLsB34DjdXMjIplXr");
            address.setAddressLabel("OT01dmYELvf");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("J2kTuh1h6VfoQ7sVN7HMgTUqX3QkwKurvFfAPEGhqJmKCm8EMW");
            addresstype.setAddressTypeDesc("ha5DjVWMvlkleAwxUTlMVgpTe6CHOhUSSs4d24KPW0DsdWQvgJ");
            addresstype.setAddressTypeIcon("xmRb51QqmxZC1tM2SfxkxgiIcjTy3f40ti8Q5n9GJZBpTxUvae");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("0aXPLgU1mR9D2yqbMksIaJRuWNAORM6v");
            city.setCityDescription("nInyL5zMynXXyP9YsqSHFAofAIdouT1sjLzg2tm5dy9X306vUA");
            city.setCityFlag("1MXX1QrScbKtErABvtE6YMvfrEjA09gKHapr5pfenfeKb5xsPi");
            city.setCityLatitude(11);
            city.setCityLongitude(10);
            city.setCityName("GV5qvSkwNecO2YeDid19ZNlyYCJ9fllnoRsmLjgSYeQNQVpg9Z");
            Country country = new Country();
            country.setCapital("sX3ag3OLYN9uhRyFSMq7lSv9MVINn2na");
            country.setCapitalLatitude(1);
            country.setCapitalLongitude(8);
            country.setCountryCode1("6TO");
            country.setCountryCode2("Gzq");
            country.setCountryFlag("aqYjFH3c5Rid5w1R0MSfX9qHs6365O0klsi8kBLl5JddGBnsWQ");
            country.setCountryName("YDWYyFthRefujhFfdAf5Dahh0k1R6PI8kPqd64UXQuxKmP25Sd");
            country.setCurrencyCode("gIQ");
            country.setCurrencyName("TWJ3vc1Mzg8rAbwiSlI8gx71MAqjJZTBqiRbJ2mDAHHeHwoW45");
            country.setCurrencySymbol("IK0nTKYV6BMClIbrzQwOtEuDd4cQLgZQ");
            country.setIsoNumeric(1);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("pmG0lZb80acyajl9rmehLfCOUKhgYsR9NaAnex1BQkmSCr8QJq");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(5);
            state.setStateCode(2);
            state.setStateCodeChar2("ANH0RKGSjx5bwqggsnTWZDrVkHyk0hrq");
            state.setStateCodeChar3("JjCvX3A9XxJde5DsdpbmP2Nn7dFs4QJq");
            state.setStateDescription("Pa0cWIoy7WzUu459mxtwLOjhMl2NPHz4rcUtByrcQbCuF5edGh");
            state.setStateFlag("Cr2UhbR87NZpOEimQOM3GsABprTtPlLU5f5sKS8aL0ceozefZY");
            state.setStateName("lPROPPVAo8U25E7TI8Zvi2wTa5glzqF3fMiJvaxXXTk5iT99XS");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("xoVZKcRYvWFWydLTWT1pdAUKbL6uqnm1");
            city.setCityDescription("K2bYn0utji0GZOcjNGzfiIAWkv27qfMMpCo1KONOSII3GkkH20");
            city.setCityFlag("9QTylABEemzC1N2c5BhTcHpwUPbYKsMgSxkZey7vhKJUjc89ar");
            city.setCityLatitude(9);
            city.setCityLongitude(8);
            city.setCityName("vho84tkL4awt1z20adORPFNXqRo4OecuC9deEdmG5b7mYkNf1L");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("78hTxvbMS4uKxkOPEWE8hk4imkMSObkCjEm16mNNSrXnbUm2bX");
            address.setAddress2("QXDY3Mjylv46DXexCbKsXMksnXjPRyJYd3XtHFtXaxWsPwKZAC");
            address.setAddress3("1ae7c5vvQqv5BxUs3zGraxXHYYT2spkD1tNYsnBsnOjiNPlZbX");
            address.setAddressLabel("fwzAgFT0EMx");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("qlEbKkaeXfwD7bLyxf5eaa3U5J11Sp2ln9MigNTRtOixILFAiU");
            address.setLongitude("457B69ggVZBqI3A5nxE0JMnfL7pgjY1uLikWO7FJf0psEa3q0u");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("Gl258V");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
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
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(93);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("6PXec7mrFlggnyE7u9UWwXeRrVTV9divQXrceVbg8oT5QcHBcg");
            corecontacts.setFirstName("jXwqtLPlk4hJBZv2WmJI2ZZ72DevGOz8sAr1fpOckE5rRsXg5q");
            corecontacts.setLastName("bxojyR5EvGdXpKyqaINnYQ4X8g2xfz1LcPCLQn52HhokJoLtpA");
            corecontacts.setMiddleName("lWkO63H7M6yT1PbhsRsOPx5OJeOZYmKYSHRjizmxR5cKm4p0xM");
            corecontacts.setNativeFirstName("SYEB5g6Qd4ADNe3F4rZB2EOxOYiuNxlORiift3syKDgwn0CHT5");
            corecontacts.setNativeLastName("vJ3qykPMcVG7NbvZZflBNq5nlRfKgvKYYDtZfXNNwqmlXIQNAx");
            corecontacts.setNativeMiddleName("lhc5w52t3ajMcbtnQAKdktvwvyeIC16cBtD7VZQah2bGGPG6ta");
            corecontacts.setNativeTitle("5uHzj7K5S5FY7WVNqV6gIImJw7YqS3vIVLVn5aB71jRcXBQYEa");
            corecontacts.setPhoneNumber("mRjBUGg3tpIqGyufWK3p");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBytimeZone() {
        try {
            java.util.List<CoreContacts> listoftimeZone = corecontactsRepository.findByTimeZone((java.lang.String) map.get("TimezonePrimaryKey"));
            if (listoftimeZone.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
