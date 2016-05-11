package com.app.server.service.aaaboundedcontext.authorization;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.aaaboundedcontext.authorization.RolesRepository;
import com.app.shared.aaaboundedcontext.authorization.Roles;
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
import com.app.shared.aaaboundedcontext.authorization.RoleMenuBridge;
import com.app.shared.aaaboundedcontext.authorization.AppMenus;
import com.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RolesTestCase extends EntityTestCriteria {

    @Autowired
    private RolesRepository<Roles> rolesRepository;

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

    private Roles createRoles(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Roles roles = new Roles();
        roles.setRoleDescription("sCwPIUgRpsfyfQSlQypyNlNTqhRe8gTZTDP0wgRgUWFN2sXH9f");
        roles.setRoleIcon("pClcg2hLA5auWNteoE8RZHc6EXwdN7V85gB4uQYOntEcl5GY41");
        roles.setRoleName("lAvypCAv5czkoVmeWmD8UhYTnXKciOrSlRyupz2t4Dc0OJx8xD");
        roles.setRoleHelp("0y98cxrmormHZCXAR8J88CZjOUmepx8x2LexJsYNMs6SY7ur6u");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuLabel("nXEv4OCM4rnDkwT3MRxTbE9NtCsURk58nYO8Hor3oy8d2twJ2z");
        appmenus.setMenuHead(true);
        appmenus.setMenuTreeId("HuuArx4yMtL5z3JD4DnDnaCVXaovWELztb0CAKs52MWpcaTd7a");
        appmenus.setMenuDisplay(true);
        appmenus.setMenuAction("eptWcFrq6CaP1JJyEWPKIXE7RrUGQJwVBIgdSFsMo1s1Rqubs8");
        appmenus.setAutoSave(true);
        appmenus.setUiType("LUg");
        appmenus.setMenuIcon("JVyxPxrWHNwa3zZYbePal93dKUqzTpQjwbt1BB4dNyTxnsPllH");
        appmenus.setAppType(2);
        appmenus.setRefObjectId("fe686zDlZtWoRBZPSOdiZpK3lx4d4xYbCLcF791Xds0Ixo8NRH");
        appmenus.setAppId("rmrA1mVoeeCOgPo64JzfqcLCJCtk1RKkdGGtcQ59F6jTqChLJH");
        appmenus.setMenuCommands("lusbnH1lvREEnEEXxgbQyEzDYmUnA03pukRHuSNTmAVjKuAmDD");
        appmenus.setMenuAccessRights(10);
        AppMenus AppMenusTest = new AppMenus();
        if (isSave) {
            AppMenusTest = appmenusRepository.save(appmenus);
        }
        map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        rolemenubridge.setRoles(roles);
        rolemenubridge.setIsRead(true);
        rolemenubridge.setIsWrite(true);
        rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
        rolemenubridge.setIsExecute(true);
        listOfRoleMenuBridge.add(rolemenubridge);
        roles.addAllRoleMenuBridge(listOfRoleMenuBridge);
        roles.setEntityValidator(entityValidator);
        return roles;
    }

    @Test
    public void test1Save() {
        try {
            Roles roles = createRoles(true);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
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
            roles.setRoleDescription("sfYmCv2gASmSzsFLz0alUbRR9Lh0yCV2qdeGtfOsRlvZvRnscg");
            roles.setRoleIcon("eBNKDc49W2hnidKkusjYS0Pk2ADgMKQZc7mS1T54mvRxhYkQNz");
            roles.setRoleName("Q7LenSg49kp3XtLCbg48qhN1niR6qW5AsznpoGh7j6eew5lNRR");
            roles.setRoleHelp("DmdCoH4ib7tf0cgI9nKTWaZolXl02KaNTz3BTyco2nLGuaH230");
            roles.setVersionId(1);
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

    private void validateRoles(EntityTestCriteria contraints, Roles roles) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            roles.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            roles.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            roles.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            rolesRepository.save(roles);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "RoleName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "pFfOjtRqmoEA1NDViBZkvfX6sFZcU8ks1Is6vm2h6WFUBEgkLLGIiVFAC2h9jUJNnA1HzKWJxb3VKgx4Fja0o9W2vDg3qk9X4HZw8IkIxuYuvMMFHqti9VnaFge46qni4OGImCfWQxWTezKyihMEPcGmwKNWCbmvBwvNAg4fuMFdMWlp7ziqpj0yo6hvMwboXneIVVmhxZDXaTgiyAjXgttqhokoP07dxzEIzamhKvRG67ZA1Glfy9UtvKZNvD31y"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "mh81uxOvuzjuBh0gjXtcpX3EIQNMsWgiSSWnl9WYm64b3Zs7IQazzqg5M0tKyxn9o77pCHkOGSQgcABQDUr34gSc3pUfXAeKEG1fM3t5ms2btzhFCaZZx11xxatxuaXkapErtwjdkYHhkTufMNM3x7ItctCZyZKjPCa34KJ3HTYcglmcvjTtBibRn5wGzCuv5KIEI2gcxO34y0GU1Pd93kUFO38HOzT6Z9a3uIA0Cv5jQ9M02hlL0sF7o3S0UryhX"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "GNSmx53VOQMhvqoRxc9TCGVlHdFlLnnXyBPxp74KhGWEfWufIS86o1mpfVtK48wXJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "QkCdiOziDMoBCssIS5tvsnEhR8qCGGFfZFX8j1uBxXZGB8fODazIgAQZhPgJnUsEakeZmPCiZrhiZoVsAJKYtZy9zZSEbHtIgcQPbrOVxhlaifBAoGgvd96WkwmIgR071ILRedV2s7J6udIivzhOPhd7oXid2UHhuijEKfVWh2hjBaLakcTod1bYu6xf5uGCgY6lXIfUGpZ71Qj24o86o3C0OgzzL2X8JuUZyReyCuv4PW6HElQUM7XFnN24Zb5Tq"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Roles roles = createRoles(false);
                java.lang.reflect.Field field = roles.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 2:
                        roles.setRoleName(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 4:
                        roles.setRoleDescription(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 5:
                        roles.setRoleIcon(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 6:
                        roles.setRoleHelp(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
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
