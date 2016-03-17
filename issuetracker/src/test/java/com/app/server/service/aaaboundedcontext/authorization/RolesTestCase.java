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

    private Roles createRoles() throws SpartanPersistenceException, SpartanConstraintViolationException {
        Roles roles = new Roles();
        roles.setRoleName("rJV9oyc15m0L4FmxOo1N96UfpuEu6ZVRvfmxg4ZeOn1nBroptl");
        roles.setRoleHelp("Pxd75oBAoHELMTf4BF1znyJoe6CFzn8luhf0tKpXDVe5v0RKCJ");
        roles.setRoleIcon("qJt6IJsx6HwMS2hWknyOi238P86E0t6f1QLafrGzfBWZ1rGFX9");
        roles.setRoleDescription("nxyqQvOVhvy0QhlivYVm4mcK0BCvwbT7LDqJ3lCLP703SpGFUB");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        rolemenubridge.setIsRead(true);
        rolemenubridge.setIsWrite(true);
        rolemenubridge.setIsExecute(true);
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuTreeId("oMepHwqv9KOOvzoMNCbdaKQ4Ox4xfhg5xithF0PQDaadWAIqZe");
        appmenus.setMenuIcon("m7VnG6iN3N2jyIIQsnal7kJGymPPIjtMLUoUTJYGyZcjUfEhlP");
        appmenus.setMenuAccessRights(10);
        appmenus.setUiType("7na");
        appmenus.setAppId("zbc16Ls5yVH9w86RgKJnzKd6LFbeOSSFOFp0ApZjPtdyq1dosa");
        appmenus.setMenuLabel("UfdJnhLQGlClpyPX2xGDcUwrX8XjKREkYZGnHQPGZeQLI8NHP9");
        appmenus.setAutoSave(true);
        appmenus.setAppType(2);
        appmenus.setRefObjectId("vSxCCNoY1ZWgcgkHlESxqLqtlJFa42neqQpWZTZpw19HSyX1yG");
        appmenus.setMenuHead(true);
        appmenus.setMenuCommands("AAcncNTaqE0vCGMKg7m7jF0pvfka8YiFtUScvLABbUYqAlTw0N");
        appmenus.setMenuDisplay(true);
        appmenus.setMenuAction("NDWr7XMi4MXrR0lhKSM9O08GewrDcxFQQLryJcS4Xv9GcEKcqT");
        AppMenus AppMenusTest = appmenusRepository.save(appmenus);
        map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        rolemenubridge.setIsRead(true);
        rolemenubridge.setIsWrite(true);
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
        rolemenubridge.setRoles(roles);
        listOfRoleMenuBridge.add(rolemenubridge);
        roles.addAllRoleMenuBridge(listOfRoleMenuBridge);
        roles.setEntityValidator(entityValidator);
        return roles;
    }

    @Test
    public void test1Save() {
        try {
            Roles roles = createRoles();
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
            roles.setRoleName("eR5dkpUW30m1yVglhEQAElvZlKGqP7vl1KFl7GqUfkX89lzJHx");
            roles.setRoleHelp("CFsViLYq4vcqVZMxGjttIpZZEHHBPLC2VUcKD7twO8mUaAirQU");
            roles.setRoleIcon("Iu3ncv8556CZj4ziahU4W61JInAumsFkqTcFxLtxrzq1bxSkxC");
            roles.setVersionId(1);
            roles.setRoleDescription("qycL23FqaExwuekpJhxfqsHWu2A0w1NbVrrOHsYWhO3ARQedS6");
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
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "lecN4zl23LkacIJbjhV9hnazh70x8fJozTX50D6aFrsuQcPueznUhL1DN1AtMV0J46UkrdfLYFGrb0lzI6UEaENrFT2dMmqfBPOYXqarTvhjQIH7yf0ArVTvY3MSzNj4NtJAINZjVzeTIx3Fy9PP6FhPj9b11qBA9V8j5zLI3oThH9bu3SCOqKFF876z1FHJ9ziu8CbqUnbxc0KAs6JMsaRhaBsHU41XKEgnI82JfkJ8chXhZsaYAhHfU3kKhK4dF"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "10pukGXFk8kXSt9N3T3Yo0fZGCtx4S1pCmVbVduo5BM0ksECBBWcS8nStA36yxODxqG6Fld3u27OI0UON1OwJ6vkHxV14MKDN3yJWLRrADMv5BiS1EonTWNr82M0rA0mRjtV7TmDxlE3ICknO2ODBOdkag0DmoAvBIsWE1bELzEUGCNhDsZ8YTKgWkQ9OVlt8tA8XyXoXOHqVuM5QTVSQriawMu2K6mh9ziYBSkiQ9G6bKRYuf5q3U29lOn5BgTnM"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "PfyRvvre4Cyu0iL3v7ST8RLM9v3hf5KdybPR4MH0YwUaivNp2aVDKvDlr5X99jO3g"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "uKdbvSJGR6Tv9RO9PiwEtOR8wOxRtltazly2trVGcmX9D92I1aGISNuQ7uZvBtp4NCGKMMUyqJ7scS1zTgZFIZrUtMTIRGLtxuzPlW3xpBDjNVcMQQIvxaqVtCQoHlWep1QTIqPJ88bM8NuebHYirt4kMOF52q53U9yWbv0gVc8zB3rfBHpdARAXNoAszcjSee9O6ZrCLvixs5RBlkryQVMZxI0T6IgL8ObsnvFlyohOyuc1unMllkfDtDP20ykuk"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Roles roles = createRoles();
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
