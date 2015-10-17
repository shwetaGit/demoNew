package oct16last.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import oct16last.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import oct16last.app.server.repository.CityRepository;
import oct16last.app.shared.location.City;
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
import oct16last.app.shared.location.State;
import oct16last.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CityTestCase {

    @Autowired
    private CityRepository<City> cityRepository;

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
            country.setCapital("uPASVEmsnXpJogYXQM8YTTHgGVTedHTP");
            country.setCapitalLatitude(1);
            country.setCapitalLongitude(4);
            country.setCountryCode1("3Gm");
            country.setCountryCode2("hdA");
            country.setCountryFlag("oOX0EB7WoOp8QZlCKh49m2GGJTIRn74tlvipMK5spINOCGJMJz");
            country.setCountryName("90cmWqA8N29B4cK4rakjdVTIdExw7qBBl8LfNWe5rdH3RgsImp");
            country.setCurrencyCode("dHb");
            country.setCurrencyName("1Izq8qH3Ze5rxTN1zAPriEihHg1PJK8SVgp9jG9H6IdFEX2z1h");
            country.setCurrencySymbol("7OYelMgo4L8MUwYCntkR0bIeC7XGvrOP");
            country.setIsoNumeric(2);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("n2eJO2aGImIsvrBmSzTJ9S9DPCCiDAHxE30BzrOdPSVsSK3LGj");
            state.setStateCapitalLatitude(2);
            state.setStateCapitalLongitude(4);
            state.setStateCode(0);
            state.setStateCodeChar2("TH2om1Hjj3RvoxRwjPtOJ80OzGuXNu6S");
            state.setStateCodeChar3("oELUcD7Dg4iAAaMYa8dFPzoFzFiN9FTo");
            state.setStateDescription("MeFkmSL6AJtEagoOnCl1nM10vGWTKAhqqje2bEU7fG9GC3mhpd");
            state.setStateFlag("lgOZ6QNNAzBGbWqb7BPVxgRgcuVxFfM4VpveeCj44zR2UFehAN");
            state.setStateName("LAilOMkqq6fCJq5mVhK5dXNTh2UsuIZBO4DzOwMGce6H9J71i1");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("gi3qQcitMayrYRT84gaLNkMitJLtWCnG");
            city.setCityDescription("nHaaBJFNk5O0PSmrIfj7MIFbYMd4wepetRWL0bwPjlQYOL1EKi");
            city.setCityFlag("7Sea35bKK6DG3hVBVyTax9dSzt4t8u7HIkANCYELGFfOPhN3Nq");
            city.setCityLatitude(1);
            city.setCityLongitude(0);
            city.setCityName("Dzdo6uhGiThON5aUz7acFXegRTeGvhe7RGVBr7PITE30sc1LX4");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey());
            city.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            city.setEntityValidator(entityValidator);
            city.isValid();
            cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
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
            city.setCityCode(1);
            city.setCityCodeChar2("CVDdP5tpCU60lylvr2EyUsCpdV3RLMpN");
            city.setCityDescription("Bjtxk7eEhkBNfEBgoYqJzSfRtJRseAjxwT6lnttZkDeiLlYOa2");
            city.setCityFlag("CZ1QfAZNKFQlBPPUaxshFad2juxJlLTPawCAVRwgGvSYMjD4Zy");
            city.setCityLatitude(0);
            city.setCityLongitude(4);
            city.setCityName("xZpAuWTLrQR39YO8RUSUqyd4AJ8vnqctZYl2zMW3nSLdKYShgb");
            city.setVersionId(1);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cityRepository.update(city);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<City> listofcountryId = cityRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3findBystateId() {
        try {
            java.util.List<City> listofstateId = cityRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
