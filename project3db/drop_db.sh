




echo $PATH
DB_PATH=/tmp/applifire/db/UP95SDFEWQJE8ELTJTKFPG/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C
MYSQL=/usr/bin
USER=project3
PASSWORD=project3
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'