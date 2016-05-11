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
import hrapp.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import hrapp.app.shared.aaaboundedcontext.authorization.AppMenus;
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

    private AppMenus createAppMenus(Boolean isSave) throws Exception {
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuCommands("CpEMxSALAkskYi7BQA94ChWNchRYbHqxc7mthgfCvRJoKZxunB");
        appmenus.setRefObjectId("LUBQrpzl544jDDSbHzAS2x2DwbfchOKloXaa4olTrm2vptOJZG");
        appmenus.setAutoSave(true);
        appmenus.setMenuDisplay(true);
        appmenus.setMenuLabel("ZxobaMryUI95BsxVeSZCtw23cMNZjO7T3lCOgrD4M7o58iwfZL");
        appmenus.setUiType("5kQ");
        appmenus.setAppId("6Z18rEU0aIToTFvSILo7ewRfZKxJHmnVXeFyzPgXgs51uJ6cfx");
        appmenus.setAppType(2);
        appmenus.setMenuTreeId("9WSk1gb34HBlHZubLJG04iUCEzD8PIVdmzjwBqrkYOSp8232Eq");
        appmenus.setMenuAction("f01AGsYoCpRVOJPHqBhXGsH41RLm6jFl8XWrNgOGyyq2IrbLi8");
        appmenus.setMenuIcon("9L8jyiyGIL9Q2E2mnyXYNYsT4tEx91zEKAJFvzKjrppJQw8uvf");
        appmenus.setMenuAccessRights(4);
        appmenus.setMenuHead(true);
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
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setMenuCommands("GMwfI7vwQ10v28WzxEnXk7mRUrf2wtmUss673QhO80jOstj90i");
            appmenus.setRefObjectId("om4xT7YvxHsQa8selHkFKUnvYDmoXKFtxd3aeHwLab0TFHUoAg");
            appmenus.setMenuLabel("R00szq2iws2v9vRxs74qwgiuAG9A0EACV9c8YS0gZ8YO46CObn");
            appmenus.setUiType("3dZ");
            appmenus.setAppId("p81tcfG96aPff0CTbRSOS6fSUn9fY9qbQs5kiD958HODgqpGsY");
            appmenus.setAppType(2);
            appmenus.setVersionId(1);
            appmenus.setMenuTreeId("oJBAfRaDLNxofW2NDMTpHeFKoa8OuhbiEfXYB5BBoFOwIITqL3");
            appmenus.setMenuAction("CnO7fulrIpzOddtVVxJWtKyGgQ4fpsVsi9v8nXdwnTQWMUqPTo");
            appmenus.setMenuIcon("bNDf0Lxu0WQSIUuaDX3YjGHYoB8yDcg9i7hGnSi8AjVKWMzGYr");
            appmenus.setMenuAccessRights(8);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "wKsOM0HfNhURKVkuhEbqRkd3ELUmat4ssfvQjbdV7TgwAY58eOMMVWfUwa5C0pZ8CgEduMjjaXc8AKyhgpZJ4EgqlQdUOGy67ExSZAa9wzNKLwYgEuzmfx7U00ZUagyYVWNijLcexKXv0YVr87lb1hoOD0t9J8BWCVres4jOHpeVobP0wXTG3kIgPnOYz6EQSECqDTQ7A4eFOYXKGrZwEPf00gc7bo3uT6IcEH2a6iHcxwVBqMuWSD9feqoldPIer"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "BLH0QblorhW6u3rCFF9rabZzwHEaaMusEOylL5Ku1tivk4UIvCVQ5VqImzTvrjNNoAOKx9uVhRT5FXFjiA7R8sPpbXBXNYOjIb40LTbxEqrQBgTnVOUWDf4P8DFRaZWohVKySRLfeVpV4B5NpRU0L8bSmha8GYczbt6J46NBa2IKYR3JpUGTWlRLyWaF8s75tMJesDYA7LwQqAEugyfe7yI82N9nUa2WQGDEA49vy9q1sXxgsOwp9UKjPLQbrow3l"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "8wmODzSMp1KVK8c8J7BugOQlSuYmQmyPPKX4ODHGDhL8zHJxHfuuEifugIpr9czgh4PyIioOYTDy1rXmEj9kkacg5t2cpGOpUj3ZShPbFGdITV92snnuDkNLHXMwRnpRDODbiIy0uIcCDoAfGh1avTOyE7d53zahdB06C9HIDU3vnd0SVEiYAXfZFqEDHbNUk7AGpyt4399DqN5mgGhovwd5Ik9m2ZUW5Bc19FbSL896AVnas1hctFB7k4hMrFlWT"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "hwcitlBJDERN1OHQFGzUyXS2BU3IBgr4arLysuUSfdC6VV5LGMnUQcK634ghFLgoH"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "zcbsOOjbycoaXPiGu4OV0ohAePX8UacMVRBEAQk7cKFUsHVA0ISNyS59m4uPbRJqkihGkHx4RMbkXJTfAXjaEKKAyBKewspULF1RHVtEgopytXxL3kKGdIMU3O8NW7y8pdLthJNYzZDs6RJPR1ssfbhxmgtyH8JXrchK8Kz0fttN3M7dbYKw6rLvB5VN2VvKwWGhCSIU2gXxQqgCi7zL24vjxDMncOtyu1pGhrHMKqBq9Khd92YPPNEwey18rw5Pe"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "1A9N"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "qk36Jvwwx9GQQU4hdps1YEhkdN9m9EWaxj6aB75GX8AzJwHQeEy7J7ASCISbpdDKz9eiIDKNh6itqGcMWBhTmx9Pq13aLlpV733fD1WsBAHHEDXpRAt15F5N8lOrT7Tp3VwEc1p9RZmd4GKpWUnC4vSatixbpXuSItcpnbfSIBDnNEozIEkrpDUk9Itg8IOJMojExYSwjQ44Zf1H9tDD6eDCnqjGARlk9NP2Pcq527ujfDR4VxnSAOrzIVQQBkBGI"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 15));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 3));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "QPdPDmQufmhNc1QZAImJ6p1K5d5RrcPYi97G02PsAPoz6BoNasq13m1KaucKYOmL8Pn2sUWz5g5c2HKCLMagUOoqlWy5Wf3CEz94x5tKXxe4o23pXfiyUNI7jBQbbCJMD92SJBj6E5Yyti8wH2Ik6ngB80lSjhVWdusZY0MdGsNjD7nwIi6ot2WIhyIGoinFa6GwbFTkMvkUQ8GgUTDoaxo1B14Hu4J0ONchNlX0j7RE1FR9FH9MYTFIg6y2lhtdf"));
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
