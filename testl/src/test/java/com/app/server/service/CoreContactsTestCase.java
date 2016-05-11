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
            gender.setGender("qmlqcM68VUnjsfJJiph231fSgdbPRbXLmjidhMRSpQg7GoSdmc");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("zH");
            language.setAlpha3("REh");
            language.setAlpha4("AHKo");
            language.setAlpha4parentid(9);
            language.setLanguage("62HDWKJtIglQ4BLwMKS48TrHpz6ulmytkA9IszduAhxTZiqDPO");
            language.setLanguageDescription("nJOsYIWH10Mc0lbqNTkCDlx2pp4iXOTjE32HqTiWPvIxFmTksL");
            language.setLanguageIcon("5Cn9Ap1oj28q07Dk5hOrL3AzgbmbIlTcbVwUBG7e7mFu0UHtsb");
            language.setLanguageType("jNHI788yKaYer3dCtXvKGnTA3SjMwv8D");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("BEhx2qNz0YWDrhDMy5u7P4D5TkYjHT3dvnZ0kVHS0Nu5cRuWNK");
            timezone.setCountry("jbw29NJTK71mFld3lPlAIJuAqup6TUVw9vkulpGeqNt4xNDO9g");
            timezone.setGmtLabel("NQpPSmVUfDrBSmBUodQ21dvUNrboel3p7N5OUb6i7KTIk84wsw");
            timezone.setTimeZoneLabel("phNcu3wFVg2w118wsj2pGsQW5wlwY4KjDncQgOaHzpMPkwnujM");
            timezone.setUtcdifference(4);
            Title title = new Title();
            title.setTitles("q6CVzv0mxRnSaHzlBGLS4ovAOy079hvOJMZOUiHRZobb1KTeMY");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(104);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488928810l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488928810l));
            corecontacts.setEmailId("CHfMBppgvVoA0ySagY0cUcJ0Gl1LRuWLtdqMH3vXKb9xyL0n9M");
            corecontacts.setFirstName("NErEIiOMD6zI5jauOY7mRjDI3zjTbaOz12wrkiF7iP0Aaihtd8");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("LQWtwethO8Dvwi2Xe9OiscYVN0a7ZhrASCKSJQ4NefLqOdymUD");
            corecontacts.setMiddleName("VF4tFkKcVyF6kqDOZ2EKTaxgMTyYnLTP2kYkglbShbevAU5pky");
            corecontacts.setNativeFirstName("LXSOgVUAZlyCxISgcE9qDoXbJzGCkJgju8Qd4BasEme1uz3TBB");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("LJFxcMXRZJlbpy4anXyC8RGNvFzOBqpj3dg8LRgQwRX0upqxVP");
            corecontacts.setNativeMiddleName("RO5YzwJd6pGBGYRouEdXEeuZo2r82LbYjWc4SBQVhV5ta7a6iA");
            corecontacts.setNativeTitle("O6WMDQjuPZnh7bY09r4NO7arZwnxxUpEkkNst9YeBKg3Wti9xX");
            corecontacts.setPhoneNumber("kP0knzuQIYXI76eRIX9x");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("F0CjNh5x1hwpPHFtBFWCscnlij2J0nTYcmS2phAigCZnbGQbSS");
            address.setAddress2("0X6Txq7Vrxtn64j4LHZJNCvvD6S6XRXNjC0GxWA7eW6MbDZupN");
            address.setAddress3("T0ilcJLG16sEQ2CNs0NRTzrMdb1uzEAKAfMj2W8CUbwVc5kylt");
            address.setAddressLabel("M4tnNeNowfM");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("iyyXhVwR8Q7EKvbYRrlt1yjbYN6UxqFRoL48HnQnQBKcd8THM9");
            addresstype.setAddressTypeDesc("ankZK3Ve5HJzSdXm7h9J7VF0SVfrYfggeYVpBTdm133SVwlijs");
            addresstype.setAddressTypeIcon("D9TK4g9hRT5y4AXnwUHqfHsFTLHA5FmITV7sByUJZqkItL03kd");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("3IQN6QgmqJtSpchf3qKw7b6WpWXNWLL1");
            city.setCityDescription("xKhjc5SQurmLTTcsJ42pa9sWAELsr8p4NTz2GXpda0VKXvUUe9");
            city.setCityFlag("tjUGB71LOjkx0qwLLV20VnzEOG6xrv6B6ws2NrXdHVWBYi7VtI");
            city.setCityLatitude(4);
            city.setCityLongitude(0);
            city.setCityName("7PwSKjiwK3zA8l2n2DDo4MJ57T32Eccram9eyF4F4CCkc3LFnq");
            Country country = new Country();
            country.setCapital("XKb0Xz42DrO6yWcVps0x85rfHt4bCskF");
            country.setCapitalLatitude(3);
            country.setCapitalLongitude(0);
            country.setCountryCode1("KOw");
            country.setCountryCode2("HlQ");
            country.setCountryFlag("iF2ERIPMuhr28UykR1BNFTjuC0upO8rG42WbGBAOIpU6B0kxAn");
            country.setCountryName("ndj3nK1pQGNLs2CXSRlw8HDzhp5uhcq3egDkhGUAJKT7yOe6kQ");
            country.setCurrencyCode("PDN");
            country.setCurrencyName("6rCH8wzl6W85nzp1pnb0N8iDUxok7iunLYZlyXWSX7SStcMBA6");
            country.setCurrencySymbol("TfqbbD1zG3aYMGo9bKE4WsWCAw1Nxnrb");
            country.setIsoNumeric(10);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("pcbEYDvbalgfsuTCieLwSaHEl6mRaGWZBlW9n53QSM1nCkwuI2");
            state.setStateCapitalLatitude(5);
            state.setStateCapitalLongitude(9);
            state.setStateCode(1);
            state.setStateCodeChar2("MkPJYLTCEnUILWOi6SLhczOe8JMU9ind");
            state.setStateCodeChar3("AHNSjWoD5rob4TTZiLNCsh6c4Hrjc47T");
            state.setStateDescription("YlBvn6lMw0S6X6e8NFncNNAR41rFtdcqIzREKo5hbQi169BAQi");
            state.setStateFlag("nPDZj0xDioWPvh5p1xZ7I2SNx2WlT7k2SacWM7INjxFiK4ceyx");
            state.setStateName("MEzwvMKGOm3Li1mFol7fUx5Mm0QfC1ZVG7M1nwLhUNfF1NC67K");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("ZH8O5XiXbW64cHZ8OxyqjbUv7b6jcKWs");
            city.setCityDescription("sAUf1T6I7boFhDbzNlHuIQJboH4D1p6QXIS0oGEgxWpDfAFSMG");
            city.setCityFlag("tF2P2pZjgFCzs1dJVLPyskXRvwfKefxcOJkBrAut9ZQqeO8DHR");
            city.setCityLatitude(10);
            city.setCityLongitude(6);
            city.setCityName("1PW6J4uyMbfJf57S2fgx3lh5exOUbtaerRozPaKj5Gw06xhhPZ");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("0F9NDjRxZEbbc7jjIEaIX6bIJjvG0q2zoVTqD85hPeffscldFM");
            address.setAddress2("8GnbULDxjOnd8bJWiC0TvDPtkw6qDjWNGhVVsqBxvL2DQlmuhh");
            address.setAddress3("ReFV66LQrHZbKkfSCIkVbmz5tdseBwqgV5xD8WBBAy0fAR0Sx2");
            address.setAddressLabel("O3V8KcXDkCl");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("star09mJ2QrKs6XZaN2HWzLOKGi82SDvVVrSAqJaGCsmTcAr2M");
            address.setLongitude("KWz5wzXhZj4jmNaeV6Q9Yv6ih4ppznYIevpzTKKMVKB1T41Dd1");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("RPBTBD");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("D");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("kNWFRq9LvPH2f0INLijvvbjyz7fBebraC6LuRw6IDd07VgTp7L");
            communicationgroup.setCommGroupName("Y7YqG56fUKgJYrebpomgShBEcWBmIV2chIfMcKZXCtzaj4fbIu");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("vfCDOmvAb94hMTqpd7aVohJijTGZlGBLDK5qmpncqkTcTTVDCB");
            communicationtype.setCommTypeName("lefzFSfO5biCz1fbxcDc28CMMct0clpbizlQsGk7TuDhKlPjcU");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("s");
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
            corecontacts.setAge(92);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488929328l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488929354l));
            corecontacts.setEmailId("ctiXt9PD10ySnI1GkwIVgc8ZoT5TDNRiUyRLLfHI7gFn0a8i0D");
            corecontacts.setFirstName("9q3HS2HhRNmiM45KvcnJhfKE23GusPR2zjjfgEDVwx7CNsnnIM");
            corecontacts.setLastName("e3u1zsJYOW4FjbW5EDog9xa9fktYHJITHPHJf50Jqth4KTk9wv");
            corecontacts.setMiddleName("lspAtwQ9OAmxb4Lt3Khj1RJY4mLMp60C7ezy5U0fjSGpJlicFv");
            corecontacts.setNativeFirstName("WcCKOEhWqi6JtwGpO90iOj1nZ9XrrVzAGw0VbYsYHrdWBMtlGk");
            corecontacts.setNativeLastName("M5427zc99tkNgKP8psXMcWGLxyWJ46ytsCPcaEVEgwW4cxWdE4");
            corecontacts.setNativeMiddleName("04USIZYq2AfoFA3CaQJgSnI8C1qL2sv7ZzHgCUF5pOFzV8pR5j");
            corecontacts.setNativeTitle("bz2byAYzoMPVG31fZ14wIgrjP5oR9o3Bx4AaWuwYlnleqzC2rn");
            corecontacts.setPhoneNumber("FxlpDbY2qBRwqbGH29Kw");
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
