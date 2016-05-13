

ALTER TABLE ast_User_T ADD CONSTRAINT fk_a00283874 FOREIGN KEY (userAccessLevelId) REFERENCES ast_UserAccessLevel_M(userAccessLevelId);



ALTER TABLE ast_User_T ADD CONSTRAINT fk_3ebca57a0 FOREIGN KEY (userAccessDomainId) REFERENCES ast_UserAccessDomain_M(userAccessDomainId);



exit;