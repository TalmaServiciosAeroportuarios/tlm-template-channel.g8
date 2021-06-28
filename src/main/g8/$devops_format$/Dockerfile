FROM openjdk:11-jre-slim

ARG CONFIG_SERVER_URI
ENV CONFIG_SERVER_URI=${CONFIG_SERVER_URI}

WORKDIR /opt
ADD **-app/target/*.jar /opt/

CMD exec java -Duser.timezone=America/Lima -XX:+PrintFlagsFinal -jar *-app-*.jar


#docker build -f devops/Dockerfile  -t acreu2c011intedev01.azurecr.io/ayni-server2:1.0.0 .
