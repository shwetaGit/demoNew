package oct16last.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import oct16last.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import oct16last.app.server.repository.TestRepository;
import oct16last.app.shared.defaultdomain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class TestTestCase {

    @Autowired
    private TestRepository<Test> testRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

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
    }

    @org.junit.Test
    public void test1Save() {
        try {
            Test test = new Test();
            test.setCc(2147483647);
            test.setDoublechk(12.34);
            test.setStringchk("wp3gTgMwsJgGIWvYn3oOeDeriCcee6i3OcuhJMgCKeq2aG3RNZ");
            test.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            test.setEntityValidator(entityValidator);
            test.isValid();
            testRepository.save(test);
            map.put("TestPrimaryKey", test._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestPrimaryKey"));
            Test test = testRepository.findById((java.lang.String) map.get("TestPrimaryKey"));
            test.setCc(2147483647);
            test.setDoublechk(12.34);
            test.setFloatchk(-1.73251443E9f);
            test.setStringchk("xCAAr3xYcIJCYLpTRCaK9RccYt0W1p7xkOBB0PhI2iVPWkpwpv");
            test.setVersionId(1);
            test.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            testRepository.update(test);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestPrimaryKey"));
            testRepository.findById((java.lang.String) map.get("TestPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestPrimaryKey"));
            testRepository.delete((java.lang.String) map.get("TestPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
