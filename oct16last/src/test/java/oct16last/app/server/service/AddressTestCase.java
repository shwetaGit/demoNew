package oct16last.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import oct16last.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import oct16last.app.server.repository.AddressRepository;
import oct16last.app.shared.location.Address;
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
import oct16last.app.shared.location.AddressType;
import oct16last.app.server.repository.AddressTypeRepository;
import oct16last.app.shared.location.City;
import oct16last.app.server.repository.CityRepository;
import oct16last.app.shared.location.Country;
import oct16last.app.server.repository.CountryRepository;
import oct16last.app.shared.location.State;
import oct16last.app.server.repository.StateRepository;

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
            addresstype.setAddressType("kLkrc1nf2zNrLqfiop3NSWStuC4VZjVeM6mkhphI0x0HOJhXIE");
            addresstype.setAddressTypeDesc("Cqdg16Y4r8ZqzTEkvhP6FBWY6LqQ7yeQStImFt7nA4kVM8S9Ge");
            addresstype.setAddressTypeIcon("iB5rR34mfORer9OwIvdSy5qyOuQxMyAm9WCssDVGBZAmcIIEG8");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("HzP2HoAt3px0osjzgNY8ynIjqBt59ltc");
            city.setCityDescription("Y9mOc2iId8DHtAqHGZ9CUNQXvEFwhX33iiMMm6uvY71kqliGBE");
            city.setCityFlag("dNQsWuHwW5n6JN6FsaEa1RYOCWUu82lHNm970lE2ETZmPA21n4");
            city.setCityLatitude(4);
            city.setCityLongitude(8);
            city.setCityName("nWQet7ueAjgB5mEDtFr9E6HtSjpgm8vvkj9ATzIaGLuYkVY6lA");
            Country country = new Country();
            country.setCapital("9qL15vOYCWR3BHdHCxgaiQT658w9Ix8L");
            country.setCapitalLatitude(5);
            country.setCapitalLongitude(4);
            country.setCountryCode1("NkQ");
            country.setCountryCode2("kej");
            country.setCountryFlag("PwfWhOKbWKBznPcrHORdgKS0APvxy5PQu4216irTTvSyOwLhVZ");
            country.setCountryName("7Ntu4Kta2zYgZOgDCJsaJn8kXAGsz5IYT2XTSYL2hiDUwAFYiP");
            country.setCurrencyCode("Hur");
            country.setCurrencyName("Kz9Xjj7hqUgSLQRfQi31UKIpfT3XPS4FHnIOLeQIWv9mzKeyRE");
            country.setCurrencySymbol("WDkgWgqmuelrCy53YhL53y0QAw15iL6i");
            country.setIsoNumeric(4);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("umYmvvir8r1vXfRbYI7KeUvKI5kvAyM3iDIzuXlPNchdTA1K2U");
            state.setStateCapitalLatitude(2);
            state.setStateCapitalLongitude(4);
            state.setStateCode(1);
            state.setStateCodeChar2("xwBHShUoy48PAOfENN06yjr8ayEXaff6");
            state.setStateCodeChar3("8wAJGOUZucFmp2RLOR9J0QU2yLnBnOVv");
            state.setStateDescription("aywdVSZAUVjs4Dvxlqlo0iImLDc1TDRIdmwiEXyaGmqoti6mBh");
            state.setStateFlag("w1jzDJBRdFZhWwNTUQibhMS7bEJ5Ynm0HqJrXpGczKLnqiEDO7");
            state.setStateName("8jT04WeWltRdTlqR1fGUjb6Hcva3wpmwP0nopCZmXR8OQ0r4vE");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("T5JfLSfmUquvI6S36AooU298V8czAWhd");
            city.setCityDescription("QmpiwUNfW5aE3QEUtWsXjkj32uNf0WO3baOdWY1A81c9NvNfhD");
            city.setCityFlag("l0yNF4pWJn6fcwo5pprFUFeQGkwkgpVtLpZVZhQZAg0fKJkA4z");
            city.setCityLatitude(8);
            city.setCityLongitude(4);
            city.setCityName("9fpwS8iDEiGAPoqkciuhAMbBKHocjEiaNu60LZIp6ve198xswf");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("eXQUj7YVdpE5yLOlNZbllMwKRENnwjDiaNmOkgkvjOzJUzII08");
            address.setAddress2("v4w0PlCse9rLdUnaDK9iSrtdwevok4vZpVuair9jmEctn8QCEz");
            address.setAddress3("I8G73QRWXOV8jAXhkWwyx99EmsfPIjIIcYcZuE9eH9LijeMnKa");
            address.setAddressLabel("4c009ARqTK0");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("A5wkSu1cd4tTEK2kp9JkMnobTxeVLodD7D5IiAHZENwVr7Oi0o");
            address.setLongitude("sa9lUCWYgjgNjo1tOhMsVSKNHWTKxdDwcSLAvKvwY21uHhMrJf");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("8Cntrk");
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
            address.setAddress1("4AHmvjExPFl5XJo6URalIkQV8nWhUTbx9SHZiUcAsBPuufV57W");
            address.setAddress2("yIwhT3iON1ppJCCr3yvhIPNo7I5SMgaj8kwiFhZ0DCPZKGGpdT");
            address.setAddress3("SRE9mpplGyp7jFbvbyh8xJ8atW7jhuXLUKzodPrRmkJSfk341l");
            address.setAddressLabel("gTaM3XejhSL");
            address.setLatitude("Wt02uOZucgKIZSY6xUk5CED8jUTLmo5AQnDVOoDy0ciJ8A1zPf");
            address.setLongitude("XO4m7QW9sspvjHbgqI9mbZSNPAl27OPmvH9eKQQdY8zL7Gn3bo");
            address.setVersionId(1);
            address.setZipcode("iOEWW8");
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
