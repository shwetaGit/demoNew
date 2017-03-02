package com.app.server.businessservice.appbasicsetup.aaa;

public class LoginDemo {

	private String id;
	private String loginId;
	private String password;
	private String multitenantId;

	public LoginDemo() {
		super();
	}

	public LoginDemo(final String id, final String loginId, final String password, final String multitenantId) {
		super();
		this.id = id;
		this.loginId = loginId;
		this.password = password;
		this.multitenantId = multitenantId;
	}

	public String getId() {
		return this.id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getLoginId() {
		return this.loginId;
	}

	public void setLoginId(final String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getMultitenantId() {
		return this.multitenantId;
	}

	public void setMultitenantId(final String multitenantId) {
		this.multitenantId = multitenantId;
	}

	@Override
	public String toString() {
		return "LoginDemo [id=" + this.id + ", loginId=" + this.loginId + ", password=" + this.password + ", multitenantId=" + this.multitenantId + "]";
	}

}
