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

    private CoreContacts createCoreContacts() throws SpartanPersistenceException, SpartanConstraintViolationException {
        Title title = new Title();
        title.setTitles("ifUd1i1wriiTFdrlEiBjsfWZMLKKqBbKGYioCk9Udksq5QIBq1");
        Title TitleTest = titleRepository.save(title);
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("EAHQvstgsJelc3mX9a0xDb8qS6PdFwZK815pRG0XGUNZQggOi6");
        Gender GenderTest = genderRepository.save(gender);
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        Language language = new Language();
        language.setAlpha4("ThrE");
        language.setLanguageDescription("NlwOvDY26wnVvVerRewSa1EtcsnMUgMdH6BUn5VELbQd19B3JV");
        language.setAlpha3("aqJ");
        language.setLanguageType("JlEism932W4172QxlG1ceZZOizB913Jh");
        language.setLanguageIcon("AxzNTxeCK0prm03GJQMjrWOfJHrz9HHiOqUKjCJy6fkMp7eeGM");
        language.setLanguage("zUQB7QNFTdYjb2xiWIsdfac4YKnQzq0ENAPP23scOpOtieBetk");
        language.setAlpha2("ms");
        language.setAlpha4parentid(3);
        Language LanguageTest = languageRepository.save(language);
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        Timezone timezone = new Timezone();
        timezone.setCities("ByWiVUY8MVt4E9b54pT42XHfpVTK9PWZkkV8QfmZEDVLOpJTaL");
        timezone.setGmtLabel("ZcBAlh1tsXYwkoZ1XP3hkxdkcqJg2XPI0uDGBn695KICJsmO2Y");
        timezone.setTimeZoneLabel("mc0kxVahsiiRIE7LmRoNfWYT68bsYfvatya20BB0vqscWBVUI1");
        timezone.setCountry("XnhusnoqOwWDbAnCxMlOfYzlTgsuO2fLqnXVKuIR91HZP77zPP");
        timezone.setUtcdifference(2);
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setLastName("4nIxMQD8Vfmf6j7p4TxIe2OcJ8R3INHG1M81Y5Kywu61qeOO8r");
        corecontacts.setPhoneNumber("9JtF3157LyEUw7T15ONw");
        corecontacts.setNativeLastName("UYwvcIr01Wjay3hJ5LjkriViCx35BgQPTlHDTa75FICdNmoZEJ");
        corecontacts.setNativeTitle("PtxJ2dRpXgFUvQLyCkwJlCOXyDzd6SmsWa1PWx62PvnDSbSL98");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("XA3TbaClOyPFdcZb7NF9Vh9HXxzQYDV2kfvfj5qkEyR9xos6zs");
        corecontacts.setFirstName("cCKGv5boPCO3hb7Y2Ygc0QqAH0cyqPxs1WmdbXwmeVsgZcGeW2");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("9pHn7uVYTxKyb5ZLV9sSizNGmhRpZlSw5NM7uty38StAl8f8Wu");
        corecontacts.setMiddleName("j10ItRvaSIqADFSXyVHKfWluuE8OsLj6dva1g2DG24f8g8pXaB");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458211478694l));
        corecontacts.setDateofbirth(new java.sql.Timestamp(1458211478694l));
        corecontacts.setNativeMiddleName("LwNcb3a6INRRx9yIjAnAaGlPgm0F8suwrNl3j1N3Q6JbzssJKc");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(108);
        corecontacts.setTimezone(timezoneRepository.save(timezone));
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("4losqyXcsuWx8MO0KQaRq3gDqpJOfvOfmlknGwWOVScZHUS8v4");
        communicationtype.setCommTypeDescription("l5Ierv7RB3B48TaApxOdglq6UFuqWe4RYpyx6XbaxX7pM8bGf5");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("5PRGu4trUFe0I2llHRCwPtVIR8cwwYeTWOt8iHNgb2FwN0bmbr");
        communicationgroup.setCommGroupName("xwTT8Ilbivc2GACaisXMBqbNYMAkWwDMQhixN7tVzq9rc4eePL");
        CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        communicationtype.setCommTypeName("c1ljYIpgO4b0CfYINF8iu5m43e4aZcgHr5u0yR7LtwSBQzzxXK");
        communicationtype.setCommTypeDescription("ZMUscLC9espV0eP14SC1mdj1k1HuPd6wZ9TnAEetxUr36MGLH9");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
        map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("bOfGJDfm1BKXwS90VkGN6xgO172vI49IztB94tx4awIrfjDoMF");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress3("BZsJQ4QOkpN34VnBaBhoT9VtjeOmnCL8xxQTd7IIkwQv9P3zUA");
        address.setAddress1("Dqm7aywBG8qbQHou7YogzaVaqblHPqnPgnktwOzclMCybZsOOH");
        address.setAddress2("2Ki2Jg4OdUDAbFhg0SddcSrwsYxoVwSyFx5yUeY8amCNYO1oxj");
        State state = new State();
        state.setStateName("MnjJvf7cGrQOp5I6iB9qcPvi7qF4qbTw9vm8lEZqu3w7jHE0pQ");
        state.setStateCodeChar2("sKB7lleosM8MiPHwSc1rPXTSQtPBsgRX");
        state.setStateCapitalLongitude(8);
        Country country = new Country();
        country.setCurrencyName("S8UzDIDMYna5x8f799yUhe8CJbk99R3vOTWJ3L3fvHCu2pGSKw");
        country.setCountryName("jjyJAdItdE2mxBuMrwA6mvCJM8El41KmNWvuA2SFzTsipwADXL");
        country.setCapitalLongitude(2);
        country.setCapitalLatitude(1);
        country.setCountryCode1("0S9");
        country.setIsoNumeric(7);
        country.setCurrencyCode("8hu");
        country.setCurrencySymbol("MMytJwqFd9fs4RlgJneqNSqyvtbNB7XJ");
        country.setCountryCode2("zC8");
        country.setCountryFlag("ELpmPsqtYIBGzndp46AXZuaZiUezOgZXZg88umLfLHlcu8jTbk");
        country.setCapital("MCWX0AcxQWQQYLFNzroO0ehhtLCE0VSi");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        state.setStateName("HXqmWvexqMKhKD010npS1vsdg2O50XlpE5IYXSMGoRIm8iTnlF");
        state.setStateCodeChar2("frQQy1okhLtCOhJ6jzXMqwmH0jPWQr9M");
        state.setStateCapitalLongitude(4);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("YSJ7qoaUNGlutxDyinFx57ni5zPVsAGe");
        state.setStateCapital("nc6cbbjyJtumuGxdV3gS70FzrkwOpSe4ovGdx58pFBRh2HCfg9");
        state.setStateCode(1);
        state.setStateFlag("9mDmaOq4Z23a1HzajfOQGAB5Plip8ZBdxYzYMbdC3VmfkAIJur");
        state.setStateDescription("DPSo6AIeA2V11gSfHfKo8xYCaNoDkSsI30JJrlw8HZCqEoNTAz");
        state.setStateCapitalLatitude(8);
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        City city = new City();
        city.setCityCodeChar2("PkqeRNnHUcSyCVQUxAPxY9oPpbG5HunB");
        city.setCityCodeChar2("TaXnB2FuqsA50jpfDNsfymus47tlBOHJ");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("7ma0VH2JmDfFtAYKnxesQtDiDadQZOz1uQ2maouMen8U5pyVuX");
        city.setCityCode(3);
        city.setCityFlag("z6mJV5esdfhGbV0JtCrDTT2iCI9CtT3WdItUyFQ6FHIJPs92qo");
        city.setCityLatitude(2);
        city.setCityLongitude(7);
        city.setCityName("kFzaPbIqVdJad8RmfOF4b1XHkMd4fN6G8dpHlzCwzx1gWHyvIj");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = cityRepository.save(city);
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("ecFB2NxH8QCJRXvjdGZG8yPTvqH1xukczod6d91bqyhRw5xR1v");
        addresstype.setAddressTypeDesc("qXRd57FQ9uWK9SfytJdOKALDa9kGSy2LLdW9OjIk2CQqTNGNFR");
        addresstype.setAddressType("Bn3UUqgCHxpC6SxWMvKfCg2iaVCdO7cudIcQxdOmmQYKqROSSP");
        AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        address.setAddress3("JT4NKa7KYgyIdVYtEeNdpkgN8hday7ftMt5c653ECu2CIOQTlD");
        address.setAddress1("uDka7qXv3x7zLPyCfBIiT11U0Sc3tjceLFKsSYT64WCNeQkiFX");
        address.setAddress2("45Mj74e80QmZutLJeXs6kkefkUb5K1L7hk65a8OFvOeA1T0WC0");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("EVrx0M2jwhCQ9RvxSx8SfVQqbmIpql72W4nzHOh06uWH8H9ZAX");
        address.setLongitude("9JNmVuuzIrP8HSxT7cLrHcTX0GsmVr1reMwZiMSideaQ2AnpZL");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("AIO6x6");
        address.setAddressLabel("DzNdyhijYrk");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey());
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        corecontacts.setEntityValidator(entityValidator);
        return corecontacts;
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = createCoreContacts();
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
            corecontacts.setLastName("rcJH0deaBv3PRxUdRWuJrB6EomAVroGDhZO6olJZaOSVI37FCX");
            corecontacts.setPhoneNumber("i1I59WCkee3bxeQAbRJ8");
            corecontacts.setNativeLastName("Mqxes1bqAdqpJ91A2HxNi1FTscHzEUKpAmLXQpuKZaPgNB7UG4");
            corecontacts.setNativeTitle("WaCLYd9hSU9PFvd5hhmaeeVcYnTsTAgcLN7UYC3QZeBEX3yr5B");
            corecontacts.setNativeFirstName("cMC5kEkZH7UpIyHwIciQXU8MzYut7rSe2KSd6eIQxaNNiT8wR9");
            corecontacts.setFirstName("RNdIxY8IYJ5Rwg1Lst739y4jmWkAe5EXmMlravOCpS1YwfebbK");
            corecontacts.setVersionId(1);
            corecontacts.setEmailId("tdDQOuKedMwQRey6wBejGJ5Pbnim0Rj8KpfmdKID9MCFW0SPEO");
            corecontacts.setMiddleName("Lk363i5BXhVj7FCQvyITDxUBfSsmaasDfZlt7v9vW8VtM2x5H3");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1458211479240l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1458211479248l));
            corecontacts.setNativeMiddleName("ReiJz2EcnZJeSQu2kjOZpUBBQ7i8DhJOgNBSzF9l2jwp4x208Q");
            corecontacts.setAge(52);
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
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "d1foMo8Xmrjf2lv3n2vzGSvnL9NLsB3CrLvVtfmQJ3ccwKNu8HmoUmQJ8NayaJcdtghr0O7EeHexSyOuKg8ejhNcwojPuXa3XXHy8z54WEeRN2MlzABkJ9wUDYFNYwt2msbhPyoVI3Yx2WqDH0G6Eg06mhFRISygVuhRpV27dW3K8yIGtshaWd4Ouq5uchu1NfFBzq3NX308FWKmJw61R3oQKaUxZSsn7dK9NakCpncaKdVtu3ZYD8OEaS5AN1Cgt"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "c2eSnFiERFiZITvLit4z8AwPaNVQtK2QyHc1d4tW6t9Ob08eRT8d9OoTADAkkEbnLoQeNINU0WRom5cissT1EBu4FfJxa77724GJoV60Bx5zvyYd6kekKWs8YXno0Bu9aOftsx5owe1unJM7sqnFXTwYjy93t03Nhy66f3xQOphQbF373dRwLPAELt8uBlmKHECJpT6mllWZninEl9yI1n8oRdM1yCU9108VNRrxjWStdMTK4xlf2STNwLQsbPujw"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "9tZeSdhXQNRuyPI9un4gaB4ZJEcKJgjhhWMoaU589hRhWLdxmQnhXlTRQfbssT9QfA0Zt1iAo2dyUJCTWHn51tYNUf7XGKMrdKcOOmP0S1nz2w4ZbSzn76DiILu3gHyhIjYoVS7LOsBAMbSJ9hfwpwj8FvqHmoR9XQMTaHS9ENjMvkMjhzHgRDff5PUXE3n36cO1KyjCbvuambpMyPWNEhbpUumYiqeueWos1NzjcBQMpjkvYays8hP1oLKZx1VYk"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "KbtfQxjzWcIKl098L0qvWJsLFSNA2Qp3dfh8bAYrkLJ5PWPrVrFyOa7GxAxgw6jVW"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "6810Z3PcKOwPSTIdWrjJx7cBEE7wseZicKaxSn7t7d8jNTUYYoqoW3EnFqM4OGibugTu8Cee4ilwcdPFLZy0j0iAfRENXDkQMnN0QahppH7WQEru6R57P53Lcv3ZRROvd3Q7Q4CYeDLQSRXAdqbmEAk9AAzpui1VUGsUqLUYVpjs9LUR020ABCE67kyBPLBpu0EdPXE2kBK35s3iBSH39Cvt01kCnKPqwqU2FoexmHQ7j0p5Gqgws0b87QA2scIHo"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "TMy5x1AFG3EgbE50ch5xYASOtlt2s8QTfDLUpOj3cemcZKWlBxt3vHnJarn1ICbfurWspN829ZhjAqBZcOaFusEwqNuYufzgAc8g3H4YDevUtj809e3YUVmjLgyO3zYiMkn8fRMcuvyRu2iswUqnX5uNVnRh4zCqdC5Myg3sqAe1GoIsqGtLv15ysmdhXOQgVyIwNudOPczPylX2PukKDrqSQbeaV9CUyeEsPGxqZe1RWwgygdrtCKswx6Ez50jyJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "V77U1ny2Q6eDy48ctMR4rm708Y3bz1mnjL7q5rK6c16QN0o2snX1frTrHiwZOmZKbQVwPQrbGIh3SO7tTYTu9WrWZHQG8bWkDkMNicXcIm66S1byuvMClWRUTniZ3ql8VUZ3c1AfZN4wrv61P56lQBV9XjuuLp5yxPNmY6XEPQZ3Ih2cnmtMOCApZpUo3NdwDn8ZL6pkiz4SeFxdUffaIPAly0BEs3pvaBxnfS2IRXqGTcbCYefhJXkWYP1oNUEWY"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 180));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "MNKjt1QmJURoA1blcN9tCFXDmzmLbiX2EbdWxIkrR7KEihy9BSJjP5rMdZl6iaOaYEjj4dodL4TPy9qHI0WiR649E8Cpi1KayGwMdJZoLDJiBfpyAzGXhjkYRtjE1IL9okm8qECwHjlY8vJyLaOiIQZvguKucX650deUpWd49bNboIY3X7Z8ZRHlFs4O29rgw8HQ3B8wDQpguEDpontmNULiHVqO5qiQMWTtGHswuv4q9D36yukS5TFyjrx8gCKSK"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "TH61wU33wxqm1QFRtZDU4"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CoreContacts corecontacts = createCoreContacts();
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
