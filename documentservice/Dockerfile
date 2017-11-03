FROM openjdk:8-jdk-alpine

VOLUME /tmp

RUN mkdir -p /opt/codecentric && \
    adduser -D codecentric && \
    chown codecentric:users /opt/codecentric

USER codecentric
WORKDIR /opt/codecentric

ARG JAR_FILE
ADD target/$JAR_FILE /opt/codecentric/app.jar

ENV JAVA_OPTS="-Xmx256m"

ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar ./app.jar
