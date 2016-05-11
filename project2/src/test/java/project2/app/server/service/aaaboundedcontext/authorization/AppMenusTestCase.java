package project2.app.server.service.aaaboundedcontext.authorization;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project2.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project2.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import project2.app.shared.aaaboundedcontext.authorization.AppMenus;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AppMenusTestCase {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

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
            AppMenus appmenus = new AppMenus();
            appmenus.setAutoSave(true);
            appmenus.setMenuCommands("17Fdh2hSn4mVJ2hF3ChWb9KMWov7UmPlZ8nokIRWXUyVMhzBmG");
            appmenus.setMenuAccessRights(2);
            appmenus.setRefObjectId("y7l3kPctkjCKdcy51qGRGVmwGkupbA2kQfejSBSn9Oq9zAc6rr");
            appmenus.setMenuAction("8kBVg3ImbuluFEj1rk3oBhP5XAejjTJG7J6j8dVj3jGrh6T9jP");
            appmenus.setAppType(2);
            appmenus.setMenuIcon("g5HDZq8OyPODPYvdDbCiQ6S9shJR39cy4lYFvM3Xiz7ZTg6Xvr");
            appmenus.setMenuHead(true);
            appmenus.setAppId("2zzGYQXZItyutksAL401MtG5OeEbj1a7D6nLCXMTy8Km9UNK4s");
            appmenus.setUiType("eB4");
            appmenus.setMenuTreeId("R1FFH2LLYULq5oxRBu7boUc0OPQmH220tgJYpsjGXc3nY655tl");
            appmenus.setMenuDisplay(true);
            appmenus.setMenuLabel("0SQ5RQ9j9LQQ8Uo6rnfq7Vu3AYMRnyYyByUJ5m8e1B7vynsigW");
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.setEntityValidator(entityValidator);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setVersionId(1);
            appmenus.setMenuCommands("bwvosXYShXWVKJmoiNNZLrf3ItISBHSfVjLPC6dizpb3eyeDVD");
            appmenus.setMenuAccessRights(7);
            appmenus.setRefObjectId("kjDoDKse7Lk8VaIxbuCzJPjviVw4lWNV1qrAW0hWWVordNRIcn");
            appmenus.setMenuAction("LCuKXgkjDuJLhxHfcnUZrJYcdBEGc26IuTfEJz0NYnxaVs5TAu");
            appmenus.setAppType(2);
            appmenus.setMenuIcon("GMHDUguu9k4k2ToBCTs2PCLifhZkeD0Yf1VoC3gZ8pC7b4nMV7");
            appmenus.setAppId("MEgtHOiiHSI3ZWF7p0HN728bVRYRWbkX5xkeLa7BBMEnXPeGle");
            appmenus.setUiType("oSG");
            appmenus.setMenuTreeId("ESL1Uz9GSpegfy8aNZuC0BovAl0W68nGdjk08dgVIdN7oargqP");
            appmenus.setMenuLabel("AEjUhCq4KyxKnEvIkODOzstAdwC9PImLxstCfQhbH15S6T71R0");
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
