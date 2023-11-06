FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:adminn -o 5SAE2-G7-tpAchatProject-1.0-SNAPSHOT.jar "http://192.168.240.128:8081/repository/maven-snapshots/com/esprit/examen/5SAE2-G7-tpAchatProject/1.0-SNAPSHOT/5SAE2-G7-tpAchatProject-1.0-20231106.200242-1.jar" -L
ENTRYPOINT ["java","-jar","/5SAE2-G7-tpAchatProject-1.0-SNAPSHOT.jar"]
EXPOSE 9999