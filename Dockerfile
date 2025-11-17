# Step 1: Use a Maven image with JDK 20 (use Temurin 20 base)
FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Step 2: Use lightweight JDK for runtime
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Create logs directory for logback
RUN mkdir -p logs

# Copy the built JAR
COPY --from=build /app/target/calculator-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

