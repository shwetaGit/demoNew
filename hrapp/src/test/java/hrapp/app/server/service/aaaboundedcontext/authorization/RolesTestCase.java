package hrapp.app.server.service.aaaboundedcontext.authorization;
import hrapp.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import hrapp.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import hrapp.app.server.repository.aaaboundedcontext.authorization.RolesRepository;
import hrapp.app.shared.aaaboundedcontext.authorization.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import hrapp.app.server.service.RandomValueGenerator;
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
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import hrapp.app.shared.aaaboundedcontext.authorization.RoleMenuBridge;
import hrapp.app.shared.aaaboundedcontext.authorization.AppMenus;
import hrapp.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;

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
            String logManagerId = LogManagerFactory.createMultiLogManager(_path + "/");
            LogManager Log = LogManagerFactory.getInstance(logManagerId);
            System.setProperty("LOGGER_ID", logManagerId);
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
        roles.setRoleIcon("6Z7RnkliRnPl4ZEQvbC17mp4Iq1qNJlQ6aAIOKobbLuqBb5c2K");
        roles.setRoleHelp("zKkCBAR4u8ihCPP5f2Ov5SIA8xb8ROxP9sIEFa3Wyt3V5KBGe1");
        roles.setRoleName("NoUdAyR0ZFWm6b7zib4YaW7a3rbCRVBnKH6glW5lg34ZxTiThf");
        roles.setRoleDescription("ItNGsgwl9xl6eQ7MywGTIUEUcXhZ3aMCGf8phD92R4H2HoBCmC");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuCommands("VZnJ0ociube25w9xS9GPrx8ftyXRzgDfTW3O2KWH4D7Tln0BYg");
        appmenus.setRefObjectId("WCUzJDZgP7pkQw5hCpeXpJJagOJPKkA5ly7UVgD63hUKuQW2YC");
        appmenus.setAutoSave(true);
        appmenus.setMenuDisplay(true);
        appmenus.setMenuLabel("Y3MQxfOFUTzMOlXrs8jPLe534flaXrjBM4sA5CF7r49ed2Qf2I");
        appmenus.setUiType("dXU");
        appmenus.setAppId("JFSfG8wU3bSzdOG5NvkVcH81MpCNTHvOqhONFCYi7dpRNqcRLR");
        appmenus.setAppType(1);
        appmenus.setMenuTreeId("oMdGpONM4DTSTdpkIGXJLxXzkfC64tJLmZJZ8sgf8Ta1ddnEq7");
        appmenus.setMenuAction("5W9XzNncBbPNV5sVoaGHeVCZhdWcEDheBSIYsOvXjOREZekcco");
        appmenus.setMenuIcon("4jpAZP5HbxgS4a0Z5nkW8Jmcb4DMAA8QJKTinCWl4uc7tgaYgg");
        appmenus.setMenuAccessRights(5);
        appmenus.setMenuHead(true);
        AppMenus AppMenusTest = new AppMenus();
        if (isSave) {
            AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        }
        rolemenubridge.setRoles(roles);
        rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
        rolemenubridge.setIsRead(true);
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setIsWrite(true);
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
            roles.setRoleIcon("6wT4AMrpyFXYfoQ7ht71zQXBgGXthO4qygJ3EEvn9KIklxZwcE");
            roles.setRoleHelp("BiD1fC9iDmrLMimqQLXzgWCL1DWOITIqhRc4pGTNxX8cvzNuDH");
            roles.setRoleName("hAyt5suuhieTZ81uUt69aJNZUCGywK7OVTz04PNlVbVxTciKiV");
            roles.setVersionId(1);
            roles.setRoleDescription("moD7mdQwYb97EG4JO7S1KLBWfl3EQIt8eSPpBSTIkXMiSqALIi");
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
    public void test6Delete() {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "y3m0b93sQyEQhOkmYXu7xyb60tVRrbEDsES0HnfC67ZM5HbPuKXcSE6sxsTe2Dl6h0WJUHkExWX3EhBbosyOkNyQ0XYeMIta38nNtbNy8c1jey9JmJa4BZSobqwMDaMtWZCTKjvjlbrz1kCDq6T5v4zlOK86wQtZzVv7rdBOSDvgytHPdl4MFniw8lLH00qyE0H4D5oZpcTmunzjcoPBkxNBZ2HEfaDYMO07PtSkm218Rj725d7z0X34U19FXP38x"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "Rixf3pzRQw79a64QN0IZak4emlwLsoW3WnPivzAMv6OtWZ0ym8WsAMxFfCOwbbOf0xvJV8o39cM8I7zCEpBGPSNvwQ1Q9D0A7eaw5pnweZgHCz6gixjqC2MQ4SAPHjGKuMt0NfDfyTdsliM2e6jktOInYK2WVY49etZFLHLSfLVbGE502I1yWFLJiyss8NZCGRvBo5tMU4rNmYW7RFqpJC7qia60vsV7EYJK62sLtEa95yfwtR9eT2lsY43c1VIDi"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "syEtIJ7ApCqzxCf8eqNNiTDSsHoPWWYq353CsSrkziwsL06dAAWCz34DsWJnhruXB"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "PKG6NqzcoDRTPNUm3cUmYAmsok7tWE9SjGYJduVDKGUTEtryZIa9FnpuMJ4BLFyJDd80AfVTYy9hcxtPXlv307nEAZnM4HPqO1cavhz8en7oPVoNs73oCbjAI9DgP8so7HcM7TxbPFGaPvKLIkVDbSSbnwdgKXdoH4DzFGInplKDRecl2jgBACoHKDxs2cJsB9FiKkokf8rr1naxPRMUVFBvN5ABRO4TxMxMCXxTmGMWjsA9ilwjXnpxQrk7rzm4U"));
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
