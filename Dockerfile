FROM 949819936055.dkr.ecr.eu-west-1.amazonaws.com/docker-openjdk:11 
ARG JAR_FILE=target/vqtool-notification-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} vqtool-notification-service-0.0.1-SNAPSHOT.jar
EXPOSE 8093
ENTRYPOINT ["java","-Dvqtool.notification.service.port=8093","-jar","vqtool-notification-service-0.0.1-SNAPSHOT.jar"]
