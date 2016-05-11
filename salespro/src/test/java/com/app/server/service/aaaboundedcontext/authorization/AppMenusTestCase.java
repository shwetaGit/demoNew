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
        appmenus.setMenuLabel("3MTQdOT78eo1D3FK3R1rRIqSisYNlnIfiXKSi1AJAxHyt6v1gw");
        appmenus.setMenuHead(true);
        appmenus.setMenuTreeId("ZL1rkU15c1TkGhpzO5BZcUXs0gHyHz8tXoRMSf147xNsLIniYz");
        appmenus.setMenuDisplay(true);
        appmenus.setMenuAction("TxOE5RJkzRzWF9ZDTW9BZRzmokeccbccls8h9qwN6d1T1VMA2N");
        appmenus.setAutoSave(true);
        appmenus.setUiType("Q5T");
        appmenus.setMenuIcon("JmcK87mK7Pvl63LPGZEUQmog6rC7v0F5OTGung9ysGc7CQNR9m");
        appmenus.setAppType(1);
        appmenus.setRefObjectId("cSCwxC4EAcLKGSIbSMQWCc03igxqrU1kRtcbsMp8eXUa1H3iU4");
        appmenus.setAppId("ChUrxT0XDgRfTB8jg6k4dpNdhfPyYhiglyf7dkNsZHUKZuJr2S");
        appmenus.setMenuCommands("Zi9vmjqjYxR2czbFQalY2WMGA1pvoSHNQ6yaabuRD1oUd2ypN2");
        appmenus.setMenuAccessRights(5);
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
            appmenus.setMenuLabel("Il9KOWqXOx9eufSl9aGEgrqYQxVYEi6NetrUGWJbkQEnpTcAmp");
            appmenus.setVersionId(1);
            appmenus.setMenuTreeId("uk22iMfcZ2YL0YSgTNDASdlHiwrnBbfbrnBZew6BMaNVFkRO4D");
            appmenus.setMenuAction("Xtg13jnohrrVoOPdgFoXZmGVnjYoYvHuXPpav2G3WorGFGiKS5");
            appmenus.setUiType("JbC");
            appmenus.setMenuIcon("XeF5yGoZ5U2MtlqXY0Fk6ZSV7e6JUa2nycN1V5lgOM70RblXF2");
            appmenus.setAppType(1);
            appmenus.setRefObjectId("zuUtiLHdleZrt0HYuCDxtX2SX0yao8n1OjMYmXsgfcdCq60LaL");
            appmenus.setAppId("BxgZXR55yNeOGtGZ5uLTuTcfxXtJtAQXY9VUQCao0AhC4JQlJa");
            appmenus.setMenuCommands("2zmHlEai9669MRvLF6dnuKKMXKkCZcN1MzQBSofEtbfRGRdxOK");
            appmenus.setMenuAccessRights(1);
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "vDHBRn4ClyV8wHOURGWbUhLM09mjsnwg9ntNQdlcV0rGXIj2Ojq66Ztq0yUOdtyiHYaFSoZSzgzJ57NpvIsMvQCV3LQYMDI9YHCe6EgBtXdPnWKQdUKJm3gvaPJ9gU1hHZm5bTCIAVlJovObNsfehmUehYQ3Z0xoSMYzyyeZEgfU5GzCJisuJFYx7lJpiBW9jZZ6ODHLYP1BHRpAVL5rNKauIVikMWVkaLKl68Jhg2aqosQEBbPMAhDP0HtTKGgzx"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "GzcWGwEAiBolC13hXVUZWSXt4auNrmMO8h2FbCCG3608Hsz5xdtvfpkWEpm06a4Lm6sv2mD0p12wX9H3DHYFByoa6JeQTQEwYPC9FVtyPGNPSBpuqE4iGI5DMF4m0cvDhR5LNpTKLFmOAKKxMDq9MPix0DjziY5dKGcKJ4NWiw5hc8CU664vu5IP8VUebT9xUwmDZdNQM0nVc8pW4kfpG3Li61LExxGfmShnao8yKrNuK3M0x4sAzuFuftVqGEaS2"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "DaSxl4OrwJR6Q3u6utRcIyih5BzY65SRb8I46iofSkl6kEZNWxSjvMPV2htClHZktvwVTKThN5Lm5P1XBzOCsADwWu7TxkKDRWdhk5HSGsGzFVo9k3ZGyQb2qbB5PB5PEKrpXY9XkozxKyQudefPG4FWre9jTVbUVvKfwWfbRGPic0JfB9t9NVmpbAclrYuk2mVUbLA5DWemEkZ0fOhaUHKqVs4cojkkD0VKSVSqhh9r6QUStyFyfIiOPzdSF7F3t"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "CPCNr5ggUs4HkCnLUY38bWI8XcYShz79K3MTrz4GSMH91XZeRDDjkm9l9Ovb7QsZe"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "MrYjiBzC0WUV1enD5fSBYrVOMpqFtoamu06K0j64SzZmugmZRN9fEhNILAQlcQX38DS9HnKijuSxagzKgl20M6RgQx4yUpIPogXBzTnDx3gybgjULUqoiEXhq0e0zlz09IVLCZs8etp9abdgwwNRe43vT1yLVwRN8lOI24yuRo1TPgRoFetCOI4pGOlO7T55UhSt3jrSZgDuFUWFnUvK5mIwVJFXl07BzqENsScuhQ2uIkTAKukcdlS4zUCGac6wB"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "Q1oU"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "fdccHquvAmHmqOsFkfOaH6w3UbOenJE3OKL5dPeYVk0CXPUf1FjDLtDqgMLenyXuo9grryi9QxmoL5IKsEI8m5Px9P6CbdhbssgLf34ScDnbFFd2TXBOiIfICvaXZFJuyfa4GFchyS9kNkIgVtptQsbK81AK3MZjE1uLS1VwYKDK3esRHATOzV1iEx5iWIhDwfhn2Uy91LIWOb5rnpX6FhLZ7TNapBem5TwML7jqgioPwMNoHRzYZaeqFsNWCqS1C"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 20));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 4));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "37fLXgP0KccnOUqQKcjjtfRthylwIWixRDOY3NwgdjaBcQjImMQWGPGGJADhhk3wZfnWWspMrYWI3IN7kXAqXg75KTKBLuMuvjzJlAtv0zzcsYsTFtAAjHXHkint9GWRakkWM0EwoMQJJ4qDjuxZX1OCoZW1fsTFk7y5yVZQ7T5Ojj3BZmpHvOVtnW3B71oYquUsHzOEsvcvqpAajb7axI6rYVTjz4T1XAl35WauWsqmwx2rp9LNs725f8llz1qOn"));
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
