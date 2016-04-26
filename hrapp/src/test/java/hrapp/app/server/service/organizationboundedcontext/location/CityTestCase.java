package hrapp.app.server.service.organizationboundedcontext.location;
import hrapp.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import hrapp.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import hrapp.app.server.repository.organizationboundedcontext.location.CityRepository;
import hrapp.app.shared.organizationboundedcontext.location.City;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import hrapp.app.server.service.RandomValueGenerator;
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
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import hrapp.app.shared.organizationboundedcontext.location.Country;
import hrapp.app.server.repository.organizationboundedcontext.location.CountryRepository;
import hrapp.app.shared.organizationboundedcontext.location.State;
import hrapp.app.server.repository.organizationboundedcontext.location.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CityTestCase extends EntityTestCriteria {

    @Autowired
    private CityRepository<City> cityRepository;

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
            String logManagerId = LogManagerFactory.createMultiLogManager(_path + "/");
            LogManager Log = LogManagerFactory.getInstance(logManagerId);
            System.setProperty("LOGGER_ID", logManagerId);
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

    private City createCity(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCapital("HimYb0nJMAh3TIuiOdy2Ta3lKdM4hRMN");
        country.setCountryCode2("7uE");
        country.setCurrencyCode("dFc");
        country.setIsoNumeric(374);
        country.setCountryFlag("hZ4P5CAVEsBdHf7yPu4DnByqp0Z5SQiBczlLZcYrUjcBfaejvv");
        country.setCountryName("kngerEtmEgvwCnTpbii8ABxnEXwokdh2mbo0Dc47aZ8TtVqxX5");
        country.setCapitalLatitude(4);
        country.setCurrencySymbol("F1utpORP0IIYwAdGqpu4UqsN5qhi5fEj");
        country.setCapitalLongitude(9);
        country.setCurrencyName("iAFFcWe6r96zQarfdQu23532rDyWqVCIREFshTkVbcFKN4a3BZ");
        country.setCountryCode1("ZjA");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateName("BzHus44vdOqK7nLjOAjkHL9qQcCX9DBUh2UyPJD9NURiAQ6oKd");
        state.setStateCapital("LWUX49st3B6WCWmDoC2nYcAAh3gLu4HWbJ1pl9mA5FXn1qBnsl");
        state.setStateDescription("lUMJJuPuVz9ZgSEJYuqTs1Hdd46eXARfnnUz0ziZGDazH9l70h");
        state.setStateCodeChar3("LioLQty5Rn1gvOeJSqI9RqJEOOGQ65Bs");
        state.setStateCodeChar2("zE1yuw9S5m83CFKHd0PDd6KuXnS9FOX0");
        state.setStateName("QK3eTGwlYHblzCdLKs1UzLW6wkF590MgADQtsVeZ5XFluJhKtd");
        state.setStateCapital("nVRh7BLjRuxNK5PLlHT9JIrTycRQSo0sLh3hqlshb1NqZsSbbW");
        state.setStateDescription("KLNNGClU5lQ5sor2VxtltTiRBptH9gHve5SjbpwiRfb5WpcTLt");
        state.setStateCodeChar3("4F88FeFocdtVlgUlKkOI6Oz5J8621Kle");
        state.setStateCodeChar2("7pvGDeG9Z5WsOdwQZnzVfRNWRzCgILp2");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCode(1);
        state.setStateCapitalLatitude(11);
        state.setStateFlag("U7ROtUNZai7mTiaubqUbwf1aVsNP5rap7FP5kQKMShJS75FqO4");
        state.setStateCapitalLongitude(8);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityName("1nzBx1Onwy9qNVATLuae1ileeTcjsR5SOzUZ2cadLysY7XVV6x");
        city.setCityLatitude(6);
        city.setCityCodeChar2("Dmae9d5t7CYuyjiYCntOvCzs9tTrANRG");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCode(1);
        city.setCityFlag("wfuNfkLLO5ckIKOy9geWo3l8DEK5xz8rJh4V4v8thgTuD8np4L");
        city.setCityDescription("rsKx3ZAjouySLKjyPCb4jCiJTdouU7KRfxfepb5Q4Y87yi0Dex");
        city.setStateId((java.lang.String) StateTest._getPrimarykey());
        city.setCityLongitude(11);
        city.setEntityValidator(entityValidator);
        return city;
    }

    @Test
    public void test1Save() {
        try {
            City city = createCity(true);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            city.isValid();
            cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            City city = cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
            city.setCityName("9bZ5EpAaG8ZdQygiaDgWXa3EcqWVFiK7K84i5JgWM8KZT7uOm9");
            city.setCityLatitude(2);
            city.setCityCodeChar2("Ocbo0OPfoyng6bkHCLEgSxFVkc0ALWnk");
            city.setVersionId(1);
            city.setCityCode(3);
            city.setCityFlag("SwvifEo9AK0GVNwqdfico5NwWu88CBgcJAjSVbBDPtt2PhVbbe");
            city.setCityDescription("rxvdHuKKXvbgnuzynrpojYGP79TPV3W7xOmlW1Xk3PvEhbXtLF");
            city.setCityLongitude(3);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cityRepository.update(city);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<City> listofcountryId = cityRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<City> listofstateId = cityRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCity(EntityTestCriteria contraints, City city) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            city.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            city.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            city.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            cityRepository.save(city);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "cityName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "cityName", "txHbm1lj5yOvsW5FHj5qX3mgUrP5b90EaDi9ELcFGTDSy5lWWH60p2rIZKbNWC7x3iGKfZjbSWQNw6ieH2XhTRnoZOAqChEWAaRHhzVXUBwMaLWRM60KgIKNGAgvA5lt3H1be9mEQacgZ3D5NWOopo4RvbW83G6YAPIqdaXWOoIyOmyxS6op9WSmjJMY6TWGhJyIKOxbWI3EikcnFuJkLifWSNpgQkq3Procu1ldua19PDDTk7maaNpFaS806mkXd"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "cityCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "cityCodeChar2", "Yyst5fPOeWK0RdAklraPUqQF3BX3VtZ1h"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "cityCode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "cityCode", 6));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "cityDescription", "TEoShpWRZH2N3GsV2tLXAu3tZUoml5GQy8vGRDOv1nW7LZCbHjtZcSLXmpys48WEl9rBfggnnVKBaAbnPinSJge9kVjR9G6dHQHec8V6lfyFahfLxnAZpoYYK7mjkNSRS"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "cityFlag", "k8XGXBq14v53OFwE9KzEmS7zBVVwNZvwvRS0gRgRLinC7h2WpMpSbvKsWjULgzg76RY655zb4Q2rheaHM4vSWF7dVKuRNkOXS5FikAiVmeo1wOj7s9CtY3VkPbADA8JuW"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "cityLatitude", 14));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "cityLongitude", 18));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                City city = createCity(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = city.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 2:
                        city.setCityName(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 4:
                        city.setCityCodeChar2(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 6:
                        city.setCityCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 7:
                        city.setCityDescription(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 8:
                        city.setCityFlag(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 9:
                        city.setCityLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 10:
                        city.setCityLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
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
