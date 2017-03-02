package com.app.server.businessservice.appbasicsetup.aaa;
import com.app.config.TokenClaimBean;

import java.sql.Timestamp;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import atg.taglib.json.util.JSONException;
import atg.taglib.json.util.JSONObject;

import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.spartan.pluggable.auth.LoginCredentials;
import com.spartan.pluggable.auth.PluggableAuthConnector;
import com.spartan.pluggable.auth.TokenCredential;
import com.spartan.pluggable.auth.UserBean;
import com.spartan.pluggable.exception.auth.AccessDeniedException;
import com.spartan.pluggable.exception.auth.AccountExpired;
import com.spartan.pluggable.exception.auth.InvalidLoginIdException;
import com.spartan.pluggable.exception.auth.PasswordExpiredException;
import com.spartan.pluggable.logger.alarms.AppAlarm;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.spartan.server.interfaces.TokenInitializerInterface;

@Service
public class CustomAuthenticateBusinessServiceImpl implements AuthenticateBusinessService {

	@Autowired
	TokenInitializerInterface tokenGenerator;

	@Autowired
	TokenClaimBean clainBeanInterface;

	@Autowired
	private RuntimeLogInfoHelper runtimeLogInfoHelper;

	@Autowired
	private PluggableAuthConnector userAuthenticator;

	@Autowired
	private SessionDataGeneration sessionDataGeneration;

	@Autowired
	private CookieValidation cookieValidation;

	@Autowired
	private CookieGeneration cookieGeneration;

	private final LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

	/**
	 * Authenticate the user and Return Response object
	 *
	 * @param loginBean
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@Override
	public HttpEntity<ResponseBean> authenticate(@RequestBody final LoginCredentials loginBean, final HttpServletRequest request, final HttpServletResponse response,
			final HttpSession session) {

		final ResponseBean responseBean = new ResponseBean();
		final boolean success = true;
		String message = "";
		UserBean userBean = null;
		AppAlarm appAlarm = null;
		try {

			boolean isUserAthenticated = false;

			isUserAthenticated = userAuthenticator.authenticate(loginBean).isAuthStatus();
			if (isUserAthenticated) {
				userBean = userAuthenticator.getAuthenticatedUser(loginBean.getLoginId());

			}

			/** UP TO THIS POINT */
			if (userBean != null) {
				setUserData(userBean, request, response, session);
				message = "Authentication success";

			} else {
				throw new InvalidLoginIdException("Invalid Login Id or Password", "ABSAA254901401", null);
			}

			/* ADDING AUTHENTICATED USER DETAILS IN RESPONSE */
			final JSONObject userInfo = new JSONObject();
			saveUserInfo(userBean, userInfo);

			session.setAttribute("lastAccessTime", new Timestamp(System.currentTimeMillis()));

			/****
			 * Generating Token using jwt
			 */

			final String token = getToken();

