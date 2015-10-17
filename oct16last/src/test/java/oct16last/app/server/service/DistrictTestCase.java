package oct16last.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import oct16last.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import oct16last.app.server.repository.DistrictRepository;
import oct16last.app.shared.location.District;
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
import oct16last.app.shared.location.Region;
import oct16last.app.server.repository.RegionRepository;
import oct16last.app.shared.location.State;
import oct16last.app.server.repository.StateRepository;

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
            country.setCapital("txVIHVqEAes3vd6nQdULpu0vOqP1sk8V");
            country.setCapitalLatitude(4);
            country.setCapitalLongitude(1);
            country.setCountryCode1("VOj");
            country.setCountryCode2("49i");
            country.setCountryFlag("1A2dkwfy9pil53IenYlzTYh8uB0WMVSwKZP2RY9OUhbc16N9Ve");
            country.setCountryName("lQpQrkEZCk6EwFJ0x923DXF2LeKtaxSTmiydZo5uTWnEWEPUl0");
            country.setCurrencyCode("3ro");
            country.setCurrencyName("ezTCG2qJjMn58PxwNq7IAJrIORzajYIE3DPhnuXY0IZsGJY14b");
            country.setCurrencySymbol("YXNT0qZLR4nsi1lJHCbKcKdCkYm6DEdw");
            country.setIsoNumeric(11);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("FHAP9xqVlopAnw13EGuT12blGTN0L3j9cwR53FSvC1XUgDWwiX");
            state.setStateCapitalLatitude(0);
            state.setStateCapitalLongitude(1);
            state.setStateCode(0);
            state.setStateCodeChar2("B09XCZaUNJ9seI1CUQXlYLX9cDamD1gp");
            state.setStateCodeChar3("ArhsoFiWUQ5PeKyeUzaHVwLXAcsVkMmi");
            state.setStateDescription("B59LVOWefyipbcrIexMjOOwohpRvVMuWUyKOza0LmwRygk6UQn");
            state.setStateFlag("FqVJUwyVOOrlc8QDgexHaUjo54cm7kYRWq6BZOe7ckttIqGhKt");
            state.setStateName("kx6ywCAD3Omo9KwXAEnLWX2b9HTvrm674l0V5FfXfGkjuTXrZd");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(2);
            region.setRegionCodeChar2("FucbUm4JOibY6CS6935cdOj4H377fi45");
            region.setRegionDescription("oGg3o6fxdZUEXAVVz6dFmICFfOamjhyFR6gFquYhAMpd2uLJVn");
            region.setRegionFlag("Gj6Ny6y10MXlrEJH35kuIeccnIgOFM95S6fDrVBBHBME40DmV8");
            region.setRegionLatitude(5);
            region.setRegionLongitude(6);
            region.setRegionName("acmVIPXu9v3LX7E5HoQDh8qZMYHkGY90IlEvWryVrz2lhxdClW");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            District district = new District();
            district.setCode2("v6zxp5dmVEbCW0IvbwfCMZgypfB2D8dM");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("OJfVCB9AToLfZHji6oG8JhiUdeeXUCRRbHe7ToNDRtRlYejRrq");
            district.setDistrictFlag("d14cRhBFHpwQJbyx9anVKPERJ11ZgvPIWRRMR21fAE53ngx57U");
            district.setDistrictLatitude(8);
            district.setDistrictLongitude(10);
            district.setName("nNxrbdNTTeRSL4lUEWdocvZsB0bYfGao8L4h0icDAuQHIH71px");
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
            district.setCode2("kGV4ruqPmwLIVsTFcKqvTHnFwlD6bmeV");
            district.setDistrictDescription("Ie9DO30vv68qpRoB8f6iDR7fSjXO7JldzdyQ4hDxLwJCsaPqoK");
            district.setDistrictFlag("eAvHPm32RpwOCdrKKipe8j3I3ilq8aIz8LxNIvHv9QXdezHm0c");
            district.setDistrictLatitude(10);
            district.setDistrictLongitude(8);
            district.setName("cmdW7pfcnMD1WkcagjhwUsjuigVVGUPWfmxlCShu7hMK5ERHlF");
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
