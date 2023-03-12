FROM gradle:7.5-jdk11-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle bootJar --no-daemon

FROM openjdk:11-jre-slim

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/api.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-jar", "/app/api.jar"]