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
            addresstype.setAddressType("UEHQtti1dMSeWmg8PnPn4jxEoh0Xt98wnVEqrZocF49wQV7BVn");
            addresstype.setAddressTypeDesc("KGT2DJlPlklDfVdXOb54uOA46kGu5XlTNnimwKom2KMiRxtyEs");
            addresstype.setAddressTypeIcon("1VlX1F3rEQ1QaZQzBAYrgAvUgPIcKx1lJCP9GnDumKdoAqYbMt");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("L0Op2NicQdVtGfsxxnDbNTxdZkBtcOZD");
            city.setCityDescription("OSLQUvorq0NmGlCEN6VSYJdUiCrfAvb3nLNQuESPMuwtb2JF3Q");
            city.setCityFlag("xQdcA3spoQaauHC0V3BFgKaRFIrbNaFIpxIFJqDGtIcqwx2Nw8");
            city.setCityLatitude(0);
            city.setCityLongitude(3);
            city.setCityName("ISeUImbFVx8CVFXu0HNOwjQKOhJyP2R8BNB16fOJUpYh0DpYbL");
            Country country = new Country();
            country.setCapital("OmEfxq2Nc27tAhtZCraBMYSxpPUEjyda");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(2);
            country.setCountryCode1("IYQ");
            country.setCountryCode2("DYQ");
            country.setCountryFlag("666Aryip4yDUu86DqFVvhMZzvGOKDqEQ4iXFrAWi15j4fc3l3P");
            country.setCountryName("X986PWuI541uYa264yykmfIiG4h9QgeRCgr8TwNfGprbiG9Pfs");
            country.setCurrencyCode("C49");
            country.setCurrencyName("4GRxp5Ley0TJPrtTWhqOx1ucWZvbauEbO6EXJjFeCRogn6mfmv");
            country.setCurrencySymbol("bre6LvPd4Vyqw6g5MVmgMgZ0580ABulT");
            country.setIsoNumeric(1);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("8MH1QtrY51egnduisiDFEib1PqrR48toMaSKAGDUtM5WasR7t0");
            state.setStateCapitalLatitude(5);
            state.setStateCapitalLongitude(8);
            state.setStateCode(0);
            state.setStateCodeChar2("MCNKdwCLYXcx8fmRVJQz7CUTM79ErF3b");
            state.setStateCodeChar3("MZOh2VSlAfDcbT74LjqcrjnuOfebiWeU");
            state.setStateDescription("LTzkEysg1xTJQvpKrzs5M6mMsTWRUoYQQqAGOIXMyjlaABUrf3");
            state.setStateFlag("dpcs86bOfRhV5oXoTR23HXJnc5PAdcG2WEYcCpMpDrxV9bzDaD");
            state.setStateName("8wjKetefz9nMmEnkfAUThnk9WF7nfdVECmzKQnXZEdyD6sizfF");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("Imip8xKAgOlSjVKzPnNGqHVMN3aJKTSE");
            city.setCityDescription("X8UXMJ0LhAoBu0aa0MJNGwh1CP0JTMcQg8pz7pj7VueqTHn1um");
            city.setCityFlag("WIUMwXHciQ4aNndKqpQIyYba0q3aRDfzfVxXqjUxuqz5gIjfiL");
            city.setCityLatitude(2);
            city.setCityLongitude(5);
            city.setCityName("brjGyZdbffwt8FRMU5GNmp7KWdIrSuOzV1Rsfgb8smduZwsftG");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("TZJWHgqO27uBD3Uue4L5jkLUovy94pUZE4FW5qWx1Mz8I4dR0g");
            address.setAddress2("01ddSkDXe6d6Lp62wajGjdxBkwZCrwllZ1atUXyPEdyJfWrMQr");
            address.setAddress3("CmaUI7bTHedhFMs6vZSPY0ccK8vh7pjTj4eGd0YZpugGy5Htjb");
            address.setAddressLabel("DXNkrGm0L5A");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("OXoA87cz5lkqUP2f37XgM66h8GJaycGQbMGNTvzowkbMP4KCnM");
            address.setLongitude("TMvO3NRMk7hEkaemNEzAl7JkfeixgvVNTZZa0m7sT6DEritkmp");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("qj8a6X");
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
            address.setAddress1("pYLbw4RlMB67tjEhvFrGJCHdz5A5YuQIe0YciEgRIMoRVnP5Z2");
            address.setAddress2("ewilq7H2hJXpxN5J4M4SniLx2oiRvmOEg846Nl8lb8GnIYHfNR");
            address.setAddress3("cGHLkUXf4X09CnFRd4raNFH9TMCNRznquEIq9VTwuMeT8hFGg6");
            address.setAddressLabel("muns5vVus83");
            address.setLatitude("DteiEYxYgMnORN72wt423QKJczCUubzIx6I6IO761JehPZ7Xgs");
            address.setLongitude("E5f87q0Q0FwvKWR8oJOy0jzcTq9yKSVcCCFLMTudyE7IpysbH3");
            address.setVersionId(1);
            address.setZipcode("bdkciH");
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
