

ALTER TABLE ast_CommunicationMap_B ADD CONSTRAINT fk_c86b37897 FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_CommunicationMap_B ADD CONSTRAINT fk_730364e75 FOREIGN KEY (commDataId) REFERENCES ast_CommunicationData_TP(commDataId);



exit;