package com.project1.app.server.service.aaaboundedcontext.authentication;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.project1.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.project1.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import com.project1.app.shared.aaaboundedcontext.authentication.User;
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
import com.project1.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import com.project1.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.project1.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import com.project1.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.project1.app.shared.aaaboundedcontext.authentication.PassRecovery;
import com.project1.app.shared.aaaboundedcontext.authentication.Question;
import com.project1.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import com.project1.app.shared.aaaboundedcontext.authentication.UserData;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class UserTestCase {

    @Autowired
    private UserRepository<User> userRepository;

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
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            useraccessdomain.setDomainIcon("3R8YQsBpJEMpO80RYFfCu77whlMvlxpsDEe8UGR6OSONok2Ya6");
            useraccessdomain.setDomainDescription("FWNqlpULbtLD2INILp8c5kheultIbpYN8n5v0G44qMQ0D8XJYn");
            useraccessdomain.setDomainHelp("o3auWR3pLFmqa2n3hhXWwWKEOeD0IyTC3J82EdjFR95w0yVFAp");
            useraccessdomain.setDomainName("gfCgO6UsnTg81DiL3KxzSU8OaDEJFeuQA5QIKlfNplKFb5GfYu");
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            useraccesslevel.setLevelHelp("Phq9IvbLlucyQ3NRk7Nb2IJBA0YTzWpLtoxUqF0FuJmiArGCvF");
            useraccesslevel.setLevelDescription("kFIDE2yvJn7qnUbeEGP42w3Ny0DvAaDqk51lQKXp0t48KRPpdu");
            useraccesslevel.setLevelIcon("Rk1gkMTuqITreoirZR7fP0GjT4ygXX50zEDTYPz0VfXMrXPE1E");
            useraccesslevel.setLevelName("bPIvuH8s1euMDuAJu0fhLEjV1jSryb2uOb2y3hBdEGNCQp0IQn");
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            User user = new User();
            user.setSessionTimeout(1345);
            user.setPasswordAlgo("zq8NuSDuJ1SJM1pB0XzfWI9D5eEgsIQvdCgabL2va9lHAtOFEq");
            user.setChangePasswordNextLogin(1);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(1457502853227l));
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setPasswordExpiryDate(new java.sql.Timestamp(1457502853252l));
            user.setGenTempOneTimePassword(1);
            user.setAllowMultipleLogin(1);
            user.setMultiFactorAuthEnabled(1);
            user.setUserAccessCode(14452);
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("0qgqfcHsxMPf5FcNXnUQvP1sXrJyyHNoJDFkMl48zCtEHGx2sW");
            Question question = new Question();
            question.setLevelid(8);
            question.setQuestionIcon("qSP4UH1QhGrtJ8CVcz2t9YmLpLWex2KT7tNGEiyHrJ0V73SplS");
            question.setQuestion("GGqkHHUyj0NuapXcdZOHTwWXiGGUb6r2Gj4CQJlYifWry31U4p");
            question.setQuestionDetails("s");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("wen8tKgl6N7b2QCNH8gEYAOrv24GmnOVdsH9vK2MuRm4lcq4Z2");
            passrecovery.setUser(user);
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setPassword("yj1NeX8y5WbLeY6MlnAfqyr7ljiSoACvWrOFVOLIU9xBgqiIzv");
            userdata.setLast5Passwords("pWp3t8iWuQaLdJXsEGvXG2sCqkEIaUfEiIUZqTAOHYQp1qs901");
            userdata.setPassword("dmaG70VKxwyYZsuKsaonUDkblAiTlOOFXHXNaIZazjUYqL0low");
            userdata.setLast5Passwords("NiEcKP2baidIgiu913zeADB9ehdrgMnghWTEdDxGU3RUXV7EEV");
            userdata.setUser(user);
            userdata.setOneTimePasswordExpiry(5);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1457502853476l));
            userdata.setOneTimePassword("dgx9n49E0ZO0akVLJYaAwfECdVSlLJpd");
            user.setUserData(userdata);
            user.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            user.setEntityValidator(entityValidator);
            user.isValid();
            userRepository.save(user);
            map.put("UserPrimaryKey", user._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
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
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
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
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserPrimaryKey"));
            userRepository.delete((java.lang.String) map.get("UserPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
