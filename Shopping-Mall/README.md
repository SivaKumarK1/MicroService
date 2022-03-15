# ShoppingMall


    docker run --name shopsql -p 3307:3306 -v ./sqlfoldertest:/var/lib/mysql 
    -e MYSQL_ROOT_PASSWORD=admin -d mysql:latest


    docker exec -it 0b bash

     mysql -u"root" -p

     create database shopApplication;

     use shopApplication;
    
     show tables;
## Start here

    docker run --name shoppingsql -p 3307:3306 -e MYSQL_ROOT_PASSWORD=admin -e
    MYSQL_DATABASE=shopApplication -d mysql

## In Directory
    docker build . -t custapp
    docker build . -t parkingapp
    docker build . -t shopapp

## create Conatiner
    docker run -p 8081:8081 --name custappmysql --link shoppingsql:mysql -d custapp
    docker run -p 8082:8082 --name parkingappmysql --link shoppingsql:mysql -d parkingapp
    docker run -p 8083:8083 --name shopappmysql --link shoppingsql:mysql -d shopapp
    
## PORTS
    
    skmall - 8081
    skmallparking - 8082
    skmallshop - 8083