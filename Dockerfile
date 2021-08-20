FROM maven:3.8.1-jdk-11 AS builder
WORKDIR /build
COPY . /build

## Optional copy your local.m2 for faster build
# run in your source code folder "mount ~/.m2 m2"
COPY m2/ /root/.m2/

RUN mvn package

RUN mv target/*.jar app.jar


FROM openjdk:11

WORKDIR /usr/src/myapp

COPY --from=builder /build/app.jar app.jar

EXPOSE 8080

ENV APP_OPTS=""
ENV JAVA_OPTS=""

CMD ["sh", "-c", "java ${JAVA_OPTS} -jar app.jar ${APP_OPTS}"]
