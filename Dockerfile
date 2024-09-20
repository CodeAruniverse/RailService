FROM maven:3.8.6-openjdk-18-slim AS build
WORKDIR /home/app

COPY ./src/main/java/com/main/RailApplication.java /home/app/src/main/java/com/main/RailApplication.java
COPY ./pom.xml /home/app/pom.xml

RUN mvn -f /home/app/pom.xml clean package

COPY . /home/app
RUN mvn -f /home/app/pom.xml clean package


FROM openjdk:18.0-slim
EXPOSE 7071
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT [“sh”, “-c”, “java -jar /app.jar”]