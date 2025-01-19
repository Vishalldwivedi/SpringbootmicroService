FROM maven:3.9.4-eclipse-temurin-21-alpine

WORKDIR /app

COPY .mvn/ .mvn
#mvnw: A script that allows Maven to run without being installed on the host machine.
COPY mvnw pom.xml ./
# Used to execute commands during the image build process.
RUN ./mvnw dependency:go-offline

COPY src ./src
#The command runs every time the container starts.
CMD ["./mvnw", "spring-boot:run"]
