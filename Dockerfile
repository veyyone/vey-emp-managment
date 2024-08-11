FROM maven:3.8.5-openjdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11-jdk-slim
COPY --from=build /target/*.war moon.war
ENTRYPOINT ["java", "-war", "/moon.war"]
EXPOSE 8080