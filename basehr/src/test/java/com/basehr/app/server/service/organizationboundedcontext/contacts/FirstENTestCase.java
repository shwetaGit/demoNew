package com.basehr.app.server.service.organizationboundedcontext.contacts;
import com.basehr.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.basehr.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.basehr.app.server.repository.organizationboundedcontext.contacts.FirstENRepository;
import com.basehr.app.shared.organizationboundedcontext.contacts.FirstEN;
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
public class FirstENTestCase extends EntityTestCriteria {

    @Autowired
    private FirstENRepository<FirstEN> firstenRepository;

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

    private FirstEN createFirstEN(Boolean isSave) throws Exception {
        FirstEN firsten = new FirstEN();
        firsten.setFname("OOQgHxZZJ3SHLyEEDxrRqIuOKi54CpUDa5MrZYBuNdg8sDAwV2");
        firsten.setEntityValidator(entityValidator);
        return firsten;
    }

    @Test
    public void test1Save() {
        try {
            FirstEN firsten = createFirstEN(true);
            firsten.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            firsten.isValid();
            firstenRepository.save(firsten);
            map.put("FirstENPrimaryKey", firsten._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("FirstENPrimaryKey"));
            FirstEN firsten = firstenRepository.findById((java.lang.String) map.get("FirstENPrimaryKey"));
            firsten.setVersionId(1);
            firsten.setFname("030Fq54YUhX7TLix0nrv8xwwu49rflKnWKCo7vncncolldq9cl");
            firsten.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            firstenRepository.update(firsten);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("FirstENPrimaryKey"));
            firstenRepository.findById((java.lang.String) map.get("FirstENPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("FirstENPrimaryKey"));
            firstenRepository.delete((java.lang.String) map.get("FirstENPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateFirstEN(EntityTestCriteria contraints, FirstEN firsten) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            firsten.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            firsten.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            firsten.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            firstenRepository.save(firsten);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "fname", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "fname", "BiukGbq0NjEOlbFtvk4hZmpdG1cIFJGvk2sarHovSNqeZs087DktWnWU8XDsNbAM34aWRoffPlwYywhMktNm1DQSu2pArZ3XCWIyH4MJdVQJxGOUNiYqWdxH8D1fQiqymoI4XYZ3LHrSK8P8rlY6BlAMopjA4lQLe9pFaJCYMrruPvec6G9uQx9KxuUrtaI6XCMLf3bwcSvEnlSSqcIpXSMTuARiE3RNOZe6Zk0uuX25Qa2YJGyef1EuTPKoNIi8W"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                FirstEN firsten = createFirstEN(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = firsten.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(firsten, null);
                        validateFirstEN(contraints, firsten);
                        failureCount++;
                        break;
                    case 2:
                        firsten.setFname(contraints.getNegativeValue().toString());
                        validateFirstEN(contraints, firsten);
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
