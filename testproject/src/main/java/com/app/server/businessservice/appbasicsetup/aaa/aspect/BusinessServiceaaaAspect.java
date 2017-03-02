package com.app.server.businessservice.appbasicsetup.aaa.aspect;
import com.app.server.businessservice.aspect.BusinessAspect;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.spartan.pluggable.logger.api.LogManager;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.alarms.AppAlarm;
import com.spartan.pluggable.logger.alarms.EventAppLayers;

@Aspect
@Component
public class BusinessServiceaaaAspect extends BusinessAspect {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    @Around("allOperation()")
    public Object aroundfindAll(ProceedingJoinPoint joinPoint) throws Throwable {
        Object object = null;
        try {
            Log.out.println("ABSAA217900100", runtimeLogInfoHelper.getRequestHeaderBean(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), joinPoint.getSignature().getDeclaringTypeName() + ":" + joinPoint.getSignature().getName());
            object = handleMethodCall(joinPoint, runtimeLogInfoHelper.getRuntimeLogInfo());
            Log.out.println("ABSAA227900100", runtimeLogInfoHelper.getRequestHeaderBean(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        } catch (Exception e) {
            AppAlarm appAlarm = Log.getExceptionAlarm("ABS", "AA", e.getClass().getName());
            if (appAlarm.getAppLayer() == EventAppLayers.BUSINESS_SERVICE) {
                Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), e, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage(), e);
            }
            throw e;
        }
        return object;
    }

    @Pointcut("execution(* com.app.server.businessservice.appbasicsetup.aaa..*(..))")
    protected void allOperation() {
    }
}
