package oct16last.app.server.service;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.bean.ResponseBean;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import org.springframework.http.HttpEntity;
import java.util.List;
import oct16last.app.shared.authentication.UserAccessDomain;
import com.athena.framework.server.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "", versionNumber = "1", comments = "Service for UserAccessDomain Master table Entity", complexity = Complexity.LOW)
public abstract class UserAccessDomainService {

    public HttpEntity<ResponseBean> findAll() throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> save(UserAccessDomain entity) throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<UserAccessDomain> entity, boolean isArray) throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> update(UserAccessDomain entity) throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<UserAccessDomain> entity, boolean isArray) throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws SpartanPersistenceException, Exception {
        return null;
    }
}
