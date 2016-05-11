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
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import com.app.shared.organizationboundedcontext.location.Language;
import com.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.app.shared.organizationboundedcontext.contacts.Gender;
import com.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.app.shared.organizationboundedcontext.contacts.Title;
import com.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.app.shared.organizationboundedcontext.location.Timezone;
import com.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
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

    private Login createLogin(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        CoreContacts corecontacts = new CoreContacts();
        Language language = new Language();
        language.setAlpha3("x7m");
        language.setAlpha4("l3Av");
        language.setLanguage("QIKxLQpyqTsehthG7DJPY7hDHvyj3CrHFwbXvUsGmvfDI1jLTp");
        language.setLanguageDescription("05sxARn8jswzQAdTJTc53d4x3Si56Kg73dXN7xjfi5ul7JjNzH");
        language.setAlpha4parentid(6);
        language.setLanguageType("Yvopda7DnIKar5lPRxIlqZzrnygZniB0");
        language.setLanguageIcon("WEzNi94BG6fLDuJzQyBmqRbayaW9pvo0hD8saahwHjNwuPyJ5G");
        language.setAlpha2("6t");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
        }
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("e493EXdDsRYGw7qUntz8DAhp0Uah6cVYtJuIJGoFNNObNvfw8A");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
        }
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        Title title = new Title();
        title.setTitles("PdtWZM62R7n7Bq3q1jk6hBoXpD2q7HDFKFiUoI3PLTFz1lLBam");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
        }
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Timezone timezone = new Timezone();
        timezone.setUtcdifference(3);
        timezone.setCountry("vHfn8kQMGZDbBC0kQgXSoILMDMjOIGtGiDZ2B4JuK8bvvwatA7");
        timezone.setCities("I4QFf19zHy1jHt8UekJXGmeyYl7jfa9Urb635nrg0APy5uHvsg");
        timezone.setGmtLabel("DS0imlOgHWeDGv0kfguScFUKRDGLEKhfkKTMuVdXW28cP9xgVv");
        timezone.setTimeZoneLabel("LidALIVDQ0kwJRLeAmmDXmy92TgASFPnOUq8yjxRnfFmbPeOux");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(38);
        corecontacts.setNativeMiddleName("LaIswPjmPTQ5HrYUqDpYC4Oam8X5QzIrDgj5pKzkr7owAQWFAu");
        corecontacts.setPhoneNumber("9JLZCIYm71huiB8653pJ");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1458541454113l));
        corecontacts.setLastName("HWA27Sz3xRhapEYUpZPbMjUWdjcxmZaRZXq3FGOm3Fme7LHsm5");
        corecontacts.setEmailId("Ru37FckdQZ8p31gSihdtBGsiiYtRao3eWX9X1tGynX6sqtux8g");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeTitle("s3BvhwctJNu1ZMT9mRSf2ltZAHIZjBip5XOs7RgPW6q9ntwhx1");
        corecontacts.setNativeFirstName("IZpazip0iQUBbxLD8YSAZB567e0ofmjNObCKZMlcFeA4M6gRfo");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458541454159l));
        corecontacts.setNativeLastName("hICm8i7XpLnqmjQy2DDTQSuAN61dqICe4mTfG5DNg81xm3XAf3");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setMiddleName("3zbggIYSEfGg98dofOJJelm3LmCGTKSnM6Jo7Sh8Yqdz9nn8Nm");
        corecontacts.setFirstName("bbHq7MY0mnTrLARs8QyFl1c9YGDJx8TcjxO8AGJUyBxoaH9rPt");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("0YzBKRZODqwvFKd2CIsrbGbeBimNguQHjMfwnyQWdn4xfiW1MI");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("fzZgJD12YEas6MQJs7RhdNeu0FqrNOORJiIOxp2CBaPuL7xUty");
        communicationgroup.setCommGroupName("UuvruDvE82Uj24dPWH6O9tCU8Z2Sp53r6oWrWRlKQMiUB7Qwju");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        }
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        communicationtype.setCommTypeName("8la3hl7qqOK1ooLv2J7keIKpAFVN92CEWPqyhjZ69FomonUKkQ");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("aPMkXpBmTys1wAOw7OBSeE2lKyyRLacVZM6fkS86iHJkYSS7ya");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
        }
        map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setLongitude("Hubogy078bI70gQVQsC1LcYPkDQTa4fb3rFQoIyYqJJBLnUt9t");
        Country country = new Country();
        country.setCurrencySymbol("8J2QMa2dXj4qundhzM7pwCecMQScYqaB");
        country.setCurrencyName("fGPlMM1HGJIHQ37RNZYhZoX3WYGRuOWYV97lSGugKz4H4cOlXP");
        country.setCapitalLongitude(11);
        country.setCountryCode1("xdn");
        country.setCapitalLatitude(4);
        country.setIsoNumeric(1);
        country.setCountryCode2("5o0");
        country.setCountryFlag("PgcBzkHg5VSgW1FIBiGKkkN2cmThbqtgPhyUmulRJGbpPmDLzo");
        country.setCountryName("IQXN24oC5h0xE0vda04IWDKqlbjho3p69hvpYTzXp3pwBWxjVz");
        country.setCapital("OLdIsmgLzOL9AbQ2rjh4kt1HH2Yszlqn");
        country.setCurrencyCode("774");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
        }
        map.put("CountryPrimaryKey", country._getPrimarykey());
        State state = new State();
        state.setStateCapitalLatitude(4);
        state.setStateCodeChar3("5Xe3RCrMpMgNTJpU0AoVKFV2VHZ7zLjX");
        state.setStateDescription("j3pfroedVkMzpXOMLTameVTTGaK3h5XK19xvcYsaV1jfmwSz8O");
        state.setStateCode(1);
        state.setStateCodeChar2("Vl60Ggc6l8Ab9uKgWPU3NA1ky8Yt55ir");
        state.setStateName("fuYw7Q8pR9p0kdQjgSLa4mmfx9VtgJilIm2ePUFGKDOLmkoIuU");
        state.setStateCapital("NEuDMpaKPhkE2BVvspO22yQxqlKcaXlxGbIy8SDbAtemiGZ5uy");
        state.setStateFlag("EWmHewbXbVVj3BUAuZrFpsdAKmZ2w922qtM6vFFjv8wkOQXSsC");
        state.setStateCapitalLongitude(1);
        state.setStateCapitalLatitude(10);
        state.setStateCodeChar3("apLf85KxJzgfwNFeBXVcH0nOmI3L2PPW");
        state.setStateDescription("VhvpyENNWdaLIcxgZWOTjkL8CXMt4aoouwzw2EWzDu1Tm4XM5e");
        state.setStateCode(2);
        state.setStateCodeChar2("JWmT5DXbzSP3t1CeeOS3tgEI1xxhCOXb");
        state.setStateName("UXxfsBqQ5eebsK0Kdkhxoa63Q7nAqgA2wLUeNeeSVPdYfpKYYm");
        state.setStateCapital("E5ekn7Gbv5p96yt7R5J9YmTDVmMDgyvr9Ky5CtqujFUPAfRqkS");
        state.setStateFlag("iWh4ND6Ib5VUL5q8Ylz3XRGSCm3xNWwGkBIoK958n3MaKovZZh");
        state.setStateCapitalLongitude(6);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
        }
        map.put("StatePrimaryKey", state._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("Tv3Fcy1ee5HpGuPS3XaHMvBEY5ecSxWo5AGONnGI0BujrY18NS");
        addresstype.setAddressType("pE5Tz2Rzu1jLh6Wkr0fCWPEnf9mlSqwdCUGCTu2cwOquEQTHH1");
        addresstype.setAddressTypeIcon("ylLo1bPqxmDvjvK8hlXbbwLlzqINFxUPk3hlClJVsoAtIY96W6");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
        }
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        City city = new City();
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLatitude(2);
        city.setCityFlag("lHTFmp4lYizWIDhr5byfGKR0MNk5VoBy3IY0PcEXGvSo92xW0z");
        city.setCityDescription("2EAhDBAy5KbB6x8cNtCkl3rDrVgXoEiZXcdCAWcCzSUqbmF3r0");
        city.setCityCodeChar2("P02sCtsaq2R2u0ghjufxLSlCCCO8Q5Dn");
        city.setCityName("XgZQvrmZRP5DfZKRKn4DNFOAdMqtxV6K3C1R6i9kZoQgbBPQEh");
        city.setCityLongitude(10);
        city.setCityCode(3);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
        }
        map.put("CityPrimaryKey", city._getPrimarykey());
        address.setLongitude("sL4qULQoHDMKwPLLq8jp78zwHlTFCEUI6tlBPXJWxhk1DE0Ymy");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("JXovCb8BNkHjXhxZVtbHrd45KK5QvY8OdBbQiK7ENOl06kDNOH");
        address.setAddress3("DKxckbC2rrryUGnauvBmJyUKjMqu5SPuuQN3nZ7YnFV0Lwx6TR");
        address.setAddressLabel("wPa9qilcYub");
        address.setZipcode("s3ennX");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("E5WNBGlrBkTlbrBMmOc3AHN27q4m4PjJ1uw5fK5cuKLnPfZHA9");
        address.setLatitude("iydwfcfCnKciUXdXxgFaKD3iSy1w0PFHUEnAj3ge59MbL5iIFi");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        User user = new User();
        user.setAllowMultipleLogin(1);
        user.setChangePasswordNextLogin(1);
        user.setMultiFactorAuthEnabled(1);
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainHelp("PyxDQgc7Osz9qse5jpOy32X22xKfNX8w2HiUrRbFsxfR6yo8Z4");
        useraccessdomain.setDomainIcon("Z02qKpOmQrvu2eMKaOB5uRpNuf6jhkKIuZzohnIwT9mGSwA07h");
        useraccessdomain.setDomainDescription("bPEDtqkUAmU2DVVuwxNplh7R48bOsDz0AyLbOa3bEAX0zzY82C");
        useraccessdomain.setDomainName("ryEqaQQzMAITE1LiceeMB6tzSsg2jksmig7a339KOjBOkGq07Q");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
        }
        map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelIcon("bk1684qjagsXMKYIOuO4r09lhPWM7zO1yVfKRCRbpqtLQAiKeA");
        useraccesslevel.setLevelHelp("GE2fB9Tkzaxvc5pfqsjNNicAqZCAycFwfEIxb67zRujvcGm2yp");
        useraccesslevel.setLevelDescription("JunODWUusBzrb8kZbHQZb3NUnmvDIJg718F5EHrXYfPboK361A");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("BLcEoWh28b4a6FIJurhpA55A3tiVEbTDhelAibRG4OCbkFC0MB");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
        }
        map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        user.setAllowMultipleLogin(1);
        user.setChangePasswordNextLogin(1);
        user.setMultiFactorAuthEnabled(1);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setIsDeleted(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setGenTempOneTimePassword(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1458541454752l));
        user.setSessionTimeout(1598);
        user.setPasswordExpiryDate(new java.sql.Timestamp(1458541454752l));
        user.setUserAccessCode(6);
        user.setPasswordAlgo("oN74Och4RuzjCZunYfGMBVEVO42dnU3HzhHVewuRLIRHuyQg3M");
        user.setIsLocked(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        passrecovery.setAnswer("Qpb66XEFQIBvSVl3eLnHIFmPzsxa8ptQ4oSNcwF9AWgW5RKTnd");
        Question question = new Question();
        question.setQuestionIcon("Ux1NweoHyOtaQU5luk7TgZuqVV6ksxJTWq61GOHIaeAlO6DdCn");
        question.setQuestionDetails("");
        question.setQuestion("Hnd3KsDSRIyd0S1E43UfJ4rbuCn7JTqG3jA4mlK2NtIlvTyKAd");
        question.setLevelid(1);
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
        }
        map.put("QuestionPrimaryKey", question._getPrimarykey());
        passrecovery.setAnswer("BI6ySbJdy4r8YsY5bxr7CDm7G801OtxGOb9bxw5VeUg1nG2hIv");
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
        passrecovery.setUser(user);
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePasswordExpiry(2);
        userdata.setPassword("WDUyU7J7dSh2zhtZKLXMtFuS6g602DwgpNuw3WMECuTZM5WJEW");
        userdata.setOneTimePassword("SkuErcYkOeehWNhZPJWrJjEBrwMsnNEW");
        userdata.setLast5Passwords("VlIPddqFIoqFCh3fRgsyujMMNUr2aQdRgi6xKtytQGYFhAnaF5");
        userdata.setOneTimePasswordExpiry(5);
        userdata.setPassword("3PAYnzl4oL7YdNAAPzyioRAPTCsG0gohpEqNT4QqrLLhxBadSQ");
        userdata.setOneTimePassword("ZUpLlAaih7OQ4jJlQq3fTBZRgKTgscGL");
        userdata.setLast5Passwords("sKB6sX46wGxyzh53g7fygOa9mVYCDWi2ExVhW72hAAXzuy4Npc");
        userdata.setUser(user);
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1458541454985l));
        user.setUserData(userdata);
        Login login = new Login();
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setFailedLoginAttempts(4);
        login.setServerAuthText("ufukTDWH0A4cHxbQ");
        login.setLoginId("kNKd1VypKueNacFekHDw8yfiTPhLgJraanjsYxoNVBkm1isTTM");
        login.setIsAuthenticated(true);
        login.setServerAuthImage("XgXYSsFRvU2WtHAaeM5WcCLNQlBeWP8z");
        user.setUserId(null);
        login.setUser(user);
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
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

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
            login.setVersionId(1);
            login.setFailedLoginAttempts(8);
            login.setServerAuthText("MKpZRziwSCCjFi1F");
            login.setLoginId("5rTxa9NwkCSlBHTPSlvBVZLjZRXqad7sSHvRS4p8wHEMNyqKQE");
            login.setServerAuthImage("rtPhrxLQnmJ75WalpebvnK9negs7tRic");
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
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "y4VQSnQwYEduRZhSGdc2EwRpiKYsrfEH8Q1yVoM4oyqLLmPbc9ayQ4EExdUQMVcGPS4qaaNajOl6exLhxTn8hBgJCPleGpGVgFXfCdxPRyENJSUFkPORyoJBhnIaAx46QPfU7DNSc3S4CWmVCTOcQjtZuaGi6oy0pzbNXDt4dXLx1hNIoWcB3I27ce94MBIgpWXh3OC6m"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "ckJtnMbS9eB9rPeu5TOZAa2Zc1q5ZI78h"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "dL8H05svrop6cDJAV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 13));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "isAuthenticated", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Login login = createLogin(false);
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
