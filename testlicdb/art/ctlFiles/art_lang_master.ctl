load data infile '/tmp/applifire/db/I628EHBUMB2HR1F6EFSRPG/09C6A33C-9FF7-4C25-951B-0FC5CB7BFB11/art/data/art_lang_master.csv' "str '#appfirenewline#'" into table art_lang_master FIELDS TERMINATED BY '#appfire#' (lang_id,lang_name,country_code,country_name,updated_by,updated_date DATE 'yyyy-mm-dd hh24:mi:ss',created_by,created_date DATE 'yyyy-mm-dd hh24:mi:ss',version_id,active_status)

