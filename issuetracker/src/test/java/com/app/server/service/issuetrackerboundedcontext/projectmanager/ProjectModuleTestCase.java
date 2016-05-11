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
import com.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectModuleRepository;
import com.app.shared.issuetrackerboundedcontext.projectmanager.ProjectModule;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class ProjectModuleTestCase extends EntityTestCriteria {

    @Autowired
    private ProjectModuleRepository<ProjectModule> projectmoduleRepository;

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

    private ProjectModule createProjectModule() throws SpartanPersistenceException, SpartanConstraintViolationException {
        CreateProject createproject = new CreateProject();
        createproject.setProjectURL("f5EofC3YIHye3wSWO5z8QVUXqm1gpcr40PoNNQYNjs3AXuYmjH");
        createproject.setVersion("qdTsqxJtCzs2zyQGFKLTDmPOAoz5zne82DAEwrYSK8hvXoYeu8");
        createproject.setBuild("XTbLSjbJUKuBvZhCGqsDkRpHmlOwfHN4CzfH6OGcJNaMsCFVt6");
        createproject.setProjectName("nP7w3fYrlzzGgIMz2EBhgbsmA8Xnyt9hrdlaBVOjB4WMdHoBpi");
        ProjectAccessRights projectaccessrights = new ProjectAccessRights();
        projectaccessrights.setProjectAccessName("ScL5npGgy3NvVhKhFiXgnQnXc4ITLYUdokpCb4yEckRA5xoqq7");
        projectaccessrights.setProjectAccessDesc("gNbdSUKdPO8XBN5Dh5FAsxKPBGs6HNsrBf8tMWNP12XnhFdhEp");
        ProjectAccessRights ProjectAccessRightsTest = projectaccessrightsRepository.save(projectaccessrights);
        map.put("ProjectAccessRightsPrimaryKey", projectaccessrights._getPrimarykey());
        createproject.setProjectURL("jQTRuDAYGDUi3Yx7FylPkJRxgkc6vubteHF3ilxPSaX9qYx3aB");
        createproject.setVersion("eM57Eq8lDUrNp1nDoss88Wy2PeggYBc9w9BI4JxqiInRIDGOm1");
        createproject.setBuild("GI6VPhU72EaGxG9bEBTmPU5nPlPpn8WgFmB7KH693O4CMeK34D");
        createproject.setProjectName("WEIi8lRVDFQOYoIVzKFhq3brVpf4ZeDEuZ380zTP8DS0J9ZEVs");
        createproject.setProjectAccessCode((java.lang.String) ProjectAccessRightsTest._getPrimarykey()); /* ******Adding refrenced table data */
        createproject.setDateOfCreation(new java.sql.Timestamp(1458211497370l));
        createproject.setProjectDescription("nCRC2yq2xlRk1wPS5dhTb8FQ1PitPU6r3J0p4hPBwpm5K7e9EL");
        createproject.setProjectShortName("mTytHqM4Y8HT6QHmGMstiePcly40V93Ma0v0trzD0Bh0eKoDD8");
        java.util.List<ProjectUserMapping> listOfProjectUserMapping = new java.util.ArrayList<ProjectUserMapping>();
        ProjectUserMapping projectusermapping = new ProjectUserMapping();
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setLastName("9QjrXTAXfXdJkFUbdlLAuNznhbWKVZm3UY47IhfAhPY23YWKus");
        corecontacts.setPhoneNumber("ZJhMSWVjWgGDf8bSHrPZ");
        corecontacts.setNativeLastName("b93m2qm0iBuwv79p19vAySNJVakEnEZ13H66NyoAtQSDDtVhR8");
        corecontacts.setNativeTitle("lXQqguU4oETNMIkA40JHsmsBKf4kpmMKugSOlAnLyFfCdRdSPO");
        Title title = new Title();
        title.setTitles("NMIy2ZP21SgeLEhl1e8QWC0p1sZcRE9RcgoCyhXxKdL2W6F1mh");
        Title TitleTest = titleRepository.save(title);
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("DiM62qQlV1e1dvLz2I5Ef8nlXPw6bWqxT6RnViZDuAKA7x0e9l");
        Gender GenderTest = genderRepository.save(gender);
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        Language language = new Language();
        language.setAlpha4("5j89");
        language.setLanguageDescription("tt3ijTnAIBVpDiZR2aJeJEe2MMycGn8h8t3yS4Abr8ROPBhXE6");
        language.setAlpha3("ViH");
        language.setLanguageType("UIDTDoT4J4F1AdY1iypQ8xr5mXWKh9GO");
        language.setLanguageIcon("JjkHcVa1Os23InAl6JwqlnRf2OszOHGyErs1hcDOxwTfd9MMpu");
        language.setLanguage("fGXLx0yv8KyNHquFunppkLrQMWF0VbtxJrtSC7qYrT65nCuUMx");
        language.setAlpha2("gS");
        language.setAlpha4parentid(6);
        Language LanguageTest = languageRepository.save(language);
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        Timezone timezone = new Timezone();
        timezone.setCities("MpxnUlEkf5LWYA1s4wfxxHRjczrONiV95PpQ852bS8WNfu75pa");
        timezone.setGmtLabel("GXHOPFQPZlEGxn3dSujruqjJdytalhBIkvoKTrYlXuJygjDpNH");
        timezone.setTimeZoneLabel("dGSB2IrFxPhIrgYdecLAcYKOa901tJJji3MaNdiRp2decIGc0W");
        timezone.setCountry("p8seVJemE5FpbZTg9VJQBboUSUj0lvxk4Fz6RIx2gbNVYIt0EK");
        timezone.setUtcdifference(10);
        corecontacts.setLastName("g461hmiPf1wMheZr07CiOXdz8iUYG6Lm2S0qQ8F78T74A0vjMb");
        corecontacts.setPhoneNumber("CGYdi2Lukkd2RTfbERG9");
        corecontacts.setNativeLastName("s8oFscW9ncc2pMnH0XgFrNvPMNlG03m77INdyq2mcEM6gSOTBC");
        corecontacts.setNativeTitle("wUkOsmgOzVGdb2aj2grSfxKZPiW9g1y1pPOMkHhQ4WFVV0fBNT");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("Mw9X2MRXtAjL0986OMQUDuGvMB73lQnFfPiMIowAU4hM6Lf2FK");
        corecontacts.setFirstName("btkE1dkB1Lmp25speLYTo0Y87QVCgFqhJYylDHZshDc1Qz2yCJ");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("cFh9SzJXPZHNyXzLzxMRYdwAQDIlBuvcUNnwyke6xiXMPDTmsQ");
        corecontacts.setMiddleName("MJTnVRYVr8Lsey56jFpsB9042NNdrdl0SGcTlwUmSFdDQeER0a");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458211497526l));
        corecontacts.setDateofbirth(new java.sql.Timestamp(1458211497526l));
        corecontacts.setNativeMiddleName("UB0QPITnHfVk86pN8ryNj9Y4RdJKsloWNUssj1J9eadOiIcpKC");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(110);
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(timezoneRepository.save(timezone));
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("ODfHdDis9eqKu54lZhUmvgsKC1VJXDbDGa1vm6zg1xi77qX3SF");
        communicationtype.setCommTypeDescription("9dw3Kd0TgYaSLPn3eJKV33wCgnmi94PsgjGAuk9B2f8bggvo2j");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("mfABU3oGc8D4mrADqErbrgMWpOSmVB2feoUQmdNFAFsInBCzcV");
        communicationgroup.setCommGroupName("kaEfCXJHSrnaTA804ZBQsaVOPf7J7ODv3fK04AWI99jVgx5ulZ");
        CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        communicationtype.setCommTypeName("UdqnLXgtFgAugURlPSgcyGWNSnQKfTsLmYhizzFhnKWI7j2EXK");
        communicationtype.setCommTypeDescription("1n5KexP9GFgwS69hG2GjqGSrtYp61SkdXXnmJRj0go41S0a9th");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
        map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("KJbnaGle8AgmD0hJ6W2xNIPfLpkXLgFnqiq0vdaldUn3PVgY97");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress3("Osl3Pyo9XNYFoBnucGi01Vpsagz2naRvxCc6wu7MVuTJsMLqR1");
        address.setAddress1("WL3gaEB0qYbmVFRNmiKj2Zixdyha7rZZjUlkDWmVErbnMq6UnP");
        address.setAddress2("gg4z6Y3q2BT5ihjD2WsTNZn3oD0h2ud8fsq0mActxXVCwUH39h");
        State state = new State();
        state.setStateName("G4cesu9BmcaQ3mUriEVpH6Fq5aSKHyN3LTdhViiq90IKHaOccW");
        state.setStateCodeChar2("PNLSO50zxGNL9vrm54dOttcm8ivRO1pl");
        state.setStateCapitalLongitude(3);
        Country country = new Country();
        country.setCurrencyName("p3Y0zgppAJxMDeq5LHRonn0qkLmJiUU3PTZKLf8rAatw9YUMi9");
        country.setCountryName("tglFHHdzTsCbjq5Zw1nOY9zkuuNOABxtf8VFrw0yGdDuBgFFS4");
        country.setCapitalLongitude(7);
        country.setCapitalLatitude(4);
        country.setCountryCode1("7hr");
        country.setIsoNumeric(2);
        country.setCurrencyCode("VOp");
        country.setCurrencySymbol("jIvfBj6YvYKRKkSUCqsm2hP1kkGO5gEC");
        country.setCountryCode2("eyk");
        country.setCountryFlag("GM9vEBJg2ZIhtnH35vujs9rbXCkB1dixnceSDwhkHR7QeDyHpx");
        country.setCapital("BrjHpgQ7FYJwmojTHPhmhJOVX8d7j11C");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        state.setStateName("4CldtJxb0oQfZhy0OW42osS2VuDduuoblO588x1jPIj8kDFmds");
        state.setStateCodeChar2("Ieg71gGhiJk8Q86zDAyGSnMZKb1e0mvg");
        state.setStateCapitalLongitude(2);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("70m6ApR7sv1mqMDn8td73E351d0fMWUX");
        state.setStateCapital("TYxk5vLtmscPCqpPyCIttCyYNHVRRbkbKpR1lkDpYZHRVJtBBU");
        state.setStateCode(2);
        state.setStateFlag("mBxt9b61DefGvNrRSUzyFsDUHPeOuhR73XDiS2g0pq1gjsyss4");
        state.setStateDescription("Kr1zr4WfZaNPROKbtoYa04TFL2GEQHAeCQbcBNEVVWiZX5xASg");
        state.setStateCapitalLatitude(2);
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        City city = new City();
        city.setCityCodeChar2("Ou6B3z5an2bS7f9g3p0E32Rqw6QgAUIa");
        city.setCityCodeChar2("tXgKZBYUib9mhMMbWvYZBP73KI09Wz04");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("Gz6z10gHA96lJCWvY6h7sclulWOxhtoe80RO77tY1xPVCiFN0o");
        city.setCityCode(1);
        city.setCityFlag("Pb5YmN3mUjlN6BhgWV3gpHpue5clMpYxrhjGX2AEeCsoFBLDGh");
        city.setCityLatitude(3);
        city.setCityLongitude(3);
        city.setCityName("JYSSsMOwJjZl0RpJ9nsDG6uwjTtINv6ZaJTWj9k8Bd1Cb4GwsH");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = cityRepository.save(city);
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("EW2gPR66V21mmHoKihvVnR9bi5BYV3mMeHveHCL90n5CPo7Xo5");
        addresstype.setAddressTypeDesc("J2ya3mSEca6aIKwMnST7t09nDHq12RifniIu74lV70ELR3EbQC");
        addresstype.setAddressType("kzXvzl6VMSmqjAClfd4KMnODRZfos3Ue3B2nMPKVijVbIotfyK");
        AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        address.setAddress3("2NtFiYhAI0EZFiUjb50lv1hOpP0sHAlzsIqbzPAWf8E511cno0");
        address.setAddress1("slvwNCUj6vRRytjHMgU0GBMB2kHVglHyg1RD5NLzuQ6sdALV0U");
        address.setAddress2("f6gj16MTMIvM0r8x0CmVXi4NKJfy72bB1ZvNHxcZ2qv0mYJEeU");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("Luz6gicLIDnGRwLj1Gzf5QdyrbLR8MKrqs8eMjye8u6xHGhRro");
        address.setLongitude("64FuLnb96xip0U83yvbkFrks4g8e7DuydAAPOKnXJgkYq5NO61");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("e14vta");
        address.setAddressLabel("6xP5vi6fZUg");
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
        ProjectModule projectmodule = new ProjectModule();
        projectmodule.setModuleDescription("DgHujhvheTIZnPpuQKjk9zHpzXnVxgxiu1I5DljEJcD1M6w8mD");
        projectmodule.setVersion("sxdgxqgXZTHyL6NTIr5CTa7qItV3Ih1SBz3eoR9hRQCy3HSKSA");
        projectmodule.setDateOfCreation(new java.sql.Timestamp(1458211497328l));
        projectmodule.setBuild("16yMdUAWf5IPrBbzgCTKLqESSblCg2TkIT31YMFPuO90Q4vXos");
        projectmodule.setModuleShortName("f4GLyCNESh0x1vWR2LruxIjdJenbrINTm4Xp0Awqp916U9PCjx");
        projectmodule.setModuleName("rTfFSx3HHgpkQMmAgwfChq6pTr7PPzL49paCy3aa3GC1Fwz36h");
        projectmodule.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        java.util.List<ModuleUserMapping> listOfModuleUserMapping = new java.util.ArrayList<ModuleUserMapping>();
        ModuleUserMapping moduleusermapping = new ModuleUserMapping();
        moduleusermapping.setProjectModule(projectmodule);
        moduleusermapping.setIsAdmin(true);
        moduleusermapping.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        moduleusermapping.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey());
        listOfModuleUserMapping.add(moduleusermapping);
        projectmodule.addAllModuleUserMapping(listOfModuleUserMapping);
        projectmodule.setEntityValidator(entityValidator);
        return projectmodule;
    }

    @Test
    public void test1Save() {
        try {
            ProjectModule projectmodule = createProjectModule();
            projectmodule.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            projectmodule.isValid();
            projectmoduleRepository.save(projectmodule);
            map.put("ProjectModulePrimaryKey", projectmodule._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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
            org.junit.Assert.assertNotNull(map.get("ProjectModulePrimaryKey"));
            ProjectModule projectmodule = projectmoduleRepository.findById((java.lang.String) map.get("ProjectModulePrimaryKey"));
            projectmodule.setModuleDescription("FyKILlFPR6oMHWfJ9pPD9fKJcQxdI86sxcL82g0YoAzQ0uASCs");
            projectmodule.setVersion("yawgvBQMZ9Z9rp3TBmWXamk9jotIt21ct8FnO9YSgJklCGpJSZ");
            projectmodule.setDateOfCreation(new java.sql.Timestamp(1458211498068l));
            projectmodule.setVersionId(1);
            projectmodule.setBuild("u0KjEsmfeKxMXqd74A0SfFgmDKfri6Y5zEoOFdITqNPnP0eCMy");
            projectmodule.setModuleShortName("qD7IMohFPYsssejYx2n1csptYfi7fQfMcmsSczN8kXAZOTZ6wj");
            projectmodule.setModuleName("FNCmIJGqVF5NROrpBIzopgwi942Q4yCL4qwOH2qlGfVZ7k5HmO");
            projectmodule.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            projectmoduleRepository.update(projectmodule);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("ProjectModulePrimaryKey"));
            projectmoduleRepository.findById((java.lang.String) map.get("ProjectModulePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByprojectId() {
        try {
            java.util.List<ProjectModule> listofprojectId = projectmoduleRepository.findByProjectId((java.lang.String) map.get("CreateProjectPrimaryKey"));
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
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("ProjectModulePrimaryKey"));
            projectmoduleRepository.delete((java.lang.String) map.get("ProjectModulePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateProjectModule(EntityTestCriteria contraints, ProjectModule projectmodule) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            projectmodule.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            projectmodule.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            projectmodule.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            projectmoduleRepository.save(projectmodule);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "moduleName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "moduleName", "YGqrYRfJ2kOocG2IoXSubPO9u5tOglpXy3Hc4pv6g4nUgGQl2r7W2okr2KNEmF2tKpV95Tkg1xIqfJzcLGkLuD20oKxChCo3O84kxFxcNl4YkilbuJUTdhvhgf2uESmGx"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "moduleShortName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "moduleShortName", "F2zf76HGIGEcsfAN6mGo2i1gKgSxNvD73NWIhEBScPYUKA1NVKioWJX6Dhk7v94oO"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "moduleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "moduleDescription", "6HunyLPTAVksLqYSqNmyfzREmH9SpIWYMOqxqsk80uLWCAVTONd5jTxKtudeOalYWNFebZJvnpIeaVkoSwHXruj6AbIU2REA2sQiAO0jXPAD2dIUXl1xaZyAmvKzY2Xy73COBJBk5UokK5GVRz8B5NLELUDgBiKwcLzZNxEgpgwk9lU5FMbQk094POgrXiXMJcGZjfPYaQvl4qO8rR31SlShJ4wqZXa6lJBJzybv84Rn3shXLGvyKSRADqPYwam2L"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "version", "I0wO52bHNKa9y1xdOcwoqU1ZPXOuMzAc6jcjSKiNjUuVC0I9h0rD3RNcxuWm05oYv"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "build", "GBDFUPSwnzjNsf16AfmgiEQiyAHRmGTYigx9tysmyuggN2ht15E4YWzifbtgWg4mh"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                ProjectModule projectmodule = createProjectModule();
                java.lang.reflect.Field field = projectmodule.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(projectmodule, null);
                        validateProjectModule(contraints, projectmodule);
                        failureCount++;
                        break;
                    case 2:
                        projectmodule.setModuleName(contraints.getNegativeValue().toString());
                        validateProjectModule(contraints, projectmodule);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(projectmodule, null);
                        validateProjectModule(contraints, projectmodule);
                        failureCount++;
                        break;
                    case 4:
                        projectmodule.setModuleShortName(contraints.getNegativeValue().toString());
                        validateProjectModule(contraints, projectmodule);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(projectmodule, null);
                        validateProjectModule(contraints, projectmodule);
                        failureCount++;
                        break;
                    case 6:
                        projectmodule.setModuleDescription(contraints.getNegativeValue().toString());
                        validateProjectModule(contraints, projectmodule);
                        failureCount++;
                        break;
                    case 7:
                        projectmodule.setVersion(contraints.getNegativeValue().toString());
                        validateProjectModule(contraints, projectmodule);
                        failureCount++;
                        break;
                    case 8:
                        projectmodule.setBuild(contraints.getNegativeValue().toString());
                        validateProjectModule(contraints, projectmodule);
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
