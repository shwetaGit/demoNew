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
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.FeatureCategoryRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.FeatureCategory;
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
public class FeatureCategoryTestCase extends EntityTestCriteria {

    @Autowired
    private FeatureCategoryRepository<FeatureCategory> featurecategoryRepository;

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

    private FeatureCategory createFeatureCategory() throws SpartanPersistenceException, SpartanConstraintViolationException {
        FeatureCategory featurecategory = new FeatureCategory();
        featurecategory.setFeatureCategoryName("FnZElNfKOaX2a3qYQ3xbrWrCZg4HGIxZ9DBiDICDKmTsR9EB87");
        featurecategory.setFeatureCategoryDesc("qYUPa2tYlGI1klcS7iAeVXvKMJeZZsHewr7CqfxptRl2T8QG7N");
        featurecategory.setEntityValidator(entityValidator);
        return featurecategory;
    }

    @Test
    public void test1Save() {
        try {
            FeatureCategory featurecategory = createFeatureCategory();
            featurecategory.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            featurecategory.isValid();
            featurecategoryRepository.save(featurecategory);
            map.put("FeatureCategoryPrimaryKey", featurecategory._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("FeatureCategoryPrimaryKey"));
            FeatureCategory featurecategory = featurecategoryRepository.findById((java.lang.String) map.get("FeatureCategoryPrimaryKey"));
            featurecategory.setFeatureCategoryName("KF4oOWkLSAMZypvtMdCGCwjEMUAnwakqr1UZRvqPISaSAEBFjV");
            featurecategory.setFeatureCategoryDesc("MxgprKN55rZVvapOB6LBlCIjY0fZvSKB0hbiMVOZcS2PtvcY10");
            featurecategory.setVersionId(1);
            featurecategory.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            featurecategoryRepository.update(featurecategory);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("FeatureCategoryPrimaryKey"));
            featurecategoryRepository.findById((java.lang.String) map.get("FeatureCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("FeatureCategoryPrimaryKey"));
            featurecategoryRepository.delete((java.lang.String) map.get("FeatureCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateFeatureCategory(EntityTestCriteria contraints, FeatureCategory featurecategory) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            featurecategory.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            featurecategory.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            featurecategory.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            featurecategoryRepository.save(featurecategory);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "featureCategoryName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "featureCategoryName", "7cbdatvJubtN3fw0WC1qjXOXKCo2XtdbEahX0FKayZ3Bb3x2F8sr0vcbKlUCCqTHBJCNY6zDA4WdOK3PzuO9GvH40TtGxvdiuBCsL8EBn4pIm6IhLJa4N0pJV61cSqdq85WkHlqQgtCvdz5SZtmadneSfWzRnygv68DzO5U1oyEx1X84mvPG4E4LG06xD2tLagJgR9kdlSes5agnBmYgfl7UCBkZMwDKPXV4kWNky3HhVsP3P2KocluZ0kGmhsEWx"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "featureCategoryDesc", "hAEw286AJFobfxorqzb4mS6Hf0jpeQR9y46sOknbHTULxosC8Cuy7VDUCp3vFjthOczsUZx6gChxKclfAcX2XjqyUKp8eG2kInUcSRkLLsmO8M9oZvGmgaFwu80idMpdTWql360W6AZOzgzuC2aTG4WtoyGYEqY4der3FhGoJDAV8zBa5mzvXiXxS6sSyg4cIh53B0RcN5sbnr8aRlz6gaEZw2AOjqNUkrRanxxu1LYCcGUNhmtcdmkOExDlJGIRLrYh3TDan4Tfkz25PQB3KXT5uXjnuStQRM9HUeqG5qk7Oki5grmN3xef78RjCzwtnjFIBeElXwOgqla7sIafsdlmkMj2xS97SfSVwbgkfzwFo4Sz7YJXpTpBkYUpniL9SKy6vC6tJWa5arqqFxKRvlCVZvUtELNcRs4bTMwW6xm49vsqIeppW9N7p8q4qN7RumVceg2XVbplW5aTSEGFAvTy2JxJlAF7ImE7X2c5C7O1bb0egdcGZeCCjTg6Dvqzw6fJaY035tEuUlqonOS6ON8AJdyPb1pHce36X4gnKsrMKHiFzONNSY7DXtSyPziwCNwQZ54TDPYgYl2H8cYbzrxOlcxVhPQ9Zi9humWS6SwxgMdfQYlWa8YKrXYlWPuu24EMTs6qusAdYFv1VfqFtXmJVakipHq8nLSrNNiH86of07b7NYWWopOiX2FgOGrhoks7KJelyg0Zt0BUfv5VIiJHhMgVzqzDuIRfaC2zCVTq8a2sMPZgmb3m481Vv1nrAxqkFWBBBmukLz2yEPvR62VtNnxhkAVSkCURo8tGQX00qUxopPVjEpn8Ya0tstk6jIIkANDRe769M2HhkUaPJqowRFHb6KkmOFTOzNZPx3GntwukmHHPbJMBldbLXfbbxwKtBsKXh10ERmErIIV6iyASzZdTXpB07OlV5KEDd6jJjoDPIQ61pZiweEdG4ZMaQ6zondpgc7Kcu0RD4uSwzRg3e2P6Bqe2aQ6bhwrDINqcIegSDZiMYHGknuSCmOzG9"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                FeatureCategory featurecategory = createFeatureCategory();
                java.lang.reflect.Field field = featurecategory.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(featurecategory, null);
                        validateFeatureCategory(contraints, featurecategory);
                        failureCount++;
                        break;
                    case 2:
                        featurecategory.setFeatureCategoryName(contraints.getNegativeValue().toString());
                        validateFeatureCategory(contraints, featurecategory);
                        failureCount++;
                        break;
                    case 3:
                        featurecategory.setFeatureCategoryDesc(contraints.getNegativeValue().toString());
                        validateFeatureCategory(contraints, featurecategory);
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
