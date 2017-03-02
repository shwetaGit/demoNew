package com.app.server.businessservice.appbasicsetup.aaa;

import javax.servlet.http.HttpSession;

public abstract class GenericSession {

	private HttpSession session;

	public HttpSession getSession() {
		return session;
	}

	public void setSession(final HttpSession session) {
		this.session = session;
	}

	public HttpSession setSessionAttribute(final String key, final Object value) {
		session.setAttribute(key, value);

		return session;

	}

	public HttpSession setSessionClientIp(final Object value) {
		session.setAttribute(Attributes.CLIENT_IP.getName(), value);
		return session;
	}

	public HttpSession setSessionClientPort(final Object value) {
		session.setAttribute(Attributes.CLIENT_PORT.getName(), value);
		return session;
	}

	public HttpSession setSessionLoginId(final Object value) {
		session.setAttribute(Attributes.LOGIN_ID.getName(), value);
		return session;
	}

	public HttpSession setSessionUserId(final Object value) {
		session.setAttribute(Attributes.USER_ID.getName(), value);
		return session;
	}

	public HttpSession setSessionTimeZone(final Object value) {
		session.setAttribute(Attributes.TIME_ZONE.getName(), value);
		return session;
	}

	public HttpSession setSessionTimeZoneId(final Object value) {
		session.setAttribute(Attributes.TIME_ZONE_ID.getName(), value);
		return session;
	}

	public HttpSession setSessionTimeout(final Object value) {
		session.setAttribute(Attributes.SESSION_TIME_OUT.getName(), value);
		return session;
	}

	public HttpSession setSessionContactId(final Object value) {
		session.setAttribute(Attributes.CONTACT_ID.getName(), value);
		return session;
	}

	public HttpSession setSessionUserAccessCode(final Object value) {
		session.setAttribute(Attributes.USER_ACCESS_CODE.getName(), value);
		return session;
	}

	public HttpSession setSessionQKeHash(final Object value) {
		session.setAttribute(Attributes.QKE_HASH.getName(), value);
		return session;
	}

	public HttpSession setSessionUsidHash(final Object value) {
		session.setAttribute(Attributes.USID_HASH.getName(), value);
		return session;
	}

}
