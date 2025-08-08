FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/SJlesson.jar app.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]