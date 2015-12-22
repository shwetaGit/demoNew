DROP TABLE IF EXISTS `ast_Testing_M`;

CREATE TABLE `ast_Testing_M` ( `pk` VARCHAR(256) NOT NULL, `checktest` VARCHAR(256) NULL DEFAULT NULL, `stringvalue` TINYINT(1) NULL DEFAULT '1', `male` TINYINT(1) NULL DEFAULT '0', `female` TINYINT(1) NULL DEFAULT '1', `student` TINYINT(1) NULL DEFAULT '0', `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATE NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATE NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`pk`), UNIQUE KEY (`female`,`student`));

