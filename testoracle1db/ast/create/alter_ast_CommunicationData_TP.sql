

ALTER TABLE ast_CommunicationData_TP ADD CONSTRAINT fk_d051b3edc FOREIGN KEY (commGroupId) REFERENCES ast_CommunicationGroup_M(commGroupId);



ALTER TABLE ast_CommunicationData_TP ADD CONSTRAINT fk_e83b42f5b FOREIGN KEY (commType) REFERENCES ast_CommunicationType_M(commType);



exit;