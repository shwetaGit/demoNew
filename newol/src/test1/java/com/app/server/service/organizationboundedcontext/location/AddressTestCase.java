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
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
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

    private Address createAddress(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Country country = new Country();
        country.setCurrencySymbol("V0MMFIkl2fm57s6DA96FrZF4RdVrJDx1");
        country.setCurrencyName("c0fV3vMNnACIhtm04hOAJIjEsYx83FobhmuYBX2VLWcpfTdrDq");
        country.setCapitalLongitude(8);
        country.setCountryCode1("wOr");
        country.setCapitalLatitude(6);
        country.setIsoNumeric(9);
        country.setCountryCode2("kIr");
        country.setCountryFlag("0eMAquJEHLgDzr0cy5YyK4oouIg0LjdTSrJGknxQo32fXXx20h");
        country.setCountryName("tISGrqa9CRf6IJB0u7crahnEVkvdsGOHMPUMCLqZYhc4tfah4C");
        country.setCapital("BGu6TOZSaOYGo25W4GLrAw62MTtweJIe");
        country.setCurrencyCode("BSq");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
        }
        map.put("CountryPrimaryKey", country._getPrimarykey());
        State state = new State();
        state.setStateCapitalLatitude(11);
        state.setStateCodeChar3("EfOVhuiqBbmmL2cMnpAffi6L0SZ8cfH8");
        state.setStateDescription("gkcKAdn1KIjQ21gy4f7LlUlyypXsxT668N4UoGesNTYnhCwufx");
        state.setStateCode(2);
        state.setStateCodeChar2("1h5i11zLczIKDkKI8xWKG0MOwdJQhvgp");
        state.setStateName("Sv0fzOGX86YX7SWhDRWftGjyz0oR9oVxAtWQfiEFJLcnZxQXoc");
        state.setStateCapital("gSOmtTv2qYzfjgFs4qE6zn5D2aVOjCNJvCueUPaouSOKsTYyAr");
        state.setStateFlag("mtOF6UpkW6HxupGVflMzDIHGYCmy1eWrfvO0lbUbtPiif4Hz0t");
        state.setStateCapitalLongitude(4);
        state.setStateCapitalLatitude(1);
        state.setStateCodeChar3("HE5VB9ynxnYaJF75tXxMWtOVyDcttpeg");
        state.setStateDescription("LK7k1Vt9vpSQM2PLOMY8Ig8699yBXY7bTRfxImDpIAhdpsWcUG");
        state.setStateCode(1);
        state.setStateCodeChar2("eGnjq0EJKI8EKHzEHLFQTVfTkNst5Ydf");
        state.setStateName("r4BtlqBNu5pKccZbJpnCWMSKpvTA4ApHf0REBZqflItbY5X3sx");
        state.setStateCapital("7qEFlhMKfgd207XO82IoFeanRbW28aQjxbkJcPHyd9fkqMpIqG");
        state.setStateFlag("3UqWiovktGIejf62nXhzqw9cWhAsM8bHDy0AtDwPyMOIcttLis");
        state.setStateCapitalLongitude(3);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
        }
        map.put("StatePrimaryKey", state._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("P9O3H8e2kXoKgqHWPergXnfFb5pYlYP14p6j0r3IeIrPxPiTro");
        addresstype.setAddressType("29kwnt0xwxpq4122KaIHtoqnIe5m4RoJpwnRDxQAAUfgdNP2ac");
        addresstype.setAddressTypeIcon("5PwyruP1RmOMQ8B3X7VU3BFwkEL4rD6doCyY9soL4gLjTJXYYg");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
        }
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        City city = new City();
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLatitude(6);
        city.setCityFlag("WnkaZUZhq7BaCeZKBDfGR50G7ORsLdMITG9ila7iKqlyvs3rZc");
        city.setCityDescription("SYiJ4yPhfWkCJsuVUl51xjIn2Zxr8IEkzO8GeZaDlHntiXE17D");
        city.setCityCodeChar2("z10UXbLFXeBaQPnsAyyYofxZ2dfl6hlr");
        city.setCityName("TiYYK8NPNcpODAk7AfojUgixPaxhKUcJoPKqAfneBBee6hjwm3");
        city.setCityLongitude(8);
        city.setCityCode(2);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
        }
        map.put("CityPrimaryKey", city._getPrimarykey());
        Address address = new Address();
        address.setLongitude("Qger56FUE8liBELeEpDxCwp5CIIGR4adEPGYQrhx4WFopc1CMo");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("r8pzKyojafGzMwcuWh3bbJ7Ouod6ceC7tk7JKrtpwEyDymxSIC");
        address.setAddress3("jnTlXioxZBZVaeoUlgifKWtI0aGxPxHkkqPEBBjDhUdUswqUR1");
        address.setAddressLabel("DMkgvayukLM");
        address.setZipcode("9nGuFn");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey());
        address.setAddress2("77VXKekpfzd93sqIP6jf7Ti2bygHyxedLvddm2NQ26407zr4VY");
        address.setLatitude("74QJZLecJcTiAjgHDNSrPqqnDlr6on2ZVdiZdah6Q9O8jKBXcX");
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
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setLongitude("IMABGMrVG7DpJKBWMd7HiYNPcAz2Pi4ksNHbuvfXm0WwsUp0MB");
            address.setAddress1("CEpnV1xkqq0PKud2oUaRMc8I6UkrzYLPVkrnxkfk3UKZZc5SF1");
            address.setAddress3("PrpqEqRqwNElcVxVm5gtmQiBNGMSRGJF2vW8GyFidlJyv9THfg");
            address.setAddressLabel("6DUrip4wd94");
            address.setZipcode("2qZtC5");
            address.setVersionId(1);
            address.setAddress2("2DEpxrIxU67J6Nk2tQsNEkilnJOK0DaDcRg31vtcclqrltpL28");
            address.setLatitude("vfG56xBwBdg7OdBfNtCywtGYUJOQmlJFGOuJ59TYDFtQJQNyiJ");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
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
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "9f97JSboN2ML"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "3uSquRMma5FppbdP4QpySnfIb3CPYAeIc04ahLrprLQIZbyqZHr5W25Pt"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "JuPdVgRxcQZ6WhgByp4gQ9DbGQ3EhL3vc3gnrIkm0sdXf5QfyZ3UxtPdP"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "ciAd5KsRzIgZBngBwydC9kW7NXOHSqEQYbXxYDywY9dbyLx13IVODYbW2"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "AOTJA3J"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "ORi6r34KNswCZWIS6nfQ4vOLfNKgJjn6ZOBj8ckKffoSaSIpjiL37uCcDIDqKe8t5"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "gcqoHPFiWxQ3Hm9E75U0g3843taMkdFUq1mmna6oU9n6ez2FtpbOVwYJN1ho28Y3D"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Address address = createAddress(false);
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
