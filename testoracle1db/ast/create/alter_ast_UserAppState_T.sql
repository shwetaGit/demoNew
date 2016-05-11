

ALTER TABLE ast_UserAppState_T ADD CONSTRAINT fk_baf850814 FOREIGN KEY (appSessionId) REFERENCES ast_LoginSession_T(AppSessionId);



exit;