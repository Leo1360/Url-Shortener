FROM maven:3.8.5-openjdk-17 AS build
RUN mkdir -p /opt/shortlink
WORKDIR /opt/shortlink
ADD . /opt/shortlink
RUN mvn package

FROM openjdk:17-alpine
RUN mkdir -p /opt/shortlink
WORKDIR /opt/shortlink
COPY --from=build /opt/shortlink/target/shortlink-v.1.0.jar app.jar 
CMD [ "java", "-jar", "app.jar" ]