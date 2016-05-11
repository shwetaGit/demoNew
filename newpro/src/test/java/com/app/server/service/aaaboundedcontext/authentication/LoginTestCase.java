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
import com.app.shared.organizationboundedcontext.contacts.Title;
import com.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.app.shared.organizationboundedcontext.location.Language;
import com.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.app.shared.organizationboundedcontext.contacts.Gender;
import com.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.app.shared.organizationboundedcontext.location.Timezone;
import com.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
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
            user.setUserAccessCode(48475);
            user.setSessionTimeout(1899);
            user.setGenTempOneTimePassword(1);
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            useraccesslevel.setLevelHelp("AUI1IkU4eKWfNcsHD1bfQ0QSEbs3jorpu59Y1hVdD4JB2aczp5");
            useraccesslevel.setLevelDescription("oABgEUYJHNxW9Gaxz3hWmMVyCeFsECNN4AiWa6mSnKPzaSxGVO");
            useraccesslevel.setLevelIcon("dIHU5EXq0n22iVsRvE8htDnL7tSifKM1bL4fJoZtn6Co6middk");
            useraccesslevel.setLevelName("xsxzIdf1BEAaf4bflb1jcDFpkiqlybSZQhW8xVBjjMtN4FDtFT");
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainHelp("p0DeiSUf5kAAv4M1AJfFvTuOs2LLbyv7ji8QnxJbVGSUoaR42o");
            useraccessdomain.setDomainIcon("uX5Y1QjmKgbrHq4sKDXVnVgxttArpw1hgqb0nNXVSNuN8Esqbj");
            useraccessdomain.setDomainDescription("jrycuZ2jPavdgKRcVI6G1BWOSpQNwmp3jmEQuZ4c9qVsGKAUvn");
            useraccessdomain.setDomainName("86OHlahNdOkeX4sqo1A7K5H8g2Wp4FKkA3NiQzDj6s7deFqA7h");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            user.setUserAccessCode(59403);
            user.setSessionTimeout(510);
            user.setGenTempOneTimePassword(1);
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setPasswordAlgo("401kh4sVz63GMnTRcv3QHtOelsjdYHnsN48MdY0vlobObqP173");
            user.setMultiFactorAuthEnabled(1);
            user.setIsDeleted(1);
            user.setChangePasswordNextLogin(1);
            user.setIsLocked(1);
            user.setAllowMultipleLogin(1);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setLastPasswordChangeDate(new java.sql.Timestamp(1457938621744l));
            user.setPasswordExpiryDate(new java.sql.Timestamp(1457938621744l));
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            Question question = new Question();
            question.setQuestion("3lKY5CjpzThiQYXzN6CVANWMZtCiafXUpHeiKVUIkiHZmYOGlv");
            question.setQuestionDetails("u");
            question.setLevelid(1);
            question.setQuestionIcon("588QfKeGy6EyLbZPvga0iXAX2d3Nl0CoJnwqrvqyUw65leEe3z");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
            passrecovery.setUser(user);
            passrecovery.setAnswer("OFjM5hJJ3AqGTD1zKiFajWWMc50HcFXN8TUe75DKB21UanYi9j");
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setLast5Passwords("6XIT4cpFNjHmnz4UsThgNc6EDGP0YYOgGPlxAMbBUT3lfB9Ool");
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1457938621943l));
            userdata.setLast5Passwords("HbclQDr5wVLhqPd3Y1sUhTW2SxRwIpfanI05yzeBVSWlzLEPbD");
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1457938621963l));
            userdata.setUser(user);
            userdata.setOneTimePassword("x82QKldFykisjrDTz2SGuxWof8yQRVy3");
            userdata.setPassword("5wEzTD9J0jk6oiJPBKiLo4qlqnXmw2yq1iGlYlMlxTkvl78IP9");
            userdata.setOneTimePasswordExpiry(1);
            user.setUserData(userdata);
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457938622055l));
            corecontacts.setNativeFirstName("9Xyynod6BwYD2wDXqq8xocoEfSxuKPYcc4UA6m2LAnYtchG8No");
            corecontacts.setNativeMiddleName("VdGdAFoLs6ycdVPrmT4rGfJFNQXLhmBdTexoRwXtvTJXjFkVWI");
            corecontacts.setEmailId("lM3zMQSt1JGOAjacfjBrWbiyC1VpXjMLVndx5E7Ot0djTFsvx6");
            corecontacts.setLastName("pjU4EzFGH4LqGtn0H1gEyhZEVLFUffHdobM9woCdhqktbd0dVc");
            corecontacts.setFirstName("Oajd56fM7z1c1klJdgD2UOFFmJHqDWg4TQSxA5dy7dLipH3Crc");
            Title title = new Title();
            title.setTitles("eO2cVFc36OcIvZ2TGxGfZqYTY6vPvCgHl84TeOeoOrtEVyNzDk");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            Language language = new Language();
            language.setLanguageType("DS3GMcuSu6pDv1YI5Tj6rQsRncdchqqd");
            language.setLanguageDescription("O2DcVRBQnneh8b816TLuHuhB5ZipJOA7o4XVREABwtpQJo86He");
            language.setLanguageIcon("qUGs4OS4EBgociv5poVs5VqKBhcyWfFgp1sOlwwpNF6pIezACj");
            language.setAlpha3("rSp");
            language.setLanguage("kgaCHgdM4oijm7Lu9Whb3uQqNOKn9Xcp6dgyhMvNTp94mF155G");
            language.setAlpha4("1za2");
            language.setAlpha4parentid(2);
            language.setAlpha2("7x");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Gender gender = new Gender();
            gender.setGender("3ntHW38aVVjCgfRHAzRly5odi6x2pcMVe5tdhyFiz36q8Accv9");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setGmtLabel("ERZaD6DR95zrPaabxFkmJFxfBgdJqXgKNYpm5AgRmQUtKRkwg9");
            timezone.setUtcdifference(8);
            timezone.setCities("xxmjl1Qe0t5iNUVd3U0cMRvl6orO7lMKjb1lAh84A26RGsKBvJ");
            timezone.setCountry("6ixnqWgmkTvjBjnkJ4Nslk2EKzC5P6GBeweoGYLJSDDAkhMPIz");
            timezone.setTimeZoneLabel("SCocqHJwJo1L0RSbJD0ZybJuwd2L9UCYuPsmHsjgyE4HKA2N8k");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457938622074l));
            corecontacts.setNativeFirstName("dq5T8iZA99yZV4PvmrOH7Q4T5TI2a8HTXFHCNqIrUrJGXbnINz");
            corecontacts.setNativeMiddleName("z4opJE7ku7zoJUfkABaPGgATKqhV48ZEysKSyxPn9L9FIpxR2q");
            corecontacts.setEmailId("98EcLuP49P4mS2DNNsoFUO4DhjNjJQwXRGyrIFtkoLQCW6yb3d");
            corecontacts.setLastName("ED8Kt9MwKZgbd08LlqXc0XEtlOJ8IsBl4cc07I3NPi4azNLfgy");
            corecontacts.setFirstName("0uwuHmo1qinJDWdOPOgPg5cmiOqmVfSkrtkHB1G7z7B9mR8Fg0");
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("z1HrOhDl1plRBFpZMMv2LjsWfD6kxS58wQhSK60iWHxb6ypN7U");
            corecontacts.setPhoneNumber("cKUCqpDqu4ceO7tjw2yC");
            corecontacts.setNativeTitle("hU1nPNltdq9E7HrYJXOmhtWRVZ2j3wFZT3KwoJUnoCP0SV5DB0");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setAge(64);
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setMiddleName("umIwlSeXnhrNEBIZrkFNyB3FCBYYDIX88rRTFCWfOAPEUkmc8y");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1457938622203l));
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress2("YzVnBwMdrxmrlQRbdiBc2WuORzVCSXhqlLZ9eQvuhHjgXTEvhN");
            State state = new State();
            state.setStateCodeChar3("vzrCMxEixmUkxvJLqrL7E3Z7Ae1M5qQH");
            state.setStateDescription("ebWffUxwYB850PpceWA02MTNmJVzlGTZgdEHNh1Bns6BOu202K");
            state.setStateCapital("ow22ihYiG5OpnS5M3Uj2HNUmnGZWw0UyKD9O6IQIFGB5QF3tme");
            state.setStateCode(1);
            state.setStateCodeChar2("QYQnWWrtmo5OQgLzVcEMpjOt0DyXDze1");
            Country country = new Country();
            country.setCurrencyCode("XNB");
            country.setCountryFlag("DJfK8xl2qEgjJrpguAZY7pHHb7bH5YtqZpwo57QKkbvEEvIj0v");
            country.setIsoNumeric(2);
            country.setCountryName("2jlLByiirFEKHsu4U5PRC5Il16G2RFSQG7QcGaagvxUP66XRnN");
            country.setCurrencyName("G6vEohUgGEgsXyJlwQFhcaoELhnJji3p8GsP96dic1oeFtzB7S");
            country.setCountryCode2("R4I");
            country.setCountryCode1("mIu");
            country.setCapitalLongitude(4);
            country.setCapital("XY5LIWdcLnz2CBe8Cd0lQDqhUyakxgmr");
            country.setCurrencySymbol("BSFbf1Hs2Vi1L7tX3SXTnpcuru1u6lRB");
            country.setCapitalLatitude(9);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            state.setStateCodeChar3("2FIbCjoXlOByUBjWjbeFbM8z1Pq7MGvx");
            state.setStateDescription("funOENF8RfRR6KIeirfM5cunPmnfUP2aEWsuXpvlLgGvmrLdhk");
            state.setStateCapital("NNLTcQ0RTfxdO4pAjZBSjJK5ykayBFWsQKG3O6YG2NzJpBMHBV");
            state.setStateCode(1);
            state.setStateCodeChar2("6VDOl48bVkKYrm3ZK7zHqXrGTmpQifZa");
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateName("PtDZZMgbeh3CNsa81Ou0oi2IGweE6I7mJoE0Xvr7QaMFd3P7kT");
            state.setStateCapitalLongitude(2);
            state.setStateCapitalLatitude(9);
            state.setStateFlag("wUJT8gyKb0WASmt7h1h1Edoj8pyjoOVbknytg7ZIWrYAbjgBPg");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("nGZJ14mQupluFdNWX8SQYS8srxJH1P6qCdMfn5TNlD0OI8mu14");
            addresstype.setAddressTypeDesc("lMjevkHhAAaz54Kzt84dYYWhPoxUxcmHenE6g6a5oOeLu5icXg");
            addresstype.setAddressTypeIcon("uh2Gf2r73eONBTEURnvgnNBSVHPMnyb2sSuBFH9sQm31hEWkKm");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityCode(1);
            city.setCityLongitude(9);
            city.setCityFlag("rbkdO2ts9KQwfaKH1ZAr8M5e5mvMMLrzrGn3rSzkDLDJlsAKQE");
            city.setCityName("tey7UtHQrI1lVbi6XGzoCr2jy5JqkgVvybDPHnml5LatkYLtct");
            city.setCityLatitude(1);
            city.setCityDescription("YLpB130ZSpNeuvlFU3uPemuumPJQEkDGX7J8CqHSq0rVNJRSaa");
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityCodeChar2("bxZaF1OxMPv24vk24L3EC8YMI6w078uh");
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress2("V26kpuZADlsOT6WakQ6WXHF6Gx6mFvsPLreK3RIVAdcIP9lPmS");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("DurlpX");
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress1("ShZmGbDSgcLW27Rsz0GkOZZe3FZnwt1Pc6VmQkoM0Llnt4Zlzr");
            address.setLatitude("6ZP540ClUV4GtjLP6hYQK74C6zM6xcYMGfsReC1YUjvMIKzpZV");
            address.setLongitude("Zcs6gRPlsVtZy7T5JWCUIKQYxce2rnaupaEI2iXYOUztWGhRmK");
            address.setAddressLabel("4DjSpC4w4CV");
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress3("nzxq79dkr6WIQKwwUFeWgX5dPiIWpoUxHJkDQlagLN2RQ5KkiZ");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupName("YZz9QoiJLIkF1msZ88q5DhhnLWs7f2Aj5EZ69dKn0FBeJ3zCdl");
            communicationgroup.setCommGroupDescription("pcaxPwUVH1iD06yYbciOP7lTsvVsASYzqjQ4tNPXpQ0ETFvAgg");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeName("cthXxw7T0j1gWje6rSrbtLIMLI0w8FGcm1x0Sx77B64OJLsMmP");
            communicationtype.setCommTypeDescription("UNCBYoRaBBkjEKvud8CG5lULhA4BgE9M5JemrT86ewXDqL8zyt");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            communicationdata.setCommData("9");
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            Login login = new Login();
            login.setIsAuthenticated(true);
            user.setUserId(null);
            login.setUser(user);
            login.setLoginId("9JHtNh9EoXJSTBtwKGxSRUolfJN3MD9MkcTldmfQffetjEh8jI");
            login.setServerAuthText("0KpAPBMjz7lTVkZ8");
            login.setFailedLoginAttempts(2);
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setServerAuthImage("almcv9rbQeB3BUn3w7G8vcBU4WM7lpYD");
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
    private TitleRepository<Title> titleRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setVersionId(1);
            login.setLoginId("gaLAAqey2ddS8T23whD63iBByQpCJYEI2Fbv4coSu895IZWGoM");
            login.setServerAuthText("G5s0KX4sleUxCS9q");
            login.setFailedLoginAttempts(1);
            login.setServerAuthImage("Y3vqsd3S2nThjWWNHaQSTINCjWo29N8j");
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
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
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
