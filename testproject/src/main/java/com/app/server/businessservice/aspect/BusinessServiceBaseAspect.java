package com.app.server.businessservice.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.spartan.pluggable.exception.core.AppBaseException;

@Aspect
@Component
public class BusinessServiceBaseAspect extends BusinessAspect {

	@Autowired
	private RuntimeLogInfoHelper runtimeLogInfoHelper;

	@Pointcut("execution(* com.athena..server.bizService..*(..))")
	protected void allOperation() {
	}

	/**
	 * Calculate health statistics for all com.athena packaged business services .
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("allOperation()")
	public Object aroundfindAll(ProceedingJoinPoint joinPoint) throws Throwable {
			Object object = null;
		try {
			object = handleMethodCall(joinPoint, runtimeLogInfoHelper.getRuntimeLogInfo());
	} catch (AppBaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return object;
	}
}
