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
            addresstype.setAddressType("WiWzG3f5xpDRuaqt0yMh90wLKPiDzmbSYckYHVOKIuEqS71bMc");
            addresstype.setAddressTypeDesc("Tb3YRcoYUf2jCcwUZxSGfj5uud3uX6WwidG9QdS0dUvm7TSjZD");
            addresstype.setAddressTypeIcon("mmxh5KttkBBuaFgRD7Ds7eAy8m7SvbNxTv1D2xWnAeOSeMjlqo");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("bq9sz4qhM8ILEFRroLSCzRSdlKxmvKeQ");
            city.setCityDescription("HqJDsa3lx9WR6n7KTUsWe5IqDnQSzBrqAq03nY12i3Ewad9aIo");
            city.setCityFlag("6E2E49r8aP7A38diFPyx0YTjquYE96yfGOk28wWT9Iddz5AhCD");
            city.setCityLatitude(6);
            city.setCityLongitude(11);
            city.setCityName("QBWqhHigXJLiSzeo6ZQNwXkg3FUXOCE8Z9wxhIjZsgYXMmOb3Q");
            Country country = new Country();
            country.setCapital("DnybwWUq0rY8yPzZ4SYkGr9ZS5jWhR7v");
            country.setCapitalLatitude(2);
            country.setCapitalLongitude(10);
            country.setCountryCode1("suS");
            country.setCountryCode2("Va2");
            country.setCountryFlag("SLLOHkIx61THtp5mRxy0k0EFUaMFQ9vbjQN07tnBpODehmZ1cI");
            country.setCountryName("tNMSIxGLboxzksO0GwAIr8Ofo6Uj9LvIpu1au23HtrUrsA3gXO");
            country.setCurrencyCode("Yyv");
            country.setCurrencyName("WEh3kkkvtTqoTa4K6RCcPg4xlzzyisKMJHRhe03qh46KvfmC84");
            country.setCurrencySymbol("9onYZHUc41QC9xkxm6ogZ167x15UG10Y");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("oG9R6Tn9SEoyNDSIFx3ejUJj259s6VXBqet3sZhnyKkDSvbobl");
            state.setStateCapitalLatitude(0);
            state.setStateCapitalLongitude(11);
            state.setStateCode(2);
            state.setStateCodeChar2("Scx0kg4IHmQri1Rw7WqhuBxQqfi1Qp9e");
            state.setStateCodeChar3("pMAXGbaNoH6olAwEAZcOf6awEUAWfnym");
            state.setStateDescription("KP0bbBNUekUy7IMYpU5IxYVQuMPZZwoGW23Rji4fviTYC5E0yO");
            state.setStateFlag("TSgLN44m1sLLwOXNtoY7KlIqFZKTFDVFMOha3c6Mn1fSiVHw1o");
            state.setStateName("mrOoCSNWMNC55DuJ24WFRGjHc7CJLNnOTADKrMkSHJqO8Z9I7U");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("u8igU1fU7fGpijdZPJ7HmIa7hWzi6LNJ");
            city.setCityDescription("OGnDXobcP7dp69YjJZv8smt7xRpc8wJeTLqPe3Db9wEYv9qO2P");
            city.setCityFlag("bCsecnKjd5oVZPT0sGo7GnCZZf6eOV8SON8HFRatx4WMY4meH8");
            city.setCityLatitude(1);
            city.setCityLongitude(9);
            city.setCityName("GqQwAMhzDnoUv83ObQmR7TZdUEDP15cMUr5ardnIb4MpQcuU08");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("ik6iWRK9EVLNXYuzHUIfpMl7aY1b7bvjoAkWWPjSTf87rcXF8S");
            address.setAddress2("LRumwQNBuoZi0rRP1pYenrfLKKHuAfPi02Bk2P5mDY4Lehg5c3");
            address.setAddress3("p6CPySfKfbey5IKvOk7q7dlfAQXiqX2smnyTCvADIE3wYnB0Hm");
            address.setAddressLabel("JKBUH7hYcDq");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("GRrxsM417maOyhCtk3HJIMkbtAEAPd7LqUExgNNhBIMCK8I92D");
            address.setLongitude("nSC4VKytFX0D7rQ09jK7yjsWdnFOYGUg1Vjpg5rCh7sjSbrPtn");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("mM6m3i");
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
            address.setAddress1("e5p26TgItB1d8EXXgXLMC5auI1UR5hfNZfO8e7ZSMDOoW4YYM2");
            address.setAddress2("F7Tw2rojqqKVxaNRFbtTDc7IuONW9vhQuJoH2QWfeDcDeiA8wK");
            address.setAddress3("JBtu4yjI5rmQtpWPmUThe6uNl3rfQ6yyEDd6hbdbsYYGCiFPOH");
            address.setAddressLabel("60WAoZCvzWk");
            address.setLatitude("fbwAPEK5jQcPZZR8QwkgAdkHO4ndaCvXNJdKahHG7Y4gcijQNd");
            address.setLongitude("pE5tfEwPZMBxSHuZ1mO5FjfNyYm8QwkL1pbM7buLT5B49YtnjI");
            address.setVersionId(1);
            address.setZipcode("TzOZJs");
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
