package hrapp.app.server.service.organizationboundedcontext.location;
import hrapp.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import hrapp.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import hrapp.app.server.repository.organizationboundedcontext.location.AddressRepository;
import hrapp.app.shared.organizationboundedcontext.location.Address;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import hrapp.app.server.service.RandomValueGenerator;
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
import hrapp.app.shared.organizationboundedcontext.location.City;
import hrapp.app.server.repository.organizationboundedcontext.location.CityRepository;
import hrapp.app.shared.organizationboundedcontext.location.Country;
import hrapp.app.server.repository.organizationboundedcontext.location.CountryRepository;
import hrapp.app.shared.organizationboundedcontext.location.State;
import hrapp.app.server.repository.organizationboundedcontext.location.StateRepository;
import hrapp.app.shared.organizationboundedcontext.location.AddressType;
import hrapp.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;

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
        City city = new City();
        city.setCityName("6WwA1o6LzYuIu0ZiXxxh9CAYaDwpsnxBhytX2D7ctVdrYiZeAj");
        city.setCityLatitude(7);
        city.setCityCodeChar2("Y2eLILSHYMIzYcX9w9zEOqC9FgS7PH0i");
        Country country = new Country();
        country.setCapital("CZXiqDtWt543VLTYjS9O95OPSEDhatAk");
        country.setCountryCode2("9Pn");
        country.setCurrencyCode("duf");
        country.setIsoNumeric(728);
        country.setCountryFlag("6dWNiqNSseTZUz55lHObkAwJBnFUb2OrkMtBLCJKsNFU9bCKo9");
        country.setCountryName("cyjT7oxqH9zVI5AStmBBjpIuW8snS8MRVF69qgDdDRJA7jXfpl");
        country.setCapitalLatitude(4);
        country.setCurrencySymbol("ohKrjHwPfyXFZBJHAajIT9A0M2zbspK5");
        country.setCapitalLongitude(9);
        country.setCurrencyName("t3ygho7O9UX7Cj9q9aye4xLU7prZMdbowJtbM247l7v6w70NRY");
        country.setCountryCode1("pTx");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateName("ViYUpIJZhu4S01RuY2bxIGTqqghKQ0RJRJUzxuyEADLuVMbkr9");
        state.setStateCapital("Y6wjL058DRrXVhBNArZR9GUVufoTVGUNtvg636GTmMH5At37LZ");
        state.setStateDescription("t0fZSVjkCntgandz6qEo3DNMMTElu75OJGgnGPWsMJjGfgainZ");
        state.setStateCodeChar3("7Ydk6DEHj3kFcr9AtHWdFYu28c5KfrIP");
        state.setStateCodeChar2("3S7DJghy26JsSr9UdbdZ2myIEECtyBJm");
        state.setStateName("m1D7azSIHvswegLXbzNuZjPWptbvJldEDRLXHQ6i0M3jTL4ea5");
        state.setStateCapital("aiU7khQLrCEi2ZukSafwXbnAg85r7jrJ7fmIE5T0ioVIyBnj7b");
        state.setStateDescription("XlBXKw3Zk7whXV7OoNDAVuEsCGQStOGt34ShWcse7QJzZXSBSx");
        state.setStateCodeChar3("hHFcgT53RgAS3iIvoCvJXUrihviaOC1k");
        state.setStateCodeChar2("VmSMo1w0anSFiCMrR99dUTWSLsMrGS3z");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCode(2);
        state.setStateCapitalLatitude(10);
        state.setStateFlag("4199sEiARZIdMMItSNl7ivaIsvo1uXrXVI7GpyvZ26zakwMNeQ");
        state.setStateCapitalLongitude(8);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityName("GXZoLmbGpsxwfQlTBMEuKskJH5OtVTDM0URDtT0K0IsvPA7crf");
        city.setCityLatitude(5);
        city.setCityCodeChar2("QHAWwLsa86tizXlIRLcypCQPlYiTXe03");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCode(3);
        city.setCityFlag("No48bj7L8IzvUEs7o6Txv9ZceIrSiN1z813UnNbEzcqy3Z40oU");
        city.setCityDescription("B0hPFNn2jeG7NhPMgl7iOmyHQ1o8qvJSOTG2aplz4ehiTraBHW");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(2);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("WKGFa7JDdwdHfWTxuqDXMuwMPrSkkGH4HUGvrXNSKHme7kEIz2");
        addresstype.setAddressType("ymyhUBq9HSQs8jxWPVrsMMJg2qG6XWkW18quBSxbKSPuCMoKkp");
        addresstype.setAddressTypeDesc("wF6rv254oisg9IdNcHDNoMmOTeZ6LHFpiN9lXbNAhgnooaT5ZO");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        Address address = new Address();
        address.setLongitude("J6rZWQnA6fiXanWlzjlkcsi1sRiIQlCAbw8pJlJh6xbFCawMra");
        address.setLatitude("XeHLvc63KNJX2U8TybPtooycE0a8cy5tz6gktg1W4wAzIDTVYj");
        address.setAddressLabel("uCqFSDcDosz");
        address.setZipcode("DhL0TN");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("yE6Cl6mouedLP1oPBREBwur8kPyhPyXk1hDdsCLC5d4BOWVcYi");
        address.setAddress2("taBVIxkmGz5dNWG60qHgM2Poi7qBR7viSGfuRJOQfGejLVmyW9");
        address.setAddress3("StQWHHyZ3ewWlpwBwpJdfpbrY5MEy3zxyFv7DsTA1OLRDlwZnQ");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey());
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
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setLongitude("opaQHP0C0m2wRdac94hJmKMPaw9bAuuvYP9aWsV1MlNOEDQKSX");
            address.setLatitude("fNkqf5ZxlKZoudgC8ZBslpgBOEZhfyp6YHYcISQivG4gM4CVoC");
            address.setAddressLabel("B8w2r3bYTg0");
            address.setZipcode("PQYz9d");
            address.setVersionId(1);
            address.setAddress1("ZsatFODNQPKl27hjuQHjyIGvwf3c2L7CvUqeP2gXOUGhQs1Epd");
            address.setAddress2("YUAKHsBqNDpMb3O2zaJ5uDcEWbuHHRLcn8GGcHKpqi2aJW24Oz");
            address.setAddress3("I8zUAGW1NwHDcWjkstoNeZfZL41mJ7bQpcksRS5ysq2LDp2mND");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
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
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "IfZmgrnjVzZv"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "gdf30KJtjP6wdMIZIdRwSUIM7pnEn6tntfE3EIYxyAPZkFKFipU3J59Jc"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "VuLlKPDnEDngKyYDVApgBoquT5E6DUJyxx47PXDtd3CzVdTSoEWCv2KYZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "QQDRaa9turgTNIyP1wMrEUnjlwYcuDjVQeAsDH594rwVVxEm2spW3oikd"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "XX3H5XN"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "zmAcqItj8H5o4opwAHYZQc2xVDiGhhANB9NYafTPTeChWJHronyrjGfWzfei44I7G"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "rry8Pt6ALqX71KDMixji2PDU1FoiW4DTQKZzi0Zbk9ZdgZUoVv8TezXZy6v3J0VGx"));
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
