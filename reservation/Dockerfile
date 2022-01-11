FROM maven:3.6.3-jdk-11-slim AS build
COPY src /home/app/reservation/src
COPY pom.xml /home/app/reservation
RUN mvn -f /home/app/reservation/pom.xml clean package

# Package stage
FROM openjdk:16-alpine3.13
COPY --from=build /home/app/reservation/target/*.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","app.jar"]