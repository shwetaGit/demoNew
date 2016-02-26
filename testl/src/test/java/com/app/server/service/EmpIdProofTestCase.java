package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.EmpIdProofRepository;
import com.app.shared.employee.EmpIdProof;
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
import com.app.shared.employee.IdProofInformation;
import com.app.server.repository.IdProofInformationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class EmpIdProofTestCase {

    @Autowired
    private EmpIdProofRepository<EmpIdProof> empidproofRepository;

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
            corecontacts.setAge(104);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488947896l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488947896l));
            corecontacts.setEmailId("C9yYS9L68AKSDX4Wdkfsv9KuXyxm0hEBVuiOPHkY6GzEzxwUoN");
            corecontacts.setFirstName("6pkImUUcUbDTyP3HTfUdkIfk16G4nOOUExm0mEoefHHRTio6hz");
            Gender gender = new Gender();
            gender.setGender("hXzx0hpiMylKoBQs8ylnnTl7VFYAx6UD0NQtQBkvRqAvhQSJp3");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("en");
            language.setAlpha3("F0U");
            language.setAlpha4("Bwns");
            language.setAlpha4parentid(11);
            language.setLanguage("KSDzzRSKeJJSpceqYWZIPJbIQv4hcSlTr6B9RgTXP8vGzdaZwE");
            language.setLanguageDescription("rFsNwu5J9cSOzyj7WjDzvfuXxv4Myy82uZHS9sxbKlBIPwvGMG");
            language.setLanguageIcon("GjMc700SZ0tqWuISAVl30jHZ4FjBoqdUPLvMeZZvYHctBea8sE");
            language.setLanguageType("mUyJz3Mm1BYJeUI4gxdq4q0a9QtgFkQT");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("QoUGTbf7fTEplSxUBaE19VUwVN3KMKON4cZvtyx2vwmvwYvDbs");
            timezone.setCountry("50lKkviUAWRx0H1upl5zG3sojrij1dw56UgkgW7H2EDh4BjFxq");
            timezone.setGmtLabel("R8WKwDQVRylEDPi1JSlZw7jh5Ln7GLCMYiOsv5GBmCvVEfF3Ch");
            timezone.setTimeZoneLabel("FGkaQcVjW5dXbeBpYcE0MQU0SbPHQHyXkSRaEF40tcDXsRsYQG");
            timezone.setUtcdifference(3);
            Title title = new Title();
            title.setTitles("nB6OefKsVCOY0G45XZjgtgPIcL69mPivtydEcWREwoFDYpLHLB");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(119);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488947907l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488947907l));
            corecontacts.setEmailId("lICs7aCG9SbMbglD4prcDSyw5DGk25impVMQyKoEzqpOLSPF8e");
            corecontacts.setFirstName("2csfnjeeCG1kUvLQneDFRPy5nGCGGIFyY8sJC9OJshciKt1Rr4");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("gx0fE349zmyqfEYrWsVyExY20ewkHVkGJoiPANEbFENf494vyR");
            corecontacts.setMiddleName("tCRqzdryyZfctHjI3mvzjp7wCHJfi3vBEySTADmfBI3YuRch04");
            corecontacts.setNativeFirstName("IgHRRcMzZpkn78Fd2FOsXyegBFpcZtS4FsTYQHQqf1jUZv3VEI");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("U1AxBhXk8IPFjDqLXXHPQokenHum4pS75kYhGDMisPVi71Ezuv");
            corecontacts.setNativeMiddleName("yVdEufACiAqtVcnmgelWe7BL6UAYETL3aH7rysmUQOljQzucrH");
            corecontacts.setNativeTitle("KX48Be1tLX9iCtATkvgVH7Q2ywzOSgpqQGcAyBzpxx2pKSWyyC");
            corecontacts.setPhoneNumber("uOJuksYsjhksIaMYr8KI");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("90QWCP6ekUGFuNacgBWyvXOqwedYWfDmfkUmOezItDZEs8CdmP");
            address.setAddress2("CqGW2ZcRwRoal0tzmTY0GuYnITJ982onC8cwmFOtwBRE6nAzXA");
            address.setAddress3("qhB4DbBfLMula7XBM7KgRrAWyrCLDOhYB9KUVxEFumefDcsVew");
            address.setAddressLabel("Gce6sVPi52e");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("V2L4zRFIAYLFSZWZJ3ErigrDAIQZPFGbd9AtB3X36G9GdykpC8");
            addresstype.setAddressTypeDesc("uaMh7DSpCWFbo8QiEhJ1VIspEJ334Im9wqDDlaBwQzMg7TSYmc");
            addresstype.setAddressTypeIcon("cOMmN29qsC6X7loGocuGpCoYlJGL8nGpNuCkGdVAMBtxsznGy3");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("tiKycXZYUnLAVQuCmtbtggqaJSgIiGGq");
            city.setCityDescription("fretm6hZ8nZNSpd7BbHSwacjsOq1vBu9GHEZweKosAL7I1R7u0");
            city.setCityFlag("TXqcW4cflSCdMAH2txv2TD5RwvotpJya5XgDGZTHtuAjv37TQZ");
            city.setCityLatitude(7);
            city.setCityLongitude(7);
            city.setCityName("NsWmgoOAAnoOLcxdcnl0g2BrL9x0Hr9mgevru7whz7DwMtMEAA");
            Country country = new Country();
            country.setCapital("2lSARlSyYmX8SHn2osTNpTaEGPCIHpWL");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(9);
            country.setCountryCode1("CJo");
            country.setCountryCode2("9HV");
            country.setCountryFlag("HsxTo6EcqSFQ6WwZshXHvlzxKKYpE9J9vjgAyPiOsZuGTmtSkz");
            country.setCountryName("x3VdTTuhvxu49DXJrY6nP1js6hg50BDxg1YakzYh5pdzg3TLO8");
            country.setCurrencyCode("gwZ");
            country.setCurrencyName("pPTbpneZncwsCFKii22yRJIYCq89D9EQNLhDehK8tcybfcJzj2");
            country.setCurrencySymbol("q0r69k7dX64tPnieGgxQLgHrohy9HkUp");
            country.setIsoNumeric(5);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("07XGuT182SIKNhNodQ6zivP9E7QiC37MmplbG3eufxSTQeAqtV");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(9);
            state.setStateCode(2);
            state.setStateCodeChar2("RA0WiQLDPTCb9YO6PYFFqITk0SeyjHFm");
            state.setStateCodeChar3("xJbstdwZbnh1l9xtHsaNOB7mHjDTuZp7");
            state.setStateDescription("FvnS9yrtJ5VvbacyB7PvjO5koATYq3gYzGgNA7bBhuMIBYj7Tf");
            state.setStateFlag("AGVRlFuarM0ipzXaUTMvk2omHcgXSVMIiVOmSrDXhXj33Q4hWx");
            state.setStateName("UBmazHCBPzGxYclQvSzHvbA5tJmo2tDAncUxoxgakZxjpwYolQ");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("jB1dQodjRDSAr6w3e7Gpn532l9Yo6BQP");
            city.setCityDescription("kvbukPo4vwiThiVv1rIz8T0EvbM8vjGfRtfW276txTYXlyQc9d");
            city.setCityFlag("lPZOZj1CJUTSpYmdCsnCxMjGdyCtNssUEkn5I4br7bcodE8yCC");
            city.setCityLatitude(0);
            city.setCityLongitude(2);
            city.setCityName("TKq5Hn0o5pgBAqiZfSOAifHmUmqM1kq7iMHBysUKIDjR2ECafm");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("mFc65MWHZeiRbYWEclr4rs9m2espSMsUv4Pc3V4I2gW7ZzkOmd");
            address.setAddress2("jRoyNfnVU4vBgnhqyqDXOrLXpOdNNeFSOkqYYOyonxN4iX9iHa");
            address.setAddress3("MSevoJ4brsUSNfLDfNxOEySFHu39TnNhxtBs8XbECxfHZ7DL0Y");
            address.setAddressLabel("rE3kyTddlOI");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("HHqFgX6KongJV0Vz5rHUt0axXgqyhqkzgpgrYXowuZTkXkaekS");
            address.setLongitude("sWSnStfqu2SVXwF6uPAax2koMW4IN4gTgxfyyPl0zr7W17ccWe");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("T7z76s");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("a");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("WfrhudJsjixh2OfNZA8Lq4vMw4xWiyqR2FIsVqxl7854qlQcQJ");
            communicationgroup.setCommGroupName("ks3VfLbUq8UWtqa6HIYgMU5j6GAkdj1qkNqCS44QYlBa8HC597");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("KhsaLQODIt9R1wB7ZmJ31Zh3TO8nvyuyYO5Jp1F4hYY1wqjwS1");
            communicationtype.setCommTypeName("GGEW6zO4v1HSOaf92vXJjYCmmLGRDUIukthtEvdRuft3AuBVrn");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("T");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            DepartmentType departmenttype = new DepartmentType();
            departmenttype.setDeptTypeDesc("bfrd2pauRVItQfoROXEVYpHA93LM5ikjVGYYeoaGdfIz1U0wD2");
            departmenttype.setDeptTypeHelp("wROAKtxLLLPOezCro8rweU2jHzadsWWKUuL0co7vZulgBwhuvf");
            departmenttype.setDeptTypeIcon("G");
            DepartmentType DepartmentTypeTest = departmenttypeRepository.save(departmenttype);
            map.put("DepartmentTypePrimaryKey", departmenttype._getPrimarykey());
            DesignationType designationtype = new DesignationType();
            designationtype.setDesignatnTypeDesc("yAaGDCS1GWIqGxRQz4NNqydoBHqUcbci7uS97K5aONMuXMThtm");
            designationtype.setDesignatnTypeHelp("1dWYhClwdK4AG09AZdZXQklDJcnzGjKoi2QhJDtysuRwCy3rB0");
            designationtype.setDesignatnTypeIcon("y");
            DesignationType DesignationTypeTest = designationtypeRepository.save(designationtype);
            map.put("DesignationTypePrimaryKey", designationtype._getPrimarykey());
            JobType jobtype = new JobType();
            jobtype.setJobDesc("GemfVfRNAlpDZQCLa3UvfJsGSTF35OQE4G5si85qohWUZLKrMi");
            jobtype.setJobHelp("4wL4ralp3pEUg4lXbUFM6PqURxI7QdB9GU3DfSpQ97kO0ZVTdi");
            jobtype.setJobIcon("z");
            JobType JobTypeTest = jobtypeRepository.save(jobtype);
            map.put("JobTypePrimaryKey", jobtype._getPrimarykey());
            Visa visa = new Visa();
            visa.setVisaDesc("DnfYK7PpHKiHspBBcjNdppp76q2KUFLj9mJ8z6SocBBBIOTrMs");
            visa.setVisaHelp("hbXLjA2VRHecbK4LaA0c6DllSkO2DnCn6BzX9sDs7cash67786");
            visa.setVisaIcon("w");
            Visa VisaTest = visaRepository.save(visa);
            map.put("VisaPrimaryKey", visa._getPrimarykey());
            corecontacts.setContactId(null);
            empinformation.setCoreContacts(corecontactsRepository.save(corecontacts));
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            empinformation.setDeptTypeCode((java.lang.String) DepartmentTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setDesignatnTypeCode((java.lang.String) DesignationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setJobCode((java.lang.String) JobTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setpAN("hq9Yfn5hzSSLPjyCxcA4txxUHTz7wtqrm0pJjFEleZZDEYb3Gu");
            empinformation.setReportingOfficer("oVb8sdGTXYSCwrbWpcw0eoH9X4IGfD2LmXNouJTTaUVoevdZgT");
            empinformation.setVisaCode((java.lang.String) VisaTest._getPrimarykey()); /* ******Adding refrenced table data */
            EmpInformation EmpInformationTest = empinformationRepository.save(empinformation);
            map.put("EmpInformationPrimaryKey", empinformation._getPrimarykey());
            IdProofInformation idproofinformation = new IdProofInformation();
            idproofinformation.setIdDesc("HgnWlX4FrcoFmpWnZAK2k4j0GZXbKu1iz11eHqrTJLfNakEl3s");
            idproofinformation.setIdHelp("qZAooWuy7DqAwh6FagINwqSJ8wwHkJboin1zIWZDoUb69tk5Wl");
            idproofinformation.setIdIcon("M");
            IdProofInformation IdProofInformationTest = idproofinformationRepository.save(idproofinformation);
            map.put("IdProofInformationPrimaryKey", idproofinformation._getPrimarykey());
            EmpIdProof empidproof = new EmpIdProof();
            empidproof.setEmpId((java.lang.String) EmpInformationTest._getPrimarykey()); /* ******Adding refrenced table data */
            empidproof.setIdCode((java.lang.String) IdProofInformationTest._getPrimarykey());
            empidproof.setIdData("eVnWWSpaowm3vdjuIUNL7xGCG26tVT74pP0Rx9eE9MuZJ0WY4Q");
            empidproof.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            empidproof.setEntityValidator(entityValidator);
            empidproof.isValid();
            empidproofRepository.save(empidproof);
            map.put("EmpIdProofPrimaryKey", empidproof._getPrimarykey());
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
    private IdProofInformationRepository<IdProofInformation> idproofinformationRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("EmpIdProofPrimaryKey"));
            EmpIdProof empidproof = empidproofRepository.findById((java.lang.String) map.get("EmpIdProofPrimaryKey"));
            empidproof.setIdData("fs79FNMOgjvWD5rc9iYpf3jJqJlYjIzw26voacnxSmoMYq2CG3");
            empidproof.setVersionId(1);
            empidproof.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            empidproofRepository.update(empidproof);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByempId() {
        try {
            java.util.List<EmpIdProof> listofempId = empidproofRepository.findByEmpId((java.lang.String) map.get("EmpInformationPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("EmpIdProofPrimaryKey"));
            empidproofRepository.findById((java.lang.String) map.get("EmpIdProofPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByidCode() {
        try {
            java.util.List<EmpIdProof> listofidCode = empidproofRepository.findByIdCode((java.lang.String) map.get("IdProofInformationPrimaryKey"));
            if (listofidCode.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("EmpIdProofPrimaryKey"));
            empidproofRepository.delete((java.lang.String) map.get("EmpIdProofPrimaryKey")); /* Deleting refrenced data */
            idproofinformationRepository.delete((java.lang.String) map.get("IdProofInformationPrimaryKey")); /* Deleting refrenced data */
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
