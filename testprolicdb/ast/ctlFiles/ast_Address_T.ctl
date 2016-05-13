load data infile '/tmp/applifire/db/CZN1ZOYRTSHGV5T4HPENRA/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/ast/data/Address.csv' into table ast_Address_T FIELDS TERMINATED BY '#appfire#' (addressId,addressTypeId,addressLabel CHAR(1000) "decode(:addressLabel, '\\N', null, :addressLabel)",address1 CHAR(1000) "decode(:address1, '\\N', null, :address1)",address2 CHAR(1000) "decode(:address2, '\\N', null, :address2)",address3 CHAR(1000) "decode(:address3, '\\N', null, :address3)",countryId,stateId,cityId,zipcode,latitude CHAR(1000) "decode(:latitude, '\\N', null, :latitude)",longitude CHAR(1000) "decode(:longitude, '\\N', null, :longitude)",createdBy CHAR(1000) "decode(:createdBy, '\\N', null, :createdBy)",createdDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updatedBy CHAR(1000) "decode(:updatedBy, '\\N', null, :updatedBy)",updatedDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',versionId CHAR(1000) "decode(:versionId, '\\N', null, :versionId)",activeStatus CHAR(1000) "decode(:activeStatus, '\\N', null, :activeStatus)",txnAccessCode CHAR(1000) "decode(:txnAccessCode, '\\N', null, :txnAccessCode)")
