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
import com.app.server.repository.appbasicsetup.userrolemanagement.AppMenusRepository;
import com.app.shared.appbasicsetup.userrolemanagement.AppMenus;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AppMenusTestCase extends EntityTestCriteria {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

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

    private AppMenus createAppMenus(Boolean isSave) throws Exception {
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuTreeId("vEvaqBBtL8mUGaC8AIw0UJEexZ5ggQbjwwcUBwJnLLLz826Cvb");
        appmenus.setMenuCommands("V3mYHZvwDPp92AjIla3T3dolTK929Y8SJAGVTmEtvz1NKgqrfD");
        appmenus.setAppId("DujFXL9micBvrI1TvcvHQEBfHoJyjwYHpnfo23FmvuadgUVAJL");
        appmenus.setRefObjectId("gIoOlMcE44mu8V644vzp6kGqMMjsCN4jWzLalYNaSYRa2O27in");
        appmenus.setAutoSave(true);
        appmenus.setUiType("wJl");
        appmenus.setMenuDisplay(true);
        appmenus.setMenuIcon("TC5aVAZTI3LlU3od9cgMQ4B1g0pFET2SMtzYvLc2xJRKkYSLX7");
        appmenus.setMenuAction("8ljhB6JK6sc6dmF0G6MeyTvdksswPQ2GyYxkx78huIhT6h8dKZ");
        appmenus.setAppType(1);
        appmenus.setMenuHead(true);
        appmenus.setMenuLabel("MqAhikSxKnFX1pkrMUGY5hDtE8rlKDLFLyKR8RVJWdcuTPychU");
        appmenus.setMenuAccessRights(2);
        appmenus.setEntityValidator(entityValidator);
        return appmenus;
    }

    @Test
    public void test1Save() {
        try {
            AppMenus appmenus = createAppMenus(true);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setMenuTreeId("Ri251ZjrjzdQCC3Q1zO7L8GMs7Zx9q60R01DmboKyazNvbMjQU");
            appmenus.setMenuCommands("BC1rgDUxbcV8XvigN4V2eX33olCjisItMwnN5nOTE1aE99ts5r");
            appmenus.setAppId("SOHWbQGrD1Mj4Qhch2rWf6PvAg655l8hZjmbqF21i4I9wPDSvE");
            appmenus.setRefObjectId("x76CVqzLc1L6y36xDIhq0vFcvsLvh9FInXKH4VGDMCW3yWZfvW");
            appmenus.setUiType("rpG");
            appmenus.setMenuIcon("vhXxwudZH4YH4d060hCsuDRBzV6xPnQHV6pwnwdADYOtjimT2q");
            appmenus.setVersionId(1);
            appmenus.setMenuAction("niZOtqJamEeeaUwYOUxkD9xOFtmZrIb95HJshNPi1qK7HjnZ1f");
            appmenus.setAppType(2);
            appmenus.setMenuLabel("I7mbIfAxnWWBkGmNyWk2sHJx5EYDXPE88Xl23QxJVtJSAzuyKP");
            appmenus.setMenuAccessRights(8);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAppMenus(EntityTestCriteria contraints, AppMenus appmenus) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            appmenusRepository.save(appmenus);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "menuTreeId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "e1jVbyA8ETP17sd9fAjAg0W2cSOl0t1SXSCyItaX7i6h19DoqQ95G9jMBczMUGJLbOA5GmxPcAgXXNEBoeKUBSIryeaUDtyrIAnwQexUPoSlz8Yx2GXf4xfOHbWQHyi1sYCxgSuZ8H5JPubyBEfsobAeVqWb0GjOo7X00NSznlUu2M9hCNfGDNagn89BB78jznbF766hGX988xbFVq8MH9vLCcpfdL3ihB9TLwjgbK7iPL13CuHaE8oxSW5XilrSU"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "K88nCNlJyQLu1k2CLutl7lNdGNXSZ3cfHn2Dtd1PMNMIkdJgkafWxqqC7kYSNJhd3zXbnUQabrzlFwQAaB7JAfPu39wQGyg7A5Jk2gt6JtV9aoI6NS3kwZB9U48aAzkvuCzpCY3l5C4pzSS34vu5nu2NuK1hd6snyxBODU5gIaDrOo5C2bDUstRbaLfqmZsuzX5dceAlzsFg02MnKZUM3X58BVUrF8g1GRrF9XIp8QCN3WfZ00HtQgTUG95g8L4cM"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "NdIghiVm5hBVQxJA4jLackOrcO4JWLmJqqfkFJBsqLbb45N6Tj0ZfU1xfLZnjtf00co9f44kyACpsOLjShVVCEHrJ6dkOJHg4HvSFKaNrQPJjrcbwg1buHQfvlpKBcCh8z5Bv0NKCR70G2v019u72klcaSeCLzusLYOAngYJ03r4jIKLBMxrLgJJpyEwJbTef2nVttadqn1xDicNR2AKzR02d3HArt5T25luioEF4v22rXItmZNKeIlwurQPMvM2j"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "c0C0PGNG3aZT8KlhIDdEsmOzAgliaaAkReQIGK6NSfUoXqIGajrISBqgw7MXHUvr6"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "nMmCSdUWsJcXFnaihJOXM1iUpTgc4csiMIgDYu4MIz3NwmdaVBtU565wtcB01KZBCIFs4QmXhszmB60VQlxgIbEQ39dryvz4roD67UudZesrRu1busn9HF7UzvogXi67HndRlAMwzIyHtDxMzE5Ss9yKGMkpIkwQGzQcTx9ppwhGvpbckTtO5OyDOoJSEXOBjpCliMUvV4BlpOgpwcTHT8dVz2viEatt9dtiUocgyLgXGxr4bHjE6AB7LymFCCOUO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "HRFq"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "inHjlQf9qljtgbTPrTk64b2JFjjb0aAooIbWcRUwh1Gxyv8Bd630SIbI8XfA2U8DYdeHhTGtAstzVFvuxstOdiKVed93HP1EtltrAAMFafi7ZXKCYbYER1EoEYRNRdUsAAB2vFrV8bImz9UKMEvqG194p26glwqcCLmwWsovVlfpv9htm7miJZgmRPk1nTuee7QAWG4aZLJ2vvwkN0rZaTLwCkJwxPZ6a555R4i3Ts6T4nY37q5Ubi1PlWjRCoLK6"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 17));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 4));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "GPt9MigSq674M0YxHcbx5ZCxIgN8933NLryrLh6IUxUzO1k8CFXa85XBRSJdE0FipvjbYcheeWNXopcTzBYkj0o6eobrof52HP6IjeDZtFqqDTAcaTYycxqISGpPbhlMSJ22KuIHw8zR1OQOAycSfRmBxuiCYKQeuXDThSyHw335pDGsFQHgMPkkh96Z7PPZ2EV1uHXuXQjuybeYnepIlOKdlmimeZI440NGxC27P8BuCQ6WlUmFertELdoxN5wN9"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 18, "autoSave", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 19, "autoSave", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AppMenus appmenus = createAppMenus(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = appmenus.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 2:
                        appmenus.setMenuTreeId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 3:
                        appmenus.setMenuIcon(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 4:
                        appmenus.setMenuAction(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 5:
                        appmenus.setMenuCommands(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 7:
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 9:
                        break;
                    case 10:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 11:
                        appmenus.setMenuLabel(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 12:
                        appmenus.setUiType(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 13:
                        appmenus.setRefObjectId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 14:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 15:
                        appmenus.setMenuAccessRights(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 16:
                        appmenus.setAppType(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 17:
                        appmenus.setAppId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 18:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 19:
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
