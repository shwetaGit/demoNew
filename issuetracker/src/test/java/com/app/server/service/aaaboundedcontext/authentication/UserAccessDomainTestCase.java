package com.app.server.service.aaaboundedcontext.authentication;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
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
public class UserAccessDomainTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

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

    private UserAccessDomain createUserAccessDomain() throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainName("swuyn2vAclceTFfmR20ihTAxE0dlhXuFVmOszlpMcplBVomnrN");
        useraccessdomain.setDomainDescription("Dy3znFgkt5PPMM8ekhbeAA21zphAkIyg86tYAksTUTuUCVW78T");
        useraccessdomain.setDomainHelp("YNIgzxAOFLXWBxjn3W75eJ0NoxiZhwVl4eBLYzt6VecDkRct4m");
        useraccessdomain.setDomainIcon("gII4n3CplO8miXLC2ybDezeisoGDrEFqLMPIOfkK2pjUfIgAY2");
        useraccessdomain.setEntityValidator(entityValidator);
        return useraccessdomain;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessDomain useraccessdomain = createUserAccessDomain();
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccessdomain.isValid();
            useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            UserAccessDomain useraccessdomain = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
            useraccessdomain.setUserAccessDomain(90291);
            useraccessdomain.setDomainName("HLlUtjfc0dz93viJbGRPmgOMU1qwvykcwLImGR4qnmgeR8J6EM");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainDescription("YD5qsueOtS27EZgEjLc5U5jy44FXuCqIAY4M4rZ1sYGRJGkIhQ");
            useraccessdomain.setDomainHelp("AIBUjzKaia1nOSvC3hxUYzMGBrWiEVabTgGEfcu4p8wikepyiG");
            useraccessdomain.setDomainIcon("Ipeu2CUuhKbQn7emmwNxLs0wn3TKn1h3RboaWunChbmXGcMH8L");
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccessdomainRepository.update(useraccessdomain);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessDomain(EntityTestCriteria contraints, UserAccessDomain useraccessdomain) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccessdomainRepository.save(useraccessdomain);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessDomain", null));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 2, "userAccessDomain", ""));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "userAccessDomain", 150642));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "domainName", "FjVuimEawlEdd9IeVUSutSl0jgfLvtOgfYOqzxOg2NfNhSOdbgss5UMWuzRw0OBcEEKCCexuy4sWNhh9FjuM70iM4CulbFehauzytHphYsgMBOZjhIRmI1eQnDAWaZRK1VayU778xEHHhCKy7FZmm8Ujf5xdjQDfvfqc6Y6wZ9WbwCI3Nms6Hj160KE2ul3QmyBhhu8qQVFITaRJnxBh5faGCYvJpRPsDBwAcnCjxNG4ADtd0PQIQ3zLjPKcV2u9I"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainDescription", "GWR5hRY8fchldoae95Nzh0wm2WvXcd37JSFpqWloNtkt2uMFpbJiATZPkhmRUUTgxqETdYeYmz84Xpahr8GEyebExHatfiUlzOFXUNI2dal3Px2GFc0CFpP9ezPqTotWfkssS7xGcBA5fiv9CCe9NgO6HvOgxWRaTpGXEvgnnloklqDKBgAWG1xySJL63rNHAwnXeQ0j7JTTPBZzGUn9gONZoIH93quDdG5rr5xgClikcYRYLhVvsvfpQcy1Ztvuo"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "domainIcon", "oA8z1eYUTkUKPn65RsURUoKoLhDvzlWxOWDspcLyeHO9l37sVhLqFiMU6KBw9TYPB6pwHSwg1XB552BJWEOz7zHJWvbOuPr6LrGmPpwEuPdX4yQpQdxPb91Sj3XfQp9qAgMoaAL6hvNa3vShh1PDhjc2lFJ86l1Vo8w8xnUVwp6LFh9sU1fPqBHNSY8zfq6hiX1UwCLVNi2ENnGV7wNcRxvBEAsjcYoXUsMjt1SCYpRDYBdHt7pkb4qazuubVSNPZ"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessDomain useraccessdomain = createUserAccessDomain();
                java.lang.reflect.Field field = useraccessdomain.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 2:
                        UserAccessDomain useraccessdomainUnique = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
                        useraccessdomain.setUserAccessDomain(useraccessdomainUnique.getUserAccessDomain());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 3:
                        useraccessdomain.setUserAccessDomain(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 5:
                        useraccessdomain.setDomainName(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 7:
                        useraccessdomain.setDomainDescription(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 8:
                        useraccessdomain.setDomainHelp(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 9:
                        useraccessdomain.setDomainIcon(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
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
