package com.basehr.app.server.service.organizationboundedcontext.location;
import com.basehr.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.basehr.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.basehr.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.basehr.app.shared.organizationboundedcontext.location.Address;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.basehr.app.server.service.RandomValueGenerator;
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
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.basehr.app.shared.organizationboundedcontext.location.AddressType;
import com.basehr.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.basehr.app.shared.organizationboundedcontext.location.City;
import com.basehr.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.basehr.app.shared.organizationboundedcontext.location.State;
import com.basehr.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.basehr.app.shared.organizationboundedcontext.location.Country;
import com.basehr.app.server.repository.organizationboundedcontext.location.CountryRepository;

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
            String logManagerId = LogManagerFactory.createMultiLogManager(_path + "/");
            LogManager Log = LogManagerFactory.getInstance(logManagerId);
            System.setProperty("LOGGER_ID", logManagerId);
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
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("JCjAP6jYuVOorzxDtKKLESRFpDxzGRfMfipfRvnCntzdS2pgvT");
        addresstype.setAddressType("sMoI0Hj4MRWvBkz4QTd0poKYIs9NiGszurt8eZfO4Sc2qjMQf2");
        addresstype.setAddressTypeDesc("91GvSK9RxxUX6gXm0jHTzr3C3Nmo1TrvrXkC8DGdqDWejudLz4");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityFlag("r67ZJ01d8HSHYz0v7ZD2jT2kmGVxiZaVNJKhBxWRlO4dzBWRgK");
        city.setCityCode(1);
        city.setCityLatitude(8);
        city.setCityLongitude(6);
        State state = new State();
        Country country = new Country();
        country.setCurrencySymbol("Qe4oRzEfrXclvhOKjdf25QmdMRp4xlT6");
        country.setIsoNumeric(87);
        country.setCountryCode1("akd");
        country.setCapital("UxI7euubk052q781wsNcjO37mVgr1qEu");
        country.setCountryName("mCOfHfVIAlxTycxVFjn2FaFQu1zrSCpn6m6MjIMJKl8i3YYAU2");
        country.setCountryFlag("rVwH2GgJkgDO3HexE5aDVKe7I6y3UgbfuYH5uIyGJ2Dp4618Zh");
        country.setCurrencyCode("nfg");
        country.setCapitalLongitude(8);
        country.setCountryCode2("otX");
        country.setCapitalLatitude(11);
        country.setCurrencyName("QAmZ49rTaDRVVwUtpgmBmSv7Kgsok6oEbNyf4M018mHVbhDN53");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLatitude(2);
        state.setStateCodeChar2("t1s8NzJRTKsd5PFBfl6B15HEKV0puBSV");
        state.setStateCode(2);
        state.setStateCapitalLongitude(4);
        state.setStateName("mJ7Muer1HcKjutT4w75kKBRloUAkf3aPgZTO88GPGJEGT7bh3p");
        state.setStateFlag("HodrSdyS0gwYTGuEkXiW356PauWWX2L5JP8AVkE0mF6zCTfUtx");
        state.setStateCodeChar3("BKY40pdOJyUtSG75LdlEVJcygr2usLhC");
        state.setStateCapital("T9mdzROPCq3sLaTSCq2TVAFxaBHSEBQ9UH8C6iFGG0aG2LqL77");
        state.setStateDescription("HtFMnXCzZQCcgopTasYg7LWWeIcjSesn9SVDAqsceSkkBdxCxK");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityFlag("lgsE1yA7leHNbRZzuN8DnvlZ9xAND6EL9PM8XHUO18Jtq3mX80");
        city.setCityCode(1);
        city.setCityLatitude(10);
        city.setCityLongitude(3);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("ROOOYG8zAJkjt6E0VYuadNYjghuZak1GM9aRH9GZDFP1w5QzEf");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("ZiZ1zhdgye6eQ99nkbPU9bhqPqXD2Hae");
        city.setCityName("P2nL6blB3OfD1ctkOYxgVWWtcEcOrUjxm8VrzAMmPZ6O1DBbXy");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        Address address = new Address();
        address.setLongitude("VcWMIn5Uy3EaaXnsKREQ1e8pvAbCODQVp3EeVw70WqVjkuocMD");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("4EHN0xUQ5eVDlRemUtVnmvXzQcGsfMGUzKX2CaHTbh3lEnDA3a");
        address.setAddress1("nGrJbaDlHLiJs5CPiycqdtNbixwDJVbDigyeMc0jqd8cSozcdX");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("b6mq5jaMwPJwCBhukcpjh5T2QWlXw1DUcfI4tbu4pb9Pe6NXqn");
        address.setLatitude("BT6EFdJb7xO4WYK6zptvpGQHTlvqV7hdFMCcnU2WbpGNr4fDN7");
        address.setZipcode("4237hG");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        address.setAddressLabel("JrvbiY19OwK");
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
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setLongitude("704bR4wXSVqLhTTac2DR9Nmv57REKDuBNPjAWJbKe6VGvaQDbm");
            address.setVersionId(1);
            address.setAddress2("iOfT2XnMkukIkduuGTfnFARmoMgpyWpa4Mi9A74GsnuRqsGnV0");
            address.setAddress1("WgDWY2qnD6y0HXC7pxUqQtJbzLkFWpMvg6Ll8M1ZalvGz5mhnd");
            address.setAddress3("1Oa1uGKp1BORVUtAhOnTrYcrQyF7KK4Xky69M4Aj8BMpwpmn0Q");
            address.setLatitude("nbCecACxzLPaNUsChxWzLH2AYVqgCvJQ7u1opOp8Bv7Ng2SNXM");
            address.setZipcode("AE2sb2");
            address.setAddressLabel("gcHdSgRPZFn");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (java.lang.Exception e) {
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
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
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "m2dfGOYVDrAA"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "H7g4peXwzRaeW93UerHxzRyptLydAYDKnkrvLevawLZN5P51CdSvztlQD"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "oaj0df3kATRkPeHsoSusF6n3VWr9PgdLQgHGnggXTsQRMYumgbaPEFieH"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "8Xtub4WeofTupMLwHhOn26S3glb9tPbjoPsP9sH0dI7hN0jrbOGDFbdZn"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "LUrSHbk"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "m2NRDWD9wxrfk62Ypn25jcNtgq5WNl4OVn4hC2EETWbjx35dWiESSwStrLcnyRVn8"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "hz3kh8RIUfyTgjoGVmlmn7Xts0HxEpC9sI0tgySOCpCknkH39gQHkw9ydJ9WJNuWm"));
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
