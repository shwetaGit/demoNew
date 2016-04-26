package hrapp.app.server.service.organizationboundedcontext.contacts;
import hrapp.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import hrapp.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import hrapp.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import hrapp.app.shared.organizationboundedcontext.contacts.CoreContacts;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import hrapp.app.server.service.RandomValueGenerator;
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
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import hrapp.app.shared.organizationboundedcontext.contacts.Title;
import hrapp.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import hrapp.app.shared.organizationboundedcontext.location.Timezone;
import hrapp.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import hrapp.app.shared.organizationboundedcontext.location.Language;
import hrapp.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import hrapp.app.shared.organizationboundedcontext.contacts.Gender;
import hrapp.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import hrapp.app.shared.organizationboundedcontext.location.Address;
import hrapp.app.server.repository.organizationboundedcontext.location.AddressRepository;
import hrapp.app.shared.organizationboundedcontext.location.City;
import hrapp.app.server.repository.organizationboundedcontext.location.CityRepository;
import hrapp.app.shared.organizationboundedcontext.location.Country;
import hrapp.app.server.repository.organizationboundedcontext.location.CountryRepository;
import hrapp.app.shared.organizationboundedcontext.location.State;
import hrapp.app.server.repository.organizationboundedcontext.location.StateRepository;
import hrapp.app.shared.organizationboundedcontext.location.AddressType;
import hrapp.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import hrapp.app.shared.organizationboundedcontext.contacts.CommunicationData;
import hrapp.app.shared.organizationboundedcontext.contacts.CommunicationType;
import hrapp.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import hrapp.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import hrapp.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;

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
            String logManagerId = LogManagerFactory.createMultiLogManager(_path + "/");
            LogManager Log = LogManagerFactory.getInstance(logManagerId);
            System.setProperty("LOGGER_ID", logManagerId);
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
        title.setTitles("tJpuRBA0I4Ju5m8Dv1NvwkOj1whGreQ33RFzEkOqOwVRqHDlKV");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("GXiwAXFFPsSFMn5TIAQZTnu6IC3EUAXXkKwKHx3QAURCIHoC0Z");
        timezone.setTimeZoneLabel("hXwwbUlxhFxHQB4gvVqefqafQhfEKZTsUeydqF3QN9Sxu8yBP6");
        timezone.setUtcdifference(10);
        timezone.setCountry("XvvungqgTiL96hlXCF8cIvxh5zQePZXh3jCJSTSGPpzljKHuCM");
        timezone.setCities("NP2P2zLaeE0gmADd2tHVGqyePaawQvhd6izKHKyzbuuuAozE4I");
        Language language = new Language();
        language.setAlpha3("xiZ");
        language.setLanguage("rTiHPThhXEroReIx7jt4oqDlUhJ3dd9rUFdhC4LGF0pRbAiUwJ");
        language.setAlpha4("4mj8");
        language.setLanguageDescription("BoTtVwTAslVZrhdAvxaF0txRDsyr3atoB94RUBdAQenWMgTNud");
        language.setAlpha2("iL");
        language.setLanguageIcon("SXjx0ZXBotqn9ofEOdLooqAmPVYpbtr2fsS9tJpwogRytbdgN7");
        language.setLanguageType("u3YL3fVxPVHyZ75JP8qIXVbgqe0fcpP8");
        language.setAlpha4parentid(8);
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("TZLKKhKOh5zqlf20jpbYYj4DAn16sWy7gKyLWt7vON6nVJiWh9");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1461653437348l));
        corecontacts.setMiddleName("qET2kzd58V9Qc7DHl17TwD14bluEmqbQcpvOS4YNzwhCXDaNZs");
        corecontacts.setNativeLastName("Nkw5Pn7mZjLgWL5eqzf0tcX3OwDKJzrqlLzRo3wSELq2sPXOoY");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(80);
        corecontacts.setEmailId("SF5dV3YoZtS0GRCODr688KYsDboGGuapxRprbHm76VBQGaIgCH");
        corecontacts.setNativeTitle("OYa9DACIz8zrgadIVfoix7l6OkL6j6sKNSpeYHtwuV9Y3eMPrY");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1461653437399l));
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setLastName("WQ3e9vF6kHaouXRFUqEe8VUPAg8AuQw2RWomn7wC4CJSu5KQR9");
        corecontacts.setPhoneNumber("BnuP3DtQ3DUdANINXpV3");
        corecontacts.setFirstName("LKCdt8ujFKJ32JWwWSQWOlyN5I23XU5BvSUHITXyygZLvIcojO");
        corecontacts.setNativeMiddleName("5XAGHMGxr5qyxnKslCpvckJVoTAV8xw3RMS7BCsjGQh1ULg8og");
        corecontacts.setNativeFirstName("rLyJX2ypxt5muAX32NUHl0TvzUqNk6VRZ6sQKTAJZTkRyDp7CA");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setLongitude("t1Ls6PGMsWbP9nJflZciCVyLXK2kxHjteTsFAeM6YeR8BdpxSH");
        address.setLatitude("QlD39u25WH18kVeDVe7lekobcdNHG8jVSSJgyIOMGbErdEQhnn");
        address.setAddressLabel("SR9zJQl2Pqr");
        address.setZipcode("1eKUbD");
        City city = new City();
        city.setCityName("C5hCSwzlxAvqV8l9co5WAzDftduZZzLset4hsmV9NXNsv96TkU");
        city.setCityLatitude(10);
        city.setCityCodeChar2("JLfD6zudN08D8ga7DwskmysIt5RTyB2p");
        Country country = new Country();
        country.setCapital("2iHY9aQc0JCXFIaxycWUF3KxTd3UC4v7");
        country.setCountryCode2("QuU");
        country.setCurrencyCode("E50");
        country.setIsoNumeric(467);
        country.setCountryFlag("KivNGhsrDEGI3aGn4So4wt5FvgQp7GFe4WnOethK5yvCZzJt1J");
        country.setCountryName("ntcBjonGcQH6RmuJjaZUGpMJKPdcaFXmKcz5LhSiDmlpRY2wNp");
        country.setCapitalLatitude(11);
        country.setCurrencySymbol("0e0vsX5v4dXLpQrZGt1eoiskGHIKd4g6");
        country.setCapitalLongitude(3);
        country.setCurrencyName("aFhdgQXEcbZA1N41UPmefVL21IWB78sQ2P1Ho49RiE1EnKXvec");
        country.setCountryCode1("6HZ");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateName("BEtbkjnNzBKH6byCH708Hm9EhWLHTJM0HyezGvxU0oh0Z2ug8u");
        state.setStateCapital("kcGUGvk2bLqcXWPQ2Q0YaUJeOEvPHb4nxOwLTANKDNEn7eOclK");
        state.setStateDescription("jfvqQVzxO1D4GR11oSZ4oKuWUqMNBiXB6NYIa9aRSfLdG6LhWl");
        state.setStateCodeChar3("giRiBm8GvoEuOOupDSDVPxzXwtREd5bc");
        state.setStateCodeChar2("LrYDy514x2o4tiUxRtd3Np18AElaZLQv");
        state.setStateName("PP3K5icObyVy9VlNjy9tqa3zkTu0CNao1h2nWrKBA1vx8mJzcu");
        state.setStateCapital("8wO9BkxCiWqR4DfhXsNxI6ouMt8dViPqaDGGE6xk6W1qtxloBB");
        state.setStateDescription("l7OznGZG5LIoW3soOy1lPjC6TAlXiigZDxbIWIw1hiFQU2SxvG");
        state.setStateCodeChar3("hVWm1EOQ3PYweJ7te2qBHLdJ7q4xLMBo");
        state.setStateCodeChar2("5IQDITjfoPl70NjnusEgK8NcotOmPuGw");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCode(1);
        state.setStateCapitalLatitude(3);
        state.setStateFlag("3EY1sBlpzBpKnB93ciLUdYFRrkY2ruwayx3HKYYnrh51Z8jvZ8");
        state.setStateCapitalLongitude(8);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityName("cj6ogiiFZUKWMpxZseVAjgOl9VXwUtug1vY0mE6ivPnecDo9Se");
        city.setCityLatitude(7);
        city.setCityCodeChar2("XT1S2UjeZQflSBCaSVM0Re8w85UEzIry");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCode(1);
        city.setCityFlag("4i078yhI8unLy1j16JZEA3f2Eu15i9jgVYuxxtRaZ787TWxoYZ");
        city.setCityDescription("7vcpm2fqQ8Yqd4vowRNPVGErz14gaRbcEUmaHSqDfDbZTRAURG");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(11);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("6HgiO1ToVfLZkJ7LyTl73IyBd8KHkmxJNui5LT4CYLnChZ3aK8");
        addresstype.setAddressType("eeUpGPPRucYhcZL3jyjl8WGe3DM52PUY0hX1gU5WCMMM1oIq4U");
        addresstype.setAddressTypeDesc("WjDvXD6nz6U2o01RcbUGTijTQvGNX8b13qT1AuG54lZgdtmXKL");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setLongitude("Pm2GTVmn47Vv12eGrvDrGRNXra9qTcIpSwxPZoUhU9bcjoAJCf");
        address.setLatitude("ZCBccB8aKhGaAxOC9hkr8lw30cWYh5oO0fQuYK63kbKWHpgDGr");
        address.setAddressLabel("dK2rNbZOiPB");
        address.setZipcode("MEE8h1");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("FYR7603TDsQ2TOHWhE0x4klV8y58iHmlBWsy0PtTZ3KGYDxspB");
        address.setAddress2("NGncZATelDGqjC0lgcmi6mQ5ZjwE9v41vFt3yv64ScTdju8mx5");
        address.setAddress3("SLqfSPnrZhvtxN85ZYHameg2w0nn069DkGAIpkqwIZmiKawFCW");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("qbIvWUICeLVb1IX37CKFYqpq2pFoUifdbj0Tvdd96CIW5bMFT4");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("zSyCHyfZswY4o3yXvHk3i5SsVPE5HwWHlvYKIfl23t2xQGKT4b");
        communicationgroup.setCommGroupName("VhOwe91zKaU0ZCy4bIKCgNpRrVhCVIO2J3ueWrnfb6KL2ZFIfX");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeDescription("TT3H1PcgXj1RbTcr5LPT9pF33sgNZVjZSWJUeDgHavGsgian16");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeName("CPhg5PAJelW3QA007DggZ2XzB2cLFYw9cyTLnAuHFRzat89sQD");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("Iz40lX5DQN");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey());
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
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

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
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1461653437900l));
            corecontacts.setMiddleName("a9TGSJYU1F72gaFMFeiBcySaPE4VcXMF9SoRBILzc5LLj2RUzR");
            corecontacts.setNativeLastName("BqjCzsbAsdQudEpulcFXf235xzk7EMYNkSlv1Edcoy663yEMtJ");
            corecontacts.setAge(49);
            corecontacts.setEmailId("oiKHD2ZgOtR8dghR4Hb3BpiTgdwfDS1tiF365sFMI1VxRndhvO");
            corecontacts.setNativeTitle("m4DDdArkQjO3J9GA4qHZxXInc2ye8ioCV12YQf5XRw2JgZIPiJ");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1461653437957l));
            corecontacts.setLastName("vkf1YepHULGnnONqIxAQ4F8WYRY1g2Ncu9vjU5jF4HXtT1KJf5");
            corecontacts.setPhoneNumber("1A1Znwu1oQVAJifettIo");
            corecontacts.setFirstName("887pPYAnJpxFOxu7jJYGYchVvjTgiIXUcK6GdOkRr0PqFbvG1K");
            corecontacts.setNativeMiddleName("1ah6b43p9jmu4kOxKH5mU3XJ4YgsobWV9UEC36Sh5IxVDMgzlq");
            corecontacts.setNativeFirstName("7vmVOMhpfgI6pEEOts57auyGqsIMNavcfRmjIYUK6BNvGGHfyH");
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
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "DaRgpEzpFqYSxhvwrKGsAX8wtk0hZCeWdOaWWj1nsm3nbqeO3iTiSEj9txAaiieji1NHi4yPmelbXF4KGecJOKDeBz5ulaEiNVH9KCLR90GlTVJzYSmJHTYohvMJxbfGy8a8WGPnVr8zaGZFDiRFOyMxBHJEVKoJ5w7HlzG1ny9irDwIeNWdHWQxWYHX52PyOr5P2s7ef5zPhUeROJwd1KYWRJtmFSRFxjAgjKDCBpL4Ma3KhjchvwGuzEe0NI0AT"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "91nbTC1iotEjgCXNXx2zYE3CGL267NWYcJori2V0HEn1P5UGjYBElWJenUFeTtTXAnTpPIefyPnaySjcvhPbFON1PCy31XIs2kew13ewUPoty4YcetpWc18u7RQA1NENXElTK9kVtL6PG1tRq3nK6tXQF18RwEVnd0eOH9QqxRlmh4eVM0wEds9gEEnkIgBL16LsoUikM2Wvw5PQFZ4Ac6HsWY7fcLag924CQOj1qtCH2sQyHqG9DhLgfeL1enBZ9"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "mbDT2SZ31C94jttN8dW8oqCf6QzjUKL7QN3SSjlRXg1gNlgAA3mE7sY2VW4SLNbZHER2has2zMDXqixCnnDDGrrbMFyIUKAJ3zYmiV9swOBnfaMb2E4Wf6sk3MEibZ1FNF6xMDhjntUVv2UTi8o5cRtUBqkEGKUz4O0pPd9C52GnhjXKJDNPSpY3Su7g3ob1Drc2Sp05rQ7GLlJeUD8SNqj5yum5jvOnnI9lxRvTXg278STDiRSnj8OZZg3ryLbVy"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "7qW8IYmsHOFoI9igZ3dWza7xNqCEdKdBAKrn6LRZ0wPRkJ4ol27Ar7SBhXzHW5ElN"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "g9UR2uf4wA9r8BbhaeQbrrxFC8r8ZuPwkeA9r6l9RvCRm8hMTxhyNeAQ7smR0o2C7tFcd0BEch2g1nMm6vH91AJywtNjQug6GWOQVseAx9cxaOMgabMo2W76XkQF2fqWXLQTaq4z18U1Zs86w8ecQg5ouBBywdRu6fCtFgpBhfUkeXmzsyoU3WBRsJ6Gsng000QKD8BT6O5i8OlID0WvfCWgT9bvtgUmvAVsTWCi2IDr9rzb0mX42S5RN2RwlyTaB"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "ONPxuZD2FriN4PBhnB63JfwpnK0kTqDMHIsuIM81S9e2be6NxmKhWVSyTyHLvkWEQgT7YQbPx83VmiPNpjLOVPiKhJvIiUhR6o2gZWT4t5zsPSu5NNCvBYYc0XOb2BM3Nik7nc3Xui7XC19mCcXr5ZPFZk139N1UPtCS3PV6OMGZDG83c9RZXd6YqtRE87QmV3Co5JzBgWvwfw0ssasTuRLsaGSQSsbLlqM90Yue8aJoA9fWJGKH0Ycj5le1XrLRh"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "bbROnLJI8rQRAB4uj0LnQkTUVPgWPUco8znrlwSsBtMsrKgS4lgsostLjkpVfz5eIaBna4Pgig20OrX8q3YZz2oJzYOpCFFyktLTw8Gfzut5PhY31ibb9FLEqbQiEcsfj9llvGjZPVZii4ln73EMq9z8uq7FQ9XGYCI60Jpm0fsK8hF7varwNEaW9tsEXAgfP6VcI7zDZP0l9TFdvtXlOSB8aOLxZf2Mvaz6Dw1lSMuweiIiVJ2dOTfGbU2QhycSu"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 205));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "CIuJUG3kyXIMZhExvUlQV4z1lVdzR3wmxcVcfctIz0PS1KW19b7cc86HcIOJaL6R1HPxP2sKKXjoCHUZXNW5U6PQUUxj3DMfy6CvxljYITvTA5PNIJaVty8lYlYlwwflhMIq8kjzDxat91RQG3h2UAqYpMLqHMYBDayKID2JBlw2wSNEDsOHRAtcQNW8diK36EUpBHy0RrDYBlKPk4fvLolfe2qOmZtlWs7uSX0o3pTuO0fdchT4XyHXOO71jeQRG"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "U56uxL7dJ389BncX4R1VA"));
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
