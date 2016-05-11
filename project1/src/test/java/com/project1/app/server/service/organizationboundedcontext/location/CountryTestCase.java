package com.project1.app.server.service.organizationboundedcontext.location;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.project1.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.project1.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.project1.app.shared.organizationboundedcontext.location.Country;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CountryTestCase {

    @Autowired
    private CountryRepository<Country> countryRepository;

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
<<<<<<< HEAD
            country.setCurrencyCode("Eh6");
            country.setCountryCode2("ZgX");
            country.setCountryName("XKLWWjzMrbx99ccmba4w1wvEDb7u2Cokq51eiKRoTCECyAB90T");
            country.setCapitalLatitude(1);
            country.setCurrencyName("vZOqFygV6VYDB5fGTCEzNXwCmscGAplWljQR0MFLBUd3Zr2aZI");
            country.setCountryFlag("BgfJu24ez5zxqH0nJaMxcqR9m4rJHjp8ggZ1PuV2cSIVTGVgea");
            country.setCurrencySymbol("BVlklDnaDzSN6d05xrxFk6KgLfJl1OlS");
            country.setIsoNumeric(1);
            country.setCapitalLongitude(1);
            country.setCountryCode1("tUb");
            country.setCapital("dSragbNxHepTEbUL1rBfUKI78GlChlpY");
            country.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            country.setEntityValidator(entityValidator);
            country.isValid();
            countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CountryPrimaryKey"));
            Country country = countryRepository.findById((java.lang.String) map.get("CountryPrimaryKey"));
            country.setCurrencyCode("1XK");
            country.setCountryCode2("9IA");
            country.setCountryName("0YOidoX0NpYfO6BZS1BpYM5vvkpqRbo6uqwNcg46fw1BVK4R3Q");
            country.setCapitalLatitude(7);
            country.setCurrencyName("kSIkBPmOBCuE3DKCVyoJIXTkWxV7tSelgKnPfDOAosPci1qpBo");
            country.setCountryFlag("RO1uwZyab2XiFhzlQCgNUKYRM8ISmahTOI9OGQIGjEEpCwEvi9");
            country.setCurrencySymbol("WyGlQyi1ME5uNScGkdfjaEgjH6FqHf9X");
            country.setIsoNumeric(3);
            country.setVersionId(1);
            country.setCapitalLongitude(8);
            country.setCountryCode1("kAT");
            country.setCapital("BqB4wRxMIS6d2woXmZYmmgDofDdxLW7r");
=======
            country.setCurrencyCode("cB2");
            country.setCurrencySymbol("JodRsheuwmYlXMPSXpoasHPA9AmRJqRA");
            country.setCapital("fXdAYPOWsvmy0g3u5ejk0Z5xTfJxF20k");
            country.setCurrencyName("uO6dljhT4nXXihU4gAB8QNWo0YamvSDM17GT7zRNcXb8odG651");
            country.setCountryName("RfJVKVB0DpGQmAz8SxvdeybiiSiup2s2lFzLKc2JFgNfTG5eba");
            country.setCountryFlag("liMgtJcyMtHsS34VEeYNnCHE5MghDYVZFwQZrUVOVtgRYHPr6h");
            country.setCapitalLongitude(6);
            country.setCapitalLatitude(6);
            country.setCountryCode1("gkH");
            country.setIsoNumeric(6);
            country.setCountryCode2("Qdz");
            country.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            country.setEntityValidator(entityValidator);
            country.isValid();
            countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CountryPrimaryKey"));
            Country country = countryRepository.findById((java.lang.String) map.get("CountryPrimaryKey"));
            country.setCurrencyCode("MR6");
            country.setCurrencySymbol("AWc3vXLpHWL3w5AME0DUJYqfZc3wkLUO");
            country.setCapital("RlX6YWKkQgeejIav53pV0G9zOJnfA8xp");
            country.setCurrencyName("xv8NS9s9FYtSQ62ylPAwBfp6hr78WR3FknN1IWXELxgRQ9MiGE");
            country.setVersionId(1);
            country.setCountryName("sHdukOpaSWOq7OMhkAwhp1yWoP3RNAI0T6R8AZ2JwGgk30oAUC");
            country.setCountryFlag("ZedPD83yO0KJJnT5Io4GbnhQALvO0dgoNlUzeSYSBf6xgy86Bu");
            country.setCapitalLongitude(5);
            country.setCapitalLatitude(6);
            country.setCountryCode1("pGq");
            country.setIsoNumeric(2);
            country.setCountryCode2("PMZ");
>>>>>>> branch 'master' of https://github.com/applifireAlgo/DefaultRepo.git
            country.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            countryRepository.update(country);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CountryPrimaryKey"));
            countryRepository.findById((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CountryPrimaryKey"));
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
