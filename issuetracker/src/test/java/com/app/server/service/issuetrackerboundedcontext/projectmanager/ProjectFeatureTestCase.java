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
import com.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectFeatureRepository;
import com.app.shared.issuetrackerboundedcontext.projectmanager.ProjectFeature;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class ProjectFeatureTestCase extends EntityTestCriteria {

    @Autowired
    private ProjectFeatureRepository<ProjectFeature> projectfeatureRepository;

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

    private ProjectFeature createProjectFeature() throws SpartanPersistenceException, SpartanConstraintViolationException {
        ProjectModule projectmodule = new ProjectModule();
        projectmodule.setModuleDescription("8UfX00bJRdJck77nGyldwZ9z1gHuDIPlTFySXrAXmYcVct5RoN");
        projectmodule.setVersion("X87q9fPEcteKxebU2KrUihQmWmTZwFgfGevFwSJOU1rdv0LtJA");
        projectmodule.setDateOfCreation(new java.sql.Timestamp(1458211499137l));
        projectmodule.setBuild("Jg8be9Uivol852nLlGisX8BQjG0cbVS0PljhhEM7oiaYwLwaDo");
        projectmodule.setModuleShortName("l74mHH13sAcgaXhVOHPaRxOzleuZohFRzPTrKAUV5jdJ52ZyiY");
        projectmodule.setModuleName("Jv6Tc8QSnAg112FTQHg2IVkzp32i7vOoy688yZi52ToyrE5DTl");
        CreateProject createproject = new CreateProject();
        createproject.setProjectURL("zPesqgeuZ2xePATEk5609uWz0DeY6E1DGmz69wheiByCVKvvqe");
        createproject.setVersion("9ijXaTJU3JpQ5OJYXSNaX7HVYqLPG7CQnh50Q2ngCtLKsMfzhg");
        createproject.setBuild("joIQpSVkfvXLhVdt56dtacNyL4t4wzzKdhV3NKEzS9fR30h0T1");
        createproject.setProjectName("RzKQ1Hg3CUOxZ3rP5GGpLxBVDBYLHhuG9fIf7ccytB9gsZkzGe");
        ProjectAccessRights projectaccessrights = new ProjectAccessRights();
        projectaccessrights.setProjectAccessName("ohf0sZu8sBqM1SbiH3GTmYnHabDNgtj66PENq7HiUPFw2LF8ls");
        projectaccessrights.setProjectAccessDesc("eqOc6HQGyzVaJI3fhgad1TDcESQclwsAVOQpvCqxwTMdQ3Vvgv");
        ProjectAccessRights ProjectAccessRightsTest = projectaccessrightsRepository.save(projectaccessrights);
        map.put("ProjectAccessRightsPrimaryKey", projectaccessrights._getPrimarykey());
        createproject.setProjectURL("hwyrBDG8WmIvC9AwZfCEoV6hdcIRNqVtKpUBLQQLBQk0IaZLJW");
        createproject.setVersion("i4ZcLXWrBpIoN083dvDRryMKz35RaHpH8I6GFlpPrU91Mtp0nb");
        createproject.setBuild("QJMtdQ32Wyg396J6oeOUafx6aAZ1bUTW4eiJA6Z96HPQVEZCi6");
        createproject.setProjectName("srdkTsModegiNRvyq29rq1tPogU3I0eJarE4dNUxDFyIBOVtJ8");
        createproject.setProjectAccessCode((java.lang.String) ProjectAccessRightsTest._getPrimarykey()); /* ******Adding refrenced table data */
        createproject.setDateOfCreation(new java.sql.Timestamp(1458211499225l));
        createproject.setProjectDescription("Xlu1Ymyww6OryB1DF1K90O3ZQaS1gKqsuvaV8tzT8qdVTd3VGN");
        createproject.setProjectShortName("QVbVq2McV5MIGLF999Ti1ivmsQZyaCNka6JvLHKkChX2ZVLarA");
        java.util.List<ProjectUserMapping> listOfProjectUserMapping = new java.util.ArrayList<ProjectUserMapping>();
        ProjectUserMapping projectusermapping = new ProjectUserMapping();
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setLastName("Gp0nUlNdrV0CUSu0IW8qZApWjt52Z08YRC29wCavlr5Vy8bUmQ");
        corecontacts.setPhoneNumber("QWhACn1XydjKS82EKgKH");
        corecontacts.setNativeLastName("mrvKTChMEELzhltrprd064Jx7XfQ2pPW5THOqo0Bx4hBZS7iEH");
        corecontacts.setNativeTitle("xgrj6pFEr4XwhIhQDQrzg0rrw8lHbyzIWmud8r6m849kTMVQMI");
        Title title = new Title();
        title.setTitles("vdKKx5Kf1DfqqvNTd2VoXSuVC7jjPpr4bT3ou9uyWDAICETuth");
        Title TitleTest = titleRepository.save(title);
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("opyiZ2GiwbqDnpg248ECxZhajn9CWhEzQyDiDT8Vq66J4je4Na");
        Gender GenderTest = genderRepository.save(gender);
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        Language language = new Language();
        language.setAlpha4("livx");
        language.setLanguageDescription("gU2Q4N8dhyAH9IuyECWjxo8oJVhCKJ3Fo1IpQKmn4DZfABndS6");
        language.setAlpha3("tov");
        language.setLanguageType("Nj0BEYW18PINhX40Q1XVLUNoCGTMUcYH");
        language.setLanguageIcon("eJ3qlTz0TiPppgoEELyel9Qr9B8xHpX0IYzxeT5TknelL47XIp");
        language.setLanguage("bfMdLB6Bw11dnSbvm4uAgW7Cgw4hYjc2eZ6UoBvfy4KrRtBAHU");
        language.setAlpha2("8H");
        language.setAlpha4parentid(7);
        Language LanguageTest = languageRepository.save(language);
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        Timezone timezone = new Timezone();
        timezone.setCities("eYGCsVMCtKsV1yiO7BQEdfhxtzOWJqDguhoxe9MBciuXSWS511");
        timezone.setGmtLabel("7Zl5DafYWR1yyYKdsBQcIfMG6A9zsnrUl0I8s8oPrG97RfEtEy");
        timezone.setTimeZoneLabel("HvjRMGkHyRdRTs5mWPkuxEH4vwGMhld6S1rlIqYEuSddJXvKf7");
        timezone.setCountry("OkppnzNdaqiTc8tEU4UlubpkmNHS6lLffbbTgEfhyHrWhky19f");
        timezone.setUtcdifference(2);
        corecontacts.setLastName("UEdLzZ3pR3gZOvIHiwYsduXVUroECgZIH789YBMGxo4HXFl5BF");
        corecontacts.setPhoneNumber("3WsxTQCVg7RQG1zgeg2A");
        corecontacts.setNativeLastName("3LW477LHXSzohHF7fRJMFDX1GO6wiO95Nfcdq6cKYyssPG5lMA");
        corecontacts.setNativeTitle("CSmdQwqlst34vgMxBTcCAX4kq3FoZBm7kRJyx0E80acvd7v1SW");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("wXg4wEtBfrypETAMVp7XcUfTRUEfCUlivWNChHuoiFoSPMpyVc");
        corecontacts.setFirstName("ejHTkqlsdx2ECOcWeUfQSkvRi3tn9yGd95XBWiH3znioklQoVn");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("R5z30lHF6bKwkk4MtKx1avaHgESOhMomyxy4c6rDgDWhjbjnFE");
        corecontacts.setMiddleName("RAUgY88g6RzM9Li7rF15KhLnGVZ60ism6JyIogUxOnIQNlJBbV");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458211499402l));
        corecontacts.setDateofbirth(new java.sql.Timestamp(1458211499402l));
        corecontacts.setNativeMiddleName("c9JCSRyKIxb1e2zeMVLCsHbjYt6Po7N3X7W5K107BAkq0dvcdT");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(35);
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(timezoneRepository.save(timezone));
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("XtR20vFTgleU7GSuV4iev73leKxBehDyH2FfaZZd5W2U9Kn9Rx");
        communicationtype.setCommTypeDescription("SWY13fyHwC2GhBu9Zjv7nXM7u7iT7cpUDxag1YleyIsFKnfsx0");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("eCUpMfiID2hPFySLqlCwKRK4umrJFNWM3YRvKFAW2fC2gKRXTF");
        communicationgroup.setCommGroupName("lqkecSyz5DGQgFnIlLyDz9QRO5iFc76JDMmFpkwqJBSSi0m7eA");
        CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        communicationtype.setCommTypeName("0cmMD7BiveWyJ1xIKDzKnXr2jrBfrdv9SybGLmB8M2fbohRvrM");
        communicationtype.setCommTypeDescription("uI12z0yqfT6nE5n0nPwqCfuaOrYqvzFESEeoidjp4IwiK8LG3t");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
        map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("5MwS5FycTWE0HB2mqDCbprQ8xZSr8xaPc4q5poSGWA0mpFgLvJ");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress3("XK8AAbUb7Ihgbs1DgHxsw2xu9RmDD4wtlzRolBmkFRhvEKsOhN");
        address.setAddress1("DBcb9cUgwKTu5I9gk3Lc2jT6GuDdAZmsR31C7e6ZIAWEwzc2ke");
        address.setAddress2("OBCaiOwTbx4wyYYU7MbB2g9dhgIKodhlBNCX5VEio3JBAFd53B");
        State state = new State();
        state.setStateName("MACKzzjbgjU7ODZ54N4TBvWYZqo2lc2atqPBirmCi9vxErxZ3R");
        state.setStateCodeChar2("qrW94bSmL26TTOCmFop5PjNotMv5zxIw");
        state.setStateCapitalLongitude(8);
        Country country = new Country();
        country.setCurrencyName("OIhzqIVTsMqaHcHr167pIQFf7OdDAOpHvdFrkTYo1knii1W8mS");
        country.setCountryName("FavlrnclCF0A3e5FY5VFOtcP6LkxQRK3KRKB11mFFc6kNiZ8SG");
        country.setCapitalLongitude(4);
        country.setCapitalLatitude(9);
        country.setCountryCode1("Cza");
        country.setIsoNumeric(11);
        country.setCurrencyCode("Zej");
        country.setCurrencySymbol("ucmt5A6Vtw17Rl3uE88hbg6aKrQCTFsV");
        country.setCountryCode2("XDi");
        country.setCountryFlag("K3tOvaZ4UuGEr1LPyH1F1ovBGzShWPmxVsQHHNJHTV7Ssq7pqK");
        country.setCapital("c3o62lUtaPc7ATA8N6rHo0VkKY3YVNAj");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        state.setStateName("IV9XvkDJFi1DvPBwXTRPvm5vYMMcZbFSwU3AdqUUVnD15v0Tc7");
        state.setStateCodeChar2("hgR9WvpvKKcP25V6pjJHd83M0iHYO63x");
        state.setStateCapitalLongitude(2);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("y7l1MKujLh1tRkqlAIpMcVdjCD2MBTLF");
        state.setStateCapital("BlYLoLgSDXS2lhGOhsvGGhb9uIC8ean6fK75Icaf8UapxEIPu3");
        state.setStateCode(2);
        state.setStateFlag("HkAOA7eKB2QovqxmgCUAUUeuvSpqvvJUBzaBd8jshnXte90Qsm");
        state.setStateDescription("2x9KR0KJ91h5a0KpLkKY87ULXtjXXwdDi2LrgsuMujM1fckgRg");
        state.setStateCapitalLatitude(8);
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        City city = new City();
        city.setCityCodeChar2("8X58061lxp0lXcNTi6G1CWJKhvN0UW1s");
        city.setCityCodeChar2("aegXik5ZJmhN7k72kZeuM0AW9Am8TpD6");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("L74GgWkVVvJ8aXIWtr7wtQcMRGxFlivWTumqiVOldCao3nxY9b");
        city.setCityCode(2);
        city.setCityFlag("ASjcMUyceQXqwUBsqT2v4645i0IxdmkrFE1IVlM05FReI4iIFT");
        city.setCityLatitude(10);
        city.setCityLongitude(1);
        city.setCityName("ln08SbpBNkHltWj8AgOdRnsJJoYedcvvEcbEkZhvdkl6KoWIF7");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = cityRepository.save(city);
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("ZioKjFhVUWtmjpppuJ5G9x1K7qnzPxFAzgsMoi1zxO1IREHjc4");
        addresstype.setAddressTypeDesc("cnwzxpoxpmgZEsgpRnyZPRBqP8IzmG8egPAqZnRM6xzcuc5dDP");
        addresstype.setAddressType("bTEe95oTvYv2hNgZywNV5fw28Aju0tUoQKFuj9OyWKN8GexA4N");
        AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        address.setAddress3("qUdzpuS9oQPjO8LHxzFfA2vQx46jyUjYqEtmMFMKUQ20tlEAau");
        address.setAddress1("JPc3souHNIDV3ScaBdXUyAtUQO6oVa7EM0lTEajmrAtr1ifQhA");
        address.setAddress2("AA64AzC3CAauWZfCa5Y5BJ5zegUpTNSAPfj3l01Xu58FTC98Bp");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("zZ1SWo8a3SHLvN5rfDJxTuQQ5VE49XgfrUd6eTJMG5mSG5g8CP");
        address.setLongitude("CjOVLKNUzpGc1TCOJz7PtnDEJKNX5NiWSz53O78NPbN1yA5FoE");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("bQezRW");
        address.setAddressLabel("SySpUQScash");
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
        projectmodule.setModuleDescription("h9Go5aTRCeEXqm12xi9TJL06jbcDJkr4TkOrU2ZUX0gUQYDhFT");
        projectmodule.setVersion("P9r8bXGwcV2ikqDRqzonYHUgRIxzRhaUolNKfV5wToceJGhjid");
        projectmodule.setDateOfCreation(new java.sql.Timestamp(1458211499151l));
        projectmodule.setBuild("pxVPYhx9Vhe7ZbjTjTlZREp3yoJzd0fu3CZ1kVmw1YawsEwFFl");
        projectmodule.setModuleShortName("ZkbTBPgEXNwPzRp2fhQG2kbQgibSTy6Eo0sW1ciqneBt04dbR9");
        projectmodule.setModuleName("mBAf1ufnxf2Boqr782O6s8gHdTCQjnquueqpy59sxyZ6xtY8A6");
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
        ProjectFeature projectfeature = new ProjectFeature();
        projectfeature.setFeatureShortName("E26g7PHubQb0M1czHfoSCfsWyXxmIBU3Y5xt7XCo1lOE1jl1L1");
        projectfeature.setModuleId((java.lang.String) ProjectModuleTest._getPrimarykey()); /* ******Adding refrenced table data */
        projectfeature.setBuild(2);
        projectfeature.setDateOfCreation(new java.sql.Timestamp(1458211500026l));
        projectfeature.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        projectfeature.setFeatureDescription("7mx2vn4hc4WHfVq5JOicL5X0OUSl6LWKVv15B38S7cMxTA3hwt");
        projectfeature.setVersion(6);
        projectfeature.setFeatureName("IzcygZ9oQ4kSEtqilGs6Ch5a3zUxGDOSyG0HJIewa3VpdJRy0O");
        java.util.List<FeatureUserMapping> listOfFeatureUserMapping = new java.util.ArrayList<FeatureUserMapping>();
        FeatureUserMapping featureusermapping = new FeatureUserMapping();
        featureusermapping.setModuleId((java.lang.String) ProjectModuleTest._getPrimarykey()); /* ******Adding refrenced table data */
        featureusermapping.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        featureusermapping.setContactId((java.lang.String) CoreContactsTest._getPrimarykey());
        featureusermapping.setProjectFeature(projectfeature);
        featureusermapping.setIsAdmin(true);
        listOfFeatureUserMapping.add(featureusermapping);
        projectfeature.addAllFeatureUserMapping(listOfFeatureUserMapping);
        projectfeature.setEntityValidator(entityValidator);
        return projectfeature;
    }

    @Test
    public void test1Save() {
        try {
            ProjectFeature projectfeature = createProjectFeature();
            projectfeature.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            projectfeature.isValid();
            projectfeatureRepository.save(projectfeature);
            map.put("ProjectFeaturePrimaryKey", projectfeature._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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
            org.junit.Assert.assertNotNull(map.get("ProjectFeaturePrimaryKey"));
            ProjectFeature projectfeature = projectfeatureRepository.findById((java.lang.String) map.get("ProjectFeaturePrimaryKey"));
            projectfeature.setFeatureShortName("fgG75UgZQ368dlhIzWE8lDNiQHLeCyiNsOh33WUI4M7oQfADda");
            projectfeature.setBuild(3);
            projectfeature.setDateOfCreation(new java.sql.Timestamp(1458211500241l));
            projectfeature.setFeatureDescription("rVhoxwgol6rGyH1i86f94AnAB4qfqxjVfQZOp1k3fFIfoU3Q9R");
            projectfeature.setVersion(7);
            projectfeature.setFeatureName("KlBLRKAEkHomBTBQOTLBeM5GXQZIecEQR2U7E4uiKIPPTJJkGG");
            projectfeature.setVersionId(1);
            projectfeature.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            projectfeatureRepository.update(projectfeature);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBymoduleId() {
        try {
            java.util.List<ProjectFeature> listofmoduleId = projectfeatureRepository.findByModuleId((java.lang.String) map.get("ProjectModulePrimaryKey"));
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
    public void test3findByprojectId() {
        try {
            java.util.List<ProjectFeature> listofprojectId = projectfeatureRepository.findByProjectId((java.lang.String) map.get("CreateProjectPrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("ProjectFeaturePrimaryKey"));
            projectfeatureRepository.findById((java.lang.String) map.get("ProjectFeaturePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("ProjectFeaturePrimaryKey"));
            projectfeatureRepository.delete((java.lang.String) map.get("ProjectFeaturePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateProjectFeature(EntityTestCriteria contraints, ProjectFeature projectfeature) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            projectfeature.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            projectfeature.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            projectfeature.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            projectfeatureRepository.save(projectfeature);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "featureName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "featureName", "EUuPcFCblSMLlGINiAmYTiGDfcavqh7O3VayKxyfLO1WDVsreT8vX6OUcc1FlL8dVUoBK90LyArZShNFpGB7FH0cTPuOKbCysITJSIKZR0gQBOEjuTjMwZGWM7l0GU5SE"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "featureShortName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "featureShortName", "abduWqknwtNSYsWdc22oRZUJNozbrCLaBd1yMh57oqoUgTHfpEcoC5RXjAUX9OI5W"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "featureDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "featureDescription", "XndT4UkJnFHY6O0f4s1axm4quz4pQW93jnHAQy9RwFhIR60jNw5oibhsUucdH9O5uHP8z6L2UDWAoIM1DxrTuV9p8MWo9kjGqiKov4jskVenITScDJh00bppr7IhEW5mYIgpbBuNwJL9c9cfHcHq7IRNQrolUBV11qQDWQROLhrlNO1ixFXQNFVdXzUhwSjwAmJxaanR1cumzxGKEaBTu6YeO993ws69s2bmf4WiwsQR0YYIKzjVVDFjLXz67P2F8"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 7, "version", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "version", 16));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 9, "build", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "build", 22));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "dateOfCreation", null));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                ProjectFeature projectfeature = createProjectFeature();
                java.lang.reflect.Field field = projectfeature.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(projectfeature, null);
                        validateProjectFeature(contraints, projectfeature);
                        failureCount++;
                        break;
                    case 2:
                        projectfeature.setFeatureName(contraints.getNegativeValue().toString());
                        validateProjectFeature(contraints, projectfeature);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(projectfeature, null);
                        validateProjectFeature(contraints, projectfeature);
                        failureCount++;
                        break;
                    case 4:
                        projectfeature.setFeatureShortName(contraints.getNegativeValue().toString());
                        validateProjectFeature(contraints, projectfeature);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(projectfeature, null);
                        validateProjectFeature(contraints, projectfeature);
                        failureCount++;
                        break;
                    case 6:
                        projectfeature.setFeatureDescription(contraints.getNegativeValue().toString());
                        validateProjectFeature(contraints, projectfeature);
                        failureCount++;
                        break;
                    case 7:
                        field.setAccessible(true);
                        field.set(projectfeature, null);
                        validateProjectFeature(contraints, projectfeature);
                        failureCount++;
                        break;
                    case 8:
                        projectfeature.setVersion(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateProjectFeature(contraints, projectfeature);
                        failureCount++;
                        break;
                    case 9:
                        field.setAccessible(true);
                        field.set(projectfeature, null);
                        validateProjectFeature(contraints, projectfeature);
                        failureCount++;
                        break;
                    case 10:
                        projectfeature.setBuild(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateProjectFeature(contraints, projectfeature);
                        failureCount++;
                        break;
                    case 11:
                        field.setAccessible(true);
                        field.set(projectfeature, null);
                        validateProjectFeature(contraints, projectfeature);
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
