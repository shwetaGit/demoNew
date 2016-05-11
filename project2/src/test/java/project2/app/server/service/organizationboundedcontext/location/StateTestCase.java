package project2.app.server.service.organizationboundedcontext.location;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project2.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project2.app.server.repository.organizationboundedcontext.location.StateRepository;
import project2.app.shared.organizationboundedcontext.location.State;
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
import project2.app.shared.organizationboundedcontext.location.Country;
import project2.app.server.repository.organizationboundedcontext.location.CountryRepository;

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
            country.setCountryFlag("JYjwWjlwdaaAfx6uezSuZcTiyZnmxHnWjTbJdO2dPOg7fWutxD");
            country.setCountryName("GQlhoXYP2w1xUR6tnbENUmMlgYjphZLZIgEXHIFW5syl6c2wq8");
            country.setCountryCode2("Ndb");
            country.setCurrencyCode("meE");
            country.setCapitalLongitude(9);
            country.setCapital("Wjk37Od2SFH9vadTS5KnRbcRHsVDiB6F");
            country.setCountryCode1("2Eo");
            country.setCurrencySymbol("fyRsEOO2iWWm2dRfUwxwho0u1K40E90Y");
            country.setCurrencyName("WFhBH5X6hrZnhHqRe4tz9FN70kGLHBWeyDU7jACNsbNAy3itc7");
            country.setCapitalLatitude(9);
            country.setIsoNumeric(4);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setStateCapitalLatitude(10);
            state.setStateCapitalLongitude(6);
            state.setStateFlag("99NbuCrJikSvgAGAmPbXeyyZhl6kvdTLyEaBceAZWF8fgsZTXy");
            state.setStateCodeChar2("Y2ouZJaIqDeLSmh7bUBdyvMBrusMTTcF");
            state.setStateCodeChar3("1rO3ES5Zext0Ls7hM3qSoZO4n5UIu2ae");
            state.setStateCode(2);
            state.setStateDescription("CcIuuztWyoMbmz6tqss8fCnm0uMA5y0rGBZB5ylpberU8k6Qv5");
            state.setStateCapital("nkPblJ4dSYcYhDRcXNVyiwe5moKIyNxhX9lgyOBZ2px6QHu0Rm");
            state.setStateName("z64mtfzyYZ2OpasUwuBJ5gw9xk9NbLVtkgYNUbjl8GOCpK4FEE");
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
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
            state.setStateCapitalLatitude(5);
            state.setVersionId(1);
            state.setStateCapitalLongitude(10);
            state.setStateFlag("ZwuPU4L4ZcWacAw4BbbP7xQecaZFkLR7UgEIo6KEEu1DW4s24U");
            state.setStateCodeChar2("pqRL03HxNracRvndKM5z6eWOEbGPSgMd");
            state.setStateCodeChar3("0KrV3KDOUECytEU2qMDfFr7WGwkDkxgd");
            state.setStateCode(1);
            state.setStateDescription("4doEqhDbuKVqiGYOMv440huQX6rNWGMpdpeayH0N7lFEf1QCwn");
            state.setStateCapital("0UPWkpD8DaDDHM8MyTaRAFZAqCLAjJn2BJOs4LBGHMPqiIZUlR");
            state.setStateName("m4eUEGVchihAfbf7GQ4QdydtLqYkIIdQ5wTzUfMAQDwaOsB4P8");
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
}
