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
            gender.setGender("WIz1iFBO2WoogAkjrRoy7jqrQHW5PmCO5zm4YJFJv0CBqIi6ax");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("1D");
            language.setAlpha3("aCY");
            language.setAlpha4("z8YE");
            language.setAlpha4parentid(5);
            language.setLanguage("BmjEczD4ji3ybbk48wasx8tovCHoFaG77Mt6waxhhR9xnzRXuB");
            language.setLanguageDescription("aDasqj9OohZTn1jyz7Yfsz6NZto8KVhip4jpyyrcc2042axkjm");
            language.setLanguageIcon("ggEHSOM9ylIgZxNcDc8JQ2yL9wj552n0jUYlRQCZdn8fTAxHin");
            language.setLanguageType("g5HyQRW3DqpxlqiwTH9tmWxrgiSYUuTN");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("tFFO3hQxyp5cw04W6jrHviQSw65Ckc1snYPdSTWyejbRehADQ3");
            timezone.setCountry("7fwUuqtOzYxKnejoegV2LWcoUbeJsbIkn4d33coJ83XpBh4Hau");
            timezone.setGmtLabel("sldFt0yqKMZeykd33Zgbrjwjb4RQZQcewHJWTud6L5QiDEgWCR");
            timezone.setTimeZoneLabel("sDYTriPaKjpzFtu9Hd0NZJw9w2htISTkS2Dzea6jK8pc3mJZkS");
            timezone.setUtcdifference(6);
            Title title = new Title();
            title.setTitles("xziDv1gqD1UEFMVm56n0fAsX3YII5Pw68mUD86BKEADlWAMnDE");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(39);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("3BjD6paTxzHHPVu7XvPmvU5Q3rLMhB23FD2Bi9ncI4UorR9IyG");
            corecontacts.setFirstName("NIwkpg40oeYdOFhFs7xY2DCKEcCBNJzWKQMvkKb8g4dHvZJVLM");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("uenwNafBAnLL2MPQg1R9lcfPfhvVz9hP2JYWsi4v7RKv0kXIoT");
            corecontacts.setMiddleName("VeWf0W6vPiINk1ydQBBOse556c23YL1gsStDp8TcIdMkYuJPKX");
            corecontacts.setNativeFirstName("BDFnPHoyqGZ1nbXQsAuBhDGJdjszhN31x98iCns6yg81avIPwL");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("GyWMRS7GXpYbUjL8g7A2CPhVZJyCQguZFw1txILowK8e8sVPYF");
            corecontacts.setNativeMiddleName("t7baxKtuBggo0Tt2Q0u69xlfgLQcEwGqQzb0GrRHdJBpwaRMqT");
            corecontacts.setNativeTitle("NHLWvMKceXmHtgxOYS9SXljuhVwLzgEwwfcifrM9BeYBIKOOy3");
            corecontacts.setPhoneNumber("QiiYQOjfBm6QMBg8Htwx");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("Pf8");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("h5dZuMk7mbDBQ2wjXKVCx5w0HnOTPKLATClK7PVg810WGOr2n9");
            communicationgroup.setCommGroupName("7IoJGPZxA8vFUFPZQKeNo0QcP3jZZXLEFXN5TwMQSvv5KchEeK");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("wpLJOvf97HGZBVdy6411VnuwjSEFn75Vk7yZ8xclC3Lcl2fSFq");
            communicationtype.setCommTypeName("5E25bPmLnU8m6PkTexhxBfnOkp7kE2gAh6NKQTD5ix2a7zDaS9");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("88E");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("pzOW3uss5DGTedgbIiJEeJS3p4jaTDu5QrJH48H0busvkcIpWv");
            address.setAddress2("L9JCaLiGAlP50vQdGMQREslFktHz0kEdrWFghHZVN5apj73gx4");
            address.setAddress3("lNPKh4dILpZU6NHaFbUZGsCqmR61d88vDHzmo53bi6WKEdtcPK");
            address.setAddressLabel("XPNUtlrauNp");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("dmf6INA6WgCvqV6g898KjZ15dx7Nrw5PE3H9Bww6l8xUbLwbRK");
            addresstype.setAddressTypeDesc("i2rFCr86zMDpuDZfGjklajzW86CKEeuJJMFKsSXMdL3AED89pp");
            addresstype.setAddressTypeIcon("kYzVS0fxaESSHt2prdDSVbgXQR7XOxX2xdElLSnfB9hMLtRtFh");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("gqqMS3pGaHJkqra2NbWcMb8yHo4ospTL");
            city.setCityDescription("lafnJjLTAOj9gJBP0HMaJnFjQSIXWQZBgQkKSypxsq6zp0RrGP");
            city.setCityFlag("r73RwARuZaOCYgeDqP89I5TTuDhJeUXhwdSca7dWVco4igLPt8");
            city.setCityLatitude(2);
            city.setCityLongitude(4);
            city.setCityName("Oj50UMjFwAu0lK9lZZFu4hWwCvHjoOUcy2VYdf183kizD3Yetg");
            Country country = new Country();
            country.setCapital("vZuHCvYa0yCN3JobxseDVtTrRaxT1zeA");
            country.setCapitalLatitude(1);
            country.setCapitalLongitude(5);
            country.setCountryCode1("okM");
            country.setCountryCode2("C6b");
            country.setCountryFlag("rRXEOh3s52WKJ9OlXctt4DoFwWmkDyyCiFfqkpU4vy1XfK5fGG");
            country.setCountryName("86ESeC9B5zvFyb5XC3ur2OiS8ehYA2GEhDZRdZLGV4lnA18Sxk");
            country.setCurrencyCode("xHQ");
            country.setCurrencyName("hFZM3ef4SOqe0xhwlbJIiBMvaypHBREadCWvfFsLt9DIICky6T");
            country.setCurrencySymbol("zSPwC3qVJAMXmqMadQ13BxJ9fl3Ohs9h");
            country.setIsoNumeric(4);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("vduwqJPoaUQv9bO03IVl51mNKm9GiY5rjUmkalqGDCBW34lgE5");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(1);
            state.setStateCode(1);
            state.setStateCodeChar2("m81uxXVkeYnx6K2pHgcPVVthPooDeaCS");
            state.setStateCodeChar3("9KWkwX4R7Qr8qJMlkpMuuCjn8Mf0vIjx");
            state.setStateDescription("3nn5Xra7LB0cnxE18WOFkOy9vtysFkRgoM69rpfn1i2CpVOHwc");
            state.setStateFlag("RkPlSQ7CLRG1zcv1WDQ7zC1GDJX5wVcWBxXXqI5suDQYFsM1bc");
            state.setStateName("V9TuA3FwolVIungdnEHtB8TmK16VoKNiAL5EFIWiKXdD6OC8P6");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("pnu1qt1Esxgb6bws8wJsMm4Ak9ysp4KI");
            city.setCityDescription("3NaO9wu1wRpgNsPjKQOyWFQkuR4TewsoWwcV5RZY8T5NdOwsCC");
            city.setCityFlag("UTxFWBB352NiwRFqFOuZJDa2mTui2jgagh7OokS5P5qI84Nxds");
            city.setCityLatitude(11);
            city.setCityLongitude(8);
            city.setCityName("gbRr9H3XaxbavWoxCnLyPT3Zh3D5LtuFVUTWYPAeT7zKY2xjkW");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("1jGQM1jbOaP2N0wYESeozLxGr6T0RxCVsuVltQ1HW4u8RgKHyp");
            address.setAddress2("9WGoiD7P3eSk8lfV2R2z3h6FjdiLusdIFtfVMRmGUJWxTkYGUx");
            address.setAddress3("WndK8NrGsQYl0r6DfkLsHdsOGN6k2Tb9MXxE0kl7RAofTWmI5k");
            address.setAddressLabel("pg4ywtcM5tT");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("8y4vaKG9rLAlEXBjqu2oYq52zO3wBSfLuibGqrAH1YyQ6g0BW7");
            address.setLongitude("iEkAvNtuzAniU7GLyMzHe9Ap2QURTvgqUkK18KcHGYpbAFTESL");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("t8UwDZ");
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
            corecontacts.setAge(29);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("8OCSPrxZ8SUJ5Qz6fJhvPWdhk0u0524ka7GaP7xhDDqCeHiU5D");
            corecontacts.setFirstName("JAJMaTKDmximLZKoyAvJh08A3B6zMvT5cNdEOxlLq5Luqram8k");
            corecontacts.setLastName("18wmTcphRkUaw3F2xuYtCG4RUDcN6MDoBanCfowETcnNWAupbb");
            corecontacts.setMiddleName("6uKJAFZb9oshtJverFpwgq08UQzMaokRtYt2Y9IU1boSUEKVRs");
            corecontacts.setNativeFirstName("awP2yWPs6JjbgJ4DYtYicijRLVYZQ3qrWjSSwXbmLeBSLhsSKN");
            corecontacts.setNativeLastName("EKVlylKQfieTIgKAKgtuKpkW7po7S8PTd9ZJur5EHAiS4CjMfl");
            corecontacts.setNativeMiddleName("1NwD1olW1ZpBQUdFP6FjzdZZCqPMzdI0SV3ePNoViF36B3yKdU");
            corecontacts.setNativeTitle("x22fj3BvFnJEfRA2J9LW3MQbvqxZJyo07MX0t3F1DBjJ3efkj3");
            corecontacts.setPhoneNumber("ucd7Vh4pzrBw2Wygj9gO");
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
