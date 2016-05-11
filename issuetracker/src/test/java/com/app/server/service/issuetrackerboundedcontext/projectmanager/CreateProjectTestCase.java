package com.app.server.service.issuetrackerboundedcontext.projectmanager;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.issuetrackerboundedcontext.projectmanager.CreateProjectRepository;
import com.app.shared.issuetrackerboundedcontext.projectmanager.CreateProject;
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
import com.app.shared.issuetrackerboundedcontext.projectmanager.ProjectAccessRights;
import com.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectAccessRightsRepository;
import com.app.shared.issuetrackerboundedcontext.projectmanager.ProjectUserMapping;
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
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
public class CreateProjectTestCase extends EntityTestCriteria {

    @Autowired
    private CreateProjectRepository<CreateProject> createprojectRepository;

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

    private CreateProject createCreateProject() throws SpartanPersistenceException, SpartanConstraintViolationException {
        ProjectAccessRights projectaccessrights = new ProjectAccessRights();
        projectaccessrights.setProjectAccessName("3iy9AgDvsU5K1zvzn8umxabR3eEymnumfx3zaLhZYPGIOwqQu3");
        projectaccessrights.setProjectAccessDesc("wfPIj5uXkeZaz2U6oju2pfbe4OwudOaCc4NyEi89a0AUgs2JYw");
        ProjectAccessRights ProjectAccessRightsTest = projectaccessrightsRepository.save(projectaccessrights);
        map.put("ProjectAccessRightsPrimaryKey", projectaccessrights._getPrimarykey());
        CreateProject createproject = new CreateProject();
        createproject.setProjectURL("gch11rTYvPz5Oz48HSD5xQPHZTHpOKtE9nTUF1FI5gDUexmhQn");
        createproject.setVersion("Dv8gflyuGqS1HjhlqG0RtH2ZuNIXJ2Egx1btoXRNBtCAc00cTp");
        createproject.setBuild("Ze5a52SedwhON5AtKJbWuFFTTCuvRutfE6P71Orhj2SDyWO3Eh");
        createproject.setProjectName("9kFFWHgCVhaT35ShAJKiBhhy27Lj6T7TyVZXD9YFDJR3KCoie2");
        createproject.setProjectAccessCode((java.lang.String) ProjectAccessRightsTest._getPrimarykey()); /* ******Adding refrenced table data */
        createproject.setDateOfCreation(new java.sql.Timestamp(1458211494946l));
        createproject.setProjectDescription("5qZAnm7jWjY8Zskxmkb51qeAilmh19G3tS3jxbUPw8kqBZ9tl7");
        createproject.setProjectShortName("HYUxmCbunVHWhSbD2uxo77QU3ivxuHifY7vGe9lR4qDYeswWoL");
        java.util.List<ProjectUserMapping> listOfProjectUserMapping = new java.util.ArrayList<ProjectUserMapping>();
        ProjectUserMapping projectusermapping = new ProjectUserMapping();
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setLastName("1zqgzJ6K00E7uBDzwUb6i1dWGFfswkaVgHzaADGfl6wSCbQgaF");
        corecontacts.setPhoneNumber("5QmiIF071y6ihhYE4Hpj");
        corecontacts.setNativeLastName("YMMN4CEgqqHGr6qnEa4WtlJGOVLb4cH91fRDhZnJaeGRgUrdJ0");
        corecontacts.setNativeTitle("rAwNHdANNFBudZrdcsf3kXkhxsqr97iQo7HMX5fwHo0FAudEB0");
        Title title = new Title();
        title.setTitles("nphDuTbkcms32cWPKFbGLsDse5YRlr9ut5FYahrdTFBw6NoZyA");
        Title TitleTest = titleRepository.save(title);
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("kwNobE5Uzf1EItX3PKXhfGSADdXUj8r9qXKbC42r4U1B09eYiK");
        Gender GenderTest = genderRepository.save(gender);
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        Language language = new Language();
        language.setAlpha4("2tWC");
        language.setLanguageDescription("S8wl6MMfmiJAzFGAndh7ZVGDfseiEJ86zU2EkdClTtJWtWFTcv");
        language.setAlpha3("XS6");
        language.setLanguageType("q2Km0npInyK08ljxFxTRzTiPJ6IcyAJg");
        language.setLanguageIcon("nWJyJkbEvpD4WTxEymAP6VaOwf5yiKcuGsJMdKPihcKFfpZiAg");
        language.setLanguage("DR5P8I8JZcyRcmwvnkd7scT14lpsjw4LTKWeASDByQJYMjCKYz");
        language.setAlpha2("WD");
        language.setAlpha4parentid(5);
        Language LanguageTest = languageRepository.save(language);
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        Timezone timezone = new Timezone();
        timezone.setCities("Itdl2kSWYIxS2nbMW983pIyTaaIf9WI8KH7H9cSBKJtua4eQev");
        timezone.setGmtLabel("YEVgwmFVMBKfpy1p2rhwrbxyX9yFpGvLRtv2TBbDZbsk4S3oi8");
        timezone.setTimeZoneLabel("1rxEYNRSVDIt96GGO1LLMzIVVCUSBQeJJlnVzdUcNBdcrxGQLN");
        timezone.setCountry("GKe4Fk5ZUO3OfYthnn9MdNsjgUxJNmJQ2cbXlhhzrv2jVuUFTC");
        timezone.setUtcdifference(3);
        corecontacts.setLastName("Km2F9bkVMLzGsin9Ki41R6Pg2HC4h8nlYmFUk6RKq1rBPX4Qe9");
        corecontacts.setPhoneNumber("YZr9FlcNmynw1XVLIhvx");
        corecontacts.setNativeLastName("SjoAoJxLvcQt0SIaiNNK5264DKmDkRk6WG7Qt7xiHLfVJeHmAs");
        corecontacts.setNativeTitle("9GVJKf5eB6zlplDPca3odp26O4u0Yfkq78Jr6cX831GWYt0sr2");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("TQ4DGkd2RvUobkp6R0ylpbZ2PT8nEZGju9WGdYkCPz2MawgxXU");
        corecontacts.setFirstName("sdiqDaC7A3erPR1d514YqjS4nLvuGwLIv8BSsSiKbd117dKm45");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("jqK6zOCNCZWXetoMKfXa9trZtYBI7D9xCKlhdwtvD5dvQhzHtP");
        corecontacts.setMiddleName("yMYaFCYO6jsAjuvOETNCw0gaEkirxxUSPjpuxnD8gW5rgDyIOc");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458211495124l));
        corecontacts.setDateofbirth(new java.sql.Timestamp(1458211495124l));
        corecontacts.setNativeMiddleName("SKWvEBSrnZJNQtw0bXs6wtpScw8fo350Wu7SwYV4NH3nPvBrck");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(1);
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(timezoneRepository.save(timezone));
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("0wwAjmd5uDZUuguUb2v2T4cdmq7qOiex0m5k5kijOmLJphowuk");
        communicationtype.setCommTypeDescription("7oxGV8KiX3Jubxd7l8hchxby4Gw2TGYz32EH41C6aruWcXhnjS");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("DZWqlg6jy8xIWnaIwWl0ctMaG3M1s0F5n7HlxLisl0P65ucAGE");
        communicationgroup.setCommGroupName("xXAWeqxBXejCllefSYApZfY93uMSnlkE1ZvV8Lf4tp6r66oUIC");
        CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        communicationtype.setCommTypeName("5aVbpwC2Wvj7rZO9tFN8GJ1pejhdcqzsKFQzeVN4SMUrfKvRPr");
        communicationtype.setCommTypeDescription("CtyfZCife1JaAk2IGuofkKWN3qKgG5PD5r0bVaZuu5WAPjSDIT");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
        map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("7OlrJYBAPA7CwIA1Qmx6vTlXQbYVPVB07Kxy1MMVzuLCxG6cLz");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress3("H1nO3116QjUKYCRuEsQSJEkk0qT5GGT2omQ2iQh8Ts8xr0ON62");
        address.setAddress1("BeInEEwu7gJia9WerWVU4PXwJkQpxtHymJ68shPcxVhN7bh3KS");
        address.setAddress2("0TApOP4wHYnLmuzgd26ZzGKoUggyvjtBxkWTTdFKYM5lTA6ilj");
        State state = new State();
        state.setStateName("bVHHhknwk4ax2k4gEMV9nzrrhOVO2g2rtFw8P5ssp3iBIGjQeA");
        state.setStateCodeChar2("WgcHsatiJBXMLStVv6sSNubYK4JaPXOf");
        state.setStateCapitalLongitude(4);
        Country country = new Country();
        country.setCurrencyName("OLdqHtrG5vnFD2BHzwPn3YvjltEoG86StXMOaRe9k5sm3XH87i");
        country.setCountryName("APIvJLbS9znevNPAmcC0eQ6v8VhRhRutgtruL1r9QMDscDp2lN");
        country.setCapitalLongitude(8);
        country.setCapitalLatitude(6);
        country.setCountryCode1("rEF");
        country.setIsoNumeric(2);
        country.setCurrencyCode("DJt");
        country.setCurrencySymbol("NHf9wdgXHqUJWPrysedGgE04hE1MWgiH");
        country.setCountryCode2("A8u");
        country.setCountryFlag("R4mPx7vIMDJb5dSoPmkK3qWyBeea8hB9XKheOoqVtnQqCKdC4b");
        country.setCapital("vvaguUuD1Te4GViUMKGeS2jHmHWwoF6A");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        state.setStateName("0YZ4BJu3grX0A0Nd5TNCh96bvqQOuDBZKIPND1C8ZTR0SjYues");
        state.setStateCodeChar2("eCCEqGYBfcOnv8jtTvWyCLqX9M5XWFk5");
        state.setStateCapitalLongitude(9);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("BIhjfroutCZSZpJAk1SrMQsHd751VCzo");
        state.setStateCapital("RRwvHcZFqllxQtIXLHBZb58UFBQgPQFXEO3mjpgjm4mEFCCR4N");
        state.setStateCode(2);
        state.setStateFlag("g2wySor8XoVrAA0Iy4QbatmEztj2UyQzf6z7lOrCcr8Bzr8yiB");
        state.setStateDescription("LbXowZ9gAuTojSaJH7PgtBgH1BiXZmI5BhYfou2Dx3ib9wbBt3");
        state.setStateCapitalLatitude(3);
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        City city = new City();
        city.setCityCodeChar2("Y2riGx5OoYjMcYPIpQFJ4JvtlQMfoAKf");
        city.setCityCodeChar2("vQlDcBLGjgeczqDRGwvaRZTpP3ktiUmr");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("CbvYtbRCaTMQ1EvTIpvDRegWhQMpeBnWRoF7ZZdzPYD9fUKkE2");
        city.setCityCode(1);
        city.setCityFlag("Dfr7eZhMbHTpFixkkQfsPtk8fiCTRECEP2CSG0DES9DRLu2hJm");
        city.setCityLatitude(7);
        city.setCityLongitude(6);
        city.setCityName("NciUJrKuTeMD0C5WV561pfllFhaiLuu3XHhP1Yv5MLjibz3bhG");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = cityRepository.save(city);
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("NRzEqh91PSHsl7ieEkrkFpAWFmx3MwfXveR7gkWVJEY0kaWt1P");
        addresstype.setAddressTypeDesc("LGdhvHwsH7Tyg10uJFrGBbdiNRp7FLfw7zG0WgEw7K0GeYJU5p");
        addresstype.setAddressType("enDywXN509ocEYSJMt2i6OZrjUaEZwlU0IhqzMIZq56TkOLV6B");
        AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        address.setAddress3("hThRoRJfUQe1Q8zEfDDPkmRMmOBcdG87a1G2oVNZBIkT6UJyEp");
        address.setAddress1("SlNmNgNkJJiA23CnMKjVm16DHd0A5bCoUZtgfjVEi47ZBCso1Z");
        address.setAddress2("7RvluTlLN9nJutFE2HVWmNDtu0u0ZK6RY57h4XAu8x6NGsyoVg");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("9V9mzG2ipCFIcwiSnTs3IuJld2n1Lw2jqvvOfAEmbdD3WInmL5");
        address.setLongitude("ky575XujvKShT5VB25oJOKz7V3m0xfBPZffSqj2ynf0ocqERZ5");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("nFxLkt");
        address.setAddressLabel("wg2gZpVcnY1");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        CoreContacts CoreContactsTest = corecontactsRepository.save(corecontacts);
        map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        projectusermapping.setCreateProject(createproject);
        projectusermapping.setIsAdmin(true);
        projectusermapping.setContactId((java.lang.String) CoreContactsTest._getPrimarykey());
        listOfProjectUserMapping.add(projectusermapping);
        createproject.addAllProjectUserMapping(listOfProjectUserMapping);
        createproject.setEntityValidator(entityValidator);
        return createproject;
    }

    @Test
    public void test1Save() {
        try {
            CreateProject createproject = createCreateProject();
            createproject.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            createproject.isValid();
            createprojectRepository.save(createproject);
            map.put("CreateProjectPrimaryKey", createproject._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private ProjectAccessRightsRepository<ProjectAccessRights> projectaccessrightsRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            org.junit.Assert.assertNotNull(map.get("CreateProjectPrimaryKey"));
            CreateProject createproject = createprojectRepository.findById((java.lang.String) map.get("CreateProjectPrimaryKey"));
            createproject.setProjectURL("cDjCL3IB69eI7BrG4TLVWomxKh81sWGYs3Jbzpl8zL2LBG6ZFN");
            createproject.setVersion("ORDH8OLCHR4DlbVOSuxROZp3mrgWrQPKLdNnYNNfLzwduDYtf0");
            createproject.setBuild("n80zbDG4oIlmLZMELOSA1bEuGrTq2SX3LXLfa5fjwl2uvMfMcL");
            createproject.setProjectName("gefCRmFzXv0UqluAU37Fvei44ZY0z1mDKW4Aub3U4H5oMgEfwW");
            createproject.setVersionId(1);
            createproject.setDateOfCreation(new java.sql.Timestamp(1458211495579l));
            createproject.setProjectDescription("Pf8xrfX94yraYTnOVaGpDdOwMLjW0BpJbFJUXfmamrHBfqtrrm");
            createproject.setProjectShortName("M05iRTsC2Cia2emMxGg5JBS9xOD73gOBjJw4T1MPGh3Tu2zuan");
            createproject.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            createprojectRepository.update(createproject);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByprojectAccessCode() {
        try {
            java.util.List<CreateProject> listofprojectAccessCode = createprojectRepository.findByProjectAccessCode((java.lang.String) map.get("ProjectAccessRightsPrimaryKey"));
            if (listofprojectAccessCode.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CreateProjectPrimaryKey"));
            createprojectRepository.findById((java.lang.String) map.get("CreateProjectPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CreateProjectPrimaryKey"));
            createprojectRepository.delete((java.lang.String) map.get("CreateProjectPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCreateProject(EntityTestCriteria contraints, CreateProject createproject) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            createproject.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            createproject.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            createproject.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            createprojectRepository.save(createproject);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "projectName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "projectName", "MWA7tnUnt5sYb1UdwjIwbPd8tJJuV9IXJRRtNvi87WoJZIWkL2Nn82jSlSHHvREPrplcVuz8ZbqeLOh115PFO4W8gxnlYS6DQer83xomx7SC66RxWoNGIZ9fgSKhiLiBo"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "projectShortName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "projectShortName", "j4q8yCa0Gj918OTK2Z7MejAmxEcCeBO5B2TXahEmNeC75X7TH3p51qXHMLeifWQpJ"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "projectDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "projectDescription", "NpJ0lu8mVDl4LnvANBzxvwvNAWRwznWICwNm8IQ3Q1EY3Tl1gPv5YkGf4MnBKe4C4XQ4BRkKGvdtaSDqtUraPhXeZ5nBBDFia29ahivjISJM5imaPnCFPnHhGcBCNWb7CRMEOzHzQvJVLhwZngPoI9GXkezI74HM4CYtjDJOTyQ4p84M9GBKTdqLdOWHJFr2xXZrqZnlJpKdOJszRA7fIfF8GeHXeLiU4GSCPMxdhD6Cve1DDWU7VSaaF31N0v90vXX6jcBVmGIuSOOTclxBJiHOKSnQHigvUOXoy7gc2InlATZhnqJPZjJlfbAKsJj02FAmPLeQHhf01BbsHFvEViKmM4JdTr8gE2hEerSiuid4HRTV2NO9Xh3klAQDJvwMENmCDRLTAASwPnXdSbxxioOBnNzJ8AKojJMm7p9Gf6HqBJd1ysyvMslQpnHXIDbp8M2iQ4SW4UOsyJZof68HwJM47ikSaSMOleJWzWkLylLTJihCGbxginPaRbb4PzncykKtRhH2nUJ2e0ImPuuu8sQnFHUnZI0wWTQPwSXEvllWJbvkQJbd3JXz9z4MAJf8oRKcOxks9ldqk8Ssuov99WcRzDraXDdp6NBdNKmh27Taq7IQ8p6UZnnS680NAQjI3Uuugw9SQPKLmH6XEElVEPUd0nA4MSfIwRlOI9XpYIVNkMuo8VkyuitfqwS99yCs795E99A1e91w62LMRY81R4AfhiWnzg4Mei6cRqpxJw8xaVb0oH2SZYmiluUAdVhFWqH2JtsJWkJE3hinMYJPXuh0ftGThJ9CMGOBZ0kxNmMH2TquflItwsuHKXebOICIur8bdNNOIaGIvPVjxAZiszSrAMdqFhZmjwnOC1IYE3h30ShTPVOATf1tnqosgECdhqAqVYVg8WW0yMmhsWKDqo0B2Ee2dpoTkxRXK68FIi4pYpQUwljPBo2QK8Ag68G3eunr92lOVvAlWS5tFF5KQk7lfYJymFaPZLToZAcBNU58YRvKxOVj8C7tr7duUFTFz"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "projectURL", "jmDj2P9zAAUm4wqcwv8oKwbJWzEg5bTWndMdH8KaZUB5ze6OwMFUX6au4IA4yScY5"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "version", "mr33BkKA2dE93BQt6pg5jkkdBooVoDTnrtqsm1WxzdTep8VztFhpFAyW6H3rjdCP3"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "build", "28LjEaBZl0ONVBBsbLTQz1sCbQDYPTrO9v2Ajay0bKCdRwonarz0MXxDGDsvAbvik"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CreateProject createproject = createCreateProject();
                java.lang.reflect.Field field = createproject.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(createproject, null);
                        validateCreateProject(contraints, createproject);
                        failureCount++;
                        break;
                    case 2:
                        createproject.setProjectName(contraints.getNegativeValue().toString());
                        validateCreateProject(contraints, createproject);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(createproject, null);
                        validateCreateProject(contraints, createproject);
                        failureCount++;
                        break;
                    case 4:
                        createproject.setProjectShortName(contraints.getNegativeValue().toString());
                        validateCreateProject(contraints, createproject);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(createproject, null);
                        validateCreateProject(contraints, createproject);
                        failureCount++;
                        break;
                    case 6:
                        createproject.setProjectDescription(contraints.getNegativeValue().toString());
                        validateCreateProject(contraints, createproject);
                        failureCount++;
                        break;
                    case 7:
                        createproject.setProjectURL(contraints.getNegativeValue().toString());
                        validateCreateProject(contraints, createproject);
                        failureCount++;
                        break;
                    case 8:
                        createproject.setVersion(contraints.getNegativeValue().toString());
                        validateCreateProject(contraints, createproject);
                        failureCount++;
                        break;
                    case 9:
                        createproject.setBuild(contraints.getNegativeValue().toString());
                        validateCreateProject(contraints, createproject);
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
