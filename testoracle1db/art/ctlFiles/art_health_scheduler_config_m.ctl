load data infile '/tmp/applifire/db/U4TXINYU4NNQO0NZB5G/1DBE399D-C04D-4FE2-8D00-2F79858E3B09/art/data/art_health_scheduler_config_m.csv' "str '#appfirenewline#'" into table art_health_scheduler_config_m FIELDS TERMINATED BY '#appfire#' (schedulerId,schedulerkey,refreshTime,refreshUnit,batchSize,enabled,connectorClass,dataModel,schedulerName,threadPoolSize,version_id,created_by,
created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',active_status)

