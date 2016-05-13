

ALTER TABLE ast_CommunicationData_TP ADD CONSTRAINT fk_c00413886 FOREIGN KEY (commGroupId) REFERENCES ast_CommunicationGroup_M(commGroupId);



ALTER TABLE ast_CommunicationData_TP ADD CONSTRAINT fk_977f725d4 FOREIGN KEY (commType) REFERENCES ast_CommunicationType_M(commType);



exit;