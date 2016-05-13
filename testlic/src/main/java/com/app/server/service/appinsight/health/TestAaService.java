package com.app.server.service.appinsight.health;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import com.app.shared.appinsight.health.TestAa;
import java.util.List;
import com.athena.server.pluggable.utils.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "shweta.zagade@algorhythm.co.in", updatedBy = "", versionNumber = "1", comments = "Service for TestAa Master table Entity", complexity = Complexity.LOW)
public abstract class TestAaService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(TestAa entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<TestAa> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(TestAa entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<TestAa> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}
