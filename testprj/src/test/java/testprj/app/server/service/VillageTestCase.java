package testprj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import testprj.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import testprj.app.server.repository.VillageRepository;
import testprj.app.shared.location.Village;
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
import testprj.app.shared.location.Country;
import testprj.app.server.repository.CountryRepository;
import testprj.app.shared.location.District;
import testprj.app.server.repository.DistrictRepository;
import testprj.app.shared.location.Region;
import testprj.app.server.repository.RegionRepository;
import testprj.app.shared.location.State;
import testprj.app.server.repository.StateRepository;
import testprj.app.shared.location.Taluka;
import testprj.app.server.repository.TalukaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class VillageTestCase {

    @Autowired
    private VillageRepository<Village> villageRepository;

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
            country.setCapital("HfgxKo2a43EcqyIqgcQUszbICV27tBoe");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(2);
            country.setCountryCode1("bwk");
            country.setCountryCode2("F5N");
            country.setCountryFlag("05iFkjO9ItNzpaEDP8VieIf9ORLix8hBkp39nSAOEYjOcYuQm4");
            country.setCountryName("ZcFwaWq388IyBsptAmOzwPayqgEOuZ1Y3O0LPbKZCfcC23duWd");
            country.setCurrencyCode("Akz");
            country.setCurrencyName("JC3aOtgmMfRsrMGEeGKn2QTEOnkrqnXPuMX7Av8JtY0E2ei1ng");
            country.setCurrencySymbol("d4ilkxBzsRO8BaiQSVcNgi3VRWdN18A2");
            country.setIsoNumeric(6);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("d69uXD7VzlujIPQAP7Yfpj6p6jZagMaF");
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("nmxxdbWmGzNBix147eCSpBSGjSk97M0RLxPpy748d4LZTGVo2A");
            state.setStateCapitalLatitude(10);
            state.setStateCapitalLongitude(3);
            state.setStateCode(0);
            state.setStateCodeChar2("Leox4PTxjyEh5CkQhQgBxq5PNTfxavUN");
            state.setStateCodeChar3("hpMmRJC0WYgeef5Wzfu5cH5Op8fvAkQG");
            state.setStateDescription("ZDSEcofigWEp0Jo5WoP2jST5hESf8IRvlYsDwVMbsbtW7CdpcK");
            state.setStateFlag("iNFEE6leGrDWvbzgztpK4Nv9Ch01cd1hYsVMHRtq0vN1KMvcgi");
            state.setStateName("kIup927PIIR0aN4iu13aGMHmxsNOCmAd6xJGEA9mjcpRduMzOK");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(2);
            region.setRegionCodeChar2("zKcFEAmlQ8RwPOtY26hZx6fv4RF6fy9U");
            region.setRegionDescription("MGSJkZS6YwtWv3N3deXXOuFEdypjPexrsukGyF6uLA44TKR6zE");
            region.setRegionFlag("zSTE95sUJn3teMM1Pgv3BZGCIOwCVnpwFpSB8Wytfemszyen7U");
            region.setRegionLatitude(7);
            region.setRegionLongitude(2);
            region.setRegionName("KKx7L7wPMA8AHuV2wbyWRr2J0RyukXTjPrxpwRUC55ojThlnua");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("fS61RRinEeE7CtkU7KTjZmYMJVPgTAJM");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("VYKpcgvJciTQH88Aq4TxIIGe7yfS5kzNYu17EuE13KCjNuV0ud");
            district.setDistrictFlag("MfUH8PHFGZUrBbbBYCXv91mrr2VizPF7BgPbqHVJrCFZlDUsAS");
            district.setDistrictLatitude(1);
            district.setDistrictLongitude(6);
            district.setName("NI5L8bHZt4s2AIDuXhpjh0yCxEzXgvvgL9ZTsaXn9kJnqUuFpM");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setTalukaCode("nK8hEbm8KCylGlIzQ6GRyFIfYP2ClnwA");
            taluka.setTalukaDescription("vDMBg9A95RPXsAzVz3WCYFAmD39oWkt8AfMJfg4oSRumx6Df7J");
            taluka.setTalukaFlag("ECZOACbzHSB4nmYL2Rgg1PLWxvRRelWN4DOyAY9xXfFLfnLexL");
            taluka.setTalukaLatitude(10);
            taluka.setTalukaLongitude(9);
            taluka.setTalukaName("c15bqz4CwHBiMCxiTuwRhYGascMljMTPLAdqVqAV6C9zeY1jqz");
            Taluka TalukaTest = talukaRepository.save(taluka);
            map.put("TalukaPrimaryKey", taluka._getPrimarykey());
            Village village = new Village();
            village.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setTalukaaId((java.lang.String) TalukaTest._getPrimarykey());
            village.setVillageCode("5qSl8hU6OnN9Ms8NUxLHn8BB73cdObgp");
            village.setVillageDescription("224oM0eUGXzRCUVQRG6pJSmiMH1YyUcte2GR1zdejAaDE4nDKq");
            village.setVillageFlag("IDhQz2c7mSuVy4adNoF3b6pmh20ziZK7K33q1uvonXB66iGzLo");
            village.setVillageLatitude("apEdjzNyex6");
            village.setVillageLongtitude(8);
            village.setVillageName("KFqcF3ubUUeW5q1N7XnrkHekveSFzjAkTWSfkv2LbXa6AT2P6G");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            village.setEntityValidator(entityValidator);
            village.isValid();
            villageRepository.save(village);
            map.put("VillagePrimaryKey", village._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private DistrictRepository<District> districtRepository;

    @Autowired
    private RegionRepository<Region> regionRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private TalukaRepository<Taluka> talukaRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            Village village = villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
            village.setVersionId(1);
            village.setVillageCode("5ccTF2NHy3qjYgQOO7maCu7eB5BGhuSN");
            village.setVillageDescription("OEoqeXaEIcmMMBZxJnz6XjvTB1T14lPjmlNgtPGAf0hH9RuF2q");
            village.setVillageFlag("tFOrwLNCWBZmof48WLAqw28Bxaa5o4KmiatJKH7O2jcOSH6Ktp");
            village.setVillageLatitude("0uouG2iv005");
            village.setVillageLongtitude(0);
            village.setVillageName("2SK8bNaRWtB8qfT1Q3t2ySGbXzfvHxKvPdZfMzTQsqa1ag2FLl");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            villageRepository.update(village);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Village> listofcountryId = villageRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3findBydistrictId() {
        try {
            java.util.List<Village> listofdistrictId = villageRepository.findByDistrictId((java.lang.String) map.get("DistrictPrimaryKey"));
            if (listofdistrictId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByregionId() {
        try {
            java.util.List<Village> listofregionId = villageRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
            if (listofregionId.size() == 0) {
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
            java.util.List<Village> listofstateId = villageRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
    public void test3findBytalukaaId() {
        try {
            java.util.List<Village> listoftalukaaId = villageRepository.findByTalukaaId((java.lang.String) map.get("TalukaPrimaryKey"));
            if (listoftalukaaId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.delete((java.lang.String) map.get("VillagePrimaryKey")); /* Deleting refrenced data */
            talukaRepository.delete((java.lang.String) map.get("TalukaPrimaryKey")); /* Deleting refrenced data */
            districtRepository.delete((java.lang.String) map.get("DistrictPrimaryKey")); /* Deleting refrenced data */
            regionRepository.delete((java.lang.String) map.get("RegionPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
