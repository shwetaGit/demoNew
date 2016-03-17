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
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssuePriorityRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssuePriority;
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
public class IssuePriorityTestCase extends EntityTestCriteria {

    @Autowired
    private IssuePriorityRepository<IssuePriority> issuepriorityRepository;

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

    private IssuePriority createIssuePriority() throws SpartanPersistenceException, SpartanConstraintViolationException {
        IssuePriority issuepriority = new IssuePriority();
        issuepriority.setIssuePriorityName("2C8jJrJkyJCBHYSvx67SA9mtfS8aujKcKXtEhklRbu8Ul7OrGR");
        issuepriority.setIssuePriorityDesc("3dxRlwtkqX2QQo8UDGniGp9OlLmfbQjpHdPixrmVLnZkhyfrln");
        issuepriority.setEntityValidator(entityValidator);
        return issuepriority;
    }

    @Test
    public void test1Save() {
        try {
            IssuePriority issuepriority = createIssuePriority();
            issuepriority.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issuepriority.isValid();
            issuepriorityRepository.save(issuepriority);
            map.put("IssuePriorityPrimaryKey", issuepriority._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssuePriorityPrimaryKey"));
            IssuePriority issuepriority = issuepriorityRepository.findById((java.lang.String) map.get("IssuePriorityPrimaryKey"));
            issuepriority.setIssuePriorityName("W9aPDOKKfFT7Ab31FFegEscX6uDUeEEX2YSOICG2tSyLIQpyOF");
            issuepriority.setIssuePriorityDesc("jiHf9x6yWXVc7Z4LYjw9NkIfdMtMnCyhOcqVXJVrkhenT79tb9");
            issuepriority.setVersionId(1);
            issuepriority.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issuepriorityRepository.update(issuepriority);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssuePriorityPrimaryKey"));
            issuepriorityRepository.findById((java.lang.String) map.get("IssuePriorityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssuePriorityPrimaryKey"));
            issuepriorityRepository.delete((java.lang.String) map.get("IssuePriorityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssuePriority(EntityTestCriteria contraints, IssuePriority issuepriority) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issuepriority.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issuepriority.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            issuepriority.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issuepriorityRepository.save(issuepriority);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "issuePriorityName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "issuePriorityName", "BaFaensID081EQLG1V3WivFTpYCHnoJQBxv8ydGgpSJpp72kDLKD65iDndDPdhQ18kp3KOwJni8D6fDT6N9iar8d3TryaJeeX5M6MqORJX1658kn0v40m0uAaSbEpXhPgcBZ8ngGgrkjvKdEzfWc8lUV0KmYsJAoKnMerGnuiXihFuD11FOqsz3ClzYEWXXMrWUeyh1WdvaeJysEHh9ixh9TBH8RuC66R9FmytM33fECUVUMGYiHFisrEQ1yA7vSd"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "issuePriorityDesc", "y7vfKOtj3GP3siGCPZWSPKMvEWhTqdJJyi9AzfYV1rcqZwmDKljzuXA45QpodYRZvywIMvndYHcYnwYjiDhT5d2FbsEhRHqL40HpIj8YSPG4IUkelax9FNLlCOUrHrbnx4Ruqrf8u0ki5Edpor1FSDXmEzG7mRuUjvhYzB75OIiHV2EM7Mt0aZGj0ifhOM4DySfHQJZ6y4WmxG3w3IEdASDgWz86Qa7qWaZg4b8xM1CZ6OaJcxv2WbR5xcpXu4Ll8O6CuALWFiKpv3sheFKSFgHJxMAQJ8F0CsLz72MeJm5vn114XE0wmMsmZDMs7WOLvbGk0JRpZonHoepwxcvP25PkziA8p5851szk1pa9UMnIuP6OUCLzTvoh3ExrYdhaU4zzPAfW6dsZUsIzuo6oB7zdbXhcbdCYCe34EmvNPNqDabf1vjOf7VuPRsG1P6X8KmnmrGewNQuPUe3AjcHowy3WxXt418dme3OD2UWTCY0HFrow07dJDTYkxJlGivoxzsX8uIqTee6rJ4YPmxW6rKv7ZWautASJzUoYHmfc5YCCDfDceaEOopTtZom5P9sAQAFGSGjll6KxKFTPmGsEWN0u3YKrB6L4ok9RHj6q4ksrdurnj3MfSqclvo5727ZrIVLTx36RpYtZj6BqJnDrdCcIFG7q6g2uAIZercSWBTSpbWf8pFMtYrJLHYJmAVnQPwA3QwvpORqPsT0kLHBmH3JPGUyYc0eTAw6dhL9VZNTwh7hYsyScdeUeydsJh41lpeLBBk6862HCxR6OH1MScPOr033otdhCERNUDtR9y58JTvTSMnS96YQitBCxjJBCnR3aa0jivdBTU1CJ7zoiclX5ruqfA3tiAUgz5Lc1k89TbCaPMj71GMXgPp1TZixGFKn4uGYlT1L4b08KtImi83yTgZiLvUcLe7JZkmjGeBqjkYK3QL5XPzXdSVwxhmuxLM8GbzWylVQSJzoKFnX1G4RP1TZeGWDo21zFUlC3GKPuEg57D7wUKolBnkTcZqN9O"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                IssuePriority issuepriority = createIssuePriority();
                java.lang.reflect.Field field = issuepriority.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(issuepriority, null);
                        validateIssuePriority(contraints, issuepriority);
                        failureCount++;
                        break;
                    case 2:
                        issuepriority.setIssuePriorityName(contraints.getNegativeValue().toString());
                        validateIssuePriority(contraints, issuepriority);
                        failureCount++;
                        break;
                    case 3:
                        issuepriority.setIssuePriorityDesc(contraints.getNegativeValue().toString());
                        validateIssuePriority(contraints, issuepriority);
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
