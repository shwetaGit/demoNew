package com.basehr.app.server.service.organizationboundedcontext.location;
import com.basehr.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.basehr.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.basehr.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.basehr.app.shared.organizationboundedcontext.location.Country;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.basehr.app.server.service.RandomValueGenerator;
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
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CountryTestCase extends EntityTestCriteria {

    @Autowired
    private CountryRepository<Country> countryRepository;

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
            String logManagerId = LogManagerFactory.createMultiLogManager(_path + "/");
            LogManager Log = LogManagerFactory.getInstance(logManagerId);
            System.setProperty("LOGGER_ID", logManagerId);
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

    private Country createCountry(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCurrencySymbol("kFjoViL4uyAraffE42xVxndBrwCH00V2");
        country.setIsoNumeric(230);
        country.setCountryCode1("t3q");
        country.setCapital("uUrMmiUDD09CdY2lxD76uycZo3kyxn8l");
        country.setCountryName("DsKLzAkyymvV964MTYtbz5GGfyphJMekzw0wzOUvQZYDKSOw6n");
        country.setCountryFlag("vxjCmeoADiZcfcWtQNtuYY0zai9slUYoSQxvzqLVyzwCkJ4OHg");
        country.setCurrencyCode("r5v");
        country.setCapitalLongitude(3);
        country.setCountryCode2("JRL");
        country.setCapitalLatitude(6);
        country.setCurrencyName("ePgvs8xudnEazywQ9nu8ADUZyYXtJ5zKD9tHItW4KjDAq7R9hJ");
        country.setEntityValidator(entityValidator);
        return country;
    }

    @Test
    public void test1Save() {
        try {
            Country country = createCountry(true);
            country.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            country.isValid();
            countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CountryPrimaryKey"));
            Country country = countryRepository.findById((java.lang.String) map.get("CountryPrimaryKey"));
            country.setCurrencySymbol("ywpDy1vVAcZHEXLABwctRasU8RP0ttyk");
            country.setIsoNumeric(898);
            country.setCountryCode1("sqp");
            country.setCapital("VNbc55oDcWDKdORbGpJotYN08Sm3ppc1");
            country.setCountryName("LpyR3L5T9sSD5kdBLzNcpL6bj9AD0RlxGjtPqRXOB2rRVXIWWR");
            country.setCountryFlag("bhom5aJMysgfVoK7ULpkgpdpby5RVwhaD97ni9soOMYDcw3TAS");
            country.setCurrencyCode("1xt");
            country.setCapitalLongitude(8);
            country.setVersionId(1);
            country.setCountryCode2("4u7");
            country.setCapitalLatitude(3);
            country.setCurrencyName("tpjTez4xXk3TEGfZO0UAm18hNyYfsP7vy5ABDLYyemmx6Gko9L");
            country.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            countryRepository.update(country);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CountryPrimaryKey"));
            countryRepository.findById((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CountryPrimaryKey"));
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCountry(EntityTestCriteria contraints, Country country) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            country.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            country.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            country.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            countryRepository.save(country);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "countryName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "countryName", "sCBClv77JNFjgZGEsnNkdlCD9wh51KUXZamj25ScoF3iLtSqviIrvuFTJ7Ev5Rxtt33NtVY4woprVFNwlb18zh8h8FLdYDYWki6lpFi2we7kCjsPq3Lhp5OkVhbr82uGQ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "countryCode1", "IV2Y"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "countryCode2", "R00K"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "countryFlag", "AsZzJc7suJ5zvjGTy0LSAljVgGVCO948mIzq1nLZtO8yl5xzj4HCnIOpxj9SbQNst"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "capital", "IdvxqSUHQcGqhlzb23CFu02UTUSuLSyoe"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "currencyCode", "T2bw"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "currencyName", "ICTS0rFDsihqV7Ox1gWCQGyBLvgbzPtUjep2DUQxOLer1bQwMf1elR94CqJKIjTbqRXSEvC2C6dkwIqUA9sRL3wICwrl4viUApKoqQpgdWqrtOdynqJpCkb2i1XGHr0bn"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "currencySymbol", "OhN33DibAYmNqprz6nlqHB5lASgivoxYM"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "capitalLatitude", 14));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "capitalLongitude", 19));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "isoNumeric", 1309));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Country country = createCountry(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = country.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(country, null);
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 2:
                        country.setCountryName(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 3:
                        country.setCountryCode1(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 4:
                        country.setCountryCode2(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 5:
                        country.setCountryFlag(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 6:
                        country.setCapital(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 7:
                        country.setCurrencyCode(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 8:
                        country.setCurrencyName(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 9:
                        country.setCurrencySymbol(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 10:
                        country.setCapitalLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 11:
                        country.setCapitalLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 12:
                        country.setIsoNumeric(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCountry(contraints, country);
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
