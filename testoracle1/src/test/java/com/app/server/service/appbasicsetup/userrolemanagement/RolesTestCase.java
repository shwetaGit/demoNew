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
        roles.setRoleDescription("hWEdzbpAhXISpyec2m2eAHLcyHqSgtZ3O4qM2QizOTfJrUWYIL");
        roles.setRoleName("mfZxgwKOWx413zDPJBzXqDhUU5Kf0p6UR6sXNlHjh8LDeBl2Pr");
        roles.setRoleHelp("7JSpXNPLedld2h9vhi7UPkXepq6RN4QlLwJVWFUdwmMmu2FNzI");
        roles.setRoleIcon("W9sucV35ebD1F5BZQ25jrpL3ks1LRux49MXBGcSJenZtk22Xcn");
        roles.setRoleId("2DcvrY4OivceBRI2tdLnoe0mw1G2sEk1lFztzBpp36ulDi4oyQ");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        rolemenubridge.setIsWrite(true);
        rolemenubridge.setIsExecute(true);
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuAccessRights(6);
        appmenus.setMenuHead(true);
        appmenus.setUiType("dTo");
        appmenus.setAppId("flmSALB7zf41DiYhnUfqOJfEm2esMjM3fv3hODT3beGNwf6bx4");
        appmenus.setMenuTreeId("ZksKu1N5jJkEAjOEL2GvKguxz7ZsC30RIsiNxKH8B0To6Txjwc");
        appmenus.setMenuAction("f9xarXDvdahnZUsA0JpeXeGwrKAV51ZPAQ4bxwIy8nIFoDaQ5d");
        appmenus.setMenuLabel("IhmMHFYvmd7xwJlHGfsTKusmYWURtIfXG4hnuF0Hz7zo73Iqim");
        appmenus.setAppType(2);
        appmenus.setMenuDisplay(true);
        appmenus.setMenuCommands("TWbspDpDSUddkxWEVaU5HRiNPKaDF3rvFwe0o7mOYXqwRVcfc8");
        appmenus.setAutoSave(true);
        appmenus.setMenuIcon("WWGHvxOlvCJWAq0vTQ7YWwsvoHGERaFcC8HNigqQa86JlCljIx");
        appmenus.setRefObjectId("U5SqbL5yRFWTAi0hADHnTZvhecVTLpaS2zznPSM4y9DUaLbNUR");
        AppMenus AppMenusTest = new AppMenus();
        if (isSave) {
            AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        }
        rolemenubridge.setIsWrite(true);
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setRoles(roles);
        rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
        rolemenubridge.setIsRead(true);
        rolemenubridge.setRoleMenuMapId("5gl2P2O3dEm8RZT2Zu6tVbMdja2HlfZnNxLeCigcoofXNMLWdS");
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
            roles.setRoleDescription("eVOD1doKOzEASPH2MXsHc71rBRSAZNC49xx7rVIkvrwQfvNpHu");
            roles.setRoleName("QDlTmG1fiXtb9idgx297flY0HF4XQQiPOhvF0PNWDAnD5Iov8g");
            roles.setVersionId(1);
            roles.setRoleHelp("VezMyQNEMPmOOERF0XGJ8wz9EmxsuZf7Havp3kbwgRAPoMvSnS");
            roles.setRoleIcon("x4jvtwkAHYReZaMAfVI4BxvpnKKpygiIW16EJ2dVGAfr7Vq8MO");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "Ehpr8xxa9JcfrSg32zhv9T9JUk2XR5XX3yXqgkB7EJ4Cgkt4qv327hqXui2DknDNCmZXOeSeIwYZ6dcNOI90TRbZX3wM1MzXKEQJM0NSHI7P9bq2PTiVxmtiFOI5IMhml84e647FpJjpBwVREKQ38iWiPNIpOp6NmQ3G7Nbz0EiNbE5jlCnuIkvKdxUjdpBdIl17hlAXPjF95LBTlYxvkWXHnSdyfcJp6h8MNcYGCOKRDH54dNBr0yPRcbTlJiHF0"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "wiqT8eUT0n2uIaUKOPOWQx8pDOA5p7r0tmrVS5ttBcn8AfrmaaUuK6RVnOOrrWoaQCNErzyZmVu9VCIUulfAq6mC8T6TMPWHIIP22N0kfeDQE0IVFMg9u7m56mDCUx4r580nEdTSFnWt9VutMnuxYZ8F7xVo4jfEDUIvZ1sUOVyujp8GQV5rQrYWi32dMJXnrJ797psJ3iKXyp4lCW7paB9dPBCCzy9Lx3oBIlzjNK2XNuXWyytzVThHw8PfJ5Zlt"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "2bVvwW1RMXj0QAFBPG8JmJuoBi89DH4IKygZ834S9bqua7Cj9AaVNwlFSxexB4ApF"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "mwkkOvhf6EKnGXxEdBdYWZC0lrJpR5mIOHBbfMnVZaEq2xHZF7Q9fc31Cnlc72X9Qt480kpPyf2GWiecNTsYGHBhC1AyycTgY7FmjDgvwzIYWub7eBCeKpQscjDT8A09zOT3niOMlmekhAtgUrJCxF9M8hczT5EU3DmyfoWqRgojcb87rGzEijNqnnLG9JIkF0bgX1kqbbis59spoAMacETGKWTduvedXTA0LxFfYUmQ8DIse7CczH0Q50PK9iD73"));
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
