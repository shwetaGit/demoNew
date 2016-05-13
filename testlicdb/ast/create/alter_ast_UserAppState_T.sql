

ALTER TABLE ast_UserAppState_T ADD CONSTRAINT fk_0ecc7d966 FOREIGN KEY (appSessionId) REFERENCES ast_LoginSession_T(AppSessionId);



exit;