package com.basehr.app.server.service.organizationboundedcontext.contacts;
import com.basehr.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.basehr.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.basehr.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import com.basehr.app.shared.organizationboundedcontext.contacts.CoreContacts;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.basehr.app.server.service.RandomValueGenerator;
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
import com.basehr.app.shared.organizationboundedcontext.location.Timezone;
import com.basehr.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.basehr.app.shared.organizationboundedcontext.location.Language;
import com.basehr.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.basehr.app.shared.organizationboundedcontext.contacts.Title;
import com.basehr.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.basehr.app.shared.organizationboundedcontext.contacts.Gender;
import com.basehr.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.basehr.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.basehr.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.basehr.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.basehr.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.basehr.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import com.basehr.app.shared.organizationboundedcontext.location.Address;
import com.basehr.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.basehr.app.shared.organizationboundedcontext.location.AddressType;
import com.basehr.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.basehr.app.shared.organizationboundedcontext.location.City;
import com.basehr.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.basehr.app.shared.organizationboundedcontext.location.State;
import com.basehr.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.basehr.app.shared.organizationboundedcontext.location.Country;
import com.basehr.app.server.repository.organizationboundedcontext.location.CountryRepository;

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
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("25hRPn1pzniVhwwhwodbw4ajoNj8dZJM9t4Rp1LDvQpduWUgM8");
        timezone.setTimeZoneLabel("hO0X0lF608jOT1AefosyctaGuTkYHaHnoG4IhcU0PblMzujTgU");
        timezone.setCountry("E2bSGu744StIK0NpaRsyTwJOutdF29VM8rixDirvvWqfpfkon5");
        timezone.setUtcdifference(3);
        timezone.setCities("oSSHwisdQoT3TZpX1pnRT0Y2N6MJ7jTW5cloVyEmJKyPdTpKKB");
        Language language = new Language();
        language.setLanguage("EeFi8KrdbJxsTcb0aRVsOBEl2abfeWL5Ef8iPjw0nXdpJArSnz");
        language.setLanguageType("mPJ8hzvBQaprgDRSw61bcNA6NmckZEaj");
        language.setLanguageIcon("eYX32zIRM9dEbKKulrtQWsHSRJn7VDRzchpggTfX07XnzCCtG2");
        language.setLanguageDescription("3egm81ig5ErWpbXbaBMDz3zMZKHQn8IBhrDiMmLpBAvb2EvRVu");
        language.setAlpha3("clc");
        language.setAlpha4parentid(2);
        language.setAlpha4("WBqw");
        language.setAlpha2("1k");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("iaaoLmWSIzMy0M4xqpw70BwgkCehYmmZusNcXW79yPP0djKdJY");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("INcE39x70870QMPaWNQGsgQkOo0tQJmyumXcgyrRENfb1rPak6");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setNativeMiddleName("J2luErgoEOUtpXgcXct1PLyrONzM9zKTP7uoL8nUBDrsPT1ksl");
        corecontacts.setNativeLastName("SlWFhefo3hiK0owT1VwcgqKguYc5L7SEGdRRWHnJX3ATwkHmgp");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1461751805017l));
        corecontacts.setNativeFirstName("cRCHDhJCZ5SEMlwZAVnZvWSDuQAQSLLIyJ2h7lRShplcXZnzfw");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setFirstName("6NEpPpUjDj9IUFTlsYTe2y8yJGMJtfuexkn6NbjjR3gkJ0xkuk");
        corecontacts.setAge(108);
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1461751805126l));
        corecontacts.setNativeTitle("6dXHSesuxJhpMbJ93ocqweqmo1RHix4uBYSrdP0kUy4Tpgvy72");
        corecontacts.setEmailId("Cj1Elj52AQeQHApwXQ9brXbfIzmwJx9wU76DEZwcYDF1YPqEpc");
        corecontacts.setPhoneNumber("e8u0ZkW8PjXdptOGurq4");
        corecontacts.setMiddleName("lSuvYsyZFG6rHc1jsUQIItB52Zk6V4WMH7U4azZNdQE7UJ5Zal");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setLastName("FP2qDcjOzKAbHVy2Lj84qS3LTP3AJSytMedH3ZHOpRT7HZ5PQt");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("MkrUP49BaNjxXXc1U0cirfhCF63fYJKrlv5infEL6srSfnsiVi");
        communicationtype.setCommTypeDescription("F2hmiSw3y6TWYmOLClQc0Wpo97GXcnlYHNPcVp7wFNdHL4ME96");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("pN7GLKs4m2hANn2BgGMF7M3fujgCuvjgWadalWrC57XndOfVUH");
        communicationgroup.setCommGroupName("2rWrWD91MyqxSqlfpsbYxd5444iRspVkYBTh7hnCErhoKSAdfd");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeName("9DBMkaxXQhgz4UuciUL8fW5lBNF41TzszhxOzSbElS34CSR9Cs");
        communicationtype.setCommTypeDescription("VzukeTXmi9AtvUYmcyDAvffmB3k3zbC9CFe2RyEMWRuKfTzUUW");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("hX7CWpMJ5q");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setLongitude("hr67WNKqyD1irjcnksMLmRpup4hWivSwzvh31G128tcYNVkqc0");
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("YCqxEl5DUBhnIqiGyLXCqUJLYDh8yIejnw4L5B6d3XS4mIzNlq");
        addresstype.setAddressType("tpM62BIGUG6ULBgDJe87dEVO6A5J3q04im45AxZZ6bG2bGiXEt");
        addresstype.setAddressTypeDesc("S5dsuOUdz3P4cERDdFTS33dGsKZ2nmtvB3H1ABen4dwoChI2rX");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityFlag("URv3v5q0TwIeo2K73VpLXUPk4IvuT4PCgzwGBcoL45pkNBIWUI");
        city.setCityCode(2);
        city.setCityLatitude(7);
        city.setCityLongitude(6);
        State state = new State();
        Country country = new Country();
        country.setCurrencySymbol("oskkfn1vwX4JDmHTOwScSsDnnrw7ksKV");
        country.setIsoNumeric(703);
        country.setCountryCode1("HDM");
        country.setCapital("SZu6fDDz5GsBPqLq4ZRvzqvgU9bBoJ3N");
        country.setCountryName("IuxJXTfEH6bddKlLjA97fj3t3pu1ifh2HlVj89MJ3hfBeL4MOQ");
        country.setCountryFlag("4pRMHYXZpT3BLewSoLuUrtZ6iGYKajamK7F0RMzMu5J4AM90m8");
        country.setCurrencyCode("5VA");
        country.setCapitalLongitude(8);
        country.setCountryCode2("NKW");
        country.setCapitalLatitude(7);
        country.setCurrencyName("RFv54Gumxrlavqun84l9TSDq62bhUYO1crLffLnwG6BHu89Ve4");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLatitude(6);
        state.setStateCodeChar2("FXSWTh7dAkDdsAEeYir3GM66HE7qrm4J");
        state.setStateCode(1);
        state.setStateCapitalLongitude(4);
        state.setStateName("yfhqASLx7JiOdCYA0GZj0KR8hYZ1pnWEybhd458zRD2ZU91LSa");
        state.setStateFlag("BQYhbcR9YiGGVqqSphB133mXTJ8PO8mroMs59OhQuychQAoZTs");
        state.setStateCodeChar3("EC4NJGBBmWWad57sh6SzqC8I0xyvHPgj");
        state.setStateCapital("MUfErQXsrwRamvshXGcHoquUiciWiDZBEGh4mcafsYD8riwVdm");
        state.setStateDescription("B2YXl4FJJepfmTxoFd1t8aOuos2TXl7YRqvnk5X5VFJCVspHDw");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityFlag("ZfTfXr7d6rnfwRoJrqb53hsJ4WBNqOeOhywF7uf1pJhrUFK3Ol");
        city.setCityCode(2);
        city.setCityLatitude(3);
        city.setCityLongitude(1);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("4B6Eqwsezrb6IHF0h7VNPzbxj6FmCCpzxyRQnwhtfLAfRMQWvc");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("DKeC5d5RheDlocFnHOoktHxJMQJuyeOJ");
        city.setCityName("0yvMNHNrvMHai2CQgmi3DGIURpJ8Xta3Bmf8z4x6l352rXTSVH");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setLongitude("EX12udEVSRV7be6yP06WzaD1fbcDvBSM3HASSo2Rq5ho2u8fSA");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("INmz3VyhJzghxZdbEiLym2frp02WiEU0CxkWygJz0xAlFwSfjg");
        address.setAddress1("DCkVwsW8vrgnMcMg7OGv2T1vJJ9FMXTxoEfECMw7ofz6aeh6mq");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("t7HbdjUsO0mvf20dXKksrHkmbNEZSOBDWgJyatWmfh6ut9IUqI");
        address.setLatitude("RnuAzh8J2U3pGOrygZNdTHdlHh0pMHnGMEp2bYGKZOqXx4r9uv");
        address.setZipcode("MJ55DE");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        address.setAddressLabel("HKKr4VVQKx4");
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
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

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
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setNativeMiddleName("MAFcQDS3ffRasn8G6GvKl8hhQ15pX1giSsSsp3jaMErfBU6mdo");
            corecontacts.setNativeLastName("aFAvJpI1l0t7rwpWKFgiH4zMe7SigIbzpncr0sOU0Gm7UuF3IU");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1461751805610l));
            corecontacts.setNativeFirstName("HUivdYwtpeofBEmlWQKT6JDoY5grjErIqz8K4Vxkk5w3ykYhom");
            corecontacts.setFirstName("JXCVYM3iwdHlfytvOHDps1dB2CSVcgM0IwoN6jam8kRaTzULuk");
            corecontacts.setAge(17);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1461751805697l));
            corecontacts.setNativeTitle("uBuVzs9OufmOvevrQjgjPPeaiXEOaOgeBpRTmELv5nFSZE8o31");
            corecontacts.setEmailId("jfg2a9c7MEfyvnsmQiexOSHIUi0xeg359pp8W9ZswuFJnAxxFX");
            corecontacts.setPhoneNumber("zijn4fczwcBHLZ7UUhLQ");
            corecontacts.setMiddleName("sWDOiJqsf47zbVEHFAFo77BgWxq40LRm49qZ6lgBwxbED13q2r");
            corecontacts.setLastName("PYPoJJaQGwF7EFLobNBU2hN1STfubx2dtQQIV0O0g1yJhbjBsr");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (java.lang.Exception e) {
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
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "SA8GLPUkn4McEDBBVjrXgsQEkUSOy1LFPEqI1Hl2HssgQ3DK6wo0mrPqKs6EPwvykKdb7stxpQiBDpzIHwIzCzkRUlXfLrMYxuTh2cp8WfInL260xHNYgK01LIx1eFQcePkkIqL6ij8O4htPCdehpv2VBUjBiugWQfpiPpJeRoYxX3pYzO13np2RpPoFU5pDVXqSTRew9VzE3G6LOPYiJP8FINTsCicufDtpfm04QjkqkIj17yUPUpVUOvrt0zUoA"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "Rlnjl337yIU1UxOIZI6LTrk6RNEKPTayUwZLfbqs4Hw3ludgyFRxwcaBH2OthxvoB2fWIRGNOdjX4byLZMnIZ2yl46EpW32ieY2hda8UmaQIfLkWCYQjuMvYF3sN2C6EhAI0bpWxTzT3oUWzsuvHdzZmqmeWxrQETIgRYMmAwNk4vHZixnxR8aR9L5SF3HyKmDIf8Oz50BdETRMwrn4glx4kzVWiMITrxDEACeFfOowe5fSZPs0i051926kOSJZfA"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "egwfE9Gt9ArerGrzgBUoB7CeAwbSB1Exy6UJLDMsRaSPCPep1HV6PzzTG1DMWjc9SMOToYeMtwV49qsQUMMYm8jvWy23ZgvIwqzUBG9QglN5AeH70sQAzusLUzs4ixRxUgvGXSjKM6zuKSleyJejIBfeWxazabF5tunh3flrJPs6rfzr6tdUuKD1YQsBkMl21WMuNy7FmNdkAEDXiVho47NrrxlOueNMGj2WQcEeVwtpENfHwqYVOKa0Ie4EgyLnb"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "9AhBGevzg0LEVHXBCYVXiYAjUUFArfgiv9OwhY1qvBAZWZhwkWhopOUoTe5gD0W7v"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "aveAlmMExyLACCE0guhc8Wvdq6ew6JnwQFQOnCi7q5lSg2jknq5CkGOCf1TZlZCmoLCsEIhbilRgTrdgCg5sqP88GFVJPToa9BtBJ8y2KtS4Tm43Y8yUVvJ7aq6pQhl3dBSBomcCCXH9we6t8WwEvsZxSmp7uzGPViEc7BgCBQcuf5axp4uVOC988Hd6AqwsATZVYAns6lqUYnRZx8LQuBj4BRCcsr6eCwcipHU3fqYiV1Z9d6xJrZ4TWYNWa0uLm"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "KIc0QyzLkh9uxmNgt7msXMKu7XsGZVv45XgRAd4C9n45JoNayxwYHVxkVHruNeGeeeKzrnSk6frT4RKiMQ4zFvpqu1gLGvztY0kg7026mSKy92CWtCRcLIKDUcaHt8329jfKr5I1QueiMloGdzbue3NAhNXyCBidbsPZcZZrHyvBHS6TL1xvxfsi1m7kjOtFPcy3oTCpRxNfRCm0ETb0yS8UCSAnl2Nr4dtvdrvCkfbEOPxvomSWGiCTFQOyNa6WU"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "qddSrTXwF3hzmJuvzoNxrkfDt4rJsHNcCcfh75ti2QamVLLy8Ad79UVwtXcjFoRVmhp7kNPYslbLi4HA9IEpPYsKCYTcYLDl8Kie07N9uLM1tel9TmWC9oKgxuiWymNWb4KcFL4EPrjRQa9Uqbki80hRxcIKpHYj84qSWXv3Ck5JgzrkkWqbgimEPOJyDkPr7fv3foLKFzYDYFuF18owvRj5MbboepSyXr0FyJzicfugsg8JLmKFi8D6YnYrRYBRF"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 169));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "7y8Eytqt1Z2Oo5dsaH0N9PI2cyA1DLdT4nfVsgsha7hGdQaOiNu6VmgJrvTH0GYWLsc9GhloZ9IYCTyx3TWHZmizY1Wj1uMlSBOdKbYIMXApOdp9EIGQ5863tTCOkpkml0thTNvKFsdxHUEIwhQ4i4js7XbtBINaRT7992e1NbX98bYqNRSEeIyONl56J91KZr7zaowou5vrKleZMIZi1qBUMmd5CZp0KiRIp4C27VqFxQKaVrUMFjlJFiqWXvDFB"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "NCOgHM5Dd1KE3qqlkRiF9"));
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
