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
import com.app.server.repository.appbasicsetup.usermanagement.UserRepository;
import com.app.shared.appbasicsetup.usermanagement.User;
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
public class UserTestCase extends EntityTestCriteria {

    @Autowired
    private UserRepository<User> userRepository;

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

    private User createUser(Boolean isSave) throws Exception {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainName("T3CwdBIiTrzwkPhB5MBd3qnxCO56NgZT10DX44xGw01c6XDq4x");
        useraccessdomain.setDomainHelp("UhvWI1xL0PQjYDjSca5344Q3p5ciBUVsm7dO2dIyYymxDDrmpD");
        useraccessdomain.setDomainIcon("LA0AteBjKZEbVi9h3YHtWwLwPRwdh0GIoqyWQ10SPgXvKeeSIP");
        useraccessdomain.setDomainDescription("05QUQaiDuzRnwhILYHgGE0ZsHRGQhnUHELCnda7yuEhJFoDOok");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelName("SyTHEYlNIkbOsZh5G74EMjPvpj8rJOols7lTRmbA0LLDA9GbbT");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelHelp("3g0sQQ7Nffj5VGtNQliOOVUFJzWr7Ozx11fxXCxk244YMhdfVc");
        useraccesslevel.setLevelIcon("JiLCIUFylpDJyIwUZ49sRrk2eUZ0V2wPgakmZXK9tiKs0VfZxz");
        useraccesslevel.setLevelDescription("LqHhPCvRGXctljOiCqEkEgSQHNHXp8ddGJE9Z47nl1qV8bvWYE");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        User user = new User();
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setUserAccessCode(23700);
        user.setIsDeleted(1);
        user.setPasswordExpiryDate(new java.sql.Timestamp(1462950611629l));
        user.setSessionTimeout(2991);
        user.setAllowMultipleLogin(1);
        user.setGenTempOneTimePassword(1);
        user.setMultiFactorAuthEnabled(1);
        user.setIsLocked(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setPasswordAlgo("EcTfaCxqD0mIFVDtUaGyoQJ5xnlRHJn0rHhNA6EpWzqm8Z6slB");
        user.setUserId("aGnEfPpawNFeYB4eMtqXvUGxeaUmejY75e9HJbMzjoZdo9EZ0l");
        user.setChangePasswordNextLogin(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1462950611681l));
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        passrecovery.setAnswer("oRZ6DhACDBkXg3rOFn9heHxHkjeDTzIPdvDrTFGQEuxbCrjsBx");
        Question question = new Question();
        question.setQuestion("A00EfUafUC4mgShpL0pARL9MZCF0HQYt6uFpTXavHyN4KcaBhu");
        question.setLevelid(1);
        question.setQuestionIcon("aDqClZajxpxhtA6mwFIGzmb1zsCRLz0TuCLGb1uduFWHHRG3Gc");
        question.setQuestionDetails("TtwhUfaVWR");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setPassRecoveryId("6DnscMmumOO7eYrT4IA5ANJK4psKBE58MFtrmrRGzYuGIKeV8q");
        passrecovery.setAnswer("U8mGSRPVNI9kdYCWyckPZq0s1xEHDne9fBMPlBhmk2hywqZ2l6");
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
        passrecovery.setUser(user);
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setPassword("zFLHMEZ8sKBAQ9fjzAGRjYA20DuVYdL5gixqsH12QLTjzLPJR4");
        userdata.setOneTimePassword("OgJ71IfXDVftbE5XSQav5UnmATgt9y4P");
        userdata.setPassword("dhZhLCI1Fl4KBGEp5ZNHyFIbfYtTaBdvZaRk0GAi3ceiiT0WIr");
        userdata.setOneTimePassword("1bfAtt4kGNsOpjUE1GPpbmHve9boa3dQ");
        userdata.setUser(user);
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1462950611937l));
        userdata.setUserDataId("cyq9mlP0gHCxiyM1ZN0Imuzu0TgAJQegfuI6vZAKJh377AdV8i");
        userdata.setLast5Passwords("rdYUHHhi4xOsEpkFk2PBJOBPI75dWn0VpQ65TRuVZIP9HJX9Du");
        userdata.setOneTimePasswordExpiry(9);
        user.setUserData(userdata);
        user.setEntityValidator(entityValidator);
        return user;
    }

    @Test
    public void test1Save() {
        try {
            User user = createUser(true);
            user.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            user.isValid();
            userRepository.save(user);
            map.put("UserPrimaryKey", user._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2findByuserAccessDomainId() {
        try {
            java.util.List<User> listofuserAccessDomainId = userRepository.findByUserAccessDomainId((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
            if (listofuserAccessDomainId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2findByuserAccessLevelId() {
        try {
            java.util.List<User> listofuserAccessLevelId = userRepository.findByUserAccessLevelId((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            if (listofuserAccessLevelId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserPrimaryKey"));
            userRepository.delete((java.lang.String) map.get("UserPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUser(EntityTestCriteria contraints, User user) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            user.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            user.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            user.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            userRepository.save(user);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "userAccessCode", 89330));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "multiFactorAuthEnabled", 2));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "genTempOneTimePassword", 2));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "allowMultipleLogin", 2));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "isLocked", 2));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "isDeleted", 2));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "changePasswordNextLogin", 2));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "passwordAlgo", "VcNbGLlb0YfgnnYmrKmY3hRIKMBRXHCxuaO8NTb07rEIYSFqdOqXqgm1OG6r4p2VE"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "sessionTimeout", 7011));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                User user = createUser(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = user.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        user.setUserAccessCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUser(contraints, user);
                        failureCount++;
                        break;
                    case 2:
                        user.setMultiFactorAuthEnabled(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUser(contraints, user);
                        failureCount++;
                        break;
                    case 3:
                        user.setGenTempOneTimePassword(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUser(contraints, user);
                        failureCount++;
                        break;
                    case 4:
                        user.setAllowMultipleLogin(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUser(contraints, user);
                        failureCount++;
                        break;
                    case 5:
                        user.setIsLocked(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUser(contraints, user);
                        failureCount++;
                        break;
                    case 6:
                        user.setIsDeleted(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUser(contraints, user);
                        failureCount++;
                        break;
                    case 7:
                        user.setChangePasswordNextLogin(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUser(contraints, user);
                        failureCount++;
                        break;
                    case 8:
                        user.setPasswordAlgo(contraints.getNegativeValue().toString());
                        validateUser(contraints, user);
                        failureCount++;
                        break;
                    case 9:
                        user.setSessionTimeout(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUser(contraints, user);
                        failureCount++;
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
