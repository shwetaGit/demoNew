load data infile '/tmp/applifire/db/U4TXINYU4NNQO0NZB5G/1DBE399D-C04D-4FE2-8D00-2F79858E3B09/art/data/art_lang_master.csv' "str '#appfirenewline#'" into table art_lang_master FIELDS TERMINATED BY '#appfire#' (lang_id,lang_name,country_code,country_name,updated_by,updated_date DATE 'yyyy-mm-dd hh24:mi:ss',created_by,created_date DATE 'yyyy-mm-dd hh24:mi:ss',version_id,active_status)

