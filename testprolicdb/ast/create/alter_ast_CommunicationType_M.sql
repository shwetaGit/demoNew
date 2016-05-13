

ALTER TABLE ast_CommunicationType_M ADD CONSTRAINT fk_46e5a2ab1 FOREIGN KEY (commGroupId) REFERENCES ast_CommunicationGroup_M(commGroupId);



exit;