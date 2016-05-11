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
        useraccessdomain.setDomainHelp("S5YmNL5kbrMj0QI54311Dh35E695hxiCcbBvhuO0OpDoIhtZ2p");
        useraccessdomain.setDomainIcon("DyNID8y7X0GAF9LazcStrFMxRo0Vt1nbDXl0S8ak8a5PDoJyly");
        useraccessdomain.setDomainDescription("mbGVVfuWQP0WSZHQWlALkdvzvXSGPNOMdpFt5XMiHdkmHNnZpG");
        useraccessdomain.setDomainName("qd9LAIZdUjz7VChux0RRrzSsrZix4uoZMHdrItBwXAxB5UypI2");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
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
            useraccessdomain.setDomainHelp("1QviUYZEgnoaUmRjmLCbI8hnQ2LGunPJpINHnG7mK7oVGiBErq");
            useraccessdomain.setDomainIcon("FwpfVus8jIp4v60gFpC6LzPx7cKvKWUEcTsYrY7vAsdBZdqKK2");
            useraccessdomain.setDomainDescription("ItHNUTd6NR8VnKY98tRbx3JlaQE1nZVL5K5u8y7ZYhuqq6pag7");
            useraccessdomain.setDomainName("FUL3KPqYW76b1DaQpdG6iwcgeV8nsZkyjk5jLDr30mNuJDi8e7");
            useraccessdomain.setUserAccessDomain(82282);
            useraccessdomain.setVersionId(1);
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "userAccessDomain", 103286));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "domainName", "kAnaH0vTpfQOH3AdbWZw7SYpi2pitoqoc89zdr15HEzRYCOxqQKWR5cHmfmJCq38dz1h2YKhdMHb7Sz6Eo9aTFaXVXDT6ttZ9fmv3Xl5xdtxBojj2sTbzWxkp2RHkP0OTc2yawwv9pt6NTRDOq3pKRpzjmthwi4STeI2HoxC2Wa2Y6FW8AlmbZomZ9z1WVKjtMRLzrqdIcFdMO8k66eR1pmclbWWYmOhaFfgpe32fdiQeqpF8I2w02TAVuLUpCEVe"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainDescription", "yrOofMfq6aGnTGIl8hML8K98GHeDpIEXO1lUXpWjBp4f83eRcZWV9JpKGDVSXQgt9bqoC3aOVpecaf9hGB2Q0JazcvRRZT9XT7aNPgGLyNaDCqTLelllP5mwFYpLjPCvg1XbnIObfkxoOC99btrlywdTV7F3x413N0sNn6dt6kK1dVKKJ4dGuBiWzbdQGSmmTChkcXZgMqdoT52O9n0dp07iftqwProMm26pJPmqcVEhpgBz7KUXq0V5JlHxUKgbv"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainHelp", "FF63h9GWGofHjt5M9DoDrihVIFebxyDkm6QBdmbm6Sskqr5u6AB5zCxqM2WNc2lbOZDifG98ue4Tpo5kKM9c02hbdqOIZdoNjrOMyVc6adMny2fRYZTNU21erN3QEDX6YTGKCto0v81Qb1A3QkzFWvr3QTTQ6DwteTtS8Bd8gxvyLEkkG64JEyaZ5EZ6xN1O8H755ck8SsBIEwDAetJWKpu9CBcVZHevvhgL2ecA6C0TkD5NZdy3kI396sCDYcyu6PS9U3FnWgFdjvlpITQh5jGY0opJ2Qkz9B5jzeDID8oExi4szaiuDNTtmaqhrwXRDuVWWDQjCbnHvdUCokqeg6KMbCLkXhvK7c84dKIjiwevD37luK1IU2WSJySfPrSvZUiw88SY6x0JlODu3uE0537lbL1v98mszZxll6uJlETF9SEaipH6RjfQ7KEZvsBbSjnKJu1M1C5WhAxD6u3P06zd3yfaGWYXaxScqsNUJ6l88IeEjRh3XLf1yFirQXoSGO7CHx8ly8UsfCRVoLsLGkfe6HxjNTZlHOKL3Ae3ePVmOpxU2AaSXxAMTdvbRcRqtHBXDL30HJvLwekwGqTj5RkR48OUakQIbG5hYkwoIRgKmtMrtudAc5hjWmKZKQuNH4Np6biT1yx4Wc6YoZjDx7w8h5WOzf29jbXSubZrtkf4n8EtwBlvh5nIHjVS6bQ40T8KsYtErlUVWOAEnp7RMPG3e8TPr5EyZTTwyl6YhE96ROp7EwChueVoJ0NOSznlYm3WhbGAk64A4uJUOEJb2ZjlDOo3BNNTiUXbhtoS6NCov7OzsgTQUq0xudXnmkgoYUf5fGHrNcaNGVQqnmxRQXuIQBQpeiPIBlX3Uf9hK7aw4WKWbs73kDeVq2yChuMsED4qcgPNQpGJPtf5NarCK2Oe8Codbazxald5dlgZhPKjJSsQsaIpQ8024bwfuwH7BvvzEhdgODwMgRhDOOH4oDfUkBf7Ud09cl9F5lEHqRYLtkkU4LnUDVNq3LyCugOhaL1gS5BgOIKigV58wkZlPS29ndY7GjIKcPWJThEvF1YiD8D5rEHQcaRwtoRdRcSGFjRv8xeOUDq8gOvEp72LZH2z0v1nOEaOZWOPFSP1527BLjS86HhEv9HYF83Ti7VyLfjUjP1K1OX1fFkN5Y6OGY0laMigtYlkG034CaXpLQ869Nvxe7CAVySc0arEKFmY5LaAaZNGQbJt77j4UFUHwEtKd03wdwCadS6WHZbH5FLtKtIwjtsgSMRkT4G23iqom1VUHlY30yKeWmz5Wjzpl0Dk2FtDtWiMRSNfZ1G102T0ilMnCB8wQ1THmIb9Bwq6Ac2H517xKjjgW7LvFvH40ETWKtaIIaFiDVCkPDKkHDZl7vRgal9yNLEhUYVDtVDTsmhz3gbsUhWoGTC2wn1ZdIi11Y7RmDILPAZXx1kYeHWb5xn2ikdnHeFESW4RzuNbHv1h1M9GtOzdkRcnT4AXMBGGA0rc11IDoA6q0zf9gdwO2NL7EslzSvBf0dn1vJvHTqunsJ6tCCq5hql9HDcUo7oty66Fv8NOD7k7rYsQLwCMjI0TpPOKMceaH330oyy6cBylLey2To9Ia3gFJf8CncnUsgDyacERDJ9QajKBxslkwCXoCcenfzzdsymE8QbHPaaGnBqzbyDbpCvMdMJkFotvq0pvC0OlbkqWYw3O2pmK89V6kHSseBd8io9eHF1qylhIJQpi7aisPP4EiU0osvlEnBNzcuoeXU3HCzI9k5vYz7gs8lmrf6L3C21pX3G3l0In5dfk2cIBb7jObV2KY4IXSxsZeMNxMCdTsWwnT6JSOZJtSvgotK62a05YKUo0vmsW0SvL3u4Uy2WxiLpMe9jNEoqEDvxlTsDXFUywb9BWLLJn7eqLV1qoV4a9js0VtjFvdO450dkqfwqTOwg9gKL0a8kA8DhSQ4Srh4VMa83rmnlRmOCvvZqk65EQ2k6NypYe817GWRoXu3zNS18ZKO8QSsJIdqM2O8538itYHjnjj6s8Z3DKK7zlt1GNlg7gd"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "domainIcon", "xank1H86covpNdAz0RYVT367GR5vM8XukQnoUwvYfj8bog4bDlUVPTZFqxovmLOcHMyThys8VGxPbNLULW5rH9M0m5JxZWxZlqdnXl1wJnp5vePbKsIu3tj8i6XQjuQYXrFnZ72REVTqxrAF15KS8FsDdiDX5d5ODw8K7QEyfBUinxE0XDquqGdmN3RsjRge17LoZbMuptNxXd4pEwngdgKj0Y0e9cxDnRMXWHICHIHHYVr7MJ4NIR6zol2LKVMt5"));
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
