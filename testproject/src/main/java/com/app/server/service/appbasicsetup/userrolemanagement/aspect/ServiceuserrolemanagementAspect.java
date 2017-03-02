package com.app.server.service.appbasicsetup.userrolemanagement.aspect;
import com.app.server.service.aspect.ServiceAspect;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.spartan.pluggable.logger.alarms.AppAlarm;
import com.spartan.pluggable.logger.alarms.EventAction;
import com.spartan.pluggable.logger.alarms.EventAppLayers;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.api.LogManagerFactory;

@Aspect
@Component
public class ServiceuserrolemanagementAspect extends ServiceAspect {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    public HttpStatus httpStatusCode;

    private final LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    @Around("allOperation()")
    @Order(1)
    public Object aroundAdvice1(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        final ServletWebRequest servletWebRequest = new ServletWebRequest(request);
        final HttpServletResponse response = servletWebRequest.getResponse();
        final HttpSession session = request.getSession();
        setRuntimeInfoObject(request, "REQUEST_ID", "APPSESSION_ID");
        if (request.getHeader("token") != null && !request.getHeader("token").equals("null")) {
            if (!checkToken(proceedingJoinPoint, request.getHeader("token"))) {
                final AppAlarm appAlarm = Log.getAlarm("ABSRM144900500");
                final ResponseBean exceptionbean = new ResponseBean(appAlarm);
                exceptionbean.add("message", String.format(appAlarm.getMessage(), "UNAUTHORIZED"));
                httpStatusCode = HttpStatus.valueOf(appAlarm.getAlarmStatus());
                Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName(), String.format(appAlarm.getMessage(), "UNAUTHORIZED"));
                return new ResponseEntity<ResponseBean>(exceptionbean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
            }
        }
        ResponseEntity<ResponseBean> responseEntity = new ResponseEntity<>(HttpStatus.OK);
        try {
            serviceLogic(session, request, response);
            final Object obj = proceedingJoinPoint.proceed();
            responseEntity = (ResponseEntity<ResponseBean>) obj;
            httpStatusCode = responseEntity.getStatusCode();
        } catch (final com.spartan.pluggable.exception.core.AppBaseException e) {
            final AppAlarm appAlarm = Log.getAlarm(e.getAppAlarmId());
            final ResponseBean exceptionbean = new ResponseBean(appAlarm);
            exceptionbean.add("message", String.format(appAlarm.getMessage(), e.getExceptionMessage()));
            httpStatusCode = HttpStatus.valueOf(appAlarm.getAlarmStatus());
            return new ResponseEntity<ResponseBean>(exceptionbean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
        } catch (final Exception e) {
            final AppAlarm appAlarm = Log.getAlarm("ABSRM144900500");
            final ResponseBean exceptionbean = new ResponseBean(appAlarm);
            exceptionbean.add("message", String.format(appAlarm.getMessage(), e.getMessage()));
            httpStatusCode = HttpStatus.valueOf(appAlarm.getAlarmStatus());
            Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), e, proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName(), String.format(appAlarm.getMessage(), e.getMessage()));
            return new ResponseEntity<ResponseBean>(exceptionbean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
        }
        return responseEntity;
    }

