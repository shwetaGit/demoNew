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
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueFlagRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueFlag;
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
public class IssueFlagTestCase extends EntityTestCriteria {

    @Autowired
    private IssueFlagRepository<IssueFlag> issueflagRepository;

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

    private IssueFlag createIssueFlag() throws SpartanPersistenceException, SpartanConstraintViolationException {
        IssueFlag issueflag = new IssueFlag();
        issueflag.setIssueFlagDesc("C38e66qivlAKG6Dj23fV0emZ6mGwklLscUrFIsm3xxZP7lyYBW");
        issueflag.setIssueFlagName("Fzx1mjvUm0RoMTVXsFRbLVMtvLdnekGq6eJrQXKY3LhIjrfAtY");
        issueflag.setEntityValidator(entityValidator);
        return issueflag;
    }

    @Test
    public void test1Save() {
        try {
            IssueFlag issueflag = createIssueFlag();
            issueflag.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issueflag.isValid();
            issueflagRepository.save(issueflag);
            map.put("IssueFlagPrimaryKey", issueflag._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueFlagPrimaryKey"));
            IssueFlag issueflag = issueflagRepository.findById((java.lang.String) map.get("IssueFlagPrimaryKey"));
            issueflag.setIssueFlagDesc("F9e15IMrFAW0pliFelhyaaXW8LJkamKTLcGWc6dU6UQqyX3NTt");
            issueflag.setIssueFlagName("MMjYJDed1epf4bzkI0XwK6YLbjXXAa4HHx8bOMi8FPTkXedPRq");
            issueflag.setVersionId(1);
            issueflag.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issueflagRepository.update(issueflag);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueFlagPrimaryKey"));
            issueflagRepository.findById((java.lang.String) map.get("IssueFlagPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueFlagPrimaryKey"));
            issueflagRepository.delete((java.lang.String) map.get("IssueFlagPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssueFlag(EntityTestCriteria contraints, IssueFlag issueflag) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issueflag.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issueflag.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            issueflag.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issueflagRepository.save(issueflag);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "issueFlagName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "issueFlagName", "J6LX7loUp01ANvNc16ahOnQBkhi3WxecXDkQ5m9pJxgXxNFalBTPSslmZVLU0q4Os7tTeETjCXnE4TYZbAQ5jKjDPiABrufMsjdJNTAwg4cSERtleybfiBBX3lUBP1qmCHqtMagi2qEHM1TLZ6m1eRPkPyZGkLAYt9D1wDWxrgFRWDWkUfTCfH8eYyJtb8c5F4Dph5fPbxjbesJQdzeZCfp3tS00DnBQ5MJHHBziTgeURwfgBDtYiMT52ZCP2j18I"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "issueFlagDesc", "FXaVLPbmlcGFUdTcf4xtPdGKQjNac3HX34Y3mg9KTvpSaCfo8KSiaV9qUlvpzix8gK1h3X1WH1UcpEA1e5881kA8yvnfgTC770BBcVjRWNR1dkdyYjaoACeFypXHPVNbydwKJTxXgiY8F5jqoVsI7BIiuJEM80pMrB8qu5wPVT4eia28qVuIetutR4IHit5QVxslzumEQefxEw5iRM2NzI9ptPs6LdM7vkk4sj61JOEZlPDR80rniBAtwiCM6zgCoI0BVd9uKHC4ncuEmk8kLSjsvmsAJmxAshnsnld1jXXYSmGdap7iu0KmSNrYOMBm6YJRbD1GOKHwq6SfQJxJLcEukgRU2IH0dmqpj6D8uaWpdNRNGrS1pBp1sJrxxZqhw92tiRCzRvNwtXtdJOogoPMT1n4dMED8jmpV9BWZNMDLEpFc26stLloZmx44RQo5StXl8X8rLpSI5bmPorWrkTFwARBu0t3ZCzuLMsxOKeOVNl8QlC1JU9OsqXLtxwYbS23dz6jnBs2LK5j4yv9yzfH0zmrwtZlE51TvBqlX0O0dftUwtrq658ZrM5SuYMAo8j140pjOyumqskcMFQjPQIhVAWqMXlYD7kaFG9VkIxfIpWdZ6YPxwHtPucLIlS7fkcNoho4cLbEfnOZEL9CyvejGBb3iyUeZYQOF93TtsyZNSJFSJs46FYo0OaLqTrGPgYWss0fkirodHJiF9fid6XpaTNkjbET9VT9s04ccH0alEH1MsXua8DuXNh2MIEoUlz35BoIVbKulZjmkL19FvgCck3moeMjrBo75FIgEKwey6tRP52NohviZRd8Bfxytl65rA7xe6AaeVo5Yn8yYkba7m1EfbtHsdI4BszWZuCHF0j1UuU70tASd6SZEmZajITZ9SYBYrxB3KewlZ85bWMNV2s3NyIfhgZlbQLWWsPcrh2ekvi8NyoSsj73gEG1yd4Fk3fuFz8HtSetsq0CDH8hA4RJVHiLZ0ogcpaqWFOMffjA9dOE8G4ByoubxNkOXE"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                IssueFlag issueflag = createIssueFlag();
                java.lang.reflect.Field field = issueflag.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(issueflag, null);
                        validateIssueFlag(contraints, issueflag);
                        failureCount++;
                        break;
                    case 2:
                        issueflag.setIssueFlagName(contraints.getNegativeValue().toString());
                        validateIssueFlag(contraints, issueflag);
                        failureCount++;
                        break;
                    case 3:
                        issueflag.setIssueFlagDesc(contraints.getNegativeValue().toString());
                        validateIssueFlag(contraints, issueflag);
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
