package com.project1.app.server.service.aaaboundedcontext.authentication;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.project1.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.project1.app.server.repository.aaaboundedcontext.authentication.LoginRepository;
import com.project1.app.shared.aaaboundedcontext.authentication.Login;
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
import com.project1.app.shared.organizationboundedcontext.contacts.CoreContacts;
import com.project1.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import com.project1.app.shared.organizationboundedcontext.contacts.Title;
import com.project1.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.project1.app.shared.organizationboundedcontext.location.Timezone;
import com.project1.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.project1.app.shared.organizationboundedcontext.contacts.Gender;
import com.project1.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.project1.app.shared.organizationboundedcontext.location.Language;
import com.project1.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.project1.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.project1.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.project1.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.project1.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.project1.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import com.project1.app.shared.organizationboundedcontext.location.Address;
import com.project1.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.project1.app.shared.organizationboundedcontext.location.AddressType;
import com.project1.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.project1.app.shared.organizationboundedcontext.location.City;
import com.project1.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.project1.app.shared.organizationboundedcontext.location.Country;
import com.project1.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.project1.app.shared.organizationboundedcontext.location.State;
import com.project1.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.project1.app.shared.aaaboundedcontext.authentication.User;
import com.project1.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import com.project1.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import com.project1.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.project1.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import com.project1.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.project1.app.shared.aaaboundedcontext.authentication.PassRecovery;
import com.project1.app.shared.aaaboundedcontext.authentication.Question;
import com.project1.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import com.project1.app.shared.aaaboundedcontext.authentication.UserData;

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
            corecontacts.setMiddleName("oaU7VOmYJfHx0SxY31cxQi7ZxgnQQkvrTjh2SvVt82YMKYJUlZ");
            Title title = new Title();
            title.setTitles("btcCGonnKvNgzCdCBY9BzFXSiem84o64sQFvRYg1D7HWRJSUtK");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCountry("huEnNTQI8OFpGXQDVYTTSHXekSaINqRsruwniZzUaxXB7HOkpA");
            timezone.setCities("vuYZmRznouLA0nOir77bbvxK3yCBYem2m7kxjvjrzmTcO6ar9E");
            timezone.setTimeZoneLabel("3FhS1uX1C9u8UyfGXAosMnAkr6avSN7TWLu9zIQr4Gib4oaWCY");
            timezone.setUtcdifference(1);
            timezone.setGmtLabel("eQikhhe7Fg0XkoxlHexIlYP6zzz4LoAFmSjN1UljdTjRkQDbbZ");
            Gender gender = new Gender();
            gender.setGender("lJ9mlXldu5g16FdBXlVcMtsL6SDfy80jNdQZxjTHg1tyVcTnVF");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha4("IShO");
            language.setAlpha4parentid(8);
            language.setAlpha3("Cp3");
            language.setLanguageType("GzK9IlAyWuGc9pEu7DCSajUdXbwR5XUE");
            language.setAlpha2("oV");
            language.setLanguage("jQvnnO0fvEb7K0QV72v15gXAeTSvZj0Og3qK8iUJmENJysacTn");
            language.setLanguageDescription("1aM3cOUDI4hNsAFyJCu3BK3rGTPTQlAVRgMQEbIrBSqU94xNUX");
            language.setLanguageIcon("6hZVii3DiE9nPPYpifrN0RVDhngCQHjuJ5JLosidSEpNYQNnWd");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            corecontacts.setMiddleName("JmIXlhRF1f6NIHFmSB0sUlF3zV5wUwZlXIfrSZjL5RKfYtYPRY");
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeFirstName("h1pQ5PIcbDVweqKfvx2QQVBshgXjYLtjmRMpobOpF0P5T6w2dF");
            corecontacts.setEmailId("zbRXWcVpd0swIRuF7GXvitcoYhSXb321palhKJZ2vlnnqdaEmU");
            corecontacts.setFirstName("W1lGiOIFeCJk8vDyQNy5XaFBbl6pCk8sc21MsxLJzhBSvllIzS");
            corecontacts.setPhoneNumber("wv3x99O1HfpB2fyRqgFf");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457502855730l));
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setNativeLastName("qzAzWJzcbeOqY2YeRjO512l3LLOYp9rNiyNznFLGTVoNX0eqy3");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setDateofbirth(new java.sql.Timestamp(1457502855813l));
            corecontacts.setLastName("ibL3jJPzWUux0Fkvan5uG61jZo7oohP1yrLjB6uSyvZZAHoCYF");
            corecontacts.setNativeTitle("1xGoipqoavDtsbcBGz1pbkiaRPfnGXIUGon6GHY2R82a6YlKEc");
            corecontacts.setAge(44);
            corecontacts.setNativeMiddleName("08MAQA9Yd7c2BGEYZQRDKU1HtdmYdbRw6Q0jV2R3ZolvJWHcuI");
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("o");
            CommunicationType communicationtype = new CommunicationType();
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupName("XhSnnwUO4p2F3XTxqtHWjTCLLECcCdjTSbUihrLdrBbgu6tb40");
            communicationgroup.setCommGroupDescription("pJlOq3093aOFTw7ZPKMQe3Br8XB7b0kzBvwtUSS5E6IrWGVmpQ");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeName("SZSj70rkGIFoy6fI2AO88uBfkw9TJxdat8crSEKjSrSF3E70Zr");
            communicationtype.setCommTypeDescription("F3D9C4D6zC3IjlPj1n8GYs3luSaQgci8cG1dksxjynZvx4VSIA");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("g");
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            AddressType addresstype = new AddressType();
            addresstype.setAddressTypeDesc("KTTv9MrmNjYlTVy6xJ9w2lFfGNnpglTV1Pw5exylv59ToFOniC");
            addresstype.setAddressTypeIcon("XNxmRRUnDihlZ5FDaAn9pGxFQCiNc1vjAxiM1nZtTHWjZuzzGS");
            addresstype.setAddressType("oYTSHodzPXpSwzMJrds0DpxZ5TjKJ5vTPBqZaBreZssI7WEnpB");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityDescription("eQIUWM9WL8FnjrSlJT63MugbC4AXoHg8KfATdXTGKzRl4XyhhS");
            city.setCityCodeChar2("c26wdoUDdIRVhRjwHRUzDpaM6SEH3hlU");
            city.setCityLatitude(9);
            Country country = new Country();
            country.setCurrencyCode("Ahc");
            country.setCountryCode2("k28");
            country.setCountryName("HGZLTAKmW9JDqdUszi1k5u5AAZmN2Qn5K3uWmBLGOyjP5S4brw");
            country.setCapitalLatitude(7);
            country.setCurrencyName("YrGtNYIKidat3LvUmdM9EbpFxAJ2FEPYD2hf4RkqvoMG0WFtZt");
            country.setCountryFlag("Q9B5EQKfHwFwEuyAUxbr1HHRA4YRe2dnKqcEXVlpfRrpkNyqUF");
            country.setCurrencySymbol("7W86Rs3DeHbgkoeaW4Z3XBE5pMG5gr9x");
            country.setIsoNumeric(8);
            country.setCapitalLongitude(4);
            country.setCountryCode1("SmF");
            country.setCapital("364n3MSpgRGElt1p9Wg9KJRRh7qrDp9B");
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setStateCapitalLongitude(2);
            state.setStateCodeChar3("xlJR9xTnXzyRvSoHPA4BgYtgRyWTg6HQ");
            state.setStateFlag("KxItYsnZ00Ob5aHnhvdV8G6eJ8CstXe7ZFQJibq0RulUw4WKBG");
            state.setStateCapital("KBPfv2IwRJYhTzI5UbxKTl2ngLE0k2NGlYiiMYWamtzlTyQ95n");
            state.setStateCode(1);
            state.setStateCodeChar2("04t7AiFmcijDifIRuNXPL6PsxWhCdmR9");
            state.setStateDescription("0DhycG5sBuMGgXwdnAxBtBuGJPcjlwnuNaonII3IfUXVmG1KS0");
            state.setStateCapitalLatitude(2);
            state.setStateCapitalLongitude(11);
            state.setStateCodeChar3("S2wVbCwJ1G5a97kqk4WFBP5xtr4ck9xh");
            state.setStateFlag("TQo24S8uxJMIqAIjPfgA5au8MR2yKjujRHfrJBtcV0pOETrkqt");
            state.setStateCapital("R4zPpFK2XflFPchw3366z2lQxXGw1AzEIqD71zCJsVoK4ha7Y2");
            state.setStateCode(2);
            state.setStateCodeChar2("hro4Iu9VAUruUtnkhrrmJyrUEoLFroWz");
            state.setStateDescription("0jye6E7e2M2yk14EhAQ3isyY5EbLbHapDlqw4TGKWOGfnlwkUR");
            state.setStateCapitalLatitude(11);
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateName("DNUnoXdj1r3sa3ayU5UFwKOMKeKsIMHWeWuDPI6ur4KDaDqxzo");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityDescription("SJHcevR4kE5U0ZDS2JRHl8kbrGY9wtpPf7FdIyQMcCr3NG7T6I");
            city.setCityCodeChar2("kiilo7NuWClBmlfvLr8HlHqIXYEXJzXP");
            city.setCityLatitude(10);
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityName("D4tlsE4KGi8kABP1Vpr8KcQWKkIuQP7dKeoZr5TFDpNIwjQwXa");
            city.setCityLongitude(2);
            city.setCityCode(3);
            city.setCityFlag("3BmkXOif4ifQU8frF5IBzebRaKABy4c2pYthe6VWjgOSp9j0vW");
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("uoO0kC");
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress2("fpFyMtDP2OKfOAvpDvnqAClrtfDRkt0ILdGIYp9nWcoVIoeR3b");
            address.setLongitude("ds25G0li6PGlNjyYR7D1KrmEEks9c1ayoEdeRQgKtMphOaBdIr");
            address.setLatitude("VKxrQsxH2yakV3OY9JlE1PoaH6CIyiqQvShSzeSe9lHgSKR0bc");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress1("y3W3E94VIZvHwrFkYDaDNEfntPKX0V0PW1mrngh9ZKHFAu1rF6");
            address.setAddressLabel("Gnaj4oS61XF");
            address.setAddress3("YUyOklTPliZbADH4bGQaSibGXq2KqWwicwQ3UmddM8n4VfXfbC");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            User user = new User();
            user.setSessionTimeout(3017);
            user.setPasswordAlgo("NsKsdIbjfagIHwrVhbMkIGlE89KGCaidomrb9XM6SLc1uWkXgr");
            user.setChangePasswordNextLogin(1);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(1457502856204l));
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            useraccessdomain.setDomainIcon("xGwE1pwnLa0PtsDUNJx4z3j9u1s3FxvqREoEIYY0YqIMbi6cjv");
            useraccessdomain.setDomainDescription("vDz3iU6270bfyRhZV3LpNcsmQ1Qff0cW1FW8Oy8acbjmNxQInu");
            useraccessdomain.setDomainHelp("CbHZZg2H9Uqhx0tUhU1xj5kfAF7T39a8frvdGkieCPh5yCg4ba");
            useraccessdomain.setDomainName("fFUyYYmpU95NYeMxxxgUQCRwKwHglfLSe9yETSgbUf60YHfofO");
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            useraccesslevel.setLevelHelp("uaKiLoBbg3Xjj9IEmTpYfSWC6pSDIa3AczUcYZDaXmp8QiP0OC");
            useraccesslevel.setLevelDescription("X9KZWjaCjU7MyPX51hCq09FjHtpZTR40IZ9Jy0q5IUSC45wPBI");
            useraccesslevel.setLevelIcon("DlmLw5IASK9MQ1DJufOxC08SHvkdNJ1Ba8l1mhAqmAti4opY8I");
            useraccesslevel.setLevelName("4EHjS2EyaCYAYPiszP8VNswTdR8xaC38ysF8CzkKCOIWvEMDnR");
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setSessionTimeout(3436);
            user.setPasswordAlgo("orWltXusLhG8mCOxm5K9nlutUiDGNJrTf5wKiPytUrYJW7aCDE");
            user.setChangePasswordNextLogin(1);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(1457502856224l));
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setPasswordExpiryDate(new java.sql.Timestamp(1457502856260l));
            user.setGenTempOneTimePassword(1);
            user.setAllowMultipleLogin(1);
            user.setMultiFactorAuthEnabled(1);
            user.setUserAccessCode(44799);
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("DrZYp1Sfe6nLRWrkEBPkbjRfgr1J4vTkxaQVlbhEjPnwk0d2VG");
            Question question = new Question();
            question.setLevelid(5);
            question.setQuestionIcon("XsWNjBKbnZk7FusiUACKmEkuZfZ0xjqcooDSbE7Iz7pyfnM2Ya");
            question.setQuestion("jv8PrclL90e6oSXeBGr9m0v7mDsVLUgvt6erU5BS6PRaOMCk3m");
            question.setQuestionDetails("f");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("s3XBnQP9h4xhhgD1xCm5mPnUt4jZ6kuBQoZDOT2M16CKHXC2Ot");
            passrecovery.setUser(user);
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setPassword("w6twin6ua47zMQR4KnnrsqPMVXwTVZCzriNneYVEdg3Sqd2PF7");
            userdata.setLast5Passwords("QEcNlhMtqeo2SgOezuiRPS2ibKQKSJpO57ixNL1Iz5MN0JksQa");
            userdata.setPassword("FgxgaS0FORoPYVzGCMCppdgICv6AtZ2mizr0HTeNJilvT7FEhf");
            userdata.setLast5Passwords("HDMrRLjXunAZkXMFV9FxuFPpsXROju5MqXUAVyEdwmJXMPyiEp");
            userdata.setUser(user);
            userdata.setOneTimePasswordExpiry(8);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1457502856530l));
            userdata.setOneTimePassword("sSMWtzs0sBHMZ57Lv0HLaeW17ILyZyMU");
            user.setUserData(userdata);
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setLoginId("WCwlS1JJDXIbaPVUNh1lhEVzad6QMQOyKErKjn77XXfFzWroaN");
            login.setIsAuthenticated(true);
            login.setFailedLoginAttempts(11);
            login.setServerAuthImage("Uml8RV1xUwETaBI4fxPqJOnNDFZbu82X");
            login.setServerAuthText("Uu7DnUR6ZMcCtlh2");
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
    private TitleRepository<Title> titleRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

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
            login.setLoginId("0SmVvw3OV1p7wqchnZbMsIyRCco0JlVnF1HZ6uq7afp2ZdUAAT");
            login.setFailedLoginAttempts(4);
            login.setServerAuthImage("XPz32wvgJKNLWCJOWMzVNPDetazYNSO4");
            login.setVersionId(1);
            login.setServerAuthText("IsupM1Fec81pgfo1");
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
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
