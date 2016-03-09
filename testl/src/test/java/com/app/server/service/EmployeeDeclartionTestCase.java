package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.EmployeeDeclartionRepository;
import com.app.shared.payroll.EmployeeDeclartion;
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
public class EmployeeDeclartionTestCase {

    @Autowired
    private EmployeeDeclartionRepository<EmployeeDeclartion> employeedeclartionRepository;

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
            corecontacts.setAge(96);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488965335l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488965335l));
            corecontacts.setEmailId("0FSasn8xeTZfK7EkBDIL7VeNHGOwCqIGMHLIUPr1TwMW58kpvZ");
            corecontacts.setFirstName("T3NrT2qK4GSUPCcUbtCIomPz9nZZO16Q82nrBe1nvHhqzD0qtN");
            Gender gender = new Gender();
            gender.setGender("yAJLy6lQvqEl63V98Cm3EoyFfWZniq7nWjvufQJcCkTJsaSok8");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("PL");
            language.setAlpha3("lob");
            language.setAlpha4("nbiP");
            language.setAlpha4parentid(6);
            language.setLanguage("kwiDzDUwAxcqm5j6JxAK4qPgsr0a6Pbomvh3hJ6CbjEjwRIG5H");
            language.setLanguageDescription("CeaJBCcTaqiiUy8DVYOd57IGlVomwxK2gE0qd34CmjjqCVIaR7");
            language.setLanguageIcon("FkJLm4eEQSdqGY2FzXkBiVpGPmVIWxa4sWXbsgjbbq87Bl4Gup");
            language.setLanguageType("cY50wiFOk84jsk9c50UgUVDcNi9sIFUe");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("jsOV6jTqG8ugsRVW7UQwDrjthCqzAgArv0HBQkxdzblOTTznJO");
            timezone.setCountry("KGevPEmL3e1puSSgbuxJxFPKf178EZ3OiqQx26G4n2CL7sEZ74");
            timezone.setGmtLabel("ujVXggVvRaXQTY4NVLglfYLTMnwHsjKD9a5ykC1QuVtIzOWI60");
            timezone.setTimeZoneLabel("bXdg7Uf78cxFMpj9uiTHWf6Dowbn8lUS3fO87CGERzzu7fKOXb");
            timezone.setUtcdifference(8);
            Title title = new Title();
            title.setTitles("nsN2HLwXVtA8O5sR6XRUDt6yqpmhhjuL0QwptlBSdJoufQOf5I");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(77);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488965347l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488965347l));
            corecontacts.setEmailId("6FKhZGS9tTKGM1YdWqGOStqn6LGGjgjQuPzaGlNb4YUy4CC0zS");
            corecontacts.setFirstName("MAfx2UxcpEtaqMev5PHg1z2Zko5mXyDTNoVhXJyiJDkbqaAzYM");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("WbELBbE36YGBwSIKJjfByZEHnUa3j92kYN5yIbSb0PQVZXYY3y");
            corecontacts.setMiddleName("JoMQ3Ur4sJGee8TVu0XapnJma4GHAtC3wiv3eLAhKdhUgExqhL");
            corecontacts.setNativeFirstName("bqV9HtgXd6Ngz2zS4oFgD7UsHnl2r5lumXW96pa6cKsuY3yV14");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("7MUObndxuL8drwj2cFDmYbWLO4Xdg7e8MolBJ8vmlzEoq84Es6");
            corecontacts.setNativeMiddleName("RHcNrMwRALQVfVv1jFIayrnSAL4VEA5hBD5MPFa8SJ3Lf1v4iN");
            corecontacts.setNativeTitle("kB1YsJUUreqnkuZdC3DEW1sMLUNhVcoAJKFozkJymv9dGmu5ee");
            corecontacts.setPhoneNumber("DUqCggvFJHNX7MjuNufH");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("eYnc9guzsvWl5KTa2CmrMC1MqGCSW2zQhCMlKp9iVmoG97y4sY");
            address.setAddress2("3CkMhbcnGTITcirWddGea3QPxbyyYnk8TcftVN0o1sEnvTIXQs");
            address.setAddress3("zlG5oNIvwiPgwBraGUnsnJUlMim5QvWekwj2PJCOg7tnR3ruXt");
            address.setAddressLabel("Rvp0tW11QTF");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("q4ShdrHF7cU4BFAu9J0gptMHn3ehWxAaDO346BnnzyF0kk3XiZ");
            addresstype.setAddressTypeDesc("uhQozzIhbzLHuIhDLUXSjysj7J3yQklE2eOsWLWp30U9rtZwLj");
            addresstype.setAddressTypeIcon("SojXPZtyHa9NTuGQC5QWy5esLEUIopLxFthucWGZlfK5138p9w");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("11Dh7rKVvPJXXWKPYSYGiGRLkEGxxiLQ");
            city.setCityDescription("fy6vgV6dkv0u2JdFzk8lRZHKuIrktBg6vlEfjImhWv2uV2c1FC");
            city.setCityFlag("eCGLxfgKJquuDTGRw0r00KC4sQefj4gVpxNdkcLDIrFenJQ2Hi");
            city.setCityLatitude(4);
            city.setCityLongitude(6);
            city.setCityName("v7ptQGDWTNbfMuTwFeIHAgGsX3oZSvjjTiVEIm0YdiM3O5fDWo");
            Country country = new Country();
            country.setCapital("URtnTFsR1EpaXvCRqMjaGp4jFXMn4Jta");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(6);
            country.setCountryCode1("5yb");
            country.setCountryCode2("zO0");
            country.setCountryFlag("xzWxt3gu9wwj8NY8fcfvEo8uUKOYKEIja3pWMgKILcOivxNeCO");
            country.setCountryName("HWrVRzXYhsITb9jDP4qS3kbyW9AlB4sxvBJArqPyZTR55EetHZ");
            country.setCurrencyCode("3g1");
            country.setCurrencyName("I42K8bspJExfEacCxMM1gV0NhWTXxL5aS98snW3ISbbOtAKoBd");
            country.setCurrencySymbol("4LJWxQSHllRKYK4HmyZ1JUdWWXJA3ece");
            country.setIsoNumeric(11);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("inRCYaiMgRdXXx5TupsKPUWpUyHOc9qC38t7Dsea6QnMdyuQdt");
            state.setStateCapitalLatitude(7);
            state.setStateCapitalLongitude(0);
            state.setStateCode(1);
            state.setStateCodeChar2("7RsQGcWPiR95KWiEb9JB162J5qBx4JDc");
            state.setStateCodeChar3("S4Y80AMdKTV8dBNwBnjxMTvqyB1H9YQd");
            state.setStateDescription("zuEUdMaNC1z1uCrizcvQlcK8Ga6HygOn7nX0AJ719VSnSoDyJS");
            state.setStateFlag("R9d6l7hnOFOhXGeeiuVNNp1ujf9MPVUwh1uEld2eUX7IFskD6x");
            state.setStateName("dPV5Jx8XJ5SWdgWb9NCtdhmg2TXZBP9aQQiuAYajLk7lenXrFG");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("qbjBGnQ7ToUGdbHOAkNTGcKSxQHdUiUX");
            city.setCityDescription("ICSjaYsWtduzl8JgXKwt2gIQSnBVRNEVfL4FDH2N4ZaHIdQN6B");
            city.setCityFlag("ZV1WQKFrFvFDuNDw69nqojNXMb0Y9neY7EO4ZGTnIANEnAQgSU");
            city.setCityLatitude(5);
            city.setCityLongitude(7);
            city.setCityName("T8khuKcvqtgUJxZmKJjBCmAp4gmvO24zFJqBkOyclWxorVn8oD");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("kcTTXyl7DmgvlVR3zdy8k8Hr6xkS5A69R5R0EuQhTFYrhHGB6E");
            address.setAddress2("ASEw3yW2freWEqhWGMKTsOKc4Ex7VkkOhpxA4cR5sVnjVjbc0m");
            address.setAddress3("zwLTcCWXdDCM4Mrq7KiXKG0KJkYNgc2Uc7RejcCuJsZC3HXXhV");
            address.setAddressLabel("s4XiHIFFTYI");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("vZfn6foHTkWW8FfbZnVrhwiSiGrFgZqaR0WJvqrkP0v9qwhS7m");
            address.setLongitude("YAbXb4n0eBbeXA2QMlDWY4JdG1MpWN8VV5U6Hu6bvJgVhl53JJ");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("dw0qfb");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("S");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("7qIdNob06Es9dUbJa6zTR8BqXkihS9rQFxNSmCM3spjDhLgH2B");
            communicationgroup.setCommGroupName("jbOGlPPECqu7l7lzXgXyAN4KZHM0qx8BoFMBIkknFA9f7zO9BT");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("U8tdRUwPac2L8DPGSz83cGC6fhRY39MX5rJNyPPsz4rvVkIwl1");
            communicationtype.setCommTypeName("4eoLr9gvlIvBvbZtE8HlKS64C7Za465t7yODVBJRcfZLO9GS2N");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("A");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            DepartmentType departmenttype = new DepartmentType();
            departmenttype.setDeptTypeDesc("jNCLT87nPFm1pVuXwrO2qxgt7f6bUFoggyWSBHPXWkicNmJCIl");
            departmenttype.setDeptTypeHelp("JhSUhHoFycvaNK0UKFz1JAIuHOCn4XjP7y43XYXQT0Rqg30ICq");
            departmenttype.setDeptTypeIcon("C");
            DepartmentType DepartmentTypeTest = departmenttypeRepository.save(departmenttype);
            map.put("DepartmentTypePrimaryKey", departmenttype._getPrimarykey());
            DesignationType designationtype = new DesignationType();
            designationtype.setDesignatnTypeDesc("Sj0glAqyUR5vwdyFHXqg8VWLJabd28g31rYbwwdwVl4FpwNPLX");
            designationtype.setDesignatnTypeHelp("S9Y4YZhlEpZMioH5iGiJuV9H4oSuGTupGPh8XRh1uS8gqIYVJa");
            designationtype.setDesignatnTypeIcon("B");
            DesignationType DesignationTypeTest = designationtypeRepository.save(designationtype);
            map.put("DesignationTypePrimaryKey", designationtype._getPrimarykey());
            JobType jobtype = new JobType();
            jobtype.setJobDesc("BkJvYhp2AhxAKysTI330eiE5VqFCeTGLWe2cYni6UrIwqDTTWF");
            jobtype.setJobHelp("90QgHaxx9sW56th39fyMiY3FX2TFDLcE6TRvbqSXkiQOx8gt5B");
            jobtype.setJobIcon("J");
            JobType JobTypeTest = jobtypeRepository.save(jobtype);
            map.put("JobTypePrimaryKey", jobtype._getPrimarykey());
            Visa visa = new Visa();
            visa.setVisaDesc("VA9MN83L0M8P64EhYGZ5eGkaKIjfAeSKwW5FVlv3p6CO03xdwZ");
            visa.setVisaHelp("QOWUPYQFyeWSSyVgfFDvf89lYcpx67vMuwvQiYJbIBSJSMHeuv");
            visa.setVisaIcon("W");
            Visa VisaTest = visaRepository.save(visa);
            map.put("VisaPrimaryKey", visa._getPrimarykey());
            corecontacts.setContactId(null);
            empinformation.setCoreContacts(corecontactsRepository.save(corecontacts));
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            empinformation.setDeptTypeCode((java.lang.String) DepartmentTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setDesignatnTypeCode((java.lang.String) DesignationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setJobCode((java.lang.String) JobTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setpAN("mzOk0aUGR97xJ6gZQDQpU3Ee6rmxNOON9JXBXYtpXJf218X1fL");
            empinformation.setReportingOfficer("y7xCB4DmP3ZZSGpKkJDaDKj0Lppj55R2DmSgyjBiKrOb02wKbP");
            empinformation.setVisaCode((java.lang.String) VisaTest._getPrimarykey()); /* ******Adding refrenced table data */
            EmpInformation EmpInformationTest = empinformationRepository.save(empinformation);
            map.put("EmpInformationPrimaryKey", empinformation._getPrimarykey());
            EmployeeDeclartion employeedeclartion = new EmployeeDeclartion();
            employeedeclartion.setEightyC(12.34);
            employeedeclartion.setEightyD(12.34);
            employeedeclartion.setEightyE(12.34);
            employeedeclartion.setEightyG(12.34);
            employeedeclartion.setEmpId((java.lang.String) EmpInformationTest._getPrimarykey());
            employeedeclartion.sethRA(12.34);
            employeedeclartion.setYear(8);
            employeedeclartion.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            employeedeclartion.setEntityValidator(entityValidator);
            employeedeclartion.isValid();
            employeedeclartionRepository.save(employeedeclartion);
            map.put("EmployeeDeclartionPrimaryKey", employeedeclartion._getPrimarykey());
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
            org.junit.Assert.assertNotNull(map.get("EmployeeDeclartionPrimaryKey"));
            EmployeeDeclartion employeedeclartion = employeedeclartionRepository.findById((java.lang.String) map.get("EmployeeDeclartionPrimaryKey"));
            employeedeclartion.setEightyC(12.34);
            employeedeclartion.setEightyD(12.34);
            employeedeclartion.setEightyE(12.34);
            employeedeclartion.setEightyG(12.34);
            employeedeclartion.sethRA(12.34);
            employeedeclartion.setVersionId(1);
            employeedeclartion.setYear(5);
            employeedeclartion.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            employeedeclartionRepository.update(employeedeclartion);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("EmployeeDeclartionPrimaryKey"));
            employeedeclartionRepository.findById((java.lang.String) map.get("EmployeeDeclartionPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByempId() {
        try {
            java.util.List<EmployeeDeclartion> listofempId = employeedeclartionRepository.findByEmpId((java.lang.String) map.get("EmpInformationPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("EmployeeDeclartionPrimaryKey"));
            employeedeclartionRepository.delete((java.lang.String) map.get("EmployeeDeclartionPrimaryKey")); /* Deleting refrenced data */
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
