FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=user-microservice-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} user-microservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","user-microservice-0.0.1-SNAPSHOT.jar"]

