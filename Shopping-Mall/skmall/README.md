docker run -p 8081:8081 --name custappmysql --link shoppingsql:mysql -d custapp

docker build . -t custapp

docker run --name shoppingsql -p 3307:3306 -e MYSQL_ROOT_PASSWORD=admin -e 
MYSQL_DATABASE=shopApplication -d mysql

