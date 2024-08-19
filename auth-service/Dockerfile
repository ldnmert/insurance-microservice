FROM openjdk:17-jdk

COPY target/auth-service-0.0.1-SNAPSHOT.jar /app/auth-service.jar

ENTRYPOINT ["java", "-jar", "/app/auth-service.jar"]

EXPOSE 8080