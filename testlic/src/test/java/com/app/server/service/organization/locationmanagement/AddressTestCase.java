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
import com.app.shared.organization.locationmanagement.AddressType;
import com.app.server.repository.organization.locationmanagement.AddressTypeRepository;
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;

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
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("CRg4UzmvyufeH5cgxrxjef5eAv1n5IEXI02gz7DlIyePzCLjtl");
        addresstype.setAddressType("QyM0cxw5gxrTKL2ENPucMepIirthGKvRSnOXAWcFN503juhHrc");
        addresstype.setAddressTypeDesc("gR1c296LjcKP7JiCYzfXu93KfvrfIZ38uHeSoO0BxODmHfE7TW");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        Country country = new Country();
        country.setCurrencyCode("2Wo");
        country.setCapitalLatitude(9);
        country.setCountryName("z2SUJygbV5iGfpceL2CuvITvlWRqwOwdBhFijJaNUPHDEwX31E");
        country.setCountryCode1("FWZ");
        country.setCurrencyName("M93dOIvGHswQq1hKiuXZaMJ8kf3sCTdR23OaxFxxjxkS3Feu7X");
        country.setCapital("50G4w2G34BjMb08idLL6SrpL2esb1KOg");
        country.setCurrencySymbol("682Hx6PT9ViXFsRTU9LnDUBQuGeLiKPJ");
        country.setIsoNumeric(69);
        country.setCapitalLongitude(4);
        country.setCountryFlag("RvEVWRHENb3X2S2J2XiRrWqNDDeelr30iYABVLDTU6RMM6eOgR");
        country.setCountryCode2("I0R");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        City city = new City();
        city.setCityCode(3);
        city.setCityCodeChar2("qe3WOhWxXpfHfowjT3IlLYbJDlDMJgzW");
        city.setCityFlag("9xGGq0eijMqrUh2qNFQREhmogbwWoM5hYUJrYx0bGL7ekGoBHr");
        city.setCityLongitude(4);
        city.setCityName("C3Xt0spaK87fo5XF31wng77XGGcrZxf15TlwoKa8IWFcQmSeW4");
        city.setCityDescription("nNrt6qlVuTZ4dBQJjw1OwSZplNVHwi2b0PUfMukiZr6qfgbtlQ");
        State state = new State();
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("4yb0r7hTGPS83FWmBJjC2IrmfFGNEE2YjUsIFSJXmSrADDjGSJ");
        state.setStateDescription("jXZuyhvq4Vulr4JCyih9tjnWp2wFp4Sf34zhT9SKufuvMeMskQ");
        state.setStateCodeChar2("NTZoU9uK85SMaN8NFhL2zk9tn7CPIBZq");
        state.setStateCapital("ml4w0ED3WGEa0Yq9lVyrTK2ntXPwyIb9LhoBUMTtWugGhiSsuj");
        state.setStateCodeChar3("wCbmTMgTUDRIxKg9tTyfow8lTVzDVLA5");
        state.setStateCapitalLongitude(6);
        state.setStateFlag("vFgKhmSKRuvkm2uUgYpfMUaIem0Jd0rgOM6oXS911Vi4qwru1O");
        state.setStateCode(1);
        state.setStateCapitalLatitude(7);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityCode(2);
        city.setCityCodeChar2("Pun2krkJcUS5InwhCQ5UlVYUbekFv5Ot");
        city.setCityFlag("lN8rRPaRWwo2A08GGabEnFTiMt0Y9kzREOgcqhi90051y7ZL2y");
        city.setCityLongitude(8);
        city.setCityName("Ym2Kj1N2N1W8tZOS3RJav6JfPMjB3ICLQPwp0yaz7RaqF6eDQ8");
        city.setCityDescription("aphZ1etcFmZblY4UAoZiLV1GdmgMzgensoEqcEt0QZCMi40dYP");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLatitude(4);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        Address address = new Address();
        address.setLongitude("gXORbuIbivlRcOnKamisIvxDoqBqSlfblOXzSq9XsFmLF2Mjoi");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("5t01UmJiipNaisOFfeCtXVGHhKyFCGEVxJEdmtlDGakKHqN4Qy");
        address.setAddress2("Yn66xeGVhRtvjTcLRkSzPOj9bR1EObahqh3hP1TEVxbll10NkC");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("rh9asOQgfomgOAesaeqPHaqHvqk8rn6RRarX0xXfrz2GSaEYUX");
        address.setAddressLabel("EFo0sppEMbC");
        address.setLatitude("icBGy15zgy01ZxrqpPQp5tlEfkSGTvC5BdjqqtpFLKiT0ZBuVK");
        address.setZipcode("djjpbR");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
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
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setLongitude("gNDZDKZ5wymKRbDT0cRtQ0ktzIQyyh6nXOtINbkV9U9Ciy8mYZ");
            address.setAddress1("Gq3FKd0ad65ouB0W8xrh53q5a73J8CQeZTSSW3zpqzHUTiUyU4");
            address.setAddress2("0DV7vvnR05pt6dyWTAceRMc1Nrbh5PjCD3e2JGaSl2Xq2qcOUY");
            address.setAddress3("WK6g1QLhKz2VTRrusAD9XZsGLJnSCsdc89F71nfLzCuEfwkNkN");
            address.setVersionId(1);
            address.setAddressLabel("A6M918DaJ8o");
            address.setLatitude("9N6RtylTSSlwTTjx99VUjzGdkvJjKf5DUMMz2W8OIYV56G31tA");
            address.setZipcode("RwwAoO");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (java.lang.Exception e) {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "eSJq98REe8J2"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "RU2JgFnZya808heWeig28a0aMySMeiQ3kUZRhH5oXg2plujvd0O3tp7fM"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "KTnCrLuMNyaFC7Xs3GK929Uv7R54RKjDmn3etxJszTvm6ZqFs7YLvbIeY"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "klf0PvJ4kkbV4HQQTnpeVoQkUqGhBRAtVAFxBvseMbvBAKV2Nw5g9kvNT"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "3jQ0LPJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "JcaM9DYA4OXREAPjtuFsVvsocc9i3WjrVE7ZJ23pFhZXSyMyq8YyPNdIkZ9G7rKOp"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "5ELTIflsxGSnoIJX42QAmE3OOyV1ZaVVoqhaOuLnpG2sM3RigN9wXVSCEd9GtKCO1"));
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
