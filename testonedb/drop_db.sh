




echo $PATH
DB_PATH=/tmp/applifire/db/MKPFAU15MI9MPOB9WDOI6Q/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C
MYSQL=/usr/bin
USER=testone
PASSWORD=testone
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'