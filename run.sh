#!/usr/bin/env sh
rm -rf target  && ./mvnw clean package -DskipTests && docker-compose up --build