FROM  openjdk:8-jre-alpine
ARG JAR_FILE=target/*.war
COPY ${JAR_FILE} app.war
EXPOSE 8087
ENTRYPOINT ["java","-jar","/app.war"]
