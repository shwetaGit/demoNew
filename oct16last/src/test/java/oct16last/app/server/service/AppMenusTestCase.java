package oct16last.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import oct16last.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import oct16last.app.server.repository.AppMenusRepository;
import oct16last.app.shared.authorization.AppMenus;
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
            appmenus.setAppId("N2eA8c1r0YVRXHsQUAWJgFrIluzYrTZcVtECTUhSEi235jeffP");
            appmenus.setAppType(1);
            appmenus.setMenuAccessRights(5);
            appmenus.setMenuAction("sbSvOYmynmDZcnkMAMB2wiHn5PGsZFPMdim5ZcxsPtzgjWaQuf");
            appmenus.setMenuCommands("RZ2sYNLRgPrmzBALAkfW4mlo1QImpix69t5LUvjmjA04MJsVEE");
            appmenus.setMenuDisplay(true);
            appmenus.setMenuHead(true);
            appmenus.setMenuIcon("dIhKG6nZhNfzvp7I1fwORk50OIDJTz0oxuHU9kQaQtftyHMrxj");
            appmenus.setMenuLabel("DBg4R4rAxECYq0XB4Ao1CvCizSToxoP7o8ZczBgnNsiV3qJjv6");
            appmenus.setMenuTreeId("MAAJBHbyG16zpAorop1GsRDlDtrn5rFRQIrz9QRT3ykHKcvzSt");
            appmenus.setRefObjectId("VUfQW6QgMvqee7GWmBjikp2eRROCOnStZ6AUf4CsmJQedRjtM1");
            appmenus.setUiType("R7K");
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.setEntityValidator(entityValidator);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setAppId("76mXhpoAmba9jkRNbKuVyY02I4VlzIl8rGbldmUFgdFMyqJR5U");
            appmenus.setAppType(1);
            appmenus.setMenuAccessRights(9);
            appmenus.setMenuAction("Db5GPlW2ZkygfTYJ0L45MMJD5C36i9oAi7Pwt0yNxXXvhet5o6");
            appmenus.setMenuCommands("GYwQuAZlnguo6qLtLJwra68KoNoSKd8NkUagK4c7puijVx9zzH");
            appmenus.setMenuIcon("SFQSmityAlSEHxtHKZbYZOsHO7QJ1f1sXUWn8ZeJVEbECV0Lq4");
            appmenus.setMenuLabel("bmzXQJPzoIUBBoiBckVyuGfxFfuLmyq0nd9afO3VVDKy17cR4Y");
            appmenus.setMenuTreeId("oQOA74mqUiwTSpKDaBN5uUNxLYHWLh9iIZmJltqZc4gJC8woG0");
            appmenus.setRefObjectId("MO7NILk5vywswgChZLqNHQzBYXpmeMcBntqLkwsROnsuOsTpBl");
            appmenus.setUiType("rMc");
            appmenus.setVersionId(1);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }
}
