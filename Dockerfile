FROM openjdk:11-jdk
ENV SERVER_PORT=8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]