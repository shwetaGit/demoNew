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
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.locationmanagement.State;
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
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class StateTestCase extends EntityTestCriteria {

    @Autowired
    private StateRepository<State> stateRepository;

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

    private State createState(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCurrencyCode("a3D");
        country.setCapitalLatitude(4);
        country.setCountryName("YcHPWBoMsQD77OWqcLPDXsNTitgPFnREFIzBAk4iMVHJsEdIOV");
        country.setCountryCode1("Qll");
        country.setCurrencyName("ge1Sp5kGvXjpuuk3OHcUtGHu3bcbfnTRyCGgc7UQstZN3eb8r1");
        country.setCapital("v9Bw785L4fMJmtV208XFmIgQUhcZ92dx");
        country.setCurrencySymbol("JJI2I9KHs2cBQvGoPen6Fa2NMjcJKAWG");
        country.setIsoNumeric(581);
        country.setCapitalLongitude(1);
        country.setCountryFlag("Blgt7GFWEmCyjmheYop4uGGeePaJ96xdnmothMCeNxXqwrZbfa");
        country.setCountryCode2("Q5n");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateName("3pDQourblARtk76xlHfXXIbBhlfwWIOoMUqKyrCMlWfe3JF3UO");
        state.setStateDescription("o0AQygJBP4qkwQIayyZU8fHsZGbFFfGXXLAbi3O7CR4FHMI5we");
        state.setStateCodeChar2("RKsPNHLPc17wcF9AYe0N5d7tilD5i8IB");
        state.setStateCapital("Ksz3iWRnOdD9OenfQxYBi57DUZJZ8rM8vqrurrzUzAz5n60K7q");
        state.setStateCodeChar3("82j0T7IvUfbw5DMHHIj7txsB45xfbQxN");
        state.setStateCapitalLongitude(1);
        state.setStateFlag("nMxKy5AE6iUT88AOVlsSfPkYppHZJvflMYm5Lib2ssQM0NOMLg");
        state.setStateCode(1);
        state.setStateCapitalLatitude(11);
        state.setEntityValidator(entityValidator);
        return state;
    }

    @Test
    public void test1Save() {
        try {
            State state = createState(true);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            state.isValid();
            stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            State state = stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
            state.setStateName("qgUiJzGt4rYvD2fVwD5izf7elIaiIeoYEMmKscRovRyZckKV2F");
            state.setStateDescription("qbhW57C7rYPTlazCdxDK82fF3Z9rwBkdL1pzWOqjrmof5NRTGZ");
            state.setStateCodeChar2("EG1fofnG6JsEX79cg0NnMMlqvv2fIcNf");
            state.setStateCapital("iyQbTDQuV3a9Q1hpEgZ7qYDCk0uxf2uuDmybCVY76pVIC5Ep6s");
            state.setStateCodeChar3("4nYO5cFjxf1cFTekO4sL4tDIQVCeBmPG");
            state.setStateCapitalLongitude(4);
            state.setStateFlag("35LU5UMpZktwmO5vyPg6OE8jJmBB7yJK7948wb9Qu7t3decCyI");
            state.setStateCode(1);
            state.setStateCapitalLatitude(9);
            state.setVersionId(1);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<State> listofcountryId = stateRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateState(EntityTestCriteria contraints, State state) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            state.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            state.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            state.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            stateRepository.save(state);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "stateName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "HU4J9V0eY8HPQhy4eKdheXXSCp3ExLCOfB5p7l0NOE0JkbuyAmqGg9agW2o4Mm4wdCTYtu4187EjdLizPycJSR80TqC4NM28s0OXFWKL1I6eQOZzoKTgIAoRI7BbW1RxJLofAylWEVqhW09kVxLdnniFFI4JDeoqSkZ5QJYnaNOarg7amv1LLMkRGnUeTCXHxvpb05Vg8VXBRHEK40pI98vSyydEedsZzlGBoIQOA3m6CcItntKIRAMmS5m7Pwe1x"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 4));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "CMXZDqkFHXA5AfBy0WCKaCm9GbIImu10b"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "VYbeC6fwMGQnKZvXpgefzbMg4OqSRet5R"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "t4io5meG5guwlHKuQXpPzArc4xHRLag8R2C3Ant9H5f38Sn6PH7DTkzfeCecfLm36xYL2WBHUyAbVDyZdQxGOAUU6ExlWLqG9rJZjhktm1JNOpJJ0SHC7ZcWanjlFvWW3GyyltQ00yEkmDXZZlmBK1Bl7YOuTSeHueoe1P86QRSkCmiRsngxJLEx6s4gOcqfMRqhOOQDOEjoLFukr2Q6SvJWYbP03K6hzrTeTBhdTRYFMxFyiyOuoWGXX56lCGovJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "8qWfvSL5MOR1TbdDcs4dsWMBhhqkykgBfTbgBOy2JQV4WXkDEb55OMFu2kbINholSbWPv9GciDrM73SXnDVvgIkBWhcr5tZES9vnUFMGdpD6Db9xPH0Y1dzWLq4q6wcSL"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "3re6gOqLpPrUVNfRfClw7eFJq85D2etEIJzCGuoEchkZBVfluDrSY8vhtOPh5POPKff5Hjn515NOc3xeH7eYrB85sw25YFvVDYOzPfnSnkpGMfUnixmLobkEIgNsB9gbO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 19));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 12));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                State state = createState(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = state.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 2:
                        state.setStateName(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 3:
                        state.setStateCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 5:
                        state.setStateCodeChar2(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 6:
                        state.setStateCodeChar3(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 7:
                        state.setStateDescription(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 8:
                        state.setStateFlag(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 9:
                        state.setStateCapital(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 10:
                        state.setStateCapitalLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 11:
                        state.setStateCapitalLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
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
