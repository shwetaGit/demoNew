package com.basehr.app.server.service.aaaboundedcontext.authorization;
import com.basehr.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.basehr.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.basehr.app.server.repository.aaaboundedcontext.authorization.RolesRepository;
import com.basehr.app.shared.aaaboundedcontext.authorization.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.basehr.app.server.service.RandomValueGenerator;
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
import com.basehr.app.shared.aaaboundedcontext.authorization.RoleMenuBridge;
import com.basehr.app.shared.aaaboundedcontext.authorization.AppMenus;
import com.basehr.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;

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
        roles.setRoleName("zPsbHsgwovYKylEfKgAOKQy3gC6dGTRmiTH1PM9WDzmjxzfU1O");
        roles.setRoleDescription("oTZmYIMU4w7BtAMphikmWsN2fzEl05mRZa2Q6dre6UmUOBWrWX");
        roles.setRoleHelp("2DGol6Q9w4RId2ekoHTEaV2fuXWiTqM30X7MWBMBr6Jx2NP3mf");
        roles.setRoleIcon("whERAhmrlpt60l3ALkEH7HMKmDIWblS4cDLhuJACINEv6b7bJz");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuTreeId("lHpPOTh6ktqNuvo23ZePnlhrqMDovDhr0ZUDJxbA0tpWPCo013");
        appmenus.setMenuHead(true);
        appmenus.setAutoSave(true);
        appmenus.setMenuAction("fHV7MsRX77Dv7oDhtMkHNSDbI8WvVvMMNi1Gs104Z3dMyEKsFg");
        appmenus.setAppType(1);
        appmenus.setAppId("B0exBaSet8llmg7JMF7Ml2TpkQ7XIQ64gNVjYOC5KJRsdDh6yN");
        appmenus.setMenuCommands("6CHZHBFnaew3jRDsztvWkSi1xnF5eFhorfyjzyXg5Dw1KkE4xP");
        appmenus.setMenuDisplay(true);
        appmenus.setMenuAccessRights(7);
        appmenus.setUiType("utA");
        appmenus.setMenuLabel("q8mkIBfIsqLtFgXKakIdaUJJQzjmJIpA0mWHnwnaCcFcceFZzc");
        appmenus.setRefObjectId("ysznWVZd4G61q4aLAt6AXnmhtXyS5AxJliojjWCXGQQFIkhoh6");
        appmenus.setMenuIcon("nbSXsgRFoXvdcfdWAlUn2D7guBJoGtL0Tai88AIJSYqxHgFS7P");
        AppMenus AppMenusTest = new AppMenus();
        if (isSave) {
            AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        }
        rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
        rolemenubridge.setRoles(roles);
        rolemenubridge.setIsWrite(true);
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setIsRead(true);
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
            roles.setRoleName("B6sPrfPMeumAJkwAnECbtoWBstWPQhfpmd9vUdCEY4kKkNAjfd");
            roles.setRoleDescription("tN2veATbmm0hA2GO4HoJqFXJQM5rDN3H6JU5rTmMwQRDU80P9h");
            roles.setRoleHelp("5ThmTEX4c4pkekHyGIBjNzUiqXjAt3BSpuItMzwFbNHVkkiKEe");
            roles.setVersionId(1);
            roles.setRoleIcon("AuMWnGvAZBbEXSWGT6IxY6MtdTrtOaBUM2U8nku9Dhap3ouu8I");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "Yy4n8V3GT4b2QenZtrthnhxW2q91N3jWMP5kvZBa2QANnyTTdyHwQBJiZraDNkhc9epEtAv85NSe1Psw1dPAtiwOG7UTCAMwHMJqrGe2I4lzr7Lxn5ufs5wDoysg3cjBQ5K4SOls5tszA1cUpsidxHtvVFXiA1zqG1ezDAITzWmc8mDZwwPTP7XSDOTB57l3xo7fTJi4KiWwBzll8ZGcWiwI2ubKLv80qUoB0asF69HOvUgntDsQW7QGIbxeLHGju"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "bRwd6gKscUpRXBX2CzVCYzNixPb7GsNfJZidunWqJU5jZ1vVOfJpuWhASe3myW4Rs5FsPmS8UlH1xiVkTgyBxHV2sdppyQ1Y6PCtMxYFR8qGbsi5cVQLkQ5PfgwdK9RWqEmmo0oLaG675atdLts0VlXDFWud99X6qqvqOXLIp2Sd6qAAtqTf5Q8UQKyvdfIrXjuGjQH8MjWvBgba6iFgpy6zah7txsd11KVKuCYIOZathgnMNcaqe9KQGU3IIKqBJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "SreTD1VPFwpCAOSCIYixFAnFWBHrNvEHJdOFRUCcuao9Y0U2yxAZAcVDTLz9ErrS0"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "rmYUtrdoEZsYN1c6HtZstMpKdlxxzoBaFCfJYYC09dsXdDUXHC0sMUJ4tHwo7NKk8QGmlbk8G5Xnss5tdmhodIc8LEhhrWDpr8A7sRPLedqcyV6bsPpzQu0p3rJEjaGqd2SGOb2hlGtjRuHahzbQC8KbIwjRKNBP6zJv7mwKJLGRljUxaXhalbOXlnYPhp6rSjdrNCDDs04ouiJUYCsbWVICkhGS4PlRikQXXt5a1M4rkiugQdEEvay5NKAAFT0O7"));
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
