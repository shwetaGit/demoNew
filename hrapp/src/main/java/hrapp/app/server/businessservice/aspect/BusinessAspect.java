package hrapp.app.server.businessservice.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;

@Aspect
@Component
public abstract class BusinessAspect {


	protected Object handleMethodCall(ProceedingJoinPoint joinPoint, RuntimeLogUserInfoBean runtimeLogInfoHelper) throws Throwable {
		try {

			Object returnObject = joinPoint.proceed();
			return returnObject;

		} catch (SpartanPersistenceException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
