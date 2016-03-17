package com.app.server.service.aaaboundedcontext.authentication;
import com.app.server.service.EntityTestCriteria;
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
import java.util.List;
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
import com.app.shared.organizationboundedcontext.contacts.Title;
import com.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.app.shared.organizationboundedcontext.contacts.Gender;
import com.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.app.shared.organizationboundedcontext.location.Language;
import com.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.app.shared.organizationboundedcontext.location.Timezone;
import com.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase extends EntityTestCriteria {

    @Autowired
    private LoginRepository<Login> loginRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

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
        entityContraint = addingListOfFieldForNegativeTesting();
    }

    private Login createLogin() throws SpartanPersistenceException, SpartanConstraintViolationException {
        User user = new User();
        user.setPasswordAlgo("Sq6TuDcSfuetqCsz0ygnwp2uj0zIrtYBD5KbDc7NeS0lQ4YcFq");
        user.setChangePasswordNextLogin(1);
        user.setMultiFactorAuthEnabled(1);
        user.setAllowMultipleLogin(1);
        user.setUserAccessCode(8236);
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainName("RU0rAi8NRand6BEDgVKFF9FxmLkD3ILkOwnz9OoH3N9HBywLBj");
        useraccessdomain.setDomainDescription("fQ9aSvsgu7h55Gzb2rXNMZB1IDdwy94Pg6C91OrEjO8pJaOEVD");
        useraccessdomain.setDomainHelp("8htaKoyDxxdOCELumUr0mFZpT5OqnXy5aXjGOt0k9wePJ8t91p");
        useraccessdomain.setDomainIcon("sVSlzOlTdCoVzAhcb2gDROtjsqQjKZJwHmYP5d3IgZYNhSAaMF");
        UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
        map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("HJb9m5mtOsVCXr2M0JftFggABisIhLzlRbWwmmJ51cMVx9NjhZ");
        useraccesslevel.setLevelDescription("l9n8Hv9BEjQPPG99OmFvON6uxFjEpC3ulpjEXRrjJ7sD0l82bD");
        useraccesslevel.setLevelIcon("WAv3G2Iwy93WZeitL7Oz89DMDXZPqTeTzMN9lr4ueM37IwkBUw");
        useraccesslevel.setLevelHelp("G51yl4rqZCk2hviErEsQDnyCX0GU10p1y3PHNUkipVp7uxZuul");
        UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
        map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        user.setPasswordAlgo("JEP3bu9DWYCCbFs7LG5R3ApHTdWTEfC5ccuANswiHh0MgHsQy9");
        user.setChangePasswordNextLogin(1);
        user.setMultiFactorAuthEnabled(1);
        user.setAllowMultipleLogin(1);
        user.setUserAccessCode(59471);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setSessionTimeout(1284);
        user.setPasswordExpiryDate(new java.sql.Timestamp(1458211486102l));
        user.setGenTempOneTimePassword(1);
        user.setIsDeleted(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1458211486148l));
        user.setIsLocked(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        passrecovery.setAnswer("OaKuOtNJqWLpj46A47PYZ4qNGJLao2dCjD78agMaDr6M23XlLJ");
        Question question = new Question();
        question.setLevelid(5);
        question.setQuestionDetails("StgcTSSj7J");
        question.setQuestionIcon("hIyrsOVAxOXwhoCKkMFPHT7PlPxnL0w0rB20sAn6qHjW5mwkdi");
        question.setQuestion("gJHwMK1DvNaOAdRzYm1oNCAhiUGDmX2D2h8UL0Gk3VHGUAkw8Z");
        Question QuestionTest = questionRepository.save(question);
        map.put("QuestionPrimaryKey", question._getPrimarykey());
        passrecovery.setAnswer("NIlgC6Jl0IKiSI03Q7SOzVYjffYMIwMyRZjYkKNu8LGcaKs7OV");
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        passrecovery.setUser(user);
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePasswordExpiry(6);
        userdata.setOneTimePassword("Vc26FzxpsB4o7YGzeZP9yF4YCpWSz2Gj");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1458211486360l));
        userdata.setOneTimePasswordExpiry(3);
        userdata.setOneTimePassword("m0ba4skJilp7nzqKznn9MLh2HjqO9N0v");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1458211486377l));
        userdata.setUser(user);
        userdata.setLast5Passwords("2In2wMSbU1953TFE1F2sMYkmVmw6lcJ9y24kKBMCk0qZSRw5Dy");
        userdata.setPassword("4exRykCtllHyyzcP8SPW4V4c5xXBf6nahOZTEf2UBNe66OIHhe");
        user.setUserData(userdata);
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setLastName("dAYEtEVYm3Y3vHdwx215lla9hYbLYd2WqfSBySZVi391qVXnf1");
        corecontacts.setPhoneNumber("dbDFRGYxEKF5khb086Ta");
        corecontacts.setNativeLastName("vg1ePqEorm3pcnL6eSHocyioEDnYcQ0xwj6V4WnAbrHd1jXE43");
        corecontacts.setNativeTitle("IuD8ym07zYgye1Fa0SASLmGv8wlxBr8IOynmw8QNqhAhoOMkmO");
        Title title = new Title();
        title.setTitles("FO1Megf7mWzx4ACghsxwu4to02WCbJTG47EOAaDbR0L7YinZE6");
        Title TitleTest = titleRepository.save(title);
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("TDJ91F3x4f4E3BUbZHipq4xzI0C0H7u0SnfvZGudSouDG2u3Sz");
        Gender GenderTest = genderRepository.save(gender);
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        Language language = new Language();
        language.setAlpha4("kFOu");
        language.setLanguageDescription("EcsixfM9MZUFgkYsu6dvDxugTLHf5ZRfrHE4n7887GsEOngx3j");
        language.setAlpha3("PM0");
        language.setLanguageType("QwNCXsetKOEpZ020zdYW8nAiebgIA44J");
        language.setLanguageIcon("cx49Sgqyu1M1URDGmilg85UKJuCiYyMblMmeJcsFF1kbYGgvmJ");
        language.setLanguage("HAK4Oqwt28lwUBj9XAhIHcygiqRZM5IYIZT8WSGQKADiE2mU4d");
        language.setAlpha2("St");
        language.setAlpha4parentid(7);
        Language LanguageTest = languageRepository.save(language);
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        Timezone timezone = new Timezone();
        timezone.setCities("gOhURFT8dJM6WBzX3rdRvzFjrSx250QQkji0sXOp7P4LLv0ta1");
        timezone.setGmtLabel("xFW9GqiKtF4MCvafWONhthp0XF8QVi0kMOXqqLsuqbhHbJk2MI");
        timezone.setTimeZoneLabel("rHS0xxQipLhw5XOe3LQck8rZKsB1uheMWc4ygdzhrdVUsM9WCp");
        timezone.setCountry("xddrqheyp1vEYNSssMM9uyELJY1D2YASEV0PLRF2l4YWHfXZ88");
        timezone.setUtcdifference(9);
        corecontacts.setLastName("jvOtwDTAqLLhEoiPcGso6D26bolimQmfliDrAapCfeVIJptfnz");
        corecontacts.setPhoneNumber("Qm9tQUfpBIzWAYzyyszd");
        corecontacts.setNativeLastName("5MkJYaylv6Eh0sF3pwg9seKVYn90hCocr3BwDJXRfujDMuHlLf");
        corecontacts.setNativeTitle("Am0Bjebr3gHr2mNb6xKvDsWHcG9ucOnGH0WJvThIze8t1rAHa8");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("v6fSGyOwIAptvSF2LyBy8Bx10yC3gpHi2sxgS8Crb1pIWqh4lT");
        corecontacts.setFirstName("XMWwLDvU3pDs2i5YBWbu00iFhFSoUElwZrDroP1O9jKDRF5rWX");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("lfVnCQ1263JvVsVI0Y08LkYLkKTggtn7HqOkDQTzQq4q0UeT57");
        corecontacts.setMiddleName("q6rfAEShVkDcQNlEYnisshzrDcASzKoCW1T2ai7Uvn3u73Hgln");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458211486551l));
        corecontacts.setDateofbirth(new java.sql.Timestamp(1458211486551l));
        corecontacts.setNativeMiddleName("wjQp1SnWKLOZdJILPT0VtzJbfhKaVzIYYS6pg1L61LpeTU54iB");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(40);
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(timezoneRepository.save(timezone));
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("aJWTv8p4ls7UDp4DEnDs27C9jtgEJt5YqarDOWvxqfaAJb7TYl");
        communicationtype.setCommTypeDescription("GOymvzUHOH66eSnm3EbotW92O78ZjQl3NDTmw6IfQQAvX5aePY");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("togyWwELYYx7Ldvp5BH82oqoOjpHBT3DpPtIsCRTroQ2S0GKUh");
        communicationgroup.setCommGroupName("ROzpirQWxRaXHcxT2lDZKw4G50IVIOvV3GLf7R0ja0XXS1SLHv");
        CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        communicationtype.setCommTypeName("3XrhLDA4IuKi0p7rAlta21J9BE62MWIOEj49zvQwHprWL2QZE2");
        communicationtype.setCommTypeDescription("VVdtb9ROQosPOaBviVsyo9BOYXb6oJ9yhO3xsgm4AFXQN0ScYY");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
        map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("QoWbI5UgG8KqAsU2v2O5dqCrVK9xYPCrRmLfQdnGpilNEQZ1jq");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress3("MbgK4eeo5tflCzLnOKPUEqNuL4p1ArOtFHX1c5NcgKIff9U6PS");
        address.setAddress1("O2T8hWKRGWbMn0JRfJYPqLBNVFp1FeCEwlZmW2ZXQoPvSzpHMQ");
        address.setAddress2("Ty3ebqamOlkBEB8zaXGyNGcFlzQla3xFHGrkydKUuqbt82Rakb");
        State state = new State();
        state.setStateName("RHkA3L3HYWrVCfRqWZkkiNszQTJJqAGTFAFMjL1ZU1RB7VDEfT");
        state.setStateCodeChar2("aXPsZTVFOrqWoyjMGmjVj8TLB1tYw8rD");
        state.setStateCapitalLongitude(9);
        Country country = new Country();
        country.setCurrencyName("zvcwJLZIUSBHXIlNlCUc8vjgzVyh9cl2Okj9YYa2DcpzXrTARM");
        country.setCountryName("FRnjoH4dh74biAPJkIpuoz8edn0YzvHX0QXr0QYbio73WxXXP7");
        country.setCapitalLongitude(6);
        country.setCapitalLatitude(3);
        country.setCountryCode1("Fbo");
        country.setIsoNumeric(3);
        country.setCurrencyCode("jwZ");
        country.setCurrencySymbol("g1XbqiQ3bDShurD8rKlYNmtAAipYO9dq");
        country.setCountryCode2("hw0");
        country.setCountryFlag("f00kMNUvkBIZ8xK2tmQ0pCAV3M4ABRAbQPJz9mcUvnVxhE4AIP");
        country.setCapital("YGTm0FG7rnzVu1m9LPbRLBbVdE3TeGBP");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        state.setStateName("tOsOdQ9KYCyGYjB65Z1OfUHNFRhfFPdTcXLn3UuVt5wj3cBGh8");
        state.setStateCodeChar2("WdGCeFnc0Ejbfwnp6EoCQPBfsSGu025y");
        state.setStateCapitalLongitude(11);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("uJQ4oecL3TtkbSYOoyBsFgAX44e6InUC");
        state.setStateCapital("dozDzrznnzc9sccciGQ4IvWhtCvzeRAOocv7js1qFTiYUZo14e");
        state.setStateCode(2);
        state.setStateFlag("eioGhX1qPxE02RO9uZrz6EuzwZnxsrQ683tTkvCGGKLrfJYxFe");
        state.setStateDescription("3vJpv6TNKga6nbfS30jlLeHKpC9q6oftwyLFDDhsVydC26NcH9");
        state.setStateCapitalLatitude(2);
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        City city = new City();
        city.setCityCodeChar2("DiKXL07ZUaCqldCU9p2iLWRKrWGoa9Ib");
        city.setCityCodeChar2("w4c8MLF4wUwdRTB306q1JJNgDOUlBhdZ");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("ctsmAJdlIOgtlFzoLhhilUWkvTsHZm7fkFul7JgEloRnzLPK5W");
        city.setCityCode(1);
        city.setCityFlag("A1AQyOsfDpKIzgvJ3PON87vejhid17oUzSrOFx72JRNGkn2Jk5");
        city.setCityLatitude(6);
        city.setCityLongitude(6);
        city.setCityName("pspoPH0i8ksfZrs6qA8C6ocXVB8kMlBf23xhtVm1g0fwuBQVWv");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = cityRepository.save(city);
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("nXjAXRQY27qlqdL3lW4R8moAofBc8p4F71VcfDFyFxJv9QMf3L");
        addresstype.setAddressTypeDesc("95vt1bwPzk0zoiF1Gmo1MVPWvvze1DqbH7h39Q3vQ0uUkUnAO5");
        addresstype.setAddressType("2RDkOMP4BROereEuuj66mH8YXALZmIOqDyyu9JnQ3m9JOYOI3k");
        AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        address.setAddress3("WJYlfA31ILElyG1XUzrf5rdEOfngunudoS9T5nBcoEmiw8JDDg");
        address.setAddress1("mQoBXx3ZTHw4bd3rxcs8HdYRl1dOVrNozge2ge0oQV4LovNcWp");
        address.setAddress2("LOqXeuAwTnGcKUQvitQgZjej0zysbrG5oVNDgmWs1gvmBzZuJG");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("m3yuaomu5FLkxYZkDeZsfds7qp1poilcK5lsKZKR22Cp8ag6rG");
        address.setLongitude("j8Uy8P4vDNZp9jf5ZRKhJvCYgeAuLZrLMPAI1wUmi20SMNJnB2");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("hOyVHX");
        address.setAddressLabel("ag77ftbjpyM");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey());
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        Login login = new Login();
        login.setServerAuthText("qT1qsQhJIWVWrv3q");
        login.setServerAuthImage("WueNMJwtH9uzpbOurnjCIWugM1Na4RLf");
        user.setUserId(null);
        login.setUser(user);
        login.setLoginId("tMjzSXsKQdxMPlC9pO0cEgEe7oBrYNj9Jv6P66swSgBwrF1zCY");
        login.setIsAuthenticated(true);
        login.setFailedLoginAttempts(9);
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setEntityValidator(entityValidator);
        return login;
    }

    @Test
    public void test1Save() {
        try {
            Login login = createLogin();
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
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
    private TitleRepository<Title> titleRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setServerAuthText("SiVmuQNGqqHVyxus");
            login.setServerAuthImage("Nsr0kRprWFvAeFENn61Hja2B3zC6VXUY");
            login.setLoginId("S1aWKz4Kv3vltJLBfb34iubg8JLDvenGN8P6WM7uQJVlL4oXgE");
            login.setVersionId(1);
            login.setFailedLoginAttempts(9);
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
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateLogin(EntityTestCriteria contraints, Login login) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            login.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            login.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            login.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            loginRepository.save(login);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "loginId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "Bq0MVFFzneF6384BhEEVQVQYRpCE7forkgFtK8FXXb9aroBv8hju1xJhoUZvcTvuusxX4tosNmSWFEkdsM35c7mB4hPOJoso5nzMI47GBNhZBv1hKPJsChJTmJvDhmCxKmJW6SgpQEJa3kHv5PMfwPxTnGlU38zYql19V4eItp9SPrW2fLJssj8q1aopMmu2u3wOq2d6m"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "ycIjIP07sBmgGUghIsWVge7gzGNpCXbAj"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "zKvnyKdiZZBI5v7Dm"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 19));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "isAuthenticated", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Login login = createLogin();
                java.lang.reflect.Field field = login.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(login, null);
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 2:
                        login.setLoginId(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 3:
                        login.setServerAuthImage(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 4:
                        login.setServerAuthText(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 5:
                        login.setFailedLoginAttempts(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 6:
                        break;
                }
            } catch (SpartanIncorrectDataException e) {
                e.printStackTrace();
            } catch (SpartanConstraintViolationException e) {
                e.printStackTrace();
            } catch (SpartanPersistenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
