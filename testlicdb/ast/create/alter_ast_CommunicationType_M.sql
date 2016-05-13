

ALTER TABLE ast_CommunicationType_M ADD CONSTRAINT fk_cb30ed112 FOREIGN KEY (commGroupId) REFERENCES ast_CommunicationGroup_M(commGroupId);



exit;