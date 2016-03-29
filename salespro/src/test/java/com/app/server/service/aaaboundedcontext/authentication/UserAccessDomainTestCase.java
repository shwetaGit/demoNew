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

    private UserAccessDomain createUserAccessDomain(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainHelp("GvpUoIykht8Z3r29IiZHHZIl2F9n9mV5XSNupBhLf2UJf4y3P5");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainName("KPkqHYpMw1J03cDVoSOyyPDLfvkAAYfgWm0pdHWcJSbjMQzNbq");
        useraccessdomain.setDomainDescription("3guUn9Lb1pVdsqazm7AyTg0BPF8Gb5WOZHI4ikfjh3EGMHInRI");
        useraccessdomain.setDomainIcon("LcYBhdMoCn5KCxVJFgzkHCs5afMLPdq9sbTu5IDk8T0Oo5OFaQ");
        useraccessdomain.setEntityValidator(entityValidator);
        return useraccessdomain;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessDomain useraccessdomain = createUserAccessDomain(true);
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
            useraccessdomain.setDomainHelp("82Yhzg6eeo0KF5sugeyR8glQxvAdYGO6pmqqnbm1nVFrGgwB2i");
            useraccessdomain.setUserAccessDomain(83021);
            useraccessdomain.setDomainName("j7fZNcMOMSDb887IEHcAAUo100tjdczr55KuhjLJSfllAuyn4Z");
            useraccessdomain.setDomainDescription("GApjG9rOLhuoHNsUtdy83B4qEwnpHxqUEybPyyACPN4LNASoO1");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainIcon("VnyOg6OBf3ugOQ5gx6xB67CpaNR2v4ktFKacwbiHbYJE6chdfa");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "userAccessDomain", 137741));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "domainName", "AByKZqLytF95wB9nDIvNywxCfu2YXEIAKXkf2boQU2K406GhFSwaxpG7qs2lYdele0RT9eq9DMcAedms9sniOybvDkqPKxkHa6qvcK41ceDOVahJEUHULy5Fh7QjpZPRVBN6aN9nhARhs4g9Ju0inUuDqvyQMZ4lR0xLywaBVqP1eO5PlRrrSa4Ngs986amUWr2Hl4L5JmQo5UW4W8gK8c0BfTBcxX4Mx9wWNCrLNZYW9boWiPEipUNB6G9zq2zo9"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainDescription", "YvnAHIbB62KlwrsAcbormTskj9oNMELomsRe9w0U6gyAxAQO9DGYCs21FKEzQEHwejsB5YgwBo5g1iYQauHntxlDmCoR6QGmjFIPvQz1jw4MhsePMYuP37zReqdhXXx0qmyjI43sELq4Cmh1LrIACLubz7xN6zmQUIEzTXWmYLMUkIFCB1W0JNctKf3Os8r3GUn4AartOHFSeXy2LAeJzyoasOsDB3gwhssR0MqprHzCvmaD1Wxbo4cBkOkGMiJDS"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "domainIcon", "Q3q8HGm4HFwXprMcTsejhWpuAUKf7G9lxwZ5XefSESUQ2Jc7F5YZ2lGxfvJX6306EQR0gKrQVlJAXJPAdm9o0vsBYckQKzy0Fun5oGZgPDYjg8BYnMQRFR88ymO1fL7W6EqrkE1IqQzsNyipEYELDV6F8BUldJ6EPfOG2h7AF8c5gTXuLoCZAZCPdf0xRD8dbCYfQESU9CWt50Z71l7Em43WtdzAe6qaKXDEWmGbnHGO4jIVdyrNFoBnVCXHi7E1s"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessDomain useraccessdomain = createUserAccessDomain(false);
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
