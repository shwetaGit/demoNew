




echo $PATH
OSNAME=`uname -s`
ART_DATA_PATH=/var/lib/mysql-files/applifire/db/LSHBZBRPRNI5RFMTM7M4A/art/data
AST_DATA_PATH=/var/lib/mysql-files/applifire/db/LSHBZBRPRNI5RFMTM7M4A/ast/data
MYSQL=/usr/bin


if [ $OSNAME = "Darwin" ]; then
echo "Setting up MYSQL PATH for OS $OSNAME"
MYSQL=/usr/local/mysql/bin/
fi

DB_NAME=pro2
USER=pro2
PASSWORD=pro2
PORT=3306
HOST=localhost


echo ' load ART data starts at ' $(date)
echo 'load ART data ends at ' $(date)

