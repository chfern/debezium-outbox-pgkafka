#FROM gradle:5.3.0-jdk-alpine
#WORKDIR /app
#COPY . /app
#USER root
#RUN chown -R gradle /app
#USER gradle
#RUN ./gradlew :app:flywayMigrate --stacktrace
#RUN rm -rf /app

FROM adoptopenjdk:11-jre-hotspot as builder
LABEL maintainer="christyantofernando@gmail.com"
ARG JAR_FILE=app/build/libs/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]