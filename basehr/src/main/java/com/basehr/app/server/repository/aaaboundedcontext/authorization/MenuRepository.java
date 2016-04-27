package com.basehr.app.server.repository.aaaboundedcontext.authorization;
import java.util.List;

public interface MenuRepository {

	public List<String> getHeaderByUser(String userId, Integer appType) throws Exception;

	public List<Object[]> getSubMenus(String header, String userId, Integer appType) throws Exception;

	public List<String> getHeaderByUser(String userId) throws Exception;

	public List<Object[]> getSubMenus(String header, String userId) throws Exception;
}
