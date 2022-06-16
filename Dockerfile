FROM openjdk:11.0.5-jre-stretch
VOLUME /tmp
EXPOSE 29903
ARG APP_NAME=back-zeeven.jar
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} back-zeeven.jar

ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=recette", "/back-zeeven.jar --trace"]
