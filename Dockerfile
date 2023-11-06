FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:adminn -o tpAchatProject-1.0-SNAPSHOT.jar "http://192.168.240.128:8081/repository/maven-snapshots/com/esprit/examen/tpAchatProject/1.0-SNAPSHOT/tpAchatProject-1.0-20231105.132828-1.jar" -L
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0-SNAPSHOT.jar"]
EXPOSE 9999