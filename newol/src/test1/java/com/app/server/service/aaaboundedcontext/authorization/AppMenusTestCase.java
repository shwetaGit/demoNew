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
import com.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import com.app.shared.aaaboundedcontext.authorization.AppMenus;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

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

    private AppMenus createAppMenus(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        AppMenus appmenus = new AppMenus();
        appmenus.setAppType(1);
        appmenus.setMenuCommands("wxI8dHVIXtyhY05SlrB9o9fBJAFiGq8Wdya4MDdKJx93FQG5Ul");
        appmenus.setMenuHead(true);
        appmenus.setUiType("phV");
        appmenus.setMenuAccessRights(8);
        appmenus.setMenuDisplay(true);
        appmenus.setMenuLabel("mPaMU8ofunZS2Zx4A80r4gp2jwi6K67eK5jwg5oNDNRdtLMCXP");
        appmenus.setAutoSave(true);
        appmenus.setMenuIcon("vjNyeAJH7oSxZUleqCRQfY8Uk3avu7SKVAoVDqtHePe9sNbVb9");
        appmenus.setRefObjectId("AfyuOh4sGDFTz1a8FzJEa09tTkHSXn6SXvtX8MVphnu7BP4xdF");
        appmenus.setMenuAction("dlULaXsPdeloEhiADeFxvZxKnl72wLLlssdbNplznXusNljcmf");
        appmenus.setAppId("UbKpfpxVpSuCXVD7zcepiaUD8xVb3Sf4386faVCqLIvdJzjSZU");
        appmenus.setMenuTreeId("5Vq7N7LScOVDYlaQVUZC3qYa5wMh9Ge3YXiKOveMedWdUEbRnA");
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
            appmenus.setAppType(2);
            appmenus.setMenuCommands("8rRQEqAoB5qI6tTkm6RD8AqAaHO6o4uj5Pt5lb18YLhGfBAWTX");
            appmenus.setUiType("jZp");
            appmenus.setMenuAccessRights(8);
            appmenus.setMenuLabel("yyq5YdTd5KbxWGnEFCd4IinatXYuHf5hwnuLROf0s2zVz70yqo");
            appmenus.setMenuIcon("cihEd2rsLOI0NFa4XwjCwc2BxtlZ7jvGbGnjA3SIgQ9ODz4XiO");
            appmenus.setRefObjectId("u4ORxBh5xlwzMITzTkZ5mnIXj0QD1xL0U1kb7PYnBsh979tFDp");
            appmenus.setMenuAction("00oGdYX1UGDdpDE0khe7xftpszEsdC5jRxiD2iDcVX2BevOK3L");
            appmenus.setAppId("LNQ7KFhUfXMMJ6WjI9gVl7eEd5aMIae5plNM2LWNDyiXroHagi");
            appmenus.setMenuTreeId("Gr0nCp515BmoOnVWnxR8ovTFGNp2bk0qBMcSxFs9ndhKP9hCCi");
            appmenus.setVersionId(1);
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
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAppMenus(EntityTestCriteria contraints, AppMenus appmenus) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "hMvNfYwNb9lgT7bllr8mdJfVkrml7gw7aobmp4mYquVfEZ9VjBziNv5d69FSh0w0wSEJXudQSsKDZi2jeuVmX6eVH1AsGK8hrtkvBUxp92SuTUHqAg21lHnU4wZdtkpiYTUnqfhx2da0v3BxhQzvf04jWs5bFJ1ey3atI81Gu1mMaDptJIPW1Im45eGh0llY6EAKFBQYYoxRWf4hyYg30LPZcurquf6ox7EsG5bsgRGJDu8J2N4f4Wy3oFMan9SGR"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "tQDz6anhQXmb876Z3QGftHvPwLYdvUzSRMWBOgNaQQlHS3prjfmaxcXa8VwJA18KGrYw2mSBlMSoTToTxRONmiecQzcQM2YdDnDoKNfl4VtDvzzkCbU6o9zFqfDnUORUVgZyrurz3bXmlENo8z2HVZYOMs58gav6X6RYH792PQlcJpZwYc3Fv7syplvTLNLX2lJeg9PYJOnqrTQQRabfK2bhHMWGzPiUCKhoOEP1MxNKPPyvSISKEcPoiy6sGluZi"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "9G2joQWfemIdwPOmBkIvbGMPflWqAlVAI5N6RLz5PnI94Ay03xCNXmzYoNJRiMnDvauvtKQhC0A7SODhk1rI59EMpn7hmgK3otE31ChWFlFxRNe6NrDta0gbufUEYoTj4Vu0LvlFElUJJFw42nSkAyOhyw8YqU4qLoZUmBtLEKBVffbY7ZbG3173lhe3Vw1rqgQyFyUFruDr50i7mJsLwfz1nFwu4TZywkqUh8ErfqHhfEo5No1aBtsFsXaCx4Rly"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "BPPd5M06wAEQUSbq5Mdiq5KAC7l7bUnAjdcPSZQmKEsnDwVB6PDlN97zOFIvU9dpY"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "HPoova1MLuS7qAngTHJMdM9dgDghakl711LON0liNAXeleqhujejqhlUNhV4cL16dh4yUZ1OPBGBXOkROLHL6N9uAqdJCWs4qVqUT2VtZPqrAzKLOH1hP4bbZP03kHuTalNAaudfdpQ4kQPi9ffHwKWHPyfbApMFnzYDvL0O0uGjKitolxTozWdWMv21JevbmbVtOFGVaMAzrUNDbLkKWy8hKU7VfvVmzA8AEfzqFnlkqJ7E0hcwDrAjpfqNMkMcS"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "NIEb"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "ITBq5VmP8ef3nHFJLLc2MvDqqZNgUJ0r8SGvOGgbyws44e0l9Eg9N5jTlTEvYKabTMT62h7R4akjesyCfF88OqovaWxJEt4qyt08187LPBIEif9QSPsm1cvmYRN3AZzgw2jNWAnuEf8uMW3EDBcNxDEOmYAd5NAsoNcNo9o5CIUljeoL7pXTkqpFvA2BRbCZokjWL6QIn50vbctJhJ6NBVVpAbWPiWOKrH2p6MNGu1NZM5WZ4jNn4ttayuCIRvRSV"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 15));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 4));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "sH4B1GsrAYnHyOahfStSV8F8ONugLQpPuBfjqWHmthJChQsRkcuZSc2n3IJKPEqVPcF27Nd470laD2aLIM0yWjdUHdAnHzxsZgivo3iXOwqBXUZU1KVaeKbOlmpbCU5JYOCGtxwXBeHTWp2Zswlj08nTwF0KkZ3dllM1wSybsaVE3izm51zC8HJn8tqUljhdYlaMO7IGyMA1Itm6BD3SBPI3aJhlbRgYwaixxmyLEkF2ifrLHGzXcz9d1r12CxTl4"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 18, "autoSave", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 19, "autoSave", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AppMenus appmenus = createAppMenus(false);
                java.lang.reflect.Field field = appmenus.getClass().getDeclaredField(contraints.getFieldName());
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
