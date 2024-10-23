FROM openjdk:21-jdk
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS

# Create a new user with UID 10014
RUN groupadd -g 10014 choreo && \
    useradd --no-log-init --no-create-home --uid 10014 --gid 10014 choreouser

# Copy the application JAR file
COPY target/backend-0.0.1-SNAPSHOT.jar dockerimage.jar

# Change ownership of the JAR file to the non-root user
RUN chown appuser:appuser dockerimage.jar

# Expose port 8080
EXPOSE 8080

# Switch to the non-root user
USER 10014

# Set the entry point
ENTRYPOINT exec java $JAVA_OPTS -jar dockerimage.jar
