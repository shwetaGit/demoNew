package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.CoreContactsRepository;
import com.app.shared.contacts.CoreContacts;
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
import com.app.shared.contacts.Gender;
import com.app.server.repository.GenderRepository;
import com.app.shared.location.Language;
import com.app.server.repository.LanguageRepository;
import com.app.shared.location.Timezone;
import com.app.server.repository.TimezoneRepository;
import com.app.shared.contacts.Title;
import com.app.server.repository.TitleRepository;
import com.app.shared.contacts.CommunicationData;
import com.app.shared.contacts.CommunicationGroup;
import com.app.server.repository.CommunicationGroupRepository;
import com.app.shared.contacts.CommunicationType;
import com.app.server.repository.CommunicationTypeRepository;
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
            gender.setGender("L3lozTQ4ql2Dio2vvT3WbwqxBAmuiMSZd2gh7hVUOYO04zH4Ng");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("wj");
            language.setAlpha3("qmN");
            language.setAlpha4("zHgX");
            language.setAlpha4parentid(5);
            language.setLanguage("V9PBjeSbkkzfo2bAVbZYGcrXXRxps588WxCxNyVrM7IvEiLXTn");
            language.setLanguageDescription("qIuY1DzoCC4KDGi0flJ8zkJ2EmcOunsjWVKFrLErp4sluT0Kub");
            language.setLanguageIcon("UUg1iWsOInTY1DtSKqTR13zBRnUPpvvK0rSj64Thkgna5Halv9");
            language.setLanguageType("Hk2pqxrrNQJLSfYgCkqCM5meoBHSFRTt");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("306SdQqIfFK64QSDA9uSCdYaYdyUu04E4sBYRKe7wIAYzoBw0m");
            timezone.setCountry("KUPmTFpNFcGlcfCqOOAQKtNPtuLPm6EPvtDvDGxjRiG5K1a1dY");
            timezone.setGmtLabel("WNxnm5H9mQ1ovzoAs4DhtRQuQhIhrUJTokQfAbrbU4jvhq1YOg");
            timezone.setTimeZoneLabel("GaEXFnaEF3imjVisVtYuYgHzs8x5fRnFI655Pd8RQP8PZyFgEz");
            timezone.setUtcdifference(0);
            Title title = new Title();
            title.setTitles("fTWWUED1ot1br7iw7bEz8Z6kcArf9COmfITc0Q1WBaOgN921ha");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(73);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456478438255l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456478438255l));
            corecontacts.setEmailId("b6Rm0bzD7Xwb6AibQg7aE4nqZmrZSFtRxEJlWAG3Hx6syLu5J3");
            corecontacts.setFirstName("JnOF8GRCfzjAmlmuvgFThyoPjJeni5yBmYQwm1MCZoRuj8TQes");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("UTuoD6bQXHbWaN8KFgdTVY1Ua3e7eHrQ7xQSmu6do7NcRN0ijN");
            corecontacts.setMiddleName("jVjuCrxS3YBeo8WP19gnTR0pKUuENuKSlzAYX7nHr4VckxJFje");
            corecontacts.setNativeFirstName("ZjbtFqXeG8puUIpVpt7IK9rD2op8uDjL1cQFt2GSJwWIlb5HyQ");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("4DoejFJM3tpLAK8uwtXCrTJNlHA0WyeY9qLFd4TaxOnR2XHqTf");
            corecontacts.setNativeMiddleName("OlouB6cTvpbegqY2gEWjQ0q30T8ojU0mQzUBLooJv1PadnMqn8");
            corecontacts.setNativeTitle("wsaI8l494r81HdrMeWehkjuG14u7dvJvj0sAMJ6dXzgmqL1s3r");
            corecontacts.setPhoneNumber("iy8yozbcoNERBMYSMpwT");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("W");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("syrZpn0VTrY6s6GEBkkMnIJV9UVdRm0dirZblC3ZtcA55Z1sql");
            communicationgroup.setCommGroupName("c0dZHbkSolg59sBHjZhyFE4292VdIPKLsXwNoXbYbwQt1Q1Bnj");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("BpdrfmSyhBoNJPLulLOR2BPGAX4H5k4VksCLMIPeSLUu4aRDDH");
            communicationtype.setCommTypeName("9VZo8kIPEbwk9CE4sMmFk9qQsl7qfV5bxJG0C79E2doOAIEg0c");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("1");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("KRQ9bfg6a7MR6d6iIQxy2ZlnGvcBFX4OYoQhKA5JsesNxT2seA");
            address.setAddress2("p1QHlxNonJUHEU4QybirzXxNRdXWKJhp8sWXqmrgCrmxkJaZyO");
            address.setAddress3("WrmG8P0o06A4Gk17nnpMszxs691BSYtrmYVeJ7mWHNIffMJpow");
            address.setAddressLabel("7jcAlnvHGGd");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("GDbgXt0EHvoAz1qGVn0j93wPqMJ3G7kCHu9J091Zu8z5a9uj53");
            addresstype.setAddressTypeDesc("qbdCWjS57AhLesKmzSS7O42VICmRB9m3PdTP1PUXi3hXpKBiMh");
            addresstype.setAddressTypeIcon("q9Np2pAsl8XtUxji5SSxQNuScJdpMB9n3jDWugODzioEOabQhz");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("3mMMyNBV21uPzUjko35P1RCtzKPPxNCb");
            city.setCityDescription("Doa2uWtjS0llpqWaBgwEgs9K0vM5abhOCA4YjBgKTt123HuLFW");
            city.setCityFlag("RWYeeTMWjupWaSNnYXPfyUNZsrm7mT6baUf8EYzJm8jwNcOdDd");
            city.setCityLatitude(7);
            city.setCityLongitude(1);
            city.setCityName("hGanauTQ4wHzq2mnCI5G8BK4BznI9f5JoRGmAyQl0F3nz64ZpQ");
            Country country = new Country();
            country.setCapital("S6Kb96QlnueI3UPjsLmhPaaLcBOaLNJl");
            country.setCapitalLatitude(4);
            country.setCapitalLongitude(0);
            country.setCountryCode1("Hoy");
            country.setCountryCode2("oOa");
            country.setCountryFlag("lT5n691TJSgiV5cDcYbjckebePvTI6ygCGiOZvx69w5xMnPk2U");
            country.setCountryName("Jh2yhHQwrXTxUKmeD9HQFgWbcz1ICA1NHIGZxwCCeVCPkDzStu");
            country.setCurrencyCode("t2s");
            country.setCurrencyName("M14hMWF8pejPWBTFs385j7jjkIDz7JtprMmjJLTxmnTYPICRub");
            country.setCurrencySymbol("RnJij9V2SlWm6e4DRDqzTkAY2WjZ7Vvw");
            country.setIsoNumeric(10);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("Ab3UN1EpbdjjmPvC6KbAGSqTNKCGqvCuYhxVqJiTViUfOOHug9");
            state.setStateCapitalLatitude(7);
            state.setStateCapitalLongitude(1);
            state.setStateCode(0);
            state.setStateCodeChar2("rSUpB48zLK2JZfnu6IgbxpjwixfHd0Mt");
            state.setStateCodeChar3("ushf7fQKQhNpbj0uM5vjrilgJwIHAB0N");
            state.setStateDescription("ogFI7BwMRp1RyxAMlG3NFkS2VNcFhS3Yb4GIg9ik0kt6Q5Lw9W");
            state.setStateFlag("hlFonZDRITk9eZf9rHhr5tE6pjrUcFu1XNGpin2TPiWEJdkwxN");
            state.setStateName("JnMxjGNEhBfusuhNM361ifnJCRXFydFSV4lWQ7NEh4hI6UaZsi");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("htXxy6GkwKIDBRrt73rvEki2TjBEOaDw");
            city.setCityDescription("j7fTuUtpXRnb2oBvfRHuHiLrvkYmfWOmdv0qQudoJ9uhEjGBMa");
            city.setCityFlag("sQ0J9QZYkDlkRdQhWgZxZYQUFrNTqyRiktGTBvMfrNVw1jG9RT");
            city.setCityLatitude(2);
            city.setCityLongitude(3);
            city.setCityName("cSYNyLIqktcGrcUZBPDzY2ncO67SDDgyAYTwhMuEeZaqU7elEm");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("ReGh6L3kQBJGPVOkag6SiIwhgdWW559sL0nZpGxHi2VQYXELCW");
            address.setAddress2("Emh4f5YzguhZOXv9GhzSLGAIi31KFRFD4pQ5gCjwwk4MhT5hZH");
            address.setAddress3("IQQbH988m3R1axno3sqA3Y2vA8yXChPu1FmnEZJkXJPZWAwMJy");
            address.setAddressLabel("lTrZnDFA1PM");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("OsyeMmvfKieSD4K5vRScTlreFVORunh3mROWRmG3Fh6KFIyPrw");
            address.setLongitude("2sEksjL1qTNsnh5rRz47Ecnu02trJeH9JL1fdpNPmMcsNmeT7Q");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("a3tC7G");
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
            corecontacts.setAge(99);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456478438852l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456478438875l));
            corecontacts.setEmailId("0yUzJkQtB7ebDOZ2eLJM6tXgRAdWaPuzoMhjhCPoFh3Y7cfc5l");
            corecontacts.setFirstName("MSH8dDQL3ZMXs3bP5F7P0nPrKYlXzhvCcznuZB63r2XOKVpfKr");
            corecontacts.setLastName("wZkjtZrVIC8IcmZtFa7J1J6ADeGbCI0jhDkZvYz5lM40a4J7kW");
            corecontacts.setMiddleName("QEi73NpQZPIlrQNFhlaaeWTH9mV0o6k6vshDnRtos8P5B895Tt");
            corecontacts.setNativeFirstName("UNiyrvEmBWbiqtxjQIlLWdRPk09i8rDcdTyDJU6t79vfRMCgZX");
            corecontacts.setNativeLastName("IbNsZjxGaOCpsJ9aypiuTpNQ9XPnT5ky3aEf5HAscOQ30Gwqta");
            corecontacts.setNativeMiddleName("t5eJP3rAT7ntDnl64dgqDob8x2I1XYXLj2wvJ2sgvEYrobirly");
            corecontacts.setNativeTitle("snOOHExhUVlyuE9i8QniDvdzrfQqMD73wQO1kNxRXfKUmKvVCN");
            corecontacts.setPhoneNumber("aJuQm9HdNuz9tNlPpy7l");
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
