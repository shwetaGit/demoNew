package com.app.server.service.organizationboundedcontext.location;
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
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;

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
            addresstype.setAddressType("QMDHyIf7YoiZVg4wcPMQqhE0h7wjUBEWaXmqb5S51hmJhOU5Rc");
            addresstype.setAddressTypeIcon("fmsZJu6kj2VUV8EdBlo6JzzeiWtDg3qFNCATfMfVDpnYQCS3Me");
            addresstype.setAddressTypeDesc("qvRvyTeY5wfSKBAqmDSOvVUxistkYNLZTv5dt8JrUp8ajVjj9a");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityFlag("ls11N9LSdksUtET6vcJBFNw1wq3VKqvwj6dsS3qf9FGSARAXFF");
            city.setCityLatitude(3);
            city.setCityCode(3);
            city.setCityCodeChar2("174wBx8G35C7rCSKlmrfnqkYSu9SUTXy");
            city.setCityDescription("Jck4iDErJmEMNaBI6ewLlBRLGI2msGAtSej6ZtrUt08oVmiXK6");
            city.setCityName("K6Qss5gpDZFBJUwwODg7OjdpqpwMacr7JjK5e1WqXhVjq5k7z4");
            State state = new State();
            state.setStateCapitalLatitude(6);
            state.setStateName("k5qyiAb0uGvWvKS4Bk0eGoaONXPDQOhUGhmwbqGhD1FlpRRaf1");
            state.setStateCodeChar3("a6j3rg54WP7YFxUpu5LgoCBGojY35tZP");
            state.setStateDescription("RmJVtpd3PGSuo5mPc1zdvzdUOb7JsoPqwEBi80taeEYXPfw5hT");
            state.setStateCapitalLongitude(7);
            state.setStateCodeChar2("YPAlrHrbyzHor9vHVVuw0HQrYYMnI1M5");
            state.setStateCapital("u3dYh7sWGatswp2VTvhSkxNcNz6cds0wwYyTXXRwdDWFYQij5a");
            state.setStateFlag("6abeJlEb0y1qZyxwoiVM7ZGcFEpILYvSqImElBmJpbEphc66i1");
            Country country = new Country();
            country.setIsoNumeric(6);
            country.setCapital("5R2QO1hDsIoMJi9Nj16AYrqk5r1r4ZEL");
            country.setCurrencyName("lYdFdmdZj8hMJSV4hsy2jt4DOQ6EJrbbu2d4afNvlUbbNxT169");
            country.setCapitalLongitude(2);
            country.setCountryName("kNZrCfPd7RvI224UtkHoCMtliM1MiM4R4RymmktmT7ZpKv5L3p");
            country.setCountryFlag("axRtBauboMcOLmFlRosJsdi5DgKdyUryo0G1p9pxzBOTm3UnkD");
            country.setCountryCode2("HMU");
            country.setCountryCode1("xyf");
            country.setCurrencyCode("axL");
            country.setCapitalLatitude(9);
            country.setCurrencySymbol("FP8jXOlq5LcnVtF7eLiV4CwL5vZs19rj");
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            state.setStateCapitalLatitude(9);
            state.setStateName("PQ0DPdlknO5Ug4vvg3jWaHx2WUGq66YxpDeoqZc2Cqmguz2mHx");
            state.setStateCodeChar3("bMGfkNjypW0TDI4sWE6Pb6CWXHIvFqEc");
            state.setStateDescription("eeJONacxSmPkAyIXOxXjLNU1VrR2jVZM64CDkKzPVwR9soLhSh");
            state.setStateCapitalLongitude(9);
            state.setStateCodeChar2("yUmpIKFqovtEWjfhDUJwU3nOROLJ1sA2");
            state.setStateCapital("dLpnWD74NdcjTBclrDAiZJYyAmM5cWpRGG3lAak9ZQjdHWLId9");
            state.setStateFlag("os6vqMnAA4N69oeJb6Ymx4crUYsUYScZ2bk2x2eORf2bKORl0v");
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCode(2);
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityFlag("JDNXwQzCsBVPNWCo0QAhOQ6LislCbg4Ez1nXBNjLxt848kAzkA");
            city.setCityLatitude(4);
            city.setCityCode(1);
            city.setCityCodeChar2("5G3u2Ds4OMBiTM8b3FpBMOh1SH2PJnsq");
            city.setCityDescription("Gipz5RRt8UASe00emzuUEIRjVgBMhxN8LTkkJpEVwMUnjAghNi");
            city.setCityName("DJjGPyONDO19LBrkXi63Uwe8BUojIQhK1QRmRy6ziCB7g0fydo");
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityLongitude(8);
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddressLabel("Q8G3PDBifaE");
            address.setLongitude("CHUH2LUghBkqDBm9MiCQmZdH4tWKemzOXWkEMSGgHd9X8WsG0B");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress3("Smo73EeYuzRthlyU32VsQ1CG5BPeDJxDFtHhkYykIRdwd3adhf");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress2("34jnFaI1rKLpzpYCDVxlU8ij1bHcHGPY14P5AaqhIeFgnIuiTy");
            address.setLatitude("iNa56GZOrzkP821hxNAhSxwhb3e5xlnoNccRfQTvSRUFv1dQms");
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey());
            address.setZipcode("dc1Zp7");
            address.setAddress1("EwbAyhlysH0AdtKoTrVGrxe4C6btaP0ktYb0J6w4R8AcHsX1mT");
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
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setVersionId(1);
            address.setAddressLabel("jwR8Q2xsHlo");
            address.setLongitude("345WaGYdkjI6Yebrl6nEyaWkg8yc5olBinMiIaRQvKc7vn7psz");
            address.setAddress3("42VYJHISYWH8RKo1seFO7EnvWg6hcknySgb1Ia6uNtj0mvxnHS");
            address.setAddress2("9XFadXxGWjKgAwcRTcvG5jz9I83VTmfryquZn6iFhE7LveKfxE");
            address.setLatitude("HBaZ7Uvny5IgK9gzEWtePa6wrUO0zQ0XvsgLvnnsUYVBIml2mG");
            address.setZipcode("6GY7UU");
            address.setAddress1("mEtgZ9bvNz9IbkB9u0Kom2SiH2g3HLcbVcZRAYRGi5i0qD1Ybc");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
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
