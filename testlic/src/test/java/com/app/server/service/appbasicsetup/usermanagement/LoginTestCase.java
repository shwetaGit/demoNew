package com.app.server.service.appbasicsetup.usermanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appbasicsetup.usermanagement.LoginRepository;
import com.app.shared.appbasicsetup.usermanagement.Login;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.app.server.service.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.springframework.mock.web.MockServletContext;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.server.pluggable.interfaces.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.organization.contactmanagement.CoreContacts;
import com.app.server.repository.organization.contactmanagement.CoreContactsRepository;
import com.app.shared.organization.contactmanagement.Gender;
import com.app.server.repository.organization.contactmanagement.GenderRepository;
import com.app.shared.organization.locationmanagement.Timezone;
import com.app.server.repository.organization.locationmanagement.TimezoneRepository;
import com.app.shared.organization.locationmanagement.Language;
import com.app.server.repository.organization.locationmanagement.LanguageRepository;
import com.app.shared.organization.contactmanagement.Title;
import com.app.server.repository.organization.contactmanagement.TitleRepository;
import com.app.shared.organization.locationmanagement.Address;
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.organization.locationmanagement.AddressType;
import com.app.server.repository.organization.locationmanagement.AddressTypeRepository;
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.contactmanagement.CommunicationData;
import com.app.shared.organization.contactmanagement.CommunicationType;
import com.app.server.repository.organization.contactmanagement.CommunicationTypeRepository;
import com.app.shared.organization.contactmanagement.CommunicationGroup;
import com.app.server.repository.organization.contactmanagement.CommunicationGroupRepository;
import com.app.shared.appbasicsetup.usermanagement.User;
import com.app.server.repository.appbasicsetup.usermanagement.UserRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessDomain;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessDomainRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import com.app.shared.appbasicsetup.usermanagement.PassRecovery;
import com.app.shared.appbasicsetup.usermanagement.Question;
import com.app.server.repository.appbasicsetup.usermanagement.QuestionRepository;
import com.app.shared.appbasicsetup.usermanagement.UserData;

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

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        MockServletContext mockServletContext = new MockServletContext("file:src/main/webapp");
        try {
            String _path = mockServletContext.getRealPath("/WEB-INF/conf/");
            LogManagerFactory.createLogManager(_path, AppLoggerConstant.LOGGER_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
        runtimeLogInfoHelper.createRuntimeLogUserInfo("customer", "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
        runtimeLogInfoHelper.setRequestHeaderBean(new RequestHeaderBean(new RuntimeLogUserInfoBean("AAAA", "AAAA", request.getRemoteHost(), 0, 0, 0), "", methodCallStack.getRequestId()));
    }

    private Login createLogin(Boolean isSave) throws Exception {
        CoreContacts corecontacts = new CoreContacts();
        Gender gender = new Gender();
        gender.setGender("eUOjeErfAxTSsSKHjUK3JnY0WF7UrolutsJAr4Nj3uSIqYojrh");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCountry("slrEGpERNogply3JqtPlvWNoRmvbudsgTZIDEYbnp9GRqnwX2K");
        timezone.setUtcdifference(3);
        timezone.setGmtLabel("v6QUlrcfthpDUFOWGFv1jCpEUlSuJLRyVyaN54h74YiRqmJtlO");
        timezone.setTimeZoneLabel("tklbvPqnm6FKDjxRUQgAeXaO2p3XezWSjhB3NgVzHFLb2NMzBt");
        timezone.setCities("O9vSL7phH3UMDOB7qQwAZNSfqrxXQi3aFUpO5Xu3t41AUEuL5u");
        Language language = new Language();
        language.setLanguageDescription("KlO7rO9rXTAIUBl3ba09HiYORaef7RnbS8ub08FznS9tQlnxat");
        language.setAlpha4("0Eix");
        language.setAlpha3("72C");
        language.setLanguageIcon("gq5uDpPJzObWkNLRpCATjAeG07KpS4M9xAUFC4mZ9vAA3YrZch");
        language.setLanguageType("vST2eoJ89dhIO0sJrcuIRZA0xUSy3kWU");
        language.setLanguage("TV7lCtFWKcoVxG3KFgRNSEgFtiFebBbj9trxCD9tDG6bstkPP6");
        language.setAlpha4parentid(9);
        language.setAlpha2("6b");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("7wVwqmC2uYjKoVTcEhOkMsti3BDZw9OnpPJOMVt9xWkeJe4Tck");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLastName("GfnTHESmzTvFu8W2WRpOlQj9erW2MFAK0SnAJH7ufToCpaUlRc");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setPhoneNumber("v59J6nnI6jL1Eqwhfl3a");
        corecontacts.setAge(69);
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1463137339765l));
        corecontacts.setMiddleName("P30OtgM3qCZbo19hfjhwNha51cmRPmOdjjI6Yyp9nQozmxKtBU");
        corecontacts.setNativeMiddleName("3E0Fu70Ec3ruLasyxRHITwiLKfn52jktTo9BSRFWq6gI9mZ5cJ");
        corecontacts.setNativeTitle("pGFPNa5kCWzMq9pmZ5dtOyuC8uAj4jN6Y5xH6XAeLJYaouh3pf");
        corecontacts.setLastName("Pwvb76J7HZZ5VYLxNx7sm0GcpzNx6qi56iY3qTKdfsEYc3oE6C");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1463137339765l));
        corecontacts.setFirstName("vEjPDmIqRHl9phL5c2IZX6oojyKZP5bFlhdzq8BHKxKFjTFCw9");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("l1fwNI756s64BgzwKecD42utKdyQoPxTL7EF04hUyRuEDJ8pNt");
        corecontacts.setNativeFirstName("ieiMP9SdgkENSHfJstGsenk16jP7XYRob0JxmM9OMUGrGS8Ek8");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setLongitude("D6uK0WFFVRoJbrApicBWUBWlhwbcVtrX0mRgDZS9GQ90gyjgzz");
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("XREhhqOSnhQ5ItJ1V7jRg1kM4hHP8DXJti1kzchztVShDCsu87");
        addresstype.setAddressType("abtT7mtZ3qPD4an7ymIu11GaoGNuPY0DrzHKgPKEtgCEbeG8Ex");
        addresstype.setAddressTypeDesc("UXyvXmGOOVJ8JdvGswRE2Ci2nqwcLIG6hgD1Y4LyEoAUmv8bGP");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        Country country = new Country();
        country.setCurrencyCode("d1Z");
        country.setCapitalLatitude(2);
        country.setCountryName("VDcpQoh6aizBEzzELKQNRXS12kBsAqiquLImAeWgZA6X8KCttJ");
        country.setCountryCode1("wls");
        country.setCurrencyName("01KoRZRV22FJMzJol6rGfTdAodrYoynUrxa4vxOL0mGT4KlcMU");
        country.setCapital("DW4vsDjME6mFsN6X5zAJXAaNinzuLk2s");
        country.setCurrencySymbol("v8plz76b806gdEBS0m27OASEB06NuceS");
        country.setIsoNumeric(619);
        country.setCapitalLongitude(8);
        country.setCountryFlag("Nl6BDmOfyw94DKNFlVGFa1bziHYUyDY3cQcsxbb6uflIFN2OXx");
        country.setCountryCode2("dh3");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        City city = new City();
        city.setCityCode(1);
        city.setCityCodeChar2("yLfeMbX054bJEin1c6LSuTTJAmuunxx8");
        city.setCityFlag("ysKNHp7IpKr5PY24oNsr0Kg9VpNNRrfFy6o8S91AbzIiuDcmLq");
        city.setCityLongitude(7);
        city.setCityName("RAC4pFJGuNFKXDtTq2Fr1PaEfulT1EVmxPEh6D1IccksnebXu0");
        city.setCityDescription("HfAizwzX7Ubma5zC8Dbgplie6cvNog53cKhNMjb9gZyiHb4jgp");
        State state = new State();
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("ZciISfNlrmrW6AZLlIyY3J84bv2qCPQq79OUZibrr7kYum70OX");
        state.setStateDescription("47b7zKQYib6JNPEbwsCJ8BFetdFtL2lnnB0dDdiQbMb5MfAAg3");
        state.setStateCodeChar2("BRanJM2J6aHVKslZYtJwiS5eNEambcFk");
        state.setStateCapital("gdWTa5IrqYcrDIFMcwQKSMIjF26uujPUlJzlXXzsDXAeCvsqF5");
        state.setStateCodeChar3("ARZWig7iDCcvbOLYOqidXQjWTUk0ka3c");
        state.setStateCapitalLongitude(7);
        state.setStateFlag("Aa3j56mcAOd11HyZssn1J7YcQqtVFHpYyVgrJQjnmTxutrRHoV");
        state.setStateCode(1);
        state.setStateCapitalLatitude(9);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityCode(1);
        city.setCityCodeChar2("PpcQjJXUtgrYldY0kF7AIEjIGE9q2BjH");
        city.setCityFlag("otPcjJMwfoP7lbn3KF2WyYqbxUUCwgIVPFchNv3nVyHVAtJKJs");
        city.setCityLongitude(3);
        city.setCityName("gOFAr1vxGv2UHQ8dEkDtspTpfUZpG1adwNEOtBVh6wL9mAgobM");
        city.setCityDescription("ILrUoDzm5Xq2VSnJdaiD2JXq8TbbfFDTdny3MbxldeIrBadO5v");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLatitude(9);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setLongitude("kLosubNBZ4oMiAvu0qlo0d0VVpDyoevGhPyoTMytVD60QzK7QK");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("7ureO20WT67r0pzJG2gm7kN49JFxUBtxllhqDyl0YEHx9eWH8W");
        address.setAddress2("J3WkASSYPD6wZEnzCQMfAIVHg6gXIVdCsKrTOrj2a3aC8tbNmY");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("jNCpPp8qNbPtAKrayfS9NgYW2s35N05e77rX0l8Qs9ccptyBq3");
        address.setAddressLabel("ONOHlrN3w9U");
        address.setLatitude("T3sLPRoBvK6yInvYruFI403LoO1ibGdViLtDjdT50DxJPwEEq8");
        address.setZipcode("9cAmpm");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("C3tlC8RIhgDp7mh2rqiTGua08k57ZbnRcjuN5c3YxacnhDvC6P");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("KIySig931bPIsxiuejuco6Dcy2yywBShXtuv7VQqRs5w50J3Qg");
        communicationgroup.setCommGroupName("Aj87iuH9PVZunAJ741hIO7kmKNeSzDBlwTyWYTcBxC3B3hmSWG");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeName("s7MXhiD5ZqE5ms4OC8qL4tKBmRvGfRcoczigUGL5xOU1crqu54");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("Hr3svYXVky5F5I74Z94nfplCgMK7O5T0EsQ7vBDndNLLbxPotz");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("eCStP54yb3");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        User user = new User();
        user.setSessionTimeout(967);
        user.setPasswordExpiryDate(new java.sql.Timestamp(1463137340184l));
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainName("LCEXRAEQukf7t2KKUBMsSM4DrnkUePw4AVOGPnyesHaPun7OOm");
        useraccessdomain.setDomainHelp("c5dk09EdRMN7g5GEvLLBArVxZXFPbe9PnES0h3PhDXUfpcvmtw");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainIcon("mPgviFrN8Fn19A3ETw001SdUXy4B0i8fKto295tvpWoFDCeHYj");
        useraccessdomain.setDomainDescription("3JQoXqKVZYUsBhP5UEQrCmSU9yBNLnXWVSdPRlpBUqGHPv1WPF");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("p1TgbqKLQBj2U9WbARWnXDWZNvCFiAUS81mfnJd8Og27Xoyt6O");
        useraccesslevel.setLevelName("24RzANyCG5CXFQA7xy3oDpioGMCSEWr53Un0gjuizxbZog22Hp");
        useraccesslevel.setLevelIcon("DYXYqJmpxHBWMA4tM1JOHGuJavaIPsTuolzUzKxrkCu1ETYFHp");
        useraccesslevel.setLevelDescription("Eh5QMMELOXQjjeUa10allEh0FVu2StmhxmTC74dKTOSV9DeC87");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setSessionTimeout(2571);
        user.setPasswordExpiryDate(new java.sql.Timestamp(1463137340199l));
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setChangePasswordNextLogin(1);
        user.setIsLocked(1);
        user.setUserAccessCode(48432);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setAllowMultipleLogin(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1463137340258l));
        user.setIsDeleted(1);
        user.setGenTempOneTimePassword(1);
        user.setPasswordAlgo("GomLOfkbw3vfGFKOfQBUIjD2pe8NaOfx0hYKZUlhO8PKzu0qS4");
        user.setMultiFactorAuthEnabled(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestionDetails("fw0tENArS3");
        question.setLevelid(8);
        question.setQuestionIcon("lLQB7SU2f827yqacrxMekPjg7ORRbkzZjcyiKmjqMg9AsbQl23");
        question.setQuestion("IrE7fImpdizd8zMlsLOBrV5XTj3PrZ8L4UQz6gVmWZc6CiGpQi");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
        passrecovery.setUser(user);
        passrecovery.setAnswer("IvMbhGWesOu256BchmFqEn1Uvl5O1VdnpWyOuR1uqyPNR4KLix");
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePasswordExpiry(1);
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1463137340420l));
        userdata.setLast5Passwords("IuIyOL9uBBBKTEKm61tFbIIwufk4GZovnTt7vXT4dyINOBRbfu");
        userdata.setOneTimePasswordExpiry(3);
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1463137340437l));
        userdata.setLast5Passwords("zC4z32IyuRrfmaFsgdMHGtRPiy8LdKB32clndUq6roBpnNsbfG");
        userdata.setUser(user);
        userdata.setPassword("lh1NCWJEnJobP5GFcrl4mfDaRdMWB6QBeoBpsL9CRpl09DVWZa");
        userdata.setOneTimePassword("iE0lIr6pmjzMLzqdXMr5qzN0gDPU902k");
        user.setUserData(userdata);
        Login login = new Login();
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setIsAuthenticated(true);
        login.setLoginId("B90FaSm4wMPj5bUcgKZB8eonYKAeVt6xQv6gUsJQq9u5qbvXur");
        user.setUserId(null);
        login.setUser(user);
        login.setServerAuthText("7VrJq09UQFC4TJw9");
        login.setServerAuthImage("yM2C5aYqQm43VWRaG7nkKc0ldL6QG8bP");
        login.setFailedLoginAttempts(1);
        login.setEntityValidator(entityValidator);
        return login;
    }

    @Test
    public void test1Save() {
        try {
            Login login = createLogin(true);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

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
            login.setLoginId("KGSAaVQouWiNOVaVExqA4M1XGpDVneL9iyzEYLnLPdyVyygh9a");
            login.setServerAuthText("TGnrRm3YkgG86v8S");
            login.setServerAuthImage("1QSpMYc70k4km1SlzXqgtzVavyVtJkTJ");
            login.setFailedLoginAttempts(1);
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
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
    public void test6Delete() {
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
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateLogin(EntityTestCriteria contraints, Login login) throws Exception {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "p2wC44uKWwt5X6WmC63PV7iKIj0crwaLvHbjGjQS9rh2Tmieo3LZRgfSLV6mMz1vPzefWh1KuBRkcSNn8Ijz6RAvEwLBexjc08FRaFIIRq7gXv5oIz9md5oKHrAmGPOkxtCDX8Sy6pnrmKTQvHvdKdIt7M0a5qqdMgtfKTEeqwupiLt1Sqd2AnXYKVBmNLuMXrk7hFc29"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "p4vqJEwUsnoGpbSYTfzl8dzlKxs9UbvUP"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "emW5hIEMFASr82lSU"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 18));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "isAuthenticated", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Login login = createLogin(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = login.getClass().getDeclaredField(contraints.getFieldName());
                }
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
