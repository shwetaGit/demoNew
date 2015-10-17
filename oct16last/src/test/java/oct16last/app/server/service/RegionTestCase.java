package oct16last.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import oct16last.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import oct16last.app.server.repository.RegionRepository;
import oct16last.app.shared.location.Region;
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
import oct16last.app.shared.location.Country;
import oct16last.app.server.repository.CountryRepository;
import oct16last.app.shared.location.State;
import oct16last.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RegionTestCase {

    @Autowired
    private RegionRepository<Region> regionRepository;

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
            Country country = new Country();
            country.setCapital("V07c941946pCDhskTfd0Gg7ZiuoUL68E");
            country.setCapitalLatitude(5);
            country.setCapitalLongitude(8);
            country.setCountryCode1("dle");
            country.setCountryCode2("1z0");
            country.setCountryFlag("tpGP2wOaag1KIsCWcPwt27Y0n4E4xGW8TOlYYXoUNfSMlfNmsW");
            country.setCountryName("VR6M5j6ljVfNx41IG8Wf9mXTMZOQd5hqExbducDtkgTQCeDkC3");
            country.setCurrencyCode("tyP");
            country.setCurrencyName("74vzeW5drnosCf6lctzYD6f1HzR3EKTbBXeuMBSr6mWCTHCpUM");
            country.setCurrencySymbol("JhbtuRsbD9m82Dykuksv2C4GkiWyt4BA");
            country.setIsoNumeric(10);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("sbEPYixlJb3gtE5WZ0b6Lsa9cnYfyZtuthz0KLBKJlOsWZ9kTb");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(8);
            state.setStateCode(2);
            state.setStateCodeChar2("0rbEqFuzNNmNf0cYh3AeGOwJCuvEFVZh");
            state.setStateCodeChar3("aLk9KpUlfXZ21t91MtOX8tONtU4OvbZr");
            state.setStateDescription("wCK0lKNZRfaIu5pkthi9MPrD2Hfrq202mbmEpCTBFULif4q9i7");
            state.setStateFlag("1sznu7TzGFkdmWKrRsv3p3S0so45cWnDbrFsJSsCmFHalXjCEz");
            state.setStateName("FMcNYI5vqrBt0xW6m8MfkW1Gp3qTtcdq61hDr1JLBKII1j4IvT");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            Region region = new Region();
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(3);
            region.setRegionCodeChar2("SHp3K8lt3VZgt5BUBT9N9XwfLS77iyAa");
            region.setRegionDescription("3qsdZ0vj1c6x2RuvMZN3t74GkNTsQo4QjgAFJez1jmIffEfy13");
            region.setRegionFlag("alghe8NE7heJjvnjWO8KmWaK6VaZUXI2JIEmdD7fo9yvziF4JU");
            region.setRegionLatitude(10);
            region.setRegionLongitude(11);
            region.setRegionName("eSkCVzCfbYfjbPDfTOJCJovh1MtxcoDiHqhughewv4LjDyvonz");
            region.setStateId((java.lang.String) StateTest._getPrimarykey());
            region.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            region.setEntityValidator(entityValidator);
            region.isValid();
            regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RegionPrimaryKey"));
            Region region = regionRepository.findById((java.lang.String) map.get("RegionPrimaryKey"));
            region.setRegionCode1(1);
            region.setRegionCodeChar2("ms9MxwE8b28w90GW8OWsf5EgbVZxbrNc");
            region.setRegionDescription("9uuItJybe4b5B6EsRGueyd3yeI6Idqw1pEL0Qgr0kB0JXXPCWI");
            region.setRegionFlag("vF4m9wiJwvcQh5NKfPK0yZN6UzAwZEUuKL2LfCbJxkscI8Tdfq");
            region.setRegionLatitude(8);
            region.setRegionLongitude(4);
            region.setRegionName("0Sxezep0VWmG9bQsdjPpPwGdj1KSZVJQHskf4pWqI3xAPP8Pfd");
            region.setVersionId(1);
            region.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            regionRepository.update(region);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Region> listofcountryId = regionRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RegionPrimaryKey"));
            regionRepository.findById((java.lang.String) map.get("RegionPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Region> listofstateId = regionRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RegionPrimaryKey"));
            regionRepository.delete((java.lang.String) map.get("RegionPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
