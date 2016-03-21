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
        roles.setRoleName("vdPDVOKUVDcDB16fbXsrKSiulaNq8aMHuDsELroZz3bSSv9TfR");
        roles.setRoleDescription("j5yk2hwATNSokcNNVsOSY3GN5wu1DHbYTVnfIVxsb8dLKRCeHW");
        roles.setRoleIcon("NXGA0NG1h9SQG6mu6rGIchLehzNUViDfF1lbNgGJvjZjNPgST6");
        roles.setRoleHelp("tnTxVIdKEQwXxddgPWPVUQwG1UwpXbBGcOKl748nHl66HH5v8f");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        AppMenus appmenus = new AppMenus();
        appmenus.setAppType(2);
        appmenus.setMenuCommands("YGNWpM0FW6pKXlfNtPAbn4KHyXfYlqHjSJJBWM6AQrQDym6V7p");
        appmenus.setMenuHead(true);
        appmenus.setUiType("XI6");
        appmenus.setMenuAccessRights(11);
        appmenus.setMenuDisplay(true);
        appmenus.setMenuLabel("XLzu86b6k1SHrfrn9SQoemwadm8wpSfvClZzYV50w4YmwsKzqG");
        appmenus.setAutoSave(true);
        appmenus.setMenuIcon("5R49PtWHabRP3LhLRNnfAnsQ52t4Moc55lC8MA9F6UqHLRcJ32");
        appmenus.setRefObjectId("am6kmKaPTFGRH0fKZTrKOBkLg11Is7CGTS4XX8dWiE066GpW07");
        appmenus.setMenuAction("u3KaU7wuElldEbPLfzrSWdbKuwRcL1Hh9RLIlGreTlbqTil305");
        appmenus.setAppId("AMyH1RjxY3jzlDd7zHBbtjz9LpSf5242KW1Gv9Cez2qQFteqYq");
        appmenus.setMenuTreeId("6XNKmzicJlCXZgDi8Za91cbkJ8QaqL636wHGMjC0AJ8QgtJCNu");
        AppMenus AppMenusTest = new AppMenus();
        if (isSave) {
            AppMenusTest = appmenusRepository.save(appmenus);
        }
        map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
        rolemenubridge.setRoles(roles);
        rolemenubridge.setIsWrite(true);
        rolemenubridge.setIsRead(true);
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
            roles.setRoleName("BUJiw6fnX5wwHUEWrxPekLQdJMsEpCpJHVZTy2Yj0G96WWGT99");
            roles.setVersionId(1);
            roles.setRoleDescription("wuEJJARg7AJqt2qM0kjB2ayq75Dqu3dd5OgjFiyaNiDcCdBFNi");
            roles.setRoleIcon("peX4Y2RS2EjCIooi29FZ1zd5DM8U3FIIDymHr0kREo52MFEL1e");
            roles.setRoleHelp("RTuytrn9tJCttpgO2Bo2NHSf1XG0ihJXZaIjxu4VaAfJ9sMLml");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "thkh2hl7x7RFuoQves156ILci5TkS6QDZI0y9rbB4j8yoxQYZW7JTBg1YnmvdkSqXlkGJoBmmJtTjOD8PlZnTpAQX7B2lAq1onenktvCvbGVQ86cdunV8UpHFns9DeeqT7Vi5JMasjmPnHhsbgZiKO9e9wlJU9pwYL0Q2vJYI3DccRamplbvVPqmtPHKqNakGdmHGCqjwrVDHKpw9CFfSq7dILo3Zcg6VKZhEPMbFBclwAi54jtwtEeu6oirZ7HMb"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "7FrSZUnxOjmbzMEgNIRoJHAP0NTyMhcU4HcQKf7jfTjuIQ2Qre8mv9NYp88H40mEbo79JvlUShii7iOAJZ4BDkTvYWv6iBJU1LcH2ONlt5cDa68odkKDzKSPiqhV6BEkx5qwloJ3uAt500gZQmBcjFWI6S7OItZZaYx07gb4TRkzVQ4pFLQgFmVH5B2uWP0EYBbBlgJniy7PnVtHiipb9OjZce7xllLVtLfXbiXdqi7UqUc1ue37PDiGCRBOylhBO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "mZj7tfP4Y0CuInrOSIj2Xix4RBg5wkG4pVxKRPCK6hrZlPLklf54SwJSt6wmIiwID"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "m9uiEJA75p73aGg1LlFiO3FfwdrjQoaK5LfV6u9mZNTqCoh01R5cvqGCqbR403UBR1SyAwgRQjO7j627hX5CLmVhwXvDdPvnXcM3SS6HXgX7ATdJWyqQxWmzCPRs36TOUKHjVZLf12N958EDlYIbL80cVZNvAyTzBhpQ3Qz0sXPhtV4qDTAvLWOfX9EpAZqdidX6l7bet0tJ47G2RVU6GgzlOMbftbgEcAVQwfi4OZ2hosd6g3CJUcBgxkSotPkzV"));
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
