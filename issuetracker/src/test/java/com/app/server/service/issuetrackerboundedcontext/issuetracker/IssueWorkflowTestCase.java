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
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueWorkflowRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueWorkflow;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class IssueWorkflowTestCase extends EntityTestCriteria {

    @Autowired
    private IssueWorkflowRepository<IssueWorkflow> issueworkflowRepository;

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

    private IssueWorkflow createIssueWorkflow() throws SpartanPersistenceException, SpartanConstraintViolationException {
        ProjectFeature projectfeature = new ProjectFeature();
        projectfeature.setFeatureShortName("tTTdZtRcWZAiF1kXjlI1Aq1XGfgozrBSFL5fB2oD09bOsamZGk");
        ProjectModule projectmodule = new ProjectModule();
        projectmodule.setModuleDescription("v6THDJUPLHjBLJTN8kXeoWjB2bFUCsc7E8GComoFfaXGFy7l4D");
        projectmodule.setVersion("d7TbqFz5ftuwv73XGlnjnqkmSSIBG95tO6q5ZFsHc5Qlvr05Q7");
        projectmodule.setDateOfCreation(new java.sql.Timestamp(1458211511279l));
        projectmodule.setBuild("YESdd8CZL5tgyzdhg69aFe2II5Z4TFa8qT27W5QtIXEMBurfVv");
        projectmodule.setModuleShortName("pcWzsiJKorfaUjmKHjyfP8tlMAXWtSWna6r2R1J4Mj8QnDFqAW");
        projectmodule.setModuleName("zOUc4q0I4X7ltIU9AudHq6wrsltKuft4dbhkoRaN87Qm4iSG1P");
        CreateProject createproject = new CreateProject();
        createproject.setProjectURL("BLHCQhXHx3wl9WxtDNPiS1e4zbGusPSbhjHaefl5LQdkyDpTq5");
        createproject.setVersion("izPqh3tmPLxArUzUPGMD3k59JXgKjLO5kIGKRfookJl477WlUd");
        createproject.setBuild("ol3X6EdBJ23bHW3MAJcneG2Aq7ofFgWTtlg6ziuHsNAaK0RO5b");
        createproject.setProjectName("tFXNj5aHMWP4HRJZyw4qNA91nsmnv36nq3FlkCMUH1MyRYuOtc");
        ProjectAccessRights projectaccessrights = new ProjectAccessRights();
        projectaccessrights.setProjectAccessName("na1RabuLahc94jjRJdOtUaOJy1DatUE4wdothhNVVCccKyLLEy");
        projectaccessrights.setProjectAccessDesc("dBJN0ageKna1HkJiZYdvvGDPK0fULCSW6d5jqdBLwbKZWo6e3c");
        ProjectAccessRights ProjectAccessRightsTest = projectaccessrightsRepository.save(projectaccessrights);
        map.put("ProjectAccessRightsPrimaryKey", projectaccessrights._getPrimarykey());
        createproject.setProjectURL("29T7rdSyQney5xoZY6emWXWJbWRHelkkSxCdpNXOLT52GEhyng");
        createproject.setVersion("xoABparpSaJoDQ38SLNxUItqU4YmxjCN4TqMWThHxpA7cWyKeF");
        createproject.setBuild("XklcN1M5Z3WDmBM12O6ngdk9lbT6Uv8Usdrio7SBMgoVg7RudO");
        createproject.setProjectName("LQUbUHag7RrB6WqrsVZkavw2YR36ApDl3gaQWShkvEsjAmtNS7");
        createproject.setProjectAccessCode((java.lang.String) ProjectAccessRightsTest._getPrimarykey()); /* ******Adding refrenced table data */
        createproject.setDateOfCreation(new java.sql.Timestamp(1458211511361l));
        createproject.setProjectDescription("9d0VQgaCDKuiDvdD4stFHifCaF5itOZRTIXEi26Dzh0cmpRJKD");
        createproject.setProjectShortName("Dwtra70gHogyvGRAACruTiTv1XIPdgT2u8CxW36ivE7k4g1LBl");
        java.util.List<ProjectUserMapping> listOfProjectUserMapping = new java.util.ArrayList<ProjectUserMapping>();
        ProjectUserMapping projectusermapping = new ProjectUserMapping();
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setLastName("jd7RfY9vw8TaDQgS51L5YivmL0hYkSolPDg1ejJRBfoSrYPkfG");
        corecontacts.setPhoneNumber("G8AATt6qEdylEc9ivqJU");
        corecontacts.setNativeLastName("h7MuLeBvGzLSaPNiVVZugUYZnbxKiHOBDWEBwhf0oBBpvXLLf1");
        corecontacts.setNativeTitle("7tKKjZF0NbXq614MrhgpD8dyI2EqqBSM8Bk6G1ti8j8m1nc2ct");
        Title title = new Title();
        title.setTitles("zHXStWi6OrkoN64vJTR0nfuhy0bA3YVLtJ4pUqxGlaLPmFMaNw");
        Title TitleTest = titleRepository.save(title);
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("wKOmm1zshSBdAsKqmeJpVaRliNTwhT0EikNTLYfyysx21wMgED");
        Gender GenderTest = genderRepository.save(gender);
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        Language language = new Language();
        language.setAlpha4("ydWM");
        language.setLanguageDescription("uSlNqodjOw95HvbbPLJHWjFpKcInRRNbali3bewjhyCTKhpicx");
        language.setAlpha3("Lf5");
        language.setLanguageType("RVcseuKJZn2zig82pS5OiBPiwFs4fEPx");
        language.setLanguageIcon("HtjdItFPbyFt3ASDopqDpXGO9kYty5c2c18i78uSo4jxMjd5Nj");
        language.setLanguage("kEiViBJwhPcv8OPLFsASPUKlejNFTfJArX1eezhxltrhGVFFyh");
        language.setAlpha2("t4");
        language.setAlpha4parentid(2);
        Language LanguageTest = languageRepository.save(language);
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        Timezone timezone = new Timezone();
        timezone.setCities("JNsv6tkrXBaxIvpAG1ehFoGIBJFSuutNLSc8RADmKa7ifVNW9o");
        timezone.setGmtLabel("rR9xCjDUeEfKZ8nHnnGFfVnHNtmKftPrTrT4NYZOMfYjxhpOgq");
        timezone.setTimeZoneLabel("Yb0DGu3y8OIvtPlByBiWgF7rSDezI7w2F7JplYuBQ3KGI0Z71I");
        timezone.setCountry("O8Q5sCkka7neQq0e0TsyRCArRJYSOZGOPqvmLbpyv3wxV7ldd8");
        timezone.setUtcdifference(3);
        corecontacts.setLastName("IhjYuIpSEWSHueZDvLivnhEtioLXJyKMzcbdqp9zQolKqQamyT");
        corecontacts.setPhoneNumber("9P4tYPMvHNmOfYlxAUSJ");
        corecontacts.setNativeLastName("Hhwplx2N1KIroe8n5OfULQvOitLrMXkkhKQo7zOTw6t3LL1bcp");
        corecontacts.setNativeTitle("xcQwUEWkAV5bwUQQCp9pvmpA084YVI6GfSdKOgC6QIrzCKNTVr");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("DuiroDPIzrb8oElxg8zCmhecoBpX7eDWskwPjnu3qrvDbOOblg");
        corecontacts.setFirstName("v6UueYyfuOwEqgN8hSHUbnZcUbVXWj0r5lSUFgLZBKfkECZoKa");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("HXfXqUnFjWpJ2zmCBIzUrv6gUalFizXG5cxM0c2x2KfN7N1xcU");
        corecontacts.setMiddleName("00WwvV3vqu9fmCzJ3U28NB5e7VhXoVcVWmeZumU26rYMyUvyX6");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458211511547l));
        corecontacts.setDateofbirth(new java.sql.Timestamp(1458211511547l));
        corecontacts.setNativeMiddleName("LkHgqSWGjBJz37Q2OdYOb7W7IHozb4bk9otBrxVQQd7EnHM0tj");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(19);
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(timezoneRepository.save(timezone));
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("d8v4uR3wyOEUpKuumn3gMELy2wo9sE95QrJltIfUev4C9rHpSP");
        communicationtype.setCommTypeDescription("nxHBmGqfGQOnoPksMLQJLMoe6wS35hh6x0U1Oiyho6FrLHhpVy");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("fcMr9MpgDuHxwu67dFxplLX3MBiGPl34D5hIwSsS29Q14FnxDV");
        communicationgroup.setCommGroupName("V4GvFJPIIcBJrfP1KLK3pvnZwz9sP5XjiB30CI2hBixLkKo1uW");
        CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        communicationtype.setCommTypeName("90G454RxiaitFhmfIlD06CKtmLxJifJcY5KJ4L2oESfuf0OCcG");
        communicationtype.setCommTypeDescription("lUxkCpsHSgo9Wa9SDkgESCvTgHESWSgdUP8YFE9yGNBgFit18I");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
        map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("Yf4BvXi8WuGz9A4qCUEkdnyGhDcBBXkObMHsvAxy9rCy5VWXEj");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress3("Bi8LBRu3nl6zxqpO2NGUL4qxC2SEMJuA79za6rhrkzfzuoPyFs");
        address.setAddress1("Wy7SIH0AfOtYb5LgdNQWyOp3FFjPHsJhfzzKbRZmY4GqioUwVg");
        address.setAddress2("6NPCPU9Vvdpo6BWweLlPgZ8S2rqWkFGzDjZr3ydpYxwJXx7lWX");
        State state = new State();
        state.setStateName("tDJRmvaOpGcoVnVXclbbxtP0zCRLeA68w5cdday9AJBNTrR4pK");
        state.setStateCodeChar2("bhF4dkNeiV3fcNUvjuB7qRX4XXL527XS");
        state.setStateCapitalLongitude(11);
        Country country = new Country();
        country.setCurrencyName("ZwFk8RRaz9NH08Lnh5IzqS1S8bbEuYHYhgxRZJG0gmOhDAcZnN");
        country.setCountryName("8PGY1PTit8gYPnsCeod8LJgoD4VfPQNzefVsdaeQdWzXu9Ub0q");
        country.setCapitalLongitude(11);
        country.setCapitalLatitude(3);
        country.setCountryCode1("2cQ");
        country.setIsoNumeric(11);
        country.setCurrencyCode("n5I");
        country.setCurrencySymbol("Bj0SSkpWQf2SG7mRzlyCI4YHwIr3Racr");
        country.setCountryCode2("rxk");
        country.setCountryFlag("9SZ2MGytIdGXLBntONVnNdMqDdgDATecoqXeeyngpe19128Jqe");
        country.setCapital("GLKiFQ78VH81tjqUDCqe4LdnHn7BbGw7");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        state.setStateName("j57xk6P9d3TPWg8VgdeILNdPjJRlOrFqgLXhOFrLbr9Gd6fSqs");
        state.setStateCodeChar2("Y6UrbWHSk2Nw9VuqBg9QMS3WpIS3AXn3");
        state.setStateCapitalLongitude(1);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("j7YZmb3OSmmKlK92qMSUoeGhQ7SezZPe");
        state.setStateCapital("WBMmoW7C8U6r248DU5QhiyKoaaNINMz7Pp9lnGFfLrf6Fb34dh");
        state.setStateCode(2);
        state.setStateFlag("wBjkzmOSWFWyU6M0QU3mtfmlq5brIzrDNNJfQx0PGcmiKrjGUV");
        state.setStateDescription("KIq8sMARyj5SWc3cF4mt7dIoADNaXaqzxE65eYCJBtlk9gFsMK");
        state.setStateCapitalLatitude(8);
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        City city = new City();
        city.setCityCodeChar2("8AONYAOC4VeyCq3A2WmIeJ2HQmMf7LO8");
        city.setCityCodeChar2("FnNXy6dxEqcTQFjXslHwr4As4DAqagMY");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("vYEijEWT8On1aRTSgomBZAZCFKNV2XpdFeIUlE8Kb0J3gIB3dd");
        city.setCityCode(2);
        city.setCityFlag("S1PQ3xHleqpaohJF9dv4LFio34iOe1AcNuspRVNnEm8lr0CUXf");
        city.setCityLatitude(6);
        city.setCityLongitude(4);
        city.setCityName("U3yCUTq4xWvcnhnKcD9C8LnFtLdgqQpe0h6LZlJw0SMmKWHXTI");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = cityRepository.save(city);
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("s1asWAsizbQ4ywZgJDTzDAzmckcJDsngm889usGuFmrXiAcBqD");
        addresstype.setAddressTypeDesc("M8cmYSqpicMPfAiwk26mE09zlFTOe0zl3c4a1miLtpfagqtxKE");
        addresstype.setAddressType("Y5q4flRBg8nTCpRo8OT1ESrkJr4wVLCu4F28zZdS8rBLRWZPgt");
        AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        address.setAddress3("ikpiKJefv1osWN4GxuVjbP3j056LpqgLCodxKIHj3V7OzG4xxx");
        address.setAddress1("OKOhmcyVu2naSaHljpsbuT90vp5yqSpuV6zPOni5jhPHxef8fB");
        address.setAddress2("7L2TmxT2ltUijyc9abYwIHi4EN39ZHjmaXqFMTxbyIedQy1vwa");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("5kzqZTAUGH5i38IrQOIbKtDUkbkfWumNqkNZil1kpQJmjJvwB6");
        address.setLongitude("YHNILuDV95Zq6EIHmK6VWs67pohzjAIloGyPpKAx1KeAwcRfHO");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("WMzRfY");
        address.setAddressLabel("e488JKYB37i");
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
        projectmodule.setModuleDescription("m4pZBu1mw1HGjIbWMNhKpCFRhZVid9atC0dU1DNbKLfAXaRFlO");
        projectmodule.setVersion("qPOSrR4g6vvCQntpKThaBAMyzDAfTrgOez6Yrap1QsLoV9Yhe2");
        projectmodule.setDateOfCreation(new java.sql.Timestamp(1458211511296l));
        projectmodule.setBuild("WCprfWgKAuRZ8fY3TxDnm6V3RsvSXuRZqL2GkrNjfL3Tyv9ZEK");
        projectmodule.setModuleShortName("zTTDMAYR0gmuUJ0Ob41PcYZx5lgmzpsItbzOAQDsqdAzW5Z5xk");
        projectmodule.setModuleName("BaIpv4FM2UhshwxqCxCAJJUIvvfgMb3L7yOwDeuGqn3toli290");
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
        projectfeature.setFeatureShortName("PopAAj8423HddiWnaTGNN8biZRIjusOKfDAGyEwcE7MZqldv48");
        projectfeature.setModuleId((java.lang.String) ProjectModuleTest._getPrimarykey()); /* ******Adding refrenced table data */
        projectfeature.setBuild(1);
        projectfeature.setDateOfCreation(new java.sql.Timestamp(1458211512186l));
        projectfeature.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        projectfeature.setFeatureDescription("bMk4kYzCh711kQjZ7qvNnWSGGgOomAMRvT86PC46aXORKr0tBj");
        projectfeature.setVersion(5);
        projectfeature.setFeatureName("bUatOjvInxWfHEXm55ZuT3zaYK7i21sSnfjerFLZayPdRY8rQl");
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
        IssueWorkflow issueworkflow = new IssueWorkflow();
        issueworkflow.setoS("kpnaOgfv96zPx3ZLSM7ctlYe89nx4iwU5OrDpRTM60lRiKjma7");
        issueworkflow.setFeatureId((java.lang.String) ProjectFeatureTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setStepsToReproduce("4L9J07TaRFQTPoFfuHTkyiLnp1bZzipoApJqzQ3Qt3JfpHqrOQ");
        issueworkflow.setBrowser("MPyFKptjsygOHSvvM6QvYnyRaqEgeMOdNIwC5ui6fJ763KLYRX");
        issueworkflow.setIssueTitle("DP9bWxfKeEiJKS2c2AMbF7Q2A3V96Dl66qlZkQM5oj8YhXdqOX");
        issueworkflow.setModuleId((java.lang.String) ProjectModuleTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setCreatorContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setDateCreated(new java.sql.Timestamp(1458211512515l));
        issueworkflow.setIssueDescription("h5SIlJaRAhZcZd40G0vfMLIFTgtUn8sFaItAJaoU2iegrskhll");
        java.util.List<AddWatchers> listOfAddWatchers = new java.util.ArrayList<AddWatchers>();
        AddWatchers addwatchers = new AddWatchers();
        addwatchers.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        addwatchers.setIssueWorkflow(issueworkflow);
        listOfAddWatchers.add(addwatchers);
        issueworkflow.addAllAddWatchers(listOfAddWatchers);
        IssueAssignment issueassignment = new IssueAssignment();
        issueassignment.setIssueWorkflow(issueworkflow);
        issueassignment.setEndTime(new java.sql.Timestamp(1458211512807l));
        issueassignment.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueassignment.setIssueDate(new java.sql.Timestamp(1458211512854l));
        issueassignment.setComments("hQZojeV4fMjeMjnjimtneIfnwsamFS7TCiGPS6UeYiaD4TXH3T");
        issueassignment.setStartTime(new java.sql.Timestamp(1458211512854l));
        issueworkflow.setIssueAssignment(issueassignment);
        IssueHeaders issueheaders = new IssueHeaders();
        IssuePriority issuepriority = new IssuePriority();
        issuepriority.setIssuePriorityName("YZw4oMYm08g92rfyHcHuhXt9ZoWp2zsp5qJzv0O95Y86zDnEVp");
        issuepriority.setIssuePriorityDesc("QbMTpcBVcQbkEsoKtMp854CzXkcKc7myfN0tp9FFAY5rpMNxof");
        IssuePriority IssuePriorityTest = issuepriorityRepository.save(issuepriority);
        map.put("IssuePriorityPrimaryKey", issuepriority._getPrimarykey());
        IssueCategory issuecategory = new IssueCategory();
        issuecategory.setIssueCategoryName("YcEk7NeBR1T0BlvfB5K8zuwV4f6WzbteOfRPwk93eZwsPFoETr");
        issuecategory.setIssueCategoryDesc("nNyNghIuoipvDTlIkbQn2XIb7Td8a52Iub8mptx7bUkziqhSal");
        IssueCategory IssueCategoryTest = issuecategoryRepository.save(issuecategory);
        map.put("IssueCategoryPrimaryKey", issuecategory._getPrimarykey());
        IssueSeverity issueseverity = new IssueSeverity();
        issueseverity.setIssueSeverityName("SgcLhj63i73GP0LYQoJ1yxgji3aAzaIHdAHzy2HEbLHFiONey8");
        issueseverity.setIssueSeverityDesc("uDQS7CetqeftGlAGeG3vS17pgGKi8EJ8rMl9Iy6FrgoyQbqBVc");
        IssueSeverity IssueSeverityTest = issueseverityRepository.save(issueseverity);
        map.put("IssueSeverityPrimaryKey", issueseverity._getPrimarykey());
        IssueStatus issuestatus = new IssueStatus();
        issuestatus.setIssueStatusName("mrIS3e5Clm3ZdIr4DC9X1Mlqy7TyIYCxIlaJYMgb3gb7vFAwDH");
        issuestatus.setIssueStatusDesc("GQh0kKJ7SBS5kOjyPtrM9xb36fvbcCUj5shPZ0Mf09ylMF44Pd");
        IssueStage issuestage = new IssueStage();
        issuestage.setIssueStageId("kHje9rbhJrMqjiSd1TCAqZJ79Q8Uc3vIaotwAgtQTZ1uQ8rsK0");
        issuestage.setIssueStageDesc("09w7dGytCCNiDRUqe2ZDTtVtn6VCL1Lq9rG1zzP66aa7uSCA2z");
        issuestage.setIssueStageName("uYK5TuNPXJ7HURtVODp4VW1yMZRzEFJK53oXo2kh4qoI7zunP6");
        IssueStage IssueStageTest = issuestageRepository.save(issuestage);
        map.put("IssueStagePrimaryKey", issuestage._getPrimarykey());
        issuestatus.setIssueStatusName("LCAJ7TFqKsHwkBl1svytHB3YJsuAN6Mowly5EDSLVk2UmZHeLK");
        issuestatus.setIssueStatusDesc("nH5UBrJESGCnvzbnQDIQzhZBCStgwyr1XE2cLDqnzhDICcctyU");
        issuestatus.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuestatus.setIssueStatusId(valueGenerator.randomValueGenerate("String", 64, 0));
        IssueStatus IssueStatusTest = issuestatusRepository.save(issuestatus);
        map.put("IssueStatusPrimaryKey", issuestatus._getPrimarykey());
        IssueActivity issueactivity = new IssueActivity();
        issueactivity.setIssueStatusCode((java.lang.String) IssueStatusTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueactivity.setIssueActivityDesc("cRYkLZaYfW2wZCn71YmQFsXv3msiWfIjlJUVPltvQPeoO9wZLo");
        issueactivity.setIssueActivityName("e0z8eXGkhfqFOYQq5nRKoMyDIOGiKRbbOYqYIcxGYDJAAGNKtP");
        issueactivity.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueactivity.setIssueActivityId(valueGenerator.randomValueGenerate("String", 64, 0));
        IssueActivity IssueActivityTest = issueactivityRepository.save(issueactivity);
        map.put("IssueActivityPrimaryKey", issueactivity._getPrimarykey());
        FeatureCategory featurecategory = new FeatureCategory();
        featurecategory.setFeatureCategoryName("smmtHmdTcxUsIxQTX0QYaUvKRFbta0YPZhArbjwKiUtO59ggWR");
        featurecategory.setFeatureCategoryDesc("LaVHQIMUWnuXwTA1b6XwFQ6bmxf8TQSWUj5jh7QHsSJiCD2Fnf");
        FeatureCategory FeatureCategoryTest = featurecategoryRepository.save(featurecategory);
        map.put("FeatureCategoryPrimaryKey", featurecategory._getPrimarykey());
        IssueFlag issueflag = new IssueFlag();
        issueflag.setIssueFlagDesc("q2RC2sNxERX1YEz7AeO2IFa4FXeC9DSoCDFK4vfWIObZLAecvc");
        issueflag.setIssueFlagName("oWbnNPZceMzc7RfPC1H4e42jmmDrx2ivG52qwYrqmvvU6sw3mA");
        IssueFlag IssueFlagTest = issueflagRepository.save(issueflag);
        map.put("IssueFlagPrimaryKey", issueflag._getPrimarykey());
        issueheaders.setIssuePriorityCode((java.lang.String) IssuePriorityTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueCategoryCode((java.lang.String) IssueCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueSeverityCode((java.lang.String) IssueSeverityTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueStatusCode((java.lang.String) IssueStatusTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueActivityCode((java.lang.String) IssueActivityTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setComments("oWSDG76EiGcS6vk4ShxmZYd6u03PDFwQ1H4wcmHhAd4IklsK3i");
        issueheaders.setFeatureCategoryCode((java.lang.String) FeatureCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueWorkflow(issueworkflow);
        issueheaders.setIssueFlagCode((java.lang.String) IssueFlagTest._getPrimarykey());
        issueheaders.setEffortEstimate(new java.sql.Timestamp(1458211513342l));
        issueheaders.setLastUpdated(new java.sql.Timestamp(1458211513342l));
        issueworkflow.setIssueHeaders(issueheaders);
        issueworkflow.setEntityValidator(entityValidator);
        return issueworkflow;
    }

    @Test
    public void test1Save() {
        try {
            IssueWorkflow issueworkflow = createIssueWorkflow();
            issueworkflow.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issueworkflow.isValid();
            issueworkflowRepository.save(issueworkflow);
            map.put("IssueWorkflowPrimaryKey", issueworkflow._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueWorkflowPrimaryKey"));
            IssueWorkflow issueworkflow = issueworkflowRepository.findById((java.lang.String) map.get("IssueWorkflowPrimaryKey"));
            issueworkflow.setoS("F5Xs2Qnubd51WjtC8DVzvr87SC7S9dVPjp9AJdcOOrdodNVSIi");
            issueworkflow.setStepsToReproduce("ruIGcQVbM3NWLvASIqdv9tTvneZP0PDigUS83dnL61UVWDQrSv");
            issueworkflow.setBrowser("pUEdoNbBgQrm4X8jQ51lOaWjAiKQ0d7ZhhPNqtYK0htmk9rTDW");
            issueworkflow.setIssueTitle("3CFhQFvSou2FyetvOpvMREFZUTkmMBDhADkazHN2eBliGJN2CS");
            issueworkflow.setVersionId(1);
            issueworkflow.setDateCreated(new java.sql.Timestamp(1458211513534l));
            issueworkflow.setIssueDescription("UqGghf0uYzmjegyaQlPiYl766QDedxrp6hRas1PwDMjv0MuGf4");
            issueworkflow.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issueworkflowRepository.update(issueworkflow);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByfeatureId() {
        try {
            java.util.List<IssueWorkflow> listoffeatureId = issueworkflowRepository.findByFeatureId((java.lang.String) map.get("ProjectFeaturePrimaryKey"));
            if (listoffeatureId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByprojectId() {
        try {
            java.util.List<IssueWorkflow> listofprojectId = issueworkflowRepository.findByProjectId((java.lang.String) map.get("CreateProjectPrimaryKey"));
            if (listofprojectId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBymoduleId() {
        try {
            java.util.List<IssueWorkflow> listofmoduleId = issueworkflowRepository.findByModuleId((java.lang.String) map.get("ProjectModulePrimaryKey"));
            if (listofmoduleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("IssueWorkflowPrimaryKey"));
            issueworkflowRepository.findById((java.lang.String) map.get("IssueWorkflowPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycreatorContactId() {
        try {
            java.util.List<IssueWorkflow> listofcreatorContactId = issueworkflowRepository.findByCreatorContactId((java.lang.String) map.get("CoreContactsPrimaryKey"));
            if (listofcreatorContactId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("IssueWorkflowPrimaryKey"));
            issueworkflowRepository.delete((java.lang.String) map.get("IssueWorkflowPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssueWorkflow(EntityTestCriteria contraints, IssueWorkflow issueworkflow) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issueworkflow.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issueworkflow.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            issueworkflow.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issueworkflowRepository.save(issueworkflow);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "issueTitle", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "issueTitle", "ScKwodSkXhlKw7GTOwAqFXjlzzXECeWRDn6shUYM6DDFSm5y0mD74aVWr3lC2hd0ksOw1djgd6Hjnfk5kpR3hWTfiNmNES3FOvrqMjCtXSVRzdq3cv7NNEUJ2XqYCXQfcS9hg5hCsDTXveF2a8VHarZHPavwSGpOGC6ILwxPIgryqJOL1lyOinthYrwUbS5MI9zVDyu3GAnRytfDi2fAZmxiz1QPI0vLwJgRuChi9wH5Qd9sbhQZT3YTYf1VK5GbP"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "issueDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "issueDescription", "pY2uPwdfI2xvvyHE5GBQRlysCoPP0NV9fgMfR8AChcu9JN7zM4IfttGg5xin7dVGzwE7JZkM0cUteoc18mhaaBWub5JHpbJojablM2AW1J8V5oWxAmMmemWaty3N1sLHvaRvrzSf2PNX1Pp3gyoQZF2lVlAATSKbcW2Swdgzi7WTBmjZQuW0qTG3DmlLhZOhvywfhbb0fa6ZJUNNYUeJfzcJIjxwmIuX6uk8sOENrGz7AQnaLyLeqpRrIWJ6aT9Tf8hvpRB9ax8QLpdpWSsLVkzduToZ7TkIU6fFXpxmmhxUu0tAWYWgFvGYeCGXzDca1d6rPp3eWMYGEkqmRdSyxzGwUjuhIzzXJgrjvw1DkqTheooZkI3q8g7mKSkuWssNCjKaAxEeqNGJ6zo3gTa4yvYrQF8HlQTGeXPY4ISMdEORh7NVjTxWi2BZbKoUzG6OmshsWImjNKJGKrIJTs3J1uE2YeQnu1BxAYcbT9fp3hsM3JQQSQ7SJ45CjTN4SyXAFIVFeYcLbSW3lSDQqaibTdAwYw9XxAwKHI6lAzzTTl3ENQaDaQXDMWqp3Z74M6rcu1k35ZF58LIyOSZQgZCrSxNrorgCd3T1JFeDc4ku04AnEt0u1zW7qe5wOuuVKvvKg0S0LtcdFliiLm7Lzuw9pSkGBlSYWagpNwd95Y9UrQTPbTJ704SQ07caaJBokzULSX6vn0ZZsVw0dsmbVVTpLvEFTYwfMY0kzdYUBY3NleARdc6FAfbmANq9MOs4rPM6Z0Ke2XHglZhOvwrQRpvCNbBRc1EBkzG0V1x2je9vk8aHYdJ66rLqp28JLlPGAMreWisHBy3TmnKBpWvncic8Wiq5XMbrAxbJ7ODssaLEDIfNtp5uxkL4Clc2aqtIqzL557fddIGudReczUUAfrMLeWE6CuUFyLkYrlHmJFM1DQnm58tLJsU4b7xEwfnfZC0IKPR46DnIp9UX1yV5nBUR8MFwfBX9w3TZ8jmIxfjpvtaU2Vj1VvRxf4sE17emcH4oN"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stepsToReproduce", "sIIdPOciEAzttTLIVMdV4v7cCBQsVNE4vIegow9SHIdHNm30R1r9DCqGA5F4CIAx4ghB4U0y2QNfOM4vhHHzUCR5y5uXBrkqLwCTsePy8CN1P3x27T2cl0UKkApQRKBWwbjMqGPCjRUCoGWxnMHjfSGSEKBvbLGBTF3fdcSmjEMlParc35wnOAVaWu7R4goPG2jBougqEDGKj1TrbnwwXryWWHTSYmmRz5jfKJs1BAQ2WiqfN9Xhct10w0qx8vzNGhrXk5mORKNAO5i8JRtNkcqGSG4pIJ6VR6UbDIINodMGvYTS5wAgDymFqxHWxryObqDNsk9jgPBl9ijIbTcIyT68E0ysVT6KPKWUKP23emz6DtyMMIFk5hE40G0Z7NcVXaUcU7aqRhA1VPqFqSX81b8TMiapy9ZUkmcbMdsEJoiplA7dc7YG7P7l27mYTBDHQFW0D5GZJyMb4gNkWZMEkn9Kq8iVpHq25pwupnGL885DcpcoRFasbJ66XvikNpL5CBNE5Ukz8PwW4pEJ98WqffrEH18F4XrhpFC3Zpg6SPbL8r2yAcHebITVTfihFEC4dYRdQChdcPSYhBgJ6M8EOAgkPitf3DcA0vxMS87KBDpwlZITHhjIlFi9urBfLH0sAg6ZPnWEvb0EHUH6vIkffdqQ0CHqSggkdcD6IB5QnZvrqcBsW2e2ROcnlM4PwZaAZKFdF9JehBbv7mCokCuVRi67l4olaazFM7I84Tee746m3RQEf8SNm6zX61qMOdWxUYKkWiEuDgB4zxlsFxVq8mQOkAY3Zuz6BSqmIjoAx4bAegZIOiG9GsloVg4jnFERYWdXgRofrbKyfH9RMqdHYM6Fd1ooDgwiXUNpq78sZ4oYNynVMuQBZOwtec4Hq6RrLlfFxjlvxgiZrfXMkZarSF53owejlNT3YmZmn2YlRXZyO8wfTxyaS78LDvvqgZvwvdsSIi3rW6cQEJCu5RCJyILpA0MhDPSgibRcd1YUUqtkWM99jEvw70KyANWdRyOFa"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "dateCreated", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "browser", "wgPul2wcESKml6Z30JmkvueTfLGbi3bUJ8VokT1IXiRZhEav9vEeIYpyM3NZkk0euhRbHuTnL2gTwj65kcIgdmOrE5fj050crTsEa5pphE5J6lGid8NnyIbOOntgEd0iP8ghnY7pocW0gzsnxaywtBgdua15fURGeYmR9a16n0gHD26EnWj12lAFRzudPs08QXz91SqYTcR5LWGLHuBnAJBEpkh0aM5YYOQcJayNYmp3rl1To35eDhXjju4rCf4cd"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "oS", "m7pay5Fz78YlKjFuuAHJtwegTw2hpfSHF4B8X0WHOsjOLEDxakW2AndsTGiXkO9OHJ3jn9w73tBQKhQXJgi0LAk4Nwf0Tqq1sxMTIYTGe5fqysB2XzZzoTC7u9WFiHD0UmTHdqHOOUQvUoGLN7VoBDDiRmEowtjz1sCVzLESy2RVm9Q4Gb3tDImqWzQpvRK4Ys61KNNjdJVcAfJ67cP8ImRPB51GjXvqTTlhCqpcvP6fACq6MofjiqAQAZkUFQSFN"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                IssueWorkflow issueworkflow = createIssueWorkflow();
                java.lang.reflect.Field field = issueworkflow.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(issueworkflow, null);
                        validateIssueWorkflow(contraints, issueworkflow);
                        failureCount++;
                        break;
                    case 2:
                        issueworkflow.setIssueTitle(contraints.getNegativeValue().toString());
                        validateIssueWorkflow(contraints, issueworkflow);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(issueworkflow, null);
                        validateIssueWorkflow(contraints, issueworkflow);
                        failureCount++;
                        break;
                    case 4:
                        issueworkflow.setIssueDescription(contraints.getNegativeValue().toString());
                        validateIssueWorkflow(contraints, issueworkflow);
                        failureCount++;
                        break;
                    case 5:
                        issueworkflow.setStepsToReproduce(contraints.getNegativeValue().toString());
                        validateIssueWorkflow(contraints, issueworkflow);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(issueworkflow, null);
                        validateIssueWorkflow(contraints, issueworkflow);
                        failureCount++;
                        break;
                    case 7:
                        issueworkflow.setBrowser(contraints.getNegativeValue().toString());
                        validateIssueWorkflow(contraints, issueworkflow);
                        failureCount++;
                        break;
                    case 8:
                        issueworkflow.setoS(contraints.getNegativeValue().toString());
                        validateIssueWorkflow(contraints, issueworkflow);
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
