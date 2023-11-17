FROM openjdk:17-alpine
ADD target/*.jar app.jar
EXPOSE 8762
RUN apk --no-cache add curl
ENTRYPOINT [ "java", "-jar", "app.jar" ]