			appAlarm = Log.getAlarm("ABSAA124900200");
			responseBean.addAlarm(appAlarm);
			responseBean.add("success", success);
			responseBean.add("message", message);
			responseBean.add("token", token);
			responseBean.add("userinfo", userInfo.toString());
			Log.out.println("ABSAA124900200", runtimeLogInfoHelper.getRequestHeaderBean(), "authenticate", loginBean.getLoginId());

		} catch (final InvalidLoginIdException e) {
			e.printStackTrace();
			appAlarm = Log.getAlarm(e.getAppAlarmId());
			final ResponseBean exceptionbean = new ResponseBean(appAlarm);
			exceptionbean.add("message", String.format(appAlarm.getMessage(), e.getMessage()));
			Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), "authenticate", loginBean.getLoginId(), "Invald loginId and Password");

		} catch (final AccountExpired e1) {
			e1.printStackTrace();
			appAlarm = Log.getAlarm("ABSAA254901401");
			final ResponseBean exceptionbean = new ResponseBean(appAlarm);
			exceptionbean.add("message", appAlarm.getMessage());
			Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), "authenticate", loginBean.getLoginId(), "Your Account is Expired");

		} catch (final PasswordExpiredException e2) {
			e2.printStackTrace();
			appAlarm = Log.getAlarm("ABSUM343953403");
			final ResponseBean exceptionbean = new ResponseBean(appAlarm);
			exceptionbean.add("message", appAlarm.getMessage());
			Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), "authenticate", loginBean.getLoginId(), "User details not found");

		} catch (final com.spartan.pluggable.exception.auth.AccountLockedException e3) {
			e3.printStackTrace();
			appAlarm = Log.getAlarm(e3.getAppAlarmId());
			final ResponseBean exceptionbean = new ResponseBean(appAlarm);
			exceptionbean.add("message", appAlarm.getMessage());
			Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), "authenticate", loginBean.getLoginId(),
					String.format(appAlarm.getMessage(), e3.getMessage()));
		} catch (final Exception e4) {
			e4.printStackTrace();
			appAlarm = Log.getAlarm("ABSAA154900400");
			final ResponseBean exceptionbean = new ResponseBean(appAlarm);
			exceptionbean.add("message", " Error in creating entity" + e4.getMessage());
			Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), "authenticate", loginBean.getLoginId(), e4);

		}
		return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));

	}

	/**
	 * Re-authenticate the user and Return Response object
	 *
	 * @param tokenBean
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@Override
	public HttpEntity<ResponseBean> reauthenticate(@RequestBody final TokenCredential tokenBean, final HttpServletRequest request, final HttpServletResponse response,
			final HttpSession session) {
		final ResponseBean responseBean = new ResponseBean();
		TokenCredential tockenCredential = null;
		final boolean success = true;
		String message = "";
		UserBean userBean = null;
		AppAlarm appAlarm = null;

		try {
			final Cookie[] cookies = request.getCookies();
			String sessionId = null;
			/** Checks the null value for cookies **/
			if (null != cookies) {
				/** Iteration for cookies presence **/
				for (final Cookie cookie : cookies) {
					if (cookie.getName().contains("XA_ID")) {
						sessionId = cookie.getValue();
					}
				}
			}

			boolean isUserAthenticated = false;

			if (sessionId != null && !sessionId.isEmpty()) {
				tockenCredential = new TokenCredential(tokenBean.getPassword(), sessionId,tokenBean.getLoginId());
			}

			isUserAthenticated = userAuthenticator.reAuthenticate(tockenCredential).isAuthStatus();

			if (isUserAthenticated) {
				userBean = userAuthenticator.getAuthenticatedUser(tokenBean.getLoginId());
			}

			if (userBean != null) {
				setUserData(userBean, request, response, session);
				message = "Reauthentication success";
			} else {
				throw new InvalidLoginIdException("Invalid Login Id or Password", "ABSAA254901401", null);

			}
			/** ADDING AUTHENTICATED USER DETAILS IN RESPONSE **/
			final JSONObject userInfo = new JSONObject();
			saveUserInfo(userBean, userInfo);

			appAlarm = Log.getAlarm("ABSAA124900200");
			responseBean.addAlarm(appAlarm);
			responseBean.add("success", success);
			responseBean.add("message", message);
			responseBean.add("userinfo", userInfo.toString());

			Log.out.println("ABSAA124900200", runtimeLogInfoHelper.getRequestHeaderBean(), "reauthenticate", session.getAttribute("loginId").toString());

		} catch (final InvalidLoginIdException e) {
			e.printStackTrace();
			appAlarm = Log.getAlarm(e.getAppAlarmId());
			final ResponseBean exceptionbean = new ResponseBean(appAlarm);
			exceptionbean.add("message", String.format(appAlarm.getMessage(), e.getMessage()));
			Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), "reauthenticate", String.format(appAlarm.getMessage(), e.getMessage()));

		} catch (final AccountExpired e1) {
			e1.printStackTrace();
			appAlarm = Log.getAlarm("ABSAA254901401");
			final ResponseBean exceptionbean = new ResponseBean(appAlarm);
			exceptionbean.add("message", appAlarm.getMessage());
			Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), "reauthenticate", String.format(appAlarm.getMessage(), e1.getMessage()));

		} catch (final PasswordExpiredException e2) {
			e2.printStackTrace();
			appAlarm = Log.getAlarm("ABSUM343953403");
			final ResponseBean exceptionbean = new ResponseBean(appAlarm);
			exceptionbean.add("message", appAlarm.getMessage());
			Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), "reauthenticate", String.format(appAlarm.getMessage(), e2.getMessage()));

		} catch (final com.spartan.pluggable.exception.auth.AccountLockedException e3) {
			e3.printStackTrace();
			appAlarm = Log.getAlarm(e3.getAppAlarmId());
			final ResponseBean exceptionbean = new ResponseBean(appAlarm);
			exceptionbean.add("message", appAlarm.getMessage());
			Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), "reauthenticate", String.format(appAlarm.getMessage(), e3.getMessage()));

		} catch (final Exception e4) {
			e4.printStackTrace();
			appAlarm = Log.getAlarm("ABSAA154900400");
			final ResponseBean exceptionbean = new ResponseBean(appAlarm);
			exceptionbean.add("message", " Error in creating entity" + e4.getMessage());
			Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), "reauthenticate", String.format(appAlarm.getMessage(), e4.getMessage()));
		}
		return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));

	}

	 @Override
		public HttpEntity<ResponseBean> checkLoginStatus(final HttpServletRequest request, final HttpServletResponse response, final HttpSession session) {

			final ResponseBean responseBean = new ResponseBean();
			org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.OK;

			try {
				final Timestamp currentTime = new Timestamp(System.currentTimeMillis());
				final int sessionTimeOut = (int) session.getAttribute("sessionTimeout");

				if ((currentTime.getTime() - (long) session.getAttribute("lastAccessTime")) < (sessionTimeOut * 1000)) {
					responseBean.add("success", true);
					responseBean.add("message", "Already logged in");
				} else {
					httpStatus = org.springframework.http.HttpStatus.BAD_REQUEST;
					responseBean.add("success", false);
					responseBean.add("message", " Error " + new AccessDeniedException("Session expired", "APSAN154101401", new AccessDeniedException()).getMessage());
				}
			} catch (final Exception e) {
				System.out.println("session has no attribute as sessionTimeout or last AccessTime.");
			}
			return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, httpStatus);
		}

	private void saveDataInSession(final UserBean userBean, final HttpSession session, final HttpServletRequest request, final HttpServletResponse response) throws Exception {

		sessionDataGeneration.setRequest(request);
		sessionDataGeneration.setSession(session);
		sessionDataGeneration.setUserAttributes(userBean);

		final int userSessionTimeout = Integer.parseInt(userBean.getUserPropertyByKey("sessionTimeout").getValue());
		session.setMaxInactiveInterval(userSessionTimeout);
		sessionDataGeneration.setSession();
		sessionDataGeneration.setSessionClientIp();
		sessionDataGeneration.setSessionClientPort();
		sessionDataGeneration.setSessionLoginId();
		sessionDataGeneration.setSessionLoginId();
		sessionDataGeneration.setSessionUserId();
		sessionDataGeneration.setSessionTimeZone();
		sessionDataGeneration.setSessionTimeZoneId();
		sessionDataGeneration.setSessionTimeout();
		sessionDataGeneration.setSessionContactId();
		sessionDataGeneration.setSessionUserAccessCode();
		sessionDataGeneration.setSessionQKeHash();
		sessionDataGeneration.saveUserDataToSession(session, userBean);
		sessionDataGeneration.setSessionUserId();

	}

	private void setCookieInSession(final UserBean userBean, final HttpServletResponse response) {

		final Cookie sessionCookie = cookieGeneration.getCookie("XA_ID", userBean, false);
		response.addCookie(sessionCookie);
		final Cookie timeZoneCookie = cookieGeneration.getCookie("XA_TID", userBean, false);
		response.addCookie(timeZoneCookie);
	}

	/**
	 * Saving data in user Json object
	 *
	 * @param userBean
	 * @param userInfo
	 * @throws JSONException
	 */
	private void saveUserInfo(final UserBean userBean, final JSONObject userInfo) throws JSONException {
		userInfo.put("firstName", userBean.getUserPropertyByKey("firstName").getValue());
		userInfo.put("middleName", userBean.getUserPropertyByKey("middleName").getValue());
		userInfo.put("lastName", userBean.getUserPropertyByKey("lastName").getValue());
		userInfo.put("emailId", userBean.getUserPropertyByKey("emailId").getValue());
		userInfo.put("phoneNumber", userBean.getUserPropertyByKey("phoneNumber").getValue());
		userInfo.put("loginId", userBean.getUserPropertyByKey("loginId").getValue());

		userInfo.put("XA_TID", userBean.getUserPropertyByKey("timeZoneId").getValue());
	}

	private String getToken() {
		clainBeanInterface.prepareSecurityPolicy();
		clainBeanInterface.prepareClaimAttribute();
		clainBeanInterface.setAudience();
		clainBeanInterface.setSubject();
		clainBeanInterface.setIssuedAt();
		clainBeanInterface.setExpirationDate();
		return tokenGenerator.getToken(clainBeanInterface);

	}

	private void setUserData(final UserBean userBean, final HttpServletRequest request, final HttpServletResponse response, final HttpSession session) throws Exception {
		saveDataInSession(userBean, session, request, response); // Set Session

		setCookieInSession(userBean, response);// Set Cookie

		// data in
		// session

	}

}
