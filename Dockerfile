FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:adminn -o 5sae2-g7-tpachatproject-1.0-SNAPSHOT.jar "http://192.168.240.128:8081/repository/maven-snapshots/com/esprit/examen/5sae2-g7-tpachatproject/1.0-SNAPSHOT/5sae2-g7-tpachatproject-1.0-20231106.183723-1.jar" -L
ENTRYPOINT ["java","-jar","/5sae2-g7-tpachatproject-1.0-SNAPSHOT.jar"]
EXPOSE 9999