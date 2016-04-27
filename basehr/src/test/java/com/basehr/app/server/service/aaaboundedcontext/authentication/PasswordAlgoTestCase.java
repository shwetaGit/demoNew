package com.basehr.app.server.service.aaaboundedcontext.authentication;
import com.basehr.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.basehr.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.basehr.app.server.repository.aaaboundedcontext.authentication.PasswordAlgoRepository;
import com.basehr.app.shared.aaaboundedcontext.authentication.PasswordAlgo;
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
public class PasswordAlgoTestCase extends EntityTestCriteria {

    @Autowired
    private PasswordAlgoRepository<PasswordAlgo> passwordalgoRepository;

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

    private PasswordAlgo createPasswordAlgo(Boolean isSave) throws Exception {
        PasswordAlgo passwordalgo = new PasswordAlgo();
        passwordalgo.setAlgoHelp("6ELcI8kalqwO8KdrGz9re8FqJ3NxQNxRgB5rho7JZRWrsbgVIH");
        passwordalgo.setAlgoDescription("A1rryJO4PzVhefgxhAJePYo62lOCktIpLOqsFuDJLfRk4eQOHX");
        passwordalgo.setAlgoIcon("hnNTrFntBk1V9jii6HIByuD1Nyjlq7wxocvGZS0vr2xO1K9Sdv");
        passwordalgo.setAlgorithm(6);
        passwordalgo.setAlgoName("IBRqQFB8GCW0GgUTMqMmk0WRK0yugndA9WZB4vSPNLcSuDMWMN");
        passwordalgo.setEntityValidator(entityValidator);
        return passwordalgo;
    }

    @Test
    public void test1Save() {
        try {
            PasswordAlgo passwordalgo = createPasswordAlgo(true);
            passwordalgo.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            passwordalgo.isValid();
            passwordalgoRepository.save(passwordalgo);
            map.put("PasswordAlgoPrimaryKey", passwordalgo._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("PasswordAlgoPrimaryKey"));
            PasswordAlgo passwordalgo = passwordalgoRepository.findById((java.lang.String) map.get("PasswordAlgoPrimaryKey"));
            passwordalgo.setAlgoHelp("UVsRSfU55B0UB8LmaEkrBu7ZRZmrjkLexdkC09mVsBpjiwQiwT");
            passwordalgo.setAlgoDescription("7pdL0xvL4KNNfKhStTYBHEjgQAFGivYA9ioABdsQD3llFvzBsp");
            passwordalgo.setAlgoIcon("oGjq9kIsb6MB6h3GSqR1lFT8yz5xlRUr7PrfGBeKKXmEYmpwLo");
            passwordalgo.setAlgorithm(2);
            passwordalgo.setVersionId(1);
            passwordalgo.setAlgoName("iNgWHMzHxOdoWxQeX9GQBaPqaUtJRpC9ccesjb2eFXug3kqOos");
            passwordalgo.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            passwordalgoRepository.update(passwordalgo);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("PasswordAlgoPrimaryKey"));
            passwordalgoRepository.findById((java.lang.String) map.get("PasswordAlgoPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("PasswordAlgoPrimaryKey"));
            passwordalgoRepository.delete((java.lang.String) map.get("PasswordAlgoPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validatePasswordAlgo(EntityTestCriteria contraints, PasswordAlgo passwordalgo) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            passwordalgo.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            passwordalgo.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            passwordalgo.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            passwordalgoRepository.save(passwordalgo);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "algorithm", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "algorithm", 13));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "algoName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "algoName", "oDgC7vc0h2wdtI8PvRTYlBvKeRnotDU8SftZAWcDGzxGENEGD5cgodQlHPPyiDWbIULuHC5DWUyx6SKBAgMNIS1ySDcjkv7wCw5W3nVgMLN3EYw7ILWcPPsNVWML1ukRjYp3Gt2HvEwhDaE848ib1MaCAcoAYpceAGin9haz6ILp8raK7GR6boYeewKZ4x1ocHStbhxUF725XnyM5ewcygm5DmT1aZaWDqJm4Ape0woKz3hlSaxEBaFZ9nZokcrCs"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "algoDescription", "vORLwZJx9Njzgn6iI1LdU83xpg7i54QuQa0Da1q7fEaJ9SihEpBA3VfFJFPxtNadB1tmSxCtIKtx0d7aSK431UHhvWCVRq75KCkv3dZUaWEQZXJXeTSYKLheREaKUE4ahMSHgtdSTbvQ1sgFKzpsfu1u1zkm0fLeEs6GAUZNmw6H7beCUoH4IoFDFc3S4f4UljHfs8IfYz8Lg48kgPx2W9YfLaX9sKqtmmqZlBoOhJAQngcwTeHVLzc7Dz10puCrE"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "algoIcon", "eZTsVZb3Hi8DBquwtsQuCLLly61bQeaivqnaA1GbVeD9AdcNcNu3D3DpYAPNk02c6"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "algoHelp", "FmgfFzk71h9EwUFq2xP6zgfqNj0gcvJ4dh2aYFSCOIZfzkbKwM9W4efjQaZUVOhzZEnWWCia0OCbql1pFoo28rx1A2PSO5gtOQbCbX7kRLIR1ggo9ppMIaIxJvzw7pxj0wFbKIHj5VoEXRsEMwXi27M30b2NOYk5rMBPLBXV182wru7uk8HTCOqfBiRr2SmIhFS1eZtL0gbkXXLsftQnhIpd3AfU5VJBkCkho2OKaYbTQscVsiPIMxbd7XfablPKe"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                PasswordAlgo passwordalgo = createPasswordAlgo(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = passwordalgo.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(passwordalgo, null);
                        validatePasswordAlgo(contraints, passwordalgo);
                        failureCount++;
                        break;
                    case 2:
                        passwordalgo.setAlgorithm(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validatePasswordAlgo(contraints, passwordalgo);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(passwordalgo, null);
                        validatePasswordAlgo(contraints, passwordalgo);
                        failureCount++;
                        break;
                    case 4:
                        passwordalgo.setAlgoName(contraints.getNegativeValue().toString());
                        validatePasswordAlgo(contraints, passwordalgo);
                        failureCount++;
                        break;
                    case 5:
                        passwordalgo.setAlgoDescription(contraints.getNegativeValue().toString());
                        validatePasswordAlgo(contraints, passwordalgo);
                        failureCount++;
                        break;
                    case 6:
                        passwordalgo.setAlgoIcon(contraints.getNegativeValue().toString());
                        validatePasswordAlgo(contraints, passwordalgo);
                        failureCount++;
                        break;
                    case 7:
                        passwordalgo.setAlgoHelp(contraints.getNegativeValue().toString());
                        validatePasswordAlgo(contraints, passwordalgo);
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
