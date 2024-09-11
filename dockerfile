# JDK Version
FROM openjdk:17-jdk-slim AS build

# Copy Jar file
ARG JAR_FILE=/build/libs/BrokageFirmChallenge-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} /bfc.jar

# Expose port
EXPOSE 8080

# Start
ENTRYPOINT ["java", "-jar", "/bfc.jar"]
