package testprj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import testprj.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import testprj.app.server.repository.CoreContactsRepository;
import testprj.app.shared.contacts.CoreContacts;
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
import testprj.app.shared.contacts.Gender;
import testprj.app.server.repository.GenderRepository;
import testprj.app.shared.location.Language;
import testprj.app.server.repository.LanguageRepository;
import testprj.app.shared.location.Timezone;
import testprj.app.server.repository.TimezoneRepository;
import testprj.app.shared.contacts.Title;
import testprj.app.server.repository.TitleRepository;
import testprj.app.shared.contacts.CommunicationData;
import testprj.app.shared.contacts.CommunicationGroup;
import testprj.app.server.repository.CommunicationGroupRepository;
import testprj.app.shared.contacts.CommunicationType;
import testprj.app.server.repository.CommunicationTypeRepository;
import testprj.app.shared.location.Address;
import testprj.app.server.repository.AddressRepository;
import testprj.app.shared.location.AddressType;
import testprj.app.server.repository.AddressTypeRepository;
import testprj.app.shared.location.City;
import testprj.app.server.repository.CityRepository;
import testprj.app.shared.location.Country;
import testprj.app.server.repository.CountryRepository;
import testprj.app.shared.location.State;
import testprj.app.server.repository.StateRepository;

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
            gender.setGender("1Z22g5ynV4ICWkhWJTQJjayEd1uVr4zJBNYtOiQAivHVCYSG2n");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("Vn");
            language.setAlpha3("Jne");
            language.setAlpha4("lerH");
            language.setAlpha4parentid(4);
            language.setLanguage("kCnErure6lfoTXwshSO9wcTeCMEGVW3FNQFQoOlkajIKs6rFb5");
            language.setLanguageDescription("UDgVvySYyIl9BaXGn8eoZrspnx8UhELn8NGwGOwNx4w7exO5LY");
            language.setLanguageIcon("UZ6y4nyX2HWcJcq47XnK5v5T7e5iwl2WaZ26QzomdOFFwC70KS");
            language.setLanguageType("HygZ7h28I0rcKzCkcSC0vygadF2WBWpZ");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("Iwj7UkQyxqfyOAaoiW9DACoILLXwK0yuHEtPLJGqkEMzQudpW6");
            timezone.setCountry("BotVvcyIqIRCKMzZJbNdHWlwdNfL21Fl2vRBYR26bQQ5ranIT4");
            timezone.setGmtLabel("wuA5oxaO53SyBoPjawi3doHMGzlQxZTGn0yorr3b3wqDucf0lq");
            timezone.setTimeZoneLabel("qFnFAddQP702guPCmqsAAEi6Hbs4CNAypS1ZKbCpSfxIQqHku1");
            timezone.setUtcdifference(5);
            Title title = new Title();
            title.setTitles("Mi9ikvzXHZ8XotchX2yfZduhWjzUUxauDhFqREKydKNgNNfv7V");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(101);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("QxLBMuv28bBWRDseXQE86BMkGAy4QsEA4LPvhKQwAkDGyuPeer");
            corecontacts.setFirstName("yrQua9UNdlvziYCpl5folZmRibYiGiWJRqkEQpVfzHlslT6jXv");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("4b2F1k4KsnSdCp8d480pB9ClXBdQKaUzmp87PpT2Z5fS9xVvKR");
            corecontacts.setMiddleName("mdV9kNpOAipNIr08tiqRpjt9nauUDIG0stGBiFq9DQtgJgMi9r");
            corecontacts.setNativeFirstName("3AS1KUYxNvWv3iw07yyf3iDh1fQ73vfbZk7e04Hp9tks1kpfv4");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("iRWDjwKcYO5L1naFikI1TloVVT80ZbvebMByNcPQQDe7qd6LT4");
            corecontacts.setNativeMiddleName("De9jObhsIyb9PDG28QYDzjbm0uhHJtOfjnXmUsOddPdAsYO755");
            corecontacts.setNativeTitle("QeyAT2QWQFfTeYayhYNCRKKCSydR22SoLX2jN46ASPzJJoKc5j");
            corecontacts.setPhoneNumber("rng8LRMT51JjK7Ylo9AB");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("axi");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("wsd3Qupazz3wuxzi5yzPDf1yrCJxHhHSktqtgxB8yyBst3DF7K");
            communicationgroup.setCommGroupName("9G1oB6h0x5rhXfosdz3rW2MKxudNxw598nb0bALQcpUenHMM3m");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("qMeW83dY1bYcBJJ2UZtAMbcZxQEbxAmEIp0FczlAJQsu5BuVYI");
            communicationtype.setCommTypeName("masIJtOOO8H24F98HRu4kSmz4YQpTgU4i5duqhxTwPeSR3ScuQ");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("92N");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("YJqu4o7TMdi3FxN3ZK6r9jXTodzISAf88iRCNlVDLamiDwRHEt");
            address.setAddress2("VSkHK7rXPqme3BeTG3VX5r5RgFrgeefE3dJrPs11WPdFnIDLJe");
            address.setAddress3("c42HNgXMWz8BgF8U64uRC5ZsPBFxTRmHnrWwLTdxnVXYpfUgho");
            address.setAddressLabel("97P7BKHUeG8");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("JVvQsLyzqCEEPrPg08wL2kYEbfy8HWTuIBX8QL4Wm6H4u323Tx");
            addresstype.setAddressTypeDesc("YoGPeMAQ8rC9E9CwPwVzlDG9HkeDs44ld5B8f6ekLpCdp3HYG9");
            addresstype.setAddressTypeIcon("Te3Ue2gEKZs9a4bpgC9FW9tySfDHuZjUp8TZHcLWqc4JZIwmCQ");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("ph0g9k6mqTJ2s3IIDMARh2LuqvhT6Wvx");
            city.setCityDescription("hy6hneGvwm0fGlY4dr838GqSu5iSROswdcHcxrh30O5V2pOrtd");
            city.setCityFlag("PG11emm9yfy7cgLyfDv9mRxBAynvjjTrTYsfKXO6IfjuDmbdyt");
            city.setCityLatitude(5);
            city.setCityLongitude(4);
            city.setCityName("F00slmI02BoT6aMKIPeR74OITHXayTCMCdyZNrO5joYffRNJ3C");
            Country country = new Country();
            country.setCapital("QAZBsmoKpYvnebeaQ2EiKmjUsWeK3TzF");
            country.setCapitalLatitude(1);
            country.setCapitalLongitude(10);
            country.setCountryCode1("13i");
            country.setCountryCode2("OXE");
            country.setCountryFlag("cncqaPeQiRppR2WgLq2d1CGgmlBcyRCssLnvrAhYLkhHOVorsL");
            country.setCountryName("O1S6hvVl6VSrzKJvSJNJShFtr3oSSNJ9dp95uDKTGOwKMgRVKD");
            country.setCurrencyCode("18O");
            country.setCurrencyName("MjKTdB8tjbkrW9EbeGZ2yGIGc4TKgZsr2Nv9PGMNszjtGVUc6z");
            country.setCurrencySymbol("XQMSGRYKv6aB5j9ReCGQRk6wZw3NCDUP");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("IBr98nToHiYaoyBT6wrtEkRrzDAIVG7tF6vsNusYPdj6BoZeEs");
            state.setStateCapitalLatitude(5);
            state.setStateCapitalLongitude(0);
            state.setStateCode(0);
            state.setStateCodeChar2("6kSbf0Ozi1eK5ZgfWkQWKuHRZxZcpZaK");
            state.setStateCodeChar3("gkE2traXVeunGxgBTrUOqHArUtOoKavj");
            state.setStateDescription("U4bTwDbbsYS75q2sX6y2HrG6PuP6QZn4EfS1oWHiiO9muUCXNi");
            state.setStateFlag("9iX4uiDJdk7OUV2vf3TlJppsrUQzlO3NPUZ58s2ilP8jpzxW7E");
            state.setStateName("YoNDFdtGK2BJfqyM7C4BlbEvdSQhiZKl9ZkFp8zY9nA9QAsVd1");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("sBnX7ID2ngqQgf0Ro3VRc8Rlpo0cG3ju");
            city.setCityDescription("BW4whmw8fzdV1GgWwcXbW3Jyp5QFZxj7OJ7k2CDuLJtrYLlNVv");
            city.setCityFlag("0NqdyUnRW3dunwedV57rCyRw02dmET46srAr1OKHwSqYnqmx4b");
            city.setCityLatitude(3);
            city.setCityLongitude(10);
            city.setCityName("4SCMZfyCDisiuwmVPNaKJIRwIcG7GaT7xZkb5a6XTzJAiZFgmd");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("xMJYh31W5aSR13VIAGpAfZhGan90tVOSPjkqgM99qE7UqqLVsk");
            address.setAddress2("PWRODpAwEtxq5lkNsITrPl5LQ34YUCIlLBRAG4k4k5RMeoAdhp");
            address.setAddress3("ucufqaAAi5EmpH9aLC0TtyvpZe5NZ7AIsyjRTotVkYJjnkmUPi");
            address.setAddressLabel("21pxG2hNras");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("LcyhjY1Ye2PV4uqjupoJRCQK0klZVrcbTCH7VErY71DlyEkAoS");
            address.setLongitude("wFaY4qlk8meOEUN0AzqFTU3Q08mjYyetLzeashLEZ4oqKeqRzs");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("h6jSyM");
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
            corecontacts.setAge(125);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("QIQts5ynk2zmDLU71rCTnFoDq78ctSEFVuNNYjqZm2CJEdaRdk");
            corecontacts.setFirstName("suLS3VBZAB055lXZGx5JKNeDMxrRNOZKV1KrPgeIRSlFNq4hmr");
            corecontacts.setLastName("9yQQaxc6VXZ2oah9QGOMVbsy6EzmqGMTB0uIwF5lTZM6dZR32m");
            corecontacts.setMiddleName("W2BTrVlFh6Z7XNIdgPv16Z4jgDy5HYqJt0ekrwkKo0HWIlsdIz");
            corecontacts.setNativeFirstName("ubgeR8aNLgibkgfcf3i9ANQNvBXHbWkjk2RjNx4o1DD2wfMH5R");
            corecontacts.setNativeLastName("NXKmN0tKh4ZLU79JcsJUTrHBb642ZeocPDgYY4oNuOB6iPRbpf");
            corecontacts.setNativeMiddleName("YlzYFXtLYPBD49rypx5EruzPZ9uSFVXp16fDozUFP2CP6xo4Lt");
            corecontacts.setNativeTitle("9GmnhXpdhpVFUQgLlZo0zThKnD96TiqLLNLmGpP6n6cerXkxZi");
            corecontacts.setPhoneNumber("oNFlcXE09Rn6flZiJX5D");
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
