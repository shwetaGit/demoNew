package com.app.server.service.sessionmgt;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.athena.server.pluggable.utils.helper.JSONObjectMapperHelper;
import com.spartan.server.session.bizService.SessionDataMgtService;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionDataMgtWithoutDBServiceImpl implements SessionDataMgtService {

	@Override
	public void setSessionAttributeForNumber(final String key, final Number value) {
		final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		final HttpSession session = request.getSession();
		session.setAttribute(key, value);
	}

	@Override
	public void setSessionAttributeForString(final String key, final String value) {
		final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		final HttpSession session = request.getSession();
		session.setAttribute(key, value);
	}

	@Override
	public void setSessionAttributeForBoolean(final String key, final Boolean value) {
		final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		final HttpSession session = request.getSession();
		session.setAttribute(key, value);
	}

	@Override
	public void setSessionAttributeForDateTime(final String key, final Timestamp value) {
		final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		final HttpSession session = request.getSession();
		session.setAttribute(key, value);
	}

	@Override
	public void setSessionAttributeForObject(final String key, final Object value) {
		final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		final HttpSession session = request.getSession();
		String jsonValue;
		try {
			jsonValue = new JSONObjectMapperHelper().toJsonString(value);
			session.setAttribute(key, jsonValue);
		} catch (final IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void removeSessionAttribute(final String key) {
		final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		final HttpSession session = request.getSession();
		session.removeAttribute(key);

	}

	@Override
	public void removeSessionAllAttributes() {
		final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		final HttpSession session = request.getSession();

		final Enumeration<String> sessionNamesEnumeration = session.getAttributeNames();

		while (sessionNamesEnumeration.hasMoreElements()) {
			session.removeAttribute(sessionNamesEnumeration.nextElement());
		}
	}

	@Override
	public Object getSessionData(final String key) {
		final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		final HttpSession session = request.getSession();
		if (session.getAttribute(key) != null) {
			return session.getAttribute(key);
		}
		return null;

	}

	@Override
	public <T> Object getSessionDataForObject(final String key, final Class clazz) {
		final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		final HttpSession session = request.getSession();
		try {
			if (session.getAttribute(key) != null) {
				return new JSONObjectMapperHelper().fromJSON(session.getAttribute(key).toString(), clazz);

			}

		} catch (final Exception e) {
		}
		return null;
	}

	@Override
	public void getAllSessionAttributes(final String appSessionId) throws Exception {
		final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		request.getSession();
	}

	@Override
	public void setSessionAttribute(final String key, final Object value) {
		if (value instanceof Number) {
			setSessionAttributeForNumber(key, (Number) value);
		} else if (value instanceof String) {
			setSessionAttributeForString(key, (String) value);
		} else if (value instanceof Boolean) {
			setSessionAttributeForBoolean(key, (Boolean) value);
		} else if (value instanceof Timestamp) {
			setSessionAttributeForDateTime(key, (Timestamp) value);
		} else {
			setSessionAttributeForObject(key, value);
		}
	}
}
