load data infile '/tmp/applifire/db/U4TXINYU4NNQO0NZB5G/1DBE399D-C04D-4FE2-8D00-2F79858E3B09/art/data/art_password_policy.csv' "str '#appfirenewline#'" into table art_password_policy FIELDS TERMINATED BY '#appfire#' (policyId,policyName,policyDescription,minPwdLength,maxPwdLength,minCapitalLetters,minSmallLetters,minNumericValues,minSpecialLetters,allowedSpecialLetters
,version_id,updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"',created_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"')

