

ALTER TABLE ast_UserAppState_T ADD CONSTRAINT fk_1b9b2cbb4 FOREIGN KEY (appSessionId) REFERENCES ast_LoginSession_T(AppSessionId);



exit;