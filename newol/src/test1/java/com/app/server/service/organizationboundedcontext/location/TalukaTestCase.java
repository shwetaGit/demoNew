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
import com.app.server.repository.organizationboundedcontext.location.TalukaRepository;
import com.app.shared.organizationboundedcontext.location.Taluka;
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
import com.app.shared.organizationboundedcontext.location.District;
import com.app.server.repository.organizationboundedcontext.location.DistrictRepository;
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
public class TalukaTestCase extends EntityTestCriteria {

    @Autowired
    private TalukaRepository<Taluka> talukaRepository;

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

    private Taluka createTaluka(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Country country = new Country();
        country.setCurrencySymbol("Clbad39EBy2LBYepwG7meuU3u7fBjTk7");
        country.setCurrencyName("XfZudXtbTh4ByDcCfKwMQePVQdMcfpaZwLRsqtWkT01eIEPNt5");
        country.setCapitalLongitude(7);
        country.setCountryCode1("pbd");
        country.setCapitalLatitude(8);
        country.setIsoNumeric(4);
        country.setCountryCode2("NM9");
        country.setCountryFlag("KwzEnW3TNQMI8mnNVpecua2znFP3dnMHN1OjaGBRtA2GkEkDzb");
        country.setCountryName("AIjCBq3PLNfLAcdPsArM478ylzVbz4NIaRzbjSdDzmUqWmdaI6");
        country.setCapital("nwTLACf8z66qwvHlvG405kkSntC27XDo");
        country.setCurrencyCode("MP4");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
        }
        map.put("CountryPrimaryKey", country._getPrimarykey());
        District district = new District();
        Region region = new Region();
        region.setRegionLatitude(8);
        region.setRegionDescription("c1Yeu9LIwALQYy7DQUZEKQ99w7xqlMXohYX951Do3aPXo5Cg43");
        region.setRegionLongitude(9);
        region.setRegionName("zzwE5ZDBFbIehvB5mvSkx2qyXjlVs1DONTdcHVJWp3kWdi1wks");
        region.setRegionCode1(1);
        region.setRegionCodeChar2("974lIbKiBXAYYZtw1NQgKcLBRdkISXCy");
        region.setRegionFlag("yvCM5lzHl6Ut3qFiBz4QNOEjuIJzEjl9hGLEpD8JLBUK7V6buJ");
        State state = new State();
        state.setStateCapitalLatitude(2);
        state.setStateCodeChar3("K2NTcn8NcZCy2TXcYfYUs5nWKL2YmVIN");
        state.setStateDescription("xE1Xp5amQbZvXMjzOYnGiwu6jrnimJpVkwwm5fiBuMBYFfqSmt");
        state.setStateCode(2);
        state.setStateCodeChar2("GDt34ceY6vZAUsF5BPr1kFA2Q9pusEuG");
        state.setStateName("CQXQpGwbNWRBXgcq0mEf3noIKJU8vsyCSsHYt8dEATAkJND1E6");
        state.setStateCapital("9GGbCXsbON2qA2A1pHlVV3BN5ty6QTpy4mqLy8thUPYuIJiGjl");
        state.setStateFlag("yOc9JzjII81pvI8ruxMKBM8i3cBuPS9ouPK2u7bjkYiYuobt8g");
        state.setStateCapitalLongitude(4);
        state.setStateCapitalLatitude(1);
        state.setStateCodeChar3("aHTH3iJsQJcs3c9HZ6HsKw1aORyW3qi5");
        state.setStateDescription("I0AC1GPRB3VYSxbFBiHXA3PmI5p4Zeypw42KzUnPzzFjwbzooE");
        state.setStateCode(2);
        state.setStateCodeChar2("uomTYe23wPv2aYEQ1owOuutihy97AIiF");
        state.setStateName("VYIGZfbzWSZGDSS9ca3SWbhDrHy9q349VynyGF5Kekg8Tx0rSD");
        state.setStateCapital("ngHG86VjCv1GPhuE02OMM3cRB23tlRbCDYqYOamV6B1JVkYROe");
        state.setStateFlag("c7ivg2V2VHNPwN2lVRZmv3aR145MkSPy9iIv3aZHz61BBHDR77");
        state.setStateCapitalLongitude(7);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
        }
        map.put("StatePrimaryKey", state._getPrimarykey());
        region.setRegionLatitude(6);
        region.setRegionDescription("YshDMPxGCa3Mnpqjuy7TB3mMxsfjmSEsJ5L1H6T2326R8JNw8W");
        region.setRegionLongitude(6);
        region.setRegionName("93bn04AxEYwTfNZVRYeEgx1NyGLP51VDRvrXWNLLh8RUXled78");
        region.setRegionCode1(2);
        region.setRegionCodeChar2("W1JWz0QXZ3sja5KfxLG5d9PpZ0PiPugR");
        region.setRegionFlag("jiyRTIu8qWX5cR0knZr676tfSJPZ9mrY35gLvbVsK4WljUmyLU");
        region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        Region RegionTest = new Region();
        if (isSave) {
            RegionTest = regionRepository.save(region);
        }
        map.put("RegionPrimaryKey", region._getPrimarykey());
        district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        district.setDistrictLongitude(2);
        district.setDistrictLatitude(2);
        district.setName("yaPMRnwD0jg57Zc7pImdEzupnVgEiI7CNgjXb0nZRoOrLSI1Pa");
        district.setDistrictFlag("Xl0wqjj8yR4TLxcM4SDQVWj5dIXBVmevL9QOeaQyBLce1xViG4");
        district.setCode2("VOn6UXCMlQCMpqO2VYRsWzgTSxvU7Pr2");
        district.setDistrictDescription("n9cLTaS6nmem4ZmzI9FJoF9gGQ6BRw5Zgbp7YFPj5QpixEVMYe");
        district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
        district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        District DistrictTest = new District();
        if (isSave) {
            DistrictTest = districtRepository.save(district);
        }
        map.put("DistrictPrimaryKey", district._getPrimarykey());
        Taluka taluka = new Taluka();
        taluka.setTalukaName("9T3NCRzb0MPHBJ5Tneazy3Tvkl0I3bM519TqqkwM2jCtvA3Bo3");
        taluka.setTalukaLatitude(9);
        taluka.setTalukaFlag("IyVatC82BwoyTXMKEjllXVP4WlRpwC5wLkw2rwnEvRSqjhJl4O");
        taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
        taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
        taluka.setTalukaDescription("bbqe3iKVLotfM8yrK98PSLqkQdGDBMtToIsP2W62G8PTEM8yTg");
        taluka.setTalukaCode("3iBgwvi537Rt9t2UbYG7okUMjNAsMGh9");
        taluka.setTalukaLongitude(1);
        taluka.setStateId((java.lang.String) StateTest._getPrimarykey());
        taluka.setEntityValidator(entityValidator);
        return taluka;
    }

    @Test
    public void test1Save() {
        try {
            Taluka taluka = createTaluka(true);
            taluka.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            taluka.isValid();
            talukaRepository.save(taluka);
            map.put("TalukaPrimaryKey", taluka._getPrimarykey());
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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
            Taluka taluka = talukaRepository.findById((java.lang.String) map.get("TalukaPrimaryKey"));
            taluka.setTalukaName("cQOOydSYTmyVz1dqcuuTCyEOdAz8lcUGIkshduTsFFw2zTl0Gu");
            taluka.setTalukaLatitude(2);
            taluka.setTalukaFlag("t8kUYmNoAhytQweS97OdxgkVEz0TgXfnTv9kwpRo8N7fCVCQy9");
            taluka.setVersionId(1);
            taluka.setTalukaDescription("SyGHTJU4ju8uTH8cnK0brroyXumA7AlZI9waq7X3Gr7VxJK7JE");
            taluka.setTalukaCode("Udb9VeMAR7mXxLCZfoQTVqpaVtkapAYj");
            taluka.setTalukaLongitude(5);
            taluka.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            talukaRepository.update(taluka);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
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
            org.junit.Assert.fail(e.getMessage());
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
            org.junit.Assert.fail(e.getMessage());
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
            org.junit.Assert.fail(e.getMessage());
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
            org.junit.Assert.fail(e.getMessage());
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
            org.junit.Assert.fail(e.getMessage());
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
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateTaluka(EntityTestCriteria contraints, Taluka taluka) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            taluka.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            taluka.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            taluka.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            talukaRepository.save(taluka);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "talukaName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "talukaName", "eCwrEZGybb3JIJcELJZMhYGFoh4oy534cD9W62mbOJMG8BIwmAWtZPayV0guIBHVM1PKGLZoYJehaQMKweiFp5QRcRy12OV9bcWO3uxBg6qrgeEqlprZY0i9SlxJMAyf5pS7RvgWktaTQXEeIyzTPOqsklef93v4FjE7rW1hDR7StXJJNlPLtuP68516dFJmtKglHUsaKxZe02HZzlS6hGMarSQCbkltLNpqmLMGrHbReLMi0QO988XaWFaCHpVDe"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "talukaCode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "talukaCode", "8q54zRmSo4qMu1JJKyPVQwgvvA10yZ9Cq"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "talukaDescription", "roiudjlvKOGZACe85fmk41Arr1YpppafD8VeVZibQGZGl1pg79xsD3fjvjByaHVYQm4ydoVbyDR9g9WdY89uluWSQE8hduHa36xWUgSUy5Vf7sWb9xnBL5vpleMR3wK7i"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "talukaFlag", "oyix6tVFjS4sARe7Auv62cJ74EAZFwUQrkYYrcAmmYNkZ6BOsgU0rerslhkSwXWsBoKVmkmiosPR08IXKUbfb23IiKt8bne6UmaKriaH60rX7PUnYvEqSqgxduLEAOd9m"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "talukaLatitude", 14));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "talukaLongitude", 16));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Taluka taluka = createTaluka(false);
                java.lang.reflect.Field field = taluka.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(taluka, null);
                        validateTaluka(contraints, taluka);
                        failureCount++;
                        break;
                    case 2:
                        taluka.setTalukaName(contraints.getNegativeValue().toString());
                        validateTaluka(contraints, taluka);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(taluka, null);
                        validateTaluka(contraints, taluka);
                        failureCount++;
                        break;
                    case 4:
                        taluka.setTalukaCode(contraints.getNegativeValue().toString());
                        validateTaluka(contraints, taluka);
                        failureCount++;
                        break;
                    case 5:
                        taluka.setTalukaDescription(contraints.getNegativeValue().toString());
                        validateTaluka(contraints, taluka);
                        failureCount++;
                        break;
                    case 6:
                        taluka.setTalukaFlag(contraints.getNegativeValue().toString());
                        validateTaluka(contraints, taluka);
                        failureCount++;
                        break;
                    case 7:
                        taluka.setTalukaLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateTaluka(contraints, taluka);
                        failureCount++;
                        break;
                    case 8:
                        taluka.setTalukaLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateTaluka(contraints, taluka);
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
