




DB_PATH=/tmp/applifire/db/U4TXINYU4NNQO0NZB5G/1DBE399D-C04D-4FE2-8D00-2F79858E3B09
ORACLE_HOME=/u01/app/oracle/product/11.2.0/xe
ORACLE_SID=XE
PATH=$PATH:$ORACLE_HOME/bin:$ORACLE_SID
export ORACLE_HOME
export ORACLE_SID
export PATH
USER=proo
PASSWORD=proo
HOST=localhost

echo 'drop db starts....'
sqlplus $USER/$PASSWORD @$DB_PATH/drop_db.sql;
sqlplus $USER/$PASSWORD @$DB_PATH/dropSequence.sql;
echo 'drop db ends....'

