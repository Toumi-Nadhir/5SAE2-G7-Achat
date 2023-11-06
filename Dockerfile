FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:adminn -o 5saeg7achat-1.0-SNAPSHOT.jar "http://192.168.240.128:8081/repository/maven-snapshots/com/esprit/examen/tpachatproject/1.0-SNAPSHOT/tpachatproject-1.0-20231106.191127-1.jar" -L
ENTRYPOINT ["java","-jar","/5saeg7achat-1.0-SNAPSHOT.jar"]
EXPOSE 9999