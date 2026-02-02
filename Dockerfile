FROM amazoncorretto:17-alpine

WORKDIR /app

COPY target/comunicacao_api-0.0.1-SNAPSHOT.jar /app/comunicacao_api.jar

EXPOSE 9090

CMD ["java", "-jar", "/app/comunicacao_api.jar"]