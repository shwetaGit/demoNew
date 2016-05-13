

ALTER TABLE ast_PassRecovery_TP ADD CONSTRAINT fk_a9cefac3c FOREIGN KEY (questionId) REFERENCES ast_Question_M(questionId);



ALTER TABLE ast_PassRecovery_TP ADD CONSTRAINT fk_e46bc777f FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;