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
            addresstype.setAddressType("Eg87HwTYeUAK59f7d2kFFZjPq33hqqSD7RzxXskkbeCNZh2H4u");
            addresstype.setAddressTypeDesc("hDG5WpziFvLj67lls293q8Kuydc2HG7r66ogASsRl752MTXS7S");
            addresstype.setAddressTypeIcon("w8MO429wc1kchnlaWlGnrzvzAc2mjExRwmL6P8dWFDs5pOKn5s");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("bKUghRgMChiOTfOvxt2jwupnwglkccBN");
            city.setCityDescription("TdoDaOHfpGpoWPcQoQKfu2T1OWsW1XWemjNs1OVqoYp9ngMjpT");
            city.setCityFlag("UMnYBcD1emX4ghFhiZKrWmlYDes9Iilp1SDWqjmwYQnGHD9Cfd");
            city.setCityLatitude(11);
            city.setCityLongitude(7);
            city.setCityName("tIcQENu9TRkpaBG5pA87rcoGyhdwRilS7hPQOz5WnBoGE0aYfF");
            Country country = new Country();
            country.setCapital("aIHt26bfOuwgTHYiVT4to03I9WhK5XMM");
            country.setCapitalLatitude(4);
            country.setCapitalLongitude(3);
            country.setCountryCode1("iqQ");
            country.setCountryCode2("D53");
            country.setCountryFlag("ONPYZR4w2fw0RiL9fIeD4bbQ5tmKs3uIoAfs0QeQJWuVw4AVYS");
            country.setCountryName("C59VfWsa78MyaWl0HEbYUr4p5gNvwGCixA4qLQGf5ebRTWi26o");
            country.setCurrencyCode("qKg");
            country.setCurrencyName("qj2tIQaiQ8S721Uwh2wcL1nceYk6qnIVkeyMrJAoHw3fJcwHaB");
            country.setCurrencySymbol("eZb0mM1yQPxIbH0Kp55DeM0hz0QTFNtY");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("bW84p187OypFqKVzpv8wFCWLgo2rjX82hBxXznhaMDERKSzwQY");
            state.setStateCapitalLatitude(10);
            state.setStateCapitalLongitude(8);
            state.setStateCode(0);
            state.setStateCodeChar2("n8N4a19VnJ8N9YeSKJfrFUY45dWFbCAm");
            state.setStateCodeChar3("eDjS2bGy0z839jQDt2gc5UJy2NnLaPLy");
            state.setStateDescription("5UEdFOvBG603cAkGpNXsb91YBWiQuUlu97r4oWsj2hvaAd4RMb");
            state.setStateFlag("oi8ha03v7c4Xj0EATXQu9OeUlfEfmpCaepJ9W2wmBN17Ho0fbM");
            state.setStateName("7jaagiiJX2AxRhefmTLyS25Y3J30mgyEHWb24FzkEpAK6LhIOW");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("BfwK7iQ70jNUsbgwQvMtKQygYIKTlhBI");
            city.setCityDescription("B1ukStBzOdL1XvK5bG3ggXYPb9J4QM8NzysBerP0dvMZpIyv5j");
            city.setCityFlag("XCBv6mtQLUFf8AFNSQugXREulxv2ZABTqyO8wrjCpHDil1wRB9");
            city.setCityLatitude(7);
            city.setCityLongitude(10);
            city.setCityName("TySOZqQY0CD8BMbtN4yl9AeQ6kiiJ3CnsJK2ZkNTram2gshJP3");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("knKS3uRM8YVi0rN5FX1zfIhJy4GY47abBhM9xS8AOTCnpUpOlh");
            address.setAddress2("HEPGEDULAyL4B1CgYnKQQ8orGDXG4s18Rm6C3vlNWvNVJP4CKu");
            address.setAddress3("1BGz3vIkGZjYlrDmrNjc0fL2KDZsaGOFqbP7jp82hXX8ht1WkN");
            address.setAddressLabel("OBo6dyLY5jb");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("cxKPZVtooQyGEEKwCzXdUqIMvfOU8bwmLUSjKxibquedGXYkIt");
            address.setLongitude("giqHHUalYVtfEqwJOW8hQMN4b8rJjn8eWoyvLzPsOOBGlzd4rC");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("kxyhDU");
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
            address.setAddress1("ZMnGTJB5ZPKAXKBhX3rSc4UmjVibbbggM9N9ZkpEWpXZdDH86x");
            address.setAddress2("WW6rd66FyAPU8eckQHRLxjEAiwDxhF749jhcN0rc3hjSJbsodw");
            address.setAddress3("r651N4GGrNmPqvdlKsQWKiT8wW6F3VNayTHpj1Em4K3IH4ipOq");
            address.setAddressLabel("qyBdLwrO18G");
            address.setLatitude("Zr6ZZt7kPFs9HgJibv85dL9sdVwylGnJS2r9gvbm0ybl73weGr");
            address.setLongitude("W4UFuxylWizLf3KKirrLjkK97K1uvVNIIqXjpz3Y8uCSwfGSx1");
            address.setVersionId(1);
            address.setZipcode("fguUM9");
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
