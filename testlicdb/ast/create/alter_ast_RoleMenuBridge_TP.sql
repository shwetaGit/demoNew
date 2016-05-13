

ALTER TABLE ast_RoleMenuBridge_TP ADD CONSTRAINT fk_ca54ddb13 FOREIGN KEY (roleId) REFERENCES ast_Roles_T(roleId);



ALTER TABLE ast_RoleMenuBridge_TP ADD CONSTRAINT fk_a0af2cf02 FOREIGN KEY (menuId) REFERENCES ast_AppMenus_M(menuId);



exit;