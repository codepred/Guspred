FROM maven:3.9.6-amazoncorretto-22 AS build
WORKDIR /build
COPY . .
RUN mvn clean install -Dmaven.test.skip=true

FROM openjdk:22
COPY --from=build /build/target/Guspred-0.0.1-SNAPSHOT.jar /usr/local/lib/guspred-1.0.0.jar
CMD ["java", "-jar", "/usr/local/lib/guspred-1.0.0.jar"]
