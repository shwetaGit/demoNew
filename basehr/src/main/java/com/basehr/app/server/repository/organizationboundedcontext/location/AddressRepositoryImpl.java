package com.basehr.app.server.repository.organizationboundedcontext.location;
import com.basehr.app.server.repository.core.SearchInterfaceImpl;
import com.basehr.app.shared.organizationboundedcontext.location.Address;
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
import java.util.Map;

@Repository
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for Address Transaction table", complexity = Complexity.MEDIUM)
public class AddressRepositoryImpl extends SearchInterfaceImpl implements AddressRepository<Address> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(System.getProperty("LOGGER_ID"));

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<Address> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.basehr.app.shared.organizationboundedcontext.location.Address> query = emanager.createQuery("select u from Address u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "AddressRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public Address save(Address entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "AddressRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<Address> save(List<Address> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.basehr.app.shared.organizationboundedcontext.location.Address obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "AddressRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.basehr.app.shared.organizationboundedcontext.location.Address s = emanager.find(com.basehr.app.shared.organizationboundedcontext.location.Address.class, id);
        emanager.remove(s);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "AddressRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(Address entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "AddressRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<Address> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.basehr.app.shared.organizationboundedcontext.location.Address obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "AddressRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public List<Object> search(String finderName, Map<String, Object> fields, Map<String, String> fieldMetaData) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery(finderName);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        Map<String, String> metaData = new java.util.HashMap<String, String>();
        metaData = fieldMetaData;
        String inputStr = "01-01-1850 00:00:00 UTC";
        java.util.Date date = setFormattedDate(inputStr);
        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
        for (Map.Entry<String, String> entry : metaData.entrySet()) {
            boolean matched = false;
            for (Map.Entry<String, Object> entry1 : fields.entrySet()) {
                if (entry.getKey() == entry1.getKey()) {
                    if (entry.getValue().equalsIgnoreCase("integer") || entry.getValue().equalsIgnoreCase("double") || entry.getValue().equalsIgnoreCase("float") || entry.getValue().equalsIgnoreCase("long")) {
                        map.put("min" + entry1.getKey(), entry1.getValue());
                        map.put("max" + entry1.getKey(), entry1.getValue());
                    } else if (entry.getValue().equalsIgnoreCase("String")) {
                        map.put(entry1.getKey(), "%" + entry1.getValue() + "%");
                    } else if (entry.getValue().equalsIgnoreCase("Date") || entry.getValue().equalsIgnoreCase("DateTime")) {
                        java.util.Date dateValue = setFormattedDate(entry1.getValue().toString());
                        map.put(entry1.getKey(), dateValue);
                    } else if (entry.getValue().equalsIgnoreCase("TimeStamp")) {
                        java.util.Date dateValue = setFormattedDate(entry1.getValue().toString());
                        map.put(entry1.getKey(), new java.sql.Timestamp(dateValue.getTime()));
                    } else {
                        map.put(entry1.getKey(), entry1.getValue());
                    }
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                if (entry.getValue().equalsIgnoreCase("String")) {
                    map.put(entry.getKey(), "%");
                } else if (entry.getValue().equalsIgnoreCase("integer")) {
                    map.put("min" + entry.getKey(), Integer.MIN_VALUE);
                    map.put("max" + entry.getKey(), Integer.MAX_VALUE);
                } else if (entry.getValue().equalsIgnoreCase("double")) {
                    map.put("min" + entry.getKey(), java.lang.Double.MIN_VALUE);
                    map.put("max" + entry.getKey(), java.lang.Double.MAX_VALUE);
                } else if (entry.getValue().equalsIgnoreCase("long")) {
                    map.put("min" + entry.getKey(), java.lang.Long.MIN_VALUE);
                    map.put("max" + entry.getKey(), java.lang.Long.MAX_VALUE);
                } else if (entry.getValue().equalsIgnoreCase("float")) {
                    map.put("min" + entry.getKey(), java.lang.Float.MIN_VALUE);
                    map.put("max" + entry.getKey(), java.lang.Float.MAX_VALUE);
                } else if (entry.getValue().equalsIgnoreCase("Date") || entry.getValue().equalsIgnoreCase("DATETIME")) {
                    map.put(entry.getKey(), date);
                } else if (entry.getValue().equalsIgnoreCase("TINYINT")) {
                    map.put(entry.getKey(), 1);
                } else if (entry.getValue().equalsIgnoreCase("timestamp")) {
                    map.put(entry.getKey(), timestamp);
                } else if (entry.getValue().equalsIgnoreCase("integer_userAccesCode")) {
                    map.put(entry.getKey(), runtimeLogInfoHelper.getUserAccessCode());
                }
            }
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        java.util.List<Object> list = query.getResultList();
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "AddressRepositoryImpl", "search", "Total Records Fetched = " + list.size());
        return list;
    }

    @Transactional
    public List<Address> findByAddressTypeId(String addressTypeId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("Address.findByAddressTypeId");
        query.setParameter("addressTypeId", addressTypeId);
        java.util.List<com.basehr.app.shared.organizationboundedcontext.location.Address> listOfAddress = query.getResultList();
        Log.out.println("ORGLO324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "AddressRepositoryImpl", "findByAddressTypeId", "Total Records Fetched = " + listOfAddress.size());
        return listOfAddress;
    }

    @Transactional
    public List<Address> findByCountryId(String countryId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("Address.findByCountryId");
        query.setParameter("countryId", countryId);
        java.util.List<com.basehr.app.shared.organizationboundedcontext.location.Address> listOfAddress = query.getResultList();
        Log.out.println("ORGLO324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "AddressRepositoryImpl", "findByCountryId", "Total Records Fetched = " + listOfAddress.size());
        return listOfAddress;
    }

    @Transactional
    public List<Address> findByStateId(String stateId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("Address.findByStateId");
        query.setParameter("stateId", stateId);
        java.util.List<com.basehr.app.shared.organizationboundedcontext.location.Address> listOfAddress = query.getResultList();
        Log.out.println("ORGLO324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "AddressRepositoryImpl", "findByStateId", "Total Records Fetched = " + listOfAddress.size());
        return listOfAddress;
    }

    @Transactional
    public List<Address> findByCityId(String cityId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("Address.findByCityId");
        query.setParameter("cityId", cityId);
        java.util.List<com.basehr.app.shared.organizationboundedcontext.location.Address> listOfAddress = query.getResultList();
        Log.out.println("ORGLO324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "AddressRepositoryImpl", "findByCityId", "Total Records Fetched = " + listOfAddress.size());
        return listOfAddress;
    }

    @Transactional
    public Address findById(String addressId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("Address.findById");
        query.setParameter("addressId", addressId);
        com.basehr.app.shared.organizationboundedcontext.location.Address listOfAddress = (com.basehr.app.shared.organizationboundedcontext.location.Address) query.getSingleResult();
        Log.out.println("null", runtimeLogInfoHelper.getRequestHeaderBean(), "AddressRepositoryImpl", "findById", "Total Records Fetched = " + listOfAddress);
        return listOfAddress;
    }
}
