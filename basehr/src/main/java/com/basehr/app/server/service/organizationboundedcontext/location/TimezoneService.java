package com.basehr.app.server.service.organizationboundedcontext.location;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import com.basehr.app.shared.organizationboundedcontext.location.Timezone;
import java.util.List;
import java.util.Map;
import com.athena.framework.server.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Service for Timezone Master table Entity", complexity = Complexity.LOW)
public abstract class TimezoneService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(Timezone entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<Timezone> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(Timezone entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<Timezone> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> search(Map<String, Object> fieldData) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}