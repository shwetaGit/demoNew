package oneee.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import oneee.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import oneee.app.server.repository.AddressRepository;
import oneee.app.shared.location.Address;
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
import oneee.app.shared.location.AddressType;
import oneee.app.server.repository.AddressTypeRepository;
import oneee.app.shared.location.City;
import oneee.app.server.repository.CityRepository;
import oneee.app.shared.location.Country;
import oneee.app.server.repository.CountryRepository;
import oneee.app.shared.location.State;
import oneee.app.server.repository.StateRepository;

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

    private static HashMap<String, Object> map = "new HashMap<String,Object>()";

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
            addresstype.setAddressType("W1ds9BpaVvAyEcr4w4WWs0aoFP0fUQ9n5fjoQSHDhGQ0lzGvmR");
            addresstype.setAddressTypeDesc("mVusFK81jOKpPaBMZ7NFVrnYRrt2Yf0644qTl19591FX4vPcqv");
            addresstype.setAddressTypeIcon("RK9dw2Ez3et0LjETr6QqGgHgWsMroag8PaLtB2xFZiMsOqQu8C");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("JyCLY2cLCkFthf3cQqh4SvTzWPW7yaH7");
            city.setCityDescription("yTjEFkLjzyEMoupvXhvOIzR0ZWwwtbkPKkRLDzQdtnxnaV58qV");
            city.setCityFlag("X4vwllpMj6epdcE0VVfH4k7GfZXEVsfSUrRy2ZpCnxlxKjMSaQ");
            city.setCityLatitude(10);
            city.setCityLongitude(4);
            city.setCityName("6SvqKgPQ3W5WRhsXRRGRQSHXKJSv2AJG1YPYEYw6pbJeH6qyUr");
            Country country = new Country();
            country.setCapital("PwQ0GO8uJLt5PgEowEW5zHhu3Us4nH4o");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(1);
            country.setCountryCode1("SVh");
            country.setCountryCode2("GKA");
            country.setCountryFlag("jtcMtbmz6IJVkLwx1UftA57MO046xrAW7zB5QoVcNPc3TZhAsY");
            country.setCountryName("bOVeZreIwL61vs9QzeGl2maDEE2Y0ALxAsFsSLPmK06LDE5KIG");
            country.setCurrencyCode("ORB");
            country.setCurrencyName("ogqp4RxiPEbChFDcE5UcsnMf4qbslDCEP4wdaru7UYKjPVShop");
            country.setCurrencySymbol("kb1HNiqI7T7FZjbTpXkE4L5EIimHu0Tc");
            country.setIsoNumeric(5);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("maPedi4CqgUDkWRJGQ4uCSUzLuk9dCol97j0rWzLIEpwHLIZ1K");
            state.setStateCapitalLatitude(5);
            state.setStateCapitalLongitude(7);
            state.setStateCode(2);
            state.setStateCodeChar2("beX4BSEnkrGYZdTQP1zshWuHaIFW8JGV");
            state.setStateCodeChar3("JMKVBOlb1dLsopebxlInAPoczDpb0kdc");
            state.setStateDescription("ORITBAcQ9fU0cQcbfkhKLXAjnZPjoqoofpIIWPJPezOBElZrav");
            state.setStateFlag("VdVxOMC820PSOpeMueAueFwNyujXgdKALKN6gaNiF5SBtxHQHw");
            state.setStateName("8WWQzhmSA7Lz12Y6nUHzCrRr4et72OauDW1lqRl9t8guYNaapJ");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("Wpkrb8a1uMDCLRRF0LR6F3Tn2RS0SmgB");
            city.setCityDescription("45Gwu2Uu8qAwIxcw8yKp34V95gcAFPlZ7gJhMQEY9lb3AyZRvk");
            city.setCityFlag("A8pz67Mrrq5BObjkHJecgNGwXRkiIWfBFtBFbzshaeqa4UrDgR");
            city.setCityLatitude(4);
            city.setCityLongitude(3);
            city.setCityName("NakaPUTcH0Re3kahBewybqw6lXtMBzP9mW1Rzv9hGgZz2t8dem");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("o3TptlIuXgmTIwkjXdiKk3g2OOg8SVoLMcrO105maF5bct5ddw");
            address.setAddress2("SCeFDZFoCwXoUoZbxZWgwcM7EonV8rzkpvZqt8wTnFJ9L9V8FY");
            address.setAddress3("kqVHA14IqgIaWSVivNl7ysUyjipRP8zsCw94FuFUFy2eLz4FDK");
            address.setAddressLabel("Zlpvreml3us");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("XGZ4Z6GHmpQQDFB01AHVsHia5TpO8afuCRucI6my49QJBMxJ0B");
            address.setLongitude("qGyUMyQOm91X6ZmoNfewzuucpcSpgDEtkm2HC6cnGX1FGgxy16");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("0vFGoA");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
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
            address.setAddress1("rZVIOTTqzQXWprz6HTI2OLCarfTp5IQxZXe8qNqzymbFifdCbV");
            address.setAddress2("nwoYh0los5062FCFrKtqJuRTzgdfkwdtOMniikKuuoAreKwTz6");
            address.setAddress3("rDApgdiCD24eLxqzkV1ff1vqWk04JTu5dlB7dR9hHtA0rpU89T");
            address.setAddressLabel("aRt4AdxI4wn");
            address.setLatitude("xcomy4aS01yLzo8lfiozlu7uj64mPfYMri1AMEzwGwHyHIrS9X");
            address.setLongitude("zpRKXUWi2HqLW5SPMm0pdAXt4zUeEkKUAMGATpnfNlTU3jP7Y7");
            address.setVersionId(1);
            address.setZipcode("zN6Ovq");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }
}
