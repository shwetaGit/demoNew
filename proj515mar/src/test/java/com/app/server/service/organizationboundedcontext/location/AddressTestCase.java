package com.app.server.service.organizationboundedcontext.location;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.Address;
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
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;

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
            City city = new City();
            city.setCityName("aXxKq9VTSlQ0mCwa8lA1kpCSajIVkIhOrjx64kwy98gyq8aao4");
            city.setCityLatitude(3);
            Country country = new Country();
            country.setCountryCode1("zmo");
            country.setCountryCode2("dyb");
            country.setCurrencyName("6Fn1HuZupFShzGPvV4fhVoM9KxsDYd13U4SOjZ2pPfoUElRErq");
            country.setCapital("c5nN4hi26eIWzrhkx5olRV7uYqt1hmGj");
            country.setCapitalLongitude(6);
            country.setCountryName("e9Ct4VUDR1pVYwP7rNAaqBxQ8sQF52Gjr5OBwxBCKE21Wbkz3t");
            country.setIsoNumeric(1);
            country.setCurrencyCode("iJB");
            country.setCurrencySymbol("5A9x3XDrGQACgO6epXL6wt7GRhQi7teD");
            country.setCapitalLatitude(5);
            country.setCountryFlag("ZCDv0PQKxmcPneiSqWEP8O2Pb5CLX8ObuQKXfvCGsG7nAmHZAL");
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setStateCapital("OrtNabZmTWeygjaXMjcGF1vYgjdQXU178uYERsDeGwiAkTHOew");
            state.setStateCodeChar2("zELdSHe30vO0FyKn2pfJN6bE0vhUgQUt");
            state.setStateCodeChar3("IcXbZsyIbq4fxdKLu04g76FqT3fGxGjW");
            state.setStateName("k70k15ebZ9our9c4lnu5H8kaIQQtL8oeJLWXBLCJo3LtYxU2oE");
            state.setStateCapital("PSLMrEWVxEcjIVkSHBjy9K8v8REawdOT9NstwwVCRBHBdZOeMu");
            state.setStateCodeChar2("jEA26bExIK1uv0QZV1UjAtyyT67iaVxM");
            state.setStateCodeChar3("rLHgjF740eckQBplRZaJfBsig1sHFcHF");
            state.setStateName("VvgnEuIM4hdYf1S7xFaG3YQ1Aez1qtLeSjMQnkrvOccyrGDH95");
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapitalLatitude(11);
            state.setStateDescription("YbHuYpFgvti492rZWm3ZgjYultkSFrZ0zbKveU9b7Jc934yojn");
            state.setStateFlag("iZizYbCajaGJJEM0hJSZmcWYXlF4Lpvg8swPUU39miUiso1Vcy");
            state.setStateCode(1);
            state.setStateCapitalLongitude(7);
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityName("OCaaS4eoDA4t19Dj0HS0HZW7vZYUXN1nh8sN7yBDEmtc4xudBU");
            city.setCityLatitude(11);
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityFlag("fYGYFHON2GgNWt00aMs8o1BPEttCub7cpX8OjfjFgEpdVyiI0h");
            city.setCityCode(1);
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityLongitude(3);
            city.setCityCodeChar2("GLEsXxCekeewIqccOLAyP3u5HXTYdh8o");
            city.setCityDescription("c0rl3KAvDWgohbogcikOHx915PIKH7lm3ORYP08ZMfjf78AwVu");
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            AddressType addresstype = new AddressType();
            addresstype.setAddressTypeDesc("A0e2UmYkTr6tnNM2F22bQGYh3TfSN5694ARQ3QrLXcOIegKsz4");
            addresstype.setAddressTypeIcon("iUBTyyhXEKNhVCCyWhtESGQk3O9cfN8a84aXDmgT2cD1igwjKl");
            addresstype.setAddressType("M9w5KsvWoYV4t4UVG3PyGpLFZGqN3iC4SB3Rz0lbWdZxCtQTXC");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            Address address = new Address();
            address.setLongitude("a81oJrin2rBTX8ICRxnDK0PHHSywNEyxfTNrvfN0UoHqa9GxQe");
            address.setAddress2("qn5MR4LKajPSf3UJZIIlwPbH9ldjI1ZQlMNZrWTBRGomjiw86e");
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("OfBn8e");
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress3("g6s8rsgOtPls1ElhLhTPdS5SXn5OFqGSIGhbLQ2U43Byc4R6Ua");
            address.setAddressLabel("3ZVZAcA83HO");
            address.setLatitude("HIEkHz3IrWOIFkFxfjIAfpmlSGklNdHHotAZGGFzCoUw1OzcGx");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey());
            address.setAddress1("Nvml47Tqfm5XHYCvI21WLVsvQPNv6fV0u5Yw1dgJMSSO9l0VeH");
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
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setLongitude("pUNEHE8CsiDXYPyKlIi386Pus10XjoOyJI1ACxwRJ7wCIZPq8g");
            address.setAddress2("uPai5jRPuvb64wtfh90rQssI7QEqsjVAjJRnJ827gXieHXNyjv");
            address.setVersionId(1);
            address.setZipcode("3dTulS");
            address.setAddress3("IZyKNYEqXZcr8aJRZIq12IRsR0cP2xzmv3huaAWFIIuVT76HaY");
            address.setAddressLabel("NBZ5YQqJaRI");
            address.setLatitude("gMvMVgqHYTOh47OMSVarZhTvvgWf3E4wYq24NulA9DHvgg0p36");
            address.setAddress1("oSQpFqpVSXAtXmyoEpaUU36eMtmOizx3hF7EHXUL7rNZYRD3Uv");
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
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
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
