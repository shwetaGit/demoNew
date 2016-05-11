

ALTER TABLE ast_RoleMenuBridge_TP ADD CONSTRAINT fk_39d6e1392 FOREIGN KEY (roleId) REFERENCES ast_Roles_T(roleId);



ALTER TABLE ast_RoleMenuBridge_TP ADD CONSTRAINT fk_6b7066452 FOREIGN KEY (menuId) REFERENCES ast_AppMenus_M(menuId);



exit;