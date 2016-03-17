package com.app.server.service.organizationboundedcontext.location;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

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
        entityContraint = addingListOfFieldForNegativeTesting();
    }

    private Address createAddress() throws SpartanPersistenceException, SpartanConstraintViolationException {
        State state = new State();
        state.setStateName("Kfdw6TrWeCWYkSGJrmlXyVM1zodk807PZnhN8v4haQKuwncUh7");
        state.setStateCodeChar2("DKgHAUMJG67jX4PRaDJbHexiMfFTOoxH");
        state.setStateCapitalLongitude(5);
        Country country = new Country();
        country.setCurrencyName("w9AYuGxSYWDgUbfnHvqzp0yxOZdRhSgVCYcO7EQbed8Pgt9sIQ");
        country.setCountryName("DxJ6GTAG1XvgDmzQHCbkY4nQfgMmgmL8XJa8RF5P6UQEQPZkC9");
        country.setCapitalLongitude(4);
        country.setCapitalLatitude(8);
        country.setCountryCode1("U84");
        country.setIsoNumeric(4);
        country.setCurrencyCode("HNO");
        country.setCurrencySymbol("uLO5oieOyFof2Xbdg8fJ3tNgSgeZEEWz");
        country.setCountryCode2("aqd");
        country.setCountryFlag("kd4xgrt4rfVuaRqkFyGRrKLgLUK2ktZQqTiJH5aXeQTS9SNCe9");
        country.setCapital("uVfQIzio6n6s3DuiW5NNT5dh5dQB5in2");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        state.setStateName("Tkzx84GL6DCsynYJ0NklyphPiaD7SOKTvXd1bxaqBqdnhxH8bY");
        state.setStateCodeChar2("BIvA3qJNwIF9JITMEKfINbZk6u4SnANO");
        state.setStateCapitalLongitude(5);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("gP6z8UZ81nDkYpaXNQWIDdLwDAldc1z2");
        state.setStateCapital("r8CwmOmNaxubj9nSqlQBC0zUvepH1N6J3I0U4V2VIOHAVHhBpd");
        state.setStateCode(1);
        state.setStateFlag("9cqOYl1Og67guh6NUCrhkYtU9hyyoIarhCQIU9fAnGZK06z6Zc");
        state.setStateDescription("XrFAaf06dxPlk4yQnLZUlmD8py8mghPfV0xNTV9Rj3Hn6621vD");
        state.setStateCapitalLatitude(2);
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        City city = new City();
        city.setCityCodeChar2("auiTHlhC95cN46fE5IWxQL9HakVOX3Mo");
        city.setCityCodeChar2("IjZXoWA1mzpkJUzYfexoR05xlxIa52N1");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("08QKc96TNQGOUDMRHQWafIdEBm5fbUDmvjwDUYPPEyEpkF9p0R");
        city.setCityCode(3);
        city.setCityFlag("qIjbLlRJ36PyplD5JZC2LB6blZjkknlnXLoqS4E5c6ikC9ZUNM");
        city.setCityLatitude(10);
        city.setCityLongitude(2);
        city.setCityName("yKtUE91pNzJoD8GcTyGstVjiYqz2U3G7JQkLhiB8wBvqmbm6eb");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = cityRepository.save(city);
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("l8g3pMAfEZNV98FKEm2uK1ym0SbrI44JGGgh4PmLw07o9w3I5U");
        addresstype.setAddressTypeDesc("6WHVo4OqBuwvnVtVACl1XbCEQ8rPWnlKJWfUaKUBL1YW6ZLeVd");
        addresstype.setAddressType("LA8L8Jvm9elYceAH2AuxCPkFZyQSKDYjYjVRGclhboRfzm44tc");
        AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        Address address = new Address();
        address.setAddress3("U2tLmlMosdWFJMDvmvAysjb5p3ZcOBZ7okrRLCZrfeFykHBCAd");
        address.setAddress1("irPayGNo5hxIF5WJuDyAnEgwZz6CLSCsrCuuXSnpno6YNIGV47");
        address.setAddress2("Xe2qMFC5jq78jp9lNAINzURxdmSktHfuIBLkdDOFkzaZ4PTALT");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("cI5AOoPWCC1IeBW16zsl24gcrMiB1aEbBHWGimQSpuNQxI8HDy");
        address.setLongitude("23vagPWrG2tVSU5sokvZVFPsbHcVTADdlzmZc3TleNK5h963Pa");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("x4b4vg");
        address.setAddressLabel("fB8jUFHo04N");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey());
        address.setEntityValidator(entityValidator);
        return address;
    }

    @Test
    public void test1Save() {
        try {
            Address address = createAddress();
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
            address.setAddress3("KPqjSGDNjAWopKru4olqzPAYOCmqOxBf0ynPeaqU4vzTz4PtEJ");
            address.setAddress1("0Xi5kcxp66vlQYVQD9nQWhAoxC5mEXPuMnegbsafRaddEnlQc1");
            address.setAddress2("KXjzjqfa03jJ2vcCcOjK7dl8bRmTyzEvcxTiLXuez5VWVJR2d5");
            address.setVersionId(1);
            address.setLatitude("I8MXJrO5S8qfMJRlGzFxuk60dbs82jY283Lm8ifOO5hOgl6OgQ");
            address.setLongitude("u77Vys3aVxdhcmp4pGd57pMszTElJcxi09tCCDazXaq0Rz3WiD");
            address.setZipcode("NrbKTi");
            address.setAddressLabel("YLZBOFfVaWQ");
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
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAddress(EntityTestCriteria contraints, Address address) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "rBrxZ9f00uqs"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "QKaDknDGmTDZ9BCm6cCdrsjQUvf5SWAs7rPuDwjUNS8Iak00UVpmERdYe"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "dWMNU37JfbTgxjLMvhfqIV36BkeiDEUATpPDlJfHdsTwuPU2dq4UnRJ95"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "FBAXpMwdvGlAZ3ZdivFiqWU81r0ipoKeTbwiK9j24YtswuyXz4Z9ByRKp"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "jDQIzIs"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "Z8XvOywqaz9zIMcvJrE7k6ENnwNjPJdJZC7N4PEpZpuGXKkzzHEZvurVoaRSsSSuZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "EeKEXdZ2eW84EL6wKLudAfuVb8RVzLjRjUJSvPio8oZGrey9qJoxqE0RkK4NSFDyB"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Address address = createAddress();
                java.lang.reflect.Field field = address.getClass().getDeclaredField(contraints.getFieldName());
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
            } catch (SpartanIncorrectDataException e) {
                e.printStackTrace();
            } catch (SpartanConstraintViolationException e) {
                e.printStackTrace();
            } catch (SpartanPersistenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
