package oneee.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import oneee.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import oneee.app.server.repository.UserRepository;
import oneee.app.shared.authentication.User;
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
import oneee.app.shared.authentication.UserAccessDomain;
import oneee.app.server.repository.UserAccessDomainRepository;
import oneee.app.shared.authentication.UserAccessLevel;
import oneee.app.server.repository.UserAccessLevelRepository;
import oneee.app.shared.authentication.PassRecovery;
import oneee.app.shared.authentication.Question;
import oneee.app.server.repository.QuestionRepository;

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

    private static HashMap<String, Object> map = "new HashMap<String,Object>()";

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
            useraccessdomain.setDomainDescription("VqgqAyfQtp8TZFoUqA6NbkfDJm2PV2CSxpOGK70bOQOsUE4yS8");
            useraccessdomain.setDomainHelp("AEM2qbWU6tO4QSoNCOhqQsGMF7UXx365K4vnKztjQqnedsvmf7");
            useraccessdomain.setDomainIcon("bqkEG5Kqkb7ErhXDD3srLnrSfCUhWShXniKoqu7h2z4eaAxvip");
            useraccessdomain.setDomainName("dolDMClra5yNuCX1V5b4QRVnveATcAXQ3iOxd8hSkrdqamCVyC");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("TpU7IaSTOsnOkxxDhrg59Cka8VUp6bbLxlyn3RgxFVD2XX638P");
            useraccesslevel.setLevelHelp("Rv3TilbilQakHtkiQDKXAFc0y4hYG3tUBy3yrkzf3SFLmZduu7");
            useraccesslevel.setLevelIcon("rhInTLiKUjVy3mN6vN3ND2ePfZ7lv4dLedFEVhBtPJ6lImfFPU");
            useraccesslevel.setLevelName("bcYyZ34YiOnaHqA6cX2au5qxmu9prelJku9nIWUb09QIwC0mDy");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("35sRHaKr2q1lwjAS72QYz4yoxp7izYLwvLjhxGrIDXWhsQKPXT");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1949);
            user.setUserAccessCode(5);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("ltgfzm56whuGt8gXxHj43b0Qzwr9wp6VS5nhYysuGsd7Cc6PRA");
            Question question = new Question();
            question.setLevelid(4);
            question.setQuestion("lRtB0OHUGoNMFAM4IyhScNYu5boPPejYOyzuK9oCwABbMwoHRm");
            question.setQuestionDetails("UXR");
            question.setQuestionIcon("a8w7cYPFqNVpc3tiwsUjCLa0DFCqK5eT1LVYOZAr6312w2x3JA");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("6mffAKPl1oLayuQlJbRsG2nlwit7CJ2ORLi4Haxz6ZwoqHHsra");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
            passrecovery.setUser(user);
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            user.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            user.setEntityValidator(entityValidator);
            user.isValid();
            userRepository.save(user);
            map.put("UserPrimaryKey", user._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }
}
