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
        appmenus.setMenuId("QDBje9bhM0bQ7F7QZoyK9Cjk1NXYcuHnJvM5gQIXAIYgtw1LIb");
        appmenus.setMenuAccessRights(10);
        appmenus.setMenuHead(true);
        appmenus.setUiType("Pr4");
        appmenus.setAppId("NoDrDGOuURgwzD4hBti3r9d0AIPPOdrRsdWnv0PtSjhtc9ZzIb");
        appmenus.setMenuTreeId("yxbNpiDd4CguuwrUy0ux0XwGsJQSAfrtQw0TNj1UHG4t2ya46R");
        appmenus.setMenuAction("gM74GRT8Q2XNYyljpnBfuKRuryiDiH6Fuz22Q5w8URHl5ZvD7M");
        appmenus.setMenuLabel("nkYFjCuQ0TsFUywTcUSCtTW97u3eAG8Ukh9qV9hRkhuq9zzlsu");
        appmenus.setAppType(1);
        appmenus.setMenuDisplay(true);
        appmenus.setMenuCommands("s50FntnsTSm9osdezwzgqUJN3AS5Fli604WWTX7Pz4P96ElL1l");
        appmenus.setAutoSave(true);
        appmenus.setMenuIcon("rhwCC9sez2A4ExOBB0EprAehdJdxHRsIHvYl9iVGM7PbH3J2Wl");
        appmenus.setRefObjectId("RnkjGGRyiItmIex7lrKu19IztuRM5FYPJ1Dogsv6BDVBCiOdpp");
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
            appmenus.setMenuAccessRights(7);
            appmenus.setUiType("iDS");
            appmenus.setAppId("M0WntAXXxvrBNSDEToTpq5qrrAS9mtWEEudO9TMRQS6Ys9DBSB");
            appmenus.setMenuTreeId("eaGFbb6cxreltfcnPrDrvvF4anuJSdG0uVjSX97VeKCvyBymsD");
            appmenus.setMenuAction("tmnsr767N0Q4HAoE1sK5dpqCGeWe57bqqy4UUFgThGKgZorAYj");
            appmenus.setMenuLabel("WjrxQmbqzIkqXGGkCXdNzkEZe3badcMIvqKoKX5NlxE8amOItx");
            appmenus.setAppType(1);
            appmenus.setVersionId(1);
            appmenus.setMenuCommands("ncUalx8fF67HvODIT4NCZYRVQQnrgEsBpqIuS8F4kziewnfG0x");
            appmenus.setMenuIcon("UyyzJwuO5oRnHkcTxmngDSfiwyvpw6scQ4Q9LklhX54ESa56N9");
            appmenus.setRefObjectId("6JgDsdF2VlAMiBCbvABTKQPhLN4bri8nhbbaioOTxr56RdOygY");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "m5QTMVU2d14Oz1AY4fB8vy8xNJyza8nKeCiclWi4W41MU0w87F1GCyiU2p2dhiKVF3gMIyrX75bMpbzgi4zpRCxV1FVmGtLTuiZUyhjUkRtdrdjeYvGNYiXquNM6gDayLqsmGqEjhac6axXiz8cgrz49xVOaK5fpSQuxEGqSixG7OwuV7w0pQFmTpXeNs3kWKOuobExYy0gWxVMsTIrRZnbM2kDxBAYLRB91IRjwH4xBwpMFJScwu1fhBKJQZqJFN"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "6pgdnNoslisKXQ2IxOvNs92EiPxhkTdRbbkvGXMRM4hUYfxqcOD2HNXNdKJgLfZrK42tVbhgLhb0LPHnbgZl9VVez7guQW5BH2MSfIh64ct5r15rwzqd1EXlGJXxKSipcV7IrX9J36NiA8bKYATRWKPJ48nX2gI0TcjnpmVhaIhhF8JV4GvbN99j2HwC5i3se9AgGMjaH1P7mR8XUGDIHdGpnBU9ETi123sHQBeXcNzjMplem2TGFe24OPWxyv2C8"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "fZQUzdEH7vv74SSsFPMoqsPmETF0nT5Mq1ViXWrwCQQ6bXrtQz9xdulvErKHU3s7bSkpz3ZbDHn8s6P1uA8VeQCTOVoxmZWx4gZGBRgKZMcGLKbzAHuThbkWuV9HTrXOYHk6XcwRnb6vOOnZf5DzoLmzku3BIIHrA87MNMYbbzwEcSsyNCbkn7AWqpCeSrzGaDuvzI4iARKMXc8cpC9WKsuamUM4PqZg9vVWHnU5lmzA1vtvY3w4uGe1Vqz6aDPfD"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "30a6RlW8C0VcFTNHNNopZaMVfSo68Qfqx9C8ubI3Dv0e8wSbyD9zJBtdfT5LWaC55"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "2kHzwFBu3eab3sAxgmIBQmcr8Rc3ZwjYBnq4RligDX3DvxRe74NxpRQwI3rFcjWTRbH5o8DL6WTc873Yksojy662eALolNauGtXTzGrhiPTQWSbOyVKfpnKUyj6GQGvokJrrKzHP4Z8uBIC8saotcSejzbib3Ameswbvb5eOz4uvFLCBCYY7GJdTcjqVCeUq7e9XwOCXDhIF9S6PGyUkea6zsoqPiGbsZgsIZoO0lB6YDpALwJTqSJnXoQI8Q1HTd"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "mWaZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "dHdIFltA7OO8gJNTa7vQ2eLqPtCcX8gVDJ3sx4MW2Y1B3UKyznLbyefSJJ9JYlRmfj5s1sfLdtDMD6AA8EDpz2js1wFvaiCDKBP7ENfe0PSkWJBpkXLzpyZYsNKmiKAFSu39pIs13mMOF15Bf14EPb2lxUFKDZuzqKlh7Z6GOatuavgkSojS7XwgYUJ0eybUQz9e30hxEPsCU5NX0ZF6gMfpbQyamRybs2DhrZFFk4FwwXN2NRino7iwu37CIUWqE"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 22));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 3));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "z6ifSkC4ttiNhItCFWiwm0dJ0uUkJ5Bf3RuakDqw9lEElKDya3JTih4g6xD9yQhtmucIBue5JjGagKIlaIf87xAx3dOn22yzIbq2zjIsWzNMK3ODGm5oTDRdih0jv4rvfAPeQRQD1mZDHTkieSDcwVDpySVTVqQL0z0d08QImze6fCYyO8eJrvpPscQG0eR0pUlHGG9r4ufcgyMVMU9v0aDm3LEpdoQetgZjs3o93qju3EHneyqu6dvrPU7Po8fYR"));
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
