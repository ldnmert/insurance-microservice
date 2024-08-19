FROM openjdk:17-jdk

COPY target/gateway-0.0.1-SNAPSHOT.jar /app/gateway.jar

ENTRYPOINT ["java", "-jar", "/app/gateway.jar"]

EXPOSE 8080