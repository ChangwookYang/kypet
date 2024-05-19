FROM openjdk:21-jdk
EXPOSE 8080
ARG JAR_FILE_PATH=build/libs/*.jar
COPY ${JAR_FILE_PATH} pet-be.jar
ENTRYPOINT ["java", "-jar", "pet-be.jar", "-Dspring.profiles.active=docker"]