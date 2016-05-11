package com.app.server.service.issuetrackerboundedcontext.projectmanager;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.issuetrackerboundedcontext.projectmanager.IssueCategoryRepository;
import com.app.shared.issuetrackerboundedcontext.projectmanager.IssueCategory;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class IssueCategoryTestCase extends EntityTestCriteria {

    @Autowired
    private IssueCategoryRepository<IssueCategory> issuecategoryRepository;

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

    private IssueCategory createIssueCategory() throws SpartanPersistenceException, SpartanConstraintViolationException {
        IssueCategory issuecategory = new IssueCategory();
        issuecategory.setIssueCategoryName("jvg3vERvXXV1ZQYK2mCgBYOyTdKz9tDFa8kVwcpUy33Z9cXF83");
        issuecategory.setIssueCategoryDesc("jGMd4r8YAG6Z7DSbK4rkEQwmZ3f6zXEG0PvIuxdVEAArMkgP8e");
        issuecategory.setEntityValidator(entityValidator);
        return issuecategory;
    }

    @Test
    public void test1Save() {
        try {
            IssueCategory issuecategory = createIssueCategory();
            issuecategory.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issuecategory.isValid();
            issuecategoryRepository.save(issuecategory);
            map.put("IssueCategoryPrimaryKey", issuecategory._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueCategoryPrimaryKey"));
            IssueCategory issuecategory = issuecategoryRepository.findById((java.lang.String) map.get("IssueCategoryPrimaryKey"));
            issuecategory.setIssueCategoryName("sDC7k17B98pzbVRzRoIrRJ0qHLQJF5u7BDYWyfucUOnAl1324T");
            issuecategory.setIssueCategoryDesc("XjgUbU0pyiJ0kCZSUMFRSyWIarbOAbYMmVcNhwBxbfV1H5TChn");
            issuecategory.setVersionId(1);
            issuecategory.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issuecategoryRepository.update(issuecategory);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueCategoryPrimaryKey"));
            issuecategoryRepository.findById((java.lang.String) map.get("IssueCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueCategoryPrimaryKey"));
            issuecategoryRepository.delete((java.lang.String) map.get("IssueCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssueCategory(EntityTestCriteria contraints, IssueCategory issuecategory) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issuecategory.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issuecategory.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            issuecategory.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issuecategoryRepository.save(issuecategory);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "issueCategoryName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "issueCategoryName", "e8X5bel2Sro5Rx9SLAyrAFFhSBhipb5vRXRQ0mVnOQras8ITPGhWEyIfVfWLgHDjFBnwDntfQ4L2dgQ7uHbmtRWts8VG5CAspvftuSUVsb28iLnqoasgVOkmHjyT3gQy5UcxVN99v71O6QY6HUdlVApnQ2eSmrAqsXkj2VAl4JIY5d24DsKF5T9MWMWDoETqpnVF88oOj0jL5sVdOZePRx6rT7WGgSukuuok8Cud2RuoX5M582XpX3NZpY6jMb68Y"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "issueCategoryDesc", "53t2o2oXVBXPvWnvsSROzajpLVcyMhcqdznwepG63riBkikagoxiiqb1jL8ilMubDXhW3byruS6yBdADrzoXCEXrjQzw2xqb14c65JeB44qEDydmEpVgpiA1Uu7Bgq2MkzFbgnjuhr0ngciQCXYLbdXki77aviKUEq596PzQEl8MTPqgdRYs4WHfhN2BKuTKA81W9oKyy2XFzClwqMPGi0u12SCqbmF4PBbTF2s5QFTiEWFDptBr3a2yu75VqNBU878YPADrcC8VQRN2LH51TbnXIMKYr00v4eZ01q9fDrZu540YI9fpLA3ajlrYwMwu2sv3iUXcypPDdLqqlnSpFBqOjHyYZUD6zIWdsdeLWFMOMM2WkU5hQXlQsQwEnHki3O0q3XOinTYUItfUJE678xWOxpwdQb6S9k5Mc9RahY34wkFdHRtOQTIi7y4YrJKyvUfeZP02JoiDD4IQhFMOcQGQPbQSuiEVqSNV3mI0gXC4LTRqaiuHXyG6XID93xiEgd93B7ChfzrOZMpIVZ9KE1KUcSJ3nfFAKHqstmAYhBJuFiz6TqZtB8BCGTDIOqU6wKcQmEMaWBvpROFhn5O9eOCjvk11hx7MLMthjcHpo5Co2lLinaG2xNnCCRPsXvmzvD6GMzKVsVyFUnUP5ujE4JJhV80fqjNANwDTXa7n3rPGmf5DKn8vDwnp2SZ7lk2LW7ltXYfIM0pUEUKmW05zirjsWNGgFathZwzAFo2fhohvOz1V6i4llRrhkbJkM0VzbfN2FQIVT1qk0znNCt08aUGhZWNkuth3TOrcb9j0ezCfspjuz7pQe0vUwQOUraPcifB1nGD3Fqtaize2zXphevyRJDFkZCzdVCSEKlC7KMUtA8CvZ3OTSGUtsBcfpNCsrQq8AraIGOpiYXFvKjG23gYbYVzrSynQEDiyMi1dc8yAxAiutfzRjrOQRrj2uvx8ZPh1ESpDVUnKxtgpKbLWbHIWJZ2IMaEuKZKUfjZY8ga8jP9C5PfGfJtjRtZ6vlABI"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                IssueCategory issuecategory = createIssueCategory();
                java.lang.reflect.Field field = issuecategory.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(issuecategory, null);
                        validateIssueCategory(contraints, issuecategory);
                        failureCount++;
                        break;
                    case 2:
                        issuecategory.setIssueCategoryName(contraints.getNegativeValue().toString());
                        validateIssueCategory(contraints, issuecategory);
                        failureCount++;
                        break;
                    case 3:
                        issuecategory.setIssueCategoryDesc(contraints.getNegativeValue().toString());
                        validateIssueCategory(contraints, issuecategory);
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
