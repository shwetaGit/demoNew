package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.LeaveRequestRepository;
import com.app.shared.attendance.LeaveRequest;
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
public class LeaveRequestTestCase {

    @Autowired
    private LeaveRequestRepository<LeaveRequest> leaverequestRepository;

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
            corecontacts.setAge(69);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488949864l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488949864l));
            corecontacts.setEmailId("54Qv2MS5fx23qz72IeiEx0Q7V5MMgpgdO6RKCHuXs1Rf2HiKFw");
            corecontacts.setFirstName("04k6UdsxgMLpUxKzYxD2JH8EBBZkHxLFyL87jIv1f7fTLL1CB4");
            Gender gender = new Gender();
            gender.setGender("8sEitokRWUxzXsSbOVuJr4c9mQnfrMuLoogTewU0D8FyxZVkq3");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("Oc");
            language.setAlpha3("D8y");
            language.setAlpha4("qBly");
            language.setAlpha4parentid(9);
            language.setLanguage("HvdQF2jUwZlxNgYShXyzRLAacEi8zzUgFFUdGmZpGjbTjVigWt");
            language.setLanguageDescription("8DLkO1Rnsv00fDCoFaTrODCKbobBZkSBpbhYd0aWTn3Ami2DDd");
            language.setLanguageIcon("VNx6p5sTV4UIt0vKVFqFu3PhNnB2oDhiafsiS1gGQ4uXIHqRHv");
            language.setLanguageType("7jf0QfGb9tt2qx6DWhGILBClTSUSHfIi");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("5YPO4mTOqPQ5WdYDsEdUlmCCaFeYHBkNTEg0BH2PykrK1zx2jV");
            timezone.setCountry("btZ1xdNnAtzPRMQU3afGUjp4w9l7gqTsUljwh3gqQn21zaDFEm");
            timezone.setGmtLabel("tW5FxtOrqxtl1A3ksJSLugURJ9e17mYef4tKBpgLoUUMQpfIsy");
            timezone.setTimeZoneLabel("8veUBxAcG6SCryn5U6SPL2O4VQYqbkZcJJGNG7jSR4CS8zSPUK");
            timezone.setUtcdifference(9);
            Title title = new Title();
            title.setTitles("lntFHJACPU8poncyUWS0obzsk4VDkceayPUclgpb89avgFZWTX");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(49);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488949873l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488949873l));
            corecontacts.setEmailId("RqHeDXcxIujKbQjI1Z1NAsucBw56t0SMSHAGeB4kwnSjO1aswi");
            corecontacts.setFirstName("IaM0BmtjeFCy1lFYqGFbjEVXeMqmnQ99dSSMEY9QSq0Sspm18X");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("P0y2P6ifzrkKszKf2yUnolMOqbU9fLgalu85Ej9l0nLQzAgZ2o");
            corecontacts.setMiddleName("oJOeULMxm1oSpzSnMIH04b8qfQLwcfXeQmBV3POieCOHU7TeVE");
            corecontacts.setNativeFirstName("cLoA2DuU0d5kInupNEgjA5gB5Mn0D9NaplQ8bVWxHPRjLcSIaQ");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("DvsLt5xRGaFqloaqbIaacrAMmqYisSG64JngfIU3j4mhbEFSP9");
            corecontacts.setNativeMiddleName("deb51x5fg6gptEyOrXdJ3heQ7HxPvNca0RbrV0fkQoeg4Qvglo");
            corecontacts.setNativeTitle("eUfeQprCu7K8iXEEZqMeuJf5Q9w7dAtPqQIcpsDMZB5lzrNS64");
            corecontacts.setPhoneNumber("QZBmQMj6P5Q85eL251eH");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("jAvGB7PmCelCi6x9NOifkhQa6NrXZ44kBN8JAqzdU8S0bUHdlf");
            address.setAddress2("fgFPz68sPpU8JhttLYKW6oorQVWFaPhDdaFAGb9gTxXZRb2g7k");
            address.setAddress3("cVhUpSh0XnHXRSilk5EUZsb2Q2nsXoglrwpwqlb3twvbe5svv3");
            address.setAddressLabel("Pwxfrm1VTzz");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("KE7YGwHckOp5yxIL9ydCJ2WvyzdUxubOohltH5FbSUJAsUS9sw");
            addresstype.setAddressTypeDesc("7u7iCuMy6DjAxRfJdNrp9DzQt3dMBg2JkjCtSbco5vUpWZjVzZ");
            addresstype.setAddressTypeIcon("52G177Bfs1Qux2Qon7JZlO3rCuRv8NlxWguvP7AUF8lkLkCQXE");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("Ne5gpkLuy7AR9umHoq988BdEwYfgNtuU");
            city.setCityDescription("oviXPyUxUuWUnLPLhkIdefvaSzSC9CRPPxbJ2cGou1t8VIG6kp");
            city.setCityFlag("WU00FdX2Cy24Xj0nyMuJEOJCnTNlygRppTBarHzrbkIssO9MWE");
            city.setCityLatitude(7);
            city.setCityLongitude(3);
            city.setCityName("rmWjA5tQQzTx0pm0X0cAjQcxiDiJF2EV2OQm8adFo27JR5yeEO");
            Country country = new Country();
            country.setCapital("2F4kCcsezkMkgPH4TW5b2OUyMKkexf0v");
            country.setCapitalLatitude(7);
            country.setCapitalLongitude(3);
            country.setCountryCode1("2Uf");
            country.setCountryCode2("ejX");
            country.setCountryFlag("DU33fRNhJZLxr3VeLkxT98qoqDlraMamqf2hh2AfVTjExpL1f0");
            country.setCountryName("qSgkOXCPUnaJ61lCYL47cVA2X7URdGYj0mbAbYGqEsrYuExlpP");
            country.setCurrencyCode("KqL");
            country.setCurrencyName("WSctEBZb97Hly0ag2WpFhEDyCAscSg5lLJx9iTojODU5gaPHDs");
            country.setCurrencySymbol("uHDaWZJCJPJAajgP0hX8ZgfpfVdULTxQ");
            country.setIsoNumeric(3);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("hSHboTPaVdQrYUAVPSimfxQsGtyWK1YCoHCBo5Hv14CwSlzLeE");
            state.setStateCapitalLatitude(2);
            state.setStateCapitalLongitude(0);
            state.setStateCode(2);
            state.setStateCodeChar2("etFZxDVMwbrGarbVoBBuuPmLNlZ8IFkg");
            state.setStateCodeChar3("sW3E8yRp2Zx3tvtQ2E6ZC6wKTIAIdJlE");
            state.setStateDescription("lSZlQk6W3AlrjELLpYLVARrLNGn8B5oZVg0tjbMGsUiLpt7CUi");
            state.setStateFlag("7IoU5cmM89b3nrLbM9LjM0DL2JvT31W3hBmKPboivxLSmvcdRT");
            state.setStateName("ZduawXMNxY3KlFjinJqsk7c99ypAhChpsWgATeMipa1m8e0UvJ");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("bft2BYU6U4sM8cHCRYsx5aUDzr26BxyT");
            city.setCityDescription("qbgnA4YwTtTYaDLAP1rPUkUDuZkCtztu895jQjzxl9JwSdGrLM");
            city.setCityFlag("AMcdPUXxetH9NPZAx8ylzg8DznneM6sCzK0lnREaNwflGPda0M");
            city.setCityLatitude(3);
            city.setCityLongitude(0);
            city.setCityName("CoZeRtjXVaDUkvLSDuiIzFuJV30xkdYlER3Bl8jZQWNOy0aUX5");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("nITF8MamQJmrGAtwsreGuxStjWjSRtA8I6Xd6ZroJxHBV37rsC");
            address.setAddress2("K0L7AgInIQto0sp49rzJXaOm5Lu4JUo8yh9WHoWoFy8foaSadF");
            address.setAddress3("TkpihOIB7U5rL7ZLTyMIbtSfT2Gho40vtMSVgpOTHaIC4h3Ua4");
            address.setAddressLabel("dl2tv2VVbKA");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("lhfSl7qfumBMH2WqujXsJWxJ8bcjQcJzr48FQMoyuX68iRQzFG");
            address.setLongitude("QRCd0AQ6q98vs2VbGuKXYxoRjTrD0UxzDyB6wUzDt0vTfKMsAQ");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("nNbC0q");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("t");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("Yd41KIVZwXpVM6jjfd317XHkV16IowJ2S2J4TvVbRN9HMPzDC8");
            communicationgroup.setCommGroupName("OmFvxUJHIEw741ajTS8HELCVlZMB6UEzlrCGpNUGprWvVpAekM");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("8e7ZU8XBs4zeXkK3qnS4HE6MhEu0vluIbJsYULgblz3QNjB2OG");
            communicationtype.setCommTypeName("ubuc55tTmzyXdg8MuGtvBGOmht11Mwq0VQS3aIvFyN5kd6aYQz");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("w");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            DepartmentType departmenttype = new DepartmentType();
            departmenttype.setDeptTypeDesc("9kffjVCjdDEq9nIiwohzHI6ZHlyNSxc31YFKOF2zFOtKNP7ceN");
            departmenttype.setDeptTypeHelp("qqlVKL5yBOQjV4Oz5fJUi5oz6fIU9cp9oUqIrhEeeZQEX8dXsd");
            departmenttype.setDeptTypeIcon("k");
            DepartmentType DepartmentTypeTest = departmenttypeRepository.save(departmenttype);
            map.put("DepartmentTypePrimaryKey", departmenttype._getPrimarykey());
            DesignationType designationtype = new DesignationType();
            designationtype.setDesignatnTypeDesc("hnD1y2cJU1luTnPnJ5wazVyVa3imNYNgydRSdoL7jTIYctPFBj");
            designationtype.setDesignatnTypeHelp("joc3GNrVTx4rRbcRhoDjGtdahpAwlRo2VNMmaA3damVX5qVWri");
            designationtype.setDesignatnTypeIcon("f");
            DesignationType DesignationTypeTest = designationtypeRepository.save(designationtype);
            map.put("DesignationTypePrimaryKey", designationtype._getPrimarykey());
            JobType jobtype = new JobType();
            jobtype.setJobDesc("7vg0Talhu2QZLotGda98ABzEnOntNZ1MFdlYlkB6CIN2e89ztk");
            jobtype.setJobHelp("4uaKnS34MsvtNyZX9XD8xuytzxaYReiAfZWzxDNN02HDiW33sJ");
            jobtype.setJobIcon("S");
            JobType JobTypeTest = jobtypeRepository.save(jobtype);
            map.put("JobTypePrimaryKey", jobtype._getPrimarykey());
            Visa visa = new Visa();
            visa.setVisaDesc("ajFDTBqAsFWV7odVl8ENrBBfHV4alzb5AFLy9jUiUvG3FXKqUS");
            visa.setVisaHelp("wOX7W9uLvapMR0cXsJkFF2aPTlNWPQrLLgWjVwncxxvzLu0ZRp");
            visa.setVisaIcon("h");
            Visa VisaTest = visaRepository.save(visa);
            map.put("VisaPrimaryKey", visa._getPrimarykey());
            corecontacts.setContactId(null);
            empinformation.setCoreContacts(corecontactsRepository.save(corecontacts));
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            empinformation.setDeptTypeCode((java.lang.String) DepartmentTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setDesignatnTypeCode((java.lang.String) DesignationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setJobCode((java.lang.String) JobTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setpAN("ub34GLEJlScm5Ob0T9GbadrmkAEuleMdY3J4jPRh9N4q6OwY58");
            empinformation.setReportingOfficer("5zYhdm0KdY74A85sh0UDQm6tXOLjZ78UhO3ygSEGjiwJQc0tC5");
            empinformation.setVisaCode((java.lang.String) VisaTest._getPrimarykey()); /* ******Adding refrenced table data */
            EmpInformation EmpInformationTest = empinformationRepository.save(empinformation);
            map.put("EmpInformationPrimaryKey", empinformation._getPrimarykey());
            LeaveRequest leaverequest = new LeaveRequest();
            leaverequest.setCasualLeave(6);
            leaverequest.setEmpId((java.lang.String) EmpInformationTest._getPrimarykey());
            leaverequest.setFromDate(new java.sql.Date(123456789));
            leaverequest.setMaternityLeave(0);
            leaverequest.setPrivilege(5);
            leaverequest.setSickLeave(2);
            leaverequest.setToDate(new java.sql.Date(123456789));
            leaverequest.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            leaverequest.setEntityValidator(entityValidator);
            leaverequest.isValid();
            leaverequestRepository.save(leaverequest);
            map.put("LeaveRequestPrimaryKey", leaverequest._getPrimarykey());
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
            org.junit.Assert.assertNotNull(map.get("LeaveRequestPrimaryKey"));
            LeaveRequest leaverequest = leaverequestRepository.findById((java.lang.String) map.get("LeaveRequestPrimaryKey"));
            leaverequest.setCasualLeave(0);
            leaverequest.setFromDate(new java.sql.Date(123456789));
            leaverequest.setMaternityLeave(3);
            leaverequest.setPrivilege(10);
            leaverequest.setSickLeave(9);
            leaverequest.setToDate(new java.sql.Date(123456789));
            leaverequest.setVersionId(1);
            leaverequest.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            leaverequestRepository.update(leaverequest);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByempId() {
        try {
            java.util.List<LeaveRequest> listofempId = leaverequestRepository.findByEmpId((java.lang.String) map.get("EmpInformationPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("LeaveRequestPrimaryKey"));
            leaverequestRepository.findById((java.lang.String) map.get("LeaveRequestPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LeaveRequestPrimaryKey"));
            leaverequestRepository.delete((java.lang.String) map.get("LeaveRequestPrimaryKey")); /* Deleting refrenced data */
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
