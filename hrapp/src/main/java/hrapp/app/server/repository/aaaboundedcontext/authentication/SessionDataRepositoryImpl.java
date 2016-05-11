package hrapp.app.server.repository.aaaboundedcontext.authentication;
import com.athena.server.repository.SearchInterfaceImpl;
import hrapp.app.shared.aaaboundedcontext.authentication.SessionData;
import org.springframework.stereotype.Repository;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.config.server.helper.ResourceFactoryManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.spartan.server.interfaces.SessionDataInterface;
import java.lang.Override;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Repository
@SourceCodeAuthorClass(createdBy = "sagar.jadhav@algorhythm.co.in", updatedBy = "", versionNumber = "1", comments = "Repository for SessionData Transaction table", complexity = Complexity.MEDIUM)
public class SessionDataRepositoryImpl extends SearchInterfaceImpl implements SessionDataRepository<SessionData> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    @Transactional
    @Override
    public SessionDataInterface saveSessionData(String userId, String customerId, int dataType, Integer numberValue, String stringValue, String jsonValue, Boolean booleanValue, Timestamp dateTimeValue, String appSessionId, String sessionKey) throws Exception {
        SessionData sessionData = new SessionData();
        sessionData.setUserId(userId);
        sessionData.setCustomerId(customerId);
        sessionData.setDataType(dataType);
        sessionData.setNumberValue(numberValue);
        sessionData.setStringValue(stringValue);
        sessionData.setJsonValue(jsonValue);
        sessionData.setBooleanValue(booleanValue);
        sessionData.setDateTimeValue(dateTimeValue);
        sessionData.setAppSessionId(appSessionId);
        sessionData.setSessionKey(sessionKey);
        sessionData.setVersionId(1);
        sessionData.setSystemInformation(1);
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(sessionData);
        return (SessionDataInterface) sessionData;
    }

    @Transactional
    @Override
    public void update(SessionDataInterface entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        hrapp.app.shared.aaaboundedcontext.authentication.SessionData s = emanager.find(hrapp.app.shared.aaaboundedcontext.authentication.SessionData.class, id);
        emanager.remove(s);
    }

    @Transactional
    @Override
    public List<SessionDataInterface> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<SessionDataInterface> query = emanager.createQuery("select u from SessionData u where u.systemInfo.activeStatus=1").getResultList();
        return query;
    }

    @Transactional
    @Override
    public List<SessionDataInterface> findByAppSessionId(String appSessionId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("SessionData.findByAppSessionId");
        query.setParameter("appSessionId", appSessionId);
        java.util.List<SessionDataInterface> listOfSessionData = query.getResultList();
        return listOfSessionData;
    }

    @Transactional
    @Override
    public SessionDataInterface findBySessionKey(String appSessionId, String sessionKey) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("findBySessionKey");
        query.setParameter("sessionKey", sessionKey);
        query.setParameter("appSessionId", appSessionId);
        java.util.List<SessionDataInterface> listOfSessionData = query.getResultList();
        if (listOfSessionData != null) {
            if (listOfSessionData.size() > 0) {
                return listOfSessionData.get(0);
            }
        }
        return null;
    }

    @Transactional
    @Override
    public void deleteAll(String appSessionId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("deleteAllSessionData");
        query.setParameter("appSessionId", appSessionId);
        query.executeUpdate();
    }
}