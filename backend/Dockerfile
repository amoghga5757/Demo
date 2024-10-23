# Stage 1: Build the application using Maven
FROM maven:3.8.7-eclipse-temurin-19-alpine AS build

# Set the working directory
ADD . /app
WORKDIR /app

# Run Maven build
RUN mvn clean package

# Use OpenJDK 21 as the base image
FROM openjdk:21-jdk

# Set a volume for temporary files
VOLUME /tmp

# Define Java options as a build argument
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS

# Create a new user with UID 10014
RUN groupadd -g 10014 choreo && \
    useradd --no-log-init --no-create-home --uid 10014 --gid 10014 choreouser



# Copy the Maven project files to the working directory
COPY pom.xml ./
COPY src ./src

# Copy the application JAR file to the final image
COPY target/backend-0.0.1-SNAPSHOT.jar dockerimage.jar

# Change ownership of the JAR file to the non-root user
RUN chown 10014:10014 dockerimage.jar

# Expose port 8080
EXPOSE 8080

# Switch to the non-root user
USER 10014

# Set the entry point for the application
ENTRYPOINT ["java", "-jar", "dockerimage.jar"]
