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
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.State;
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
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

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

    private State createState(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Country country = new Country();
        country.setCurrencySymbol("jzEd57yPURZtMH7He5jgJ6Pf9REqKrn7");
        country.setCurrencyName("SSdgPqU4cJv2IZYh7OinNz3A3DbMDsDRjlQZYam8g56UFPQQfZ");
        country.setCapitalLongitude(2);
        country.setCountryCode1("dEu");
        country.setCapitalLatitude(11);
        country.setIsoNumeric(9);
        country.setCountryCode2("zpd");
        country.setCountryFlag("3xObebXQTRsKnDUcWOcZEZjqgjqVn5GtSrV3WO0ciLgcQwfnig");
        country.setCountryName("hK3DBhVLntCfOIe5pMZZcRTAlxxkQ1TGc9cfqIUZhk93ckbAQT");
        country.setCapital("lG3DBt6HfXZttFTBxl4ASQRZP7rgDFZM");
        country.setCurrencyCode("RLS");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
        }
        map.put("CountryPrimaryKey", country._getPrimarykey());
        State state = new State();
        state.setStateCapitalLatitude(4);
        state.setStateCodeChar3("iZCcD3nxe88QRqvKIljkJbIiNLIgSE69");
        state.setStateDescription("NliSOvApJ1zK6RAtpzsYYT86CtSqxgVanci8S0199tYu60Wb0J");
        state.setStateCode(2);
        state.setStateCodeChar2("etK0T8jPeIYmnMcVex8k2Ay3PxaNXCfQ");
        state.setStateName("Q0vMQfKbvJR9bkpEZMYDgJTq6tuGYRJiIyHQnWA39tP96D5bnw");
        state.setStateCapital("xqE2NrCQjlxTVe8t7kDlV4ghvolzeHISrHaOOcB7WPPwAIkBnl");
        state.setStateFlag("lorLU7E4nqzUnH8LV0v65SoAcXvPiPpRaBHZrbxqedF8b13JBa");
        state.setStateCapitalLongitude(6);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
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
            state.setStateCapitalLatitude(1);
            state.setStateCodeChar3("3QhHbE7s8mCAdvRe2s0D4azClMXVvblS");
            state.setStateDescription("6thBpiuqQagLWmpOmoestDhslgszdzdBYlQIH8QPVLeMLYgz60");
            state.setStateCode(2);
            state.setStateCodeChar2("qmRQhrDp7QeYt9vLhux2N88XT3R01yBy");
            state.setStateName("J8DjfgwmxqCQWP5HjEJGr6gm2vuYWHcM4QPc5iWcTiWfXlcYHW");
            state.setVersionId(1);
            state.setStateCapital("VjkbRoQgasuxr96lvBzyl4vKXAap6X4bTbYGUxdQNPt6iGFScL");
            state.setStateFlag("LL2njwWByOEoPwOOEAG1qHVHWGKq3p2JG6GP2megdYLWytxCXK");
            state.setStateCapitalLongitude(6);
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
    public void test4Delete() {
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

    private void validateState(EntityTestCriteria contraints, State state) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "jgpRcSv2CzRsLjwvLyzbpfT6f6sIxIZ9RSrn8JDzjGGMql4RyaTDxfT4qKfgjiJBvog5y84pxcxaU3y1fRZZwyJtCTuXCsl50x3LSNW7W37q9lb6eMFWiKq8LEd9Ed9baDV1Cj3m3cwRn6xvXm3fC8qtdb7etDUrHVJVfeNddMW9RE9k4T0XW4pRnBha6SCtWbxBWIGNmQSj9egIhoFgXc3sJxEl85G3UYt2RUqja8rXVoSs4BFdFPSiIC5PPGM0W"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 4));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "xGQ6wR79Jo4OMFpNPSGGv9prupl13WUOD"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "jrLAZIDWN19ThEonhN1yO38KvBxRmg6ib"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "lZ2SiQZv26vgMgqyPODS3a9c5nsCDNzDAZAxhJnvvLCIFXj1YcuzL9dz6xkIuortR5BYRBsCfvIL4GU135NnAlPLegAMMeWpwBOIkiDemUpOI6jcX1clNKUbihcRjNVolKtXiKtRitQ27JRcyJAhfUSxE0IBmlnTS8cQ2XHQLpY5WF10UCTgadGmZvhJ6bZvbvvZ7fAEX3xyPhY1mst8fgDgmBV7OLPaRtMFHoSqyW3gZqF2MJ5IcA7kb2UBB2nJi"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "8gvOJPLsXKLaSw4SY1ah8FwVTQWFBGx2E6xL8gF6TQAsWEdorYSmK2hPgVqpAu7lls7mscS8dIrIPGFsZC206YqbTa8QONNNFI3woULIe7uyHGhKP5wtf8YzleXFrFfFA"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "WNsQxLyAGfp6iVbKVSy3LWiHRFXsxy9SE143NN8k3qLpNJtT0gFXJJSJP26pGYrn17FyV1jKMXn9vaAHzemYLCPbOkDBpJfabzXZ4iXsFe0gA6cJlsAG0UP8w3XfkLzng"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 22));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 21));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                State state = createState(false);
                java.lang.reflect.Field field = state.getClass().getDeclaredField(contraints.getFieldName());
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
