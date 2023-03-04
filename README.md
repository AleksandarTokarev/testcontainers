https://www.testcontainers.org/modules/databases/jdbc/  
https://www.baeldung.com/spring-boot-testcontainers-integration-test  
https://www.testcontainers.org/modules/databases/jdbc/#using-postgresql  
https://www.testcontainers.org/test_framework_integration/junit_5/  
https://github.com/testcontainers/testcontainers-java/blob/main/modules/postgresql/src/test/java/org/testcontainers/junit/postgresql/SimplePostgreSQLTest.java  
https://www.testcontainers.org/features/creating_container/  
https://stackoverflow.com/questions/53078306/populate-a-database-with-testcontainers-in-a-springboot-integration-test  
https://www.baeldung.com/junit-5-test-order  
https://www.atomicjar.com/2022/08/testcontainers-and-junit-integration/  
https://www.testcontainers.org/test_framework_integration/manual_lifecycle_control/  
Last 2 links are great reads - have a look at them.

# USAGE
There are different ways to do the configurations, check the files in tests

# How to start local Postgres (for the actual app - not tests)?
Start Docker Desktop, navigate to `docker` directory and run (up or down to start or bring down docker images)
```
docker-compose -f docker-compose.yml up
docker-compose -f docker-compose.yml down
```
(docker-compose has different containers - postgres, redis, kafka, etc)

Redis UI - Commander  
http://localhost:8081/  
Kafka UI  
http://localhost:8080/

Postgres username/password are postgres/admin

