# Geolocation Service

- Java REST microservice for geolocation
- Uses the free ip database maxmind: https://dev.maxmind.com/geoip/geoip2/geolite2/

# Swagger

- JSON: http://localhost:8080/v2/api-docs
- UI: http://localhost:8080/swagger-ui.html

# Dependencies

- java: 1.8
- spring-boot: 1.5.2.RELEASE
- spring-boot-actuator
- spring-cloud: Camden.SR5
- spring-cloud-eureka-client

# Default parameters

- spring.application.name: geolocation-service
- spring.cloud.config.failFast: true
- spring.cloud.config.discovery.enabled: true

# Enviroment parameters

= Eureka config
- eureka.client.serviceUrl.defaultZone: http://localhost:8761/eureka/
- eureka.instance.preferIpAddress: true

= Spring cloud config
- spring.cloud.config.profile: dev
- spring.cloud.config.label: master