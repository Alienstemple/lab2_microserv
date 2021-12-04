#FROM openjdk:11-jdk as builder
#WORKDIR application
#ARG JAR_FILE=target/loyalty-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} application.jar
#RUN java -jar application.jar
##RUN java -Djarmode=layertools -jar application.jar extract

FROM maven:3.6.3-jdk-11-slim AS build
COPY src /home/app/loyalty/src
COPY pom.xml /home/app/loyalty
RUN mvn -f /home/app/loyalty/pom.xml clean package

# Package stage
FROM openjdk:16-alpine3.13
COPY --from=build /home/app/loyalty/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]