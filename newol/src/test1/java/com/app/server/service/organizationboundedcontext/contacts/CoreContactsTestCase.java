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
import com.app.shared.organizationboundedcontext.location.Language;
import com.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.app.shared.organizationboundedcontext.contacts.Gender;
import com.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.app.shared.organizationboundedcontext.contacts.Title;
import com.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.app.shared.organizationboundedcontext.location.Timezone;
import com.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
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
        Language language = new Language();
        language.setAlpha3("4AO");
        language.setAlpha4("N0Gl");
        language.setLanguage("6MxCcI8EXTqOYy8LSGaDlFzY3zXYdPavOJa1xEeSR0vmWA1FVp");
        language.setLanguageDescription("TTIGfRCMtjxNe9RBHzykPE1tosZr3Ishf6fkVMK5H77aDXv0uv");
        language.setAlpha4parentid(1);
        language.setLanguageType("f9W7azDGXaHPWRBJqj0HVtpXJgJpA0yB");
        language.setLanguageIcon("GvgJJKrcfIbaKXeq1r3CcLeb1W41WNLXNOTmBRmBjKuZWlWwBw");
        language.setAlpha2("W3");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
        }
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("33PzkLMWox4UlMlNeHGLJJPS8sthIsSvYyKXOvZUSKjiM7164c");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
        }
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        Title title = new Title();
        title.setTitles("MxeKJQfIUiC7ZOOAghSYAjcQ1SgnRmmB4C0K5h1AnUqOYmTvbx");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
        }
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Timezone timezone = new Timezone();
        timezone.setUtcdifference(9);
        timezone.setCountry("wRhr8xZEWZ5RlJkxv4JpoGGcVWipJC6KkoMvh0K48SjeEbFPOM");
        timezone.setCities("p7QL1nxMEncyooYDpcqPjtwvnVTOxpGa2C5aZ825DwpN3viJzg");
        timezone.setGmtLabel("K7YGDVJI7ObMhMtO9DWmKbA61Zujgz4HA7uw8Qx9scy3R1q593");
        timezone.setTimeZoneLabel("6LKS2nhfPpwNczn3SSZhAY3vaZutowLG40jpXdUOg38HKLKiWv");
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(47);
        corecontacts.setNativeMiddleName("qTb3Ga5NWKL4zzxui3ikJnMp52NZ8BTuofa0oyEPBsDtW5MJ5c");
        corecontacts.setPhoneNumber("NeD2DrmNIIwnolpAmG3m");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1458541446787l));
        corecontacts.setLastName("eWw9lmCNtroTFokvqSe3THPOkPIC6WQ9HWphOYVkHUly3tQM4e");
        corecontacts.setEmailId("nEnS4vJ3b9SYBeq4QmWpdTFyE767o6rRuM5qd7p95c9C6qbZvw");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeTitle("t1kPwruLeSRv1EwY1h2RBYoWYBvhVIPkxGFFrKzHrXcsASn4U8");
        corecontacts.setNativeFirstName("u7JJXPa1MR7JuhdEk1tTuUGt10H1DNkdIYYSTvP4sf6lddWF3X");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458541446829l));
        corecontacts.setNativeLastName("OLvpMAAn8RBdGf9wBrCEMggyPVACWq99H6EbmqqIhxhseEzJSe");
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setMiddleName("KhUP9hCrImxZOrTJsVjE4YkqUG47pq2tXNz0qeHGojJphpfF7o");
        corecontacts.setFirstName("CMwc80Xs2AffagqydXvdVJS3y4S89pn6Lz5jzKvfMwpbUZGdRk");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("ar53SQEHsXw2eOOXcLEPYSdUJ4uRJ6opj5Aa0IO0Y6RO4gTlEy");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("JSLQsnIhl1kCSbyAkFF8PfC43f4Nt078NSMSxrAIOy0IWFqjtD");
        communicationgroup.setCommGroupName("YjSGAnyygErTRpQpmzPeoFhLeq8xfmUzI1C1Kpl74W9gBGgwjA");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        }
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        communicationtype.setCommTypeName("zMtIPKiGWTXdtaf5EDSYRGRg5lf6Rzhf4ujfqpgk67Ioewb9IE");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("Nw8hM0IgfrgEvMjnnU0e8jibEHSgLBcNwdMDBcIapGHvDE73lJ");
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
        address.setLongitude("KPPyhoxmfgokNwb5qKjFnkdTP2Qfk3sJc4YAsQI5a7byTXHatb");
        Country country = new Country();
        country.setCurrencySymbol("kdtMmmXnKipaKaeu2SXlyipnDOolxCqy");
        country.setCurrencyName("pMkMiIeHPyq6rJSCJiKFxdM9ZIaeEg8BmMAUPB3Ah6BtUF2XQ8");
        country.setCapitalLongitude(9);
        country.setCountryCode1("NaU");
        country.setCapitalLatitude(6);
        country.setIsoNumeric(2);
        country.setCountryCode2("AIp");
        country.setCountryFlag("3EyBH1uEJTFUyQhqKhwEkx8U6aps4vObaIY41LKXsZW65aIbuO");
        country.setCountryName("OtvHBgrCL3qP6itbQEDSfmm1Rofa2QIf3zSBkjLgMwyOYo4BT6");
        country.setCapital("pPEkNw5Wd5NrX9xSKMPBWETgTGaFj5Rz");
        country.setCurrencyCode("4Pj");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
        }
        map.put("CountryPrimaryKey", country._getPrimarykey());
        State state = new State();
        state.setStateCapitalLatitude(5);
        state.setStateCodeChar3("FyWhDfFtMFrvLLwWu6hPukp9CPVwgQAv");
        state.setStateDescription("E9brdXYzhDkWdj2Iiap4eg4xeO9ZueJnOiz3z68RBx81QxAs9D");
        state.setStateCode(1);
        state.setStateCodeChar2("xCfxIJn0ja9ot2vl0j260fcgXLkni6wU");
        state.setStateName("M3B5ePKNlo8tVaFnhAUHRslybEijj2jEw9hO8Jcg0Nt3eVB8IJ");
        state.setStateCapital("zpSd2JNm7njAc0zqrO9PAPF4I6TK9VZqHYmithTb8vt8AjyE51");
        state.setStateFlag("woyRQjsWB8lknb4Tacwi9UQRQYkaAE8hoHu2RE3nczKOcvLMSU");
        state.setStateCapitalLongitude(1);
        state.setStateCapitalLatitude(6);
        state.setStateCodeChar3("GTKqut1cTORAvOu7O3PS8UXe9RXwKWLm");
        state.setStateDescription("6vCX9xNaUBu2nPFo1a65vc1m7EBoiZSCpTyOivIbj2hg687IJA");
        state.setStateCode(2);
        state.setStateCodeChar2("4AaradZEGyhbRPJVQLP3TNAPWTXkfPMK");
        state.setStateName("HjLeXxN4QJL7N9RBAGGUrXYhSqfamZxXnwmWmhzdYRTH0zKk2y");
        state.setStateCapital("0AnQY0XZcWMmLoMMSLCS8s8iDXpGSUxZBKo2NLOh7R1zRQO6xY");
        state.setStateFlag("D5GI4VvpWESO9W3qAlgEq8x6YZsWoSUJx8XwaAjOz6zbn7xHs2");
        state.setStateCapitalLongitude(2);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
        }
        map.put("StatePrimaryKey", state._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("PMj8HHVKEaCiRxr7plMAUV3qENruSZb8TtBSbcFUMpwpu0Xn3z");
        addresstype.setAddressType("u9KGSfJyTE5s2BPiX7vTzKkvXhAdCJUSRvntcuQvWumcIS1Mhv");
        addresstype.setAddressTypeIcon("6Sbdvz2RfiYDlDVPKV6H9RosqiTS60rwI7CyAAVdbNxVOyEkNl");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
        }
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        City city = new City();
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLatitude(7);
        city.setCityFlag("163rHGdLSfrx1JL8Pnvdh3Ww5QCmk06vlWkcx3wXqxQAR4LotC");
        city.setCityDescription("j4oilP5HKgjJJlem87qJra6fXULZi6rYjQOHqi5F6S8YPvVewn");
        city.setCityCodeChar2("eIWznCdwIlSkMsuI6qdv8iNVbRFseZ1g");
        city.setCityName("RbEP7aYHsvN5V4ilCvZdZAkZMz4mTEGiwfTIZKh3zTI52oKOI3");
        city.setCityLongitude(5);
        city.setCityCode(3);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
        }
        map.put("CityPrimaryKey", city._getPrimarykey());
        address.setLongitude("B4viOk5HRcE25O8ebDwhTIAkKfcuTKgw7jwgZFLPxqklNg7oPa");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("8MGvlRj7JsGNanDQE5yel6QFyafVKRjycBGAZg53ROSWJwHmRO");
        address.setAddress3("1a4bzXwgeVEIpm0kGY1fhvfdP4tQv69Pdgkl67xsuYscuXF6jG");
        address.setAddressLabel("U2d9Jb7S2No");
        address.setZipcode("okrNCH");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey());
        address.setAddress2("e6nGVr9mYYXtda9yN5eGSzX7ieUTZ86UOhYPB2oEj6Awlk6oyV");
        address.setLatitude("5qHNm5IZEMN6QIg6Ztr9RmxblCbHPi1Gj69EpoJkBNnN80KdZ9");
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
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setVersionId(1);
            corecontacts.setAge(70);
            corecontacts.setNativeMiddleName("9vTI3rWgjRiKLl7OVOCbhWSrWmUDydtgs1UvG4iwe5o6BSwoX6");
            corecontacts.setPhoneNumber("5asvnfMM55HYKCd8geDG");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1458541447291l));
            corecontacts.setLastName("cslF3Knum2Ety1SjhhcEfSZTVNpS57CLoDHA362jo2NqrhdOTW");
            corecontacts.setEmailId("tpE94PdkU5buDzLC2HqO7GBQczuVDy4OaewwySmMlaZRwk2KqV");
            corecontacts.setNativeTitle("IOgltTMGYVofXdpXUBiMRRPFVL44iB4j2crkXbkQHnLbe3E1Uh");
            corecontacts.setNativeFirstName("nZdpQ4v5JzexcIcWOpYvToVzYAwuvgk9mpOdv8fLjJxYK72uDI");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1458541447365l));
            corecontacts.setNativeLastName("HqerNiPSk0VRybzKdKWdBZnM2AMRmUtXf6fQwRtM346YOTDAUA");
            corecontacts.setMiddleName("COERbd9RRB2jCIbgerOIzq6fkyXmDX9IOuwCFiz2sMJT9Nu0a6");
            corecontacts.setFirstName("YV4phpOGC0DHttBKc3xE9zSddwkY6McWCdQ5bkThLoJ5t3iLRg");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
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
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "Sx3L9CkjBiqMpICT8xLz84NkXo5uzMmK68SJUYunDHpWo3xZ9zCf4oFaB4p7XaPHPjMPIz5sIykID3fljUfFfexdoITtkIB5C4iPTcNQOXUv17X91p0F9No01K6Ph3gn7NOUKJhPNBNYKg2m6gIhxkHVQhpXF2ZFrX6ZEzNMEishTPHT5LdQouQSNzK7CaZ8c3LEZ2DOdb2YZc1maSj1Z6xSQHFURSMOa1P6u8vROTejcp83RDqeHKstzREZ1dx3F"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "FVCmctTSk1w0bbCtuom8bpKhXQIVf7crap0O5KvZiJ7diu0WfWDnTvpaJITLXG01Lp2E207bX1L1q3IA1sobRMiSRytoFGb4kM7HqdrP1OJZBqmNHdoqJOyq5uHfsqNaf4iIkl1ZqFTenzfrluBFAFc1730eAzpyQYXpBmbTAvxVvLzW6lZQuIeqfTuQad1zcsp3FH1I7J9YvyWE9H7UB9CdRLvUNdPIJ03QMGnU19X2DCfi6g8kOH7fFIgiczs32"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "GNDFsszNczCozoj04IGzxxrEEoNK6baNlDxeEPxYdox4hYKjA428MA9SuXOciuv3DqR0NbNS0A1cVhqPbOWitjvGBmc5a9RmNBuTRDtMHkOoHlboFdsI293mWSR4hRfqoGgsHwvOhHITfRLq8uueEgPBKXfAbTipbG8FfAmuufojHeUcSXNg76QH25MUAQKrCsw7SCmD7hiVbOEWz2xzDcOtUDHRBJGICQTNRUxh1Zm447LHfAsZaE4Olo29pFHIF"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "Y8yU0QvTzfvCAfgfE7EtUUsLQzFUWlxx99HudBDftMFMfTPfyx94TU30npVnmcp08"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "R1IlwXIndHxFZTQPUKgGLFgYnkF8sU4VV1snEHq9RMUSBsaCLuqXxEIYogALpMuIego1NlHlZ9IogqzzNUpsOOKN0m7mYScYQvOL1bhJgzhqo55cVR8yqVaWGNPOzQnIo52GReLdxxoVzwgqXzHdpokkLck2jbaqHRFn3iX4AujhMH2yERNiCsm5blM4sLKZNDHoJK36y662DRQSDFmisrTsbABe6PbOhYsvaucM5gMps1T1O08af6ZhKoJHUHqfA"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "0i9xeDHYEVOcNXioLAt1QJM7QjCQyZfQue4lhMRgpyTrEeXI2yOSvMPMyLlml8YyA8RPHciJ1Wrz5LOZZ1m0AB2j4xigy3wFv2mMN2rYhEJrKM0t9a0irlRTfzdiBl1Fsw7NYGpAm7l7X6SaGIrgIsZwQr5p4AzPKUfNqCs4TFZTQkoZWSnGxrFGe43S3PSynWxIOaDalJ4KlQ894oF9mLfPjK1bKcnHb8XChsD7HlQa4zhpIJID1BX78pHsjdjwb"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "ZLNdCWwOFb3Vha8F5TNS0JWFz2f9zkvM3ifWhe7npbd9aSc1GCF5nxSJGfKRkYCKAi1MeK1zLyERmfsFKLlaSJOK9m6FRtS5dc0XLRBpWMVnbhhN1MmtKWJFkJcE6pdGQIXeWbvUaZNGCp9m0TDgOAwz1gl0KeDyCm0UQVmV3VI2P87D7Thxig8luiDeQN9623zXnvDbOkG87bOj6gNWi9TEBiQyQZGEujiYE98G0sbGXsKr1TAe3ZtvmauHZydBm"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 214));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "1IISTGBVTbZ8xEeKstP1X4VMYenEOTRvYAp5taUuyt7jH7befiULIGP5JJkWUW33glkKvonzzMMqCHTnzPZEEsGTpU6QZKNsRJtudXB8mEWQd9NvoX14l9RsE5pQUUMCrcAChmetuelsx6EmNNEQavrieitlbQnHPOdfx2wl5BFLQWp2V5WaUfgQFzsBkOrZQ318WaakNo8GTYGrRELANnvCf0AC8wnieSGeoaD2Y5MLkdeGyxCsrycM6af4QTm7t"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "CP74IUdgiVl4Cb9930mF5"));
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
