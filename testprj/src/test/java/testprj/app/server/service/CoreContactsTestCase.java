package testprj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import testprj.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import testprj.app.server.repository.CoreContactsRepository;
import testprj.app.shared.contacts.CoreContacts;
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
import testprj.app.shared.contacts.Gender;
import testprj.app.server.repository.GenderRepository;
import testprj.app.shared.location.Language;
import testprj.app.server.repository.LanguageRepository;
import testprj.app.shared.location.Timezone;
import testprj.app.server.repository.TimezoneRepository;
import testprj.app.shared.contacts.Title;
import testprj.app.server.repository.TitleRepository;
import testprj.app.shared.contacts.CommunicationData;
import testprj.app.shared.contacts.CommunicationGroup;
import testprj.app.server.repository.CommunicationGroupRepository;
import testprj.app.shared.contacts.CommunicationType;
import testprj.app.server.repository.CommunicationTypeRepository;
import testprj.app.shared.location.Address;
import testprj.app.server.repository.AddressRepository;
import testprj.app.shared.location.AddressType;
import testprj.app.server.repository.AddressTypeRepository;
import testprj.app.shared.location.City;
import testprj.app.server.repository.CityRepository;
import testprj.app.shared.location.Country;
import testprj.app.server.repository.CountryRepository;
import testprj.app.shared.location.State;
import testprj.app.server.repository.StateRepository;

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
            gender.setGender("KZ0ASSstbTs7SLbLLaQiN7fWRbpCCUcB4L6lAOtCxmvPKl0kMn");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("xf");
            language.setAlpha3("Btq");
            language.setAlpha4("zF1L");
            language.setAlpha4parentid(1);
            language.setLanguage("lGzhtYvCiy64JjesJRm1Sxcs4ubkaZpo2DpoIIeYx0QP75etT0");
            language.setLanguageDescription("146eShqkG5YwzRJ1rcEwt77ueEB2FFSNU9qvl30z9UxQYzOfyK");
            language.setLanguageIcon("oQwz80z4pOfLgprac6YmoXkbAcQOSQzcZiA5dnk5k1U4lYPiC1");
            language.setLanguageType("fjggksRvnMSYg3DbjOnofpKKgYheyZjt");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("zdiKGc4cf29ClOzZCSCyKFbHUcmm5AMvFoN0v9Fzc7ByIwiM5I");
            timezone.setCountry("Y6kraZCt6Bi8qpT5vSRX9DGlz2YwB4yjCc4e1FlnxDNVsYtqiH");
            timezone.setGmtLabel("0dqTYdmHPekJ3OMfFPSN6ZMtonVkeWDo0ZWqnWwtOYUmo2P78Q");
            timezone.setTimeZoneLabel("d60rsjWBzinXyVIXSNlGR8XJXQQ35GxHPivuxT71ny49jrQRdf");
            timezone.setUtcdifference(6);
            Title title = new Title();
            title.setTitles("amYVGHyhL2xKuPQtOaaARLxWgXttMdxsbhQ92cdoqGJtr0ZL8U");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(77);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("Hae9wzZBbWJWZWXba14ynZTKChcvQ3Ox1mfykH3lV4dvdnltW5");
            corecontacts.setFirstName("OR7Zwq8RGAvw15Cgmv5We9KZevVhCyeeIYaQ0gYqNtRJ2lAiv9");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("JPdNwPIsbYPNDpEhdN5T8Wshg1cpUcK9JysK1i9tlwwuOBCD4H");
            corecontacts.setMiddleName("gtTZL9YnekZ60UnYM4i3iTJp31Kt31OMCS8m890trYGSe6ODkK");
            corecontacts.setNativeFirstName("HM0SeM4YRMqZztBVaWLqUIjhoJ1VQ4UBRgkqTZrVbAoi9Y0bxJ");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("Z9bhPhKnvHISvFcfcyLPGARz5hsEdHAWWtMOQ8wdWiqnrcE8CC");
            corecontacts.setNativeMiddleName("9xOatKhyRn0etcx2ITc1vO2YbjcmoYDUJxKaGDUDE882UI2frB");
            corecontacts.setNativeTitle("aft1tHIzQUVKVKKmtY2QoHIOQsWYfnjb9uymhn7WWE98u416TQ");
            corecontacts.setPhoneNumber("lYb9wdrGN6YGZ7Mok106");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("F");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("LwqzUovBXSlvxbkGKr94Ypgt4I8PlpPOWGJXCHgcIYsZQ3d5Gu");
            communicationgroup.setCommGroupName("9GDaEzBRipBRsPT7CTWdPmVKWPlSPyMxJzCAgL4xtsfhxrr49z");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("dO8sw42kHLSXCH3KFXAX8LgOcIVkwl0Au9a9GAoW6eLJ74h7Lg");
            communicationtype.setCommTypeName("P9DSqPs7npGiLR5MNMLrIwgKkewgTpBmwJ3SZOm4y6jFYCWWuD");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("c");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("uVeJcOZMNC1vHZmEafVFranfb1FkwMK3T6sc3Y9RseTebCwKPV");
            address.setAddress2("oxJadI34zdA2Lgc4W2XlW9swOnaKbPPysqoyhFZEV7ZS26umiN");
            address.setAddress3("zYf2ipxStUqfQfhhPDumziH8BslfbAwcSZqkizGmWuKatXBJfy");
            address.setAddressLabel("fwOkGQ00a1I");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("RBvqLHuIkckNxIDrThyv90cqae8yusBRxoFSxQwdM8biqjo7TS");
            addresstype.setAddressTypeDesc("rkisohxQs05EITGwo6e47HB5uB2zyALaRWDo5LIHSk0xWusrdC");
            addresstype.setAddressTypeIcon("hBnZ5dyeeopiwICK1iXU4UVQgNfOus0B6e57m7ogiA2fcfxT68");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("GQLSrEgOcM7mjMh249eZLu9iwskyRsVf");
            city.setCityDescription("7iw69IA0WAnYV8P5saV8jno2DhqFhjHf6IvYPRjSNKkTvCKCvQ");
            city.setCityFlag("lRulid78uplqLQY0LVASZEwO6ugC9L41AEwReqRSobTQy3J0WK");
            city.setCityLatitude(10);
            city.setCityLongitude(4);
            city.setCityName("QB9Gtsb8MOUvcUQ2Pkdmvj6ai0cbvlkqij9FU89xZbKMNrKd7Y");
            Country country = new Country();
            country.setCapital("ORqY9kKJjASuM4qoqF4RS2mYXV3Yw6AQ");
            country.setCapitalLatitude(3);
            country.setCapitalLongitude(6);
            country.setCountryCode1("afM");
            country.setCountryCode2("EaX");
            country.setCountryFlag("JK7cXsf30iKmbFeUdZVK5rYE1jkwqgjT0EjroxMkiunptCa82h");
            country.setCountryName("aW2moQYpTOHaudbQnrXgdv5DL98ysqXwSUpxTwNCLste0O4mgn");
            country.setCurrencyCode("56R");
            country.setCurrencyName("35AItDmoSAEjvYgHUG1Wpd1aN1zbwv61ZV4KFdofsfXBvaInlD");
            country.setCurrencySymbol("brw3pImKmmYeAFc2NKbnUzPsQoFlDNza");
            country.setIsoNumeric(4);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("XHhyGk5ZILIZbHJWAxwgcuTvDdoCfh3vygHYUBYnGB9xzK3f0a");
            state.setStateCapitalLatitude(10);
            state.setStateCapitalLongitude(11);
            state.setStateCode(1);
            state.setStateCodeChar2("Ap07Y9tA2Lqcn2aNZs7971eBEt4M9hYK");
            state.setStateCodeChar3("HZUbT3lwShkBH9iXPMmwhdv7LAxv5ctO");
            state.setStateDescription("RiJ0gB6SJslGNkDUCTtY6ycudPkMlTVHIERyCeUKFAcJ7lUAPF");
            state.setStateFlag("svgosZjGacovrQ0siePuyr8GHfAY24WxLf0OCc1wefECtpEI8i");
            state.setStateName("fusVxw4yhtPZEueXaEt7UzMb65j1BE3LWekMccj4i4ifcNlvjH");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("q0Lr6b3NfoT95IHo44Yq8aYSbDleCtRS");
            city.setCityDescription("hqCCALaJCJH4qirz5BZpBmwgUJr6hRzJ3z319E8RBI2pHPXTbX");
            city.setCityFlag("UMFqNkURHfNYCPYnCND1uysl3WhsrJn2jcWV5Yey9Ljq3rJCRh");
            city.setCityLatitude(8);
            city.setCityLongitude(10);
            city.setCityName("xlJGq3mp4wPKCgKqTnFQlm6DxKYMkqlLhx0kjEXxlOac7Amjhr");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("u640VHG24o2YdQYqE4uqZH3X3T2V56VStCm1HJSshpLUw6WlEc");
            address.setAddress2("BTRQVCtO2P8wFdBWVM1GczgKmu5XUnTEvdfFI1yGb1yJpjGJ26");
            address.setAddress3("muQ4xVOyNbedVTR4BOaGAHSHpOhwnt4V5IDBs1FBlZp7kHegKi");
            address.setAddressLabel("MI1fSxUovfc");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("rtgww7GNhxfPUWoBk4CvqOr0PAeJDH3vVz6Z3xWQTFtPHYSp7d");
            address.setLongitude("v28LS5OJxTOhgWGl01fVZ56XP1GoC2FJNFBR3YtXmO04hkkUQE");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("yJNgmu");
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
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(68);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("siPhrEellDjMJGaB0Szl6BVPUk09UdEf5vAoXVjOOCmlGpoxd4");
            corecontacts.setFirstName("7kh1wWBEbdooj3IuMIaHLP0TAC7sxX5uf6ysXhMoLHzcpEQffg");
            corecontacts.setLastName("Ba6SEFlPCsWmEDV7pofTG0YRY3lSIZQSugaJR3M3ZJ65BA7lhP");
            corecontacts.setMiddleName("xHzHrjg8dOXluHvzDCBZ1dllUZWJ7lLvBHkam3ZRxb4VcIuNAu");
            corecontacts.setNativeFirstName("7iMxC0T6bvr1omohC9FzNAOxbDxe05kkoZtpk6lY7oUaUtym1O");
            corecontacts.setNativeLastName("lI48TiAUl7BXpFdFe4rWhQ5ouzzMx15EnScJmFaZ1Db85Zrkq0");
            corecontacts.setNativeMiddleName("tzynYOJE9CUKpBRHuO8HqFHKjun0kiZ495C9zff7EFGMv9eiap");
            corecontacts.setNativeTitle("uyTqN2Bufqe0jB0nUscsi4e2JcD3oa0khXqjeuFcYDKYysU2uz");
            corecontacts.setPhoneNumber("6gvOR1a0JjKfLhudVw4E");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
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
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
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
