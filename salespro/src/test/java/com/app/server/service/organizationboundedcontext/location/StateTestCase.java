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
        country.setCapitalLatitude(1);
        country.setCurrencySymbol("BiK83RR9ZFyyUXzOJkeqS9HNjuQ5ZjcR");
        country.setCapitalLongitude(9);
        country.setCapital("SGAkigNgaTmaFnwvqb0DCJkzHBypJkuL");
        country.setCountryCode1("Xol");
        country.setIsoNumeric(94);
        country.setCountryFlag("ucOwYySITED69ju8IYW8XewNslXL7XbIxngksmZr7op23Xdo9t");
        country.setCountryName("K7YGjarGslOn0MJVcfy43sxvprMVJOQkshvxlwoF7BADueGmU5");
        country.setCountryCode2("BtM");
        country.setCurrencyCode("Djf");
        country.setCurrencyName("ALfELh13feumn4dmHbWV9n0uekUd3RPnqktwwp8ySJAwKHIR8U");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
        }
        map.put("CountryPrimaryKey", country._getPrimarykey());
        State state = new State();
        state.setStateCodeChar2("nkR25GZWIkupIIX5SYO36Xl4In7tVRBh");
        state.setStateCapitalLongitude(11);
        state.setStateCodeChar3("QSDU6JbIduJYGaVYUOKsFcHyxgRDwJDF");
        state.setStateDescription("TaodwPLQnF7I2JOAGrYGZw2nPiauL0gHsSwxoSHBREmq5bvxa2");
        state.setStateFlag("TEdNbzexe0OA7yjuix5OGTbMouJgxRF8ZZeJ3y8HlLxUYidToJ");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateCapitalLatitude(4);
        state.setStateName("rm6cba5mqZLNn0JxG9wxeMvMt0Ic3tYyu1qa0krAca16dIdBpg");
        state.setStateCapital("0cbRo27isgZ4p6W6XnzAMgOOGIKlUM36zZr3Utq8h6e2WSjdqz");
        state.setStateCode(1);
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
            state.setVersionId(1);
            state.setStateCodeChar2("2mB1zwiRYhDWEfbzGV5OSrfeA8qi2C09");
            state.setStateCapitalLongitude(8);
            state.setStateCodeChar3("Jfudy2Naz5fR3TvbigNzs2X7XGsywT3D");
            state.setStateDescription("cwVNCKwq5Qy4kJoCogdpGbSxJ8ImMw2HA3jBufomK4CrUYbbQ7");
            state.setStateFlag("ZJ9UITUesxfE8wf9ykwaevzPnZbu0PieVn6qkflYO5L8h83sIb");
            state.setStateCapitalLatitude(5);
            state.setStateName("P4V1a4LSX8G9I37ZISPySoRxXJ84O8keSlVI6sRx3TPAirhn4o");
            state.setStateCapital("VVhbsSwdClmGq7cHAtOfP49JktyQwjUjd94pUWbCcaCPmg46Hb");
            state.setStateCode(2);
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "lz3zsQkheGHvHaCDFE1fN0EQG54LjCQblWwWGVpcrIedIljmbHDH2Ads8uJF2fvnfV6f21V3j5vRc80pcKqmx9A1Ihg9fuWQft42Fmwi0zen6g4z6jAGd4bEMYyLrnaUZYMTrd8cnGZsag45JAMPnJneoVhYjXwALuKYPX5rvHVRdksCt98V6OXWszglRD70m0N5GST0ycd0czTXoGOgqT1PFzg0iJTHOmae962uz6coowTxzzNoqoaBnvVWuyb8M"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 4));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "muDJai8OvyNO51H0EPzRf7dKBDpzoWicH"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "KYs1d1mR5gkgwBF9HyulgPNVoIKxKQ2Wv"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "st1RIXTbzbMPcb6ZHipy4swo1ATUZZd0LZAc807fHD6lUJR1zIDcirlkPxgno2Ybe1DhwUcKIqkmL7lIUbnle8mzKiSha1YmWQRUbDPXI0D9A60gjJuDa1jxucwLMH0gNljrKVyoFv4SjYitMnVqCy1TJ8XG2kWbmhbZ8JbN1wdEkTQPhQdkXJVQ1D7U5zM488DBfxIkm9siW25ME6agblppq2YQtiLL5xCZuvalEpOYW3d9D2wsEEbmeja5VExeJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "ZT0DNGPX7S9L5mfSG2SDG1H5lp49MuCoMxB19Cvhj22oTRAdw3N3nccIJJCqyzNwB4r4tuRjcu0AQ2ycSBUShTiD8xTaCHVRYM1BXQJNit1id1J3goWmLCBBdop2FiiXy"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "sBlmpjOrm0G6BVSh38OHV3qLwJWf2h8DVpbI05eVlW4Uj75HHcafxTaWJ8bct6oJ74PN5iisZB1hXJizsyKrppMNLv0AeNydyl5tDA2flwbrRRx8DXF9D9az8kyrGpwpV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 15));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 17));
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
