package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.WorkExperienceRepository;
import com.app.shared.backgroundcheck.WorkExperience;
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
import com.app.shared.documentmanager.DocumentList;
import com.app.server.repository.DocumentListRepository;
import com.app.shared.documentmanager.DocumentType;
import com.app.server.repository.DocumentTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class WorkExperienceTestCase {

    @Autowired
    private WorkExperienceRepository<WorkExperience> workexperienceRepository;

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
            corecontacts.setAge(74);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488957133l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488957133l));
            corecontacts.setEmailId("LDRRNhOv0XuGGiMsBo3702ISYWfWuGPvg90xDb9cfBiqRhv410");
            corecontacts.setFirstName("I935PZQeIinyaG6RO0LMghW2vbrYgfK7Nykd4J183ck69jM9sp");
            Gender gender = new Gender();
            gender.setGender("6qif08HO54utA7BRwm040OJZfhj5vZNfsMXViwn8Jafm07xHDT");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("WF");
            language.setAlpha3("tnv");
            language.setAlpha4("5Mqz");
            language.setAlpha4parentid(5);
            language.setLanguage("6whlmBWpSmDqZUD3AgbPzA5m0mfwYUY47u8FUgYhwfmlRCSMBl");
            language.setLanguageDescription("WOWBFQRz0oOsfvIMdEYe3h2STKAXSojPmRyiP8tZts07g9gcMZ");
            language.setLanguageIcon("xoQ4q8tZg7wPk7i0loIjbvdTs0NIk9Vb315SrD2Feb1Xpnc9bt");
            language.setLanguageType("loUnidJAo8wSR5acnEFRajOgVzcZa6O4");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("qNYR3bYN7Bm9XehAzmrONPBBsvtSY2SVxQZarXtYHdFGxfcCrl");
            timezone.setCountry("5KT0YtA6EZCCR3ErTzZfH0XW5LvVbF3uFvIOZ3XYOT7oMbsbT0");
            timezone.setGmtLabel("fM9umo0GKzVKxLj0PjPccfpxqhIA5UFJYdXfysM3otUdQC6VsM");
            timezone.setTimeZoneLabel("r2GLeHSMvcToBfKvS9xkmgSeANp3hoabVb2U9zLDRyn2BsOrnp");
            timezone.setUtcdifference(0);
            Title title = new Title();
            title.setTitles("wClrsMuYNQ0dYzGIhCaqGCb5oncikLgqBqj9Yr8Ra5JswpuMeR");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(121);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488957146l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488957146l));
            corecontacts.setEmailId("tHyycw3S6r2C75aiWdHmZsWteOSD6urgbPWLXY0UamYjBYg9rD");
            corecontacts.setFirstName("fAoVfg68Ej8xMDjYh4JtPHxjbFYrcNXNIYo8X9If6Fi1VqquUL");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("eIWrQAzWuJajXy3gYtQuoDKDLUVh6xca2Yqv9zkzWKJarF930N");
            corecontacts.setMiddleName("WAbTXghrophwrIMfTp5YXvA3AAdjEebkI51ondzQ6tRi3ukAa1");
            corecontacts.setNativeFirstName("nunngc9et8WunR6Y3tSr6Cnb3nvOkm6KUY4bPv9lQHp5iwZhTz");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("ADrKieRwR7qM9bSesGOYniM3UPl6XyiHTt54BSEvmCB1LdxFaz");
            corecontacts.setNativeMiddleName("NUy7RVD3rKQwNE7k7I2vQdhhusc1p2J2C5eBpPVE6mtFZ8hPHM");
            corecontacts.setNativeTitle("CCMzaKQFotqQ2bb3DpxCF3uJsLKBHLK3rZ3eZilWzMuMetRB5k");
            corecontacts.setPhoneNumber("pyFh3Pf4OwsoOMTi3Yek");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("OCRhOuxzG0yGbo9ni0H6FLLRmABjUESRknP92vTRFIWjlQaXUG");
            address.setAddress2("zT26E2cyo4JH0ZG62dOm5NbH5v73xRYQxVzZroMzHznvzzShfX");
            address.setAddress3("n0OXYNEJAv0JXMwk1FvUcdSTFawp3MorJ3YCqCjpcNSPJ0ok2V");
            address.setAddressLabel("IzsyJv3nZzB");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("ApVyrZ4kiAKsmCNZ3stmvKy0SOObG3OFlUQgDYOgrhCLQH8F2i");
            addresstype.setAddressTypeDesc("Ts87SVRbSPTDPLYbQzcBBGLR7xL2mOyEM7FZKjdsdprMvKJBMF");
            addresstype.setAddressTypeIcon("wuxa5FKxDlp6HF3WLUUYlejGq3kwCghSLRUGrj5ykqNtwGL31d");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("LqDQGAFPE0ETNMMdBScydDjflGEADhE3");
            city.setCityDescription("BM43iw5Vs0vNtBacXTK9fryEnj3X7L44WmKQ99pXlYgHnBrofb");
            city.setCityFlag("dXViYcT6wkBfKd96hH5fugRVfYrh7fWwzJaIKXSW9bwwxYdMbR");
            city.setCityLatitude(9);
            city.setCityLongitude(10);
            city.setCityName("n1yMG5zLLAZHZDYMfCVTDz0gft2Q2NgLacHH28YthWpLqaeQOq");
            Country country = new Country();
            country.setCapital("uKhZ2CWOSR6469XQ0JXXRt6UN7WWYBrf");
            country.setCapitalLatitude(11);
            country.setCapitalLongitude(10);
            country.setCountryCode1("20B");
            country.setCountryCode2("h6g");
            country.setCountryFlag("P0fSx3eMgrti89lHLr8LLDkZIKn4JYFB9Ar2kdXzHvDXonQpxf");
            country.setCountryName("P0JS47mTD3w6RZSBop2wS68BqvdPUxzv277gip4H8kRlOoTcQe");
            country.setCurrencyCode("Ieb");
            country.setCurrencyName("kxiZCw32XbcvGQA2txEhkzAfvonE2kfYx1rNTNnsDEttUFGbI7");
            country.setCurrencySymbol("ZnI7pZAyDThfRFFQ3ITbqegrDtCfN4XX");
            country.setIsoNumeric(4);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("LSM8ON3cRngXNKsZ0J72W9XqNOK4SzAF1Flrp8W0YKkeB5XqtS");
            state.setStateCapitalLatitude(4);
            state.setStateCapitalLongitude(1);
            state.setStateCode(1);
            state.setStateCodeChar2("P9Jsz3JG7oVKKrGNkB0c5q1S3jf1yMtx");
            state.setStateCodeChar3("epihIIWXcKyu4LMmZoVLzoMx6sp83Xfg");
            state.setStateDescription("VTMu4Nd7gdZpZS2CGzhMLi2vEbfcR5Ib2hnKBCGsZOyONcTCqY");
            state.setStateFlag("u9PEMr81mAC8AaWLgncXQ219iJKG8nTcyWhOPgAXs8co8ChcXl");
            state.setStateName("23qy9TFMemiP7rzJLXszIA9s7prlGrf60bpsh256YsaRs8HFLu");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("NkQyZXVL65o0aihOuByoQi3kDYWchyhY");
            city.setCityDescription("eeJ1UKG5cWqYFvC6mlzcbnXcyi11DHNmB4Te9CcNvAwbP4VB0r");
            city.setCityFlag("P0NZXVcoTiqgNznW9H8RKfWzFrc2l8mbz6Ay1uUkjeYYdcZITU");
            city.setCityLatitude(3);
            city.setCityLongitude(4);
            city.setCityName("hAt8MTJKY6sgNfF9oHSK4Vpq9fVUuKnEustH0xc5sfgFCtFxT2");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("UZfKjsgs8kwZq40YJO49FidUqGsDUlLLnGehIeq6xQ3EbZ4zBV");
            address.setAddress2("uKwMZ5APC6LcCLXfp7KrB8O4lyUMNJoNH8FB10niMNuVWn0yK4");
            address.setAddress3("d9k1hE3FIaBeh03e4Kk3E4EUQ4N2bn175ZgFN43jCEoUaNbSqq");
            address.setAddressLabel("2RzCwA2ol82");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("L6Cld7UZIS8EEQ2DWLxTySGUeqG9dfgF7Jzc6am6Mox7xvg46Y");
            address.setLongitude("HYE8OHxe37jHtLX2n3JMBuj1vd7RoBeN7kKcbJ0LhWtm3o4E8f");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("Y05M0m");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("d");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("UoLIAClOOZrjH6ktziUBdWLuYs6vmydW2y78tcZBqRzXe8inXn");
            communicationgroup.setCommGroupName("omkdV0yUcB4n3oyH47mih4KQXzYfljHsT8wdVol8wVpfIgPffV");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("fNdiWxIcDC96gI4xCek4cIEamrRkJTeeJD5KDLpYq7HPuduxLs");
            communicationtype.setCommTypeName("envZ0i8cwFJL574QhvRqlaeuTLtzC8QNJkvFDgr4qhR5QWT9zy");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("J");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            DepartmentType departmenttype = new DepartmentType();
            departmenttype.setDeptTypeDesc("o0CRhZV4jlmiSTSGYM5YqoUxyEKSg3Jpkakt4eiJKxMfoHsD5V");
            departmenttype.setDeptTypeHelp("WMIyegIM67bGxt3Om1TXD27j856Fy70DByTCxxU192vOK6Y24O");
            departmenttype.setDeptTypeIcon("6");
            DepartmentType DepartmentTypeTest = departmenttypeRepository.save(departmenttype);
            map.put("DepartmentTypePrimaryKey", departmenttype._getPrimarykey());
            DesignationType designationtype = new DesignationType();
            designationtype.setDesignatnTypeDesc("86cGgIsZwtL4mEYI8CLJZzLsB89dTAGH96QxVZE4Vjy0sjyTWa");
            designationtype.setDesignatnTypeHelp("HhU2DfvdULKVh8UULs6irjQN1YgTUS6sYmiOE8uAizBex0QpT9");
            designationtype.setDesignatnTypeIcon("1");
            DesignationType DesignationTypeTest = designationtypeRepository.save(designationtype);
            map.put("DesignationTypePrimaryKey", designationtype._getPrimarykey());
            JobType jobtype = new JobType();
            jobtype.setJobDesc("5XvGIrSUw4x9eRJI4ChFcLYiOY3tUfBnMd1L2sWCKGIUKviINP");
            jobtype.setJobHelp("Vrp6ZYSWUElO8IxtOfoyMDb80SFITsUG24ObW5dj4SgXHooKNg");
            jobtype.setJobIcon("X");
            JobType JobTypeTest = jobtypeRepository.save(jobtype);
            map.put("JobTypePrimaryKey", jobtype._getPrimarykey());
            Visa visa = new Visa();
            visa.setVisaDesc("5QZGonJmBi07dBRZchaE9sO3dqqadCJmRDITCl1CuyVdnbE09e");
            visa.setVisaHelp("MTzoDJQ7049YqIvVl9xGyOd1CFNO2GITYrViI5hZmtudzh0Hgj");
            visa.setVisaIcon("p");
            Visa VisaTest = visaRepository.save(visa);
            map.put("VisaPrimaryKey", visa._getPrimarykey());
            corecontacts.setContactId(null);
            empinformation.setCoreContacts(corecontactsRepository.save(corecontacts));
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            empinformation.setDeptTypeCode((java.lang.String) DepartmentTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setDesignatnTypeCode((java.lang.String) DesignationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setJobCode((java.lang.String) JobTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setpAN("4tm6ktFo0yXbBtwQPAAGuAvcJpQ28Vw9h7PoIoDM4Fn0Byb4pH");
            empinformation.setReportingOfficer("P223Ff7pDNsHPBqGI0X0V8OUmbMu1pYpkHbppXkbNDeb1w3AmA");
            empinformation.setVisaCode((java.lang.String) VisaTest._getPrimarykey()); /* ******Adding refrenced table data */
            EmpInformation EmpInformationTest = empinformationRepository.save(empinformation);
            map.put("EmpInformationPrimaryKey", empinformation._getPrimarykey());
            WorkExperience workexperience = new WorkExperience();
            workexperience.setDuration("lUWYKObYRHUjtgGmfKikwBnyCsO5LhPgI6lEWFWeePADu8rpvE");
            workexperience.setEmpId((java.lang.String) EmpInformationTest._getPrimarykey()); /* ******Adding refrenced table data */
            workexperience.setImmediateSupervisor("oy3IiKQXpqqiR5b0Jes6jYX08iOuUWu8QoBXIsNxa92bEx79Bz");
            workexperience.setJobTitle("Qvz7z6Kg4M9Dsx63see2YChTeAHEENNdXQyb2oi25jtcHHLZsv");
            workexperience.setPreviousCompany("rpw0FVzhdD1MEXkfzrCp46TFcVjjtsEWyEqdmRP0BHkdgKT4jO");
            workexperience.setReasonForLeaving("awhGgmzTI887FbHPLCsXvXMsl6T4Uan0vGVnmSj75DoqQlfIzd");
            workexperience.setSalaryPerAanum("3MXoEBzqsLAOLcimi5arVHjdONH5NOhzX9rXwxQhO09Wm0wwjb");
            workexperience.setSupervisorContactNo("4JIchFe1kR");
            workexperience.setWorknResponsibilities("36cVEQ32n0kG3BRffrBTkHsctAzsH5R44w0SnHFLUsOiQr93FL");
            java.util.List<DocumentList> listOfDocumentList = new java.util.ArrayList<DocumentList>();
            DocumentList documentlist = new DocumentList();
            documentlist.setDocDate(new java.sql.Timestamp(1456488957809l));
            documentlist.setDocDesc("dXydtfS50ELLjYEQGG0fJl66ZcbyfZbT1rKWBjWkJCcRMWfxBL");
            documentlist.setDocFile("nIzm2bf9VsRrNQSIIKpimgbULzCG3Azquiep11n4QKDooKh58q");
            documentlist.setDocName("zvPw4ZQGOvKTlaRo38plZsr7mghWtEpnFgOSUnAtg5H3gbHfkO");
            DocumentType documenttype = new DocumentType();
            documenttype.setDocTypeDesc("WMs3xc6Xq4Ohz41DeXobMj41tpVL2F6zrCDUcqPpRuULRrtPFu");
            documenttype.setDocTypeName("Wpdpt81MkZGwIxxvT47RAhThwfHDalFued8ZEIeJxKTeh0sj3G");
            DocumentType DocumentTypeTest = documenttypeRepository.save(documenttype);
            map.put("DocumentTypePrimaryKey", documenttype._getPrimarykey());
            documentlist.setDocDate(new java.sql.Timestamp(1456488957815l));
            documentlist.setDocDesc("59u4HhG5ZGWsjrsczmN7PuuowhYrAnzl0LVJow3DbGa2GSO3Xc");
            documentlist.setDocFile("4rBr6msZKxKQjSoLywGfsC0NOXWmFWFqt34LVF0jhUhlCmWXSE");
            documentlist.setDocName("GOtW3CPtPudhIgscfZutdApfnutjBnU1on0ZWqiu98Ia3f2gmL");
            documentlist.setDocTypeCode((java.lang.String) DocumentTypeTest._getPrimarykey());
            listOfDocumentList.add(documentlist);
            workexperience.addAllDocumentList(listOfDocumentList);
            workexperience.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            workexperience.setEntityValidator(entityValidator);
            workexperience.isValid();
            workexperienceRepository.save(workexperience);
            map.put("WorkExperiencePrimaryKey", workexperience._getPrimarykey());
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

    @Autowired
    private DocumentListRepository<DocumentList> documentlistRepository;

    @Autowired
    private DocumentTypeRepository<DocumentType> documenttypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("WorkExperiencePrimaryKey"));
            WorkExperience workexperience = workexperienceRepository.findById((java.lang.String) map.get("WorkExperiencePrimaryKey"));
            workexperience.setDuration("2U5ZkxLmcw01R7JkWYVGgE1WglHLTRgit5w1mHbOulASx60ZNS");
            workexperience.setImmediateSupervisor("NTfJyDwJHITpx0eV3SRsti6DHajROkajEnXIzYw3RphQmfmHZU");
            workexperience.setJobTitle("MmglrPpFcXkVq6LOb76IiBHblUYMnIC4FPVH3J0IkwlLpK6tdL");
            workexperience.setPreviousCompany("Z9HrP3nkHXXZUtCflaHZ8anLAB8Iv9DGzi9sxvd0HJfLzxiTSV");
            workexperience.setReasonForLeaving("qqpbEAdRI4Iq0v10xacdFbkTSjdov1rzotiNjyT3NHGOQilfoG");
            workexperience.setSalaryPerAanum("ALGqQzDcBeHGxkEs7DYAVeWqBb8ut4qgRkzHQlHLxOc8BthlOP");
            workexperience.setSupervisorContactNo("pUAfQU6w6h");
            workexperience.setVersionId(1);
            workexperience.setWorknResponsibilities("LVW4thbmcYgLHaf6WDyhjmyQFYHn7MSCyoBPaKeXBBBjVsnK6q");
            workexperience.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            workexperienceRepository.update(workexperience);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByempId() {
        try {
            java.util.List<WorkExperience> listofempId = workexperienceRepository.findByEmpId((java.lang.String) map.get("EmpInformationPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("WorkExperiencePrimaryKey"));
            workexperienceRepository.findById((java.lang.String) map.get("WorkExperiencePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("WorkExperiencePrimaryKey"));
            workexperienceRepository.delete((java.lang.String) map.get("WorkExperiencePrimaryKey")); /* Deleting refrenced data */
            documenttypeRepository.delete((java.lang.String) map.get("DocumentTypePrimaryKey")); /* Deleting refrenced data */
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
