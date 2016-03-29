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
import com.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.app.shared.organizationboundedcontext.location.Language;
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
public class LanguageTestCase extends EntityTestCriteria {

    @Autowired
    private LanguageRepository<Language> languageRepository;

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

    private Language createLanguage(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Language language = new Language();
        language.setAlpha4parentid(2);
        language.setLanguageType("MtyrhTZKEGQETXHD6OkrXIURtGJfCGfq");
        language.setLanguage("rhFH0E7M3FJRGn0fhk5OJph6u2joK2ir7ZFiQxZJMkZuosiPJb");
        language.setAlpha2("N1");
        language.setLanguageDescription("sNrZCsGXo7UxwSiDlomxSoTJgGbd023g5LOcpvGP71mURzLwii");
        language.setAlpha4("ikHG");
        language.setAlpha3("o6x");
        language.setLanguageIcon("xW9ScXyVAhr1e4EOoEoUXrvIxny9PmBgBr71ZVmfiXY0177WMe");
        language.setEntityValidator(entityValidator);
        return language;
    }

    @Test
    public void test1Save() {
        try {
            Language language = createLanguage(true);
            language.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            language.isValid();
            languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LanguagePrimaryKey"));
            Language language = languageRepository.findById((java.lang.String) map.get("LanguagePrimaryKey"));
            language.setAlpha4parentid(2);
            language.setLanguageType("sr3ynEubHAAvFlRiCkyUtGeUTyRlpMsi");
            language.setLanguage("I8HOJrKZGbTZeJdk3aiv2iE0xDtVa5sW6H6EEUbGTw5GgUBC1J");
            language.setAlpha2("ZZ");
            language.setLanguageDescription("7K6gZG7nyiUU163VekfTmILoqnP4il2OO5VgLJuTQ6CwhNtZgW");
            language.setAlpha4("Dvi1");
            language.setAlpha3("qMF");
            language.setLanguageIcon("cp2MiHkCunhXdDSseqRCif8t5npQtZtqUsR3KiGeZxElKZNobz");
            language.setVersionId(1);
            language.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            languageRepository.update(language);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LanguagePrimaryKey"));
            languageRepository.findById((java.lang.String) map.get("LanguagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LanguagePrimaryKey"));
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateLanguage(EntityTestCriteria contraints, Language language) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            language.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            language.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            language.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            languageRepository.save(language);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "language", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "language", "PQJUzlbn0beKxLcVjAowbp7UhrqVMeQni0G2F7sd1rdYoKno39r2Dcwia00scQJ6P2niWUVhVRKzUL48esZU8TFpPkyNMsnqd87JTJAVrqkRdLQn3AjDJoHov5N4Wmy5aXAk9UdZDAeyJsEW1tfMJy114UUwdYF9MTxyyJYaGQcG7bvJbNcKS4QSw3jYfU05LVs1WpuOqJCGjmO9kGgATNOvrb4f2wmxEDYKcxnrBwgIcmQ11d4hDmtgFsn4K8ElU"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "languageType", "nNAVaL4qJsNxy0stf6bEHKDWcABb6nNj5"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "languageDescription", "LGJf16bcsiCAe1CkURWvlB5nH997xTFPoZVEK3d8MnMnd47cEbW1Cs4pEPbMO4bulDeGj615GRAWBkIR89356UJnFs6tP2SjLjEqvDJ3oR2WVxXrYhtct1xcslM7jXHSQKlkNLFUtKcJxrfak1dZSFYMUinQCHBlkNmfQ6BesRV6yAnJ4n6QknQWgop3mUFEq5Sc9nySrRKy2QzF28s6athNEkun2AHztKn5JHvF3zvBZWFiO1nUIhv8Z32HBUE15"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "languageIcon", "paPqsAtnl2ceMiUWu6gcZeVxCqK42S6t20jF6tIxo8KvIa7OtotVx9oMz54bo5J0pjN2kM6Q5izKEm7v1fMG34bpxnh17ZGCw1gWXURIZScUKgBreLREKxreV0WwaF1ad"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "alpha2", "1Pp"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "alpha3", "1IOJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "alpha4", "8JOa9"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "alpha4parentid", 20));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Language language = createLanguage(false);
                java.lang.reflect.Field field = language.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(language, null);
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 2:
                        language.setLanguage(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 3:
                        language.setLanguageType(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 4:
                        language.setLanguageDescription(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 5:
                        language.setLanguageIcon(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 6:
                        language.setAlpha2(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 7:
                        language.setAlpha3(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 8:
                        language.setAlpha4(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 9:
                        language.setAlpha4parentid(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateLanguage(contraints, language);
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
