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

# Modular Application Structure

This application uses a multi-module Maven structure with different security profiles:

## Module Architecture
```
base-parent (root)
├── core (utilities, validation, MessageService)
├── common (main eshop functionality)  
├── security-core (security domain objects and repositories)
├── basic-mvc (MVC security configuration)
├── disabled-security (no authentication configuration)
└── main (application entry point)
```

## Security Profiles

### No Security Profile (default)
```bash
mvn -Pno-security clean package
```

### Basic MVC Security Profile  
```bash
mvn -Psecurity-basic-mvc clean package
```

## Key Modular Application Fixes

### 1. **Dependency Management Structure**
- **Fixed**: Added centralized `dependencyManagement` in root pom.xml for all internal modules
- **Why**: Ensures consistent versioning across all modules and prevents version conflicts
- **Impact**: All child modules now inherit versions from parent, eliminating version mismatches

### 2. **Module Dependency Chain**
- **Fixed**: Established clear dependency hierarchy:
  - `main` → `core`, `common`, `basic-mvc`/`disabled-security`
  - `common` → `core` (for MessageService)
  - `security-core` → `core` (for validation annotations)
  - `basic-mvc`/`disabled-security` → `security-core`
- **Why**: Prevents circular dependencies and ensures proper module loading order
- **Impact**: Clean separation of concerns and predictable build order

### 3. **GroupId Consistency**
- **Fixed**: Maintained separate groupIds for security modules (`lt.codeacademy.security`) while keeping core modules under `lt.codeacademy.spring2025`
- **Why**: Allows security modules to be treated as separate concerns while maintaining proper Maven structure
- **Impact**: Clear module boundaries and easier security module swapping

### 4. **Spring Context Dependencies**
- **Fixed**: Added `spring-context` dependency to all modules using Spring components
- **Why**: Required for `@Component`, `@Service`, and other Spring annotations to work properly
- **Impact**: Proper Spring bean registration and dependency injection

### 5. **JPA Configuration**
- **Fixed**: Added proper `@EnableJpaRepositories` and `@EntityScan` annotations with correct base packages
- **Why**: Ensures JPA repositories and entities are discovered across modules
- **Impact**: Database operations work correctly across modular boundaries

### 6. **Maven Profile Integration**
- **Fixed**: Root pom.xml profiles properly include/exclude security modules based on selection
- **Why**: Allows switching between security implementations without code changes
- **Impact**: Runtime security behavior controlled by build-time profile selection

# Docker
## Run DB with Docker
### Run mysql
> docker compose up -d mysqldb

### Run postgresql
> docker compose up -d postgresqldb

### Run pgAdmin for postgres
> docker compose up -d pgadmin4

## Run application using spring-boot
### on H2 DB with No Security
> ./mvnw -Pno-security spring-boot:run

### on H2 DB with Basic MVC Security  
> ./mvnw -Psecurity-basic-mvc spring-boot:run

## Run application using spring-boot
### on MYSQL DB with Basic MVC Security
> ./mvnw -Psecurity-basic-mvc spring-boot:run -Dspring-boot.run.profiles=mysql

## Run application using spring-boot
### on PostgreSQL DB with Basic MVC Security
> ./mvnw -Psecurity-basic-mvc spring-boot:run -Dspring-boot.run.profiles=pg

## Access the application
http://localhost:8080

# HOW TO run application from scratch step by step:
1. ```cd <your maven project main location>```, where pom.xml available
2. check if pom.xml available using command ```ls -la```
3. run maven wrapper```./mvnw -Psecurity-basic-mvc clean install``` for build and install required dependency from maven repository
4. run docker on postgres ```docker compose up -d postgresqldb``` as example
5. if point 3. and point 4. success then run spring boot application using ```./mvnw -Psecurity-basic-mvc spring-boot:run -Dspring-boot.run.profiles=pg```

## Important Notes
- Always specify a Maven profile (`-Pno-security` or `-Psecurity-basic-mvc`) when building/running
- The enforcer plugin will fail the build if no profile is specified
- Database profile (`-Dspring-boot.run.profiles=`) is separate from security profile (`-P`)