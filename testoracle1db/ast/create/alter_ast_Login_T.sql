

ALTER TABLE ast_Login_T ADD CONSTRAINT fk_ff3b462e9 FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_Login_T ADD CONSTRAINT fk_70cc37183 FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;