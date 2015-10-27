package svntest.app.server.service.sessionmgt;
import svntest.app.shared.authentication.SessionData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.stereotype.Component;
import com.spartan.shield.server.authentication.interfaces.LoginSessionRepositoryInterface;
import com.spartan.shield.server.authentication.interfaces.LoginSessionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Timestamp;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@Component
public class SessionDataMgtServiceImpl implements SessionDataMgtService {

	@Autowired
	private LoginSessionRepositoryInterface loginSessionInterfaceRepository;

	@Override
	public void setSessionAttribute(String key, Object value) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		session.setAttribute(key, value);
		LoginSessionInterface loginSession = null;
		try {
			loginSession = loginSessionInterfaceRepository.findById(session.getId());

		} catch (SpartanPersistenceException e1) {
			System.out.println("Requested Session Id not found");
		} catch (Exception e1) {
			System.out.println("Requested Session Id not found");
		}

		if (loginSession != null) {

			String sessionData = loginSession.getSessionData();
			try {
				JSONObject sessionDataObject = new JSONObject(sessionData);
				sessionDataObject.accumulate(key, value);
				updateSession(loginSession, sessionDataObject.toString());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

	private void updateSession(LoginSessionInterface loginSession, String sessionData) {
		try {
			loginSessionInterfaceRepository.updateUserSession(loginSession, sessionData);
		} catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void removeSessionAttribute(String key) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		System.out.println("Removing session data for key: " + key);
		session.removeAttribute(key);
		LoginSessionInterface loginSession = null;
		try {
			loginSession = loginSessionInterfaceRepository.findById(session.getId());

		} catch (SpartanPersistenceException e1) {
			System.out.println("Requested Session Id not found");
		} catch (Exception e1) {
			System.out.println("Requested Session Id not found");
		}

		if (loginSession != null) {

			String sessionData = loginSession.getSessionData();
			try {
				JSONObject sessionDataObject = new JSONObject(sessionData);
				sessionDataObject.remove(key);
				updateSession(loginSession, sessionDataObject.toString());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Object getSessionData(String key) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		if (session.getAttribute(key) != null) {
			System.out.println("Returning session data from session for key: " + key);
			return session.getAttribute(key);
		} else {
			try {
				LoginSessionInterface loginSession = null;
				loginSession = loginSessionInterfaceRepository.findById(session.getId());
				if (loginSession != null) {
					String sessionData = loginSession.getSessionData();
					JSONObject sessionDataObject = new JSONObject(sessionData);
					if (sessionDataObject.has(key)) {
						/* Put the value in Http session */
						session.setAttribute(key, sessionDataObject.get(key));
						System.out.println("Returning session data from db for key: " + key);
						return sessionDataObject.get(key);
					}
				}
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}
}
