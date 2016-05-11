package hrapp.app.server.repository.dataVisualizer.query.aspect;
import hrapp.app.server.repository.aspect.RepositoryException;
import hrapp.app.server.repository.aspect.RepositoryAspect;


import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import com.spartan.pluggable.logger.api.LogManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import com.spartan.healthmeter.entity.scheduler.MethodCallDetails;
import com.spartan.healthmeter.msgWriter.config.HealthConstants;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.spartan.pluggable.logger.alarms.AppAlarm;

@Aspect
@Component
public class RepositoryQueryAspect extends RepositoryAspect {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private ArtMethodCallStack requestDetails;

    private LogManager Log = LogManagerFactory.getInstance(System.getProperty("LOGGER_ID"));

     @Around("allOperation()")
    public Object aroundAllOtherOpeartion(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodCallDetails methodCallDetails = new MethodCallDetails(requestDetails.getRequestId(), requestDetails.getCallSequence(), HealthConstants.CLASS_TYPE.REPOSITORY, runtimeLogInfoHelper.getRuntimeLogInfo().getUserIPAddress(), "", joinPoint.getTarget().getClass().toString(), joinPoint.getSignature().getName(), runtimeLogInfoHelper.getRuntimeLogInfo().getUserId(), requestDetails.getAppSessionId());
        Object object = null;
        repositoryLogic(joinPoint);
        try {
            Log.out.println("DVIQE354901100", runtimeLogInfoHelper.getRequestHeaderBean(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName());
            object = joinPoint.proceed();
            methodCallDetails.setPostCallDetails(HealthConstants.METHOD_NORMAL_EXECUTION);
            Log.out.println("DVIQE354902100", runtimeLogInfoHelper.getRequestHeaderBean(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName());
        } catch (Exception e) {
            Log.out.println("DVIQE354900100", runtimeLogInfoHelper.getRequestHeaderBean(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getMessage());
            throw e;
        } finally {
            requestDetails.addMethodCallDetails(methodCallDetails);
        }
        return object;
    }

      @Pointcut("execution(* com.athena.server.query..repository..*(..))  && !within(com.athena.server.query.repository.ArtQueryRepository+)")
    protected void allOperation() {
    }
}