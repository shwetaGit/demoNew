package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.AddressRepository;
import com.app.shared.location.Address;
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
import com.app.shared.location.AddressType;
import com.app.server.repository.AddressTypeRepository;
import com.app.shared.location.City;
import com.app.server.repository.CityRepository;
import com.app.shared.location.Country;
import com.app.server.repository.CountryRepository;
import com.app.shared.location.State;
import com.app.server.repository.StateRepository;

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
            addresstype.setAddressType("lULse1dqPzwqSfqL6GpUANKsjgJeVdvyuhIvrrhgukZ5MNni43");
            addresstype.setAddressTypeDesc("hW61RESDt0PljkDyamPO3FScMRucXSmcOLlVE4yJcTwfOPrkhl");
            addresstype.setAddressTypeIcon("2F78S7Mmi8pbAVcc3xdnY7bSSEKngiIFIeXTjc1VEYWsKRGumh");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("XJSepylxRnNwAKXnc8gLSq1oOFQL5mEW");
            city.setCityDescription("8NhAhuUJcpRKNJ5QMkofyKNZi27FsljH2T1pHhjTNrJvuWpXA7");
            city.setCityFlag("HLkjlLprJDEKmyQ9WfOpgaTLcOIMByAygNWCS8ERFWrqjxw0L1");
            city.setCityLatitude(3);
            city.setCityLongitude(9);
            city.setCityName("8WxQYVPN9TVMA2uOFsrvVfa7SO0teyIUOZcZqNE5I3QxHrQkXW");
            Country country = new Country();
            country.setCapital("D2yz50HNwysL9AuxNYBJEAw2qHS7vYJi");
            country.setCapitalLatitude(8);
            country.setCapitalLongitude(7);
            country.setCountryCode1("10j");
            country.setCountryCode2("fSq");
            country.setCountryFlag("tgiwYdbGWI5A49nmmyMH4aokUyWtQZA3cw9tpCbLaaR2y6dJH2");
            country.setCountryName("jsCR1odExO3zTDYYlQ5eaXt6bBaaYp5gx4yZwNLuV3mLUp8J2V");
            country.setCurrencyCode("Zlf");
            country.setCurrencyName("HMcFwff7912qc4ezTCfT3pZzK5qflbdZtO8nwgyKLymsjb4jIp");
            country.setCurrencySymbol("6qaHnoGtZM4tXuOiHVKxsFWJUsV1JVIb");
            country.setIsoNumeric(7);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("n8vr0ssta5Vtha4OgrYl77MhtAa6Xc7sHNO5sdkAopaBRZt3v1");
            state.setStateCapitalLatitude(11);
            state.setStateCapitalLongitude(6);
            state.setStateCode(1);
            state.setStateCodeChar2("ciXu4JFi7OzCrs2yg7Xbs1EhybI1rcSF");
            state.setStateCodeChar3("tsZKjUZjEvl4OkaCEhm8w7Rf5fuQGAER");
            state.setStateDescription("pdhtJmY83gr1muRaxKy6jV9UYoHMaE0w0oJ27aejZJwP11JNuA");
            state.setStateFlag("L0zswLaeL6lGe4dtIfiv0tmgTeZIGJY23xN0Jps7YunT75OMLK");
            state.setStateName("QpGHR7UuGrypgwz0lYdRjzqMZ04yy7CS9HGyUiJNM3fc5kndkb");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("44GrJgOa5QfAM91ss0fRkf0bTlAcPaNr");
            city.setCityDescription("JyKdMRbA6vvO5BPZlLTtwvvUmZ3cHoKuR4L0EjJxsuas58EpDG");
            city.setCityFlag("BbXli1YHANPjCmBtXvvbRBjNeqBAamEkEfc0sbb3tfpONmsKkI");
            city.setCityLatitude(7);
            city.setCityLongitude(2);
            city.setCityName("Lm7Fx39ElFxnUP6Pxh21HrqADL9ldYo85sV2aLQGmKjIofGMlE");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("0YdIU3CNhnotJHqjG33IDHE9JO93x9B6w6yA3g8NM5hmSbUg29");
            address.setAddress2("SdHVosI2syj7HtV2oVb4krDV0oRNzNTqY8m7agysffRKnd1KIs");
            address.setAddress3("4WwEGvxVrWx0nPwhNvKLzPcpfQjjoPfyOaWyLwZcXUYgAtSNEJ");
            address.setAddressLabel("ahHVrk3KSLG");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("QNVimxNMbab0tD6DiP2gZEZkjIyTl8Ovo1OzuyY0WVlaNfQDcA");
            address.setLongitude("lPwtMyjooiGPQv0ihkOqgeQGHkgN3iw90Bi37CvfIjpoE791sT");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("hPuJcg");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
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
            address.setAddress1("zi9NJHprWcomz1U1aPc3kV5XdEto2Cs0z3NXicw1W0LoAjzbVA");
            address.setAddress2("nSuSP1nzSGbOpRui5Id1Y6XGJkpzmQJnH4wLk3ifJbaMFPzLcs");
            address.setAddress3("AsnbiaE2wSTODs4FZo6DvQ1YND5QUZjlg8XqkwpYNXTeTMR3Zp");
            address.setAddressLabel("KU8W5g9lOPV");
            address.setLatitude("VlilgOcOKaWmLRtSsMBZ4qacnoOjbocJHx5scRWHUG0DJwPwyp");
            address.setLongitude("TCgU5lPwMbS0JujQYzW9wpse3CF01hwbJGkab0Fz0RywoQFEEY");
            address.setVersionId(1);
            address.setZipcode("QpqDmn");
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
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
