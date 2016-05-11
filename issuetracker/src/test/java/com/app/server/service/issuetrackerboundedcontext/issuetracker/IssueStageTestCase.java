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
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueStageRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueStage;
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
public class IssueStageTestCase extends EntityTestCriteria {

    @Autowired
    private IssueStageRepository<IssueStage> issuestageRepository;

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

    private IssueStage createIssueStage() throws SpartanPersistenceException, SpartanConstraintViolationException {
        IssueStage issuestage = new IssueStage();
        issuestage.setIssueStageId("8JF45V4HkoMODo1PoUnZz1MNtQkCPL5U5XwIM7YPRJtOdED4GC");
        issuestage.setIssueStageDesc("d8V8HR2zBK2JYyOV5kkZDuAfAQLf7Z1r28nXNMaHm8IlSREu4F");
        issuestage.setIssueStageName("0ZXrJYTOZ8TdCQHzWDSHfuOAJMrrK7M7DLiVcw49uFtAfs4g2m");
        issuestage.setEntityValidator(entityValidator);
        return issuestage;
    }

    @Test
    public void test1Save() {
        try {
            IssueStage issuestage = createIssueStage();
            issuestage.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issuestage.isValid();
            issuestageRepository.save(issuestage);
            map.put("IssueStagePrimaryKey", issuestage._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueStagePrimaryKey"));
            IssueStage issuestage = issuestageRepository.findById((java.lang.String) map.get("IssueStagePrimaryKey"));
            issuestage.setIssueStageId("wjlD3CR1jjCtKhj2xsbLoYQb6XE3nqhaBFGajYUoLw2Q17JXdh");
            issuestage.setIssueStageDesc("4SooAD0CAj994Z8ilGk6wnURPhjlqg92oHAAQFbIDle7Hmgbi8");
            issuestage.setIssueStageName("H3mht0BAcBddPYjgeaEXswdHcypGKtf47oYNtmSvELdIwBrSWC");
            issuestage.setVersionId(1);
            issuestage.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issuestageRepository.update(issuestage);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueStagePrimaryKey"));
            issuestageRepository.findById((java.lang.String) map.get("IssueStagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueStagePrimaryKey"));
            issuestageRepository.delete((java.lang.String) map.get("IssueStagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssueStage(EntityTestCriteria contraints, IssueStage issuestage) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issuestage.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issuestage.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            issuestage.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issuestageRepository.save(issuestage);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "issueStageId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "issueStageId", "l6Iz6xzyM4G3sylfXyopu9efiF5I9vCkzxJgUZQjdXzYWifEamjjhnmRv2Mvxp373"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "issueStageName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "issueStageName", "gazNLezjMUVLbv3lHDrBjcZJu0t8qIsBG6TfffgKcXjoeFfpUCvxJ39B2su2ceL7m84fiTyNmr7ahmyaMnD32tHqwQBH5L938xHhSYub4LIw0qAouJqpsiWXYrZ3PrkA8XPfFo0Z3FY7jTkIAWzZhPmAdeBLHo6m1q9P3ULaEACT5KKJqP1nAyqAO9qrwtTygB9DXIn2hBC5JxJNjrfeql8oqLdUFrUhNF0aCaPiKl8v9ONADiusx9L7F3f2fD1as"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "issueStageDesc", "77marJUqoJBLd8u1H3F7Y50L0ixNVbDEyD5wDdqsdRXSzE7IhcbfohzdU1OBxYzAgb5O6cCndaYx9lH2gAoH2sLCo8nSlaUnAutm1WavK9mSs9Jk15unoGN0RwC8rKOznmx9euBazdB7kItIPQ8huRcbhTFXC6zOL7ylt0lvcJHOPMYHDRWdyJ10X64IThHk0zTf7oHvGQQ0fQURNJ6SKynQZblBYNRtzOg1agckAh30T8FTOecXWQc04LqrLy9FMTVr06fAvxo8gJJAR54PWHF2nawpwE6vBf7UDhT0SUtY71IgKUZvLQdu5hv2pyLDuN4f2TYv9D6NEA0M0gBX2sNzDh9dxi5mVMAyEVRLma37jJQQZU47yLcKtTnpsF1DEtVFgXHTUUWQWoFWyBIskAOR0amN8UBIPY5FYHlQcnF45kZt9URyBiQmedcIABWd6iWCwOIinoPJxW2Ss4cB0bHT23aZq5h3RgLd2IshOTcxRcri9CFye0zKHdIbUxuDshUBHsuKdb2Um6y9BCEBqf9jPcG0FrgzBLThubLu3UQLYuMvt35W0WJJgAlsHhrOWwIx6jo9XpVj7Iuq4fM1iXqbAdHWKXQv0JZDz3GKT7bBdqSQ4RmQvMMVDMTmhLdQMk3D5WBgu3Bk5Wxb9E719FS1Yj8kmo0fIxaZaSqlbabHsdNKKzVsbglNAGxpT9SDpOKE4voBw1HmFWOpjaUM1DhL01bXRIR95jJy49ML8ZgBYPspwGaEdGJbuV4YWw6tZTXA2UbYqHUJFfFJDKZZnnyezEJJKod2WwDQMV5uO4LzUVOH2bFclEvzu227QGZFl6ZIRJLsJKBRq9nEdsvc8BxudYli4d5Et0nV18mTOawrN03KYIZBHAmTBb4CO5PbgzfgfDd1HekAxoTdXiLqiaR7lwGeCMMzwb7nFtDuFFfGpPMf2x27NHkTyq11Hajzaze0p07RtPu3Jn5AJyukQcLkGkUX1c599JbKMT03jlb2DcyWC65Yp12Oh9Qg025Me"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                IssueStage issuestage = createIssueStage();
                java.lang.reflect.Field field = issuestage.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(issuestage, null);
                        validateIssueStage(contraints, issuestage);
                        failureCount++;
                        break;
                    case 2:
                        issuestage.setIssueStageId(contraints.getNegativeValue().toString());
                        validateIssueStage(contraints, issuestage);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(issuestage, null);
                        validateIssueStage(contraints, issuestage);
                        failureCount++;
                        break;
                    case 4:
                        issuestage.setIssueStageName(contraints.getNegativeValue().toString());
                        validateIssueStage(contraints, issuestage);
                        failureCount++;
                        break;
                    case 5:
                        issuestage.setIssueStageDesc(contraints.getNegativeValue().toString());
                        validateIssueStage(contraints, issuestage);
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
