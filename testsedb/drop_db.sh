




echo $PATH
DB_PATH=/tmp/applifire/db/QSARIWH9Q0LL0J8YU3RAYW/FBB1FF45-0B94-4D3F-A056-5636EEB3B154
MYSQL=/usr/bin
USER=pro2
PASSWORD=pro2
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'