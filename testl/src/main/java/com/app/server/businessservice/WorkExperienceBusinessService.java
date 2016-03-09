package com.app.server.businessservice;
import com.app.server.repository.WorkExperienceRepository;
import com.app.shared.backgroundcheck.WorkExperience;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class WorkExperienceBusinessService {

    @Autowired
    private WorkExperienceRepository workExperienceRepository;

    public void update(WorkExperience entity) throws SpartanPersistenceException {
        try {
            if (entity.isHardDelete()) {
                workExperienceRepository.delete(entity.getWorkPk());
            } else {
                workExperienceRepository.deleteDocumentList(entity.getDeletedDocumentListList());
                workExperienceRepository.update(entity);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }

    public void update(List<WorkExperience> entity) throws SpartanPersistenceException {
        try {
            for (WorkExperience _workexperience : entity) {
                if (_workexperience.isHardDelete()) {
                    workExperienceRepository.delete(_workexperience.getWorkPk());
                } else {
                    workExperienceRepository.deleteDocumentList(_workexperience.getDeletedDocumentListList());
                    workExperienceRepository.update(_workexperience);
                }
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in updating Entity", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }
}
