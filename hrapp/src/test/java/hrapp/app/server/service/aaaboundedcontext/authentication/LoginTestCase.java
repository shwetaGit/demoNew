package hrapp.app.server.service.aaaboundedcontext.authentication;
import hrapp.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import hrapp.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import hrapp.app.server.repository.aaaboundedcontext.authentication.LoginRepository;
import hrapp.app.shared.aaaboundedcontext.authentication.Login;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import hrapp.app.server.service.RandomValueGenerator;
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
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import hrapp.app.shared.aaaboundedcontext.authentication.User;
import hrapp.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import hrapp.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import hrapp.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import hrapp.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import hrapp.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import hrapp.app.shared.aaaboundedcontext.authentication.PassRecovery;
import hrapp.app.shared.aaaboundedcontext.authentication.Question;
import hrapp.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import hrapp.app.shared.aaaboundedcontext.authentication.UserData;
import hrapp.app.shared.organizationboundedcontext.contacts.CoreContacts;
import hrapp.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import hrapp.app.shared.organizationboundedcontext.contacts.Title;
import hrapp.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import hrapp.app.shared.organizationboundedcontext.location.Timezone;
import hrapp.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import hrapp.app.shared.organizationboundedcontext.location.Language;
import hrapp.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import hrapp.app.shared.organizationboundedcontext.contacts.Gender;
import hrapp.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import hrapp.app.shared.organizationboundedcontext.location.Address;
import hrapp.app.server.repository.organizationboundedcontext.location.AddressRepository;
import hrapp.app.shared.organizationboundedcontext.location.City;
import hrapp.app.server.repository.organizationboundedcontext.location.CityRepository;
import hrapp.app.shared.organizationboundedcontext.location.Country;
import hrapp.app.server.repository.organizationboundedcontext.location.CountryRepository;
import hrapp.app.shared.organizationboundedcontext.location.State;
import hrapp.app.server.repository.organizationboundedcontext.location.StateRepository;
import hrapp.app.shared.organizationboundedcontext.location.AddressType;
import hrapp.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import hrapp.app.shared.organizationboundedcontext.contacts.CommunicationData;
import hrapp.app.shared.organizationboundedcontext.contacts.CommunicationType;
import hrapp.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import hrapp.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import hrapp.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;

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
            String logManagerId = LogManagerFactory.createMultiLogManager(_path + "/");
            LogManager Log = LogManagerFactory.getInstance(logManagerId);
            System.setProperty("LOGGER_ID", logManagerId);
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
        User user = new User();
        user.setAllowMultipleLogin(1);
        user.setIsLocked(1);
        user.setGenTempOneTimePassword(1);
        user.setMultiFactorAuthEnabled(1);
        user.setPasswordExpiryDate(new java.sql.Timestamp(1461653442107l));
        user.setIsDeleted(1);
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainDescription("zlPWz58OK28bB8KtOEwdfwEW63KjiVceHQb155D0g7RWEYfiOc");
        useraccessdomain.setDomainHelp("fpUcGPyeq9NmjmaZ4jgjrTrVCIJPvoxblZf8FHYbplguwvZ3o6");
        useraccessdomain.setDomainName("cKjDHwLYj521an1d9IZhxd14T8MgXIzv7DcyAmy7JPzoyEzPmW");
        useraccessdomain.setDomainIcon("RfC3fI0F2ZbjNI65G71fZiZ8zRU7m1bTimQzUmqutJhzcyLrpM");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelName("d7Zky1RleAqUGRoGqzH0JuUPUDEfRpocCw2mIe73bQVrQtRwhw");
        useraccesslevel.setLevelHelp("tJLlR5ODGdSuH77uCsG7tMBGK1joQ9LjlYSMWWP4GEvkJPD4Oe");
        useraccesslevel.setLevelIcon("kuBGNBsdAFrDEN3qpEOTWwGif7Ff0FWCQHiqAsRcxixyCKh8Vz");
        useraccesslevel.setLevelDescription("rJ5A0g58RFaIMMpWFJMa7RmcrqIPhO0diw6z7cBvWDE4E0h5vX");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setAllowMultipleLogin(1);
        user.setIsLocked(1);
        user.setGenTempOneTimePassword(1);
        user.setMultiFactorAuthEnabled(1);
        user.setPasswordExpiryDate(new java.sql.Timestamp(1461653442128l));
        user.setIsDeleted(1);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setPasswordAlgo("kZ0EMqzlXh3IHLPmK0VM5UFiUQrraWRoah9EQHbO0nupxGsBR8");
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1461653442160l));
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setChangePasswordNextLogin(1);
        user.setSessionTimeout(1983);
        user.setUserAccessCode(11608);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        passrecovery.setAnswer("q61jOr2kdofYmIdmumPfVzTusK6VQePyNrTpIznlKyGLPeqqs7");
        Question question = new Question();
        question.setQuestion("VxoOO1WVndMlQIoWWeOiY9cf85UWoNLZhSzeTuKS2V067TvBEo");
        question.setQuestionDetails("BAsvCdqv3f");
        question.setLevelid(10);
        question.setQuestionIcon("PGl7K4rFvq1lyphjGdq3RxoKe2l6J0QhWl5X6eyTgQkv7lWrcj");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setAnswer("jA9mJdOvxPSXoRnLj0poKhVIxxwqwNT7eXjO1Qe6ZuKOsFT2PP");
        passrecovery.setUser(user);
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePassword("x6K0qhspDWXpgMzACAw4iX3ZJxpgCe42");
        userdata.setLast5Passwords("ag5JgReeXrFWFenOOifO2tGod2s2Mvts5dl0DKMOrcFcKAvfHb");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1461653442357l));
        userdata.setPassword("ogQ4qu19rcXz83YDcnYmYIbOPry7gTmm1oRZY2uXdcTwNyVm8W");
        userdata.setOneTimePasswordExpiry(11);
        userdata.setOneTimePassword("ldmdH5Jd8vZtEhMAwOwCLwWqzcNxz3NL");
        userdata.setLast5Passwords("jP7vPdT27VUO9PGyRMHJwlUg3gNSmixS5DoC6PG5nCYTO9HwvE");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1461653442377l));
        userdata.setPassword("WXgADURFBmuJVT2qDLgAR7ZSAJtpjMjkAJxbvStjkJT7gePuHr");
        userdata.setOneTimePasswordExpiry(4);
        userdata.setUser(user);
        user.setUserData(userdata);
        CoreContacts corecontacts = new CoreContacts();
        Title title = new Title();
        title.setTitles("PsDkmyJM0049F6O9w4lEkXpw2t1MWeSRl6CCs6ldhCcGXGKr9D");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("El1rnbDVjzFhixOINNOyDBepLODD6CLnPcl8UMdRh2Gqy240UO");
        timezone.setTimeZoneLabel("CcFqb9gIwo22MvESvnsLI3ymUPa2XU9OXRzRAIV9qNMPfMFhzQ");
        timezone.setUtcdifference(9);
        timezone.setCountry("SwC4fenCkKlHDToWLOLfdjTfjnQy2XekrS9cDmc860714vtGsH");
        timezone.setCities("vE70e6MtTW3VFXrcAhIdqoxGCrX1HmWMtwqFuFJEtYRUPG5Ue5");
        Language language = new Language();
        language.setAlpha3("J7K");
        language.setLanguage("zOR5UZJNidfLnk4zTuCsLe3AP2gokJdhzt5rkuz7TYsdWe1JZX");
        language.setAlpha4("mf17");
        language.setLanguageDescription("kIuXT8lbfKm7rDrlKM5V5WIHTCxcSmp1XMW49MIFDxsJQbwqFW");
        language.setAlpha2("jo");
        language.setLanguageIcon("YnI2TjBRyk6GROhPgcgBihrbcF3B0NjshgZODUtf9ueltHtRba");
        language.setLanguageType("WOp6XWzYRlGKE25zAsDXlfmLxGLLZ3yC");
        language.setAlpha4parentid(10);
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("QmPbR9kKryZfJud9O7wIc2pn21rVGBU1usj3gY5iBoG2FihvIz");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1461653442547l));
        corecontacts.setMiddleName("buN2NdsX92nojGkJlv86VwthAmKdtUVOQ9GNSLxk0nCAzMC9dp");
        corecontacts.setNativeLastName("b6SiuJHfOu8pvix4cNe7rwnYMpAGKIZvFwColtJOLy0sobgWdF");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(44);
        corecontacts.setEmailId("t3fCCLYPa6iH2Z16MiJYJFd6ypTs3twN3iREeTolpd777WWbGf");
        corecontacts.setNativeTitle("DPZWu7pqK9M4Cfam7KlXjXRPaU6y2tKPYQ8rLI8N8kgVAwr3rK");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1461653442574l));
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setLastName("XkpZ75SPqrXbQp3CAapYxKx5mjp2w6mWrfSXieQHZxcFxqYZ0C");
        corecontacts.setPhoneNumber("h8eWh2uyhitqJqLijuga");
        corecontacts.setFirstName("uSu81YuFBC27FKeiFsw36zfWfASjMe8APd6UnTbGyYZfAJfSP2");
        corecontacts.setNativeMiddleName("QAnKZmvZwTQU6woHk4Uk4DZv5nopb11gWhxmMU4eVL9JYkGrUO");
        corecontacts.setNativeFirstName("u7pLXAwM4pdKp55GOcJt8UB5PrwAaQTdMrycMGnrQQ9dh8kByQ");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setLongitude("VlRfVIrJJ3ATTcyABQ3oJOvypWv0C1EL56JiC3Snacy0Itrqu7");
        address.setLatitude("8TGgPTKfZWQU11wLmJZO1w5ME28wT30O575QR7Yq460yfaqWi6");
        address.setAddressLabel("YoNW1rFMZhX");
        address.setZipcode("FSnWXn");
        City city = new City();
        city.setCityName("qG5frnvdhnRdRZXy00GLPouP38enqVPO8CMfDm6b0qhtQ2bi7f");
        city.setCityLatitude(11);
        city.setCityCodeChar2("7zgMNQGKofz1Dy07XRYh7LE2gxGbcO3W");
        Country country = new Country();
        country.setCapital("16lYId5ZDIi915Td7cpj1WuJ10kv27b3");
        country.setCountryCode2("Ndq");
        country.setCurrencyCode("Bzl");
        country.setIsoNumeric(935);
        country.setCountryFlag("hg3q1AxUSG8DJkWRiVxFY2KcGoZJIRYEtbtN0to9jQAZgdbabM");
        country.setCountryName("hQYdBjphyujDclIp0j2aEDD24y4wYoJczkIExUobYvd4zRtqwX");
        country.setCapitalLatitude(1);
        country.setCurrencySymbol("Y8Fppsl1JtR9Zn9nVvja2l9Gc9v5ZZ2K");
        country.setCapitalLongitude(4);
        country.setCurrencyName("CujRhmyIP0ymcgpvVqliwZtNz8UKKwM4YA9SkMADDWbsAN5Ty6");
        country.setCountryCode1("kDm");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateName("61qD2gK9TOqbb70wMA6HHaLQFPufURCE4WY8LR2p1Ux0yzE4u3");
        state.setStateCapital("CMO9Z23nSbyhBAkcjpv93uSPWR4MSfn6Um1Cg4qTnnRXv9DU4x");
        state.setStateDescription("tRSWxiMbjXoDVeEFr0ewsDr1nE1DO0ewh2haoxk4aibLc7MfdT");
        state.setStateCodeChar3("khJgZbzj9Rfucbvl0ksKJVUmwJpQERNy");
        state.setStateCodeChar2("5e4bnU0LZvnRHPcNNhjh2qUKvVimDsle");
        state.setStateName("eTXaGRdV15XPl0UgKKPWFUGbsI3RYwSwhGGN3kh3Zlqt5UpCWu");
        state.setStateCapital("Y1pcQ6MezCNuWWl8rF4tqum5iHSWvuxyyQ5Skm50SW6TNU0pLt");
        state.setStateDescription("InvSg55zLLTizrEVEaL4mPcRafFrQXlxkDFoFUJfV1QFCKsyNT");
        state.setStateCodeChar3("BVbJuTrK2St4kJLUmKTw1Zy9roYkDCwc");
        state.setStateCodeChar2("E2q6OmlNozQIwTOIdbEPM93kA32CZwyF");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCode(1);
        state.setStateCapitalLatitude(3);
        state.setStateFlag("R2DwEg4XJcLQ6eKJhqWDTDzyC3IOCQSbbA1UNQFwZeD1puSSyy");
        state.setStateCapitalLongitude(4);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityName("l749O7bLcJvWK6w0tYfDClFun2GpG7qKmYUTsYMeWf59VJTV7N");
        city.setCityLatitude(4);
        city.setCityCodeChar2("XMKYUJHfVctkYQSNSeHopqfSGV7FT7tg");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCode(1);
        city.setCityFlag("k3MmgmkioFeRA9eej2J47slTmwNtZwiYahN12VkotRvNUShqAZ");
        city.setCityDescription("xYgK8OUt7tV1Wr6BvQa1lT9phwIqvJKwPVH3ZqO3Ter8rEVaaL");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(9);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("YhbhISCHz31SOlGRdRZiRoIuwzEb4ixtiAPjykSNuJX1qZnAxL");
        addresstype.setAddressType("kcntFvkEWNrMp3s0ibhxfdlaGATvs54sgWbP7HKA5rzwBcII2i");
        addresstype.setAddressTypeDesc("GtKy7yiVRsh0Nmz0FULPvsHBMiDPIdAkwAEimkte58VJeKCYe2");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setLongitude("qxA9gnHQuqEWdHPReaqsCcShWF0tqY7SH97gg6UQzJu27HGIYf");
        address.setLatitude("HuEB3cy8HkExNiGEsC3suNO5qyaEOxjcrCTnbwCHSopclKbYRG");
        address.setAddressLabel("tvMePNgtYPp");
        address.setZipcode("gOegg7");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("T9iXnrCEWRPDpdBdH9F1ADOgOsL4UsMby60CugCXg7aTSLbKjh");
        address.setAddress2("od4La5cMqSvwSBlwWupgDP0SPJ5VjhVwOre8dZcfgj0uErIoya");
        address.setAddress3("Y7GBals9ZG1D1RGiTOnPmfPBwK9Q6iFiGrsG9PWKMnaQDQWQJi");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("7Wybul31T514vbuuSa51DGdirhniz5Yv4W5cjoCj8fwMNfinck");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("jKTZsLX1OmgKexrrnLQgJgypiSqdWC4VGLIIxwuKtIFgC3P3Z8");
        communicationgroup.setCommGroupName("f7uFE9qAjA1UyoBPOUufYAsAL4emDkveDbxekglt0cvuScVafM");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeDescription("L6NjjJIld8kqcZTvnmCrh5C7GaiOEHRXWzfr0VLi1PTp7M6eJe");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeName("OO5xzS2M26skqhWqz2p7PXsHuYpUgESybvi7ymnTxaexiZn6WZ");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("vvsfTQ87fA");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey());
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        Login login = new Login();
        login.setFailedLoginAttempts(7);
        login.setServerAuthImage("ANwEL0PFHbG2acgkhWKLozrbn4dqpjU2");
        login.setServerAuthText("zK95GfhEEStx1jJZ");
        login.setIsAuthenticated(true);
        user.setUserId(null);
        login.setUser(user);
        login.setLoginId("tfOSm1oxlvuN08RTfrM4PZnEXoaEi5AeLjxaD0vc4bEw9lS6aH");
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
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
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

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
            login.setFailedLoginAttempts(7);
            login.setServerAuthImage("QK6kYSWVPBKPumVCDR9TrR9PignjiEpt");
            login.setServerAuthText("HawmGFjDmq3ryUIS");
            login.setVersionId(1);
            login.setLoginId("7I8SwnW0IUdn2TkZFmMmgugfEhJnunsaIAYR2gvdYjVbFksPqA");
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
    public void test6Delete() {
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
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "q7FECAhRQ8CoWRrRnDhem3wGjTsMePh4I3xaTSTiW1xKHXIsdQxYIRgVHr4WlOIKdNTH2wQU88W1N4osB5L1lm6ftLWQl15BGEUF01WYQhwroJoxN4t10ZIA8pypj1Grs0DmiewhOk6q1ZNb1hsIARAmLnvEsjRkFvvMseiLintmUdxgu6yVhuL0qfMVnY33RNwwBkmET"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "j0llRBvUrYfLBn5tRgCa54KqyhtMPSbOR"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "VayOf30Sp4iuKTuFM"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 16));
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
