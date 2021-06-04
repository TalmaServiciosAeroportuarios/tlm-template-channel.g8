FROM openjdk:11-jre-slim

ARG JAR_VERSION
ARG JAR_ARTIFACT_ID
ENV SEVICE_VERSION \$JAR_VERSION
ENV SEVICE_ARTIFACT_ID \$JAR_ARTIFACT_ID
# Create app directory
RUN mkdir -p /opt/logs
WORKDIR /opt

ADD **-app/target/*.jar /opt/
EXPOSE 8080

ENTRYPOINT [ "sh", "-c" ]
CMD ["exec java -Duser.timezone=America/Lima \$ANOTHER_OPTIONS  
                -javaagent:/opt/elastic-apm-agent-1.7.0.jar 
                -Dspring.profiles.active=\$PROFILE 
                -Dspring.config.location=\"/\$SEVICE_ARTIFACT_ID/\$SEVICE_ARTIFACT_ID/\" 
                -Delastic.apm.environment=\$PROFILE 
                -Delastic.apm.service_name=\$SEVICE_ARTIFACT_ID 
                -Delastic.apm.server_urls=\$APM_SERVER_URL 
                -Delastic.apm.enable_log_correlation=true 
                -Delastic.apm.log_level=INFO 
                -Delastic.apm.instrument=false 
                -Delastic.apm.service_version\=\$SEVICE_VERSION 
                -XshowSettings:vm 
                -jar *-app-*.jar"]


#docker build -f devops/Dockerfile  -t acreu2c011intedev01.azurecr.io/ayni-server2:1.0.0 .
