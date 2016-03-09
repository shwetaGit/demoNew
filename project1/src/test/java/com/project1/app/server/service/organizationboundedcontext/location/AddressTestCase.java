package com.project1.app.server.service.organizationboundedcontext.location;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.project1.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.project1.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.project1.app.shared.organizationboundedcontext.location.Address;
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
import com.project1.app.shared.organizationboundedcontext.location.AddressType;
import com.project1.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.project1.app.shared.organizationboundedcontext.location.City;
import com.project1.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.project1.app.shared.organizationboundedcontext.location.Country;
import com.project1.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.project1.app.shared.organizationboundedcontext.location.State;
import com.project1.app.server.repository.organizationboundedcontext.location.StateRepository;

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
            addresstype.setAddressTypeDesc("GRYGuVJBVk7w7UF7gjYB8tEz8gPvN92Ler5WR5SfJ1uvZtDRm2");
            addresstype.setAddressTypeIcon("qF91vTDDc1QJKYyWEyz5iNjOYGP0v7twxvp0P2v61s8VwSyW00");
            addresstype.setAddressType("mNqArwXwFXzFmUNUpRVMxmecFh4UmCX4ape6hP7DVSsi8PMqUH");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityDescription("3UdZLWFLupW6mEsZFiIJdKOt9pTmS9qbVB2vuJYswVX3g9wlMq");
            city.setCityCodeChar2("UQ8udXUK5aXUYtZIZeSYIsSJBF3VspN8");
            city.setCityLatitude(4);
            Country country = new Country();
            country.setCurrencyCode("mV2");
            country.setCountryCode2("R6q");
            country.setCountryName("UzxZgrCShAXf7X3jDvIb0qTPar7XS5nYwKoDLA9dxjilYi8dTt");
            country.setCapitalLatitude(6);
            country.setCurrencyName("bbmgSTXRCE45GYFLDqDPGsJwlqhxHKHZuPe5vMveUgd91VqytX");
            country.setCountryFlag("830iW5XQUgBs1CDDGAUGAnnhtCDBIT5DyxeTLjD6S806yotm0m");
            country.setCurrencySymbol("GReIiYqAszcCN29xC7OYeqrMMMrxdk6s");
            country.setIsoNumeric(4);
            country.setCapitalLongitude(11);
            country.setCountryCode1("dFW");
            country.setCapital("biggsYQFf07anwC04kyVYzUZEgFYFR4z");
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setStateCapitalLongitude(8);
            state.setStateCodeChar3("I8U47jOKEmViSowfpwCOaH9TFFoCLx3L");
            state.setStateFlag("GkyyB7J1hVJGfPLxwPGPvBAzad8DWZjYmNXisgBge4cgrEwPq7");
            state.setStateCapital("4vE5uKFGqVj62XSClcrPeFgJKnjtppdAibkWXR5LQMVXLSYj0D");
            state.setStateCode(1);
            state.setStateCodeChar2("77vXwsHcZwxmtL2DzL603WpRjnX6salS");
            state.setStateDescription("yOrFsCegEHAKxmqRHnBF2RBKLNztKbFRCzFCNJDMLEDV3zUsXn");
            state.setStateCapitalLatitude(3);
            state.setStateCapitalLongitude(6);
            state.setStateCodeChar3("b1tGj7IvgNjKqV0J2eb3tOKf3zdjl7B9");
            state.setStateFlag("YamvBZk01Xzwbjj2ZGwdL5taSBhKhyMQ1bKFX8qnzjgbgsh5Ds");
            state.setStateCapital("lxn439TtXm757LYrbZ7nBEfun0qdxdXkWQrhVkYq1SAKwaKNnV");
            state.setStateCode(1);
            state.setStateCodeChar2("DkFcGt6f9hcZEyE4ZjzfR5aXy0AlZ2X7");
            state.setStateDescription("rmf0n2dE6ggxBAbTVsWxVRqkmK3X4Y19BYvzfPWUTx7cjNTt5d");
            state.setStateCapitalLatitude(1);
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateName("vmDTdLRCMKQIitzeHNHnXVeeOLuBzO3w8kcpr9fuZGC6BkrRCv");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityDescription("eQMS2DPihrGGDMrGZp9KYKVIDELqQywRNCiTRIVTJikQjtYeYp");
            city.setCityCodeChar2("I6QPBaIJUHyYLZ8ajchkKvu2mnQWQkt7");
            city.setCityLatitude(9);
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityName("BVIBTPUJKJwifMO3XcjtS9E1CouHi7Eh3Osm5g9ZJF8pwlVpfh");
            city.setCityLongitude(2);
            city.setCityCode(1);
            city.setCityFlag("kfbTW3MV859NhaNodRoRjE6OFgt5FGkLqL1kUuSjae53biWqzr");
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("cBHQPW");
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress2("jIKVD9YqX6inp1m2VejaCCDxl4wgXddJ8AceM0R8wEyvHDXV1u");
            address.setLongitude("qBcf5JyQlZdi4y9zTpdJeA11xga2rJBTcstgzEkCGowMYFHhx8");
            address.setLatitude("CQcU3UiBvnIhA2QnhVGAQ5KPrL4UKgyTXKJD0VV3myKSz9QreS");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setAddress1("m3nDCCMMEBRPvvus5OSGcPw0r94fmm1E1dLsaQGlJOWc52xQP9");
            address.setAddressLabel("sJeHteuPXXh");
            address.setAddress3("2Ln64jCyJ3xRvCzswDgKRtMMh8oRkB7sBscKWd52Lfd802q3UW");
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
            address.setZipcode("56jeli");
            address.setAddress2("3z7vMsZf0XAaf6enbDu8dPxkGrrYBApsEzsFy9uoC1V2rk9I3b");
            address.setLongitude("1XIiH7IcvGaos55ueP3rAek800qsY1nwA9XwIDzMy69lwgZcMY");
            address.setLatitude("IC5H2LRtpIJGwomD0omThD44kmHrGBubev7pPwoUwAyqAVuIzM");
            address.setAddress1("L1EaqS6gZWP7VULQmfSh94PFq2BDBdapfxMikwUFtLfgLlcQQA");
            address.setVersionId(1);
            address.setAddressLabel("3kU3pSfg0mg");
            address.setAddress3("YcBuOCzwGJmT9EEstReHyypsd9sEWlmhTttNUH1pwIF19K5s3t");
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
