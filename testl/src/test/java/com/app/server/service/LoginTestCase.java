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
            corecontacts.setAge(107);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488936185l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488936185l));
            corecontacts.setEmailId("7rcTd1SfBOAYvANs5mDPbpOgmS70JAfqVCDdHMmxIdulAa5VHO");
            corecontacts.setFirstName("3jMYVwb5eF9kV9T9BbSf3WDVkslupZiSUsYG1SWRwBHLHZYv0o");
            Gender gender = new Gender();
            gender.setGender("Hpa0Oed6EI0BB3ZnwavLhh2RVvphLO6K7zsAaUfTTe3vcwPSch");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("Vp");
            language.setAlpha3("PgH");
            language.setAlpha4("cCzr");
            language.setAlpha4parentid(5);
            language.setLanguage("WOvcj5KIIbwZJPGxd2du52GJKuKXLE6BAiKNowORozP78cu1IS");
            language.setLanguageDescription("J2J3AKmmRwJHY7qxtJXlYud3Y7dTics1fxOUzhKfzQhib6FM5H");
            language.setLanguageIcon("sjfO3hMyp5IgyImEAQZfsR7Yl49lkDkYuf1R31tA1SZm8oOyZ2");
            language.setLanguageType("cTdJIq5CIQ5Km7ZxYxvYTj9TsRW4rd9Q");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("Y7BJjaEQ8mzvGILcEoJnMwheReWckIvC709PLyohlhR3EkIgfK");
            timezone.setCountry("OMxicXWXcZghZuVNB8wb0aBeSXhkdW9iAy8nTSW927Rby1yGDm");
            timezone.setGmtLabel("t2BCWlKJnicPkQItCE7pAY2NP5lpR1ZpgFZmdeqLEbs89mTfHG");
            timezone.setTimeZoneLabel("0f8XpAKy7XlwjuBpWjRu3ygEEk63EdA55vNKSd6ruKRKNaRnrr");
            timezone.setUtcdifference(10);
            Title title = new Title();
            title.setTitles("IpZ0wUat4lIQtQVrBJ571g8oqRxC2aBicR07cmnJIERuBZeE6e");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(78);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456488936205l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456488936206l));
            corecontacts.setEmailId("eSryMzCrOCqcZFQksL06GKewlrc9GsZtpoIH0mngpmwbWIrlKj");
            corecontacts.setFirstName("EDbayCMaOQK1s4ztyc03On50qt6oCBJFoxudIesgMsmE4tErEQ");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("Exjw6kmDmMu4d8LGg7cwHqOSCzoMEq0SLYdsFIMoCSy668QQBr");
            corecontacts.setMiddleName("wA9VrpTgfPre5ghudvOVKUG67qOz6fDPSUDWK2oE2gWs4eqmZY");
            corecontacts.setNativeFirstName("JxUox9D56yCUkEJhQhqGEJg9V0NDGrY0o7rtrpXUE135Sar17Y");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("UJDL2RJOA2tiVioUHKxGt0BMhNDYCDRSW0tbVn1FVqONMXP7PR");
            corecontacts.setNativeMiddleName("MvkzgjupUdBOydv3MhiIK9uDjDgIGeW34fWCNKUMKROgAVYGVn");
            corecontacts.setNativeTitle("dBTwthcwDm9HbPe0n26wmp8IfAtm5SvFiaEzl5MGXY27zzMpEn");
            corecontacts.setPhoneNumber("UJMtiMSvmD6GISSRAHDO");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("S7DIUmgfJUl0nEYmJGPUJhva6zYWHvT3ayqSRF3ktCFw5iQGIt");
            address.setAddress2("3FR0DDRd9HrtBLaGADNB84BGKyDegahQ0h0tCPwBSI4YhAuzRU");
            address.setAddress3("EfnHecoA2AXOlaXoabDU0fbGQlWfcWvrI4BiguvZ1FxqFjgnHO");
            address.setAddressLabel("1FTDYhyFrt2");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("LKdHz1eUL9B1VyYw4krAi0k4tfaViG6Dcc9bFTPvq72CoPMYa1");
            addresstype.setAddressTypeDesc("f5OEib8S96hruUHL03Smrlaw5kU2F1IW1FcSLmPbzxklO0YMK0");
            addresstype.setAddressTypeIcon("XQ8MgFpUOmjoOExeVOz6uzIHWnGFIoQhjcAYk9y6Vr1Jp6GV7X");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("R8UMWnvULJaLk5MQomNxb4CiRP2Jz182");
            city.setCityDescription("hWBPEN8dgQ2qD2sQBsxoVPEuq8FWpqJFrAELZpKVtV2uaTiyJ6");
            city.setCityFlag("BS2vBd2Gm1iDg0upIDN8KcII2ERdzC6rfUceU2B9NJEFH6rIv8");
            city.setCityLatitude(4);
            city.setCityLongitude(1);
            city.setCityName("5Ksz1YOv5OIbyHdz4C14CHg9CmhNoO7ushuiZXODBkP1Iods1f");
            Country country = new Country();
            country.setCapital("x201zfBjmw2UYppsLEu1TjokI8dtn45g");
            country.setCapitalLatitude(4);
            country.setCapitalLongitude(8);
            country.setCountryCode1("jkt");
            country.setCountryCode2("Um0");
            country.setCountryFlag("8wsyYxHwEpxQ23eIj43Fh7B1G3PvEzBxMUvzaZ6YenqG89PT5d");
            country.setCountryName("hXVngbQOlYeFguqtN1vr1linLmspBkbM5dfRCdvuIcYcN9Q43g");
            country.setCurrencyCode("mSD");
            country.setCurrencyName("3O0MnrUMG5SaG0bt21dlyv4VLX2K3SYZuvNWGMgO953OemVrVC");
            country.setCurrencySymbol("pwCUXFmj7X95n9y9vufmdXDsyZsE1jle");
            country.setIsoNumeric(2);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("dhkXF4WVc6EKQpqkeSrzHwWieoOVAqULqXglEJR0xdZNXPJkre");
            state.setStateCapitalLatitude(0);
            state.setStateCapitalLongitude(11);
            state.setStateCode(0);
            state.setStateCodeChar2("L5gU8S7k7oMXIDMxG4u7KW2vChjY15Dx");
            state.setStateCodeChar3("a1hTM8atA0aQI6RhlLoiVZPn8DxZwSzm");
            state.setStateDescription("8s2DV4UWWKbKGWrmC6M8s7O4cBQUyrQhQjj8TAaildS31Zj5D6");
            state.setStateFlag("w4Gkw2TQ9fPx2kbXydwSHdmqNX9IA67xkPF0xN8SAkim0aFED9");
            state.setStateName("0k6uMgDJmNoB0a6hITmY9pcStOdqPqjOprMDntUwsL9bffhOL8");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("LZ454IJ1JgFQOQCRaJBv2T9ElWdiv8Bf");
            city.setCityDescription("SH7Y8hfRAnBV0fFm2E5hdWLUGoBERzPGvfLC2IUzZGsOLaSe9D");
            city.setCityFlag("6cMP68V1W2FKyi2GZd3QoTOnxhfOgjwfUpnzTEObb8BPIlyyrT");
            city.setCityLatitude(9);
            city.setCityLongitude(2);
            city.setCityName("8W9WvzSW8rppq6pbzVmFMGT5d61f30YC3lNjlN5kwmK4waQVst");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("LO3BzKJN2zenkTgxTcR2ddqam3GSIdhNfy3RojAAtyhmoHCb1p");
            address.setAddress2("6UFqnbs6eJBrC2ONI3padER2NkTCrOZrHHOSnwXZCqmGKXaRRW");
            address.setAddress3("oKIxU9ZCOujsvYfAJBL8LABtuJWCpH8sWtEnNn2hq2dJtFf9BG");
            address.setAddressLabel("DwhbjHpRAg9");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("IGeITIRqqNIKcYcZv4GOl2dwSb7x1zwIWpOK1IUyij2lqmLdWZ");
            address.setLongitude("cPb5E7rxbpe6HLLVWWEmCp2Sik5T89QYW5yomAtUKGG7KOxdB9");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("SzeY8Z");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("5");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("X3MrKj2EBdhS3LYHz1g0hoUgUiE9H3HhQOFGR5uh9N1K12TxSt");
            communicationgroup.setCommGroupName("L14gdSi3uXiCtDZo9OdTvaYCWYqJcZhBWEXCNSSkGlKRaOciZS");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("x87UqkQ4jbkhH51BL7P3s419SXuMJnmx2gE5TS2ApjQvFOysEz");
            communicationtype.setCommTypeName("Nme93jubMyQnvxt3Q6tECydhFCse2XDYbSHX2npMxOruAlth2c");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("x");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(1456488936668l));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("DGxBOXpjnfmTrb5vK6qzhORE555E12UTbZMEyFADMUa5g4McU8");
            user.setPasswordExpiryDate(new java.sql.Timestamp(1456488936668l));
            user.setSessionTimeout(73);
            user.setUserAccessCode(40425);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("FMFiPACInDOCw2icsbpAlti90DNOFb4TRvlgsF6mj1FG6tgVwt");
            useraccessdomain.setDomainHelp("qJVyoir3cb56CwMVT1OmW7UccAqlMtN8dhYDKiejqFP0WdIdTP");
            useraccessdomain.setDomainIcon("AswJiRhIyUFKmpdjPx41si1oiN9wSCOxIL92XPjEYNsgR2RBbi");
            useraccessdomain.setDomainName("qKWSYXMzu4pbVigkAzetOBVQg1tavfZvTIzixGrhFUDvuCFxYX");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("HIYu2COhfCUupa5tTc0pxDxA73wTf9Qvi5E2LZpWNl6PsdVgYg");
            useraccesslevel.setLevelHelp("T5cSfQ0inbIWejgZ30ApXzG6zwjCiUeTF7cy8lOVyBoCd1asJL");
            useraccesslevel.setLevelIcon("RUfI1YYHCCWvgN6d56JQ4cBkktKWu55XtqYwl1v5fLidGkYNe4");
            useraccesslevel.setLevelName("Oblwxk5yqVvIpAg0vUk9JmcG0z8FnDNtKf7jhiY2Wtkotm8eRM");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(1456488936685l));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("N9oC5BIEyHZuQbrfuYdP7xNXrOivNnMymbEnoAAbTEhDQmU1hF");
            user.setPasswordExpiryDate(new java.sql.Timestamp(1456488936685l));
            user.setSessionTimeout(740);
            user.setUserAccessCode(35685);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("pWLRljBWVvbyePSvbOtErvD2MNd1SH4vxKS7nZfAQq1paonTs9");
            Question question = new Question();
            question.setLevelid(0);
            question.setQuestion("dTRK0kK7zwnSRdmtpUqNiMthuN3KWk8xw46cQootx6nR8GH7PK");
            question.setQuestionDetails("b");
            question.setQuestionIcon("XBhRWZAC5OGXoD5tNGgncrljeGpdZEUCEzgKPFaZpqEDxPU72z");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("3GzX9UsSKVKNhrKydssGCvq3UiIO6Rhf4DBZHeCioemqZjI9W6");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
            passrecovery.setUser(user);
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setLast5Passwords("XlmM1aAurat1hOJSdttwCo4O0e8qRlyqpFP0DdHjfWQYl9TQqM");
            userdata.setOneTimePassword("ZpWqmcNFNAZd9Yvw7UpLeGYHvrdjQyRx");
            userdata.setOneTimePasswordExpiry(2);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1456488936945l));
            userdata.setPassword("tGPIx5yo0bumdMTAm1H5I0zOyoxgzZ8ehWAnCDG6NMVpXubvAo");
            userdata.setLast5Passwords("VrL1p7J9Hht0Gj7rxgbs5uJtvvs7qJFTXDW1Lu9ieeq3e48FOJ");
            userdata.setOneTimePassword("JBFdqoSFoy6UpmrlVBQi6Pi26rjDHQ3j");
            userdata.setOneTimePasswordExpiry(1);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1456488936967l));
            userdata.setPassword("LVLwsQ0WoJBFkYbqyXHc31WzMvX58oQJR2ttIdnnFXGosBtKYr");
            userdata.setUser(user);
            user.setUserData(userdata);
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(1);
            login.setIsAuthenticated(true);
            login.setLoginId("jFDGK4RGYljOpdSvRlPVk7x1FrseqtBeluzwmO5loadVzFgIak");
            login.setServerAuthImage("wkeJBciNCy9E4v5DSXg1KiSWQI8Eztq8");
            login.setServerAuthText("5twFIaIUUXTFvG58");
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
            login.setFailedLoginAttempts(5);
            login.setLoginId("iM66KkB11a5UgSlRPZaDt8pN8RQpj6M3aDllaCXTDij9kB21nu");
            login.setServerAuthImage("KnIyaLQ6mcwRbQ6pluuNJSYaZ9Y85A1u");
            login.setServerAuthText("vF28dYLC6Mx6lB1A");
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
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
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
