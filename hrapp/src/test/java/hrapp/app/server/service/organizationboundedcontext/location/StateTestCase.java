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
import hrapp.app.server.repository.organizationboundedcontext.location.StateRepository;
import hrapp.app.shared.organizationboundedcontext.location.State;
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
        country.setCapital("BYFWsxagEUtIR4C06tdEruxpdKTgF9sE");
        country.setCountryCode2("n2s");
        country.setCurrencyCode("LVA");
        country.setIsoNumeric(472);
        country.setCountryFlag("seehkFdRYsnU8wivojXFMnpBVNIJSWz3mfViVaMmTf7muqPajR");
        country.setCountryName("MRcTHgeUSvziNv4IzkYcX1A5wjGDAuXu79ccJqxoBTAV0xmEZw");
        country.setCapitalLatitude(9);
        country.setCurrencySymbol("KdeSrA4WF8xoeQ3qHMmmpNZCR6u994iK");
        country.setCapitalLongitude(8);
        country.setCurrencyName("fO7sPUL2WTztJAo1QuKMr78MdX9YV3G6yKilnBCyItpeAz226O");
        country.setCountryCode1("TWl");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateName("BO97dS89nC82wFC9Wgdq8x537gblk49siHGbi6Juj3fMIEhkVN");
        state.setStateCapital("Yaijr0EDRU8Ln5RvfjkaxzD8LSxJ99voub3KIp5t8PCyckNgK1");
        state.setStateDescription("j4YHU1uOHzhZErDpB9by1zmCSBxohwZtjjUk8Qaca9NbrAe4tL");
        state.setStateCodeChar3("obxztKAQtFeFblgQR1SNgGs3pCIZlfb9");
        state.setStateCodeChar2("YsyvK3q0MQt8XWQ4wFkQja9yPJm6jMAt");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateCode(2);
        state.setStateCapitalLatitude(3);
        state.setStateFlag("fCEixTXdxSZBLAzXmfBCHfEky6C847o3c0HPdbGMJYCdZANtnF");
        state.setStateCapitalLongitude(8);
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
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
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
            state.setStateName("R1pBg14c8bm0qDS6kc3QHMkMgeSQ15JRaSbQ6qR7OTXezrxnbG");
            state.setVersionId(1);
            state.setStateCapital("TKFAPwi3QwZH3XRm1QuR08sEhycvvMmCuLubbY8HiorRXKOSdk");
            state.setStateDescription("lyalDhfK917ZbPH809oqTfMfkHsdLgisT3IrPickA9mEwCA4X8");
            state.setStateCodeChar3("Tv4Aq0PZRaKnMIxCbyk6z9NBiW6woH7K");
            state.setStateCodeChar2("QrXByFd9FhisFjjRZgmYRZ0mDcmUQDJp");
            state.setStateCode(2);
            state.setStateCapitalLatitude(9);
            state.setStateFlag("z9l3ZDewFrAwzpjmfIZag4i9iGaV0mN5uYRLVq3RQhfRABbj1n");
            state.setStateCapitalLongitude(4);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
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
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
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
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "LjB8tKDJZ2JztIfqf6545qVHvMpcJupgqZSVr8yTZLTRs1d0gmAyy8mDPVqsEXjVexxL3XwtDrd8Ur2FL0d60tKi0XTrRrzanECC9Dbo6MM0gwNRYEHxNHUFEF6fkyeRThu3ctQSPLz60pXisFUzbdnGqKzbh5cEGrhHaH1mfeeKYSkzuDtQ33qUVb7EMGa53zkXTiV880UcLm5xZv8dtmv6TeSmDs9HmYee88lKD9N95BbwZWZN4eTWJvkjjDPOj"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 4));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "y6fBB1LQypSCULBgLkqyDPQmJ3Ls4zTf3"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "pSSV8MUhQvmxi2oKMClp3rp4tlbEclb4j"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "oFuHe8RWGpmzZYNhwgc6qYGt4C7loN7b3kyLVczKuifr8yPH6vMCHNcFKXND9kMRraVhVLgOvOkM72XexMCOt6qUA5KZwJglxyUkHwLQWJft4VailB6UfQJFe4oedHtO5NdloelQ25AJa4reixbzd3RFOKRmYdeKIyZYR35ItMRMoEUGFqv0jD0HJ3T61DesyyyK60Phd0MDjQZfVGIv0DTPJfHpCTozDIcUVAkPwGJAnmRo2c9rH4O8lHw8kwZ1h"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "5woNXwm70yTk2D4gUuro1P0v8wSYJ2Sw3O1je2wCYeVXNomcwA6aYXlzAcFDRi3BO9B5oe3ZrLvE88iuB8XSwDIMDt4VjaEdzqV3vV3Kj09agUjuNQm4UG7J5zCybzZFI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "RhKKRf9Xrt2yp596YSaExL2qjWtGsgtpEtXQ75kJ3vaES8ILIS9LuVnXV7kdmB4r18I5ZVw1i8Pd1hVg05C0mnpFfrAYI6B0KSy0CTRx2PfmwXitemTuHxKhJz405Nz0t"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 15));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 18));
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
