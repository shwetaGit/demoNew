package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.AttendenceSummaryRepository;
import com.app.shared.attendance.AttendenceSummary;
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
public class AttendenceSummaryTestCase {

    @Autowired
    private AttendenceSummaryRepository<AttendenceSummary> attendencesummaryRepository;

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
            corecontacts.setAge(122);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488954046l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488954046l));
            corecontacts.setEmailId("nuMkuDHDgvtSq5Tjr0wTpcHt5aciApQXQNk05yf0fKpwp3iS0M");
            corecontacts.setFirstName("jMpMqXme3A4YxAkEwchZTKKo0uWKV4f4597XNfWwlUEVVZmV6w");
            Gender gender = new Gender();
            gender.setGender("uSUDzAb0AWZu749LVc0qHkDcjVt5bP6Q15AzCRtkAzYZ9dxHZa");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("La");
            language.setAlpha3("uyh");
            language.setAlpha4("VPCX");
            language.setAlpha4parentid(11);
            language.setLanguage("x8kQJcmNjehwD6iEHGC3UDg4FiJxhAy4G9LAYfwLXvQoPhTGJC");
            language.setLanguageDescription("p8GLHTdrYqq6Hm0HqGUlK5EsqK9zfVjfzAZTJJaNjvtHFvg1xO");
            language.setLanguageIcon("3kSbKhfb94HF3kCAt1tQ0hw95NDDx8cV4XkpBjjNb8VYLMzVCt");
            language.setLanguageType("8WB0WSVSqI7SvG5DIVFacFgmBaj2BVDO");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("S5kGvOTAPuqCmgEZDANhqsA8974ewRJcj2uimGPry5OXIVEmDU");
            timezone.setCountry("M0lHm1CU4Y4x7ViVLreQbpHD9qFbSTfKmAGu72UJQi4Cjs40bK");
            timezone.setGmtLabel("Gxy401CZSkQgLTuMGiaZEsFA5EkHl0h8n3iqE9hI8quMgSUGHd");
            timezone.setTimeZoneLabel("xQMgpVs84LUAw7ypTama4LPMSdQZHxaghq6fbak0LIDdk0YJ2w");
            timezone.setUtcdifference(5);
            Title title = new Title();
            title.setTitles("G9AwmW2xKauIJcqGCkcfODmdf2OWkXHli0i1LJGlR7hjF0Y0Qr");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(11);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488954060l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488954060l));
            corecontacts.setEmailId("4Dk2OBURYRa3x4DhpLPVHsdNSxQrWykkfDIpqiwVQ3n9OQ5b9R");
            corecontacts.setFirstName("ALP45ro0UUervdXeH7j4LSgjIVmz46kDoaVctzlTTKwLbGOdnQ");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("W06oh2aBRVD3xQkz2uP76roZeyajxlmlQbM1jTlywhRsirwu2B");
            corecontacts.setMiddleName("j7wYBVHErnVYkb7SLWH9qUZvKZAn5arpbE9Fh5KmfUXgP59qU2");
            corecontacts.setNativeFirstName("nONfSD2uOYy6QEFqZ7Y6xqywheCNjbNK0XS6U0zMVPBqqIow9f");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("JeFMMrhp2lYEkajOPsKwYm9GAadwTwLUmmEvkJ4yjUClLZmfWO");
            corecontacts.setNativeMiddleName("AdT25QuTj55eXTmYObDrIeVPxTCQdbVfuhldhww5xpZy8IoUrr");
            corecontacts.setNativeTitle("siuw5f9Z6sWgY8uPEsokt8jEq4vCpSvqvYKrp66pxTATV1bNKR");
            corecontacts.setPhoneNumber("t6ziNyNKr1u9J6afJSfF");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("yvfWTEucLWpzn3kSY6YURq3rvIMxgWW3uxMvqjdD3ocJ86gF18");
            address.setAddress2("cQDJh1maL3gUMvmcogjXy06XKAyOoeChygaMY9Djn5TmgXmOSW");
            address.setAddress3("U0fZdU3OMvktdZpWiIon27Rz812SPWYtdAuIbrsT122EXb8VAn");
            address.setAddressLabel("rbACsXt3KAo");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("7hqtg3E0x81UWzfY6gGtEafNOF1EmoOurk55enncUnjg7Hih0e");
            addresstype.setAddressTypeDesc("RALtLLyY1CgIj3BFS7p6x2PAXE4KGPJ0azYzfYfFMCOZfqo0z7");
            addresstype.setAddressTypeIcon("muVa54pB6zufmhttASLsXsto4KYLVo2BjUBxL1E8L5awsJRHzn");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("JDJN4CBhgWlNoY9R5iwnXS9LPXNm2bQY");
            city.setCityDescription("qWXmBBrrqr1b2qIPTrJ0WjCDSfiMgqr7ZL3rFh43LC7eMvfBDn");
            city.setCityFlag("9OxwcwrM9zqzMUpsWhrYkwApAOOBp5T96gCwZSYNN3xoNNAMtW");
            city.setCityLatitude(6);
            city.setCityLongitude(8);
            city.setCityName("FHd5dNCv1xeflGZMCrNdYoHQvbC344LDjENwA0q4BgESVRi2CR");
            Country country = new Country();
            country.setCapital("3IVmDHrcjDXD7Iyq3nJuM5NyW1JjvtVx");
            country.setCapitalLatitude(3);
            country.setCapitalLongitude(10);
            country.setCountryCode1("qKb");
            country.setCountryCode2("66u");
            country.setCountryFlag("GRo6JwbOQZTdPrJyW9mHPosFVmqiBxxT6uAX2Xnsk4IkE7P1gn");
            country.setCountryName("FRNJOeLw39QE1X650kN1uadSwirx2Ku5lKjNiDk0RyY8MdzD2l");
            country.setCurrencyCode("u3y");
            country.setCurrencyName("SJLwjEno41uoh6ox8lMzBQwn6sJwyD1r8REcsSGWCYlOuTbPkm");
            country.setCurrencySymbol("y8aAfVtEYyyuYDYTX6732Z1RtSVOn8mM");
            country.setIsoNumeric(6);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("aMPqjoqKD5r3W66mU3wyv4kryDCPUdczcDG6JMu9OcRUQghVwi");
            state.setStateCapitalLatitude(2);
            state.setStateCapitalLongitude(10);
            state.setStateCode(0);
            state.setStateCodeChar2("a6Df1ERwDhO1Zorpgey4sHgRNFoYuz3F");
            state.setStateCodeChar3("tv7wPh4gdJKTIOVTfCrtwlLWLSqRTBhc");
            state.setStateDescription("5ZTct1HiSlajMBwqGkBZv1HsTrRh9I4EdqSH3WgeOltDpEAEZW");
            state.setStateFlag("GRAEpIJxBC0Zc7RwdikaK4OhE8oXdbQSnkD2ECWrbqhVVZzuDC");
            state.setStateName("3KPL4Ai7Qe1Q5wuWB2iCdbvHfnBfqnE3qgCko8pwNsMPaO3Phr");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("Q5cOazyOv2aZVv9Jr4LWi7c1BBzmEoUU");
            city.setCityDescription("goc8HS1jaLPhuloYFaRi9cb0PQgvNw6ScrO2dP2NVRtfrKTD41");
            city.setCityFlag("rhJRHqYi4B0hUc849Il1TK2fU4iKSzqOOGyS8eoyonsdFqr4K8");
            city.setCityLatitude(7);
            city.setCityLongitude(0);
            city.setCityName("LslpRq1i3CHdBf9bPAyQEd9YWokv7u2GGH7SwwRgtaHnyNKe6d");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("iVLtjZTkxPxZiocK4QP7CzauQLJK8Ubn1O6MeyYrT0USdVhK4C");
            address.setAddress2("kZp2JkpFJxpfRrAGQGrFnVRUnHKoi9SDLhukmndbofqm8XNXnx");
            address.setAddress3("Yuh04XEsQlZJHCYX2lhpAw8xNTb7gEECqPRG7ZvJivr0yTeHDc");
            address.setAddressLabel("nM8eNnXNCkL");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("awvKslz3f84lHCocsZdGuf4kv8M06grasfEsDv74nyvcxAk3ea");
            address.setLongitude("rozzSBcGMO5iQCj0u8YYa0DRha1laXBuahszHoz8QDxlJodNRu");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("QUJyN2");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("h");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("CfZrpjlDfq0wzY8pOSERDugbmb2gDhFUXHKNBZOqRQKqKw6BLF");
            communicationgroup.setCommGroupName("KUyUWJLbCD2s7joSiCBbvgGPHd27eBXmaMcxwiA82Delkz621K");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("XAB1OUiKRufc83hE9zqQ5gBB9yk9RjdA1mCXG6oiphBizorro2");
            communicationtype.setCommTypeName("EFVeVhrht5rq6Vitigv3dEag7xvNCPZS0hkWEGeaYPYevgEOWe");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("A");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            DepartmentType departmenttype = new DepartmentType();
            departmenttype.setDeptTypeDesc("n3kiEEXZFsmJYB5U2rR5f9xzxMG47rSJeiyDYpFXevYNxzNOxS");
            departmenttype.setDeptTypeHelp("y3Ui67LwpyzVY9wiGb6vg0Tesm6uuxdfXvRNCjVCNjssAycPUF");
            departmenttype.setDeptTypeIcon("U");
            DepartmentType DepartmentTypeTest = departmenttypeRepository.save(departmenttype);
            map.put("DepartmentTypePrimaryKey", departmenttype._getPrimarykey());
            DesignationType designationtype = new DesignationType();
            designationtype.setDesignatnTypeDesc("nYCdKkCfSrazPGsSkxvQ5dEF4wSfYST22LxmxhwIHcTLcPtNEB");
            designationtype.setDesignatnTypeHelp("hN0eaV8TilS0GK4jgxsaJIxt7gQmiB5R7xQdOufaUYD9P3N0oX");
            designationtype.setDesignatnTypeIcon("I");
            DesignationType DesignationTypeTest = designationtypeRepository.save(designationtype);
            map.put("DesignationTypePrimaryKey", designationtype._getPrimarykey());
            JobType jobtype = new JobType();
            jobtype.setJobDesc("kmhjwQJXrkGltRafIxzXnhbZJBxfBhxTMXVNcLDRzBODJkvfND");
            jobtype.setJobHelp("X24BOeUXklDKG7yoAlZQlAJYRQEgZB7f41d1wMpIEeu0wf8UIY");
            jobtype.setJobIcon("T");
            JobType JobTypeTest = jobtypeRepository.save(jobtype);
            map.put("JobTypePrimaryKey", jobtype._getPrimarykey());
            Visa visa = new Visa();
            visa.setVisaDesc("vALeNEEo4W3kaQnwWqmbU25u5sCQYCX0iVgBHbG2lvFwjMtMHr");
            visa.setVisaHelp("HTcXhMUx0BmVAlUAuruOrWYVbACa9WKmTRJaUzcFcdgiqWKdJy");
            visa.setVisaIcon("e");
            Visa VisaTest = visaRepository.save(visa);
            map.put("VisaPrimaryKey", visa._getPrimarykey());
            corecontacts.setContactId(null);
            empinformation.setCoreContacts(corecontactsRepository.save(corecontacts));
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            empinformation.setDeptTypeCode((java.lang.String) DepartmentTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setDesignatnTypeCode((java.lang.String) DesignationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setJobCode((java.lang.String) JobTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setpAN("cRDQzRuActnhjVSYBMj1VZqu7A6VaazB4MVyBmRzoAQWWp9wS8");
            empinformation.setReportingOfficer("wrZeDVqNIr1AMvCBV4G5jd3gpbkqZwv33o9X8FvgeWGofisnzX");
            empinformation.setVisaCode((java.lang.String) VisaTest._getPrimarykey()); /* ******Adding refrenced table data */
            EmpInformation EmpInformationTest = empinformationRepository.save(empinformation);
            map.put("EmpInformationPrimaryKey", empinformation._getPrimarykey());
            AttendenceSummary attendencesummary = new AttendenceSummary();
            attendencesummary.setAbsent(7);
            attendencesummary.setCasualLeave(0);
            attendencesummary.setEmpId((java.lang.String) EmpInformationTest._getPrimarykey());
            attendencesummary.setMaternityLeave(4);
            attendencesummary.setMonth(6);
            attendencesummary.setPresent(5);
            attendencesummary.setPrivilege(4);
            attendencesummary.setSickLeave(0);
            attendencesummary.setYear(9);
            attendencesummary.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            attendencesummary.setEntityValidator(entityValidator);
            attendencesummary.isValid();
            attendencesummaryRepository.save(attendencesummary);
            map.put("AttendenceSummaryPrimaryKey", attendencesummary._getPrimarykey());
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
            org.junit.Assert.assertNotNull(map.get("AttendenceSummaryPrimaryKey"));
            AttendenceSummary attendencesummary = attendencesummaryRepository.findById((java.lang.String) map.get("AttendenceSummaryPrimaryKey"));
            attendencesummary.setAbsent(0);
            attendencesummary.setCasualLeave(4);
            attendencesummary.setMaternityLeave(2);
            attendencesummary.setMonth(7);
            attendencesummary.setPresent(0);
            attendencesummary.setPrivilege(8);
            attendencesummary.setSickLeave(10);
            attendencesummary.setVersionId(1);
            attendencesummary.setYear(6);
            attendencesummary.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            attendencesummaryRepository.update(attendencesummary);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AttendenceSummaryPrimaryKey"));
            attendencesummaryRepository.findById((java.lang.String) map.get("AttendenceSummaryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByempId() {
        try {
            java.util.List<AttendenceSummary> listofempId = attendencesummaryRepository.findByEmpId((java.lang.String) map.get("EmpInformationPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("AttendenceSummaryPrimaryKey"));
            attendencesummaryRepository.delete((java.lang.String) map.get("AttendenceSummaryPrimaryKey")); /* Deleting refrenced data */
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
