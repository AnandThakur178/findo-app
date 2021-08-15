FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY  ${JAR_FILE}SpringBootRegistrationLogin.jar SpringBootRegistrationLogin.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar" ,"SpringBootRegistrationLogin.jar"]

