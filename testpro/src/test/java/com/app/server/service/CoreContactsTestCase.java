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
            gender.setGender("XuiDGv7QZcTD7PjrStzt1IiRwSbLgLC3QbFuSwEQ2jQi0YJ3hN");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("rY");
            language.setAlpha3("WBA");
            language.setAlpha4("oDPd");
            language.setAlpha4parentid(11);
            language.setLanguage("vacuMyqMqzpsR3OEcJjUtUGBUjqahFClFxYtJ6vV58yDn7CrAs");
            language.setLanguageDescription("VaxM5k3WqMlMCjUMguZfPe1IfVOvYM8dk5pv0xVVTmBplf7xlh");
            language.setLanguageIcon("bK6YAFaYbuQ0F8VIGeMrDIm8CAXawu3LKW2han6culyOgRRvyp");
            language.setLanguageType("Xu7ttMy86bwLwNVWPN88OeSjC3tCh1IJ");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("fRTRC942lWzXpDAKuQh1asT6n5hm0yaAyPoJ7mNYxoP4BznXy8");
            timezone.setCountry("2oTs5He4v1lK5lQmY3RGrsOXvOUvKMqlhWR7MN1iE7s15Xv6KM");
            timezone.setGmtLabel("J34ViAszqDlvmZnkNbQarD3udmIMUJEA1fuSTL43K6WLVGrbE8");
            timezone.setTimeZoneLabel("98tKtfVGU4HT3UuZnTviJL3Q4PcIrvspMUZkcr1jSPv4cnlf8C");
            timezone.setUtcdifference(6);
            Title title = new Title();
            title.setTitles("y3JY7M3dM3eIeT11SJ3qaGMFQw29LZFSRaHbVlqzVvQsTxVtxX");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(74);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("DL5yhrMYsgkEYWj7Luk8cz8HjhUDXotLZaTlA6gqqhxXVbglRd");
            corecontacts.setFirstName("PkQUpsb0KMHSPUQJMw4P2PSPbTMyjCEfc88kBZqY5cZuLFElYd");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("HIwtzXmQw0BJuIPEiodaVvKBxyPpLp2XcAljV0NKedxln1t6zf");
            corecontacts.setMiddleName("GVDVouoPeCD9dRjKlpWAJcsEsWznqasC82f3KwAZN8zVgYw9Ze");
            corecontacts.setNativeFirstName("DYZ7eengNAuXDbLPwZ0c5noUsNUU917aiYMIhLpbymsHbfL2FZ");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("sUDwDsTHpgFnc9AV5on0npSdFZ0wu3F2Xgatg53kuVzy2Ei6WN");
            corecontacts.setNativeMiddleName("CPD1eoBO5ZRJJejLjOz2MGhCHnLnEdv1POvnNtGeDgAqXgnXXd");
            corecontacts.setNativeTitle("RXQ4MOBWDw85qeSCAAIDaH2pU4iLhI9V40EnRgfcGJ1s7UTbJu");
            corecontacts.setPhoneNumber("EOXHkHGVSO7sosTEymCa");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("x8u");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("Wx2bQIPnxlICvOqddU03ZT3LJkaCG7AwfBRFv5Vki4Nhgqy8cy");
            communicationgroup.setCommGroupName("gjdsTDOWhXDgcdTik1tY3ikD5hTanPNN9bqph3Gzc6LL5XbGHY");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("0fHRnUvL7N5itoA69rWGnBHJJqJML6H1DR2zrTKLF11pf5j2NY");
            communicationtype.setCommTypeName("eyCLFKCZQlew3CBGcSVsQLvHZL55VHmWcmDQPsmdyqSDxOMwF7");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("hsQ");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("fnUXPNfeL2lxICvSSCtGKtzLzDuW3UpS93nBUckSfTEcA3MCas");
            address.setAddress2("n8R4A38RM6LQyLkweZGQmDbUV6T0G5DFdG37q5f7wLo1aM43Su");
            address.setAddress3("RSgDgLoAuizIvDE0lHH5gzQFv3Y96a9XrWVEHUu5OnYpAzt4Kb");
            address.setAddressLabel("INxpg0ZMGuw");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("tYYlQWeo0NrSPuz5CpdQV9yv0En2EbBQSGUTt2Qt7FghfIcfMY");
            addresstype.setAddressTypeDesc("aPfHuH8JFVMkmKX0hEg8MzcQRq8ZJnxXdTkDVMmfZALXHjtSut");
            addresstype.setAddressTypeIcon("0DE5nrfpTOtldJfh6lWqKKGR0yw5ya5570sZvm8X20S7e9zxMD");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("CII4hxTlWt1gJ2XL3s0btFeXsFGXx9gK");
            city.setCityDescription("vKpYOME1ZIaYnF8cRSgvdKi9VbYv4y17fl7JYEzhEQ9Zbw6uMS");
            city.setCityFlag("23sJ16VIig5f1ogNDx8gEZb6wAmSK3BEhbVr8VFInlQfddBAJG");
            city.setCityLatitude(9);
            city.setCityLongitude(0);
            city.setCityName("wQor2svLnHG7UpNg7VZFS8oZgZWf5EuVFVQOhDrQe2wrHFdrsQ");
            Country country = new Country();
            country.setCapital("M0APSeS0PlKmfRG10TyLLCSGQH7pWFjt");
            country.setCapitalLatitude(6);
            country.setCapitalLongitude(8);
            country.setCountryCode1("MmB");
            country.setCountryCode2("8oa");
            country.setCountryFlag("bnOHZZBZ6XmNVxAS8l3j5LLTrMwuKSeGJM4QsmEsXbhPGQfzql");
            country.setCountryName("nsXHmbRA5kAiVFF35xuIqVqngvmsmqLPwir2vxx8T2vEeZCDqq");
            country.setCurrencyCode("sHG");
            country.setCurrencyName("5kb86XMRHKcZ4cLTDCjRnebzz8XiW2Gk8cMqIjOv3lmSVOUNiF");
            country.setCurrencySymbol("ne2qssRirokllWPDTQ8kQMaB9nQ9Jm09");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("PkQhFVEn2Pv9sVbpAcrOB0jCwSP5nuiHayNiQCLdFvo7i1iZX7");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(3);
            state.setStateCode(1);
            state.setStateCodeChar2("WoCwElaXdbIRSQg5ao1Y6yYSURkGZc6S");
            state.setStateCodeChar3("eOBGZuoPip3dLUVQg5J0SffvG2opEHb8");
            state.setStateDescription("RsAuezGoMTytHqovMj5dQkFlP960f3aoLo5pCfQScz7JzPoBmo");
            state.setStateFlag("hNyMzHs1113eqyvIvqUEMw47ZV2Q3K6KVCIQdS15vBWlib9n1q");
            state.setStateName("xOp5GmTI4sGrhoQsSQgU13LqRzg6LJJrKCoDNTn2TYShNEgiWJ");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("BMaCCMYxGaRVzNuEmS67kyE8MoIkwwhF");
            city.setCityDescription("iQX704kNzSPjMdL4h51lJcMW42As3kZeQunD2KDUKQnY41NnGC");
            city.setCityFlag("CRbV3sfh2LhFnylKCA1BatPXxoaxv1V2q3wTTuPGBxZvNjG0d2");
            city.setCityLatitude(1);
            city.setCityLongitude(0);
            city.setCityName("M1ojFBRdXYQdDVKNtg1PZZXQZYbCZ1WCU2qQD0mFkJSiTl21WD");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("gkHtHiGzyGf3lJghjwoHF6NKVbm6pgyw5skkdQbwClU1ZoEZZF");
            address.setAddress2("jyzDW4t7HTekTkEoAtBfta0WZZCZ3HL4YQqsbO9Kr5TMBWKRzC");
            address.setAddress3("EQofK057zE2Rhib2XQiopXzQ3BGXnT6Gt5UWvUbREgrtjMqeHF");
            address.setAddressLabel("XoTbIbrdNS5");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("qkmGlQ0XEV2oV6LdyR0ibV9m5m6sp3lFVZ3uP9nwIfekK3IXAa");
            address.setLongitude("IEEUe1buq4yGcoVB6rgoMY25Wxdjzeus4HUzSorbrxGrpYGqyr");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("hHVE2N");
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
            corecontacts.setAge(114);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("xqYcPF4mCI38dduTWPX8rpMrqcO66avQCdZAvWKPG98afYoArb");
            corecontacts.setFirstName("Hf1etsHHlqSYMZdoeaVLtkRTolQwos6uZhbRjBRwdLpUTuwHCS");
            corecontacts.setLastName("udCuDPphjrJl8VlweLauAziz6ekuM0CcAIY5o7TEn4RX9Lei0f");
            corecontacts.setMiddleName("hh70ujH3GE8fAgBTrFTvDVCWW7Eab8jiU8nPA1wrGmbpwBHwVt");
            corecontacts.setNativeFirstName("watEr3dhNTNmtlqLSPRhw3JjA4wpIK6WIIjTc0bRlyNYqgMg26");
            corecontacts.setNativeLastName("DolilIEgnwBQGtsVRLYKuYYZCoiSAc6WCCQUguM6QfQgf7LlXq");
            corecontacts.setNativeMiddleName("DcotRgHpVEiTLtd3cm1VSHjMyhqk5KjDSRquPehGBfFTkxUNf8");
            corecontacts.setNativeTitle("XDsPZzkb7PkYLgzo30r5XOcS4bnYbJl0eoxxSV2kfbjMrCwuqk");
            corecontacts.setPhoneNumber("ujt3aJbwV9XNoIG53lME");
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
