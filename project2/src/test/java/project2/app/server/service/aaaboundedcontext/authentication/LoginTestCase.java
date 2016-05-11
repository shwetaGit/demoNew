package project2.app.server.service.aaaboundedcontext.authentication;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project2.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project2.app.server.repository.aaaboundedcontext.authentication.LoginRepository;
import project2.app.shared.aaaboundedcontext.authentication.Login;
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
import project2.app.shared.aaaboundedcontext.authentication.User;
import project2.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import project2.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import project2.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import project2.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import project2.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import project2.app.shared.aaaboundedcontext.authentication.PassRecovery;
import project2.app.shared.aaaboundedcontext.authentication.Question;
import project2.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import project2.app.shared.aaaboundedcontext.authentication.UserData;
import project2.app.shared.organizationboundedcontext.contacts.CoreContacts;
import project2.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import project2.app.shared.organizationboundedcontext.contacts.Gender;
import project2.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import project2.app.shared.organizationboundedcontext.contacts.Title;
import project2.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import project2.app.shared.organizationboundedcontext.location.Timezone;
import project2.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import project2.app.shared.organizationboundedcontext.location.Language;
import project2.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import project2.app.shared.organizationboundedcontext.contacts.CommunicationData;
import project2.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import project2.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import project2.app.shared.organizationboundedcontext.contacts.CommunicationType;
import project2.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import project2.app.shared.organizationboundedcontext.location.Address;
import project2.app.server.repository.organizationboundedcontext.location.AddressRepository;
import project2.app.shared.organizationboundedcontext.location.State;
import project2.app.server.repository.organizationboundedcontext.location.StateRepository;
import project2.app.shared.organizationboundedcontext.location.Country;
import project2.app.server.repository.organizationboundedcontext.location.CountryRepository;
import project2.app.shared.organizationboundedcontext.location.City;
import project2.app.server.repository.organizationboundedcontext.location.CityRepository;
import project2.app.shared.organizationboundedcontext.location.AddressType;
import project2.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;

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
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelIcon("H0ksqDDnqlqWqP88DkdUk1PMsg5DMjFkjZzqNDnjm1Y55qj4mg");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            useraccesslevel.setLevelHelp("1q3xmVvFEvzGg8EiFfpD50BLDEFFNvtuIPVVTe8SX9S5hfNNLx");
            useraccesslevel.setLevelDescription("0g9RS5QQgLMFlk3BUxIqge10mAZQy2koSWZZgOpZLlteUC6kjQ");
            useraccesslevel.setLevelName("pTSdpofzuDHx37Opl2kI7xHYIdG8E0dxZv0twcjFhj6E21Oi4Z");
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainIcon("Wo0F5O4UU4yQ0hM1hQM1GtE3WbivUrQAt8yCpChFAWp53Xz55Y");
            useraccessdomain.setDomainDescription("ypG8tJHI1bwDXhmkKagQ1Du9wjhSTHJN6IKLKJPfPlXQnlnWao");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            useraccessdomain.setDomainHelp("dkZ6TEJ0MjVxZtm7Xk9v1pJecdq9C0PNKZYSjDnavdIT72ixAj");
            useraccessdomain.setDomainName("v8LnA5QUYDIUxT6vMZILJP5zsDwQqkVL6oEFQoJwp777bOUwKD");
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setSessionTimeout(962);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(1457448008865l));
            user.setPasswordAlgo("VVu5zDU2sjZXb9q6aAQ9KCusl9AjSxg829BxQCoQj1n9tUrpZQ");
            user.setMultiFactorAuthEnabled(1);
            user.setAllowMultipleLogin(1);
            user.setIsDeleted(1);
            user.setChangePasswordNextLogin(1);
            user.setIsLocked(1);
            user.setGenTempOneTimePassword(1);
            user.setUserAccessCode(57595);
            user.setPasswordExpiryDate(new java.sql.Timestamp(1457448008866l));
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            Question question = new Question();
            question.setQuestionIcon("hweTP56geSlEUHmRmqCKQbRgKwT3IjxVIYSNQCEGV8hazJwk2G");
            question.setQuestionDetails("D");
            question.setLevelid(10);
            question.setQuestion("gL0IkvhucDTpMS9vmzqkjRrdC2rYJTpZbk4q5FRaALmHwEL7Ma");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setUser(user);
            passrecovery.setAnswer("tjWLHEg1KfJDXq9IJaw02rbfXKqkLOVBClfCGZ0h26epbE4qf4");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setOneTimePasswordExpiry(1);
            userdata.setPassword("YdDc5tWEGxwuqmFt8ou4rjez8GwVsYOaOSsfVBzRaywut4n8pP");
            userdata.setOneTimePasswordExpiry(11);
            userdata.setPassword("JDOesPh80tF0gmWe7JakQVHIHxElPFJ30UcTDfHUEhM3gKK6PQ");
            userdata.setUser(user);
            userdata.setOneTimePassword("Li5NhKTU43rBQFkHMOruQhrqJWZcc3nX");
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1457448009183l));
            userdata.setLast5Passwords("5FGPlCIClX4Dy2mzepQwYisAPzhUA13w1zr133CG59ZEpu5xt6");
            user.setUserData(userdata);
            CoreContacts corecontacts = new CoreContacts();
            Gender gender = new Gender();
            gender.setGender("0yE3vSLBEu57hHfKDWEC6l1JgejQ4KfAVFeie2UjoORKXklXjY");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Title title = new Title();
            title.setTitles("mmz6o8CkcA6aBoRI5gBsgzcf7izQ9YDaOgUd3xJyraFqnj7DkD");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setGmtLabel("zRe3bAMcVJeJK5sGFZ4LNWaQHBMb1POHVV1OFe7wC0vbYe1bvc");
            timezone.setCountry("JDuqUtxFMxEN1VmlyZLp83Ws4rx8nXirqG2dyUtU97GzRn8JbD");
            timezone.setUtcdifference(8);
            timezone.setTimeZoneLabel("eTCB85RAUf69ra7h6vLqxwJt8CpzpmO4qf3hvV8zgqpSf1W1DJ");
            timezone.setCities("In3bSe91Yz44jz27ivsOBmtq8SH6mnnsUZisU8OorBtl5Z7yjr");
            Language language = new Language();
            language.setLanguageIcon("ZEAce2OJrOd0YwIZLW5a1UxlEKnO6f332OPB6O7qQEYaFzoRur");
            language.setAlpha4("VZaB");
            language.setLanguageDescription("Vnvc37FB9ZXDpLFQAXSxB00jxIYTIJWWGDCsQ8M4FHn4Q1PzaY");
            language.setAlpha2("OK");
            language.setAlpha3("wC7");
            language.setLanguageType("pKsuwEWlJB842g38hhtFDtb8DCV1hWDb");
            language.setAlpha4parentid(5);
            language.setLanguage("24lpcnLhElBqr5R30oEXQriQpGEHrJfoje1iusSEsiBBVdKAHZ");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setEmailId("bdrCs7hRzfz1bN4G5paPP7e6UHCZ6U1D5ZfaRTu68Zr7o5evbe");
            corecontacts.setNativeMiddleName("R7K9IvGwO7mVrcbfxNTXMXSnX4oPEDmrqkFoypBcgSlguY0l8B");
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setAge(80);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457448009347l));
            corecontacts.setPhoneNumber("N38hjn6pI34xfzbhpRfy");
            corecontacts.setMiddleName("p40z0pbSaKPVBmoM3IeBh9f0lesqD7B1RyNNLDxJijwhWrBLxi");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setLastName("zaoLowO7eLe7dQmaYTFhgwx6QIDnlh35qIlxCilqNtOQPAAC46");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1457448009391l));
            corecontacts.setNativeTitle("NbL2BuGvH8UoJUFrYgZx0tkAdMplCF2aGJZausAdalFvimKFhV");
            corecontacts.setFirstName("jeYQAAKFCYbamvdNQ3ExqMfMtm8CwyCJ9uEFR6rLfErPlhp6jM");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("V0HMGP1w5StQyNWkn0PDDWzf4tq3IrOr76ZK7VJds9Tketisvb");
            corecontacts.setNativeFirstName("HIgBupBWj486zcu4qkaq8wU9wgKuf73K5WrXckzV4gCfnGhNcS");
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("T");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupName("GPrLgtca1Umlf0nsK4s3sbOuGAVslhIf0JpVckKh2aBhJ2lsjO");
            communicationgroup.setCommGroupDescription("clqhpdRZ6m5ZjREtBumnnDlhJ4HOONb1swJh1Gb73iLkVc2bkL");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommTypeDescription("qsvU1L5XCv81HuEQeow7lCB1sZE5f3fH7DWkVDJeKzB5BbUPfY");
            communicationtype.setCommTypeName("ZGezafmD0AXmayLItEiKxXRipPT66izbwDGnx1G6gmnhvSenyn");
            communicationtype.setCommTypeDescription("j2S5FRxkjwUq4sDMYcXXvawtzWUKout371fv012jiByiEY56Fn");
            communicationtype.setCommTypeName("O67qIQEku1N4nnYuJcRCZU0Oa4bLshgn5M90XRXg7ED18QV8Tr");
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("4");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            State state = new State();
            state.setStateCapitalLatitude(2);
            state.setStateCapitalLongitude(4);
            state.setStateFlag("gmOwzqwdibS6EKDecMJqM0EweBOGlVbhny9abbatDybJLIjwYz");
            state.setStateCodeChar2("8LoE93NL4u3q43AWQ8OcWgDX1XKONZre");
            state.setStateCodeChar3("ZpY1X50zCcEGsrPzSaN1G5flF8sB8fLX");
            state.setStateCode(1);
            state.setStateDescription("aHp8ZfrNAgshUjKr902L0mUumO49NX6gTeqF7Kxf7sK97WHkzu");
            state.setStateCapital("ejHBjyKn9BIiZKkfMeibzrNi3ploZTzK0Hw1IIHS9e31sXKWpW");
            state.setStateName("lqVJg0gAweQ5XO5JN5qxDqxWvHzDFJM4pICeQ282OGg2jkks7y");
            Country country = new Country();
            country.setCountryFlag("LDB6lqZHawLV0SwznUyTwByzInN7tw8eHdOiz0AmWNrV6tKb98");
            country.setCountryName("kEndyWgF6CYQSwdROPQwdrhtYqZu6ZAg6KMKXOx7UQFp0aOkFJ");
            country.setCountryCode2("llb");
            country.setCurrencyCode("4v1");
            country.setCapitalLongitude(1);
            country.setCapital("y2if3YPWGnwyDxfdn6PaUEoEbSVFaKhu");
            country.setCountryCode1("3rl");
            country.setCurrencySymbol("cU5iYIritqjiLMaQ6rsG15aF5JbF86N6");
            country.setCurrencyName("9jHhzvMTzlhgWLOnIo7L5rrdjPEQb6n56xaE8H8maQKaogK62O");
            country.setCapitalLatitude(6);
            country.setIsoNumeric(3);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            state.setStateCapitalLatitude(9);
            state.setStateCapitalLongitude(10);
            state.setStateFlag("PPcf0bWrk3RaiZyZCqmCQUrvOCsIW3qRp0dD1yuEG4lUk51mcn");
            state.setStateCodeChar2("cCiZRnqi6tXOVO7yBhvaV0vsDyt2JvCB");
            state.setStateCodeChar3("Kc9DkplEnPGS7Xpu30y1H1Wjy0NJ0hxj");
            state.setStateCode(2);
            state.setStateDescription("j8SiconbIbUKX3sH7i1OcMQOmDHd1vygb8lPjT0xLVN2sOhxtJ");
            state.setStateCapital("rOKjiNTxKBVGTqK2A5hUEYoaRKwE2grd5bNCJLDoVTuLikHh8G");
            state.setStateName("AxihJAZ7DyX9QdcnuOvrMFRfjdPOAp9kCIuPh7LICuHahLtZvZ");
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            City city = new City();
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityCode(2);
            city.setCityDescription("cS5JL6QcKgyRZm0LZ66kTSuXdWjKGsoNtmX5ddyrjHgYl0wOmo");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityCodeChar2("QxPHl49pp1YDPxGkiXyTasn91tgXAw23");
            city.setCityLatitude(7);
            city.setCityName("Egml6UdiwoUHYdsu1k6JxqyCpxndri8gOZV5K3Zv8nNpNKSIY0");
            city.setCityFlag("swjM00PvYwBEqei0rkmKHnuyDVwceHxqbqS00GlTfglOQV4ZaG");
            city.setCityLongitude(3);
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            AddressType addresstype = new AddressType();
            addresstype.setAddressTypeIcon("QrKa757QNkQPqxS5QwHpzDWVPJ6NYVbTTpak2EGJuK7CtVCzmz");
            addresstype.setAddressType("xZnM0FijoEbK1wRZG4UlPATjfBvq1R9yBoURZSzipPfFh03kP3");
            addresstype.setAddressTypeDesc("uOpXdAD2n8WweGVf2Cghw5rjOk85wqOzPNB7uS6f1d0DRq14fv");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress3("ytcRUEEfVp5Qe2fRPFfkjuQFJOk0CVOKSucr97fzzunCNmVWJu");
            address.setAddress2("en14Xyv6ZjQOHY0ft6JRQreNhThhSHXbii8IR789zZA1mQuU6g");
            address.setAddressLabel("eRPJVVhWKyX");
            address.setAddress1("2RrtdRzv2OKAmUPMBGlChwblmQodt0YPJGmrAWsJzAdar8SPC5");
            address.setZipcode("4smEed");
            address.setLongitude("8UUHMTGGpK8liiPWtxBOCxDtCgpRvQnbbwLvpUV6xKgKq5BD7K");
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("QYruqYz1oauQw22aOF6SPh5vgTfVyNSyaeUeCkzY00nnxXoISV");
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey());
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            Login login = new Login();
            user.setUserId(null);
            login.setUser(user);
            login.setIsAuthenticated(true);
            login.setFailedLoginAttempts(6);
            login.setLoginId("3pTuj7RglOSvfwo2RPCgftKzmwH8hIhD0UflzktrbviI64RTFw");
            login.setServerAuthText("ySEfDbtr2KoEPkmB");
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setServerAuthImage("SKTbBSRS1agpF0t2Ju0MhmrXZSA0xLoG");
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
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

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
            login.setVersionId(1);
            login.setFailedLoginAttempts(11);
            login.setLoginId("fH4QlWM0Nh3j99guVDKGhJC9EnTC36zPY7tBgJjRO0dJeAdbTY");
            login.setServerAuthText("hYymU1SmuHN31q3X");
            login.setServerAuthImage("Qi0C3M9u6JtDBl8KexDBAG8kXbr3ST52");
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
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
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
