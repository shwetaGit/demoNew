package com.app.server.service.organizationboundedcontext.location;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.location.DistrictRepository;
import com.app.shared.organizationboundedcontext.location.District;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.Region;
import com.app.server.repository.organizationboundedcontext.location.RegionRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class DistrictTestCase extends EntityTestCriteria {

    @Autowired
    private DistrictRepository<District> districtRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

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
        entityContraint = addingListOfFieldForNegativeTesting();
    }

    private District createDistrict(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Country country = new Country();
        country.setCurrencySymbol("wSKzrQWpIHIENRZ0RrarFvsIH2a6YGcZ");
        country.setCurrencyName("B1IgQOmRrXSJEs71a8oa597caJzRMfaBbeOIYRkgkumxAV8DOc");
        country.setCapitalLongitude(2);
        country.setCountryCode1("ZGt");
        country.setCapitalLatitude(3);
        country.setIsoNumeric(1);
        country.setCountryCode2("mFh");
        country.setCountryFlag("cIwA9m728TVkPfCMl0rtfIsBHJ5ADskXOmAKLZVAZWDheA8nhk");
        country.setCountryName("jDnDtvvys76fwG11Z4c87F1pETrCmBMC4AMogHIchmW0emzdk6");
        country.setCapital("4qjzJKWz4tZEotfxlnpf3WG4Vpq9aCwb");
        country.setCurrencyCode("OX7");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
        }
        map.put("CountryPrimaryKey", country._getPrimarykey());
        Region region = new Region();
        region.setRegionLatitude(5);
        region.setRegionDescription("ZXdLd17XnR1J5AZrBsVzff1ghzElHtz762TAI0zsrBIiriIUzp");
        region.setRegionLongitude(3);
        region.setRegionName("Ef8f6RiMO7lpDIhZbsGbmmGukYl40g2hOhHi9rqiQ7jfpbuUHA");
        region.setRegionCode1(3);
        region.setRegionCodeChar2("v1pXAYh6EFgcBNYWRiJ6XxWcem0zDcsU");
        region.setRegionFlag("wt9GDnUxedP0cPuLhCUjXxpqxRka92PrHmLfszHmMY2aVIEtrh");
        State state = new State();
        state.setStateCapitalLatitude(4);
        state.setStateCodeChar3("Oh3onjgxj4i6gRUk532fsKlKfc9sEghx");
        state.setStateDescription("jnDTCOZ1rWUjTtmQTzUiWDEBLjtq6i2JPhsILPuCpuTfsWvHkH");
        state.setStateCode(2);
        state.setStateCodeChar2("kaz4z93uuRGLKEGyVJU1hPePob5Dv78Z");
        state.setStateName("B6JhU6JWYRUXflG1F2Bt5l8KFdTwKBPss7LhmRnOwNIWSvQWLX");
        state.setStateCapital("ldoDkPH2En1FCbQKUWjleLQfgK5DhUaoVHvff9gveWrBY83KKo");
        state.setStateFlag("yLRrwFOrwvbA5G5tiifr5t7Eyhog8Rjw5Q2v5qEKri3OdPRqUt");
        state.setStateCapitalLongitude(4);
        state.setStateCapitalLatitude(10);
        state.setStateCodeChar3("JTkHGwzBSqhu8s5PGyW0AILXpzh4GblR");
        state.setStateDescription("pGabWZkcEKpd1MOcCa5S2ey31Q0S63NrHVNYJv2uNPiCe6KAKm");
        state.setStateCode(1);
        state.setStateCodeChar2("tMiaXbZmXiLMqYmnB8gqzE6kbnudRGiz");
        state.setStateName("EuQIdPNpFlSLsUXCdQxW4b4XZ3Z83jTIp0MicEf8Lz2Br69O9M");
        state.setStateCapital("Gy7T5B56dbMsYhRltBKd1qwlv0fzoWZJYcwvBfSGqLUdnR1Vzq");
        state.setStateFlag("xTP9cf1gSsUqKWRyXPRyt5ipV3NVJns2xnFM6HZFaOWSvT4dYF");
        state.setStateCapitalLongitude(9);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
        }
        map.put("StatePrimaryKey", state._getPrimarykey());
        region.setRegionLatitude(6);
        region.setRegionDescription("JmXktew4KoN6uuf2oEgXqELU9mUkGCZmeBQzzDMInZzo1W3MRH");
        region.setRegionLongitude(5);
        region.setRegionName("JZ8R58afKv0fIxqg6BKkhMwHBQCMt2sQRDN0CHk3OlGuiKiplk");
        region.setRegionCode1(1);
        region.setRegionCodeChar2("YIACg16Ol2yT2iYoQ6x4Fv0MOhcJBd0I");
        region.setRegionFlag("j53RUXkN9RBgDdVErYhBA2CFwCLvaOP1JULcNJNlTLCzc85wcd");
        region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        Region RegionTest = new Region();
        if (isSave) {
            RegionTest = regionRepository.save(region);
        }
        map.put("RegionPrimaryKey", region._getPrimarykey());
        District district = new District();
        district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        district.setDistrictLongitude(8);
        district.setDistrictLatitude(10);
        district.setName("vmjElfHDuhoKjy4wBnkzAVluBskYlCH2Cra0sI8oFPfvl5H8lx");
        district.setDistrictFlag("ihRSAyImBMdQ7a6hgYANqnMT92y047pKzL4DAU0R0CPymzzQzD");
        district.setCode2("SOB2Rz2dJj25rN4Umf4FU3cG8G0vonu2");
        district.setDistrictDescription("fo79B4eSqlvFjze7uqzYsqP955puyBymE5ZOyB7BOApZjITuvH");
        district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
        district.setStateId((java.lang.String) StateTest._getPrimarykey());
        district.setEntityValidator(entityValidator);
        return district;
    }

    @Test
    public void test1Save() {
        try {
            District district = createDistrict(true);
            district.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            district.isValid();
            districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
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
            district.setDistrictLongitude(5);
            district.setDistrictLatitude(1);
            district.setName("MHl3JOMxL5cHDTmO4x34uvsDZQM0VHv26SBbmpNEVGZxfbeWSr");
            district.setDistrictFlag("qWSZeyK9lPcke99zqtZfBrralYSWbKa9NcjXBMhMbMcS9auXSY");
            district.setCode2("QBsmouCqq1DFtYHH8SHAU0OYKwT0at0Z");
            district.setVersionId(1);
            district.setDistrictDescription("5NdsDFu9LGPPTdUZnqjfexKXkA8iB4m9ZHm88eI3mlM5colSW9");
            district.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            districtRepository.update(district);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
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
            org.junit.Assert.fail(e.getMessage());
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
            org.junit.Assert.fail(e.getMessage());
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
            org.junit.Assert.fail(e.getMessage());
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
            org.junit.Assert.fail(e.getMessage());
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
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateDistrict(EntityTestCriteria contraints, District district) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            district.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            district.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            district.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            districtRepository.save(district);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "Name", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "name", "5cwSW3Ygt7iTZRbh4DWKk0MrQX1iXNSMgZSesUt928Qw3H3zWMeZiKPIuU1qHkyrTNCfn35fjuPcd2sGSW2967zew2iEgrMUEJjeLwblpXCzdMCn9rkLUGLfLj7c4kc5mgqiR6wpWGZecrRjWUtUJnUOZMzHgp2gSD9ULGlZrWaSCv22ZUCFr46UXvgvS4vEWazoEV2bzQbzAOooyOLBSClvTL2s93Mc063y7uNHy9aXrFPd5h5OJghDp606GpbY7"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "code2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "code2", "8FyhjOYYslmeQtQMz65audwF3B4aKoca3"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "districtDescription", "XTnt5xXPtSOHbc85iN25MaHhPF3aUAPemlW2V0HXKxKaVAkeB69x65Vu9EEmIQ5FdK3UQH83p53q7QA79pWtnIB9mbi09TxHYPFAx8kLbOIFSsplWhrzGMRtqZWY0IZHk"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "districtFlag", "TnKgF4resK3XA2FLcREA1rpDJaMCoGo8CF1FNnwBNPSYhTJLShnrfh6ExOir7qTQZSenCNk51uwx7RyN4mixYeIOCV0KLMoGpyHqfZSmWND2I8lVu13waiWZvSAV24eFz"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "districtLatitude", 21));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "districtLongitude", 19));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                District district = createDistrict(false);
                java.lang.reflect.Field field = district.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(district, null);
                        validateDistrict(contraints, district);
                        failureCount++;
                        break;
                    case 2:
                        district.setName(contraints.getNegativeValue().toString());
                        validateDistrict(contraints, district);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(district, null);
                        validateDistrict(contraints, district);
                        failureCount++;
                        break;
                    case 4:
                        district.setCode2(contraints.getNegativeValue().toString());
                        validateDistrict(contraints, district);
                        failureCount++;
                        break;
                    case 5:
                        district.setDistrictDescription(contraints.getNegativeValue().toString());
                        validateDistrict(contraints, district);
                        failureCount++;
                        break;
                    case 6:
                        district.setDistrictFlag(contraints.getNegativeValue().toString());
                        validateDistrict(contraints, district);
                        failureCount++;
                        break;
                    case 7:
                        district.setDistrictLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateDistrict(contraints, district);
                        failureCount++;
                        break;
                    case 8:
                        district.setDistrictLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateDistrict(contraints, district);
                        failureCount++;
                        break;
                }
            } catch (SpartanIncorrectDataException e) {
                e.printStackTrace();
            } catch (SpartanConstraintViolationException e) {
                e.printStackTrace();
            } catch (SpartanPersistenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
