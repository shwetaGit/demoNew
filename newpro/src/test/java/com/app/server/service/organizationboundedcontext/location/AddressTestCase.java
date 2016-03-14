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
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;

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
            State state = new State();
            state.setStateCodeChar3("1djJQqN4QKIGbP8NYRfIXHkWcc9RdCnN");
            state.setStateDescription("WJUUtMzol0TM9TW4F8ZKEb82lgxWXv68iXZEpEoBxx0OrohFI3");
            state.setStateCapital("UFMwTTihhuLbsU2OhTrV20i1bZAMHQldizKuPI5fCvljpocedd");
            state.setStateCode(2);
            state.setStateCodeChar2("nWegTeLbTzsPbUgMkNWNsaZUw4Hgmg6N");
            Country country = new Country();
            country.setCurrencyCode("Hkm");
            country.setCountryFlag("NWCUU7DAkAPTStaTzlS7ci1HBEXO4OdBc65uwfISBQJhQFakGc");
            country.setIsoNumeric(9);
            country.setCountryName("KifViz6KMIdbAI5pCp576t3ELOicgO8nL9pVynuTfvcQ1dWX9B");
            country.setCurrencyName("KV5kogjnZg4S2L5KhEcaFowL2Bp9JKIJECExuFeBtWIVVkHiJv");
            country.setCountryCode2("zKd");
            country.setCountryCode1("0Yn");
            country.setCapitalLongitude(9);
            country.setCapital("koBY4ogBIbsQgZ82HPfaNybU6xEA7LxD");
            country.setCurrencySymbol("DcK5K5lx0mqp8ozH45vOjfH4JVzql0bW");
            country.setCapitalLatitude(1);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            state.setStateCodeChar3("ZeenDHULolYFbd7ys0GmKKV1kuMPpGBx");
            state.setStateDescription("cUK21UQWf7R2ypQUKfVa2qwqHpCqO3ze6XgzDNyeUZvTydnyMe");
            state.setStateCapital("LINCNf09EBRG5lA0IKDf7doT4Gx3LKBigSjKiYVYkpmZgvgjGC");
            state.setStateCode(2);
            state.setStateCodeChar2("0zvY6OSGkr5n2J8DgXsiNbP7uSVrSAWa");
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateName("5I9GFJDhJjbEpHEY1N6Wp9to9lGNyODm7Duf1LvoyTRa2OzPDM");
            state.setStateCapitalLongitude(4);
            state.setStateCapitalLatitude(5);
            state.setStateFlag("Wn6gDgLxxqXk1oCbuvlXJhk3fDtxgcmkEVkIuGJRIM3NV5lGCM");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("H9iqmSXtFrMuJkss1RNigdv4Kcm9tlpO0dQ5bpX2UVfMK0TPQ7");
            addresstype.setAddressTypeDesc("ngAWKslmKumJs4JNx4viT0T8vIHyxpQnKo3KlPcnYlBzNnec5R");
            addresstype.setAddressTypeIcon("gFMLZw05i03p5oY5u3Ic769W7fJNPa0tLAW09QCrPR5LFalvx9");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityCode(3);
            city.setCityLongitude(7);
            city.setCityFlag("jstc4Lnl9sUPh0Nn2c7dYFCqoMJRiJ35r8U0CflY4W7QuKbvjS");
            city.setCityName("V43tkroOhmn0qcDwobThXtiBS8JiczyfJA38RvblN0lNttPWYi");
            city.setCityLatitude(3);
            city.setCityDescription("kauSyEqhPjlI8W87uzpTXCdhOvg9Y3RE4cWuKfCRaBn0qmSVJW");
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityCodeChar2("ywmSuBoy4jveSrNczqWOOsrWEmuTolgz");
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress2("VSLy1bTqoooZ1CFIqao4WYy3DPmDpWz27kthFnzGA7ioHrgW3C");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("un5TU3");
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress1("3h1oxWgoPSYSKxEvG4J8z81Eir3ZNLeuyo3pbrdvP0bUxGrDgD");
            address.setLatitude("KQA3LnZfuofPw0pXRkkBZGERZtC7xs4VrL5lyr9OrKJ75LFo0d");
            address.setLongitude("2X0kkVry1dcZsZshIdQcjFAybMJECjlZBP8XfEesKcAoa68sIg");
            address.setAddressLabel("7p9jKCfxygP");
            address.setCityId((java.lang.String) CityTest._getPrimarykey());
            address.setAddress3("ItFNtkQb1EDKOkp9VddBmwNyj30MOaxuhI87n6JMsha3glvOi4");
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
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress2("IEb5imNeNObSxDpskhlHNff3IbMpVzGjHGLcytuoCPlu7TMUCB");
            address.setZipcode("YkwokY");
            address.setAddress1("wQqQ6I87LE4J16Eg80RPjvUQIpL54PhnVXMuSxIrRUee0lfJhn");
            address.setLatitude("hxfpa5JbliEzaRrIImNXbGzpqvTLBnPTQfaXkFtOBU5c7OC1TA");
            address.setLongitude("ag99njgaW3uJ7maeavvs59y8Bff7rpy0yM43sXEafPS0wisILP");
            address.setAddressLabel("da4RHIquk2v");
            address.setVersionId(1);
            address.setAddress3("H0WDUbelqrvaLAtOx1LiSPPIai1HVXDYwVM7iaZ810FjdTd7eY");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
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
}
