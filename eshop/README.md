# E-Shop
WEB for Spring MVC learning

# Prerequisites
This project uses Spring Boot, Spring MVC, Spring Data JPA, and Thymeleaf.
It is recommended to have a basic understanding of these technologies before diving into the code.
Uses technologies:
* Bootstrap 5.2.3
* Font Awesome 6.7.2
* Spring Security 6.4.4

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

# HOW TO run application from scratch step by step:
1. ```cd <your maven project main location>```, where pom.xml available
2. check if pom.xml available using command ```ls -la```
3. run maven wrapper```./mvnw clean install``` for build and install required dependency from maven repository
4. run docker on postgres ```docker compose up -d postgresqldb``` as example
5. if point 3. and point 4. success then run spring boot application using ```./mvnw spring-boot:run -Dspring-boot.run.profiles=pg```