package project2.app.server.service.organizationboundedcontext.contacts;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project2.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project2.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import project2.app.shared.organizationboundedcontext.contacts.CoreContacts;
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
import project2.app.shared.organizationboundedcontext.contacts.Gender;
import project2.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import project2.app.shared.organizationboundedcontext.contacts.Title;
import project2.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import project2.app.shared.organizationboundedcontext.location.Timezone;
import project2.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import project2.app.shared.organizationboundedcontext.location.Language;
import project2.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import project2.app.shared.organizationboundedcontext.contacts.CommunicationData;
import project2.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import project2.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import project2.app.shared.organizationboundedcontext.contacts.CommunicationType;
import project2.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import project2.app.shared.organizationboundedcontext.location.Address;
import project2.app.server.repository.organizationboundedcontext.location.AddressRepository;
import project2.app.shared.organizationboundedcontext.location.State;
import project2.app.server.repository.organizationboundedcontext.location.StateRepository;
import project2.app.shared.organizationboundedcontext.location.Country;
import project2.app.server.repository.organizationboundedcontext.location.CountryRepository;
import project2.app.shared.organizationboundedcontext.location.City;
import project2.app.server.repository.organizationboundedcontext.location.CityRepository;
import project2.app.shared.organizationboundedcontext.location.AddressType;
import project2.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("DHQhIxmu5jVRDB4Fb2JEe4SwInOgllJ9kOYtkriG8z6yZk19st");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Title title = new Title();
            title.setTitles("MdtzKlqFzOWi2b2uvsVw35Cz6x7f2KZztmV5VHgz5PYtoJyCCr");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setGmtLabel("JoOfLPXF5H7ooAZk13GtGMK6gEcUVnasRnGSmX1pNYwY9hyaBN");
            timezone.setCountry("Lh01N1VIlHV7CSdidiUJbNTHvOJW04JYTD5DP4vvUQb60wOrp4");
            timezone.setUtcdifference(4);
            timezone.setTimeZoneLabel("vhHoOb9NecTTf3dQg6E8G3P4zxWa91tG2v54ERmDe1VKaFE07V");
            timezone.setCities("Q54DXmJWYkjxgpPlkgSmzJnDJrNWWTtlmKucSHtcOE5dWMAa1h");
            Language language = new Language();
            language.setLanguageIcon("z2JNZybM3f2f2pBzVCKYjnGxlGc4t7AnyhbB16q1jmykYdVUkt");
            language.setAlpha4("OYPh");
            language.setLanguageDescription("adnfEgaEkuCwCN5fEYP4rPKPPipO8aI9bN8IzVEBxvup1UqOpt");
            language.setAlpha2("3p");
            language.setAlpha3("FcC");
            language.setLanguageType("EkiLVRGm2D3j1Kj3daNZZpru0U2eLBfn");
            language.setAlpha4parentid(11);
            language.setLanguage("seMyZPBKd5TLU6DRBbWTu56CSZrGgyOSWtkOYsrnPJWZZxKik5");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setEmailId("4VFOz2pLigtyPty7eqaezwIzDZLyMwcjjyGaT0zHPl7yUkzOO2");
            corecontacts.setNativeMiddleName("BwORukwQO1DzudYt0gbAeaR73zx4eMg0nDyN90dJj4B7jYp8RV");
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setAge(82);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457448000435l));
            corecontacts.setPhoneNumber("PRAIRTabRzsZcJJDKYwX");
            corecontacts.setMiddleName("pntrx7x6BJuJ60Sal45zIz5TxZqgJ0JriQ6DFyRamz1MiwTG0V");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setLastName("7G1ETfJ4Za7YRaQ7WA5kVPbAje0YrsXZS37HjwRhFLeAQowQZR");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1457448000479l));
            corecontacts.setNativeTitle("DeLRIMiVHwyPogKhNhJKvE6fVmchV5ZGYVuD7o58i9as4iRDej");
            corecontacts.setFirstName("FbygDoi8SalYZmiek4M41NdAjPddyGJUl874ipVd6oZHsfrxhc");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("IeZP1L4CoIrtMNQ0uDlnatZtT0vIEerkOCmcB6lmziyBaLFZNN");
            corecontacts.setNativeFirstName("Sx4jcosNWUPn172cysnIjyoiAt0vTMMfaCVOdjN0Fo0SBhBDfJ");
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("R");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupName("IuO3DaW4Hhzi9lDe12T3RRwJGaE2H5yERnR9mKpIXKeuX13oV4");
            communicationgroup.setCommGroupDescription("zlQEAqp0xfO4RZW1jgfmg3Pxm4cPUVhHTG7UcGbYS8i1wX1UJy");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommTypeDescription("kVCr04ir4oqd0YPpbnIYQEtdhKZHTBCpLTFnWOsw57tLGvISaW");
            communicationtype.setCommTypeName("1qlw9knWV7tecEwlBHZn21R8bMIpcnCOKVmA1u6qr4uwva5DfZ");
            communicationtype.setCommTypeDescription("wXwS0q6rUzXZL7yIE4Tg8svBdsETOjUSYI5vVmU1LHUKRWlmPE");
            communicationtype.setCommTypeName("lUgTBX5zJN77qhvOmTu1y8pTqcuBxmCgpkaFOOXASeinVhfeLm");
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("1");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            State state = new State();
            state.setStateCapitalLatitude(7);
            state.setStateCapitalLongitude(2);
            state.setStateFlag("o4LGnQvVsVbOItAgDYnhNPkWn2MdfqaqhUjcJEReZu2eIHLYLO");
            state.setStateCodeChar2("Q3fLuU8sqJ5MQW1PcDsNITH4yz2kePpH");
            state.setStateCodeChar3("6qWgmMPqrzJYywDoEShBV4VqrYsaiPj4");
            state.setStateCode(2);
            state.setStateDescription("wpyIW4SFgGYaUiVQxBjO1ExEgs3XzeQJSvnT75Y8wrKdkbllR1");
            state.setStateCapital("rY41sO8UIAJPrx9WmovRNwxDslmL7lbtszghuFLI7TT6qpXrlB");
            state.setStateName("JPYv5P62R0M9IVPOw2WOsReaXhiSy5RDFnG6HfkOcFVleuw315");
            Country country = new Country();
            country.setCountryFlag("zDSI3ZITFn2hrqFkp2b0mYUggaYxlmDbc0cruSxVznHVGyukWY");
            country.setCountryName("wyytzScrZwOQ8WDfmqZvn4csTfTpRFs9kaNI85wxVswIJ7UUhE");
            country.setCountryCode2("4I4");
            country.setCurrencyCode("P8X");
            country.setCapitalLongitude(10);
            country.setCapital("4R47zhb4ICT7NryFAsKhCkak5EqPBE84");
            country.setCountryCode1("oog");
            country.setCurrencySymbol("XGkV04s0uYR3OQL9bLC5HupRXd5yVyXh");
            country.setCurrencyName("Hc3KWDk0bzEBpcfSxPPvT1dNqUUN7l82BQ7CI08vbAsdPlFIGN");
            country.setCapitalLatitude(11);
            country.setIsoNumeric(7);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            state.setStateCapitalLatitude(7);
            state.setStateCapitalLongitude(1);
            state.setStateFlag("klE6AvQNqfmIr3J59yswrpPAqebBXa9BgAblmTGGWSn3Okcjeo");
            state.setStateCodeChar2("OXd4Y9JtoBlOQXKhDSNIp4emzThXfnQr");
            state.setStateCodeChar3("agctBIKGYSEmO5xT1QHDqkBQz3Dqcclt");
            state.setStateCode(1);
            state.setStateDescription("lq1iforiEzYMcv5fonN1MKevYZHaXV3ntOfvpq5fyWehtdh7eh");
            state.setStateCapital("xV3UBcIb8pVgSOQitKHT3zi6WnZqMHsGu8XZEZL1TfIXoPnq8Z");
            state.setStateName("sHN0JydvOLSWFAcUV1fpzEjfhg1lJXWZmbQ644UNbB6AxDQa9W");
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            City city = new City();
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityCode(1);
            city.setCityDescription("Ot3LinxIthnBcORgxpw8cQbIeU1FBUfEtRSOKUC3Da5v9r7PtF");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityCodeChar2("JOWDH8fS7LImBOw3tTIJc2r295ycsi33");
            city.setCityLatitude(1);
            city.setCityName("gvw4SDU46ZlvYyih3kg1GSkg8U6l60jJWg1jEs39OnXacibtIW");
            city.setCityFlag("1kyJWz2ixdc0PfO2NUL31EuTd8I6gMEx3C2d8lP4cY7lGSPK7X");
            city.setCityLongitude(8);
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            AddressType addresstype = new AddressType();
            addresstype.setAddressTypeIcon("WE3iRCY0P3geWf4mxbkzW9MdlzQF2ETx3kLq6uRdH5fkDmY44h");
            addresstype.setAddressType("MK6hXOgaA2o342BDmU5aH3QykLjtjUF561WfI6yyYRaBOGWX7r");
            addresstype.setAddressTypeDesc("ourBbPjMhfYMMj7ZcovAI292L9gZahuZGryVRk78mH7uxl2l6U");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress3("bSQR236OR761qaBZm7NdMe2XPsrytWfNFcsvdFv9l574YcXXPH");
            address.setAddress2("mHiC6ubuCb4RplrLEVCL983NRRcl727IQYQocpsIyIlpK3DtmB");
            address.setAddressLabel("tAku93vFnEe");
            address.setAddress1("bRIO49eWnLfm2HfNo8ctIWdyvXfH9096ozrQVjTnKaR1yINQfg");
            address.setZipcode("YGTit6");
            address.setLongitude("B3Pg70ilEjtrd0LsmXcRL8eN0BF7ygR8KTLEf8zb5BIY8dP98z");
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("0U5k941CmDkPfEcgFdANadc9oqfcDJGeyCPQcya44HSP88IbBF");
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey());
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setVersionId(1);
            corecontacts.setEmailId("k3xk5y6rzZO6RdwpIbCU4PhJBbXJvrtvTMoAM1WlPmAxwfFzfT");
            corecontacts.setNativeMiddleName("mk2tAhS4aiBpz8egLSqGlBDxwrYF479InIt6Cb6VH9I0IU6P41");
            corecontacts.setAge(14);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457448000952l));
            corecontacts.setPhoneNumber("1ElWgOmtOS6e2zBvkhy5");
            corecontacts.setMiddleName("iptzOKZrRkduQetvffQbevUxGiQu2HgzPQPTVMzr9lYXycAkmj");
            corecontacts.setLastName("SySpH3fvzBYPKAhzHLdpuBfw7X5df7xcjxaYIuwHjwfVzSkLcW");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1457448000988l));
            corecontacts.setNativeTitle("MvBPAyx9bEmcagTRdC7RQk46Qa2VUwoSAroQO921tPnXwGFza6");
            corecontacts.setFirstName("TM50ZNB9IzZ6KP1a6VzzFZWdH4QqJu6zSfPnv25vrSvB6E4QC5");
            corecontacts.setNativeLastName("3LUG2pptk1ewByNOda0IrcgJwJJUdoDtHn9AhdSpCTiiZaItxD");
            corecontacts.setNativeFirstName("9NpSBuZ3FltHcvAb940qd6r2j9QNGHrowWvzVB2cwJ3F32muYh");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
