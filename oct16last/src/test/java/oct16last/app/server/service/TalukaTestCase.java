package oct16last.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import oct16last.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import oct16last.app.server.repository.TalukaRepository;
import oct16last.app.shared.location.Taluka;
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
import oct16last.app.shared.location.District;
import oct16last.app.server.repository.DistrictRepository;
import oct16last.app.shared.location.Region;
import oct16last.app.server.repository.RegionRepository;
import oct16last.app.shared.location.State;
import oct16last.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class TalukaTestCase {

    @Autowired
    private TalukaRepository<Taluka> talukaRepository;

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
            country.setCapital("po6g142XSv1MKyePygXXteDxUGkpmDXG");
            country.setCapitalLatitude(6);
            country.setCapitalLongitude(5);
            country.setCountryCode1("bal");
            country.setCountryCode2("4k4");
            country.setCountryFlag("siNuqELtactDaqcjtLbk1ynCKhEuj5JVwTODLVqC20F2oK69Wa");
            country.setCountryName("wUlXFoBPph1cM1t6EKg92M0117A6WWQTuBoXC3rkTVq65kwd4b");
            country.setCurrencyCode("air");
            country.setCurrencyName("WirDcpCuegmE7evxzFeH2mQg2PGGBqXE4if0CcjQ904yMdZIMf");
            country.setCurrencySymbol("u0SynpGgYNT8v3WnBXgQ5zGCV6BxQxL3");
            country.setIsoNumeric(6);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("gnRfKPTXtcypE1D7ABWTfJeFslh4G4Yh");
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("3CGLO3DU69awwNUQTzI0fmk0Y4W5gexMqOlaO0vTQPi85U0L6d");
            state.setStateCapitalLatitude(4);
            state.setStateCapitalLongitude(4);
            state.setStateCode(0);
            state.setStateCodeChar2("GiHLlAitO9QklHIRT05xdz1Ap1KHw25G");
            state.setStateCodeChar3("oAxInaAeRkIPXhgEx1AJaksCUteR1n1s");
            state.setStateDescription("L3HUDSbneKc3zvtx1fvZGJjxJ07MsPENxlxdwasTFHGUR0gYZw");
            state.setStateFlag("A8xdrg2RKdWHbxok3igbaBUav9JdIf9P5Th6D1T0Ehl01ARpqQ");
            state.setStateName("1YgbULZUUubXiLEqclEupZhllXfFl0p8248VdUnKZS0SHJfm8v");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(2);
            region.setRegionCodeChar2("fK30nUcQdtR5EYZIOuTChOTSqEQwgrpt");
            region.setRegionDescription("24iqGcijUrpp6ViPt1gTsV1yhYjJA1hb2xbBiiOnhiS4cVCDfj");
            region.setRegionFlag("ObPJOkR4VK3MtN2muoSt1heYoZz9ANM8kLejgTquqKEziGJKih");
            region.setRegionLatitude(0);
            region.setRegionLongitude(11);
            region.setRegionName("BJopDe9wxNYRiq9cDqwx38WmppRK8QpYZlczFBOoQ0NoA4lQT7");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("TWHXmGd6YuOME6lG6RTJHGD519aTJl73");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("L6DF80AiK4RRciyF5QAdEgKCaPs0gGJyqII649mhTmmj2sCeha");
            district.setDistrictFlag("rBHTfIaYKhed2ysfHeZ5kEQdUfygBpEc2B13gTxoHlkts5H8wW");
            district.setDistrictLatitude(3);
            district.setDistrictLongitude(1);
            district.setName("BNVZiszKxyHri7Gh9Bk8YyMZZizgbNfLX7T2fOJlVQMsTUqoKJ");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId((java.lang.String) StateTest._getPrimarykey());
            taluka.setTalukaCode("TsnzGmuaHGcSPzETDq2w3v2sl5WZIqM8");
            taluka.setTalukaDescription("tpAm4nlizRSjhNUr1ml5PAP2rHDZB3JPhl1ct85c066TtneLx7");
            taluka.setTalukaFlag("qsViC1eD5PAuLtCUfwtEFEZBy3lk8XnXKvHflsdW5NWrcjvAms");
            taluka.setTalukaLatitude(8);
            taluka.setTalukaLongitude(11);
            taluka.setTalukaName("48Wnq0QlvJxn88xYFuMvQa3WebSOpTlIQco0bm714d2rVyqUrU");
            taluka.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            taluka.setEntityValidator(entityValidator);
            taluka.isValid();
            talukaRepository.save(taluka);
            map.put("TalukaPrimaryKey", taluka._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
            Taluka taluka = talukaRepository.findById((java.lang.String) map.get("TalukaPrimaryKey"));
            taluka.setTalukaCode("avgaz4CLlGp38jw8FxvZ8Dq1bFRwurxe");
            taluka.setTalukaDescription("EnzCt7nMnZQPjpNFD3FRZR05EBgUDdKNgH6ug8dPLcf1hmdpR7");
            taluka.setTalukaFlag("0Y4g4Wu5AQBQk5Yw0I1dRIgQ6xdmB3852K9F3jKXoKWcq5vL4p");
            taluka.setTalukaLatitude(8);
            taluka.setTalukaLongitude(9);
            taluka.setTalukaName("Mn3WqgwppmiqPwwUpSzCiBfI74E5kQRnd22ibxdzhLE2sVCGdf");
            taluka.setVersionId(1);
            taluka.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            talukaRepository.update(taluka);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Taluka> listofcountryId = talukaRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3findBydistrictId() {
        try {
            java.util.List<Taluka> listofdistrictId = talukaRepository.findByDistrictId((java.lang.String) map.get("DistrictPrimaryKey"));
            if (listofdistrictId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findByregionId() {
        try {
            java.util.List<Taluka> listofregionId = talukaRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
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
            java.util.List<Taluka> listofstateId = talukaRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
            talukaRepository.findById((java.lang.String) map.get("TalukaPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
            talukaRepository.delete((java.lang.String) map.get("TalukaPrimaryKey")); /* Deleting refrenced data */
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
