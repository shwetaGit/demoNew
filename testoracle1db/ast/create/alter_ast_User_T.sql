

ALTER TABLE ast_User_T ADD CONSTRAINT fk_4085a33d8 FOREIGN KEY (userAccessLevelId) REFERENCES ast_UserAccessLevel_M(userAccessLevelId);



ALTER TABLE ast_User_T ADD CONSTRAINT fk_46d0fdb88 FOREIGN KEY (userAccessDomainId) REFERENCES ast_UserAccessDomain_M(userAccessDomainId);



exit;