#!/bin/sh

echo "Starting eureka discovery server"
cd ../discovery-service
mvn spring-boot:run
echo "eureka discovery service started"

echo "Starting gateway"
cd ../gateway-service
mvn spring-boot:run
echo "gateway-service starter"



