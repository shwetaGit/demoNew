package com.project1.app.server.service.organizationboundedcontext.location;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.project1.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.project1.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.project1.app.shared.organizationboundedcontext.location.City;
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
import com.project1.app.shared.organizationboundedcontext.location.State;
import com.project1.app.server.repository.organizationboundedcontext.location.StateRepository;

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
<<<<<<< HEAD
            country.setCurrencyCode("991");
            country.setCountryCode2("GHh");
            country.setCountryName("TEjTRAjKE1kM1B81sbaQiC1EpuEfdYynQZjGYULl2f8kFv8Nzf");
            country.setCapitalLatitude(11);
            country.setCurrencyName("ARkAuzfPhnQejUIjqZ6erjnY13iPJSwKUZgwEi0G0OeXvMicDO");
            country.setCountryFlag("yxir7gZsXGtVeSSHIQP8ml0GxXnt3yJsz2zl8YHx5o3c79qwde");
            country.setCurrencySymbol("khXXCvmQODkbE5BL5pd0XkpqXokjZMqd");
            country.setIsoNumeric(2);
            country.setCapitalLongitude(7);
            country.setCountryCode1("Olx");
            country.setCapital("po8rTsFujtvV1U7CzNXdRAaluluTHeYG");
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setStateCapitalLongitude(10);
            state.setStateCodeChar3("mETJqhImuy2i3Vgc04H6qvtEDlUaKq2Z");
            state.setStateFlag("oGqHfsAMOhZUMlFHYbSYP1EcQAmbu6q6XPi9U97R5VtuKnLzRf");
            state.setStateCapital("Y79CkGPyuirAHJtJ54MU1MdZCLv4A5GlNhp2UynngnajdnJPVL");
            state.setStateCode(1);
            state.setStateCodeChar2("UrrQwWTinHtlvM7BS3VDdgBVt8sWo9p6");
            state.setStateDescription("LMoLc9cRKIkKWPsztG5jnbL9659LkoXVvfhrxOZ5WsXefd77X8");
            state.setStateCapitalLatitude(4);
            state.setStateCapitalLongitude(1);
            state.setStateCodeChar3("hIKSQLCdEZzhi5iCZB7JCKuveRHZAqrf");
            state.setStateFlag("WftQODVkg8ujTeiT4EStnaaVqzKD3yecdfiVbeHssnjbPF9Q9w");
            state.setStateCapital("2SIwHHPJMKwisGBZ8Y605PnikI9uGc0YRSObDr0zycnFAFfJYL");
            state.setStateCode(1);
            state.setStateCodeChar2("Bfl2cOctr9sbfMk1HrKWoXqIDfpcOJdN");
            state.setStateDescription("k8Pt5auHEXyEq6bvBU6iW54o6kjDS4VUnA2fr2cdEu0yRWgFUf");
            state.setStateCapitalLatitude(5);
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateName("1xg0iZA8gOIBYFqTiSDyl17NK95IGTsKArnTtCHGQm1HcLNrDm");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            City city = new City();
            city.setCityDescription("96N0xo3cwfRQ8o0H23umEOYIG3t2IAMRlLqwkwe1oLbpnKAumg");
            city.setCityCodeChar2("3GwFfoaFq533eS8YkZ26AtpX5J1bETup");
            city.setCityLatitude(8);
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityName("zsLDnJd6vI1q7KdGD5rVbrucDZJl4aaGV8r5Xsx18nFaheX647");
            city.setCityLongitude(11);
            city.setCityCode(1);
            city.setCityFlag("u0XJcUXkCIY8ORxmvbMW5pfKURLq0vKDt4uXp2ayCPIzyFT0HO");
            city.setStateId((java.lang.String) StateTest._getPrimarykey());
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
            city.setCityDescription("CF3sXcCOek2FqtqCdPuefnWTLK0T3fO71UbQrJ3ubS0gQhF2Sy");
            city.setCityCodeChar2("4kzjOQN46UORPeUl64J4OfForE6d57aQ");
            city.setCityLatitude(6);
            city.setCityName("TnTyg3pSenuWmZEPGYbvgx4OE4wdMQX2MSReZE3T9DYWzZk9GR");
            city.setCityLongitude(7);
            city.setCityCode(1);
            city.setCityFlag("Td3alPM8A3obknukJwBFlt6x5vGy5Vf1Fp7IWr2hYA0txMrAnX");
            city.setVersionId(1);
