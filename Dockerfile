FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY ./project/ .
EXPOSE 8080
RUN chmod +x gradlew
RUN ./gradlew build --no-daemon
