package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.EmpInformationRepository;
import com.app.shared.employee.EmpInformation;
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
import com.app.shared.contacts.CoreContacts;
import com.app.server.repository.CoreContactsRepository;
import com.app.shared.contacts.Gender;
import com.app.server.repository.GenderRepository;
import com.app.shared.location.Language;
import com.app.server.repository.LanguageRepository;
import com.app.shared.location.Timezone;
import com.app.server.repository.TimezoneRepository;
import com.app.shared.contacts.Title;
import com.app.server.repository.TitleRepository;
import com.app.shared.location.Address;
import com.app.server.repository.AddressRepository;
import com.app.shared.location.AddressType;
import com.app.server.repository.AddressTypeRepository;
import com.app.shared.location.City;
import com.app.server.repository.CityRepository;
import com.app.shared.location.Country;
import com.app.server.repository.CountryRepository;
import com.app.shared.location.State;
import com.app.server.repository.StateRepository;
import com.app.shared.contacts.CommunicationData;
import com.app.shared.contacts.CommunicationGroup;
import com.app.server.repository.CommunicationGroupRepository;
import com.app.shared.contacts.CommunicationType;
import com.app.server.repository.CommunicationTypeRepository;
import com.app.shared.employee.DepartmentType;
import com.app.server.repository.DepartmentTypeRepository;
import com.app.shared.employee.DesignationType;
import com.app.server.repository.DesignationTypeRepository;
import com.app.shared.employee.JobType;
import com.app.server.repository.JobTypeRepository;
import com.app.shared.employee.Visa;
import com.app.server.repository.VisaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class EmpInformationTestCase {

    @Autowired
    private EmpInformationRepository<EmpInformation> empinformationRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(59);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488946109l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488946109l));
            corecontacts.setEmailId("LPVzrbcgjWefViXI1I6grgA2y45GTqD8jrUtv31A4X2JtolxPy");
            corecontacts.setFirstName("ERmiiX4WVqMZJaqEv2wHGuC3wapLbC0AJB9faEn2HlN9A9EgkI");
            Gender gender = new Gender();
            gender.setGender("4RnS50O0mW4woFMzgBFGsMICs1aaPA9JXJPrOxHc8AWVltG5Op");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("Qc");
            language.setAlpha3("mDQ");
            language.setAlpha4("Nwnn");
            language.setAlpha4parentid(11);
            language.setLanguage("vQM03puuFcSUPwlUeoLDtqqwwiAiuHimBsNVfXAVqwBgIICmfz");
            language.setLanguageDescription("UdSA1fLWUHG1rwSpFhkRPc2LvaQUEoEC09THkNwClApZVrpTpX");
            language.setLanguageIcon("gertm2JjNeeQW13pWU174Muudaq2cVOsCS9Vwh81XUiYyiSfQD");
            language.setLanguageType("Bf6TOYOEmFuqTHAF5bdsgxaiKF9K0wDH");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("AT1AJq2fCR1QDp1Bsmfq0SdfYdHBX5Mh0bHNPxHteYivyyUaxZ");
            timezone.setCountry("6fmRqjlCK8dP0YVmaGIJKXeKCHgHygRK9auS8PB7oWV8EvB9wS");
            timezone.setGmtLabel("vojCEQkHz0iz1dxC0zDsZj2Kn2k6xtzLR7rt3Q4ghr4X6yRs4j");
            timezone.setTimeZoneLabel("o9V5pkuK5ZIixSguBAGFtBeSYuSHd5JZKAsLbLYqC8j0iQfmQ0");
            timezone.setUtcdifference(3);
            Title title = new Title();
            title.setTitles("e0BtN3X66GMJ1b5sw0fOwiep7CCOQVsPiRBZo4NBNRxr0hF1Nw");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(124);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488946132l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488946132l));
            corecontacts.setEmailId("R01q4RtiWHZcoKHidlxiTZgBtUSFH9pA6a1D69HMEKbz5T3vKs");
            corecontacts.setFirstName("GTnWFWAuwbLtjKwZP785C8WaeAPsw1MIJvIrorety3kJXrILdo");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("BNqrf2lcMtsnW852JmIjp8VaMFIF5T1enB2Eg6LnRjWCD976Dw");
            corecontacts.setMiddleName("M80U9FJgXJl0j3AHxF3v8KU9Er8bpmFrpioQO0D7D1jImb0uFs");
            corecontacts.setNativeFirstName("Y0zAyuDADGcTm80bM5mYPHvx6BrqrYPOOhqXWiIVViMgjwSYmZ");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("8MmWcbLZVHVcmrQGj3k0oXXWKzZwJypo45ve9locnEHcEV2bLL");
            corecontacts.setNativeMiddleName("UszwuE1F1Dy6Gsyq2PPkEMX77zJWirVhuo5hfviOihWH6o4lq9");
            corecontacts.setNativeTitle("u7mXnCnja7QEy5g97v0LWYvyIWgPwAQgFjjH1l2ySFSozZpWct");
            corecontacts.setPhoneNumber("1k95VIS8ehGNNAUZNeAQ");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("asifkGyXDx4pXesugXZvdcITYPflmCu9imK2lERRrs7dJvbmTM");
            address.setAddress2("LyJJmrcWQsuNyNYlvvm9XAu6ulR1jYJ41JTZSRQshvUVvMfYKm");
            address.setAddress3("Zo1plYQ6i8oS89h7igHHPEKGDuQ63SxMQkOlyRJRdkOPRMeY2J");
            address.setAddressLabel("fiTQVjHo4m3");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("WIS2wLzrhCh1Dsk4vRUTUzxR9cYy1L8iU7Nq5wRo3ILXG66wwc");
            addresstype.setAddressTypeDesc("2O0TWMVJaTCzpQmtjBYijd1QrBmxrqJz51COSI7i5rLMdk5eit");
            addresstype.setAddressTypeIcon("sWlhSppkL8a6wPNGXbEWzXlcDClMD2vAjtFd0Adq3LGA8lnf7v");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("kwdzBosr4tKNech3KfdBOWIZdx5XPqR0");
            city.setCityDescription("MyXnxgHxjuKOfWZKTxfJGUtTWbBlN5YBTLhH1orW8E98Pg13Zw");
            city.setCityFlag("eK1zyPyM2kAXFXaR8dQisKSwnNKrpXNntWmMCAFvPYg0TKofYb");
            city.setCityLatitude(5);
            city.setCityLongitude(7);
            city.setCityName("0UiiwLa18VS0t20kT3kuSOEW0bw2mbXErJULY4LLlNrRA1ZKQb");
            Country country = new Country();
            country.setCapital("sgW7w82kxYhle52eZrjx5UxCoAGnhJ6c");
            country.setCapitalLatitude(10);
            country.setCapitalLongitude(4);
            country.setCountryCode1("55u");
            country.setCountryCode2("htJ");
            country.setCountryFlag("VE4H0Cg8KHQ928JlkTUiZqtkAr2xJwj5juwSI8DAGaBuwEwNyJ");
            country.setCountryName("OdT3B3wck1Fk2Rzgb2Y7pIMtie0LAYRqXctc7bZBfdBpAmvMkD");
            country.setCurrencyCode("DnY");
            country.setCurrencyName("PLGwWY6K5n3fBbVlx6s7bEKDPtrfwafhUQSbzbg6o6EqZwlVox");
            country.setCurrencySymbol("TSdCaJdjSCRvuJhPbyRUdelqUwi1HFWs");
            country.setIsoNumeric(10);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("YYFEltXYpVr7Cj1SMnF9DjTa3n85dZxdPYEZNcI60x4cjoou0Y");
            state.setStateCapitalLatitude(11);
            state.setStateCapitalLongitude(10);
            state.setStateCode(0);
            state.setStateCodeChar2("1ETkU8zGZHWxlMIDQ8lurqiCkI00u9bX");
            state.setStateCodeChar3("wMwlPunoVhtzKOtLOCO8XpEoJZ0HInDQ");
            state.setStateDescription("o50JzGy7maC1rnG89iDurWOa9PwsmMYYiExbvgqMe9EP1VFIjl");
            state.setStateFlag("gRAogE0DYz6I3sW8i9YENIJLVDDxk33xzGcR4YQL00tBvaGY6i");
            state.setStateName("7hksl7xotd2GSh582SvLHy9x6jUIu2w5Kxd8s1ygkqh7YAN3wH");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("ZxK48AcVvM0rRxW0KZNv4CK5C5DhQzEh");
            city.setCityDescription("c3X02qUe7TjuYknzTwaaJkCjLKEBet9Z1m6zhlU9tJUcnbiiwz");
            city.setCityFlag("okxXMfSupoXGxHhGMMs42hOPPfwMtVTJPVvnYuUkhiofXKFc4i");
            city.setCityLatitude(7);
            city.setCityLongitude(8);
            city.setCityName("VrV2C4vkNMvcl3s99DK4MvIs8PjHwVyupSIIqo7UCq9muRVtW4");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("Ux8ivjjty7G6tRmYv0CjWPTK2CjHDWLI0ccVEZpRujjLBuPMmP");
            address.setAddress2("KRpC1gp3pWHb9YPTi06MbBT7QeE7aECOPKgqwa7t7BAAEi1ybn");
            address.setAddress3("1PodwJAR2NwkMvfVvGkMyQPIqlE7TyvEDBDcfXs3hfWxJRkPw2");
            address.setAddressLabel("Wy1knVp3RQL");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("6TXTSTSV6qYPan92xG80O50Lb2hiiZZUby8gXjKj3yKLSrseku");
            address.setLongitude("VTL6Mcf63e8I5IW1wIwGHnUJKAxRl3K3zngYIXIrySPdVxp8kD");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("qUgcUC");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("6");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("0Phgmb01Q6jt0XrKceLcD9ivy2R3JHqQV2JzJqtxnIOKbXtMc9");
            communicationgroup.setCommGroupName("dMhTVBBDzyXPWkHJOmJj2MBwG7LXo2L3MLdE3KdvWEZTgSflgR");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("8g4lpCoBrfRvJy0HBKr4Mb9d2mvhoVo2bZsFGFPH8SdNRs5P2k");
            communicationtype.setCommTypeName("12bulaO2Bih5kSMzMnZXKCwwuxW1X37ivXFSWnR3v5hMTfSeJj");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("w");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            DepartmentType departmenttype = new DepartmentType();
            departmenttype.setDeptTypeDesc("SP82f7Fqw8aFGuJGN6tbLzhqvGxdZUyeBjYiM2kLmoNlhkU2p9");
            departmenttype.setDeptTypeHelp("gNBT2rukRmrMfWtehaE3SzV4kBccXqdZZpGvQZeF9eZgw3NNu4");
            departmenttype.setDeptTypeIcon("V");
            DepartmentType DepartmentTypeTest = departmenttypeRepository.save(departmenttype);
            map.put("DepartmentTypePrimaryKey", departmenttype._getPrimarykey());
            DesignationType designationtype = new DesignationType();
            designationtype.setDesignatnTypeDesc("Y3wt03RqHaUtjLlm5bRPhBQNsBXvyiSVAk1OxDKEwdp6GpKHmJ");
            designationtype.setDesignatnTypeHelp("9xkmkQISwaQeoI9rp3YVcClpW1YaaiMndzyrsFRlzeiE1JVebd");
            designationtype.setDesignatnTypeIcon("9");
            DesignationType DesignationTypeTest = designationtypeRepository.save(designationtype);
            map.put("DesignationTypePrimaryKey", designationtype._getPrimarykey());
            JobType jobtype = new JobType();
            jobtype.setJobDesc("qqECZGP8DAu7I9Mh1m9Ci6VpPxr29SCRe39JFiZ5Htzsyy3EjA");
            jobtype.setJobHelp("NgeAf5WaQNsrPHC4oAFqJiH4nXnthghSMDsu0DeWgkbcZhph7E");
            jobtype.setJobIcon("J");
            JobType JobTypeTest = jobtypeRepository.save(jobtype);
            map.put("JobTypePrimaryKey", jobtype._getPrimarykey());
            Visa visa = new Visa();
            visa.setVisaDesc("1ixkASQv0SDv0aHZmW6QGvOG3zRMJr0pOqaiH08arOqbV5P9Wo");
            visa.setVisaHelp("aBHP46KTeFh0lejY9rbG9JAJiM9814cyCIfCSV8ZWrXahJWiQo");
            visa.setVisaIcon("0");
            Visa VisaTest = visaRepository.save(visa);
            map.put("VisaPrimaryKey", visa._getPrimarykey());
            EmpInformation empinformation = new EmpInformation();
            empinformation.setCoreContacts(corecontactsRepository.save(corecontacts));
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            empinformation.setDeptTypeCode((java.lang.String) DepartmentTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setDesignatnTypeCode((java.lang.String) DesignationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setJobCode((java.lang.String) JobTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setpAN("3pykeeIE4j2xvyOeEi8TOmjAaq0EMmngQJhbV5GOvUwqdNmFHv");
            empinformation.setReportingOfficer("wcUp1CCKRrvFRU02XoCbpLPNZXQnRXT7m3Lxk5yqcQmFTOE9zo");
            empinformation.setVisaCode((java.lang.String) VisaTest._getPrimarykey());
            empinformation.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            empinformation.setEntityValidator(entityValidator);
            empinformation.isValid();
            empinformationRepository.save(empinformation);
            map.put("EmpInformationPrimaryKey", empinformation._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

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

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private DepartmentTypeRepository<DepartmentType> departmenttypeRepository;

    @Autowired
    private DesignationTypeRepository<DesignationType> designationtypeRepository;

    @Autowired
    private JobTypeRepository<JobType> jobtypeRepository;

    @Autowired
    private VisaRepository<Visa> visaRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("EmpInformationPrimaryKey"));
            EmpInformation empinformation = empinformationRepository.findById((java.lang.String) map.get("EmpInformationPrimaryKey"));
            empinformation.setpAN("KLit0QY4G6JCNaWltTsFIR8IT8zwsLb3OoaepJVuaEY5L5Bc5i");
            empinformation.setReportingOfficer("rlyy6OduSjZ1hTnDtZKJXlo4P14V6AtRWgLjPpGeHP0qCLaciO");
            empinformation.setVersionId(1);
            empinformation.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            empinformationRepository.update(empinformation);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBydeptTypeCode() {
        try {
            java.util.List<EmpInformation> listofdeptTypeCode = empinformationRepository.findByDeptTypeCode((java.lang.String) map.get("DepartmentTypePrimaryKey"));
            if (listofdeptTypeCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBydesignatnTypeCode() {
        try {
            java.util.List<EmpInformation> listofdesignatnTypeCode = empinformationRepository.findByDesignatnTypeCode((java.lang.String) map.get("DesignationTypePrimaryKey"));
            if (listofdesignatnTypeCode.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("EmpInformationPrimaryKey"));
            empinformationRepository.findById((java.lang.String) map.get("EmpInformationPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByjobCode() {
        try {
            java.util.List<EmpInformation> listofjobCode = empinformationRepository.findByJobCode((java.lang.String) map.get("JobTypePrimaryKey"));
            if (listofjobCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByvisaCode() {
        try {
            java.util.List<EmpInformation> listofvisaCode = empinformationRepository.findByVisaCode((java.lang.String) map.get("VisaPrimaryKey"));
            if (listofvisaCode.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("EmpInformationPrimaryKey"));
            empinformationRepository.delete((java.lang.String) map.get("EmpInformationPrimaryKey")); /* Deleting refrenced data */
            visaRepository.delete((java.lang.String) map.get("VisaPrimaryKey")); /* Deleting refrenced data */
            jobtypeRepository.delete((java.lang.String) map.get("JobTypePrimaryKey")); /* Deleting refrenced data */
            designationtypeRepository.delete((java.lang.String) map.get("DesignationTypePrimaryKey")); /* Deleting refrenced data */
            departmenttypeRepository.delete((java.lang.String) map.get("DepartmentTypePrimaryKey")); /* Deleting refrenced data */
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
