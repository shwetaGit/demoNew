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
import com.app.server.repository.issuetrackerboundedcontext.projectmanager.WorkflowUserRoleRepository;
import com.app.shared.issuetrackerboundedcontext.projectmanager.WorkflowUserRole;
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
import com.app.shared.issuetrackerboundedcontext.projectmanager.Workflow;
import com.app.server.repository.issuetrackerboundedcontext.projectmanager.WorkflowRepository;
import com.app.shared.issuetrackerboundedcontext.projectmanager.ProjectRoles;
import com.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectRolesRepository;
import com.app.shared.issuetrackerboundedcontext.projectmanager.IssueVisibility;
import com.app.server.repository.issuetrackerboundedcontext.projectmanager.IssueVisibilityRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class WorkflowUserRoleTestCase extends EntityTestCriteria {

    @Autowired
    private WorkflowUserRoleRepository<WorkflowUserRole> workflowuserroleRepository;

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

    private WorkflowUserRole createWorkflowUserRole() throws SpartanPersistenceException, SpartanConstraintViolationException {
        Workflow workflow = new Workflow();
        workflow.setWorkflowName("7YctU08VjHAHPGOmyuNiof1ErdhXpgkZXDRdp6GtzpsyV0GJnF");
        Workflow WorkflowTest = workflowRepository.save(workflow);
        map.put("WorkflowPrimaryKey", workflow._getPrimarykey());
        ProjectRoles projectroles = new ProjectRoles();
        projectroles.setRoleName("wSxSJS0rhSbUtrKme0En4TRoQplvep58qS9Vx5J8I8GTVNIIkU");
        projectroles.setCanAssignRole(true);
        IssueVisibility issuevisibility = new IssueVisibility();
        issuevisibility.setIssueVisibilityName("EAwh7Awy9uvfuParsLSvNXCDD6L7T5yiSj6xc8zchxzIXAMqpw");
        issuevisibility.setIssueVisibilityDesc("a0ST0A8OwEc6sndZlEhxA73nSf0xXL30Whlbxnsv5lsyPTlsZw");
        IssueVisibility IssueVisibilityTest = issuevisibilityRepository.save(issuevisibility);
        map.put("IssueVisibilityPrimaryKey", issuevisibility._getPrimarykey());
        projectroles.setRoleName("BY0CbRKBt8QOy1zNLpB5Rc4v4QDbhCwxsBNqJ2Nri6dwSSPA8H");
        projectroles.setCanAssignRole(true);
        projectroles.setIssueVisibilityCode((java.lang.String) IssueVisibilityTest._getPrimarykey()); /* ******Adding refrenced table data */
        ProjectRoles ProjectRolesTest = projectrolesRepository.save(projectroles);
        map.put("ProjectRolesPrimaryKey", projectroles._getPrimarykey());
        WorkflowUserRole workflowuserrole = new WorkflowUserRole();
        workflowuserrole.setWorkflowId((java.lang.String) WorkflowTest._getPrimarykey()); /* ******Adding refrenced table data */
        workflowuserrole.setPrjRoleId((java.lang.String) ProjectRolesTest._getPrimarykey());
        workflowuserrole.setEntityValidator(entityValidator);
        return workflowuserrole;
    }

    @Test
    public void test1Save() {
        try {
            WorkflowUserRole workflowuserrole = createWorkflowUserRole();
            workflowuserrole.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            workflowuserrole.isValid();
            workflowuserroleRepository.save(workflowuserrole);
            map.put("WorkflowUserRolePrimaryKey", workflowuserrole._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private WorkflowRepository<Workflow> workflowRepository;

    @Autowired
    private ProjectRolesRepository<ProjectRoles> projectrolesRepository;

    @Autowired
    private IssueVisibilityRepository<IssueVisibility> issuevisibilityRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("WorkflowUserRolePrimaryKey"));
            WorkflowUserRole workflowuserrole = workflowuserroleRepository.findById((java.lang.String) map.get("WorkflowUserRolePrimaryKey"));
            workflowuserrole.setVersionId(1);
            workflowuserrole.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            workflowuserroleRepository.update(workflowuserrole);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByworkflowId() {
        try {
            java.util.List<WorkflowUserRole> listofworkflowId = workflowuserroleRepository.findByWorkflowId((java.lang.String) map.get("WorkflowPrimaryKey"));
            if (listofworkflowId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByprjRoleId() {
        try {
            java.util.List<WorkflowUserRole> listofprjRoleId = workflowuserroleRepository.findByPrjRoleId((java.lang.String) map.get("ProjectRolesPrimaryKey"));
            if (listofprjRoleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("WorkflowUserRolePrimaryKey"));
            workflowuserroleRepository.findById((java.lang.String) map.get("WorkflowUserRolePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("WorkflowUserRolePrimaryKey"));
            workflowuserroleRepository.delete((java.lang.String) map.get("WorkflowUserRolePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateWorkflowUserRole(EntityTestCriteria contraints, WorkflowUserRole workflowuserrole) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            workflowuserrole.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            workflowuserrole.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            workflowuserrole.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            workflowuserroleRepository.save(workflowuserrole);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
    }
}
