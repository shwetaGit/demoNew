package oct16last.app.server.service;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.bean.ResponseBean;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import org.springframework.http.HttpEntity;
import java.util.List;
import oct16last.app.shared.defaultdomain.Testing;
import com.athena.framework.server.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "", versionNumber = "1", comments = "Service for Testing Master table Entity", complexity = Complexity.LOW)
public abstract class TestingService {

    public HttpEntity<ResponseBean> findAll() throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> save(Testing entity) throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<Testing> entity, boolean isArray) throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> update(Testing entity) throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<Testing> entity, boolean isArray) throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws SpartanPersistenceException, Exception {
        return null;
    }
}
