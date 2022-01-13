FROM openjdk:11

COPY target/staff-service-0.0.1-SNAPSHOT.jar /app/staff-service-0.0.1-SNAPSHOT.jar


WORKDIR /app
EXPOSE 8001
ENTRYPOINT [ "sh","-c","java  -jar staff-service-0.0.1-SNAPSHOT.jar"]