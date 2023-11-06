# Utilisez l'image OpenJDK 11 depuis Docker Hub
FROM openjdk:8-jdk-alpine

# Exposez le port sur lequel votre application Spring Boot écoute (par exemple, le port 8282)
EXPOSE 8282

# Copiez le fichier JAR de votre application dans le conteneur
COPY target/tpAchatProject-1.0.jar achat.jar

# Démarrez l'application Spring Boot
ENTRYPOINT ["java", "-jar", "achat.jar"]
