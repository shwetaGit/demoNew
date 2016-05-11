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
import com.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueRelationTypeRepository;
import com.app.shared.issuetrackerboundedcontext.issuetracker.IssueRelationType;
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
public class IssueRelationTypeTestCase extends EntityTestCriteria {

    @Autowired
    private IssueRelationTypeRepository<IssueRelationType> issuerelationtypeRepository;

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

    private IssueRelationType createIssueRelationType() throws SpartanPersistenceException, SpartanConstraintViolationException {
        IssueRelationType issuerelationtype = new IssueRelationType();
        issuerelationtype.setRelationDesc("vcGsl9DLMRaiPJ0Qa24dvgSLxXaBFQcbbHN9xIwHxbfpksuGci");
        issuerelationtype.setRelationName("4hKbcmbTL1JdClb7synh5kjUqRZcDOGjvmgoPfLiZorx1stglx");
        issuerelationtype.setEntityValidator(entityValidator);
        return issuerelationtype;
    }

    @Test
    public void test1Save() {
        try {
            IssueRelationType issuerelationtype = createIssueRelationType();
            issuerelationtype.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issuerelationtype.isValid();
            issuerelationtypeRepository.save(issuerelationtype);
            map.put("IssueRelationTypePrimaryKey", issuerelationtype._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueRelationTypePrimaryKey"));
            IssueRelationType issuerelationtype = issuerelationtypeRepository.findById((java.lang.String) map.get("IssueRelationTypePrimaryKey"));
            issuerelationtype.setRelationDesc("Um7P6UV87Xc0Bqi475kprKQYFmQdvEQG1fidAn88fB39GLt3sv");
            issuerelationtype.setVersionId(1);
            issuerelationtype.setRelationName("Aa0v4VYSClL2otXkLYus1xmN1f4skVRPjBQfCVn77h1r1SZVh2");
            issuerelationtype.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issuerelationtypeRepository.update(issuerelationtype);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueRelationTypePrimaryKey"));
            issuerelationtypeRepository.findById((java.lang.String) map.get("IssueRelationTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueRelationTypePrimaryKey"));
            issuerelationtypeRepository.delete((java.lang.String) map.get("IssueRelationTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssueRelationType(EntityTestCriteria contraints, IssueRelationType issuerelationtype) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issuerelationtype.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issuerelationtype.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            issuerelationtype.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issuerelationtypeRepository.save(issuerelationtype);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "relationName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "relationName", "KLtbvy5zQRZk2KWVuSOeRAAvUbipeWMKOmxzMSZ10wDaarqlX5v7X1iDmmtjsOtYGuPnQ5gw3hpW0IFJlQpuMxVKLLkg8BVE4Bpq16mjRq2n2r6PWNsqfhKYpbi3hk8NMF9VFMezSSjVY620FxpqQLkjg0ZewGtJmppqsIhT1h0lwQ0xKRMwEFVMcKjJE9DrDq8yQwaYuhblYT0sRD9w2kkzyhcp9j3Vtixu0WWn47komUZBgn8enBGXqoR4eV9HC"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "relationDesc", "pcQI99I05NkFN1RJval8mL9ISedSEscnMFu3oqvTLeg8xFRK87SDkYy8h5JoQekZ440Mjmzyd9UltWae3FOZ6MLkZj4BiaNYpL4rxdyhr3ezfY6Ny7glydrlV8SFlpStbFhrCZ4N78alOhgEr94iQo5jMQj3zBomTIol536GKje9ediEzzCJl428y2rMcAERBm36VHoCCaUp2kByvx8ecG5y92K5rytrXieRTxT7TbyqmGvQ98f07hrlhCKxJv72KmPr0vIzTKSIKHXoprC6DjjRZVOUKZJODuTnY6sdJhubax6wTuX5r6xH0RvrvIRBGl6pVFKBw99BHEzQcvh2DNTXq2JEAuap1d4K9Dvh0LrXEMlgZg0tHvY5zG51lN3GYmEhlim5gpxjOx7OwXMFwtukqUQWaSVM4lmf3lYvKfZauzs97oTGZyqfxwudN9m6S4T94b0am3Ld8KBR7EJQKuXOgeYh8CbC8Ld9tRVKtLaNN5VaqEhxm5hs0Dsefa9w7TCGGNeVTsU5jX1Ikc7HKeLTOvgDI29vT4S3vNM5RUDvlsm5EoGfkcfZsqXT5CK9WUpClLcyaIDY0f8IDYNvkuCFyFzCbF7H5gPedHUkIwLzcu23RLyyfv9d3yfzUqSquYS75YRCB46LeqkesrIh4FtUWBvwdgZqLikqw5ZOLbqLKgB3DiZcP7l1B1ZpvX4NPGm3PudMbnxrVVdm3tZwmUsLoSrZsQNUhsqtEYDNnK3UWgRpMI4BiMB7aWmdhqjv1H5fVdawTGKlQ1jxeViNqOwRzOcX6dxehyJLJQn7lnZbyYHIEKqqqxwUFigynEAng5mWzkTxB6ZVEIG0eUOSJVP0Z4UbkYK4DifPbYd2jkEeeMRKcBBSU5ihljoLduQfaFqHc5YycTt4c1xjNv6yNUTVdHWfi2eg5QwLpZJBCPQi5OVNk5HrfWlXre5EgoJ06wqbuUfk5OiDxravNt3AcacJR2vSU5bliAiKhVPTwEbun5VLio5QInZItHPcmdB3E"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                IssueRelationType issuerelationtype = createIssueRelationType();
                java.lang.reflect.Field field = issuerelationtype.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(issuerelationtype, null);
                        validateIssueRelationType(contraints, issuerelationtype);
                        failureCount++;
                        break;
                    case 2:
                        issuerelationtype.setRelationName(contraints.getNegativeValue().toString());
                        validateIssueRelationType(contraints, issuerelationtype);
                        failureCount++;
                        break;
                    case 3:
                        issuerelationtype.setRelationDesc(contraints.getNegativeValue().toString());
                        validateIssueRelationType(contraints, issuerelationtype);
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
