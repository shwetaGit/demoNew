load data infile '/tmp/applifire/db/U4TXINYU4NNQO0NZB5G/1DBE399D-C04D-4FE2-8D00-2F79858E3B09/art/data/art_scheduler_details.csv' "str '#appfirenewline#'" into table art_scheduler_details FIELDS TERMINATED BY '#appfire#' (schedulerId,schedulerExpression,jobId,project_id,app_creator_id,project_version_id,created_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updated_by,version_id,active_status)

