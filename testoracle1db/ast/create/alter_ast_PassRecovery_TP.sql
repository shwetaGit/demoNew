

ALTER TABLE ast_PassRecovery_TP ADD CONSTRAINT fk_3437c3d56 FOREIGN KEY (questionId) REFERENCES ast_Question_M(questionId);



ALTER TABLE ast_PassRecovery_TP ADD CONSTRAINT fk_19b695868 FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;