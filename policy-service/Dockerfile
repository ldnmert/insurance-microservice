FROM openjdk:17-jdk

COPY target/policy-service-0.0.1-SNAPSHOT.jar /app/policy-service.jar

ENTRYPOINT ["java", "-jar", "/app/policy-service.jar"]

EXPOSE 8080