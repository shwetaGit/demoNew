




echo $PATH
OSNAME=`uname -s`
ART_DATA_PATH=/tmp/applifire/db/4G5KMO4OORZSY9UJ7CWSPW/C989E313-5BA5-4148-BF17-F007C22F6413/art/data
AST_DATA_PATH=/tmp/applifire/db/4G5KMO4OORZSY9UJ7CWSPW/C989E313-5BA5-4148-BF17-F007C22F6413/ast/data
DB_NAME=applifire
USER=root
PASSWORD=root
PORT=3306
HOST=localhost
MYSQL=/usr/bin
PROJECT_ID=4G5KMO4OORZSY9UJ7CWSPW
PROJECT_VERSION_ID=1

if [ $OSNAME == "Darwin" ]; then
echo "Setting up MYSQL PATH for OS $OSNAME"
MYSQL=/usr/local/mysql/bin/
fi



echo 'copy ART data from applifire starts....'
echo 'copy ART data from applifire ends....'

