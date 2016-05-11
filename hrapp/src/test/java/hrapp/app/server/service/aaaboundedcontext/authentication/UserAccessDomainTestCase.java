package hrapp.app.server.service.aaaboundedcontext.authentication;
import hrapp.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import hrapp.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import hrapp.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import hrapp.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import hrapp.app.server.service.RandomValueGenerator;
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

    private UserAccessDomain createUserAccessDomain(Boolean isSave) throws Exception {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainDescription("WLZfl9HGUr3tzu5UZYcpKtKA9LALFXe8SmiVxvJrCarAQ25kF7");
        useraccessdomain.setDomainHelp("FTZpxgwxEwMcVkHmPIRxB3uQ9nzlxkUoSb47zTR7LXignlG6ic");
        useraccessdomain.setDomainName("g4anZwZzus4kDEtVTd4pyu3grPFEJW2KZGAPuyZH53E7hm4Hwa");
        useraccessdomain.setDomainIcon("5R6hH3b5qtRJZJxaee5HxPUh5ICpgu8UFWSDgzK0BtNnz5cWga");
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
            useraccessdomain.setUserAccessDomain(12707);
            useraccessdomain.setDomainDescription("3xxLzCv7zWhmxY4JArvxaO8ri1cvOWAHzrnkFUvUButGDnLy70");
            useraccessdomain.setDomainHelp("D1R5It2n0fBYpmiidBEvK86cAvGDt7sIGQzZjrlkZxROW82zAK");
            useraccessdomain.setDomainName("YnYq3oJ0NvLBI0Hmvyd82l3GZdPlqneVWsrsrZa24ekzoiKl8O");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainIcon("6DCLxIWPXmhHNAybtf29fGbUN2WhvAyBqMGRVMYtHilId63WHw");
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
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessDomain(EntityTestCriteria contraints, UserAccessDomain useraccessdomain) throws Exception {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 117764));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "B1OqjVza2bhZDR6P7OxlFiK35JCQH8QvXt5y6ia3d9YJMeUThrKWNoZOejLwCB0uToTmzQVkmstBKL3fpIPoGGJDYVEkkDFCAz428N17gt7F9066uE4250WSq0r5VXqEKnZ8Z3JR8uSRW4MYi54SAqbZpGaKkjB2xXO0Cooda3kbY12XU0LEzcbEdWtHwAgvIA73DBCxGvucSk22Vv8aX3f3TAtYZPaUo9Ynd4UcflGkAdxkvdJiWFWNElCR5OvzA"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "zCGV2tKMRGZASgjjY3QLx6NTjKdKgsoRlQhDZkYcrO78hHncxt2CniC2zXd2QRSHsWKQAG3a8U8valIMCRGfojEwCDlaARYEHspFpFzcrsqzd8MMMZTwGEn1BdBImdS76Eur4q2blQ8a415neQUft2hUfVFdvFrWq6TaRwfowzUJfCckn4GZpZ3cJX4tmylJpLiKWmljdxy8G3O5UEkZkaCHKx9KJ0wCCl6JPJs3YG93tHK7Mirb607Vr7YvaRKeV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "nITTnrEsRi0gEP0u1ahQ765LYUUHFtcaZycvtNwX6bCDavaGkjqpSk0G85AxfA8d7dTc8CCud5AM7EAmdzeITi7s2EAydED0DXjy2jzxhdg4mCRAUYlQixUjwnqnvMjxvEQzKQxMshP0tqXgqqWv1ScJcZrr0Vkm3sXOTgULaxRa4fEmwhYqzjESE9F3jnbVFJWv7YDEMdqLq4HIVllmMLSNTIwUptvkl0rHijBaRkGASEyVgzCvrBFAKfUbKsfWf"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        UserAccessDomain useraccessdomainUnique = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessDomain useraccessdomain = createUserAccessDomain(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccessdomain.getClass().getDeclaredField(contraints.getFieldName());
                }
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
                        useraccessdomain.setUserAccessDomain(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 4:
                        useraccessdomain.setDomainName(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 6:
                        useraccessdomain.setDomainDescription(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 7:
                        useraccessdomain.setDomainHelp(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 8:
                        useraccessdomain.setDomainIcon(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 9:
                        useraccessdomain.setUserAccessDomain(useraccessdomainUnique.getUserAccessDomain());
                        validateUserAccessDomain(contraints, useraccessdomain);
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
