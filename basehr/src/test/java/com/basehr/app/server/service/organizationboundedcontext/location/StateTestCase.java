package com.basehr.app.server.service.organizationboundedcontext.location;
import com.basehr.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.basehr.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.basehr.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.basehr.app.shared.organizationboundedcontext.location.State;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.basehr.app.server.service.RandomValueGenerator;
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
import com.basehr.app.shared.organizationboundedcontext.location.Country;
import com.basehr.app.server.repository.organizationboundedcontext.location.CountryRepository;

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

    private State createState(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCurrencySymbol("LmxJsCnvktOEHXJa01QFloU7Y4s34FN3");
        country.setIsoNumeric(777);
        country.setCountryCode1("2K2");
        country.setCapital("cq3VAdpMTq1tU489IOjKif1VruVR5N75");
        country.setCountryName("1nVC8JZVSN1g9ycDAVMjsqNBjqP3WZR0hJMKoaYT83g52YP3qO");
        country.setCountryFlag("iTcLmAz9wLB0IknEDTHYTS9kaw04Q9Kh2NirTSCHD8disQ7LAC");
        country.setCurrencyCode("fgj");
        country.setCapitalLongitude(6);
        country.setCountryCode2("o8o");
        country.setCapitalLatitude(5);
        country.setCurrencyName("EU94FgMS4E5JYFGl6avF7yZiceEqRktoJKFadC4iqKsjT48C29");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateCapitalLatitude(2);
        state.setStateCodeChar2("p1f4juScVQobiKzqFaDbwb3oCRdOhf3z");
        state.setStateCode(2);
        state.setStateCapitalLongitude(8);
        state.setStateName("F5w2twWzpgmYfV0aRXijm6xvawxDfv2tqbQSN6D9jG0Zijpr3P");
        state.setStateFlag("jOwJl95ofv08pcMXBfXfebDRAq75Vpuo15WAexC396Yhzhr9kf");
        state.setStateCodeChar3("Zxrao5qVciYaqA7rs0GkIvqmh3BmPVxS");
        state.setStateCapital("PuMk6CP7pGtAUZQG39e9u6OShrHAG5EHQq6ucsSvK6PX1SxCSc");
        state.setStateDescription("uid4cbmKwE3GuYhJT5y8f45TUt2nQvn3Ntavy2tcAqWu8luiuF");
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
            state.setStateCapitalLatitude(11);
            state.setStateCodeChar2("jKiwgkoqDMirrEzCuqakVe7fTlQf8hUU");
            state.setStateCode(2);
            state.setStateCapitalLongitude(10);
            state.setStateName("atwvfIWQeH3faLo8eJzWifAU7z0yVJt786tdghhZOoTDINWrQI");
            state.setStateFlag("T3ZWoRcix4j1smgAgS3QTTxVla0acjhTjpjc2J5Px6gahxz6LV");
            state.setStateCodeChar3("jjTW9H4uq9Kj3qcXMQobiQkGXVxz8wi1");
            state.setStateCapital("sUT7YEcpdPwfju0K5rYiUFTY6Wrty1c11ln2YyPzXvSHFrZOYD");
            state.setStateDescription("v2vEbXsuZbwRRlRWvXs3mk0bHxIRxbzlq1MnYRpErmOIqpS2PB");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "un5fa2kkp6pL10K3OwAoZLMMBgBTjPZZE9CB7g2VLM6PusvdkUmxiwRO322if25J558Cv5fhFmA7p611NnC2jzAx9G1FYiZ63dWm6RRGc4RdekPP2h1JEpwz1QAL85zTj9At7uJvxglEd6yOqFJUSJgP6AWape01RfQvE5wpFm3uoUWBeq8jPUI4mO4ezxGX6RhdMSxQ9Uw1EUxx9elT5PKBi33jNTWv28tbvAUwXZk5d5IloyqrEA1LaEi8QinPu"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 4));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "ggOlQRmnT3vOJCDuOiHTcU4Pp9PksJyth"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "3mNLJe2e6MjhFxnKGDssN6Ivoq8sMBWIP"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "7zSDigOUx0EqKU5YJgVlyO18SLsFl0g6i4jxKtrh8XDurzLCxgu7ZmJdz90r1INWvrHBssd7iNZrpBHSemppwBABzvtMnZUUqsBSCRTcge6rbmozB2bxqijzXlAr6KNMNjTN1dbr0n19352Scy6AnVePt8tZp2JLr2Am6tB3cTbG4LBdvaUxnKpZF2uWaNeZCTAAJ2LYVM9wb9AUg41MV8O98U1Wq0xIemScNbPYwOwsAcRmxqHZFZhVsuNaGvfv0"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "D8SkPW44BWXuFYhlwVLHJTznUNr6ToFCqeGxDkvAk0JylvbUoZDnT87bYth4iwMc95X9eRhbWpsQjWHgXoIc36KB05ZDXRkwbHs4Lt2YUEbXmVGE8ZADuJzriQu3IxKHV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "JZF1ak1bS3k9lEcrmHdBnl3wQou05O4zpxhLVK0jcmhLw1i72OgFTHAhYfY5LRNuQ7p46JeI6L7HSSNThYr1tOEBbilcTPcAF7ePUtno3DzmndtPc2xiDGPDfeaMZCBvO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 16));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 16));
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
