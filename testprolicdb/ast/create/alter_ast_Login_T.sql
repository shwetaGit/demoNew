

ALTER TABLE ast_Login_T ADD CONSTRAINT fk_d6c4d11fe FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_Login_T ADD CONSTRAINT fk_08b10be44 FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;