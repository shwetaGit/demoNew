CREATE TABLE ast_User_T ( userId VARCHAR2(64)  NOT NULL, userAccessCode NUMBER(11)  DEFAULT NULL, userAccessLevelId VARCHAR2(64)  DEFAULT NULL, userAccessDomainId VARCHAR2(64)  DEFAULT NULL, multiFactorAuthEnabled NUMBER(1)  DEFAULT NULL, genTempOneTimePassword NUMBER(1)  DEFAULT NULL, allowMultipleLogin NUMBER(1)  DEFAULT NULL, isLocked NUMBER(1)  DEFAULT NULL, isDeleted NUMBER(1)  DEFAULT NULL, changePasswordNextLogin NUMBER(1)  DEFAULT NULL, passwordExpiryDate TIMESTAMP  DEFAULT NULL, passwordAlgo VARCHAR2(64)  DEFAULT '1', lastPasswordChangeDate TIMESTAMP  DEFAULT NULL, sessionTimeout NUMBER(11)  DEFAULT '1800', createdBy VARCHAR2(64)  DEFAULT '-1', createdDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', updatedBy VARCHAR2(64)  DEFAULT '-1', updatedDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', versionId NUMBER(11)  DEFAULT '-1', activeStatus NUMBER(1)  DEFAULT '1', txnAccessCode NUMBER  DEFAULT NULL, PRIMARY KEY (userId));

exit;