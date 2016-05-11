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
            country.setCurrencyCode("4jU");
            country.setCountryFlag("WgwdcQfW4COyanCj2Bl0RnB5vOn7CMB007pzdpPSx1OJJ6QYYn");
            country.setIsoNumeric(6);
            country.setCountryName("W2NF3YY1WawemVSYkLh3pCgCVJoJpzQ1YFwrQo0FRM667TWST4");
            country.setCurrencyName("1MyyZVWp47sORXsb5POWXXwXevtYjyRzrcbqyPYpza9gAScNjN");
            country.setCountryCode2("bhH");
            country.setCountryCode1("ARx");
            country.setCapitalLongitude(2);
            country.setCapital("Ij8yeYdqFkmTHw9g07w2Xp340OQoaaUY");
            country.setCurrencySymbol("vkeLRJl3emhDurrxaWtTP1uDKHuPdiT4");
            country.setCapitalLatitude(3);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setStateCodeChar3("QFdDlIYqeRR2YmxZcLntn04UkszYyYjP");
            state.setStateDescription("HgN2XCzrpyybtEXHmQ7jImljOdgqhNOcvaoWPFOKo1fb91mtxD");
            state.setStateCapital("QgHu1fkHG96YEFt9ttvJbgiqFyQFOmviPMMi0iMZuD4rragIBP");
            state.setStateCode(1);
            state.setStateCodeChar2("bD8EPi57imjNiAesvNXZRi1xzwbgSy3D");
            state.setStateCodeChar3("rjFanU8LofCW0jiChW95y9LH7Mqeav81");
            state.setStateDescription("BXQfzDzmXWH8VxB8pi4KAmdnlM3cAflXTIxcqnbcoRvI9xkmBF");
            state.setStateCapital("WbJN0CfyGBUvxJH4o2WV34KjIT3oxuBNV4v5XYqmQSzJBRKZrI");
            state.setStateCode(2);
            state.setStateCodeChar2("HQYg6XoA2rHRecDfhHq2BABcUPcG0nG9");
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateName("QwE8nyflOapEY5vnGWybE6R0JzV27v3JW6bYSaevtZAhKS8nqj");
            state.setStateCapitalLongitude(1);
            state.setStateCapitalLatitude(11);
            state.setStateFlag("rTVLPvhxk3SpEXL3wQIeRs7wtnR5gf9iO8SBLclBQBqLiSgOTe");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            City city = new City();
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityCode(3);
            city.setCityLongitude(9);
            city.setCityFlag("C8WkL3serdngR1DKEFVhUhFB2G3OHV8Vmz4uAKspXEQiXSsUqy");
            city.setCityName("fqA7wUynzvEoinTznkcChEjmch4takwU9yi2m4TYT7HAd48CsH");
            city.setCityLatitude(6);
            city.setCityDescription("RfdlWyQ8BLHEEZ3EKPkaBnGBy20KRbSjYAwmTKRyGXYnmIILbF");
            city.setStateId((java.lang.String) StateTest._getPrimarykey());
            city.setCityCodeChar2("2LDE2UVyUjwMkVG9eyyHBx1gvKv7cHKa");
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
            city.setVersionId(1);
            city.setCityCode(1);
            city.setCityLongitude(6);
            city.setCityFlag("2hjPuzjHAWiLaZmwhlZJEfIOF0KxToPB7zVbSkIcQUbhNT5pDg");
            city.setCityName("I5KxnUQGZwVCvn5clnIx90pFvduMBSwuvWHl5GJMRnDswI0nRh");
            city.setCityLatitude(3);
            city.setCityDescription("lP54YKzMCF0BexA13NnWNeQRIdU1Dwt4k9xdYi7QfmpwrfpumJ");
            city.setCityCodeChar2("8C6QMdIeon43XDF93MvrnaByMQ4WGcma");
            city.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cityRepository.update(city);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
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
