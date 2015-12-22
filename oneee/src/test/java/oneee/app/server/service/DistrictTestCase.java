package oneee.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import oneee.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import oneee.app.server.repository.DistrictRepository;
import oneee.app.shared.location.District;
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
import oneee.app.shared.location.Region;
import oneee.app.server.repository.RegionRepository;
import oneee.app.shared.location.State;
import oneee.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class DistrictTestCase {

    @Autowired
    private DistrictRepository<District> districtRepository;

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
            country.setCapital("v1FPipEUgTZL7Rk3ZXFRhADwBOnL31q7");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(1);
            country.setCountryCode1("NSp");
            country.setCountryCode2("tuG");
            country.setCountryFlag("e1te3K5E8HfO9hK8mtTcLZvO5RPZiNKRyCslvaar1f8X7SKY7f");
            country.setCountryName("pKP6Hb9S7sR5FWpgiWTvGTXudkECRaQpUH1cRzLKZvlETCjCdx");
            country.setCurrencyCode("80R");
            country.setCurrencyName("MDboHFEF1wpyHtM8Xd94cW0zPHnZojAqZYN9WNdj6N7t2Ep1Sn");
            country.setCurrencySymbol("0SjnyPA7WqlAPweAju6npQ2fwCiiMChL");
            country.setIsoNumeric(3);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("cTa2CCWuybdD7qufZlQjq2hlilwP0k3iaVItBBu3PiViTifSpb");
            state.setStateCapitalLatitude(7);
            state.setStateCapitalLongitude(3);
            state.setStateCode(0);
            state.setStateCodeChar2("KhGldZ3Sb56YpC6FLFEs123vuh8g2ZKw");
            state.setStateCodeChar3("CsWcUAsupoECAdzXq7AX5WQ3pokczdiJ");
            state.setStateDescription("BmMBKUDzXE7Qs12CdvQZGIA01mZ242cR2Lrq3upRZWG2P2UTnP");
            state.setStateFlag("aXElqwd47ZDdRmeLv3rQN3GuJTP7RdaLuQjHh0QnhP2f7ZWX6N");
            state.setStateName("OMraNSCjsR3lvuTyDpkEu46yzzENjKbGx1L9TbFgg7nteu5hzT");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(3);
            region.setRegionCodeChar2("FNFvLabWTSqcoUirxyJ0o0gTBsLIvGlf");
            region.setRegionDescription("M0VIU5zz80xJkgteiSi4LDIfQbrVa9PXBM3Xb5XR7NZ9ZwQryN");
            region.setRegionFlag("fO03NGKBMrQaONWoSO0ylxzyUx1LoYCoa0lTK8miyMDzdku243");
            region.setRegionLatitude(6);
            region.setRegionLongitude(5);
            region.setRegionName("SvDxt5Jr69KLFPKzJg07z0VRJibjEVldhkOuJURG6Bky19P3eR");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            District district = new District();
            district.setCode2("Du92dNNpLnXV2HkORwjhEsEh5nsI4zo4");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("p37DTs1TXMkZA6GP0zcDZYE2OBDZ0gJkW8zzhnv7SO5dyClG9l");
            district.setDistrictFlag("IkTqEWe8LvJsRCYnvaeedIBN4k1DKTi6jaHL4n4Qk7fsAyYpgT");
            district.setDistrictLatitude(3);
            district.setDistrictLongitude(10);
            district.setName("hvOuyNpNtEYgaAglEq5QabDbStS34y5MFO4You0jhecHnaVBXS");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey());
            district.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            district.setEntityValidator(entityValidator);
            district.isValid();
            districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private RegionRepository<Region> regionRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("DistrictPrimaryKey"));
            District district = districtRepository.findById((java.lang.String) map.get("DistrictPrimaryKey"));
            district.setCode2("PohVUtKADy3kRaIzoEmP4do0QBDT6Hjz");
            district.setDistrictDescription("miEP7il8Zld2s6kVdLQGPghZ2GlxLrAbGmU2YDkkUdjpAEhH46");
            district.setDistrictFlag("4Aazdlx9F2xApexkyUUdwXdM2TIKUY4A9z8l7aapSz29kSO8yb");
            district.setDistrictLatitude(6);
            district.setDistrictLongitude(2);
            district.setName("HuhqdFwFE1XRQNMltYAz6XPUksivoyjivOEmQXao8lCcGooALs");
            district.setVersionId(1);
            district.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            districtRepository.update(district);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<District> listofcountryId = districtRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("DistrictPrimaryKey"));
            districtRepository.findById((java.lang.String) map.get("DistrictPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findByregionId() {
        try {
            java.util.List<District> listofregionId = districtRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
            if (listofregionId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<District> listofstateId = districtRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("DistrictPrimaryKey"));
            districtRepository.delete((java.lang.String) map.get("DistrictPrimaryKey")); /* Deleting refrenced data */
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
