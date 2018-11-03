FROM openjdk:8-jre-alpine

ADD main/target/account-service-main-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT exec java -jar /app.jar

EXPOSE 8080
