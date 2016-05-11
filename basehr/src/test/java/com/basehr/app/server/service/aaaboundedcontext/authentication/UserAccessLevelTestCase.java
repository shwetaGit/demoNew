package com.basehr.app.server.service.aaaboundedcontext.authentication;
import com.basehr.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.basehr.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.basehr.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.basehr.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
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

    private UserAccessLevel createUserAccessLevel(Boolean isSave) throws Exception {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("ULFQKj4pgrCDJJkEpK7CCSbi3OwJOea8jxYMr0RJ9SkuWDEzox");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelIcon("6I5JsBOvgVf4OQfERfBQj9ndYZb4xUzqDWcIPkjJqGf7nQXDrG");
        useraccesslevel.setLevelName("Kni9kPg2kIsWyVYNlMZPlsfnD6Z2amZT7aOqBcgk1rmbHU88Gh");
        useraccesslevel.setLevelDescription("k6VmASBTGU1LzRdouxvAvcxoChRu6CZNsOrmuYqUEUfj6S9rza");
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
            useraccesslevel.setLevelHelp("i5lQwI3eQiOWsDt2O0Dji0LKkdpn0F7Y6cIcULKQ0khpvsbkXZ");
            useraccesslevel.setUserAccessLevel(65942);
            useraccesslevel.setLevelIcon("Epy1u2bU84iHnwWXLdCuZ7ZCCSr6kPqaKlgy0aDgq9c50sWGrn");
            useraccesslevel.setLevelName("u12ZmwRCMLKUuRHVNyF0d9MhUqFHmEbsTwStpKtwCQSDHVivUz");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelDescription("5WSYmEQy8jX43pKSReT0l1NX1ZlsiMFbAmJWpo6HdZl1uDJKe4");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 138613));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "VpbVnRwC5iHbGsT0qpi4B2QDVIhdquFMAzoDBtiQoTwJcrS7GMJFvAMAFSkbKMea4VJdzH1dclejoF1x68PK1BqoUqa2Jt4fyQyZ3TpBgQXAuWNXa1L2qLFhz7anV1dbsc2aTpOWhhkVn6q6UhiJnVRVcf5PYsDtEUkSVkAoorYYfRaMzDSGnLBacFT5stiPayPDFqFrABJSHq1iXWfpCxgEUTCoLBOPsay2I3hZergtp8WRj6P5tGyTbYPeTSMbT"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "mDIqHjSopoYOHTtiH3ieNjXuncN5Q7vx84g50JsL7eztamg9c7VXwV2iMD1JBMBPMc16ABXW8Wx8HswR0B6rdSZe2Qsdgs3YWaIgKqDKlGQbGnPMzIa8DzASsgZwIeNRQ7kpCz4W76ZrCAuPcBLL6GAv6ONCXxprICZasLJLG5ggLrC7ctiRSq1uqnh6gmPQJLol6M29WzAW4ydAxj4EQNJX1NdevBpRlqfWplmlny83RFur1Fc4PFrvJNtSuCYBh"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "Ma7et5HEeOyH2VBYgVLwp6JcKYVLidrIw98envs2hoxTgDAH6vskI9beEeKX3er05iDz0Ch2K4sULEjmspnMtAem24ftxAgT5UttRBc1fJU2sxWNEtKEEt2rRmwibaRyJgFveEI3JAYS995nPzFyxbf1QytXacJwmJN99sOowKPwI0JWAtDJYsBZIqBje0Q0j3PPGSIby0piN1tiaArGxHSMLUTUO4dmn3Q2FmAfGYL5ivVxfID3e0n7NyJqZchd9"));
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
