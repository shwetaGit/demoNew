package com.app.server.service.organizationboundedcontext.location;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.City;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CityTestCase {

    @Autowired
    private CityRepository<City> cityRepository;

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
            state.setStateCapitalLatitude(5);
            state.setStateName("hg32hgGmg5oG80T638VOSdXmPiU0qEAHrhX3aUm7ZxQD1OPcGf");
            state.setStateCodeChar3("DceLN9lOUrdOhrKuir3R2lsjKnyBLtNp");
            state.setStateDescription("NFrEQGzVcfbqgrhszjKBdzHYp6QBYY3kh9wVPIC4MCwyQ6wr8Q");
            state.setStateCapitalLongitude(5);
            state.setStateCodeChar2("FiPDyfBwoKuWpY59ViasdkE4dcgg4ypE");
            state.setStateCapital("0xRQvWO7x7FsTjbjuV2ZZCOI2RG4AfVFQnpu0JdxDhaVtg89jD");
            state.setStateFlag("k0ml34lwF0VgkefM2kgAmm9HNM78feAtj8XAd3vEslYyukUzBu");
            Country country = new Country();
            country.setIsoNumeric(5);
            country.setCapital("fYu8eD311osaG5o2u7hfmWaKgDtJvSev");
            country.setCurrencyName("3uwc9ghaZ4gKqxvNkjngniAMkx8I0hxpldDnfhzpBt2YBmPNG3");
            country.setCapitalLongitude(2);
            country.setCountryName("UNJcvbhVRdXGfeB875u5GQwwrKBT0wJrIUdK60LKgkdpRRSisc");
            country.setCountryFlag("NWdiJrJhp41zXPJ12emtaUnzRZqdMJf2VwIc3Ku0HLQswQMk0k");
            country.setCountryCode2("CxH");
            country.setCountryCode1("ZkW");
            country.setCurrencyCode("1Ls");
            country.setCapitalLatitude(6);
            country.setCurrencySymbol("D9nYljeCWVFBDxXJA0YdLa0QitMMkuBG");
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            state.setStateCapitalLatitude(11);
            state.setStateName("Va9sg5En75IygHGm2ugxkktqLd4RcFreZW98rHnpMEiEr4bVLK");
            state.setStateCodeChar3("bXFcT8pKkDuefjGqk85cG2M9auUEM3sB");
            state.setStateDescription("8zaovOUvcWbjZEADKH7RnH76J4em2bFWbaGAhLompxJKoYUdI4");
            state.setStateCapitalLongitude(4);
            state.setStateCodeChar2("HamoH4X663JrhVn34D6C4sVSBbdYDMlL");
            state.setStateCapital("cPvSB1QJp5hCyh0iuUfKCw8ccCkhB7MwBn2B56O3nEK4pYIkNA");
            state.setStateFlag("6snCdvPrJEcAuFH11WZ3Y5rbpqbq2ACvYN08SyHinVgKE3r18b");
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCode(2);
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            City city = new City();
            city.setCityFlag("3zHX2pJky1O9pVlBmIBRSUxbvl6RXGK1eyAuEVjeJ7AkX8hBOm");
            city.setCityLatitude(3);
            city.setCityCode(1);
            city.setCityCodeChar2("sz7JAYFtE8IMcApao1LFwOim5uSGvBnW");
            city.setCityDescription("tccr3BL7pZpHFkv1wmOtac1GmYVXc6KfZ8eX6NKoiZd4BfWnPj");
            city.setCityName("sQKjmSUr5sOTkRUtjsoI7g6gjySTkCcgKUilJ67xa2JpJAH4CJ");
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityLongitude(8);
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey());
            city.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            city.setEntityValidator(entityValidator);
            city.isValid();
            cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            City city = cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
            city.setCityFlag("aIqF1orOaF7AnFbw1L4ooTZpVg1LAvUnBFJLoHLUZWnclEXd48");
            city.setCityLatitude(10);
            city.setCityCode(1);
            city.setCityCodeChar2("5AfEtEFzb5MzRMkdb0M2DleuJzLzFsL9");
            city.setCityDescription("phCE3zXq6rvzSmOl2qbKlsqV1PqjSH70a1rqIBTiwXlblfDlKp");
            city.setVersionId(1);
            city.setCityName("GcmhVohy0x12vji5X14NzV4kOObnYdMKbkdnMpSCbAPv6GC7kT");
            city.setCityLongitude(9);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cityRepository.update(city);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<City> listofstateId = cityRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
            java.util.List<City> listofcountryId = cityRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
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
