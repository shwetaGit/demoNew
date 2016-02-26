package com.app.server.businessservice;
import com.app.server.repository.EducationDetailsRepository;
import com.app.shared.backgroundcheck.EducationDetails;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class EducationDetailsBusinessService {

    @Autowired
    private EducationDetailsRepository educationDetailsRepository;

    public void update(EducationDetails entity) throws SpartanPersistenceException {
        try {
            if (entity.isHardDelete()) {
                educationDetailsRepository.delete(entity.getEduPk());
            } else {
                educationDetailsRepository.deleteDocumentList(entity.getDeletedDocumentListList());
                educationDetailsRepository.update(entity);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }

    public void update(List<EducationDetails> entity) throws SpartanPersistenceException {
        try {
            for (EducationDetails _educationdetails : entity) {
                if (_educationdetails.isHardDelete()) {
                    educationDetailsRepository.delete(_educationdetails.getEduPk());
                } else {
                    educationDetailsRepository.deleteDocumentList(_educationdetails.getDeletedDocumentListList());
                    educationDetailsRepository.update(_educationdetails);
                }
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in updating Entity", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }
}
