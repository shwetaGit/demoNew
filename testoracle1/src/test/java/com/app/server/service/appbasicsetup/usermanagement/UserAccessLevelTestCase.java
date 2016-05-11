package com.app.server.service.appbasicsetup.usermanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
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

    private UserAccessLevel createUserAccessLevel(Boolean isSave) throws Exception {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelName("ZrSAWIXka9nf8S2I9R0ACvMNr3XmGefR5VRURZ1VWd49crxze2");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelHelp("TsWeWRp1TxI2PMATsGETzB4VYdWH0ZvbA7kKZlqqWqYAEsmO2M");
        useraccesslevel.setLevelIcon("GObtb1U9HfN2teIAz9ENTjl9epoZzhMTP2bQUiDnwfgQoJ1nQ8");
        useraccesslevel.setUserAccessLevelId("ZbERRCHnVQu0niHMnIHCBcpVIDAqfRnVawRM9pwpGbvlstxlDx");
        useraccesslevel.setLevelDescription("i8VHrCB8TFSTrqkhfTUolAJFBFYfIsqZgwksaMubN6DLSiT2q9");
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
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            UserAccessLevel useraccesslevel = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            useraccesslevel.setLevelName("qLD5qnKt6IvjGhrsbRziqWVPnHXALhIS6VjzZBiJQajHH2YsJT");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setUserAccessLevel(86377);
            useraccesslevel.setLevelHelp("z6neYi8GB3ALqSrFTnehU9b1oavk9KHNcvbLCCkj6a6QCBi3qY");
            useraccesslevel.setLevelIcon("BXJpm7PJUhkAJkmN9nDwjiD3PncHSJzJo0ESDWpaMiPg6a93fk");
            useraccesslevel.setLevelDescription("TScm52Li9XvMWbYuc01qaMYPUKNZ1Kxo49C0zIRZr6i1gsLiq6");
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccesslevelRepository.update(useraccesslevel);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessLevel(EntityTestCriteria contraints, UserAccessLevel useraccesslevel) throws Exception {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 187064));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "evXKu4gr4uq1LtJ3luwFHFKQx58XRjh66l9DUJG1TWTwPfuXlsiXb242e600TWQLJ9qG8kufFjyjDt6PFrDnV1YxxEPWbauDlxFiIxYZMCPQgmdmpsIPZHY3UOirPO88Xez0XE8KxQzVOBHUsxsqiakxALpSD6vGT3uDj7MMDbNh35eDlXInseHlx7H4pUwPsM3Csevqwv7xAjg3EZBrl1XbqXdS3r2HJV9hCzJfTBUWura4axN4JaEv61JcBOdMp"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "naVZ6nD0uDzzyP0EjVq0fBRbByCShjqPnDWf4nZDmlXOO151gi43jsuMDHBoOr7fXPlTX3KjhgARZa3oLeRebdeBb7A1FVl8y1EzhSSLywp66iEwq1ghO7oavPUdBgWTlnmjT4VT0r7dnxls5Cckx4N0zBIujsEDO8tj8rKIZ6L7rwqmTPVd143ihDApfBOjJvg9ER8pGbPosvWLBEX1iSXYj0oAtjwVpU9ixYZ5W908g5tQ3zhk6WDJgXX5IShij"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "Kq0QHOdz2ssdH1FTpcBdHJlErQjRQ5LecfvnqdxbAEfNbLl9RE8MAP3Ync0fgGrjPJA640BB9g3xzsjGe0wUYpWqKfDcuseFWemqbIeQAwm9x94sG9lXCASNJWPfdfprSUetw5908Opzr0mO0NWBauvGMeiVco94gO8qbxSfqsMhWv0Z5hBNHe25UbuRtR0kMqqtPzTxF60O9L2q11CUNpIXRfQPelY2fMD4kjhnhojku6dval2BSG3NwVF5tBAGL"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        UserAccessLevel useraccesslevelUnique = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessLevel useraccesslevel = createUserAccessLevel(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccesslevel.getClass().getDeclaredField(contraints.getFieldName());
                }
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
                        useraccesslevel.setUserAccessLevel(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 4:
                        useraccesslevel.setLevelName(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 6:
                        useraccesslevel.setLevelDescription(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 7:
                        useraccesslevel.setLevelHelp(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 8:
                        useraccesslevel.setLevelIcon(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 9:
                        useraccesslevel.setUserAccessLevel(useraccesslevelUnique.getUserAccessLevel());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
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
