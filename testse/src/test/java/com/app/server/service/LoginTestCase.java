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
import com.app.shared.contacts.CommunicationData;
import com.app.shared.contacts.CommunicationGroup;
import com.app.server.repository.CommunicationGroupRepository;
import com.app.shared.contacts.CommunicationType;
import com.app.server.repository.CommunicationTypeRepository;
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
            corecontacts.setAge(79);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456739815779l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456739815779l));
            corecontacts.setEmailId("ZQPdf516EFVSXHwDk5SK1QkJirOHmIptasy0hwwuONuTCmVJsB");
            corecontacts.setFirstName("S8I28xay14r72LZ6TBRmVxniFQWEql995BlHzw2zNRkgD098IS");
            Gender gender = new Gender();
            gender.setGender("c771waLkv0U3ZMhFTvLkR1mV0O1AAdPuFjBQCVDmw41SeA9Cc5");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("ch");
            language.setAlpha3("JNz");
            language.setAlpha4("96xm");
            language.setAlpha4parentid(1);
            language.setLanguage("yQI9Ks87Y26kwwTf8RLIQt7lxDOBwvOTdlYVPImd9DDAJ8Fu9Q");
            language.setLanguageDescription("2ffQ0DJKXDfwnu9D5jzVIg8YcGWDrS8bweqcHmjooIaRJwdwzm");
            language.setLanguageIcon("smQnX6I96BFAVZh97sNXlUJj53RhfPOFxzdG6OTChoMYnQNPZu");
            language.setLanguageType("fOBii0ONURZseUU4nsecRqMDSSrWmpTL");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("dHWL4tNqhGChEzKeqEAsuNgwk3P9e4cOJJNeBQqWYlg9lwbJsL");
            timezone.setCountry("Cz2q80eEzbRNd6ptEWKf4FLTms0nHUf8qYM8bRbZMz1QCmRy5z");
            timezone.setGmtLabel("yXaLPSBziNFj57KK9bWqZ9dLCVGdTkYnM5tCbcBTFGKKBi6qQK");
            timezone.setTimeZoneLabel("XFIbKLmdb5SDD9PhcbW4JRc49JbxgdpAXp3P4JsACKRcjDPaee");
            timezone.setUtcdifference(10);
            Title title = new Title();
            title.setTitles("x8ZwVF3sWXQu8FHxxP1WXu8IOftOm1CH3s1q3o8jAWkxBgqgyK");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(27);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1456739815810l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1456739815810l));
            corecontacts.setEmailId("A7dDjudUYlcaXWZf70TdsI0caORQ2fAB2yjL05qII5GOYIv03t");
            corecontacts.setFirstName("wdYnJNe3dwXOIA2HVrT6q6RGkrMX0O6WaYPjid0rsAstvhXuGd");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("XxOGCc2cq3yBsAmQxdSOpyjnR6uPYSQVAUa5hoKJQTIvENBeLN");
            corecontacts.setMiddleName("8k22oZMDWnceLfcYckLQAZfApqWgyIiuRvL1WhYuD8KNOakPD9");
            corecontacts.setNativeFirstName("Rt1xuBFxeyWiGakPdxSHyWwJA5PlI7MRSGcyikD0lfTzvHCfuB");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("iY5upkh8baXFFCAPAy0KIGBwwOtvwzdENihdY1Wb3KOuhw5R6U");
            corecontacts.setNativeMiddleName("sV09Pt4mJLfgeWbVfRtnnyng588LMCW8YjxBxltrdbNbMDxI8C");
            corecontacts.setNativeTitle("cScNMN2XBSaywbZM3bKXlLafppJQgB2IbhlL9Jxt6P76c7zPPa");
            corecontacts.setPhoneNumber("5GlmnADd7EbnbG4Wljvt");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("4");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("1hQDtWPb4z2XSdnYXi54ZY4nTmZRIZmU3OiOKXrwHg9HvJxlPs");
            communicationgroup.setCommGroupName("aQ2YCf5IzIaL7RMQitat8afHzbUsP0OwI3umewQUBMiJrS4aLG");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("2eBILZ7qbIlKOp3LvsObDy0pu8mOlc49W8Gftu9EpsHZioMbzo");
            communicationtype.setCommTypeName("AEAGnxqfieCtZxhOKEUyM530f0SRZ2PxfgJX328QGsUsccpA6W");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("T");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("tybgbE5OgDZob256UlX1ML3SJdS32yKaMUdnBpzSelyiRLVls8");
            address.setAddress2("I4nNHJMPMvvTLiAyufofBtl1xmein6ahDBlYOlpzdDI7Hd1W8f");
            address.setAddress3("KYVfegj1DfAf3dKGYz8vOxfwwAScBgQo3twlwzNtuYOPxfgTq6");
            address.setAddressLabel("gclMfQ3nBYS");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("VKh7mMAp0dlTH1JyM2NR1aMoYVoW4VQbRrluqUOSCOKceyYzrA");
            addresstype.setAddressTypeDesc("2trljDomx2PQ2DUOv5OL6gUXxSyhfJzqcKBj2oImNUtZ2e4HJE");
            addresstype.setAddressTypeIcon("BcucxeEZxiY3ZIqErFSAtRoylCDniOCKS8FoFLbkLWQaQEoPhW");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("zCMU4UPDWbafrbuRITr6IDy2UG5TwrFl");
            city.setCityDescription("Lvy2qlyEgnLJLClimWu8a6VdS6vQleDDXUFnT48iZtwbxlTwew");
            city.setCityFlag("LpaloS6JJX85v60jFmvbSjPq47du6niQ15SFsirb3b9o8Ff6rU");
            city.setCityLatitude(7);
            city.setCityLongitude(4);
            city.setCityName("Cgiiefp45bpkC4x68Yf4TJyiUJ2vE8vXhrNkesLV6SJb6RUQTK");
            Country country = new Country();
            country.setCapital("06oX1JP714QPYqu7s9yfRxISkuddGP0U");
            country.setCapitalLatitude(2);
            country.setCapitalLongitude(9);
            country.setCountryCode1("6jT");
            country.setCountryCode2("zSQ");
            country.setCountryFlag("qjPtp83PTqGFDfjK2iB3lEtJMxTRYo857cpqsugmQPYHVoivbU");
            country.setCountryName("FJGX0Yt5icdvLJI3ky5mgpcrRH02fUkyvcztL4TGg7i8epwTFJ");
            country.setCurrencyCode("26w");
            country.setCurrencyName("iUxhkgkQqW58f0BRqkU0MByNRdykXi3I8bh3tLnjyC5YMYXhXv");
            country.setCurrencySymbol("mL9vnqCSDNa78ND4eLfnnPMfNJXXWTFU");
            country.setIsoNumeric(6);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("IMvAilPeYoMqayRYCLOmZDpFAL3AQZ937s6n6LKOFaY5Gz3waG");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(10);
            state.setStateCode(1);
            state.setStateCodeChar2("2TUCojRUwP1yalIPAEhLIR6mCLyqqwng");
            state.setStateCodeChar3("HpVoDdNQ8HXxo7E2wPyG286UbaVa9zWE");
            state.setStateDescription("ywvjV2O16y2G6GkjG2szD2dAvSAGH9bnMPVITQVg44ruzhYmES");
            state.setStateFlag("Cm5AgDCbi6CgjN4YlSJ4SNQHksFRruVl92Sr8Lsz82a5kSWDWj");
            state.setStateName("EerMBTkSHbvRRwYjkwsqxkfxI4w49NLUXISO1I4bUNqu8mKEQm");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("2mjUmVcPg6jPtu6USuLQxwEiYXdgl2w0");
            city.setCityDescription("ph6c0iTuKf3vjOBUlCKKyqlZpeR1xwfcQ4YIICULVufiG59UVZ");
            city.setCityFlag("EggS8wiglIviE1fiIpVCm6lCjPeVrqRKBXpSbF9OTocYPZm8YN");
            city.setCityLatitude(1);
            city.setCityLongitude(1);
            city.setCityName("e4INJhzjFGXi1ov2o2OOJECJnJ7cnafFKM6SMVDrs6bOTMlRsw");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("Y5R0oQP8UWRJhVVYeFFs16AwbPKJasRuOesKjwlEAD6TVPwguA");
            address.setAddress2("61xLwP5aqpHmAN4Ka3xApLmpWtjsH9RlSLyv7W84Senndk0BpJ");
            address.setAddress3("OlBDJ6b3dERpoLL7eNmtHuQ8Ux0CX9BnmvWlj00PDfdBDnjjFf");
            address.setAddressLabel("6IPNHxgqZm2");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("T8YWaCt97KAgVv1ZAJOiVjmgKAO7RYWjZzwhRusnfl3Lv62NNP");
            address.setLongitude("3TskusmcclKnIEDnLzzd2TF3eEHvrYzSadBQDEMjNgeUFBbwzs");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("Jr3GhQ");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(1456739816314l));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("FX1yy3jtPcJVgBX4MUY5We06NM2fADABaGIuG6bjiabjwcP2q3");
            user.setPasswordExpiryDate(new java.sql.Timestamp(1456739816314l));
            user.setSessionTimeout(3000);
            user.setUserAccessCode(27558);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("2FlOZo69B2g7IX2NCvU8BdCk7dEV1O83aB1njE6b6WXTyeEsfh");
            useraccessdomain.setDomainHelp("NAGNKpo6bo0y1HqrV2solZrBu7OMsP4r6gEHZUMSHForrh10gu");
            useraccessdomain.setDomainIcon("IiYIYF19sV8cpDDgOEOZ4Vk3TBFNN0f8y6c7cdWsqab3efG8v5");
            useraccessdomain.setDomainName("0Hyc9aWBRtY108K7NwuVt23llLTFIxmYx7y8srEOUELC34tk4X");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("bjkkcBZHy0fWPMEYqlp3M0MGpCGGWFkxgF9mzfOOitZgb2eBuD");
            useraccesslevel.setLevelHelp("titWoD6h7kjdvUh5jY112yRYviHCR1fXag7LXebZ5nVgbEnPkQ");
            useraccesslevel.setLevelIcon("hazmaNrcaQIvZE4lZXzsano29x7mcM3m5CzIq1jChZsA4iiLYC");
            useraccesslevel.setLevelName("KMV1qpuRVeWgo6xiYVMPZg2gKT4TcKXHElVrS493L1jJPGQg0N");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(1456739816338l));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("KfzHpfvZ6XGCZFgqN8UOz5sFUghVl0sGJzfw7KAD5Mjho2s19e");
            user.setPasswordExpiryDate(new java.sql.Timestamp(1456739816338l));
            user.setSessionTimeout(1052);
            user.setUserAccessCode(9728);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("wPE7AVJrvxSQl7h3g4WHluHshjuYYiVZKbn44PTvZhDWIot7i9");
            Question question = new Question();
            question.setLevelid(10);
            question.setQuestion("udlBtAwFEyi01Bd2Mt7nds1dnUgvQzEET9XEVtsfDfLL0YOmvT");
            question.setQuestionDetails("U");
            question.setQuestionIcon("EPOjV7u5JUWT4jmjSmqSOky0nwEREHPTyXWLlWI5wrX478RQSj");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("EHxOAcf7fur2PE4pgZDt0H9cNVv7kZx2P27zVG9ah3jbepO4Ll");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
            passrecovery.setUser(user);
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setLast5Passwords("ByWDLHo0yUlDkDikKVxbEaxhLUdUoknquMOVWWdy4TRRbjXij7");
            userdata.setOneTimePassword("QvHlxuIuZFyRP0aF685MzORPsOg3sFhw");
            userdata.setOneTimePasswordExpiry(1);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1456739816580l));
            userdata.setPassword("Cpp17yCobBmulTOpoN62F3zC4NntWfFKRPdicxsQgpYeFXwEVl");
            userdata.setLast5Passwords("Pugz2Q7wn3GMKoXQaPqyZABHWokBQfHgLdF97CpiXRyGUYJx0I");
            userdata.setOneTimePassword("qlPFokVDpVnw9FGaWC0kAFbAvcTgC9Ee");
            userdata.setOneTimePasswordExpiry(9);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1456739816599l));
            userdata.setPassword("wIo94PapB46Dv2pyFGtuacq53sPZQjmo7Dn6L4j9P7pZrVhBeb");
            userdata.setUser(user);
            user.setUserData(userdata);
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(8);
            login.setIsAuthenticated(true);
            login.setLoginId("rHMabNUkfUZpKq9SCyXdOX5woWzQcHPg4EhxQpELyu1PvZQ9x1");
            login.setServerAuthImage("KzOeAjcNSEqVtmERzCTYMc19s1RzCiSf");
            login.setServerAuthText("VxNp8rwR1vrh17Py");
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
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

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
            login.setFailedLoginAttempts(4);
            login.setLoginId("dsGlP4xWNxRfjxleLrbEYYydK0d1AufUlgEh8SxDH2jWgaFHo6");
            login.setServerAuthImage("mj4MB9SWgXB89lxDHP3jGqpISvwXlX65");
            login.setServerAuthText("mnOaYjHEmDAPTcNG");
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
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
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
