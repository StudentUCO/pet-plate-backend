FROM openjdk:17-alpine

WORKDIR /app

COPY web/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]