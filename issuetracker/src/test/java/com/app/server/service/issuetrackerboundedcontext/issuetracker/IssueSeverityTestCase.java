package com.app.server.service.issuetrackerboundedcontext.issuetracker;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueSeverityRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueSeverity;
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
public class IssueSeverityTestCase extends EntityTestCriteria {

    @Autowired
    private IssueSeverityRepository<IssueSeverity> issueseverityRepository;

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

    private IssueSeverity createIssueSeverity() throws SpartanPersistenceException, SpartanConstraintViolationException {
        IssueSeverity issueseverity = new IssueSeverity();
        issueseverity.setIssueSeverityName("bm1DrCHSMubovLcjcYKsUtugPalFsCo9VIIMa5uvH2CEwFOg4j");
        issueseverity.setIssueSeverityDesc("MYPwLopPEzHfwU6WUfrr769tYmYxXAnkoDf8A1L9hgna8IsgPh");
        issueseverity.setEntityValidator(entityValidator);
        return issueseverity;
    }

    @Test
    public void test1Save() {
        try {
            IssueSeverity issueseverity = createIssueSeverity();
            issueseverity.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issueseverity.isValid();
            issueseverityRepository.save(issueseverity);
            map.put("IssueSeverityPrimaryKey", issueseverity._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueSeverityPrimaryKey"));
            IssueSeverity issueseverity = issueseverityRepository.findById((java.lang.String) map.get("IssueSeverityPrimaryKey"));
            issueseverity.setIssueSeverityName("mf93P0188aA7kIu0cu9GuaLLovj5nPjBnj7NM6ZHaYSZNMOF3g");
            issueseverity.setIssueSeverityDesc("v3kbQezuzN33yIFMJvCo4vANEHjYUUIWFhVTl16pJ5EwxHU1Ab");
            issueseverity.setVersionId(1);
            issueseverity.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issueseverityRepository.update(issueseverity);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueSeverityPrimaryKey"));
            issueseverityRepository.findById((java.lang.String) map.get("IssueSeverityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueSeverityPrimaryKey"));
            issueseverityRepository.delete((java.lang.String) map.get("IssueSeverityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssueSeverity(EntityTestCriteria contraints, IssueSeverity issueseverity) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issueseverity.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issueseverity.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            issueseverity.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issueseverityRepository.save(issueseverity);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "issueSeverityName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "issueSeverityName", "u5a98AnuFAr6DwTtecAexkRSUdMciqpMtIXBy4iypHtksvWjz76FnOXLrHTK4m5tixYBNRKKS4IWHVy0GyGv0lNkzDMXES9iQJNIfUhPBqUeNuRWXeaWZ8718H5Hsah3dUSO70Pxo3HHNVR18Sw7CfSQodIHGxapnHhcdj0kec4bHuKDHfNIkK8pV3uidHBhxmWDVWzZ4pZspelA4mABEi2Il3LilK57SYU931qFML0JVxGqHjBHrhZc7ORHg4dWb"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "issueSeverityDesc", "fJG1TCwzWpLzHCAZy3YzOVVszEe13cHvKp4P2ASaDkwqo2DUSybkuJC8vYBmntyU3o6xv10udcQCmvcch3ZzDqOAF0erSMfrlrrWAmhsrPCLdQNyXGHerLRyAC6nUY33duPjVGeUGu0oBr2JFyINwHanACyIXghCEeUcY3pSjkzLUdxV7E9lo3VC086yFKP6nqIh1sUXdKdlvzvDIc6lxYc6FCi6gnbcteolcoIkjP4KaA5GSUtqvwVCElBCDegoxQtJjD6WkFZECZKZRFEtywcOppJw6ELAVtXbkGL80BELLgPmmnHJ4X7cZYkgsO8EojKGN1DkRfqT5oC8Luwvo23dMGHZ13wQYGvzLYOQ4rIXxRHQY8lUvczUpRNsi2UeC0d7EGULXYcGJjiwyBFUbL8WL68IZfkSaxEYpG6mCywyAYMfa7Gl1SiCJUyRqttUrrQwMIS2PSwx7Q0O66whLO3iEjWoRlTOdF9fME2YzDFdA4RzyZ8iUid7QzAkFkUYzXASNSQaYAQSHCzlxQiTG5vQxup9RRm4DbSVMh7DGcnpwbMtlHgqo9S3enfV1gt3AhBM2kx2oxi8ZQZpS0Q5u7RK7mirbgr5Jn7abf5B3OuggtP2B9QlcoXOiWNYu4xOZArhdmbfMhVtHH1bId4EIrIH6nBYx7YtfaQBIQ9U4oHvdBpx2W8nKbwz1ZE30y0xSJolw3frKXVbH0fiTqPoCIT2u9mlbpVGTLbbfTC9FHW7rxSbEjkbKjEyCsgo4Z97p8h3FLGGSe6tq9nX7EOSwP0PgU0mihe15FLwWfpAi1Phr12YpviB0pCv6QDrZEkdP8scmYtQ9JgzKDj5RrJ6AesMoczwyjq04P0lSKxceTvkecD70HV7btoM7RCXNITEmChX7YsWbCp3XfPe1ynj1mGsKlZDPi1DePkbnDdrrMzir9Evb9RvXskHENrMeZEIublfJROAKqBLmzq7FyTddosFGkKo8NAMB50zDznNLs7SQhdkcior2GpD3moVZsZAh"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                IssueSeverity issueseverity = createIssueSeverity();
                java.lang.reflect.Field field = issueseverity.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(issueseverity, null);
                        validateIssueSeverity(contraints, issueseverity);
                        failureCount++;
                        break;
                    case 2:
                        issueseverity.setIssueSeverityName(contraints.getNegativeValue().toString());
                        validateIssueSeverity(contraints, issueseverity);
                        failureCount++;
                        break;
                    case 3:
                        issueseverity.setIssueSeverityDesc(contraints.getNegativeValue().toString());
                        validateIssueSeverity(contraints, issueseverity);
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
