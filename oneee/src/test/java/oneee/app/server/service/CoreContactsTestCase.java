package oneee.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import oneee.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import oneee.app.server.repository.CoreContactsRepository;
import oneee.app.shared.contacts.CoreContacts;
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
import oneee.app.shared.contacts.Gender;
import oneee.app.server.repository.GenderRepository;
import oneee.app.shared.location.Language;
import oneee.app.server.repository.LanguageRepository;
import oneee.app.shared.location.Timezone;
import oneee.app.server.repository.TimezoneRepository;
import oneee.app.shared.contacts.Title;
import oneee.app.server.repository.TitleRepository;
import oneee.app.shared.contacts.CommunicationData;
import oneee.app.shared.contacts.CommunicationGroup;
import oneee.app.server.repository.CommunicationGroupRepository;
import oneee.app.shared.contacts.CommunicationType;
import oneee.app.server.repository.CommunicationTypeRepository;
import oneee.app.shared.location.Address;
import oneee.app.server.repository.AddressRepository;
import oneee.app.shared.location.AddressType;
import oneee.app.server.repository.AddressTypeRepository;
import oneee.app.shared.location.City;
import oneee.app.server.repository.CityRepository;
import oneee.app.shared.location.Country;
import oneee.app.server.repository.CountryRepository;
import oneee.app.shared.location.State;
import oneee.app.server.repository.StateRepository;

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

    private static HashMap<String, Object> map = "new HashMap<String,Object>()";

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
            gender.setGender("wvSbhPwj7cSozH6tskViSbfHnvvOMengSYk5ul4rOxLorA9Wi0");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("dF");
            language.setAlpha3("4EJ");
            language.setAlpha4("0lW9");
            language.setAlpha4parentid(0);
            language.setLanguage("nmEraawFsrgjGMXigyxRNitNV9hEx0oLugQN8OqfIG5GjDG21g");
            language.setLanguageDescription("SCPK83FJkeIUjo6PO0uW241AY2zH2ADANHYf2VFcq4SKDLXpQZ");
            language.setLanguageIcon("AWkxfd6ZNRu0V3bg7WrWrMH88HE98lyzP8XCTVOFRYOQxlVzOU");
            language.setLanguageType("kUgrXXBC8E35blWLVzTAqwwp3zjyEiuP");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("xsIswn4LkMHLmOrypZSuOvlmRMgH3m9PLefGekfLjTtMUzCYBw");
            timezone.setCountry("rG6DJPOvt4XLoeIIp0A6K6wSKsHJKkADuiVuzHId2Jc93GOiJ2");
            timezone.setGmtLabel("ATkm74g7zlrVijA9QDfUQpVtSRUhDQIHGAxnzWTugEnYREvNFL");
            timezone.setTimeZoneLabel("tdGT6VUjGYFnEUpupLhQCzZah29x3rrORkvpJxFMyzGDkhpck8");
            timezone.setUtcdifference(9);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("J2tJZDVQn0rmfktWFHXxlTI8TnjJUQ66jw9dJSzrSbhWxYhEK3");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(61);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("pbbV22kTAvlyy6oajQVNwH3A6MdF23HOhtBPaNGM44cdRJwia2");
            corecontacts.setFirstName("UHYpO17cAOapYFG1c1mWs7l9KjxPPOMeet2XsfTZHAP1t6V9VF");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("B3XYMZOWgLfjkr76ycDqm33cNHpVCPlrnnrgtwgMvXvdaMjQfP");
            corecontacts.setMiddleName("b6HDhRqJo1L0GbExa1o6pdkVLUG78ax6CLAau8OduhPBmPAim9");
            corecontacts.setNativeFirstName("USBwkeSjBrfCn6VF8Qmo4t5VCHw5YQqbBy1ZNMk7ahd87O0WSo");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("9nouIG1OCQORxB4sUAJWzWPmS4OajnayAyhxChFUY0qjr5VYIS");
            corecontacts.setNativeMiddleName("tbx3Mc5Nu7rXRJaNUhW5iHO4fTYWGc5ElScwm0MkvhCy0mh9jc");
            corecontacts.setNativeTitle("GKomt4flLfygKME7ektPoSTWJpTSgs0qzm6W1ZX59rVSLINX7j");
            corecontacts.setPhoneNumber("QjRZytxXcL8UPoqBP61w");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("aa9");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("D6ak0IAXd27VkCptFKibH28pYT90kD3GSAa1GbKX90RYMw9L4H");
            communicationgroup.setCommGroupName("IuCswqDt80CcZsgxZiDNyMAugpwSyrJakU61dSUBVzK1Mwftem");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("mcoJUcmq3dyLQLVdV1pOEvdNxx4jle6o5wcgv4JFtz1KICfUzt");
            communicationtype.setCommTypeName("khz84hKjnFxGeIzlaxmTLjxbF7iN9oAo9udpD9fIdLGRd9dU39");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("pUc");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("VEQAwJtkXCuf4xWZeu6kCpU7FIPBjLpjs5rtkYZrp57lDI9Jks");
            address.setAddress2("FkR9H1lwJ6u8q74hYfVTCJwA77djsY2FOBxVaUVr4L5oW7DQoS");
            address.setAddress3("afXyUFUCUppEwLUD4RPGG2B7cnP0JyUrxFVh1QvCCCUaBrjhUw");
            address.setAddressLabel("iGkolpe8OGJ");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("CZdercSCwSgTUXMe7vaA1PUv9y8h5Hm31qfKjP7cDAi6MndEuu");
            addresstype.setAddressTypeDesc("uoZ1kOBG0MyJdAMP4kBocXJwjmapxjsApdbyUHNWkJK42f8B6k");
            addresstype.setAddressTypeIcon("1NW56WgkUV6oFOWKzwJ8vZTHmydzoHCnlBngdpkmMzOjslgaNA");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("hl9vwFXFWsHHrrPxfQwPKho4exZuTYTP");
            city.setCityDescription("ahlc4mdmGeQB4j6IwKCb8Vtac8zlx0kXEoybqjLXE7TAI1BLjj");
            city.setCityFlag("jYI57t9urUT4aWEBCxiPTnCWJ556ysSjjIrSuAVE2Wl3NPRMUO");
            city.setCityLatitude(9);
            city.setCityLongitude(9);
            city.setCityName("Yqdz8BPoFDAXTL7ZWd5kaKvaFLXNShP3pPaPMBkGdDoZt6HgMz");
            Country country = new Country();
            country.setCapital("E9Dyr5IvrZifFnlPmcOVPrLnR5i949ie");
            country.setCapitalLatitude(11);
            country.setCapitalLongitude(5);
            country.setCountryCode1("oY8");
            country.setCountryCode2("Atn");
            country.setCountryFlag("s5V8gELmfzRGJTNY1A9ibUst6Yc6uS2noI723ifXBtIylMN9N2");
            country.setCountryName("hOs6pRSuEIpmGlKct5PNRoOKuVQY8Fi5d858Pynzx29juj2oMU");
            country.setCurrencyCode("OTB");
            country.setCurrencyName("6SPfG87HlJEstCBTFG5wjuMm7zFihuFAAiWiQxrO4TGVY0hdyd");
            country.setCurrencySymbol("8ymIeyXLT7F2ztQKeyYax96bf2A5mxUZ");
            country.setIsoNumeric(7);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("rlOUEfuPABowqoXTCk9PAd5VSGe57k0axmwWXlwwJmLw0nn2E9");
            state.setStateCapitalLatitude(2);
            state.setStateCapitalLongitude(9);
            state.setStateCode(0);
            state.setStateCodeChar2("eRgYrk8AXgSiIpxyf4vUe2z794DgQxGf");
            state.setStateCodeChar3("J3N9JNFqTogVJmrbxcvlcWYe3b0B51r6");
            state.setStateDescription("bo0W5jPPPeqIrff62creaRxloBJ8ED4jSrftgF9avsjn2hU6oh");
            state.setStateFlag("dTnS27HeLY4kT78S0BgtSjxSCWQ0jTlFM7L8VbviR07VZni28W");
            state.setStateName("2GgLc2QETWiaacimp62JKJjYN4kkSfmEABZpqgSnPgNOo64GWL");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("rRLTSgZaS2t869WwURwtDQWX2ymEbC0B");
            city.setCityDescription("qly8qIZ96axuICIy8pFFIuPq1i22CbumLHRnMNfaeF5znuALHC");
            city.setCityFlag("290Sjp2gIMDujD2jmcOgGM0mrMwimArzZVBBkqteSvSs8deKST");
            city.setCityLatitude(7);
            city.setCityLongitude(11);
            city.setCityName("Rhxw20tiI3l6AC2FzWMRkeWdbfhu5ohmzFUjkX0RWB6qBpJFsB");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("ZteOGt6u20OZSqtjHMZeit50TBN6ZX3DeAeqlhzmJzsaTDD8My");
            address.setAddress2("buop1daOl3F6a3hriuBEzESaufdVmAoQvi6MmPDk0ZWL0Sb7SK");
            address.setAddress3("9om60NSqJk3HHAWIL0guiqhy7g30OXgZrrzoBTGe7suQ7LBb63");
            address.setAddressLabel("cKOVVejDVTE");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("9gbevCII0kkdgXcNa2hA19KldrYLtV494v4Gx20XnYXdevaHy4");
            address.setLongitude("WnUf03TGuQNMlDTl0FgddDpxwJB1GBeT6ZBhX61sXfUF5Y88Bs");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("hxv84V");
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
            e.printStackTrace();
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
            corecontacts.setAge(46);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("6x5GkMS3M2fXxECCxnMg6KTHqUaCZKgGynlCuOS95RdNoa7199");
            corecontacts.setFirstName("2Y2a71ZTxfBGnDZPQLirT5ObctO3gjfqcVVAA83UeOysloItQf");
            corecontacts.setLastName("szcbws7g4zJWwNc8H2X3K1QFsr7pXtZwUdK6759TGsBrV0mzWD");
            corecontacts.setMiddleName("HldDWcXsXeFQvV0F1vwcT2bRVx3QGaNqSqhp2aiu6r0mxeqDff");
            corecontacts.setNativeFirstName("f7gvf0HHfZyHLxQjrQTPPQN87zrtYQbJZdzwnFMFeRb42hcHOu");
            corecontacts.setNativeLastName("Bvd2YTpTjjrXLT2KcTh7Uwd7bAFTRKhCWDplnmqB1uZC4I1Z6T");
            corecontacts.setNativeMiddleName("z86nPnoboKzj1AdfnaLp13Di1hLrmX9BR3vij4LgovpPVsU0N1");
            corecontacts.setNativeTitle("rMKs9UWA6owRJvVYHmE9mFRdMf42IGhhlplNs3C0ujt4L77kNY");
            corecontacts.setPhoneNumber("zQf22YclpUpn70aBhxWg");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBytimeZone() {
        try {
            java.util.List<CoreContacts> listoftimeZone = corecontactsRepository.findByTimeZone((java.lang.String) map.get("TimezonePrimaryKey"));
            if (listoftimeZone.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }
}
