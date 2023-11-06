FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:adminn -o tpachatproject-1.0-SNAPSHOT.jar "http://192.168.240.128:8081/repository/maven-snapshots/com/esprit/examen/5sae2g7tpachatproject/1.0-SNAPSHOT/5sae2g7tpachatproject-1.0-20231106.185218-1.jar" -L
ENTRYPOINT ["java","-jar","/tpachatproject-1.0-SNAPSHOT.jar"]
EXPOSE 9999