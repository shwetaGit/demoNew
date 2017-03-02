package com.app.server.businessservice.appbasicsetup.aaa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.spartan.pluggable.auth.AuthStatusBean;
import com.spartan.pluggable.auth.PluggableAuthConnector;

public abstract class UserAuthBusinessService implements PluggableAuthConnector {
	/**
	 * @return current session of logged in user
	 */
	protected HttpSession getSession() {
		final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		final HttpSession session = request.getSession();
		return session;
	}

	/**
	 * Terminate the User Session
	 *
	 * @return
	 */
	@Override
	public AuthStatusBean terminateSession() {
		final AuthStatusBean isSessionTerminated = new AuthStatusBean();
		final HttpSession session = getSession();
		session.invalidate();
		isSessionTerminated.setAuthStatus(true);
		return isSessionTerminated;
	}

}