=======
            country.setCurrencyCode("JyC");
            country.setCurrencySymbol("sTahPqUOYZrWcqLYnTVNSTH4I898tYXJ");
            country.setCapital("S33EYNB9Wibiph56Rl1pcEhtWpLUnFQI");
            country.setCurrencyName("nn2I5JNBoS9DZDZKgsLV1Kzteg2LuIUEuG0OsKy1o1Rgsl7M6P");
            country.setCountryName("wOt0qXHaOWNaR3Lw8CH1JFlBZHh95YzciZpj1bBLQvVyEpIBmt");
            country.setCountryFlag("z1qDVav2TIYcyRxS6P2dWE1sccJ5jNtiJypnL0O4uJh2fCaQwA");
            country.setCapitalLongitude(3);
            country.setCapitalLatitude(8);
            country.setCountryCode1("SWI");
            country.setIsoNumeric(9);
            country.setCountryCode2("Bjf");
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setStateCapitalLatitude(7);
            state.setStateDescription("zQPtYKSlBo9CaBdfS2Bkzd0RozwqfreNJi5DgCOWv3tZCsuNFr");
            state.setStateCodeChar3("CKhadNW9kefEXBK5VvPKQ05xh8IADyJH");
            state.setStateCapitalLatitude(7);
            state.setStateDescription("fLmvvG2qWLeBuk3gQmPUmQi57MgVRzkdAHYHTNHoyEg6eKplAu");
            state.setStateCodeChar3("s3JE1Hys8IDmOyVh5AwPckwRz6m4uMxP");
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCode(2);
            state.setStateCapitalLongitude(10);
            state.setStateFlag("mc8Pp8StwX71KsA1TNsfvQgMtYvwxdIpArLIL3e2iCjjXzSHGW");
            state.setStateCodeChar2("fhhEBcCYPcmiJwgRYR2ZyNKGoXrwSQG2");
            state.setStateCapital("qRDZ6F6XUloo3z3jyulxcKEShk8zWQoOl7SswVrWJMBPti1yuB");
            state.setStateName("xDSn2myV7gmPOeFc6pYpZUvQ8kea27hsHccoER1g0f1AbD1QRt");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            City city = new City();
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityLatitude(11);
            city.setCityDescription("KnfQnUJwTn1JVSKrKYNbCqRq9LfX6eDKkIkOTdAzUpJYn78EQw");
            city.setCityLongitude(4);
            city.setCityCodeChar2("TXpGjnIpekn8NOv6xIT9aI5K30mD4eBa");
            city.setStateId((java.lang.String) StateTest._getPrimarykey());
            city.setCityCode(2);
            city.setCityName("4NkgCmIcnlNvXE5KTZFgC1z8bjX6vFwe4tHbS2KQvZ43YgObUU");
            city.setCityFlag("fEPvdnwYXEo2VeFytFKyBHcHODPxyFUk3OuZoIgaJINqesDg83");
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
            city.setCityLatitude(11);
            city.setCityDescription("BnyTmp8ObIUTZBJr2Sj0hzPce6bowfvqjrKFhT239F49WRE9MZ");
            city.setCityLongitude(4);
            city.setVersionId(1);
            city.setCityCodeChar2("kXllDlPNWH9WSnZkSl9ZWTxOjKAHIlny");
            city.setCityCode(1);
            city.setCityName("tTxz2sD1KUUjl18sX6YPS5X1O9kZi2tS3rfvxsL5zLnomSOCxw");
            city.setCityFlag("osypVSiFXFtXaSWyhzfUT13Yc2cVfVrycPekKJVNUahNWWkeTD");
>>>>>>> branch 'master' of https://github.com/applifireAlgo/DefaultRepo.git
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
