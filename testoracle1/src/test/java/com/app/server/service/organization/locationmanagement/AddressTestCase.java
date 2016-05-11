package com.app.server.service.organization.locationmanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.organization.locationmanagement.Address;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.app.server.service.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.springframework.mock.web.MockServletContext;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.server.pluggable.interfaces.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.locationmanagement.AddressType;
import com.app.server.repository.organization.locationmanagement.AddressTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase extends EntityTestCriteria {

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        MockServletContext mockServletContext = new MockServletContext("file:src/main/webapp");
        try {
            String _path = mockServletContext.getRealPath("/WEB-INF/conf/");
            LogManagerFactory.createLogManager(_path, AppLoggerConstant.LOGGER_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
        runtimeLogInfoHelper.createRuntimeLogUserInfo("customer", "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
        runtimeLogInfoHelper.setRequestHeaderBean(new RequestHeaderBean(new RuntimeLogUserInfoBean("AAAA", "AAAA", request.getRemoteHost(), 0, 0, 0), "", methodCallStack.getRequestId()));
    }

    private Address createAddress(Boolean isSave) throws Exception {
        State state = new State();
        state.setStateCapital("0xBddFOqlMcViAY7zn5QIJgdV96CWD1zdrYa6c853cL3vjcpLE");
        state.setStateName("iz4lJcJCSIvxZxewZvjsVMXiCLsf4UttMMmyjUMlvuHlgkWMqd");
        state.setStateDescription("IB5GLZUE9hS9H8TSSlwT9BzkqjMiATVFJmJVMj8f6TkKsYFtyI");
        Country country = new Country();
        country.setCountryCode2("WzI");
        country.setCurrencySymbol("42b4ht6xauxaUfzUgWwTCg6zF3nF4QC0");
        country.setCountryName("tYGZ5512lZEY3oBPfBLfEZPzERnOLQEhLjsUjUDx6b2oLNpUrk");
        country.setCapitalLongitude(5);
        country.setIsoNumeric(859);
        country.setCurrencyName("IuKwLIsyRFgGsDs1im4NA6biiVJN3T1MZwUPopRL3KsaKy4eWE");
        country.setCountryCode1("zSl");
        country.setCurrencyCode("5oX");
        country.setCapitalLatitude(10);
        country.setCountryFlag("ndSJsgdA56j8fG7Ui9toAOSVc6LnI31hx3RcLF2HTVXFFyGwwP");
        country.setCapital("ilqQai7ODb7w0HQUYMU7Ai8USQauC0uF");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateCapital("T873sVLiIwzNcgurROQ5sBCJbIrgVYLffGYtc5kJI0m6rVWINN");
        state.setStateName("CtFBzMeHpqyKVHTX5zhjpCM7B86XBUQdDJGetLsFp7h5UmFyuM");
        state.setStateDescription("ElyPhrPuPxRm0cZDpfcgtu127myeQndxPVjF1wJxatksBZxRb1");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("i9Ry5isWrszRzCLMlo7xNxRB3Mc6k1zo");
        state.setStateCodeChar2("gcMRxo0yCx3Ai6Tuz0Ff0dE6YlDWrUpp");
        state.setStateCapitalLatitude(2);
        state.setStateId("5ilBpRhgAs93t8mtjCCfrThjh50M52aaUJKAZozUob3rr3VU0d");
        state.setStateFlag("aBbaSTBe6WTR13uEiXoFb4iK6qYPBzUplz7HwKVUbtoULBE56w");
        state.setStateCapitalLongitude(8);
        state.setStateCode(1);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityLatitude(8);
        city.setCityCode(1);
        city.setCityName("zIPelbGaVKyTGOLXFeTSWoeS00G5YENftUYEWeIHzvmqQ0kSf6");
        city.setCityLatitude(4);
        city.setCityCode(1);
        city.setCityName("1RmxpIhhPPA7ytsCMi63QDyMeJBB7MyqQAVGcfekpgp4FwDI5G");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityId("bAWxmUH6OjMec1JsSUy3lRIJ07J495ArJi22ISLOvt98Cy7rXP");
        city.setCityCodeChar2("lLURvKWlTAZmwT5Po13QZXCRekphDLAf");
        city.setCityFlag("7TsPr3ug70Nw9ekQe1pTX7E5FjrlwYYjIKB3KSU2JNh7aAGfwi");
        city.setCityLongitude(8);
        city.setCityDescription("Zy4TMRVPaSzQ9rSdgo6Q8WFquUZhf6MpYlwWyi5dmBx57d8JKz");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("YOYJsGUNs040a6gVppabnopf6S3kbvw9MorXzlmZNbgwQtgvSr");
        addresstype.setAddressTypeIcon("U0F3lXh1BJQ8ClsEhGQaFPSMpWtyIrfT03r6TRXq6hegQ06yFp");
        addresstype.setAddressType("9owSaMdDB092GtNcuYUB7JmUFb1K1Y5vsmS6b2QOo0tMLQ3Syl");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        Address address = new Address();
        address.setAddress3("QB8knERLv3qWw05qNHpofqQnOsHPeI2DLcxTEEozDQba9tJcOk");
        address.setAddress2("TpLIWmWxhP5zpanpxdmggeiYvpIDQEAhTw0gRn54cY0k8jRoqI");
        address.setLongitude("99R4qWkZBkDMN1bvx5TRiYYARR7Nhcx1WuenC3vxweGxNVYRIe");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("p1awd4WUX3seCHJALf0r6w7WYmCNpJibIXaKJvGTgdeKJkyNc6");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("CTx6uYLeOh4hUoKrQY6XBTZfzTtyHUp2woS04VwHeMHeS5fJHW");
        address.setAddressId("YjWqBjlZ2sZTsoGubZg6RMghWCiwM3GWtIyNZ7cjy3o3KiNqat");
        address.setZipcode("wtlods");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey());
        address.setAddressLabel("enWVp4WGmd4");
        address.setEntityValidator(entityValidator);
        return address;
    }

    @Test
    public void test1Save() {
        try {
            Address address = createAddress(true);
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress3("XI4D7aNZUufitZLsGvn1nmvUInKAqmXhBk3sPH82ERlIJnHx1P");
            address.setAddress2("NGGZyFiSPbvE8o799pcJVqEdmMicYWazSCPmSsSoDl4G8sXTZE");
            address.setLongitude("CHAvzqETxDF131DwSgFlc7euef4x1tMD2fRTVsVqA1SAyn5gj0");
            address.setAddress1("rJ4hcwabmdCIr2qmEcOrxllrRrSfV6DxcoWgAvIFWpS4PSUwNK");
            address.setLatitude("pIPbAOi8djcNDoteOapiaBuGTpUbve2Dq1PCNfzEJRNmucPcbq");
            address.setZipcode("JMm8Cy");
            address.setAddressLabel("bAdKqniPDbm");
            address.setVersionId(1);
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (java.lang.Exception e) {
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
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
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
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAddress(EntityTestCriteria contraints, Address address) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            address.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            address.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            address.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            addressRepository.save(address);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "8UunpTnZ4DMI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "Vs6o7xDNXQC9u2417mU13jaSDDXGPqFR1zXtRzVtJZZn9YH1dSlzrjPEj"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "pkH1JdVcitccw7eFDuetIqqlRYNWNu3AiWrRvtIvfZ4CRmEuqkW1kE8mV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "sPzUnJWsCdZVthAgLqVBl3yMDYetgEn5WU5YlSJ9QSCcaxrEMWGVDevfi"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "bAPhMgT"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "w5jqUXjr3oJtAolGZRps9LCbfi44wuNGeNf3dQBaXC0I6UxGIqbqYWiHQCp6rKiO8"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "AryI1OrNX8S7zJkhYRaJfbno7bGankXapElQMUH62Xgq31YsEp08kNTzGwZuhOVCC"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Address address = createAddress(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = address.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        address.setAddressLabel(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 2:
                        address.setAddress1(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 3:
                        address.setAddress2(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 4:
                        address.setAddress3(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(address, null);
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 6:
                        address.setZipcode(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 7:
                        address.setLatitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 8:
                        address.setLongitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
