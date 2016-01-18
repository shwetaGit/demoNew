




echo $PATH
OSNAME=`uname -s`
ART_DATA_PATH=/tmp/applifire/db/MKPFAU15MI9MPOB9WDOI6Q/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/art/data
AST_DATA_PATH=/tmp/applifire/db/MKPFAU15MI9MPOB9WDOI6Q/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/ast/data
DB_NAME=applifire
USER=root
PASSWORD=root
PORT=3306
HOST=localhost
MYSQL=/usr/bin
PROJECT_ID=MKPFAU15MI9MPOB9WDOI6Q
PROJECT_VERSION_ID=1

if [ $OSNAME == "Darwin" ]; then
echo "Setting up MYSQL PATH for OS $OSNAME"
MYSQL=/usr/local/mysql/bin/
fi



echo 'copy ART data from applifire starts....'
echo 'copy ART data from applifire ends....'

