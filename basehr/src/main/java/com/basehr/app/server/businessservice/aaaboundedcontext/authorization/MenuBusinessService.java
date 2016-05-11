package com.basehr.app.server.businessservice.aaaboundedcontext.authorization;


public interface MenuBusinessService {

	public String getUserMenu(String _userid, Integer appType) throws Exception;
	
	public void storeMenu(String userId,String menuId, String json) throws Exception;

	public String fetchStoreMenus(String userId) throws Exception;

	public void deleteMenu(String userId, String menuId) throws Exception;

	public String findMainScreenMenus(String userId, Integer appType) throws Exception;

}
