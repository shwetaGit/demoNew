package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.PaySlipRepository;
import com.app.shared.payroll.PaySlip;
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
import com.app.shared.employee.EmpInformation;
import com.app.server.repository.EmpInformationRepository;
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
public class PaySlipTestCase {

    @Autowired
    private PaySlipRepository<PaySlip> payslipRepository;

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
            EmpInformation empinformation = new EmpInformation();
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(107);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488966847l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488966847l));
            corecontacts.setEmailId("Rn1Dgb7U28RFzD1Ek2rCiqnr6Gh1BDzI3CQqtVKHYqUjHOuqCn");
            corecontacts.setFirstName("F786IPafBBdQjibeksoohjauxpysuX1SL6t6qlXefwSzAekkH2");
            Gender gender = new Gender();
            gender.setGender("bq55rGauJwZyzAWs9CrPu8W5kdsvEHVEG6BZgsk3dvPTNZipL9");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("AT");
            language.setAlpha3("KZd");
            language.setAlpha4("0lVr");
            language.setAlpha4parentid(5);
            language.setLanguage("4vwTOb2JMpXbDHR8U8ry8NhHrYjOFuZqiKuUSlyOCHt5iMtiPY");
            language.setLanguageDescription("bgzXacXeobuAbTjgBdeSxpZDH8W7RJ1rPjIiNieT3AbIwo1t8S");
            language.setLanguageIcon("S3i0tB4Ev3qOFbIijfmaKQTj4Do6WFMqC26ULgjp9sgrcnL7BR");
            language.setLanguageType("h6Sc3YEFW4XLyytxHDv3f8ci6PL8j2yX");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("qSUudiWKl0y14u1qhEgkx1mU2HLAAE1ndCJpz6F37Gkz5RB9Io");
            timezone.setCountry("VM1V2kw5GOBH4jeijtMxFaawWi7iE4FMSXNiBKbznEn0eqEszY");
            timezone.setGmtLabel("CmqqWeRqa56pAtSUSl2AbeIomUTKo52hxUPLywGb8utzcKnxhH");
            timezone.setTimeZoneLabel("aMlRUUqqFDEideVD8Sb3OJv1ldUzcuCEdZiNpWNcWIb4b1B1mM");
            timezone.setUtcdifference(11);
            Title title = new Title();
            title.setTitles("lKE9Az7Uif9c96RPYFCz3EblVNLXio5Wxorc1A5tGLLS2RBj6n");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(30);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488966863l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488966863l));
            corecontacts.setEmailId("MbGJLvE2sGnuJX4MvxgFKN6auRlc7jE0hiy3TewfeZnwFSJerG");
            corecontacts.setFirstName("CQBfyw4ezbYfwlK1Z66d0o0gwZG9sotRwru2KAWRFboivdeNV3");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("h6IF1mi9geL7ltm2yOwlIO4fSy5ZTw6f12cNpmy0K5zRH6QIZW");
            corecontacts.setMiddleName("eX8BdPAYyJstzec3m1mqMjundecn84DEubB2XVbDo5PwIdBNiZ");
            corecontacts.setNativeFirstName("WzGbDt9YUUNd5mvcPTrVPkhnwfp5Md5VnJOAswVhJrfi8pfbPQ");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("U6Bp2RKKy0fCaYxeSczWq0mjon0ivn3umZTrFGmCB3Yxl65Yc6");
            corecontacts.setNativeMiddleName("bA3LZpTsHGWiy3jjVwREAmvGYfVBKMpdFuQ4krfT5vP2dms9yk");
            corecontacts.setNativeTitle("prNTgCac3XyLOWhCHhvwwwyxT531VUKmYn7GW49gperNZO3934");
            corecontacts.setPhoneNumber("02SqpRj5wPJQt9PEEL7I");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("JvcemFCeSoMOoA3Zx2CWq8NP3EzoegLJogRaSJqIbhnor93I9O");
            address.setAddress2("aCcG0cGRg5szXCQaCNdqbPcmcUgbjQXXFoeChNPb9Matb3TlL7");
            address.setAddress3("IZ5KWZWyvAbli7RiGhnwRgdsx4rbDIlg3ORUFitJOC7M0l7fJO");
            address.setAddressLabel("Ykvu0fDhNDA");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("9YxJ8CKgiFHz3T8l5gx9lpmNUxULmnwqkctTJOjrwm8EWg1mbq");
            addresstype.setAddressTypeDesc("OVlpCfWdeCD6MZfU57JIstl1Ocou9PNoB3T7OGDzQceupzpUKI");
            addresstype.setAddressTypeIcon("ywKMhuVdq5zQP5WQP3cQ1EIxvrsHfDV4dSDimTRSmxSG5jyjgT");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("JxIB8sIjcJHHaE2VdRo2yEI8jhu1E8VJ");
            city.setCityDescription("Xr0RoEG44kfCeu4Bfz4f6NAQDwlG6U4baPUQlAfu82z5HDL8wh");
            city.setCityFlag("7Zv8k7sIuy1ReJt75Kt3GjMxgY2y975NRsRE261IVJlapDjBRp");
            city.setCityLatitude(9);
            city.setCityLongitude(9);
            city.setCityName("1GYxnPhb1XKnkxSVvoN44DQheJPB7Rznd2T0y7UWNhr3CtVq9P");
            Country country = new Country();
            country.setCapital("WjnMcEVDMJpW8yFBaSS6PCz5a88DUapY");
            country.setCapitalLatitude(7);
            country.setCapitalLongitude(7);
            country.setCountryCode1("jPn");
            country.setCountryCode2("3Ll");
            country.setCountryFlag("4zU44BxH8dS5SGmWsiqjLlDLGHXUqr7KCKOO6Bs57nWpoF3YEd");
            country.setCountryName("Re43Icvj0w1fJdUfuESTeMRjLPNED2qJJkQCFpJ8GEBYMOzoIx");
            country.setCurrencyCode("ob6");
            country.setCurrencyName("vR2Bk6UNS6EYTrvCA6blgVcHjvFmkOxodfkYcKlQYIEQUcMAAi");
            country.setCurrencySymbol("oO7bCXRAqcQSaAWjhYju4UDqyniI7RvE");
            country.setIsoNumeric(1);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("et2zFzAKuSzBdt5mc8y9IDHgs6u9jr72fJQIH1QKwqyHtePtD6");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(2);
            state.setStateCode(1);
            state.setStateCodeChar2("7UA6eyisVQ7Hga3jIkRsParyOR7EO4yH");
            state.setStateCodeChar3("muvwC97dzPIEQ53rCY8MpqFpE6fnnpWG");
            state.setStateDescription("fLXiJLpaZoTF63t07TeQOamLp8WYTuxFxaU9sAIFaPupS6HB87");
            state.setStateFlag("SEN6q5tDywS6xeMCBP7vZLnGcumKTw5jj5u2A01YaeAYbZ3zuM");
            state.setStateName("mueWnLgiYBZzlZ109VcY6ifUL2pGJfNV9JH18RAiLfsKOcVyK9");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("tR8F2oGU6F43l1X9oC0r9cMNCMzPsDWK");
            city.setCityDescription("ZaR7Qp420nlwZWcWcSWuVH6olewc9vmlspM1in6zttNSm2OmnQ");
            city.setCityFlag("wcCvlDGbxoFbOnADVJgUPlCvE3uHql5gcFYvnCWwZrByqfohaT");
            city.setCityLatitude(8);
            city.setCityLongitude(7);
            city.setCityName("VVHt2beJ69vsRBH8cP2ccY9RBHi8glyiuLYsW3mmfePU0241Fc");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("VFtxOwb0q77E8eAskEf8JAu2CCXB3XFmY7QPoBENVWNJA9w0Yy");
            address.setAddress2("MnRPgZOOErPvs2FPGvScarijRuvWaHHF9g003tiIHJc9x06fPf");
            address.setAddress3("nlpbnvPoRTzXBUAXIAWdEu3qoMKcZ6VNB7QMYMR9KKU52c7wvU");
            address.setAddressLabel("WjkKI8ifzZk");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("MsHhJJNSxJ5pqveQxYThvO15Bvz9UulGrbd2b5Buhu7wu1o9Yt");
            address.setLongitude("n76G5T0G0UADPvFNS4ejPRCjGDgTJeCs7D91I33HhboGseeERZ");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("nmRWR0");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("G");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("hm3yZviJkbZeWzx3BKWPvg9JQoRRzALJTCW5m0gdIFB6TriXSG");
            communicationgroup.setCommGroupName("7bAVfpAlSz0YtdR82H5H4vJxohLjxrKztHnNIWewMSL4k9YsH1");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("q274LfVR9G2iPWrLLCcYS9wg7N1Devvp4DMaWgGSAF6h5sTpoH");
            communicationtype.setCommTypeName("iUv2raOUKt0eDztWiA845CIGE0lMkOoxGI66aYQdMCxUz49wPl");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("2");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            DepartmentType departmenttype = new DepartmentType();
            departmenttype.setDeptTypeDesc("aHSoVG2b8wft1WEQEfcRhdKBdQJNbhyBKggMLT77BzzqwHWApI");
            departmenttype.setDeptTypeHelp("3bfaJed7u63yvtC4nuXHMtCrWNNwmpvbywZmMo2KsTnngSldUw");
            departmenttype.setDeptTypeIcon("W");
            DepartmentType DepartmentTypeTest = departmenttypeRepository.save(departmenttype);
            map.put("DepartmentTypePrimaryKey", departmenttype._getPrimarykey());
            DesignationType designationtype = new DesignationType();
            designationtype.setDesignatnTypeDesc("Ik1I9LpS8Tk6H3gWPLoEkQdEh36EVOLpcsUAh6qeX3YsWitoDn");
            designationtype.setDesignatnTypeHelp("g4QlV2i45zrcYw7cEKywEteHWAbqYqmDRne4Jr3Iy3TRndpnTN");
            designationtype.setDesignatnTypeIcon("p");
            DesignationType DesignationTypeTest = designationtypeRepository.save(designationtype);
            map.put("DesignationTypePrimaryKey", designationtype._getPrimarykey());
            JobType jobtype = new JobType();
            jobtype.setJobDesc("EGsTyC1zzShwWpRtm9zzVu13Bxmg3h4xedX0W9tfw0Yz7ovnPE");
            jobtype.setJobHelp("5ckdq6bst6U4ABJBi3wn7gqM3tiwa1PAPo6bQ4BArrqc9Kcife");
            jobtype.setJobIcon("q");
            JobType JobTypeTest = jobtypeRepository.save(jobtype);
            map.put("JobTypePrimaryKey", jobtype._getPrimarykey());
            Visa visa = new Visa();
            visa.setVisaDesc("zUwqIqG4bSMJyLXi6fgtDcS8RqSlUzRD1czPEOUwLmGeLEpbWH");
            visa.setVisaHelp("abEGFK3X1nCdDVESp7D5BRYk10ja8lmyzGCXkNpwYnGfwHEgdp");
            visa.setVisaIcon("Z");
            Visa VisaTest = visaRepository.save(visa);
            map.put("VisaPrimaryKey", visa._getPrimarykey());
            corecontacts.setContactId(null);
            empinformation.setCoreContacts(corecontactsRepository.save(corecontacts));
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            empinformation.setDeptTypeCode((java.lang.String) DepartmentTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setDesignatnTypeCode((java.lang.String) DesignationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setJobCode((java.lang.String) JobTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setpAN("RLDxZ60CRS37pVrSzQUpGT75fkhP9K5oagpZVlC03qwoK8XzGb");
            empinformation.setReportingOfficer("GuULUSrOb4YusjAFzn8hHRl3wtkmi1Mx3GrLEh4JzjHRTWGB4Z");
            empinformation.setVisaCode((java.lang.String) VisaTest._getPrimarykey()); /* ******Adding refrenced table data */
            EmpInformation EmpInformationTest = empinformationRepository.save(empinformation);
            map.put("EmpInformationPrimaryKey", empinformation._getPrimarykey());
            PaySlip payslip = new PaySlip();
            payslip.setBasic(12.34);
            payslip.setConvenceAllowance(12.34);
            payslip.setEducationalAllowance(12.34);
            payslip.setEmpId((java.lang.String) EmpInformationTest._getPrimarykey());
            payslip.setHra(12.34);
            payslip.setLop(12.34);
            payslip.setMedicalAllowance(12.34);
            payslip.setMonth(3);
            payslip.setSpecailAllowance(12.34);
            payslip.setTakeHome(12.34);
            payslip.setTax(12.34);
            payslip.setYear(2);
            payslip.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            payslip.setEntityValidator(entityValidator);
            payslip.isValid();
            payslipRepository.save(payslip);
            map.put("PaySlipPrimaryKey", payslip._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private EmpInformationRepository<EmpInformation> empinformationRepository;

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
            org.junit.Assert.assertNotNull(map.get("PaySlipPrimaryKey"));
            PaySlip payslip = payslipRepository.findById((java.lang.String) map.get("PaySlipPrimaryKey"));
            payslip.setBasic(12.34);
            payslip.setConvenceAllowance(12.34);
            payslip.setEducationalAllowance(12.34);
            payslip.setHra(12.34);
            payslip.setLop(12.34);
            payslip.setMedicalAllowance(12.34);
            payslip.setMonth(8);
            payslip.setSpecailAllowance(12.34);
            payslip.setTakeHome(12.34);
            payslip.setTax(12.34);
            payslip.setVersionId(1);
            payslip.setYear(10);
            payslip.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            payslipRepository.update(payslip);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByempId() {
        try {
            java.util.List<PaySlip> listofempId = payslipRepository.findByEmpId((java.lang.String) map.get("EmpInformationPrimaryKey"));
            if (listofempId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("PaySlipPrimaryKey"));
            payslipRepository.findById((java.lang.String) map.get("PaySlipPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("PaySlipPrimaryKey"));
            payslipRepository.delete((java.lang.String) map.get("PaySlipPrimaryKey")); /* Deleting refrenced data */
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
