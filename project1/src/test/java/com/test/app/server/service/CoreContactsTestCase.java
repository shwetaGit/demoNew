package com.test.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.test.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.test.app.server.repository.CoreContactsRepository;
import com.test.app.shared.contacts.CoreContacts;
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
import com.test.app.shared.contacts.Gender;
import com.test.app.server.repository.GenderRepository;
import com.test.app.shared.location.Language;
import com.test.app.server.repository.LanguageRepository;
import com.test.app.shared.location.Timezone;
import com.test.app.server.repository.TimezoneRepository;
import com.test.app.shared.contacts.Title;
import com.test.app.server.repository.TitleRepository;
import com.test.app.shared.contacts.CommunicationData;
import com.test.app.shared.contacts.CommunicationGroup;
import com.test.app.server.repository.CommunicationGroupRepository;
import com.test.app.shared.contacts.CommunicationType;
import com.test.app.server.repository.CommunicationTypeRepository;
import com.test.app.shared.location.Address;
import com.test.app.server.repository.AddressRepository;
import com.test.app.shared.location.AddressType;
import com.test.app.server.repository.AddressTypeRepository;
import com.test.app.shared.location.City;
import com.test.app.server.repository.CityRepository;
import com.test.app.shared.location.Country;
import com.test.app.server.repository.CountryRepository;
import com.test.app.shared.location.State;
import com.test.app.server.repository.StateRepository;

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
            gender.setGender("aifKND8QcRWjbljLbdMZ0woj5lT9VPUUoZY8g6zRXzjxXgWMg9");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("VR");
            language.setAlpha3("S40");
            language.setAlpha4("Dtgs");
            language.setAlpha4parentid(5);
            language.setLanguage("iGc00rBKDxOBe1LvRcd1LH9LpPhUMru03XWcczWsu390ocjEBu");
            language.setLanguageDescription("qjfkaotFlDFsgSiqZzYg250B7Tyu2C95DqedIKiDu5v6imL5GA");
            language.setLanguageIcon("mTXph8QYkJQ039tULvvFM3NhPKXLHDBmgmP77oljx2HW983sJ8");
            language.setLanguageType("yg7PLBjBRhBwK1EM0L1a6WkZKur4feVa");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("KOQa4Z8dP3PJ2vNBwWBq1t5G6VnDG74zVrNbJe7eaAXVFyClNT");
            timezone.setCountry("k5iX6vjdQuHh5q0mWxDgBJjRlKzqcVJLqdEAgYFRnW7HMOBkX0");
            timezone.setGmtLabel("JMCuLDCe0eaWKt2gCjX3hcJWdzJvWdJ4yv25GWWGOvmOGXwchq");
            timezone.setTimeZoneLabel("bZnulq15meZmzPC0QyG52b3c7xWoBzH23S12kvopqetTbaqCgH");
            timezone.setUtcdifference(1);
            Title title = new Title();
            title.setTitles("7gVBKMPgIzmdpANjPeSWmKJXVuqzacr5vN650aLhuMSZS14C2h");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(26);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("BJL38Y3jGDCd55hdDlyHODg3TmUruXrjku3nLeXohxi7jpBNXG");
            corecontacts.setFirstName("PaWzOLDc6oFhvPEUsOkASBOlfaf8CkgVOuZRCkHG1yJZpRYjjw");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("BrPIBpZrSWx4gmwCg4hi6wnmpUiCgUObADMynZdA4lQgDeZCfT");
            corecontacts.setMiddleName("PXiXRczpr4oNXIThJqFdMwkaDp8CD54YXIBpJDQ73mNZDyTI9a");
            corecontacts.setNativeFirstName("chsqqlnliooDRxAGbrdZmbo07LsDMJFIPB50ADoyEgTSXvm0zq");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("laq5aTOq3SON8l9TLhzPV7vxZz756b6gb3J9HTj8EA4SB41Keu");
            corecontacts.setNativeMiddleName("33qabLeg4jrK4XJVsZuN5qmjrEgmi5MPoILNxaJFT6KrYMNzKt");
            corecontacts.setNativeTitle("RV1D9RhF5fl1uqZ87NCmQqOYqP3qvzhLaoTCA13TyglcrxX1kG");
            corecontacts.setPhoneNumber("rwkclAG6hplXL1PxtQtD");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("cDO");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("CFLlLWWbBp8AAvclpPuBuHN5FxPPx1THgctpMgFenOpQeSMUHM");
            communicationgroup.setCommGroupName("IG4HrZ5vw4xWHGNdPVhxeMrX03LAqGGZh49TrH4oIHyYyo1Ok0");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("lT0wY0We8NF85EQmnYdFoob84yMbHhJjj0dKi5quTS31W5sJvJ");
            communicationtype.setCommTypeName("gfBtOeVzfAecOEAHbiUwTnmB0PTXuxY9Yi7No08m1VVkS3u4Sb");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("0Rt");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("erFAUj5MxNcPBHxu1CckyctUqI0XeG6MAQjWr6DTsFz7RjEo3A");
            address.setAddress2("RPa6nCfOSpv6llEzEXPBIY8igm6g9gffSpWzakKdlR114Gao5n");
            address.setAddress3("xXZUOumYI6HWGKjOVrIqY7nz7jFKMObvsLIJCmocAUHfsCPbyn");
            address.setAddressLabel("DG17Q8C2WFC");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("XEzvvqZVrsjoFR6NMXqyzUCuDIMZcCLlROfldJ6NeNq0QXiIpD");
            addresstype.setAddressTypeDesc("31YGleEzCYEtMWeerwnWFWn7NhkVRRy2HLNCllXyOHX8ZXf0Et");
            addresstype.setAddressTypeIcon("K2FKpmZ01aeM0ojAFuITufFj6quPLmYyiqwdv2SU67CBtsxXh8");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("eEEDmepsIIJYEmDko3RcviNt1EAnSpO9");
            city.setCityDescription("hEWfftUYFSszvJR0IiQvhZafdLqBh0MgoQhNCQTejQMZLOlVmx");
            city.setCityFlag("p4uDS6iGdsfqWpkmCppYYhaPwNHsKdC6ZfjivM0F4xlyoKADPS");
            city.setCityLatitude(5);
            city.setCityLongitude(8);
            city.setCityName("3ygp5dlWqIE2rWfyjRY3K27JHWksuZt54nBNAmakw8rd7nGg03");
            Country country = new Country();
            country.setCapital("b8aFTxiD4au1d5z7ounXF4cmcis5Kthx");
            country.setCapitalLatitude(11);
            country.setCapitalLongitude(1);
            country.setCountryCode1("Imx");
            country.setCountryCode2("X3L");
            country.setCountryFlag("5pZ8p6JLaCJwoolBf5DlC0M7BF0rJ475lVXyvUbyVzsBPacAMR");
            country.setCountryName("fw57uNkn2levJVLbomKAAAOaEcCxJ3S495XHEDViMVyL1d2rdu");
            country.setCurrencyCode("m1l");
            country.setCurrencyName("Do0UKvVx8uKXXQp8Xt2HVTcrAbgxCDfyn3nCEkRpZtbxmyj9HU");
            country.setCurrencySymbol("QOGhA3b0PhEBm8mnAZJ90jXA55MD9UVH");
            country.setIsoNumeric(10);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("BnMvc6kS4jVGGE4xmUvMs3NqEjGXJq73tPI3iGmsYcpOcz1nPV");
            state.setStateCapitalLatitude(4);
            state.setStateCapitalLongitude(4);
            state.setStateCode(1);
            state.setStateCodeChar2("pK5llCDI0VfHzT8RZJF5CROX8eVNZKuh");
            state.setStateCodeChar3("3vusa6pXibcjdYvDij5ACw0cNcDcXaEx");
            state.setStateDescription("S1DwgZVF3FGmNOHEQHuXfFcIFkCJsQfPTdlLfOtCMniowYY9qj");
            state.setStateFlag("BPtBZatWAYa9Jc51xyHmPpIdmioklKjS0mypE2vQUFgdXBAfmH");
            state.setStateName("7IKZwgqliueIqgsEgSRXIvboMReYLRfQf6xUPaBzvm3gOdUM15");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("ZISwco8qSwA9KMyUninAgjumPPKs7yLJ");
            city.setCityDescription("wkiJMPMt8UKTOmQkqY3EbePbw6VRYezPFn3CoXgRLGamLYBKiJ");
            city.setCityFlag("6qkyTKBGITCGMAHnpJWS1BDwPRPKoxEBEhszfDAYdxo1drkeHD");
            city.setCityLatitude(6);
            city.setCityLongitude(10);
            city.setCityName("I9vZele01gMmODbjkeqKZ0uNJE1ZjzZYimtXkKUhrDNGqByLRc");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("h9AEQGRoAOTxdFFMHLHAfkmHbgrWZRLxcsSSLB1KHTbCwXn8sa");
            address.setAddress2("xRMZ5dgT2cnUNU7ko6Vg4fp8xOVo2mXX9FgPCdsCQtWcO9bA4j");
            address.setAddress3("TwkVuqNxtsg3FW1aE4lhP7czeH0YAfIE4RRaWGRZX7JlocFp2K");
            address.setAddressLabel("4vDdaDkzng3");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("V6zHdbX7ykljFrihIrcHhAvyc4QSYiRTeD5wrtjfg4dHV3KYj7");
            address.setLongitude("tfpcVBsNRoOOoh9NxOnVlJ4bePkbpVLHjEuDgB66z7muaJn5Y9");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("XJJJsx");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
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
            corecontacts.setAge(62);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("5udOd39P86xya352BmXkD68y8EC3H2sb3EIQ1OvxJgbdRqa6jv");
            corecontacts.setFirstName("GNb90Y15YxZ4Oi3BsXZ92NsAbEZd7OSwlqgsoyLiUB9iQ8mLBN");
            corecontacts.setLastName("u4tuQENUI9LMOlyr86BRSDrUJTDGZWT7kUK8jkT5yeSJW3BIHG");
            corecontacts.setMiddleName("Db9iIt9qs3fFlsLWXn10XnnTX4wknN4ZNbFe2sP6KhJIwnZ4Bm");
            corecontacts.setNativeFirstName("BDRj1VbsoijK58fKFX6CWdtTiva4plh8rHH1gswMb1zSxWgyNh");
            corecontacts.setNativeLastName("HQmu5SecXftOBqdQv3nDwuCn1pdqhmU0Ox26BIG9uoqcCPs8ku");
            corecontacts.setNativeMiddleName("60A6C1IVpGydcEgtUhFg2FZ9Zu0fr5qCMyBTI3VHkZxHEV2OYE");
            corecontacts.setNativeTitle("OFTqD3AsMIZKbVz19Mdh8ltQNR8UkoPFlmZcO1Xt19ZPW2Sdr2");
            corecontacts.setPhoneNumber("GHfJi8lyBPoKJTI9596e");
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
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
