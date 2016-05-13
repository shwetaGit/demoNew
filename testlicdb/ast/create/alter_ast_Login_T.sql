

ALTER TABLE ast_Login_T ADD CONSTRAINT fk_04f8ed657 FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_Login_T ADD CONSTRAINT fk_691f3b137 FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;