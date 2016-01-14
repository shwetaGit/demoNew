




echo $PATH
DB_PATH=/tmp/applifire/db/ZFXGXKLJJBAP6OPSUORG/41268682-574E-47B9-B689-837647591A45
MYSQL=/usr/bin
USER=demo
PASSWORD=demo
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'