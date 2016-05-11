package com.app.server.service.issuetrackerboundedcontext.projectmanager;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.issuetrackerboundedcontext.projectmanager.IssueVisibilityRepository;
import com.app.shared.issuetrackerboundedcontext.projectmanager.IssueVisibility;
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
public class IssueVisibilityTestCase extends EntityTestCriteria {

    @Autowired
    private IssueVisibilityRepository<IssueVisibility> issuevisibilityRepository;

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

    private IssueVisibility createIssueVisibility() throws SpartanPersistenceException, SpartanConstraintViolationException {
        IssueVisibility issuevisibility = new IssueVisibility();
        issuevisibility.setIssueVisibilityName("9QoFIhrhzqU31ebyXWTMmF4Q06EoRcYhOGEY3flQVAdPduywPG");
        issuevisibility.setIssueVisibilityDesc("XHSVRGaM1p14NEA3u3JunRa1xrRW9MIwRDv0ZtUcqvHM24hOzB");
        issuevisibility.setEntityValidator(entityValidator);
        return issuevisibility;
    }

    @Test
    public void test1Save() {
        try {
            IssueVisibility issuevisibility = createIssueVisibility();
            issuevisibility.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issuevisibility.isValid();
            issuevisibilityRepository.save(issuevisibility);
            map.put("IssueVisibilityPrimaryKey", issuevisibility._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueVisibilityPrimaryKey"));
            IssueVisibility issuevisibility = issuevisibilityRepository.findById((java.lang.String) map.get("IssueVisibilityPrimaryKey"));
            issuevisibility.setIssueVisibilityName("3KC4EazwHQV18ztTHW266SYgLnsdBo1dcrRYGBnkYOWVOxLK4u");
            issuevisibility.setIssueVisibilityDesc("GhRM3sk7454EUCkhAOY7MwY5zBupnoO25MLBpWWluP3ThTw2oU");
            issuevisibility.setVersionId(1);
            issuevisibility.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issuevisibilityRepository.update(issuevisibility);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueVisibilityPrimaryKey"));
            issuevisibilityRepository.findById((java.lang.String) map.get("IssueVisibilityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueVisibilityPrimaryKey"));
            issuevisibilityRepository.delete((java.lang.String) map.get("IssueVisibilityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssueVisibility(EntityTestCriteria contraints, IssueVisibility issuevisibility) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issuevisibility.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issuevisibility.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            issuevisibility.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issuevisibilityRepository.save(issuevisibility);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "issueVisibilityName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "issueVisibilityName", "T7PCzrxTSi2JZnBmq1mA0Uf8azvjRejq2QMOO3N5HpainyLyTQxcUcrCTJYGpvtLzhy1tZFhibgZVtR8rDe1udwTf1vQyVAmRVwvAZsPhRHXH7GT8cMEHbKSRQrqko8jrPKfMX6p5aA03oKYpqwT5g6cUS0PnqCUAAwRJVznJFk6SAtnJIBcgOoxQalaWwsCSvQnldRpQ97kObjOnvqMILs4Sr7ypqrkszMgt2J9lX2z9sgIHDPLHWUeJwIwzjGup"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "issueVisibilityDesc", "F3FraHOu4rXQ7oqCZluwqsH7He2eb4VdLVITWB4CeIcxbu8vDmsabhkxK5OgPDQHei5KoaYnmcv4dpJYIIE14Vl2iLHAnKtqeW5Nw7nm8Lqw31cGn4LVgxwlgrMCerh2Kewb1adShExboG5gUwS4xyZGSjDAlmOy0CPv7cwDb8fpHbA9dra6at6lcjcOqzcZzOgwhABc9u7Xe68F5QieBXxhrvrSV7N1yw7HcUtUI7JFtAEKaARcg4vUO9v3KyRjsKBZukYiDBRFwmU9kAjux3T2e658DLkah4DAUoNEPpSKXYcdagJV89Bl5SjpoglRtcXKP0TlvJqWwhPZ2tGJJrtlu5vqx7x8FLPBn22qEtjRjP2YPxz3uGr6zrKFN3ST2HMNwLmLtpvdBYC2tkKtNbpOlKbqXAGC6iQ9iMWJ39aMlmr6tAZ5WmreG1EAPN9SDhSGxBndtIgLVf1tRJ8S9mM7Bgxoku3PuMmbY8png89R0Q5bAo3pa6kWxjcN0IoN2CYCIoVArPlccf8txFbHF04SzII3oQlBsyj5V3ZxlkcIGnp6ZoSF4sn3w1IUMoXwAwZcMIBOGEktUHGyBtzoC73X5cCCxlg1hGdmys3K7BlZngbs4u0RPTLUZ6iwlccZb3ooNjTeMoyTVXFbpCtymrW25rlnU6G2LdGR08vgFzby0wC5z7zN7SK4ENFaWe1QV6j99eFT7wEMI4v3D3MJdQL59e6FrsaSwOjc0KfAAjWctOtymm1pSk8vFYu6Lxrc7flEhvB40D3vDpK2TgJdGuArse1H6FymbvCpfK2CkQXaMMNyEPledafl5A32qeE0rGKUQQI2PM0J4v8XgGEx04Pce2yGbc8r07RcFlm0kbegDlaGn7XBsyXHkSYmNNSqxQJtUcrF2nLnljC7M26QfPs7FYFy0uHMjJ9ty6d2cRsXxIOVLIV47TmLS9x25hFtxDY4PiPGVMzWhNa7LQcl1RK3XDUgGTYWKEakgahxNG6y06X1pIr2gyfxWsJOC7Ool"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                IssueVisibility issuevisibility = createIssueVisibility();
                java.lang.reflect.Field field = issuevisibility.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(issuevisibility, null);
                        validateIssueVisibility(contraints, issuevisibility);
                        failureCount++;
                        break;
                    case 2:
                        issuevisibility.setIssueVisibilityName(contraints.getNegativeValue().toString());
                        validateIssueVisibility(contraints, issuevisibility);
                        failureCount++;
                        break;
                    case 3:
                        issuevisibility.setIssueVisibilityDesc(contraints.getNegativeValue().toString());
                        validateIssueVisibility(contraints, issuevisibility);
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
