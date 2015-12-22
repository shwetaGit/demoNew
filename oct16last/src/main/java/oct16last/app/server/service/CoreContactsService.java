package oct16last.app.server.service;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.bean.ResponseBean;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import org.springframework.http.HttpEntity;
import java.util.List;
import oct16last.app.shared.contacts.CoreContacts;
import com.athena.framework.server.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "", versionNumber = "1", comments = "Service for CoreContacts Transaction table", complexity = Complexity.MEDIUM)
public abstract class CoreContactsService {

    public HttpEntity<ResponseBean> findAll() throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> save(CoreContacts entity) throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<CoreContacts> entity, boolean isArray) throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> update(CoreContacts entity) throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<CoreContacts> entity, boolean isArray) throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> findByTitleId(FindByBean findByBean) throws SpartanPersistenceException, Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByNativeLanguageCode(FindByBean findByBean) throws SpartanPersistenceException, Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByGenderId(FindByBean findByBean) throws SpartanPersistenceException, Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByTimeZone(FindByBean findByBean) throws SpartanPersistenceException, Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws SpartanPersistenceException, Exception {
        return null;
    }
}
