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
            addresstype.setAddressType("EzVHRbyVBu0CX4lwjmDRqY24LdQLWH2uOxCa26zlXezkoAHSPE");
            addresstype.setAddressTypeDesc("PnDTOLWgQ384TUrSd8a25cHmjr5lBd80DXSEpzfzX08aoCB30A");
            addresstype.setAddressTypeIcon("FbASA35rI6g1WxpMtlOByQgRalCaFF43FfiJvi9IfPEU2dvAII");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("7xgxjHo0d4geqemEeYrFwXUS5c0ykqS7");
            city.setCityDescription("y07lSSt2raAX3AVZDJFUhIa4dhIpXvtV3GHXb0uJkmSIyEa74v");
            city.setCityFlag("p2qvMHu9NS5YpJerLxQu32P9gHdFvvj2ioQ3GcfaoohAetSyCs");
            city.setCityLatitude(7);
            city.setCityLongitude(6);
            city.setCityName("TFjnrduSeJKwYpH07bJzZHDu5k4edD2noUKiXTvlMxhDH23TwO");
            Country country = new Country();
            country.setCapital("bONbQuvYgcT3Pfvl66kUlTDv7KbOylTu");
            country.setCapitalLatitude(10);
            country.setCapitalLongitude(9);
            country.setCountryCode1("36n");
            country.setCountryCode2("WYy");
            country.setCountryFlag("Sw8g1tCWCoprfguT8SU1OwOWDKwkTvSu1R7nAD2aNa6ivzb5K2");
            country.setCountryName("W01qZGjnVxXsvk4mKc4Hmb2nKDSp4b65xSFRn9a4qgPDwYsM73");
            country.setCurrencyCode("baK");
            country.setCurrencyName("VtCe1liQKyHreTZf71f64ZU1h6FkfxjssoxuwEbdNvWRYxmdcy");
            country.setCurrencySymbol("0Eyce4gB9dXrmHzKdvJqIPOgaoeqPLtt");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("R0NWQDTF51URlyUMJuPlkJcq9f7EFW1vchlHWHjBmLqifI9qRz");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(5);
            state.setStateCode(0);
            state.setStateCodeChar2("tfNNhYiQx0WPuKp8t7M2893sTRk6i2iH");
            state.setStateCodeChar3("GoBXBZWiONs8nvlBxWiOIJgYMB4thzof");
            state.setStateDescription("VjLDTzVAVcaMVd6f2z1ymtPamHcI7t1NlyzghdTcAJe2uabvgC");
            state.setStateFlag("IywWRVcnXtMLw4v0mimcwTmjI5Nx1ZEp1MZqmsJCvSzWmrYdj9");
            state.setStateName("eyQaiyAhiGaquYO6TVdd9QigXAutdNgUbPXOVs8ENdDRlvkzwW");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("iU82TsgTAmDX0IVH7KD9o4St5Imgp0W3");
            city.setCityDescription("VCgqdJ264v3zvWMva3jlNeDI62C0LJiLdYDh4vUuQqDn0bHSC0");
            city.setCityFlag("9e6cuCeVywAu9DVmxGzr1AcrBRcFOmSrysVozOXznoYoBoZE7j");
            city.setCityLatitude(5);
            city.setCityLongitude(7);
            city.setCityName("d6R7cf8zGOHqMmZmzONTzZ5UFmNR1B9QceNYeeBVKcuMCSNvH0");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("R2qydlELIdM98OtSwfAF7J3MMy2ho74bVouP1ZAmvjfJ2PLm4o");
            address.setAddress2("o3afaASaDx3a9hrSeLGl8RFlOOlzQoBI3xo2KsTdvxhQLgGzzi");
            address.setAddress3("6t4iQKzjq8kHlagG2B0wBZXWGJic26u8s5ZeUPi1TOV1rBnYVD");
            address.setAddressLabel("0OYDl8lzV7A");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("9qGTB8KqyhVB5Jdq6JZ1Ziba4lVKKM8UEDX1aqHgONuZMFIHJb");
            address.setLongitude("wLKFORUevkqS9r7CYBJvjO9xrZgA4fBTxhSU7ZgUUv0nLrcIYD");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("F0Gz2I");
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
            address.setAddress1("4PEJPdXXvZ6YmAplHtUz3wQk1gZkeccxkx2XiXZbvzWpLnMMPA");
            address.setAddress2("faXbemiHptP5rFBv6LPO2rk7AvUXDvOIGZqPqN7BVjzZ7gklAP");
            address.setAddress3("3meCIxv0PtQwAyZdGQEt9JekN5lHaEhNw7dBlYN21Gr2QeIFjk");
            address.setAddressLabel("7nmfG3ssdbo");
            address.setLatitude("socMcx1UUGCOCx6ySKTUageSocmOriU877yMWw4UnrYLMqVe0E");
            address.setLongitude("b1OBvYiEFepNJUAYdMNsbi7dqOtR2XCFVPa51zDwBdkoHVUAsB");
            address.setVersionId(1);
            address.setZipcode("AG30W4");
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
