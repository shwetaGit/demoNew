load data infile '/tmp/applifire/db/U4TXINYU4NNQO0NZB5G/1DBE399D-C04D-4FE2-8D00-2F79858E3B09/art/data/art_log_severity_m.csv' "str '#appfirenewline#'" into table art_log_severity_m FIELDS TERMINATED BY '#appfire#' (severityId,logConfigId,severity,label,versionId,createdBy,createdDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"',updatedBy,updatedDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"',activeStatus)

