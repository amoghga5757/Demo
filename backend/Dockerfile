# Stage 1: Build the application using Maven
FROM maven:3.9.9-eclipse-temurin-21 AS build
# Set the working directory inside the container
WORKDIR /app

# Set a volume for temporary files
VOLUME /tmp

# Create a new user with UID 10014
RUN groupadd -g 10014 choreo && \
    useradd --no-log-init --no-create-home --uid 10014 --gid 10014 choreouser

# Copy the Maven project files to the working directory
COPY .mvn/ .mvn
COPY mvnw .
COPY pom.xml .
COPY src ./src

# Grant execute permission to the Maven wrapper script
RUN chmod +x ./mvnw

# Run Maven build to create the target folder and the JAR
RUN ./mvnw clean package -DskipTests

# Stage 2: Build the final image with the JAR file
FROM openjdk:21-jdk

# Set the working directory for the final image
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Switch to the non-root user
USER 10014

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]





