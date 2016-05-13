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
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
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
        City city = new City();
        city.setCityCodeChar2("WiGrWe2tzjHgD7eMs2PWVywFdv334QwJ");
        city.setCityCode(2);
        city.setCityLatitude(5);
        city.setCityLongitude(9);
        city.setCityName("ZzKQ8yv1drQzLSFHcYdSAbEVXvJyWDme2Sz2msRfKqXDFxgG2b");
        city.setCityFlag("bAKQVeHwLukX4VZOvmSVaLQUCJ3CDFSgnEC5CFTI47tY2ICF1c");
        State state = new State();
        state.setStateCapital("NfUXcQpzd4eJA1AfSP9sk1i3Aq0CYvuOQJ0r6xP9ApzpA841Rh");
        state.setStateCodeChar3("jfABmxjjaK4fa4sQAZqXVcsmjPudBHwM");
        Country country = new Country();
        country.setCurrencyCode("RUP");
        country.setCurrencyName("BY9TrMAxkk2wfrUzotDJRTIjtiB9FCNGh2Syq4fRbGteOt2UCV");
        country.setCapitalLongitude(8);
        country.setIsoNumeric(387);
        country.setCapital("b8UgwIeCF9SCuw5A8NUwnPjIdG64x5Fd");
        country.setCapitalLatitude(6);
        country.setCountryName("XTCoD4n6m9w5urBs5oNwsLF2MGSHOPkOebZGcTuBQ0AOyrvUGu");
        country.setCurrencySymbol("S7nrgU35NhUxoWwAgTyO84WmqUoM65lw");
        country.setCountryCode1("6Vc");
        country.setCountryCode2("B7L");
        country.setCountryFlag("2qXiA1Bb8Fq7iPcdQRHjhGcVdGLuwc7l2BrqT2tFUxJbbQ4oqQ");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateCapital("5sYqgcfBKgRbou1MLn6Ir3KRIebFDOB8BayB6N8oz3xdp0zDWV");
        state.setStateCodeChar3("ko7iGe0IG3tDPrTOfqWlqGNHTa9mvdDs");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLatitude(8);
        state.setStateFlag("h4gmK2cyFKt2AkKTagMgDINXGwAR83QKoo8CetnSbu4XrHIRa3");
        state.setStateCodeChar2("ce8XtcITUct3Kf4uLUOsLhOPUgCIcshA");
        state.setStateName("kxsmN4DIndJK0hHOZYjJw0ykuGvVYheuro1TJUPIK3e68y3Kni");
        state.setStateCode(1);
        state.setStateDescription("GD3XoZLRMqmZE561xXbbV0FKfgahRuVh52lo1fIS8kRPWwhXTe");
        state.setStateCapitalLongitude(1);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityCodeChar2("Rq3g5zWNuUld7Xm65rlwvJo7woNiV6I4");
        city.setCityCode(2);
        city.setCityLatitude(5);
        city.setCityLongitude(3);
        city.setCityName("W9DbKx6YHScS4ac9pUWfsd4JTGJ8rDo0pePwSgqv7VCcw0cm1p");
        city.setCityFlag("AhGSSySpy2EdOyV2MRUu9MktlA2lteCVVDXa6VHMSGbkHurQsc");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("ZYQERYDUc5O7bryWe5NbexU7oVYeJiwtJQszatGcE0UNPokayZ");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("0TIGoYdydfj5rCNpOmFmxgpPJ4N106OyOj68NSYgRgHArY7k5g");
        addresstype.setAddressTypeDesc("Tfe2DvFZYYKdxOrV3lcoO86YfhFWpNe76mqLHeeGbQCPRiucD5");
        addresstype.setAddressType("F12l4gi8JwjAaNgslVmHQvoIoRZ9lNpDIlUG9xGJR5tzs6DahL");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        Address address = new Address();
        address.setZipcode("Jjm6Xn");
        address.setAddress1("mUPSu2993pBlQ8dbWs5jKFuvd6DOLjA5zpsJ7lsQf1K8jhJYdS");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("4liNaJBoWpj8kwZBMkFzSfOIX0JOhODxL2dUxX1ddCEFzV96Lv");
        address.setAddressLabel("uh6TpPLR295");
        address.setLongitude("kh7Lx2dbNpS2YGFe9pcDBF3cyKEEPUplHfvwyGHeh3CDFU1BZn");
        address.setAddress3("QAdHNev7UAidjo3QCDeSIxoahSNUH0MWNxRotDuBhADczWEq8T");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey());
        address.setAddress2("RFis8H1RaLDgh0ceDh6ghY2VRC41DPDjKfgCfcrvDSVsCo3IcH");
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
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setZipcode("sT3rzk");
            address.setVersionId(1);
            address.setAddress1("6priYaxqgZ7GhtDPPxEFuZdp6qVBeMUoUskPBGfr8lqRxuZwXp");
            address.setLatitude("Iea4HhKaMebWI8O1w7GFGCz8tkb19qifSaZJZqU1GNgBIBviLK");
            address.setAddressLabel("PxqgKdjywEr");
            address.setLongitude("m6JLS7NlMXx5MyRPzczsFOFhvQc9uBxnuoBxPSCLWyOgWsRBCX");
            address.setAddress3("36ujUQh0sqh1wEaLORw5oUuSxqRBsQS94fKxx1ic7GQ1OexyDa");
            address.setAddress2("c4a6PQHSnGUSNEdUjc1y8J3mytF67YVcF53zDI8Xd9Ne2mJes5");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "hNkis9ueB6L9"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "cSGmNGGZIb9L3UyZmuYzT9WzUPmeJodKCVNnk3BlLidkRkZyS4oXt9BB1"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "vHRMrZ0Dll8JYSytBssmZCTMqnNSIC28yvTUrF78XM1yIDSCpT2EDXCPf"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "wW10BSgWtlhkeyVaTJjZyxpXniN2bKJy0Oa8QawUhHlGC74ZuazPKgq4D"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "1g4OYdY"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "WWrRdFQ3aM3mYzvGC8PTUFAa78aehGOwh3ojR7AdenU6hIvoJ6NRWN8VqJjtiq4SF"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "jCChQftPxWSDu6vSmdjmPUUYEj2xh1xJzAn00BSclPdwkTuWP6H0RdBGIytsTC8PM"));
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
