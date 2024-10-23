FROM openjdk:21-jdk
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/backend-0.0.1-SNAPSHOT.jar dockerimage.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar dockerimage.jar

