package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.AttendenceDetailsRepository;
import com.app.shared.attendance.AttendenceDetails;
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
public class AttendenceDetailsTestCase {

    @Autowired
    private AttendenceDetailsRepository<AttendenceDetails> attendencedetailsRepository;

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
            corecontacts.setAge(29);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488952567l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488952567l));
            corecontacts.setEmailId("7XA2ce6x7Cgk15DiVgvl6GfyUf2I6rPJSDojvO51j85amPMdw3");
            corecontacts.setFirstName("UWkDsef1wUVBgnpB1B5pNSHpJQwrcabEPefF4hxVuCHC9gSEoo");
            Gender gender = new Gender();
            gender.setGender("aRcliHPbyqboajmz9tP5VrNX1KEgcyA2dug4o1Ew8ZZ2Xe7iDK");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("CS");
            language.setAlpha3("wtx");
            language.setAlpha4("TZsF");
            language.setAlpha4parentid(9);
            language.setLanguage("x4awRh3KR4XOPvtT6cs1RXMTimEU1ap0aawEKnhgzimT75OuUh");
            language.setLanguageDescription("fONm35kmVobkyBuCzpyl8Rh4ZlRiuvKDU9pYpVso65jel2Xqhu");
            language.setLanguageIcon("XqrKiSXPhSkLKaXvhTp9acMMdmY12GfVZQ7JQnqmlb5yTyNlO5");
            language.setLanguageType("LoIIZOqHquwhLbrWT1ThTcZF2OYHotlb");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("Qij6KcPc6VwhqTmyqIE9V1r4oYwunQfETyi3stlIcceFKIrk3y");
            timezone.setCountry("4owmDbDeR9UTK445mqf8f5hbvfwpkVwc5aBlAer2YUhZQUobYd");
            timezone.setGmtLabel("KyLlr7DGjPLFMRAYGXl2eTNf3HQMzds5HtQQt5QDNa5CIhF0YK");
            timezone.setTimeZoneLabel("qHDO9VUE281VR5CHlO522Bm1oDrkDripMFsqKafZVwBd3KZtv5");
            timezone.setUtcdifference(8);
            Title title = new Title();
            title.setTitles("bdIwdfeTL33JKrjmNr9sVENXJktdRyrRIrIXvtx4GC5Bzse9yZ");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(95);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488952579l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488952579l));
            corecontacts.setEmailId("8FTDDriShmskG4WuOSW89DsmffCWdE4Dxuat7rUeVxVjNRdHi5");
            corecontacts.setFirstName("82z76opVasD0J8TtJwGtHg5aBf1K9vDIZ6j8XmSqYYVIpZ5f6x");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("K2bAdrZZbvY7cM8Snr57JCbbepQkhQ1eJtNWtbPtS08dcRRRFv");
            corecontacts.setMiddleName("8RFxdGdWXTRUJVMXIWKbM3vt2QtqV5q7vSUsTDXyARHveRDBr0");
            corecontacts.setNativeFirstName("IGAeXuWEQoiCc7MH40HPG74sE6eTJ3mPIF862m8gJwQSg8ssMK");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("UuCNW0j2f1phQrAtqfga3elfouLkKosMzdvkr1T6ZOnQiApj1p");
            corecontacts.setNativeMiddleName("pX2S9lxk5CDHJx9se3KGqfBq15GvovWS2Clo1tYaeTDHdb93Am");
            corecontacts.setNativeTitle("bYYXKFfU0K7yyoSTbgLgtA0ntFzuOu03oHUszRwDpIIN1sGAoE");
            corecontacts.setPhoneNumber("HVRICIfGdn1zawBm1fxe");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("Co2ydR04fCrxSevH1jGPNJKFMpp5bYjgSAAutmwLbQ4ft1a0ZJ");
            address.setAddress2("HNtuPaDXkf72U3DQsMKU9MNrOE90TrB0f41fdGmSAknsQSwJH8");
            address.setAddress3("W3AVpXDPLzJqTqSQ11wzvK55sBJRYG9RkiZ4faMe3rcRT2wlGS");
            address.setAddressLabel("TVyD7lX4DJf");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("qWChumGxIsWO3c5WEORySzxnuCXIfLubveSGA0S3bfOhn7tWnE");
            addresstype.setAddressTypeDesc("7aVoIL6v2zPxqEsnholj3KgAFa4Vrv4VzkmRg8kipSSGyoMTsF");
            addresstype.setAddressTypeIcon("vDI8sSjnKHeUEvkoKG1SFyUxH4TENu7FwG9eeHZURzs9zUpNbV");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("38fEuoD2dVHoxvolTj5cKG6hEZiqDrtf");
            city.setCityDescription("DmC09qxKRZ5a0xeQGDhgnEUXwnFZnXCkXNWB2XMEbBsJl9kliP");
            city.setCityFlag("KLhyJtVs2e5OKuscHmZ3CJn1aj7NUFHsXK4xF2LHZIvroqmXjn");
            city.setCityLatitude(6);
            city.setCityLongitude(3);
            city.setCityName("jyz9EpZ1dJn0Jh76ezjsZEAxS368J97dRE4iM1mvdJYQuh20ON");
            Country country = new Country();
            country.setCapital("95b9on7yeXJCdQwIx3jLlSj3xWK6AwYw");
            country.setCapitalLatitude(7);
            country.setCapitalLongitude(9);
            country.setCountryCode1("T4d");
            country.setCountryCode2("U02");
            country.setCountryFlag("Sn8eCbiYWVIXRKLhwEZw5ul1Dv03cjxiI9jM3iWdR7qARE7tiy");
            country.setCountryName("x0E2lWbd5EEy0MHPSzPEXCBp86sv4iXQQrrjNyVrFhRNdzj0oZ");
            country.setCurrencyCode("ltU");
            country.setCurrencyName("NRQhwU3UlCxQ4F15i9J8vx6pBSEOgOzQvyn2mdB2MoDShsqPb6");
            country.setCurrencySymbol("XRe8ANsBZdGrQLG0AuCWzWDi1kDtsAZ7");
            country.setIsoNumeric(3);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("mnCWwtr8aFYRA2IcCP09mOQk4jNCvQlaeDNNWzGsMwA3AZ47yN");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(11);
            state.setStateCode(0);
            state.setStateCodeChar2("abMU04W2xBGSGgxRtlizeKWhKoPWoHEd");
            state.setStateCodeChar3("6rh2FTUE93yNhvNJ7O2rAStP8Uk57SuX");
            state.setStateDescription("R0tc8L9KEZn3Ps1aXCGl8np3wcnW1hrHn3sGlzrvUplm8x8wPV");
            state.setStateFlag("rfnYh3vkQL3hZe43JqEi1wp76YjPfNDI1dbriYfIVW0aYS2vTQ");
            state.setStateName("mEyGFiY5FPe1NhuDWMQW0T9pytKO3Q2nriHuG6GntVq4fUzYs6");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("1UYEjMXsBwzyFpmZcho3gEJ0RUQLaKXt");
            city.setCityDescription("ZWo80zHxxRogK053xooWc1EIok3fpV4GyiTR7ZO4WFb7L8hRfb");
            city.setCityFlag("Ym6xFt5EzkDYh1xxDIszpXp8CpuMXN172KeQbDrEs6mR3Y4Zmk");
            city.setCityLatitude(9);
            city.setCityLongitude(1);
            city.setCityName("w8KDiXAvspANfo4zHfJ0rOfrLTpzHIqL1HBMM493D9bkpcaSY3");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("FP9jFX7tAWmKvphjxe9LJ0ZvUXaxptIduoWY6zPJcOwCVIIfy9");
            address.setAddress2("Kvf3LRmCJ3znsyOkGw7QgnAWcYM5XRKtSktTZBlyvmCZEGzTLk");
            address.setAddress3("abOQR8iKYnyJllfbiUsNXbJFsDotS4539nKNsXgNgpXbGi0hIA");
            address.setAddressLabel("w2J7Nfy14Ng");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("Y2ooLAu3DXqx46WQOt40L8Ou07mSoVJb56ulwhd8rShY1nRhhw");
            address.setLongitude("heKLUGUwoyzQGOrrQwuG0OMveSVNUhca08u5aLLJr2VCReyUdS");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("Pb2a4u");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("7");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("LYrYaOJlUiZ8kPNAGZtBX0andelPPUkNXKb0fQOjPVkiLOonm7");
            communicationgroup.setCommGroupName("BqEEKsgvCbx9HxMU0iBfjZtL6iFNrzMM4zLRadLdFLWj1SAuJ0");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("zB60HcggPUCsQF9NFAIiV8C7xkGYf7tInjmmOFxggidt6IAFpi");
            communicationtype.setCommTypeName("TsvDlpQa0Vn1LeLDnN62fxqbqt7iUvx45HRRQXfy34ymhbvuhP");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("H");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            DepartmentType departmenttype = new DepartmentType();
            departmenttype.setDeptTypeDesc("vVj0nQTevJeJC22UNGyPdE3t3iUeQDgHxTCWJmoOALf6QxElbf");
            departmenttype.setDeptTypeHelp("5NJwDKVPIyj56obSUdLM4oPAAlc5oSsDiljNlcWrdH9TKGtruJ");
            departmenttype.setDeptTypeIcon("Z");
            DepartmentType DepartmentTypeTest = departmenttypeRepository.save(departmenttype);
            map.put("DepartmentTypePrimaryKey", departmenttype._getPrimarykey());
            DesignationType designationtype = new DesignationType();
            designationtype.setDesignatnTypeDesc("9p2u1FYjzY3TUAh639sGypVcsotfm4zZqD59CDshjIWPUfrHZx");
            designationtype.setDesignatnTypeHelp("Avt2bhJqRsjm8QYdHyi3qHGUiwlEUJFTE1cvSVHOdAywCh6kAl");
            designationtype.setDesignatnTypeIcon("J");
            DesignationType DesignationTypeTest = designationtypeRepository.save(designationtype);
            map.put("DesignationTypePrimaryKey", designationtype._getPrimarykey());
            JobType jobtype = new JobType();
            jobtype.setJobDesc("qQISqSOzzoTwNrVq0jQtKybmif1D2J3hbKtO7td9vEx2UJ7fWg");
            jobtype.setJobHelp("YTHeL9ZCvK4iFManZI64cu6LX84acheNGvR9pe50Jek6nfaAkd");
            jobtype.setJobIcon("Z");
            JobType JobTypeTest = jobtypeRepository.save(jobtype);
            map.put("JobTypePrimaryKey", jobtype._getPrimarykey());
            Visa visa = new Visa();
            visa.setVisaDesc("pPiR4tVzxgYfn8F1vJd1o8In7S5wndzBkJJKAKMxywZji2kIjx");
            visa.setVisaHelp("Iy9LKjDQqdjX121GMNaTNjZR9HpKLJ9hNwkq028tJURP8jTXID");
            visa.setVisaIcon("t");
            Visa VisaTest = visaRepository.save(visa);
            map.put("VisaPrimaryKey", visa._getPrimarykey());
            corecontacts.setContactId(null);
            empinformation.setCoreContacts(corecontactsRepository.save(corecontacts));
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            empinformation.setDeptTypeCode((java.lang.String) DepartmentTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setDesignatnTypeCode((java.lang.String) DesignationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setJobCode((java.lang.String) JobTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setpAN("zb2IzYN73uBZLAs4SglNJNZmeTOq980RyYgy4zIyTZ1upKAIA3");
            empinformation.setReportingOfficer("4w8m4ns1Wxx84vI6noV348a2Ufn4V1V29fyX7hi1eK5bK1JlLU");
            empinformation.setVisaCode((java.lang.String) VisaTest._getPrimarykey()); /* ******Adding refrenced table data */
            EmpInformation EmpInformationTest = empinformationRepository.save(empinformation);
            map.put("EmpInformationPrimaryKey", empinformation._getPrimarykey());
            AttendenceDetails attendencedetails = new AttendenceDetails();
            attendencedetails.setAbsent(true);
            attendencedetails.setAttendenceDate(new java.sql.Date(123456789));
            attendencedetails.setCasualLeave(true);
            attendencedetails.setEmpId((java.lang.String) EmpInformationTest._getPrimarykey());
            attendencedetails.setInTime(new java.sql.Timestamp(1456488953254l));
            attendencedetails.setMaternityLeave(true);
            attendencedetails.setMonth(3);
            attendencedetails.setOutTime(new java.sql.Timestamp(1456488953254l));
            attendencedetails.setPresent(true);
            attendencedetails.setPrivilege(true);
            attendencedetails.setSickLeave(true);
            attendencedetails.setYear(4);
            attendencedetails.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            attendencedetails.setEntityValidator(entityValidator);
            attendencedetails.isValid();
            attendencedetailsRepository.save(attendencedetails);
            map.put("AttendenceDetailsPrimaryKey", attendencedetails._getPrimarykey());
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
            org.junit.Assert.assertNotNull(map.get("AttendenceDetailsPrimaryKey"));
            AttendenceDetails attendencedetails = attendencedetailsRepository.findById((java.lang.String) map.get("AttendenceDetailsPrimaryKey"));
            attendencedetails.setAttendenceDate(new java.sql.Date(123456789));
            attendencedetails.setInTime(new java.sql.Timestamp(1456488953271l));
            attendencedetails.setMonth(7);
            attendencedetails.setOutTime(new java.sql.Timestamp(1456488953272l));
            attendencedetails.setVersionId(1);
            attendencedetails.setYear(6);
            attendencedetails.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            attendencedetailsRepository.update(attendencedetails);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AttendenceDetailsPrimaryKey"));
            attendencedetailsRepository.findById((java.lang.String) map.get("AttendenceDetailsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByempId() {
        try {
            java.util.List<AttendenceDetails> listofempId = attendencedetailsRepository.findByEmpId((java.lang.String) map.get("EmpInformationPrimaryKey"));
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
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AttendenceDetailsPrimaryKey"));
            attendencedetailsRepository.delete((java.lang.String) map.get("AttendenceDetailsPrimaryKey")); /* Deleting refrenced data */
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
