package com.app.server.service.organization.locationmanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organization.locationmanagement.TimezoneRepository;
import com.app.shared.organization.locationmanagement.Timezone;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.app.server.service.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.springframework.mock.web.MockServletContext;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.server.pluggable.interfaces.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;

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

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        MockServletContext mockServletContext = new MockServletContext("file:src/main/webapp");
        try {
            String _path = mockServletContext.getRealPath("/WEB-INF/conf/");
            LogManagerFactory.createLogManager(_path, AppLoggerConstant.LOGGER_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
        runtimeLogInfoHelper.createRuntimeLogUserInfo("customer", "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
        runtimeLogInfoHelper.setRequestHeaderBean(new RequestHeaderBean(new RuntimeLogUserInfoBean("AAAA", "AAAA", request.getRemoteHost(), 0, 0, 0), "", methodCallStack.getRequestId()));
    }

    private Timezone createTimezone(Boolean isSave) throws Exception {
        Timezone timezone = new Timezone();
        timezone.setCountry("OsMmVB6Mxl6SKh6DnUdu3RPlCFkJPg9hpvkaKjEmFDXhoMziLu");
        timezone.setUtcdifference(3);
        timezone.setGmtLabel("S8cmjGHPx7HF6A1GOQrSPfLHLRSFojnLN9R0p5Zd6QOC0iwL9i");
        timezone.setTimeZoneLabel("pQPfGDNBN0earL7P84Z4QLWUQVhtjU1YduqyJMfBQvT9XiJNUm");
        timezone.setCities("CrD42Xa5dJnpJafnjnlNyhbpaY7MS4MqqfoPSfHdYvpUMrgMG2");
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
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TimezonePrimaryKey"));
            Timezone timezone = timezoneRepository.findById((java.lang.String) map.get("TimezonePrimaryKey"));
            timezone.setCountry("MyFtj45JXxACCTWvDe51nMN1nNjVjdro8I76VutJqEcslodrnQ");
            timezone.setUtcdifference(1);
            timezone.setVersionId(1);
            timezone.setGmtLabel("jIBl4PYYjfiKe967hv3y36W618UI2LKteR03rpfuCimOjDwPvX");
            timezone.setTimeZoneLabel("MuR0UXW5DlOngLNiM5G3oVL8K4I7pdckfJlba6sUTKDoe5DzoW");
            timezone.setCities("VxUU4aqZKA3p2WYf2EqPwP19ML2vcTjVn9E7XbJEDU8yj7qhIW");
            timezone.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            timezoneRepository.update(timezone);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TimezonePrimaryKey"));
            timezoneRepository.findById((java.lang.String) map.get("TimezonePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TimezonePrimaryKey"));
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateTimezone(EntityTestCriteria contraints, Timezone timezone) throws Exception {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "utcdifference", 18));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "gmtLabel", "S7VB9zveweKRF1yxpzqNMPn98SNTalp1A2984ea6VAJTdH6XdovKAcbw3ZoaSUX0UTZ47znZh3Xxio7pUjJt6kSLDFn3TZwRQkaMFFrbeJYsC3r9bNwZyGu6K0KI2rIi7NwZsT4BtafdI4wqegZguNYSRmKGKPKsmskrOWwZCkQgL8ngDIdQJfmOj14mx40nSNQ9zFHLbyGoLL09ZROE2DkuQ0EI6tzGO6Wi2zHgSoPKv0VWC7jdgLUGs99Lq7IbI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "timeZoneLabel", "XIcpRdvCHNw2F3q844bH3J3SPx7ltIocEceqqgMvhQY57jrH2w7weZfR42MEcBM8Tr8MPM1fMaddFhNni1E4WIw9ESsWBjgroHCq5OzPBjeukqArrNmFpcjzwDHfeK6k3LsHmJt3CGxargvyXH0uGtnO0opSqgQeNIYSbTJzwgnKVTpe7V0qCSotDhEmJR1bkpgNm7pQg1s116KJIjS4GNUKW1SLWdtzb7JHcIzcavlEaXCtQ0ognYYlR1Xm96n2w"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "country", "s83v2gjgZ7ej16WUnaQbzcqcwgmPXJXEXVJaFXgidipjRVlGEehEUNgRX170oRAxljNmfuL3aDgvDjIQJLfFDD9kyhKqZmvQ9HW2yX4IJYP5VapkgQkWwKBpgmSCJFZcoSw9XxRY4f7YSCX8ozoPARjO6XNpoaELa9bqYqFEcB1YgIwqgUYTjl5hnD0ew5UlwXNMtgs4pfB6fltakFjkTmFsEQcCdTq6XDmi4UkOP9oIVbMiYG6NFu0O17ecZoIaW"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "cities", "Jyr67G4CiF5Y8HKNr9C9MCSnuUXwLGcKzJoRLoXIfLPMh3Spt9Z2wHsVE1Tay9JShRAuWEV4igzUb3ARUjp2TKfWbC0m1fDa1ixUJNj0i95qOGsu3zWdvX7twBh0toGfT4sCe3XBHDQWeBIYjcytUahZwTaOKG0KOZb7sE8cKkjWrRpaKVKjhtZqJtMIts2VA5xvGPAYCRTkqbTNR3fdmDUhILPKb8s2agW3XQdMWjTvUFJQRSzUAqWB7CSpg8ri3"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Timezone timezone = createTimezone(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = timezone.getClass().getDeclaredField(contraints.getFieldName());
                }
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
