package com.app.server.service.organization.contactmanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organization.contactmanagement.CoreContactsRepository;
import com.app.shared.organization.contactmanagement.CoreContacts;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.app.server.service.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.springframework.mock.web.MockServletContext;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.server.pluggable.interfaces.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.organization.contactmanagement.Title;
import com.app.server.repository.organization.contactmanagement.TitleRepository;
import com.app.shared.organization.contactmanagement.Gender;
import com.app.server.repository.organization.contactmanagement.GenderRepository;
import com.app.shared.organization.locationmanagement.Timezone;
import com.app.server.repository.organization.locationmanagement.TimezoneRepository;
import com.app.shared.organization.locationmanagement.Language;
import com.app.server.repository.organization.locationmanagement.LanguageRepository;
import com.app.shared.organization.locationmanagement.Address;
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.AddressType;
import com.app.server.repository.organization.locationmanagement.AddressTypeRepository;
import com.app.shared.organization.contactmanagement.CommunicationData;
import com.app.shared.organization.contactmanagement.CommunicationGroup;
import com.app.server.repository.organization.contactmanagement.CommunicationGroupRepository;
import com.app.shared.organization.contactmanagement.CommunicationType;
import com.app.server.repository.organization.contactmanagement.CommunicationTypeRepository;

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

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        MockServletContext mockServletContext = new MockServletContext("file:src/main/webapp");
        try {
            String _path = mockServletContext.getRealPath("/WEB-INF/conf/");
            LogManagerFactory.createLogManager(_path, AppLoggerConstant.LOGGER_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
        runtimeLogInfoHelper.createRuntimeLogUserInfo("customer", "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
        runtimeLogInfoHelper.setRequestHeaderBean(new RequestHeaderBean(new RuntimeLogUserInfoBean("AAAA", "AAAA", request.getRemoteHost(), 0, 0, 0), "", methodCallStack.getRequestId()));
    }

    private CoreContacts createCoreContacts(Boolean isSave) throws Exception {
        Title title = new Title();
        title.setTitles("kIWrCYPwGDZDDTKUcsXGI8VAr9EDExURDnSdfEpcgEoMrruQXv");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("FcmN3gUtoV0yfS2e9CcyepJs3ApC86bFpuzOYhkHBFFPLppO5S");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCities("uR9wX7z4rJiK2oflGtV1xyJ4oErJLjjWW0BxZ6SsFQQpbpmpdQ");
        timezone.setTimeZoneLabel("oTUZePBVGPXwNYpVkJIIQ7nLfe01J6Nc0wzrwuI9mzozhCIgKK");
        timezone.setGmtLabel("jNJvOHfuzJxMrk11HhoQY84g2nceaSDCuQueUw7e6nYhLUF0qK");
        timezone.setCountry("2D6k2FLPoeQnZaTEgIMUWPp0TMXYUYwsS3q70NeA3W1rMx1ZmR");
        timezone.setUtcdifference(9);
        Language language = new Language();
        language.setAlpha4("6zmB");
        language.setLanguageType("gBLD5610t9wDX4MaJKDPBg23OZD6kwEp");
        language.setAlpha3("Ik7");
        language.setLanguageIcon("TzCsU9TU8Iuv72kGYVs8YAT5qEyUbrhrLGUfR17ecIMXRZfzR1");
        language.setAlpha2("G9");
        language.setLanguage("XtZWXCdvNERkZ87y736QnLeGSroGkQYdgULG3s72Lsyp0qfvQg");
        language.setAlpha4parentid(1);
        language.setLanguageDescription("l4YJIzZCp03y9H9plR44HiWvfhVeqNhRACxSjfp5vSQjSzYNCN");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setLastName("otgavYxWsoOJraWnCiQCgi3h7GmjCDgU48fEY7P3HgZbOOPLBB");
        corecontacts.setNativeMiddleName("oYJL6sVKuhZ4Mq6vYBteLeKqq0oKODc28OCdVjtp50c7q6nY64");
        corecontacts.setFirstName("Fy6UFVzP4eezwmJtmSue5DUMvS0kD7NVo9SXstvu5i7M963YUP");
        corecontacts.setNativeTitle("rhr8TC1TsX5ox3LYz5pTzcI6HTBjTXpsDejgCkWssF1QFVcW67");
        corecontacts.setNativeFirstName("orBTmVvXEnIlMJsGZk4Kq04o9sMVK92xvFZcSXMrZDiHYOcp7u");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLastName("uo5tRx4ozKrhLeTi5CI43TtmheJ2qAyEGbteUrcvaCTnGd6cma");
        corecontacts.setEmailId("2YpBT53GzFsY6wikBzEHPWkxmVUDXzmsAJ8TylqQ4W1XWgFv4r");
        corecontacts.setPhoneNumber("RxsuAr5G4ADAQu1dqaLk");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1463133499469l));
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(14);
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setMiddleName("FFYrM9K2XgIfBKZx2dkZgkW9O9CtHUI0DYhHJ1atE59XVl0vTp");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1463133499535l));
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setZipcode("psXpl6");
        address.setAddress1("Yh07bHp5uku5aKqVzqYoA2lGGvYKFlDTrwBhWHBfnU9tTI53ef");
        City city = new City();
        city.setCityCodeChar2("SxlVspoSRNdH8uN925uq65PYfjgcJdzC");
        city.setCityCode(3);
        city.setCityLatitude(5);
        city.setCityLongitude(6);
        city.setCityName("ZAcB9DM3RJyzpFpf4jJRtCzxv3hDwV2hEMZNLngCodvrqUqP4u");
        city.setCityFlag("ie4ozfPnaXcSVAbpVYhoYEGntTz9TohMSSh1m5hlePgbivw4wY");
        State state = new State();
        state.setStateCapital("9JZBlRigninlP24R9DqyovzVRHF2W5XByE6BFJtsMrgf408yIu");
        state.setStateCodeChar3("UIJTVrWk6IUXGmPPVU304ivRfIiif2zR");
        Country country = new Country();
        country.setCurrencyCode("D5B");
        country.setCurrencyName("fuLt2sv8M3JJVBIzmelucxxIEDgehWjrwhgMU0ZzqLNHaC2Y5m");
        country.setCapitalLongitude(5);
        country.setIsoNumeric(326);
        country.setCapital("kdQ9sb49lrJQmPxebgo3w2xPBM8Ft32o");
        country.setCapitalLatitude(7);
        country.setCountryName("F5YnUZ4ExSbmJeEo7lWXOpCbF9Jk6B16SrMkEaFT2A13RCcMAW");
        country.setCurrencySymbol("2ygMH5uif7Iqv1M2AtBeWnWkoWQBRW71");
        country.setCountryCode1("dHq");
        country.setCountryCode2("tOq");
        country.setCountryFlag("qK1Yc4nfPwCeedRQvktcl5rJoMeuwQ409SCbGR9Qw2ksmbw7tn");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateCapital("zsEEgcH5sXZizvjiwMKJtO1aC8d1NeikccLVtPJUQB0SIyX8ET");
        state.setStateCodeChar3("tC5oo1mxf3oqw6vto6ahMPgLvOrI13CE");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLatitude(10);
        state.setStateFlag("khKM1gTLkBTc2lX5VONHFIwYAwRpVlc7Pw8skfGcTXqBK4EE4c");
        state.setStateCodeChar2("VI4OJ2etkRZOA6V1yDyurSnZKiaxkvlX");
        state.setStateName("Z1Q1r740Hpd4H67NByTpKfxMCAm2oTKD3cPuUmgNhtnnrpxlop");
        state.setStateCode(1);
        state.setStateDescription("UcNUWINcnFingnidOB6vbouzXTzEVByMjiWmIM4lckxQcuswCJ");
        state.setStateCapitalLongitude(5);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityCodeChar2("XZyxrZyYT9RGCmaNTMQpzfmLnFRKIb19");
        city.setCityCode(1);
        city.setCityLatitude(5);
        city.setCityLongitude(8);
        city.setCityName("gPB35JlHIBx5v3WIgwEYXbaTXVxvhKCGhGb7qP4oqOtPZpub6U");
        city.setCityFlag("ujcD7kFpW49158iVSAnhleeFYVEOYLhL0ck1dPpQSsMwAb2mEW");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("pfZu5SNtpD2tEyEx1YjxDTZQbRv11lbt5T7KpAifkXpFEVWUcF");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("hv4KXqKrafBa3HlHSWERcHsJDCGLU1WHXqZBaLVEbY5aOdlEJx");
        addresstype.setAddressTypeDesc("4fTGc8xsFFPVtx9pGzrygKDJpTxFGGAnfDFpByXe4HM2TIk4oD");
        addresstype.setAddressType("CT6ptnVjWxM7PncQsUfRfXVqtjshhWFEb8DQrU1QJtAff8bX05");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setZipcode("NbSBkD");
        address.setAddress1("PXhaILP5DF4dRutUdr8WrsTGwNRViop1Lfd1JVR4QQDTZeqDLD");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("OrcVeEM2EyotLJfY0NBV9McVNJbiY5fdWH6zG8x23ddqCRopQW");
        address.setAddressLabel("CRQE6Aa95fA");
        address.setLongitude("QgbjWGtLGo8AWcOp3Q1LT3wjf8x8TV4IeuI2xBm36G13csrZFy");
        address.setAddress3("aECTNTuh2eHZNV1JGooxAWK06x9UxqmrdII9idPKA9F8ZNfe2B");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("1dg0rbPDKks1e1oaD8QDmqfnDTX6p6SSJrlI0cAKAf8sR7YqVW");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("Rfg6S5oy58K9y1H4IuaZkCGJwSsnV81UdEzHh1Kq8isf2WicuF");
        communicationgroup.setCommGroupName("j1GHD2WVVFHOQAWNdnipV6Fdope22rXKvuI10DNHTPnwb9hGCC");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("orw2S0CJO3ST8Untnyr9eJszB5cfRxAyS2kA8YRe3cfF7JrPc3");
        communicationtype.setCommTypeName("UfHmF9auYOLFKtv6IyItBQQBhP3GSrpgtNsfl5V1kFjALXMeaV");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("ZxYDGnVBvs");
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
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
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setLastName("SVq949dIfxGxsOzovt3RybptO1RXxDbvmaANiwhYMr5eBgeliX");
            corecontacts.setNativeMiddleName("va4GYvWKO3pt4pcHmfHQecIEaqYvdR6txChhhIi7JSnSP5migj");
            corecontacts.setFirstName("CmfG2AZLudxdfPx8AuX5NjVOMA5cXFG2bNNVY8Y5DuAUfYPqkn");
            corecontacts.setNativeTitle("NvR4TnhlLUzYpU91qtoPSytLlpWTeLBKIv8Wt7kb4AULzUYCW3");
            corecontacts.setNativeFirstName("qzVmZ1fh0UEd2d0I7rRcCTQykaW4iVzcBSnlcyqdtLie6GJMmP");
            corecontacts.setNativeLastName("1unt1j9D3ab9wL3XfTuin1JZugY33MxkYPF2aSYo6EqzxhgAXs");
            corecontacts.setEmailId("rNX8pSWOH07SckAFq5ZgJJ9Ms1AhUY94XhDgns1DqHrptLBuOC");
            corecontacts.setVersionId(1);
            corecontacts.setPhoneNumber("aIey1Sk1uyTtl9po7YpA");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1463133499976l));
            corecontacts.setAge(8);
            corecontacts.setMiddleName("DLYjRpWVAPmubFbN4utGgPAZzhalVCLduAVcezFw1AMHyy4Jua");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1463133500056l));
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
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
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
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
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCoreContacts(EntityTestCriteria contraints, CoreContacts corecontacts) throws Exception {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "8JLd8ZWLitvH7xAHODlUfwEWFDjFQG62mJ6TzuP1to4yIYlrKBhLC6ln0sc9PKue1sh4kiaMAYEWygOoauHsK8T82kUALsIHSuAoizPeN5TSXMi7Hun7BUyfEX0jop5tkg4E5wqyDl0vVLTjvwjF35Ank0PYaNHtS02WgfZyRmokubLO13mNbwAZR0DS1UK79d53MWbjPv2oZ4gFIfo2vpg1uYRNgmqeXkwX1I5AsihwejOYRVVvxmDFya2QdGFO1"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "dH9pCJtDoN559IbvKhkFtLXtQjDeRcKyb3QCS9KlW3COImJgoDzqTytyXEF9JejrwXtyYV3Zs1DNc88vzozQ1iXhvZtCQrjn3bZUPN0dlap5fndL6ZeiJ7XW722MDpGuqkRi9uUsWZQsoVM7kwn396ZDYQDFMeuPADS8Yo2EZ4fTcVdkVe0PcIroaFvx9UVDUuV0N1E3mjKDFDGy6O4GbNIgAjBe8KZRgSHH9oPySEiVXTNccozD4UNtcvuafn6G3"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "AphAh8uIPVG1s93hjUMVmoObC5Me8qsJqsfSMdFAr1QjoY8PgGBAgcKpzYgOVTe2bDSG49mMPlixdJSJNSgUSzQB2OVd6IQ5mh1lp6O9onYjNS0EjHVEcgKYkJKLh205by9dl5UUQ7kPsNSynSfka9Fu6C26B1wHzHEGZsP3sqpX9Ml8zsEI198Ce1G3NQGZ9yPvNKOp5XxHPcuOgUL5W6gWDjYbi7ZJDiOSzrZR7ANB3veMlnRby2UGOSZMYF9wq"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "nPb59jLLWdzhaAgZ0pWT97326793YX1pkEN0eZpIpDLr8OO2eI3U7T8LWzCbhs5UU"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "ssdsMk7C55d7lGhqCruirUxaj9NukAEYnsWTf1o6SmO5Kmf5aANWYzt46fhr6oqnVDSZY2KcYkBII8sZgk3rvl9jjY1mG8zKWxAa8gOwc95YyQJDW0MX1bTiEVetCtUiK0D3AAkFyqW1JDs0xpaJu4N5bUk651bk6jSSFurOA4WDXR2DfdafN3eM4dnji4CBiIOk0odaH3Xcb52ujCcaF6Dm3pTuRtA3JN8v1Z3lNPeeognK8b1mJzD53tVm3VI5I"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "8GIVgENsKBcsssJk81Se1Sx8J1Lx8dlCMWlhL7XOlkJWrb0HvUwhj5TWVXAULQMMo4zSrjhJPW7SYNSk1rfgHxpxmYnNNDQawcL3J4pfM3jb0LG5xk2qDq2myuyPedeDXRlLROhCyb1BH5VuZ9jsuLGFUiSIPmyh1weGpU3L6S2kohRZpspDPzoN5qpjWTxIQ8LZSv0Uh5ix4mRUJrHmwZmd6KqRRrfwBvctRamFlNsaf8zf2pN7q9RqX4khQWbvV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "xNB665vcW0Ar9oY9FPT8vObQU1kbmAUkQUAGRqzc4GhXdluKLQrWnEg7TJjo5Pj8lNczeHjyRGKWvJHX7FGyA6IqUeGivv8YfdOPWj6F1ywM2Q9X9OxxujJ8hqo5GHJmHJ5yVSWtKkPU9B9VrCau1M9hKNiIOiba5TqsSJsUp2GhCzVIGEoZAIbuD9og9vofPwcvyccpzQoJi3jBFkGjy0pzKpqjnbm0ppcU1a1tsQaK0rdDTzVHFCYgiENQEk9BM"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 227));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "0yyZ2Om4cDZArLYgBuLyFlW9EbsWtfOEMzGRrlApHrVrw7xY3lJIfynWSf7D6E3nzMspS831T1EkJPEx5VqwvNwjponpe2JeHxslAIwxvaBS5PL2ETFxNtsOpqV0nY7FsffQck881hufJYyYOYWxI4NwNwgk8k7SOsUttGrucVdRjZWob3YHEofahLKopwBnJndc0Dzt6vienTi2XDT5d56xjMDio7oTJYiMgXyZBK9nmoaa2Ox6ELl6QgosOh75y"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "BMpqvJS34yolXh8qbMNNu"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CoreContacts corecontacts = createCoreContacts(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = corecontacts.getClass().getDeclaredField(contraints.getFieldName());
                }
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
