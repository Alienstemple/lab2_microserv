FROM maven:3.6.3-jdk-11-slim AS build
COPY src /home/app/payment/src
COPY pom.xml /home/app/payment
RUN mvn -f /home/app/payment/pom.xml clean package

# Package stage
FROM openjdk:16-alpine3.13
COPY --from=build /home/app/payment/target/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","app.jar"]