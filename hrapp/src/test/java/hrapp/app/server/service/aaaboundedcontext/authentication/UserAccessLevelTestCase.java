package hrapp.app.server.service.aaaboundedcontext.authentication;
import hrapp.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import hrapp.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import hrapp.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import hrapp.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import hrapp.app.server.service.RandomValueGenerator;
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
        useraccesslevel.setLevelName("ncAPEYF48BE40LBbNn99WllDPVSl9PtgkICT97XU0oXSPB6ndo");
        useraccesslevel.setLevelHelp("GaEhYyoEDnKRJOXnSbgDNjMGFF4MGOvOiOS6PpxHHmLhWb794n");
        useraccesslevel.setLevelIcon("5EWUU5mQ3sXLFqrEwaOxi1011zhCRfMEFcP2AJE3EYSI4TycyH");
        useraccesslevel.setLevelDescription("45ibysVSBjoU37RfbME7lSFhxRbVPeC3WCUQfNd0AHjb5gyPrS");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
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
            useraccesslevel.setLevelName("kGe85FcDNbohKwPQdZLUxc3WC3sPaMRGhfBfpWb5JdhA1akxPh");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelHelp("ZjF8EtLb8QO8cISokD2UQyTQMtUjA0ftbopQnnrSrEtnZFL037");
            useraccesslevel.setLevelIcon("6LimRoryUBoe4wlJYa0MPhOYTNfKZsMCjp3psIG6BNc2gdcT6I");
            useraccesslevel.setLevelDescription("zpwjPW4yjCsVuuzuS6tLELtZTCyD1IU1fU81ly3x50PdaPNx6R");
            useraccesslevel.setUserAccessLevel(24799);
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
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 172684));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "HAjRwoQOpHqMeTsfWSRvLuUqrsGVnVefF73TiO1xVT20AVZuxgabDQUSNbvBZalhxi36Vwha5mtb59JzXyL4a29CmFAUyHRJp0eIRA2TAkwtzlrqvGmqLiBJixbe63DCMqSRNIKc82tCGq0gQjk7ZNuQ1mTZFWQYwMos526s64BEAWQC9NrV0IDM4DFkUdJq5IwFvDXSJlnMWy08mDDuwPAPINjWrQxHZnOhE2FAbsRh8LvksYSgIKKXeGZbuJOR7"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "cbL41khD67ZmhOeUlMrwXADJknvMmTawE3SPUG8CRwYlT6cOFwxR80GL8X0Znd11F9ZCiWJu5fVFwFsbp6UhhvJbcaT9MbDmIgxPgPCqzyeCAQ5XKSBWyI0QneB2xEysxTZCezez4od1rywNXG0dKOFoBvEwCudQdNK6sKeKKY2Y34XCZxve6OxAVbw6BGi2YwHzeQ6fHubFKdMKLFF1Chhn1najCP2XrJaVLMBzclkLvipDYelCrYBpo5wVBUOMl"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "LkfZqVaQTV4o7ZOQEteeL3koTeQ0WGls1Gh99Z0K4vUrQa8nejqaScWxk1v3D5HnjWTmxk2MQpbiEJtAQLgGpxUQwGg0j3Pbx46PMivgmnCMBhGgBNptMupj6J1kSeYWHHO8YkTlSj5cMzXvkJ1u4Xop9mHonKzWcnfqbHCpEmfxGPrmlpmpS2kShxQLlyvZTA7ehYJsVJuv9aaTKt0zktCOyh3QLr3H2V8o8wIqC3RLMD1HwkHxqh05MK5wnntNB"));
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
