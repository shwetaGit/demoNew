package com.basehr.app.server.service.aaaboundedcontext.authentication;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import com.basehr.app.shared.aaaboundedcontext.authentication.PasswordPolicy;
import java.util.List;
import java.util.Map;
import com.athena.framework.server.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Service for PasswordPolicy Master table Entity", complexity = Complexity.LOW)
public abstract class PasswordPolicyService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(PasswordPolicy entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<PasswordPolicy> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(PasswordPolicy entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<PasswordPolicy> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> search(Map<String, Object> fieldData) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}
