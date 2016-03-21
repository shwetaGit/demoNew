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
import com.app.server.repository.organizationboundedcontext.location.RegionRepository;
import com.app.shared.organizationboundedcontext.location.Region;
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
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RegionTestCase extends EntityTestCriteria {

    @Autowired
    private RegionRepository<Region> regionRepository;

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

    private Region createRegion(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        State state = new State();
        state.setStateCapitalLatitude(5);
        state.setStateCodeChar3("LqVKDOM4JWq9YDzbTDI6BPImjVEYQ4Pn");
        state.setStateDescription("sBI6M9UFkrXzYkWDAVQvdhz1LcU1NORcJHwirgbxBfjVuoqaoV");
        state.setStateCode(1);
        state.setStateCodeChar2("yopFXrzfwu9Og9zq7c7KsUpjR2hKLGjT");
        state.setStateName("Z5u4VjYgbyUapXvamX5Py5jjEiZzU3E1JeArpANSZnSVfTEbNp");
        state.setStateCapital("n28ZOFC9xpQMSVaXRaRyMEIYeGWfoBLqGnaA8fAmdp5tukFgeA");
        state.setStateFlag("0X6dbNEIW4S7hbk2CNfZSF1CqQRw2PBsJoTwSehOMPGfymbIh7");
        state.setStateCapitalLongitude(7);
        Country country = new Country();
        country.setCurrencySymbol("YyYWe3Q2Ik5Kx8Mg18hiZWbAadjw2xD3");
        country.setCurrencyName("2T1jDfwrXIvKV2XGXd69nuALDoR16fsgrUBuhmwKmsI5Jkzp08");
        country.setCapitalLongitude(7);
        country.setCountryCode1("4Ah");
        country.setCapitalLatitude(10);
        country.setIsoNumeric(2);
        country.setCountryCode2("xkw");
        country.setCountryFlag("Gt9mr4UyuIbJAhMvMBYaPWoCN9a3eCas4H55KHZVGqP3LN7WrD");
        country.setCountryName("41Ji8cae3wYtMW0mveYETuA7iYwFCF6wYoP9Cg668Nik7EFKgv");
        country.setCapital("7ALERV6yA5xeakIUom0sHH7aK0ZBy4kl");
        country.setCurrencyCode("cou");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
        }
        map.put("CountryPrimaryKey", country._getPrimarykey());
        state.setStateCapitalLatitude(11);
        state.setStateCodeChar3("7ocgi1PAkjiBhHCA7dtgFsf4KjLxDDYe");
        state.setStateDescription("g4vkmF2ckdiHumE2Hf1xFvFmRnvBWHtlTDtnQBbe5cyVYZFRtU");
        state.setStateCode(1);
        state.setStateCodeChar2("LRv2oEx1LcmZ0333TdBWQXU1UpPJbNh8");
        state.setStateName("j0PgNpuNUgrEsCB06SZM7afdIJjCSpa41y5GX9FQbKlU8NHvmZ");
        state.setStateCapital("IUSeloriEg26JoCsx4zU5cMeYx8noAlq0trtCTyGuhNCDgEFTX");
        state.setStateFlag("7U73UmuBh7wYDRVz6yLTDbMZNt10KlZZ1OiiIuXZYImWlxHFeE");
        state.setStateCapitalLongitude(7);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
        }
        map.put("StatePrimaryKey", state._getPrimarykey());
        Region region = new Region();
        region.setRegionLatitude(6);
        region.setRegionDescription("ZPSh7j83vTY66SjJb4tfa2jrzhwCj9KzzrmEAypAlqd0mRiHoB");
        region.setRegionLongitude(7);
        region.setRegionName("6bCV38ueWD8b6GloshwoSRKyo8i7x1iwyigcQbUxsPn1VnD4mL");
        region.setRegionCode1(2);
        region.setRegionCodeChar2("wEZTXI3QGahmKQpG3StYTz0TdzpvrZaj");
        region.setRegionFlag("z45mvmOSIBTqnGmIdM1ZBcI3Z950htkPRq2ac0RbrDq3HJUJCq");
        region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        region.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        region.setEntityValidator(entityValidator);
        return region;
    }

    @Test
    public void test1Save() {
        try {
            Region region = createRegion(true);
            region.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            region.isValid();
            regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
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
            org.junit.Assert.assertNotNull(map.get("RegionPrimaryKey"));
            Region region = regionRepository.findById((java.lang.String) map.get("RegionPrimaryKey"));
            region.setRegionLatitude(3);
            region.setRegionDescription("nkTriO8AHpoa1MRpHU8DWIRd86SdyHP8u2jeospQiCKCz8qy47");
            region.setRegionLongitude(1);
            region.setRegionName("kSUAECHCPej7EA8y9TXe6QfjT4Bdhn5ZCMysjMDJYBqwCbYVRP");
            region.setRegionCode1(1);
            region.setRegionCodeChar2("laG2aAUv0z5lEaNEqQdi3UxGFJ5DIQbY");
            region.setRegionFlag("mSV9cAQ9Njpc2vrISKT6UmGXlWQEB40UOEWUnyseeIJzvXlXcA");
            region.setVersionId(1);
            region.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            regionRepository.update(region);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
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
            org.junit.Assert.fail(e.getMessage());
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
            org.junit.Assert.fail(e.getMessage());
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
            org.junit.Assert.fail(e.getMessage());
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
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateRegion(EntityTestCriteria contraints, Region region) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            region.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            region.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            region.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            regionRepository.save(region);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "regionName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "regionName", "Za6SiSWjBhq3KQ5YPTZlGmSUFinfVE5aqdSyfpWkcZf6DV6ASVlmZc5RbuskhB7oSmm1h1hPt4HjbvMewUoyP1gT4Oa5rggQJL1MOuUCmV3Yq6rD3MKg8tli3MDRLJDLHZwsesVZzLtoXheSsfodrhqOevZJsDaeA53BjV0mn2Ar80EhJ7FoOt61x9c8ePRJhVyciAKBLmx3HjMtJMI3gNV6LwCGhZXX2UpZzczqtEKzm9e4nPQ8kQTsANLi1hiSI"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "regionCode1", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "regionCode1", 5));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "regionCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "regionCodeChar2", "qEdezF8F16oT9Yhvg10oFWZLz1u2HoGoD"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "regionDescription", "9fPIh9aNUZoFoOKOx1oyDcZLWrLU8S9pCg85hQoPAT2TVMBgTUPdtK2bijcxousgL9wWtJQTRbFIaRr2Wc797n7Rjbz6wrNkYPDuAjXTo6BhstvZ376afyQ86V6XXbFwf1dI8WZrR9YslipWBk2OAzlV77PnxOPp6DSuvBFp1JY9ISAREFfgNykRwC59gmQwxksEPNBBrUUqezQwL5FxCfxC61cx5P5PvUdBbOPDCVm0PdFwM5yHLslGOHRjktEiU"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "regionFlag", "EI3w0AXTCGKD0LOwI5GMV4s5RPt1bAj4wL8NhFlAAKgoSyYGB2fhaXF56hQYBqHEXaZKbO0Vvu00IlykjNIDlRTrtEBV45Z9BTbkigalkBwaMOnQ7VrGsHySiAknsIO0g"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "regionLatitude", 18));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "regionLongitude", 20));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Region region = createRegion(false);
                java.lang.reflect.Field field = region.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(region, null);
                        validateRegion(contraints, region);
                        failureCount++;
                        break;
                    case 2:
                        region.setRegionName(contraints.getNegativeValue().toString());
                        validateRegion(contraints, region);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(region, null);
                        validateRegion(contraints, region);
                        failureCount++;
                        break;
                    case 4:
                        region.setRegionCode1(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateRegion(contraints, region);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(region, null);
                        validateRegion(contraints, region);
                        failureCount++;
                        break;
                    case 6:
                        region.setRegionCodeChar2(contraints.getNegativeValue().toString());
                        validateRegion(contraints, region);
                        failureCount++;
                        break;
                    case 7:
                        region.setRegionDescription(contraints.getNegativeValue().toString());
                        validateRegion(contraints, region);
                        failureCount++;
                        break;
                    case 8:
                        region.setRegionFlag(contraints.getNegativeValue().toString());
                        validateRegion(contraints, region);
                        failureCount++;
                        break;
                    case 9:
                        region.setRegionLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateRegion(contraints, region);
                        failureCount++;
                        break;
                    case 10:
                        region.setRegionLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateRegion(contraints, region);
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
