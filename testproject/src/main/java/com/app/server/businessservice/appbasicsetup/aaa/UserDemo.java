package com.app.server.businessservice.appbasicsetup.aaa;

public class UserDemo {

	private String userId;
	private String firstName;
	private String loginId;
	private String timezone;
	private String timezoneId;
	private int sessionTimeout;
	private String multitenantId;

	public UserDemo() {
		super();
	}

	public UserDemo(final String userId, final String firstName, final String loginId, final String timezone, final String timezoneId, final int sessionTimeout, final String multitenantId) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.loginId = loginId;
		this.timezone = timezone;
		this.timezoneId = timezoneId;
		this.sessionTimeout = sessionTimeout;
		this.multitenantId = multitenantId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(final String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLoginId() {
		return this.loginId;
	}

	public void setLoginId(final String loginId) {
		this.loginId = loginId;
	}

	public String getTimezone() {
		return this.timezone;
	}

	public void setTimezone(final String timezone) {
		this.timezone = timezone;
	}

	public String getTimezoneId() {
		return this.timezoneId;
	}

	public void setTimezoneId(final String timezoneId) {
		this.timezoneId = timezoneId;
	}

	public int getSessionTimeout() {
		return this.sessionTimeout;
	}

	public void setSessionTimeout(final int sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}
	
	public String getMultitenantId() {
		return this.multitenantId;
	}
	
	public void setMultitenantId(final String multitenantId) {
		this.multitenantId = multitenantId;
	}

	@Override
	public String toString() {
		return "UserDemo [userId=" + this.userId + ", firstName=" + this.firstName + ", loginId=" + this.loginId + ", timezone=" + this.timezone + ", timezoneId="
				+ this.timezoneId + ", sessionTimeout=" + this.sessionTimeout + ", multitenantId=" + this.multitenantId + "]";
	}

}
