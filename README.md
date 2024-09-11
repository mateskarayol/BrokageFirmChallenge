## Brokage Firm Project

Brokage Firm Challenge Repository is a REST API implemented using Java and Spring Boot.

It contains REST APIs related:
  - Asset
  - Customer
  - Order
  - Authentication

It implements practices related :
  - Spring Data
  - Spring Security (Authentication, Authorization, JWT)
  - Exception Handling
  - Junit - Mockito
  - Dockerization

In order to test the project requirements, please follow the steps below:

1 - Clone Project 
```
git clone https://github.com/mateskarayol/BrokageFirmChallenge.git

cd BrokageFirmChallenge

./gradlew clean build
```

2 -  Open Docker Desktop

```
docker buildx build . -t bfc:latest

docker run -d -p 8080:8080 --name bfc bfc:latest
```

3 - Find and import Postman utility BrokageFirmChallenge/postman-utility

4 - Check the Api Endpoints 
