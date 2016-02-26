package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.SalStrucFinWiseRepository;
import com.app.shared.payroll.SalStrucFinWise;
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
public class SalStrucFinWiseTestCase {

    @Autowired
    private SalStrucFinWiseRepository<SalStrucFinWise> salstrucfinwiseRepository;

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
            corecontacts.setAge(85);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488964033l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488964033l));
            corecontacts.setEmailId("nNuTBHQ0i9NLIQc2AeOooAWFAhvAne6ixZBJhyqjlonzWxYkoB");
            corecontacts.setFirstName("QsaCzcjE25i5jUpjRWLyPfusoZanrYYItwlKcLEAIHMalwAeAM");
            Gender gender = new Gender();
            gender.setGender("shxMxuO25pWZG1uaQaL6QQXkfLuBqTiv4bXBN6PHeLvDUduI71");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("qy");
            language.setAlpha3("Ts4");
            language.setAlpha4("uCqj");
            language.setAlpha4parentid(9);
            language.setLanguage("pBOrteMUL5GMRp3iQmPeoUPquMJqPujD5hWfZLH7vlqMNVXyqz");
            language.setLanguageDescription("7QXbDkjtbmm8Ts4IIx4jvTS0FxxeoBEmlWqfmAKFMC0bxmqYMm");
            language.setLanguageIcon("l56qbUyqr6l7KFfRVDf51PspVU0TZTmx64VANlxf8bAiju1rze");
            language.setLanguageType("rBqn9ZdDTtAAwvd6KBY0UcPF0HUIowFD");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("42SAhG3GgVT6roen5Xd5lhqmDUpMuk5JPKsOWT5PJ19ght2KFW");
            timezone.setCountry("BKxDvhQIeREutfBs6rKYVbmdIukW683Q8Ahh73sEnsar3V12j7");
            timezone.setGmtLabel("gtUGWO552JjpoT6YNXDyPCOZ8TrqGsxTiLOOIktStwORvk9AcF");
            timezone.setTimeZoneLabel("A879w0gM4l5zs3Nyh7qV4Oe64Hih3BTsYFfkXoOGcUJH4Tzc4D");
            timezone.setUtcdifference(10);
            Title title = new Title();
            title.setTitles("IOtHUs9tosyuZxR1ITkQHYC6BERgyqEuZbFYtOYErU6kQZGeSg");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(79);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488964045l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488964045l));
            corecontacts.setEmailId("xdoN4dho8fh66Y1UrYmp7avX2kE1JcVDIYl0pb3Qj3rzgNGOHu");
            corecontacts.setFirstName("XZSON5AZXgAnaj8C8R7Dwb6TBV9xHAtFCST1gE97hUmNp4l9G6");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("10ykItjixrrrbBsezxaAZmG9bv9C8WfiAw27qgZiJMgkyzHDnZ");
            corecontacts.setMiddleName("alhkEnihAKQR03GgB4PKljP7yJdvZCn70t7xGlnY9JvZlPl6Ue");
            corecontacts.setNativeFirstName("6USONYeMdjSJV1hFEsixU8j6MvTJ74X1mZjyol4DuG6wK9ptI3");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("FKFun5dRtFunH5VWyversQ1mTpQ77EX0MfcHiSS3LNRicG14X0");
            corecontacts.setNativeMiddleName("2MDvAmSaQzGQIT925NCCw5USt9tdTDPPoQIm4xszxZK3zK4UGs");
            corecontacts.setNativeTitle("JYAS9E9qDodqb8OPJsgrCU5HjP4WASLoUbkt3nf62GyhKv7ba1");
            corecontacts.setPhoneNumber("bon6zXlatplGsEI0iUwq");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("BEHenhfLf2uTyfdSUGT7p3p7h0ii2JlnwJHKe1Ustqt3eCGbQx");
            address.setAddress2("xIJnvLnnZDYSugjyE5WQvoj6JFDPBOtO2YSFRTV4nu913Mo0cU");
            address.setAddress3("OgN72URWmlZ3p1AixpoH3RUqBPcKbUvM9yaNKp6rINoWyOCwM0");
            address.setAddressLabel("fjQdFK4Wwo5");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("pAsvQensGcFzpANQ3EZmXrHQfm0zbIQ6MG8E0aAoqC2DhHVyTr");
            addresstype.setAddressTypeDesc("xrCz6yG37c3pBHxmhidXjQz3yR6EabPKz4WKpzPO6572BJWn1r");
            addresstype.setAddressTypeIcon("8qG7gpmBONanmbn6xgAZVlDOWLGF7cxIrTtMz1znPmsHlhetkX");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("zAXfOa7pVUEnGLlp1aRa22B4CiKk8MLz");
            city.setCityDescription("KD3CG3IWliDbNqRCl2aZ5gfHaLztEoAZ7tp1MtLCCertHhh8r4");
            city.setCityFlag("2pvPSUGVDfePuMGmsVRu5qOHJfzgxOdhZ0kR2NQBlC7tV2scF0");
            city.setCityLatitude(1);
            city.setCityLongitude(11);
            city.setCityName("EsagLwjgA1HtjWbHzqFuEFG0lZ5lQB0l1zpyLqhxv4AGon2TwM");
            Country country = new Country();
            country.setCapital("dz2O2BGZMvQIQdKpzundWQ3uMqOafSnp");
            country.setCapitalLatitude(6);
            country.setCapitalLongitude(3);
            country.setCountryCode1("CDu");
            country.setCountryCode2("Rkv");
            country.setCountryFlag("FavVpw2b5rlNzUNNrotseHbt1P8xOunyopGucHUeN1FkjyD87r");
            country.setCountryName("n9J5XGDbqBbs9JfznCrTt9z8UclqYil94XQiR8xlOpwRqxRybP");
            country.setCurrencyCode("qBT");
            country.setCurrencyName("ss7Td2x0mR3g4xd1Dfq2GnnILVbE5adbde3B6wfBpwsQ1RKcqZ");
            country.setCurrencySymbol("Rr625Z5Dl1T3naZfWyJR2pwR6T4NdYfx");
            country.setIsoNumeric(2);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("l4FB1NAKHaJNSmb6Afa26YA4dY50LWYXf4pPG8BrN4NnsRjuRB");
            state.setStateCapitalLatitude(7);
            state.setStateCapitalLongitude(8);
            state.setStateCode(0);
            state.setStateCodeChar2("3BLVCJYwGngZkrRcMzWo72SfVWvgClYj");
            state.setStateCodeChar3("DxqIsdPtLZKtszlOPzVcHhtg7SRcbibR");
            state.setStateDescription("GWlo7pO1XCCHYJWis1badv0vef053410yghdSjBNkkWZzaXzdE");
            state.setStateFlag("IFMrsTUlNl3v08TL2sxm4qsSCXYwPkgqTjkvaJJ9pAShRMp5Uz");
            state.setStateName("1hHpnDBnuK72tLNFHUEmFCMZIXprDHMtG4k4dVlG2pjt7RA1JF");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("AJm26pRXuLMGK3m3gN9dGURuAA45I6Mg");
            city.setCityDescription("NsqHvfQzaITKGNIbjzSCRME72YmkbT6wWWxWM0pBbrjp0WTlPw");
            city.setCityFlag("kXhaHDnRSGf5dy7O79INM1Z8tzwSvDCm60k88LMk7VfmSu6M1P");
            city.setCityLatitude(9);
            city.setCityLongitude(1);
            city.setCityName("TszXlIh5dphjnYXVWZetqWHVFFQw1GdKUHa2MZeL8mDnN6X622");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("JKy5SYWPfkSzTiokt1eHuIbY9muLROJ2PeCBKNuoFTc52xUAsv");
            address.setAddress2("T9B3Y8pGy1086lhCg9SLgjp0e3KwbXy8MZ3iaIouG1RU44W4rU");
            address.setAddress3("GVRX6AyAT4EXN3y4qW7RyYKnijXLzM06R5zVDGzdjHCv2ZItJz");
            address.setAddressLabel("gO5CeIctR5p");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("Bxiy0yemW4pwArSIFSMEaQVNwKsyuVgcMFhFlC71xydf23ixiR");
            address.setLongitude("do6YzSncOyP1vvlZaoZliSbbrLCh95zHICvQz9woJ9Xmazfe1I");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("Dy6tNT");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("z");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("ZjPU0dv9UnO3Rcla3Jw7PNoDurJlxRtIBNW00L0TgtlkxexM56");
            communicationgroup.setCommGroupName("wBworJ1G0vu1PasxK9VNBYvKH1ItLuezaDYMZMkhqb9PcQjhSA");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("3qJd10GZeW11kLT2ZroDBak5W6CSkxxwzdEbSjXez41WDLeRQU");
            communicationtype.setCommTypeName("eVy51Egw5ATBL1uVeaeRG8HybxY1sPLnZ6E8P7Ek8beGIbmHjo");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("C");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            DepartmentType departmenttype = new DepartmentType();
            departmenttype.setDeptTypeDesc("WOfIm7bcG06eoTBW0dHZulb0i3ogOLVRvuIH8EYW8VBo9FyCrI");
            departmenttype.setDeptTypeHelp("PC3E3Pgmyy9yJWa5xNV3C6By6IEaAf3hvAItG9gkNPsWv8v1PX");
            departmenttype.setDeptTypeIcon("n");
            DepartmentType DepartmentTypeTest = departmenttypeRepository.save(departmenttype);
            map.put("DepartmentTypePrimaryKey", departmenttype._getPrimarykey());
            DesignationType designationtype = new DesignationType();
            designationtype.setDesignatnTypeDesc("8XYWSJzLSaNCW5qT0gcqDlqW2kf80i5a47smJNmyrqY4K9Jji1");
            designationtype.setDesignatnTypeHelp("OkEigfhXnDN8d6TIpSG3tpUOszje5hGuAWpHndyVCb0z3P0RJz");
            designationtype.setDesignatnTypeIcon("l");
            DesignationType DesignationTypeTest = designationtypeRepository.save(designationtype);
            map.put("DesignationTypePrimaryKey", designationtype._getPrimarykey());
            JobType jobtype = new JobType();
            jobtype.setJobDesc("aumKtkUQUFDTtvI1o3vNcpPqiZzBCmi1Bc5td3SLw0oCtZFImT");
            jobtype.setJobHelp("sxXX8vJJwpX1Aq6jUn5peTVkrrW4E2ailXakMIZbdS4BqckEdB");
            jobtype.setJobIcon("H");
            JobType JobTypeTest = jobtypeRepository.save(jobtype);
            map.put("JobTypePrimaryKey", jobtype._getPrimarykey());
            Visa visa = new Visa();
            visa.setVisaDesc("RXToFDAulCEvjly7mNUxWnWLHcAkpuSHH6fqfqzenog4uL92SC");
            visa.setVisaHelp("X7tAxx3EvQcmzzZlzMlIjdfiOXrU8JXMrY1EE7M48Tv7XyU63O");
            visa.setVisaIcon("V");
            Visa VisaTest = visaRepository.save(visa);
            map.put("VisaPrimaryKey", visa._getPrimarykey());
            corecontacts.setContactId(null);
            empinformation.setCoreContacts(corecontactsRepository.save(corecontacts));
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            empinformation.setDeptTypeCode((java.lang.String) DepartmentTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setDesignatnTypeCode((java.lang.String) DesignationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setJobCode((java.lang.String) JobTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setpAN("keCtJSywBhxYB5aIDtVrfcVDu7vAcAkvg29dw0yiUW1nsSkQwN");
            empinformation.setReportingOfficer("CyZDPIc9BotZD5cCR2MUgC1vAGNT9yz77r4PDeOmwrOHM67HUT");
            empinformation.setVisaCode((java.lang.String) VisaTest._getPrimarykey()); /* ******Adding refrenced table data */
            EmpInformation EmpInformationTest = empinformationRepository.save(empinformation);
            map.put("EmpInformationPrimaryKey", empinformation._getPrimarykey());
            SalStrucFinWise salstrucfinwise = new SalStrucFinWise();
            salstrucfinwise.setBasic(12.34);
            salstrucfinwise.setConvenceAllowance(12.34);
            salstrucfinwise.setEducationalAllowance(12.34);
            salstrucfinwise.setEmpId((java.lang.String) EmpInformationTest._getPrimarykey());
            salstrucfinwise.setHra(12.34);
            salstrucfinwise.setMedicalAllowance(12.34);
            salstrucfinwise.setNonTaxableAmount(12.34);
            salstrucfinwise.setPerk(12.34);
            salstrucfinwise.setSalaryDrawn(12.34);
            salstrucfinwise.setSpecailAllowance(12.34);
            salstrucfinwise.setTakeHome(12.34);
            salstrucfinwise.setTaxableAmount(12.34);
            salstrucfinwise.setTotalCTC(12.34);
            salstrucfinwise.setTotalTax(12.34);
            salstrucfinwise.setYear(4225);
            salstrucfinwise.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            salstrucfinwise.setEntityValidator(entityValidator);
            salstrucfinwise.isValid();
            salstrucfinwiseRepository.save(salstrucfinwise);
            map.put("SalStrucFinWisePrimaryKey", salstrucfinwise._getPrimarykey());
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
            org.junit.Assert.assertNotNull(map.get("SalStrucFinWisePrimaryKey"));
            SalStrucFinWise salstrucfinwise = salstrucfinwiseRepository.findById((java.lang.String) map.get("SalStrucFinWisePrimaryKey"));
            salstrucfinwise.setBasic(12.34);
            salstrucfinwise.setConvenceAllowance(12.34);
            salstrucfinwise.setEducationalAllowance(12.34);
            salstrucfinwise.setHra(12.34);
            salstrucfinwise.setMedicalAllowance(12.34);
            salstrucfinwise.setNonTaxableAmount(12.34);
            salstrucfinwise.setPerk(12.34);
            salstrucfinwise.setSalaryDrawn(12.34);
            salstrucfinwise.setSpecailAllowance(12.34);
            salstrucfinwise.setTakeHome(12.34);
            salstrucfinwise.setTaxableAmount(12.34);
            salstrucfinwise.setTotalCTC(12.34);
            salstrucfinwise.setTotalTax(12.34);
            salstrucfinwise.setVersionId(1);
            salstrucfinwise.setYear(4757);
            salstrucfinwise.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            salstrucfinwiseRepository.update(salstrucfinwise);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByempId() {
        try {
            java.util.List<SalStrucFinWise> listofempId = salstrucfinwiseRepository.findByEmpId((java.lang.String) map.get("EmpInformationPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("SalStrucFinWisePrimaryKey"));
            salstrucfinwiseRepository.findById((java.lang.String) map.get("SalStrucFinWisePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("SalStrucFinWisePrimaryKey"));
            salstrucfinwiseRepository.delete((java.lang.String) map.get("SalStrucFinWisePrimaryKey")); /* Deleting refrenced data */
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
