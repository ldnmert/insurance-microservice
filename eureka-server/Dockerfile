FROM openjdk:17-jdk

COPY target/eureka-server-0.0.1-SNAPSHOT.jar /app/eureka-server.jar

ENTRYPOINT ["java", "-jar", "/app/eureka-server.jar"]

EXPOSE 8080