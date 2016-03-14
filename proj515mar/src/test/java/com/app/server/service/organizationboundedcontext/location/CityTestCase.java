package com.app.server.service.organizationboundedcontext.location;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.City;
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
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CityTestCase {

    @Autowired
    private CityRepository<City> cityRepository;

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
            country.setCountryCode1("vyN");
            country.setCountryCode2("huY");
            country.setCurrencyName("33hKq4BXDoHrshDjvK7DMWRiaUsuVnUJ8jNyhZKDHe9qclM4lb");
            country.setCapital("0sokLTYIBZ7WdlYGL4cQxnRGrETdJ0G2");
            country.setCapitalLongitude(11);
            country.setCountryName("cBI9qSw0rikNwMTbrhZHpynRmgFjAZ73FrEmfQRAvZPfrHypnL");
            country.setIsoNumeric(7);
            country.setCurrencyCode("H9D");
            country.setCurrencySymbol("ejcwMQ8Fu60BuIf33gAJt8efCQy9i5F1");
            country.setCapitalLatitude(5);
            country.setCountryFlag("ctOwCufrPTQr18hYxFz04tdZypgNOFhp68LEZKy0QZVoscfnmw");
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setStateCapital("1ZaM6XHeiOac8V9sr9pDWzFuzpe91DpWXOesefMev5v1MxE5RA");
            state.setStateCodeChar2("xzpnaeMnqBWlzqkXhdisjTNaUe8bj3LP");
            state.setStateCodeChar3("QcZkKaMQ2jOIjNhPS0YYCLyEYuwEGysk");
            state.setStateName("tH4qb1ow4RNQtHq9xOXRhRzMsEmss2Porsuith0uryCchEghND");
            state.setStateCapital("m0mpvPPgFN4Tx7poVkiOtBgh51dqsPpZJkEvCNl8beBFHRtRGs");
            state.setStateCodeChar2("P4yZwBht7rz2YRbbojLIj7bpny7azYJf");
            state.setStateCodeChar3("igMYm8vQQleVmq7Vwt0nyugZuKqIdlcY");
            state.setStateName("HRUtQxgHFEQ6GRtz0PT9E0vuce5Za3Hp1H2t6ttJm223r3lvHD");
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapitalLatitude(5);
            state.setStateDescription("F4yYs80AJCSoeUUKX7jlkwPhUxveXNETj0RsikRPvXZNwm0R2J");
            state.setStateFlag("S3IsecHTKA5W7V3IRE5we7Mls0c3kZixcwBUt5UcX46XVhOt73");
            state.setStateCode(1);
            state.setStateCapitalLongitude(6);
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            City city = new City();
            city.setCityName("TEPIn5fADgaDPwc2aH0mNfj6EbLkHgRIQ2LfpybfcbzhyKr5W2");
            city.setCityLatitude(6);
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityFlag("RcoXJko1hnObOojFLDbp4WLPiSn1vqS8UC0TuL1eRCkoFRd6Iv");
            city.setCityCode(1);
            city.setStateId((java.lang.String) StateTest._getPrimarykey());
            city.setCityLongitude(4);
            city.setCityCodeChar2("29tPq9w82kgOI8eWhQXfJiUL40r0zjcO");
            city.setCityDescription("0qSVClsMLxWVVnauqseOHlDWhpi8jhwmlNNc1alZBGNHLKOXyF");
            city.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            city.setEntityValidator(entityValidator);
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
            city.setCityName("6RgMA7VjOkhSSHCQWRBXTolsZ4ZrjSUOQar6tz7YPE0kbsGNii");
            city.setCityLatitude(2);
            city.setCityFlag("kGMGvCypUemug3o76er8bvZBiTOMzvSafnNyMcjWXvSX488YjK");
            city.setCityCode(3);
            city.setCityLongitude(7);
            city.setCityCodeChar2("eSJejl4E1E71Z4kpdjtqEjvSc7i91s36");
            city.setVersionId(1);
            city.setCityDescription("es7bxjfs7CA3ZkmpzoxNj3q2i3sPcWqAmevPjM8Lgs85gIy7eb");
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
    public void test4Delete() {
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
}
