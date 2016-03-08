package project2.app.server.service.aaaboundedcontext.authentication;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project2.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project2.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import project2.app.shared.aaaboundedcontext.authentication.User;
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
import project2.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import project2.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import project2.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import project2.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import project2.app.shared.aaaboundedcontext.authentication.PassRecovery;
import project2.app.shared.aaaboundedcontext.authentication.Question;
import project2.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import project2.app.shared.aaaboundedcontext.authentication.UserData;

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
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelIcon("Yn0Tqc4C1heHLLJq8CypjmiMWDLQJxivo3sSeC1ikrHP6TOXo4");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            useraccesslevel.setLevelHelp("Jbw7DwFP2k7WaWqTIVmV70AT7kuJG6629D8T6k070KRn3Y2W6a");
            useraccesslevel.setLevelDescription("7MykLo7aNYtlmnf0HMzsbo5Rg89X3ZVmsRFwmO2TbQh5XBVWPV");
            useraccesslevel.setLevelName("SOYL5Y8fEHRVMadJlD0etPrvvuhNQTHoErHdptqcmlZNDAtVeP");
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainIcon("TKejf9puVngQBHpCuUGpBnghTyc5mdSLUE8M5MMnhpVzPKN9Z7");
            useraccessdomain.setDomainDescription("StqYwauYKPzzqRsI2QQNpVOP7Xk7psHybVceu0WiYzeEqzJY2Y");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            useraccessdomain.setDomainHelp("Gg9vIWUg5ha32peYUb01N3KNi6S2KNGSmfhZf068auWariGTV5");
            useraccessdomain.setDomainName("rO13rdHVIkPDbxFkEy9pICKe3IzpE71qqpUAmvP5apMnagCb9o");
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            User user = new User();
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setSessionTimeout(2699);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(1457448006285l));
            user.setPasswordAlgo("Oeb5HvuDe7EMnSRaeVp4j6c5vKypPLhtiSaJoV5UTGASBoRXL6");
            user.setMultiFactorAuthEnabled(1);
            user.setAllowMultipleLogin(1);
            user.setIsDeleted(1);
            user.setChangePasswordNextLogin(1);
            user.setIsLocked(1);
            user.setGenTempOneTimePassword(1);
            user.setUserAccessCode(34970);
            user.setPasswordExpiryDate(new java.sql.Timestamp(1457448006285l));
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            Question question = new Question();
            question.setQuestionIcon("AlA8WBiKLWo8CksaGYunpQneeXIwaUzqCW2IkVGj6aO6KiMxtR");
            question.setQuestionDetails("m");
            question.setLevelid(7);
            question.setQuestion("uyKcTCRBJiddWN9cZLargGsKhVLWlC60yl5w2OOvz2jTRgW25F");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setUser(user);
            passrecovery.setAnswer("wjdUA6lCxxoYvgTvhDeyEDL3VvUEOs1sCfJj63OM7Xwb7xbXuk");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setOneTimePasswordExpiry(2);
            userdata.setPassword("wT6DXL5chXijqJ95OtLXYgeCCg6ejrSBY5wjH2U7wKmzcdTOt0");
            userdata.setOneTimePasswordExpiry(9);
            userdata.setPassword("H4Ik07qYgv5V6abiDb2tGnZTCO0YvBPYbIGZ0lAjDLSrEy168c");
            userdata.setUser(user);
            userdata.setOneTimePassword("QW1annK8H9r81hYPKHWVwHlBcgzqDJd9");
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1457448006500l));
            userdata.setLast5Passwords("fTTX8Hko1rTz4y7ypL6VpYfFpj3nNKlFYfkyrdUKjIUGVmKnRF");
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
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

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
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserPrimaryKey"));
            userRepository.delete((java.lang.String) map.get("UserPrimaryKey")); /* Deleting refrenced data */
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
