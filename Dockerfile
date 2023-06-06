#FROM openjdk:11-jdk
#ENV SERVER_PORT=8080
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

FROM openjdk:11-jdk
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} project-reactor-essentials.jar
ENTRYPOINT ["java","-jar","/project-reactor-essentials.jar"]