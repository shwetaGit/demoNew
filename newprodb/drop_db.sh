




echo $PATH
DB_PATH=/tmp/applifire/db/WCAMF6JKCX7FW1VKM6AAA/868647B2-0D2E-4D64-980E-53657AECF5D5
MYSQL=/usr/bin
USER=pro2
PASSWORD=pro2
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'