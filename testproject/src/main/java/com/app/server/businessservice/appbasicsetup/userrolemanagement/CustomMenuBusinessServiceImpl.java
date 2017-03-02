package com.app.server.businessservice.appbasicsetup.userrolemanagement;
import com.app.shared.appbasicsetup.userrolemanagement.MenuTreee;

import com.app.shared.appbasicsetup.userrolemanagement.Menu;

import com.app.shared.appbasicsetup.userrolemanagement.MainMenuPage;

import com.app.shared.appbasicsetup.userrolemanagement.MenuJSON;


import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import atg.taglib.json.util.JSONArray;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomMenuBusinessServiceImpl implements MenuBusinessService {

	/**
	 * getUserMenu function accept the userId and appType and return the String
	 * of jsonArray containing list of Menus initialize the getUserMenu with
	 * given configuration
	 *
	 * @param : userId, appType
	 * @returns String
	 * @throws : Exception
	 */
	@Override
	public String getUserMenu(final String userId, final Integer appType) throws Exception {
		final JSONArray json = new JSONArray();
		/*
		 * final List<String> headers = menuRepository.getHeaderByUser(userId,
		 * appType); for (final String string : headers) { final String
		 * menuTreeId = string; final List<Object[]> subMenu =
		 * menuRepository.getSubMenus(menuTreeId, userId, appType); final
		 * List<Menu> menus = new ArrayList<Menu>(); for (final Object[]
		 * subMenus : subMenu) { final Menu menu = new Menu((String)
		 * subMenus[0], (String) subMenus[1], (String) subMenus[2], (String)
		 * subMenus[3], (String) subMenus[4], (String) subMenus[2], (String)
		 * subMenus[2], (String) subMenus[6], (boolean) subMenus[7]);
		 * menus.add(menu); } try { json.add(new
		 * MenuTreee(menus).createMenuTree()); } catch (final JSONException e1)
		 * { e1.printStackTrace(); } }
		 */
		return json.toString();
	}

	/**
	 * storeMenu function accept userId, menuId and json string to store menu
	 * initialize the storeMenu with given configuration
	 *
	 * @param : userId, menuId, json
	 * @returns void
	 * @throws : Exception
	 */
	@Override
	public void storeMenu(final String userId, final String menuId, final String json) throws Exception {
		/*
		 * final ArtUserLastStatus artUserLastStatus = new
		 * ArtUserLastStatus(userId, menuId, json);
		 * artUserStatusRepository.save(artUserLastStatus);
		 */
	}

	/**
	 * fetchStoreMenus accept userId and return the list of menus respect to
	 * userId initialize the fetchStoreMenus with given configuration
	 *
	 * @param : userId
	 * @returns String
	 * @throws : Exception
	 */
	@Override
	public String fetchStoreMenus(final String userId) throws Exception {
		// final List<ArtUserLastStatus> artUserLastStatus =
		// artUserStatusRepository.findByUserId(userId);
		final JSONArray array = new JSONArray();
		/*
		 * for (final Object element : artUserLastStatus) { final
		 * ArtUserLastStatus object = (ArtUserLastStatus) element;
		 * array.add(object.toJSON()); }
		 */
		return array.toString();
	}

	/**
	 * deleteMenu accept the userId and menuId to delete menu from list
	 * initialize the delete with given configuration
	 *
	 * @param : userId, menuId
	 * @returns void
	 * @throws : Exception
	 */
	@Override
	public void deleteMenu(final String userId, final String menuId) throws Exception {
		/*
		 * final List<ArtUserLastStatus> list =
		 * artUserStatusRepository.findByUserMenuId(userId, menuId);
		 * 
		 * for (final Object element : list) { final ArtUserLastStatus
		 * artUserLastStatus = (ArtUserLastStatus) element;
		 * artUserStatusRepository.delete(artUserLastStatus.getId());
		 * 
		 * }
		 */
	}

	/**
	 * findMainScreenMenus function accept userId and appType to find and return
	 * mainscreen menus initialize the findMainScreenMenus with given
	 * configuration
	 *
	 * @param : userId, appType
	 * @returns String
	 * @throws : Exception
	 */
	@Override
	public MainMenuPage findMainScreenMenus(final String userId, final Integer appType) throws Exception {
		final MainMenuPage MainMenuPage = new MainMenuPage("");
		/*
		 * final ArrayList<Menu> menusTreeArray = new ArrayList<Menu>(); final
		 * ArrayList<JSONObject> menusTreeJSONArray = new
		 * ArrayList<JSONObject>(); final List<String> headers =
		 * menuRepository.getHeaderByUser(userId, appType); for (final String
		 * menuTreeId : headers) { final List<Object[]> subMenu =
		 * menuRepository.getSubMenus(menuTreeId, userId, appType); final
		 * List<Menu> menus = new ArrayList<Menu>();
		 * 
		 * for (final Object[] subMenus : subMenu) { final Menu menu = new
		 * Menu((String) subMenus[0], (String) subMenus[1], (String)
		 * subMenus[2], (String) subMenus[3], (String) subMenus[4], (String)
		 * subMenus[5], (String) subMenus[2], (String) subMenus[6], (boolean)
		 * subMenus[7]); menus.add(menu); } try { menusTreeArray.add(new
		 * MenuTreee(menus).createTree()); menusTreeJSONArray.add(new
		 * MenuTreee(menus).createMenuTree()); //
		 * System.out.println(menusTreeArray); } catch (final JSONException e1)
		 * { e1.printStackTrace(); } } System.out.println(new
		 * JSONArray(menusTreeJSONArray));
		 */

		final ObjectMapper mapper = new ObjectMapper();
		// final ArrayList<Menu> menusTreeArray = mapper.readValue(new
		// File("/home/algo2/DefaultFiles/Menu.json"), ArrayList.class);
		final MenuJSON[] menusJSONArray = mapper.readValue(new File(getJSONFileLoc()+ File.separator +"Menu.json"), MenuJSON[].class);
		final ArrayList<Menu> menusTreeHead = new ArrayList<Menu>();
		ArrayList<Menu> menusTreeSort = null;
		final ArrayList<Menu> menusTreeArray = new ArrayList<Menu>();
		final ArrayList<Menu> menusTreeList = new ArrayList<Menu>();
		for (final MenuJSON menu : menusJSONArray) {
			final Menu tmpMenu = new Menu(menu.getMenuId(), menu.getMenuTreeId(), menu.getMenuName(), menu.getMenuAction(), menu.getMenuIcon(), menu.getMenuLabel(),
					menu.getMenuCommands(), menu.getReffId(), menu.isAutoSave());
			menusTreeArray.add(tmpMenu);
			if (menu.isHeadMenu()) {
				menusTreeHead.add(tmpMenu);
			}
		}
		for (final Menu menu1 : menusTreeHead) {
			menusTreeSort = new ArrayList<Menu>();
			menusTreeSort.add(menu1);
			for (final Menu menu : menusTreeArray) {
				if (menu.getMenuTreeId().startsWith(menu1.getMenuTreeId())) {
					menusTreeSort.add(menu);
				}
			}
			final Comparator<Menu> menuComparator = new Comparator<Menu>() {
				@Override
				public int compare(final Menu s1, final Menu s2) {
					final String menuTreeId = s1.getMenuTreeId();
					final String menuTreeId2 = s2.getMenuTreeId();
					return menuTreeId.compareTo(menuTreeId2);
				}
			};
			Collections.sort(menusTreeSort, menuComparator);
			menusTreeList.add(new MenuTreee(menusTreeSort).createTree());
		}
		MainMenuPage.setMenus(menusTreeList);
		return MainMenuPage;
	}

	private String getJSONFileLoc() throws MalformedURLException {
		final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		final ServletContext context = request.getServletContext();
		final String filePath = context.getRealPath("/JSONData/");
		return filePath;
	}
}
