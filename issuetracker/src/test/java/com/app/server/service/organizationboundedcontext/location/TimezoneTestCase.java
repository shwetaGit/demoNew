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

    private Timezone createTimezone() throws SpartanPersistenceException, SpartanConstraintViolationException {
        Timezone timezone = new Timezone();
        timezone.setCities("6g4wjr8i95uGIsUlkae5xdb4yzGZOlCHurB3mxSc7xPz7ADCW4");
        timezone.setGmtLabel("GiF6PEWYnR99EiWFAbiE0Vm3QcJVCnNzZngAvFnqYoRRqZ8lvp");
        timezone.setTimeZoneLabel("7px2hl3fMosj2EnZ5GfIoDAjpYBLUz7ZUr0MtBAiTb7ofY9W9z");
        timezone.setCountry("EoUypUMRWFcJp7LmDpWsKH6x0OmfivJRDenupdrMWeOVaNBEdm");
        timezone.setUtcdifference(8);
        timezone.setEntityValidator(entityValidator);
        return timezone;
    }

    @Test
    public void test1Save() {
        try {
            Timezone timezone = createTimezone();
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
            timezone.setCities("rrGY8NeG07OzIxUvgvA5BalLJhaBg6WTbOqZQ7KBkZDgPYqax5");
            timezone.setGmtLabel("lr68icZPnDDHXvSpMM1246msNgC0CAIXbF96nMmLtFtTLyiTo7");
            timezone.setTimeZoneLabel("oqS0TY0dOlKy99Nt30TIO8tNEp4BQLChtBqYExZPkAnDcnJxLX");
            timezone.setCountry("LhjpDvlXQGRrf9TuvFR9d8Gmg6QMDyGbRbRJxvZIdx3ftR2ERf");
            timezone.setVersionId(1);
            timezone.setUtcdifference(10);
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "utcdifference", 16));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "gmtLabel", "Z7gsipVWjdteqdTZuPkx1ftTTJO8U0YmmoM4n2hj5mocoAVTr4sZmWcgxotOT4BfxeNjDBZbETuqvk3G6GhHY4akuTe4ZWzCxnzfHPd7ywvBW01nBkyrC7OEKOmqj7T6LkSnE1WD4WkfWG7JVadMs1vvK1jXXiY9Fpb567Bm2E5ig9hDCkCUClXFBthZmXKS2wTOUhkBsga62YbNPNIcWad0NuzWrvL7qQSotkiu6413j97nHrX5UzT508bwKdwxr"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "timeZoneLabel", "m2CaTUwGVpzGkeslvPHJE2EL0TxSPPPfuLiQmmfxgrGkOFwiUTxP3FpixJR2bmiGu2AEunyVRWimGQJeG9IH3L5Wpn2pqbDBTBub3m4hq6DMQYkTVtK2BUcbAGIUZbv2BYgxa0uYPMtLF1XG3Rn82UtnjDBGm5BXdgCZm4l7LHSucsbA15jw0r0omwQuj8aqGRAwJCI9TTEiD0UcXfO0XwIzG17Sji15gPeEY6ekrMIm4wgGlJff8R1tM6XNpa9VP"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "country", "qa2BFJD112UOQ2Rle9DFtKiWHyMq5ZqdBU4oqmeAwD1m5AVB7UAHc0quxjTudn4DHbH5mxdpVNigIyETxVVBfU7KSADlHqVNL3xQcfvWGVI3zVeSNVcH5vtfe2kGkWP5TbEZYQ6lnBwQleXQIUVuOAVvmqskiWcvmFVZ7jBGl4x9roRBHRTgB29O2MifUwzbDOAl8aJQ4vO0FSXs9UHG1OTcSEPx1lq7s6UtT6JmccPAsijhh9jJPX7jfk5qFttKV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "cities", "gnbizOA23a43jvYvfP5HZtBRlp4b0iSlXXpsWcWrwpEkD8NlGPGChY5wiI7El5ltBtR9oaUlR1e2n2Q0JuHJncn5kFA4FTEmaFFHW0ZNfuzgFUPmgT302ZNo01WgXwXRmsiQRAMA5Dkne4PIxo6EIB0V49j5QIoRbANK2e5Xv70TmxgCkn9Y26OLT8vEVxuzxSuBkd9K8t7dAgKyttq0whBmMy6UBbIJwVpf1jMdf2zs0Dt4sKWRnI9qH4Ul8sa9a"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Timezone timezone = createTimezone();
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
