FROM maven:3.8.1-openjdk-17-slim AS build

COPY pom.xml /usr/src/app/
COPY src /usr/src/app/src

WORKDIR /usr/src/app/
RUN mvn package

FROM openjdk:17-slim

COPY --from=build /usr/src/app/target/*.jar /usr/app/app.jar

ENTRYPOINT ["java","-jar","/usr/app/app.jar"]