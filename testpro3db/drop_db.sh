




echo $PATH
DB_PATH=/tmp/applifire/db/4G5KMO4OORZSY9UJ7CWSPW/C989E313-5BA5-4148-BF17-F007C22F6413
MYSQL=/usr/bin
USER=pro3
PASSWORD=pro3
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'