package com.app.server.service.aspect;
import com.app.server.businessservice.appbasicsetup.aaa.SessionValidation;
import com.app.server.businessservice.appbasicsetup.aaa.CookieValidation;
import com.app.server.businessservice.appbasicsetup.aaa.TokenValidation;
import com.app.config.appSetup.model.AppConfiguration;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.athena.server.pluggable.interfaces.CommonEntityInterface;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.spartan.pluggable.exception.core.BaseSecurityException;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.server.interfaces.TokenValidatorInterface;
import java.sql.Timestamp;

@Aspect
@Component
public abstract class ServiceAspect {

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    @Autowired
    private SessionValidation sessionValidation;

    @Autowired
    private CookieValidation cookieValidation;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private TokenValidatorInterface tokenValidation;

    @Autowired
    private AppConfiguration appConfiguration;

    /****
     * Method to validate the entity in save and update operation .
     *
     * @param proceedingJoinPoint
     * @return
     * @throws SecurityException
     */
    public Boolean aroundAdviceSaveAndUpdateLogin(ProceedingJoinPoint proceedingJoinPoint) throws SecurityException {
        boolean isValidEntity = true;
        if (proceedingJoinPoint.getArgs().length > 0) {
            Object methodInputParam = proceedingJoinPoint.getArgs()[0];
            if (methodInputParam != null && methodInputParam instanceof CommonEntityInterface) {
                CommonEntityInterface entity = (CommonEntityInterface) methodInputParam;
                preSaveUpdateOperation(entity);
                entity.setSystemTxnCode(51000);
            } else if (methodInputParam != null && methodInputParam instanceof List) {
                List listOfEntities = (List) methodInputParam;
                if (listOfEntities.size() > 0) {
                    /*
                     * Checking 0th element type. So no need to check type for
                     * each element in the loop.
                     */
                    if (listOfEntities.get(0) instanceof CommonEntityInterface) {
                        for (Object object : listOfEntities) {
                            CommonEntityInterface entity = (CommonEntityInterface) object;
                            preSaveUpdateOperation(entity);
                            entity.setSystemTxnCode(51000);
                        }
                    }
                }
            }
        }
        return isValidEntity;
    }

    /** Set runtime info object to be used every where in all layer */
    public void setRuntimeInfoObject(HttpServletRequest request, String _requestId, String _sessionId) {
        /* create logging info object (Needs to call from login service only */
        runtimeLogInfoHelper.setCustomerId(getCustomerId(request));
        runtimeLogInfoHelper.createRuntimeLogUserInfo(getCustomerId(request), loggedInUserId(request), request.getRemoteHost());
        runtimeLogInfoHelper.setRequestHeaderBean(new RequestHeaderBean(new RuntimeLogUserInfoBean(getCustomerId(request), loggedInUserId(request), request.getRemoteHost(), request.getRemotePort(), 0, 0), _sessionId, _requestId));
    }

    /**
     * Method to check whether the request is validated .
     *
     * @param session
     * @param request
     * @param response
     * @return
     * @throws BaseSecurityException
     */
    public boolean validateRequest(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws BaseSecurityException {
        if (!sessionValidation.checkIgnoreURL(request)) {
            sessionValidation.validateSession(session, request, response);
            cookieValidation.validateSessionCookie(session, request);
        }
        return true;
    }

    protected void preSaveUpdateOperation(CommonEntityInterface entity) throws SecurityException {
        prepareEntityAuditInfo(entity);
        /* validates the entity */
        validateEntity(entity);
    }

    public Object aroundAdvice2Update(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        return proceedingJoinPoint;
    }

    public Object aroundAdvice2Delete(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        return null;
    }

    /**
     * Validate Entity
     *
     * @param entity
     * @return
     * @throws SecurityException
     */
    private boolean validateEntity(CommonEntityInterface entity) throws SecurityException {
        boolean isValidEntity = true;
        /* set entity validator */
        entity.setEntityValidator(this.entityValidator);
        /* validates the entity */
        isValidEntity = entity.isValid();
        return isValidEntity;
    }

    protected Object aroundAdvicefindOperation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        return true;
    }

    public void afterReturning(JoinPoint join) throws IOException {
    }

    /**
     * Fetch userId from session
     *
     * @param request
     * @return
     */
    public String loggedInUserId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("userId") != null) {
            return (String) session.getAttribute("userId").toString();
        } else {
            return "SYSTEM_USER";
        }
    }

    /**
     * Fetch sessionId from session.
     *
     * @param request
     * @return
     */
    public String getSessionId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("usidHash") != null) {
            return session.getAttribute("usidHash").toString();
        } else {
            return "";
        }
    }

    /**
     * Sets the entityAudit value for entity.
     *
     * @param entity
     */
    protected void prepareEntityAuditInfo(CommonEntityInterface entity) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String userId = loggedInUserId(request);
        entity.setEntityAudit(1, userId);
    }

    /**
     * Fetching customer Id
     *
     * @param request
     * @return
     */
    public String getCustomerId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("multitenantId") != null) {
            return session.getAttribute("multitenantId").toString();
        } else {
            return "SYSTEM_CUSTOMER";
        }
    }

    /****
     * Method to validate the token .
     *
     * @params ProceedingJoinPoint : taking request token : token passed from
     *         request
     * @throws java.lang.Exception
     */
    public boolean checkToken(final ProceedingJoinPoint proceedingJoinPoint, final String token) throws Exception {
        try {
            return tokenValidation.validateToken(token, appConfiguration.getJwtConfig().getTokenKey());
        } catch (final Exception e) {
            return false;
        }
    }

    @Pointcut("execution(* com.spartan..service..*(..))")
    protected void spartanServiceOperation() {
    }

    @Pointcut("execution(* com.athena..service..update*(..)) || execution(* com.spartan..service..update*(..))")
    protected void athenaAndSpartanUpdateServiceOperation() {
    }

    @Pointcut("execution(* com.athena..service..*(..))")
    protected void athenaServiceOperation() {
    }

    public void serviceLogic(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getHeader("Job-Execution") == null) {
            if (request.getHeader("isPublicApi") == null) {
                validateRequest(session, request, response);
                if (!sessionValidation.checkIgnoreURL(request)) {
                    java.sql.Timestamp currentTime = new java.sql.Timestamp(System.currentTimeMillis());
                    session.setAttribute("lastAccessTime", new Timestamp(System.currentTimeMillis()));
                    runtimeLogInfoHelper.setUserAccessCode(Integer.parseInt(session.getAttribute("userAccessCode").toString()));
                }
            }
        }
    }
}
