package com.app.server.businessservice;
import com.app.server.repository.CertificationDetailsRepository;
import com.app.shared.backgroundcheck.CertificationDetails;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CertificationDetailsBusinessService {

    @Autowired
    private CertificationDetailsRepository certificationDetailsRepository;

    public void update(CertificationDetails entity) throws SpartanPersistenceException {
        try {
            if (entity.isHardDelete()) {
                certificationDetailsRepository.delete(entity.getCertPk());
            } else {
                certificationDetailsRepository.deleteDocumentList(entity.getDeletedDocumentListList());
                certificationDetailsRepository.update(entity);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }

    public void update(List<CertificationDetails> entity) throws SpartanPersistenceException {
        try {
            for (CertificationDetails _certificationdetails : entity) {
                if (_certificationdetails.isHardDelete()) {
                    certificationDetailsRepository.delete(_certificationdetails.getCertPk());
                } else {
                    certificationDetailsRepository.deleteDocumentList(_certificationdetails.getDeletedDocumentListList());
                    certificationDetailsRepository.update(_certificationdetails);
                }
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in updating Entity", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }
}
