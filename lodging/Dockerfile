FROM openjdk:17-alpine
EXPOSE 8081
RUN mkdir -p /app/
ADD build/libs/lodging-0.0.1-SNAPSHOT.jar /app/lodging-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app/lodging-0.0.1-SNAPSHOT.jar"]