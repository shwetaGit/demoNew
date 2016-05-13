

ALTER TABLE ast_CommunicationMap_B ADD CONSTRAINT fk_ee54a280c FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_CommunicationMap_B ADD CONSTRAINT fk_361c3928d FOREIGN KEY (commDataId) REFERENCES ast_CommunicationData_TP(commDataId);



exit;