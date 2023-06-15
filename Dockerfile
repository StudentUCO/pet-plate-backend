FROM openjdk:17-alpine

WORKDIR /app

COPY web/build/libs/*.jar app.jar

ENV ENVIRONMENT dev
ENV PORT 8080

EXPOSE ${PORT}

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=${ENVIRONMENT}", "-Dserver.port=${PORT}", "app.jar"]