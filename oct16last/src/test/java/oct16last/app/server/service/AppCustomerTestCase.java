package oct16last.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import oct16last.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import oct16last.app.server.repository.AppCustomerRepository;
import oct16last.app.shared.customers.AppCustomer;
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
import oct16last.app.shared.customers.AppCustomerCategory;
import oct16last.app.server.repository.AppCustomerCategoryRepository;
import oct16last.app.shared.customers.AppCustomerType;
import oct16last.app.server.repository.AppCustomerTypeRepository;
import oct16last.app.shared.contacts.CoreContacts;
import oct16last.app.server.repository.CoreContactsRepository;
import oct16last.app.shared.contacts.Gender;
import oct16last.app.server.repository.GenderRepository;
import oct16last.app.shared.location.Language;
import oct16last.app.server.repository.LanguageRepository;
import oct16last.app.shared.location.Timezone;
import oct16last.app.server.repository.TimezoneRepository;
import oct16last.app.shared.contacts.Title;
import oct16last.app.server.repository.TitleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AppCustomerTestCase {

    @Autowired
    private AppCustomerRepository<AppCustomer> appcustomerRepository;

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
            AppCustomerCategory appcustomercategory = new AppCustomerCategory();
            appcustomercategory.setCustomerCategory("EqpAIB0KZgiuuerUYLf1qoHrD2lXhyWBEhYuUrIkNUijwz2jh5");
            AppCustomerCategory AppCustomerCategoryTest = appcustomercategoryRepository.save(appcustomercategory);
            map.put("AppCustomerCategoryPrimaryKey", appcustomercategory._getPrimarykey());
            AppCustomerType appcustomertype = new AppCustomerType();
            appcustomertype.setCustomerType("OtdCuigNdB5LxxUL77Nj0dRvwy4mQU8qYpimzdqXUdbHjvcePA");
            appcustomertype.setDefaults(1);
            appcustomertype.setSequenceId(2147483647);
            AppCustomerType AppCustomerTypeTest = appcustomertypeRepository.save(appcustomertype);
            map.put("AppCustomerTypePrimaryKey", appcustomertype._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(103);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("QYrhVI3AOG9GU2Z6Dtb5XpUlnYFuBnxpj27uyxM2hklzLiI83C");
            corecontacts.setFirstName("ClqzjPVd9SFoBNKunIOf7qyXd7l10psozNDokA7AY4pcCFGESN");
            Gender gender = new Gender();
            gender.setGender("1c9ZTR1F6PQTZa8CwEdCxBYElebtNJfng3i1B9sBiL0mlHfAd4");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("Xo");
            language.setAlpha3("i9f");
            language.setAlpha4("jEpg");
            language.setAlpha4parentid(7);
            language.setLanguage("m6vHI0Y4nq7BGC7EnnZyr3KtXef8gW3w7fqV2XeqQSQbNU3TkS");
            language.setLanguageDescription("cK38yXU8kv4Hh7qIkuefgQZPXW0VD3eh0Je0IQdanQvNPPje5H");
            language.setLanguageIcon("vFNw6TRUfuJkyo41SCiNk7apFJgi5IOWDY6vixIvZkBdlselUU");
            language.setLanguageType("CIJBjf9V7bwulP36DczbqMoSkBKZkm0E");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("cKNVOVemb8uKjanBY49abaCs7eyZhQDBeXoLQlxh8dis7H4zi5");
            timezone.setCountry("Jr5jcGisbACeBgWULF0DFxOqXaSAJnCgJlWqUucRpnYGe73Bgm");
            timezone.setGmtLabel("8UkxyOdxfYoY2hKIuOOJmMcaXkqk88QNKNaouzdfuulb9DsSfL");
            timezone.setTimeZoneLabel("e8ixQXHBcjpGxKMUmrM4UaGgHoKoTMgnWo99a9nAqm4LtIpIRM");
            timezone.setUtcdifference(1);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("bduRj3Ni2wTgk0zCvZYADvnrCrLgNn7d4erEWxV5HVHcbjWun4");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(73);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("LNTazyF767lvKKytUbGNbGHGH3DLt9Wh0DD1hCVSDNczRymHIo");
            corecontacts.setFirstName("vuTO22BSuutxrRfLIO7GXazPfqOuDUulxSe5BHBK5IMFAa6RL3");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("T5Uvvc3puThHFurH6Fx3DMQTnfLnx4YwTwB4qPRjHP3TdCrhcu");
            corecontacts.setMiddleName("5TnEH1JhlNmbQfSGUgQWTzMVI4Ofab3swjcViK0jOzCUdab7LB");
            corecontacts.setNativeFirstName("QDeE1RU3PvZ8EbxPxqRAAPgkfj4SUz8fOJTpP6cYKYVJwYxLRC");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("2EgSH2XoqnNhg6HcUkwNKoWkjgkSjKtMlIC2KCIvEZ23ZF73tf");
            corecontacts.setNativeMiddleName("cBflh78XF1QNbGz7WdOyS014ym4wuq41Mjlo54rzhOJHdptxjM");
            corecontacts.setNativeTitle("x8fEEUWWbtgOb2wQmYyeVG3TCIYB2nuY17JQWgZbmhGWvpawJS");
            corecontacts.setPhoneNumber("a2ZjRnwF4VeqKbKFajtK");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            CoreContacts CoreContactsTest = corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            AppCustomer appcustomer = new AppCustomer();
            appcustomer.setAppCustomerCategory((java.lang.String) AppCustomerCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
            appcustomer.setAppCustomerType((java.lang.String) AppCustomerTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            appcustomer.setContactId((java.lang.String) CoreContactsTest._getPrimarykey());
            appcustomer.setCustomerName("w4qRKanySHn1Xz22EbvcIsPJyxG8iBqIv0LUfFv4s3p80fX3vl");
            appcustomer.setCustomerStatus(0);
            appcustomer.setDeploymentModel(true);
            appcustomer.setEvalTimePeriod(2147483647);
            appcustomer.setUserRequested(2147483647);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appcustomer.setEntityValidator(entityValidator);
            appcustomer.isValid();
            appcustomerRepository.save(appcustomer);
            map.put("AppCustomerPrimaryKey", appcustomer._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private AppCustomerCategoryRepository<AppCustomerCategory> appcustomercategoryRepository;

    @Autowired
    private AppCustomerTypeRepository<AppCustomerType> appcustomertypeRepository;

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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            AppCustomer appcustomer = appcustomerRepository.findById((java.lang.String) map.get("AppCustomerPrimaryKey"));
            appcustomer.setCustomerName("LKQAd0ExAx5j56EK8sYI9jb8iHaaM64EnPCK2mTCZNFv14NM2q");
            appcustomer.setCustomerStatus(1);
            appcustomer.setEvalTimePeriod(2147483647);
            appcustomer.setUserRequested(2147483647);
            appcustomer.setVersionId(1);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appcustomerRepository.update(appcustomer);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findByappCustomerCategory() {
        try {
            java.util.List<AppCustomer> listofappCustomerCategory = appcustomerRepository.findByAppCustomerCategory((java.lang.String) map.get("AppCustomerCategoryPrimaryKey"));
            if (listofappCustomerCategory.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            appcustomerRepository.findById((java.lang.String) map.get("AppCustomerPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findByappCustomerType() {
        try {
            java.util.List<AppCustomer> listofappCustomerType = appcustomerRepository.findByAppCustomerType((java.lang.String) map.get("AppCustomerTypePrimaryKey"));
            if (listofappCustomerType.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycontactId() {
        try {
            java.util.List<AppCustomer> listofcontactId = appcustomerRepository.findByContactId((java.lang.String) map.get("CoreContactsPrimaryKey"));
            if (listofcontactId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            appcustomerRepository.delete((java.lang.String) map.get("AppCustomerPrimaryKey")); /* Deleting refrenced data */
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            appcustomertypeRepository.delete((java.lang.String) map.get("AppCustomerTypePrimaryKey")); /* Deleting refrenced data */
            appcustomercategoryRepository.delete((java.lang.String) map.get("AppCustomerCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
