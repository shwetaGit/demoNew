package testone.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import testone.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import testone.app.server.repository.AddressRepository;
import testone.app.shared.location.Address;
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
import testone.app.shared.location.AddressType;
import testone.app.server.repository.AddressTypeRepository;
import testone.app.shared.location.City;
import testone.app.server.repository.CityRepository;
import testone.app.shared.location.Country;
import testone.app.server.repository.CountryRepository;
import testone.app.shared.location.State;
import testone.app.server.repository.StateRepository;

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
            addresstype.setAddressType("7HDrsXCH7Lj1uUhBxpTsvaq3JkocgWenrxefz7ubN3F0wiii9b");
            addresstype.setAddressTypeDesc("vcPAZ0Kr4R4d0Uar5KtL0AUZSNWAKhfQx3uwmvjmAhpFDT0oCd");
            addresstype.setAddressTypeIcon("nRHlbaMqDybTF9uCBqqvGLm7bfJt0ChmSoKO5T5AjEdYW1XBcm");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("T4xkmnMdJNONZssjpjjAmtyh3XkjPstc");
            city.setCityDescription("wda6b2LdoN2ca9kS7XqRnNDQ3CwTlhOCtTy4NErIiiyLDTsfz9");
            city.setCityFlag("gio0SOlcGFYq5ZV7Zk2aoLu2RgsKaFiyEUw8mLhq11RW7RHYdg");
            city.setCityLatitude(3);
            city.setCityLongitude(1);
            city.setCityName("pgENPATMzZ7hDAEyvcaXuPeL1pMdw1kKwxPYqMB4fPkhYE6WHE");
            Country country = new Country();
            country.setCapital("MhV4kP7FVeuN5jNe5DhKDD4QNYkbGrYF");
            country.setCapitalLatitude(3);
            country.setCapitalLongitude(8);
            country.setCountryCode1("2wM");
            country.setCountryCode2("f5R");
            country.setCountryFlag("0OX47bBB2PkTbkAE6iljJlQ941xw3jT1L6CYXHaQptWuN9T0zo");
            country.setCountryName("snslwiDRFsl4OiisJpt0lc4CxLpQdb5JM1s5s94UyoD52vJoNG");
            country.setCurrencyCode("Yjx");
            country.setCurrencyName("6irowYB66OqxlEA16DjTEe7rJ0poth0UQYLtIWMsup9wRzTaca");
            country.setCurrencySymbol("FGLY6UCDncSE8bPfkO14hLCNEtV2KWvM");
            country.setIsoNumeric(3);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("wLZiSuFHiaP2MVcAgwJrW43Evf3VUDkAxlnXcgsqpnMmSzYDyB");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(9);
            state.setStateCode(1);
            state.setStateCodeChar2("45zYMFJadxTzoy6qr2vSAnfDMXexmxnD");
            state.setStateCodeChar3("oxlqYmvEdOt98VhHryjpT786SaRlVqcP");
            state.setStateDescription("VAdKGBZ0sACPSbbKdl98ABaMS1aNoOQ3thj3ljoIjSYLLlzr3Y");
            state.setStateFlag("6dbDiPZrtWqK0ZqjHe6wYsQpJnWX51ghutA1gPOYTOS6EUAiER");
            state.setStateName("AYdSyJLRoYJ5ks1Fypt05KLPeXbmVnHNVr2cDZ4fW12I0ZShJf");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("5Z56dhNRFuGb6Re7wwxdMwct1OTof4XJ");
            city.setCityDescription("l6LCw5LmRcqHw4PEQkHlBakAlcBYbaNRvzASpsTXJ3xYqHd0HC");
            city.setCityFlag("fhyTj2BAVtLZxICsXm8SbGwO5rvY8avJLN8VVzkn8zMO3hDPlT");
            city.setCityLatitude(9);
            city.setCityLongitude(3);
            city.setCityName("WDyDk6dxQ6ia9SOu7vbnzBvuQbaeD5IPjULgyUcymkyjzdzNZy");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("16FXuBtX70CEKPEbNPmuovnGM9mnvfkEuwYjzvzDgTTtY2uDyL");
            address.setAddress2("fAnicGCRc0VKYZt31rMM0mBCQj8n9M1jkuOdoDd7i5JaGnYpsj");
            address.setAddress3("Pc2xa7KDYhUEIhcJcdFPeCCyDuqHTzGMc9USZCpn5ljmJkjjTW");
            address.setAddressLabel("ak6jyGiyDat");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("BtHrvgdGjFjzlv3d11UeSv3yO7sgMmRXGOeVjSj74B3161fMTe");
            address.setLongitude("VZY1C3St02Nj5N94CBoAf8cvH82sFCmhfp2box89XzuyUcaNql");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("fZzqgt");
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
            address.setAddress1("ItKh4EWWoVJTuPmjjcFYweyRGzYVmp3NgVFfRQglCTmR3nj9D6");
            address.setAddress2("r8vzCYP5ecGrrs06lOsgxu12JdWerObvBhuzQ0lUTl2EjGeBDk");
            address.setAddress3("AvLCFd6bY6jxmClBfaglGoqZ8U5MkNnNDDuRiNyhImhcQPrSuX");
            address.setAddressLabel("kHcicJPTXCc");
            address.setLatitude("InOsVhTwzUW8irCRkUI2cb7PlhEAv6A2V5vGy8lpBoOFztCNrj");
            address.setLongitude("wpLKuyUg8wB0YAjnSIsKDDEjn3Cf7wmaKAYZ2VQ96OX4kUNHQh");
            address.setVersionId(1);
            address.setZipcode("PlEUlq");
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
