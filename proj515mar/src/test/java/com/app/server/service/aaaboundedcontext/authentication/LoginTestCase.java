package com.app.server.service.aaaboundedcontext.authentication;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.aaaboundedcontext.authentication.LoginRepository;
import com.app.shared.aaaboundedcontext.authentication.Login;
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
import com.app.shared.aaaboundedcontext.authentication.User;
import com.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.app.shared.aaaboundedcontext.authentication.PassRecovery;
import com.app.shared.aaaboundedcontext.authentication.Question;
import com.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import com.app.shared.aaaboundedcontext.authentication.UserData;
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import com.app.shared.organizationboundedcontext.location.Language;
import com.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.app.shared.organizationboundedcontext.contacts.Title;
import com.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.app.shared.organizationboundedcontext.location.Timezone;
import com.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.app.shared.organizationboundedcontext.contacts.Gender;
import com.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;

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
            User user = new User();
            user.setIsDeleted(1);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainIcon("zKlV7R5e8ipoK0vhFma4xBjJU7uMsRWEElGZCZSLmVBPcI9ToD");
            useraccessdomain.setDomainHelp("TeF2q9CuJsRykmX4QQQUbRMq2O8NaNNkjsLgiHp22twAjmCUxZ");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            useraccessdomain.setDomainName("EKwEaEj2fiwAf1PLqWbXFZSKCZMClZenWmtmcNwI14HGAVYhHP");
            useraccessdomain.setDomainDescription("7SSzUci4Z2vaNQv8O3QHEixkzNYq1ch6i7DO1dgTRuAh8ICwdm");
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelHelp("BYSAN2WBMRxxcWmBAwIvjUJUlWLigJlvZ5KCGGkoe6L0vkprLr");
            useraccesslevel.setLevelName("PFCw96tCSL6FwG5hv7paCf9DcFVjqEd17l9GHnSEtjiHsA5BMi");
            useraccesslevel.setLevelDescription("SAvSCelLVlclvxXGIewvzVsiq5u6ckkIB8TNe8mQCa92UJGCxq");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            useraccesslevel.setLevelIcon("KyiSM5iKgylNH6RjoSUYVaObxWrzB6klHWlTOrrNwlpkm0nHHj");
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setIsDeleted(1);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setSessionTimeout(3542);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(1457945748818l));
            user.setMultiFactorAuthEnabled(1);
            user.setChangePasswordNextLogin(1);
            user.setPasswordAlgo("xYACs24wNVDpe0y46cAi9OR26ocGLRqEvYZL2BWFTRuDxvUC5b");
            user.setAllowMultipleLogin(1);
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setIsLocked(1);
            user.setGenTempOneTimePassword(1);
            user.setPasswordExpiryDate(new java.sql.Timestamp(1457945748859l));
            user.setUserAccessCode(54974);
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            Question question = new Question();
            question.setQuestionIcon("FTj2AVQLYCbmCPCUYEVLVpkPtfYLJKwAldzIMmqmU7Cbb9Hvlu");
            question.setQuestion("SP0DFL43jz8ttH3kWo8iUv8iMkfJWbJOBrpe2p9SYVapmcQWzp");
            question.setLevelid(1);
            question.setQuestionDetails("Z");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
            passrecovery.setUser(user);
            passrecovery.setAnswer("UnrpkIQo3WfQEpqnGkow9WgNCNwXYMr3YDFKGXi0mL0Zp7F2hl");
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setOneTimePassword("T2dN6SwU15jYn1B2viAArAj9E3yrIxjg");
            userdata.setPassword("CAwku5LnSAUEJALWWkEe2O4l030jxqi2ZFzyqEqx8FWIhMWRpA");
            userdata.setOneTimePassword("N1PVxFm2I6x02rag8JWNyrDnNeMbHiwh");
            userdata.setPassword("8vqOfzQYvIBvNJlbeQbq52IpPju0QNd2R1u2COqYAvc0ObgF8M");
            userdata.setUser(user);
            userdata.setOneTimePasswordExpiry(3);
            userdata.setLast5Passwords("c4Vyyknt1tu18JoFFxvUc1yR88lIRB8ZWqb5NEnA4QYwDrgLfO");
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1457945749094l));
            user.setUserData(userdata);
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setEmailId("5DHYvKoxOMv723RvrNoyPiILW7lTHkbVBoAdpbOasCB2TA78dz");
            corecontacts.setAge(9);
            corecontacts.setFirstName("W4sT3MD1nQiYsxBtsqUt3NYYNhFliL1PWCreFSLcZ2h2CHxJ3I");
            Language language = new Language();
            language.setAlpha2("YV");
            language.setAlpha4("ySDf");
            language.setLanguage("A46dCYHzjcvtsl773eF126aW31rgldZI11F0EoqU5tStOVWkNB");
            language.setLanguageIcon("n46FlS93trfinjR5aN7vvawr24lzZHHpBj6QypYDRqI8Ix1jgm");
            language.setLanguageType("vOZ93SZMfKeIeoUVtKrNxb1zeDIiu3HS");
            language.setAlpha4parentid(1);
            language.setLanguageDescription("HAonX4JAkTY36o2u3BxhvhNqlOypnax7AFi4lB1JoVFy8RYm1M");
            language.setAlpha3("1HL");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Title title = new Title();
            title.setTitles("SVXEK7YcZzt4wB86bie7JLEPFNW7XkZMKucktQ3LdVETbXMLTT");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setTimeZoneLabel("MhJZLzscuFQWZ3r5MDLq4gMdLNbYAsUayspTns35sDdo9dSRwt");
            timezone.setGmtLabel("rOEfVmTPjY63roXsU1jSbG1wDtJIJv2chuhqKgMU6IfPLtyZg4");
            timezone.setCities("LP0oHL72OKCeiZTOwKTBwxr5bA6DehnXAFnK9ZJZ5Vbji4zR4q");
            timezone.setUtcdifference(9);
            timezone.setCountry("3kEEyNBJnnauButzLVxVSeZW3wEMOcgOttgn75qFfEV6bl9YZ4");
            Gender gender = new Gender();
            gender.setGender("LOvNdyBR4nEX4sR24EFRVPZawa6piEBrFig18lnMC1F0WeSHyH");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            corecontacts.setEmailId("U2Vtf8o92FTLv1Q7xQhI4cLevZMNP3NDnA5cbQvnZyzW5aOc9i");
            corecontacts.setAge(12);
            corecontacts.setFirstName("WcI1mLHKCON5dQ1pDCYQadnNjpy6sXZqpqvqKkHRt1KZGxdJyt");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setMiddleName("PQIf77pbFdHWye3ukjAzPDUWNwJJMW9GbDhyUrTfGz0wPPq0Gw");
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeMiddleName("FjXiPORxWDJWWvX6zrBw21cjVK3VDmv3MSjMu9HSoFjP4YD1yZ");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457945749258l));
            corecontacts.setLastName("p2JNy1YQ6AWeuOPhqyNcZG8V2Tl9GeCsmbyJv3Zhp3CsW0sA0s");
            corecontacts.setNativeFirstName("EhSrTvGdqFB3yMyYpTzJ8pVpPMvbr1nXa17iuDgJVuLrj6fdfy");
            corecontacts.setNativeLastName("eLKnsLuWJI7FCwz4ywWjLNVSwGY8gJMDFvHSvE7Dg3SJyC3Jt3");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1457945749258l));
            corecontacts.setPhoneNumber("2axqhENnexX2uUsbMaFW");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setNativeTitle("raDuqCAdw0YfqrHZuLoq12tPt5hy13qjKylPliQh1TLK3Ukv3r");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setLongitude("9DVfE6FqGCitAndrhArf577jEh5RIQL2E0koAw4cMenn0MhPtG");
            address.setAddress2("O1bSmJoeVij5uTymQGxjofwWVfLEfybkYzvLLrIkeWYaFaQAhJ");
            City city = new City();
            city.setCityName("k7tUeVuLgOgxBFmdKhe3D10RAMxGySPZIQ6LXBYVwy7qKaIUSY");
            city.setCityLatitude(9);
            Country country = new Country();
            country.setCountryCode1("p0A");
            country.setCountryCode2("vyW");
            country.setCurrencyName("7KMp2RcPJHhE5PZpG22pA10gpR764yx4DgNyY8NZeGkmqsQpu9");
            country.setCapital("OSZpiP8IgBkqdRg9m4mOXlYlWpoVMux0");
            country.setCapitalLongitude(7);
            country.setCountryName("j3cqPyMxKxO9pL1KvlJXRq1hVIBRu9PslmFOCvtcVDac6rnGvF");
            country.setIsoNumeric(2);
            country.setCurrencyCode("5Fg");
            country.setCurrencySymbol("RhmiiSkVFxIlJsZhI2u0wZ7RC52eriOz");
            country.setCapitalLatitude(4);
            country.setCountryFlag("gH4fIlKkkfzTdAtv0Qkfi6CDfp9TRfUOJmIzJcfs3S7pTfA3sD");
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setStateCapital("XaKjR3sbNb7WmvkJxSX9xbQcDv5FSPvTaxANczPM2XAxnBOXQ2");
            state.setStateCodeChar2("A2DBHucdt4TGwU1YFz5Bo4C7ZVkjwMOu");
            state.setStateCodeChar3("JXeHtgNsWnqtBOEsfUsRytLfbH3PH4ld");
            state.setStateName("A6ObAcD6KDNZavTG1r20Bh6mkwfVnFcEGdDbzqvcOuqjxBqnSV");
            state.setStateCapital("GviA0zBjRPnFo8zDrIEdf3emRzB6OrYO3JUDJhm2hn5alz85HV");
            state.setStateCodeChar2("LNhRt3TInWlkwL1vkXfw7Uw3q81h1rBf");
            state.setStateCodeChar3("CB7EeD9x5zzyWpwzxM9HUMM7uASgNrZz");
            state.setStateName("yeyinbq2L4plxDw4RWbjK9XTiSt76Vj5xlTnY9ecCJL6vYKPS1");
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapitalLatitude(2);
            state.setStateDescription("gQWs7lyuTQbI261TYyZY7IMinvhURE7AImufcM7Mg3FFCLlQTP");
            state.setStateFlag("gNEc3xr49wWLQbJO0P2iM4gtsQS4wlxdtyuheGZMdtM1NJGnfF");
            state.setStateCode(2);
            state.setStateCapitalLongitude(11);
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityName("77j8D8X3bgLMpmNEK4izm2vvP5Ba4bjc8SyDt1dMWSBJSAyeIr");
            city.setCityLatitude(11);
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityFlag("jhztNEaHe7KILe42CT0EbqMJHRpNQP8z8vlkW1bGKlQgA0CEbB");
            city.setCityCode(2);
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityLongitude(11);
            city.setCityCodeChar2("sXO9eawn8I7k6CqMUwxev5vunuDmkf2Q");
            city.setCityDescription("lqyrLKdlAVnV0mWUigf1RytqNQUYBgfnTmveT6Niw2ZcCQOj05");
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            AddressType addresstype = new AddressType();
            addresstype.setAddressTypeDesc("RM5weBKt6Sk0oezFnXfl9WNh6NL7wBaxZgTBOENJXkwFGGayIF");
            addresstype.setAddressTypeIcon("3kI1m4XmD5hU0wBvPADSw2oGNsjUuIjtZfWmE0PSa1wvS8SM20");
            addresstype.setAddressType("BeHg4BCWGESmFVu52qbRwdVFQwwWOh7vtyOJGD6ITMKeX5gNLt");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            address.setLongitude("8EX0NQpshWJ98tERqjAtMOnDJHYPq9rglXfRI5mBOgNTr3GAG1");
            address.setAddress2("RglaAon84dIOss4VFnmABkhAKuN3HFJ7siT3XVbcnUGxoch6ZZ");
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("YtkZl3");
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress3("cxd0BWasiJ6Ea6Oq76ysZC4up6xMjudAZj1BB1fQIqqNg8uwrv");
            address.setAddressLabel("HvNw9KSOcFj");
            address.setLatitude("hj0hWh7p3vUhQEi6HDcwXtmYaSM9RCONkz8LkhFSgAFZy0HZjB");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress1("fvurBW8ham88Mi1YV5UKlfdtEL3SyC7F6c3WRU6LJM4oO7pME1");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommTypeName("bnc0gdbnPgUn8Ty292W34tTlcOIghFwh4VQQE7N3IUZqjJaRP4");
            communicationtype.setCommTypeDescription("y0urzvcfUmoDxT3eFIvG9cmX0hS75dzuI711J5SNrJUwpx5aEo");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupName("8tiwEtDtqL1OlNatoKiI90kXS3dxkDxy3r9KxiUlRYgUIt2VPC");
            communicationgroup.setCommGroupDescription("ULx5TKQVMi2zv7u5GND0YTJYr1jwqOjm7Yw9LXSazZgjPQcL16");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            communicationtype.setCommTypeName("gYLs6t7RlqRqIvd0TUajpSo9pU3Ig7iPFfRdvv7AGNuWVklcDi");
            communicationtype.setCommTypeDescription("DrJvGVBFbAVj6NiLuViTjHpQIfCxcQtU7dFLcCW9UjemKxDX4O");
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommData("6");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            Login login = new Login();
            login.setLoginId("xSQVj2iqzN4VsJ35wr9OkSsbBCSPRj3sFUlqz3NYmlqGaCbneG");
            login.setFailedLoginAttempts(2);
            user.setUserId(null);
            login.setUser(user);
            login.setServerAuthText("KVeCIpUpmVM0kaqE");
            login.setIsAuthenticated(true);
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setServerAuthImage("2dCoDefOSY4kLaTfDGkZSnf6z3aXebSG");
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setVersionId(1);
            login.setLoginId("GQ42vbwAm6k9lO8h8TAanIR11R5e7AoTDOsoMktNgBwXrS80tV");
            login.setFailedLoginAttempts(6);
            login.setServerAuthText("wYZzCa6CIxJwxjX4");
            login.setServerAuthImage("AUrTmuwd6JocPNQ4y2mzT9I4WfSLkJik");
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
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
