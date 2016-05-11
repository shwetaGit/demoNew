load data infile '/tmp/applifire/db/U4TXINYU4NNQO0NZB5G/1DBE399D-C04D-4FE2-8D00-2F79858E3B09/ast/data/SessionData.csv' into table ast_SessionData_T FIELDS TERMINATED BY '#appfire#' (dataId,customerId CHAR(1000) "decode(:customerId, '\\N', null, :customerId)",userId,sessionKey,dataType,numberValue CHAR(1000) "decode(:numberValue, '\\N', null, :numberValue)",dateTimeValue TIMESTAMP 'yyyy-mm-dd hh24:mi:ss' "decode(:dateTimeValue, '\\N', null, :dateTimeValue)",stringValue CHAR(1000) "decode(:stringValue, '\\N', null, :stringValue)",booleanValue,jsonValue CHAR(50000) NULLIF jsonValue = '\\N',appSessionId,createdBy CHAR(1000) "decode(:createdBy, '\\N', null, :createdBy)",createdDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updatedBy CHAR(1000) "decode(:updatedBy, '\\N', null, :updatedBy)",updatedDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',versionId CHAR(1000) "decode(:versionId, '\\N', null, :versionId)",activeStatus CHAR(1000) "decode(:activeStatus, '\\N', null, :activeStatus)",txnAccessCode CHAR(1000) "decode(:txnAccessCode, '\\N', null, :txnAccessCode)")

