

ALTER TABLE ast_UserRoleBridge_T ADD CONSTRAINT fk_36fc4b49d FOREIGN KEY (roleId) REFERENCES ast_Roles_T(roleId);



ALTER TABLE ast_UserRoleBridge_T ADD CONSTRAINT fk_b118672a2 FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;