    @Around("saveOperation()")
    @Order(2)
    public Object aroundAdvice2Save(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object returnObject = new Object();
        final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ResponseEntity<ResponseBean> responseEntity = new ResponseEntity<>(HttpStatus.OK);
        try {
            Log.out.println("ABSRM112900100", runtimeLogInfoHelper.getRequestHeaderBean(), proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getSignature().getDeclaringTypeName() + ":" + proceedingJoinPoint.getSignature().getName());
            aroundAdviceSaveAndUpdateLogin(proceedingJoinPoint);
            returnObject = proceedingJoinPoint.proceed();
            responseEntity = (ResponseEntity<ResponseBean>) returnObject;
            httpStatusCode = responseEntity.getStatusCode();
        } catch (final Exception e) {
            final AppAlarm appAlarm = Log.getExceptionAlarm("ABS", "RM", EventAppLayers.WEB_SERVICE, EventAction.WRITE, e.getClass().getName());
            final ResponseBean exceptionbean = new ResponseBean(appAlarm);
            exceptionbean.add("message", String.format(appAlarm.getMessage(), e.getMessage()));
            httpStatusCode = HttpStatus.valueOf(appAlarm.getAlarmStatus());
            if (appAlarm.getAppLayer() == EventAppLayers.WEB_SERVICE) {
                Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), e, proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getSignature().getDeclaringTypeName() + ":" + proceedingJoinPoint.getSignature().getName());
            }
            return new ResponseEntity<ResponseBean>(exceptionbean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
        }
        return responseEntity;
    }

    @Override
    @Around("updateOperation()")
    @Order(2)
    public Object aroundAdvice2Update(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object returnObject = new Object();
        final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ResponseEntity<ResponseBean> responseEntity = new ResponseEntity<>(HttpStatus.OK);
        try {
            Log.out.println("ABSRM111900100", runtimeLogInfoHelper.getRequestHeaderBean(), proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getSignature().getDeclaringTypeName() + ":" + proceedingJoinPoint.getSignature().getName());
            aroundAdviceSaveAndUpdateLogin(proceedingJoinPoint);
            returnObject = proceedingJoinPoint.proceed();
            responseEntity = (ResponseEntity<ResponseBean>) returnObject;
            httpStatusCode = responseEntity.getStatusCode();
        } catch (final Exception e) {
            final AppAlarm appAlarm = Log.getExceptionAlarm("ABS", "RM", EventAppLayers.WEB_SERVICE, EventAction.UPDATE, e.getClass().getName());
            final ResponseBean exceptionbean = new ResponseBean(appAlarm);
            exceptionbean.add("message", String.format(appAlarm.getMessage(), e.getMessage()));
            httpStatusCode = HttpStatus.valueOf(appAlarm.getAlarmStatus());
            if (appAlarm.getAppLayer() == EventAppLayers.WEB_SERVICE) {
                Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), e, proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getSignature().getDeclaringTypeName() + ":" + proceedingJoinPoint.getSignature().getName());
            }
            return new ResponseEntity<ResponseBean>(exceptionbean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
        }
        return responseEntity;
    }

    @Override
    @Around("deleteOperation()")
    @Order(2)
    public Object aroundAdvice2Delete(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object returnObject = new Object();
        final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ResponseEntity<ResponseBean> responseEntity = new ResponseEntity<>(HttpStatus.OK);
        try {
            Log.out.println("ABSRM118900100", runtimeLogInfoHelper.getRequestHeaderBean(), proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getSignature().getDeclaringTypeName() + ":" + proceedingJoinPoint.getSignature().getName());
            returnObject = proceedingJoinPoint.proceed();
            responseEntity = (ResponseEntity<ResponseBean>) returnObject;
            httpStatusCode = responseEntity.getStatusCode();
        } catch (final Exception e) {
            final AppAlarm appAlarm = Log.getExceptionAlarm("ABS", "RM", EventAppLayers.WEB_SERVICE, EventAction.DELETE, e.getClass().getName());
            final ResponseBean exceptionbean = new ResponseBean(appAlarm);
            exceptionbean.add("message", String.format(appAlarm.getMessage(), e.getMessage()));
            httpStatusCode = HttpStatus.valueOf(appAlarm.getAlarmStatus());
            if (appAlarm.getAppLayer() == EventAppLayers.WEB_SERVICE) {
                Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), e, proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName(), String.format(appAlarm.getMessage(), e.getMessage()), proceedingJoinPoint.getSignature().getDeclaringTypeName() + ":" + proceedingJoinPoint.getSignature().getName());
            }
            return new ResponseEntity<ResponseBean>(exceptionbean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
        }
        return returnObject;
    }

    @Override
    @Around("findOperation()||getOperation()")
    @Order(2)
    public Object aroundAdvicefindOperation(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object returnObject = new Object();
        final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ResponseEntity<ResponseBean> responseEntity = new ResponseEntity<>(HttpStatus.OK);
        try {
            Log.out.println("ABSRM114900100", runtimeLogInfoHelper.getRequestHeaderBean(), proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getSignature().getDeclaringTypeName() + ":" + proceedingJoinPoint.getSignature().getName());
            returnObject = proceedingJoinPoint.proceed();
            responseEntity = (ResponseEntity<ResponseBean>) returnObject;
            httpStatusCode = responseEntity.getStatusCode();
        } catch (final Exception e) {
            final AppAlarm appAlarm = Log.getExceptionAlarm("ABS", "RM", EventAppLayers.WEB_SERVICE, EventAction.READ, e.getClass().getName());
            final ResponseBean exceptionbean = new ResponseBean(appAlarm);
            exceptionbean.add("message", String.format(appAlarm.getMessage(), e.getMessage()));
            httpStatusCode = HttpStatus.valueOf(appAlarm.getAlarmStatus());
            if (appAlarm.getAppLayer() == EventAppLayers.WEB_SERVICE) {
                Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), e, proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getSignature().getDeclaringTypeName() + ":" + proceedingJoinPoint.getSignature().getName());
            }
            return new ResponseEntity<ResponseBean>(exceptionbean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
        }
        return returnObject;
    }

    @Around("allOtherOperation()")
    @Order(2)
    public Object aroundAdvice2AllOther(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object returnObject = new Object();
        final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ResponseEntity<ResponseBean> responseEntity = new ResponseEntity<>(HttpStatus.OK);
        try {
            returnObject = proceedingJoinPoint.proceed();
            responseEntity = (ResponseEntity<ResponseBean>) returnObject;
            httpStatusCode = responseEntity.getStatusCode();
        } catch (final Exception e) {
            final AppAlarm appAlarm = Log.getExceptionAlarm("ABS", "RM", EventAppLayers.WEB_SERVICE, EventAction.READ_WRITE_UPDATE, e.getClass().getName());
            final ResponseBean exceptionbean = new ResponseBean(appAlarm);
            exceptionbean.add("message", String.format(appAlarm.getMessage(), e.getMessage()));
            httpStatusCode = HttpStatus.valueOf(appAlarm.getAlarmStatus());
            if (appAlarm.getAppLayer() == EventAppLayers.WEB_SERVICE) {
                Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), e, proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getSignature().getDeclaringTypeName() + ":" + proceedingJoinPoint.getSignature().getName());
            }
            return new ResponseEntity<ResponseBean>(exceptionbean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
        }
        return returnObject;
    }

    @Pointcut("execution(* com.app.server.service.appbasicsetup.userrolemanagement..save*(..))")
    protected void saveOperation() {
    }

    @Pointcut("execution(* com.app.server.service.appbasicsetup.userrolemanagement..update*(..))")
    protected void updateOperation() {
    }

    @Pointcut("execution(* com.app.server.service.appbasicsetup.userrolemanagement..delete*(..))")
    protected void deleteOperation() {
    }

    @Pointcut("execution(* com.app.server.service.appbasicsetup.userrolemanagement..find*(..))")
    protected void findOperation() {
    }

    @Pointcut("execution(* com.app.server.service.appbasicsetup.userrolemanagement..get*(..)) && !within(com.spartan.server.session.bizService.SessionDataMgtService+)")
    protected void getOperation() {
    }

    @Pointcut("execution(* com.app.server.service.appbasicsetup.userrolemanagement..*(..)) && !within(com.spartan.server.session.bizService.SessionDataMgtService+)")
    protected void allOperation() {
    }

    @Pointcut("execution(* com.app.server.service.appbasicsetup.userrolemanagement..*(..)) && !within(com.spartan.server.session.bizService.SessionDataMgtService+) && ! findOperation() && ! saveOperation() && ! updateOperation() && ! deleteOperation()")
    protected void allOtherOperation() {
    }
}
