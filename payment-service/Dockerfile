FROM openjdk:17-jdk

COPY target/payment-service-0.0.1-SNAPSHOT.jar /app/payment-service.jar

ENTRYPOINT ["java", "-jar", "/app/payment-service.jar"]

EXPOSE 8080