




echo $PATH
DB_PATH=/tmp/applifire/db/Q4J5ZQEQ8YIBNQ1HMAU7W/5D8935D1-EE79-41BC-A109-F8E17BD10F88
MYSQL=/usr/bin
USER=pro6
PASSWORD=pro6
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'