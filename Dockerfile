FROM openjdk:8
EXPOSE 8080
ADD target/docker-service.jar docker-service.jar
ENTRYPOINT ["java","-jar","/docker-service.jar"]