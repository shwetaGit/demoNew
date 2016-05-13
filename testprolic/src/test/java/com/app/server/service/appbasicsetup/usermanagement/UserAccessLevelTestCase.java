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
        useraccesslevel.setLevelHelp("lkTCEF7dbif7V2kO5GN2ejnPjwRBnaVpZg9TrCs3OVzCdGxrwW");
        useraccesslevel.setLevelDescription("i3oUDvSPGel0UURpscIrr2A59LMd7x411KGqw0sMKa2UXxxK7F");
        useraccesslevel.setLevelIcon("yKoGvuT4JcFnrYd9ASGO3JGf5G7JjE2iKWVERUPJUcf9gTIrzC");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("ibFMWlMzFsaRfSGs0ebSvQsvGkLQeSS1rYK1SC5nNSanYdDKB3");
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
            useraccesslevel.setLevelHelp("5ITbyzvgyLgfCjsmLEXpRg0orTLK1USCwCA2a3Aq3zCqozsUq2");
            useraccesslevel.setLevelDescription("TvqrnOpf1da9zUVQbU2IwLk7AQUKBAzkrqbP8Sy8xzX8kKNqq5");
            useraccesslevel.setLevelIcon("jIkGRjUtNuPxc9THJ1udvhjmFBDJN6vGRwnCRHHT3sDjHQPP4x");
            useraccesslevel.setUserAccessLevel(18832);
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelName("8RQ4lQId4WdieRXkf06uTaG6EvpuaqD5iZDZdv0hLc4y1rCfgX");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 134510));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "uaUeGcNjG5y5bFn4yiHTNfQwYmhSS22XJBdjnRVWwQb23Re9HMmwVz1dbG6XQPqVvcslUsMPJp5BuhmBWXCE0qYUlGvpsGInzyJGrml1lKoEdWh1i7pLppG1bZuwYUIULZv03fWN92p1twAbXEcfU8f7LB9ge83gtrCtf728FxFkUWgxzGroasz6rMVLkeCSDVkrhxyr1sT9jZfRVfJYPedFjNy3JTaMhM68aiQd1pySpRuNcPOR1WoaZJkCRvzXQ"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "SIC8xMf3obxQGessPgYkGGY2aHYJrGDsjqSXeaEWUpUZN1BcIolkpySXMLwUGS5E8DQhjUrqKHXULo7uDPRr653Otj9XcPsVPjdGRsYJMH8ov6yC7iK8zk0uQ8r5XAlUoQ9j1aCRQfitBlhB7qz8jCEgOeRAuELG6mb03aPS9c9Fx0Id30UtbnIq3ReHA8xbDXzULQIQXkOJCyo3KNa9rIfdF3uZJGkw1f9aCAZO5J19h0JU0hIfj3sohqihEnPL0"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "HJaCxbrxXAHFQzmeNQRPv5MLRtI41Sw62MrDDap7yyW4q7fXftygbTQfTudfHDfwL38KOtKaIsdtieS8PEowxBXoHi1nqsr0Kh2af7wq3tcG3XWcvB1vkw4YFJhLcIBxLzyA5aQpbJ1sQOvttlj4M6rpTPanYv00t6FazAYJanfqM593T8FSupijvJ6m8PtuzZ4liRiOYitIq2qpa2TvGxQPhPmj5jfMhIr0T75v1fNVDq6RvDgCxU1ZzCpqpOrNU"));
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
