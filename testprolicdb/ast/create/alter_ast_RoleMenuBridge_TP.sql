

ALTER TABLE ast_RoleMenuBridge_TP ADD CONSTRAINT fk_0c0329de1 FOREIGN KEY (roleId) REFERENCES ast_Roles_T(roleId);



ALTER TABLE ast_RoleMenuBridge_TP ADD CONSTRAINT fk_65b92834b FOREIGN KEY (menuId) REFERENCES ast_AppMenus_M(menuId);



exit;