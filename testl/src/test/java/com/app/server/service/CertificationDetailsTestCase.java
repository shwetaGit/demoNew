package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.CertificationDetailsRepository;
import com.app.shared.backgroundcheck.CertificationDetails;
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
import com.app.shared.backgroundcheck.CertificateType;
import com.app.server.repository.CertificateTypeRepository;
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
import com.app.shared.backgroundcheck.GradeType;
import com.app.server.repository.GradeTypeRepository;
import com.app.shared.documentmanager.DocumentList;
import com.app.server.repository.DocumentListRepository;
import com.app.shared.documentmanager.DocumentType;
import com.app.server.repository.DocumentTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CertificationDetailsTestCase {

    @Autowired
    private CertificationDetailsRepository<CertificationDetails> certificationdetailsRepository;

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
            CertificateType certificatetype = new CertificateType();
            certificatetype.setCertDesc("zPIkCe084NUhYGLv2xZ3a8QIGunnRIK8huWTmcSeK5kfOhoep8");
            certificatetype.setCertHelp("wF53vy41GyXuDClwVsaY4CnjdftdpjfhBk2c53qM2SrAIjjkrw");
            certificatetype.setCertIcon("e");
            CertificateType CertificateTypeTest = certificatetypeRepository.save(certificatetype);
            map.put("CertificateTypePrimaryKey", certificatetype._getPrimarykey());
            EmpInformation empinformation = new EmpInformation();
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(46);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488958986l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488958986l));
            corecontacts.setEmailId("2N4uVhgWQBlXNGoKDvTwedm5QsF2mgVSTu9K76QtOigFdtEM2w");
            corecontacts.setFirstName("wIZ9qyinndVkXcgd6un6Vn903amaZS2jyqpwkNGewSL2xLrHBy");
            Gender gender = new Gender();
            gender.setGender("87Ne5eQjhAAoqg9FQl6bDuty0g59MJPkNlG6MWMc2RYNxeTh7z");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("ZJ");
            language.setAlpha3("kqQ");
            language.setAlpha4("asj2");
            language.setAlpha4parentid(10);
            language.setLanguage("WXaYpFbpyQ6opYUiGxEH8LCukwQ6PHaBKZF6CdvxWeOdI0CoYB");
            language.setLanguageDescription("ocfwR0iE0r7oTDMinGJI78pTv7RD8ov1euDfvO1wAOPKam7Lns");
            language.setLanguageIcon("mdEyIPRQY3IaDNjGqLGmK3mhxixYaURxv4Hx3FlarXomFbBzgG");
            language.setLanguageType("IjnMvbRQP3g8VN0xGF302Z4QtOQMxiX8");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("tZ9JoNkUz7AtNRynQ8tX8EaYjhuiEjXjzWOHCSOHeg6zuDNzBB");
            timezone.setCountry("2A9EiLFHz0NwmAWijk21OAhE8LlN9aM874bV86EWwe4Hnva6Hf");
            timezone.setGmtLabel("MwmvtSTGAnFK030GSPHRdmygFKS04PdEYIvUVvVEHtH4z30fSt");
            timezone.setTimeZoneLabel("DslkgrmTDPohfb4nBlrNb30CNTaEssMpk5RaxnVkxaHqybKpOC");
            timezone.setUtcdifference(5);
            Title title = new Title();
            title.setTitles("QIOCfdsb4Li9WcEU2QdDFFCuZj5Hjxbt39IeT1cIb4igqvOJN3");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(103);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488958996l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488958996l));
            corecontacts.setEmailId("WFf13EjNUrtyOTBqN6SxuEMWVQnxJbNncn7UuQSacPM4O5kjbI");
            corecontacts.setFirstName("4COWdg2esYfw7kHf4gwX72CGHTRDKYJQTkwHc6vQ4TzfjPaVCp");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("1SDSYug2ADaNTFj0OleI8rMBO8hIPnlVu9oJnDhajpiXtKrEaS");
            corecontacts.setMiddleName("R6H0CPRGPRJ2NXtZhzVlFf2oNq2rfwRJeoely1C9G3M8IP09rM");
            corecontacts.setNativeFirstName("nxekYd4WsucyVFk48QDgpWDmClwj1h9bZNYQbWMRMyayvx2Mws");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("itVvJw3sKlJlAzGynQ5yOmNDO4bp22KEXIj8K0fQSoiUNbjiCf");
            corecontacts.setNativeMiddleName("GggMZnzuf1wETfAMtcpSieIKIOvxhEBar8vAunvf6GgdO1T2So");
            corecontacts.setNativeTitle("3kOAg1nbLwyUpk5fnasQlllkPr1yQSZSr0r8AW0HLnqqSuvOXV");
            corecontacts.setPhoneNumber("nrC7fWJjuZdzTpi7hFH5");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("BgQWyN0ROyNyOWDtSUwfr8E83KWiX6IAk41gbqxYasG4nWbYtB");
            address.setAddress2("C6uP4mfYuRyEAM0sRhUsK3GGP5fI9eGW5oFZkKycAefO23Air1");
            address.setAddress3("br4JeDsaaswrTKzEOktlUIGOIwoBIiCW4yjsTuAzG3DXAnxUWc");
            address.setAddressLabel("lnZlXPVv3ZB");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("Zzdr4h2QMrfzHsK4LyP3ofGvglw7XKb0fvGQzsxBlEa11nIuqT");
            addresstype.setAddressTypeDesc("r0e19uXOiv7lDIHCY6iNzqtuNYKii3a92lGTm3egdArTsr7Nph");
            addresstype.setAddressTypeIcon("WwGSvouWhLpSiXUjFV57vg8eCSaCDdTKf1QSxJrHk2y8y6wOfY");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("vljEwzb5ohUYjc0zFLlt9pgsWcnceh56");
            city.setCityDescription("1sYK9XUEfTCGZVOfkf7yIiyY7Bgx0828GNWmm0O4zcq3znP7Bl");
            city.setCityFlag("DbwSwYEcFp5pHNb7FrS6Qjn7mAygeIa0HH6VbAvo4VNupDKT5O");
            city.setCityLatitude(5);
            city.setCityLongitude(0);
            city.setCityName("V5DuMsE7UK3WAXXZsLDj7uV0sBT4pe55D0qevIN0Cc4mKoMmoP");
            Country country = new Country();
            country.setCapital("1QniPvYfl6zWJW0HPIN5BJXVmiL12GpA");
            country.setCapitalLatitude(3);
            country.setCapitalLongitude(1);
            country.setCountryCode1("V2O");
            country.setCountryCode2("NjV");
            country.setCountryFlag("VjMmYsUQcjpfQca2Zd1VhxZCY79j5PYuYrNElDhnWVJdQpA0SO");
            country.setCountryName("mQu2fmnYNza4x32UXKGS4tvWWUYwROFa4zdo30nYS7Vadk3xxK");
            country.setCurrencyCode("48m");
            country.setCurrencyName("5YDEL5fKXEFxI2bXVn8MhHkNl8qn4cAHolcxT5iSMNJoPc5NP3");
            country.setCurrencySymbol("uLP91nfGL5wRFqNlfpUxukAk1OY8nltk");
            country.setIsoNumeric(3);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("DFbj7Oo6TNLWcKBCPUUMuYc13eL3BajITzt1xdNdZZuxZRz8aF");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(1);
            state.setStateCode(2);
            state.setStateCodeChar2("V3iNLgLEr0kpgE2dngiWbbFaPJIGcayB");
            state.setStateCodeChar3("FBgmQme0PofZA2Hdb2ssnhxMpXX2Uw6d");
            state.setStateDescription("1eHzcvjwXiUaTB2kkCFYjdpNrQLOZNrnwXarb1UJYoLT8yX0ap");
            state.setStateFlag("W41jCoDPttc2XBeqIFiMdxA3HVB5RdA3A3ELP9AQIlFzMbaRNw");
            state.setStateName("n438n4rkKWNSmFxejyIFKgUIdIp4Ryf0na6NAuEFAKzncqc1nQ");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("OaFDUw158nfyFoPxQp1aPjARCJHMaZJN");
            city.setCityDescription("iaxyqgsggJTxNMBFbcEzs4ahaZkPFiPgrzNLpqbPsMo6PZDQs7");
            city.setCityFlag("i22L4VWcvyKN4nQzfdHCxIJRvb5zp1Wm6aLJCA8zLMu1r0zttw");
            city.setCityLatitude(11);
            city.setCityLongitude(11);
            city.setCityName("qVmJeneoMitOZUDyzYpQMraaThZ0DW9Tnp0FEk5YAeePRS67m2");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("RixYRmOMabYUaVO5NBsXXPotkb5HEX82WAVRAoAzwPWaTb95pm");
            address.setAddress2("ZpmU16AumwVkwXSg6DDxnp6WCSJrKIFtOkFhvEtfayvF0MqCPL");
            address.setAddress3("SsbvK1k02KsmcNlpJzhK0SrawVhrPPyL0uFtxcIFO2yE6nSEyR");
            address.setAddressLabel("xeFzQ6qyMTs");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("t0PV936mez5JlZyoQg3YABGsnmZj5Lf2pY7Nd31ZxBFdi1DQY7");
            address.setLongitude("v2tM2i4mhz7jeP8wKosZmfWY3OYs2OHQGnYN17dhHJJYPKOKIa");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("S6AUTQ");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("H");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("CjL2fEy8WLRF294LRuKibenWkiikINRP67zSy6dOjILnFQKCRE");
            communicationgroup.setCommGroupName("V9F0pykaRttsLQqOUhrLV0DtENbhJVYHnE8I6fRLaxoTphsP0F");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("wjW0GBpW2X7hzzedOXiKoxcHVmpgIOWqWd93SNqBozIB059y9g");
            communicationtype.setCommTypeName("3b1oYTqkZDIatGNK4MHmQ2OxYBSEGEbslhjPJdD3F9vwJ53ioC");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("d");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            DepartmentType departmenttype = new DepartmentType();
            departmenttype.setDeptTypeDesc("uiu5xzbwV4sBiUmaEwE2fnZHwf085HLeKdDHtRjJAmHG0DlSph");
            departmenttype.setDeptTypeHelp("wI2w1h4qZdi89eVCFUy4WxidAQOACP9MKY6Nxzv34UcZrHRgP2");
            departmenttype.setDeptTypeIcon("g");
            DepartmentType DepartmentTypeTest = departmenttypeRepository.save(departmenttype);
            map.put("DepartmentTypePrimaryKey", departmenttype._getPrimarykey());
            DesignationType designationtype = new DesignationType();
            designationtype.setDesignatnTypeDesc("3hf5nGjo68lTxiU8nHlfi1DxkvOewn5yDjKDHgH0VVj6072HpD");
            designationtype.setDesignatnTypeHelp("RNYLOgj2akGcRD1kO7WXX9xIDuxvWBNGvv7mcvehUlHD2tTxQ2");
            designationtype.setDesignatnTypeIcon("H");
            DesignationType DesignationTypeTest = designationtypeRepository.save(designationtype);
            map.put("DesignationTypePrimaryKey", designationtype._getPrimarykey());
            JobType jobtype = new JobType();
            jobtype.setJobDesc("MpY1zEb6ZjQwcqa3LroOA60AO66vjRSuupJpuvVdZteBccLSkF");
            jobtype.setJobHelp("EDyx7bLenlAW0Zmrm339r8QV4oe0q3LeAxUtV5t8HvpiJvHbHQ");
            jobtype.setJobIcon("m");
            JobType JobTypeTest = jobtypeRepository.save(jobtype);
            map.put("JobTypePrimaryKey", jobtype._getPrimarykey());
            Visa visa = new Visa();
            visa.setVisaDesc("07agYzogaxAqqD7ULGmNoLOMp7NyPrwqfSdTQflJ66bJXuGvrW");
            visa.setVisaHelp("2aTUc4TeCjXvT5h9dzLpOqkl2gdTtbGrgbShiUUhkWNPPR2iRg");
            visa.setVisaIcon("M");
            Visa VisaTest = visaRepository.save(visa);
            map.put("VisaPrimaryKey", visa._getPrimarykey());
            corecontacts.setContactId(null);
            empinformation.setCoreContacts(corecontactsRepository.save(corecontacts));
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            empinformation.setDeptTypeCode((java.lang.String) DepartmentTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setDesignatnTypeCode((java.lang.String) DesignationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setJobCode((java.lang.String) JobTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setpAN("XPZD1h7DTwdrIwNIkpHC60bWhhsFzXgdDADpV9L36zxOKoaY2B");
            empinformation.setReportingOfficer("CyrcPBaoUtQLHUsvEwk6N2OkBiWrAv1606efgQANFrApMdf0Yi");
            empinformation.setVisaCode((java.lang.String) VisaTest._getPrimarykey()); /* ******Adding refrenced table data */
            EmpInformation EmpInformationTest = empinformationRepository.save(empinformation);
            map.put("EmpInformationPrimaryKey", empinformation._getPrimarykey());
            GradeType gradetype = new GradeType();
            gradetype.setGrdDesc("HWS0jhLdVAtG5qqD3m43YBYG1HuurfYRaIpZ2WHJXbpOZ6P72F");
            gradetype.setGrdHelp("lk7ZttsSTjylP2GAd7ylQwnKU6pOi1WY5L0zsVOlvID62avbjQ");
            gradetype.setGrdIcon("a");
            GradeType GradeTypeTest = gradetypeRepository.save(gradetype);
            map.put("GradeTypePrimaryKey", gradetype._getPrimarykey());
            CertificationDetails certificationdetails = new CertificationDetails();
            certificationdetails.setCertCode((java.lang.String) CertificateTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            certificationdetails.setEmpId((java.lang.String) EmpInformationTest._getPrimarykey()); /* ******Adding refrenced table data */
            certificationdetails.setGrdCode((java.lang.String) GradeTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            certificationdetails.setInstituteName("m70lnjtXFXjiTlo4NjNEvDTF8sXq0BCE08vKGJWjSXfxDCfQfD");
            certificationdetails.setObtainedDuration("7BgpsTCz8YP9LPEimrZRsXBC4TJ3UuZMGDwWT0a2sWFYcoGjC2");
            java.util.List<DocumentList> listOfDocumentList = new java.util.ArrayList<DocumentList>();
            DocumentList documentlist = new DocumentList();
            documentlist.setDocDate(new java.sql.Timestamp(1456488959618l));
            documentlist.setDocDesc("qqs7QbU94vk8sagVYqynqaRExcrXkFvOV5ixvIurm1njAb3PDW");
            documentlist.setDocFile("6J9xm6h0ecAOLo2jDhKu1KXw1dDhlnoKjadqEuoHbjQoMgBRzv");
            documentlist.setDocName("wDH19YU0k0KqwXxvQduwVQq7NHskwwCpfizuBoYPr27X7emWyc");
            DocumentType documenttype = new DocumentType();
            documenttype.setDocTypeDesc("f1NJ9WAaDDSa7qzGd40XNTOolPMmCkh59zf6TOQJ2OpjBFHktx");
            documenttype.setDocTypeName("h7ztr5Mt2K1mjyN9SvfRbHKJwMQepHRKB4RLwzE7P1v2T32ZOM");
            DocumentType DocumentTypeTest = documenttypeRepository.save(documenttype);
            map.put("DocumentTypePrimaryKey", documenttype._getPrimarykey());
            documentlist.setDocDate(new java.sql.Timestamp(1456488959627l));
            documentlist.setDocDesc("LuFyPkfp55p7yfae7P7wu1oDGdew43Zt4NOKhiA6aK3mC8dfLd");
            documentlist.setDocFile("9JkWSdM2rYybqognFKgh7WFH6eOO0llHaXCA7oOwNdWYYbnbvM");
            documentlist.setDocName("a7Axxts9cFa4lnxl0mBkYO5WkVOQUCAOqiCvA5O6SuBeQuzrWn");
            documentlist.setDocTypeCode((java.lang.String) DocumentTypeTest._getPrimarykey());
            listOfDocumentList.add(documentlist);
            certificationdetails.addAllDocumentList(listOfDocumentList);
            certificationdetails.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            certificationdetails.setEntityValidator(entityValidator);
            certificationdetails.isValid();
            certificationdetailsRepository.save(certificationdetails);
            map.put("CertificationDetailsPrimaryKey", certificationdetails._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CertificateTypeRepository<CertificateType> certificatetypeRepository;

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
    private GradeTypeRepository<GradeType> gradetypeRepository;

    @Autowired
    private DocumentListRepository<DocumentList> documentlistRepository;

    @Autowired
    private DocumentTypeRepository<DocumentType> documenttypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CertificationDetailsPrimaryKey"));
            CertificationDetails certificationdetails = certificationdetailsRepository.findById((java.lang.String) map.get("CertificationDetailsPrimaryKey"));
            certificationdetails.setInstituteName("nSlBgKHgf2BsYiy9waV8aW6HABM2cgdaH9adClTUdFFgvVfKhh");
            certificationdetails.setObtainedDuration("9fFckuzcbh1oICLXyXQZoKw82S5CBUnNrDV6FRxYVVZKXUFgNu");
            certificationdetails.setVersionId(1);
            certificationdetails.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            certificationdetailsRepository.update(certificationdetails);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycertCode() {
        try {
            java.util.List<CertificationDetails> listofcertCode = certificationdetailsRepository.findByCertCode((java.lang.String) map.get("CertificateTypePrimaryKey"));
            if (listofcertCode.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CertificationDetailsPrimaryKey"));
            certificationdetailsRepository.findById((java.lang.String) map.get("CertificationDetailsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByempId() {
        try {
            java.util.List<CertificationDetails> listofempId = certificationdetailsRepository.findByEmpId((java.lang.String) map.get("EmpInformationPrimaryKey"));
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
    public void test3findBygrdCode() {
        try {
            java.util.List<CertificationDetails> listofgrdCode = certificationdetailsRepository.findByGrdCode((java.lang.String) map.get("GradeTypePrimaryKey"));
            if (listofgrdCode.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CertificationDetailsPrimaryKey"));
            certificationdetailsRepository.delete((java.lang.String) map.get("CertificationDetailsPrimaryKey")); /* Deleting refrenced data */
            documenttypeRepository.delete((java.lang.String) map.get("DocumentTypePrimaryKey")); /* Deleting refrenced data */
            gradetypeRepository.delete((java.lang.String) map.get("GradeTypePrimaryKey")); /* Deleting refrenced data */
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
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            certificatetypeRepository.delete((java.lang.String) map.get("CertificateTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
