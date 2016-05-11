package com.project1.app.server.service.organizationboundedcontext.contacts;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.project1.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.project1.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import com.project1.app.shared.organizationboundedcontext.contacts.CoreContacts;
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
<<<<<<< HEAD
import com.project1.app.shared.organizationboundedcontext.contacts.Title;
import com.project1.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.project1.app.shared.organizationboundedcontext.location.Timezone;
import com.project1.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.project1.app.shared.organizationboundedcontext.contacts.Gender;
import com.project1.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.project1.app.shared.organizationboundedcontext.location.Language;
import com.project1.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.project1.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.project1.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.project1.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.project1.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.project1.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import com.project1.app.shared.organizationboundedcontext.location.Address;
import com.project1.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.project1.app.shared.organizationboundedcontext.location.AddressType;
import com.project1.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.project1.app.shared.organizationboundedcontext.location.City;
import com.project1.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.project1.app.shared.organizationboundedcontext.location.Country;
import com.project1.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.project1.app.shared.organizationboundedcontext.location.State;
import com.project1.app.server.repository.organizationboundedcontext.location.StateRepository;

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
            Title title = new Title();
            title.setTitles("rNYWCqqIejaiDCCpztRd6pK92JbIrH38zOfiQB1FJ0APaYx4Bz");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCountry("ypvBTaJsKhKqfntkEEyo1H89KYQolVuRxyl5AEPt6fe7MMNjJF");
            timezone.setCities("zCelz93GEhiIJ8Fe4FTGjcMVnoaki1kibNM3Mygx2mPouJ7njh");
            timezone.setTimeZoneLabel("sDdAuSqf2Twd3hldMbhBGjLhl6lJ6hqN5v31AtdIFwQyvl0wCh");
            timezone.setUtcdifference(8);
            timezone.setGmtLabel("gfsFw4K6j6s1bqPunEtG9JPW7bI59oyvNFUfttUmYBnY9kTW91");
            Gender gender = new Gender();
            gender.setGender("w2ARK5c4Lh1o3dII3nMYSRcFwEW6g6XeZDe7vUXYS1yqx8G1zF");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha4("3mXV");
            language.setAlpha4parentid(5);
            language.setAlpha3("0uZ");
            language.setLanguageType("6jPqP49yxLpA4Ike8T16wOV58ECh5OCt");
            language.setAlpha2("tV");
            language.setLanguage("0J40eqJ9JfEYW9huUJFw5IOxb82Dmfb8feIWXPqxSN9fF68Rms");
            language.setLanguageDescription("OXmjS8auUbAk30OFz81rcV6KknEoZIme6NnoIKvL2oHDGuCriA");
            language.setLanguageIcon("znetLPujDOo2at2pyKBjegwZgLBlzYK3KfoJDEGoJBbsmeug0t");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setMiddleName("XuWnoL1Rkta4QR6PgoQoDApJyt35sMnIrIqJQZVf2XA5J0bjFv");
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeFirstName("7U3RUjdUGxk6nFwnIAN2uIdeYydjbqNY3A7Rfp5uZUD14DeOOV");
            corecontacts.setEmailId("5vXg4YkavUzBy1L1iI2aKvn41fZ4id7k2YPNwcijgVYoc08goC");
            corecontacts.setFirstName("sQYq4IotU80DaKKiq58eBMkwC49nM5XP4FsSprcH5bOoLCRU90");
            corecontacts.setPhoneNumber("JbLsYkGHoU69leLLPbt3");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457502847875l));
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setNativeLastName("jlXEeZz9ThpYJFMnDeFrpXJraXgmVRT810YC3l6MUQlMVwueqP");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setDateofbirth(new java.sql.Timestamp(1457502847991l));
            corecontacts.setLastName("I5higdxknN1rUEq3mPmvGe9KLs4zLuWiUyFBkjdZwQTo15uu3R");
            corecontacts.setNativeTitle("ZmrqvQgAfVwusBUnlwQJrYXj9cyZNv7NTISOyIbDycCGxzGPaf");
            corecontacts.setAge(50);
            corecontacts.setNativeMiddleName("dhtqAwlRPXXSjvvjIQVdZpukuEiI7C8fRSoXPr7xPr9oD9lAOI");
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("L");
            CommunicationType communicationtype = new CommunicationType();
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupName("LUpdxZY8nxt6JX1COn4mBZY97Lz6k8AiEHqntqXsFCzFY9i2yQ");
            communicationgroup.setCommGroupDescription("7oiUncfFPP9wbiU1a2xaLCP1JEACU8RIkTbl46cSQ5AkxhEQjK");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeName("SXLkirPnqQU9bLspACoEymHCoYiF2upTDv9XfUzcqI3CSvmQ0Q");
            communicationtype.setCommTypeDescription("Q40tZWWQbxWmiBrpHE6r4ZIFqCCSZNcccxIaUXTFckNBYFMQLZ");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("2");
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            AddressType addresstype = new AddressType();
            addresstype.setAddressTypeDesc("LQeMp7HSyB4ibQ320AyBVRO3PtERdRS6K3FVuagRoIySu876tJ");
            addresstype.setAddressTypeIcon("lkPliM3SMQtYBGNfzYptUJPlmhXFTz97OiWqLWqplcVpPH9JBE");
            addresstype.setAddressType("blU5uKmIRCCFQmxaqWmNWQTOQ94ZAvrP3GnnkYclvJRJsL0fiZ");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityDescription("HvdBChZoC92QSGcn6VhJdn07cerMIxLRcPVXzwCNh1PgOGwrhT");
            city.setCityCodeChar2("cxryzbbqLIJ3Q0MPM8ymESZ0XQbrXRJv");
            city.setCityLatitude(9);
            Country country = new Country();
            country.setCurrencyCode("jeo");
            country.setCountryCode2("8xB");
            country.setCountryName("d38ZhKJFCK3hZsAJwrJ83v7mzD4dWGji4xH19Jr8WPhWG8OB3C");
            country.setCapitalLatitude(2);
            country.setCurrencyName("67h57uXMLgidGJK8G0C0yw96Boe43HZHuCDCPaHywtT5FuJLLu");
            country.setCountryFlag("Lpg9YBX6Z46GJvb3rdIuII2Sa0Kc7HUqlZKbEnofj8Sc6oJLlg");
            country.setCurrencySymbol("hbEbbApsAnajzAJhDkZOclSqL67vPP7s");
            country.setIsoNumeric(2);
            country.setCapitalLongitude(4);
            country.setCountryCode1("6mD");
            country.setCapital("qXBG1WmAYBUJzawg7O4BAq3YnLc22KxA");
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setStateCapitalLongitude(8);
            state.setStateCodeChar3("CFg2J54Uqf0pF7irfBdncxrixfTcNGf8");
            state.setStateFlag("otfh2q5LBGY5uwJvrJUG356NP7QcDP833cflqW7aJhm748Alji");
            state.setStateCapital("Pur9FAu3rFH1uC5WxeJGnLIf18SMUWtn6R3UCYSAI5a4Jwf8ue");
            state.setStateCode(2);
            state.setStateCodeChar2("W2RQSUkJZ0XamJLBVpowLxYte6FYBPam");
            state.setStateDescription("VQ7RDffeuBdpU1IU5bSqpzlN9365xcBGApY9ToAaAtoDlI1fkw");
            state.setStateCapitalLatitude(5);
            state.setStateCapitalLongitude(3);
            state.setStateCodeChar3("68cGz6ITB8acqO8PPjElolI5Rw1sicTf");
            state.setStateFlag("XMUhC996p2w6KnfBwsq9G6eJjxBC7FZmZkJNtgM0C6yDCO1wXm");
            state.setStateCapital("J2Wals0ckrSRsp8rvFL8UcIr2HoOkQiTBBPVXbo9a9n1zwTa6S");
            state.setStateCode(1);
            state.setStateCodeChar2("Bceo9eSbsJs5QRoAIStSwF33h8oXCb6E");
            state.setStateDescription("ghyY4PKYnn2EEZ2PBgjNFwpjKSp8Kgg8SJWdoAOqIU0v4KttyK");
            state.setStateCapitalLatitude(2);
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateName("c5LI2P9AbAO9o9qNLHJFVuM1Qy81KUCpRIC23ejTUXQ478aWfP");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityDescription("WDWyvL7VhtMDNh0ynqt0ckwDUETHiYwfGBZq4mMYFbrnAzBxhy");
            city.setCityCodeChar2("LBKvBedNWcgVZAzWCr9ilI8De7zN8eVq");
            city.setCityLatitude(11);
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityName("KHitTs47BAVJCaVYwQndU4VS7pphyM3Kkpv0J0RJLAWHfwWvs1");
            city.setCityLongitude(8);
            city.setCityCode(3);
            city.setCityFlag("XOIaYuzP3JnNHLG6oGyZeYMZjygWIfuiEgQNF4p1gQlgLIxXMJ");
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("f8rvQK");
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress2("pI1Y7YFjhkbbsP7iNsbBEz8puqpoL2K1pNdV1kqKgDj4acBNQ4");
            address.setLongitude("c02nGHkRTWSMN9ccVhBDE9z0fEDzArrXPz86PaD5x6Xru9EQV0");
            address.setLatitude("ZQlII7RcLlF435OoTlg8rRZtCp0C5Pcx6AssvjGQjhZQ9QOYDK");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setAddress1("ucQHVkoxvGP1yit5fP9FDxCoTyXBJOz5EWUuy2O0aUtdqAcM6H");
            address.setAddressLabel("TYEmegwwTaO");
            address.setAddress3("8oNVAditmDyxsGVrPK281NsXUe7nk8R5aE69jtdOinOtKQDdzr");
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
    private TitleRepository<Title> titleRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

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
            corecontacts.setMiddleName("WlixBKeqYo48X227cTzlnnhq7BzrodrC0fAFn7FE3kyGIFfWHh");
            corecontacts.setVersionId(1);
            corecontacts.setNativeFirstName("Xp4Hg5MYB2aCx1lvUEPwx7ufFS6sUK7cuRd1KFF1OIbuOTYEEf");
            corecontacts.setEmailId("yhT2fahQnTt3iafUcP42DTuDW5a7jLlSbzJ3phiPeoSA4An6kF");
            corecontacts.setFirstName("mETNXdfkirfpTyi3TVH1uFb3Ag7W63tBxl1f3M4Y3KhA7xVpHn");
            corecontacts.setPhoneNumber("0PgxCkBV58NbxMWfijYJ");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457502848427l));
            corecontacts.setNativeLastName("eLx0ZF41oAQVe6Mcajqb6F60Ls6Q2ybTpVd58ugLyqHAScnU9Q");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1457502848463l));
            corecontacts.setLastName("UHCj5urouxi2SEp6EwpGBLHgpY5LkZNb1MNio9D260HZnQYfx4");
            corecontacts.setNativeTitle("MkMuN2HBVwoTBhmqpRCw5LrAG6k0Nnt0q1Wg7nqJ56whdasIaJ");
            corecontacts.setAge(47);
            corecontacts.setNativeMiddleName("raaXiOO5JEyg4gatdLnjtimucE7puC6c7oEsm8bB7ShzlcCZkk");
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
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey"));
=======
import com.project1.app.shared.organizationboundedcontext.location.Language;
import com.project1.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.project1.app.shared.organizationboundedcontext.contacts.Title;
import com.project1.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.project1.app.shared.organizationboundedcontext.contacts.Gender;
import com.project1.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.project1.app.shared.organizationboundedcontext.location.Timezone;
import com.project1.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.project1.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.project1.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.project1.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import com.project1.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.project1.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.project1.app.shared.organizationboundedcontext.location.Address;
import com.project1.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.project1.app.shared.organizationboundedcontext.location.City;
import com.project1.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.project1.app.shared.organizationboundedcontext.location.Country;
import com.project1.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.project1.app.shared.organizationboundedcontext.location.State;
import com.project1.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.project1.app.shared.organizationboundedcontext.location.AddressType;
import com.project1.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;

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
            Language language = new Language();
            language.setLanguage("kPqQUJdpI4RMFR71nawk7qLkbfZHZ5aitqGeq6uHX9xnYAE33J");
            language.setAlpha3("8NF");
            language.setAlpha4("QJ83");
            language.setLanguageType("DDBxid2ZsRzMB9NOOHX1TT3XKH9BY4XK");
            language.setLanguageIcon("Q3oHn8E4AQCfKG3pmYwl7FddgstjIQIHbdweWBt7KnCiobOPWF");
            language.setLanguageDescription("WIPjLfHGwkHLFMSoNhnej1KItzwHqi4QjhEEODymAdZ06hjnst");
            language.setAlpha4parentid(1);
            language.setAlpha2("NE");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Title title = new Title();
            title.setTitles("l7F0XiRKt6ETkGMXFZytNHyICh2NbmjJhtHm9TLadH8AatH1Nf");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            Gender gender = new Gender();
            gender.setGender("cKiFDuI119Lg5hKt9F5verUjjl8p2iv8g3fWhNujEXzXRvXdZU");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setUtcdifference(7);
            timezone.setGmtLabel("EaFDLKqNclauy41nIK9HBFoErfeqnQlm6Xv0hYmtxu9dpACcNR");
            timezone.setTimeZoneLabel("a1i1UFFjYu7FntRRnjuGOZL1LoZC6oGXoUTcpVpr5S5OZlozLh");
            timezone.setCities("rwBdSxcSw4CeHEQS4F54jX18Png0ALJzDjOQ5300wNugxDPuif");
            timezone.setCountry("vlMgEjUQ5YbdBzT6ZgG7Nqr9ln8ghx0Kl2Tege96Bm7VNafmOn");
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setFirstName("Qxs5NTNwYPYGHpkyqTyRGVEP2bcGaU9BMPoCZHNSwKGSH9oU8J");
            corecontacts.setPhoneNumber("BglM5cbvseJY0gJrzSsg");
            corecontacts.setNativeTitle("IwyrARDJQgwJmooH1pel4DAkwgV1oszkk88m7IIqUG2x6nNvaH");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeFirstName("eDC9Tk5ulEiADr3Tjh2xu0ohDEmgAmIwG9Tx5mH1k0vqfPJgC0");
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeMiddleName("sJrjRMj4Wzk7dwQEkwpATjvFueyHDQOx2O2ILHKBxrBH4bU7hq");
            corecontacts.setAge(7);
            corecontacts.setEmailId("6xyDFen4lFy1yCVG8GJXXfjUNbTYh3BtOdSZKSkY611ZuQtVMc");
            corecontacts.setNativeLastName("ZAj1AGjtMxP7QrBmrUDMF8cACMIsOhLsB7OYoLIQlTXjz3MGug");
            corecontacts.setLastName("cCSiuXFEerXcMsGUdveW3NFqAEvZldNhslSqfaGDGj1Uk65Bew");
            corecontacts.setMiddleName("Ro4ogpEhSFILx9x0841dxL6Z48Mn8qacBk4dPwQCU2ED84BQqu");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457502200022l));
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setDateofbirth(new java.sql.Timestamp(1457502200103l));
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupName("IV77NcfWgd6DpcQ1mFz9Ei1uSrNyfCr7PRsqIFxjQ1sl3Hgj3y");
            communicationgroup.setCommGroupDescription("hjRlim5uJH8Qc01kEK3VXqZcT3IIygmpDOx3z9LxltJY0B7e70");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("37egLIGlHb8f0g3AL348cupB8Roym5CKs9HJ2UGnNMId4KEgEA");
            communicationtype.setCommTypeName("W5SKFDO81L447D4BRiOAplyAbAQXidOoVr8C9zISJExPbcydd0");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommData("G");
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setZipcode("KOsmdP");
            City city = new City();
            Country country = new Country();
            country.setCurrencyCode("I6W");
            country.setCurrencySymbol("1FgMhIBbgkVSzGyOrXIMy92c7HYNobwH");
            country.setCapital("718dAGNdBoXy6OVbzNJ6Hq8gmF2Yozpo");
            country.setCurrencyName("mSCyYlUynvG0fmLvwigx3ZRifH4JYFkwUKeDIZyeEtXBSyjzbr");
            country.setCountryName("TI9VWqSLPdsCxuaCxYBrQRar6l6D27nml6eXZArrezkSMaToVw");
            country.setCountryFlag("DiIlwtvCg8r9Kr4Js74gro9ByesKJaouk0qtgRYsidn7y7DwjE");
            country.setCapitalLongitude(3);
            country.setCapitalLatitude(5);
            country.setCountryCode1("2RV");
            country.setIsoNumeric(4);
            country.setCountryCode2("D4E");
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setStateCapitalLatitude(1);
            state.setStateDescription("4iajiFdg5sWKctAKuISHpxWven41NrIQl9rGRge0pPBPOrIvk1");
            state.setStateCodeChar3("cKU28jAjZoLbLkbNTPYJGQecqNa6w1Z5");
            state.setStateCapitalLatitude(11);
            state.setStateDescription("dvddmjKcd1TbZNWx5MpPHDXVTSpFCEYWATDonDlM8nMmWvNdUq");
            state.setStateCodeChar3("jDJq6wqcbD7IpVeA6ScKox4G6YmPEiCL");
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCode(1);
            state.setStateCapitalLongitude(4);
            state.setStateFlag("GTbb7hssjnSKpEVwZb9xIfHiEZhcq3rph1yVrYksBos7iTtBD4");
            state.setStateCodeChar2("NPdq9dsO4601vtO4O9tFMPkgf63KvA8u");
            state.setStateCapital("5KOzmXjM7ijTZ3bWpDOjKj221MSNzr5Nv2rmBflB3hYp8rJQim");
            state.setStateName("LkHQZ5wFiFzkIyLTDli64TbRfYgsqrWzqW7f1PQzvUgsEcyaqc");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityLatitude(11);
            city.setCityDescription("fnOFWPAWInF1ZHBBHxND1a68UXezDKcV8JLjn5SOILMNWgmibd");
            city.setCityLongitude(6);
            city.setCityCodeChar2("vq6KV66qdxL54hQv69biBwF8S9Cjr7sY");
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityCode(1);
            city.setCityName("tEKevbyK9Y3Fw0Dhy4OWVzwoPzt4vz5lJMDPpCAlbBjNS4tlI3");
            city.setCityFlag("aXUEnjYtqRPODWgZvtMqhh1NiDOkLFDWzAB1hTBtHsQ8hoM2C0");
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            AddressType addresstype = new AddressType();
            addresstype.setAddressTypeDesc("RwfJSnav3V6lDdBE5DfP3HWakW2HpLW86BnbIZTbkL2VULmkde");
            addresstype.setAddressTypeIcon("2hSDVrsCRpdM1vei1b9nz7ojGve3IgdrRR5coKHZNrI7PsU3UF");
            addresstype.setAddressType("uWyaJmehxPRDOLfzN2hKj0zsjDZUuI0hEEM63Uwn3rCJLs7pRx");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            address.setZipcode("kENCHP");
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey());
            address.setLatitude("gky62MYANRQ5taLm3EvMFw0fFAKNrgaAtS9u9czOuZ9FILFEfP");
            address.setAddress3("i1TG9NTB13e8b1Qdx0PkfA4Regxk5sZIaNo3yiU9TmMJKIydQj");
            address.setAddressLabel("46s4gvtIYiF");
            address.setLongitude("yU8NVD0rOVSevGR9ilSBFpPqYebrwymHCcryGLa1x8RxXuAixm");
            address.setAddress2("4lNMRQrxgrfoAgPGMWerPBUKXlcnejp5MAq0jt1cAfkfZbtrOb");
            address.setAddress1("maKNbivA5duy6feM6zKyaFAdyCVKrnmGj6LhEacZlNczG8vECk");
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
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setFirstName("gEzwwK7P5bNH3oihutYaJIwxqVcBzTfs9LkZjxCfsjt9dvbWU4");
            corecontacts.setPhoneNumber("rwWczWwI9nkpMw0zdQCu");
            corecontacts.setNativeTitle("3qpqovHJRNTTbMa4hhwiD4pBF9ro899hvD4ZiTwNJutsBWogQB");
            corecontacts.setNativeFirstName("xpSAMEzmYQCINpBPSsz9PkFw2N5QfWBJVAkTgstQlyR06ZtITd");
            corecontacts.setNativeMiddleName("ZTl4aVajft4nVCcyd1bHFEmYFAIMxjvzR7uyJEhBS8RY1VqDSI");
            corecontacts.setAge(122);
            corecontacts.setEmailId("YQ8VtGV2twhM2iLlxpqjfbqrPh757yw80cvmT1P3ZZ9NUJnBXf");
            corecontacts.setNativeLastName("a6NJPnn5A5Tfh17No6C2aEViuvm1ip7WMCVHo4SJpxVgHRU6AT");
            corecontacts.setVersionId(1);
            corecontacts.setLastName("yDQn3aRvKWI5yNKVTi37Hxyy7mmj4S80PwpBoiDQ8gFsbDfbBN");
            corecontacts.setMiddleName("KIFZacToAsQHuvNp5exsC9ABesTkCvEwT0WoOYSSD4lH5PpBAq");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457502200561l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1457502200599l));
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
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey"));
>>>>>>> branch 'master' of https://github.com/applifireAlgo/DefaultRepo.git
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
