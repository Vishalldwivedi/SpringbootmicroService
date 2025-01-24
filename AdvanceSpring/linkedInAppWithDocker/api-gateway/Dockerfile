FROM maven:3.9.4-eclipse-temurin-21-alpine

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src
#below command when container runs
CMD ["./mvnw", "spring-boot:run"]
