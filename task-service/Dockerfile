FROM openjdk:11

COPY target/task-service-0.0.1-SNAPSHOT.jar /app/task-service-0.0.1-SNAPSHOT.jar


WORKDIR /app
EXPOSE 8003
ENTRYPOINT [ "sh","-c","java  -jar task-service-0.0.1-SNAPSHOT.jar"]