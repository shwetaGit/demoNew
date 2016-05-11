package project2.app.server.service.organizationboundedcontext.location;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project2.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project2.app.server.repository.organizationboundedcontext.location.AddressRepository;
import project2.app.shared.organizationboundedcontext.location.Address;
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
import project2.app.shared.organizationboundedcontext.location.State;
import project2.app.server.repository.organizationboundedcontext.location.StateRepository;
import project2.app.shared.organizationboundedcontext.location.Country;
import project2.app.server.repository.organizationboundedcontext.location.CountryRepository;
import project2.app.shared.organizationboundedcontext.location.City;
import project2.app.server.repository.organizationboundedcontext.location.CityRepository;
import project2.app.shared.organizationboundedcontext.location.AddressType;
import project2.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;

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
            state.setStateCapitalLatitude(3);
            state.setStateCapitalLongitude(1);
            state.setStateFlag("wHwXWtitvv5M7YIpgXEdxYzKGXHXKgb27CDibjRm2ZImGUIfYa");
            state.setStateCodeChar2("ytY9tF3D9IxlZWhUKEEIu220KOu8xg6T");
            state.setStateCodeChar3("BoGn7SluYfsLfGNcjl1cvO8BRrw9U2rL");
            state.setStateCode(1);
            state.setStateDescription("uRGGNOJ5YRp83aSKrtcEgnNkyfj8g0TLyagc9QjJUay4vOk5Is");
            state.setStateCapital("UTBMjYuOo3PT8HGoGZwPdeE6sBpY6kXUfdbdINn6oonKPWtFYZ");
            state.setStateName("7yyT9TqMZi1ZdQZJfNWgl9azBElvAg9b4w59xrQodtB3fegmjt");
            Country country = new Country();
            country.setCountryFlag("2LDfCgbkvTGD2IR6xZiHFnTaOARxpeGejsVDPJwFNo0mMPSZyu");
            country.setCountryName("1aWGBwwa2lxeGzZ7GDQZ2PvDD2ywQocUV1cMWXfQv9sWaEPmys");
            country.setCountryCode2("dnj");
            country.setCurrencyCode("Ag9");
            country.setCapitalLongitude(1);
            country.setCapital("gqSH3GSkQcdvYKMLdkufOflfEek3fRCZ");
            country.setCountryCode1("HmW");
            country.setCurrencySymbol("slITcFLgxCvb4tdygk4rd5v8fYinDTsJ");
            country.setCurrencyName("6KuxWIuLQipINKr0DyGwzJicgI6cB5tUVg70bMkpbDreIptc6W");
            country.setCapitalLatitude(4);
            country.setIsoNumeric(6);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            state.setStateCapitalLatitude(9);
            state.setStateCapitalLongitude(10);
            state.setStateFlag("FKnbAmoL2SMAMsm0sukdWlBkqbj6E784Jyyb3uQY7uNBlAiedZ");
            state.setStateCodeChar2("d5ZhDN7hlitoOnRFJVdvMNhi2LOx8lft");
            state.setStateCodeChar3("gpNsnK7q6QUjD2wzM3KQbeIUVJbVrubM");
            state.setStateCode(1);
            state.setStateDescription("XttKE4ENzmTycOm4G6GZVnQZ7atKDYnP3Pt8C70ezPesLGHB1f");
            state.setStateCapital("sgHoueWMFrW1AftoL9wAEId3hcDTETkGXuByDI3O9ZyKxU7ykF");
            state.setStateName("OCfy7aZZgagzJqRIa3FLSmV2jdOrYFMiZNulvULrke8kxdNbkO");
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            City city = new City();
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityCode(2);
            city.setCityDescription("T56TuFSZQJEVJjDZXByhfsCrv2GP5xEd9QfKGZyZ9SV33VGUrf");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityCodeChar2("iiorPFAupEAjSpjfmdaVGqZQRDhhLcnz");
            city.setCityLatitude(5);
            city.setCityName("Fbh8cSIyd2qqWzFcajrrHrEYWsz3Lelvvg6gyhlfJ2GrYwQz3t");
            city.setCityFlag("kYDTGy2KFh7N2YlUZvltEsPHiQsd3iLBqaiSGNE0ee3kY5j1OJ");
            city.setCityLongitude(9);
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            AddressType addresstype = new AddressType();
            addresstype.setAddressTypeIcon("kDaV2dy5Qx5gLysrSFHYhs7rNlLKudduRQrrKCvA0BrZSiTK30");
            addresstype.setAddressType("ur41MJX97PmexjSO2lA0lbxdNHcxH53Zdl6JyaIxucICHGZEc9");
            addresstype.setAddressTypeDesc("wjergQlPJz3yKwQBrjtPtdYL0HIZJSNqWqjxZJTWARzmcf5za2");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            Address address = new Address();
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress3("MRMST6wwONRSKEfTEL8XRLqdYczXjiRqYw5dey9Uq1UMlsz3KL");
            address.setAddress2("8s2MCEr7QXOG4y1VqCV1Qnl76tFmTqQo8WqpzvLZ6TWFxfiq3J");
            address.setAddressLabel("kPvxm71EkUN");
            address.setAddress1("Ph0ISYPV872OKbQsbm7R9D4u3AG2TsLavL0afJalIDzhaPk65m");
            address.setZipcode("QJ0Usw");
            address.setLongitude("LmNmOUTAAzZF2Fw72YNgQv7ThHs4JYpXbqKwxi0XxGRNk993kR");
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("7vmSrltmdXsEpLpxjCpFi9Ann7VNGCXGRaayPDanPunQd45I5O");
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey());
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
    private CityRepository<City> cityRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress3("cZteidY5MmNVP1h6lBe4ymo4sQyiaYOdBZ5yMzlMmjZCjIyr5h");
            address.setAddress2("18G7V2nDmix1MNCmQKr7S7F19o4eIL7CcgXWs8D5v2DeJT8hoI");
            address.setAddressLabel("heROoGvs2p7");
            address.setAddress1("BfP85ksxa8REB1iHEx5HLNITJRvtKu4aweCo42rj1DWWMwZ6Lh");
            address.setZipcode("xncFT6");
            address.setLongitude("lERmVdieyY2yNetSr5uQkoZXCMig4KlYy6nDAsTVW9koEAAfgY");
            address.setVersionId(1);
            address.setLatitude("4IH2JcjqPT1HMwJfiZYYw7BNZDBIaNMDvqCKENk36UfrKZGIrK");
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
    public void test4Delete() {
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
}
