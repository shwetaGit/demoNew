package com.basehr.app.server.businessservice.organizationboundedcontext.contacts;
import com.basehr.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import com.basehr.app.shared.organizationboundedcontext.contacts.CoreContacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CoreContactsBusinessService {

    @Autowired
    private CoreContactsRepository coreContactsRepository;

    public void update(CoreContacts entity) throws Exception {
        if (entity.isHardDelete()) {
            coreContactsRepository.delete(entity.getContactId());
        } else {
            coreContactsRepository.deleteCommunicationData(entity.getDeletedCommunicationDataList());
            coreContactsRepository.deleteAddress(entity.getDeletedAddressList());
            coreContactsRepository.update(entity);
        }
    }

    public void update(List<CoreContacts> entity) throws Exception {
        for (CoreContacts _corecontacts : entity) {
            if (_corecontacts.isHardDelete()) {
                coreContactsRepository.delete(_corecontacts.getContactId());
            } else {
                coreContactsRepository.deleteCommunicationData(_corecontacts.getDeletedCommunicationDataList());
                coreContactsRepository.deleteAddress(_corecontacts.getDeletedAddressList());
                coreContactsRepository.update(_corecontacts);
            }
        }
    }
}
