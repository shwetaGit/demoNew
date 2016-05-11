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
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueActivityRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueActivity;
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
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueStatus;
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueStatusRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueStage;
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueStageRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class IssueActivityTestCase extends EntityTestCriteria {

    @Autowired
    private IssueActivityRepository<IssueActivity> issueactivityRepository;

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

    private IssueActivity createIssueActivity() throws SpartanPersistenceException, SpartanConstraintViolationException {
        IssueStatus issuestatus = new IssueStatus();
        issuestatus.setIssueStatusName("MKHuXnaKxcqS3Kenx6EnWY4ccirsKfMIMNoo0rdc9qep6WRiZA");
        issuestatus.setIssueStatusDesc("i5JnoEtODs8lBgffEHhh1BSTbyDAsNGGG14rgqK7o6TPdOEhNs");
        IssueStage issuestage = new IssueStage();
        issuestage.setIssueStageId("XbmU1hCzQNNQuZgyr09luc6z365Q4IlMEVT7hnVrLriHQy6I39");
        issuestage.setIssueStageDesc("8JIj0M4r1JaE9NiRdWIOQvO4w3FGVP8cYRHQIZd6tAWsED3Yyq");
        issuestage.setIssueStageName("DZUJncrBpqFtwjDvUXCT1jtJPddRPvwZuNEscMH3TkP9fOS32m");
        IssueStage IssueStageTest = issuestageRepository.save(issuestage);
        map.put("IssueStagePrimaryKey", issuestage._getPrimarykey());
        issuestatus.setIssueStatusName("FaiuasdI1zppWfN963U3XW6M7Dnb5nVp5oNJPBS5UQHaXr3nT2");
        issuestatus.setIssueStatusDesc("YKdFJUo5MCmHaOIJjDUUFwd0dRPG6PEydafkq7jtNALjr5nPkj");
        issuestatus.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuestatus.setIssueStatusId(valueGenerator.randomValueGenerate("String", 64, 0));
        IssueStatus IssueStatusTest = issuestatusRepository.save(issuestatus);
        map.put("IssueStatusPrimaryKey", issuestatus._getPrimarykey());
        IssueActivity issueactivity = new IssueActivity();
        issueactivity.setIssueStatusCode((java.lang.String) IssueStatusTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueactivity.setIssueActivityDesc("vuRLVeythEKdiNiByJFSLLIOBvBMp9LNOlOPJCXcjtUyoMI0Fy");
        issueactivity.setIssueActivityName("EivLfPROSlSjCCXesBGsXkwtrbCaoIkVm3p6nC1RGsa9UER4Qp");
        issueactivity.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey());
        issueactivity.setIssueActivityId(valueGenerator.randomValueGenerate("String", 64, 0));
        issueactivity.setEntityValidator(entityValidator);
        return issueactivity;
    }

    @Test
    public void test1Save() {
        try {
            IssueActivity issueactivity = createIssueActivity();
            issueactivity.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issueactivity.isValid();
            issueactivityRepository.save(issueactivity);
            map.put("IssueActivityPrimaryKey", issueactivity._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private IssueStatusRepository<IssueStatus> issuestatusRepository;

    @Autowired
    private IssueStageRepository<IssueStage> issuestageRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueActivityPrimaryKey"));
            IssueActivity issueactivity = issueactivityRepository.findById((java.lang.String) map.get("IssueActivityPrimaryKey"));
            issueactivity.setIssueActivityDesc("IeZXKR92LksNHlfUVUnDPluYdpwQDBm7xBADJybzZ1pllbNtp6");
            issueactivity.setIssueActivityName("t0XyuZXsn4N4IayRzXMLJ3QbJrHaOQS82ADa6hiCVOCg8JnbaE");
            issueactivity.setIssueActivityId("GWZFCpnQhY2lx1juBweq6E3rXGBmJvoiG21nqAMnmiovmvIg39");
            issueactivity.setVersionId(1);
            issueactivity.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issueactivityRepository.update(issueactivity);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueStatusCode() {
        try {
            java.util.List<IssueActivity> listofissueStatusCode = issueactivityRepository.findByIssueStatusCode((java.lang.String) map.get("IssueStatusPrimaryKey"));
            if (listofissueStatusCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueStageCode() {
        try {
            java.util.List<IssueActivity> listofissueStageCode = issueactivityRepository.findByIssueStageCode((java.lang.String) map.get("IssueStagePrimaryKey"));
            if (listofissueStageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueActivityPrimaryKey"));
            issueactivityRepository.findById((java.lang.String) map.get("IssueActivityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueActivityPrimaryKey"));
            issueactivityRepository.delete((java.lang.String) map.get("IssueActivityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssueActivity(EntityTestCriteria contraints, IssueActivity issueactivity) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issueactivity.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issueactivity.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            issueactivity.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issueactivityRepository.save(issueactivity);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "issueActivityId", null));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 2, "issueActivityId", ""));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "issueActivityId", "6noAjYWVjpOqYrBLrzV8gep2OB5KEB7zr55V7EosjJi8VMBSMCoSKVXzY36G1WXUR"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "issueActivityName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "issueActivityName", "MkNjVk262EJcoUjAitetjaLUfPXI1Xt2wxz3t3NVK5tGGrvJBboaZOjeMzn5lV54xMEmjNOxyEKh0zNNY7UwEh6uP2UWuRR3cduoqEX2nAGMUXMBcL4aKElRCWi22I7LuVFMc6fLPgnMFKfXPlFRR9dx9SxDrUm5f7TrLyvqil7wY4PwbFlfcarQO2do5NqPwg3nyaOljIw1b0xrM3SLQ4YKMhaH22uRpiORUOEh3qLpJR8Er0Smj0FNkNSCfw8nO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "issueActivityDesc", "Z5jOJCqSbQVSFRHFqsQ5xFmUGygrjPlEJVeqC9TOHcqcbm5YWWen2YvGrq7I6WAJ9E64melaiXxLSxwZwk0YB1QtvzG0sQcq1c3JgQqW7I976tWCe4D4Oo1KDJfsyBZBp5I2qQkiptpeqKBTdSromEeNyTLrX518wkVXo7MNHj5zXYn1RJux2s4E7Rj0HPcc0tcHboelp9Al1akIKFXZFw3fV5zBekXuLN67P8yS1LtN14PHWlwkA3xxQVgmDG4YbIsQ0K2gF3JNMx20oTkH1NyTMKRyEzRcxJWNi3Wt8p9hgkrBuC11lsa9KtRwBIkHIAGZIcYjArZ86am7Ok5ml7iXs8bgIY7fWLeNH6hX7VwWju9dZTx9tFQU5bizMsbFTQdEGd7TufNQ1n5vRhDdAHm05D5bWWqDlb8trYyjj9pPlEAjuk6wtoa5erSt1V2jmMpf31ymEVdZGaOc9giC0tM6D7CWRvnyGpgBpBFWcif91OX8yzIk8TsEuKgiLORv0MQbtsSFj963QFxBdztf8lF5HFMZsP6O755Me3B3PehLAqZgFivjoOLdm2TmUS8FnOQvRXMeRaTAkMTy6zHRLOqH7KoWaNQBCb0UmZFUzJB1KqbbOrEE2wmN5BAphLEoyJhd6oKqfSDrv231X2nmh8RWZwQ255au92cjUrlitbyX6tVZU13bBBqezltf1qHI8nIRkRhq8vzol9ELHtqenplnlNqTmJdtWgeuR7IgAyRzF6LJWyTEbJ6VJSLtyZe35Gz4aeQBNiHrDNSVGFkxsNrA1slfUzyS5Lkt0dDoCXoW9EaHtM3pJjWlo1prRrNB4MMCP9HNJT5PspgZ7dfjIo1ncpq8vIpIG4tsAadlAWQ9thCZLa9kCw5LbkR79mEPq3mVuJTsEA0WPRJ5pPHvMXCT4YGUaqt9ENILbYVKRxWcWkILF4YwP0qm97Uo2aCXA01vUSF8j7goXJNbODNDAgUCT22A2DRnpaMcnvtcHbBnHHq9ooDrtBv1CxZY5PqjZ"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                IssueActivity issueactivity = createIssueActivity();
                java.lang.reflect.Field field = issueactivity.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(issueactivity, null);
                        validateIssueActivity(contraints, issueactivity);
                        failureCount++;
                        break;
                    case 2:
                        IssueActivity issueactivityUnique = issueactivityRepository.findById((java.lang.String) map.get("IssueActivityPrimaryKey"));
                        issueactivity.setIssueActivityId(issueactivityUnique.getIssueActivityId());
                        validateIssueActivity(contraints, issueactivity);
                        failureCount++;
                        break;
                    case 3:
                        issueactivity.setIssueActivityId(contraints.getNegativeValue().toString());
                        validateIssueActivity(contraints, issueactivity);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(issueactivity, null);
                        validateIssueActivity(contraints, issueactivity);
                        failureCount++;
                        break;
                    case 5:
                        issueactivity.setIssueActivityName(contraints.getNegativeValue().toString());
                        validateIssueActivity(contraints, issueactivity);
                        failureCount++;
                        break;
                    case 6:
                        issueactivity.setIssueActivityDesc(contraints.getNegativeValue().toString());
                        validateIssueActivity(contraints, issueactivity);
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
