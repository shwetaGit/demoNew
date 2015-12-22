package com.test.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.test.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.test.app.server.repository.AddressRepository;
import com.test.app.shared.location.Address;
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
import com.test.app.shared.location.AddressType;
import com.test.app.server.repository.AddressTypeRepository;
import com.test.app.shared.location.City;
import com.test.app.server.repository.CityRepository;
import com.test.app.shared.location.Country;
import com.test.app.server.repository.CountryRepository;
import com.test.app.shared.location.State;
import com.test.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("fl1EuSEDscV163jBVtlVC1pq7oUYYzkiLAUZOQuEXoIDkcVQvG");
            addresstype.setAddressTypeDesc("P7hPEhjqGyvXFJl6VMZuD7e5vImrBflijBmm7eaMKM7oLxj3fU");
            addresstype.setAddressTypeIcon("f2AheGTrfy1plJG65RptyAQwhJTytfaZjbC54R5OGkDC0GY4wR");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("gHi3BzNhFOLkSVVHVFNufzFuIT6962E0");
            city.setCityDescription("3WMNLOi8dGdLceKQyBjFhG9PtdUjRG93cfjug8lBU1Asx72B40");
            city.setCityFlag("vatPt6Mdiv6eWv5VTY1ZclJowZvvkArMN9orDDi39KjQA3SoFz");
            city.setCityLatitude(11);
            city.setCityLongitude(8);
            city.setCityName("NRpVI4vloqqIh3C6dJRr25utYshMBYCUQOUWe7sbOYmVvtBMcn");
            Country country = new Country();
            country.setCapital("BmImUYVFRlHtbR84sQ8ReQWTJwgmm5qq");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(4);
            country.setCountryCode1("m08");
            country.setCountryCode2("tnS");
            country.setCountryFlag("5jC89wHwVre7wrYSjzmqSjqnzXw7xFlv0lhMvj7SZgp2un7Jw2");
            country.setCountryName("rt9UyDyAfVhpQ2vZkZzbykN92xz4HF4uvILBgbsAojPMpOrTve");
            country.setCurrencyCode("oZh");
            country.setCurrencyName("RHzwoHiL0ZQlPOTDwgygmLNQ3HkucIQSB82RwnU2KeYNeA2CbD");
            country.setCurrencySymbol("6vAgtx3pBkSr1mtS6TuLn66h6RRnnlsk");
            country.setIsoNumeric(5);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("tL7eJqeLXCgDdtjFRcDzcXWExiZHEykoxqHNobH2cqMe650MJZ");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(6);
            state.setStateCode(2);
            state.setStateCodeChar2("EIicEm1BZs7IpgzrgpC8IP5NQuXwlXSR");
            state.setStateCodeChar3("II2OLhJagSNW2ydvPlGDBR4jqxNjQW0I");
            state.setStateDescription("ySD6Ybq1ujcAk3SwCkBIp4RC73FjsEuKHqBu8es8NPJdpftGx0");
            state.setStateFlag("3pB3whIeAtuGe1OiHgroXyr2AEkvck9VxDmovkVqS25e6O5O25");
            state.setStateName("vmAknyl7mDfZ0jNWyZuQEa8YZOJAo6eWkg16S3ZeUg3zww7Vqt");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("4fiFcCfJL3iPRXCnlIJiHNm76KQb9BrT");
            city.setCityDescription("taqwwoSyEQ6VHespTwl2De1x2UA62LbfqRVefP8Tq6nyRp4jLp");
            city.setCityFlag("QFIuXGqJa1J353KuGNajZqd4SooNuLjOka7eGZIE3CFroQK8TM");
            city.setCityLatitude(10);
            city.setCityLongitude(6);
            city.setCityName("0VuJ9IA1Fap3AMVOIO13oupeVt3r4m5Ew5XiBCdX5I8vvCQzqz");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("GEwmdeuUEFegltvVHT7KRyKqlIe5EGSsSOsJbqAOJZ8mKTLRra");
            address.setAddress2("WHELEdE8CijFgqyniw2TV9AELDWNs4rhPiAAhn5EgzAaHOZ8eK");
            address.setAddress3("4N9D6PHxwbtveOoT3LgiOPOs4ycGvqnhjuPXoadq68BgDOXfT6");
            address.setAddressLabel("7RcPTNybXbJ");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("mihGnolxrPHNGo1oQEJEMypF4gKlaBlMzEA7Esy3LtwVaD8zVf");
            address.setLongitude("e5T4xxALkbbQlA1MUHIvWMhlrVbTKiIsn52eUlRsaASaXiB8LT");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("e60zBG");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("OvhJzKVTA1s1HwpH7tduEZaFtts1JKVaQJQbarcAnvIR9ZipnY");
            address.setAddress2("arr6Etxd9ePyWhPgHMEcYZ9IYZjxMhCSYFOacalfUs15APhOe1");
            address.setAddress3("7jpPFjBSCrod5R0llwMAKOcU4WkRz4qs8c1zouGKM0eP4qGaDz");
            address.setAddressLabel("AZw9En2feiz");
            address.setLatitude("BfoOo9l27CUf7o4ZN6moRpPjiydArUW3DdpcD49JqYQQ6mKFKo");
            address.setLongitude("tK1x9JJnGLlJ3GvvAWbYbR3VMlGgCgVrylnFPCB69y4dm84tB9");
            address.setVersionId(1);
            address.setZipcode("RwwzgN");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
