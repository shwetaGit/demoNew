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
            gender.setGender("6gyS8JF1uytrkPQms6e4okqn6pnuDCJZIuJwn6fE93R6b5qK0y");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("01");
            language.setAlpha3("bPt");
            language.setAlpha4("vmun");
            language.setAlpha4parentid(10);
            language.setLanguage("i68pDuvN7dUQ3NNbiB0FmGaopWGZi2cHq5wusmCZmhr70ZpvYD");
            language.setLanguageDescription("pQ9wBba7t8r5oPcPKdQXN9TKqWN6n0UcqRe1lRV8gIQf9iPR8L");
            language.setLanguageIcon("FNiViGs1APtqxB1VHWlyEj3UOmAYpP026bFSFRUNcgTscKtko4");
            language.setLanguageType("f6f030hcJkDbtY8pS79v78XkKbkB2uew");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("XH7lVIukcLf5n1dXNZl6Hia1RA4M1qq7yUnnUlRWgaYklhlIg1");
            timezone.setCountry("0iVDGXtUMNqJkjEoeb7bZYM4UOUaMZlm5IC0Fh0wRVE7LXRV6r");
            timezone.setGmtLabel("Kvda9b1NSyIsdv8GEwO8eiPGx7Bqp0zfzfIuitRXLF116GvofW");
            timezone.setTimeZoneLabel("aPwuDyv84REbXkEBtpO1wGOud31L87Dlr9qusilMSJws7ady6S");
            timezone.setUtcdifference(11);
            Title title = new Title();
            title.setTitles("uE5D7iruyEJ307XfaXcG5SPucoM3CTbsf6kzLPkUGfcFwBvpJ1");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(50);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("pjK4HxxgK1HoqKVU2JVvHHF7dYDfIORXOr25j67pYqVHLLV3Ql");
            corecontacts.setFirstName("5OVfNgam4VibgUihPCdohSdWuhorrW4BKCHFLb4Yc7zxkG85tc");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("3vWNFh0hJyn9YtZAKPcBAgmm1ml1Ip6qh5OF4vwBZMOPbRUFj3");
            corecontacts.setMiddleName("8U3dCG44wB9mHuNtDmEj0olHYJnU7lbTFNBKDKuCpZQBApTb7y");
            corecontacts.setNativeFirstName("zbHbVhGNQVQMaxJmHanrFOs5QYXuy12v8SKN3mXFZ2LnQloD2P");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("2FbPnQAtIFKH3bp3A00SD4rolb0m1y5KWXjc5aZmGC9TbOSLTy");
            corecontacts.setNativeMiddleName("lRW6bwrdtFeWGLtKMUnDbT0C2Ywfc76AeEZM7dAkALRA96gzTT");
            corecontacts.setNativeTitle("GjaEODqyGsFIUtYJUUshUIEyjrnU2mitmAa7fSWRJKWoTPRalO");
            corecontacts.setPhoneNumber("MMCUigst8KIvZsxrBpjz");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("zAK2wXVEuorACsAkrDyZAak9TRYOLztVCbMoxZkYr50goEmojl");
            address.setAddress2("Tt53XIEXJcm4aWzZIIrCwpoabMj0tOQbKZbyi0HdbmXDp5qme3");
            address.setAddress3("HPsRMQBd61GHMRgGmt2FXlrAsFDU6rHN5TUpJDIsO4xvExG7U9");
            address.setAddressLabel("SRAuixITPwo");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("FdQHt3kpMZMFStuV4IDgSUGvcVBX8ajHqFI50pCSrSR13QSY23");
            addresstype.setAddressTypeDesc("LzLSUK8aU20h4BBexbR7vWDbBnbzaIGejyHv86ECwyRBul2rBB");
            addresstype.setAddressTypeIcon("NwxPMtCP1GCSSI7cl5LMoLqH8fKzukuLxpGQa53AA9G4yWUc2o");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("qCCokD1CyaYqJoA0eeZdjV3tzOfDAiGs");
            city.setCityDescription("M2UWlCAisWqZ3oEIuhzRuqVkaEfn828PYTUE46Iuw5JTdlr33z");
            city.setCityFlag("3yxEowhj9nXcsWZH8j9rt8tYJSbI2kdakMS80Xg9pYlcvzT6MR");
            city.setCityLatitude(11);
            city.setCityLongitude(1);
            city.setCityName("99rJeBruvcfa2oqsQ0QNX6KZN4gyJRYTiHXpBt3IK8d27TUR8n");
            Country country = new Country();
            country.setCapital("anrjdB1Rvgn2O9hbxd45DsJqGagN62No");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(11);
            country.setCountryCode1("1kQ");
            country.setCountryCode2("6Ey");
            country.setCountryFlag("Nmc7n0jNO3llRqCs9fsBJCNZzvCOmdI9rod7P1uDuMmgwxaKWP");
            country.setCountryName("TZOaWukRBgWeuTP6NNSQCq355nMVyUEvd6BltL5tU1dP9kD3qp");
            country.setCurrencyCode("BkU");
            country.setCurrencyName("cLtaDDPCub58jBGh0kfkJYqJ2nLhVdbCN7djB1PE6awvE6QRn0");
            country.setCurrencySymbol("CapWgqhnhCqAOCGFpJlrc4XwI0wTl3c5");
            country.setIsoNumeric(0);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("nJ8wjwuTZZbLtFP4eZcjiMIhhUZnnDOOipSCbUy2IEvE2UUmtj");
            state.setStateCapitalLatitude(4);
            state.setStateCapitalLongitude(2);
            state.setStateCode(1);
            state.setStateCodeChar2("hvZomAsAC90TVZOiCN042cERDwYFvCbg");
            state.setStateCodeChar3("G6hV0EZIWcyadlNrBN0ww6505Tbwsqdz");
            state.setStateDescription("epEDNdcFLzyUDxfdl95CtoY48oSJ8RkAgJWGUA2t6BgXZX1kXD");
            state.setStateFlag("GAoXtExd0pRuzJO3IPqvg9sLyVHt4UQ6haJtveitgP5TIxVBco");
            state.setStateName("aYACO6Eu6FmZqIWDEp2Sx8fFjQR9g609eUeoG4ecoOuJUFLD0W");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("MlVzcdfg8CbkX1KOqdwQCIjXuqegqHqg");
            city.setCityDescription("HRZgDpSESZvXlFAkCYS0OReB3VFMFzqPCFZf1FxiWm09bdnGhE");
            city.setCityFlag("xWxSkag1tPLSRnTBt6gkE2K88YYj8IWZjADvEdEu3TXDQHtp8S");
            city.setCityLatitude(4);
            city.setCityLongitude(9);
            city.setCityName("w7d7bGs88C3f1AlkQhUkuwXMtpD5yaTElLtyvNH2UWwg4P2SWn");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("IogxStjbXLEH03NvCk6URdHoV8TBlGtuhvOWTmmOEGpPIOM7Bd");
            address.setAddress2("yw5SV24MUwoj40ksH3pqRN0wybkzNUvIyBuSvEcKJ6TDIYV5YU");
            address.setAddress3("yXO7GTWuxDPbiRPeb2NgASslYg3ZR6JWBz9MlugA6xAvU82Lnz");
            address.setAddressLabel("1GnAqBSxiej");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("YCHnnpW7I1rqvWWLCNX21IxvLuDUg0GOwY25xLUIGLjS5JDujA");
            address.setLongitude("KcZ6aFgTRCElrVeAwxtCAyHiLKtWdf82fryqJrmDnW3cSvZXRg");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("TpXWuj");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("c");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("DgTu3blbyjwpEowZV7uuNKVDRU8EcZAn4dP5wi9RhVYMLa7ICl");
            communicationgroup.setCommGroupName("GgFTwjsifFos0PZ9d2SPJFi4FHNxfeanGtWumQmbaof0VVgYtL");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("fREE5UF6lXyvlbmFsrtaYT73YEFCerzTEjfYYtZicuqHizRIAu");
            communicationtype.setCommTypeName("1QTldnZhBhqDMCGrqSL1LXifAbvcVZBtKIA74MnEalOkNrTQ6D");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("D");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(29);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("eFRiP3lD6ZnretYMIggx7nUvKXwe2EQEzDlTSQo8mud4QWJhho");
            corecontacts.setFirstName("ME7uiqRQNpMX4CBT4LFuUMoVNfnb1D6TeckgPTaPuFu2bICL64");
            corecontacts.setLastName("jhpMKhQE4HORRcgPYkPHnFFMrs4NWMf0Tr7gHQ0SLIHIMAov6u");
            corecontacts.setMiddleName("tDrdvngYLbVBa3zuX192j78VmNZZtOicmwaTiXegnRJu1jqTy0");
            corecontacts.setNativeFirstName("0UPgm4DONHewWFcbfdfGPmzVbsO6vyboxf2ZKs73spQ7t4GuCy");
            corecontacts.setNativeLastName("KgGrkw35Y0nSFGGXtUEWB3Wp3b1BpqgsdrOoG1Rn1V1ESn6ahD");
            corecontacts.setNativeMiddleName("fE2nTKEcpxOhettZP6evlx9HgmlwUN4CcOAspGsJJZPWK0KY8x");
            corecontacts.setNativeTitle("TMhlHBdXRm5A01UVhT9Nrw95O54o4yvhZT8wt5IrAmWTlcM4zQ");
            corecontacts.setPhoneNumber("k8J8KRNHJnPdWn9hGP1i");
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
