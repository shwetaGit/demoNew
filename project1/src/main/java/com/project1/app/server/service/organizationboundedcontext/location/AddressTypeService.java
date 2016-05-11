package com.project1.app.server.service.organizationboundedcontext.location;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.bean.ResponseBean;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import org.springframework.http.HttpEntity;
import com.athena.framework.server.exception.repository.SpartanTransactionException;
import com.project1.app.shared.organizationboundedcontext.location.AddressType;
import java.util.List;
import java.util.Map;
import com.athena.framework.server.bean.FindByBean;

<<<<<<< HEAD
@SourceCodeAuthorClass(createdBy = "sagar.jadhav@algorhythm.co.in", updatedBy = "", versionNumber = "1", comments = "Service for AddressType Master table Entity", complexity = Complexity.LOW)
=======
@SourceCodeAuthorClass(createdBy = "sagarjdhv2014@gmail.com", updatedBy = "", versionNumber = "1", comments = "Service for AddressType Master table Entity", complexity = Complexity.LOW)
>>>>>>> branch 'master' of https://github.com/applifireAlgo/DefaultRepo.git
public abstract class AddressTypeService {

    public HttpEntity<ResponseBean> findAll() throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> save(AddressType entity) throws Exception, SpartanTransactionException, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<AddressType> entity, boolean isArray) throws Exception, SpartanTransactionException, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws SpartanTransactionException, SpartanPersistenceException, Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(AddressType entity) throws SpartanTransactionException, SpartanPersistenceException, Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<AddressType> entity, boolean isArray) throws SpartanTransactionException, SpartanPersistenceException, Exception {
        return null;
    }

    public HttpEntity<ResponseBean> search(Map<String, Object> fieldData) throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws SpartanPersistenceException, Exception {
        return null;
    }
}