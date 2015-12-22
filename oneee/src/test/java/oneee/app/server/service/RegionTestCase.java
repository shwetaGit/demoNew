package oneee.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import oneee.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import oneee.app.server.repository.RegionRepository;
import oneee.app.shared.location.Region;
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
import oneee.app.shared.location.Country;
import oneee.app.server.repository.CountryRepository;
import oneee.app.shared.location.State;
import oneee.app.server.repository.StateRepository;

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

    private static HashMap<String, Object> map = "new HashMap<String,Object>()";

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
            country.setCapital("UKAugkwgvsjXG4j8lyv6peFyRma3AgWJ");
            country.setCapitalLatitude(7);
            country.setCapitalLongitude(0);
            country.setCountryCode1("8jJ");
            country.setCountryCode2("6sp");
            country.setCountryFlag("fvrdbFeexksPbPaZpMDztGcsKeA5DuTkRVI1JHPsQUTU9h3tLJ");
            country.setCountryName("OvZHUyUrePwPc7qOzVjTli57crDrj5S27QVSsxHmBSKnhTapl6");
            country.setCurrencyCode("pfm");
            country.setCurrencyName("glYN7gx7mTm2g9AkPfy987ytLZxvWfMGgetjgEgHYgpCplVx5a");
            country.setCurrencySymbol("6wILfzSNPVoey3v3nviwiaunAqKSdN8P");
            country.setIsoNumeric(5);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("nqusUH9WkGMBhyTCU8xSUCAKkKFXlvR8WGo1UHe33r9EO0VVYC");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(2);
            state.setStateCode(0);
            state.setStateCodeChar2("RjWo6qeFNwGOdhO9VSZRbVz2CitF7xs8");
            state.setStateCodeChar3("t6nYKsUj6lEDtR0XKO9XxOLG3oqHiwXF");
            state.setStateDescription("iHuHmQL5X9jaLfacwH3g3CgWNmD0Su4SCz9xwQbJo7TDHJRMUp");
            state.setStateFlag("XTwToXdJmzjPU9BfapmS33o4UXhYQh7UvQI5M38L5mmzvxEH9N");
            state.setStateName("T084qpxdmS6gJtxpnWMyMVEK9MgMhXaJhUUJNvpn4Lk6gantly");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            Region region = new Region();
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(1);
            region.setRegionCodeChar2("MBaAoLvJQuOotNFzR8zP5Mbxk3z86Bi3");
            region.setRegionDescription("HPjQ1ufwwiEJnjVOwYfur9IrLkMD4t46c3rMmSdIboYp9hyCES");
            region.setRegionFlag("Bk2DQ9wy0GKhn0QUB30tBTSCuBoSAcB8DyvbSKcoNWLUyiTBqE");
            region.setRegionLatitude(11);
            region.setRegionLongitude(1);
            region.setRegionName("Jdbuerb2huqXVXBEGFQTLfx7A6Epnj6QdEXukrLkomtJ4pRoYw");
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
            region.setRegionCodeChar2("MN66K7ST5Ym6CibsenI7OtLP8LHLKU7b");
            region.setRegionDescription("3VNlxZx8UL30ZZFUo6tUNMMb7fdTWd9oEa1RtEDEPn8Vxi56pS");
            region.setRegionFlag("sS78F3sRRP5F1SBgrJ8wfcTQBmkla4RVGQi1wsQ2NYrAK3gOqo");
            region.setRegionLatitude(1);
            region.setRegionLongitude(6);
            region.setRegionName("44UYkp01gF05gyLgHvuHAhA5kYYwtFbhybCvgvFfzcHjPOTbp2");
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
