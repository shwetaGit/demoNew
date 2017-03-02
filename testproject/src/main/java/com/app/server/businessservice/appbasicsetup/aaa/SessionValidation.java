package com.app.server.businessservice.appbasicsetup.aaa;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import com.spartan.pluggable.exception.auth.AccessDeniedException;
import com.spartan.pluggable.exception.auth.SessionTimeOutException;
import com.spartan.pluggable.exception.core.BaseSecurityException;
import com.spartan.server.interfaces.UserAuthentication;
import com.spartan.server.session.bizService.SessionDataMgtService;

/**
 * Validate session against each request. Its checked user exists in session, as
 * well as valid cookies are sent with request object else @Throws
 * BaseSecurityException * session attributes : usidHash : SHA_256 of (Concat of
 * session_id | login_id | remote_host | report_port | date_time |
 * encrypted_password) qKeHash : SHA_256 of (Concat of session_id | login_id |
 * remote_host | report_port | date_time | encrypted_password) SHA_256 of
 * (Concat of session_id | login_id | remote_host | report_port | date_time |
 * encrypted_password) : User obj ref clientIp : client ip clientHost : client
 * host loginId : loginId
 * **/
@Component
public class SessionValidation {

	@Autowired
	private CookieValidation cookieValidation;

	@Autowired
	private SessionDataMgtService sessionDataService;

	public SessionValidation() {
		super();
	}

	@Autowired
	private UrlPatternDefinitions urlPatterns;

	/**
	 * Validating session for current request
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @throws BaseSecurityException
	 */
	public void validateSession(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws BaseSecurityException {

		{

			Object usidHash = session.getAttribute("usidHash");

			if (usidHash == null) {

				validateSessionTimeout(session, request, response);
			}
			Object user = getUser(session);
			if (user == null) {
				System.err.println("Invalid Client request. (Need Authentication!)");
				throw new AccessDeniedException("Invalid Client request. (Need Authentication!)", "ABSAA154900400", new AccessDeniedException());
			}

			/* validates Ip address attack */
			validateIPAddress(session, request);

		}
	}

	private void validateSessionTimeout(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SessionTimeOutException {

		final int sessionTimeOut = (int) session.getAttribute("sessionTimeout");
		Timestamp lastAccessTime = (Timestamp) session.getAttribute("lastAccessTime");
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		if (lastAccessTime != null) {
			if (currentTime.getTime() - lastAccessTime.getTime() < (sessionTimeOut * 1000)) {

				session.setAttribute("CookieTokenName", "XA_ID");
			}
		} else {
			throw new SessionTimeOutException("Session expired", "ABSAA254905401", new SessionTimeOutException());
		}
	}

	/**
	 * Validating requested url
	 * 
	 * @param request
	 * @return
	 */
	public boolean checkIgnoreURL(HttpServletRequest request) {
		AntPathRequestMatcher requestMatcher;
		boolean ignoreThisURL = false;
		String[] ignoreURLS = urlPatterns.getRequestFilterIgnoreUrlPatterns();
		if (ignoreURLS != null && ignoreURLS.length > 0) {

			for (byte i = 0; i < ignoreURLS.length; i++) {
				requestMatcher = new AntPathRequestMatcher(ignoreURLS[i]);
				boolean matched = requestMatcher.matches(request);
				if (matched) {
					ignoreThisURL = true;
					break;
				}
			}
		}
		return ignoreThisURL;
	}

	private boolean validateIPAddress(final HttpSession mapSession, final HttpServletRequest request) throws AccessDeniedException {
		if (request.getRemoteHost().equalsIgnoreCase(getAuthClientIP(mapSession))) {
			return true;
		}
		System.err.println("Invalid IP Address. Possible Session Attack from IP Address = " + request.getRemoteHost());
		throw new AccessDeniedException("Invalid IP Address. Possible Session Attack from IP Address = " + request.getRemoteHost(), "ABSAA154900400", new AccessDeniedException());
	}

	private final String getAuthClientIP(final HttpSession mapSession) throws AccessDeniedException {
		return (String) mapSession.getAttribute("clientIP");
	}

	private final Object getUser(final HttpSession mapSession) throws SessionTimeOutException {
		String usidHash = getSessionID(mapSession);
		if (usidHash != null) {
			return mapSession.getAttribute(usidHash);
		} else {
			System.err.println("Your session is expired.");
			throw new SessionTimeOutException("Your session is expired.", "ABSAA254905401", new SessionTimeOutException());
		}
	}

	private final String getSessionID(final HttpSession mapSession) {
		return (String) mapSession.getAttribute("usidHash");
	}

	private void setSessionDetails(HttpServletRequest request, HttpSession session, UserAuthentication user) {

		int userSessionTimeout = user.getSessionTimeout();
		session.setMaxInactiveInterval(userSessionTimeout);
		session.setAttribute("clientIP", request.getRemoteHost());
		session.setAttribute("clientPort", request.getRemotePort());

	}

	/**
	 * @param request
	 * @param session
	 * @param user
	 */
	public void setUserSessionData(HttpServletRequest request, HttpSession session, UserAuthentication user) {
	}
}
