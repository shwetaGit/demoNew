package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.AddressRepository;
import com.app.shared.location.Address;
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
import com.app.shared.location.AddressType;
import com.app.server.repository.AddressTypeRepository;
import com.app.shared.location.City;
import com.app.server.repository.CityRepository;
import com.app.shared.location.Country;
import com.app.server.repository.CountryRepository;
import com.app.shared.location.State;
import com.app.server.repository.StateRepository;

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
            addresstype.setAddressType("tGNTUy6hSwlSSHIaiZnCnRnxiuB3q2D144f9c19tU1hKdHLoFb");
            addresstype.setAddressTypeDesc("kntMoQIP7E2qdO5kQVRBSaMFq63Z5Q755nZI6pL93OCiD3CdqM");
            addresstype.setAddressTypeIcon("ljY66PjRpb2z5v81MhQVEDKx9BljRj8vg6GfyQPEgKDhVhAgUZ");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("0YDSSqTlnhUJsuIJMfZUDp20X14eqK53");
            city.setCityDescription("EAu4Sp28Wmma9Knr9gObmjTZYWOQYeudKKMcYpOYIIm7ZNNaiD");
            city.setCityFlag("egp7eGjHwFqkJ3D9K7DpOEy8QY5L0IHYPI17cp0jT51YnOihil");
            city.setCityLatitude(11);
            city.setCityLongitude(10);
            city.setCityName("031wx5kwaQYyKw5wY7DuFiXNkPFwPOtf0T1kxOYMRa70h4zzwN");
            Country country = new Country();
            country.setCapital("9VbZytFv7DAdQJQfFt61FEBjaDOj3ITN");
            country.setCapitalLatitude(11);
            country.setCapitalLongitude(7);
            country.setCountryCode1("yYF");
            country.setCountryCode2("Y9g");
            country.setCountryFlag("pLep67P8Yc1MyLB7QvmlGiV8UaZKNfXVjJxmwoyqKbLjpxnLfz");
            country.setCountryName("adLCyJdVnvhNNvmMLfu2LAL7uGRl9O6mq0PHj3l0I9qvrLDazb");
            country.setCurrencyCode("CUb");
            country.setCurrencyName("xZTlgTrMfSzRpUwxwUYp6EpYyf0e5kK6FWnblEY6u42fsbn0fn");
            country.setCurrencySymbol("kltvRGgCRtvQu7NhCNCwkhSUG7svcdet");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("cnM4lDic3pEOhGmtHiIFJtaNWTN22eACzBn6bZ2M75YohIq9bb");
            state.setStateCapitalLatitude(11);
            state.setStateCapitalLongitude(8);
            state.setStateCode(0);
            state.setStateCodeChar2("cOEywP8mR3XzMXkATn4UgBwV7AENwxox");
            state.setStateCodeChar3("Dx9yzErdG6ZUdS7aUlwOmhot9UGvf5FW");
            state.setStateDescription("Hie1aMmpkfXb0crCJr7fPgwkXTos0ghNLQenU9qviHPmwYVrPN");
            state.setStateFlag("IpD0ji7JwhOjQ8Jan8wtNEI4zazMMMwopwrflLgYIXe33apEri");
            state.setStateName("TqOvibmgykbMIMFQNJFVRhj3xgSvAgNxUCa9YiUH29SogFSO7l");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("3u0Lqee9EXAwyEBmyxhMQybSnxGwI1el");
            city.setCityDescription("qNZvhT915OOyRe3f776Dmrr24L1nT1UMvZwV3cCGNFetQkTKY8");
            city.setCityFlag("O6znYcJuSkauBcHY7kkO3ZvaEbMNkmRj7Q41ZWWzGANmxzggYK");
            city.setCityLatitude(11);
            city.setCityLongitude(9);
            city.setCityName("XAR7ue2iKsooEmN0l2Rr9Ei27ebPgQvi0EMQ7fO4otZA51YjqC");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("ylp3z6uRHG6qOGLbwhNfqD4ipiDDVGRWDS29CDkgxQlFhXNGhF");
            address.setAddress2("zTPoF6qbNJJbD2kTnZaaqOqGyEe7o0CkbyUrU30alt3WVuhLfY");
            address.setAddress3("JkJ3DNFq9vk1SczIVkOtusOebX0Os0rhMyXT9GHmGyzTn7WeOu");
            address.setAddressLabel("LDSCAfULsyV");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("ChPbVobUeawznw3XXlGJBk9u1bsmq6l45dxsuGveIbM3FdrYDg");
            address.setLongitude("3kEhSnHRYr07ceDRJy7lem1cRmtxnjn1BbXs9d3F8bRbe1IsgJ");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("ZlzRGE");
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
            address.setAddress1("zzaID75wYD0lGwmj0Tqz8PCdiqhzh43K2rBxgznyqpsCo5RKQ5");
            address.setAddress2("8BFukXnEFEu79PFiJm6nVRf8TMuzEMmrS4SyRLwtSuD5WA4Aym");
            address.setAddress3("htv0TmzjOmKg9NpPduY8JpMmJKTsTu0MGYMbV0OmAqjY1ITu5w");
            address.setAddressLabel("wz5RmMtvz6a");
            address.setLatitude("8hs8bcJPNWZ8gajULCDDXN5R6IoAF0KvteCnp9dreMb5P89xc5");
            address.setLongitude("YEiRRagCGai7WYdAcdKaotWJ6oh3XTxYPL13jxb5nICXJeUAai");
            address.setVersionId(1);
            address.setZipcode("EeTJ0j");
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
