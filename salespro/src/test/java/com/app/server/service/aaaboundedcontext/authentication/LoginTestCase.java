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
        corecontacts.setFirstName("ocXresvtLTjuc49t0Ttlaxwf1Z4hNQ29hb8IEZZQwUJvHEelV5");
        corecontacts.setNativeTitle("PR7rvNSRtcMvdm9ijAJq5Xe7pDctHb162tEjh2w5O2TMeq6Quv");
        corecontacts.setAge(125);
        corecontacts.setPhoneNumber("Sxwlw0VxQtRiOHLXyJxI");
        corecontacts.setEmailId("ht2P5Bv1B6rcse3OvQf92e1a8xOIjhSd6gRE7TFqig1lDb3K7G");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459233526865l));
        corecontacts.setMiddleName("LL0tr1Ox5HCn2nY3o9hCg9eDJyX7iytgHeg0bhK9rkpolWhDqN");
        corecontacts.setNativeFirstName("iAEVng5XhSQOvdiHrTiknkP0f4jt93HCOpDWktSag6qQzYWViI");
        Title title = new Title();
        title.setTitles("b6Yhrq23q3Fhm8VYQdDmhvsnTWRLeOJOKqUWVxcxVyRuxLMDEz");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
        }
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("snVwbEGaDc75kWyhAxVtD6n62khcoNYjlmraR1z5QQ2L32mo7s");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
        }
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        Language language = new Language();
        language.setAlpha4parentid(2);
        language.setLanguageType("ofv8spOL47ybRoMyOZAnUKvzVVJ2YJmQ");
        language.setLanguage("oMOc1JJz62bUJaMBlg2poRP7r54TWMKNLrmCXokt2VGQYsHNum");
        language.setAlpha2("4M");
        language.setLanguageDescription("LuMKBWK5s2j1C0FiCgSrn1odWky2ATj5bxPA70bQBuefdJu8W9");
        language.setAlpha4("TO5j");
        language.setAlpha3("UYo");
        language.setLanguageIcon("0NVbZyJEV2RnlcJNjfMacMt6qCUNFNrZkrWZ19ONRwQxfF0AOL");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
        }
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        Timezone timezone = new Timezone();
        timezone.setCities("Dd6SsOTnXuUl0IaOTDL0uGZ7omY79ZsHB0cJVNZHWrt89XUSkS");
        timezone.setTimeZoneLabel("9Ocp9CMgA4KDheCuC8dksbBTgqXdmNPFFmAJ6OqciL1MSFjVUZ");
        timezone.setUtcdifference(3);
        timezone.setCountry("VFPC7T8UomzOPYGHROXT9hG51a05waLf1wzmTC9GnAhjmkURqe");
        timezone.setGmtLabel("fdmJqhUpW5MEgCplSMU3zzoxT7Aj4GGN7z7FctqTbx0CzfEyHr");
        corecontacts.setFirstName("ylZQ3enXtrY6NjurrIlB7R5vbJ1KgD2Vd9nB8UypSIfIV5TBVu");
        corecontacts.setNativeTitle("fQuQE3DrWUZf1NVMlJjtv8gOAqKIi3Ii5qarkqoSoRbu06e2Jg");
        corecontacts.setAge(106);
        corecontacts.setPhoneNumber("sy1LbVmn9z6lH8dCXaBb");
        corecontacts.setEmailId("GaCn2huqinP9fFFCgFHk0lN51oJddV32G5mNzcWPBd8s3folQD");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459233526885l));
        corecontacts.setMiddleName("OIrB3JeN3z0uXpbwtYJrkPAX90dbFaPonbXh9NQlJmsiFqJkXj");
        corecontacts.setNativeFirstName("6VWj6HKUtCWdjnImXuhPi2tUTBDNC1Q3v2Phwe5kdGATqyd611");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setLastName("M0jMVHoAMB00vZg02CwATxCKPDtwhzEGXE8cNLbHYq5YuISQBB");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLastName("TQR7F58VuWAih5LOKl8JbPIH3VUrT1I8YfurrDKbhk9hI260Gm");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459233527027l));
        corecontacts.setNativeMiddleName("4xqXmWpwiyJTLziMmhw1gpYaixkziF7hK5UGjLa5tNENzqIW6K");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("e8sRXekJhh9gqcBAolbzDfR3rsgaU06GvIMu9T6qAYZFLThtWp");
        communicationgroup.setCommGroupDescription("KeAcHPBonrTzJY5dKURVY5qBlQ0ZTjSgC3knqgamOvSx25gU92");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        }
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("fAYHts4Frd8wQKOYkExg6EZHKQnIpQPqUeKrXRbGPVW9UAnuFq");
        communicationtype.setCommTypeName("PX1u333Vo8zT41me0VkyAAzV2ynwJIi927LhC48N2yWpNYpFUE");
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
        address.setAddress1("d5iH7Mr8pi2STfMiieYsqbylzBChOmap20ceHvBn0FCpL8uPxf");
        address.setZipcode("QwUT1s");
        address.setAddress2("QXwZ2j03NfQ6HOHGAUtKdMyZO8MofFsclAnnzeWewJQpiRe2BJ");
        address.setLatitude("M5eLC3VIc6BCD3nYtBzJc7lWlsba9yAQTExPMeVjDkFdVeAFSh");
        State state = new State();
        state.setStateCodeChar2("ejPGof3ZAA9lvKoYLWC5uAkPiq4Qhc0T");
        state.setStateCapitalLongitude(1);
        state.setStateCodeChar3("QTCqOWbloDk3WwrgehqW2jZthUN8Bz0T");
        state.setStateDescription("q2LXAEpsxUuBn4pWSAInrHehaTV2G40ugcmB9G5HYCn01kzxv1");
        state.setStateFlag("VLZqMufrMCl2PWQ17bJv2R1g2IrRFvTDgOXkR9oUXSkLOwrqux");
        Country country = new Country();
        country.setCapitalLatitude(3);
        country.setCurrencySymbol("Y1wze0XlDeR9UTlGpiNMVYTDALakKhoK");
        country.setCapitalLongitude(9);
        country.setCapital("ZLipGGq6WFv1MlGLPKoDXSbD5GKDHwPa");
        country.setCountryCode1("LqO");
        country.setIsoNumeric(48);
        country.setCountryFlag("5vwfa0fTAQlWwA3FNq37KADdZSfk9d2ZVLcU2XkdqDvQrbGMMf");
        country.setCountryName("qjZpM7KienHf9Spt0GdE8nrCKKFELcQRyV2z9UPQSUqTSY9uem");
        country.setCountryCode2("s2I");
        country.setCurrencyCode("WJg");
        country.setCurrencyName("pYedeRr6X8Y0PZEGEOBUugpFubqV6j48jyBbeu2ZKLN1oWwNS6");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
        }
        map.put("CountryPrimaryKey", country._getPrimarykey());
        state.setStateCodeChar2("vkTti4z2aFaJXtk8EtGDgJEhAw5dZW8k");
        state.setStateCapitalLongitude(3);
        state.setStateCodeChar3("zqGPEiWOCJlvX393Qd0lYJRzW2hyvJWY");
        state.setStateDescription("oMiSZ5UZw0i9XXptkg7kUKjfC5LS4Z7T73GdxLz3gs6MBtMeRT");
        state.setStateFlag("SvleukORWtVPdt2bRX6UzFyCeSNoaSalAG1bwk1BKgX1v8MLFb");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLatitude(2);
        state.setStateName("fctJHlwArM2b7dUVGWVng50R8H2yx6sNrmmwdO1vGPUQgfC5gc");
        state.setStateCapital("qEJMtBcC4v7HFVRK3Fr3nCr2LpeRdGEZ9D8nnli2JRh7FptY4E");
        state.setStateCode(1);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
        }
        map.put("StatePrimaryKey", state._getPrimarykey());
        City city = new City();
        city.setCityLatitude(7);
        city.setCityLatitude(4);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("DfzAMQWb7XKxDjYVokyESY32yqpZe4m6");
        city.setCityCode(1);
        city.setCityDescription("ZKO20tU0MOGoJLDQMY77Pmeq3v0lpl3DfkkKnkLrK4OrvHsIYY");
        city.setCityLongitude(6);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("vkDAuteKugLs0vYKgsgtLofoYu9YhGPDDxBB2a1y38HzH4EqSY");
        city.setCityFlag("7T7JXv60iFbQW3ZqkTpMTNFM5WPysp6l0mPFLrGJgGU3PcpCL0");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
        }
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("CFzcRtfbpqSBj1Wlajkon9VZ0OihUSqwKancF7keRZtJ8v56UL");
        addresstype.setAddressTypeDesc("j311W3kHLn24Q0Vw2iTcSxaksgvbjfd7KceW5950PZ5eNBopLZ");
        addresstype.setAddressType("l1T07rFjbLwatMemUMEzVoogHjMHw7IQ7wrqh0vOwgzfZPMup5");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
        }
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        address.setAddress1("uT4eQC2I6nyDFkZHhs7FF8D6Mw9LVk0Sv6UadpyBZ8QogbGeT2");
        address.setZipcode("62tfm6");
        address.setAddress2("3HbF3Ocr9OXovKGHZgKGfR4q76oUIc2KxPywN352ot3KkwLUSU");
        address.setLatitude("MsMnZgIujfi2xIANh3S1JyEiwC43m8UkLvfAdGpVM1ON4SJ4Qy");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("wj3CFwcDE8F");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("jzUwqrIxPKYBzOHHsGpaVuCpEatR62OCrf3AknW4WdLUHkcTUk");
        address.setLongitude("egMCgQVD8s9rLrNGgzfodDydh2SZGNNTRCMZKX9thEYPehOerA");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        User user = new User();
        user.setSessionTimeout(35);
        user.setChangePasswordNextLogin(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459233527421l));
        user.setPasswordExpiryDate(new java.sql.Timestamp(1459233527421l));
        user.setGenTempOneTimePassword(1);
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelIcon("064L7aFQFfntI56s2uOB2gFCzDhkaeLv5gPUzheWU3pFcMK5hQ");
        useraccesslevel.setLevelHelp("CAejaFL6y2pqeivEOSWRli5JCHurcAbWG6gYffBVBURFHOtBJM");
        useraccesslevel.setLevelName("NKdCLijuNC53FX40wBNvPPTW5Rayx1OIJZxI9MavrY09kca3sj");
        useraccesslevel.setLevelDescription("BYQj6lsK064tAIRMa65od4gjDJI41tBSyI7SuqToyez9bAx4AO");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
        }
        map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainHelp("XmL31aWxwwTUnwiJKBH6KsMw42kGiE1uzp8UGoWT22ANFBIAIF");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainName("kBJl7JoB8q3LJZx1wIydCtcuf4HHyYD9DZ0l4rwT1vd7eAjNP9");
        useraccessdomain.setDomainDescription("YJuwmYgtSLv8H5MU26bSy1szebb8h3RfHkolIG3wJseZF83kye");
        useraccessdomain.setDomainIcon("rJETx29IAr19TyiCYrEOBNvar0kL96vCI0ehxuSYiS8nXJHJDV");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
        }
        map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        user.setSessionTimeout(1586);
        user.setChangePasswordNextLogin(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459233527444l));
        user.setPasswordExpiryDate(new java.sql.Timestamp(1459233527444l));
        user.setGenTempOneTimePassword(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setMultiFactorAuthEnabled(1);
        user.setPasswordAlgo("Ytw5MJRRcGny1HdrH4Xl0ZGNPGxYa5A6lyFJxU7ChxYbUtToOx");
        user.setIsLocked(1);
        user.setUserAccessCode(28219);
        user.setAllowMultipleLogin(1);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setIsDeleted(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        passrecovery.setAnswer("QloiJWE5kMZGGFOiNMXdrU4mmkZ6poYw5tnbU606exYvzxUIsM");
        Question question = new Question();
        question.setLevelid(4);
        question.setQuestionDetails("2wD22RwV1Z");
        question.setQuestion("ko7GRUlKDwIUY4SLguwtfl5M4R9l7vQ9YaVUx4BJJUvlvdcper");
        question.setQuestionIcon("lSum6QVD1V7uvpfWdXkqdROmvxSSGNJoNOOl8RtXXJxfq9hpS2");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
        }
        map.put("QuestionPrimaryKey", question._getPrimarykey());
        passrecovery.setAnswer("pntLlCwnjg5ji7tU8U8iqauDMd1WPHl0nrpFMhP8cff97UAdrA");
        passrecovery.setUser(user);
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setUser(user);
        userdata.setPassword("LOIt1lQjhXQKOrR71hfcm6skecW9TQ3JK1XbNspNHZyTeFpkaC");
        userdata.setLast5Passwords("KPptjBBr9kAoCEt98PgiTEIpXUtc5ujRI4dSZg4ofVzUBuWZti");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459233527731l));
        userdata.setOneTimePassword("HMico9Z64uV78vYHYdsB7RMeRkmJXxaT");
        userdata.setOneTimePasswordExpiry(7);
        user.setUserData(userdata);
        Login login = new Login();
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        user.setUserId(null);
        login.setUser(user);
        login.setServerAuthImage("d1BBDBRE8mDlekVmQDJ4PmKc6pBURBac");
        login.setServerAuthText("dXLwjYVUk72vx6ZV");
        login.setLoginId("VK2eQraN1fFzClQzDBEKpHNOkgMNnrJblsfIyrCgzzimY9QR0H");
        login.setFailedLoginAttempts(4);
        login.setIsAuthenticated(true);
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

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setServerAuthImage("OHiS6pX6dVxb8jxNiITv5sepcIuHGfD8");
            login.setServerAuthText("ELuhOCGwzhvq5Ru5");
            login.setLoginId("VLV9Uv9cj8Rnx8ymLTi44LvrUTxQZvHfZzwydVaWAmudniI0LH");
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
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "p2KT3JRnCNhTqdcYY1lpKRBuZH3LCJljmNIBWyQhwhNjGlezwEGCC8rtZHWeq2BKfSSX3nIg3lsVCKDClUOMgF9rlcIO1SkhgZ53ZuoTdeJAzwTI0P2m6Iukx6Gjw4qknJ32BudfV2ewlY5dutxQMO75VuRgwdqHF4FReJbhH4ZUqkhHfWDj2O0v9sU8puP1VyOKgCDiH"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "aVdwfZRxyymKOg2dzu9jalBcPjs0vtegk"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "CFWjza68azNULiMpK"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 22));
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
