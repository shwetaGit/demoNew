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
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
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
public class AddressTypeTestCase extends EntityTestCriteria {

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

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

    private AddressType createAddressType() throws SpartanPersistenceException, SpartanConstraintViolationException {
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("7fKvatcJXjJuvlDfTvCHLgZLXOMJNmTTuZyAT4R6sxpj3tC7NZ");
        addresstype.setAddressTypeDesc("21IhpXDX7Ju0IIdtWmiIptL3rpIEiF0G6Kb4jZsADCdZA06Jtr");
        addresstype.setAddressType("w9bPQJ7Ru0Xh9rCMifH9VAYUPjAys6eIsRaahuDhU1GUN0Gkyw");
        addresstype.setEntityValidator(entityValidator);
        return addresstype;
    }

    @Test
    public void test1Save() {
        try {
            AddressType addresstype = createAddressType();
            addresstype.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            addresstype.isValid();
            addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressTypePrimaryKey"));
            AddressType addresstype = addresstypeRepository.findById((java.lang.String) map.get("AddressTypePrimaryKey"));
            addresstype.setAddressTypeIcon("444W8NyeTeBJkv9GoirZNe6JrMeDoDaDXvxlYm4h0W9v6UmcMo");
            addresstype.setVersionId(1);
            addresstype.setAddressTypeDesc("XYG8mBFLrVTR6aGcxd8YbApn7sgjYWTWoVGlUrjrPqzldbSUlB");
            addresstype.setAddressType("U1LMT0yER6cVFBPTfTb04e40kZuWSxa9YRlDhFXmT9NtZmW4Ow");
            addresstype.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addresstypeRepository.update(addresstype);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressTypePrimaryKey"));
            addresstypeRepository.findById((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressTypePrimaryKey"));
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAddressType(EntityTestCriteria contraints, AddressType addresstype) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            addresstype.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            addresstype.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            addresstype.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            addresstypeRepository.save(addresstype);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "addressType", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "addressType", "4ihuLYMtOjf8nWA10waNALCJxHldXaujmwyD5yt2pVUcSg33WXvoCKt00cCDH15Z1wabQ3HWngaZdYL5VFmDsewqm0uo2fklY8os1ZDkE73l7MgcvdY3oGUUpc3vQHBDE"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "addressTypeDesc", "Y8XjlLGR143YRYngxBe39EnoMOtbRqmHzR6cdfWyWYc4fRW7vlNsZ5B3CX8a5SLlsrOxgpJlp4qJn8RirOOykGO8UHQ6ER5wQxgFdzuNHjuwatb8FKDHP9k8KkE2B5Jm0r0lbmVUmZpgna2NYMFKCXU34YbqbkuUWTcB3CaMgtXiv3gXbmhTuwh0cyHL2K7noWDpW3icPsEYn4LJCJm9voT7sYZej3jfW6Stvbns9BhNudHTCWINOFSs4NFJbV1ij"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "addressTypeIcon", "mLcTkNAk3xyp7SpmSBFVJZZIjEZ9Xjuy6hsbUxXyJ2p3Qg9YbsPT3YMktB9LFyrF1i3JkUj4ertuy9pNGOvr59mKgAft3KkFMVW2csOH8EtFz9EB37jElLSqI0uC7TZUH"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AddressType addresstype = createAddressType();
                java.lang.reflect.Field field = addresstype.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(addresstype, null);
                        validateAddressType(contraints, addresstype);
                        failureCount++;
                        break;
                    case 2:
                        addresstype.setAddressType(contraints.getNegativeValue().toString());
                        validateAddressType(contraints, addresstype);
                        failureCount++;
                        break;
                    case 3:
                        addresstype.setAddressTypeDesc(contraints.getNegativeValue().toString());
                        validateAddressType(contraints, addresstype);
                        failureCount++;
                        break;
                    case 4:
                        addresstype.setAddressTypeIcon(contraints.getNegativeValue().toString());
                        validateAddressType(contraints, addresstype);
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