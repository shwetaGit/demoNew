package com.app.server.businessservice.appbasicsetup.aaa;
import com.app.server.businessservice.appbasicsetup.aaa.Attributes;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.athena.server.pluggable.utils.HashAlgorithms;
import com.spartan.pluggable.auth.UserBean;
import com.spartan.pluggable.exception.auth.AccessDeniedException;


@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CookieGeneration {

	final boolean isSecure = false;
	private final String usidKey = "NOKEY";


	private Cookie getSessionCookies(final UserBean userBean, final boolean isSecure) {
		Cookie cookie = null;
		try {
			final int age = Integer.parseInt(userBean.getUserPropertyByKey("sessionTimeout").getValue());
			getSession().setAttribute("CookieTokenName", "XA_ID");
			cookie = createCookie("XA_ID", prepareCookieValue(), age, isSecure);

		} catch (final Exception e) {
			e.printStackTrace();
		}
		return cookie;
	}

	private Cookie createCookie(final String cookieID, final String cookieValue, final int age, final boolean isSecure) {

		final Cookie cookie = new Cookie(cookieID, cookieValue);
		if (isSecure) {
			cookie.setSecure(true);
			cookie.setHttpOnly(true);
		}
		cookie.setPath(getRequest().getContextPath());
		cookie.setMaxAge(age * 100);

		return cookie;

	}

	private String prepareCookieValue() throws AccessDeniedException {
		String cookieValue = null;
		cookieValue = generateQKeHash();
		return cookieValue;
	}

	private Cookie setTimeZoneCookie(final UserBean userBean, final boolean isSecure) {
		Cookie cookie = null;
		try {

			final int age = Integer.parseInt(userBean.getUserPropertyByKey("sessionTimeout").getValue());

			cookie = createCookie("XA_TID", userBean.getUserPropertyByKey("timeZoneId").getValue(), age, isSecure);

		} catch (final Exception e) {
			e.printStackTrace();
		}
		return cookie;
	}

	public Cookie getCookie(final String COOKIE_ID, final UserBean userBean, final boolean isSecure) {

		Cookie cookie = null;
		switch (COOKIE_ID) {
		case "XA_ID":
			cookie = getSessionCookies(userBean, isSecure);
			break;
		case "XA_TID":
			cookie = setTimeZoneCookie(userBean, isSecure);
			break;
		}
		return cookie;

	}

	private HttpSession getSession() {
		final HttpSession session = getRequest().getSession();
		return session;
	}

	private HttpServletRequest getRequest() {

		final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return request;

	}

	public String generateQKeHash() throws AccessDeniedException {
		// Create Unique Application Session ID for the Cookie
		String qKeyHash = "";
//		Need to check Corner issues 
		HttpSession session = getSession();

		try {
			qKeyHash = (String) session.getAttribute(Attributes.USID_HASH.getName().toString()); // Plain.
			// Cookie
			// Session
			// ID
		} catch (final Exception e2) {
			e2.printStackTrace();
			throw new AccessDeniedException("Unable to compute Cookie Session ID QKe using Key 2", "ABSAA154900400",
					new AccessDeniedException());
		}

		return qKeyHash;
	}
}
