# $app;format="upper"$

Iniciar el servicio en local:
```sh
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.profiles.active=local"

mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.profiles.active=dev"



$if(distributedtrace_enable.truthy)$
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-XshowSettings:vm \
                                                    -javaagent:$app$-app/target/elastic-apm-agent-1.7.0.jar \ 
                                                    -Dspring.profiles.active=localdev \
                                                    -Delastic.apm.environment=localdev \
                                                    -Delastic.apm.service_name=$app$ \
                                                    -Delastic.apm.server_urls=http://104.209.255.47:8080 \
                                                    -Delastic.apm.enable_log_correlation=true \
                                                    -Delastic.apm.log_level=DEBUG  \
                                                    -Delastic.apm.instrument=false \
                                                    -Delastic.apm.service_version=1.0.0" 
$endif$

```
Para realizar la coneccion al configserver se debe crear un archivo: bootstrap.yml
y agregar la siguiente configuración:

```
server:
  port: ${PORT}
spring:
  application:
    name: ${APP-NAME}
  profiles:
    active: ${PROFILE}
  main:
    allow-bean-definition-overriding: true
  cloud:
    consul:
      config:
        enabled: false
    config:
      uri: ${CONFIG_SERVER_URI}
      fail-fast: ${CONFIG_SERVER_FAIL_FAST}
      enabled: ${CONFIG_SERVER_ENABLED}
      label: ${LABEL:master}

```

Variables para la conexión con el config-server (revisar archivo bootstrap en modulo ".app")
```
Se debe setear los siguientes valores como variables de entorno en la configutacion
de arranque de su IDE.

    VARIABLE              |                  VALORES
      PORT                |                   8080
    PROFILE               |                   local
CONFIG_SERVER_URI         |  [apuntar a la microservicio de config server]
CONFIG_SERVER_FAIL_FAST   |                   true
CONFIG_SERVER_ENABLED     |                   true
      LABEL               |                  develop
```

Esta estructurado en los siguientes submodulos

```
$app;format="upper"$
 │
 ├── $app$-app
 │   Contiene el SpringApplication que es el inicializa el spring-boot y 
 │   tiene como dependencia a todos los demas otros modulos.
 │
 ├── $app$-core
 │   Contiene el codigo comun entre los proyectos.
 │
 ├── $app$-$module1_format$
 │   Contiene un sudmodulo con logica de solo este dominio.
 │
 ├── $app$-$module2_format$
 │   Contiene un sudmodulo con logica de solo este dominio.
 │
 └── $app$-$module3_format$
     Contiene un sudmodulo con logica de solo este dominio.
```


[](http://spring-config:8888/$app$/qa/gateway)
[](http://spring-config:8888/$app$/dev/gateway)

<https://bitbucket.org/tlmteam/tlm-commons-service-configserver-repository>

/config
+  bff-app/
   + application.yml
   + application-dev.yml
   + application-uat.yml
+  backend-transaction
   + application.yml
   + application-dev.yml
   + application-uat.yml
+  backend-support
   + application.yml
   + application-dev.yml
   + application-uat.yml


