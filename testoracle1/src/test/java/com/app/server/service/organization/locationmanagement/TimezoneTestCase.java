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
        timezone.setCities("o1NxvKKdymU1vFse7mHAMAKhi8ZgxOW2VOiUt7LbDf7TwwrWJW");
        timezone.setCountry("TegFru1DxG3aQboP8vxP1CHr5oWEr1GPwUD050yAzZBVsyCZi9");
        timezone.setTimeZoneLabel("Lk9Ijgsav6bFKFLVfxkDUOf7i40pw0Lwn8xyliEuf585i4Qywc");
        timezone.setGmtLabel("6kFGRbcY6qlD0Dwkj0sfc84iWYijWojS710uf1EFLFUL7y4q07");
        timezone.setTimeZoneId("77TQoOjiFNRARBSlK1FWgfbR6AhGIbyAQnkEkSHy9gQp4Tdb0n");
        timezone.setUtcdifference(3);
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
            timezone.setCities("k0HYMydseXRlD3MwEkcjsyOPawm46JvoiWYFjdg8hKEoWe62LT");
            timezone.setCountry("6Il2FNxUHkYpkwJubxt7UJnP41DXnxdPmo9tOiYKeBjVbPUbk6");
            timezone.setTimeZoneLabel("1K2vyq7Acm8AhQQtTBwmyZLqzZ1hAyU0TkP3OsGslFHKrL7AXP");
            timezone.setVersionId(1);
            timezone.setGmtLabel("NEapXtHfll7K5IiHzARkz2RG5IHQtJY1Nhepa0TNiwoY8wi5Zw");
            timezone.setUtcdifference(6);
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "utcdifference", 22));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "gmtLabel", "V1OMUZg2f8ws1lhfzfi8RGxCuZoiUmfDx87COo8OkPaueZr5UdAPYPiFtQOOWwxI0JAq6Oid1eba7xk2Da9jiwWj061Ycv5CTouX0QDSRZXWTzCyBodcteGOoqxslXL9aStFXYpNK5Iw0acPxfhsGoNUcWDB9gqOcQnDZdxI3HPtGUD63WlFbCA0lLRvGKcmgVG8aHeORw8xhiXCaYc5c10vlVJOOq6vFZkBYGFIOTxIdQZRLkoxTBkd0J3KuIVJv"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "timeZoneLabel", "JIRhsFOPRfvVK6BntMExauSvDhWtNlbgLady6bnZ9EXkljLSefh4WUt7OEXwLHykqUz7i7C8AAUjp1GWqXtKL6FD2eL9B2yh42B1DQDVxZ8YfJPTUgzO5dzqNpPt9x7CUAk6dzzH2hmfewAAD7rKOtVmQ5bHb7s8BXd8Gf2KTEaSUcLvbIqKIBNwHAJDvbq7eHsOCHUnF6AkVgfwVv03X0M9GHU9n8uccifyyhNVI0F6nLDsfQdBdrlXcoARnyiPY"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "country", "ESIcMV9qMw7SdiaERS2CvCG87gP1IIX9tM2DVQmV89VojkDMeDDcyKR26AsDFljSA0RfXjEE4OGbV3JojjsNLdU8V8W3dCE8o8LyvblZe6OBnGDzlUn6i9r5JFubLkDsJqKuxkSCV30m08qMeYc1BQunuusDRrUZonDqOYMGjIkjrHGgs5iTM6NIwJ4RybnNcxiGpOooSMib83ykTPkVO9wHPEVPMMNH12ZTrZmvQpjaJ5xXJHRZBWDW7IFOXJK3o"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "cities", "mZk18T4jLpdmyEEVuFWVM6mgveSgV4Ky1OdiJi2eicmioRK5D6TKiVVTmyillNCP12Ig0fMdhTA0aiw5s666sCHUx0Zeu8uPGIBSgZtNwOdyPo5VOMj2CDh5c49u4y3MMiGPYVMtDPgGvHus4lucRVRMMsLIJ64IraV2yGh035t6M1KuFklzdwLnyji27mwWzMiMBOJc1U6NZyFM07oQXWsLEjoSN3E8kL3xH0eGgkli3xI3K0Z2cAjkaOvjEKde3"));
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
