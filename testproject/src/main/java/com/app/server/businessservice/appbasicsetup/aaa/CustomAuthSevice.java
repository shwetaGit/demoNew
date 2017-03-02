package com.app.server.businessservice.appbasicsetup.aaa;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spartan.pluggable.auth.AuthStatusBean;
import com.spartan.pluggable.auth.LoginCredentials;
import com.spartan.pluggable.auth.PropertiesBean;
import com.spartan.pluggable.auth.TokenCredential;
import com.spartan.pluggable.auth.UserBean;
import com.spartan.pluggable.exception.auth.InvalidLoginIdException;
import com.spartan.pluggable.exception.core.BaseSecurityException;

@Component
public class CustomAuthSevice extends UserAuthBusinessService {

	@Override
	public AuthStatusBean authenticate(final LoginCredentials loginBean) throws BaseSecurityException {
		final AuthStatusBean isAuthenticate = new AuthStatusBean();
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final LoginDemo[] loginDemoList = mapper.readValue(new File(getJSONFileLoc() + File.separator + "Login.json"), LoginDemo[].class);
			for (final LoginDemo loginDemo : loginDemoList) {
				if (loginBean.getLoginId().equals(loginDemo.getLoginId()) && loginBean.getPassword().equals(loginDemo.getPassword())) {
					isAuthenticate.setAuthStatus(true);
					break;

				}
			}
		} catch (final Exception e) {
			throw new InvalidLoginIdException("Invalid Login Id or Password", "ABSAA254901401", null);
		}
		return isAuthenticate;
	}

	@Override
	public UserBean getAuthenticatedUser(final String loginId) throws BaseSecurityException {
		UserBean userBean = new UserBean();
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final UserDemo[] userDemoList = mapper.readValue(new File(getJSONFileLoc() + File.separator + "User.json"), UserDemo[].class);
			for (final UserDemo userDemo : userDemoList) {
				if (loginId.equals(userDemo.getLoginId())) {
					userBean = getUserBean(userDemo, "Algo@2015");
					break;
				}
			}
		} catch (final Exception e) {
			throw new InvalidLoginIdException("Invalid Login Id or Password", "ABSAA254901401", null);
		}
		return userBean;
	}

	@Override
	public AuthStatusBean logout() {
		final AuthStatusBean a = new AuthStatusBean();
		a.setAuthStatus(true);
		return a;
	}

	@Override
	public AuthStatusBean reAuthenticate(final TokenCredential tokanBean) throws BaseSecurityException {
		final AuthStatusBean isReAuthenticate = new AuthStatusBean();
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final LoginDemo[] loginDemoList = mapper.readValue(new File(getJSONFileLoc() + File.separator + "Login.json"), LoginDemo[].class);
			for (final LoginDemo loginDemo : loginDemoList) {
				if (tokanBean.getLoginId().equals(loginDemo.getLoginId()) && tokanBean.getPassword().equals(loginDemo.getPassword())) {
					isReAuthenticate.setAuthStatus(true);
					break;
				}
			}
		} catch (final Exception e) {
			throw new InvalidLoginIdException("Invalid Login Id or Password", "ABSAA254901401", null);
		}
		return isReAuthenticate;
	}

	private UserBean getUserBean(final UserDemo userDemo, final String credential) {
		final UserBean userBean = new UserBean();
		userBean.setLoginID(userDemo.getLoginId());
		// need to discuss
		// userBean.setAthenticated(true);
		userBean.setLocked(false);
		final List<PropertiesBean> propertiesList = new ArrayList<PropertiesBean>();
		propertiesList.add(new PropertiesBean("loginId", userDemo.getLoginId()));
		propertiesList.add(new PropertiesBean("userId", userDemo.getUserId()));

		propertiesList.add(new PropertiesBean("timeZone", userDemo.getTimezone()));

		propertiesList.add(new PropertiesBean("timeZoneId", userDemo.getTimezoneId()));

		propertiesList.add(new PropertiesBean("sessionTimeout", userDemo.getSessionTimeout() + ""));
		propertiesList.add(new PropertiesBean("credentials", credential));

		propertiesList.add(new PropertiesBean("contactId", "ABCD"));
		propertiesList.add(new PropertiesBean("userAccessCode", "55000"));
		propertiesList.add(new PropertiesBean("firstName", (userDemo.getFirstName() == null ? "-" : userDemo.getFirstName())));
		propertiesList.add(new PropertiesBean("middleName", "_"));
		propertiesList.add(new PropertiesBean("lastName", "_"));
		propertiesList.add(new PropertiesBean("emailId", "abc@def.xyz"));
		propertiesList.add(new PropertiesBean("phoneNumber", "123232323"));

		userBean.setProperties(propertiesList);
		return userBean;
	}

	private String getJSONFileLoc() throws MalformedURLException {
		final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		final ServletContext context = request.getServletContext();
		final String filePath = context.getRealPath("/JSONData/");
		return filePath;
	}

}
