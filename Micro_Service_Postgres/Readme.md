# Micro Service Postres

This is a small project which makes use of two services.
1. User service
2. Contact Service

## Prerequisites

* [Docker](), [Git](https://git-scm.com/), [Maven](), [JDK 7 or 8](), [Eclipse or VSCode or Intellij Idea](), [Postman]()

## Installation and Run this project

* clone this repository 
    ```git clone https://gitlab.com/SivaKumarK1/Micro_Service_Postgres```
* Get into the folder 
    ```cd Micro_Service_Postgres``` 
* Build Project ```./Jars.sh``` (or) ```sh Jars.sh```
* Run docker-compose file ```docker-compose up --build -d```
* To stop all services run 
    ```docker-compose down```

## Endpoint Description

| SL 	| Endpoint                                    	| Request Type  | Data Format in Request Body                                                    |
|----	|---------------------------------------------	|--------------	|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	|
| 1  	| localhost:8082/user/{userid}                         	| GET         	| ```--------X--------``` | 
| 2  	| localhost:8082/user                         	| GET          	| ```--------X--------``` |
| 3  	| localhost:8081/contact/user/{userid}                         	| GET         	| ```--------X--------``` |
| 4  	| localhost:8082/user 	| POST          	| ``` {"cId" : {contact_id},   "email" : "{user_email}",    "contactName" : "{contact_name}",   "userId" : {user_id}} ``` |
| 5  	| localhost:8081/contact/user/{userid} 	| POST          	| ``` {"userId":{user_id},  "name": "{user_name}",  "phone": "{user_phone_number}"} ``` |


## Authors and acknowledgment
* [Anil](https://github.com/AnilComakeIt)
* [Siva](https://github.com/SivaKumarK1)

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
