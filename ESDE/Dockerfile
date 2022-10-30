FROM openjdk:11
ADD target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT java -jar -Dspring.profiles.active=dev app.jar