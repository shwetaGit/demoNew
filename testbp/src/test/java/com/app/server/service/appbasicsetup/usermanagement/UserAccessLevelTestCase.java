package com.app.server.service.appbasicsetup.usermanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.app.server.service.RandomValueGenerator;
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
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.server.pluggable.interfaces.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class UserAccessLevelTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

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
            LogManagerFactory.createLogManager(_path, AppLoggerConstant.LOGGER_ID);
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

    private UserAccessLevel createUserAccessLevel(Boolean isSave) throws Exception {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelName("CiOLcbOwFTNOLJuNun973juIE60Fb00ZyUb60dftnwtDq7l9FR");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelIcon("V8kzhhUPDyeXZRJjzyYBlIDBYBBch4PpdjzAdDUYfXg76Vx8cj");
        useraccesslevel.setLevelDescription("NNelPv2L91x3ZfxluvMjsFCIm7aSTFiJcvElG4kwlYvw8UJCUc");
        useraccesslevel.setLevelHelp("jGnJjRPDsYFkeInWELaO2W0RH9UZqjWFHVd7Akxu2EfOAjd7Z6");
        useraccesslevel.setEntityValidator(entityValidator);
        return useraccesslevel;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessLevel useraccesslevel = createUserAccessLevel(true);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccesslevel.isValid();
            useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            UserAccessLevel useraccesslevel = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            useraccesslevel.setLevelName("S9G3JR2LFK0WTzkAEZFYrLkQ7aAUpCCjPGmt5jBGT0hOW2BoGh");
            useraccesslevel.setUserAccessLevel(88166);
            useraccesslevel.setLevelIcon("PhO3ZpzwOmkIehIgy1OB1sODHxXNVnFo4IARMli4mGbuHpSJn5");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelDescription("7BDsDTecHhoIdQy1GSK3yodGjifor1baHfb96fOHDAnnPQNNCX");
            useraccesslevel.setLevelHelp("QdKPRgS05haFlyZfidbZpa8RpJFExeDhC2b4m43PEN1kxi4PtX");
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccesslevelRepository.update(useraccesslevel);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessLevel(EntityTestCriteria contraints, UserAccessLevel useraccesslevel) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccesslevelRepository.save(useraccesslevel);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessLevel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 118759));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "GECnuYsPTIDTlkJWalbE3wpjewjQiSAX7WqIEuJi7FcT7cAKD4WsqHL9fFW6Ad285FOnUIRQdoME0vNLNVqEcOsYi76CfAYt2ws4aw79U1pSuoF2ynJSaU3miBJgAHW5Ik4HwYtguEbRsUBmebdkQ03UBwHKoE2sR5aIQd4U1k4p1aFK7PvnDDiQta1mtd7BJhKuLIjZDzzU29AveWXQStaDaLJgQOj553bWdpaTE8Hok39CBO91cQITvyHsfqibx"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "PVwxdMh5Zh7zSW6B9FnevscIzqagWARdJAtmdNk2wBPqSaPcQdtC78f6iGUl0vtPKD7lXoB5QjNQ2C4aDShtt6zg7JykaQWBhuQwDmymHrWivUdQ1DOojg7vmaJK9JN5ust8wAsNE6olgLBOYSAfxKIODThDE0nwL54GxfJH2VCaB6AZyFXlik55eKdKyYfIpbcpkzyHJPu0wxBa6IJoectt36sm1cNL5nfKje9JFOJpoJOgHBcMalWaQPutFwJZR"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "r2Y71jfdy0zc5cOxt5VnBuvmum93wL2scPC15LaNQeUr821eE8on3VWHm6YSx6d8cEOV49qN0WwQ9VWaQKCaDZshVqEGTXP8rYtuZTxptZjBNJRWBXvMKvV33fZQDWirv0i0vkfdxTKOlaeyZ6bnIxowFt62SfPeUTDeDtcjUN4MuMc3efwqmVZmG3uYqNV4zV3DWo36o6Bc5TmxgUxEKNCFzt2LMEgtYHC37JZ2U8zR1g8gaoxPpd0NbgmANJmh0"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        UserAccessLevel useraccesslevelUnique = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessLevel useraccesslevel = createUserAccessLevel(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccesslevel.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 2:
                        useraccesslevel.setUserAccessLevel(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 4:
                        useraccesslevel.setLevelName(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 6:
                        useraccesslevel.setLevelDescription(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 7:
                        useraccesslevel.setLevelHelp(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 8:
                        useraccesslevel.setLevelIcon(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 9:
                        useraccesslevel.setUserAccessLevel(useraccesslevelUnique.getUserAccessLevel());
                        validateUserAccessLevel(contraints, useraccesslevel);
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
