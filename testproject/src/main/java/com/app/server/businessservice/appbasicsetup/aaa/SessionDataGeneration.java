package com.app.server.businessservice.appbasicsetup.aaa;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.athena.server.pluggable.utils.HashAlgorithms;
import com.spartan.pluggable.auth.UserBean;
import com.spartan.pluggable.exception.auth.AccessDeniedException;
import com.spartan.server.authenticate.repository.AuthenticateRepository;
import com.spartan.server.interfaces.UserAuthentication;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionDataGeneration extends GenericSession {

	@Autowired
	private AuthenticateRepository authenticateRepository;

	@Autowired
	private CookieValidation cookieValidation;

	private UserBean userAttributes;

	private HttpServletRequest request;

	private HttpSession session;

	public UserBean getUserAttributes() {
		return userAttributes;
	}

	public void setUserAttributes(final UserBean userAttributes) {
		this.userAttributes = userAttributes;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(final HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public HttpSession getSession() {
		return session;
	}

	@Override
	public void setSession(final HttpSession session) {
		this.session = session;
	}

	// private String usidKey = "NOKEY";

	/**
	 * setting some required values in session
	 *
	 * @param session
	 * @param request
	 * @param userAttributes
	 */
	// public void setSessionData(HttpSession session) {
	//
	// int userSessionTimeout =
	// Integer.parseInt(userAttributes.get("sessionTimeout").toString());
	// String usidKey = "NOKEY";
	// usidKey = generateUsidKey(session.getId(),
	// userAttributes.get("loginId").toString(),
	// userAttributes.get("credentials").toString(), request);
	// session.setMaxInactiveInterval(userSessionTimeout);
	// setSession(session);
	// String userHash = generateUserHash(usidKey);
	// saveUserDataToSession(session, userHash, userAttributes, usidKey);
	// // setSessionAttributes(session, "userId",
	// attributes.get("userId"));//ALGO0001-Delete
	// setSessionUserId(userAttributes.get("userId")); //ALGO0001-Insert
	//
	// }

	public void setSession() {
		super.setSession(session);
	}

	public void setSessionClientIp() {
		super.setSessionClientIp(request.getRemoteHost());
	}

	public void setSessionClientPort() {
		super.setSessionClientPort(request.getRemotePort());
	}

	public void setSessionLoginId() {
		super.setSessionLoginId(userAttributes.getUserPropertyByKey(Attributes.LOGIN_ID.getName()).getValue());
	}

	public void setSessionUserId() {
		super.setSessionUserId(userAttributes.getUserPropertyByKey(Attributes.USER_ID.getName()).getValue());
	}

	public void setSessionTimeZone() {
		super.setSessionTimeZone(userAttributes.getUserPropertyByKey(Attributes.TIME_ZONE.getName()).getValue());
	}

	public void setSessionTimeZoneId() {
		super.setSessionTimeZoneId(userAttributes.getUserPropertyByKey(Attributes.TIME_ZONE_ID.getName()).getValue());
	}

	public void setSessionTimeout() {
		super.setSessionTimeout(userAttributes.getUserPropertyByKey(Attributes.SESSION_TIME_OUT.getName()).getValue());
	}

	public void setSessionContactId() {
		super.setSessionContactId(userAttributes.getUserPropertyByKey(Attributes.CONTACT_ID.getName()).getValue());
	}

	public void setSessionUserAccessCode() {
		super.setSessionUserAccessCode(userAttributes.getUserPropertyByKey(Attributes.USER_ACCESS_CODE.getName()).getValue());
	}

	public void setSessionQKeHash() {
		String usidKey = "NOKEY";
		usidKey = generateUsidKey(session.getId(), userAttributes.getUserPropertyByKey("loginId").getValue(), userAttributes.getUserPropertyByKey("credentials").getValue(),
				request);
		super.setSessionQKeHash(generateQKeHash(userAttributes.getUserPropertyByKey("credentials").getValue(), usidKey));
	}

	private String generatePasswordHash(final String userCredentials) {
		/** Store User specific info into session */

		String pswdHash = "";
		try {
			pswdHash = HashAlgorithms.getInstance().computeHash(userCredentials, 1);
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return pswdHash;
	}

	public String generateUsidKey(final String sessionId, final String loginId, final String userCredentials, final HttpServletRequest request) {
		final Date date = new Date();
		final StringBuilder sb = new StringBuilder();
		sb.append(sessionId).append("|");
		sb.append(loginId).append("|");
		sb.append(request.getRemoteHost()).append("|");
		sb.append(request.getRemotePort()).append("|");
		sb.append(date.getTime()).append("|");
		sb.append(generatePasswordHash(userCredentials)).append("|");
		return sb.toString();// Plain User Session ID
	}

	public String generateUserHash(final String usidKey) {

		String userHash = "";
		try {
			userHash = HashAlgorithms.getInstance().computeHash(usidKey, HashAlgorithms.SHA_256);
		} catch (final Exception e) {
			e.printStackTrace();
		}

		return userHash;
	}

	/**
	 * Return QKeHash from session inputs
	 *
	 * @return
	 */
	public String generateQKeHash(final String userCredentials, final String usidKey) {
		// Create Unique Application Session ID for the Cookie
		String qKeyHash = "";
		// Create the Session IDs (User and Cookie) after the successful
		// validation.
		String qKe = "";

		try {
			// pswdHash =
			// HashAlgorithms.getInstance().computeHash(userCredentials, 1);

			qKe = usidKey;// Plain Cookie Session ID

			try {
				qKeyHash = HashAlgorithms.getInstance().computeHash(qKe, HashAlgorithms.SHA_256);
			} catch (final Exception e2) {
				e2.printStackTrace();
				throw new AccessDeniedException("Unable to compute Cookie Session ID QKe using Key 2", "ABSAA154900400", new AccessDeniedException());
			}

		} catch (final Exception ignored) {
			ignored.printStackTrace();
		}

		return qKeyHash;
	}

	public void saveUserDataToSession(final HttpSession session, final UserBean attributes) {
		setSessionAttribute(Attributes.USID_HASH.getName(), session.getAttribute("qKeHash").toString());

			setSessionAttribute(
					session.getAttribute("qKeHash").toString(),
					"{\"userDetail\":{\"userId\":\"18D01ABF-F632-496A-B379-FC50EDEAB8C0\",\"firstName\":\"System Administrator\",\"loginId\":\"admin\",\"timezone\":\"Asia/Kolkata\",\"timezoneId\":\"IST\",\"sessionTimeout\":1800}}");

	}



	/**
	 * setting cookies in response object
	 *
	 * @param userBean
	 * @param session
	 * @param request
	 * @param response
	 */
	public void setCookieInSession(final UserBean userBean, final HttpSession session, final HttpServletRequest request, final HttpServletResponse response) {

		final Cookie cookie = cookieValidation.getSessionCookies(session, request, userBean, session.getAttribute("qKeHash").toString(), false);
		response.addCookie(cookie);
		final Cookie timeZoneCookie = cookieValidation.setTimeZoneCookie(session, request, userBean, false);
		response.addCookie(timeZoneCookie);
	}



}
