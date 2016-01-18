package testone.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import testone.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import testone.app.server.repository.CoreContactsRepository;
import testone.app.shared.contacts.CoreContacts;
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
import testone.app.shared.contacts.Gender;
import testone.app.server.repository.GenderRepository;
import testone.app.shared.location.Language;
import testone.app.server.repository.LanguageRepository;
import testone.app.shared.location.Timezone;
import testone.app.server.repository.TimezoneRepository;
import testone.app.shared.contacts.Title;
import testone.app.server.repository.TitleRepository;
import testone.app.shared.contacts.CommunicationData;
import testone.app.shared.contacts.CommunicationGroup;
import testone.app.server.repository.CommunicationGroupRepository;
import testone.app.shared.contacts.CommunicationType;
import testone.app.server.repository.CommunicationTypeRepository;
import testone.app.shared.location.Address;
import testone.app.server.repository.AddressRepository;
import testone.app.shared.location.AddressType;
import testone.app.server.repository.AddressTypeRepository;
import testone.app.shared.location.City;
import testone.app.server.repository.CityRepository;
import testone.app.shared.location.Country;
import testone.app.server.repository.CountryRepository;
import testone.app.shared.location.State;
import testone.app.server.repository.StateRepository;

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
            gender.setGender("qq78T4NBcSytACexCA6PGGjuEjKT0xJUim1c1zN8uVvNyOyvU9");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("dl");
            language.setAlpha3("Tjf");
            language.setAlpha4("il40");
            language.setAlpha4parentid(11);
            language.setLanguage("SLfHeijJj6laF2EwS0wlWFeDhqODXSY9OZhKxhXthRJXH7AB9j");
            language.setLanguageDescription("XY4ZejUoTVKBdQYoaBbOpTDUenJSzhoqmHRR14ugUklT7Jop4Y");
            language.setLanguageIcon("qhdO3qUMQWQYDgoLCfdAlZHCFCyfSlfqVg3EFnWWazli4QYm8i");
            language.setLanguageType("RngqORJ9ukAmF4c4rHraHUeZMehdFfGc");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("fQkepMIGDb8QVehkjHJUPCswiA00Ed6tVFJmKE6Rjbku9qGfgt");
            timezone.setCountry("8QDCFFD6zvEdLk0yZ7zMUYML7Tv2vPVHQEV9Einxl1OwvLoWqq");
            timezone.setGmtLabel("fqOFEVOpAfMuiJze7zthzDLKOwDuZSCM7XuSyH9izZ622QpzK1");
            timezone.setTimeZoneLabel("I3dNyo1sB11E7JgxzuVF50rKZHNH2SmDsUYaa4FV84qP2Gfi8B");
            timezone.setUtcdifference(8);
            Title title = new Title();
            title.setTitles("hRzrVS1tP4qTrquIaJqUx1MYoOaqvexD123IYFZrOSkfyVmpcL");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(99);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("wezfUSjMXugirLRli3oWE4tny8FpkM5Qs6swqVio5JqsJEKNF6");
            corecontacts.setFirstName("YfdplUFpH0UDLKNV4esHTROcm9cL3ykvo6rTmO6B6pL17sAlod");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("IoP7srZ2i99siFbYzha7ohz6y7DQ2iGMKtdiU2o0EgSBmmQqwX");
            corecontacts.setMiddleName("3dGny4pNIf4g3a18JO0IkcahGv1cQNGvXlxe5Rivj3gU7AYcwc");
            corecontacts.setNativeFirstName("AVvUPZ0v0GhWVie8nYcawSrfXZEQJc5MbzfLzOQM7myNq3vu3T");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("4BwlCnUIuaoDVm4livPkpRIOk5mWEB3xoEnLkqDQGW3m5BDNW5");
            corecontacts.setNativeMiddleName("tJfeDO8nKmLdebJDrH8kRPIosFgOG4BHx4sz56SOaru1UAtQtD");
            corecontacts.setNativeTitle("YRDe5E9GjUpJpv3S4Jpgk6SoDs0fBFez91lOisfow9D07IdgNX");
            corecontacts.setPhoneNumber("sqGZXsPVWqyvIIMslJBG");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("a");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("ofFFvCzivfK2IYylSIEm8iS1JOqTWtcZJjapfqcsLwsxIEq6Iz");
            communicationgroup.setCommGroupName("cyD39Me8pbQoKyT2vbui0Y21nGd39UyK9TrgQ8MksWA6aQf2Ll");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("gd46WDn7H3eu7za3nGheYCJ2CayvW9Mgxgffkzv9K7uXDaAU76");
            communicationtype.setCommTypeName("HZg4WZSdsins4WJwGPSc6uk91UnKDHagjhmwCtmBy2j7WDJu8O");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("u");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("zlYP9mKbqd5Dg33FlcRiIvmVTOIdtshlMC1QJQYmnDp01E5DrP");
            address.setAddress2("zZQdNkMtFygxB5yq5h6dP6GMxvwzoC8zhobcD2gmkfyuaTmhv2");
            address.setAddress3("9GtUHM5drDoljMpjrUPQYLf7s0o8VrORTZDLtEmVTeidWerlFz");
            address.setAddressLabel("aQg3664GJky");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("XRmAjNdEczz41RNOT5zkcYjqi6WBY3pHkwhHrO6xmqNKiZMyqB");
            addresstype.setAddressTypeDesc("0u6vHwYy0mh9CMtiAGzOfFg5l79XHvzrGJfmKdD32l0EfchtBJ");
            addresstype.setAddressTypeIcon("Y3ckT4nP9s1HURlr1p7v2aUBHEIZG2q0BF8BaoiOdjH63CprJt");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("PvWhntZi0hGvyEB8XlsPZShs0P4BiwEf");
            city.setCityDescription("5zFSiupUHwyS5ZIUSg6VSiI9PcP5wo6lWc1TnFnlbH68wK6zM1");
            city.setCityFlag("FZy5DKoEIaXiGOtcFcTAPwpOUfXmgtwkjVjtwM8i3SYRKP7vXE");
            city.setCityLatitude(3);
            city.setCityLongitude(8);
            city.setCityName("Qe43kbbVmlT0f0n75wdf1OKC660osmU2WyZeDa0zN6BWGljbvN");
            Country country = new Country();
            country.setCapital("lNkCJTcUwOdnvp03qSZ0oq3WlcsuqWjf");
            country.setCapitalLatitude(7);
            country.setCapitalLongitude(0);
            country.setCountryCode1("REF");
            country.setCountryCode2("Waw");
            country.setCountryFlag("98oEiboOmWLOf6rHR9pOu9eHHmEeF5drpLnqKgivdVcDLCcLAY");
            country.setCountryName("7EHzmAcfytx4FJRVRXvxQKmqPEo5AW5sbmXdxpr2Jw4sAXfX7K");
            country.setCurrencyCode("J8x");
            country.setCurrencyName("bbGcwUWgMj7AAvquBHDhNwg99yT3hSu77Ym5sd0xcoRMJsdubC");
            country.setCurrencySymbol("4Ge4wUYnHwnV4cKkqzBwWvo2GVjIuHP4");
            country.setIsoNumeric(1);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("8Sjb0Nc4dGTMGth2v0lOCx8v4YJRW7GrO4G1BTLPiyZKghEu6B");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(11);
            state.setStateCode(1);
            state.setStateCodeChar2("FIqvI1ynh04TuE3z2MwPFem82QsP1cgk");
            state.setStateCodeChar3("QSdIKFDTmOwwpQyH7h6YWyNxIyehgHHJ");
            state.setStateDescription("hWUWDb5VdMPrB1edwBcdhLogPIkUMNnDlTmyvo0PY6onff4dSL");
            state.setStateFlag("8RQZ9ngFWy3pWKKAU4sc84k8oQnRXN837rbk9CqwzrQrbvPHyd");
            state.setStateName("unrTkBl4lUaYjN2heG0flLUkf5Mx9Erfrow2ta3U9oB4NijT09");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("7zigFSJYeY1RpAswALXhXdVqHPWMv0fm");
            city.setCityDescription("zdlhKsqVOIPRVea3qwhtQJiacsuqJsCAVrvXGqJK4vrDLoPR45");
            city.setCityFlag("U4EAhf0zJrGhEErdTKtgIRgFbKiQPPifaWYW9CRcyT1aTAEraG");
            city.setCityLatitude(8);
            city.setCityLongitude(0);
            city.setCityName("1fSSQQ29NTM35WVLmnUCaOQhWpFPvkmTtMv6iWU2h18fh0o5U4");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("zMtQ4Cehh1r7aTnYSr2h6YEZwrKg1k3GRd7Hk7tdTy3Be9VPiV");
            address.setAddress2("nu5d3xPX9kkAQgowRueedPSVv1VHk0cnCu3UShbbnw9JmtRUGp");
            address.setAddress3("yjygmkwJtNC540BQQmUqPrPifN4qIjdaQFJVKeQRKmCXaqIpoT");
            address.setAddressLabel("w9bnzuDpRlR");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("QOlB7tAk7GbNoRQTXFIdj73dkA5HtszwPXKRH08zlZq6Rwlvzb");
            address.setLongitude("qjywi54AgwEOiBJ2lVg6l8mF4XrPGnE7q8tTC5zQDn1sS6lbjb");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("RyrJES");
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
            corecontacts.setAge(66);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("ExZb7VGBes7bBmE8fdlW32gg2A1Lap2uHhnrEz2RvtmMf6rOJR");
            corecontacts.setFirstName("GNj9EcYBico2CDGxQybRLfeTLnAzusBYYXvjvsnaPbfvS3s1N1");
            corecontacts.setLastName("AOYSHGfWgSZ0O4ZfjqZe62hSX6jRzQ6nK2iYD40M0facJvHa1e");
            corecontacts.setMiddleName("WDEyLyPh1ySN8Eja0eaHF4ugM3swqhRxZnfYwhTPIo1NWThHJM");
            corecontacts.setNativeFirstName("EX5doB8tXkFgBT69TyAlJgaUUu60xyEZDhSw4wc5LnsJ9JOnLL");
            corecontacts.setNativeLastName("3RJz8F1GvGDUGRPnnysBIhyyL0MCPgt2o7N7mPcqaXh4GSRufK");
            corecontacts.setNativeMiddleName("rqi0VQhrgvPsmd2O2eSHgzR0hs927TEJ9ZSEJ3hVVTgNpVwRCS");
            corecontacts.setNativeTitle("rz1jhQJouToi1KEcRec9B12RA1WfHVhVDtg3pqlf0NTnTzAhXT");
            corecontacts.setPhoneNumber("Rny0g7KkCRJYtKAtElZk");
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
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
