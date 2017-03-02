package com.app.server.service.aspect;
import com.app.server.businessservice.appbasicsetup.aaa.SessionValidation;
import com.app.server.businessservice.appbasicsetup.aaa.CookieValidation;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import atg.taglib.json.util.JSONObject;
import com.athena.server.pluggable.interfaces.CommonEntityInterface;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.spartan.pluggable.exception.core.BaseSecurityException;
import com.spartan.pluggable.exception.security.InvalidDataException;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import java.sql.Timestamp;

@Aspect
@Component
public class ServiceBaseAspect {

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    @Autowired
    private SessionValidation sessionValidation;

    @Autowired
    private CookieValidation cookieValidation;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    public HttpStatus httpStatusCode;

    /**
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("athenaServiceOperation()||spartanServiceOperation()")
    @Order(1)
    public Object aroundAdvice1Default(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ServletWebRequest servletWebRequest = new ServletWebRequest(request);
        HttpServletResponse response = servletWebRequest.getResponse();
        HttpSession session = request.getSession();
        String entityName = incrementUricounter(proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName(), proceedingJoinPoint.getSignature().getName());
        ResponseEntity<ResponseBean> responseEntity = new ResponseEntity<>(HttpStatus.OK);
        try {
            serviceLogic(session, request, response, "REQUEST_ID", "APPSESSION_ID");
            Object obj = proceedingJoinPoint.proceed();
            responseEntity = (ResponseEntity<ResponseBean>) obj;
            httpStatusCode = responseEntity.getStatusCode();
        } catch (Exception e) {
        }
        return responseEntity;
    }

    /****
     * Method to validate the entity in save and update operation .
     *
     * @param proceedingJoinPoint
     * @return
     * @throws SecurityException
     */
    public Object aroundAdviceSaveAndUpdateLogin(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
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

    /**
     * Handling request for athena and spartan save service
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("athenaServiceOperation()||spartanServiceOperation()")
    @Order(2)
    public Object aroundAdvice2SaveDefault(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        boolean isValidEntity = true;
        Object returnObject = new Object();
        aroundAdviceSaveAndUpdateLogin(proceedingJoinPoint);
        if (isValidEntity) {
            returnObject = proceedingJoinPoint.proceed();
            return returnObject;
        }
        return returnObject;
    }

    /**
     * Validate entity
     *
     * @param entity
     * @throws InvalidDataException
     */
    protected void preSaveUpdateOperation(CommonEntityInterface entity) throws InvalidDataException {
        prepareEntityAuditInfo(entity);
        /* validates the entity */
        validateEntity(entity);
    }

    /**
     * Handling request for athena and spartan Update service
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("athenaAndSpartanUpdateServiceOperation()")
    @Order(2)
    public Object aroundAdvice2Updatedefault(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        boolean isValidEntity = true;
        Object returnObject = new Object();
        aroundAdviceSaveAndUpdateLogin(proceedingJoinPoint);
        if (isValidEntity) {
            returnObject = proceedingJoinPoint.proceed();
            return returnObject;
        }
        return returnObject;
    }

    /**
     * Handling request for athena and spartan Delete service
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("athenaServiceOperation()||spartanServiceOperation()")
    @Order(2)
    public Object aroundAdvice2DeleteDefault(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object returnObject = new Object();
        if (proceedingJoinPoint.getArgs().length > 0) {
            returnObject = proceedingJoinPoint.proceed();
            return returnObject;
        }
        return returnObject;
    }

    /**
     * Validate Entity
     *
     * @param entity
     * @return
     * @throws SecurityException
     */
    private boolean validateEntity(CommonEntityInterface entity) throws InvalidDataException {
        boolean isValidEntity = true;
        /* set entity validator */
        entity.setEntityValidator(this.entityValidator);
        /* validates the entity */
        isValidEntity = entity.isValid();
        return isValidEntity;
    }

    /**
     * Handling request for athena and spartan Find service
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("athenaServiceOperation()||spartanServiceOperation()")
    @Order(2)
    public Object aroundAdvicefindOperationDefault(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object returnObject = new Object();
        if (proceedingJoinPoint.getArgs().length > 0) {
            Object methodInputParam = proceedingJoinPoint.getArgs()[0];
            if (methodInputParam != null) {
                returnObject = proceedingJoinPoint.proceed();
            }
        } else {
            returnObject = proceedingJoinPoint.proceed();
        }
        return returnObject;
    }

    public String incrementUricounter(String className, String methodName) {
        return null;
    }

    /**
     * Fetch userId from session
     *
     * @param request
     * @return
     */
    public String loggedInUserId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("usidHash") != null) {
            String loggedInObject = (String) session.getAttribute(session.getAttribute("usidHash").toString());
            try {
                JSONObject json = new JSONObject(loggedInObject);
                JSONObject userJSON = json.getJSONObject("userDetail");
                return userJSON.getString("userId");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return "";
        }
        return null;
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
            return (String) session.getAttribute("usidHash").toString();
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
            return (String) session.getAttribute("multitenantId").toString();
        } else {
            return "";
        }
    }

    @Pointcut("execution(* com.spartan..service..*(..))")
    protected void spartanServiceOperation() {
    }

    @Pointcut("execution(* com.athena..service..update*(..)) || execution(* com.spartan..service..update*(..))")
    protected void athenaAndSpartanUpdateServiceOperation() {
    }

    @Pointcut("execution(* com.athena..service..*(..)) && !within(com.athena.server.dataengine.service..*))")
    protected void athenaServiceOperation() {
    }

    public void serviceLogic(HttpSession session, HttpServletRequest request, HttpServletResponse response, String _requestId, String _sessionId) throws Exception {
        runtimeLogInfoHelper.setCustomerId(getCustomerId(request));
        runtimeLogInfoHelper.createRuntimeLogUserInfo("customer", loggedInUserId(request), request.getRemoteHost());
        runtimeLogInfoHelper.setRequestHeaderBean(new RequestHeaderBean(new RuntimeLogUserInfoBean(getCustomerId(request), loggedInUserId(request), request.getRemoteHost(), request.getRemotePort(), 100, 0), _sessionId, _requestId));
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
