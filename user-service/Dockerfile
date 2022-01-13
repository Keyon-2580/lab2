FROM openjdk:11

COPY target/user-service-0.0.1-SNAPSHOT.jar /app/user-service-0.0.1-SNAPSHOT.jar


WORKDIR /app
EXPOSE 8002
ENTRYPOINT [ "sh","-c","java  -jar user-service-0.0.1-SNAPSHOT.jar"]