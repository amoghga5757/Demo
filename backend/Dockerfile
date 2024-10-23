FROM openjdk:21-jdk
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS

# Create a non-root user and group
RUN groupadd -r appuser && useradd -r -g appuser -u 10014 appuser

# Copy the application JAR file
COPY target/backend-0.0.1-SNAPSHOT.jar dockerimage.jar

# Change ownership of the JAR file to the non-root user
RUN chown appuser:appuser dockerimage.jar

# Expose port 8080
EXPOSE 8080

# Switch to the non-root user
USER appuser

# Set the entry point
ENTRYPOINT exec java $JAVA_OPTS -jar dockerimage.jar
