package project3.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project3.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project3.app.server.repository.AddressRepository;
import project3.app.shared.location.Address;
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
import project3.app.shared.location.AddressType;
import project3.app.server.repository.AddressTypeRepository;
import project3.app.shared.location.City;
import project3.app.server.repository.CityRepository;
import project3.app.shared.location.Country;
import project3.app.server.repository.CountryRepository;
import project3.app.shared.location.State;
import project3.app.server.repository.StateRepository;

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
            addresstype.setAddressType("vEN0zstJRwZW4b5IQic3K7U9Ioc5duDVRdeeTrcoRmcOT3unGx");
            addresstype.setAddressTypeDesc("WEpaXPHKxrHPinjjCY4fPAD7XGqPoturUHSUT1RKmbh3ryQszI");
            addresstype.setAddressTypeIcon("YRLTsT8phrtSFAcoxyUiONwxONidzYeasbLangLzTwvHjwMqSd");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("hbvloxciB1VbMOTMemxDfSkO1pgZzTJa");
            city.setCityDescription("ek0jOegVvebdl5hZqwzuUtpr6yWNfBpegO2rdUS0r8CIJEBBNg");
            city.setCityFlag("YcBIQ0cJQHrigbmmZ8zXYEmcF3FV5jz6XMRLFA5x2Dzn9g6A4V");
            city.setCityLatitude(11);
            city.setCityLongitude(11);
            city.setCityName("8OUEU3OqMLfkP7fbTv4Z1LSTn6xQFUQp3vohtiRrodUEShqq0O");
            Country country = new Country();
            country.setCapital("rreuW7Phu73XgIWczoTBMkEHVWZ1OQOo");
            country.setCapitalLatitude(8);
            country.setCapitalLongitude(8);
            country.setCountryCode1("slA");
            country.setCountryCode2("9QT");
            country.setCountryFlag("SbJ8rO32Ghwdv2pA440l5dPdQPawj8ePKldvMArs28h1iPPD8k");
            country.setCountryName("xt0OwsSxo0tJUWHDeKgj7o2tT00eFXhcewPEyO5fzDZoGi3cx1");
            country.setCurrencyCode("DnW");
            country.setCurrencyName("FhckuaRuKxlDoYZWV4Kiwb0QLHEww6TiQFVtwiiVS55NPKpNUs");
            country.setCurrencySymbol("d19rz4biSP0nzTHrhBCzdYsiZJ2nZ7iw");
            country.setIsoNumeric(2);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("CXU0q44VHctnSvJWkeYrjLlXFlETZIT1IiUc67XfRqXKNWBap8");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(9);
            state.setStateCode(2);
            state.setStateCodeChar2("tlAAtCDJfYg3KE1YZwtn5WASxSagU4zT");
            state.setStateCodeChar3("J7JzZyl8WwLxKUFX136X6H1Gx7Aikcvc");
            state.setStateDescription("cHT03vMT4H94BI6yhVROxYuVpH6Spz8ApjagKEkyIfzQsCrmtc");
            state.setStateFlag("QoO8VRCMTPuaGd0fPTRGpZCY5jyB6Tn4SESjkykcIK7K671pgQ");
            state.setStateName("HGlIyAsBFHTZ5DUoaadDzoaNaQckdFPue5uaq5Z2OtAJHfwkld");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("j9IRBq4V0M1TA89mkgnU7Pb8uiXkjJl6");
            city.setCityDescription("AmOXofXBuDF5nxqTC0WpO5puOcfYI5GknHe18kg41xbYaYyhMS");
            city.setCityFlag("AuypBfyGcAeCz0qlfoAAZUXLqkOr4rAiyyeEota00FbOXoxgcm");
            city.setCityLatitude(3);
            city.setCityLongitude(8);
            city.setCityName("nn9pASz7Ew0inT6fcmQtUA1wYSc7tClv8zIEYNm5hsiqocXGdb");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("hSDG1waSiLRhndgS9engPQJZDdMEnKkUNkWpd5TNSANAWBIezs");
            address.setAddress2("ogBBP2n0PRq1OZKEQl1i3AhGbeiPeGX9C5luO9WNPVt2ijouYk");
            address.setAddress3("h4urIkxKEnfof8Ouk9bCnHvMGcAouP0n2hxoKOJZ4geS7CtBaM");
            address.setAddressLabel("ZCEJgV89mvj");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("SG8sS1VnaZYtdr3grUjZbpcx3k7iNg2BjazpK2p6bJutzjpONY");
            address.setLongitude("XpxTaO5GTm24785ggj3YBX8QTVZnYtEKYx18FB1FupeKMlmUem");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("A94TRm");
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
            address.setAddress1("U3KoFILnFCeynVhG72czaHo0XdDtSGJEAFvQrlbGydWRipGdD2");
            address.setAddress2("dikX7azY5agZiPijVA5DmFhwrX32byDZzC3mzTpGQslWJRKw5D");
            address.setAddress3("tSPsr2RwTBeossn3sXvDjG0Vr6guNwUjJVp7qgofdZCe9F6bZP");
            address.setAddressLabel("TwRmQTJBgqe");
            address.setLatitude("0EvmcsfOgxkYTOEhTFTbFRodWJXgySur5kbx0qhSM6SA2mQ5Qf");
            address.setLongitude("9rsLLxkLHbTQNETVlrVN5MSyihn05FRwgFa4Z8SccQPupG1qLd");
            address.setVersionId(1);
            address.setZipcode("4Hf4OG");
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
