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
            addresstype.setAddressType("MNb78uuURhKDcoEvL5zsaaul2jx1AyykUNGbdD9tTo4dNEhQ7Q");
            addresstype.setAddressTypeDesc("Y4l19dFeHxLCJVDPaUzarBqH4aYKSYfrIEAcK9aCn64TNaIxcb");
            addresstype.setAddressTypeIcon("4YSGpzz0ndNqxUqckzBPIZcICcXqtWNa94Joc6wSZyCxT2F8Xc");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("eQm50xbiTRr0Kjqht5T13Co78PC1hJGx");
            city.setCityDescription("OnXcNWHaInake1dh0IvEAfkppnkFWHHW7ckse9cgbhoTuELPBP");
            city.setCityFlag("iMi37zVkPEXUHysWOA7EyfiieMQIIsCOaxuEbCcG8quOG3My9X");
            city.setCityLatitude(6);
            city.setCityLongitude(10);
            city.setCityName("m59Bz7ueIovYxsiSA10jRsU11ACQvrOj6W7appc9yUqCIOH4gY");
            Country country = new Country();
            country.setCapital("SGFFzw33wvVTK2bVaLjKVWDsNZZQOIL5");
            country.setCapitalLatitude(5);
            country.setCapitalLongitude(1);
            country.setCountryCode1("HnO");
            country.setCountryCode2("xql");
            country.setCountryFlag("DbePIdTevnN3wgf7iC1Zf8IXrRbbRUDfqnqbyuuSIcsPSEUQq9");
            country.setCountryName("KEU827DjOmaFSjiVK8oVuzdMEqkUOohMk5lybaotQeiZkqSmsE");
            country.setCurrencyCode("YKA");
            country.setCurrencyName("qtoswedlAzLMQgQ4dm6LhXkQciKNTDivqpQRgDYErxOAJRoL5q");
            country.setCurrencySymbol("XWD610KXLwGoxVXYOUkdrRyD13RGXkY0");
            country.setIsoNumeric(9);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("QEPMbtdBEdrXV4OS2WY1i7fjONuHZpr5XhIFHpc9MyeaEgYH67");
            state.setStateCapitalLatitude(4);
            state.setStateCapitalLongitude(7);
            state.setStateCode(2);
            state.setStateCodeChar2("HNRdhyCYMuz9XWjVOiovJcf1h7IZF0Te");
            state.setStateCodeChar3("rPXpRndpqnf10UXrXOiHd3aPNcmxZ3jI");
            state.setStateDescription("aTnalrddiaxIT09C716SvPRvSeKn7lqOyPRECiMMi9QPvLoa4j");
            state.setStateFlag("nNfDNrWCP3vUCuEXB5VB2mzXY8hkfXNuWC4Uq4S0M8PJRioTim");
            state.setStateName("MfgW1JgbEygdT0UMZRLsEXVjBadui14IshgimDoC2WMXtukvU3");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("QSG7Oc3wvYg4RrMay654RwEyrwrvYdA1");
            city.setCityDescription("5Ykk2LlWxLPTbtI4mNTvqLEnKWe52VzkM8TffkRHSwO2UiURki");
            city.setCityFlag("dnlScFzq6T6HUQFF0z6fXdm9L8LEoPOvoU6yZgcUs0tvHXJMuH");
            city.setCityLatitude(6);
            city.setCityLongitude(5);
            city.setCityName("U6Mxd7k8Mipgzd5J0CNrPT9sfFANqxTrr0OVjYl37TIiv1t1Zg");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("bz0SrHN1uujWfNOKufrZyEabygNPvifxIFQH4m96SXyh0RD8EI");
            address.setAddress2("SK57w9MAT4yBGzTFBjZkJdNRA8h8Lr8es5eYktsXm9aEPqdEJ2");
            address.setAddress3("Qb8q5rSMgPuzVHNSbivojWziljCUotbN8xqoIgJWEmbdfNA5rj");
            address.setAddressLabel("CXw6OcPLbLW");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("3RHTdsMiaSt9yS6Hq9lKYiFaDm7H8vIOQEV1mCZevD9wjYyjQ3");
            address.setLongitude("26AGMZQ0LRFzGpohMNEdFNsdUGfkpumANoTRMXwzh9O0csADOq");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("2N0YR3");
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
            address.setAddress1("v2vcCNgLSy7L41stI4117ERSnmTuvaNNGsS2dnhiqtXu1rGht0");
            address.setAddress2("IQ6FNMUnJcBKq1xHz0f7pAJDGqTODcvsSx0GrGHLmbX5J2hFh5");
            address.setAddress3("N5ISz679qlZYYYvGL7kFXYIc1wWAuV5taZogVkS5TPUuGEEH10");
            address.setAddressLabel("8ZeiUSbvhKI");
            address.setLatitude("EWnqOnEFpchhk4Ato66OQAeSr1X96mWvAos7V2GfRF1P8ZmYjw");
            address.setLongitude("cRwCtCzNxBei0iSqU7DVfOkbSakgB11Ghebj4QMWSyprmIftCP");
            address.setVersionId(1);
            address.setZipcode("GQQk0O");
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
