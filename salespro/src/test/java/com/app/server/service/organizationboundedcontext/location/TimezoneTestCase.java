package com.app.server.service.organizationboundedcontext.location;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.app.shared.organizationboundedcontext.location.Timezone;
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
public class TimezoneTestCase extends EntityTestCriteria {

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

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

    private Timezone createTimezone(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Timezone timezone = new Timezone();
        timezone.setCities("WNJmVpRVTlBnlAeNl450s39o3aCA1LMmq5l8DpeIGcLrmYJLNy");
        timezone.setTimeZoneLabel("b6y2Xxr1N8aFOE67DLUIO21lePw13wFXKRCbqSlTdQwvBZm209");
        timezone.setUtcdifference(6);
        timezone.setCountry("Cq9r6Pj2npx3LATP9DbuM4L5uNshaIkPPWeFzRp4SEsAW6f7GC");
        timezone.setGmtLabel("RyYhEWP3buDM7AoqQ0sK81ROgfPElqauimtpTLU5aPGJxwhBxD");
        timezone.setEntityValidator(entityValidator);
        return timezone;
    }

    @Test
    public void test1Save() {
        try {
            Timezone timezone = createTimezone(true);
            timezone.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            timezone.isValid();
            timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TimezonePrimaryKey"));
            Timezone timezone = timezoneRepository.findById((java.lang.String) map.get("TimezonePrimaryKey"));
            timezone.setVersionId(1);
            timezone.setCities("Z4BP9XnCcURvgPuhHl2XA6BLjEQsF0v66yvquCO4kpFm0VHEei");
            timezone.setTimeZoneLabel("5DyQXvpe0JTR7pfBuELxvoiiLQtwiw5bibJ0081d7zMpO7OWO7");
            timezone.setUtcdifference(3);
            timezone.setCountry("j6MIGGQMTFSjDIXonTEBnWVtbLMg1s0RZlWcNiXc7o1zswwp9y");
            timezone.setGmtLabel("zvMogYl3lsmktMuCKE3gBHYBJ6pOmwFWrl4al2rX7mEgH65P0e");
            timezone.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            timezoneRepository.update(timezone);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TimezonePrimaryKey"));
            timezoneRepository.findById((java.lang.String) map.get("TimezonePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TimezonePrimaryKey"));
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateTimezone(EntityTestCriteria contraints, Timezone timezone) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            timezone.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            timezone.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            timezone.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            timezoneRepository.save(timezone);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "utcdifference", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "utcdifference", 14));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "gmtLabel", "CtAGpzh7xw9oeRKaDlQUMChYpX8bLhMqHKqXoBDLaEKuAm3ItGSBbFsY4grcR0zzq8vPKDtBB3gF63MDVrCLl2oJ3OdZaoMgE0jVKQIP6tDxSCr9lzcFHSPNPgxM7u0rF1IrLqn4pzmkqRVQg1SKOPpGyajWb1YCV7ZGu7SvI8eUDLfMAslIfO50orfSefxnyBSHQEbmYEHmRYZvApaUULEor6Oy3ZLrkYOB3BXHZIJ6qonoocFF6JeVuOLpsvEGu"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "timeZoneLabel", "78UzHiQUWNO7lHRD6NJPRywGAp2eDMGM3cjcbRhzXWHfp4idevJmB8FhhoUb1nG7yrf66FnvlSUC1vYsfnSZJi5FpkguCpMTnVYEhw64EBqVwaE4SB9pExT9TC0EQmKEvNE9Asrf7YmwKbFCJ2nxUpzUyRguX5ARDcqWqRYQsGIkA7PGBvc2DRXEVtVpl0xiORiuPajRHh4wDGFj5saTfB20Oc7aQXfG3boAHDZwtIbX9GUbc4YH8T3xGbQVj7uY0"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "country", "q24y8qhFgG5xJ0Nn75NkoUdDv060ZrQgacJNZ2BvNCJwD4rFG0yHJrpvw4xhh4DKTtWmMLOyBIRUUf9hKGhY6aRaLHWO3GwdAPQubGlJFATdcA3fbdpJtJRr3089hNp6rQNe3jRZqr2zdRhZ4rJmt2Ye6nkukLiXFdzl28UlgkMOhovBzLsqA1QwStLXB4hlxHxWukuewPpXA0Z2uXxsDhCVg3dXGUy3jczrIpDT37SqgPZiSxk4sWgQRZZWJIm2z"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "cities", "f9ziX1szlEzYZ3qCXmTvhwoBXNc3BEFoN9EwNA6GH2eQ8Gvpk8jNYW3JE0GRhmyl0zCp7kwnSfA0iFuhLj4tH6QqqM2pJF62ngT4pjUxLdDFbcaaVVNp8bCC9q3lWM28LMa1wVSomRMat82hkbaDnpCpmnD5pJV9jHJYW4FfyBmFpxE7FJlcRfZuIE4kqPggaIQIn4VTmcqMg8NF1CmmvnFUnAgtTs5ssHfiXQjgADjUPn0zGzd9VjlDUekM0qrhb"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Timezone timezone = createTimezone(false);
                java.lang.reflect.Field field = timezone.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(timezone, null);
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 2:
                        timezone.setUtcdifference(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 3:
                        timezone.setGmtLabel(contraints.getNegativeValue().toString());
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 4:
                        timezone.setTimeZoneLabel(contraints.getNegativeValue().toString());
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 5:
                        timezone.setCountry(contraints.getNegativeValue().toString());
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 6:
                        timezone.setCities(contraints.getNegativeValue().toString());
                        validateTimezone(contraints, timezone);
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
