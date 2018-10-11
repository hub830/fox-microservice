# hops-microservice-discovery
# Version 0.0.1

# GET_IMAGE
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} app.jar

# PORT
EXPOSE 8761

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]