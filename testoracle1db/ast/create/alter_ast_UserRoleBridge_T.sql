

ALTER TABLE ast_UserRoleBridge_T ADD CONSTRAINT fk_b810a7387 FOREIGN KEY (roleId) REFERENCES ast_Roles_T(roleId);



ALTER TABLE ast_UserRoleBridge_T ADD CONSTRAINT fk_f3ca63e54 FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;