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
import com.app.server.repository.organizationboundedcontext.location.VillageRepository;
import com.app.shared.organizationboundedcontext.location.Village;
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
import com.app.shared.organizationboundedcontext.location.District;
import com.app.server.repository.organizationboundedcontext.location.DistrictRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.Region;
import com.app.server.repository.organizationboundedcontext.location.RegionRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.Taluka;
import com.app.server.repository.organizationboundedcontext.location.TalukaRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class VillageTestCase extends EntityTestCriteria {

    @Autowired
    private VillageRepository<Village> villageRepository;

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

    private Village createVillage(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        District district = new District();
        Country country = new Country();
        country.setCurrencySymbol("d6ETdfsUR2GQIymF3jhmlBhg6JaMKbc1");
        country.setCurrencyName("iRpGnULbHbnQLvOiAcpftMmLcAKzQpIGnaWzsd2TVBnwbYXJZF");
        country.setCapitalLongitude(10);
        country.setCountryCode1("hLT");
        country.setCapitalLatitude(6);
        country.setIsoNumeric(9);
        country.setCountryCode2("Lyo");
        country.setCountryFlag("cQjpiSQ3ZaYTJahTB0KDaXEXqm2OnkzIVo72DC0tyMnNnaJuZr");
        country.setCountryName("Nz4lQCz8mSi5DWEneQZMnsPRSrHaD4xmqLteJpL5JHsq3d0czU");
        country.setCapital("7CIhjJjtA2YuC80JJ1MC0ABTBLFVn4Oh");
        country.setCurrencyCode("pnD");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
        }
        map.put("CountryPrimaryKey", country._getPrimarykey());
        Region region = new Region();
        region.setRegionLatitude(10);
        region.setRegionDescription("n1jC94f19JR1DBRNoN7rjsaDBZM31IliFk0TQw8hVygUF7nQBN");
        region.setRegionLongitude(9);
        region.setRegionName("uQG62F11A8ygcehmLBAoBTlYO23L7MPL3Moowl1MJrWr3W72em");
        region.setRegionCode1(2);
        region.setRegionCodeChar2("1BOOCAhoNxHlXO3MvlzpOJK5PfiFIWbZ");
        region.setRegionFlag("8mhySfu0vrO47XjX24H50mexGgHbsLxxPlr5snO9mN1HISAlr3");
        State state = new State();
        state.setStateCapitalLatitude(6);
        state.setStateCodeChar3("OyxE7GQ0UYSdzXklta6sL0x2bp1okAdC");
        state.setStateDescription("37dkviScxPFCpSukKHTZpYj5aPJTzrYxhCIYifTNsBezXnADkv");
        state.setStateCode(1);
        state.setStateCodeChar2("0F6cuBHC6hR9f3S3WRuqYD6rVApMqAwA");
        state.setStateName("UfxVK5eFGlWLcbNg5QHHPi2ZOcxZYkngXogM3waY47Cxqsai5w");
        state.setStateCapital("HfFpPXh5P9BEpPdWgg46CjpxXiNSSpaummMQW8f1P5SHqedPxw");
        state.setStateFlag("MPZbBdPFKcvaYlfyDjGWWyDlIqDTGyPmH2x2Y8OBKzeQUgsVre");
        state.setStateCapitalLongitude(1);
        state.setStateCapitalLatitude(7);
        state.setStateCodeChar3("2WqjDRnR6g0DBBH6RmC7PXzRWvGk8LDh");
        state.setStateDescription("uio3fXtkND1CfCkY1XABFk3r8DkxTVY2tMlxFdd0R4U9asIyuz");
        state.setStateCode(1);
        state.setStateCodeChar2("DhgydiHpVd0tu5fAntIz7Xqg7enSHbx6");
        state.setStateName("LxvkOHMVUThuPG7hEEws81nzkCAyaMWSSjPPMSQbhrcB3JX3ep");
        state.setStateCapital("wYNkCTMz23Z7fghBgQ4NQJc1jRxSS1Uc8uU1zS83w3lZN4ZFzi");
        state.setStateFlag("FlRTzQYJ7d7V9ZnlYJlywVmQ71EECH2pZu9R9uDFyH1F3hlqPT");
        state.setStateCapitalLongitude(11);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
        }
        map.put("StatePrimaryKey", state._getPrimarykey());
        region.setRegionLatitude(1);
        region.setRegionDescription("MdufHmZax0LcRKk2taSbxUxCM1yUQIlI9AT4FKxaaPk4QF2kx1");
        region.setRegionLongitude(3);
        region.setRegionName("GUmbjQ7KHDfvYC0rhRblsYcSVaGnUYPyPdLFR6nYhhp1Lz5fVr");
        region.setRegionCode1(3);
        region.setRegionCodeChar2("ClTWY9tQxmScgaLZJVujaK2IqfanOsdo");
        region.setRegionFlag("0KqyTOULkBX5njxjJoREQWkkSEIUROdrCndw1EaUGdL70Bypbi");
        region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        Region RegionTest = new Region();
        if (isSave) {
            RegionTest = regionRepository.save(region);
        }
        map.put("RegionPrimaryKey", region._getPrimarykey());
        district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        district.setDistrictLongitude(9);
        district.setDistrictLatitude(7);
        district.setName("50I2rLO9BHjEhxr05aQKwOW087QnIFdAalD8kV04EQLTAKY08f");
        district.setDistrictFlag("8xEITreXMpCA734F8jt3okIM9Q3GPTnOzWPlE8BrJDYKFpADBG");
        district.setCode2("wjcWCDUdajJhouOXdQroTld9EvPTTNhs");
        district.setDistrictDescription("VN2zpC1jDNcNCqWsjO0KJzlqD1lX5aueHVzOmKZ8dkUmAg6B7I");
        district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
        district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        District DistrictTest = new District();
        if (isSave) {
            DistrictTest = districtRepository.save(district);
        }
        map.put("DistrictPrimaryKey", district._getPrimarykey());
        Taluka taluka = new Taluka();
        taluka.setTalukaName("Byp3EYkK3Uw6lWO47qKQXpWTYSvapgObrTElVSmxe5VmF7VOET");
        taluka.setTalukaLatitude(11);
        taluka.setTalukaFlag("lL46XHSIKfqeMNsc3Lh7ldHpRZT2OgNiEHvhpSXsXsVOmQPeih");
        taluka.setTalukaName("bDTGShSM1KWoNdxtVwXGj6MBpoYpsDIytvwEzh6BSg9zWMzVNb");
        taluka.setTalukaLatitude(11);
        taluka.setTalukaFlag("pAjWXhOVHKdB7tqcNTqtxwSIjbedgw5QEcdGSDQIP1uh03IJ5U");
        taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
        taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
        taluka.setTalukaDescription("pQmeDdFSWOrgdfBVvNzpiZtcOzvFa9l5ZwQdiMzea2CJmeLCjK");
        taluka.setTalukaCode("FTTTYTQTXxRav4h2PGS1lTXU4KpX1KVJ");
        taluka.setTalukaLongitude(5);
        taluka.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        Taluka TalukaTest = new Taluka();
        if (isSave) {
            TalukaTest = talukaRepository.save(taluka);
        }
        map.put("TalukaPrimaryKey", taluka._getPrimarykey());
        Village village = new Village();
        village.setVillageLongtitude(5);
        village.setVillageLatitude("52L9oHrstaf");
        village.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
        village.setVillageDescription("cAmAGcFKSp0NtCKW1EnDCWv2W2k96Wati8nYv5Weqedga43z92");
        village.setTalukaaId((java.lang.String) TalukaTest._getPrimarykey()); /* ******Adding refrenced table data */
        village.setVillageFlag("K65dlOAjCgzUWxgiAOCpIYa0d4o4Iy1aFElk18uYgenue4JIKL");
        village.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        village.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
        village.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        village.setVillageCode("oBofdqZDqRRgZHi8zilnBmV7zxmAv5Tu");
        village.setVillageName("WXOmkUqJcCrnrok1Mbyd1prDFEeHobqY2k3trwGgSTJnpSn1RH");
        village.setEntityValidator(entityValidator);
        return village;
    }

    @Test
    public void test1Save() {
        try {
            Village village = createVillage(true);
            village.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
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
    private DistrictRepository<District> districtRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

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
            village.setVillageLongtitude(5);
            village.setVersionId(1);
            village.setVillageLatitude("Gq26AY0Irzf");
            village.setVillageDescription("Udmwne4fTrwYmuyFLGRafYENnMndpK2QA8hQ9mF0PHFPR9kB4Y");
            village.setVillageFlag("XlzA6BSdcZcAGjxhklO89sW4GYpmaOHjT3DxWCUzUcfSyrqIcR");
            village.setVillageCode("LAGLHgPlecuQ6R59qHq6zCMEXZggArL1");
            village.setVillageName("t4aFiLDJORkdiijvn78OLkmkLSATYcYWqqcAKD0fyiA6NmmkRd");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            villageRepository.update(village);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
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

    private void validateVillage(EntityTestCriteria contraints, Village village) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            village.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            village.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            village.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            villageRepository.save(village);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "villageName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "villageName", "SLvtrtf6qItlqcVC3sVkCL9H8GlvGY66d3pz9u9GctaKTFpHpapZLDNvxdwPUQRa38bloBHX1JgL8OgwjxBo9qPxozM7JDHArr0jiePAnvgEvknCNkSc0XOorsecevSbGui4fELfgPidLsFHvCLBh4TNPTVueCBqL3F4WQzzgjg3qGAWuEV8bKBZ7h3Kvh7gVJjIVgbWlSvC8kz90EnFmk8NNyiFoDBS4McCbG9dl0LPw1JrufGZ0OZQouKFCiDr7"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "villageDescription", "WmmtjB0dyWKoAz6lRY5K0O3dcllsj0gWP3IqYjgPmDo9TnNNijJgdURqPoz1tQuCbU85p5ezuZ3LcY8Wt8rDKOpNZdjP4uXnKysYBFNj5z8EZmhz0drIBWRckURv2zbKBOSSHKhBYlmbqSl4m99bptY3covSG7TEaMOalhqGL41uJp5NiQafoqMderJNHknjXKAH72Wkqsl6J7QUg8pSmcqqrax9RWt5xYwqWGTBMMwtryxbAwYmXPgOz1LkBZ3cY"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "villageFlag", "8ubdz27pwSmFK0IYUwFV4nFwutDOTkUyzTXgMkkK8xaPhh4hseJcIHgtw1fekKuVr"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "villageCode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "villageCode", "jLQAclLvD3y1hzey2xGXmjDFrxN8PiPWx"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "villageLatitude", "E46zqKZVeliT"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "villageLongtitude", 16));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Village village = createVillage(false);
                java.lang.reflect.Field field = village.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(village, null);
                        validateVillage(contraints, village);
                        failureCount++;
                        break;
                    case 2:
                        village.setVillageName(contraints.getNegativeValue().toString());
                        validateVillage(contraints, village);
                        failureCount++;
                        break;
                    case 3:
                        village.setVillageDescription(contraints.getNegativeValue().toString());
                        validateVillage(contraints, village);
                        failureCount++;
                        break;
                    case 4:
                        village.setVillageFlag(contraints.getNegativeValue().toString());
                        validateVillage(contraints, village);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(village, null);
                        validateVillage(contraints, village);
                        failureCount++;
                        break;
                    case 6:
                        village.setVillageCode(contraints.getNegativeValue().toString());
                        validateVillage(contraints, village);
                        failureCount++;
                        break;
                    case 7:
                        village.setVillageLatitude(contraints.getNegativeValue().toString());
                        validateVillage(contraints, village);
                        failureCount++;
                        break;
                    case 8:
                        village.setVillageLongtitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateVillage(contraints, village);
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
