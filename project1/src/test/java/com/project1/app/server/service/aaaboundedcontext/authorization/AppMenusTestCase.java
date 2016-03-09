package com.project1.app.server.service.aaaboundedcontext.authorization;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.project1.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.project1.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import com.project1.app.shared.aaaboundedcontext.authorization.AppMenus;
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
            appmenus.setAppType(2);
            appmenus.setMenuLabel("0odyjOjEjjaV0bKxJTYsI0pnkEZmPBxjOQx8evIC5Tgtia4qvO");
            appmenus.setMenuIcon("37RlvJO1CqF8gDvbWqJYWnwVKdJf4kmJ0DI6puGpzEFZCvW7Go");
            appmenus.setAutoSave(true);
            appmenus.setRefObjectId("QsEfSYa8pKTR3kRiUPyMEMmHg4akiGWJpXZvPk3tNJvd3HCfN9");
            appmenus.setAppId("Y570bLGaXK7PBnOJAElFoHULDKU9f8GhoiEj20gakJnkUNOAio");
            appmenus.setMenuCommands("OCptA134YdaIULG0R962aqmU89mexysUszhwlYZX4AlpdIxlu6");
            appmenus.setMenuHead(true);
            appmenus.setMenuAction("i0R9lDNDdilZHbvgzHqoi2HW0obXrQ5249D3PxXK3MibBBLqXU");
            appmenus.setMenuDisplay(true);
            appmenus.setUiType("KCr");
            appmenus.setMenuTreeId("FU3n6R4RHDWBFcvNVQ0KD5G9o4ZgI9954cDyrAwydTedaocbLS");
            appmenus.setMenuAccessRights(3);
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
            appmenus.setAppType(2);
            appmenus.setMenuLabel("PhQHy7filIIqlbXiosycEJUNhGdS3uP1oWEVI4Rbjh5pfqkyRh");
            appmenus.setMenuIcon("O4QNFlLCWmXmMWLawrWOOCzVVbuzE8HiIgjzdEcwceAW2mytkF");
            appmenus.setRefObjectId("EM7TTITTqj3xMmLKoe866U6cWELRQMDgv5jemGfTClHYGDoWdG");
            appmenus.setAppId("Mfjne90LTUJzKlceU6wZ3V7SOYBmW2h9kDHxBg66ivbEMBJh1X");
            appmenus.setMenuCommands("HlD2R70oJKt276hC0CWqOM6MtlOMN6uTcuMXxmZfjbmEC9XGNB");
            appmenus.setVersionId(1);
            appmenus.setMenuAction("OlSW3q56Oc5IsWloQyk42BXDGiF49BZA6FTlut933uwcMiAnSo");
            appmenus.setUiType("Z17");
            appmenus.setMenuTreeId("4dMPEMEatGmXJ0E9M0qM9y7jz1jUqXo2bckwlZz4eKDA86eYgU");
            appmenus.setMenuAccessRights(1);
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
