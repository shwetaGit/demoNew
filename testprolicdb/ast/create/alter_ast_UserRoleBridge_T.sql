

ALTER TABLE ast_UserRoleBridge_T ADD CONSTRAINT fk_0c68b8545 FOREIGN KEY (roleId) REFERENCES ast_Roles_T(roleId);



ALTER TABLE ast_UserRoleBridge_T ADD CONSTRAINT fk_5dc7604af FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;