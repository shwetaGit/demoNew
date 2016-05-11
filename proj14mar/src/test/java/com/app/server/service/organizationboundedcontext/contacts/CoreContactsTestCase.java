package com.app.server.service.organizationboundedcontext.contacts;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
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
import com.app.shared.organizationboundedcontext.location.Language;
import com.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.app.shared.organizationboundedcontext.location.Timezone;
import com.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.app.shared.organizationboundedcontext.contacts.Gender;
import com.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.app.shared.organizationboundedcontext.contacts.Title;
import com.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;

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
            Language language = new Language();
            language.setLanguageDescription("RH1KfFAF8sq61yGm4LJJ3d1FXePt48rIX065Vm4twEaLehyTyb");
            language.setAlpha3("6Jg");
            language.setAlpha4parentid(1);
            language.setAlpha4("DtRv");
            language.setAlpha2("ED");
            language.setLanguageIcon("S7d8lE8FD88YA3yEbU34BNxYEb9ZzvDMYqFaOGg4rJYn6Jcmu6");
            language.setLanguage("tzsXB6ujA6EJSQNzjxmYJZMcx0sO5m0s8m2e1YekKadknafLpS");
            language.setLanguageType("DaOPilBK4bnHfr29wNy04Vdn10UcwuTm");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setUtcdifference(10);
            timezone.setGmtLabel("mL2bTlsvEYIpiCJnD8su2Q61ZB1s47jZfq8GNxDEbBPgXJE9aQ");
            timezone.setCountry("uQ0Dhnu8toFacWxTwI67fSH9wjLPwCmWbjSddXXUrTQuXI8Yix");
            timezone.setTimeZoneLabel("sWiNVIMc6bg4ZvofkLp1jvFVp6hclyABLXB2qXyruiyOzfwJ6H");
            timezone.setCities("PEWSZILoHOe7i96j1CTbE0ENAd7IExzySd8TITqZBxOXo7eTIH");
            Gender gender = new Gender();
            gender.setGender("Izo2vXd8dy64CmyALz8TZaUbGGFb99eTtVqYsRoVRcOKjD7aFF");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Title title = new Title();
            title.setTitles("fKG7XoMqLyLYAgTX8xH2Sn2MPElJsS0MS0dzwr3aE4MSXClnmL");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(74);
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setLastName("jeqoOzd7G98xRpsrs4xY3UvIg8Szvct8HOEIHvEtLti297Uzq8");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457943999997l));
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setFirstName("DOqueAurmmDav8gMUUjpe3yhhvmgPwoM3ju2diYPAqyNJC2YOV");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1457944000030l));
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setEmailId("bqPrPdzFMR0Yqa8DefPuGlUmLMRdHHlhReffjaibvBci22wYpc");
            corecontacts.setNativeMiddleName("g4JwCnnjZkpc6wBn8IlUF2dnQOE7XcLnlFwk20iLzgL5lzU9eS");
            corecontacts.setNativeLastName("8FJoLFDPkuYIkOMrF2iZbcjOgrMAXuGdee2teHajOzFhhISMCb");
            corecontacts.setNativeTitle("QtgmApVzmRDsj0TfmhtX7uOJmTk9hmhBu72rYUMf4Wd55flCkS");
            corecontacts.setNativeFirstName("1RF9rRO3mnNs89yPpy9oqKEgjn54Yr9k3O2WX1C6mhWjFDPucz");
            corecontacts.setMiddleName("vRq15X8kFUj09hYiUQ3u0o9bjRy3xNoIYv0X8dE1RbVeLjubqL");
            corecontacts.setPhoneNumber("RwccJ7tc5tTk4zutL3Ph");
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddressLabel("Q0wTy7zCEDC");
            address.setLongitude("zyZFh2hes61UyluDlnDc2PtNGtIqMMaBQaiOnjPv55y84gXOC7");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("W9GLI0xLJLxIGGxFpqL0H8SeNpTh7UbYJkm5ti7SY9ukZrva3j");
            addresstype.setAddressTypeIcon("jg3uAkUDnLCt0X465QJewYo8B0hcFjiPue6hbNPWytzXY9X4bH");
            addresstype.setAddressTypeDesc("kQ4xEUAJNFY86EIPwTwdvEzgfT77B9GYey1xFWCoOX4SEfrUrp");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityFlag("b3Oc3Bm2gru22oxUkDP6BqcXzrCmGbxULJ2yMj4RhLIUpIN1CN");
            city.setCityLatitude(10);
            city.setCityCode(1);
            city.setCityCodeChar2("Qg2dwAaXJxb5QbqHx4yVgk9LWkSkiEIJ");
            city.setCityDescription("ttnuTEStpwZdQOb5uPdop1sdMPpNAcpLolYy1y16U2yOeeUD8V");
            city.setCityName("b6bVl013xznhpBFs8dZHZAnfUFzYYovgR2ZPJqH6eoqAe09ZJq");
            State state = new State();
            state.setStateCapitalLatitude(5);
            state.setStateName("tzw6R8Mri6nJ0kN3JYdJicgCPSUAbd3v2IViFs0HdyIm6RaSLC");
            state.setStateCodeChar3("uEGpRUrTqppvRdtl5b2CoNFxHiFtllZt");
            state.setStateDescription("bLQ6zosBJiXwKu0WMaTy9IyqelH6wgHGGbXNyLuPC6gt3aJoQe");
            state.setStateCapitalLongitude(7);
            state.setStateCodeChar2("40O4w3t4oF4pBfYAwu2xECre6VWMkUUP");
            state.setStateCapital("ITDjVUUqdSCJZrkG70quyLES0U1GHxbos9G9qIYI5Px4TToeJj");
            state.setStateFlag("LgoxP7wecEoYjEvYWOE1eyD6ysUUYgalVQ8usMLykZUjY0qy9z");
            Country country = new Country();
            country.setIsoNumeric(4);
            country.setCapital("43QwNlqJyrEC91Q994YZN67gpdaWSRxt");
            country.setCurrencyName("dwVOMobAMaEFZsABjCQuNnE45948yfCEv50WluU6db0X2VwpmS");
            country.setCapitalLongitude(8);
            country.setCountryName("uYpOt1hbRPJmokQrKqfxp7J7vOMA2VASsmU3mDdvFAgOP40p6n");
            country.setCountryFlag("s8ZwUXFi6EXWlX1bK19L3uEBvUbWDRkX9ZY4qky80VYaT66xvt");
            country.setCountryCode2("ucZ");
            country.setCountryCode1("qBI");
            country.setCurrencyCode("k50");
            country.setCapitalLatitude(3);
            country.setCurrencySymbol("MFAbAwdcoVpBq5L9xFJR3fXn8jWS4rm8");
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            state.setStateCapitalLatitude(5);
            state.setStateName("ipSZOPsCTF3AOQKUgN9ZjPgPoTO7tJ3T9yMQSnDmSJYMIl7set");
            state.setStateCodeChar3("fbD56KKXBNDmxpTHA3kyr0wLNugqSPTt");
            state.setStateDescription("E3ynP1r8dm2VAfy6sZwUQBUTMMIsxnjcnBtnNeT53F3umfK067");
            state.setStateCapitalLongitude(8);
            state.setStateCodeChar2("tLy50iSwbst0FVfi7S8d2eZrpBl1GGtL");
            state.setStateCapital("mf38r9gKY5xrjsADvg1CNyC9hIAM2jVeq9hRxdCigmJ6xGfICA");
            state.setStateFlag("X8Cj7wb8dNhjZT3p3CmhzYenz3auzMZ50BMlcQEMe7BNEfQVnd");
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCode(1);
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityFlag("pjRarFvfZCMCrL0LaMtY2MeyHi32RYIdPrRKGBuKqnhEGWAsyb");
            city.setCityLatitude(3);
            city.setCityCode(1);
            city.setCityCodeChar2("JRayUNBdZRbNJLTMvWIDhlYEv4Btg0C0");
            city.setCityDescription("V43F8yJalTDJYq7vmFE9pd1PSiRB9pyT0JUEvDfgDEm5P4dY0L");
            city.setCityName("2afmt7uEKsjQeVl9UpU97v4UIGjk4JQJ5AV81JdJOY9eEywM2Q");
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityLongitude(8);
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddressLabel("q0TyOyXzOh9");
            address.setLongitude("TbJudcunn90iL8qMaLCQpMQJhxbC8rUSd0sMgDFskZjiMshxuI");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress3("Y6p2lOjeE5pp29IcqRjQGeraft9S620GZEP5j1ELtaUez5lOfy");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress2("mw4PbMP7iAXqdaXOlEyiFzUQz3EXFFY6UuSzfzsZG864SMkEFi");
            address.setLatitude("N3cwZLJjyJM9XdPxn9eZ91dHrXZpLp0UHJC2oSsMW8UNB8Fttk");
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("8Fmb89");
            address.setAddress1("qvmXEu7Wzn1kb6t1AIPOlJfYBRfcdrSFs52qJHVDUOhN63mi7R");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupName("PusTN9sUzsx8uECfxbDnf62DprcGElrLJRqJuRaYVRQuXuxA0F");
            communicationgroup.setCommGroupDescription("ebHx7jhgOxhuBwBiCPly68RBbshf222mydQ6EH0JofBZGBh19L");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("JKtn3NApliDAeK4pw8rPRv3Cdy84PL7XzfJnN2xziq36TeCJza");
            communicationtype.setCommTypeName("coxOyZZ6qpX1IdPfvm926bRxzqb1mNFMFobkY8EUf3oYFPcMIn");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            communicationdata.setCommData("O");
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
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
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(119);
            corecontacts.setLastName("nTodOxbnPST63rMj1ZVCCWpgGFbHByQBONcGWcczUbp7lL1IA1");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457944000423l));
            corecontacts.setFirstName("aOQdIZBJ35r05abrL5Jh8TTzJA8eyCkMbNCPedbKhvLZYU8z1P");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1457944000467l));
            corecontacts.setEmailId("bI8FaYjUeC5pVhANoRwUg10Vv8j7nNSjj8qEBtUCFYZfj1BPUn");
            corecontacts.setNativeMiddleName("HTBXJeJhRaEhA64WyirOd2Lx10Vz08NWckAyQxhfgJndl4Cs9O");
            corecontacts.setVersionId(1);
            corecontacts.setNativeLastName("pJMbl3ulv7PlFFD9EGG7wtmztSaKcNWpdXeZUdbYrCcpNCWiRq");
            corecontacts.setNativeTitle("brZz2vuQW3EQyYt4bWDehZpLQ0k4exXE9FJ46rei5qTLLORMrv");
            corecontacts.setNativeFirstName("OypujI5bwcc0l1Xiwt9jfwqW4X8XcQlNjY0l70WIIunEuNPayC");
            corecontacts.setMiddleName("nOeQxKNHVyfcNCdZFzn2LXNBIv8Cu1ZIN8E295bjjVgCQW5PrO");
            corecontacts.setPhoneNumber("njr45kdRBU4nDOH3Nqgp");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
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
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
