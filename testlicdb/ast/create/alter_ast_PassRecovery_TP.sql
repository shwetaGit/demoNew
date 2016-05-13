

ALTER TABLE ast_PassRecovery_TP ADD CONSTRAINT fk_f0c913d5a FOREIGN KEY (questionId) REFERENCES ast_Question_M(questionId);



ALTER TABLE ast_PassRecovery_TP ADD CONSTRAINT fk_35f579571 FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;