package com.app.shared.appbasicsetup.userrolemanagement;
/***************************************************************************

 * File Name:-MenuJSON.java

 * Date Created:-22-Dec-2016

 * Author:- Rushikesh Jeware

 * Purpose :-


 ***************************************************************************
 Date Modified    |		 Author		 |	Modifications

 22-Dec-2016		Rushikesh Jeware

 ***************************************************************************/

public class MenuJSON {

	private String menuId;
	private String menuTreeId;
	private String menuName;
	private String menuAction;
	private String menuIcon;
	private String menuLabel;
	private String menuCommands;
	private String reffId;
	private boolean autoSave;
	private boolean headMenu;

	public MenuJSON() {
		super();
	}

	public MenuJSON(final String menuId, final String menuTreeId, final String menuName, final String menuAction, final String menuIcon, final String menuLabel,
			final String menuCommands, final String reffId, final boolean autoSave, final boolean headMenu) {
		super();
		this.menuId = menuId;
		this.menuTreeId = menuTreeId;
		this.menuName = menuName;
		this.menuAction = menuAction;
		this.menuIcon = menuIcon;
		this.menuLabel = menuLabel;
		this.menuCommands = menuCommands;
		this.reffId = reffId;
		this.autoSave = autoSave;
		this.headMenu = headMenu;
	}

	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuId(final String menuId) {
		this.menuId = menuId;
	}

	public String getMenuTreeId() {
		return this.menuTreeId;
	}

	public void setMenuTreeId(final String menuTreeId) {
		this.menuTreeId = menuTreeId;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(final String menuName) {
		this.menuName = menuName;
	}

	public String getMenuAction() {
		return this.menuAction;
	}

	public void setMenuAction(final String menuAction) {
		this.menuAction = menuAction;
	}

	public String getMenuIcon() {
		return this.menuIcon;
	}

	public void setMenuIcon(final String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public String getMenuLabel() {
		return this.menuLabel;
	}

	public void setMenuLabel(final String menuLabel) {
		this.menuLabel = menuLabel;
	}

	public String getMenuCommands() {
		return this.menuCommands;
	}

	public void setMenuCommands(final String menuCommands) {
		this.menuCommands = menuCommands;
	}

	public String getReffId() {
		return this.reffId;
	}

	public void setReffId(final String reffId) {
		this.reffId = reffId;
	}

	public boolean isAutoSave() {
		return this.autoSave;
	}

	public void setAutoSave(final boolean autoSave) {
		this.autoSave = autoSave;
	}

	public boolean isHeadMenu() {
		return this.headMenu;
	}

	public void setHeadMenu(final boolean headMenu) {
		this.headMenu = headMenu;
	}

	@Override
	public String toString() {
		return "MenuJSON [menuId=" + this.menuId + ", menuTreeId=" + this.menuTreeId + ", menuName=" + this.menuName + ", menuAction=" + this.menuAction + ", menuIcon="
				+ this.menuIcon + ", menuLabel=" + this.menuLabel + ", menuCommands=" + this.menuCommands + ", reffId=" + this.reffId + ", autoSave=" + this.autoSave
				+ ", headMenu=" + this.headMenu + "]";
	}

}
