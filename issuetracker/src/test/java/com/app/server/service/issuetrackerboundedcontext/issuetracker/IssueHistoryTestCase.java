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
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueHistoryRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueHistory;
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
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueFlag;
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueFlagRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueSeverity;
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueSeverityRepository;
import com.app.shared.issuetrackerboundedcontext.projectmanager.IssueCategory;
import com.app.server.repository.issuetrackerboundedcontext.projectmanager.IssueCategoryRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.FeatureCategory;
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.FeatureCategoryRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueActivity;
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueActivityRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueStatus;
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueStatusRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueStage;
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueStageRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssuePriority;
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssuePriorityRepository;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class IssueHistoryTestCase extends EntityTestCriteria {

    @Autowired
    private IssueHistoryRepository<IssueHistory> issuehistoryRepository;

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

    private IssueHistory createIssueHistory() throws SpartanPersistenceException, SpartanConstraintViolationException {
        IssueFlag issueflag = new IssueFlag();
        issueflag.setIssueFlagDesc("2P1AwwUStheGOR5lkTOe2D8Jbubl99XMbeqE2dCiL8jVh5L0E0");
        issueflag.setIssueFlagName("9LZ9ayc6y1S1OGVt7bXmAGnVdaFYINbDAAgX8w9UtVzE6oMxHA");
        IssueFlag IssueFlagTest = issueflagRepository.save(issueflag);
        map.put("IssueFlagPrimaryKey", issueflag._getPrimarykey());
        IssueSeverity issueseverity = new IssueSeverity();
        issueseverity.setIssueSeverityName("oRtcQDuGF9TLLpCME76JZ8DZJlG5OWW9KnS3jq8XRGm0RpE09J");
        issueseverity.setIssueSeverityDesc("WY837XKmnZyDefUMHxMLhstqXITgQWOTt1zcDq3FP0pniZrS6C");
        IssueSeverity IssueSeverityTest = issueseverityRepository.save(issueseverity);
        map.put("IssueSeverityPrimaryKey", issueseverity._getPrimarykey());
        IssueCategory issuecategory = new IssueCategory();
        issuecategory.setIssueCategoryName("c6VsoGPVltaNilkG4d98FWws5b9wVS6kthJp91DJXz4smpHRUn");
        issuecategory.setIssueCategoryDesc("kFdrritwgkrKRfvw1IJaXxA82YzAwff1ZylZws11vLxglSAoUu");
        IssueCategory IssueCategoryTest = issuecategoryRepository.save(issuecategory);
        map.put("IssueCategoryPrimaryKey", issuecategory._getPrimarykey());
        FeatureCategory featurecategory = new FeatureCategory();
        featurecategory.setFeatureCategoryName("plAQNhgeEZrzGWri5UFSfWDUPSQsXHTD5HU2MhGSQy9LZq4MwB");
        featurecategory.setFeatureCategoryDesc("NJrr2GzgFCYhCTDz0hNnzePgi0D8YJ50DTUILrsU39qFc2ZxwU");
        FeatureCategory FeatureCategoryTest = featurecategoryRepository.save(featurecategory);
        map.put("FeatureCategoryPrimaryKey", featurecategory._getPrimarykey());
        IssueActivity issueactivity = new IssueActivity();
        IssueStatus issuestatus = new IssueStatus();
        issuestatus.setIssueStatusName("nC8Z2EWedIj0rWYZcHtq0HS5NwuGKn2X0xyvBcttpUOdSeouex");
        issuestatus.setIssueStatusDesc("E7znKqWCpwv32djAsMz4XleKrm6htHmFHIOa5MvUSGK7IfXC1O");
        IssueStage issuestage = new IssueStage();
        issuestage.setIssueStageId("TF88G4Zt0Jkmh8Oogd11m222zjo039FQxlskmyyRBHufpi6QVC");
        issuestage.setIssueStageDesc("QbiuiBKNnFYiXVpFU3MKaQahkxNGgu2N9AMpDZzWP6PvvEqtzc");
        issuestage.setIssueStageName("j91qu2HR4R4w1yaPQ193sXW4iDTHvm8DJDIGvHedhp4XFB46ao");
        IssueStage IssueStageTest = issuestageRepository.save(issuestage);
        map.put("IssueStagePrimaryKey", issuestage._getPrimarykey());
        issuestatus.setIssueStatusName("Im6BBTzTWfdB6W8fAdDcwUCyVw6ciqYvE7ywmtQAvGyc02Sxtw");
        issuestatus.setIssueStatusDesc("nSiDdL1OgLCNYCAvV6pcV2to4HmCVy99Hfgs7uq6wzUqpJiWkD");
        issuestatus.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuestatus.setIssueStatusId(valueGenerator.randomValueGenerate("String", 64, 0));
        IssueStatus IssueStatusTest = issuestatusRepository.save(issuestatus);
        map.put("IssueStatusPrimaryKey", issuestatus._getPrimarykey());
        issueactivity.setIssueStatusCode((java.lang.String) IssueStatusTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueactivity.setIssueActivityDesc("92K3T7Zea1SDAXYI5hrGWb4n8ECOIA8czi6wWrbSzAnYUJRQyc");
        issueactivity.setIssueActivityName("5l0rH6fTUqvGoEoWQzeeZIm9Ji2DVsiW3VHbgm63bMNsn4kfYb");
        issueactivity.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueactivity.setIssueActivityId(valueGenerator.randomValueGenerate("String", 64, 0));
        IssueActivity IssueActivityTest = issueactivityRepository.save(issueactivity);
        map.put("IssueActivityPrimaryKey", issueactivity._getPrimarykey());
        IssuePriority issuepriority = new IssuePriority();
        issuepriority.setIssuePriorityName("jqFMJ9LAoFIJXtyOcxunZIDawWnoloCduWRIyPndNniPIcX60p");
        issuepriority.setIssuePriorityDesc("606hELnL0tf80vU8OkndhJ5HNylmIZdiYoXI1dcKjPRFiuquMr");
        IssuePriority IssuePriorityTest = issuepriorityRepository.save(issuepriority);
        map.put("IssuePriorityPrimaryKey", issuepriority._getPrimarykey());
        IssueWorkflow issueworkflow = new IssueWorkflow();
        issueworkflow.setoS("4wOVUSiEywS7GsyI8NVV1TIuuetFzcDHf0hEVIulLjrO1ZFdev");
        ProjectFeature projectfeature = new ProjectFeature();
        projectfeature.setFeatureShortName("CVp3VZFbK7fKONTUXjhtkZ2U8evejEGy2P5I4aSX9lm53K3pYg");
        ProjectModule projectmodule = new ProjectModule();
        projectmodule.setModuleDescription("xRAiJqpBLGFOWWP29HBs7iFqKKA5SZOLMuHravFrH8XdZH5fcP");
        projectmodule.setVersion("lBjtaeYErWeIFslzmjLK9CefeBwCgKxlU3qGDEPBMffjenUU3U");
        projectmodule.setDateOfCreation(new java.sql.Timestamp(1458211516094l));
        projectmodule.setBuild("Nvdieqqjd7J5s1znKvPEfWKyCtP7wj0qHpG5hKqo9t5gbIR7AI");
        projectmodule.setModuleShortName("rsC9TJOYHsvAsKmwa0zCrttoeC7qKC2l8l0v8kiyDYqtHX74vG");
        projectmodule.setModuleName("SUsDCIah8uPncs1v3JqoDzVHELyvNAs2c7dSLB6vfpkB1xzQJe");
        CreateProject createproject = new CreateProject();
        createproject.setProjectURL("QJJLGvZO7euhtRPaL09wOC1UWFL0dy472LXNoDcGmAZ4JhJjET");
        createproject.setVersion("W1bfP2p5vp253qZXv3GwnSodnip1ATQjai8Alc32SYXY3plMNk");
        createproject.setBuild("t9D7KgYDnM072Qz3WqyWAe0hwkQDZ4kcOdZO1r2340F1Z53OAG");
        createproject.setProjectName("LeNQo28rK3rfi196gPU1SZIDAI6Q2nuNoexsskJO0FLZ9IUJen");
        ProjectAccessRights projectaccessrights = new ProjectAccessRights();
        projectaccessrights.setProjectAccessName("KmJjk4BsYq7mL3guhOBSU4fNoYcTqNq3KuhPbSs5v3GJ7JiD9M");
        projectaccessrights.setProjectAccessDesc("AmFEWRgAp5CDMku88eH01flTTWCBjhjjrYcMnYMu6uCBiw5qML");
        ProjectAccessRights ProjectAccessRightsTest = projectaccessrightsRepository.save(projectaccessrights);
        map.put("ProjectAccessRightsPrimaryKey", projectaccessrights._getPrimarykey());
        createproject.setProjectURL("ABBVMWPLsNMVESHIC6S8moDEqSSRVZxxoH7vc7RyUzd8ozcVWq");
        createproject.setVersion("npoWx3olZkEmBn37UKU7Z9lmyMC563gcu5tf7qNgXz1WeusK0Q");
        createproject.setBuild("emPd9Dz8gDgSXXLCDfavGZ1PeQqr5aK5WWkMRR0MskFJW7KwGR");
        createproject.setProjectName("E1auTUT4aBZx1peDkEXLqAFr4pcqgPqzHMYfne6zq4nzRl6kdt");
        createproject.setProjectAccessCode((java.lang.String) ProjectAccessRightsTest._getPrimarykey()); /* ******Adding refrenced table data */
        createproject.setDateOfCreation(new java.sql.Timestamp(1458211516143l));
        createproject.setProjectDescription("SBr78LgMOG7MlfedVWhZ66PA0WE7kkfQHEBe55YmIiFlmOVz7j");
        createproject.setProjectShortName("Gj3M2RNYode6rdepKkaxh61ws7vSQ2kYyUcWTEz22Omd1yglM3");
        java.util.List<ProjectUserMapping> listOfProjectUserMapping = new java.util.ArrayList<ProjectUserMapping>();
        ProjectUserMapping projectusermapping = new ProjectUserMapping();
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setLastName("uuevjLPqMc6TKbDJ0wGJzpcaVDSO9HBgp1cwlLWZE8q8vhTpQl");
        corecontacts.setPhoneNumber("nsN0WAuDTXL4loYwbknR");
        corecontacts.setNativeLastName("pongcFwsQmWFkgIU5gIW5LonGWD87DJeoa7SU1TCfFEEdBkuzC");
        corecontacts.setNativeTitle("efrpK7UDB3ehU1jMRG1IBaPnbyyNk3Ld1BhdvAw5x3jS6B0KuW");
        Title title = new Title();
        title.setTitles("vYYzyqjhr8HHhJYwIjFkdKNN2xvBNNj9MQc8K5ZwhV7g75Nb6Z");
        Title TitleTest = titleRepository.save(title);
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("dJrEbSm1bHtYg6uiscgaQOo3G0HXrsWs35K00c9W7BhJBvg6c8");
        Gender GenderTest = genderRepository.save(gender);
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        Language language = new Language();
        language.setAlpha4("yhmx");
        language.setLanguageDescription("h149y5mhf2B9h4l8BZ8gUyOR1ouPdUnIQ8RjqNv64VrhQiUcvH");
        language.setAlpha3("xKH");
        language.setLanguageType("7FHeFyACy8pivKiAWKgFTL0emSL26kMC");
        language.setLanguageIcon("HUPJsps6T7e1qdENUm2zogkNAlrNfveH0GM8j1dzuW1lMHZNp0");
        language.setLanguage("uFORvL8pIkjFeijOpOOpNXPnrNjkGKbMx7mDVGs0uztFJUu0d4");
        language.setAlpha2("7d");
        language.setAlpha4parentid(5);
        Language LanguageTest = languageRepository.save(language);
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        Timezone timezone = new Timezone();
        timezone.setCities("i7iqG41dV5m1y4bCbVOTiV7EfSDJYStyVeaNndAPexK2knAwxT");
        timezone.setGmtLabel("JJYXWTkE3z3CvzIoDYr4Qp31OpKqBUbUzu1ChrEmKrbXqLjPIT");
        timezone.setTimeZoneLabel("uP434waL2L3IJOdNoyRYBlUv3mIXOZ3oZoyDN4DqpfZnrWdd25");
        timezone.setCountry("6NoVysa9KeZbLEjLmTZRXYSHXtCiDSzMwA9saijxBb52RzZ63p");
        timezone.setUtcdifference(8);
        corecontacts.setLastName("AkUxey9bNY3lKyL2M5HtO1oHLCoJQJPDL2CbaPUDVDDB09vlMa");
        corecontacts.setPhoneNumber("kX1xBRGuY8h4v3SWSENj");
        corecontacts.setNativeLastName("xdwOYG4hLCRiA30OdGmZY88s7IV2ykvdmjkT68Gr43Cp9mlNX5");
        corecontacts.setNativeTitle("5JAwU060B4xwQzgDyFRWwkaDty7sfeY18U8tvAtbn77ndA5QzY");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("3Fln1gHQGM3Qi0D3KjSTStY01dXY9uv3OWw6SdMjgSzuq9JKPH");
        corecontacts.setFirstName("JQvtGI46Vc9Z9IH2enoCaMzZNtAeGjEZw0fJiuoxARQYlka4uh");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("9vrHKcRRbObfPVOol0FchFDXWjFKngDGIcBImlt4QRNxJfgk49");
        corecontacts.setMiddleName("bXf2vnp1F8c8fFBEv3LUFFoWPDxSdqVYsPFlrEKrvudmwN0iBc");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458211516300l));
        corecontacts.setDateofbirth(new java.sql.Timestamp(1458211516300l));
        corecontacts.setNativeMiddleName("PDU0wU1EScism0mf86s7PN6aAC8sxwEXmbszHYbknSYgB6a0Ol");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(111);
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(timezoneRepository.save(timezone));
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("mb6NqVEhUIjloqhcibaDgtmjM4oWSYoKoYyxMTlT0BpIPxiTJh");
        communicationtype.setCommTypeDescription("bNApj1cHi4nVtvJjDmNsBinQ3XggVqUEHIOeyUzrv5sQ73Bk08");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("IfcK9KmaUd96nIEticyPIp6gjnMiHQy5BU7Z2FVAUPoov6km7I");
        communicationgroup.setCommGroupName("k8N0XTNNiP2HmfgqZuSdc4PUk9KgD3SIdUbXlU2WSfZWhLMzFa");
        CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        communicationtype.setCommTypeName("TzObSJzjpjc8V2icDYtFx1wsS41HXHKrPV0LUqWQg4Eud2bHwd");
        communicationtype.setCommTypeDescription("IywsTGZhQCJnxP6ey1hUDvel6V6UCR7jOcXWaxtacGlTHinC0Q");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
        map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("Qj4XtVX2bRjV3VS6jC5VQ65PZrkYqvzZDKo7FdjrolZPXzCbqV");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress3("iZwzhpb8if4KMuDGQ1PARrui0gg9GFdpe4Rmrm8cFIzxx3dLAj");
        address.setAddress1("1MXvsfl90NFJHdG7uImHPEOGZo3YmAV0MkxP3Vzb9v5ySUn5hH");
        address.setAddress2("B6YqcFxn4158LvgOQ6k3yzbMYgNALrnhcUaelEbwU7frKcqMEj");
        State state = new State();
        state.setStateName("aAwCR0GmPy58z82zeBtHSoT9ZcfbInzOLX8xbdjrbdJZCuKaTb");
        state.setStateCodeChar2("ayuAmMFsQzb0RjTC6jRdsZC4lBEin3QT");
        state.setStateCapitalLongitude(4);
        Country country = new Country();
        country.setCurrencyName("D9K0IJ9TadYXPJPudgNlXFIMRJoosRF4ITBlcJFdvE5xYcCMbe");
        country.setCountryName("XEy1fuNcjX2ksjw8X2BkfemJkkOgbWTs1ezDaKnjy9juMWIbCA");
        country.setCapitalLongitude(9);
        country.setCapitalLatitude(10);
        country.setCountryCode1("pqc");
        country.setIsoNumeric(11);
        country.setCurrencyCode("ucM");
        country.setCurrencySymbol("5ogkOWq9q34g9eUwMBvysh8MS5w1HghD");
        country.setCountryCode2("wNC");
        country.setCountryFlag("AAEx0SihepVdACRnORQ1EYDVUg006A8wu34MkemJVr4Gdwjt3O");
        country.setCapital("XOtyXK743ovzE2RQKcQBfIZaz6gtKNzU");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        state.setStateName("A09d8XPpBkZCqTdCByLt7RgrIAbann5xC1oGzBwa4zU7hwxmuX");
        state.setStateCodeChar2("IgYGQVP4sFwY0pYYBwpvUVYUFbkNZ9Kj");
        state.setStateCapitalLongitude(9);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("gduo9VlBah9ktc7MXUEDtoOFNitnASxr");
        state.setStateCapital("Ljr0X52Ij6qTHjF5lCQIDoq5r9N2HkTQyb8eeKKB6oS0whScnl");
        state.setStateCode(1);
        state.setStateFlag("vLZyPOTX52CB9ylgWLskJqEVwn39Wl4kMDzilhtWWJei7JzwhR");
        state.setStateDescription("Bsli2IFBjx5c0CqwYFGraXhO9JnUqQVHfugJ0oIKA9JbWUxvLX");
        state.setStateCapitalLatitude(6);
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        City city = new City();
        city.setCityCodeChar2("X1vREUUmhonBDJ43iSntQmAQfa4JlCXm");
        city.setCityCodeChar2("uypoAsSPM2q62pL9v1jhpPITQIVXiGPZ");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("KjDvAY85ueMOMsP5vkrRquhiZP275mkETc7ZN86Ht9NoMlra87");
        city.setCityCode(1);
        city.setCityFlag("ergZhkPsToh3V8blc6xsYO9Ll0eAq2a9gWMo5N6DBndE7U8twb");
        city.setCityLatitude(1);
        city.setCityLongitude(4);
        city.setCityName("1vD5ngHHtUWoTmPeXKI6jpIQv5BXgf7AY7S9TDrigPcYipL6tm");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = cityRepository.save(city);
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("3TVQotIw2akHrCF5m3du05CTV7Fo6tTIG0pkWkDKU88VvZRzEy");
        addresstype.setAddressTypeDesc("PQkUEaNw8nxT8ac6S8QDXGZngks2eIKKNVHLueBWjZ7nTiOpa7");
        addresstype.setAddressType("AY3WU99879NNpuobzEnBA9WjaCfI2LqFCDegbl26Y2T6Cq0FuH");
        AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        address.setAddress3("2b4OF3GwLJbUQXNAaXkTsTjEsNo2blbMA3kzTItujQUkrxmEpU");
        address.setAddress1("QFv4M15zKDRYs7q0lvlV0sSR7oT08M8ziRC63PXYNjgtVyGJAD");
        address.setAddress2("37z3kT2u2r72vdAUnHIibqmVLaoPAygdjOoFW9KHHNfynRoGxn");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("iZfqtlt21DNLvMM250FVVpBaai80wdCO9GUb3QTS3YdREpuck3");
        address.setLongitude("CyRxSeISXAhGhZzmXKAV3lVjkxMNuvoE7kVLbnRpKXzxlkuYtk");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("pkFffA");
        address.setAddressLabel("UwhiE3HQUMC");
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
        projectmodule.setModuleDescription("TcG9j7ngUN4iwnhL0PrzfNE9vDqNVvIFMChtiBv9vLXS5Sps2F");
        projectmodule.setVersion("qpzLJFSzuwbcoCxhPr0P2LEyiSBoUYYmsheByhJ5EMedDSl9WS");
        projectmodule.setDateOfCreation(new java.sql.Timestamp(1458211516099l));
        projectmodule.setBuild("Vlldxfg0bHmT0YX1Teh7i6FVZI1iIXnFoeP0IRVMdTFYIafRCW");
        projectmodule.setModuleShortName("c8oXQlx8tPfsWnUwDWX12AuBS7hAVH57rT0XBXZhv8DTuL17k0");
        projectmodule.setModuleName("EjkXxovLkQ68tJGCli2L87WFU66npEEB9lczIK53EerwXN7GLV");
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
        projectfeature.setFeatureShortName("sZUvg0j7dRKvcjx776tRVoNmTT7MuQQAJqLXA5HeVrkOb2QSpb");
        projectfeature.setModuleId((java.lang.String) ProjectModuleTest._getPrimarykey()); /* ******Adding refrenced table data */
        projectfeature.setBuild(1);
        projectfeature.setDateOfCreation(new java.sql.Timestamp(1458211516885l));
        projectfeature.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        projectfeature.setFeatureDescription("o4jpuxisY0oDWufmZjQpT8R3vKhbxi7GI8YDxLLLppDcazxtCg");
        projectfeature.setVersion(9);
        projectfeature.setFeatureName("d0j2cgyFJ5FEzA6108nohLlqnLayOCksXy6VOHkgDt0TYSsx6o");
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
        issueworkflow.setoS("ewIjrdMyCC6yWINPX4gVdd65hi8oUQ6QQETzYWxudGmEqL3Sih");
        issueworkflow.setFeatureId((java.lang.String) ProjectFeatureTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setStepsToReproduce("wkruPzIPut9hq9BIPyWgAF7VT0283UWZeXigq6Ksh5QhgfkmYv");
        issueworkflow.setBrowser("fFba8bQbFBIO9u1MuVloXznX7mHd4t0UPQcDbU3PviibrAow9Q");
        issueworkflow.setIssueTitle("uEHgu1LXIm6eUGWlCbMW0aLvEyf6PfHSAzSSWxiQcbZOypUPgr");
        issueworkflow.setModuleId((java.lang.String) ProjectModuleTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setCreatorContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setDateCreated(new java.sql.Timestamp(1458211517303l));
        issueworkflow.setIssueDescription("sbjAZJ0YA6QNwPK3IKpzU48IjgG5p8ji6myeKsz9RpIdyuTW4N");
        java.util.List<AddWatchers> listOfAddWatchers = new java.util.ArrayList<AddWatchers>();
        AddWatchers addwatchers = new AddWatchers();
        addwatchers.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        addwatchers.setIssueWorkflow(issueworkflow);
        listOfAddWatchers.add(addwatchers);
        issueworkflow.addAllAddWatchers(listOfAddWatchers);
        IssueAssignment issueassignment = new IssueAssignment();
        issueassignment.setIssueWorkflow(issueworkflow);
        issueassignment.setEndTime(new java.sql.Timestamp(1458211517601l));
        issueassignment.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueassignment.setIssueDate(new java.sql.Timestamp(1458211517644l));
        issueassignment.setComments("kA8xjrx9VbM7vvouU24uAj33gzGs4TiRvBKTcJu2weAcxy3LF3");
        issueassignment.setStartTime(new java.sql.Timestamp(1458211517644l));
        issueworkflow.setIssueAssignment(issueassignment);
        IssueHeaders issueheaders = new IssueHeaders();
        issueheaders.setIssuePriorityCode((java.lang.String) IssuePriorityTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueCategoryCode((java.lang.String) IssueCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueSeverityCode((java.lang.String) IssueSeverityTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueStatusCode((java.lang.String) IssueStatusTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueActivityCode((java.lang.String) IssueActivityTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setComments("xxUHglkBbDpza7assW5SC4L4msmYqfRG5F80d7DXdM5atKXrH4");
        issueheaders.setFeatureCategoryCode((java.lang.String) FeatureCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueWorkflow(issueworkflow);
        issueheaders.setIssueFlagCode((java.lang.String) IssueFlagTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setEffortEstimate(new java.sql.Timestamp(1458211518047l));
        issueheaders.setLastUpdated(new java.sql.Timestamp(1458211518047l));
        issueworkflow.setIssueHeaders(issueheaders);
        IssueWorkflow IssueWorkflowTest = issueworkflowRepository.save(issueworkflow);
        map.put("IssueWorkflowPrimaryKey", issueworkflow._getPrimarykey());
        IssueHistory issuehistory = new IssueHistory();
        issuehistory.setIssueFlagCode((java.lang.String) IssueFlagTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuehistory.setIssueSeverityCode((java.lang.String) IssueSeverityTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuehistory.setIssueCategoryCode((java.lang.String) IssueCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuehistory.setStartTime(new java.sql.Timestamp(1458211515834l));
        issuehistory.setEffortEstimate(new java.sql.Timestamp(1458211515834l));
        issuehistory.setEndTime(new java.sql.Timestamp(1458211515834l));
        issuehistory.setComments("nZBDKtGLmM6Sty8ViGn8wac7hQB7YJXDcrMF4Px9anPCsPi8Pn");
        issuehistory.setFeatureCategoryCode((java.lang.String) FeatureCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuehistory.setIssueActivityCode((java.lang.String) IssueActivityTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuehistory.setIssuePriorityCode((java.lang.String) IssuePriorityTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuehistory.setIssueDate(new java.sql.Timestamp(1458211515991l));
        issuehistory.setIssueStatusCode((java.lang.String) IssueStatusTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuehistory.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuehistory.setIssueId((java.lang.String) IssueWorkflowTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuehistory.setLastUpdated(new java.sql.Timestamp(1458211518102l));
        issuehistory.setContactId((java.lang.String) CoreContactsTest._getPrimarykey());
        issuehistory.setEntityValidator(entityValidator);
        return issuehistory;
    }

    @Test
    public void test1Save() {
        try {
            IssueHistory issuehistory = createIssueHistory();
            issuehistory.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issuehistory.isValid();
            issuehistoryRepository.save(issuehistory);
            map.put("IssueHistoryPrimaryKey", issuehistory._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private IssueFlagRepository<IssueFlag> issueflagRepository;

    @Autowired
    private IssueSeverityRepository<IssueSeverity> issueseverityRepository;

    @Autowired
    private IssueCategoryRepository<IssueCategory> issuecategoryRepository;

    @Autowired
    private FeatureCategoryRepository<FeatureCategory> featurecategoryRepository;

    @Autowired
    private IssueActivityRepository<IssueActivity> issueactivityRepository;

    @Autowired
    private IssueStatusRepository<IssueStatus> issuestatusRepository;

    @Autowired
    private IssueStageRepository<IssueStage> issuestageRepository;

    @Autowired
    private IssuePriorityRepository<IssuePriority> issuepriorityRepository;

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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueHistoryPrimaryKey"));
            IssueHistory issuehistory = issuehistoryRepository.findById((java.lang.String) map.get("IssueHistoryPrimaryKey"));
            issuehistory.setStartTime(new java.sql.Timestamp(1458211518163l));
            issuehistory.setEffortEstimate(new java.sql.Timestamp(1458211518163l));
            issuehistory.setEndTime(new java.sql.Timestamp(1458211518164l));
            issuehistory.setComments("JrcmN7xxcxyjAJGsTNSyZj2nzVKl2Z9Zjl5KE8aQKKFJ4yVAUK");
            issuehistory.setVersionId(1);
            issuehistory.setIssueDate(new java.sql.Timestamp(1458211518168l));
            issuehistory.setLastUpdated(new java.sql.Timestamp(1458211518170l));
            issuehistory.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issuehistoryRepository.update(issuehistory);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueFlagCode() {
        try {
            java.util.List<IssueHistory> listofissueFlagCode = issuehistoryRepository.findByIssueFlagCode((java.lang.String) map.get("IssueFlagPrimaryKey"));
            if (listofissueFlagCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueSeverityCode() {
        try {
            java.util.List<IssueHistory> listofissueSeverityCode = issuehistoryRepository.findByIssueSeverityCode((java.lang.String) map.get("IssueSeverityPrimaryKey"));
            if (listofissueSeverityCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueCategoryCode() {
        try {
            java.util.List<IssueHistory> listofissueCategoryCode = issuehistoryRepository.findByIssueCategoryCode((java.lang.String) map.get("IssueCategoryPrimaryKey"));
            if (listofissueCategoryCode.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("IssueHistoryPrimaryKey"));
            issuehistoryRepository.findById((java.lang.String) map.get("IssueHistoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByfeatureCategoryCode() {
        try {
            java.util.List<IssueHistory> listoffeatureCategoryCode = issuehistoryRepository.findByFeatureCategoryCode((java.lang.String) map.get("FeatureCategoryPrimaryKey"));
            if (listoffeatureCategoryCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueActivityCode() {
        try {
            java.util.List<IssueHistory> listofissueActivityCode = issuehistoryRepository.findByIssueActivityCode((java.lang.String) map.get("IssueActivityPrimaryKey"));
            if (listofissueActivityCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissuePriorityCode() {
        try {
            java.util.List<IssueHistory> listofissuePriorityCode = issuehistoryRepository.findByIssuePriorityCode((java.lang.String) map.get("IssuePriorityPrimaryKey"));
            if (listofissuePriorityCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueStatusCode() {
        try {
            java.util.List<IssueHistory> listofissueStatusCode = issuehistoryRepository.findByIssueStatusCode((java.lang.String) map.get("IssueStatusPrimaryKey"));
            if (listofissueStatusCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueStageCode() {
        try {
            java.util.List<IssueHistory> listofissueStageCode = issuehistoryRepository.findByIssueStageCode((java.lang.String) map.get("IssueStagePrimaryKey"));
            if (listofissueStageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueId() {
        try {
            java.util.List<IssueHistory> listofissueId = issuehistoryRepository.findByIssueId((java.lang.String) map.get("IssueWorkflowPrimaryKey"));
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
    public void test3findBycontactId() {
        try {
            java.util.List<IssueHistory> listofcontactId = issuehistoryRepository.findByContactId((java.lang.String) map.get("CoreContactsPrimaryKey"));
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
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueHistoryPrimaryKey"));
            issuehistoryRepository.delete((java.lang.String) map.get("IssueHistoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssueHistory(EntityTestCriteria contraints, IssueHistory issuehistory) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issuehistory.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issuehistory.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            issuehistory.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issuehistoryRepository.save(issuehistory);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "comments", "sTg3yC8EV7mHSTY0ykxxGMtuZFIBjXpXyhjTK5NPbHhfR8dTLdOC0ziBcSk7IzRZ4lg5OocUVyxD6ISOI30YYh8qN6YJoyTDRqsLkdwxMnkB7hyULQegyeMlKYYVZQBhqV2vr2vWrP6Wi7un5IuEjoxvDyYldx4AoPvlNbtNYFuJs6BUgm0I1db1fH7D3lZy3lyM8goq3Gf6zV04aWHLe9VEZrHC7NR5GUL6cdnxBFDffujxI2XD7RotsfuxerffE5pVGIGVHRhzfEfEDFUjSo1kV6sk8eqKJCEqBZvkECILRlUdc2UaxSJZcBpGH05s8m4kqPHtRH4ldIYydaDRhWcOldqtyIiiq3rp7stB8Qeb0D7oHaZVKbxgf9l93aAbTCIP7fFYz07FWM9InnYVC7JZqYIhC2i0kXVaTsT8LDdSvj1NhwTuwdlsiNlnh2Z5Adl1fgNE2SKFE99NM66LUDGtjvgGVmi6VtVDZjg9EEsqvp8aBktrKxibk87w0S5PW6qUwYLNB0Rtwf7gJkVwP5Q3claP6EPz8HNOFEAvAq6qRfMX6HPF7h3JAKygwmhPofA0fHRiwsloNyMTpzFewnAuyQrc6Q0aSxSSt1o8kVq8WpwbVbuROxgWnpxhWuzfGiVQeoa1kalw0mzTYxI7IXTCq0xJOoyyQzhwj2YMhBptgAGGqUHNWHigZFKVLbWtptKymouWOakN2uUhkDiRCT8uLHeFSHWq3xVQfNSLPQJgM8u2y1vt5ZUmji2zFltUsqW3RRZsJO1V5R2a8gnabPLVVdm8ohoO79JT645XJDhmTLn1SwFG0vdQKDHJx6XXVW0KpSXAPlAMUMiXeAu5N8NuJRLqIWj3Rkpi2QCnybcb97q2yphwE4hEsqLxRtLgQVBArYscv1YJkOPUmeWoXgj4uR2J5pwoSWoVZLOPx6whrkUnA2Qf9oTJ8ZQ3Dwth7tC5EtNio8Au9LHoe9FRU3PVLojFRKpjibPdUFOPTaISiT2ehB9lqnEDT4wxv3dp3"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                IssueHistory issuehistory = createIssueHistory();
                java.lang.reflect.Field field = issuehistory.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        issuehistory.setComments(contraints.getNegativeValue().toString());
                        validateIssueHistory(contraints, issuehistory);
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
