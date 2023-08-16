#Spring Boot Inditext test
A spring-boot application to get the rate for a product in the string between specific dates.

#Technologies
The project is created with:
* Spring Boots 2.7.0
* Java 11
* Database H2 (In-Memory)
* Maven
* Open Api 3 & Swagger

#Architecture
The architecture of the web service is built with the following components:
  - DataTransferObjects: Objects which are used for outside communication via the API. (ConsultResponse.java)
  - Controller: Implements the processing logic of the web service, parsing of parameters, and validation of in- and outputs. (PriceController.java)
  - Service: Implements the business logic and handles the access to the DataAccessObjects. (PriceService.java & PriceServiceImpl.java)
  - DataAccessObjects: Interface for the database. Inserts, updates, deletes, and reads objects from the database. (BrandRepository.java, PriceRepository.java & ProductRepository.java)
  - DomainObjects: Functional Objects which might be persisted in the database. (Brand.java, Price.java & Product.java) 

#Run
* Comands
  - Run directly with the SpringBoot plugin:
    mvn spring-boot:run
    
  - Generate war, running unit tests:
    mvn clean package
    
 NOTE: 
 The application will be available at the following URL: http://localhost:8080/api/v1/consult/
 The documentation will be available at the following URL: http://localhost:8080/swagger-ui/index.html    

#Database
The H2 console will be exposed at http://localhost:8080/h2-ui
* Configurations:
  - url= jdbc:h2:file:./inditextestdb
  - username=sa
  - password= 




#TESTS examples
Application is tested using different kinds of test:

*  Spring Boot JPA - Unit Test Repository
src/test/java/com/app/test/inditext/PriceRepositoryUnitTest.java

* Spring mvc test for REST endpoint
src/test/java/com/app/test/inditext/PriceControllerTest.java






