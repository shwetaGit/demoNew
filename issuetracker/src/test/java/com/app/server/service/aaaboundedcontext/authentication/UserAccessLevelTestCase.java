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

    private UserAccessLevel createUserAccessLevel() throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("W19Bgv8Fu8A5Pm53odBuHGdFPJPMBapIN1BcLMzMTWDni01XOk");
        useraccesslevel.setLevelDescription("lq9GXyA2uKRPe4wOXlhAzTyWghNJc1P4l0El3Rjm9pq1syGU1B");
        useraccesslevel.setLevelIcon("8BTjKmMxOVitNCbk79KuaZAu2eLMrOhsVFzpwQmuS6A6ej6Iba");
        useraccesslevel.setLevelHelp("sMFojnJukZVxmxeHdualXvpRlsY3yoU9UzaxxmxROulFeOtQKt");
        useraccesslevel.setEntityValidator(entityValidator);
        return useraccesslevel;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessLevel useraccesslevel = createUserAccessLevel();
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
            useraccesslevel.setUserAccessLevel(86575);
            useraccesslevel.setLevelName("70R0xPrIio5lfEBgm2WxWaQ0FCPqX0dJvnl9DpTMiqzJEvqFfi");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelDescription("mlzbjo2vxJDaVp9sSAcxwzFonJ2yDZhQUhcrVeBxBw9VTEadS8");
            useraccesslevel.setLevelIcon("y9cTQPnO1KTM1eSRaZ49eMkdR1j8KbvkNM0qoFjwJN2trcwTep");
            useraccesslevel.setLevelHelp("rDjaH48aqyC5cnVsRfO4e7lyvXA3gr8gAvNBqDIfBwzV6sN2Yx");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "userAccessLevel", 172116));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "levelName", "4vQNJrx92DtVReTCqapA7z6753LBaht5nd1h64Y4gCr2UcKg6KI3g8gPKohIKJrKZ8Aq2fsDPOOTmrgGvbiavjWzJZgPZR55G6xxGPxnjB76cJ8qPD0zNZiHRs2L7l3fPRwNDsHxLpGofSPwCf7kiq1YgZTrHmy6kCqsDQ44CqdakxdvLynJl8U0LwpDcoK8mKtm5lmASwzw33xosT04ZMnQECjampEcuX7ly09kV5IpX8IMb3YrETNdkgxidZhis"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelDescription", "TieLcpsw1uxhHoc8355DPJ6d64vsDafWkdPD09dWSIccao3pvkEVffWcegrNriX17QjNQjn7BiWIMjsxrot9loYQNNb19DDLzzS5EH1imQPKql26E5NExLj9FtzxhXf8YZZe1u2C33to6FYMpdkxRi3dG0md0PA2d4GNyzZXFDUiGWHx3aLvdS69YsACnJzH4EHXYI4OySMC3I8nnoxgXO3cbrTV5TBZR8gnBsPFiXJlQgpGOcK7rFUQ32gjShRc1"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "levelIcon", "V6IpKLx4euHYI2q7Vm3KHwyrBhJkI8qzwxq8HjqzVeqFfyyyUu3n32ei5AjVNVWKlWRLD6i8ls0iN66xmR8RswUGC7xT58c0IaTsTCXoGbqlhoIEY1oM34jWEcKyxxdOpbKxEEwNoCh0xLrzRxUrCBYWPK3pEiPmQWNHsq4dmVYezbbpLyXbb1yHwQAnBmmPB1xDmEtxszPtAifjmdpc9k4n3S2CkHDENvkOeCPxZBOlx4lEkDWt2z7CvZMv8duuW"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessLevel useraccesslevel = createUserAccessLevel();
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
