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
        appmenus.setMenuAction("pRcVjbT2ElSOeWKxbT0vtRKwSSdIJTn3Bp7UUp52x6BsMAfQ4Y");
        appmenus.setMenuLabel("FtjGSx2gmgfVToApYzFTSU8FAupLQETckxCodVOi5L8R72ixQb");
        appmenus.setMenuIcon("1U80a4hVGMjGNpjplxKmrum2fnD6BHDQVocrbrCjU31qgYuSXv");
        appmenus.setUiType("jce");
        appmenus.setMenuHead(true);
        appmenus.setMenuDisplay(true);
        appmenus.setMenuCommands("LpciRa7LKHFB25l69M9B4mgb1p5tMVkjX3rE83qbxtO4zLvDa5");
        appmenus.setAutoSave(true);
        appmenus.setAppId("94e8aR6rE53ZRzIEW9YQWRCvDthRHN18yLEJnmkzYaR1ZDD3B9");
        appmenus.setRefObjectId("oLs3DMMx1GcRTDaPUMVwGHoF80AvQsUD4z7P4gNRVcTbdw8cOO");
        appmenus.setMenuTreeId("sFsZ890xT7TbwxzA4IOXENKgdHhFVMYCxTe3yR4U9T1556GYMm");
        appmenus.setAppType(1);
        appmenus.setMenuAccessRights(7);
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
            appmenus.setMenuAction("QFHy1jHcDYz8OiZ5Xj8mFkNTLwIqj1ZkSOsnY6sDLYY04zhhgU");
            appmenus.setMenuLabel("Mpymzcag3zpQe1kLjBFptKXi0tt44Bu4DABhGwBJgIOK9A7xoN");
            appmenus.setMenuIcon("h4pIA8ldUfLFMjKUqJANbIfH76pAeCnDtRRUOZVRbtzMjiDAOb");
            appmenus.setUiType("rVd");
            appmenus.setMenuCommands("lOb2KwhHmPKHFEauUKKY7FQ3T5ueQm1kUUgtxzIOnwtqEnvCKA");
            appmenus.setAppId("4MDskWeWx40L13qTpQMH5PT1xDiznGxFkccQRis1TC2YUNTCtO");
            appmenus.setRefObjectId("vZQRxODssVTB78BnVcYjFQ8PFkfw3Z2sFw7blkXNbT6zGYuNca");
            appmenus.setMenuTreeId("U9hIMqZ457roLDXVZfuvuZMMjTD5soObzK31Lx35xoDJXouTST");
            appmenus.setVersionId(1);
            appmenus.setAppType(1);
            appmenus.setMenuAccessRights(11);
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "M3nvouWEHWgfizUrrrot2GTrpxF7KvHK1qTfNfmeJtkvyRHSx2tZKCUBCqgBNwbYT0LRH4xD5Qzallil0OHfUGuqUfpQLl1foxMO1LBVQ66HohLdQDrK9WlttXnDnp0rVLZl2CAx99i0YE3SVlKcZJfBJAw9p2CSD8QFlqIuU46D58GqyiPp19BjR0Be37moiIeazEQY1ZayQt6PZcEhU3dSC7n3MuG9u5YygTiDg8Z3iuN3Av6qJRW7fTgwJoIBX"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "ByjlKsTvbQiF0pwnHK268XgMu1ABLxuL6hln44Zr2m3KLFDUOnwEOLBrEIqya7QraaOYOk0utiscNPimuKvIitWoNtPhw7HXL0jxg9o7aTfldJzs8fXck35aR3GpcSQec4kfA5P6q5fWBBF0gpojpYWsl3dAkIZODHecj0IjpJ4O1T82zOHJykd74BETqP4rRes3LcoFIYbnGz0AgQtZKV14gzjvt68A9bq5IbFKxNrQ8t4KdbZamcslMfJ3KrcT7"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "Lm43xhQEZMMiiDPTbffXh08iN0btUKEPVZ1mVGB868ScOZ0FpD1YjOZ5d52uRk1jmibavL6JZ0IS9mHVJo61J8StC4eOK83KpJ6Yxv5mNfPvirGzGXTUUQPZV4WCjL2VotJFFwUSfBLB0DLHROZWBIcpIY7RHmWlSbx89s2zqRdSJkwNGkKZ4S0d0eZhmF2Zg9McOOzBgukt8Ic4qJSLYMDXAVkZxkKlnxRag3TKSQ8vBIJ7eI0tb3cjgTu7pGabG"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "E5zpzzuFJ3vEYteHssf1t194bFQBmmRt7xsN6lZSUNw6U7zaqiUgwahV5tEJgl0ly"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "E6IorPSsU4XBVg2jCXkWFN9zsapkoFVUGuIGgLNn0s1CxEW7T7KCONoXaf5ef4O452SZKqKkRIq98pK8SdsB8QCI7UPr8KbuSW29T0P7ztmigrVMOI0roiQbB0x6JjWgCNuwte8M081l5RK6RlGvuEAZssN3uF2XwjB9tv1ptSztOZYgEr0hSw37oTIsnCxo7lGejzIMG5F1jUGLiBRpioWvd8MqJuRBFO9rd1mdlmDDOac2yUvMOD6OIEDth4UPc"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "URJY"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "P1kHI5k6bhz6Pu65tEC4Kx5dgWfN0Cl8JS1bkQaV7S48deSBKKCNZgzbdq7nYY53Qy4bfKfxYJsCLPVPoTnw1PMTySZxnaLEyPek0ksfYpaibHP7iGfD12Q0XZ2mgWyLuKH9vXltfioRQjCthOzthnFKhYJMyHBQW7E5M96fTBtw0b0apQnrciEVIRocwS6iCuW2JKufzYKz0nOas6GwIRKCQBBHLYVNM6LpGrQJXEjvMaSrU5nNoGP7j47DQsFjp"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 20));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 3));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "gCr4KmA2ucORbijV230qQfiP41BFCyPLyp8mjAhc4CjwEq2u83zCbbrxZ1i5TsXHTSDXG36VvazmuWPMKlblZZL7dgWKVYTnoFLhtshYOAXyhcJLL9JeNlg6r16104G5ykLT8hCjiLyFnjGIrjwySUoplInC6qMpifRlbAnd0cEyWHOpZEDy0Lc8k61uI0pCxfDInjpXQnTclYdD2uINqIwadF1nWW1gfXQKa7JjVcEQMX7KbMiKEj5mfxmcrY4ah"));
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
