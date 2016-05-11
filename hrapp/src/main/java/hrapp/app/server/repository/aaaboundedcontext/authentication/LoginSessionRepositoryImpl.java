package hrapp.app.server.repository.aaaboundedcontext.authentication;
import com.athena.server.repository.SearchInterfaceImpl;
import hrapp.app.shared.aaaboundedcontext.authentication.LoginSession;
import org.springframework.stereotype.Repository;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.config.server.helper.ResourceFactoryManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import com.spartan.server.interfaces.LoginSessionInterface;
import java.lang.Override;
import java.sql.Timestamp;
import org.springframework.transaction.annotation.Transactional;

@Repository
@SourceCodeAuthorClass(createdBy = "sagar.jadhav@algorhythm.co.in", updatedBy = "", versionNumber = "1", comments = "Repository for LoginSession Transaction table", complexity = Complexity.MEDIUM)
public class LoginSessionRepositoryImpl extends SearchInterfaceImpl implements LoginSessionRepository<LoginSession> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    @Override
    @Transactional
    public void updateUserSession(LoginSessionInterface loginSession, String SessionData) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createQuery("update LoginSession l set l.sessionData=:sessionData where l.appSessionId=:AppSessionId");
        query.setParameter("AppSessionId", loginSession.getAppSessionId());
        query.setParameter("SessionData", SessionData);
        int updateVal = query.executeUpdate();
    }

    @Override
    @Transactional
    public void saveSession(String userId, String appSessionId, String appServerSessinId, Timestamp loginTime, Timestamp logOutTime, String ClientIPAddress, Long ClientIPAddressInt, int ClientNetworkAddress, String ClientBrowser) throws SpartanPersistenceException {
        hrapp.app.shared.aaaboundedcontext.authentication.LoginSession loginSession = new hrapp.app.shared.aaaboundedcontext.authentication.LoginSession();
        loginSession.setAppServerSessionId(appServerSessinId);
        loginSession.setAppSessionId(appSessionId);
        loginSession.setClientBrowser(ClientBrowser);
        loginSession.setClientIPAddress(ClientIPAddress);
        loginSession.setClientIPAddressInt(ClientIPAddressInt);
        loginSession.setClientNetworkAddress(ClientNetworkAddress);
        loginSession.setLoginTime(loginTime);
        loginSession.setLogoutTime(logOutTime);
        loginSession.setUserId(userId);
        loginSession.setSystemInformation(com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE.ADD);
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(loginSession);
    }

    @Override
    @Transactional
    public void updateSession(LoginSessionInterface loginSession) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createQuery("update LoginSession l set l.loginTime=:loginTime, l.logoutTime=:logoutTime where l.appSessionId=:AppSessionId");
        query.setParameter("loginTime", loginSession.getLoginTime());
        query.setParameter("logoutTime", loginSession.getLogoutTime());
        query.setParameter("AppSessionId", loginSession.getAppSessionId());
        int updateVal = query.executeUpdate();
    }

    @Override
    @Transactional
    public LoginSessionInterface findById(String AppSessionId) throws SpartanPersistenceException, Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createQuery("select l from LoginSession l where l.appSessionId=:AppSessionId");
        query.setParameter("AppSessionId", AppSessionId);
        java.util.List<LoginSession> loginSession = query.getResultList();
        if (loginSession != null) {
            if (loginSession.size() > 0) {
                return (LoginSessionInterface) loginSession.get(0);
            }
        }
        return null;
    }

    @Override
    @Transactional
    public void updateLastAccessTime(String userId, String appSessionId, Timestamp timestamp) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createQuery("update LoginSession l set l.lastAccessTime=:lastAccessTime where l.appSessionId=:appSessionId and l.userId=:userId");
        query.setParameter("lastAccessTime", timestamp);
        query.setParameter("userId", userId);
        query.setParameter("appSessionId", appSessionId);
        int updateVal = query.executeUpdate();
    }
}
