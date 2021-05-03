FROM gradle AS build
COPY --chown=gradle:gradle . /home/demo/src
WORKDIR /home/demo/src
RUN gradle build
FROM openjdk:8
COPY --from=build /home/demo/src/build/libs/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
COPY application.properties.production application.properties.production
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.jar","--spring.config.location=application.properties.production"]