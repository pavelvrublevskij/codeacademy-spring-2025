# E-Shop
WEB for Spring MVC learning

## Requirements
* JDK 17+
* Check if JAVA_HOME used JDK 17
  * On Windows CMD: 
  > echo %JAVA_HOME%
  * On Unix Terminal:
  > echo $JAVA_HOME

# Docker
## Run DB with Docker
### Run mysql
> docker compose up -d mysqldb

### Run postgresql
> docker compose up -d postgresqldb

### Run pgAdmin for postgres
> docker compose up -d pgadmin4

## Run application using spring-boot
### on H2 DB
> ./mvnw spring-boot:run

## Run application using spring-boot
### on MYSQL DB
> ./mvnw spring-boot:run -Dspring-boot.run.profiles=mysql

## Run application using spring-boot
### on PostgreSQL DB
> ./mvnw spring-boot:run -Dspring-boot.run.profiles=pg

## Access the application
http://localhost:8080