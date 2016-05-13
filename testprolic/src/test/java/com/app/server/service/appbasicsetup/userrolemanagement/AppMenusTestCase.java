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
        appmenus.setAutoSave(true);
        appmenus.setMenuIcon("ikcOjcKlF7qcGKPSWgLfvOJsm7B75xDhVZXyv7oAYZWMlkauj1");
        appmenus.setMenuDisplay(true);
        appmenus.setMenuTreeId("0iAZ9SkjWHUKML9EjDcNz9WooFWMw1vmkD6tiH5IocXUAMxoo5");
        appmenus.setUiType("446");
        appmenus.setMenuLabel("uaOQnbOvd0iNHHKlIKN3eZY3UyMWN626wtkTW50Ibd6Lg0AoMI");
        appmenus.setMenuCommands("9HtVrQuyJ51WtzKR8ypdwq1h3TMwpVABlygSHJxUfObgDqVtnl");
        appmenus.setRefObjectId("FLddCeEnBCNNKajjyJJEZTXfkzS2jSIdSlT6thqCseCowy4wlo");
        appmenus.setMenuAccessRights(9);
        appmenus.setMenuAction("QleZdEZNGKwQyvgxDpsE0JGe2R8mScW98OV5gd0ulRBVmVxjpk");
        appmenus.setAppId("LoNDgiQkHyYGXnJgv1ImBN9BXE31iEXPrU6yfxixAJm5mkI7M2");
        appmenus.setMenuHead(true);
        appmenus.setAppType(1);
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
            appmenus.setMenuIcon("Migm6xnvelIB4YzrAje79NgGZ48K8A3927u5k6BeJLls8efEu2");
            appmenus.setMenuTreeId("KeXsU969tAxsx9UdKjKXHzzSMqKrCPxjiJDdORKlemxqUZfmeK");
            appmenus.setUiType("G5u");
            appmenus.setMenuLabel("SgMlu4ug2ZelgVMk3mMVIoZVZSe3OHPtJ5BkByOkEz7CRGo4ZH");
            appmenus.setMenuCommands("qiprTmCYYTymB6EyLOfKAvfRnPJHK92iUU3Evn3c7aDrORr0PF");
            appmenus.setVersionId(1);
            appmenus.setRefObjectId("8thpNIGdqY0IDcgQMG88cNB5QMTfWZFUI3xucYXW2I7yMmv2Ff");
            appmenus.setMenuAccessRights(10);
            appmenus.setMenuAction("9tJsaaWrbdx6jR23LxXgrWc8SXqvse6mR4Vlc0u57Ju9XsWYU7");
            appmenus.setAppId("3fF44oeZCuavXfqmma6FLJxmW9de2QtaLW3SeC2BZPgHzk3MUM");
            appmenus.setAppType(2);
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "GVag2VfpfHLxvFn7XDoaVqB1u7chFYJnX3J7fUpQJobxkXE4acpeBFuqb1yqXIGAlOyuNL7ROaGcvEnMzZfRbenVJXdRWmiZS0bnBp2Bq9B2NuGuLOI27ZySWEQ2M0kzXLmkZl01fPmZdygcN93PlXBye41VSoik5mUWuheKYYRvsLaeR7Mf7FsJpA4YBBnRQHzUV0Dtdbv6hrcPAJorux3o8tOvSv6nVRrW7PWQlTGmYHh0sPJtHLOdnLtgO1lfO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "6t9zMoQxYGtg1Q25zh69K9lO4hRa8Dx8C7XlVZpX8ba2YJt6ZYuBXepTInrpWlrlao6O93WD8w5WFxmDKE5UlTsqIra3cUnaYMe7rbBwmzVOKHzSvCLHmg7SNn3wjunchdBdt0DkQ8sZvdPtMgKGeLU5vKJqHVeTUeM50N2LPibdHoS6Bbgy2GHD4Ic2WjRFxzdMq9NfCl6VHLBTzXBWvFp4N3fcX1jpEet6pqwCRxXYr5ts5MPdf4gYGfxhdBDDB"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "NnIfRwC8LEpuariNpU0A6MpVt0wMbCRvalGGwSn2ZjSyjYhHWi3cDSE3DomeQCLPkWAOM3yy5gKWp5tL73l9n45Xn1ec1clpKUUZ8gRMabhr6vEWwPvDZ3yb6XDdPZ59BJPhWlAuO87tx1sBaqsjw5e7iURjMahXglKOi60BNJmFIEUs3s3422eKmwVhBX8mwQULAk7VUMXDO6aj7ASmyfMYYtuG9d0f6lWi2DIkxTUZbhwhlgw9H2rGcx9woMPId"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "EFqKVxTG6ZXxGiU770XE99OITfAlVfZZYGQ4zCsSFVrabw8ZwrIW5Quc1OmPV2Hs2"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "jUwdn7TJXRPEZJCRm0fZJ9Vcd65RnXf4LWGGfOpmrQXh5dCRkmr1UsbINELOgzot3bGImdAfnFr5K4BLYyV3AR9EwqRqP1x8yUeMFc6hJ0D6Cw2TmHJKmObOLYw2O1HtVvcEywICszsCRgZvho9usINaeFiKoKaeGp63XNTv7CuCEDCVsvv3sNGEEQ337l2TARMcZlfJyBMFDMxXTrkaPesLvJvk6IGEYrwoKvoqv4XsiQjXfxBH5PrHKwOA8ZAAT"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "AxWe"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "d0wIS5etAsdPzNF68FpYJghnVC6iwjHVXXb2yGw6w08W3WIMUNrT4bUJnzYFZeWdVU3CS47nqyd7K3956rWUbD6rXh1TmToepkk0m5wqTOQ5URgPEfqKRoWZRoMl0xOWZCQyKhWae7KHGYs54eusEeA3dXXayjeUx6uB8299HDfhDN6HJKUj7X0zeS1LEhD85KPVwk0Dm8B0rp3b7RM3D9bHL3ocmOp0Pw1hF3dVOwbTBQi3CIij0iOpkWCwfBjah"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 18));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 3));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "zPetYHbrRF8DN8FfJdBdquMpA5MWMxQbSloXxwDNcWG8VWit2PP3rGiTJq9Pm0zuw68MuJzdL4DPEjGkU7fEgG36lzUVkcbM9mN0cezAXHGSpGRKx2J6m8cUhJKpPxgtxGiQg9F2AzLPdgLy7uIST3MVFkCz7WmowyOMUVFL8kMJQO4cmeupEaNrPo69clLGvkUV5yaWoWSPd4oObZCDTUqgckRo3YQTiE9wMWKJKNB17FepfzRm7RxKc60bk0TXv"));
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
