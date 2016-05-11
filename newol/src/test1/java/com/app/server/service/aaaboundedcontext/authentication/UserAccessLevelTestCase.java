package com.app.server.service.aaaboundedcontext.authentication;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
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
public class UserAccessLevelTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

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

    private UserAccessLevel createUserAccessLevel(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelIcon("TsSKcIJNiUxwVs0ml7rNio2EAQN3X3NbnttGxHtbI8idEhoWKD");
        useraccesslevel.setLevelHelp("CYPf62vafpBKabReQxUYwRgp7GszEKogw5QHVUHr5rQNDCzzQ9");
        useraccesslevel.setLevelDescription("SPGDOvxebX8YlfKjGBP2fLpBSr59av8HRrGn3hRFNBEceExHSX");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("HuBfkzJKo2Sc6ESv26xfYi8xM5NOIvsU9iVeijhrsXZEpSSYAE");
        useraccesslevel.setEntityValidator(entityValidator);
        return useraccesslevel;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessLevel useraccesslevel = createUserAccessLevel(true);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccesslevel.isValid();
            useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            UserAccessLevel useraccesslevel = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            useraccesslevel.setLevelIcon("otuEW4eIyTDvFo7AnUSOySohbaKYBbiR3Z015JQTDbjACSLqEg");
            useraccesslevel.setLevelHelp("9o3S6suehi6hayIM4el5tODCLrJmDu5mXO4fYGNBDxY9dyRowy");
            useraccesslevel.setLevelDescription("K5bO2j2A3H4DLvxZB64MknUATc9htqudHHOxcYj2JJGDE3kpFz");
            useraccesslevel.setUserAccessLevel(9);
            useraccesslevel.setLevelName("y52MBtsxMJc9QjvjRVAkJsyARAIvpnhCoRNycwun0nyffxKyjG");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccesslevelRepository.update(useraccesslevel);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessLevel(EntityTestCriteria contraints, UserAccessLevel useraccesslevel) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccesslevelRepository.save(useraccesslevel);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessLevel", null));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 2, "userAccessLevel", ""));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "userAccessLevel", 174005));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "levelName", "6JLIKBPNrvBJraaCzzLgH95NZvPI1hSsmLx67K4beNtogJf1dnFKWzn36g3sQJ7z5Pq5aV1GX58xPptY3YekeiJsgAcZmmG7RrFkNXMEE7C2ndMwto1LXc5DahbcALB4SeuX63nKYjGBm0iZnxoQkEpWWxayhUycpyOavZO6NlZzrQvpwcdb8W1L3kGt6mu5A1qutxDa35MvNrGFMnlmgNzrc9pyD1prl7fCxyvHkNfXuuLyLzyCRcumd7bgy2vtd"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelDescription", "hGBCmA8BFfyZf28EONsRA03a6U5OCwDKjoPS9kp9PWU9QFn9TCAoAdvsHXI0G0PqoGk8QrcdICUPM6oYs81r1pHQ9815rauZ1qHZr14fspFHhaBU0WuLEg4U4DkeiibFCfhVzyDYck7n8jSVcSZhQzjChdD7EQ62uuQ3WD8Bu7mIX7Mh2bqW8uBwODIZcW5KKg2s5wZQVRpO8Am1cwk2btriwhPvrEawASTpI3arRa55ecqlgwoUSMUMprBfvsM3q"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "levelIcon", "ssyRyOczZckwFJ73Rf2bj1InByQaaVMBbboUzVyROTKyRnFEi7aICuHBzVbAYl2kmkpgb93QEXKuSuZbz3DN1AMpJMyRox1UnLQdjGPrP4zgV6fO6YmvhrPc5YTd1uoqhcc7Ev6cZUSw07fify7MQNGqzW1Wpdx2ZFwqC0G1NbWYKwk2juZyCTLClKkZwd9Fl3oGk51oaBGBd1mYDtdIxieGGdJe0MVkOoV1oPez2GPp3tk9nfQoESLGYOJhNa1KV"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessLevel useraccesslevel = createUserAccessLevel(false);
                java.lang.reflect.Field field = useraccesslevel.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 2:
                        UserAccessLevel useraccesslevelUnique = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
                        useraccesslevel.setUserAccessLevel(useraccesslevelUnique.getUserAccessLevel());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 3:
                        useraccesslevel.setUserAccessLevel(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 5:
                        useraccesslevel.setLevelName(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 7:
                        useraccesslevel.setLevelDescription(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 8:
                        useraccesslevel.setLevelHelp(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 9:
                        useraccesslevel.setLevelIcon(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
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
