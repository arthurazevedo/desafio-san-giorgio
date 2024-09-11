FROM maven:3.8.4-openjdk-17 AS java-build

WORKDIR /app

COPY orquestrador/ /app/

RUN mvn clean install

ENTRYPOINT ["java", "-jar", "target/orquestrador-0.0.1-SNAPSHOT.jar"]