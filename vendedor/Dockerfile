FROM maven:3.8.4-openjdk-17 AS java-build

WORKDIR /app

COPY vendedor/ /app/

RUN mvn clean install

ENTRYPOINT ["java", "-jar", "target/vendedor-0.0.1-SNAPSHOT.jar"]