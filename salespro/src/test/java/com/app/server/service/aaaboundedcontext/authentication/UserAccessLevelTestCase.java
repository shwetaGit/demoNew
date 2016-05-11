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
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelIcon("pcv6faAvnwMLhussCglfGLiEVLhAv2lbYTJ9dkreNPQvZ3dKw0");
        useraccesslevel.setLevelHelp("21fKcWNCS4NJw3ELuZWw6xngw5uWEb1S2bKMUD2332VlHpMesT");
        useraccesslevel.setLevelName("L5bi5FU872eaiAFfdmQ199IQ6AbnM52i3SV1yKUBqF3VsmQYe5");
        useraccesslevel.setLevelDescription("RMuIVJPFl1w5Ka6lh422swKinydQAbrw9x3cc4ak0f3R4wY5ia");
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
            useraccesslevel.setUserAccessLevel(1208);
            useraccesslevel.setLevelIcon("roc2YknAD8LEmhasRXldaGf6srULOHyD22g0aF3ff3T9FRNlk2");
            useraccesslevel.setLevelHelp("8zJmQyMrwITTkLSOgXs2RB0AMf3JJ4IKFx1aeRAJQEfqcCBKDe");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelName("lKNECrEOkTB78OeA4wzhYK0RhTfoZeg3eq3eLvhuXSwMROwZg8");
            useraccesslevel.setLevelDescription("FKAT460YtiD1vLj0sttPVkLz4Z1iCtdIpuuFuuQcXe5RNbDTaJ");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "userAccessLevel", 136727));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "levelName", "3kyMGAYn4sorOhhoyCu4rIqMAynYzCDFGACZZGkkF9XHEihyZUGfusJsm9pJ3bstgv6tlq7esvDkCKCorL2bENhw3gwgFBeBx63FuUYaG4YNg3TQzbvrrgFeE844mX4Vr1XcqlqOaZc7wqBW57N7mz4L3LDerRO39O7GsslwZYI7F2XtrmLxhJNr1RxXQcDSc9jcVfqyibcZyVwl8yMNYLrcnBSCudOu0cAo7vQKe61kNmfIMDGtJPHZHxMKp6wLG"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelDescription", "mq4HXqye8HTAEa8kRSivgwv1DlmuCKLgqiUhiF0JUcYwQqHVcXk3fE8DVfKSmhAIWikhqObkvQ6IaDrgVToCjQNCz0jfXdHHC2FlowFjx8ZiykzwCMNp1M0DQOaBZs2dI4H1lAO5QaMTU77IncWQR9TunZTLFC5RiOXPDdsQmlnuP3vcbfccvFI1GD5medo6l0QIpcV0WrFxxYrsa9BjqBIuxeBmuo9jQq1vUYCsjob4GKJMOeQ4jjJ8q106IW5Hx"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "levelIcon", "BA6ff8y3e1q1m04cRQfoeA6sJRmkWMXHrLj2wol3TrkFQ2pPllt4l0CgbZ16amVFh9QN15iJ2Ks5fwBfm1doVWJXxq4nW1XrPdoTeaxMa0AApxPyiLm75vfIRGljedzGRtd4qbyrUJJTYfhFMOzktgrjW5u9BW8MAkxhFUCQw8ai2Uln7GYuxHDi5FfZvmjg2xUWxkhAhvJHa5dsiW1w5knxxxgoJOaq6Atl06RQH9bN8XBV8tX9pN4ozBDTtHdtJ"));
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
