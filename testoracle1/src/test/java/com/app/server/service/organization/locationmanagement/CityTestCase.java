package com.app.server.service.organization.locationmanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.locationmanagement.City;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.app.server.service.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.springframework.mock.web.MockServletContext;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.server.pluggable.interfaces.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CityTestCase extends EntityTestCriteria {

    @Autowired
    private CityRepository<City> cityRepository;

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

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        MockServletContext mockServletContext = new MockServletContext("file:src/main/webapp");
        try {
            String _path = mockServletContext.getRealPath("/WEB-INF/conf/");
            LogManagerFactory.createLogManager(_path, AppLoggerConstant.LOGGER_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
        runtimeLogInfoHelper.createRuntimeLogUserInfo("customer", "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
        runtimeLogInfoHelper.setRequestHeaderBean(new RequestHeaderBean(new RuntimeLogUserInfoBean("AAAA", "AAAA", request.getRemoteHost(), 0, 0, 0), "", methodCallStack.getRequestId()));
    }

    private City createCity(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCountryCode2("VYc");
        country.setCurrencySymbol("SoGHvRaeEh4tnVnW6HehTVUGSRoii10W");
        country.setCountryName("Xmvc96SsaEhzDt2iYwQBUxAhkobMrpyeKKRE4H4FYgmag5xTc1");
        country.setCapitalLongitude(2);
        country.setIsoNumeric(36);
        country.setCurrencyName("3It2cabS6zSJPRfhzqPmPKOzSLBgADYMgv5gygTs3K8xHXPzkf");
        country.setCountryCode1("rb1");
        country.setCurrencyCode("0ze");
        country.setCapitalLatitude(9);
        country.setCountryFlag("6EzlSe5XjXhGU5fG9ZtAOJBMHturKibhm2egnr2lBK4sSTR7nW");
        country.setCapital("73KFg2JSZWndAdlOZQ30WwIrRdOpVdmN");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateCapital("KRJ045GvEaWvF2LXUUnS8Rt4RFfVQHlZzFFp77XdEUwId3VdbI");
        state.setStateName("HRdUZ1EjwJHVOd2cY0ERdtWy2gfs4D2XsDb5pN063t17YKsIag");
        state.setStateDescription("7qCLooGGGjX9qfEg33xJp2lGKdScPFVeQnwMrw2mElAtDBFHm6");
        state.setStateCapital("e9TnB52TuxYu9LfnW7clqJSX3Z64ONeKCWTJzZAlOHsQm25WWQ");
        state.setStateName("beUUEZK3WQW1y8pHNMYluXdiXByMWS2YhtRCrF7HSjMjIhyEn4");
        state.setStateDescription("jsTzx8AYHBMX9v8QIV0EVHxCnJKyj0isy1ia8EAWlkLDtcqk6L");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("h8FOg8xcw00Di9Uwplwh8xo9TYOx029B");
        state.setStateCodeChar2("mRbS1jgnvjDZONyweBUnBRkHlkPb1ZUs");
        state.setStateCapitalLatitude(6);
        state.setStateId("6unwXS2xJRHBggm90RqvznCiFkywnVizWKfChjTdPeO7LC3urm");
        state.setStateFlag("onRUpLV0L09unVodnVS0MVq8GqMTYFHmrZvCTvrgRXkzwGF1CT");
        state.setStateCapitalLongitude(11);
        state.setStateCode(1);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityLatitude(1);
        city.setCityCode(2);
        city.setCityName("zFnxCQZEExSRpaqOB8M62p5GvIFISf1j1UaqObEbMKdLWL52aV");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityId("3zF3JUsdhObTFVxKtxWBvFEHOZtHOlRL2DHmFQ3R5zWo0DXJoy");
        city.setCityCodeChar2("TYLm2SqRp6id0BxMOjl9z6FXxoZwbxjT");
        city.setCityFlag("cVuSgcUPAGvFQIft3C8PLHnFCNuZl2f5wmV3KWqSCXCfJikbWx");
        city.setCityLongitude(3);
        city.setCityDescription("tjIDsHD38K0UyrCyIwpZKcJinXBz3pNrELo0m11sVhGDD6Xdpc");
        city.setStateId((java.lang.String) StateTest._getPrimarykey());
        city.setEntityValidator(entityValidator);
        return city;
    }

    @Test
    public void test1Save() {
        try {
            City city = createCity(true);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            city.isValid();
            cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            City city = cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
            city.setCityLatitude(1);
            city.setCityCode(1);
            city.setVersionId(1);
            city.setCityName("jLq39wc2bDVhQNzMHbzPnv4l7jgGl7wvcAfY5WcHJZ9D8iE8dU");
            city.setCityCodeChar2("D51O66BooIRjoS4tWZcJaDopFKfSbUfY");
            city.setCityFlag("eT01CoxgcnJVeIqMFLzF9Q668T5hq4W0V86uKLX55WocsnrDRE");
            city.setCityLongitude(3);
            city.setCityDescription("4w3ppnAVbRt4mi1DlfMlUfGVhxdLCKPHpJgslU6Npppwcwkxrf");
            city.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cityRepository.update(city);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<City> listofcountryId = cityRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<City> listofstateId = cityRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCity(EntityTestCriteria contraints, City city) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            city.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            city.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            city.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            cityRepository.save(city);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "cityName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "cityName", "o4OAbB4atsKwwy9gTCrSTAnrSU1zZhsvC1vXPTLjaqdpdj0Gi15bZvmbk4OIxB5fJSvhUoPdYb0KKlTTx1O9PFIKeE2Ey9ufwq2Cl2wWFSqMdqTzqDhYUZWjmNDVHCpMjHQezRi3Y8T9jIOBcpt8Iv0OavyVD5seawCtTGLzSjODdm6ElWyLkcpFHVQtdHVJzfPtAqVLLE3r6VEOvYHKVc4xLXA5vk3DyD9gQy4ahQFsJ8UzJIU8zUjsa3dYlBaWq"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "cityCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "cityCodeChar2", "nQfDxepATi0S2aifa1cBynTEo1J2ZIymp"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "cityCode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "cityCode", 4));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "cityDescription", "XG6jkVquKSYVsdqUKUgVxazM3cSnLdEFgegkiBQ3Y3YzuDkuEMqGXvay4qX1JnoB00aL0676UfcVSVtgHxUqfZ47JRz3vsO3ewB9SaOZDAY1T6TSE37o6hblHEfyV4WnS"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "cityFlag", "DnPcK9MdfZvpx0sXzrj8HBYOPuMfV1hlgNLNWwDjR5cSfDs0QN67vWWhXHhlKxdZf4MdgloCe06i7tAE0kq5mEntdyxZRiboWyGsdXBWPgc9asZTOlQwkwlJXOifwfWQQ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "cityLatitude", 15));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "cityLongitude", 22));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                City city = createCity(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = city.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 2:
                        city.setCityName(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 4:
                        city.setCityCodeChar2(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 6:
                        city.setCityCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 7:
                        city.setCityDescription(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 8:
                        city.setCityFlag(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 9:
                        city.setCityLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 10:
                        city.setCityLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
