load data infile '/tmp/applifire/db/I628EHBUMB2HR1F6EFSRPG/09C6A33C-9FF7-4C25-951B-0FC5CB7BFB11/art/data/art_password_policy.csv' "str '#appfirenewline#'" into table art_password_policy FIELDS TERMINATED BY '#appfire#' (policyId,policyName,policyDescription,minPwdLength,maxPwdLength,minCapitalLetters,minSmallLetters,minNumericValues,minSpecialLetters,allowedSpecialLetters
,version_id,updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"',created_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"')

