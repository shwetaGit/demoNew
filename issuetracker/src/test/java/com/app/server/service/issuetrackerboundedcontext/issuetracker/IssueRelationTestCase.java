package com.app.server.service.issuetrackerboundedcontext.issuetracker;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueRelationRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueRelation;
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
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueWorkflow;
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueWorkflowRepository;
import com.app.shared.issuetrackerboundedcontext.projectmanager.ProjectFeature;
import com.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectFeatureRepository;
import com.app.shared.issuetrackerboundedcontext.projectmanager.ProjectModule;
import com.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectModuleRepository;
import com.app.shared.issuetrackerboundedcontext.projectmanager.CreateProject;
import com.app.server.repository.issuetrackerboundedcontext.projectmanager.CreateProjectRepository;
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
import com.app.shared.issuetrackerboundedcontext.projectmanager.ModuleUserMapping;
import com.app.shared.issuetrackerboundedcontext.projectmanager.FeatureUserMapping;
import com.app.shared.issuetrackerboundedcontext.issuetracker.AddWatchers;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueAssignment;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueHeaders;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssuePriority;
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssuePriorityRepository;
import com.app.shared.issuetrackerboundedcontext.projectmanager.IssueCategory;
import com.app.server.repository.issuetrackerboundedcontext.projectmanager.IssueCategoryRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueSeverity;
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueSeverityRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueStatus;
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueStatusRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueStage;
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueStageRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueActivity;
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueActivityRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.FeatureCategory;
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.FeatureCategoryRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueFlag;
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueFlagRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueRelationType;
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueRelationTypeRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class IssueRelationTestCase extends EntityTestCriteria {

    @Autowired
    private IssueRelationRepository<IssueRelation> issuerelationRepository;

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

    private IssueRelation createIssueRelation() throws SpartanPersistenceException, SpartanConstraintViolationException {
        IssueWorkflow issueworkflow = new IssueWorkflow();
        issueworkflow.setoS("qK8vjWhAZEk9frCua5cfKMqq1rKxivOgGXZlQhaaFMyZxVkHdB");
        ProjectFeature projectfeature = new ProjectFeature();
        projectfeature.setFeatureShortName("GbPcHeFiHqdOBGrGoykJYuYILpqF4O7F3OjiIsU0fW6G55Sw6H");
        ProjectModule projectmodule = new ProjectModule();
        projectmodule.setModuleDescription("mu3j8i5CUXW1DO4Ix5jcgTxAMgh6XNIjTfzGJOVxZG1jF0Ckzy");
        projectmodule.setVersion("h99hLPLTor6mFqSxbPLSJVToaBWH9c3zD5Li076xaVVtN2pTEO");
        projectmodule.setDateOfCreation(new java.sql.Timestamp(1458211520265l));
        projectmodule.setBuild("ugrSNyGLKYUiBO0EBl2KAlyluUsI9Ujb7dvQbhQSzbaUlYC3ZW");
        projectmodule.setModuleShortName("6SUxIJwonlNg9DW1XBaxxXMoCMSzmpYRp5UnokdLUJqqYwpWmU");
        projectmodule.setModuleName("je3DjtPeSk5RD68Xlf2WiPNu7L1heNVHaZtfySaW0IL0hwiMuK");
        CreateProject createproject = new CreateProject();
        createproject.setProjectURL("edUzEPxitXY2Plbw0uyPOjPgEAFVfDpvP5QBjhsCZsh9LZrqdl");
        createproject.setVersion("Dj2nOBVc3QdrKojcDbTUM7hIihZZBv7x3nwFdmA7PC6hNi3uGn");
        createproject.setBuild("OyuIfbbIHCZlrn0VYm9kNltSPvpbrtSnM8J3o5B18hIrNoafnJ");
        createproject.setProjectName("C2Ooe7hPSFQR6xFlDRwo4qIQ7BKjNJSQmPyLWjwBgXksWpce3A");
        ProjectAccessRights projectaccessrights = new ProjectAccessRights();
        projectaccessrights.setProjectAccessName("tT6J2YjhThZ1N8Scnzq1jTLF7IZp0Qv4nvyznj2Sg3caAUYIg2");
        projectaccessrights.setProjectAccessDesc("mNYsi1fOHI9K3vknuuhVUdketBGL3ZtQo20RVlAsj1whbl5m7B");
        ProjectAccessRights ProjectAccessRightsTest = projectaccessrightsRepository.save(projectaccessrights);
        map.put("ProjectAccessRightsPrimaryKey", projectaccessrights._getPrimarykey());
        createproject.setProjectURL("6FkDA46685EMGfiqvh7erIRK5HXjbBopYFDWvpEAJ1I5WLj49K");
        createproject.setVersion("CsBRr9FWYJBE8YfIodFOk6YiB4Kj742K9XzO6jrnXyP6B6AAhQ");
        createproject.setBuild("rtCekJ409tVR8jYHGnyITFsAb4uTDySPkq5zDC0s6AEsFyyQY0");
        createproject.setProjectName("bkAzha209vrTY0tnIPUwwwull5yYrl25vqQ3FAkO4LPkLOB5Hr");
        createproject.setProjectAccessCode((java.lang.String) ProjectAccessRightsTest._getPrimarykey()); /* ******Adding refrenced table data */
        createproject.setDateOfCreation(new java.sql.Timestamp(1458211520334l));
        createproject.setProjectDescription("XtWWApG2OQavfvWCJLELz5P5Jso3fu1Imdj8qN5Kvi6bzKUcRJ");
        createproject.setProjectShortName("LKiVmog8bcu9cg0s6FpcBlrf1ecq6IsbwmIOiZjhGauapDBC4Z");
        java.util.List<ProjectUserMapping> listOfProjectUserMapping = new java.util.ArrayList<ProjectUserMapping>();
        ProjectUserMapping projectusermapping = new ProjectUserMapping();
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setLastName("HjQMx6eLTtFLdgc3TwL9PmGi69g1EVhny47lyhPyangDTgYaqk");
        corecontacts.setPhoneNumber("HSMWEOsMw6XrEVljyQGW");
        corecontacts.setNativeLastName("13M3IhYnIMdj7vn1LFUGDaNewVyxZNKRhLfh5jQD7uxBUJpweB");
        corecontacts.setNativeTitle("KGfclULyYum8i6G35ol0123OpKH4DCn1OY8cxLpPANXhwvCNkK");
        Title title = new Title();
        title.setTitles("VNVyGt2m7Elm0PXyyiTvORr0dNu8qeYCr6wQ9eZCMSJsLWkXTi");
        Title TitleTest = titleRepository.save(title);
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("pqaWNSDspZyJ2qBRfpaNt9ZyjYjGYDfIAGdjTaeExBhbNijL5q");
        Gender GenderTest = genderRepository.save(gender);
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        Language language = new Language();
        language.setAlpha4("ZPEM");
        language.setLanguageDescription("1RmAjuq9pZBRttwVlXhR28lNXPchk5xcqAWe2jIeuX2yT9uxqY");
        language.setAlpha3("srW");
        language.setLanguageType("93ZT6NSBLpc8u4avAS8unzzG4oi98QMs");
        language.setLanguageIcon("9jTmoSSyPveS1gvXtnkg5A4WoI7HMb33uXKVu9DcRitgqO9QBw");
        language.setLanguage("C1WDuBs18TDFAVDSkPvid496PH6O2EIKqTqS8jfABLTBUkwdcA");
        language.setAlpha2("qV");
        language.setAlpha4parentid(11);
        Language LanguageTest = languageRepository.save(language);
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        Timezone timezone = new Timezone();
        timezone.setCities("IES6icCGBfHzNW6pS7lmaE1dWJgzmF6Ofk8ZEpznjOieq36ZUn");
        timezone.setGmtLabel("rsOBVTS4fhZTwNxGaqqNClkykQTPTwFDNkQvETed5R0A99y0VI");
        timezone.setTimeZoneLabel("7J46yexxjFToDsEpJsOr44merVGskzTmiOC9AWtPLGcps8s6o4");
        timezone.setCountry("iHJAM5cDF85Bh3TcBbgK2VDyht9lSGFvHNRKbruwYnqVq7Urhk");
        timezone.setUtcdifference(7);
        corecontacts.setLastName("KqM0BTnDk6VjutmGofGXNyDhPCm0mHk3NLIk6WztIEYtcwklY1");
        corecontacts.setPhoneNumber("g0txSZkBebto2w9zb7BA");
        corecontacts.setNativeLastName("u0EnkoKitfYYtLnPlEXwxW9FcUDlPBCR0iiL5vt8L6bry8byjX");
        corecontacts.setNativeTitle("kLzijJOZBFmuyBRq6APy2zcjnWQ2X0sHjRjtCwa7vk1pu5veaw");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("SQLVh6Gz5FC3pAdoUUcqa2ogPlQWCSVTnI3X8uK1mjzAuBcd3r");
        corecontacts.setFirstName("JuthmDtjz2tUEBdBQkFmOTbxKhxRl0DAeAKENI3rfJAHj5CYWR");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("lneqcyG0pUrGCfySa4xVqZ2lP11pygzPr5iB1eo1kCG0nRZyfy");
        corecontacts.setMiddleName("2oSUit2HTHBrZkhjb5EhPDsr4e0qaabfJDyz7LK0ZHBDd1eXk5");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458211520507l));
        corecontacts.setDateofbirth(new java.sql.Timestamp(1458211520507l));
        corecontacts.setNativeMiddleName("8e1QoBQpZgey0uR9JaJJI0UtgIHypSCQluJuFiQ0wWQNKqiMJk");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(16);
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(timezoneRepository.save(timezone));
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("ogYpfur6vqKo9EiuGVJb2xsAC1OZCl5JLghoW4zmuduDwnk4st");
        communicationtype.setCommTypeDescription("cx8zpFjTnWCnf0oTj73p8KCmcPtM4fR2SYFrXy6Ijy5dYh9kVs");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("pAswoMmAX8hFMehELet5wvyf3ollZQ4VIjFa79pZDLMaA2ZcEd");
        communicationgroup.setCommGroupName("WiOdcc7qqc6zf7Vnd6K0zmYg9fsRBJNnX5qlmQUp1ez0Ce8tHd");
        CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        communicationtype.setCommTypeName("U2NqLY8ZH4PRp8ZvqZYh9ACkBR2qYHb4zZVkCF0iWQ0C6qw9h6");
        communicationtype.setCommTypeDescription("3o6TsSEqOePkSr14OB2lKofdSDV1JRwhgAKtFIpdVLvvY5ZJyM");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
        map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("5mHHZhQlZsAgQkwVKKzoUXvs0T7RG5va4ahlsqobIs3puAmF5E");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress3("UShVFre8b6jJl7I9wKI2IhzGZlq7J2dMucuXpiDreAGvEyiCIY");
        address.setAddress1("vQKQYdTx07ETt5sCTjpcnk0Axac5od4h3Nww8HqzAVt3ef3m56");
        address.setAddress2("xsULYEatM7cr7hpzejqjr1B1mkYDcA8LrkAYqeKT77WruPZc0L");
        State state = new State();
        state.setStateName("dpzkKbe1biLSHXvIGwL4iQDnj38zCXw1cYyeM02gU9hnp3oLXm");
        state.setStateCodeChar2("FRTyOFyyWgEYRbBhRGX4iFX9DpCZ7UGa");
        state.setStateCapitalLongitude(1);
        Country country = new Country();
        country.setCurrencyName("lUkq0BCYenEpJ5QvVHNH9Bxi5iw8lreHoLfIkXpsMp46rblrDC");
        country.setCountryName("firF9SkpQAYOhf0gKWmiD5g1LN2hc6pCWeaaCrIBSH5phB0l7E");
        country.setCapitalLongitude(4);
        country.setCapitalLatitude(1);
        country.setCountryCode1("VAg");
        country.setIsoNumeric(1);
        country.setCurrencyCode("kxs");
        country.setCurrencySymbol("bgbu4FEd5hw4wkwuKrGyacQqM2RPhjLO");
        country.setCountryCode2("KuB");
        country.setCountryFlag("GArtd8ypDBS7yKUfH37n3IRQCf2shLqEgQzVlBrtm2P7xROha4");
        country.setCapital("V7KGWI4iNLVOgpew3A1abKb1psxynYbi");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        state.setStateName("Ds1DgFQ6VJ5CdOXnqLdPOJ7Vw3aAHIPWRvLNZbLOmMbOEjkQDA");
        state.setStateCodeChar2("rtSKWDtelh8qsEM9MM5vtRsGwRQ29fz3");
        state.setStateCapitalLongitude(11);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("2bGyCpHP4CzNjT8TfN5eqCRJpdrUidzy");
        state.setStateCapital("c6BAjxpqgYZhusXe46jURhn5zbFeKAGl99hSNf2sKpo30uGgJ2");
        state.setStateCode(2);
        state.setStateFlag("RC1qll5hDEHDHI07sLQvDyEeVVzJXN9pRkndGMFe1ENcXHF2qU");
        state.setStateDescription("XMlsHPv3HZptUGpu7JiuMEjz0hnWoCuD9sYApt3IitRHtqsBJo");
        state.setStateCapitalLatitude(6);
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        City city = new City();
        city.setCityCodeChar2("6b1IwlToKs96krsGg1ntBnhncRvCcEmm");
        city.setCityCodeChar2("buf1ARMB8b4SNodckHHJSH7NOqXry4sD");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("2INjjNoSOKxw2BpsPrclODtyNTxLxG97jTPfq7khwLm5XREKEZ");
        city.setCityCode(2);
        city.setCityFlag("dKubSqUFbtstTDiASGqWG4vaZagzvYanFcnZ47r2H6I89caMi6");
        city.setCityLatitude(6);
        city.setCityLongitude(3);
        city.setCityName("5KIE3S2l2l02XzmPDKkoIcR1My0JrCSYbbz7UmBFXTJkBh3zjm");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = cityRepository.save(city);
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("zLRPR0jlJWg4Cbxdb4Nc0Pc1ZV5ArzsN8Mn8rYfumgfCQMgtfu");
        addresstype.setAddressTypeDesc("RSVIcETLpdYFelgN9yNhdSGtKQWiuOLcU4i5108QHQEqVMIOHe");
        addresstype.setAddressType("lLfFnzijkfetk14cm46hlOZFdR42nfeIZViSEOUuyqGo8ZsTIS");
        AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        address.setAddress3("eswrv7NvjQcyMhhR99oH84XZURiXmcaUeiIf3QsQK1TVEmhyoe");
        address.setAddress1("Zqy00NYG6t1kC9ZbzyXawdqwWvXN5QCYe10Le9133BOTYaSAa0");
        address.setAddress2("9cZOl4hehQpw3Z2XBdroQMyPlWMywjrnuklnc01pGeksLdwxnd");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("JntVShKZoboi4GP9aJFwvgTi0DL6oiW46LzkuYiMSpag2Y5yms");
        address.setLongitude("8wI200hO68X7EmC80q5JQ3i0vQ2c9VWFpA6Ohmjz1GqINyteBe");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("r3QK3r");
        address.setAddressLabel("4LSjDR0HjLJ");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        CoreContacts CoreContactsTest = corecontactsRepository.save(corecontacts);
        map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        projectusermapping.setCreateProject(createproject);
        projectusermapping.setIsAdmin(true);
        projectusermapping.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfProjectUserMapping.add(projectusermapping);
        createproject.addAllProjectUserMapping(listOfProjectUserMapping);
        CreateProject CreateProjectTest = createprojectRepository.save(createproject);
        map.put("CreateProjectPrimaryKey", createproject._getPrimarykey());
        projectmodule.setModuleDescription("hoWp38ffvidyIfwF9j1ldMhXvI6EydgVFOe0mhoqMEbK5kn9GJ");
        projectmodule.setVersion("yV66S4t9bwRGYjoBsOal9YtlCrGSnThu6mrEEFCQEMi2SNpEDF");
        projectmodule.setDateOfCreation(new java.sql.Timestamp(1458211520275l));
        projectmodule.setBuild("QSBgFqaXRqGVqIt4YgLu15zTffn8R49luXn2aUXkLCiWvTbMHA");
        projectmodule.setModuleShortName("Ur1gcr2g2n7YgZYXjgd6PWiXywem2RijMgPCbYz38xD5yaFaqi");
        projectmodule.setModuleName("H112K0igbFw5kV6pLB1SIriagQTA1bSBAe2xqRxBktTa7pHVo2");
        projectmodule.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        java.util.List<ModuleUserMapping> listOfModuleUserMapping = new java.util.ArrayList<ModuleUserMapping>();
        ModuleUserMapping moduleusermapping = new ModuleUserMapping();
        moduleusermapping.setProjectModule(projectmodule);
        moduleusermapping.setIsAdmin(true);
        moduleusermapping.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        moduleusermapping.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfModuleUserMapping.add(moduleusermapping);
        projectmodule.addAllModuleUserMapping(listOfModuleUserMapping);
        ProjectModule ProjectModuleTest = projectmoduleRepository.save(projectmodule);
        map.put("ProjectModulePrimaryKey", projectmodule._getPrimarykey());
        projectfeature.setFeatureShortName("t1PpJyCRh7ol0XLzhXcyft0LTMA7buA3EmNQCF0Nw0kzCJSQOZ");
        projectfeature.setModuleId((java.lang.String) ProjectModuleTest._getPrimarykey()); /* ******Adding refrenced table data */
        projectfeature.setBuild(4);
        projectfeature.setDateOfCreation(new java.sql.Timestamp(1458211521059l));
        projectfeature.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        projectfeature.setFeatureDescription("7wCnlm1dIfvHS604ZupICeopZoapGWoC3oABbHPSjXeo3UCao1");
        projectfeature.setVersion(6);
        projectfeature.setFeatureName("3u61HI44Fne4Dtk2HRfJ2T20t0KZuqEu7iBTtHzMAZzzXsu2WT");
        java.util.List<FeatureUserMapping> listOfFeatureUserMapping = new java.util.ArrayList<FeatureUserMapping>();
        FeatureUserMapping featureusermapping = new FeatureUserMapping();
        featureusermapping.setModuleId((java.lang.String) ProjectModuleTest._getPrimarykey()); /* ******Adding refrenced table data */
        featureusermapping.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        featureusermapping.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        featureusermapping.setProjectFeature(projectfeature);
        featureusermapping.setIsAdmin(true);
        listOfFeatureUserMapping.add(featureusermapping);
        projectfeature.addAllFeatureUserMapping(listOfFeatureUserMapping);
        ProjectFeature ProjectFeatureTest = projectfeatureRepository.save(projectfeature);
        map.put("ProjectFeaturePrimaryKey", projectfeature._getPrimarykey());
        issueworkflow.setoS("W1d5qaICeA1Qb7GPoNxogsU1clTUPDMXPs2Xf56PEbNa5WDqsW");
        issueworkflow.setFeatureId((java.lang.String) ProjectFeatureTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setStepsToReproduce("Ak6HJkIHRhc7NmKuf8VGDjmHArgELpWBNhm32BTRlWrIX7l0aS");
        issueworkflow.setBrowser("FA8sgEN0VjmWg0lqJavzjB819os8ZU3GRNYOFQMdiGF9khDpjr");
        issueworkflow.setIssueTitle("t6gr468Q0MJZhTaUGVm3sD8eCbDKiURhJCfjYP8ef3A9Wd8Ijf");
        issueworkflow.setModuleId((java.lang.String) ProjectModuleTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setCreatorContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setDateCreated(new java.sql.Timestamp(1458211521543l));
        issueworkflow.setIssueDescription("4RoJ1In9Q2kx9WUq5rn07BmyNkoWeJWmc6h9X33KAhuxNXzcJP");
        java.util.List<AddWatchers> listOfAddWatchers = new java.util.ArrayList<AddWatchers>();
        AddWatchers addwatchers = new AddWatchers();
        addwatchers.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        addwatchers.setIssueWorkflow(issueworkflow);
        listOfAddWatchers.add(addwatchers);
        issueworkflow.addAllAddWatchers(listOfAddWatchers);
        IssueAssignment issueassignment = new IssueAssignment();
        issueassignment.setIssueWorkflow(issueworkflow);
        issueassignment.setEndTime(new java.sql.Timestamp(1458211521878l));
        issueassignment.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueassignment.setIssueDate(new java.sql.Timestamp(1458211521920l));
        issueassignment.setComments("L61wu64cyYZepFXGaZKtDiNLq5dhaInJ8CW4iPi3A9DOgWk9cP");
        issueassignment.setStartTime(new java.sql.Timestamp(1458211521920l));
        issueworkflow.setIssueAssignment(issueassignment);
        IssueHeaders issueheaders = new IssueHeaders();
        IssuePriority issuepriority = new IssuePriority();
        issuepriority.setIssuePriorityName("ED2f5XmhXAovViPB0YyirlcskEMV2Arj16CsFbhFPrHqgc2F7u");
        issuepriority.setIssuePriorityDesc("ksS91X6pShRjl8b5fXOmNZz9eg1BgMdLqfN9eGzIttOc4xtVAk");
        IssuePriority IssuePriorityTest = issuepriorityRepository.save(issuepriority);
        map.put("IssuePriorityPrimaryKey", issuepriority._getPrimarykey());
        IssueCategory issuecategory = new IssueCategory();
        issuecategory.setIssueCategoryName("jvHTbl4LtOxka4fuhbNIjGvqEY0i3AYJ1f5E3gVqDQjww26q8Q");
        issuecategory.setIssueCategoryDesc("OvOJC9WzHR21UdMpnhjfgGPDntcs0K7D81c0DagADwwkoR8xIo");
        IssueCategory IssueCategoryTest = issuecategoryRepository.save(issuecategory);
        map.put("IssueCategoryPrimaryKey", issuecategory._getPrimarykey());
        IssueSeverity issueseverity = new IssueSeverity();
        issueseverity.setIssueSeverityName("pNbdnikKgAkHGMXjhwOJSAfFXdEEOuj8nCmQGZyZF7698KepSi");
        issueseverity.setIssueSeverityDesc("ORXj71CIrYBwImHp5g7SzOZKWSijgDCxq3NfVydUuI6plp3JKQ");
        IssueSeverity IssueSeverityTest = issueseverityRepository.save(issueseverity);
        map.put("IssueSeverityPrimaryKey", issueseverity._getPrimarykey());
        IssueStatus issuestatus = new IssueStatus();
        issuestatus.setIssueStatusName("ZOuPX4WP3lG8z3ioq7GKzBHXJ1X1Q9XSGJ9QTgXhYlBE8xbX7b");
        issuestatus.setIssueStatusDesc("56pBSTDJKIcYdqBMUKRTsDabKniq1KbT2uXY8zxhFUksDdtI68");
        IssueStage issuestage = new IssueStage();
        issuestage.setIssueStageId("fpHGoNVq4e8YlFY3SLp7A6bOo5jKNnIpbPvtZtoNco8hfWP03D");
        issuestage.setIssueStageDesc("F3oXhlDjh29MZSw2VJI5qJj1YwT8wBqCHgTY8EbjsPZlS7HUnC");
        issuestage.setIssueStageName("b2T4vJ5nzaQtEcO5niJNPtI2NzXXAxSDiuCAdoqdUGWTil8o4m");
        IssueStage IssueStageTest = issuestageRepository.save(issuestage);
        map.put("IssueStagePrimaryKey", issuestage._getPrimarykey());
        issuestatus.setIssueStatusName("vj40egAY7njIob78dIuIUk2aoOPIDr67o5XGmRIVMFWNXVKhLg");
        issuestatus.setIssueStatusDesc("M0SF1Y3v7Ax94plIPBYYnovaQGk9ILDGfakVfiH492BxqUz9pO");
        issuestatus.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuestatus.setIssueStatusId(valueGenerator.randomValueGenerate("String", 64, 0));
        IssueStatus IssueStatusTest = issuestatusRepository.save(issuestatus);
        map.put("IssueStatusPrimaryKey", issuestatus._getPrimarykey());
        IssueActivity issueactivity = new IssueActivity();
        issueactivity.setIssueStatusCode((java.lang.String) IssueStatusTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueactivity.setIssueActivityDesc("8tuF1xSXJPyr7STwnNYHjS5tcJUBuTqtVNfOwkhGXIgMu7MRhF");
        issueactivity.setIssueActivityName("HwAYOzbopJ0fhZSnWkYVmN1GhLLhTm3umbZA4QKMFVgSYTlGfj");
        issueactivity.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueactivity.setIssueActivityId(valueGenerator.randomValueGenerate("String", 64, 0));
        IssueActivity IssueActivityTest = issueactivityRepository.save(issueactivity);
        map.put("IssueActivityPrimaryKey", issueactivity._getPrimarykey());
        FeatureCategory featurecategory = new FeatureCategory();
        featurecategory.setFeatureCategoryName("mr6ncRl9dzoO64hK5IlRkoxivmkjrkJEdOUe7bdKuL1IjdK274");
        featurecategory.setFeatureCategoryDesc("Z91jo8SVHQI2p7hrmqe8mVEJmk2mRIX94wuxtWZ06JFjapsK4L");
        FeatureCategory FeatureCategoryTest = featurecategoryRepository.save(featurecategory);
        map.put("FeatureCategoryPrimaryKey", featurecategory._getPrimarykey());
        IssueFlag issueflag = new IssueFlag();
        issueflag.setIssueFlagDesc("0SyKf8IXGX6WOBKCiW3zPY88ghs8qhvG0NRIY6BNpOvIuG22s0");
        issueflag.setIssueFlagName("432CSVVeL5rTRd3JjN184kMD9HtZjd5bRmhS0XTwIuFyCh2OVL");
        IssueFlag IssueFlagTest = issueflagRepository.save(issueflag);
        map.put("IssueFlagPrimaryKey", issueflag._getPrimarykey());
        issueheaders.setIssuePriorityCode((java.lang.String) IssuePriorityTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueCategoryCode((java.lang.String) IssueCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueSeverityCode((java.lang.String) IssueSeverityTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueStatusCode((java.lang.String) IssueStatusTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueActivityCode((java.lang.String) IssueActivityTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setComments("QdWwTcWIPSku7eTs1GjAVkz7L0eVgVX5xQRaqnMPIQmOCRRpf6");
        issueheaders.setFeatureCategoryCode((java.lang.String) FeatureCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueWorkflow(issueworkflow);
        issueheaders.setIssueFlagCode((java.lang.String) IssueFlagTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setEffortEstimate(new java.sql.Timestamp(1458211522337l));
        issueheaders.setLastUpdated(new java.sql.Timestamp(1458211522337l));
        issueworkflow.setIssueHeaders(issueheaders);
        IssueWorkflow IssueWorkflowTest = issueworkflowRepository.save(issueworkflow);
        map.put("IssueWorkflowPrimaryKey", issueworkflow._getPrimarykey());
        IssueRelationType issuerelationtype = new IssueRelationType();
        issuerelationtype.setRelationDesc("aZJiuY8SX3fkinGap9oBbuw3K9ALKMabzBDaWmwSmauBlOZCyq");
        issuerelationtype.setRelationName("fzI8xlOnVBvZs1MLvW7HBPgMYO7XwI6e8AqSPIlV5WvYhxdLmG");
        IssueRelationType IssueRelationTypeTest = issuerelationtypeRepository.save(issuerelationtype);
        map.put("IssueRelationTypePrimaryKey", issuerelationtype._getPrimarykey());
        IssueRelation issuerelation = new IssueRelation();
        issuerelation.setIssueId((java.lang.String) IssueWorkflowTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuerelation.setRelationCode((java.lang.String) IssueRelationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuerelation.setIssueRelationId((java.lang.String) IssueWorkflowTest._getPrimarykey());
        issuerelation.setEntityValidator(entityValidator);
        return issuerelation;
    }

    @Test
    public void test1Save() {
        try {
            IssueRelation issuerelation = createIssueRelation();
            issuerelation.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issuerelation.isValid();
            issuerelationRepository.save(issuerelation);
            map.put("IssueRelationPrimaryKey", issuerelation._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private IssueWorkflowRepository<IssueWorkflow> issueworkflowRepository;

    @Autowired
    private ProjectFeatureRepository<ProjectFeature> projectfeatureRepository;

    @Autowired
    private ProjectModuleRepository<ProjectModule> projectmoduleRepository;

    @Autowired
    private CreateProjectRepository<CreateProject> createprojectRepository;

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

    @Autowired
    private IssuePriorityRepository<IssuePriority> issuepriorityRepository;

    @Autowired
    private IssueCategoryRepository<IssueCategory> issuecategoryRepository;

    @Autowired
    private IssueSeverityRepository<IssueSeverity> issueseverityRepository;

    @Autowired
    private IssueStatusRepository<IssueStatus> issuestatusRepository;

    @Autowired
    private IssueStageRepository<IssueStage> issuestageRepository;

    @Autowired
    private IssueActivityRepository<IssueActivity> issueactivityRepository;

    @Autowired
    private FeatureCategoryRepository<FeatureCategory> featurecategoryRepository;

    @Autowired
    private IssueFlagRepository<IssueFlag> issueflagRepository;

    @Autowired
    private IssueRelationTypeRepository<IssueRelationType> issuerelationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueRelationPrimaryKey"));
            IssueRelation issuerelation = issuerelationRepository.findById((java.lang.String) map.get("IssueRelationPrimaryKey"));
            issuerelation.setVersionId(1);
            issuerelation.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issuerelationRepository.update(issuerelation);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueId() {
        try {
            java.util.List<IssueRelation> listofissueId = issuerelationRepository.findByIssueId((java.lang.String) map.get("IssueWorkflowPrimaryKey"));
            if (listofissueId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByrelationCode() {
        try {
            java.util.List<IssueRelation> listofrelationCode = issuerelationRepository.findByRelationCode((java.lang.String) map.get("IssueRelationTypePrimaryKey"));
            if (listofrelationCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueRelationId() {
        try {
            java.util.List<IssueRelation> listofissueRelationId = issuerelationRepository.findByIssueRelationId((java.lang.String) map.get("IssueWorkflowPrimaryKey"));
            if (listofissueRelationId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("IssueRelationPrimaryKey"));
            issuerelationRepository.findById((java.lang.String) map.get("IssueRelationPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueRelationPrimaryKey"));
            issuerelationRepository.delete((java.lang.String) map.get("IssueRelationPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssueRelation(EntityTestCriteria contraints, IssueRelation issuerelation) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issuerelation.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issuerelation.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            issuerelation.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issuerelationRepository.save(issuerelation);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
    }
}
