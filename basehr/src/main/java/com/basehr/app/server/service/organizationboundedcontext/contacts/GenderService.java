package com.basehr.app.server.service.organizationboundedcontext.contacts;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import com.basehr.app.shared.organizationboundedcontext.contacts.Gender;
import java.util.List;
import com.athena.framework.server.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Service for Gender Master table Entity", complexity = Complexity.LOW)
public abstract class GenderService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(Gender entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<Gender> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(Gender entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<Gender> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}
