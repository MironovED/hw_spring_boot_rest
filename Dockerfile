FROM eclipse-temurin:17

EXPOSE 8080

ADD target/spring-boot-rest-0.0.1-SNAPSHOT.jar myapp.jar

CMD ["java", "-jar", "app.jar"]