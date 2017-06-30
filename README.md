# Geolocation Service

- Java REST microservice for geolocation
- Geolocation database: Maxmind: https://dev.maxmind.com/geoip/geoip2/geolite2/
- Service discovery: Eureka Server
- Configuration: Spring Cloud Config Server 
- REST Documentation: Swagger

# Swagger

- JSON: http://localhost:8080/v2/api-docs
- UI: http://localhost:8080/swagger-ui.html

# Dependencies

- java: 1.8
- spring-boot-starter-parent: 1.5.2.RELEASE
- spring-boot-starter-web
- spring-boot-starter-actuator
- spring-cloud-dependencies: Camden.SR5
- spring-cloud-starter-config
- spring-cloud-starter-eureka
- springfox-swagger2: 2.5.0
- springfox-swagger-ui: 2.5.0

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