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
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;
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
        Country country = new Country();
        country.setCountryFlag("agsII6BAUQWyPV0doJx6viHJPAQi7gyYlCXK9WBCh7zS6VARao");
        country.setCapital("UCnp0v7n1sZNSBihxSuK9AVGvfBcc48u");
        country.setCurrencyName("zDt3vIjBJsavP38h0TlcNBiBea052CrquHgyIL1kGV9dlD3Zzi");
        country.setCurrencyCode("hMw");
        country.setCapitalLatitude(1);
        country.setCountryName("PIt6s2Hmoh6bzCIs3TJzxSylFxn7EFjnZROhMUwniG24VYNo4z");
        country.setCountryCode2("UM9");
        country.setCapitalLongitude(1);
        country.setIsoNumeric(430);
        country.setCountryCode1("orL");
        country.setCurrencySymbol("5I56gBqc3xOivmfoK8N1HzuVIcem19sa");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        City city = new City();
        city.setCityCode(2);
        city.setCityLongitude(11);
        city.setCityFlag("cF4FN6eg1gFLfIQndV8MUpCluCFjS3zUWXXGENJKPRiF8HdYCR");
        city.setCityName("pKoiya4bbWkaKIuU8dSkiyKptvYRU4nHY9aAbSpMromE0iQRKl");
        city.setCityCodeChar2("LSoNEhphBEdJuVLvaWRYsYeEcrH0LFOP");
        State state = new State();
        state.setStateDescription("KSrTVTyyguS1Dzbwt4YsjDEfAKKIYKCZA0ZQVXg5XvwdUARYdB");
        state.setStateCapitalLongitude(4);
        state.setStateName("mdaJ6DHw84hlaKAK2SgVxyCQRdNOg84hsw8n1RgZs8Jw6FrpDs");
        state.setStateCode(1);
        state.setStateDescription("44Tu9Opc28MO5JckXOHfahbA4qvgQgl1rUCnVEs162kbWR9DRg");
        state.setStateCapitalLongitude(11);
        state.setStateName("HPN3Gd8q5A2RNoNxRjd4kJ3Ui87MKAs7phye3j2q6ATo56Q96X");
        state.setStateCode(2);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar2("n091cPIvIjcXr3Ntkq1dcY0ayDGYztxw");
        state.setStateCodeChar3("3jhPCKkhQKtfYBwLYFtmActjUlnMOoRo");
        state.setStateCapitalLatitude(1);
        state.setStateFlag("6249LfSBGMMpEO23bO6DuzuztrYfc8yMmqCsr2TFxVaGY4THRg");
        state.setStateCapital("yrem3EPCCVGb5B6tP0PB6esxTXqK4Iff39idDbdQWXfS65BFXK");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityCode(1);
        city.setCityLongitude(10);
        city.setCityFlag("wMFeTsaGRmUMu2jdJT8snEVYtZ5ZLCmWrosJq55OBd3tXnl6XA");
        city.setCityName("qqbThMupxBIrqfmkSCSoj2zS7jmCD3g4hetTOTHf5zrZrjlOFb");
        city.setCityCodeChar2("3JqQ5uPwixdqRJUY2AnHEZBhAO7fSdje");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("kd32O6UbQ6DuZ01QzekIJHkbLhbLXFwO43MXIow1JGQOnXEVZc");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLatitude(11);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("Tp4AQSaHEaS0YWKffUUd23aXvLmvjAMQXUW1O226O34oDlJkkq");
        addresstype.setAddressTypeIcon("P7QkuaJAVZqK8m85LihbfAyQHvXwWcYC8S2o0Wp4lvy1SEuBHJ");
        addresstype.setAddressTypeDesc("3heQbnIXvWL6CGtc48oZ4JOEjU1vcL5pCjkbb6Uc3ShBk0itmp");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        Address address = new Address();
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("fPKqP8ckqKUN4Grdu65cSvFCQdfZdoZJ5icrv6rLGEepfbsO0t");
        address.setAddress1("Ed7QEHciTJ4CuLMFx57qSTC9uAtqbWTJ6qsRIY2PQ8uJystY6D");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("iWSNZg5wFFREWbKXBNy1DkjFevxruR2nbT1EEuz2UgYwiPX6GG");
        address.setAddress3("jWCNsobP3TLBgBRhMGxpIMySdeKl5gGoOuqrwVv7u7SOFNbKsq");
        address.setAddressLabel("1mFCHATaWC3");
        address.setZipcode("xhhCDg");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey());
        address.setAddress2("o0N2WExmmdccAEIj9CxUFfoSZnoAejGLUmNX2DR8KwXD0V1CkF");
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
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setLatitude("u9TBkj3rPYvGWfy5PO67rE3BUGLEzAsUxHjM7Axzj39Dcbhmeh");
            address.setAddress1("r4WT1pieXfafNaQQfjo1u8arnmTCD40Ei12YkjeFFyhcDwvmvr");
            address.setLongitude("TXstX8XzHcRs4bNlgSOUTfY7VFN1hEexlcepestdxpcAaTUAwe");
            address.setAddress3("P02tMr2c6iPtJflI5VyQt29ssM3gBoYfIzEJBV7Ev7hjEhJqtR");
            address.setAddressLabel("j6nNylfjjF7");
            address.setZipcode("dwweSu");
            address.setVersionId(1);
            address.setAddress2("KIf0CSDpiFn3H1kKGxQcBQWxhZ9qrRm7r4mBcJCia8AbL9sfoo");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "VimWMs1tjcPt"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "6s83d2svJTqMa7OUmdsuOJA9I9tt7gdFXBJnheWzzVmQzbMHPxA5XjeW2"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "VawUMvyvrbgYhl9oStQQliUXmGYDCSIv3CmSICRxO4Vkw0XwLfcnhZZt7"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "lb52ttCUdpZybSKbyvFF5yxOCXuplFerNchxtJtrpouqVZsMpo4E2NHgT"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "q2q27BL"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "WxAdTnjdPGDjdPwE1MP4mxYthID34fM0TKHWmuF37XqWk9gzy44DtEc0oMnWA2rDY"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "p54sWVca3ZZJbXDxeQKIC3UNRja1r0IsQQvwK2RUV8zqRuZmgjteAloaBDLTG6oS9"));
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
