package oneee.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import oneee.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import oneee.app.server.repository.TalukaRepository;
import oneee.app.shared.location.Taluka;
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
import oneee.app.shared.location.District;
import oneee.app.server.repository.DistrictRepository;
import oneee.app.shared.location.Region;
import oneee.app.server.repository.RegionRepository;
import oneee.app.shared.location.State;
import oneee.app.server.repository.StateRepository;

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
            country.setCapital("5Gbq7MTLWMOrR44R7eS1YyEh3YtoJA2d");
            country.setCapitalLatitude(10);
            country.setCapitalLongitude(4);
            country.setCountryCode1("CrO");
            country.setCountryCode2("YmQ");
            country.setCountryFlag("iHuSMdC9M63wIVOoBI3zrcKjFnSqBZpgfB7oxrdOf2xyGOwfPP");
            country.setCountryName("Pki6RfvkqaIcqPtkwxdAa8ZWGN14dAYUoR3oJ3hJ2lrDWEPEwe");
            country.setCurrencyCode("KgQ");
            country.setCurrencyName("pjJFaLJHlAH3R4mcFMhWij5ZpaNmmGVacyHiO3y0yKlGrU8JWU");
            country.setCurrencySymbol("pjME0h15xb6Wa6pbHALD7Ar1fzCuU8Ku");
            country.setIsoNumeric(1);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("kx6EQzPQ0VEAwkaJcCMbTaMndoYirDMj");
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("yEqBg0cDjI2BrDxQqKvXMMIdwf45i8PCbFiHEszeXmc2bLK9Fw");
            state.setStateCapitalLatitude(11);
            state.setStateCapitalLongitude(1);
            state.setStateCode(1);
            state.setStateCodeChar2("mFocrgB70IrjiueIz1QpCt8LdYBIK3l9");
            state.setStateCodeChar3("NAKr79gBZsBUEZwVYysi99LKHkcJ6042");
            state.setStateDescription("aIlL2ituZ2VFub6rdeUZshwSOilxV8kOw027hQT4EGI6dAmw3S");
            state.setStateFlag("oVm8b0Q7IKLLaYlNUCzd1vWMJhGeyH69slgAmHxkfasj3rck7s");
            state.setStateName("fCR8tLq4x43cwm60VcKwz09oV3xul9ZmiW3tJ1hg7apPDq4i7c");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(0);
            region.setRegionCodeChar2("CgFkkNdZRAV3NA1UuGqAoqkzKaSb3zxa");
            region.setRegionDescription("YebuiXXLI9gvQqZnkleFGqCjGvVlKyoTv6CpT4abgqUf9rv1jC");
            region.setRegionFlag("Wh7UqTRa7yF54xcFtkPRPmtPNgWnHU2JJpSVuA8OF40uHV3ja1");
            region.setRegionLatitude(6);
            region.setRegionLongitude(2);
            region.setRegionName("joOUSHGhkG55Fl7Wei7d3Ig4Ev7Rxk73SHP0mLsGt6t7H90Wla");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("8SImsJ7VK54gHY18U0FIeT7TkFiaNoT4");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("FEuD5XBqx5lape7TRvPiOS4ojwofA91Yh6ZhjD8OF052eV2loh");
            district.setDistrictFlag("ZauYZBUJndJZUFbNqJ0S3pE9AZ9jhHeFcN1eCbbPKNAZEeesuf");
            district.setDistrictLatitude(2);
            district.setDistrictLongitude(11);
            district.setName("t60ev8pBFy8s5QO2L59Fl6q0BDdunVYrA9hASFC2UVHQIAckQI");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId((java.lang.String) StateTest._getPrimarykey());
            taluka.setTalukaCode("QYkajIjvyyMTd891PUmTGqgQ4bdECn9q");
            taluka.setTalukaDescription("KjABN68jNiF8Qdxfm36PuknSLwaDJXHT2xx4pkqj8yeWGgRhXb");
            taluka.setTalukaFlag("H3WvACJgg7Jj2xwjPz8dkjTgfDFI0D26wCljQvEZNHNr89XEfz");
            taluka.setTalukaLatitude(10);
            taluka.setTalukaLongitude(1);
            taluka.setTalukaName("NUNwNoCYO0tfPSPewjSmwNXYScKc8gl7ACeEJq8PUujTxs1quW");
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
            taluka.setTalukaCode("lvvd77Qe9WN4Gbs5wfnonufOuXFMy4a5");
            taluka.setTalukaDescription("U9C6cjHIoBmZQaeQElRAWoSzfvEiNVHtg900saE1sOS6CO4Kma");
            taluka.setTalukaFlag("k1fGmDGBTXg2pWKHHbWHaPWbQtaFDpPcGLjoFGa2tni3bgTCD5");
            taluka.setTalukaLatitude(8);
            taluka.setTalukaLongitude(10);
            taluka.setTalukaName("iTfpHcMEss7YYoWWsORevmQIsn6C0iLobviGOLmpMAIaC6cjNa");
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
