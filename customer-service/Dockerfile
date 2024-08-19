FROM openjdk:17-jdk

COPY target/customer-service-0.0.1-SNAPSHOT.jar /app/customer-service.jar

ENTRYPOINT ["java", "-jar", "/app/customer-service.jar"]

EXPOSE 8080