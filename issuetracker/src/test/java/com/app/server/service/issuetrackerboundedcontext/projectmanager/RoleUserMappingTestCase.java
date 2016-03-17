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
import com.app.server.repository.issuetrackerboundedcontext.projectmanager.RoleUserMappingRepository;
import com.app.shared.issuetrackerboundedcontext.projectmanager.RoleUserMapping;
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
import com.app.shared.issuetrackerboundedcontext.projectmanager.ProjectRoles;
import com.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectRolesRepository;
import com.app.shared.issuetrackerboundedcontext.projectmanager.IssueVisibility;
import com.app.server.repository.issuetrackerboundedcontext.projectmanager.IssueVisibilityRepository;
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
public class RoleUserMappingTestCase extends EntityTestCriteria {

    @Autowired
    private RoleUserMappingRepository<RoleUserMapping> roleusermappingRepository;

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

    private RoleUserMapping createRoleUserMapping() throws SpartanPersistenceException, SpartanConstraintViolationException {
        ProjectRoles projectroles = new ProjectRoles();
        projectroles.setRoleName("fEpPoeG5mymCoiNHMSApyjph3RjP8EcpRzNrIQiu9wWuKwXYH0");
        projectroles.setCanAssignRole(true);
        IssueVisibility issuevisibility = new IssueVisibility();
        issuevisibility.setIssueVisibilityName("Goeq9FEW3qMXH0kJQLdtoxsm8cTn8u4wXQnOr10JubMNSX4f11");
        issuevisibility.setIssueVisibilityDesc("JIdeA3etvGiHiQ9bmXaQRY5t4jHHIFrvNegdiO4FQEi24KWO2C");
        IssueVisibility IssueVisibilityTest = issuevisibilityRepository.save(issuevisibility);
        map.put("IssueVisibilityPrimaryKey", issuevisibility._getPrimarykey());
        projectroles.setRoleName("hY05Ji8pJQltUyFPTnVd07qCwUubgYfnLsEanYksoPmVYI6cEo");
        projectroles.setCanAssignRole(true);
        projectroles.setIssueVisibilityCode((java.lang.String) IssueVisibilityTest._getPrimarykey()); /* ******Adding refrenced table data */
        ProjectRoles ProjectRolesTest = projectrolesRepository.save(projectroles);
        map.put("ProjectRolesPrimaryKey", projectroles._getPrimarykey());
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setLastName("vEUrMbrgmBq37kRxaAxoecqXwtOsDYxQbjVwzawjyjM75g603W");
        corecontacts.setPhoneNumber("GpaHHsfGT51M753cgZQ5");
        corecontacts.setNativeLastName("Ljx7C6FybkurYbkZhIeMpYupUlMRIIJFL8s6yevhgKB4sbGPvC");
        corecontacts.setNativeTitle("w15Umb3QRWj8mC5rsIUlLMzwRGB1i0IUGNYQnj94VXlbNLPzsJ");
        Title title = new Title();
        title.setTitles("9mW73LinL5jb8v4eXZZqpM1zFE2GYZMku04VNr3g0LICuJDJIS");
        Title TitleTest = titleRepository.save(title);
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("o0NuH8Gn0aOEriMUV7QaXflbxq59sh8GPJHjztn0sE4dTEcfWZ");
        Gender GenderTest = genderRepository.save(gender);
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        Language language = new Language();
        language.setAlpha4("ROnJ");
        language.setLanguageDescription("idaxNij74K0j61hWJ9bz6RkCgVGieznNjaBU46F2HOBgQRXeaV");
        language.setAlpha3("f3D");
        language.setLanguageType("AklWDk90oY3nAoFkGXdXbppoeIAHXcv9");
        language.setLanguageIcon("c1WI55C739inwRNBRD5HAae0haODtdmkGt4WkYyHKqtqXF6522");
        language.setLanguage("gIhbrfAMz98TgkpAGteWld0eKsBw8tfkDqFganRuolNp3ioxD8");
        language.setAlpha2("06");
        language.setAlpha4parentid(6);
        Language LanguageTest = languageRepository.save(language);
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        Timezone timezone = new Timezone();
        timezone.setCities("NsXKgTfRnPi47yiSxCeZ6Wi6lNhoz5bzZa9OTMUm1bc2RtfBNH");
        timezone.setGmtLabel("VWyzCbuF5adQEArj17zEck2ZlWOhrS8pltHEO99igZcTt0Dmtw");
        timezone.setTimeZoneLabel("RO4XPbB3Q4wbaQTecvVJgPRCXoQ0dPghiiZiG5VnKJnFZeDLd9");
        timezone.setCountry("5khrATf5M5DVgKqGl7xu57ZF94lmnsz7MLmcRYQ33R3kTJpKLJ");
        timezone.setUtcdifference(8);
        corecontacts.setLastName("9vVSgBm4iFpdYLJqiptuTSxEM18q9cYJZCxwlKJTYJyNv2O4r6");
        corecontacts.setPhoneNumber("GXrfY3WFCVcip8m9rac9");
        corecontacts.setNativeLastName("WhCeFwpJ4tvJaDXaro2DbyLAoQHvnRyZfbwJvfylSxHi3QDZxK");
        corecontacts.setNativeTitle("5PkI4uIo6efsE1BrRr2DQ60PmUxBXlm9c0xOF0KEZWhtKFWt7c");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("peuCLUqKTdMYBDKANZxhcNo8sggJbcE2DkKkDTuH6d3cLCVAUm");
        corecontacts.setFirstName("lpVi69ITX3Z3oIo2uhNAymMAVKs45rJy0cSSM3pZEBB6coFgfX");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("XDrX5rmT3i1dWm0lbED60yQETHF9CR0CvlCtQlQrK2dWmvfY2X");
        corecontacts.setMiddleName("QPrNm4XT7K9jskfIoeTsvBoGFbcxRjsiIkFWDRU6aHAFTkP1vv");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458211504039l));
        corecontacts.setDateofbirth(new java.sql.Timestamp(1458211504039l));
        corecontacts.setNativeMiddleName("N6B90g7XbxSC35hgKDelu9fTyaYh1om0l5EPmFeEzT6tze0mnC");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(99);
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(timezoneRepository.save(timezone));
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("KiJoigx5BbvjxT7URg95pVjpxYBc1B6pnDq8GfrFFZXgBg5zlD");
        communicationtype.setCommTypeDescription("4uf32logCRP4hyRmGtHHS3Jw2tow5XKa8MptZymzrUk8OXy1hZ");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("yvV4Yyvi6TCxBwwnSQJ1h8Z7ht8oa526ohc315Z9UbIg4JpnBE");
        communicationgroup.setCommGroupName("vUAxB61ClUTlpibHm2KV3mUDbzIYhjSHv3CihiZ4VBXs2wtvvv");
        CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        communicationtype.setCommTypeName("e4fwtP6Chzc8m63BWRtS1Blm4WR3IQmCyAuX1kTwTf4TFPCTGf");
        communicationtype.setCommTypeDescription("VCOQiG5GMXNFJ0MKYbPtI65MSZzzpi4v5YtrF2VOEYTGiRP5ox");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
        map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("WqemM71S4JqibnlPX0C5PYicZalUEzRvuj6K8h9PzH8rit7Wy7");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress3("NGLDnGyDLXPQ3mS0gr5Hvjj9hxXwooFlt9eWTjXaJbg5fmBWJq");
        address.setAddress1("3dz6JKRZv4TRtw2nbadi2IFt1i1jLihv23oziq447PRjrWkokb");
        address.setAddress2("v3OJUsCbAnJ6hKiR0fAr6cgoaojdC5KuoGQTFLx1MCJagML9HM");
        State state = new State();
        state.setStateName("7gk9B4L6mrdcW3SQJBpkMiORtvuTVzaJcfOX3MQy4dFtYcEcn3");
        state.setStateCodeChar2("KY16foGYXtviIAIglnF5HfkprECMlBNV");
        state.setStateCapitalLongitude(10);
        Country country = new Country();
        country.setCurrencyName("EiojqyJlII9Z3n3qoTzmlJqDyw5HShOKCE9lgd6zSIPauW7Jgr");
        country.setCountryName("gjUaKlxe5nq27g2W5mDFDDaEEc3ewFHathQMYsBwpJvNYacClo");
        country.setCapitalLongitude(9);
        country.setCapitalLatitude(6);
        country.setCountryCode1("6h5");
        country.setIsoNumeric(3);
        country.setCurrencyCode("vMh");
        country.setCurrencySymbol("jaW4PeMmKzDfaXZBgI2i4AqWDghztZBc");
        country.setCountryCode2("qGb");
        country.setCountryFlag("QbjGAd54GwvL8KTcLG7R7gdYWUrZM3V68kqjkazNy7OQrTgYGd");
        country.setCapital("iUzLbpCsofw5vMgkQujrkgRywBE2lH5s");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        state.setStateName("6qMw6KH0sh0P2XA5Z0l0dZaokPEUNE6nYfQpAckZLVZbYVkPBj");
        state.setStateCodeChar2("4nOeAaphpn8li0c4RXzaby69f3aDgNTI");
        state.setStateCapitalLongitude(10);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("HI2nkOYklSN0qW294mcxne2ppkIzq6K4");
        state.setStateCapital("U9H6K6qvISvMJiE8YhQlmF6CAhSQeh5acNsNunEq77hxfIkAqa");
        state.setStateCode(1);
        state.setStateFlag("8B73PxmJfLGn4uK3O2zHwWuRvDc0pDTAROthnpM8ygqTvLVRno");
        state.setStateDescription("z1MFhOmYoQghKiQCmNDjSAUDl592bvU0K6EMm4gCixHW93m0xn");
        state.setStateCapitalLatitude(11);
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        City city = new City();
        city.setCityCodeChar2("mS1So7RH9MNZQJbp7WJVp7PvqBaDZXLe");
        city.setCityCodeChar2("pp2UMKnJERbqjwEVprMeZ79LuOSxHw1n");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("D0v12bW9CXfmjxNTJ5Tpt9Lps7QEdcnkemXXD6k4xab2FKeiP5");
        city.setCityCode(2);
        city.setCityFlag("allgdsyX0KpbZqCib60dHqnayKhuUUTaTAiMHrB3tUD5bShqLA");
        city.setCityLatitude(9);
        city.setCityLongitude(7);
        city.setCityName("J5cnink4J4qc9eVOrffDnCrzeDM9EufJ5tGUqQj8ljQhD75BRn");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = cityRepository.save(city);
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("l3fR9L2YnN80zF5cO5BwaiZP1yEO3DVn4B5xzaEmkRzpTuUgvQ");
        addresstype.setAddressTypeDesc("27dmuYsCaPiazxyWACzGfrOPuImepznqPPCQevo4nplBwit8xE");
        addresstype.setAddressType("Kz0Y8OBlRZVUXc5EYkW9criUvwFSqeGwuHaUXIzMU7vyW2lZfs");
        AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        address.setAddress3("SGWNKp1GSyGUGZPwnVzWIPHo9DuHRnRJ14qwKGH1XLo0CY0rgi");
        address.setAddress1("OnQLWXMG2nyeDhIxKBgOmHtBkkHc1uEStPBtBlSVtz9EqyWJX8");
        address.setAddress2("4O8cHr7ZydujjARxnDsYspuP0Xtiyhq2iGpC4bsWVcT2C3oWMO");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("qR0JaN1RBX0NDwHZkSwXK4MQrLdxqyUkgbeRQIW31P9LvDoIpO");
        address.setLongitude("4NBAt8nZgiAf3SBWaykY5qyM9hdUr07FAyQaNTTkjF3spXHYEW");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("F7G0IU");
        address.setAddressLabel("dnA7AuJxuQo");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        CoreContacts CoreContactsTest = corecontactsRepository.save(corecontacts);
        map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        RoleUserMapping roleusermapping = new RoleUserMapping();
        roleusermapping.setPrjRoleId((java.lang.String) ProjectRolesTest._getPrimarykey()); /* ******Adding refrenced table data */
        roleusermapping.setContactId((java.lang.String) CoreContactsTest._getPrimarykey());
        roleusermapping.setEntityValidator(entityValidator);
        return roleusermapping;
    }

    @Test
    public void test1Save() {
        try {
            RoleUserMapping roleusermapping = createRoleUserMapping();
            roleusermapping.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            roleusermapping.isValid();
            roleusermappingRepository.save(roleusermapping);
            map.put("RoleUserMappingPrimaryKey", roleusermapping._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private ProjectRolesRepository<ProjectRoles> projectrolesRepository;

    @Autowired
    private IssueVisibilityRepository<IssueVisibility> issuevisibilityRepository;

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
            org.junit.Assert.assertNotNull(map.get("RoleUserMappingPrimaryKey"));
            RoleUserMapping roleusermapping = roleusermappingRepository.findById((java.lang.String) map.get("RoleUserMappingPrimaryKey"));
            roleusermapping.setVersionId(1);
            roleusermapping.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            roleusermappingRepository.update(roleusermapping);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RoleUserMappingPrimaryKey"));
            roleusermappingRepository.findById((java.lang.String) map.get("RoleUserMappingPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByprjRoleId() {
        try {
            java.util.List<RoleUserMapping> listofprjRoleId = roleusermappingRepository.findByPrjRoleId((java.lang.String) map.get("ProjectRolesPrimaryKey"));
            if (listofprjRoleId.size() == 0) {
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
            java.util.List<RoleUserMapping> listofcontactId = roleusermappingRepository.findByContactId((java.lang.String) map.get("CoreContactsPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("RoleUserMappingPrimaryKey"));
            roleusermappingRepository.delete((java.lang.String) map.get("RoleUserMappingPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateRoleUserMapping(EntityTestCriteria contraints, RoleUserMapping roleusermapping) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            roleusermapping.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            roleusermapping.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            roleusermapping.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            roleusermappingRepository.save(roleusermapping);
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
