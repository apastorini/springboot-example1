# Grandma recipes
https://bitbucket.org/gofore/recipes-java-senior-ap/src

##Assumptions
The name of the recipe is unique
if an attribute is required is mandatory
I assume that amount and unit could be null because dont be filters in the query
I use I use alpha-numerical in reference field like the example
Reference must be unique
Differents Receipes could have the same name
In the searchReceip endpoint, if sort parameter is !=0 the order us ASC, if is equals 0, the order is DESC
In the worth, if receipe not catch in any case I return in whorth nothingToDo


##Corrections
In the text of the exercise says:
reference (optional): The recipe unique reference number in our system. If not present, the system will generate one.
But in the example use a letter and numbers. 
The examples of worth are not correct, for example the example receipe in case B have prepared time 2, the result is ok 145, but with prepared time 2 is not correct for this case.

## The Project was crated using
https://start.spring.io/
I dont use spring profile
IDE: sts 4
Congifure Lombok on  STS follow:
https://stackoverflow.com/questions/35842751/lombok-not-working-with-sts
and add to SpringToolSuite4.ini in vmargs: -javaagent :lombok.jar
## Code Notation
camel Notation

## Libraries and frameworks
Swagger 3.0
Spring boot 2.5.6 (with Spring Web MVC, Spring Data JPA)
Java 11
H2 Database
Maven 3.6.1
Apache Lombok 1.8.1 (to avoid boilerplate code)

##Run project
 ./mvnw spring-boot:run

##Data Base
H2

##Optimizations
Create BD index over reference field in Receipe Table

##Bitbucket url
https://bitbucket.org/gofore/recipes-java-senior-ap/src

##Solutions Urls
http://localhost:8080/grandma-receipes/swagger-ui/index.html
http://localhost:8080/grandma-receipes/h2-console

##Testing
./mvnw test (deprecated)
mvn -Dtest=ReceipeRepositoryTest test
##Run
-Compile
mvnw compile
mvnw -Dmaven.test.skip=true clean
-generate jar
mvnw -Dmaven.test.skip=package
run jar: (2 options)
mvnw -Dmaven.test.skip=true spring-boot:run
java -jar  recipes-java-senior-ap\target\grandma-0.0.1-SNAPSHOT.jar
