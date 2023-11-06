FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:ubuntu -o 5SAE2-G7-tpAchatProject-1.0-SNAPSHOT.jar "http://192.168.37.128:8081/repository/maven-snapshots/com/esprit/examen/tpAchatProject/1.0-SNAPSHOT/tpAchatProject-1.0-20231106.163011-1.jar" -L
ENTRYPOINT ["java","-jar","/5SAE2-G7-tpAchatProject-1.0-SNAPSHOT.jar"]
EXPOSE 7000
