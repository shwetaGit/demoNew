DROP TABLE IF EXISTS `ast_OrderTransaction_M`;

CREATE TABLE `ast_OrderTransaction_M` ( `orderTransactionId` VARCHAR(256) NOT NULL, `orderId` VARCHAR(256) NOT NULL, `transactionId` VARCHAR(256) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`orderTransactionId`));

