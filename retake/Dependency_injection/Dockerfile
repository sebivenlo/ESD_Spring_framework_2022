# Stage 1 - Build the application
FROM gradle:jdk17 as builder
WORKDIR /app
COPY . .
RUN gradle build --no-daemon

# Stage 2 - Run the application
FROM amazoncorretto:17-alpine-jdk
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
CMD ["java", "-jar", "app.jar"]