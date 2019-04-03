# Run a 'mvn package' in the top level directory
FROM openjdk:8-jdk-alpine

LABEL maintainer="agordonmoss@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available outside this container
# for some reason tomcat is running on 8084...
EXPOSE 8084
EXPOSE 80

# The application's jar file
ARG JAR_FILE=target/ClassicModelsRestApi-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} restfile.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/restfile.jar"]
