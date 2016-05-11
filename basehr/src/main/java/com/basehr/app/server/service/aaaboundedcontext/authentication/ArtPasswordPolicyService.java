package com.basehr.app.server.service.aaaboundedcontext.authentication;
import com.basehr.app.shared.aaaboundedcontext.authentication.ArtPasswordPolicy;
import java.util.List;

import org.springframework.http.HttpEntity;

import project.app.shared.aaaboundedcontext.authentication.ArtPasswordPolicy;

import com.athena.framework.server.bean.FindByBean;
import com.athena.framework.server.bean.ResponseBean;

public abstract class ArtPasswordPolicyService {
	public HttpEntity<ResponseBean> findAll() throws Exception {
		return null;
	}

	public HttpEntity<ResponseBean> save(ArtPasswordPolicy entity) throws Exception {
		return null;
	}

	public HttpEntity<ResponseBean> save(List<ArtPasswordPolicy> entity, boolean isArray) throws Exception{
		return null;
	}

	public HttpEntity<ResponseBean> delete(String id) throws  Exception {
		return null;
	}

	public HttpEntity<ResponseBean> update(ArtPasswordPolicy entity) throws Exception {
		return null;
	}

	public HttpEntity<ResponseBean> update(List<ArtPasswordPolicy> entity, boolean isArray) throws  Exception {
		return null;
	}

	public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws  Exception {
		return null;
	}

}
