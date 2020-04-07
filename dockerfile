FROM adoptopenjdk/openjdk8:ubi
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN chmod +777 /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
