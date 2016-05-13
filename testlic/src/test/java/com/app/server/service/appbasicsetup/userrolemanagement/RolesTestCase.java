package com.app.server.service.appbasicsetup.userrolemanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appbasicsetup.userrolemanagement.RolesRepository;
import com.app.shared.appbasicsetup.userrolemanagement.Roles;
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
import com.app.shared.appbasicsetup.userrolemanagement.RoleMenuBridge;
import com.app.shared.appbasicsetup.userrolemanagement.AppMenus;
import com.app.server.repository.appbasicsetup.userrolemanagement.AppMenusRepository;

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

    private Roles createRoles(Boolean isSave) throws Exception {
        Roles roles = new Roles();
        roles.setRoleHelp("VlCgHLYnnRIX8WTYSZoZFtjq5VHshsisBPCqd8j0pZ0kXTxLrp");
        roles.setRoleIcon("Jznab5dz7oQ01laPcmGvkVWZQh4DyR2UzrUzpd3IYTmB0rlWpm");
        roles.setRoleName("M3xSPDGGok1GyrOVkH09Lu0p9M0ZW2JLS86qoJIMzhmDjAeOUo");
        roles.setRoleDescription("onDlujxkO2o7MXcrhcJzR9POxDTVnKZrGmiMKpsheW2zNuQtQR");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        rolemenubridge.setIsWrite(true);
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuAction("byVFeNp8RiGYhgnv9ECnKwUxv6d1kymZumgP8tdVWcwgyrDZvB");
        appmenus.setMenuLabel("127g1E63ieIFnVC6qB5KtJB1RciUfjeY0w30i7GYapsey4GzPB");
        appmenus.setMenuIcon("M1Ik0KiD5PNJ7ufpstnQOtA7KbOeh81LDOT3Og1vpxSZQXu6Et");
        appmenus.setUiType("IT3");
        appmenus.setMenuHead(true);
        appmenus.setMenuDisplay(true);
        appmenus.setMenuCommands("mgwOmvKV21irRcd8mOWuAVwAsiFhHUv2NKIEBh7iFTA2TdznE6");
        appmenus.setAutoSave(true);
        appmenus.setAppId("ESb9nnO12Ccu1G1lGe9VplY1nG4XyHfxMB5TfiVHX5B0wY4EyC");
        appmenus.setRefObjectId("oiLUDV8AL5uIRQEKXVVqnTTrbFqw2zSuZ7OJ889UsfxNefaGaH");
        appmenus.setMenuTreeId("N0ea6nHeixNe1unqevwdyBIgWRGGPLAFtXoYiTH5HFLyBdhhWu");
        appmenus.setAppType(1);
        appmenus.setMenuAccessRights(3);
        AppMenus AppMenusTest = new AppMenus();
        if (isSave) {
            AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        }
        rolemenubridge.setIsWrite(true);
        rolemenubridge.setRoles(roles);
        rolemenubridge.setIsRead(true);
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
            roles.setRoleHelp("FuMImnerRutY0IQgUZYss1NHUHQvITBDqS5dQ2gih2EH9g7QQw");
            roles.setRoleIcon("GNJaRF9QSngV6MYbvYBbljX6KxG2L6Qd1ibWoGqTB6YLDViHNF");
            roles.setVersionId(1);
            roles.setRoleName("yRjTtqM6q6BJ0vtTTXkfLoMkTVDN3tTK6lgAvBLfdhFZKkyE5v");
            roles.setRoleDescription("ILq2giujdspMx3y35miVIAe0aPLOsLEG3olGr3wp9gzSRQHDci");
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            rolesRepository.update(roles);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey")); /* Deleting refrenced data */
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateRoles(EntityTestCriteria contraints, Roles roles) throws Exception {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "Jzv9CT1F5stO75okbK3JXHZY9LSH6EHoWbIAy1OYYXUBXXnCe04sgUuPjIq6phMpK9FPxgCkILYJtA1xIf86qhQSvpVxpFwJt4DcBbUihKlXXkLrZfWBgQhgreK4tWoB839fdSkgExBrgzHYJyRdntFpWKLKhADL3aCWqVDs7eSgzToHI1xicjqQkkOniW3wPJMvbYIb4kKNZYyv7RKVjZyHNIiuD3VFHzzENs5zTFGqb92N686l1EvR5S7ptagbB"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "2P8xCREWfc4Vv3hx0hYHWJ1QiBLRJI5ZqwZiLpNvbT3e0cyLOtVwz1upTtomoKUIwPO2ofnPjrhfKy0DEh5johKYUR8DO9tXLzJSTk8C8Ww7KZIBCwMqiTuXFPDKdFN6BVXz5zmkNMo3ReGaKgfEdUBSc2ngcNbmg4k3WB0Zg7ziunhaW1qieZ8Zw4iCkYP1f3phFGgrzm1D7t8tsddnvWMf2NIhXP3EEffOLMOT6S0MkJsew5KGCoGwkUdkEK6rl"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "d43oZN5gjOO4ngvsXX5rkhuKnZp3tCvPdSfTQhjOdjw8A79uPSfk74BOOklLEt7tj"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "nD0xNJa0Zo6pmX4KBohGQTz1QVIeZpVSTCkklnkWiBf7uAI2QOaZAPqVD81BlNhGuKOGc4w4QIJey7jjPv3YxKh0iJVF9EoJiupOkY7kiqs9hIxFuG6Ao0M4rqGPvQKeKRYFEjiTmwubACQhph6wsoEaZg3OM3ErpqH095prrFzc3htkoqV333oEeF0lD3zy1kGBu4dsdKjH5L5n2MKOGDsuDpx8Bgg25nds4fapVrjFsqMYZyGfzPAvQaz6FeeZS"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Roles roles = createRoles(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = roles.getClass().getDeclaredField(contraints.getFieldName());
                }
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
