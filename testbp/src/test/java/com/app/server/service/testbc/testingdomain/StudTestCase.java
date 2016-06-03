package com.app.server.service.testbc.testingdomain;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.testbc.testingdomain.StudRepository;
import com.app.shared.testbc.testingdomain.Stud;
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
public class StudTestCase extends EntityTestCriteria {

    @Autowired
    private StudRepository<Stud> studRepository;

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

    private Stud createStud(Boolean isSave) throws Exception {
        Stud stud = new Stud();
        stud.setStudName("4L9925LWH1FZ7qUE0hd2eVGjdhMl9ccfa1mrC6AIIAcU1cSpsp");
        stud.setDob(new java.sql.Timestamp(1464950664796l));
        stud.setEntityValidator(entityValidator);
        return stud;
    }

    @Test
    public void test1Save() {
        try {
            Stud stud = createStud(true);
            stud.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            stud.isValid();
            studRepository.save(stud);
            map.put("StudPrimaryKey", stud._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("StudPrimaryKey"));
            Stud stud = studRepository.findById((java.lang.String) map.get("StudPrimaryKey"));
            stud.setStudName("t7S38zf0STMRHKDMREujX0AvZtq4w2d7wzG8MxHFiQlLPWJCy4");
            stud.setVersionId(1);
            stud.setDob(new java.sql.Timestamp(1464950664813l));
            stud.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            studRepository.update(stud);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("StudPrimaryKey"));
            studRepository.findById((java.lang.String) map.get("StudPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("StudPrimaryKey"));
            studRepository.delete((java.lang.String) map.get("StudPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateStud(EntityTestCriteria contraints, Stud stud) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            stud.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            stud.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            stud.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            studRepository.save(stud);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "studName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "studName", "bQqku9Sk9y4nF7rDtKxR4f571ws8ddELliWrgqriRIxfqgqhwfZa0rhnrqUy5ZCCbvAbGJUgNhHcMxZfoLLebhhAUta0K9uK5pEolZF40lceRsPvUyqY5CidoIR0xboawVInpyz9bFL0pu7jWOmQb9UgyVfrQkR17bF4dBEKWKOOy3lIN6TiUx6WogiNSr2LJmUtbk9Up4leKC8pbMHlM5SkJ95aBSHFTnP31ZV3U7ZaYfpEzyrdPjRRTCnVn2ym0"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "dob", null));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Stud stud = createStud(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = stud.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(stud, null);
                        validateStud(contraints, stud);
                        failureCount++;
                        break;
                    case 2:
                        stud.setStudName(contraints.getNegativeValue().toString());
                        validateStud(contraints, stud);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(stud, null);
                        validateStud(contraints, stud);
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
