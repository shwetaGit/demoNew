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
import com.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectAccessRightsRepository;
import com.app.shared.issuetrackerboundedcontext.projectmanager.ProjectAccessRights;
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
public class ProjectAccessRightsTestCase extends EntityTestCriteria {

    @Autowired
    private ProjectAccessRightsRepository<ProjectAccessRights> projectaccessrightsRepository;

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

    private ProjectAccessRights createProjectAccessRights() throws SpartanPersistenceException, SpartanConstraintViolationException {
        ProjectAccessRights projectaccessrights = new ProjectAccessRights();
        projectaccessrights.setProjectAccessName("mJfp09ikGLlLp1ahITT9CYxzYExNuzSrWgv4Kc3PlFw6azGDcD");
        projectaccessrights.setProjectAccessDesc("yEMn03KXJ5QH2wvrUDPx8ddGY2YMuYY9NiytvnxG0Szq6L7P5l");
        projectaccessrights.setEntityValidator(entityValidator);
        return projectaccessrights;
    }

    @Test
    public void test1Save() {
        try {
            ProjectAccessRights projectaccessrights = createProjectAccessRights();
            projectaccessrights.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            projectaccessrights.isValid();
            projectaccessrightsRepository.save(projectaccessrights);
            map.put("ProjectAccessRightsPrimaryKey", projectaccessrights._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("ProjectAccessRightsPrimaryKey"));
            ProjectAccessRights projectaccessrights = projectaccessrightsRepository.findById((java.lang.String) map.get("ProjectAccessRightsPrimaryKey"));
            projectaccessrights.setVersionId(1);
            projectaccessrights.setProjectAccessName("tbdoS8qoYkl0CEDbo4SmNzVrRFMX28yoPvn4TPFNhMrbYkHxAH");
            projectaccessrights.setProjectAccessDesc("YLFQKlnXC0cF27kwCwMv4ti3GQXILSstLAMVPxyKymUEWMxyci");
            projectaccessrights.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            projectaccessrightsRepository.update(projectaccessrights);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("ProjectAccessRightsPrimaryKey"));
            projectaccessrightsRepository.findById((java.lang.String) map.get("ProjectAccessRightsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("ProjectAccessRightsPrimaryKey"));
            projectaccessrightsRepository.delete((java.lang.String) map.get("ProjectAccessRightsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateProjectAccessRights(EntityTestCriteria contraints, ProjectAccessRights projectaccessrights) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            projectaccessrights.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            projectaccessrights.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            projectaccessrights.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            projectaccessrightsRepository.save(projectaccessrights);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "projectAccessName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "projectAccessName", "fZyCByRQ3oKM8Fj57cvvkHmAlobujT1aDdVXCYprAf46sfCCKujVGslQHqcPaJhfGgUrKOarxsfLaY5dgvRcDSxwsUVJQWO6y0EPQJnpsXKgIr866iX91TGZCJT00llV6MsnzWkBcJodsDVdOsTytIe0VExkUbmkGQXNaeVQT9Tak4yJs1ID8Itl2z6dCxDOegPGV3XuPphn4FnOPUDi1wmsNE7xKOLxtihPZ82xADwJo8UA8KIHyfnIHXXejJvuV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "projectAccessDesc", "CgSFZvUeuXAiwVB4LdoMaQ9aM5SyAhxgCZlttT02fdG9CnKslBoc4fVkoPkAUqYWABtEs1NtcCpbK6OlmUY00Q938qGF3iqbEkV196Xha4ACWKDoekGZzzingbfstO1qAho2mINtkw9pnQOrhxQmGDyAnyi23qk6or603APOGYIZBglE5CKTaKJeYKN3hTOfqR723WKh1uA98HC0DHeTiqUgdvfCpa5fQ0O8eg2IjVQDB4KtwLMLtJljdNG00HfQs9QnMOn7jVXSfFckklft9Hn6i9u576QfIYn4ETMqTHgXnc6zCGDqB9NkiYfY1yfWJOIdvJACUZaolyiAa0FTPznlZ2ny7GHZfGi7oj9YG4iw6JJiBACyXBxZDYexswyj3Qtf4G3DJtnINZFxBMKu2dDuYX7INpO2YaFi1ND3N4LJnuKxTUMoc5seMs5mWtFKezjyCBnjsABTD6hoBaaJDHaLzWNNgr2jY38PzAPM6w5EGLDyn8ugyWFVp4tGhloILNqtpLM2BxIridGmN1232cllyo5EOYl778vboaJFJSDyx5Mr9H2cAJUZIFbkV7SmI1ut97OXA4CvhHJ8BZqq1SS31OSkx4LQmPSBuNf6Pc26u1meT4ykWMACXy7aqnSnB6zIc0TB44yytcsU7LUnmfIBSWL4Xjq8yZSl39euYXE2bQn95j4Ix8w5d3krWYr9qNKVwromN86b1WaqhK9307kuafIHGaAWpEXf84gP79d9xG7rxxRi3SjhSvT0AN3jUPFXAK39d7Z7pesKWJJOj0g9M87BF9iQIcRvdCJlFuHomc8wcTeuMLRCa8U5ogYwl6gW4cG99viek15tWEeJnQvFBNRVC68ViXPYAiV7vSSyAfArowny8AcNwA5cKs4UVzYhuaM14ritL7LLfSABU9CrHHaMGoiPFfl75a2k35MkTTYsF1cx77S7MBQcXIn8EbjfLmd6ko7fWjGdkiVlkhDhhpmipZjUxIBSmPD9v6eWPMEwIg85Yt1owdBl7EvBW"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                ProjectAccessRights projectaccessrights = createProjectAccessRights();
                java.lang.reflect.Field field = projectaccessrights.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(projectaccessrights, null);
                        validateProjectAccessRights(contraints, projectaccessrights);
                        failureCount++;
                        break;
                    case 2:
                        projectaccessrights.setProjectAccessName(contraints.getNegativeValue().toString());
                        validateProjectAccessRights(contraints, projectaccessrights);
                        failureCount++;
                        break;
                    case 3:
                        projectaccessrights.setProjectAccessDesc(contraints.getNegativeValue().toString());
                        validateProjectAccessRights(contraints, projectaccessrights);
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
