FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
#RUN curl -u admin:adminn -o 5SAE2-G7-tpAchatProject-1.0-SNAPSHOT.jar "http://192.168.240.128:8081/repository/maven-snapshots/com/esprit/examen/5SAE2-G7-tpAchatProject/1.0-SNAPSHOT/5SAE2-G7-tpAchatProject-1.0-20231106.200242-1.jar" -L
#EXPOSE 9999
#RUN curl -u admin:esprit -o 5SAE2-G7-tpAchatProject-1.0-SNAPSHOT.jar "http://192.168.142.128:8081/repository/maven-snapshots/com/esprit/examen/5SAE2-G7-tpAchatProject/1.0-SNAPSHOT/5SAE2-G7-tpAchatProject-1.0-20231106.205223-1.jar" -L

#EXPOSE 8089


#RUN curl -u admin:ubuntu -o 5SAE2-G7-tpAchatProject-1.0-SNAPSHOT.jar "http://192.168.37.128:8081/repository/maven-snapshots/com/esprit/examen/5SAE2-G7-tpAchatProject/1.0-SNAPSHOT/5SAE2-G7-tpAchatProject-1.0-20231106.205054-1.jar" -L
#EXPOSE 7000
RUN curl -u admin:nexus -o 5SAE2-G7-tpAchatProject-1.0-SNAPSHOT.jar "http://192.168.17.139:8081/repository/maven-snapshots/com/esprit/examen/5SAE2-G7-tpAchatProject/1.0-SNAPSHOT/5SAE2-G7-tpAchatProject-1.0-20231106.010645-1.jar" -L
EXPOSE 1919


ENTRYPOINT ["java","-jar","/5SAE2-G7-tpAchatProject-1.0-SNAPSHOT.jar"]
