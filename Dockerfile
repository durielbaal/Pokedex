# Usa la imagen oficial de WildFly desde Docker Hub
FROM quay.io/wildfly/wildfly:27.0.1.Final-jdk17

# Copia el archivo WAR a la carpeta de despliegue de WildFly
COPY target/hoennPokedex-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/pokedex.war

# Exponer el puerto 8080 (puerto predeterminado de WildFly)
EXPOSE 8080

# Comando para iniciar WildFly
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]



#docker cp .\target\hoennPokedex-1.0-SNAPSHOT.war wildfly:/opt/jboss/wildfly/standalone/deployments/