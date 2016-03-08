package project2.app.server.service.aaaboundedcontext.authorization;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project2.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project2.app.server.repository.aaaboundedcontext.authorization.RolesRepository;
import project2.app.shared.aaaboundedcontext.authorization.Roles;
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
import project2.app.shared.aaaboundedcontext.authorization.RoleMenuBridge;
import project2.app.shared.aaaboundedcontext.authorization.AppMenus;
import project2.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;

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
            roles.setRoleDescription("xHQKRMWlELJrpyKVQmiapM24pziqXfbPIcOhpGi2Lm9U7UMfq7");
            roles.setRoleName("hULe0LCPKscBzEdjoyn2ivInzEaRjy0SiZhQv4nCr9M1iil7N3");
            roles.setRoleIcon("6Sf5xaj5ABaqVYp26aWtLnKx66TSosgesF5kyjcN2tpETuvPgK");
            roles.setRoleHelp("bWXc4EKLRpCyq6e2LDSza2Qkgzs6WvUU78W18S3SE1xcibbukX");
            java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
            RoleMenuBridge rolemenubridge = new RoleMenuBridge();
            AppMenus appmenus = new AppMenus();
            appmenus.setAutoSave(true);
            appmenus.setMenuCommands("dB3W6rpuky5AtK5EW4RNSramZf1UAjwhSLuxtAI9wtKeUayRmG");
            appmenus.setMenuAccessRights(4);
            appmenus.setRefObjectId("M1IxAzvJoxVpowIxRpTxe3KRZLS22JwU8kefoZtemubruPXhEk");
            appmenus.setMenuAction("r8EUqMjHIS3FEY3WVz4e7L034cDN9yV8XYId87QEvx3bHCHBal");
            appmenus.setAppType(1);
            appmenus.setMenuIcon("6g9kmUIGUNPJTXfiR4SHw4Bbjc1Ox5zyp8zVS53bwuLGKAsj5S");
            appmenus.setMenuHead(true);
            appmenus.setAppId("pypd9xFinLyT5jWx6zQcoUYVP36voUpc8uv9CCAOgwIRLkcWY5");
            appmenus.setUiType("coV");
            appmenus.setMenuTreeId("Ucx37ElsIIzFXbrBSupKXWeJK1ghdUpQRsy9FoU6eZiliWaT3i");
            appmenus.setMenuDisplay(true);
            appmenus.setMenuLabel("0XGVUYiYsJlumOi7tlSujZLBm1cwasOhCcuqwiSqoeGRxkyDEP");
            AppMenus AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
            rolemenubridge.setRoles(roles);
            rolemenubridge.setIsExecute(true);
            rolemenubridge.setIsRead(true);
            rolemenubridge.setIsWrite(true);
            rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
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
            roles.setRoleDescription("XHY6niAF5zkZ8NGV6R6PfXlUARd4Ze2oV5Otp0rkDlatrtRUAI");
            roles.setRoleName("MgRoeyMkmUvGvGSGC3Wqi4Nab92yixKn6sIEsIM1de7uwFbt6r");
            roles.setRoleIcon("UPUsap78cnaUHj65U2bG4gbbW7UiUsSoT6ixCkjsjCl7XYe9hY");
            roles.setVersionId(1);
            roles.setRoleHelp("7ihVWmkasqTzCP26JSrN347qwruYyML2Lo0z9ZejVBOAk1iTU9");
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
