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
import com.app.server.repository.organizationboundedcontext.location.CurrencyRepository;
import com.app.shared.organizationboundedcontext.location.Currency;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CurrencyTestCase extends EntityTestCriteria {

    @Autowired
    private CurrencyRepository<Currency> currencyRepository;

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

    private Currency createCurrency(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Country country = new Country();
        country.setCurrencySymbol("RNl0OvKdVXNcU5ZjABAaf0bC1SAyrFCb");
        country.setCurrencyName("7XU5Sx3w5iI5j8RDa9ylwfxrCA4ZQvyrqGUedFDwaYgAQuw0wb");
        country.setCapitalLongitude(8);
        country.setCountryCode1("fFa");
        country.setCapitalLatitude(10);
        country.setIsoNumeric(10);
        country.setCountryCode2("Ah5");
        country.setCountryFlag("7tMXVsz1BwXmJ5FNjb6vtQo735hlV7UWPNms3LCySs38vYCZt6");
        country.setCountryName("vquHykZmPWlQXl63sD9mCmL8giZmnxi138Vd0T401roarkaAGI");
        country.setCapital("51Sr0A214lGjrECASxNY1Jkn02dBhUEz");
        country.setCurrencyCode("r5V");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
        }
        map.put("CountryPrimaryKey", country._getPrimarykey());
        Currency currency = new Currency();
        currency.setCurrencyCode("A6RbJaINjvashP0ytIXhmqXChg4RIc1QgbhnzJAEbbIWsMjl0t");
        currency.setUnicodeHex("2o7GWIO1TpMdA7sitDXI3QW9Cbe3BUPpv8Jp1LRJMKJJodt4gr");
        currency.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        currency.setUnicodeDecimal("r8ErE3mEFOEYmuhnV924b1t0w6tQRSNukQNsAoMWHN5xNVGbhG");
        currency.setEntityValidator(entityValidator);
        return currency;
    }

    @Test
    public void test1Save() {
        try {
            Currency currency = createCurrency(true);
            currency.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            currency.isValid();
            currencyRepository.save(currency);
            map.put("CurrencyPrimaryKey", currency._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CurrencyPrimaryKey"));
            Currency currency = currencyRepository.findById((java.lang.String) map.get("CurrencyPrimaryKey"));
            currency.setCurrencyCode("P1JX1lBQBw5fA2f4ZT0jq3RfyhA09SgU6fiRXZLryY9nje0mCH");
            currency.setVersionId(1);
            currency.setUnicodeHex("lrYHeKteEANb82VnpnOzAWrKOo0L9dbmlvM4sB09QDvohSBZm4");
            currency.setUnicodeDecimal("c5IBaIbAJngaKZZJI5nw5vLPjxHSFSk7aq7wVdlT5h3n3c8kBU");
            currency.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            currencyRepository.update(currency);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Currency> listofcountryId = currencyRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("CurrencyPrimaryKey"));
            currencyRepository.findById((java.lang.String) map.get("CurrencyPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CurrencyPrimaryKey"));
            currencyRepository.delete((java.lang.String) map.get("CurrencyPrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCurrency(EntityTestCriteria contraints, Currency currency) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            currency.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            currency.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            currency.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            currencyRepository.save(currency);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "currencyCode", "nHqGBZOjTpoHhazAt6zp1eXlbQPQOy9BglwnTIgXPLS6QtXkYtCJ4jCOQbQ6rlnSBd6akGaNXikqdhjEXmpJUOf4MXu0uJj3iV47DUJpzKfOmxSjAH4iaLskZzYq1rmn5"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "unicodeDecimal", "hTJFFn6jD9EOVyEBMje3rkxpva2bQrOeYYUuBr7fdc216QOAeYmyWemv9gOnLI03qiPFAOdx1aWfBbdVrRR4Jcatd0Q1Jo6fO7Gn7pYof9Gput7VI5JzMveRedgKW4ejI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "unicodeHex", "9fbfo9IRinu1h3MQh8qbEVFHFvNNpvjOagWuuWNOSgYxKOkbf2vix6DE62jAZfvvxzGjsySWzv5jpQfpkZSAR0hi97DKvl5taaaXkRlLBHs5ZhdgzYpN363hYBgcKFwNV"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Currency currency = createCurrency(false);
                java.lang.reflect.Field field = currency.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        currency.setCurrencyCode(contraints.getNegativeValue().toString());
                        validateCurrency(contraints, currency);
                        failureCount++;
                        break;
                    case 2:
                        currency.setUnicodeDecimal(contraints.getNegativeValue().toString());
                        validateCurrency(contraints, currency);
                        failureCount++;
                        break;
                    case 3:
                        currency.setUnicodeHex(contraints.getNegativeValue().toString());
                        validateCurrency(contraints, currency);
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
