package com.app.server.businessservice.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import com.spartan.healthmeter.entity.scheduler.MethodCallDetails;
import com.spartan.healthmeter.msgWriter.config.HealthConstants;
import com.spartan.healthmeter.msgWriter.core.Healthmeter;
import com.spartan.sprinkler.core.RuntimeLogUserInfo;
import com.spartan.sprinkler.core.Sprinkler;

@Aspect
@Component
public class BusinessAspect {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private Sprinkler sprinkler;

    @Autowired
    private ArtMethodCallStack requestDetails;

    @Autowired
    private Healthmeter healthmeter;

    @Around(value = "allOperation()")
    public Object aroundfindAll(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodCallDetails methodCallDetails = new MethodCallDetails(requestDetails.getRequestId(), requestDetails.getCallSequence(), HealthConstants.CLASS_TYPE.BUSINESS, runtimeLogInfoHelper.getRuntimeLogInfo().getUserIpAddress(), "", joinPoint.getTarget().getClass().toString(), joinPoint.getSignature().getName(), runtimeLogInfoHelper.getRuntimeLogInfo().getUserId(), "");
        Object object = null;
        try {
            object = handleMethodCall(joinPoint, runtimeLogInfoHelper.getRuntimeLogInfo());
            methodCallDetails.setPostCallDetails(HealthConstants.METHOD_NORMAL_EXECUTION);
        } catch (SpartanPersistenceException e) {
            methodCallDetails.setPostCallDetails(HealthConstants.METHOD_EXCEPTION, e.getExceptionId());
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            methodCallDetails.setPostCallDetails(HealthConstants.METHOD_EXCEPTION, HealthConstants.DEFAULT_EXCEPTION_ID);
            e.printStackTrace();
            throw e;
        } finally {
            requestDetails.addMethodCallDetails(methodCallDetails);
        }
        return object;
    }

    private Object handleMethodCall(ProceedingJoinPoint joinPoint, RuntimeLogUserInfo runtimeLogInfoHelper) throws Throwable {
        try {
            sprinkler.logger.log(runtimeLogInfoHelper, 2000, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), "none");
            Object returnObject = joinPoint.proceed();
            sprinkler.logger.log(runtimeLogInfoHelper, 2001, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
            return returnObject;
        } catch (SpartanPersistenceException e) {
            e.printStackTrace();
            sprinkler.logger.log(runtimeLogInfoHelper, e.getExceptionId(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e, "fetching", "Entity");
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            sprinkler.logger.log(runtimeLogInfoHelper, 2007, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e, "fetching", "Entity");
            throw e;
        }
    }

    @Pointcut("execution(* com.app.server.businessservice..*(..))")
    protected void allOperation() {
    }
}
