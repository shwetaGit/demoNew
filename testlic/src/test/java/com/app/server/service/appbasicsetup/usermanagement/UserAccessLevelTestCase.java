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
        useraccesslevel.setLevelHelp("Mnnac3jGCnrgurIsE1CL3JAhw4jF9A3925dBb20A1F5KpgtOd2");
        useraccesslevel.setLevelName("uViOXqi9fOTztx2gbgLh8W24fu0FnVdUHdpUbFMY8noW3pjXP6");
        useraccesslevel.setLevelIcon("vLjaGaPJu1MWEsazvlouzvFCLlaLJclQUvBhJc49YpjQNm2DyC");
        useraccesslevel.setLevelDescription("UtRDFETXSUtjEGDy2sDMAekomSq8ysxVsGFI6UlcucYiYuLX31");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
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
            useraccesslevel.setLevelHelp("pkjO7kVZoo1bbteRbXVOLj5Jj22TEJ2uRF06rlUnNAEkiaiLft");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelName("TfiFQi42VUT9vCzN1Dr6tiLuRqX4L6uohPCjDxN4GdHFyJaT1I");
            useraccesslevel.setLevelIcon("Ev5vuuhwtYkCXzk1SQutpOdykRzqC94kk4WGIMNQ0t1aQrYR5N");
            useraccesslevel.setLevelDescription("kvQLbAKIpNF7InZ8YFWkwKNSFudi6YxT2G2quECOsM3fE5RJlJ");
            useraccesslevel.setUserAccessLevel(76211);
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 165770));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "3M1HNIQgOkEZYJl97FGX08Uo8N4aUaVCfOMoZW8wPXUqWokbPj6tQ57uRrlp4fX4BrAJEp9aoxYkffNyAxHI0Rk6PH5pxS1qOxibA9y0pvQRVhZIM3dTsR9iA3fxTyfJX3Blra7u1c1LQygDa27FqlrhAauhG3FQYTIx4hKyAEjDgXOfdm0b4YHjHmufcNHKdm2FaSdo1KVmjSIY0ufhWtCsKs0jv9nXGcfKW6E2E9kHI4CW2gDVul3Jf2nzDacv2"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "TUfjRMGTbeIFbYGxjBIyHOZk3Ux5Uo2gZmIhAwPfxUls6YoZRVvibmEYxg8fj5ol4rmkTunURJ5ahg4icqo4vFcfreyzOroxC1FNduqkJaN2BmheeLx4SRAdUrQG5I6jTfXLHGB97GqquWB1tLNcEO20yHdn6bGYTX6h6Df7AgYZvdwlVlb5rl4FShFaIgDm0mCIbrinM55MX5qXgdp3OyvYvgDcxxIjCH7gJxC66vWo9O7FMq04nXyjn0X6uKthB"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "BABETbhfN5ns8nFms6CgMGbMR3rdinvgb7OU0inkqjYb9mTUTA0QkJw3bKXErQqb0hRMjYJhmTQixAYYHVHC6fdQL5ix9jOm2YNsdh5Dw0etYHEOSUdDQ8DKTrx3PbCfXRnt5gnQz67U4gx5Ws2VK5usyDVeneoe3SDNN2rXjbTVt988PIFey1TV7fxMYmHkeTeQPmIvRxDWEuZa5vXqTaFbNV4YKYYdTiSQfwE38rZcvCNo8DvXZwAPA4XIbc7PV"));
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
