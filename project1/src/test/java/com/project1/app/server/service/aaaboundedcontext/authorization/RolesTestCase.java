package com.project1.app.server.service.aaaboundedcontext.authorization;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.project1.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.project1.app.server.repository.aaaboundedcontext.authorization.RolesRepository;
import com.project1.app.shared.aaaboundedcontext.authorization.Roles;
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
import com.project1.app.shared.aaaboundedcontext.authorization.RoleMenuBridge;
import com.project1.app.shared.aaaboundedcontext.authorization.AppMenus;
import com.project1.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RolesTestCase {

    @Autowired
    private RolesRepository<Roles> rolesRepository;

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
            Roles roles = new Roles();
<<<<<<< HEAD
            roles.setRoleIcon("yjzZEY0rSPhavlBLf8PfvKKiAeW3hBs7xq5VCbvfieJfKCr0IH");
            roles.setRoleHelp("5X5DgymbIJhUxj7cA7J9WocS1FGXGE290Ri3h2uKCpJqpPhcHT");
            roles.setRoleDescription("c7Fn77PTjDYxO7dDvWfjHmenaUkWkyDVbu8FVaJqZU1LgeKvvq");
            roles.setRoleName("WfjxzOucYwf29l2RfW0Ug8hAewCu66WjmntCpQ1uCLY8eSaX0b");
            java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
            RoleMenuBridge rolemenubridge = new RoleMenuBridge();
            AppMenus appmenus = new AppMenus();
            appmenus.setUiType("Nbp");
            appmenus.setMenuTreeId("A2IbOTY89UNKskMVigT27fWfCwTLurcnkLDZHUjJgxN9f8Jg5t");
            appmenus.setAppId("Phsp6wjePYU5iUEL26kDkaYIKVP7MjQImXF50MBEJCPHFXbD4d");
            appmenus.setMenuDisplay(true);
            appmenus.setRefObjectId("SXKa8KeRwOUdCOMjUBmjiNiZ5hy635wU3JXcWtvorO2NjzTBcD");
            appmenus.setAutoSave(true);
            appmenus.setMenuCommands("ogWLqCDuySpwVq1l6JLfTEZRO6I9thy4Ed63ndHdkDwcTQ5PXW");
            appmenus.setMenuLabel("qZeiLwzZ7qUDNNoz21q9mSmg25y6BgXi98vm44VNbgXDsycn0L");
            appmenus.setMenuAccessRights(6);
            appmenus.setAppType(1);
            appmenus.setMenuAction("u2Opjhx2bWQdRsYiACIrHiwVDD3ieAC2CBLE5eYNaQP2lmrVbu");
            appmenus.setMenuIcon("yvsYr8pRpG1AAF0ZuJzyTPMy0gcj0Ldsv5ygdrVbpqOxvUVEBc");
            appmenus.setMenuHead(true);
            AppMenus AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
            rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
            rolemenubridge.setRoles(roles);
            rolemenubridge.setIsWrite(true);
            rolemenubridge.setIsExecute(true);
            rolemenubridge.setIsRead(true);
            listOfRoleMenuBridge.add(rolemenubridge);
            roles.addAllRoleMenuBridge(listOfRoleMenuBridge);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            roles.setEntityValidator(entityValidator);
            roles.isValid();
            rolesRepository.save(roles);
            map.put("RolesPrimaryKey", roles._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            Roles roles = rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
            roles.setRoleIcon("scerHnC9bdkfi2myDwOARrM8fnTPzgruGLBNj6XTLnJo3AIajI");
            roles.setRoleHelp("WCjdn9DUm1r5UALu0tJjRgWtJk2ireCSZHJ7iwIBoc7BdEfhLr");
            roles.setVersionId(1);
            roles.setRoleDescription("ddGufOmz1q6zmtxVAESthpNPl4DMSmdmrjQTBaD8LCsjrbP8IG");
            roles.setRoleName("CP3RuSWeEvS8y1BVunS1qSoskQ5IJ4jMf5z01ZYuTM9KswvMsi");
=======
            roles.setRoleDescription("tRnXWMBfPyhV0gafT4HSUFmk6x66bMzQNakIZFvaVFC7NkL8Tw");
            roles.setRoleHelp("KeWbUZUoa8ZIlJ373S1zEk7whcF5rEJlAeKGODIGdq2q3UjAje");
            roles.setRoleIcon("NQD0dz2wLrzpUo8JpK9zDrq0QGqk5n9kvDqfAEi1jIAWJaqFtO");
            roles.setRoleName("E291bTMxUgIINoD6ax6cdr0fMrSGOLbbxBHlqbus3TijjhtRec");
            java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
            RoleMenuBridge rolemenubridge = new RoleMenuBridge();
            AppMenus appmenus = new AppMenus();
            appmenus.setAppType(2);
            appmenus.setMenuLabel("ZEDV7H44WhhR0jVAbsawhTi2VeshrMAtPDHVOL2WV8BRdOlGwA");
            appmenus.setMenuIcon("3KghCtflBIyxXu4k1qiBp4rPHVjdEBg13J4OPvw2aq4UMxNC1j");
            appmenus.setAutoSave(true);
            appmenus.setRefObjectId("eDOljmPW5NyCS2P3OwyKr4oEaB23ajEwZC7cvNt2SJ4ivLnQCJ");
            appmenus.setAppId("AH650jPE3EdX2q091ggCz0ylt4jFzmx1XYclZL8f2HuNHtoihC");
            appmenus.setMenuCommands("LrNGwnFlqK1io0sGE9n073aCniMtaKyz1gE4JMTqlKAeWBED90");
            appmenus.setMenuHead(true);
            appmenus.setMenuAction("SoT0d8rNJw2XaEvY8f0viekkMLkZwneY6Dkxal2LwkV5WwhPSZ");
            appmenus.setMenuDisplay(true);
            appmenus.setUiType("sju");
            appmenus.setMenuTreeId("1xLtBMijtjNeIyRMUHbruMaLEUDQd7mmgkxWWjK1l9vEmFSe25");
            appmenus.setMenuAccessRights(5);
            AppMenus AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
            rolemenubridge.setRoles(roles);
            rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
            rolemenubridge.setIsWrite(true);
            rolemenubridge.setIsExecute(true);
            rolemenubridge.setIsRead(true);
            listOfRoleMenuBridge.add(rolemenubridge);
            roles.addAllRoleMenuBridge(listOfRoleMenuBridge);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            roles.setEntityValidator(entityValidator);
            roles.isValid();
            rolesRepository.save(roles);
            map.put("RolesPrimaryKey", roles._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            Roles roles = rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
            roles.setRoleDescription("npSZQBI6XwpmcvtjUJnF983OFgdWuYajvhVLffrfsrnQNhd8Be");
            roles.setRoleHelp("KKLnCkwLw7cIjF8m0k4mhdK31zw5qfEUVkqVbYmzNAV7YCDwRM");
            roles.setRoleIcon("iGN5B8CwRk9vDnGxBDlaFeHGZSisMsACY4HVhgYFaTuOJVuAcm");
            roles.setVersionId(1);
            roles.setRoleName("PRqQAYvIwujNDDujSm1Cu1ZQSaFRcHYsZASoVGKorlyZnRuHKf");
>>>>>>> branch 'master' of https://github.com/applifireAlgo/DefaultRepo.git
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            rolesRepository.update(roles);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey")); /* Deleting refrenced data */
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
