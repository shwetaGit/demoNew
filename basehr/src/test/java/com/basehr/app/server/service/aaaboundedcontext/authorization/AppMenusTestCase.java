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
import com.basehr.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import com.basehr.app.shared.aaaboundedcontext.authorization.AppMenus;
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
        appmenus.setMenuTreeId("Za3SBizf9UvI1VpGEzmKwz2Ge3I19m34UmZD3mlJTNjcHg54de");
        appmenus.setMenuHead(true);
        appmenus.setAutoSave(true);
        appmenus.setMenuAction("WNMsXncW2ZQXfXvbABYP7dny4ub1bPm9ZRybfRpNs9tfBdMBd8");
        appmenus.setAppType(2);
        appmenus.setAppId("OS4T95k2WPcdoK2XfXTTjof2Pl6lLsrd9uqqzM9BgBvZTjepgY");
        appmenus.setMenuCommands("ghsOsf9sMrrYm9xsyS0pGz7pY9pIipV1CnJ2ovHnzpFgNEMRut");
        appmenus.setMenuDisplay(true);
        appmenus.setMenuAccessRights(5);
        appmenus.setUiType("MkL");
        appmenus.setMenuLabel("8aGiPGbVPNWbMRI4pKdDOf9v0vWroBuDE1Yre1g9tlwF7GMgvo");
        appmenus.setRefObjectId("PccSqHgBEdM8EhhI0fJqLx5DHy6asxvyA2Ex0QBFMLrX4SZLiN");
        appmenus.setMenuIcon("idkw0Cyrf95cD9rd4zNGBKREnSF1kSb7bdzFlTkScjregApIey");
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
            appmenus.setMenuTreeId("va3UpMnOFIEdoDlmaDAGynIX7eDS3V1oYsz7LT5v08Jki36y31");
            appmenus.setVersionId(1);
            appmenus.setMenuAction("LyxKQFJpP17UJIToaNzY0ptW6B2PyyTLB08MQQoDQFktj68g3s");
            appmenus.setAppType(2);
            appmenus.setAppId("SirPGUJEvXwYusxkaLyeg5kZESYgKqEo8lq34JRporvI91IdWt");
            appmenus.setMenuCommands("H1d2rsEY8WfZ8bOyN7Hl58OCZJ6ygsfar5hZFpib7Ew376KmQ4");
            appmenus.setMenuAccessRights(1);
            appmenus.setUiType("Jsl");
            appmenus.setMenuLabel("VUg2tUbXn2IMgcLE55Ff5LRxtXPMs6zd2iB78J1ErQiZpiit8U");
            appmenus.setRefObjectId("erWGIFWZalfIt4rNUmJTY0VJx3LXHy7I9DrvqmmF3Xk5iptz1t");
            appmenus.setMenuIcon("GID1iSbA89NycsU18suKssNGfBWCAzDVZEJrAxpeiqj0qTALBv");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "SCQ7WqoSdqkHHBiDvZ23qUVc64CEKTYKqTdtOD9eKQMc1B5VIsrGiXLL2zCYut69vvQjURCcE4LCnNy4C1ZB0NvagbWW8K4oGR8UUnKytWV0WqBI8yrt8kLdSrsbXa0HxHsIqYQ5p9Fwq4xXfvaxdJYt0CQOBt5q5x0oMFUNNkUPIkTlHLUpsOsGGVNnE2UvldNwcvw9l93AtpI1lJA7sHZP9hG92ikS6NvXi5wfIPjoSApInR7wLzQepi2mT1ZuX"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "3VzgBwc3AsaEwfqA13P8gHZcA0RhvXTBYcJxwl5kNWXjIX2KfTDlKisITeI3w2UQNAV1YWi27CUMNcqLHM7CtZY3KEotrTAhx4OoJHRq4EqbUPWQl9jv9fusH6yvbCLTUnID8kQNlmcu4Y8ZWu7IgOkn3Ifr0JyJw2oam5T8c86tVdN53UeyjW0D5IMX6fM8nBt6tQsOv3Vger32OSsl8m3FD8aAy2pocjQJRATlF8tEQUnWNWUXvaUE5FGKBUti0"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "vwVJvFS7SVz2RbF4f6aZop3uxXrvkCaUrYILRBK0zdHMOfIhKf4GgUq1uMbemEO06jl93boKMmIcJqjwjDe8FrWcNouEYpmklZ8gHoVReLjiIMLgVNYVQNPaN0J25J8I2AsTZ9dw1tyUpYvEdKg7lqnzbpiF3ZJY4tPgaUP6uYufNWsi9RCGGxuCDEdpSgDKSuDnau63mCOzbcMEeP0xDiYWINEQYUhdCLJ8xvpeNeLhdMs3brm24Gu3TBFOaieNp"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "TboQBB8gxKX7x1Ywi3HRZYi42rk87EHUS6w3AxgSLvhD1CI03lOtVG5CcFfC3CYx7"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "Myom7fBETeTB2fWRa6vk8Smw5Lb7bMRLjAIm4dqPque0yvmt8IvETk7i4pdJOqpXhZv6VCAdIIGOdhHaje77zclevFe7Wl8XBwtE5kDnLZSS1YIf4zhfzXeBmNt7qtlxb1BqjiAT4Ou99YeDZxaWMpXKuWWhfywOW2vPHowmBSu1il2IEyia5wwcgAfBtXldVPvRC312LWvoeI6rp5xlFZLKEmjvz1dPfVlefTMShuJIuowz0w83arWx0zkvUy7Fc"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "7bGF"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "lQWMEqvWS11wMJZtdWgAY2fAWQxxTujFO8d3q8ZM8ov9SglIpqPwUm3AsAvI3ts947Y023ED82MH5ropbjIdOuhK5eQTGiJaIrkcKmhAP6Oei1E8uJSrp4bbvbJkhPPJI6bnC8PduOcWCsIojTrCmpgxzND31iTrM31jBJ8cfA1uHAqDcWF0An6yiboxnVNtD3FNL7dR8VAWTaF53uZ4ZEM9yKT405ckw5GbwWW9rJIySIOO5Y920M2wRZLs2FfKw"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 13));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 4));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "ImsdSrlcyfGoph4j3cggPRDOKZ7m9g4RoHZwO5jHWUKbhYodqTC24fnS21l4nnZzY6t1pg1Lmn4pSZ6c1HAlu7DfaD7CVMGU4AXqctJn3RW12C3N6fZ25odccUxoxHKOPydnLU8Xcn9fFHU6ZyQYxQ1qWhZp8oDHUOiINdfrl8Xjs00FLZZ8QDC5V3nswbIUnJ0M5WwzfUE4EcyHyr5zMNYLdJ9dlVcJvNVpZFR552xqNalJe1gLYqSJwOlXU3IPd"));
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
