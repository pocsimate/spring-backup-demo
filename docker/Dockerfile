FROM eclipse-temurin:21-jdk-alpine

VOLUME /tmp
COPY target/*.jar app.jar
COPY src/main/resources/application.yaml application.yaml
COPY docker/backup.sh /usr/local/bin/
COPY docker/restore.sh /usr/local/bin/

RUN apk update && apk add --no-cache mariadb-client

ENTRYPOINT ["java", "-Dspring.config.location=application.yaml", "-jar","/app.jar"]