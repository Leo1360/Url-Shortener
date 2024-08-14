FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/shortlink-v.1.0.jar app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar" ]
