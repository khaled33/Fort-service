FROM  openjdk:8-jre-alpine
ARG JAR_FILE=target/Fort1.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","/app.jar"]
