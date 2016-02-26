package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.EmployeeLeaveSummaryRepository;
import com.app.shared.attendance.EmployeeLeaveSummary;
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
public class EmployeeLeaveSummaryTestCase {

    @Autowired
    private EmployeeLeaveSummaryRepository<EmployeeLeaveSummary> employeeleavesummaryRepository;

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
            corecontacts.setAge(72);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488951184l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488951184l));
            corecontacts.setEmailId("S24D98Uwsf67bnpVUXDxj97VXTVP02XBw98Y6tdWhHEgofcl65");
            corecontacts.setFirstName("cbIvEwa2jX4EbOrrZQaB0I9mJSSNuymG33nLry7BnLPRXyZMH3");
            Gender gender = new Gender();
            gender.setGender("VoNs22rex7EjtZVutUlhKysPMsOdzrOnUPcisoaEHCd4l5wu9E");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("qC");
            language.setAlpha3("qlB");
            language.setAlpha4("jBdu");
            language.setAlpha4parentid(8);
            language.setLanguage("1MyKSEFDbO9SG7oCps8gmbnsminWY1R1wgxwNpsvhrQDFiDovM");
            language.setLanguageDescription("FDnS6szysLsShgxKxrBl8fexTHhAfmKww6J02nta1iJwwijQAx");
            language.setLanguageIcon("dbhRmnNe5NdORoBGRoBOfsEzr8umOnDjA81mesOjJdVlRo2Wnq");
            language.setLanguageType("EjqVbncidbpg9ZCiLfnKmMQv2tFrn2F0");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("XKM2lxun5OSO9DSRmhiZSMXEPauV7ZqmbdHuT9YwlSgCtosmFX");
            timezone.setCountry("soErQLsz4AQrLo7amQ5nSQKNfAZrxt95si7045j6TNijLVSurB");
            timezone.setGmtLabel("h0HkJeBXx501sunjBqRsjGKcXlKFJwBneTCrj5h1MngTMF7toV");
            timezone.setTimeZoneLabel("E9GnMfBkKBTAWLWRQ1E4CIqD9UOkuxNFSXViAqx73mr7uLO4x1");
            timezone.setUtcdifference(8);
            Title title = new Title();
            title.setTitles("JnmzVW1g4MEnpwj5B6K8laLcjh2fc3V2MMnqgiuB8VkVe1fpVY");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(36);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488951195l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488951195l));
            corecontacts.setEmailId("XP4FHxv45cKzDJOp8tZ5NvnnGoJcHj6AsNM7KxXB6MvbQPZKOp");
            corecontacts.setFirstName("kz7SPZdCAdqhJFJhXGjtm7nAr2vKoEDDK45Q98kxb13DBuEjAD");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("MKZsPEC5RhTAcflYaa9A9Nj4Ls1fEfAwQFhFI6e3ALqFOnD6vT");
            corecontacts.setMiddleName("uqLjOPeJTLPvYsjz7jSTYj21a8pbAM9bjgmBXACXIVRwhY52Ha");
            corecontacts.setNativeFirstName("A21Kl6wQIynVeY2uF0GTelmemK0Jm69EesitWaK095HBOtwAVe");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("z9AxTsyXE96Hl3QcOcWOMdILb8efkyWo2Lv8L0SI2XzPgAgXiS");
            corecontacts.setNativeMiddleName("DY5DvECZBOpH0orT0G048tKlfo1w4UrYxxpipnWTAe6MN14gPt");
            corecontacts.setNativeTitle("PslHmElQeCsesPGhMuK99uQNDnH5PrMOjKKl6LMSxGTSuhTvh8");
            corecontacts.setPhoneNumber("SNTLB2NX3tuLyL8Df2bc");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("oKekmUogfgMDUkOz0PjN289txCPoxZGwrDdbd1CqJWgMD0fAHT");
            address.setAddress2("C1V4o1XCWDSivNWrSLtPkAmV1RKvAo2UHYGY4N6h63IZXLNllD");
            address.setAddress3("JVKiyhTcBWjNMUfBvpAwJTXVkZNBy46y9WbVihtkmfNxy05WRR");
            address.setAddressLabel("kjRTSJzvomf");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("6clZajEagCXIl1OCnuVGU7pkaDjeLXN61VzZDa29xwpZdlzJQC");
            addresstype.setAddressTypeDesc("nQ2h9gzTrcXfwgRpBBP1tabPGht1pkYTO14mxhe6snwoJNrZuU");
            addresstype.setAddressTypeIcon("y808I3Y04MkxOwZbNHsbTNAiMVgLD6SoaqOVIfZ4EgwTaz3hE8");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("rKCxKjAcANMwp4mwz9JUihuxfyLxeUk7");
            city.setCityDescription("TaDQ9tjmyXmdhBecVmyvidGU7WbZ5YIgd7LnFr4teWTkNsD6ip");
            city.setCityFlag("L9ELRiIMkEsWb7TuUdxHSqKIjvriJ1TKvtoZJ9TQkCsBGfnKhT");
            city.setCityLatitude(4);
            city.setCityLongitude(4);
            city.setCityName("T8CWvZNnrplhLbcX25ZOaiZOm7Ymc5lwrdH9FLxNxPFGgRFMl4");
            Country country = new Country();
            country.setCapital("iBXU1Hj1wtUyIa4j9MhDyVDbugKBjRif");
            country.setCapitalLatitude(11);
            country.setCapitalLongitude(8);
            country.setCountryCode1("55V");
            country.setCountryCode2("NVb");
            country.setCountryFlag("A90vt8vKzurjICQtkUEaxpPr8kmYnnbGl9hAM0kFpZZ1mxjgOR");
            country.setCountryName("w4FquqHmDbQAEKOwiAVG3dNOEVSxvfHZnVJeBeaIUdhRtal6Eg");
            country.setCurrencyCode("JMp");
            country.setCurrencyName("nDedMNAjCh1HS6L2YnMy0k43j0uvZtCuNyOSPcyZtZVUhrzxFr");
            country.setCurrencySymbol("rrlqCnWdZKwmwM1R7cEshZBeG3gpszqd");
            country.setIsoNumeric(2);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("hYp9GURfquHOpCEWcqCcdK06XV8n5Tfv8SSa8aw6cjCi31SC5g");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(5);
            state.setStateCode(2);
            state.setStateCodeChar2("oTrX8YDSb4SpCmFVpv7SHZlzafHDjCdg");
            state.setStateCodeChar3("iOTcYsDbtHRFhTBmRr2VHJExRCW88mzr");
            state.setStateDescription("DsfpY4AXe9YNTCwHOi16TI8mnTthr0iUey5hy8JwNdtwMLSh5s");
            state.setStateFlag("4mwjCoIaMvSSH9wQDuB4GyZurd4Eb1bimasj9iL2M6JA763V4C");
            state.setStateName("vXoIlQGKqxaTnXbThCj3PcToP2DuqBaC8xKPT8U5aBgJRsBYvC");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("46nZtAGxkSJF6p3oNlEcspi3ukPA2jO3");
            city.setCityDescription("XnjNamqQ3rzubBFoapuo68n9plU0bzkuWuOOwinYkn7wTED4dO");
            city.setCityFlag("ZRZtHjtRfY2nNkzVg5tjcsnYicqHLti0nsy7kTbwJGLLp4RLnO");
            city.setCityLatitude(0);
            city.setCityLongitude(1);
            city.setCityName("JtFv3feyuRfAhWaqb9eKKpIGuGXFRbPhe7PUmudKXYp7HR27LQ");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("yECnejArFmrKXmPoWN0b2lY6GDBxN2UnpWpGEac7bU3VkPZU4B");
            address.setAddress2("etPVhQVwcs60GZeVFkTXEOEBFORd834n8uEFzbAzIx5W1LGSLe");
            address.setAddress3("uNOpWBPzPPoDVL5gJKaeh0rlIDN7lDUppPNRtRkcG6QOLameYe");
            address.setAddressLabel("Om4T2YQZIup");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("Jn57DGSmdKhhbrgFWHSk5HgFxi1mS0aB6AVym44r2ZJfZ3qton");
            address.setLongitude("B3LbHL7fHXgRFzLZ2gPyQ6NfpUigschuK9R71gAu6HBmoWnZlw");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("Or6hMQ");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("b");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("0tMY76m9b7K5XqUBLF3AEK6sQ6GTgLJnP3VqmNcKRFJSnmxQp0");
            communicationgroup.setCommGroupName("D8Lt8WT5tSt1N0EcBuCKM7nAySocQfLcEJalCz9sfzRhnjXc62");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("qCTLVr9HaGEWhmZ9Lg8RX7eK5HpWkLjYCb2Hh0wfabeKFwUxEY");
            communicationtype.setCommTypeName("htfJfEWVB4EcAZjUb68DUsegT9dQTIdKqn79kDQOdmBAnzebJ1");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("O");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            DepartmentType departmenttype = new DepartmentType();
            departmenttype.setDeptTypeDesc("sZN5NnLkyzdqBTwYX5nBewTmTPzPuQDx1klM8tyzMFSMm35kNH");
            departmenttype.setDeptTypeHelp("dKrUNJcZcCdNcf9GfWbg3PfSOqTY94DUIWMbprwMWAEM6eEmvJ");
            departmenttype.setDeptTypeIcon("v");
            DepartmentType DepartmentTypeTest = departmenttypeRepository.save(departmenttype);
            map.put("DepartmentTypePrimaryKey", departmenttype._getPrimarykey());
            DesignationType designationtype = new DesignationType();
            designationtype.setDesignatnTypeDesc("0Eh1B3AnNyTPVYvI5DFpddiR52SbJlVDBds697kojVWcci9Cfc");
            designationtype.setDesignatnTypeHelp("c3hanGSBWYLqRqHU7J8bY3jcKKJmiYFoZBqHjARTmZ0g7BaO72");
            designationtype.setDesignatnTypeIcon("4");
            DesignationType DesignationTypeTest = designationtypeRepository.save(designationtype);
            map.put("DesignationTypePrimaryKey", designationtype._getPrimarykey());
            JobType jobtype = new JobType();
            jobtype.setJobDesc("AWwRTUBAksDUFwJ9QCYO5jSDnGt4UdN9mmhJ5Xr6ApQPKkVu0K");
            jobtype.setJobHelp("wslx5hEgdjZ0809qbcXe0mFQqUYyt3NTJf6HxEfPlHj3L6j8vD");
            jobtype.setJobIcon("c");
            JobType JobTypeTest = jobtypeRepository.save(jobtype);
            map.put("JobTypePrimaryKey", jobtype._getPrimarykey());
            Visa visa = new Visa();
            visa.setVisaDesc("DVdYXNILjd55ZPSpcwrmIZutFvX9dLJ1eQi5EfXY2zbQBxNOJV");
            visa.setVisaHelp("q1W5WLJfk9FxgFyAubpo9QpZQejbLwe8Dp0udUBUJE0S3IgLVr");
            visa.setVisaIcon("s");
            Visa VisaTest = visaRepository.save(visa);
            map.put("VisaPrimaryKey", visa._getPrimarykey());
            corecontacts.setContactId(null);
            empinformation.setCoreContacts(corecontactsRepository.save(corecontacts));
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            empinformation.setDeptTypeCode((java.lang.String) DepartmentTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setDesignatnTypeCode((java.lang.String) DesignationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setJobCode((java.lang.String) JobTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setpAN("gFCjvC5uLH5iL8SPgUQ0HuT5Bx9YkbBtWCUafrzAzSYnsUYJVu");
            empinformation.setReportingOfficer("yZdnrUR0YNcisCnF1XW9HQ8APKDwdDKBSfv2OU9ABoaD8dleeA");
            empinformation.setVisaCode((java.lang.String) VisaTest._getPrimarykey()); /* ******Adding refrenced table data */
            EmpInformation EmpInformationTest = empinformationRepository.save(empinformation);
            map.put("EmpInformationPrimaryKey", empinformation._getPrimarykey());
            EmployeeLeaveSummary employeeleavesummary = new EmployeeLeaveSummary();
            employeeleavesummary.setCasualLeave(5);
            employeeleavesummary.setCasualLeaveTaken(6);
            employeeleavesummary.setEmpId((java.lang.String) EmpInformationTest._getPrimarykey());
            employeeleavesummary.setLop(3);
            employeeleavesummary.setMaternityLeave(0);
            employeeleavesummary.setMaternityLeaveTaken(6);
            employeeleavesummary.setPrivilege(3);
            employeeleavesummary.setPrivilegeTaken(8);
            employeeleavesummary.setSickLeave(9);
            employeeleavesummary.setSickLeaveTaken(8);
            employeeleavesummary.setYear(2);
            employeeleavesummary.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            employeeleavesummary.setEntityValidator(entityValidator);
            employeeleavesummary.isValid();
            employeeleavesummaryRepository.save(employeeleavesummary);
            map.put("EmployeeLeaveSummaryPrimaryKey", employeeleavesummary._getPrimarykey());
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
            org.junit.Assert.assertNotNull(map.get("EmployeeLeaveSummaryPrimaryKey"));
            EmployeeLeaveSummary employeeleavesummary = employeeleavesummaryRepository.findById((java.lang.String) map.get("EmployeeLeaveSummaryPrimaryKey"));
            employeeleavesummary.setCasualLeave(0);
            employeeleavesummary.setCasualLeaveTaken(8);
            employeeleavesummary.setLop(3);
            employeeleavesummary.setMaternityLeave(10);
            employeeleavesummary.setMaternityLeaveTaken(0);
            employeeleavesummary.setPrivilege(7);
            employeeleavesummary.setPrivilegeTaken(10);
            employeeleavesummary.setSickLeave(2);
            employeeleavesummary.setSickLeaveTaken(5);
            employeeleavesummary.setVersionId(1);
            employeeleavesummary.setYear(10);
            employeeleavesummary.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            employeeleavesummaryRepository.update(employeeleavesummary);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByempId() {
        try {
            java.util.List<EmployeeLeaveSummary> listofempId = employeeleavesummaryRepository.findByEmpId((java.lang.String) map.get("EmpInformationPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("EmployeeLeaveSummaryPrimaryKey"));
            employeeleavesummaryRepository.findById((java.lang.String) map.get("EmployeeLeaveSummaryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("EmployeeLeaveSummaryPrimaryKey"));
            employeeleavesummaryRepository.delete((java.lang.String) map.get("EmployeeLeaveSummaryPrimaryKey")); /* Deleting refrenced data */
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
