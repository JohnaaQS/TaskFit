# Stage 1: bouwen met de volledige JDK
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Eerst alleen de Gradle-bestanden, zodat Docker de dependencies kan cachen
COPY gradlew settings.gradle build.gradle ./
COPY gradle gradle
RUN ./gradlew dependencies --no-daemon > /dev/null

# Dan de code, en de jar bouwen
COPY src src
RUN ./gradlew bootJar --no-daemon

# Stage 2: draaien op een kleine JRE, zonder broncode en Gradle
FROM eclipse-temurin:21-jre
WORKDIR /app
RUN useradd --system appuser
USER appuser
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]