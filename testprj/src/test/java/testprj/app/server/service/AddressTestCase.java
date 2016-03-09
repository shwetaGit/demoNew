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
            addresstype.setAddressType("sGXsO7eIKjQAWfgvoa1KweDUPWgr77Pmfnin0bykTClECsHjUw");
            addresstype.setAddressTypeDesc("2pCq4eDE0mXGxovNTYiwvHKOPUWuHwtaoEXXPI0aoMMiYHEcPG");
            addresstype.setAddressTypeIcon("vHR1e9A8JK2KMmdd4rqihRdaOrKHnGAjxDIZv28lVoq80qGEiJ");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("PJCLkIjePdJlZZXzO6Fhya17dykaOD9B");
            city.setCityDescription("wSvRoEA6pekeA94gK2HTYX6ZTOCACc01ettnkHImSQ0BMQXbuH");
            city.setCityFlag("5r7eiNm4s9Fa2qD5wEAwk37BVfdYInKkJT26gVlYUjLWD0XyQV");
            city.setCityLatitude(6);
            city.setCityLongitude(2);
            city.setCityName("rMndmIZ6jw8BAb3jAihIEeTNnbc6igoek7beuQjZfHjWwZvxc2");
            Country country = new Country();
            country.setCapital("jpOqpMLyOYcvzgcTZvdYwR9ETt2ef4gQ");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(10);
            country.setCountryCode1("pHr");
            country.setCountryCode2("1f7");
            country.setCountryFlag("p5hcSAHryHQShaGxwJHr9ac6tXI0XAQMZ6YDvTMcQagrLfZ1ic");
            country.setCountryName("st5RcsUA9IiW9AaUwuhfZBzsQoQ1nLdiK6VQQiKvrky4CzipoD");
            country.setCurrencyCode("5R0");
            country.setCurrencyName("EtxB7TxiZ77NEYWMfEIk33fCXjOESyNZhpGU9CTrnaS4PS4qm9");
            country.setCurrencySymbol("8BN9MTxdVfKhSbo9x47sc4Mq1QloLH1C");
            country.setIsoNumeric(10);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("HVqSoOZxPBmfOpfXnWtkqRpoHdcTqy4N67nzoCw2wgoohThSs5");
            state.setStateCapitalLatitude(0);
            state.setStateCapitalLongitude(1);
            state.setStateCode(2);
            state.setStateCodeChar2("xXuiIFQQw1y34W0QzIh9pFaSHtG8c4lf");
            state.setStateCodeChar3("8jyFpreiwh6f4g3ftl2VyQTTsanYmzop");
            state.setStateDescription("1k6S3tHg1A8KcxWhXnKFzDdmxayDSVzE5KlfBa337YNzcmQefb");
            state.setStateFlag("ddAQOBWCwmTeU0GmPXBHskAM7upF9hQZMBKHelCC8ZZbBae2Gy");
            state.setStateName("tUqZwjNsRQzPLeFzc9jNI53b8DcE4mZWpTjl3OLA2UgUp7Bx6Z");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("7pnFWgYDWbmyw521qBqF7kdZ0dgK2dAv");
            city.setCityDescription("drW5KGr2KIiDMekSNxP1RXu80Puk5PFoibZkTHvaSW6FuXTWw1");
            city.setCityFlag("ZG4Mm9lElyQnU736nRZnaa7G8yf3OHvF91ytCjRxJtFTioWFAK");
            city.setCityLatitude(2);
            city.setCityLongitude(8);
            city.setCityName("CqbvI1ET27rIEmn1SSR8mgGBY5UoId0ZYKZQHc0CGBxPIYpyyZ");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("9pCbmLOvSbWDhHEDdKin385mQKQo06oxqFUPzUgMQO67oyr0D9");
            address.setAddress2("tzNRm5dugO69ZleBE3vzgtJIZiYDkxU2LgFKCnBafYKt0VJjFW");
            address.setAddress3("N1EAso7ZlNCehFlA7IQ4OyzLjwpPhexdQXXzNneeWFkNkdniFr");
            address.setAddressLabel("TEqoUUptfxL");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("pRsWSh3Y7MNXD7qysFfCqC7XAxqLKbe55emOYYOmEWDqKZJGPU");
            address.setLongitude("jNuUbrvaWzxxaPRillSNT1FwYykH4HjdGp2nGOp8S3pcJ3q9mg");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("0ctRKp");
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
            address.setAddress1("1GGjFPoxStY9YhUb1jBGwnKB3qISbTVFZWU7dB8SJir8xI4Dhi");
            address.setAddress2("BFzKckHvDDL78z6SsnpJo3H7gOiVkbIR5HpYKF909bfbXaXxVx");
            address.setAddress3("9FSZUG8vQTShjxkoQNtsJYkqkm1bpK90FgqmASorpeFXJN1Be8");
            address.setAddressLabel("4QwZRXYCszC");
            address.setLatitude("i5KNQcuCGx4vyHGUNGEuLzW46Gkoo1iYwpRUhrABGE1Tt7jbux");
            address.setLongitude("9gC5rz6kQUCZb28Lr5SK2ZNlmuIRCd7VUjIHGdjOAoei5jLWGU");
            address.setVersionId(1);
            address.setZipcode("FlDIoo");
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
