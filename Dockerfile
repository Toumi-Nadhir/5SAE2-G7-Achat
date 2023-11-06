FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:esprit -o 5saeg7achat-1.0-SNAPSHOT.jar "http://192.168.142.128:8081/repository/maven-snapshots/com/esprit/examen/tpAchatProject/1.0-SNAPSHOT/tpAchatProject-1.0-20231106.114854-1.jar" -L
ENTRYPOINT ["java","-jar","/5saeg7achat-1.0-SNAPSHOT.jar"]
EXPOSE 8089
