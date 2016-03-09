package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.CostToCompanyRepository;
import com.app.shared.payroll.CostToCompany;
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
public class CostToCompanyTestCase {

    @Autowired
    private CostToCompanyRepository<CostToCompany> costtocompanyRepository;

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
            corecontacts.setAge(42);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488962666l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488962666l));
            corecontacts.setEmailId("rzCKJ4nKMaQlPBMFdd4cCmk6b2azYgJPVNB8kqSnmUxGiM6pAu");
            corecontacts.setFirstName("SS0kqNbUZ7VoD9FYjc9Ye5LiVIJRFbBU4YrCuTuxEbNrSLE9CS");
            Gender gender = new Gender();
            gender.setGender("fVyXNQRkLnnbnEsgP8eCfeYo5XD240lZ3PiBt5YDkn6odV3rpd");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("AI");
            language.setAlpha3("2Qr");
            language.setAlpha4("VZib");
            language.setAlpha4parentid(2);
            language.setLanguage("YOYN1HW1nJJ8bA5cNO4CK7d2nVOluOptaSZ2I4hYYOi1xIeLoJ");
            language.setLanguageDescription("VL4w5nX4T67D4I2Qbjs488c5f4pXNocIZClWe8GR32McUvnxEc");
            language.setLanguageIcon("PcNzoLkbH6MQBooL3KiGPVkqrSE7c8keNdmSzWVbHhULeyDlFb");
            language.setLanguageType("sMKmjFEeI1c90vIrjI6r7iVlbrMQkqrY");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("Oz5mVLlBR3qW374nIviUqXCFfNFpp19mNCRZvXfpHXXp0WsjBm");
            timezone.setCountry("GRgGGsjLKkYtxY7pERRbUtTSFsttCp05ORsQD5TPrmcJcoBGkZ");
            timezone.setGmtLabel("dOU2HegTZrEzWRMRXn8McM0XOvHBBckHUfC9YAwkQtLRqv4t72");
            timezone.setTimeZoneLabel("9yCCubIPCXQNpFsnvLV8oTeLsl1PlFdKxAh9KyLBmweR1OwUpK");
            timezone.setUtcdifference(11);
            Title title = new Title();
            title.setTitles("es1QVO55w4VWRFJlmfcsFCtrKSDOszpQE1xONdm9m85hKIRfdy");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(87);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488962677l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488962677l));
            corecontacts.setEmailId("Axh0uO7sldWzoGiYTKnl7GbR9TTWqje12RcQhhskO91w1ghCnH");
            corecontacts.setFirstName("zsRyYNzUF8gHU6ByYc1tVS0aXSfIXIBZzneOVkz5ff7GirPIl6");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("CXKXModP4QmKfAosPNdZ5P14sDyChnWzpuvIe2isycEr7zpNF8");
            corecontacts.setMiddleName("sZXCYPXnZkg9hrFgR5xUdNMcDGE5Af2D0w6DjvckxqJj5rQj6L");
            corecontacts.setNativeFirstName("poekoI7b1TKTgBh6htz7lYyc5jYc3j8ctBHaFQWzydCMdrpOBq");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("psM9jFkhO78XPLSFPw0UP6lMrTKzzlvKVPHv4C0chbLMwFvWPQ");
            corecontacts.setNativeMiddleName("wblwUAaPMhVMV11YC1kYUPwXg2GBlxrjzfWityyxVVJLvcQBTT");
            corecontacts.setNativeTitle("OJTN54qOA7KHHeGicWM9lx4lh3KhOZg9OhoOlwOCmKMg4x04De");
            corecontacts.setPhoneNumber("GtNHs6X90IzBQbXU7OfR");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("EVSkAhQaN0u1vxfV61kPYnoQZAAdT6mRajMQOv9XlceMJ0iXNH");
            address.setAddress2("y72MsSrcJMYIWadpd3d4IBQ4OBFjWgGr5Hq8l7nezFBMt1cOme");
            address.setAddress3("yaEDoSAxHAQs6JLEDnpuVFsk0GGsZwZOhOaXG6W7bKfJ1oizcI");
            address.setAddressLabel("D9G5SgA6N90");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("3X2GjIgYmrIyjlE3vPrRCCOzg5L9EOSsQUT76ywyLR3wsmnIhl");
            addresstype.setAddressTypeDesc("q5NLstT7WpDU1o5IhLwRbLJKpjJyJAbWnoR11CYC0NvWUaFj0H");
            addresstype.setAddressTypeIcon("X3AlZYsMuvgPHwkTzXQyEnSKnUZaZ36SgJkjmgB5snIfHEI42H");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("7AdXlyAeuL5ZH4ppoZCjdV9BMVtncNbj");
            city.setCityDescription("QxsEjGSHGVRHlwH1tPk28VCy6tZkaKQQfgrbQD6Xw47eIjfyks");
            city.setCityFlag("HaL9s0LiRgMwYLc7aLVA4UsHtHJXYoyCFDlQuCOkNnx4pipGnd");
            city.setCityLatitude(8);
            city.setCityLongitude(1);
            city.setCityName("DbzkssHrZjP5QPWGyHR8ypTEeHY4w3Oywlhlr1JncEPBBZI66A");
            Country country = new Country();
            country.setCapital("p9VSD6A3dfD6pMXrExUdcog8HEe0Tsx3");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(7);
            country.setCountryCode1("80U");
            country.setCountryCode2("3cD");
            country.setCountryFlag("vn9ZWmw0s3j11bHXDdj1objzZuKE5EbG6xlNyf1eF83iudU1A4");
            country.setCountryName("5zyFYJgR2vZ09bkUHHKki2Gkamzq0Io86gT2k2OkX1m5izH2tO");
            country.setCurrencyCode("nvf");
            country.setCurrencyName("W2atmuipIf8fmxYRR5SghMhmCEm31SfdZNaPv8Rahz4M8vSrCX");
            country.setCurrencySymbol("Pl8uIuQHr5vve3J12yxP9q7I1zQbBIpK");
            country.setIsoNumeric(0);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("wYRcsZCwrWUkPTeQN79VdzX10lqWhk58WGFuQNupTkwI1bJhv2");
            state.setStateCapitalLatitude(4);
            state.setStateCapitalLongitude(8);
            state.setStateCode(1);
            state.setStateCodeChar2("e3dLT1QpBb1pCdWS4NEyEsHkP2i5WG9e");
            state.setStateCodeChar3("HjjkHAcDkwNNasXGnoaclFlH61MCSYFt");
            state.setStateDescription("E29Nu0986s4M2PWObXEEnucfFgKxbLpe3ZZ48BNqF1GQI5DLAo");
            state.setStateFlag("c5E5rM67mGnJ6QIVIdzJRigN6ZcGDO7g57iQgHyKUPs4KjyqP4");
            state.setStateName("q9erEX9o44d2zVvwqttL2SGnWNMeFnmbhiQBP2CrJcBxQH41NQ");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("0vOClmkjl1cFzgtzFz0dEJG3rG7PnEIo");
            city.setCityDescription("s1DNOujLbZa3YS9l3mnOMIDFOMrkN1X2bzfw31poi7JKhpYKml");
            city.setCityFlag("E4MQb4pDnOsIJGtCivI6RqY9SMUca9cUnW81iWks9zHRy5rgAG");
            city.setCityLatitude(4);
            city.setCityLongitude(6);
            city.setCityName("GXGYKGcpkwiEM9b2NPbMWT61L9b0fpzcrPRdS3NFjqPahgNWps");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("xvtuZhbqpuOWykSbuBL5MFENyTxjZ7qTWeEqbiW47Gf5fq97v4");
            address.setAddress2("T8XcupuXIwWmQzQaBiRHA0dcrzOnMo14domf9xIOec0nphfSKu");
            address.setAddress3("gB66rE2MV4DaQJGEkNRZidotAB9LoMd1IIAPj0dCKRwXp8R6cf");
            address.setAddressLabel("iV2vnhiT5Xa");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("sJHEYoK6mXvksSwQYaeTiYwg4ddjEBuMrjC50s9CHENcuaS0w7");
            address.setLongitude("69JY6D2FRr10TbornJy0pI2OGuaBBwdnCLsm98RMCKrCKa483d");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("z9yQr6");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("h");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("nH5BXaywH0A9O5Za1TnrxNr2PCCWLzvISdNlKD2x6CewocLc34");
            communicationgroup.setCommGroupName("XjOQR1iudoFJizPBFLrlFFf633xZUGZmb60xB693W4WYFxcj7t");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("2Q9DSTbMGarTZduo8C4XF3FiDGke9tyN6q2cSoqN8mx8jDez7x");
            communicationtype.setCommTypeName("AZycdy5zKDahKDBoiO9FOsuE8SeV7mu2FtZaQe61uQOvV9iHEc");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("c");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            DepartmentType departmenttype = new DepartmentType();
            departmenttype.setDeptTypeDesc("HOeNdj9MmMLMRS7GmE2wlXO2TgNjgzlSI6Z2ECvFFY8xrwwrCI");
            departmenttype.setDeptTypeHelp("kB25NZdOP3hHuJkKNgMXxcnT7b5YoNx0sCHQkecx5HUM3ruwOW");
            departmenttype.setDeptTypeIcon("d");
            DepartmentType DepartmentTypeTest = departmenttypeRepository.save(departmenttype);
            map.put("DepartmentTypePrimaryKey", departmenttype._getPrimarykey());
            DesignationType designationtype = new DesignationType();
            designationtype.setDesignatnTypeDesc("CZOAN2VJspzqTWz4JYXbTvTaIrB06kkexuqpD5K9TXDo2InM2h");
            designationtype.setDesignatnTypeHelp("RS3Y5gpJE4WHPIh9I0CTGGa0RRFaN6quxgUWnFCMziXSBl7uNA");
            designationtype.setDesignatnTypeIcon("g");
            DesignationType DesignationTypeTest = designationtypeRepository.save(designationtype);
            map.put("DesignationTypePrimaryKey", designationtype._getPrimarykey());
            JobType jobtype = new JobType();
            jobtype.setJobDesc("0U244QBax313m6YUJxXwcrUIviDiCDq33vU5TOhtigeplre0mW");
            jobtype.setJobHelp("PLFB6znNZQY7jeKLBZzIMVvQw8KxyMxQtE3kFcACTpWxR3BNfL");
            jobtype.setJobIcon("M");
            JobType JobTypeTest = jobtypeRepository.save(jobtype);
            map.put("JobTypePrimaryKey", jobtype._getPrimarykey());
            Visa visa = new Visa();
            visa.setVisaDesc("S8Ky909fhmTiWl7Zc0YlaDS1CxCOa5dVVAhmb9s8kU8tUEAk04");
            visa.setVisaHelp("KJdMqbYp4xhb87PgWiXeWPYESoIV0KjZvEiER1Yqw4juhfAwg0");
            visa.setVisaIcon("Q");
            Visa VisaTest = visaRepository.save(visa);
            map.put("VisaPrimaryKey", visa._getPrimarykey());
            corecontacts.setContactId(null);
            empinformation.setCoreContacts(corecontactsRepository.save(corecontacts));
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            empinformation.setDeptTypeCode((java.lang.String) DepartmentTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setDesignatnTypeCode((java.lang.String) DesignationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setJobCode((java.lang.String) JobTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setpAN("OONiNqsMJhKSav14NHUKcKpXM32f9jgQLKFbJOXHgndmNrdibg");
            empinformation.setReportingOfficer("rTZxi8Qh2442kyBFQQy1wU3cwlHx7tHyDrx4ENN0WMkpimD7aC");
            empinformation.setVisaCode((java.lang.String) VisaTest._getPrimarykey()); /* ******Adding refrenced table data */
            EmpInformation EmpInformationTest = empinformationRepository.save(empinformation);
            map.put("EmpInformationPrimaryKey", empinformation._getPrimarykey());
            CostToCompany costtocompany = new CostToCompany();
            costtocompany.setBasic(12.34);
            costtocompany.setConvenceAllowance(12.34);
            costtocompany.setEducationalAllowance(12.34);
            costtocompany.setEmpId((java.lang.String) EmpInformationTest._getPrimarykey());
            costtocompany.setHra(12.34);
            costtocompany.setMedicalAllowance(12.34);
            costtocompany.setPerk(12.34);
            costtocompany.setSpecailAllowance(12.34);
            costtocompany.setTakeHome(12.34);
            costtocompany.setTotalCTC(12.34);
            costtocompany.setYear(0);
            costtocompany.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            costtocompany.setEntityValidator(entityValidator);
            costtocompany.isValid();
            costtocompanyRepository.save(costtocompany);
            map.put("CostToCompanyPrimaryKey", costtocompany._getPrimarykey());
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
            org.junit.Assert.assertNotNull(map.get("CostToCompanyPrimaryKey"));
            CostToCompany costtocompany = costtocompanyRepository.findById((java.lang.String) map.get("CostToCompanyPrimaryKey"));
            costtocompany.setBasic(12.34);
            costtocompany.setConvenceAllowance(12.34);
            costtocompany.setEducationalAllowance(12.34);
            costtocompany.setHra(12.34);
            costtocompany.setMedicalAllowance(12.34);
            costtocompany.setPerk(12.34);
            costtocompany.setSpecailAllowance(12.34);
            costtocompany.setTakeHome(12.34);
            costtocompany.setTotalCTC(12.34);
            costtocompany.setVersionId(1);
            costtocompany.setYear(3);
            costtocompany.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            costtocompanyRepository.update(costtocompany);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByempId() {
        try {
            java.util.List<CostToCompany> listofempId = costtocompanyRepository.findByEmpId((java.lang.String) map.get("EmpInformationPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("CostToCompanyPrimaryKey"));
            costtocompanyRepository.findById((java.lang.String) map.get("CostToCompanyPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CostToCompanyPrimaryKey"));
            costtocompanyRepository.delete((java.lang.String) map.get("CostToCompanyPrimaryKey")); /* Deleting refrenced data */
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
