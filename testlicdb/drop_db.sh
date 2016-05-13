




DB_PATH=/tmp/applifire/db/I628EHBUMB2HR1F6EFSRPG/09C6A33C-9FF7-4C25-951B-0FC5CB7BFB11
ORACLE_HOME=/u01/app/oracle/product/11.2.0/xe
ORACLE_SID=XE
PATH=$PATH:$ORACLE_HOME/bin:$ORACLE_SID
export ORACLE_HOME
export ORACLE_SID
export PATH
USER=pro4
PASSWORD=pro4
HOST=localhost

echo 'drop db starts....'
sqlplus $USER/$PASSWORD @$DB_PATH/drop_db.sql;
sqlplus $USER/$PASSWORD @$DB_PATH/dropSequence.sql;
echo 'drop db ends....'

