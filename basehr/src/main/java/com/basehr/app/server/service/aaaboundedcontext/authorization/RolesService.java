package com.basehr.app.server.service.aaaboundedcontext.authorization;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import com.basehr.app.shared.aaaboundedcontext.authorization.Roles;
import java.util.List;
import com.athena.framework.server.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Service for Roles Transaction table", complexity = Complexity.MEDIUM)
public abstract class RolesService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(Roles entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<Roles> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(Roles entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<Roles> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}
