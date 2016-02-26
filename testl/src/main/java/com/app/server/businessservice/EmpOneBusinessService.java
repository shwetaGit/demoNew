package com.app.server.businessservice;
import com.app.server.repository.EmpOneRepository;
import com.app.shared.defaultdomain.EmpOne;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class EmpOneBusinessService {

    @Autowired
    private EmpOneRepository empOneRepository;

    public void update(EmpOne entity) throws SpartanPersistenceException {
        try {
            if (entity.isHardDelete()) {
                empOneRepository.delete(entity.getEmpId());
            } else {
                empOneRepository.deleteEmpTwo(entity.getDeletedEmpTwoList());
                empOneRepository.update(entity);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }

    public void update(List<EmpOne> entity) throws SpartanPersistenceException {
        try {
            for (EmpOne _empone : entity) {
                if (_empone.isHardDelete()) {
                    empOneRepository.delete(_empone.getEmpId());
                } else {
                    empOneRepository.deleteEmpTwo(_empone.getDeletedEmpTwoList());
                    empOneRepository.update(_empone);
                }
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in updating Entity", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }
}
