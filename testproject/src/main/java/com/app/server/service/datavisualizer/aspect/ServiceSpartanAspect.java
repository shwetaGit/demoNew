package com.app.server.service.datavisualizer.aspect;
import com.app.server.service.aspect.ServiceAspect;


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

import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.spartan.pluggable.exception.security.InvalidDataException;
import com.spartan.pluggable.logger.alarms.AppAlarm;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.api.LogManagerFactory;

@Aspect
@Component
public class ServiceSpartanAspect extends ServiceAspect {
	@Autowired
	private RuntimeLogInfoHelper runtimeLogInfoHelper;

	public HttpStatus httpStatusCode;

	private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

	/**
	 * Handle all operation in spartan package and add service login to it
	 * 
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("spartanServiceAllOperation()")
	@Order(1)
	public Object aroundAdvice1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		ServletWebRequest servletWebRequest = new ServletWebRequest(request);
		HttpServletResponse response = servletWebRequest.getResponse();
		HttpSession session = request.getSession();
		ResponseEntity<ResponseBean> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			serviceLogic(session, request, response);
			Object obj = proceedingJoinPoint.proceed();
			responseEntity = (ResponseEntity<ResponseBean>) obj;
			httpStatusCode = responseEntity.getStatusCode();
		} catch (Exception e) {
			AppAlarm appAlarm = Log.getAlarm("ABSAN154101400");
			ResponseBean exceptionbean = new ResponseBean(appAlarm);
			exceptionbean.add("message", appAlarm.getMessage());
			httpStatusCode = HttpStatus.valueOf(appAlarm.getAlarmStatus());
			Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), e, proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint
					.getSignature().getName(), String.format(appAlarm.getMessage(), e.getMessage()));
			return new ResponseEntity<ResponseBean>(exceptionbean, responseEntity.getStatusCode());
		}
		return responseEntity;
	}

	/**
	 * Handle Save service in spartan package and set values to request after
	 * validating it .
	 * 
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("spartanSaveServiceOperation()")
	@Order(2)
	public Object aroundAdvice2Save(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		boolean isValidEntity = true;
		Object returnObject = new Object();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		ResponseEntity<ResponseBean> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		aroundAdviceSaveAndUpdateLogin(proceedingJoinPoint);
		if (isValidEntity) {
			try {
				Log.out.println("ABSAN112100100", runtimeLogInfoHelper.getRequestHeaderBean(), proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint
						.getSignature().getName(), proceedingJoinPoint.getSignature().getDeclaringTypeName() + ":" + proceedingJoinPoint.getSignature().getName());
				returnObject = proceedingJoinPoint.proceed();
				responseEntity = (ResponseEntity<ResponseBean>) returnObject;
				httpStatusCode = responseEntity.getStatusCode();
				Log.out.println("ABSAN112100100", runtimeLogInfoHelper.getRequestHeaderBean(), proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint
						.getSignature().getName(), proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName());
			} catch (InvalidDataException e) {
				AppAlarm appAlarm = Log.getAlarm("ABSAN154101400");
				ResponseBean exceptionbean = new ResponseBean(appAlarm);
				exceptionbean.add("message", appAlarm.getMessage());
				httpStatusCode = HttpStatus.valueOf(appAlarm.getAlarmStatus());
				Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), e, proceedingJoinPoint.getSignature().getDeclaringTypeName(),
						proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getSignature().getDeclaringTypeName() + ":"
								+ proceedingJoinPoint.getSignature().getName());
				return new ResponseEntity<ResponseBean>(exceptionbean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
			} catch (com.spartan.pluggable.exception.core.AppBaseException e) {
				AppAlarm appAlarm = Log.getAlarm(e.getAppAlarmId());
				ResponseBean exceptionbean = new ResponseBean(appAlarm);
				exceptionbean.add("message", appAlarm.getMessage());
				httpStatusCode = HttpStatus.valueOf(appAlarm.getAlarmStatus());
				return new ResponseEntity<ResponseBean>(exceptionbean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
			} catch (Exception e) {
				AppAlarm appAlarm = Log.getAlarm("ABSAN154101400");
				ResponseBean exceptionbean = new ResponseBean(appAlarm);
				exceptionbean.add("message", appAlarm.getMessage());
				httpStatusCode = HttpStatus.valueOf(appAlarm.getAlarmStatus());
				Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), e, proceedingJoinPoint.getSignature().getDeclaringTypeName(),
						proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getSignature().getDeclaringTypeName() + ":"
								+ proceedingJoinPoint.getSignature().getName());
				return new ResponseEntity<ResponseBean>(exceptionbean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
			}
		}
		return responseEntity;
	}

	/**
	 * Handle Update service in spartan package and set values to request after
	 * validating it .
	 * 
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("spartanUpdateServiceOperation()")
	@Order(2)
	public Object aroundAdvice2Update(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		boolean isValidEntity = true;
		Object returnObject = new Object();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		ResponseEntity<ResponseBean> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		aroundAdviceSaveAndUpdateLogin(proceedingJoinPoint);
		if (isValidEntity) {
			try {
				Log.out.println("ABSAN112100100", runtimeLogInfoHelper.getRequestHeaderBean(), proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint
						.getSignature().getName(), proceedingJoinPoint.getSignature().getDeclaringTypeName() + ":" + proceedingJoinPoint.getSignature().getName());
				returnObject = proceedingJoinPoint.proceed();
				responseEntity = (ResponseEntity<ResponseBean>) returnObject;
				httpStatusCode = responseEntity.getStatusCode();
				Log.out.println("ABSAN112100100", runtimeLogInfoHelper.getRequestHeaderBean(), proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint
						.getSignature().getName(), proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName());
			} catch (InvalidDataException e) {
				AppAlarm appAlarm = Log.getAlarm("ABSAN154101400");
				ResponseBean exceptionbean = new ResponseBean(appAlarm);
				exceptionbean.add("message", appAlarm.getMessage());
				httpStatusCode = HttpStatus.valueOf(appAlarm.getAlarmStatus());
				Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), e, proceedingJoinPoint.getSignature().getDeclaringTypeName(),
						proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getSignature().getDeclaringTypeName() + ":"
								+ proceedingJoinPoint.getSignature().getName());
				return new ResponseEntity<ResponseBean>(exceptionbean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
			} catch (com.spartan.pluggable.exception.core.AppBaseException e) {
				AppAlarm appAlarm = Log.getAlarm(e.getAppAlarmId());
				ResponseBean exceptionbean = new ResponseBean(appAlarm);
				exceptionbean.add("message", appAlarm.getMessage());
				httpStatusCode = HttpStatus.valueOf(appAlarm.getAlarmStatus());
				return new ResponseEntity<ResponseBean>(exceptionbean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
			} catch (Exception e) {
				AppAlarm appAlarm = Log.getAlarm("ABSAN154101400");
				ResponseBean exceptionbean = new ResponseBean(appAlarm);
				exceptionbean.add("message", appAlarm.getMessage());
				httpStatusCode = HttpStatus.valueOf(appAlarm.getAlarmStatus());
				Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), e, proceedingJoinPoint.getSignature().getDeclaringTypeName(),
						proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getSignature().getDeclaringTypeName() + ":"
								+ proceedingJoinPoint.getSignature().getName());
				return new ResponseEntity<ResponseBean>(exceptionbean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
			}
		}
		return responseEntity;
	}

	/**
	 * Handle Delete service in spartan package and set values to request after
	 * validating it .
	 * 
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("spartanDeleteServiceOperation()")
	@Order(2)
	public Object aroundAdvice2Delete(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object returnObject = new Object();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		ResponseEntity<ResponseBean> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			Log.out.println("ABSAN112100100", runtimeLogInfoHelper.getRequestHeaderBean(), proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint
					.getSignature().getName(), proceedingJoinPoint.getSignature().getDeclaringTypeName() + ":" + proceedingJoinPoint.getSignature().getName());
			returnObject = proceedingJoinPoint.proceed();
			responseEntity = (ResponseEntity<ResponseBean>) returnObject;
			httpStatusCode = responseEntity.getStatusCode();
			Log.out.println("ABSAN112100100", runtimeLogInfoHelper.getRequestHeaderBean(), proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint
					.getSignature().getName(), proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName());
		} catch (com.spartan.pluggable.exception.core.AppBaseException e) {
			AppAlarm appAlarm = Log.getAlarm(e.getAppAlarmId());
			ResponseBean exceptionbean = new ResponseBean(appAlarm);
			exceptionbean.add("message", appAlarm.getMessage());
			httpStatusCode = HttpStatus.valueOf(appAlarm.getAlarmStatus());
			return new ResponseEntity<ResponseBean>(exceptionbean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
		} catch (Exception e) {
			AppAlarm appAlarm = Log.getAlarm("ABSAN154101400");
			ResponseBean exceptionbean = new ResponseBean(appAlarm);
			exceptionbean.add("message", appAlarm.getMessage());
			httpStatusCode = HttpStatus.valueOf(appAlarm.getAlarmStatus());
			Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), e, proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint
					.getSignature().getName(), String.format(appAlarm.getMessage(), e.getMessage()), proceedingJoinPoint.getSignature().getDeclaringTypeName() + ":"
					+ proceedingJoinPoint.getSignature().getName());
			return new ResponseEntity<ResponseBean>(exceptionbean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
		}
		return returnObject;
	}

	/**
	 * Handle Fetch service in spartan package and set values to request after
	 * validating it .
	 * 
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("spartanFetchServiceOperation()")
	@Order(2)
	public Object aroundAdvicefindOperation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object returnObject = new Object();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		ResponseEntity<ResponseBean> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			Log.out.println("ABSAN112100100", runtimeLogInfoHelper.getRequestHeaderBean(), proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint
					.getSignature().getName(), proceedingJoinPoint.getSignature().getDeclaringTypeName() + ":" + proceedingJoinPoint.getSignature().getName());
			returnObject = proceedingJoinPoint.proceed();
			responseEntity = (ResponseEntity<ResponseBean>) returnObject;
			httpStatusCode = responseEntity.getStatusCode();
			Log.out.println("ABSAN112100100", runtimeLogInfoHelper.getRequestHeaderBean(), proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint
					.getSignature().getName(), proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName());
		} catch (com.spartan.pluggable.exception.core.AppBaseException e) {
			AppAlarm appAlarm = Log.getAlarm(e.getAppAlarmId());
			ResponseBean exceptionbean = new ResponseBean(appAlarm);
			exceptionbean.add("message", appAlarm.getMessage());
			httpStatusCode = HttpStatus.valueOf(appAlarm.getAlarmStatus());
			return new ResponseEntity<ResponseBean>(exceptionbean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
		} catch (Exception e) {
			AppAlarm appAlarm = Log.getAlarm("ABSAN154101400");
			ResponseBean exceptionbean = new ResponseBean(appAlarm);
			exceptionbean.add("message", appAlarm.getMessage());
			httpStatusCode = HttpStatus.valueOf(appAlarm.getAlarmStatus());
			Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), e, proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint
					.getSignature().getName(), proceedingJoinPoint.getSignature().getDeclaringTypeName() + ":" + proceedingJoinPoint.getSignature().getName());
			return new ResponseEntity<ResponseBean>(exceptionbean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
		}
		return returnObject;
	}

	@Pointcut("execution(* com.spartan.server..service..*(..))")
	protected void spartanServiceAllOperation() {
	}

	@Pointcut("execution(* com.spartan.server..service..save*(..))")
	protected void spartanSaveServiceOperation() {
	}

	@Pointcut("execution(* com.spartan.server..service..update*(..))")
	protected void spartanUpdateServiceOperation() {
	}

	@Pointcut("execution(* com.spartan.server..service..delete*(..))")
	protected void spartanDeleteServiceOperation() {
	}

	@Pointcut("execution(* com.spartan.server..service..find*(..)) || execution(* com.spartan.server..service..get*(..))")
	protected void spartanFetchServiceOperation() {
	}
}
