package project2.app.server.service.organizationboundedcontext.location;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project2.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project2.app.server.repository.organizationboundedcontext.location.CityRepository;
import project2.app.shared.organizationboundedcontext.location.City;
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
import project2.app.shared.organizationboundedcontext.location.State;
import project2.app.server.repository.organizationboundedcontext.location.StateRepository;
import project2.app.shared.organizationboundedcontext.location.Country;
import project2.app.server.repository.organizationboundedcontext.location.CountryRepository;

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
            State state = new State();
            state.setStateCapitalLatitude(2);
            state.setStateCapitalLongitude(7);
            state.setStateFlag("UNGX55EkX8znCiwFznW11emoe4QufsWlgG5wiOr1mX6CK4BqwH");
            state.setStateCodeChar2("45xOQaUrFHrprZvqwFgycrg1NuV2lqd4");
            state.setStateCodeChar3("Ix6ET7SwylGe0RVHVy5R0SbzWf67B2cd");
            state.setStateCode(1);
            state.setStateDescription("RLoEk6muhl7FmC23z4dvNLIrMVrTWWXZQ8cK75jQxD1JZ8rPER");
            state.setStateCapital("C8NTAV1n3GlEOd7fYaJaSnHcakw8fDvCJ9galwRH8nxV1Djm66");
            state.setStateName("I7g1SRL9PWjPn3XX5si17r2qtsI0oxp2cWQx7O3unyzgxCeI8O");
            Country country = new Country();
            country.setCountryFlag("YtHdiChKeIsit46gHJFLU0KLpGXxP0ToFibqCAVNc8ov7iUFyb");
            country.setCountryName("EgOV5STMFQiVne7B92yzd0zOjVQPSJJt4jaWXMHbeJYs2WzFHZ");
            country.setCountryCode2("PPa");
            country.setCurrencyCode("Nlu");
            country.setCapitalLongitude(1);
            country.setCapital("nG0QGjwVkSNJ4d4ux4K3HtMYw0qqOIQD");
            country.setCountryCode1("8Kz");
            country.setCurrencySymbol("5DbViwTBeJLPe4rlJT2TWj2D5Ar0AIaO");
            country.setCurrencyName("PzsqbZBKtZzGeBFtOFDb6GvG7TA94TgSQKkTZCMg9kmOqGhSAN");
            country.setCapitalLatitude(11);
            country.setIsoNumeric(1);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            state.setStateCapitalLatitude(5);
            state.setStateCapitalLongitude(8);
            state.setStateFlag("W96qaCzVxkNdlxFTcB0NCWXtIdUQwp9L1J6T0SKCaCcs8F0zli");
            state.setStateCodeChar2("QMjUbcZVsmBwfPWeC8OMZsDOmP41vHQI");
            state.setStateCodeChar3("hWB4WoYLqGbmDval8vEE5cixUkjG3gr0");
            state.setStateCode(2);
            state.setStateDescription("NczMlvmHA8d3nsiSckvOzCHjWNEwyeS9jkzgXHYmUTniPwY7Fk");
            state.setStateCapital("7yHHVSk72iEH4O42LAZ4HsWDFBHPrd3YeSAuOhfVBl6JZHyniC");
            state.setStateName("cyTCAzGIU0Eo5Wlo9r4B3B1hAB9ConYgtpB1hRiLpSXXGqyMVG");
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            City city = new City();
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityCode(1);
            city.setCityDescription("sq8pTXAK8ztjx6Y49o140F4xSQ4g3sogwCRMdxBsRIA4spnXh7");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey());
            city.setCityCodeChar2("mWag95PUyTzy2b6un3m9Kk0EjxSpksUW");
            city.setCityLatitude(7);
            city.setCityName("d4fYeHKn2SSjPByBBrbCu4oNFCwIdHyNhRlggSykZe86ZlfGFs");
            city.setCityFlag("L4T9xSkJt05t6QpfiKDXuvoMlvE8zqugz7IwwHVbNPmXnDkIB8");
            city.setCityLongitude(6);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            city.setEntityValidator(entityValidator);
            city.isValid();
            cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
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
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            City city = cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
            city.setCityCode(2);
            city.setCityDescription("JpsT2hQYU93f7JlTj2cGROGXCQhWXuq6y8UZu785rASi1PRvSK");
            city.setVersionId(1);
            city.setCityCodeChar2("9KZ9oktFEsUITVN3PKdnpsDk4W1r1XJc");
            city.setCityLatitude(2);
            city.setCityName("9UyZkBwawFSShYrledVJrksyKpGnHrsT1Xzk5q7gvXpm902MuK");
            city.setCityFlag("3T5gnWwj9jlwz8KXdKer5K1ZaSffyPRZsiJsy1QzBVFgouUNfU");
            city.setCityLongitude(11);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cityRepository.update(city);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
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
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
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
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
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
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
