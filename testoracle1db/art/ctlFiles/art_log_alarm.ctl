load data infile '/tmp/applifire/db/U4TXINYU4NNQO0NZB5G/1DBE399D-C04D-4FE2-8D00-2F79858E3B09/art/data/art_log_alarm.csv' "str '#appfirenewline#'" into table art_log_alarm FIELDS TERMINATED BY '#appfire#' (loggerPkId,alarmType,alarmData CHAR(20000),alarmVersion,created_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"',updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"',version_id,active_status)
