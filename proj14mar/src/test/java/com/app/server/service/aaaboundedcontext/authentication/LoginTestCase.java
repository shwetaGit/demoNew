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
import com.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.app.shared.aaaboundedcontext.authentication.PassRecovery;
import com.app.shared.aaaboundedcontext.authentication.Question;
import com.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import com.app.shared.aaaboundedcontext.authentication.UserData;
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
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
            user.setGenTempOneTimePassword(1);
            user.setIsLocked(1);
            user.setPasswordExpiryDate(new java.sql.Timestamp(1457944007956l));
            user.setChangePasswordNextLogin(1);
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelName("Kz0awELvleuRuKAnUhoMvKKNcOyXQmCTAJAykmvwyjb1tzBA1n");
            useraccesslevel.setLevelDescription("5D4t6lbXwhXXWG2XNz0IMWpwdtyjfzvZOJhijHOGdFtwy5ZGK6");
            useraccesslevel.setLevelHelp("cow7pM96BhIZcnOHK39HojBBgyik6q0ULgt1Ec5tR36tuNN1KP");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            useraccesslevel.setLevelIcon("rr5cE3AOdSLfZLJvqml2SiyZInRyWsaxr3qTQW6adWLng1H89a");
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainName("jSLt70o6Bbas2XjVnzZeKgQU984bzIo0msyFjzobf0HrPh8baw");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            useraccessdomain.setDomainHelp("FhsInv2GSU4qqnbIUFGufCtXCWySg8TbWE6dWr9otHDUdVxw8U");
            useraccessdomain.setDomainIcon("iL1UMJGWf4LWqHyKyKjpz2FqkccZbPuI09IdVbnGuN2MqYqiyN");
            useraccessdomain.setDomainDescription("gbsZGWRMnEw5dypYPh9ZIv0OpmjpT3loKUnuhX7CsW9dYutgaM");
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            user.setGenTempOneTimePassword(1);
            user.setIsLocked(1);
            user.setPasswordExpiryDate(new java.sql.Timestamp(1457944007975l));
            user.setChangePasswordNextLogin(1);
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setMultiFactorAuthEnabled(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(1457944008034l));
            user.setPasswordAlgo("tASICGIwIBhIbevEzBzmuxuU2qFXrsn2rTFUKbaJIox6Kdtbcx");
            user.setSessionTimeout(2985);
            user.setIsDeleted(1);
            user.setAllowMultipleLogin(1);
            user.setUserAccessCode(41506);
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            Question question = new Question();
            question.setLevelid(2);
            question.setQuestionIcon("9LWvnemM79ZxD9mI2l15RLNm1IQ1Pfij8lTuJq4oNHsroDVnwz");
            question.setQuestion("dTDgaAKLTI5Ym9A73Xg51xPKwAioNxzXj3Wk8dN7Usru0L0O6b");
            question.setQuestionDetails("2");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setUser(user);
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
            passrecovery.setAnswer("3s3UXyZGKbbaW9FB8eVNLDjc3vIt5nMMHBMDDVWerBV2diaY7x");
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1457944008218l));
            userdata.setOneTimePasswordExpiry(8);
            userdata.setOneTimePassword("44Xc92bWDL3CK1FprBJ9Ewbku68bJJx2");
            userdata.setLast5Passwords("TimjENuF0yJkc59fyFQmvySBFaeEyXcgxJQicKxHlnOUsINkm1");
            userdata.setPassword("tPxtK9K1ApTMsNNKC5vp0I7ePJ0SqRsJJCplPBNmVffpFoNvFL");
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1457944008237l));
            userdata.setOneTimePasswordExpiry(10);
            userdata.setOneTimePassword("Nws67Ttz9ryxsGZLeWCp9TJgyAyQpAue");
            userdata.setLast5Passwords("HhlWK6LyaqYkxpm8W9dUDRU2dhq2cuGoV1etsBDI7V6ZFxyjTC");
            userdata.setPassword("jthLnxEiV51D2WxgZPpus7yiU5tdeEKVdjOlTXDD45Ijvz0EFR");
            userdata.setUser(user);
            user.setUserData(userdata);
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(3);
            Language language = new Language();
            language.setLanguageDescription("YmlOtiqVCp4ObFFbe8wGHylYVYsShQPgIUF9gbjRO1bX072aV8");
            language.setAlpha3("B3p");
            language.setAlpha4parentid(9);
            language.setAlpha4("gsC1");
            language.setAlpha2("0S");
            language.setLanguageIcon("eIU9abe3ML16PR2SbZpEREeySCz2FEyIGLp32aoqXEE0nQOmay");
            language.setLanguage("VYiU02pUUFPtN6WcRdBQ3Y99vQoUoGQP2TECLqU1UYslzlalci");
            language.setLanguageType("zsaksmBQVXLAlXfegxtkcp3y03X7d0rm");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setUtcdifference(1);
            timezone.setGmtLabel("E0VCK93euwxqMTvMO8YuQZqh509stpQTHPns7IWESZoZyBLCla");
            timezone.setCountry("2facUfEnY16V2T8v6FKZgqObQ0fFVGjC3jdHm16vYBFViSPp8u");
            timezone.setTimeZoneLabel("9QkmcYX9lzw2Z1DbeVJiOhuCYpFgSFgXYf3dhNeUEK5uI601mk");
            timezone.setCities("BcnK9Gf2gbXG2OSGmKyXT7m2Rh54PZXqzMFwJoDcDjIPOm7dwP");
            Gender gender = new Gender();
            gender.setGender("BHwA9fKZINjqOO7fFXPtQrAlcsJhBobnx4gLD2fgeLxJVifBqH");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Title title = new Title();
            title.setTitles("ksxH9u0XFbbyfW0OmUgVeuNFqyblptncNwUBhvkF66wzhL93wz");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(95);
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setLastName("zHkh20dOHESQRljamCa0YTZ8nNWPRQw65mFVokUwSghyTo7RkE");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457944008413l));
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setFirstName("jra9eTTvtbZL1Z8vqNgqu3MEX2m7ytqkqo9wFPj7ncWvWL3e4m");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1457944008445l));
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setEmailId("IGCMOMuUEysbTbaidf6WZuYn2TfCE1PYr3VaBF3KxQvCQJO58E");
            corecontacts.setNativeMiddleName("zF6SXlkmSAYos3UfaCmA1j9kCYjylaAuCi3FKApZyz7YIHJvRs");
            corecontacts.setNativeLastName("TnfxBLUHMWDFbeEket8gV4O39lghhkR0wEf1ZyTTl1Il52y0Vi");
            corecontacts.setNativeTitle("Ya9kV7QrnttxFSJ3lqymTOYhtrLfakwMzz2Pbwm8jGprtMXqg2");
            corecontacts.setNativeFirstName("Lo5Ybv7pYdM4ZPxaY870WjhOHXNDbffcnNbo9xOlsxjTMxNzOa");
            corecontacts.setMiddleName("tHyk3EZWcjVGy0lJn1Z0wUglZnE8o612cevOp7DhgAOpUwbzLe");
            corecontacts.setPhoneNumber("7KIPXkFReqSEXoLlBVx8");
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddressLabel("MKNV3iq4iDN");
            address.setLongitude("e1OY0U5CyBIIWPQRS8w6S5GHfL3D0GuBYnUXCGxJBmZwee7cMJ");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("GRP7HmtxIzFdrGb6wNNxDG1RBY776S1uHQIbyfzn80otsuDjBk");
            addresstype.setAddressTypeIcon("0q5rzdw1gdDCIuMCgdtED1IO9CUtMN6p7z4wtThPDpWLdUvhnv");
            addresstype.setAddressTypeDesc("QIveS9GLAPhJzD8EtVdbskeIuEDxJSrL4QRZ8NkhFOCYXOvnfY");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityFlag("Ag1X4wlrVlkpfMagTnlRZehverUSLkYW1IBdNY3Chf4WRnd8at");
            city.setCityLatitude(2);
            city.setCityCode(1);
            city.setCityCodeChar2("pIl2ZL0zwWyKpqlSSBgS0XyX9gRY0Vui");
            city.setCityDescription("ckRpzxwJrgIu91S8W7VItSTcNTjXRmV76pp5pZ3gM0wQFnVpVx");
            city.setCityName("CVU7wSDv6gxvk7TFdELTEkNzGnikL0grz325yCRWfCifMzaDAM");
            State state = new State();
            state.setStateCapitalLatitude(5);
            state.setStateName("yCDCVhY4jKVByqRjjHCssNmDkIJqjGf3Kn9htLoOmUmJWKyFT1");
            state.setStateCodeChar3("1yVYNpZpLIn6pFa7Uzs3Nc6SrF8Aoeop");
            state.setStateDescription("Uh9w3ZdlU2iPS3oGOnEh2u3YbynygTExWzWiAmP9UfvAzcgQCg");
            state.setStateCapitalLongitude(6);
            state.setStateCodeChar2("p8XEWQJmWCeSQHyzzwBrX2W7JS86FLVG");
            state.setStateCapital("0rNBvaKtjXNn0K6FNFsNtAFcxNxX79WPT1pbIaKYMsE6myXkef");
            state.setStateFlag("gz8Z7Tj6ikY8IIUbXVWA2yIEiA0JCavBy7QXBlX6PDPkBgJ23G");
            Country country = new Country();
            country.setIsoNumeric(10);
            country.setCapital("Sy3vf5H0ZuabPABhkKVg4Z5F2e0FduqB");
            country.setCurrencyName("CZfIT2AxFwuWLbPG4VRCxUxfxWcxdCsTua2ylLkEQHKU3AJelo");
            country.setCapitalLongitude(4);
            country.setCountryName("71K2Z6rIg23ko34NtVlHYJHA8K4UdqHjiuVGUte5qR9nuZ8kFz");
            country.setCountryFlag("ml8MQT9wXyCmSEjNex31sX8DTGewZB4qZD5fiUUkMva4tj3Eo8");
            country.setCountryCode2("wlJ");
            country.setCountryCode1("K5u");
            country.setCurrencyCode("8Qe");
            country.setCapitalLatitude(2);
            country.setCurrencySymbol("1HepN8AL7mnbAqfvJ9jzSLuimPwPAgQm");
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            state.setStateCapitalLatitude(4);
            state.setStateName("pszbAYV687wcLFrf12J588xrEi4G3TJJFoZhxAskZS8lHIeFbc");
            state.setStateCodeChar3("jv7iOnZAvinsvZLc5XZ6fI21o3IHffi7");
            state.setStateDescription("ENrJSCqFCMEjCj5oDaFLgxvGxbYtF3tMbAzlDtgLZBKTMWlOOw");
            state.setStateCapitalLongitude(1);
            state.setStateCodeChar2("MmjE0g4Nx6eZriSJrdDFxpJUYcD7APcm");
            state.setStateCapital("SyosReCTeGAaSFluByVe5r8DPQ5xqHFD2lOa8QAaUIQCeyKfGd");
            state.setStateFlag("NID6eMBeB6Vv4tZmPl8p3rW3ghDzKSk7fnLvPa9ULBbPVSCcP7");
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCode(1);
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityFlag("9PtHdsOAQzAObB01GHAn3ImjSAGsN0CIuZHKUd3LqLxPzE8TJn");
            city.setCityLatitude(7);
            city.setCityCode(1);
            city.setCityCodeChar2("uSrtzuRra5wiN1wDT3uiJN3gVN9UurXf");
            city.setCityDescription("fmBocv7N1EjFBZGslWAR24edOh424tNGOUdVx51AIuORnvRAUG");
            city.setCityName("oBvEQR72xaQ4wDHnMWsiZhbBYnHEvYHbPJipoJVUkO0SnRL2WT");
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityLongitude(7);
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddressLabel("BgTXPAAqZiE");
            address.setLongitude("uYVyzfQZdFZBGJf66EJRsAzDpIeYcoqXjUG32QdAnqiB8J7u6i");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress3("mKKJyA8CiUuCkUf6XOHSorMH21rRe9VI4tOzQC9sOK5oU8m6UX");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress2("jGuDpw2Oo6vt0ejSUag7CrLbCfxxfTCvKKpC2j0rKcZcZhVLBr");
            address.setLatitude("WVxUYVPIEA4E3TMn43w3GSr0Z8SfTVBg6D8noU1ynLLxHR4pZw");
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("6rXnP3");
            address.setAddress1("aAWynSfiDwkAxg8Lebt16j0Ya403kkQ6k79XKgJsA4iRWDjeaL");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupName("pC2NzngqlBHsvaJnuOqA0auClkrU8EQjUL781Ukmjq8Mkre5xv");
            communicationgroup.setCommGroupDescription("9C45BN6o6C6gx2NV37SM6zssEdMKGdVaecX1Vd8DKUP13Lg2Q3");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("wMd6TdrdXZ5Cs3211PlNofDioqWRJKjG7SjGwrHieivbJyHb6v");
            communicationtype.setCommTypeName("cCegeOkLpwlEcrfJnf7a9Gt9xq1xboaRwNZyKaJFvPzIsjI44N");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            communicationdata.setCommData("B");
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            Login login = new Login();
            login.setServerAuthText("kze0Gn9V86WgXAp7");
            login.setServerAuthImage("jItPntE7wcHMmoFSFg80Vf316hZMyFmi");
            user.setUserId(null);
            login.setUser(user);
            login.setLoginId("4LA9IyYHiNAP9BznlwdqXfPrtS2JrodyiwiAXdLQeszpOqa4kZ");
            login.setFailedLoginAttempts(1);
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setIsAuthenticated(true);
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
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setServerAuthText("ySs4wQkRP9vjydox");
            login.setServerAuthImage("Rtxsgg7gmVq46APRg22H8gOsaJ6TahfV");
            login.setLoginId("iFo82oU6GnGby7AictwKT4PZCeNA6UgxJUmdfoFU89RjH0HPvn");
            login.setFailedLoginAttempts(3);
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
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
