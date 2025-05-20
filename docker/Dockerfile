# docker/Dockerfile
FROM eclipse-temurin:17-jdk-jammy AS builder
WORKDIR /app
COPY .. .
RUN chmod +x gradlew && ./gradlew bootJar --no-daemon

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
