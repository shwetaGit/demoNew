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

    private AppMenus createAppMenus() throws SpartanPersistenceException, SpartanConstraintViolationException {
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuTreeId("bcA3VSxFWjLAAjz6MJjww1dwug8pFLx8ecQpXk8cEtx8PRKW0W");
        appmenus.setMenuIcon("dNnm8MWeLvju8gSDAPUh3Utyr8trmbmK1D8EuknoBPczaec5Tj");
        appmenus.setMenuAccessRights(7);
        appmenus.setUiType("0Ct");
        appmenus.setAppId("GOHGPszNJh0Jxj14bRwmJsdEecL2Iscji1elccyqysWu4NZ6Qy");
        appmenus.setMenuLabel("PvmTaewrG7gFgmLRfqUHzOOCIpmAB2xyMc7ZhaO1WfM9yWIlog");
        appmenus.setAutoSave(true);
        appmenus.setAppType(2);
        appmenus.setRefObjectId("KBQYL4PYxxmgd434PB9XmfvjH3pD1soZBHrGHfWkmVROWiPMiX");
        appmenus.setMenuHead(true);
        appmenus.setMenuCommands("Q3yWQhwxz8HXqyiJp0PnKsxLZthfkoWzQCx8WK4S0v4jxuhpd6");
        appmenus.setMenuDisplay(true);
        appmenus.setMenuAction("ievqGS2UuWIcWb1h7iDRaEF3w0JgL9TDk6hlGGSXYkFONFowNl");
        appmenus.setEntityValidator(entityValidator);
        return appmenus;
    }

    @Test
    public void test1Save() {
        try {
            AppMenus appmenus = createAppMenus();
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
            appmenus.setMenuTreeId("GCpcB4Jnol8BR02UrARS04Din4DaY3PqtGQV4CmzIJUyieKYWr");
            appmenus.setMenuIcon("kkEvVSwe48PnkytcUbQatI7Z8Q23iXo76i0s8Lz5dbDG6E54yY");
            appmenus.setMenuAccessRights(9);
            appmenus.setUiType("gvh");
            appmenus.setAppId("ohDwLjbAKEHoa5MeGvHJJHgI3NHnnUqac3Ss5gcF0syY3PtH0S");
            appmenus.setMenuLabel("CrYZntft4HGEOMWFp5ESOFSOkU3wZH08vXEzcpHwYYNVYEVC6E");
            appmenus.setAppType(2);
            appmenus.setRefObjectId("vLwH3IotOi7kQl3McMM8K3x7eUr2k9g8WtLtbOzqktdcT5mKEP");
            appmenus.setMenuCommands("6qQYCCvFobDYEGJxlnhODX9HK9uyXWWOiLgY4aQCcJbYpr0VAx");
            appmenus.setVersionId(1);
            appmenus.setMenuAction("kXJWqxquATH6IpxNMJH8ZIZUEx1qL1Upcgfo67ZfUfBRUjOYy6");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "0mPTtQsslJ78lsKAUaZBFTOGDsnA9PxIM04j80wcAgeVSImFu3O3AIf4osl3sZW9N1WX5kPW8qQizGiDphcm5VM3pXcY58BhsZVq91txcVJ3M0BHtnx9vaITKdSNqrdDq2naJEt11b1lsSawTLQoWQmUY6T74Dl6pNlNd9smFNy693T8UCyKYYdp0uI1w0e6WRt89Xj2TvNh4l01Da9nvGX7ZQT30BV2k8njPhjW8c6k1P5M0ufFHglml70dJUHjM"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "fVNYFHu8DHfKIHe7q6lxYuMw0zyOLVjkueWkzxvgZsRbm9xLsMOtIIgr0co8Ot01sQwF3GU959TYkZCixSeGAVtrIkKVd0J286Y8ttrMut9cZRG2gqhqI88hiJcNkb1xLXh7iTuPbap0tIpTaCcDj132p5Gs9A4b1ElUh3KQvQieMUb1yqtiudQANKX3g9bbzCEwojw3r7uYm1Z8qF03prki8ei1TPr3IbXV8Yy1UhX2RAUwGpWuv2kj37lPQEk41"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "w0Ty3T8n7yMgfWr3185BGOPK7cNRWEr4LUHc9aWkhEJgV3hkAAar66JLpScmxqkDCLZP55SLMPtlgUCwnsMASFMVLZVHk9g1l39v8q5Pt1bWLa4lHgqoqq637VchljW3R7tMoEyg5v1YnWPy2nKV4rwwcVhsBb8oydsrggWDVoVNuQi3Jw6DrJbTuO4JL31Fl6MGXG5nJBIMj28vKH6JD3TrSoRASwiix1vWRKHeu35H4ETctgqrcdB7sXts093d9"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "UUn01RLQJnqR6GhkGZI5dEF8aa5eopZmtHHP6pm6R9b84nb6kZUz2eyYPhPClX5aQ"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "GMsWnea3s6NtzZpg4KY3iw1KaQSHMw8e2iqDLcr1jCrJRgxIxIM9zOLYj5DRRy221mQrG9MvXr6PAN8yC3Ra66jUhBctIYwUh6llHMfdtrXOYHobGfWknxKGsVJqFWzkr7TaluKnVy5U0DgepyQO3pti2CVYbsTobdLJeIHYtZdvncApzYBWNzWl3GzQHhpVr0c2lMGQB0yAlJNcOkxLpzk3Hj67Q7YeNjv9JdCBAhS8vRoKwcdQakJrp5VTbGufE"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "yd54"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "RDkLIey2ySCYXVPHRVa2b7WYN3dvUqRTfhKBx3QNH6qJ0StaTCLGigD3zUupE55H1AlUD9s0AcmrtBHgHO5FOVB13Z2Ue1BYMtXyeXHR6NK65qb46dzpWvIaIIMvRTGzGkMxRJE3vDTybItGfWEu8xN0TV25OGVLoGXGOYPMmyaphuOdwRv10URnxyFC5FseaKjzwwucMVJq3ZfIYSl4psC6uDN80GQBX7Mopq3rM9oZREKIZ4ill2KW9zIuhKIPi"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 22));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 4));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "EeAd5yMZYJJjHkRoU91hhceYaD94eSdMZGnqRjoyLbyJrFfKSKGhU1GqpxVkpcTyBTzulJSEu3ypmX7krFhN4jRDl08Y8xJxm8fpm1IYrhmWOKheprEHv38CDWIOrCLuGovlhjDxzYAPEOJfRVZLYKddzAljNLoe8AFCDfqUa4SgLvPq5r1IzQbSrSVmsteyi8MoW4vMS9GWdrdeS9Lukjtk9L4RUdJA7ZqPf5rd5oEDnuNC7eOgLOBtHNRT1t8rM"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 18, "autoSave", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 19, "autoSave", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AppMenus appmenus = createAppMenus();
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
