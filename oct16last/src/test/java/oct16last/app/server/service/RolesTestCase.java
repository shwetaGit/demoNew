package oct16last.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import oct16last.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import oct16last.app.server.repository.RolesRepository;
import oct16last.app.shared.authorization.Roles;
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
import oct16last.app.shared.authorization.RoleMenuBridge;
import oct16last.app.shared.authorization.AppMenus;
import oct16last.app.server.repository.AppMenusRepository;

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
            roles.setRoleDescription("71CeX6sVXjYyez2saQKMiODBzl68tkiHFUqIrWhfmoZPAhJxSU");
            roles.setRoleHelp("pKHS7M2mAeYTTwOxj76LgYntiXwhu8dr0hqpJPZXC7dGx2GF0N");
            roles.setRoleIcon("lBBYD3eJ0dLP8grAONF4wMzBKQDrz8bxyJoCmDX05FLe4cBgoh");
            roles.setRoleName("2P7Oer8zxqHCSsaXjd60ukkvzCRkZDLjbQobLxAJiHIZpel6c2");
            java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
            RoleMenuBridge rolemenubridge = new RoleMenuBridge();
            rolemenubridge.setIsExecute(true);
            rolemenubridge.setIsRead(true);
            rolemenubridge.setIsWrite(true);
            AppMenus appmenus = new AppMenus();
            appmenus.setAppId("ZdpdPHVOzNzIenVxx4oK9GoGaQ3swhWpDGcdpDTWQBpCczBhIO");
            appmenus.setAppType(1);
            appmenus.setMenuAccessRights(1);
            appmenus.setMenuAction("SHEgT4lABlLnSvOwbBAtWQc5eXk54QBO6fZeUZDrYsfjJhokkR");
            appmenus.setMenuCommands("eGUAxPDqRcuF2jVDwwvBLjzsfJozBXVFig3smtDoiU96P3Jd04");
            appmenus.setMenuDisplay(true);
            appmenus.setMenuHead(true);
            appmenus.setMenuIcon("prH9gRgAFxJAtullsX3zaprfQPu30hI0nTm3N1zS4lniFUYS6f");
            appmenus.setMenuLabel("B2CWbfEjtgDIL0xHfGU3LbKJnrK52UZIlUA82yVixrkeBLp8Wd");
            appmenus.setMenuTreeId("0u9C9g8seTsn9dZJlnLEPEuxW577xGss8DurTb0oZjJat4tJjO");
            appmenus.setRefObjectId("uGOLxeg1syA3eMhvHPZosONS27PwVcAeWArqF5uv5yfQ4aduNz");
            appmenus.setUiType("T9I");
            AppMenus AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
            rolemenubridge.setIsExecute(true);
            rolemenubridge.setIsRead(true);
            rolemenubridge.setIsWrite(true);
            rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
            rolemenubridge.setRoles(roles);
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
            e.printStackTrace();
        }
    }

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            Roles roles = rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
            roles.setRoleDescription("x7j4IsTK16buydbCt5Ay3g12Va6hVtoyNegguSdneFGDOkI3dZ");
            roles.setRoleHelp("nR8zKYaACNraFOhDwZj5CVan03S40PMJKVV5F2uDCye19uwLcn");
            roles.setRoleIcon("C2Y1CDbGjKN8KXQvcApLZP6WkFAXfCE50WmrF2QJlxLosGkIrY");
            roles.setRoleName("HyaFYK5JarZIv1IBWLCrCb0JfxTvMH8MKxqBnqTo20qnqPfl71");
            roles.setVersionId(1);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            rolesRepository.update(roles);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }
}
