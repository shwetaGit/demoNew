package svntest.app.server.service.sessionmgt;
public interface SessionDataMgtService {
	public void setSessionAttribute(String key,Object value);
	public void removeSessionAttribute(String key);
	public Object  getSessionData(String key);
}
