
FROM openjdk:17-jdk-slim-buster

EXPOSE 8082

RUN mkdir /app

COPY build/libs/*.jar /app/jp-config-client-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/jp-config-client-0.0.1-SNAPSHOT.jar"]