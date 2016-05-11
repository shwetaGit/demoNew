

ALTER TABLE ast_CommunicationType_M ADD CONSTRAINT fk_23fed6d90 FOREIGN KEY (commGroupId) REFERENCES ast_CommunicationGroup_M(commGroupId);



exit;