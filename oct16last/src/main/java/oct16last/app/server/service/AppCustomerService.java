package oct16last.app.server.service;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.bean.ResponseBean;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import org.springframework.http.HttpEntity;
import java.util.List;
import oct16last.app.shared.customers.AppCustomer;
import java.util.Map;
import com.athena.framework.server.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "", versionNumber = "1", comments = "Service for AppCustomer Master table Entity", complexity = Complexity.LOW)
public abstract class AppCustomerService {

    public HttpEntity<ResponseBean> findAll() throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> save(AppCustomer entity) throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<AppCustomer> entity, boolean isArray) throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> update(AppCustomer entity) throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<AppCustomer> entity, boolean isArray) throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> search(Map<String, Object> fieldData) throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> findByContactId(FindByBean findByBean) throws SpartanPersistenceException, Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByAppCustomerType(FindByBean findByBean) throws SpartanPersistenceException, Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByAppCustomerCategory(FindByBean findByBean) throws SpartanPersistenceException, Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws SpartanPersistenceException, Exception {
        return null;
    }
}
