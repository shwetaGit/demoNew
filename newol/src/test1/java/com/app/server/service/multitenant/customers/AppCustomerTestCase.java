package com.app.server.service.multitenant.customers;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.multitenant.customers.AppCustomerRepository;
import com.app.shared.multitenant.customers.AppCustomer;
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
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
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
import com.app.shared.multitenant.customers.AppCustomerCategory;
import com.app.server.repository.multitenant.customers.AppCustomerCategoryRepository;
import com.app.shared.multitenant.customers.AppCustomerType;
import com.app.server.repository.multitenant.customers.AppCustomerTypeRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AppCustomerTestCase extends EntityTestCriteria {

    @Autowired
    private AppCustomerRepository<AppCustomer> appcustomerRepository;

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

    private AppCustomer createAppCustomer(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        CoreContacts corecontacts = new CoreContacts();
        Language language = new Language();
        language.setAlpha3("bLW");
        language.setAlpha4("Tgy8");
        language.setLanguage("3lsNQu6TwLJf6F2qAfC2zyo0YDhdEHSug0HEXAAEk1M3ELkGm2");
        language.setLanguageDescription("drYEWiWCt7yfRA6QRvxAXSd0fFTTxd1vHN74j1h4sF31hrxwHW");
        language.setAlpha4parentid(3);
        language.setLanguageType("elNqamZav7nV2EjOcKZqDh0ti2pd0eCl");
        language.setLanguageIcon("3AqJxuzxYvspscCeeX6PEGIFZGmJS42FnqvTPZuAvMiCVChdeF");
        language.setAlpha2("gW");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
        }
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("2eck4Fumb7veBaDoe2k1d4rfJAui8eMh0NxOo643oRXWjkEWgr");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
        }
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        Title title = new Title();
        title.setTitles("1tbVd4iVY9hKj5M2ObhNJ74rTsHyWoFFhCfegtU0YF62esaaix");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
        }
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Timezone timezone = new Timezone();
        timezone.setUtcdifference(9);
        timezone.setCountry("9XREH58E7lntRbm2f6AsWZiefUlmdF5UbscpRfliKghDt4Yks7");
        timezone.setCities("yuCKPAO97YejJp8IlAbDn9wikFnhoFOAne6knSSMiWAPoDn6IA");
        timezone.setGmtLabel("hvSkl1h8FCrHzjhzrw7pjnVwDMRqyRtRS2N5lJM3z6Sfuj4jHI");
        timezone.setTimeZoneLabel("U1taMDseYmfv6k9NfeClazGCUxMeZXRD0wbT8sIkP4BohMEOJh");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(115);
        corecontacts.setNativeMiddleName("DkibqTBteTsi4LEZmrVx1SCwxhXmooAwztbTin320eHVOF6iOn");
        corecontacts.setPhoneNumber("mBEsQmbwEHWJyLYueCHr");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1458541462268l));
        corecontacts.setLastName("2cSdQDjBMm1tLdT0Gweiuj956yuT9FKbY2yANI35lJz5k4CrDo");
        corecontacts.setEmailId("puf5zfLl2RvJFcRiKEYZzZaZFUY8RyxTwCxv9K3xqUwCzrNngt");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeTitle("vnpOJGQObI997mHA4NsSxR6bvCB4zaLODrDCCpv84NBRqkNKl3");
        corecontacts.setNativeFirstName("khMWZewAloGcPoJbQyWq34KFyDvMjQwNIwWVdCH2zd8NDrTwwh");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458541462313l));
        corecontacts.setNativeLastName("qVz77H755S27rEdYM7rdSt8Y5XLo3tY1vRpZVzlEJKQhbjViaA");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setMiddleName("WPbDJO4tFQX4mkMQvtXstj3cEAR79yGIQFY1F7c1tja9ana1iv");
        corecontacts.setFirstName("6uuvfaA3OoT6nZwXzIbgDvxKRBJzRYeXjPJ9ERyMf2j01BG6Rb");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("EHHIRP5sahj1vHLQlkzd7isIIDDOqcWTB7A7bM6vgl9ApDIF5s");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("RvkZldvQFeZLzF53ZEsGuh1NJT5dRiZaddT1JQu39o7cYLIdsk");
        communicationgroup.setCommGroupName("43wm2DPA2mBjPAThOBQyKbbzOXpVK8voh0VoT3A6eCo9TRdhVf");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        }
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        communicationtype.setCommTypeName("nq5JkzyAMY5tYtN7BQNULuhcTB2pgt1URqATZ8vcppW8vcadk8");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("hqXmrgUWKIExriTw7lQfA3Ry4uaYf34GsJYuGdvu64uCpmQd7K");
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
        address.setLongitude("A5wL5qSd39hkbJtSce0ZUK6OzJf7m0AdTVm3XxPvBSP8KXt7vf");
        Country country = new Country();
        country.setCurrencySymbol("WapfVwGou06Uhv8Hw79iZFudnDjagmOf");
        country.setCurrencyName("qEuXeU1TnmMgp9hD5BqLQsMW8Er7iZ4C4BCsEHyIeQDDJpHBAp");
        country.setCapitalLongitude(3);
        country.setCountryCode1("P5N");
        country.setCapitalLatitude(3);
        country.setIsoNumeric(6);
        country.setCountryCode2("WQh");
        country.setCountryFlag("wkBeu4Zfmk9paBG31Vh4KgFoqKRrXbA1SdHYRAppj7UZlKfavq");
        country.setCountryName("7NaoXYiJvuPtRODwwgi9k0CHQOpv7fwAU5i6IbubJly3AwfSlo");
        country.setCapital("jMgf737LrQOgjPhjOfmxpX7JXldEngFU");
        country.setCurrencyCode("mrr");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
        }
        map.put("CountryPrimaryKey", country._getPrimarykey());
        State state = new State();
        state.setStateCapitalLatitude(6);
        state.setStateCodeChar3("Sa013YvuRjYV4gRef502qpw5NHL7K6JA");
        state.setStateDescription("yR7ybP1QLU1E9NtTPZ2auT2JXUPfcCFuSqIUzPWL9e9I82ahEs");
        state.setStateCode(2);
        state.setStateCodeChar2("IXdyu2DzdDchkz61KKdfjyIpmMkfhHBO");
        state.setStateName("Ugvf76eAvbOMsw5ukKTF0hUPMXuRIV1wGYuP33swAFNeZQ8owS");
        state.setStateCapital("tAQT2jLBEf22FEimC2sj8ng5MM0tkTSz3Dyl77PgtEy3nDGeit");
        state.setStateFlag("qGwT9Z7mAmew7HnEyP8PSPRNIgCIDeZQMGt4NK3jqGpDveFhEu");
        state.setStateCapitalLongitude(4);
        state.setStateCapitalLatitude(3);
        state.setStateCodeChar3("ubwQ7cEswLyWR7hzYegVIYST82g1VTJt");
        state.setStateDescription("SmrUfQpnseotvcYZyI22Yj0WyevYAiEbBExn6CwwyiwkJtlm1m");
        state.setStateCode(1);
        state.setStateCodeChar2("8dpNLwmCz7GRuyipg9c75J5xxOcVSIUY");
        state.setStateName("mQlQXnlOijitTOSjIblIZS53txsU2SIIMbSrvC6DAk9EVDGAmc");
        state.setStateCapital("XaE3BYjvMrSO66nbOOooay64ZxN2NZ0zoumbFstqqbli5mS63P");
        state.setStateFlag("MMs5SFx06T5zTngEfjUdh80qZTM7b0b9oKsFEQ8DS0pSPPDnJi");
        state.setStateCapitalLongitude(5);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
        }
        map.put("StatePrimaryKey", state._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("HOG0G72qAFYsEGagfct6GVyy55We1OACFn6fmiT0ycfMedbYDH");
        addresstype.setAddressType("42nrW4Qvxc8d2ONq2VkPlhbd5JDUgRxUNsvPGVgKC37N3jSvKW");
        addresstype.setAddressTypeIcon("sKI0WX3d1tJtJLqVWWCD2Ti8urFRhiYwCpewmm14wOsiGNckhT");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
        }
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        City city = new City();
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLatitude(1);
        city.setCityFlag("e7UCxoMYZwY0rj2fwv6FVOXAwzhQzRXRqsuotpJFPBWNEkQQhS");
        city.setCityDescription("BKgxWBsXvQiu23DiZazqKrmYXZxJWrdadDeKq4oxrVspRIeKc9");
        city.setCityCodeChar2("ek9zr5C8skTrpFh3PGioxCQ1oWPsiJW9");
        city.setCityName("CiZTMmLE8KPxgk3yb5KAxwfsbaQulKeFBO9AxZjDnvnkaA2R45");
        city.setCityLongitude(1);
        city.setCityCode(3);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
        }
        map.put("CityPrimaryKey", city._getPrimarykey());
        address.setLongitude("5IVfkJz8HfLdtZK1DbbSKGTskrnjjyv1YsR0Cwzp4sNsCpKsyH");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("zyQ47xlh2hoH3EZ94INUomIWqhJFj8b5axlPCNQjCmW2bZyyPr");
        address.setAddress3("EV2NvumJtoZakkAEwjFsNM5t2sK1zPM6v2iBp5jzNV0T3VCRsD");
        address.setAddressLabel("JNruVD906sm");
        address.setZipcode("DkTova");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("p6sDvisqfBtB1NQKPjvYCDWOygFb2BkMqh6szay2ki06w59wqF");
        address.setLatitude("TAVDbNwyWQWTvwzCkc0KCNXuNSnNv1HLVOodgCQb0apAX6EaPS");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        CoreContacts CoreContactsTest = new CoreContacts();
        if (isSave) {
            CoreContactsTest = corecontactsRepository.save(corecontacts);
        }
        map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        AppCustomerCategory appcustomercategory = new AppCustomerCategory();
        appcustomercategory.setCustomerCategory("ZQr6fnhNsN1r4n6c8ryjHaNm2kowH82nebNigERtSi2ixqBJ4e");
        AppCustomerCategory AppCustomerCategoryTest = new AppCustomerCategory();
        if (isSave) {
            AppCustomerCategoryTest = appcustomercategoryRepository.save(appcustomercategory);
        }
        map.put("AppCustomerCategoryPrimaryKey", appcustomercategory._getPrimarykey());
        AppCustomerType appcustomertype = new AppCustomerType();
        appcustomertype.setSequenceId(2147483647);
        appcustomertype.setCustomerType("OatQGcHU4Faf2NDwjPNyeySoBvLjGjhemUBdobGadhYg5FTlO9");
        appcustomertype.setDefaults(1);
        AppCustomerType AppCustomerTypeTest = new AppCustomerType();
        if (isSave) {
            AppCustomerTypeTest = appcustomertypeRepository.save(appcustomertype);
        }
        map.put("AppCustomerTypePrimaryKey", appcustomertype._getPrimarykey());
        AppCustomer appcustomer = new AppCustomer();
        appcustomer.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        appcustomer.setEvalTimePeriod(2147483647);
        appcustomer.setDeploymentModel(true);
        appcustomer.setAppCustomerCategory((java.lang.String) AppCustomerCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        appcustomer.setAppCustomerType((java.lang.String) AppCustomerTypeTest._getPrimarykey());
        appcustomer.setUserRequested(2147483647);
        appcustomer.setCustomerName("qWCyuZ7UPF73a5EaccvOE2KIABWy8pRo7DPLf5tDnTRyCFX0OS");
        appcustomer.setCustomerStatus(1);
        appcustomer.setEntityValidator(entityValidator);
        return appcustomer;
    }

    @Test
    public void test1Save() {
        try {
            AppCustomer appcustomer = createAppCustomer(true);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appcustomer.isValid();
            appcustomerRepository.save(appcustomer);
            map.put("AppCustomerPrimaryKey", appcustomer._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    @Autowired
    private AppCustomerCategoryRepository<AppCustomerCategory> appcustomercategoryRepository;

    @Autowired
    private AppCustomerTypeRepository<AppCustomerType> appcustomertypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            AppCustomer appcustomer = appcustomerRepository.findById((java.lang.String) map.get("AppCustomerPrimaryKey"));
            appcustomer.setEvalTimePeriod(2147483647);
            appcustomer.setVersionId(1);
            appcustomer.setUserRequested(2147483647);
            appcustomer.setCustomerName("9Z6qnzAVpmRWGz617BrymHi5lQC0lkLINt80EcIddrXLF03L3W");
            appcustomer.setCustomerStatus(1);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appcustomerRepository.update(appcustomer);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycontactId() {
        try {
            java.util.List<AppCustomer> listofcontactId = appcustomerRepository.findByContactId((java.lang.String) map.get("CoreContactsPrimaryKey"));
            if (listofcontactId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByappCustomerCategory() {
        try {
            java.util.List<AppCustomer> listofappCustomerCategory = appcustomerRepository.findByAppCustomerCategory((java.lang.String) map.get("AppCustomerCategoryPrimaryKey"));
            if (listofappCustomerCategory.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByappCustomerType() {
        try {
            java.util.List<AppCustomer> listofappCustomerType = appcustomerRepository.findByAppCustomerType((java.lang.String) map.get("AppCustomerTypePrimaryKey"));
            if (listofappCustomerType.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            appcustomerRepository.findById((java.lang.String) map.get("AppCustomerPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            appcustomerRepository.delete((java.lang.String) map.get("AppCustomerPrimaryKey")); /* Deleting refrenced data */
            appcustomertypeRepository.delete((java.lang.String) map.get("AppCustomerTypePrimaryKey")); /* Deleting refrenced data */
            appcustomercategoryRepository.delete((java.lang.String) map.get("AppCustomerCategoryPrimaryKey")); /* Deleting refrenced data */
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

    private void validateAppCustomer(EntityTestCriteria contraints, AppCustomer appcustomer) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            appcustomer.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            appcustomer.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            appcustomer.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            appcustomerRepository.save(appcustomer);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "customerName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "customerName", "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"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "deploymentModel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "deploymentModel", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "customerStatus", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "customerStatus", 2));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 7, "userRequested", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "evalTimePeriod", null));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AppCustomer appcustomer = createAppCustomer(false);
                java.lang.reflect.Field field = appcustomer.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(appcustomer, null);
                        validateAppCustomer(contraints, appcustomer);
                        failureCount++;
                        break;
                    case 2:
                        appcustomer.setCustomerName(contraints.getNegativeValue().toString());
                        validateAppCustomer(contraints, appcustomer);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(appcustomer, null);
                        validateAppCustomer(contraints, appcustomer);
                        failureCount++;
                        break;
                    case 4:
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(appcustomer, null);
                        validateAppCustomer(contraints, appcustomer);
                        failureCount++;
                        break;
                    case 6:
                        appcustomer.setCustomerStatus(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppCustomer(contraints, appcustomer);
                        failureCount++;
                        break;
                    case 7:
                        field.setAccessible(true);
                        field.set(appcustomer, null);
                        validateAppCustomer(contraints, appcustomer);
                        failureCount++;
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(appcustomer, null);
                        validateAppCustomer(contraints, appcustomer);
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
