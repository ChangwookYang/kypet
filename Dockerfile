FROM openjdk:21-bullseye

RUN apt-get update; \
    apt-get install -y wget unzip; \
    rm -rf /var/lib/apt/lists/*

ENV GRADLE_VERSION=8.7
RUN wget https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip -P /tmp && \
    unzip -d /opt/gradle /tmp/gradle-${GRADLE_VERSION}-bin.zip && \
    rm /tmp/gradle-${GRADLE_VERSION}-bin.zip

ENV GRADLE_HOME=/opt/gradle/gradle-${GRADLE_VERSION}
ENV PATH=${GRADLE_HOME}/bin:${PATH}

COPY . /app
WORKDIR /app
RUN chmod +x ./gradlew
RUN ./gradlew build

FROM openjdk:21-bullseye
COPY --from=0 /app/build/libs/pet-be.jar /app/
ENTRYPOINT ["java", "-jar", "/app/pet-be.jar", "-Dspring.profiles.active=prod"]