package com.project1.app.server.service.organizationboundedcontext.location;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.project1.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.project1.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.project1.app.shared.organizationboundedcontext.location.State;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.project1.app.shared.organizationboundedcontext.location.Country;
import com.project1.app.server.repository.organizationboundedcontext.location.CountryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class StateTestCase {

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

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
    }

    @Test
    public void test1Save() {
        try {
            Country country = new Country();
            country.setCurrencyCode("LIl");
            country.setCountryCode2("fky");
            country.setCountryName("kBx4rxCtHbROdGmgE2XzhAk4koBYjQjz0mKEzCjCbwpY0y9L30");
            country.setCapitalLatitude(1);
            country.setCurrencyName("nT7fiIcc9wtI3RrVIJPNqNDh3K9YpVvoXN8aU3PaDEuNCWntbR");
            country.setCountryFlag("1Beu4hWYy0bAT0fCzTCJS38gmlDnEwVSayNF1IxfIuKTQk7ROz");
            country.setCurrencySymbol("NfNcHLtthl0ZM8m5tlL6ETMPHnYjzFnC");
            country.setIsoNumeric(6);
            country.setCapitalLongitude(3);
            country.setCountryCode1("x4V");
            country.setCapital("p8QXQFA5omLBSBrOg10uZO0DEwsyelwb");
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setStateCapitalLongitude(3);
            state.setStateCodeChar3("GeTLUASX34IuUEpGZ4ktyQ3xIQZN5JBU");
            state.setStateFlag("30iDpsFUcS9ijQ6I5hVJ9Kzzh9qcDzgbe4eQEs6U3yZhzs4xMY");
            state.setStateCapital("NoInqiC9rOwvxcLmXxzmeTCMvTK5XSuBmcw0Xw6eySSuOAcIzd");
            state.setStateCode(2);
            state.setStateCodeChar2("1fI6so6vkacbaajSn4qG7SXHllJg0K9z");
            state.setStateDescription("DNw1r8TkXmQm0KpdwcqeXXtth1o1RcTRrXDIwoZObBsckuEBwJ");
            state.setStateCapitalLatitude(7);
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
            state.setStateName("Lps942sHsCFsoKQ9HtvQVYXvsuUCcnhtqBq50WSV3wH3rkg3I5");
            state.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            state.setEntityValidator(entityValidator);
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
            state.setStateCapitalLongitude(11);
            state.setStateCodeChar3("NwTaAM4ybjoqDEhEdH8IJeKolARi1mut");
            state.setStateFlag("s6EV37qRfLbj41Go788IZkwA3yO7S3TokrwGKLGEVdx4Q4qp2c");
            state.setStateCapital("5siYeSqFUm2tzw23itxkfYtZEiGuWhdLBQdo08nR1a1NRQK9V3");
            state.setStateCode(1);
            state.setVersionId(1);
            state.setStateCodeChar2("8j0bu54T0aJ814hodh4T6rTSd14CQZR9");
            state.setStateDescription("vqGkSMZhPbWaAzNLl0LHfvyKysfP5B6gcC1pdYQGkFGUKSlVDU");
            state.setStateCapitalLatitude(1);
            state.setStateName("QU6peREvca6MS33Yoi0DH2vF6WGg7Jr38GILltDQCFtKTxlx14");
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
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
