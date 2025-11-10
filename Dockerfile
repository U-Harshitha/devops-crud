# Use a lightweight JDK runtime
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the jar file from the target folder into the container
COPY target/*.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
