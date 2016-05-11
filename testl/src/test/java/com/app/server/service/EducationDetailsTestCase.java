package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.EducationDetailsRepository;
import com.app.shared.backgroundcheck.EducationDetails;
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
import com.app.shared.backgroundcheck.DegreeType;
import com.app.server.repository.DegreeTypeRepository;
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
import com.app.shared.backgroundcheck.UniversityType;
import com.app.server.repository.UniversityTypeRepository;
import com.app.shared.documentmanager.DocumentList;
import com.app.server.repository.DocumentListRepository;
import com.app.shared.documentmanager.DocumentType;
import com.app.server.repository.DocumentTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class EducationDetailsTestCase {

    @Autowired
    private EducationDetailsRepository<EducationDetails> educationdetailsRepository;

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
            DegreeType degreetype = new DegreeType();
            degreetype.setDegreeDesc("1mioL3U0VFwkOJpaSTwFbKwciC1IlVtY5bE7Lf83W9iYnUMWYD");
            degreetype.setDegreeHelp("Uo7RNQ0gFT1uZ04S4YZ6zPuvQwuJ9ApD8fSGkLl6waLwBWPaTX");
            degreetype.setDegreeIcon("L");
            DegreeType DegreeTypeTest = degreetypeRepository.save(degreetype);
            map.put("DegreeTypePrimaryKey", degreetype._getPrimarykey());
            EmpInformation empinformation = new EmpInformation();
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(90);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488961081l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488961081l));
            corecontacts.setEmailId("HH6X5arItENC3LPI8qfEYbZ3MBAdTTMes0vKtd4s5ZvVhtYg1t");
            corecontacts.setFirstName("sGGwd35FvHAKb05t8Rp29GTAcaPREZpGjSKWjqFv2b2v4AN0Uz");
            Gender gender = new Gender();
            gender.setGender("KGnt7KlfNCWyK5zLIrNewW7OeA8sy7xixNggxfYRYMIZftkou4");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("Gv");
            language.setAlpha3("YCA");
            language.setAlpha4("aZ6F");
            language.setAlpha4parentid(7);
            language.setLanguage("ZkEIlam4kHZZVVUQ5KmG8AkFrjT9TQBa8YJ0j0pQgLQwBkkBm3");
            language.setLanguageDescription("pG75qSmEZlpdL9npQ9nbW5ItDgRNXdQpo4rBiwYArWmxXIvNrh");
            language.setLanguageIcon("XxSpMxkRsm4uhjNlivw7ByZFwAsGyORV5tu5iY2V1JeURyeNhV");
            language.setLanguageType("vr6IpxI1gav3XRkDgGjtjEF5hKmlJvtl");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("SEi5G1KfaqPkrHkiorF75GODSSS4Wl1mI10lmNZ5BYYwlDvy1W");
            timezone.setCountry("D9fwR079Z8IzGePPG17YmCIVI2WttT5lpsBXvAVmyCf6MIHr0L");
            timezone.setGmtLabel("CwMahQm0RnIOmOzjGnnoSgyjftgrEWTKSeEEZKxz30hIgnehQj");
            timezone.setTimeZoneLabel("ERoDYA3GlReO98mygWkEOCdrtS2fuOq0tUenwvA8JhYtYut5cr");
            timezone.setUtcdifference(11);
            Title title = new Title();
            title.setTitles("B5u1x05LuzD35yGYsiwq3rbFWBspraVBH1dxSpQpDREIhEK2g0");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(93);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488961095l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488961095l));
            corecontacts.setEmailId("vDrRSr26VO4VTWUsMQbD0uRKfaXrpREUwLmM6tMPbJRmthjCcr");
            corecontacts.setFirstName("ZswY0s9wBXUyc8BiCk4Yx81hPeVhpcmoOW9fKWM1XoRnU2k8Nv");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("4Qz6vLj6BYMdoSrMVGDBCQiM5RhpEgkXP7X9IfVt6a0x25S7xT");
            corecontacts.setMiddleName("BfnyVYXIDmCYdGAHnUbwNtZI5BLEz5lFfE0Z4MUbnzoa8YAIwG");
            corecontacts.setNativeFirstName("hYKyEX3YZYProunj6Ps2LkIucRp8FgICc3AIbe1Rp5TfFu5Pnu");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("khqVxF0trDgZtVzdN1xw9WJTQtdV5CDoLljfhKXkkSEyHXEhM9");
            corecontacts.setNativeMiddleName("X7xp9l0C6GbuYplF4mg4O4BImARlKtqdiK1R2KWhyqaTNMpYMp");
            corecontacts.setNativeTitle("PlTimqi3r1iFgwNycNlTE3Wqc9lIko12njptvzIqKn9WWtVUcB");
            corecontacts.setPhoneNumber("XaY9FNxqwbD6siaQ8DbE");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("UNTVIuBv6phndJJjNHUvGgM9bVeJKTiLLDvAPRgquD6RkyixDj");
            address.setAddress2("910ZFiuP1xwM2fDxrAo5wmE2fIMtYZF19NOPKY0UAoCeh5ok0l");
            address.setAddress3("thuFHyjHKPgPsDGxVJknnfCPHZFbzLJEaiSiLR2EzFGi6BfKMn");
            address.setAddressLabel("bIXaAjrKgne");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("XdFFsLSWSi00q1eerJC07gGpHs01HyAL1UOBusMXw5DAOTItFg");
            addresstype.setAddressTypeDesc("PAAlUiOn5MEZUZ6KiHUOZXG3aK1k0FTxtwbBI7draNvPawMFY6");
            addresstype.setAddressTypeIcon("Qu4e0VaJQyou5CJDGtg6OJ2rDkhQ8ZgsDm9DCrSx3bG0cJaawq");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("QsD3L5I417HvDehQS4XF5VQScLcx4Wrs");
            city.setCityDescription("LTYiom8NYQ1qWoQvQIl1lDDOcHbkkwNzH8rlHHRmtp2xibssLt");
            city.setCityFlag("RT7OQjNQsYjKe1UAzaLbFZ2RBYF4d5NEejkSeRRK4Xg3WZE7Kb");
            city.setCityLatitude(5);
            city.setCityLongitude(1);
            city.setCityName("1sdpNukt72HktxyU2g3xKjLsFTbKqj7pWLjYRRGv1IKITAoUg3");
            Country country = new Country();
            country.setCapital("vchYtTJj6FlBGFw1ZBzDkqRVGQllRqDw");
            country.setCapitalLatitude(11);
            country.setCapitalLongitude(6);
            country.setCountryCode1("Ozm");
            country.setCountryCode2("Zcu");
            country.setCountryFlag("bPuBo9hUkmOkdPZxfCkSGV2Uk8JDD66ferjMaZX58X40EnhJt5");
            country.setCountryName("DPja2E38pYsXWu79jMSFTmYpX2aYGLPzl84CBgTt0lMWlVXOkc");
            country.setCurrencyCode("Ppa");
            country.setCurrencyName("mlVD5ENYnkOfUJ8Z3fWlSTDc7UdOCtMMexM1qyAisrnMKYWgiU");
            country.setCurrencySymbol("NNWIQYCtyQ3udRIRcMwCh8OWn5atvTjl");
            country.setIsoNumeric(6);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("o2uPwQbHhdJy0siCBdAUxsqBOMeyIhmmNzVa3D9ho4R5JfcHpz");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(6);
            state.setStateCode(1);
            state.setStateCodeChar2("0KYtY5kwb7itzSdrCoxBiAHz2eBTwumC");
            state.setStateCodeChar3("bph9sGMsVVIiuyNH2nR0GwCpZZGaIciZ");
            state.setStateDescription("BbQiCEnkxoBBirU1udbwPWA9vs0QEjovvy9eE6R9TqAjSoPCxw");
            state.setStateFlag("fZ7zeZf3RkPDEkFmXw6w9M4aWfcxwDYQu0aSwYIdNsYqvBav04");
            state.setStateName("OfyJwJmQRffSKfb0coiD6GVSZYaaXV1mUTMX6FUkkv4uMNGUtc");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("itF9rNk96qMED12yf0umwTJxrntnSUUQ");
            city.setCityDescription("SE2uMpnnPQC8Lx1iNuWUS9x66uEGmrj4OUMIF2DMuWXZpUZFvi");
            city.setCityFlag("wNXhnaxW8JsJyZYNLbr1gqxU3FYa16ilqn1kMu51JGwWEtNMNv");
            city.setCityLatitude(7);
            city.setCityLongitude(1);
            city.setCityName("8JuIwdmYaIZqGVsS8PzNOx2ND5ivPqxtUqKaIdli1RXE5WYx33");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("2bg2nRYIv1agewXFOAjxaLC6JFyCBWQBph5rrJJbOjIppAaoJ6");
            address.setAddress2("P0mIXMklvy7HGDmvNjLot4SRmFpW4p8w2NUIf6HLdn4ub6MUYH");
            address.setAddress3("cR6B5uLNZ1x8g8yasDR56kWPjfqqy9YGXqt9JQHJEHLLu92kdA");
            address.setAddressLabel("O14pse3K8Um");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("HA3X687CrWZNJXeVrd7zp3fKsjXxfypvY6MtfuSYFS0j8t62Ad");
            address.setLongitude("0lNufTIGKTLMZjUgtPxFpha0gpusJ4Yu4Gg9Q7NMPzvU4CVuOs");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("GCCSYg");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("a");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("DB7QnpqMvTCYJ8fDZRoGBtYIYpAaxYlzEAr7OCBYPe57wzURbO");
            communicationgroup.setCommGroupName("GGxMv2MuVoNsbMOxhKJIGvM8QNApAAIy80GBSUez1QOwUIRHcS");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("9gsHAKPqNr6gUZQlSjIsicc3n7NNtCiGRkSW87nUxZ8Dl56SKT");
            communicationtype.setCommTypeName("c8ds0u5d3pfwKdnnV9kMg6t0wV0GdGCAMZj5d0WoboNDNPFCzI");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("d");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            DepartmentType departmenttype = new DepartmentType();
            departmenttype.setDeptTypeDesc("KKaILXXcwuH2yMcnO11A45ZEZyLHkiUbLGMrAoS33U3BUUpIy9");
            departmenttype.setDeptTypeHelp("Km5PIEcSgEdB9eqtYkf4EaxZVbiL4O5HoNpI4E1goQw4kXnyhj");
            departmenttype.setDeptTypeIcon("G");
            DepartmentType DepartmentTypeTest = departmenttypeRepository.save(departmenttype);
            map.put("DepartmentTypePrimaryKey", departmenttype._getPrimarykey());
            DesignationType designationtype = new DesignationType();
            designationtype.setDesignatnTypeDesc("sExhnHve5fntOrygZMcYYZWYoccSsrH87TENcHYpZAQpoCKBXc");
            designationtype.setDesignatnTypeHelp("6PjDIXhIRiD8S3BkdVQrQKHi8VftwvhXYDmmosW6FNNOwAttJy");
            designationtype.setDesignatnTypeIcon("j");
            DesignationType DesignationTypeTest = designationtypeRepository.save(designationtype);
            map.put("DesignationTypePrimaryKey", designationtype._getPrimarykey());
            JobType jobtype = new JobType();
            jobtype.setJobDesc("WakaYLjR7cALmXgtB1iyGMH8GqoEE2VUKybevql62T8M6ZNYXk");
            jobtype.setJobHelp("5jTqpVyvKsQgqbSOTVRI4DFmPrvi4LQzjA5fsBZd3izbNY0vnv");
            jobtype.setJobIcon("N");
            JobType JobTypeTest = jobtypeRepository.save(jobtype);
            map.put("JobTypePrimaryKey", jobtype._getPrimarykey());
            Visa visa = new Visa();
            visa.setVisaDesc("1RdYp3GZdi2eNrn734GAcQnbReOQNbpcZM7ZkJtK9xk1JHeDbO");
            visa.setVisaHelp("gTVziw9uNIS7NyqKmWtWmPpb0KQS45b9MLQHTIH3RiamhOSgjg");
            visa.setVisaIcon("K");
            Visa VisaTest = visaRepository.save(visa);
            map.put("VisaPrimaryKey", visa._getPrimarykey());
            corecontacts.setContactId(null);
            empinformation.setCoreContacts(corecontactsRepository.save(corecontacts));
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            empinformation.setDeptTypeCode((java.lang.String) DepartmentTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setDesignatnTypeCode((java.lang.String) DesignationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setJobCode((java.lang.String) JobTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            empinformation.setpAN("7lNSifKP49EzxjuylAJADB1jnV6wyKNryuAeqcIkflEB7C5lbF");
            empinformation.setReportingOfficer("BF0eThAeJb7IooSSwcHVeE8rOE6g0prs5DXM9lLTate3fWntNo");
            empinformation.setVisaCode((java.lang.String) VisaTest._getPrimarykey()); /* ******Adding refrenced table data */
            EmpInformation EmpInformationTest = empinformationRepository.save(empinformation);
            map.put("EmpInformationPrimaryKey", empinformation._getPrimarykey());
            UniversityType universitytype = new UniversityType();
            universitytype.setUnvDesc("4kupSbE40XTM8b11rEOpKkfOWeOJ1fYskpFM3yomoKbLj2STDs");
            universitytype.setUnvHelp("dhqEo4vmKE2lKLInYbRtNR3PIzmf3it8ZWV7owONPLvwrRwmjc");
            universitytype.setUnvIcon("M");
            UniversityType UniversityTypeTest = universitytypeRepository.save(universitytype);
            map.put("UniversityTypePrimaryKey", universitytype._getPrimarykey());
            EducationDetails educationdetails = new EducationDetails();
            educationdetails.setDegreeCode((java.lang.String) DegreeTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            educationdetails.setEmpId((java.lang.String) EmpInformationTest._getPrimarykey()); /* ******Adding refrenced table data */
            educationdetails.setUnvCode((java.lang.String) UniversityTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            educationdetails.setYearOfGraduation(10);
            java.util.List<DocumentList> listOfDocumentList = new java.util.ArrayList<DocumentList>();
            DocumentList documentlist = new DocumentList();
            documentlist.setDocDate(new java.sql.Timestamp(1456488961753l));
            documentlist.setDocDesc("ltozGT50ONKCOmaLX0ypUGTuqBIXn0Rhpp40umbAjBVK641Z4Q");
            documentlist.setDocFile("J6Z5n2WQW2zxRVloTRR2GaJSdZ8b6EsG1A0XqSJpz3rwOMITkS");
            documentlist.setDocName("VCTFix3SAgbiVPD4Lj4mpy78bNo2HI9mjExM0WX6TSZbtQuUKD");
            DocumentType documenttype = new DocumentType();
            documenttype.setDocTypeDesc("q4ZEoX49EhfdtnkOHK6yMsdfHavYpmObxBY6h0NsY3yLRHKpvC");
            documenttype.setDocTypeName("i7DJz0oRQBlfibxUxOcJ8WFUpn6XAwwTe2vDCbj9f2HIQT5V8q");
            DocumentType DocumentTypeTest = documenttypeRepository.save(documenttype);
            map.put("DocumentTypePrimaryKey", documenttype._getPrimarykey());
            documentlist.setDocDate(new java.sql.Timestamp(1456488961759l));
            documentlist.setDocDesc("IovVv2wutqabEh1FdfGtQjbD2gq0J8aKkVq9Pn9nO3mXTZJRi4");
            documentlist.setDocFile("Vlx3NQBuANPmMyEMaXzVmFf1MFPlnmMw6gFzziLi7II3c5opqq");
            documentlist.setDocName("23ZaTXimsFi12iKVLMFTSWELtyKnXRhjUwsljf1hXSekHSRtnr");
            documentlist.setDocTypeCode((java.lang.String) DocumentTypeTest._getPrimarykey());
            listOfDocumentList.add(documentlist);
            educationdetails.addAllDocumentList(listOfDocumentList);
            educationdetails.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            educationdetails.setEntityValidator(entityValidator);
            educationdetails.isValid();
            educationdetailsRepository.save(educationdetails);
            map.put("EducationDetailsPrimaryKey", educationdetails._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private DegreeTypeRepository<DegreeType> degreetypeRepository;

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
    private UniversityTypeRepository<UniversityType> universitytypeRepository;

    @Autowired
    private DocumentListRepository<DocumentList> documentlistRepository;

    @Autowired
    private DocumentTypeRepository<DocumentType> documenttypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("EducationDetailsPrimaryKey"));
            EducationDetails educationdetails = educationdetailsRepository.findById((java.lang.String) map.get("EducationDetailsPrimaryKey"));
            educationdetails.setVersionId(1);
            educationdetails.setYearOfGraduation(1);
            educationdetails.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            educationdetailsRepository.update(educationdetails);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBydegreeCode() {
        try {
            java.util.List<EducationDetails> listofdegreeCode = educationdetailsRepository.findByDegreeCode((java.lang.String) map.get("DegreeTypePrimaryKey"));
            if (listofdegreeCode.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("EducationDetailsPrimaryKey"));
            educationdetailsRepository.findById((java.lang.String) map.get("EducationDetailsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByempId() {
        try {
            java.util.List<EducationDetails> listofempId = educationdetailsRepository.findByEmpId((java.lang.String) map.get("EmpInformationPrimaryKey"));
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
    public void test3findByunvCode() {
        try {
            java.util.List<EducationDetails> listofunvCode = educationdetailsRepository.findByUnvCode((java.lang.String) map.get("UniversityTypePrimaryKey"));
            if (listofunvCode.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("EducationDetailsPrimaryKey"));
            educationdetailsRepository.delete((java.lang.String) map.get("EducationDetailsPrimaryKey")); /* Deleting refrenced data */
            documenttypeRepository.delete((java.lang.String) map.get("DocumentTypePrimaryKey")); /* Deleting refrenced data */
            universitytypeRepository.delete((java.lang.String) map.get("UniversityTypePrimaryKey")); /* Deleting refrenced data */
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
            degreetypeRepository.delete((java.lang.String) map.get("DegreeTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
