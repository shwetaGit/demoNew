package project3.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project3.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project3.app.server.repository.CoreContactsRepository;
import project3.app.shared.contacts.CoreContacts;
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
import project3.app.shared.contacts.Gender;
import project3.app.server.repository.GenderRepository;
import project3.app.shared.location.Language;
import project3.app.server.repository.LanguageRepository;
import project3.app.shared.location.Timezone;
import project3.app.server.repository.TimezoneRepository;
import project3.app.shared.contacts.Title;
import project3.app.server.repository.TitleRepository;
import project3.app.shared.location.Address;
import project3.app.server.repository.AddressRepository;
import project3.app.shared.location.AddressType;
import project3.app.server.repository.AddressTypeRepository;
import project3.app.shared.location.City;
import project3.app.server.repository.CityRepository;
import project3.app.shared.location.Country;
import project3.app.server.repository.CountryRepository;
import project3.app.shared.location.State;
import project3.app.server.repository.StateRepository;
import project3.app.shared.contacts.CommunicationData;
import project3.app.shared.contacts.CommunicationGroup;
import project3.app.server.repository.CommunicationGroupRepository;
import project3.app.shared.contacts.CommunicationType;
import project3.app.server.repository.CommunicationTypeRepository;

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
            gender.setGender("3rMRPJcDYOXujkul0MvzNr8cE0SWYd4nCZ7CcNvY6R6HwyrsjC");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("iN");
            language.setAlpha3("r8i");
            language.setAlpha4("LqKd");
            language.setAlpha4parentid(1);
            language.setLanguage("okBu2Anxy0Q85Nn4EhFIoJdEBCgF30BWenTgMtpaILNk8fZDJS");
            language.setLanguageDescription("R3YjKkDU1WKuT2ZjummXT7ed7WxEpJV5l6rRla0SfhZ43aOw45");
            language.setLanguageIcon("ej6LFXPAHdSEehUfF8ehNMxeA3jQrssYgWQuKLa3jHtIU27lU2");
            language.setLanguageType("wh2JZ3QhtCFnrVMbJsV6nbtJzUUiiy7X");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("y84yfuyRc5IIdzNar0gnbshObHvu0hRhjeQRf8cOxdZsUTs4y1");
            timezone.setCountry("yNxwnsSPwOsFyvn04cvvwujWs8f8m5rRxZjdpzVbUGZVHNEOxE");
            timezone.setGmtLabel("FM7hh66mtJ1PLImbADq0ZtdVYYsAtjTkigB8rbj7mupzgfJSYA");
            timezone.setTimeZoneLabel("sh1Ooq0KB4QL9UzMGFhSceTrxamAZDY7bm62ShImyV3LSroRSW");
            timezone.setUtcdifference(2);
            Title title = new Title();
            title.setTitles("6IRoNTeYFwSSbg7U0kyeMCPM3BIfGqHcMZLX8DSLhGTwf4c9PW");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(68);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("ZFd96tHZ5rzekedcQZtQhSv96V20FC4udN0Omto8vxUI4cEBKW");
            corecontacts.setFirstName("J57HbPuc7Lc66JPAsc8dp33DKbytNW6eAASpf9j1m9HUGISdeL");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("tMmYTcc7WLjkFvawZcRBwmXjAtzDnenAPJqeiNYIkAUqvriyno");
            corecontacts.setMiddleName("YgmF0nuqRUh5GAoKHSzRG8gKcbRrqVnYGqs3M0j585Z5MxUgHs");
            corecontacts.setNativeFirstName("lZYTcGEHGb3kkmCjiN2STEWp16RPupYQNrX9OFOq7bfNORGG5f");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("7WuhLiedetOnwMHxjCuuYVsG6CsbqnI2Vby9DznKCd6GCA0tYQ");
            corecontacts.setNativeMiddleName("B36a10XQiHkR1DLrwDHNT30CakCGJnuKXBW0hYyTlWV8WOlyQz");
            corecontacts.setNativeTitle("4Icd9EI7S8Lo2TbU16QAT6fAO6CocSqF01O7bDELLj8a2k884C");
            corecontacts.setPhoneNumber("7LG9sp0ygiBMqdAng0G5");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("hY1rDK4fFBYOqmrEGvZHYG2iOjV5j6zH76M7kDARgyUsVMsbOP");
            address.setAddress2("PHy1WKD9AA2RDJJg1bGjcWbUBH8u56QJT4cHCgp2kn101lQ2Mw");
            address.setAddress3("q9QlRU0YBHAvoulZnE9W2UStLOzYZMebdew2TCLf8f0rlj8lj2");
            address.setAddressLabel("oAUTPlbCKCV");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("LrgQq9ehFlvmnuNetiBITJgK0p5JUvUkQad846DhfvA1BBKFYs");
            addresstype.setAddressTypeDesc("iqNLNHw4xhNa4K8N7O5mia7fBneq8cT8x73uaoIINCbBpxfpmA");
            addresstype.setAddressTypeIcon("plCxc9eIaVBbzdyFlPiTvbdgwT4hd8hUKocuWRjeeIyyfMCFQ6");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("N1gubu9UgcqnBfQhz1KlwC4QdDXkHoi6");
            city.setCityDescription("oVEbGdsjCpw6qYc7SiZjQfi10uUU1w3TYHlhwyHwVR5dTvAALq");
            city.setCityFlag("jYBx303QB7glkNq6boMkHpJySz6KPKnpL2P25xg7W6QqzQcJTo");
            city.setCityLatitude(9);
            city.setCityLongitude(6);
            city.setCityName("lEeNPbzCeqRP9V0d6TGl0mAY0B26vyu2kUG4KqW6FQ8PQ2cWY2");
            Country country = new Country();
            country.setCapital("L7Z32IvSue59R20gaFMLTpxuGh7pLB6X");
            country.setCapitalLatitude(7);
            country.setCapitalLongitude(10);
            country.setCountryCode1("XS3");
            country.setCountryCode2("U7T");
            country.setCountryFlag("bbkwRZyvvVlm4XFVBTq6cjVzmx9YZJVskrpePPWh4PK9RncgsZ");
            country.setCountryName("ft3aVmlV1CHgNDCZj1XEqbrcw3dzMiLrFXVBmfN0NavYc8aOik");
            country.setCurrencyCode("TG0");
            country.setCurrencyName("gqcpCEesgtdxgyo5mdWdG4MrYRTWme8s0Od0obb6LyYBoigFyK");
            country.setCurrencySymbol("mCes6SwEtO8Yu9bIZRY4MKOFsYHFbyC4");
            country.setIsoNumeric(9);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("cEHrvCDkdIB8p8sptqCX9GTVUh4fqviyJL2I2nLT2kAwJr52ND");
            state.setStateCapitalLatitude(9);
            state.setStateCapitalLongitude(4);
            state.setStateCode(2);
            state.setStateCodeChar2("HfWlaEgIABWlblLQdVr7AoaaEOZyf1B6");
            state.setStateCodeChar3("rWjDxFLRVmnlHKJGGkkYUsFyhbpBhTwg");
            state.setStateDescription("4iMBpzCbNqk4ZlcFhz1cBnEFcRzPhhhZl8Hv9oWZdFGcDpxEFZ");
            state.setStateFlag("MsDb5Ns4ZxCTN578KHatc7QBB0WpNzNEaO7pNoQ2fPGMcuCOVC");
            state.setStateName("B7rqUcvR5Bh35Sk3dVeKyQjxtzTeUz5gOniN1TyAi22Mu4seqt");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("yYBkUNtSBRrz5UwIaduHe6gCDELPeO7t");
            city.setCityDescription("IYM5J6Ho6dEXrMhgImKOqbcyiACYZO6tKjMYQHhCsseBMXMEyX");
            city.setCityFlag("CZ10JArfgs6wdPmpdfhNb8CUHFjetm5SgSl0ZtoECb3PmT18eQ");
            city.setCityLatitude(10);
            city.setCityLongitude(9);
            city.setCityName("2EEkRqq79ngatP6EbCT4E7NyVmhDNIl9iByiHcZkW8sbiQW8Iv");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("MHJrOcP1ObJc7B4XSnWaU78gY4c7CMXyopTvHFFmxBuNPvnJ4U");
            address.setAddress2("nUHAyvWhxoefrtl8ERSPxSckBPBK44V8g5ZLAbBYhKr0ChOCRK");
            address.setAddress3("b41b8IwCgDjUnkgnKq9I71jlbfs5hTTsqZMBRWYAT6soFGh4dw");
            address.setAddressLabel("WncTUbmgXoa");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("956eZkMwXmGJtQ3G86J52kaprtq2dx9dQXYgBCQMX8KKjsEymw");
            address.setLongitude("fxAiPiJ9ldpDAg2wyLjWU8dyFNw6Q32rMRBMvAe6mlrqMhCLxP");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("SRcCJu");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("r");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("8oOsZUilddPMNY5m9cFz1QXqSjcpgoaboFTOVCBtTMUUIojC6y");
            communicationgroup.setCommGroupName("hAMbtXoviSTu10cVNOfYb0URvDEL27OhyBq7VIMUabX7yM5TmF");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("z0ffiOgsjHgSjv6BUWVTlVqjzxyN368F67EJIyJkI1cvlMrrjj");
            communicationtype.setCommTypeName("ej9fhpl0U3qbziF9w2E14NzkfnqsgBwwMOVpXgvWI1qqPv7mqI");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("a");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
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
            corecontacts.setAge(26);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("uSdZC6nQQU43JnE6CsNmUFWbvY5BGQ6nSWicaa6ajJ7J4gwr80");
            corecontacts.setFirstName("03bUw9PphFGpwcTywRw2bSvJbNa0SacYQ3jdDGaNO4S6NV9mpQ");
            corecontacts.setLastName("RLqWUo0SFVSmTDwPoMuAwM3ufzX4Vr4jEpmC6q0XVEOwfVABhr");
            corecontacts.setMiddleName("nr7YkgASRUnlktOg56pINOclWCgxAlKUiaECKlk1axTolz6VTH");
            corecontacts.setNativeFirstName("pjw4VMqH7TAgROr59Wh7Fs1j4YnS8mD9CHs3cia0rBQrllfyzX");
            corecontacts.setNativeLastName("cZpqpoWmlpkLC4V4LWP3o3yvuzqlr7ia8i3XlHeW0cviqvGaZC");
            corecontacts.setNativeMiddleName("B92Eop15YUb93U6uMliICOLzedLEMqmUXm07nUyDk67f2y9ehU");
            corecontacts.setNativeTitle("RfUzQRyUKFKFkRwsD4UgGXDSwmKuvPG0XD2Y7dtcPZKLhF9BXU");
            corecontacts.setPhoneNumber("bCBUKndi83CdUZAgxdDi");
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
