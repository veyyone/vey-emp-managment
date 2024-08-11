FROM maven:3.8.5-openjdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11-jdk-slim
COPY --from=build /target/*.jar moon.jar
ENTRYPOINT ["java", "-jar", "/moon.jar"]
EXPOSE 8080