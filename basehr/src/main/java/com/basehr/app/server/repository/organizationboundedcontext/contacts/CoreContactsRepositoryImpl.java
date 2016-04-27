package com.basehr.app.server.repository.organizationboundedcontext.contacts;
import com.basehr.app.server.repository.core.SearchInterfaceImpl;
import com.basehr.app.shared.organizationboundedcontext.contacts.CoreContacts;
import org.springframework.stereotype.Repository;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.config.server.helper.ResourceFactoryManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.spartan.pluggable.logger.alarms.AppAlarm;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.spartan.pluggable.logger.api.LogManager;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import java.lang.Override;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.basehr.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.basehr.app.shared.organizationboundedcontext.location.Address;

@Repository
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for CoreContacts Transaction table", complexity = Complexity.MEDIUM)
public class CoreContactsRepositoryImpl extends SearchInterfaceImpl implements CoreContactsRepository<CoreContacts> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(System.getProperty("LOGGER_ID"));

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<CoreContacts> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.basehr.app.shared.organizationboundedcontext.contacts.CoreContacts> query = emanager.createQuery("select u from CoreContacts u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "CoreContactsRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public CoreContacts save(CoreContacts entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.basehr.app.shared.organizationboundedcontext.contacts.CommunicationData> communicationdata = new java.util.ArrayList<com.basehr.app.shared.organizationboundedcontext.contacts.CommunicationData>();
        for (java.util.Iterator iterator = entity.getCommunicationData().iterator(); iterator.hasNext(); ) {
            com.basehr.app.shared.organizationboundedcontext.contacts.CommunicationData childEntity = (com.basehr.app.shared.organizationboundedcontext.contacts.CommunicationData) iterator.next();
            if (childEntity.getPrimaryKey() != null) {
                com.basehr.app.shared.organizationboundedcontext.contacts.CommunicationData ans = emanager.find(CommunicationData.class, childEntity.getPrimaryKey());
                communicationdata.add(ans);
            } else {
                communicationdata.add(childEntity);
            }
        }
        java.util.List<com.basehr.app.shared.organizationboundedcontext.location.Address> address = new java.util.ArrayList<com.basehr.app.shared.organizationboundedcontext.location.Address>();
        for (java.util.Iterator iterator = entity.getAddress().iterator(); iterator.hasNext(); ) {
            com.basehr.app.shared.organizationboundedcontext.location.Address childEntity = (com.basehr.app.shared.organizationboundedcontext.location.Address) iterator.next();
            if (childEntity.getPrimaryKey() != null) {
                com.basehr.app.shared.organizationboundedcontext.location.Address ans = emanager.find(Address.class, childEntity.getPrimaryKey());
                address.add(ans);
            } else {
                address.add(childEntity);
            }
        }
        entity.setCommunicationData(communicationdata);
        entity.setAddress(address);
        emanager.persist(entity);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "CoreContactsRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<CoreContacts> save(List<CoreContacts> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.basehr.app.shared.organizationboundedcontext.contacts.CoreContacts obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "CoreContactsRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.basehr.app.shared.organizationboundedcontext.contacts.CoreContacts s = emanager.find(com.basehr.app.shared.organizationboundedcontext.contacts.CoreContacts.class, id);
        emanager.remove(s);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "CoreContactsRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void deleteCommunicationData(List<CommunicationData> communicationdata) {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (com.basehr.app.shared.organizationboundedcontext.contacts.CommunicationData _communicationdata : communicationdata) {
            com.basehr.app.shared.organizationboundedcontext.contacts.CommunicationData s = emanager.find(com.basehr.app.shared.organizationboundedcontext.contacts.CommunicationData.class, _communicationdata.getCommDataId());
            emanager.remove(s);
        }
    }

    @Override
    @Transactional
    public void deleteAddress(List<Address> address) {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (com.basehr.app.shared.organizationboundedcontext.location.Address _address : address) {
            com.basehr.app.shared.organizationboundedcontext.location.Address s = emanager.find(com.basehr.app.shared.organizationboundedcontext.location.Address.class, _address.getAddressId());
            emanager.remove(s);
        }
    }

    @Override
    @Transactional
    public void update(CoreContacts entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "CoreContactsRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<CoreContacts> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.basehr.app.shared.organizationboundedcontext.contacts.CoreContacts obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "CoreContactsRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public List<CoreContacts> findByTitleId(String titleId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("CoreContacts.findByTitleId");
        query.setParameter("titleId", titleId);
        java.util.List<com.basehr.app.shared.organizationboundedcontext.contacts.CoreContacts> listOfCoreContacts = query.getResultList();
        Log.out.println("ORGCN324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "CoreContactsRepositoryImpl", "findByTitleId", "Total Records Fetched = " + listOfCoreContacts.size());
        return listOfCoreContacts;
    }

    @Transactional
    public List<CoreContacts> findByNativeLanguageCode(String nativeLanguageCode) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("CoreContacts.findByNativeLanguageCode");
        query.setParameter("nativeLanguageCode", nativeLanguageCode);
        java.util.List<com.basehr.app.shared.organizationboundedcontext.contacts.CoreContacts> listOfCoreContacts = query.getResultList();
        Log.out.println("ORGCN324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "CoreContactsRepositoryImpl", "findByNativeLanguageCode", "Total Records Fetched = " + listOfCoreContacts.size());
        return listOfCoreContacts;
    }

    @Transactional
    public List<CoreContacts> findByGenderId(String genderId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("CoreContacts.findByGenderId");
        query.setParameter("genderId", genderId);
        java.util.List<com.basehr.app.shared.organizationboundedcontext.contacts.CoreContacts> listOfCoreContacts = query.getResultList();
        Log.out.println("ORGCN324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "CoreContactsRepositoryImpl", "findByGenderId", "Total Records Fetched = " + listOfCoreContacts.size());
        return listOfCoreContacts;
    }

    @Transactional
    public List<CoreContacts> findByTimeZoneId(String timeZoneId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("CoreContacts.findByTimeZoneId");
        query.setParameter("timeZoneId", timeZoneId);
        java.util.List<com.basehr.app.shared.organizationboundedcontext.contacts.CoreContacts> listOfCoreContacts = query.getResultList();
        Log.out.println("ORGCN324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "CoreContactsRepositoryImpl", "findByTimeZoneId", "Total Records Fetched = " + listOfCoreContacts.size());
        return listOfCoreContacts;
    }

    @Transactional
    public CoreContacts findById(String contactId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("CoreContacts.findById");
        query.setParameter("contactId", contactId);
        com.basehr.app.shared.organizationboundedcontext.contacts.CoreContacts listOfCoreContacts = (com.basehr.app.shared.organizationboundedcontext.contacts.CoreContacts) query.getSingleResult();
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "CoreContactsRepositoryImpl", "findById", "Total Records Fetched = " + listOfCoreContacts);
        return listOfCoreContacts;
    }
}
