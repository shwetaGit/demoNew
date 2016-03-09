package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.LoginRepository;
import com.app.shared.authentication.Login;
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
import com.app.shared.authentication.User;
import com.app.server.repository.UserRepository;
import com.app.shared.authentication.UserAccessDomain;
import com.app.server.repository.UserAccessDomainRepository;
import com.app.shared.authentication.UserAccessLevel;
import com.app.server.repository.UserAccessLevelRepository;
import com.app.shared.authentication.PassRecovery;
import com.app.shared.authentication.Question;
import com.app.server.repository.QuestionRepository;
import com.app.shared.authentication.UserData;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(122);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("51rleIokQS6B3BXTcM4QTvTaUMgJ87DsFKyVHbbssIzNDbPpc9");
            corecontacts.setFirstName("7eZs8T0Pk3J0dem5hHsTVk97bmzUPAC913JlORmODjkV6SOVjM");
            Gender gender = new Gender();
            gender.setGender("5puzXycYyI9OpQzRY0f7gBDhP6ECnCSd3ZwDsRisB4V0YP6BY8");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("SX");
            language.setAlpha3("15P");
            language.setAlpha4("S1xP");
            language.setAlpha4parentid(3);
            language.setLanguage("dylHQs6ETFMGJ29rFy5R9yRX4VaWxAzWuLA3xYBpjHQMZOcTee");
            language.setLanguageDescription("DUOuNOB7T0YnYeVdtq4LrsqSTuspFwjmQS504fm2ykaIEwHaFx");
            language.setLanguageIcon("j8A2KilSrXGooY28A4Xa4vfZaWs2pJYOSkPSEwrDbfk5H3ZxFq");
            language.setLanguageType("JNxnYY3jRTDx6jRlc0vTYxr3DUA7RPR3");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("tO60JwO51pRPrFBRhFdIPZcu6ub96EaDTausE9MY0LA5IOrCHQ");
            timezone.setCountry("jBLv3A7ARSUnrFzERkuk1cEK08LtCWfzobDWIFe11fzkc69xri");
            timezone.setGmtLabel("Pzb99OrCq1mo0LMwjuWCt3204A6QGXmdYUjkDa7ZSLvVIjdq3H");
            timezone.setTimeZoneLabel("UtrogVDQophhep8lVlzTygnzu4KWxjbvLCBVklm0DnAbJPK6wZ");
            timezone.setUtcdifference(4);
            Title title = new Title();
            title.setTitles("GQ5R7mJYPJfWzYTrH6dKlfQPBIUueRrVd3IUTiAjspJWMb1ss3");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(120);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("ZuiWsmUHH9quqS0J6i9ptkiyOaqImUDm10ONX6Z4IvYanqhRVD");
            corecontacts.setFirstName("ETUTUqvWaWps1pHUhUnw60YcQY5WVF3c70hibTrt8E0Zj3tq57");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("rwTU3n2BjfNWonJjnPK0CKh3tezFj7AUXKth29ceb0GIlkkoeV");
            corecontacts.setMiddleName("51GXQMUnCHKJq0CoOBaIaUOrNvBPbOCqlWqL5jHxKlEmHssi1l");
            corecontacts.setNativeFirstName("fzvKlqgUAji6uTGMqdTN1wc2NTqZ2ME5dxlZr37ywxZAN3hbeu");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("8ESWNV2YNy8RctP24N0eiML8QAlldu6d5g8PbXOhyRd2ObLjn1");
            corecontacts.setNativeMiddleName("TYU1v1zv4RBMHVmCJJg8fWLym4xjJpvD6ficpOO15qK6O8kwKl");
            corecontacts.setNativeTitle("4EHfQECJMd1ytiwbns07eWgVvx5kzMupKadOiy2gDyHHne97Jn");
            corecontacts.setPhoneNumber("IMF4k5N5KaqUCrTQxrYC");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("NlSzNicJZ6D39n3mlYRYWsaHFPOpiz1pYZSJJ3LrMXUGUOg2Ek");
            address.setAddress2("TYfq7ZT768nHm8Nf21X4sN1r9VbmsCciN9gphA530jPoyRfoeO");
            address.setAddress3("QZFaE3oqfdZzfwwvtlFkiNMQdrkScRoIn5gt6gjwVEfO7rKqd0");
            address.setAddressLabel("0HsBTMObSYv");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("3BJ63ocY8WzwnLXLnz9xQpMfS80aOw9vkIHevsbYgRaCCbsTtv");
            addresstype.setAddressTypeDesc("ihqyPN4xdenmPUY0FMzjqKZjd1QVgJJ8Viy0UZgK1ZwCdx3QSQ");
            addresstype.setAddressTypeIcon("21VCDi85IIo7xC6OwUG2uRXucZDOzsRyD10PCgBfYKOgdoQJ6i");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("eCKsE1linLNN0V2vmZGKVzk8Drt0eh0o");
            city.setCityDescription("CJ818vEU7nI30e2cJt03hw3JqqiFgm037IYq4EQbjSbJeHuvDH");
            city.setCityFlag("pVZLaqYZPg3W0JR5ecFRlmxq355tGFcJNZNGasprFHVwYmdKDD");
            city.setCityLatitude(11);
            city.setCityLongitude(10);
            city.setCityName("Y7GJVBfaA6xbI0GBtIAKizap1vIlhFvUIY4lKzaZlpC8OVMEad");
            Country country = new Country();
            country.setCapital("XNzS9anycuDtD3MbgA7az0QOLyIhpqWg");
            country.setCapitalLatitude(11);
            country.setCapitalLongitude(7);
            country.setCountryCode1("jJT");
            country.setCountryCode2("skJ");
            country.setCountryFlag("q2KMnOohKMT9BnQek8whdrv2UbsdAgyJFUYyYBMfc7pUieFCWf");
            country.setCountryName("NM70s44fFqh3pfQE1mM8qFl0hv7qGAMDPq8tb1QVAXRofnS0hx");
            country.setCurrencyCode("nGE");
            country.setCurrencyName("DjOLhvUQkdQ3ZMXrEWpcIOwaBYG3i7xmruU7kz78iHwX0PX4hM");
            country.setCurrencySymbol("orCRGTK146XgmmoFCqZKG2We06B18cwj");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("IbLZnoQW4c3Q2U5KbOREjuOoR9ZaQoeABNrEQtroP6yJUIkUF4");
            state.setStateCapitalLatitude(3);
            state.setStateCapitalLongitude(9);
            state.setStateCode(2);
            state.setStateCodeChar2("UhTGiO5cbXqGF1D8yh4lWmTrsR571zuc");
            state.setStateCodeChar3("n8b0EIzPHS4Xx6FIabCk609eq5s1n92Z");
            state.setStateDescription("caKdXyRxqZMbXHp21S1c7cWe7vs4mbrAjyOph5eEUfhc8Wwl4N");
            state.setStateFlag("kLjXmEeb1aiM11T3a8qPMflf5IKIg6MjgPbCOOLOAFnF2BDJOS");
            state.setStateName("nh2FMJCYNnb0w4SsbXpfg9Pwlz4hWZpR5hs0oaBqkF7GCruwtZ");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("0lzZO1ReoqGcK43EoGKOce95hFkYBOPG");
            city.setCityDescription("FCuBNdnRayXRJ5ks6h96tLjy9iqp042aq0d7i9iIeCCNYWa5lh");
            city.setCityFlag("u8sGCzbnS998Pjrpo26v4kErve7cqtKXvRTpjQxTcYqyYt4oIb");
            city.setCityLatitude(3);
            city.setCityLongitude(7);
            city.setCityName("YFVVrw9WDZvd5iLsnCxZa2Z3AIWNuPF6Nl0SqYEUCQZiWNyCYh");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("cG7YHpLjWClmCh4s8lAVg92x0ElmerlmJEBe9Y1Nj0U7gkmSf6");
            address.setAddress2("3Nl5HPLu8IP2oUZBCKx8h25dIBgWkmiJpuAqUSEefVZionhjif");
            address.setAddress3("yY62jg7SQasD5KiLzpQuzrihqmsKToBS7UkpMbUPJ0vVzKORp1");
            address.setAddressLabel("sfzqvxyYZut");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("VJgUxP0PlwkZcYmTWXfVHvpTkE2jFCcFysIyaSqyB7BCUNehga");
            address.setLongitude("YPtArb75RDnMpUaeLml9ZouvgpSOyHQ1YZ2AEeyw7B3mcAfoNP");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("GOZHKz");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("4");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("dpCqwvjN33gA4gerJWhlLducMgS4vZct6Kyegli3fEylt0qJcw");
            communicationgroup.setCommGroupName("RDcmrXXHskkKW6ladWcrVaCTrHFX6gFx8RE8UGmDs57zgplVku");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("jveNNizanXkkT9Vdj2s0Y2YOH79vkjn8nn59KDGXFnqX9ytvMx");
            communicationtype.setCommTypeName("YKEIE4J0m9dcinTTaVkCJBsismC2NSDTop5sHw5hz4HEuFdDDd");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("4");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("VDElrl8bLRcdKxZIbLXYa4RQiIwZ9veAnrlpP1V5yGVcatXgnH");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(3085);
            user.setUserAccessCode(2);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("OYJuouqrY7jf33ubN3ks63w4bYxuk46GpLj0eB37E8qT3OLm09");
            useraccessdomain.setDomainHelp("NXq6GSyHA87DxMEcueEagqBdlCUlZwqSxVldZntKxSKeIFbbz7");
            useraccessdomain.setDomainIcon("V2zFSPSnj37zYkVIFGXQOCLYK9r7LkzYoa30n0OjcWpYGWI4Rh");
            useraccessdomain.setDomainName("4vVM56DWNO7NgdL1oA58Nq9wQjTvHrJta2MKKtjXAz7NFH2B1y");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("VFtTwo9WEa8kZaZKtpELlqlgV54lkUKgpV1kuOgTLFs92geXUm");
            useraccesslevel.setLevelHelp("4MOQOq80GlpkROOx84eGsHYDTSqBOcuISzes6KbyQNvbwZAbf1");
            useraccesslevel.setLevelIcon("8E5eqno6kixEBrFK9Q7tbsxgLEWdj95Esx3tcBX4fpQJupNpK2");
            useraccesslevel.setLevelName("pgS7ktUOvZsatmdnWp4eVQJoz2Uk7YLcoFCWH20v6GcBWdleSZ");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("kbnfjzEmFaDT12n9kXqqb60jaDJ4gq3uj2Muj42r3AJNJkEE9T");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(3002);
            user.setUserAccessCode(9);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("VHAjgGiShusHyqWdStKWnpCmaUWRUlndlX9P6FHwOI3eov93B0");
            Question question = new Question();
            question.setLevelid(11);
            question.setQuestion("sZM0P9tj9cajawpb2SsmZntNCt2HoM2klfDiXF9ieRiGOs15mW");
            question.setQuestionDetails("d");
            question.setQuestionIcon("ACTG3aC3rVeVc0l2DB79GGExSlC13eKfaSLQvUSXMu4wAW25id");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("ytqKZwmohPNWxceq8cizFBADEVfl9QHRxkBk4AqkUbZPwSKomT");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
            passrecovery.setUser(user);
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setLast5Passwords("EOnB29gj28vM9u5jYNHLS6rsWAx4miCajjNAXWrBdgBiX2VFEc");
            userdata.setOneTimePassword("xPgqSdDyGlpNZjVOvHxRkaDlodcd3jM6");
            userdata.setOneTimePasswordExpiry(2);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("w4K8m8mC9R1DMu9d9usG9Q1w0bN76LnaClI64vOFZS7UH2tLnt");
            userdata.setLast5Passwords("qupfUJtRY7hURfpGBlvpnXILMhFTLFTviJHZLuTQxCHPXMVfKn");
            userdata.setOneTimePassword("Tl0BWhncKMSIvDhuOgvSagzOukWKyVun");
            userdata.setOneTimePasswordExpiry(1);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("BRy5f8Ar6EAWmRRjXYO22ziwvyeSrj3V9L9oeCRNwpPoyYMi6s");
            userdata.setUser(user);
            user.setUserData(userdata);
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(3);
            login.setIsAuthenticated(true);
            login.setLoginId("bwIQXsPqznaYv7FWok4eSeOxYB3Glgxt2dhYYpEOvwfr2mn3sp");
            login.setServerAuthImage("rOX1aSRQ2syaPQfHjXl8aJZNjBdh3T0Q");
            login.setServerAuthText("W8yU0zWpHOqIpi1O");
            user.setUserId(null);
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(6);
            login.setLoginId("SXf1Ogxr09unqDxUQEPhwWorNdLQSVA6S0yj6yRmvK7RW5FPgc");
            login.setServerAuthImage("zkG7dDZStz7XNzNJHFCxakEcSrbDQ5Oi");
            login.setServerAuthText("bEi7n26vcOUjRkEH");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
