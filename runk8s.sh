#!/usr/bin/env sh
rm -rf target  && \
rm -f customer-service.yaml  && \
./mvnw clean package -DskipTests && \
kompose convert -o customer-service.yaml && \
microk8s kubectl apply -f customer-service.yaml && \
microk8s kubectl describe svc customer