FROM openjdk:14-jdk-alpine
VOLUME /tmp
COPY /target/starwars*.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:dev/./urandom", "-jar", "/app.jar"]