package testprj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import testprj.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import testprj.app.server.repository.AddressRepository;
import testprj.app.shared.location.Address;
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
import testprj.app.shared.location.AddressType;
import testprj.app.server.repository.AddressTypeRepository;
import testprj.app.shared.location.City;
import testprj.app.server.repository.CityRepository;
import testprj.app.shared.location.Country;
import testprj.app.server.repository.CountryRepository;
import testprj.app.shared.location.State;
import testprj.app.server.repository.StateRepository;

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
            addresstype.setAddressType("IX5nBSGoIqfeg3pmDxipFBEnOmBfbDhNPlyNEyKXvUPcwmAuO8");
            addresstype.setAddressTypeDesc("mpQRnVHO2Um3EfHhSVYuMX8NG1mli60HRmHditnbn1AChZUYcl");
            addresstype.setAddressTypeIcon("1i7rlsxXOGm2l6AW4uKgEebnMXCK1pbHDwGydNNwOO35Uz8NCt");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("i0fiGj5q6pNY1MFD3pvzt4PzFakjeUuW");
            city.setCityDescription("KHnNpHbvDDK1hGU9XwNDegsjDqZEDtKzdwUQuargkkSx0wq67q");
            city.setCityFlag("DjjiTjdAoWAOkUseNwaFKU0tyE3rdXJmo6LESTxjsrgxkGnven");
            city.setCityLatitude(0);
            city.setCityLongitude(7);
            city.setCityName("HQBinLbuecQIBxTxv0sBJYnIkGVL4ZkI5FHJcdttDpYXjgMfDe");
            Country country = new Country();
            country.setCapital("t9i5wFXSBzITPUVje60zGUvbCwKIjzvj");
            country.setCapitalLatitude(3);
            country.setCapitalLongitude(11);
            country.setCountryCode1("XB3");
            country.setCountryCode2("DCD");
            country.setCountryFlag("qwIgqUd5oHnEw0TGzAtyjED0yJJIaU3WWu3tpIVLtzqKNZRTFF");
            country.setCountryName("eIjv8HkFEqHK2c4ym23DjhbCu200oBfN16d0cCXj8sKn7IE4Ft");
            country.setCurrencyCode("MQV");
            country.setCurrencyName("hqv8UrpWro3xCB1CVD8AMQoXPGk5TXpYyTsJTYpVdxUYsXqLqZ");
            country.setCurrencySymbol("1g6yXotFk7c3oy7mOiJkMEOQqXzwAJGG");
            country.setIsoNumeric(3);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("bV0uAa11QdyaqETLu6QJSr3eT8TE3t7UsLwK2H2Dee1Qz3oMFa");
            state.setStateCapitalLatitude(5);
            state.setStateCapitalLongitude(10);
            state.setStateCode(0);
            state.setStateCodeChar2("qd4jsXqwGNnv89mZunfhrMGw9jRN79Xj");
            state.setStateCodeChar3("7tEsinPOWGubawLW4IZWRw6OsagJ4Uvh");
            state.setStateDescription("K8QuW2QjBg4PPsihh5tcFqnlI8n8XpyFZcfchUD641WxCYLpH4");
            state.setStateFlag("VBnwrsS3U47SiDKnvAe5bm3T7NR6ohW7Tz4JYTwaJRNdIaTWSz");
            state.setStateName("K3Fgo6Hnegsg6rbEh6D3WdDX9Pq64ExDkOIxv3G5UvMR5RKPfV");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("dgJ1n09SoftA8WbXjZiONmJhFWFIzo6V");
            city.setCityDescription("JG0t9Uf9Fpmz6UA620XK2YDkXARonxottfkZcC9hEFYNWEn8hS");
            city.setCityFlag("RwuK0UtBPSzEUGUX2161ni8vEexcl7dHmjzsvFdRcBwQ8ke9Wt");
            city.setCityLatitude(0);
            city.setCityLongitude(6);
            city.setCityName("ycamEoQoGwA32guIwNxaxNdOOcPNXrnEN5MKoKHPhfYExBpuMq");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("Kep6KZWcIhhSvpJDyS6v34JzUri63cJ0IKJCOobqM4mq4TF946");
            address.setAddress2("Bwj3R6gzVzoPx9BiGMYE6DcuFttMr61W2SabmgFnkClq4qk3yr");
            address.setAddress3("dPpvmQri6Xsk8HlN8uof8Qym2QSrsbAUbEN2Lmqzz7onnrVeus");
            address.setAddressLabel("SPjRPms6twY");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("VhASeYsi9Qyp0ugIYuIvAxic3tQpu8FIXuaW1eb1At3nXUPkyu");
            address.setLongitude("oAlDwOUhJppeUEPAdxOp350s9HyWM6DmhZm9xtjkg4WJW0hhBs");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("zwhUsb");
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
            address.setAddress1("u1sKzfr6n2pdejAKhPN4iWrualSeaOcmIHArdOjni16uow8C6E");
            address.setAddress2("qbZJ85oMBXCehIcofmKRm7idcyQJeSYNEVVHue9mVuITbAkkbV");
            address.setAddress3("n22LfI54l4tJF05FQmshe6btTPvOeRvVUCyJizeexZ0Jzgb9ty");
            address.setAddressLabel("iI18bKwlOow");
            address.setLatitude("PwlXSRStCpFjOJ1syj1YM5m4sMyqWCPs8q33cZbWBaxyG5qMwv");
            address.setLongitude("pkhgzBdFJzIS8Ug9v0r7dTDhnxNl7uylPWKRNoVde0P9G8kH7g");
            address.setVersionId(1);
            address.setZipcode("OUUU40");
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
