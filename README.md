# Microservices and distributed architecture

## Usefull links
* https://piotrminkowski.wordpress.com/2017/02/05/part-1-creating-microservice-using-spring-cloud-eureka-and-zuul/
##### Microservices
* https://www.oreilly.com/ideas/migrating-to-cloud-native-application-architectures/page/3/migration-cookbook
##### Ribbon
* https://gooroo.io/GoorooTHINK/Article/17367/Spring-Cloud-and-Netflix-Ribbon-Clientside-Load-Balancing/28985#.WhnCULQtUTI

# Lancement application
## Eureka - Service Discovery
Démarage spring eureka, découverte de service:
```
mvn spring-boot:run
```
#### Paramétrage
PORT - Port par défaut : 9000
```
mvn spring-boot:run -DPORT=9999
```

## Zipkin - Tracing distribuée
Démarrage:
```
mvn spring-boot:run
```
#### Paramétrage
PORT - Port par défaut : 9411

```
mvn spring-boot:run -DPORT=9999
```

## Gateway - Gateway service
Démarrage:
```
mvn spring-boot:run
```
#### Paramétrage
PORT - Port par défaut: 8000

DISCOVERY_URL - Url eureka Discovery: http://localhost:9000/eureka/

ZIPKIN_URI - Url zipkin : http://localhost:9411
```
mvn spring-boot:run -DPORT=8888 -DDISCOVERY_URL=http://localhost:9111/eureka/ -DZIPKIN_URL=http://localhost:9422

```
## Users - Users Service
Démarrage:
```
mvn spring-boot:run
```
#### Paramétrage
PORT - Port par défaut: 9100

DISCOVERY_URL - Url eureka discovery : http://localhost:9000}/eureka/

ZIPKIN_URI - Url zipkin : http://localhost:9411
```
mvn spring-boot:run -DPORT=8888 -DDISCOVERY_URL=http://localhost:9111/eureka/ -DZIPKIN_URL=http://localhost:9422

```
## Tiers - Tiers Service
Démarrage:
```
mvn spring-boot:run
```
#### Paramétrage
PORT - Port par défaut: 9200

DISCOVERY_URL - Url eureka discovery : http://localhost:9000}/eureka/

ZIPKIN_URI - Url zipkin : http://localhost:9411
```
mvn spring-boot:run -DPORT=8888 -DDISCOVERY_URL=http://localhost:9111/eureka/ -DZIPKIN_URL=http://localhost:9422

```
#### Profils
* discovery : enable eureka discovery
* tracing : enable tracing instrumentation
* standalone : enable standalone rest service

Par défaut les 3 sont activés

# Composants SpringCloud
### Zuul
Gateway service. Fournis des fonctionnalités de routing, monitoring, resilience...
* https://github.com/Netflix/zuul

### Ribbon
Client side balancer.
* https://github.com/Netflix/ribbon/wiki

### Feign
Client rest déclaratif
* https://github.com/OpenFeign/feign

### Eureka
Découverte et enregistrement de services
* https://github.com/Netflix/eureka

### Sleuth
Tracing distribuée
* https://github.com/spring-cloud/spring-cloud-sleuth

### Zipkin 
Système de tracing distribuée

