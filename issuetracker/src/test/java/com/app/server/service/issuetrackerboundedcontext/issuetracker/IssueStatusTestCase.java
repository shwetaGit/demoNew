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
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueStatusRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueStatus;
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
public class IssueStatusTestCase extends EntityTestCriteria {

    @Autowired
    private IssueStatusRepository<IssueStatus> issuestatusRepository;

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

    private IssueStatus createIssueStatus() throws SpartanPersistenceException, SpartanConstraintViolationException {
        IssueStage issuestage = new IssueStage();
        issuestage.setIssueStageId("MvRoZlbLbj9qRiBatdxYDl6CTm9Wn8eJgqBwj93sz2fbmdCdcs");
        issuestage.setIssueStageDesc("zdLlpARMLULmxkrcY7Cv2hcPjIv3jS0jjUJdyOC9ZmVPWZDyit");
        issuestage.setIssueStageName("gbR94XrymshvKy6SsTYgDsZPNl6Nkh6rYlzrTSLBfVaVy94PeT");
        IssueStage IssueStageTest = issuestageRepository.save(issuestage);
        map.put("IssueStagePrimaryKey", issuestage._getPrimarykey());
        IssueStatus issuestatus = new IssueStatus();
        issuestatus.setIssueStatusName("fZXESRgDGDMBdV7LimKrd0AWsgF8i5Fexdx0CHJGzUHPOvIjIK");
        issuestatus.setIssueStatusDesc("xebZuBHfD1SC0AU0Ecg927yvwQXwYGjtb7Ylaft0FePMYGaOT5");
        issuestatus.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey());
        issuestatus.setIssueStatusId(valueGenerator.randomValueGenerate("String", 64, 0));
        issuestatus.setEntityValidator(entityValidator);
        return issuestatus;
    }

    @Test
    public void test1Save() {
        try {
            IssueStatus issuestatus = createIssueStatus();
            issuestatus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issuestatus.isValid();
            issuestatusRepository.save(issuestatus);
            map.put("IssueStatusPrimaryKey", issuestatus._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private IssueStageRepository<IssueStage> issuestageRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueStatusPrimaryKey"));
            IssueStatus issuestatus = issuestatusRepository.findById((java.lang.String) map.get("IssueStatusPrimaryKey"));
            issuestatus.setIssueStatusName("9oggjvLpCqYcr4dlLHokO5xwZFcf8X5hKJPBEwEqCtEMtWR3Hs");
            issuestatus.setIssueStatusDesc("xYDYal6Rd0r1ivZRkT2VA0gPDud1NTK2CoC1Y0rXn5vmvo068T");
            issuestatus.setVersionId(1);
            issuestatus.setIssueStatusId("xuvHto4zv2eLi6J1aD7NEfAYyEarMyja550Vd8rKaDzjNfLHba");
            issuestatus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issuestatusRepository.update(issuestatus);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueStageCode() {
        try {
            java.util.List<IssueStatus> listofissueStageCode = issuestatusRepository.findByIssueStageCode((java.lang.String) map.get("IssueStagePrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("IssueStatusPrimaryKey"));
            issuestatusRepository.findById((java.lang.String) map.get("IssueStatusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueStatusPrimaryKey"));
            issuestatusRepository.delete((java.lang.String) map.get("IssueStatusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssueStatus(EntityTestCriteria contraints, IssueStatus issuestatus) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issuestatus.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issuestatus.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            issuestatus.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issuestatusRepository.save(issuestatus);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "issueStatusId", null));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 2, "issueStatusId", ""));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "issueStatusId", "4CB32IFnYuZKXGogLcuyDgcW0yo6nDQspJPpHr1cPOGIdvunoQ9ldYSAbuMeglhEQ"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "issueStatusName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "issueStatusName", "Q8yl6UBBy7sCCBw0HIzb5JIiAnTqkNOShCp8knrvEX3G2aFzKI5aMLMK4S7uxjYjHjCY8QUVNH2OMFUjebgHis8pjyIBLXF9ombvvamLDzU5UMXmB2oOvpiPdIzZxvu339t32Lw5O6Y8LHa5Ccjm2dn7c3aVI5RrOxdOQA6UDLRo7ej2ndEIDiGh7wkKnHSPKzWP8Yj6KpYftYRZv6ohCXpB0x28DgW8BEQuFR6ByfsanNMPO1RTml0HSHMO3qCGS"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "issueStatusDesc", "Cpl6rZQd9L9oPyQD2pctYQcbzC3mRsvgMQXK10rdOKJTiSKOPjQjh4VBgT83CU1Z2cv9SBiEgzbzJhKfoO8PYyhwnaBurD56otXdStOCDrFHwNsca9guW407ofuwDjxeT1g9yR7JXF8ag4mHvSG5uIDM8JpBJWXpyPrd9jFIU1fteTHUiTrP9nLEuJBIp7CxRwnIzXrFTsJpMuL3qZyjtaKpXtaPRvCltJHvHhvFkJ8R2V8iGDsM75Yt2F8zQ46i3elocKFmo01en7RdxrCi7KAIBCEbE6q68bTB0pSXajnJbZY0F6Iohw8xfDzsGTuzDpW5D80M7vEwGj1A7nkm3e64Rk01poKV3vPEzkL6iapM49lPgbLt5u6cky4R6KUpIhVsgjlvl1NdT82i6dmf6mme5M9XAf5J7v1g7rgM9hQIVcuHQwYZ8qhGhC30HtXcFVvtgTgpx6ZVDUXZahQdkn5iCkfRCDrsXpCJZZZ64fhbhgvGr7I03emOlDyflcnoq5JXOkcxsecrPYXz5YZAohRMBeJ76CZiICq9xycwEMBErJ8nVC2uLSyEkJLDlfioG1M4HhCD6mdaVYoCQJ1JRjOWyCsM6BeCD4QfqYukQ0HtOtLO8CFQO5hAs0hOObL4mbwfAGWDI0Zekc7bEkpomdNoUGfWpATuOCY6VN8Wa5CYFYyvpmDqhdlpnnoUXGHYzRLHnBe8FeJRH1VC0xutImvSaPMP0t3Iocp7vLrSJlu56ixEaLPExMpr6yAxD25Ir2u5Bhruz7ijn31Jtksw3vjbmlu2IxyMQaGlxrIFqTXC86ztuWsRuqdfyvYdw80QRolpf2lpBnOl92jZIEAqWXQjhTojELfY4SOivV4W4hqgsb9Kwj4JgNtouPqlNMaFcDvtzSkvyqoQfUa6NOP1WMGQb5kYgRrN38CVILLmoFJjPwXIa7i8XatvxCMdT2qb0EStaZrCje10vZ90qC1JGCGN0S8zLpGUoZqNhzDTKHsrf3QBxa5QINBoAC3MQ6jcT"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                IssueStatus issuestatus = createIssueStatus();
                java.lang.reflect.Field field = issuestatus.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(issuestatus, null);
                        validateIssueStatus(contraints, issuestatus);
                        failureCount++;
                        break;
                    case 2:
                        IssueStatus issuestatusUnique = issuestatusRepository.findById((java.lang.String) map.get("IssueStatusPrimaryKey"));
                        issuestatus.setIssueStatusId(issuestatusUnique.getIssueStatusId());
                        validateIssueStatus(contraints, issuestatus);
                        failureCount++;
                        break;
                    case 3:
                        issuestatus.setIssueStatusId(contraints.getNegativeValue().toString());
                        validateIssueStatus(contraints, issuestatus);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(issuestatus, null);
                        validateIssueStatus(contraints, issuestatus);
                        failureCount++;
                        break;
                    case 5:
                        issuestatus.setIssueStatusName(contraints.getNegativeValue().toString());
                        validateIssueStatus(contraints, issuestatus);
                        failureCount++;
                        break;
                    case 6:
                        issuestatus.setIssueStatusDesc(contraints.getNegativeValue().toString());
                        validateIssueStatus(contraints, issuestatus);
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
