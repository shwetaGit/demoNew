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
            gender.setGender("fA4WB9f9VcLwLKCjEaUV7YZcqEzBt9aZapEn7CLoGNRQkO2gpn");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("4L");
            language.setAlpha3("dME");
            language.setAlpha4("kAto");
            language.setAlpha4parentid(4);
            language.setLanguage("ktUhuy3JZ2vZEkixq3vMf0FKvrqzj14yJKO0BfZtaRpVrxTAtA");
            language.setLanguageDescription("jKfJQ4UdoKJInuIOKBlDVPXNafIGFCC7Apk1VkDN1vuKsy8Sxw");
            language.setLanguageIcon("AsBxm0wSEUsZBuA4uTU2ijJzCRtfn0rKdLUytDR27G1P0rFLmG");
            language.setLanguageType("aMJpfprET01WRKjsl4PL6kZ12gN4JPQD");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("NbAhhXr01AUOdcJW3ZcMvz66YhVsKHHi8Yn3FguNvwRMDa85za");
            timezone.setCountry("l7sbw3YNk2kg51tfg9Sl73Wr16NjSAE4opwQcX5HfENqxewAv9");
            timezone.setGmtLabel("OvmYEV5lojmq4BBDBJ3XHZv8gQBF9IXK991vcTUu8bIBjLM90T");
            timezone.setTimeZoneLabel("Ejtag4EzucNfhnuN3YyvxpFtkhweEYyB335uV65yQSsnMaFwSl");
            timezone.setUtcdifference(9);
            Title title = new Title();
            title.setTitles("6sq297CPxoVFPKrudafjFulrgYZSo5xXBAOv7OuitDZISnMLKN");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(25);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456739808560l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456739808560l));
            corecontacts.setEmailId("zns4nAd7qwaTKp7RckDNPJCAroAMbwmAMGz21Bet7eXlz1YrJf");
            corecontacts.setFirstName("v3XXa9ntyybQvrNLbTWivvfIunYcEe2kF5egVwkzZBhqSd7AHh");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("zZsZ8NI0eQujbZLDVmK8p8j1M1rp4wIfxvLzDp2kh6aXZt17pK");
            corecontacts.setMiddleName("7XALyDWcrURttHo4pKxmgyaqduCTKPJwWtGXJQmQHZifIaNRLi");
            corecontacts.setNativeFirstName("fqACpxgBrzwjdJ03ZcneiXSJ6mgV0CbHZTp3n1dyYwZsMeEUQW");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("yqDG6LhlUvHTlGiUSK4QFtAW1ONvrUGmcIQMXKpLSYJcRmraaL");
            corecontacts.setNativeMiddleName("6otXSYkWyDVQyuTDvCdgCcTW73krfN9nkXqWmCVaUPsBnNLHEu");
            corecontacts.setNativeTitle("QjFP1KMsU8bwRaihPjBv0uMljNQdQyNh72w8JUUXAx132a6MtL");
            corecontacts.setPhoneNumber("CiVtO69YYdPtJzTgYmfq");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("w");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("MhahAwC9JnXZn8iOHi8yCfff4uAAxlbpxiOJSvKAre399GZ3x9");
            communicationgroup.setCommGroupName("slM8G3yqBdcPDEEPZmwL10j4sDJGazycdqCMmz0pMDQARIjVOQ");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("j2xDGSKctGRMzqFtwDfP4WBCiEgeniPDF6CeCx2RNUTbgqYz0F");
            communicationtype.setCommTypeName("hCivg2JZfiJ1s6o50TMw8E7k570NCqqgbTPtLWdx1wqWjQ9feW");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("h");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("q8Mf8mqwM6HU1e0Y1k0xwEksi0PBwBGUvTltAG5ifiC6fFerOj");
            address.setAddress2("GByUZ8QnOJbFvICZuUsUZiWbDIGAzXxYY40NFWROMxgmUGB7zw");
            address.setAddress3("C8G73kE1JdspbWcUQKrnfcHnoykjycpkqKNK9zRcwvvJDK3YWY");
            address.setAddressLabel("uUtI910EQ4f");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("yzoIPwRv2NynDT00xIL7pGoYHuj7c9QAm5EH6EdAM3myPHb9pm");
            addresstype.setAddressTypeDesc("9aihkE9QoQ5OlhRq7fgijWSGYtBPBvb5ORKelTsESTcbnSm9bx");
            addresstype.setAddressTypeIcon("Bumqq6fYOCzgSqscIUH8QUOelJtLlyAMo31nMJxTYPuBmGbVHN");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("4PdPbwpsO2F55eceK8uMyDx5GmfHBKFh");
            city.setCityDescription("WYGSOYaqur1KGRqLo0ugPFmwfUztD9r1HSV36anLw7VZxA9q86");
            city.setCityFlag("oxiJq6m8FtUYSatdDYHjGBvCI4163AyVfpF49wLBn1EVTno1Ax");
            city.setCityLatitude(6);
            city.setCityLongitude(8);
            city.setCityName("LFQWQIghepfcHXapV4KJG2oN31DeMxeln7KBuAsREbNdg5GRWM");
            Country country = new Country();
            country.setCapital("Xsezx2mpHFZSslJxRExSl7ueSm1HWNrQ");
            country.setCapitalLatitude(3);
            country.setCapitalLongitude(3);
            country.setCountryCode1("NfV");
            country.setCountryCode2("25r");
            country.setCountryFlag("Z32dq1EW1xlR60n0qoHpfWLDzJFA355uBbrSdoqFtQxzLpL7SD");
            country.setCountryName("cr8orwN7RLDOlagVCCoJhh16REHCaSQ9sWUO8Qt6De5fDSqyNx");
            country.setCurrencyCode("21d");
            country.setCurrencyName("oCzhjJt1CmJJ87I8ZrdO3rseXlryrqSX7PoanUKnXQRBRIwAXp");
            country.setCurrencySymbol("Ce8gwDqzZiLRlGmfGOXu7lGgW5AX3ur5");
            country.setIsoNumeric(10);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("bLPn2dP3nN7EDvqZzBYQ0H0FR25Pksw4HFAqN4If8JKLSECRTO");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(2);
            state.setStateCode(2);
            state.setStateCodeChar2("wn3hoP8qjxGgXglfDEzdW75lKlVYjCyz");
            state.setStateCodeChar3("vTfYREDOsQzIcN1IBwu5KT3tKLcm6Wnw");
            state.setStateDescription("zPLVCJ2nN3jCJ5HhiB3M1zznCepQm978ThgvQdAuqmP2FIOYRS");
            state.setStateFlag("v9rId0rXNVo64dbK0DCWfT42KUaY0NggeHPoo2mbv2bJuLEctn");
            state.setStateName("B9DcciLmz80wkZ8J3j0LzIKxe547wtywSwQ7Y1ywzY4KFCMp9b");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("sCXYtIx42HJ6Llx3M1ZnJvBa15jHRMwA");
            city.setCityDescription("49g2IHyH7uFjAlEyVYrsk08VvGzIKBm5nov1VkDuM9MdjBuG4Q");
            city.setCityFlag("nlpZ5QLZPgDx0fAsU2zf5K3AYZh0NXwwGHNFk1utFwiJ2Qt594");
            city.setCityLatitude(11);
            city.setCityLongitude(11);
            city.setCityName("utCFkSOGiA2DYn37cOGnQWIIJkh2bkoKuVQ6Xrb3GPSOAWnysA");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("5wGrndVCXw53zekrlo3lfOYeXRmfkWZSKtmRZRQ9sWULdZ1SO5");
            address.setAddress2("fRa011WHD7UFRtwMiwjg6HrBj6wpYDIxoovjPu0TYT6Wmgy8si");
            address.setAddress3("XA40MrNmLujGgdhKG4JJA9DCD1cUNsiYWoMhuy1Ga1vQK9zoGc");
            address.setAddressLabel("RvF902Sr1Ov");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("1WWDenAnxBYg5BKR8vUUV2Co2swYro2I8rBRNlivf3MJ1IWLLM");
            address.setLongitude("OzONKapDaYNvmL9oeg9fnVWiknHRtuWswpO7YI0V5vbu1CzP1G");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("EuAkOM");
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
            corecontacts.setAge(47);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456739809166l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456739809195l));
            corecontacts.setEmailId("IWlVxDh8apy4xtr23b8h6JF7kcCvVe4LSwYSb5WkEcVDItAaS3");
            corecontacts.setFirstName("cZiKBct8m7ThDfcxyMl3IaThq5yiQFYn3OaTfci72SPtPrsUdt");
            corecontacts.setLastName("Qe7XSoRyuKx8796mpMhqwIxj6Ui36p6vAifjdM8l7Z4T1JspBS");
            corecontacts.setMiddleName("kOpI67UQZpa9gaSKWIfeJ5rRfmiFNV15nUKqniMCAwGNAuLUip");
            corecontacts.setNativeFirstName("ONhja3O0O4pUFZ4B1mHHiYZ6Io8Xma14D6dKfhW0CULxuKTdnt");
            corecontacts.setNativeLastName("YtdSEPJokreYXPApugObF8bUSdn0qYiaCoEGlo1CqswnncaZ8p");
            corecontacts.setNativeMiddleName("IcozHvHeacopMDXPcioXTpMy7rSMPrh8Zl28zpI94WYUTP39mH");
            corecontacts.setNativeTitle("xGbsY8MhB1Dk5EeYVGpBrIzYu1CyWcAhyGWC122wPFe9yU3QPB");
            corecontacts.setPhoneNumber("jeCiz8mrHoRjcGVRAYfq");
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
