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

    private State createState() throws SpartanPersistenceException, SpartanConstraintViolationException {
        Country country = new Country();
        country.setCurrencyName("nHWprYrMElj6A5ZyQ6JssT3QU1yskGw1G7iBZ3Jk4yFqrO6O3I");
        country.setCountryName("nOWkMADsP1bnX3dRELe1iYMcfLQ6H9CsRQab7Gc2OykbRzZ9AO");
        country.setCapitalLongitude(9);
        country.setCapitalLatitude(7);
        country.setCountryCode1("hgK");
        country.setIsoNumeric(8);
        country.setCurrencyCode("7Gi");
        country.setCurrencySymbol("vgKHPI2XBHhoOh145zKGIYujtS0qMlru");
        country.setCountryCode2("vLQ");
        country.setCountryFlag("2dzboNpGm32nxczct8ZsYhn4fj6RiC5jITtmZzC9qWSSpbu9nw");
        country.setCapital("bBzAxAtktct3cpLUIBSnQbYzsAyZredh");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        State state = new State();
        state.setStateName("ex3iI3xqIcTQ1YUAgEFvy2TLXf6u4QI7qajEX3yybcYodXZILL");
        state.setStateCodeChar2("AcIL4TIQ8F8F6yST21gKd4sBt77eiUwM");
        state.setStateCapitalLongitude(10);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateCodeChar3("tbgxEE2EkQ4fl30lz9EIpbgLsBKynKtH");
        state.setStateCapital("FdPAwFN1RxJPuGKN1aYOJIrZtRutGd5tzaOBBIKilPoKZMJ3Lv");
        state.setStateCode(2);
        state.setStateFlag("ejgxAlxMHcPIiZ6c8DNCcuTMghIMnJCtg2g0Nmfdf1fyZgAKgw");
        state.setStateDescription("IUYVWT0lnLR1DYk51eFQt8t5a5NDiJQCoJKfDeehOu1af4lP3S");
        state.setStateCapitalLatitude(6);
        state.setEntityValidator(entityValidator);
        return state;
    }

    @Test
    public void test1Save() {
        try {
            State state = createState();
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
            state.setStateName("9Ac3R2qUsTOHCiHGNlxJSVdIiVxWugjZ1XY2pej1SlFt6kVZj1");
            state.setStateCodeChar2("hPTL6MfBgsvK1qZ2oTa9PsufDTTyJBYF");
            state.setStateCapitalLongitude(6);
            state.setStateCodeChar3("BLBhp3oele4KYpipSxMLTQwxPSqylhQl");
            state.setStateCapital("hfwzObQDzqm5sPTR3eIHs6hQoNhN8jp9gsVzpTPvsk5AkJutw8");
            state.setVersionId(1);
            state.setStateCode(2);
            state.setStateFlag("88q6ABbrMIL0rvygYrNqOWrehOAQcfuvAmeGXp72kM2kdXZePk");
            state.setStateDescription("kxsTqg0IXtBgKZxNUUFDHBCTSssxYAm2Xt5tmZUnS8GdVJ4hRb");
            state.setStateCapitalLatitude(8);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
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
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
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
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "O3aQEleUZV9jlNxKDfBP3zPOiCqXbaDQV0ltCEgCeflgiCYbZ54MFWcM9G5bQz7lhtp26r8lfzlLO1ltM0ERdrDVWYIRSKl6O0w35VOLXTmG1CzdoPsGcG02Xy4pbBHPAjflIjaOGsrEjWUueMHePWX2aFJykTl3URgeFi63p77JpJHMHTMP5TK2kgL6T8dz7OS2cVkxt0LIJNRydzoy1JjUSgfJYl7lp43bkdZsoOylJHNDo4IAZhEHovlLWEPfj"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 4));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "Vg96P2eTd361Re83YFllRig1uwmmHPGZ3"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "zVqmXkEGpRB1y0pTgASJaJGEvmwdpiw6b"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "tIUXUsEjB5GLi2de6ZD8rZZRhSbn0ZCS5Q7HgjAajZIbkZyiDeVviNo34vy95EHTP78XpaLx1vD5tg4zZRi7yyKGPF5z1kHFTox8xqbeX9vacsTBZxNm4YLPKazq1rSfNhFCxdwYrHXo9i8N9gQo7LGhcL5SM5ii60u5R01OJXfWAybfioPs73CnphvqHLOJCaIZ8vb3GwrYEdKfOyUODkZu7Or3nUeDdrQ61qhlUkKdnXqYp395AlkDQuaJN3y0r"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "J7WgaUfDHer6k4MhBrVFDinOuXjdOt9CeKHYyKRBIsrQHAn98CiVV5vpC6UyFs0X0GTUpAGOIMvPvtmNhyQF9i3rm8YytV4w3iQxbOr158jcKUE4WEJdDuiRVgtrFfJvL"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "RskglhizIn97mC3wW60cQc5yJ5z2JCe69tOn2fLrSpcHy7jHfT3waOFhlgvm0LVkGFoVXQ0ZLjGWkeO9TxhPYQVmukmVzrpXrcsjGVXtlN0D2it38mtRcZ3kIFLkKo4vJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 13));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 13));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                State state = createState();
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
